package com.takeaway.response.model;

import com.google.gson.annotations.SerializedName;

public class GetMediaResponse {
	
	public int id;

    @SerializedName("media_type")
    public String mediaType;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

}
