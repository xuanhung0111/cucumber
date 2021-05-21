package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class ProjectIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public ProjectIdGenerator() {
        this(TestDataSize.MAX_PROJECTS);
    }

    public ProjectIdGenerator(long maxProjects) {
        super(maxProjects);
    }

}
