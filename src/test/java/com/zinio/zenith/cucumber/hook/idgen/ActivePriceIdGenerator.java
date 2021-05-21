package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class ActivePriceIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public ActivePriceIdGenerator() {
        this(TestDataSize.MAX_ACTIVE_PRICES);
    }

    public ActivePriceIdGenerator(long maxProjects) {
        super(maxProjects);
    }

}
