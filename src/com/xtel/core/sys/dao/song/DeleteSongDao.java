package com.xtel.core.sys.dao.song;

import com.xtel.core.sys.dto.request.song.DeleteSongRequest;

public interface DeleteSongDao {
    DeleteSongRequest deleteSong(DeleteSongRequest request);
}
