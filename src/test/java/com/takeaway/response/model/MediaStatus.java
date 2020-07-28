package com.takeaway.response.model;

import com.google.gson.annotations.SerializedName;

public class MediaStatus {
	
	@SerializedName("media_type")
    public String mediaType;

    @SerializedName("media_id")
    public int mediaId;

    public boolean success;

    public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
