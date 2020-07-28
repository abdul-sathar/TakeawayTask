package com.takeaway.response.model;

import com.google.gson.annotations.SerializedName;

public class CreateListResponse {
	
	@SerializedName("status_message")
    public String statusMessage;

    @SerializedName("status_code")
    public int statusCode;
    
    public int id;

    public boolean success;


    public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	

    
}
