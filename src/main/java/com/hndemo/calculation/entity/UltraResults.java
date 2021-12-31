package com.hndemo.calculation.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UltraResults {
    private double maxF;
    private double[] xk;
    private double[] y;
}
