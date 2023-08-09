package com.team.winey.order;

import com.team.winey.order.model.OrderCancelDto;
import com.team.winey.order.model.OrderEntity;
import com.team.winey.order.model.OrderIdCountDto;
import com.team.winey.order.model.OrderPickupFinishDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.SpringProperties;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper mapper;

    List<OrderEntity> selOrder(Long userId) {

        List<OrderEntity> temp = new ArrayList<>();


        if ("".equals(mapper.selOrderIdMax(userId))) {

            for (int i = mapper.selOrderIdMax(userId); i > 0; i--) {


                OrderIdCountDto dto = new OrderIdCountDto();
                dto.setUserId(userId);
                dto.setOrderId(Long.valueOf(i));


                int result = mapper.selOrderCountByUser(dto);
                if (result >= 2) {
                    OrderEntity entity = new OrderEntity();
                    List<OrderEntity> list = mapper.selOrder(dto);

                    entity.setOrderDate(list.get(0).getOrderDate());
                    entity.setUserId(userId);
                    entity.setOrderId(Long.valueOf(i));
                    entity.setPayment(list.get(0).getPayment());

                    int sum = 0;
                    for (int j = 0; j < list.size(); j++) {
                        sum += list.get(j).getTotalOrderPrice();
                    }
                    entity.setTotalOrderPrice(sum);

                    entity.setStoreNm("이마트 " + list.get(0).getStoreNm());


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

                    entity.setNmKor(list.get(0).getNmKor() + " 외" + (result - 1) + "건");

                    temp.add(entity);
                } else if (result == 1) {
                    OrderEntity entity = new OrderEntity();
                    List<OrderEntity> list = mapper.selOrder(dto);

                    entity.setOrderDate(list.get(0).getOrderDate());
                    entity.setUserId(userId);
                    entity.setOrderId(Long.valueOf(i));
                    entity.setPayment(list.get(0).getPayment());
                    entity.setTotalOrderPrice(list.get(0).getTotalOrderPrice());
                    entity.setStoreNm("이마트 " + list.get(0).getStoreNm());

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
                    entity.setNmKor(list.get(0).getNmKor());

                    temp.add(entity);
                }
            }
            return temp;
        } else {
            return null;
        }

    }

    int cancelOrder(Long orderId) {
        return mapper.cancelOrder(orderId);

    }

    int pickupFinishOrder(Long orderId) {
        return mapper.pickupFinishOrder(orderId);
    }
}
