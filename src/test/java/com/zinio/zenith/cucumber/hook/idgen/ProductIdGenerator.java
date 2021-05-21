package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class ProductIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public ProductIdGenerator() {
        this(TestDataSize.MAX_PRODUCTS);
    }

    public ProductIdGenerator(long maxProjects) {
        super(maxProjects);
    }

}
