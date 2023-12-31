package org.food.ordering.system.payment.service.domain.valueobject;

import org.food.ordering.system.domain.valueobject.*;
import org.food.ordering.system.payment.service.domain.entity.Payment;

import java.time.ZonedDateTime;
import java.util.UUID;

public class PaymentId extends BaseId<UUID> {

    public PaymentId(UUID value) {
        super(value);
    }
}
