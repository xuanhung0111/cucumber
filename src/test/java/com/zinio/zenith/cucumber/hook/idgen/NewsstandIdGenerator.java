package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class NewsstandIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public NewsstandIdGenerator() {
        this(TestDataSize.MAX_NEWSSTAND);
    }

    public NewsstandIdGenerator(long maxProjects) {
        super(maxProjects);
    }

}
