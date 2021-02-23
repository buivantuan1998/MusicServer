package com.xtel.core.sys.dto.response.customer;

import com.xtel.core.sys.dto.response.play_list.PlayListResponse;
import com.xtel.core.sys.dto.response.album.AlbumResponse;
import com.xtel.core.sys.dto.response.config_schedule.ConfigScheduleResponse;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class LoginCustomerResponse {
//    private String token;
    private CustomerResponse customerResponse;
    private AlbumResponse albumResponse;
    private List<ConfigScheduleResponse> configScheduleResponseList;
    private List<PlayListResponse> playListResponseList;
}
