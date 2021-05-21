package com.zinio.zenith.cucumber.hook.idgen;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * Created by ducnguyen on 9/18/16.
 */
public class SqlDateGenerator {
    private LocalDateTime startTime = LocalDateTime.of(1980, 1, 1, 0, 0, 0);
    private long step;
    private TemporalUnit timeUnit;

    public SqlDateGenerator() {
        this(
                LocalDateTime.of(1980, 1, 1, 0, 0, 0),
                600,
                ChronoUnit.SECONDS
        );
    }

    public SqlDateGenerator(@NotNull LocalDateTime startTime, long step, @NotNull TemporalUnit timeUnit) {
        this.startTime = startTime;
        this.step = step;
        this.timeUnit = timeUnit;
    }

    public Timestamp getDate(long step) {
        return Timestamp.valueOf(this.startTime.plus(step * this.step, this.timeUnit));
    }

}
