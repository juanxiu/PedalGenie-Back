package com.pedalgenie.pedalgenieback.domain.available.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AvailableTimeSlotPriceResponse {

    private BigDecimal price;
    private BigDecimal fee; // 수수료
    private BigDecimal totalPrice; // 총금액
    private List<AvailableTimeSlotResponse> availableTimeSlots;


    public AvailableTimeSlotPriceResponse(List<AvailableTimeSlotResponse> availableTimeSlots, BigDecimal price) {
        this.price = price;
        this.fee = price.multiply(BigDecimal.valueOf(0.1));
        this.totalPrice = price.add(fee);
        this.availableTimeSlots = availableTimeSlots;
    }

}
