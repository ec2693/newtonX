package models;

import java.util.Map;

public class Response<T> {
    private Map<String,T> data;

    public Map<String, T> getData() {
        return data;
    }

    public void setData(Map<String, T> data) {
        this.data = data;
    }

}
