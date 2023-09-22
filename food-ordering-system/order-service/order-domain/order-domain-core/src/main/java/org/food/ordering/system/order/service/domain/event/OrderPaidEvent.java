package org.food.ordering.system.order.service.domain.event;

import org.food.ordering.system.domain.event.DomainEvent;
import org.food.ordering.system.domain.event.publisher.DomainEventPublisher;
import org.food.ordering.system.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderPaidEvent extends OrderEvent {

    private final DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEvent;

    public OrderPaidEvent(Order order, ZonedDateTime createdAt, DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEvent) {
        super(order, createdAt);
        this.orderPaidEventDomainEvent = orderPaidEventDomainEvent;
    }

    @Override
    public void fire() {
        orderPaidEventDomainEvent.publish(this);
    }
}
