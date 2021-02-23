package com.xtel.core.sys.service.song.impl;

import com.xtel.core.sys.dao.song.DeleteSongDao;
import com.xtel.core.sys.dto.request.song.DeleteSongRequest;
import com.xtel.core.sys.service.song.DeleteSongService;

public class DeleteSongServiceImpl implements DeleteSongService {
    private DeleteSongDao deleteSongDao;

    public DeleteSongServiceImpl(DeleteSongDao deleteSongDao) {
        this.deleteSongDao = deleteSongDao;
    }

    @Override
    public DeleteSongRequest deleteSongRequest(DeleteSongRequest request) {
        return deleteSongDao.deleteSong(request);
    }
}
