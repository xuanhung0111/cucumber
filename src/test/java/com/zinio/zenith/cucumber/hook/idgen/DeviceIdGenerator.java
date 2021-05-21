package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class DeviceIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public DeviceIdGenerator() {
        this(TestDataSize.MAX_DEVICES);
    }

    public DeviceIdGenerator(long maxProjects) {
        super(maxProjects);
    }

}
