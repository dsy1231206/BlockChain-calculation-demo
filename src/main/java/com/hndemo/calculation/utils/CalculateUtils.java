package com.hndemo.calculation.utils;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CalculateUtils {

    //最新table5
    public static final double[][] NCo = {
            {0.8,0.7,0.7,0.65,0.4,0.9,0.75,0.5,0.75,0.45,0.55,0.6},
            {0.45,0.65,0.8,0.35,0.60,0.75,0.6,0.45,0.60,0.40,0.50,0.8},
            {0.55,0.75,0.35,0.80,0.70,0.85,0.70,0.55,0.65,0.55,0.60,0.75}
    };

    //RMk和RFj的关系
    public static final double[][] FMjk = {
            {0.087,0.163,0.12,0.098,0.076,0,0,0.109,0.098,0.098,0.054,0.098},
            {0.066,0.066,0.121,0.198,0.022,0,0,0.11,0.165,0.022,0.055,0.176},
            {0.253,0.2,0.027,0.067,0.027,0,0,0.04,0.027,0.187,0.067,0.107},
            {0.036,0,0,0,0.036,0,0,0.571,0,0.143,0.143,0.071},
            {0.186,0.093,0.116,0,0.465,0,0,0,0,0.07,0,0.07},
            {0.125,0.109,0,0,0.031,0.203,0,0.125,0.016,0.094,0.297,0},
            {0.109,0.109,0.164,0.073,0.291,0.018,0.018,0.036,0.073,0,0,0.109},
            {0.107,0.143,0.107,0.143,0.286,0,0,0,0.107,0,0,0.107},
            {0,0,0,0.261,0,0,0,0,0,0.609,0.13,0},
            {0,0,0.179,0.286,0,0,0.321,0.071,0,0,0.143,0},
            {0,0,0.138,0.172,0,0,0.69,0,0,0,0,0},
            {0.107,0,0.107,0.179,0,0.607,0,0,0,0,0,0}
    };

    //Rij，SRi和RFj的关系
    public static final double[][] Rij = {
            {0.218,0.205,0.077,0.013,0.026,0.013,0.077,0.115,0,0.141,0.064,0.051},
            {0.087,0.152,0.065,0.011,0.087,0,0.109,0.217,0.022,0.163,0.022,0.065},
            {0.067,0,0.111,0,0,0.133,0.022,0,0.089,0,0.178,0.4},
            {0.163,0.082,0.061,0,0.02,0,0.041,0.02,0,0.122,0.408,0.082},
            {0.067,0,0,0,0.111,0,0.089,0.067,0.422,0.133,0,0.111},
            {0.095,0.048,0.048,0.095,0.079,0.143,0.095,0.111,0.063,0.095,0.095,0.032},
            {0.037,0.012,0.073,0.22,0.037,0.244,0,0,0.073,0.159,0.061,0.085},
            {0.149,0.119,0,0,0.209,0.015,0.239,0.134,0.03,0.075,0,0.03},
            {0.158,0.053,0,0,0.105,0,0.158,0.105,0.158,0,0.053,0.211},
            {0.147,0.176,0.029,0.412,0.088,0.059,0.029,0.029,0,0.029,0,0},
            {0.158,0.158,0.053,0.316,0.053,0.053,0,0,0.105,0,0,0.105},
            {0.143,0.095,0.238,0,0.143,0.095,0.048,0.238,0,0,0,0},
            {0.153,0.068,0.339,0.017,0.051,0.051,0.085,0.068,0,0.034,0.034,0.102},
            {0.089,0.125,0.018,0.036,0.357,0,0.089,0.125,0.018,0.071,0.071,0},
            {0,0.1,0.167,0.067,0.067,0,0.033,0.033,0.2,0.033,0.133,0.167},
            {0.103,0,0,0.051,0.103,0.077,0.154,0,0.154,0.128,0.077,0.154}
    };

    private static final double[] SRW = {0.0303,0.0906,0.1045,0.0568,0.604,0.0623,0.1209,0.0656,0.0923,
            0.0478,0.0224,0.0546,0.0518,0.0464,0.0707,0.0226};

    private static final double[] RMW = {0.0912,0.0732,0.092,0.1263,0.1026,0.0862,0.081,0.0787,
            0.0398,0.102,0.0671,0.0599};

    //最新table6
    private static final double[] c = {9.62,11.54,8.17,8.65,10.58,5.29,11.06,7.21,6.25,3.85,10.1,7.69};

    private static final double basicB = 10000;

    /**
     * NCo确定，计算出xk的最小值并返回
     * @return  xk数组，k = 1,2,...h  (h = 12)
     */
    public static double[] getMinXkArray(){
        double[] xk = new double[12];
        for(int i = 0; i < xk.length; i++){
            double x = 0.0;
            for(int t = 0; t < 3; t++){
                x += NCo[t][i];
            }
            xk[i] = x / 3.0;
        }
        return xk;
    }

    /**
     * 计算出C表达式中，xk的参数Ak
     * @return 参数数组
     * 已舍弃
     */
    @Deprecated
    public static double[] getParamAboutXkInC(){
        double[] param = new double[12];
        for(int i = 0; i < param.length; i++){
            param[i] = c[i] * RMW[i];
        }
        return param;
    }

    /**
     * 拿到ck数组
     * @return
     */
    public static double[] getC(){
        double[] res = new double[12];
        for(int i = 0; i < res.length; i++){
            res[i] = c[i];
        }
        return res;
    }

    /**
     * 得到都取到最大值的xk数组
     * 方案是这样的：
     *      先将<param,index>放入到HashMap
     *      排序数组之后，依次将KV放入到新的HashMap
     *      于是新的HashMap就记录了当前参数的下标index
     *      按照index，依次将xk取最大值
     *      得到最终结果，C <= B，直接返回
     *      如果C > B，依次更新最后的xk
     *
     * @param B 限制条件，A1X1 + A2X2 + ... + AhXh <= B
     * @return 返回最大xk数组
     */
    public static double[] getMaxXk(double B){
        if(B >= basicB) B = basicB;
        double[] param = getC();
        //如果每个xk都取最大值1
        double[] xk = new double[]{1,1,1,1,1,1,1,1,1,1,1,1};
        double sum = 0.0;
        for(int i = 0; i < param.length; i++){
            sum += param[i];
        }
        if(sum <= B) return xk;
        else return freshXk(param,xk,sum,B);
    }

    public static double[] freshXk(double[] param,double[] xk,double sum,double B){
        //xk的最小值
        double[] minXk = getMinXkArray();
        //用一个map记录每个系数的下标
        Map<Double,Integer> map = new HashMap<>();
        for(int i = 0; i < param.length; i++){
            map.put(param[i],i);
        }
        //根据参数大小进行排序
        Arrays.sort(param);
        //index用来记录当前需要更改的参数位置
        int index = param.length - 1;
        //从最后一个xk开始修改
        while(sum > B && index >= 0){
            //xk对应的下标
            int curIndex = map.get(param[index]);
            double leftSpace = B - (sum - param[index]);
            double maxXk = leftSpace / param[index];
            //更新xk[curIndex]
            if(maxXk > xk[curIndex]){
                xk[curIndex] = maxXk;
            }else {
                xk[curIndex] = minXk[curIndex];
            }
            //确定了当前xk，sum 和 B 都减掉这部分，继续判断
            sum -= param[index];
            B -= param[index] * xk[curIndex];
            index--;
        }
        return xk;
    }

    /**
     * 计算RFLj
     * @return 返回RFLj数组，用来计算yi
     */
    public static double[] getRFLj(double B){
        double[] xk = getMaxXk(B);
        double[] RFL = new double[FMjk.length];
        for(int i = 0; i < RFL.length; i++){
            double sum = 0.0;
            for(int k = 0; k < xk.length; k++){
                sum += FMjk[i][k] * xk[k];
            }
            RFL[i] = sum;
        }
        return RFL;
    }

    /**
     * 求yi的方法
     * @return 返回yi数组
     */
    public static double[] getYi(double B){
        double[] RFL = getRFLj(B);
        double[] y = new double[Rij.length];
        for(int i = 0; i < y.length; i++){
            double sum = 0.0;
            for(int j = 0; j < RFL.length; j++){
                sum += Rij[i][j] * RFL[j];
            }
            y[i] = sum;
        }
        return y;
    }

    /**
     * 得到分母的大C
     * @param xk
     * @return
     */
    public static double getBigC(double[] xk){
        double sum = 0.0;
        for(int i = 0; i < xk.length; i++){
            sum += c[i] * xk[i];
        }
        return sum;
    }

}
 