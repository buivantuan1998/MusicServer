package com.xtel.core.sys.service.song.impl;

import com.xtel.core.sys.dao.song.SongGetListDataDao;
import com.xtel.core.sys.entity.Song;
import com.xtel.core.sys.service.song.SongGetListDataService;

import java.util.List;

public class SongGetListDataServiceImpl implements SongGetListDataService {
    private SongGetListDataDao songGetListDataDao;

    public SongGetListDataServiceImpl(SongGetListDataDao songGetListDataDao) {
        this.songGetListDataDao = songGetListDataDao;
    }

    @Override
    public List<Song> listData() {
        return songGetListDataDao.getListSongData();
    }
}
