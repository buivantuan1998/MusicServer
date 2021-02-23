package com.xtel.core.sys.dto.response.play_list;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PlayListResponse {
    private Integer ID;
    private String PLAY_LIST_NAME;
    private Integer PLAY_LIST_TYPE;
}
