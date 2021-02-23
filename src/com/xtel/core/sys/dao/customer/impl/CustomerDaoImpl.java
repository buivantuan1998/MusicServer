package com.xtel.core.sys.dao.customer.impl;

import com.xtel.core.config.ConnectionDB;
import com.xtel.core.sys.dao.customer.CustomerDao;
import com.xtel.core.sys.dto.response.album.AlbumResponse;
import com.xtel.core.sys.dto.response.config_schedule.ConfigScheduleResponse;
import com.xtel.core.sys.dto.response.customer.CustomerResponse;
import com.xtel.core.sys.dto.response.customer.LoginCustomerResponse;
import com.xtel.core.sys.dto.response.play_list.PlayListResponse;
import com.xtel.core.utils.CryptoUtils;
import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    public LoginCustomerResponse getInfoAccount(String phone_number, String password) {
        Connection conn = null;
        CallableStatement callst = null;
        LoginCustomerResponse loginCustomerResponse = new LoginCustomerResponse();
        List<ConfigScheduleResponse> configScheduleResponseList = new ArrayList<>();
        List<PlayListResponse> playListResponseList = new ArrayList<>();
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            callst = conn.prepareCall("{call PKG_CUSTOMER.customer_login(?,?,?,?,?,?,?,?)}");
            int i = 1;
            callst.registerOutParameter(i++, Types.INTEGER);
            callst.registerOutParameter(i++, Types.VARCHAR);
            callst.registerOutParameter(i++, Types.VARCHAR);
            callst.registerOutParameter(i++, Types.VARCHAR);
            callst.registerOutParameter(i++, OracleTypes.CURSOR);
            callst.registerOutParameter(i++, OracleTypes.CURSOR);
            callst.registerOutParameter(i++, OracleTypes.CURSOR);
            callst.registerOutParameter(i++, OracleTypes.CURSOR);

            callst.setString(3, phone_number);
            callst.setString(4, CryptoUtils.md5Hash(password));
            callst.execute();

            rs1 = (ResultSet) callst.getObject(5);
            if (rs1 != null) {
                if (rs1.next()) {
                    CustomerResponse customerResponse = new CustomerResponse();
                    customerResponse.setCUSTOMER_NAME(rs1.getString("CUSTOMER_NAME"));
                    customerResponse.setEMAIL(rs1.getString("EMAIL"));
                    customerResponse.setFULL_NAME(rs1.getString("FULL_NAME"));
                    customerResponse.setCREATE_TIME(rs1.getTimestamp("CREATE_TIME"));
                    customerResponse.setPHONE_NUMBER(rs1.getString("PHONE_NUMBER"));
                    loginCustomerResponse.setCustomerResponse(customerResponse);
                }
            }

            rs2 = (ResultSet) callst.getObject(6);
            if (rs2 != null) {
                if (rs1.next()) {
                    AlbumResponse albumResponse = new AlbumResponse();
                    albumResponse.setID(rs2.getInt("ID"));
                    albumResponse.setALBUM_NAME(rs2.getString("ALBUM_NAME"));
                    albumResponse.setCREATE_TIME(rs2.getTimestamp("CREATE_TIME"));
                    albumResponse.setCREATE_BY(rs2.getString("CREATE_BY"));
                    albumResponse.setUPDATE_TIME(rs2.getTimestamp("UPDATE_TIME"));
                    albumResponse.setUPDATE_BY(rs2.getString("UPDATE_BY"));
                    loginCustomerResponse.setAlbumResponse(albumResponse);
                }
            }

            rs3 = (ResultSet) callst.getObject(7);
            if (rs3 != null) {
                while (rs3.next()) {
                    ConfigScheduleResponse configScheduleResponse = new ConfigScheduleResponse();
                    configScheduleResponse.setID(rs3.getInt("ID"));
                    configScheduleResponse.setNAME_CONFIG_SCHEDULE(rs3.getString("NAME_CONFIG_SCHEDULE"));
                    configScheduleResponse.setSTART_HOUR(rs3.getInt("START_HOUR"));
                    configScheduleResponse.setEND_HOUR(rs3.getInt("END_HOUR"));
                    configScheduleResponse.setSTART_MINUTE(rs3.getInt("START_MINUTE"));
                    configScheduleResponse.setEND_MINUTE(rs3.getInt("END_MINUTE"));
                    configScheduleResponse.setSTATUS(rs3.getInt("STATUS"));
                    configScheduleResponseList.add(configScheduleResponse);

                }
                loginCustomerResponse.setConfigScheduleResponseList(configScheduleResponseList);
            }

            rs = (ResultSet) callst.getObject(8);
            if (rs != null) {
                while (rs.next()) {
                    PlayListResponse playListResponse = new PlayListResponse();
                    playListResponse.setID(rs.getInt("ID"));
                    playListResponse.setPLAY_LIST_NAME(rs.getString("PLAY_LIST_NAME"));
                    playListResponse.setPLAY_LIST_TYPE(rs.getInt("PLAY_LIST_TYPE"));
                    playListResponseList.add(playListResponse);

                }
                loginCustomerResponse.setPlayListResponseList(playListResponseList);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callst);

        }
//        String token = JWTUtil.encode(loginCustomerResponse.getCustomerResponse().getEMAIL(), new Gson().toJson(loginCustomerResponse), 5);
//        loginCustomerResponse.setToken(token);
        return loginCustomerResponse;
    }
}
