package com.takeaway.utilities;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import org.json.JSONObject;


public class JSONParser {

	/**
     * This method parse the JSON to an object of specified type
     *
     * @param  response Response
     * @param  requiredClass Object of Model class
     * @return Model class object
     */
    public static <T> T deserialization(Response response, Class<T> requiredClass) {
        JsonObject json = getJsonFromResponse(response);
        Gson gson = new Gson();
        return gson.fromJson(json, requiredClass);
    }

    /**
     * This method parse the object of specified type to JSON
     *
     * @param  requiredClass Model class
     * @return JSON String
     */
    public static String serialization(Object requiredClass) {
        Gson gson = new Gson();
        return gson.toJson(requiredClass);
    }
    
    /**
     * This method gets the JSON from Response
     *
     * @param  response Response
     * @return String
     */
    private static JsonObject getJsonFromResponse(Response res) {
        Gson gson = new Gson();
        return gson.fromJson(new JSONObject(res.getBody().asString()).toString(), JsonObject.class);
    }

}
