package com.team.winey.admin.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Getter
@Builder
public class OrderDetail3 {
    private List<OrderDetail1> list1;
    private List<OrderDetail2> list2;
}
