package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class UserIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public UserIdGenerator() {
        this(TestDataSize.MAX_USERS);
    }

    public UserIdGenerator(long maxProjects) {
        super(maxProjects);
    }

}
