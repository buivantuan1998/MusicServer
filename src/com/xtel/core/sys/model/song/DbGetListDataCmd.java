package com.xtel.core.sys.model.song;

import com.xtel.core.config.ConnectionDB;
import com.xtel.core.sys.entity.Song;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DbGetListDataCmd {
    public List<Song> getListData(){
        Connection conn = null;
        CallableStatement callst = null;
        List<Song> songList = new ArrayList<>();
        ResultSet rs =  null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call PKG_SONG.get_list_data(?,?,?)}");
            int i = 1;
            callst.registerOutParameter(i++, Types.INTEGER);
            callst.registerOutParameter(i++, Types.VARCHAR);
            callst.registerOutParameter(i++, OracleTypes.CURSOR);
            callst.execute();
            rs = (ResultSet) callst.getObject(3);
            if (rs != null){
                while (rs.next()){
                    Song song = new Song();
                    song.setID(rs.getInt("ID"));
                    song.setSONG_NAME(rs.getString("SONG_NAME"));
                    song.setURL(rs.getString("URL"));
                    song.setVIEWS(rs.getInt("VIEWS"));
                    song.setRELASE_TIME(rs.getTimestamp("RELASE_TIME"));
                    song.setTIME(rs.getInt("TIME"));
                    song.setSINGER_NAME(rs.getString("SINGER_NAME"));
                    song.setMUSICIAN_NAME(rs.getString("MUSICIAN_NAME"));
                    song.setCATEGORY_ID(rs.getInt("CATEGORY_ID"));
                    song.setCATEGORY_NAME(rs.getString("CATEGORY_NAME"));
                    song.setCREATE_TIME(rs.getTimestamp("CREATE_TIME"));
                    song.setCREATE_BY(rs.getString("CREATE_BY"));
                    song.setUPDATE_TIME(rs.getTimestamp("UPDATE_TIME"));
                    song.setUPDATE_BY(rs.getString("UPDATE_BY"));
                    song.setSTATUS(rs.getInt("STATUS"));
                    songList.add(song);
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
        return songList;
    }
}
