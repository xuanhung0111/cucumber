package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class EntitlementIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public EntitlementIdGenerator() {
        this(TestDataSize.MAX_ENTITLEMENTS);
    }

    public EntitlementIdGenerator(long maxProjects) {
        super(maxProjects);
    }

}
