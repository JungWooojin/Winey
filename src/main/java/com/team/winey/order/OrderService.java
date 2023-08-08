package com.team.winey.order;

import com.team.winey.order.model.OrderEntity;
import com.team.winey.order.model.OrderIdCountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.SpringProperties;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper mapper;

    List<OrderEntity> selOrder(Long userId) {

        List<OrderEntity> temp = new ArrayList<>();

        for (int i = mapper.selOrderIdMax(userId); i > 0 ; i--) {

            OrderIdCountDto dto = new OrderIdCountDto();
            dto.setUserId(userId);
            dto.setOrderId(Long.valueOf(i));

            int result = mapper.selOrderCountByUser(dto);
            if(result >= 2 ) {
                OrderEntity entity = new OrderEntity();
                List<OrderEntity> list = mapper.selOrder(dto);

                entity.setOrderDate(list.get(0).getOrderDate());
                entity.setUserId(userId);
                entity.setOrderId(Long.valueOf(i));
                entity.setPayment(list.get(0).getPayment());

                for (int j = 0; j < list.size(); j++) {
                    int sum = list.get(j).getTotalOrderPrice() + list.get(j).getTotalOrderPrice();
                    entity.setTotalOrderPrice(sum);

                }

                entity.setNmKor(list.get(0).getNmKor() + " 외" + (result-1) + "건");

                temp.add(entity);
            } else if (result == 1) {
                OrderEntity entity = new OrderEntity();
                entity.setUserId(userId);
                entity.setOrderId(Long.valueOf(i));
                entity.setNmKor(entity.getNmKor());

                temp.add(entity);
            }

        }

        return temp;

    }
}
