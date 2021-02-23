package com.xtel.core.sys.dao.song.impl;

import com.xtel.core.config.ConnectionDB;
import com.xtel.core.sys.dao.song.DeleteSongDao;
import com.xtel.core.sys.dto.request.song.DeleteSongRequest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class DeleteSongDaoImpl implements DeleteSongDao {

    public DeleteSongRequest deleteSong(DeleteSongRequest request) {
        Connection conn = null;
        CallableStatement callst = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call PKG_SONG.delete_data(?,?,?)}");
            int i = 1;
            callst.registerOutParameter(i++, Types.INTEGER);
            callst.registerOutParameter(i++, Types.VARCHAR);
            callst.registerOutParameter(i++, Types.VARCHAR);
            callst.setString(3, request.getCode_song());
            callst.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callst);
        }
        return null;
    }
}
