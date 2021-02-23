package com.xtel.core.sys.dto.response.config_schedule;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ConfigScheduleResponse {
    private Integer ID;
    private String NAME_CONFIG_SCHEDULE;
    private Integer START_HOUR;
    private Integer END_HOUR;
    private Integer START_MINUTE;
    private Integer END_MINUTE;
    private Integer STATUS;

}
