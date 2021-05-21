package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class UserPaymentProfileIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public UserPaymentProfileIdGenerator() {
        this(TestDataSize.MAX_USER_PAYMENT_PROFILE);
    }

    public UserPaymentProfileIdGenerator(long maxProjects) {
        super(maxProjects);
    }

}
