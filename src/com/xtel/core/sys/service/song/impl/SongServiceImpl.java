package com.xtel.core.sys.service.song.impl;

import com.xtel.core.sys.dao.song.SongGetListDao;
import com.xtel.core.sys.entity.Song;
import com.xtel.core.sys.service.song.SongService;

import java.util.List;

public class SongServiceImpl implements SongService {
    private SongGetListDao songGetListDao;

    public SongServiceImpl(SongGetListDao songGetListDao) {
        this.songGetListDao = songGetListDao;
    }

    @Override
    public List<Song> listSong(Integer page_index, Integer page_size, String search_name, String order_by) {
        return songGetListDao.songGetListData(page_index, page_size, search_name, order_by);
    }
}
