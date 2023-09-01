package com.team.winey.payment.model;

import lombok.Data;


@Data
public class RegionSelVO {
    private int regionNmId; //지역pk
    private String regionNm; //지역이름
    private int storeId; //매장pk
    private String nm; //매장 지점 이름
    private String address; //매장주소
}
