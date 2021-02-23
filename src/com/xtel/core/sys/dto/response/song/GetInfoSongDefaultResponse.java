package com.xtel.core.sys.dto.response.song;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
public class GetInfoSongDefaultResponse {
    private Integer ID;
    private String SONG_NAME;
    private String URL;
    private Timestamp RELASE_TIME;
    private Integer TIME;
    private String SINGER_NAME;
    private String MUSICIAN_NAME;
    private Integer CATEGORY_ID;
    private String CATEGORY_NAME;
    private Timestamp CREATE_TIME;
    private String CODE;
}
