package com.takeaway.request.model;

import com.google.gson.annotations.SerializedName;


public class UpdateList {

	@SerializedName("sort_by")
    private String sort_by ;
	
	private String description;

    private String name;
	
    public String getSort_by() {
		return sort_by;
	}

	public void setSort_by(String sort_by) {
		this.sort_by = sort_by;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    
}
