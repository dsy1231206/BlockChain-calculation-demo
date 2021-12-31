package com.hndemo.calculation.utils;

import org.springframework.stereotype.Component;

@Component
public class UltraResultUtils {

    private static final double[] SRW = {0.0303,0.0906,0.1045,0.0568,0.604,0.0623,0.1209,0.0656,0.0923,
            0.0478,0.0224,0.0546,0.0518,0.0464,0.0707,0.0226};

    private static final double[] RMW = {0.0912,0.0732,0.092,0.1263,0.1026,0.0862,0.081,0.0787,
            0.0398,0.102,0.0671,0.0599};


    /**
     * 计算得到TS
     * @param y
     * @return 返回TS的值
     */
    public static double getTS(double[] y){
        double res = 0.0;
        for(int i = 0; i < y.length; i++){
            res += y[i] * SRW[i];
        }
        return res;
    }

    /**
     * 返回RMP的值
     * @param xk
     * @return
     */
    public static double getRMP(double[] xk){
        double res = 0.0;
        for(int i = 0; i < xk.length; i++){
            res += xk[i] * RMW[i];
        }
        return res;
    }


}
