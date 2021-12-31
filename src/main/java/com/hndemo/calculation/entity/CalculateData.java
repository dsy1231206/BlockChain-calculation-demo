package com.hndemo.calculation.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CalculateData {

    private double param1;
    private double param2;
    private double b;
}
