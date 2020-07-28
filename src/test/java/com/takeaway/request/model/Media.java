package com.takeaway.request.model;

import com.google.gson.annotations.SerializedName;

public class Media {

    @SerializedName("media_type")
    private String mediaType;

    @SerializedName("media_id")
    private int mediaId;

    private String comment;
    
    public String getMedia_type() {
		return mediaType;
	}

	public void setMedia_type(String media_type) {
		this.mediaType = media_type;
	}

	public int getMedia_id() {
		return mediaId;
	}

	public void setMedia_id(int media_id) {
		this.mediaId = media_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}