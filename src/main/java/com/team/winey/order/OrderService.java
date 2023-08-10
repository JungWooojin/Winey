package com.team.winey.order;

import com.team.winey.order.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper mapper;

    List<OrderEntity> selOrder(Long userId){
        List<OrderEntity> list = mapper.selOrder(userId);

        for(OrderEntity entity : list){
            if(entity.getCount() >= 2 ){

                entity.setOrderDate(entity.getOrderDate());
                entity.setUserId(userId);
                entity.setOrderId(entity.getOrderId());
                entity.setPayment(entity.getPayment());
                entity.setTotalOrderPrice(entity.getTotalOrderPrice());
                entity.setStoreNm("이마트 " + entity.getStoreNm());


                try {
                    String strDate = list.get(0).getPickupTime();
                    SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat newDtFormat = new SimpleDateFormat("MM월 dd일 E요일 HH:mm");
                    // String 타입을 Date 타입으로 변환

                    Date formatDate = dtFormat.parse(strDate);
                    // Date타입의 변수를 새롭게 지정한 포맷으로 변환

                    String strNewDtFormat = newDtFormat.format(formatDate);

                    entity.setPickupTime(strNewDtFormat);
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                entity.setOrderStatus(list.get(0).getOrderStatus());

                entity.setNmKor(list.get(0).getNmKor() + " 외 " + (entity.getCount() - 1) + "건");


            } else if (entity.getCount() == 1) {

                entity.setOrderDate(entity.getOrderDate());
                entity.setUserId(userId);
                entity.setOrderId(entity.getOrderId());
                entity.setPayment(entity.getPayment());
                entity.setTotalOrderPrice(entity.getTotalOrderPrice());
                entity.setStoreNm("이마트 " + entity.getStoreNm());

                try {
                    String strDate = list.get(0).getPickupTime();
                    SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat newDtFormat = new SimpleDateFormat("MM월 dd일 E요일 HH:mm");
                    // String 타입을 Date 타입으로 변환

                    Date formatDate = dtFormat.parse(strDate);
                    // Date타입의 변수를 새롭게 지정한 포맷으로 변환

                    String strNewDtFormat = newDtFormat.format(formatDate);


                    entity.setPickupTime(strNewDtFormat);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                entity.setOrderStatus(entity.getOrderStatus());
                entity.setNmKor(entity.getNmKor());
            }
        }
        return list;
    }


    int cancelOrder(Long orderId) {
        return mapper.cancelOrder(orderId);

    }

    int pickupFinishOrder(Long orderId) {
        return mapper.pickupFinishOrder(orderId);
    }

    public DetailVo selOrderDetail(Long orderId){

        List<OrderDetailVo1> vo1 = mapper.selOrderDetail1(orderId);


        OrderDetailVo2 vo2 = mapper.selOrderDetail2(orderId);
        if(vo2 != null) {
            try {
                String strDate = vo2.getPickupTime();
                SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat newDtFormat = new SimpleDateFormat("MM월 dd일 E요일 HH:mm");
                // String 타입을 Date 타입으로 변환

                Date formatDate = dtFormat.parse(strDate);
                // Date타입의 변수를 새롭게 지정한 포맷으로 변환

                String strNewDtFormat = newDtFormat.format(formatDate);

                vo2.setPickupTime(strNewDtFormat);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            vo2.setStoreNm("이마트 " + vo2.getStoreNm());
        } else {
            return null;
        }


        return DetailVo.builder()
                .vo1(vo1)
                .vo2(vo2)
                .build();

    }




}




