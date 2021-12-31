package com.hndemo.calculation;

import com.hndemo.calculation.utils.CalculateUtils;
import com.hndemo.calculation.utils.UltraResultUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculationApplicationTests {

    @Test
    void contextLoads() {
        double[] minXk = CalculateUtils.getMinXkArray();
        for(int i = 0; i < minXk.length; i++){
            System.out.println(minXk[i]);
        }
        System.out.println("================");

        double paramSum = 0.0;
        double[] param = CalculateUtils.getC();
        for(int i = 0; i < param.length; i++){
            paramSum += param[i];
            System.out.println(param[i]);
        }
        System.out.println("参数总和" + paramSum);
        System.out.println("================");

        System.out.println("最大参数列表：");
        double[] xk1 = CalculateUtils.getMaxXk(88);
        for(int i = 0; i < xk1.length; i++){
            System.out.println(xk1[i]);
        }
        System.out.println("================");

        System.out.println("新的参数列表：");
        double[] xk2 = CalculateUtils.getMaxXk(80);
        for(int i = 0; i < xk2.length; i++){
            System.out.println(xk2[i]);
        }


    }

    @Test
    void test1(){
        //前端传来的参数
        double param1 = 0.6;
        double param2 = 0.4;
        double B = 70;

        //获得对应的结果
        double[] xk = CalculateUtils.getMaxXk(B);
        System.out.println("xk:");
        for(int i = 0; i < xk.length; i++){
            System.out.println(xk[i]);
        }
        System.out.println("===============");
        System.out.println("y:");
        double[] y = CalculateUtils.getYi(B);
        for(int i = 0; i < y.length; i++){
            System.out.println(y[i]);
        }
        System.out.println("===============");
        double TS = UltraResultUtils.getTS(y);
        System.out.println("TS:" + TS);
        double RMP = UltraResultUtils.getRMP(xk);
        System.out.println("RMP:" + RMP);
        double bigC = CalculateUtils.getBigC(xk);
        System.out.println("BIG C : " + bigC);
        double maxF = (param1 * TS + param2 * RMP) / bigC;
        System.out.println("maxF:" + maxF);
    }

    /**
     * 测试getBigC
     */
    @Test
    void test02(){
        double B = 80;
        double[] xk = CalculateUtils.getMaxXk(B);
        System.out.println("xk:");
        for(int i = 0; i < xk.length; i++){
            System.out.println(xk[i]);
        }
        System.out.println("==============");
        double[] c = CalculateUtils.getC();
        System.out.println("xk:");
        for(int i = 0; i < c.length; i++){
            System.out.println(c[i]);
        }
        System.out.println("==============");
        double bigC = CalculateUtils.getBigC(xk);
        System.out.println("bigC:" + bigC);
    }

    /**
     * B = 0
     */
    @Test
    void test03(){
        double[] xk = CalculateUtils.getMaxXk(0);
        for(int i = 0; i < xk.length; i++){
            System.out.println(xk[i]);
        }
    }


    @Test
    void test04(){
        double[] minXk = CalculateUtils.getMinXkArray();
        for(int i = 0; i < minXk.length; i++){
            System.out.println(minXk[i]);
        }

    }

}
