package com.zinio.zenith;

import java.util.List;

/**
 * Created by ducnguyen on 9/14/16.
 */
public class ResultList<T> {
    private boolean status;
    private List<T> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
