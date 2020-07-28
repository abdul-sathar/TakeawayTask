package com.takeaway.constants;

public enum PropertyKeys 
{
    ROOT_URL("root_url"),
    API_VERSION("api_version"),
    API_KEY("api_key"),
    ACCESS_TOKEN("access_token"),
    INVALID_ACCESS_TOKEN("invalid_access_token");

    private final String key;

    PropertyKeys(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
