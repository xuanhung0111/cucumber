package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class IssueIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public IssueIdGenerator() {
        this(TestDataSize.MAX_ISSUES);
    }

    public IssueIdGenerator(long maxProjects) {
        super(maxProjects);
    }

}
