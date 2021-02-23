package com.xtel.core.sys.dao.song.impl;

import com.xtel.core.config.ConnectionDB;
import com.xtel.core.sys.dao.song.GetInfoSongDefaultDao;
import com.xtel.core.sys.dto.response.song.GetInfoSongDefaultResponse;
import com.xtel.core.sys.entity.Song;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

public class GetInfoSongDefaultDaoImpl implements GetInfoSongDefaultDao {

    public GetInfoSongDefaultResponse getInfoSongDefault(String phone_number) {
        Connection conn = null;
        CallableStatement callst = null;
        GetInfoSongDefaultResponse data = new GetInfoSongDefaultResponse();
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call PKG_SONG.get_song_defauft(?,?,?,?)}");
            int i = 1;
            callst.registerOutParameter(i++, Types.INTEGER);
            callst.registerOutParameter(i++, Types.VARCHAR);
            callst.registerOutParameter(i++, Types.VARCHAR);
            callst.registerOutParameter(i++, OracleTypes.CURSOR);

            callst.setString(3, phone_number);
            callst.executeUpdate();
            rs = (ResultSet) callst.getObject(4);
            if (rs != null){
                if (rs.next()) {
                    data.setID(rs.getInt("ID"));
                    data.setSONG_NAME(rs.getString("SONG_NAME"));
                    data.setURL(rs.getString("URL"));
                    data.setRELASE_TIME(rs.getTimestamp("RELASE_TIME"));
                    data.setTIME(rs.getInt("TIME"));
                    data.setSINGER_NAME(rs.getString("SINGER_NAME"));
                    data.setMUSICIAN_NAME(rs.getString("MUSICIAN_NAME"));
                    data.setCATEGORY_ID(rs.getInt("CATEGORY_ID"));
                    data.setCATEGORY_NAME(rs.getString("CATEGORY_NAME"));
                    data.setCREATE_TIME(rs.getTimestamp("CREATE_TIME"));
                    data.setCODE(rs.getString("CODE"));
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callst);
            if (rs != null){
                try {
                    rs.close();
                }catch (Exception ex1){
                    ex1.printStackTrace();
                }
            }
        }
        return data;
    }
}
