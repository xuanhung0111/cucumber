package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class SingleIssuePriceIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public SingleIssuePriceIdGenerator() {
        this(TestDataSize.MAX_SINGLE_ISSUE_PRICES);
    }

    public SingleIssuePriceIdGenerator(long maxProjects) {
        super(maxProjects);
    }

}
