package com.takeaway.constants;

public enum ListEndpoints {

	GET_LIST("/list/%d?page=1"),
	CREATE_LIST("/list"),
    CLEAR("/list/%d/clear"),
    DELETE("/list/%d"),
    ADD_ITEMS("/list/%d/items"),
    CHECK_ITEM_STATUS("/list/%d/item_status?media_id=%d&media_type=%s"),
    ;

    private final String endpoint;

    ListEndpoints(String endpoint){
        this.endpoint = endpoint;
    }

    public String getUrl(Object... params) {
        return String.format(endpoint, params);
    }
}
