package com.xtel.core.sys.service.song;

import com.xtel.core.sys.entity.Song;

import java.util.List;

public interface SongService {
    List<Song> listSong(Integer page_index, Integer page_size, String search_name, String order_by);
}
