package com.xtel.core.sys.dao.song;

import com.xtel.core.sys.dto.response.song.GetInfoSongDefaultResponse;
import com.xtel.core.sys.entity.Song;

public interface GetInfoSongDefaultDao {
    GetInfoSongDefaultResponse getInfoSongDefault(String phone_number);
}
