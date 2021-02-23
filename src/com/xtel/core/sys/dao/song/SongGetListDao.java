package com.xtel.core.sys.dao.song;

import com.xtel.core.sys.entity.Song;

import java.util.List;

public interface SongGetListDao {
    List<Song> songGetListData(Integer page_index, Integer page_size, String search_name, String order_by);
}
