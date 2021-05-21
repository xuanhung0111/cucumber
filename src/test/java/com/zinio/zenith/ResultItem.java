package com.zinio.zenith;

import java.util.List;

/**
 * Created by ducnguyen on 9/14/16.
 */
public class ResultItem<T> {
    private boolean status;
    private T data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
