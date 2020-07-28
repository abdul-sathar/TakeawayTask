package com.takeaway.testcases;

import static com.takeaway.utilities.JSONParser.deserialization;
import static com.takeaway.utilities.ReadProperties.getValue;
import static com.takeaway.utilities.TestListeners.extentTest;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.takeaway.constants.MediaType;
import com.takeaway.constants.PropertyKeys;
import com.takeaway.request.model.Items;
import com.takeaway.response.model.AddOrUpdateItemResponse;
import com.takeaway.response.model.CreateListResponse;
import com.takeaway.response.model.NegativeResponse;

import io.restassured.response.Response;

public class ListNegativeTestcases extends BaseTest {

	@Test(description = "Test Create list with Invalid Token")
	public void createListWithInvalidAccessToken() {

		Response response = listClient.createList(getValue(PropertyKeys.INVALID_ACCESS_TOKEN));
		Assert.assertEquals(response.statusCode(), HttpStatus.SC_UNAUTHORIZED);

		NegativeResponse negativeResponse = deserialization(response, NegativeResponse.class);

		Assert.assertTrue(negativeResponse.getStatusMessage().equalsIgnoreCase("Invalid API key: You must be granted a valid key."));
		extentTest.get().pass("List didn't get created with invalid token. ");
	}

	@Test(description = "Test Add items to Invalid list")
	public void addItemsToInvalidList() {
		int invalidLIstID =786;
		Items items = new Items();
		items.setItems(123, MediaType.movie, "Movie item");

		Response response = listClient.addItemsInOtherList(invalidLIstID, items);
		Assert.assertEquals(response.statusCode(), HttpStatus.SC_UNAUTHORIZED);
		NegativeResponse negativeResponse = deserialization(response, NegativeResponse.class);
		Assert.assertTrue(negativeResponse.getStatusMessage().equalsIgnoreCase("You don't have permission to edit this resource."));
		
		extentTest.get().pass(String.format("Items didn't get added to invalid List (ListID : %s )", invalidLIstID)); 

	}

}
