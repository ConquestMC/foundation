package com.conquestmc.foundation.player;

import java.util.Map;

public class FProfile {

    private final String profileName;
    private final Map<String, Object> properties;

    public FProfile(String profileName, Map<String, Object> properties) {
        this.profileName = profileName;
        this.properties = properties;
    }

    public void set(String key, Object value) {
        this.properties.put(key, value);
    }

    public String getProfileName() {
        return profileName;
    }

    public String getString(String key) {
        return (String) this.properties.get(key);
    }

    public Boolean getBoolean(String key) {
        return (Boolean) this.properties.get(key);
    }

    public Integer getInteger(String key) {
        return (Integer) this.properties.get(key);
    }

    public Double getDouble(String key) {
        return (Double) this.properties.get(key);
    }

    public Float getFloat(String key) {
        return (Float) this.properties.get(key);
    }

    public Long getLong(String key) {
        return (Long) this.properties.get(key);
    }

    public Short getShort(String key) {
        return (Short) this.properties.get(key);
    }

    public Object getObject(String key) {
        return this.properties.get(key);
    }
}