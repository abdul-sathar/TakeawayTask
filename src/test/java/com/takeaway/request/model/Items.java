package com.takeaway.request.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.takeaway.constants.MediaType;

public class Items {

    @SerializedName("items")
    public List<Media> items;

    public List<Media> getItems() {
		return items;
	}

    /**
     * Method to set media
     *
     * @param mediaId Media ID
     * @param mediaType Media Type
     * @param comment Comments
     */
	public void setItems(int mediaId, MediaType mediaType, String comment) {
		Media media = new Media();
		media.setMedia_id(mediaId); 
		media.setMedia_type(mediaType.name());
		media.setComment(comment);
		items.add(media);
		
	}
	
	 public Items() 
	 { 
		 this.items = new ArrayList<Media>(); 
	 }
	 
}


