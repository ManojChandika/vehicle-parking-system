package com.example.vehiclemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FloorAllocationDTO {
    private  Long id;
    private String vehicleType;
    private int parkingSlots;
    private double rate;
}
