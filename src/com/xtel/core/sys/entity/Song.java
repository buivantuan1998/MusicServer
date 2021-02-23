package com.xtel.core.sys.entity;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
public class Song {
    private Integer ID;
    private String SONG_NAME;
    private String URL;
    private Integer VIEWS;
    private Timestamp RELASE_TIME;
    private Integer TIME;
    private String SINGER_NAME;
    private String MUSICIAN_NAME;
    private Integer CATEGORY_ID;
    private String CATEGORY_NAME;
    private Timestamp CREATE_TIME;
    private String CREATE_BY;
    private Timestamp UPDATE_TIME;
    private String UPDATE_BY;
    private Integer STATUS;
}
