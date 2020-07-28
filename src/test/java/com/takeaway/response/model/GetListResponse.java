package com.takeaway.response.model;

import java.util.List;

public class GetListResponse {

    public String name;

    public String description;

    public List<GetMediaResponse> results;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<GetMediaResponse> getResults() {
		return results;
	}

	public void setResults(List<GetMediaResponse> results) {
		this.results = results;
	}

}
