package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class ApplicationIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public ApplicationIdGenerator() {
        this(TestDataSize.MAX_APPLICATION);
    }

    public ApplicationIdGenerator(long maxProjects) {
        super(maxProjects);
    }

}
