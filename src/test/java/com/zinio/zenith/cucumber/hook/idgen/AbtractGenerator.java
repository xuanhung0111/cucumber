package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public abstract class AbtractGenerator {
    //    private final long pading;
    private final long total;

    public AbtractGenerator(long total) {
        this.total = total;
    }

    public long genId(long index) {
        return index % total + 1;
    }

    public long getTotal() {
        return total;
    }
}
