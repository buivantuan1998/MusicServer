package com.xtel.core.sys.service.song.impl;

import com.xtel.core.sys.dao.song.GetInfoSongDefaultDao;
import com.xtel.core.sys.dto.response.song.GetInfoSongDefaultResponse;
import com.xtel.core.sys.entity.Song;
import com.xtel.core.sys.service.song.GetInfoSongDefaultService;

public class GetInfoSongDefaultImpl implements GetInfoSongDefaultService {
    private GetInfoSongDefaultDao getInfoSongDefaultDao;

    public GetInfoSongDefaultImpl(GetInfoSongDefaultDao getInfoSongDefaultDao) {
        this.getInfoSongDefaultDao = getInfoSongDefaultDao;
    }

    @Override
    public GetInfoSongDefaultResponse getInfoSongDefault(String phone_number) {
        return getInfoSongDefault(phone_number);
    }
}
