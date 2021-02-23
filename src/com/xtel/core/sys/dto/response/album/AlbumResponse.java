package com.xtel.core.sys.dto.response.album;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
public class AlbumResponse {
    private Integer ID;
    private String ALBUM_NAME;
    private Timestamp CREATE_TIME;
    private String CREATE_BY;
    private Timestamp UPDATE_TIME;
    private String UPDATE_BY;
}
