package org.food.ordering.system.order.service.domain;

import org.food.ordering.system.order.service.domain.entity.Order;
import org.food.ordering.system.order.service.domain.entity.Restaurant;
import org.food.ordering.system.order.service.domain.event.OrderCancelledEvent;
import org.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import org.food.ordering.system.order.service.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateOrderAndInitiateOrder(Order order, Restaurant restaurant);
    OrderPaidEvent validateOrderAndInitiateOrder(Order order);
    void approveOrder(Order order);
    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);
    void cancelOrder(Order order, List<String> failureMessages);
}
