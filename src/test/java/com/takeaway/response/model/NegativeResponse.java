package com.takeaway.response.model;

import com.google.gson.annotations.SerializedName;

public class NegativeResponse {
	
	public boolean success;
    
    @SerializedName("status_code")
    public int statusCode;
    
    @SerializedName("status_message")
    public String statusMessage;
    
    @SerializedName("error_message")
    public String error_message;
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
        

}
