package com.xtel.core.sys.controller;

import com.xtel.core.sys.dao.song.SongGetListDao;
import com.xtel.core.sys.dao.song.impl.SongGetListDaoImpl;
import com.xtel.core.sys.dao.song.SongGetListDataDao;
import com.xtel.core.sys.dao.song.impl.SongGetListDataDaoImpl;
import com.xtel.core.sys.dto.request.song.DeleteSongRequest;
import com.xtel.core.sys.dto.response.song.GetInfoSongDefaultResponse;
import com.xtel.core.sys.model.song.DbDeleteSongCmd;
import com.xtel.core.sys.model.song.GetInfoSongDefaultCmd;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/song")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class SongController {
    private SongGetListDataDao songGetListDataDao;
    private SongGetListDao songGetListDao;

    public SongController() {
        this.songGetListDao = new SongGetListDaoImpl();
        this.songGetListDataDao = new SongGetListDataDaoImpl();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListSong(@QueryParam("page_index") Integer page_index,
                                @QueryParam("page_size") Integer page_size,
                                @QueryParam("search_name") String search_name,
                                @QueryParam("order_by") String order_by){
        return Response.ok(songGetListDao.songGetListData(page_index, page_size, search_name, order_by)).build();
    }

    @GET
    @Path("/list_data")
    public Response getListData(){
        return Response.ok(songGetListDataDao.getListSongData()).build();
    }

    @GET
    @Path("/song_default")
    public Response getSongDefault(@QueryParam("phone_number") String phone_number){
        GetInfoSongDefaultCmd cmd = new GetInfoSongDefaultCmd();
        GetInfoSongDefaultResponse getInfoSongDefaultResponse = cmd.getInfoSongDefaultResponse(phone_number);
        return Response.ok(getInfoSongDefaultResponse).build();
    }

    @POST
    @Path("delete")
    public Response deleteSong(DeleteSongRequest deleteSongRequest){
        DbDeleteSongCmd cmd = new DbDeleteSongCmd();
        DeleteSongRequest request = cmd.deleteSong(deleteSongRequest.getCode_song());
        return Response.ok(request).build();
    }

}
