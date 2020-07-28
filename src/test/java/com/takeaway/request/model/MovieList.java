package com.takeaway.request.model;

import com.google.gson.annotations.SerializedName;

public class MovieList {
	
    private String name;

    @SerializedName("iso_639_1")
    private String iso639_1;

    private String description;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIso639_1() {
		return iso639_1;
	}

	public void setIso639_1(String iso_639_1) {
		this.iso639_1 = iso_639_1;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
