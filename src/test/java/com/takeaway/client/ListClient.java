package com.takeaway.client;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import com.takeaway.constants.ListEndpoints;
import com.takeaway.request.model.Items;
import com.takeaway.request.model.Media;
import com.takeaway.request.model.MovieList;
import com.takeaway.request.model.UpdateList;
import com.takeaway.response.model.AddOrUpdateItemResponse;
import com.takeaway.response.model.CreateListResponse;
import com.takeaway.response.model.GetListResponse;
import static com.takeaway.utilities.RestAssuredUtility.*;
import static com.takeaway.utilities.GenaeralUtility.getRandomName;
import static com.takeaway.utilities.JSONParser.*;


public class ListClient {

    /**
     * Method to get the list
     *
     * @param listId List ID
     * @return Response
     */
    public GetListResponse getList(int listId) {

        Response response = getRequest(ListEndpoints.GET_LIST.getUrl(listId));
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        return deserialization(response, GetListResponse.class);
    }

    /**
     * Method to check whether list present or not
     *
     * @param listId int
     * @return Boolean
     */
    public boolean checkListIsPresent(int listId) {

        Response response = getRequest(ListEndpoints.GET_LIST.getUrl(listId));
        return response.statusCode() == HttpStatus.SC_OK;
    }

    /**
     * Method to get size of the list
     *
     * @param listId List ID
     * @return List size
     */
    public int getListSize(int listId){

        Response response = getRequest(ListEndpoints.GET_LIST.getUrl(listId));
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);

        return deserialization(response, GetListResponse.class).results.size();
    }

    /**
     * Method to remove all the items from the list
     *
     * @param listId List ID
     * @return Response
     */
    public Response clearList(int listId) {
        return getRequest(ListEndpoints.CLEAR.getUrl(listId));
    }

    /**
     * Method to create the list
     *
     * @param list List to create
     * @return Response
     */
    public CreateListResponse createList() {
    	MovieList list = new MovieList();
        list.setName(getRandomName(5));
        list.setIso639_1("en");

        Response response = postRequest(ListEndpoints.CREATE_LIST.getUrl(), serialization(list));
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);

        return deserialization(response, CreateListResponse.class);
    }
    
    public Response createList(String token) {
    	MovieList list = new MovieList();
        list.setName(getRandomName(5));
        list.setIso639_1("en");
        return postRequest(ListEndpoints.CREATE_LIST.getUrl(), serialization(list), token);
    }

    /**
     * Method to delete the list
     *
     * @param listId List ID
     * @return Response
     */
    public Response deleteList(int listId) {

        return deleteRequest(ListEndpoints.DELETE.getUrl(listId));
    }

    /**
     * Method to update the list
     *
     * @param listId      List ID
     * @param updatedList Updated list
     * @return Response
     */
    public Response updateList(int listId, String description, String name) {
    	 UpdateList updateList = new UpdateList();
         updateList.setDescription(description);
         updateList.setName(name);

         Response updatedList = updateRequest(ListEndpoints.GET_LIST.getUrl(listId), serialization(updateList));
         Assert.assertEquals(updatedList.statusCode(), HttpStatus.SC_CREATED);
         return updatedList;
    }

    /**
     * Method to add item to the list
     *
     * @param listId   List ID
     * @param itemList Item list
     * @return Response
     */
    public AddOrUpdateItemResponse addItemsInList(int listId, Items itemList) {

        Response response = postRequest(ListEndpoints.ADD_ITEMS.getUrl(listId), serialization(itemList));
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);

        return deserialization(response, AddOrUpdateItemResponse.class);
    }
    
    public Response addItemsInOtherList(int listId, Items itemList) {

        return postRequest(ListEndpoints.ADD_ITEMS.getUrl(listId), serialization(itemList));
  
    }

    /**
     * Method to update item to the list
     *
     * @param listId   List ID
     * @param itemList Item list
     * @return Response
     */
    public AddOrUpdateItemResponse updateItemsInList(int listId, Items itemList) {

        Response response = updateRequest(ListEndpoints.ADD_ITEMS.getUrl(listId), serialization(itemList));
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);

        return deserialization(response, AddOrUpdateItemResponse.class);
    }


    /**
     * Method to update item to the list
     *
     * @param listId   List ID
     * @param itemList Item list
     * @return Response
     */
    public Response deleteItemFromList(int listId, Items itemList) {

    	Response deletedItemsResponse = deleteRequest(ListEndpoints.ADD_ITEMS.getUrl(listId), serialization(itemList));
        Assert.assertEquals(deletedItemsResponse.statusCode(), HttpStatus.SC_OK);
        return deletedItemsResponse;
    }

    /**
     * Method to check whether item exists
     *
     * @param listId List ID
     * @param itemList Item list
     * @return Boolean
     */
    public boolean checkItemsPresentInList(int listId, List<Media> itemList){

        List<Boolean> status = new ArrayList<Boolean>();

        for (Media item : itemList) {
            Response response = getRequest(ListEndpoints.CHECK_ITEM_STATUS.getUrl(listId, item.getMedia_id(), item.getMedia_type()));
            int statusCode = response.statusCode();
            System.out.println(statusCode);
            if (statusCode == HttpStatus.SC_OK) {
                status.add(true);
            } else if (statusCode == HttpStatus.SC_NOT_FOUND) {
                status.add(false);
            } else {
                throw new IllegalStateException("Unexpected return code");
            }
        }
        return !status.contains(false);
    }
}
