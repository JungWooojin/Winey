package com.team.winey.admin.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreVo {
    private Long storeId;
    private Long regionNmId;
    private String nm;
    private String tel;

}
