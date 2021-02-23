package com.xtel.core.sys.dto.request.song;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DeleteSongRequest {
    private String code_song;
}
