package com.takeaway.testcases;

import static com.takeaway.utilities.JSONParser.serialization;
import static com.takeaway.utilities.ReadProperties.getValue;
import static com.takeaway.utilities.TestListeners.extentTest;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.takeaway.client.ListClient;
import com.takeaway.constants.MediaType;
import com.takeaway.constants.PropertyKeys;
import com.takeaway.dataprovider.TestDataProvider;
import com.takeaway.request.model.Items;
import com.takeaway.response.model.AddOrUpdateItemResponse;
import com.takeaway.response.model.CreateListResponse;
import com.takeaway.response.model.GetListResponse;

import io.restassured.response.Response;

public class ListPositiveTestcases extends BaseTest {

    private Items items;
    
    @Test(description = "Test Create list")
    public void createList() {
    	createdList = listClient.createList();
        Assert.assertTrue(createdList.getStatusMessage().equalsIgnoreCase("The item/record was created successfully."));
        extentTest.get().pass(String.format("Successfully, created list with Id %s ", createdList.getId()));
    }

    @Test(dataProvider = "updateList", dataProviderClass = TestDataProvider.class, description = "Test Update list")
    public void updateList(String description, String name) {
    	
    	createList();
        listClient.updateList(createdList.getId(), description,name);

        GetListResponse getListResponse = listClient.getList(createdList.getId());

        Assert.assertEquals(getListResponse.getDescription(), description);
        Assert.assertEquals(getListResponse.getName(), name);

        extentTest.get().pass("Successfully Updatated the list ");
    }

    
    @Test(description = "Test Add items to created list")
    public void addItemsToList() {

    	createList();
        items = new Items();
        items.setItems(123, MediaType.movie, "Movie item");
        items.setItems(12345, MediaType.tv, "Tv item");

        AddOrUpdateItemResponse addItemsResponse = listClient.addItemsInList(createdList.getId(), items);
        Assert.assertTrue(addItemsResponse.isSuccess(), "Failed to add items to the list");

        Assert.assertTrue(listClient.checkItemsPresentInList(createdList.getId(), items.getItems()));
        extentTest.get().pass(String.format("Successfully, added items %s in the list ", serialization(items)));

    }

    
    @Test(description = "Test Update items to created list")
    public void updateItemsFromList() {
    	
    	addItemsToList();
        Items itemsToBeUpdated = new Items();
        itemsToBeUpdated.setItems(123, MediaType.movie, "great tv show");

        AddOrUpdateItemResponse updatedItemsResponse = listClient.updateItemsInList(createdList.getId(), itemsToBeUpdated);
        Assert.assertTrue(updatedItemsResponse.isSuccess(), "Failed to update items in the list");

        Assert.assertTrue(listClient.checkItemsPresentInList(createdList.getId(), itemsToBeUpdated.getItems()));
        extentTest.get().pass(String.format("Successfully, updated items %s in the list ", serialization(itemsToBeUpdated)));
    }

    
    @Test(description = "Test Delete items to created list")
    public void deleteItemsFromList() {
    	
    	addItemsToList();

        Items itemsToBeDeleted = new Items();
        itemsToBeDeleted.setItems(123, MediaType.movie, "Movie item");

        listClient.deleteItemFromList(createdList.getId(), itemsToBeDeleted);

        Assert.assertFalse(listClient.checkItemsPresentInList(createdList.getId(), itemsToBeDeleted.getItems()));
        extentTest.get().pass(String.format("Successfully, deleted item %s from the list ", serialization(itemsToBeDeleted)));
    }

    
    @Test(description = "Test Clear the list")
    public void clearItemsFromList() {

    	addItemsToList();

        Assert.assertEquals(listClient.getListSize(createdList.getId()), 2);

        Response clearListResponse = listClient.clearList(createdList.getId());
        Assert.assertEquals(clearListResponse.statusCode(), HttpStatus.SC_OK);

        Assert.assertFalse(listClient.checkItemsPresentInList(createdList.getId(), items.getItems()));

        extentTest.get().pass("Successfully, cleared all the items from the list");
    }
    
    @AfterMethod(description = "Delete list")
    public void deleteList() {

        Response response = listClient.deleteList(createdList.getId());
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);

        Assert.assertFalse(listClient.checkListIsPresent(createdList.getId()));
        extentTest.get().pass(String.format("Successfully, deleted List with id %s ", createdList.getId()));
    }

}
