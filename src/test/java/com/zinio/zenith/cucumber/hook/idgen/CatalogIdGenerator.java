package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class CatalogIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public CatalogIdGenerator() {
        this(TestDataSize.MAX_CATALOGS);
    }

    public CatalogIdGenerator(long maxProjects) {
        super(maxProjects);
    }

}
