package com.zinio.zenith.cucumber.hook.idgen;

import com.zinio.zenith.cucumber.hook.TestDataSize;

import javax.validation.constraints.NotNull;

/**
 * Created by ducnguyen on 9/16/16.
 */
public class PublicationIdGenerator extends AbtractGenerator {
    //    private final long pading;
    private final PublisherIdGenerator publisherIdGenerator;
    private final long projectPublicationRate;

    public PublicationIdGenerator() {
        this(TestDataSize.MAX_PUBLICATION);
    }

    public PublicationIdGenerator(long maxPublication) {
        this(maxPublication, new PublisherIdGenerator());
    }

    public PublicationIdGenerator(long maxPublication, @NotNull PublisherIdGenerator publisherIdGenerator) {
        super(maxPublication);
        this.publisherIdGenerator = publisherIdGenerator;
        this.projectPublicationRate = maxPublication / this.publisherIdGenerator.getTotal() + 1;
    }

//    @Override
//    public long genId(long index) {
//        return (index / this.projectPublicationRate) * this.projectPublicationRate +
//                (index % this.projectPublicationRate)
//                + 1;
//    }

}
