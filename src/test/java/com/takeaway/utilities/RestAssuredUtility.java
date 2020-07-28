package com.takeaway.utilities;

import static com.takeaway.utilities.ReadProperties.getValue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.takeaway.constants.PropertyKeys;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class RestAssuredUtility {

    protected final static Logger logger = LogManager.getLogger(RestAssuredUtility.class);
    
    /**
     * Performs GET request.
     *
     * @param  method HTTP method
     * @param  url    URL
     * @return Request response
     */
    public static Response request(Method method, String url) {
    	return getRequestSpec()
                .when()
                .request(method, url)
                .then()
                .extract().response();
    }

    /**
     * Performs specified HTTP request with body.
     *
     * @param  method HTTP method
     * @param  params request parameters
     * @param  url    URL 
     * @return response 
     */
    public static Response request(Method method, Object body, String url) {
        return getRequestSpec()
                .when()
                .body(body)
                .request(method, url)
                .then()
                .extract().response();
    }
    
    /**
     * Performs HTTP request with body and given Authorization token.
     *
     * @param  method HTTP method
     * @param  params request parameters
     * @param  url    URL 
     * @return response 
     */
    public static Response request(Method method, Object body, String url,String token) {
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .body(body)
                .request(method, url)
                .then()
                .extract().response();
    }

    /**
     * Generic request specification
     *
     * @return RequestSpecification
     */
    public static RequestSpecification getRequestSpec() {

        return RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + getValue(PropertyKeys.ACCESS_TOKEN));
    }

    /**
     * Get request
     *
     * @param  url String
     * @return Response
     */
    public static Response getRequest(String url) {
    	logger.info(String.format("GET request - %s", url));
        return request(Method.GET, url);
    }

    /**
     * Post request
     *
     * @param  body Body
     * @param  url  URL
     * @return Response
     */
    public static Response postRequest(String url, Object body) {
    	logger.info(String.format("POST request - %s with body - %s", url, body));
        return request(Method.POST, body, url);
    }
    
    public static Response postRequest(String url, Object body, String token) {
    	logger.info(String.format("POST request - %s with body - %s", url, body));
        return request(Method.POST, body, url, token);
    }

    /**
     * Update request
     *
     * @param  body Body
     * @param  url  URL
     * @return Response
     */
    public static Response updateRequest(String url, Object body) {
    	logger.info(String.format("UPDATE request - %s with body - %s", url, body));
        return request(Method.PUT, body, url);
    }

    /**
     * Delete request
     *
     * @param  url URL
     * @return Response
     */
    public static Response deleteRequest(String url) {
    	logger.info(String.format("DELETE request - %s", url));
        return request(Method.DELETE, url);
    }

    /**
     * Delete request with body
     *
     * @param  body Body
     * @param  url  URL
     * @return Response
     */
    public static Response deleteRequest(String url, Object body) {
    	logger.info(String.format("DELETE request - %s with body - %s", url, body));
        return request(Method.DELETE, body, url);
    }
}
