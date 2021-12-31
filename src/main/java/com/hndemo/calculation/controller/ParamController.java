package com.hndemo.calculation.controller;


import com.hndemo.calculation.entity.CalculateData;
import com.hndemo.calculation.entity.UltraResults;
import com.hndemo.calculation.utils.CalculateUtils;
import com.hndemo.calculation.utils.UltraResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParamController {


    @Autowired
    private UltraResultUtils ultraResultUtils;

    @RequestMapping(value = "/calculate/getmaxf",method = RequestMethod.POST)
    @ResponseBody
    public UltraResults getMaxF(HttpServletRequest request){


        //前端传来的参数
        double param1 = Double.parseDouble(request.getParameter("param1"));
        double param2 = Double.parseDouble(request.getParameter("param2"));
        double B = Double.parseDouble(request.getParameter("b"));
        System.out.println("param1:" + param1);
        System.out.println("param2:" + param2);
        System.out.println("B :" + B);

        //获得对应的结果
        double[] xk = CalculateUtils.getMaxXk(B);
        double[] y = CalculateUtils.getYi(B);

        double TS = UltraResultUtils.getTS(y);
        double RMP = UltraResultUtils.getRMP(xk);
        double bigC = CalculateUtils.getBigC(xk);
        double maxF = (param1 * TS + param2 * RMP) / bigC;

        //封装结果
        UltraResults ultra = new UltraResults();
        ultra.setMaxF(maxF * 100);
        ultra.setXk(xk);
        ultra.setY(y);
        return ultra;
    }
}
