package com.xtel.core.sys.service.song;

import com.xtel.core.sys.dto.response.song.GetInfoSongDefaultResponse;
import com.xtel.core.sys.entity.Song;

public interface GetInfoSongDefaultService {
    GetInfoSongDefaultResponse getInfoSongDefault(String phone_number);
}
