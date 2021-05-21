package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class CatalogPublicationIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public CatalogPublicationIdGenerator() {
        this(TestDataSize.MAX_CATALOG_PUBLICATION_RELATIONS);
    }

    public CatalogPublicationIdGenerator(long total) {
        super(total);
    }

}
