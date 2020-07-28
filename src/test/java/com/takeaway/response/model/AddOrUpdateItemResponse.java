package com.takeaway.response.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class AddOrUpdateItemResponse {

    public boolean success;
    
    @SerializedName("status_code")
    public int statusCode;

    public List<MediaStatus> results;

    public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getStatus_code() {
		return statusCode;
	}

	public void setStatus_code(int status_code) {
		this.statusCode = status_code;
	}

	public List<MediaStatus> getResults() {
		return results;
	}

	public void setResults(List<MediaStatus> results) {
		this.results = results;
	}

	
}


