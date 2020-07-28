package com.takeaway.response.model;

import com.google.gson.annotations.SerializedName;

public class UpdateListResponse {

    @SerializedName("status_message")
    public String statusMessage;

    @SerializedName("status_code")
    public int statusCode;
    
    public boolean success;
    
    public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
