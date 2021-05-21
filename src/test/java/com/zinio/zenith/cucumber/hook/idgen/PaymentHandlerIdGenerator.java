package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class PaymentHandlerIdGenerator extends AbtractGenerator {
    //    private final long pading;

    public PaymentHandlerIdGenerator() {
        this(TestDataSize.MAX_PAYMENT_HANDLERS);
    }

    public PaymentHandlerIdGenerator(long maxProjects) {
        super(maxProjects);
    }

}
