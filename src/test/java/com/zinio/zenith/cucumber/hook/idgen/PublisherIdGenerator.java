package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class PublisherIdGenerator extends AbtractGenerator {

    public PublisherIdGenerator() {
        this(TestDataSize.MAX_PUBLISHERS);
    }

    public PublisherIdGenerator(long total) {
        super(total);
    }

}
