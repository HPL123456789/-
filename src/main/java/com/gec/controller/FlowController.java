package com.gec.controller;

import com.gec.pojo.Ip;
import com.gec.pojo.ResultFlowVo;
import com.gec.pojo.ResultVo;
import com.gec.service.FlowService;
import com.gec.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;

@Controller  //表示这个类是控制层的类 让spring创建对象
public class FlowController {
    //获取业务层对象
    @Autowired //注入对象   DI 依赖注入
    FlowService flowService;

    @RequestMapping("/pvsNum")  //请求映射   访问的路径
    @ResponseBody //以json格式返回数据
    public ResultVo findPvs(){
        System.out.println("获取9.18-9.24的pvs");
        //获取数据
        //封装数据
        //调用service层的方法
        ResultVo resultVo = flowService.getPvs("2013-09-18", "2013-09-24");

        //响应数据
        return resultVo;
    }

    @RequestMapping("/avgPvNum")  //请求映射   访问的路径
    @ResponseBody //以json格式返回数据
    public ResultVo findAvgPvNum(){
        System.out.println("获取9.18-9.24的findAvgPvNum");
        //获取数据
        //封装数据
        //调用service层的方法
        ResultVo resultVo = flowService.getAvgPvs("2013-09-18", "2013-09-24");

        //响应数据
        return resultVo;
    }


    @RequestMapping("/flowNum")  //请求映射   访问的路径
    @ResponseBody //以json格式返回数据
    public ResultFlowVo findFlowNum(){
        System.out.println("获取9.18-9.24的pvs");
        //获取数据
        //封装数据
        //调用service层的方法
        ResultFlowVo resultFlowVo = flowService.getFlow("2013-09-18", "2013-09-24");

        //响应数据
        return resultFlowVo;
    }

    @RequestMapping("/ipList")  //请求映射   访问的路径
    @ResponseBody //以json格式返回数据
    public int[] findIpList(){
        System.out.println("获取省份对应的数据");
        int[] returnList = new int[34];
        List<Ip> ipList = flowService.getIpList();
        for (Ip ip : ipList) {
            String shengfen = IpUtil.getRegion(ip.getIp());
            if (shengfen != null && !shengfen.isEmpty()) {
                System.out.println(shengfen);
                if(shengfen.contains("北京")){
                    returnList[0] += ip.getVis_num();
                }else if(shengfen.contains("天津")){
                    returnList[1] += ip.getVis_num();
                }else if(shengfen.contains("上海")){
                    returnList[2] += ip.getVis_num();
                }else if(shengfen.contains("重庆")){
                    returnList[3] += ip.getVis_num();
                }else if(shengfen.contains("河北")){
                    returnList[4] += ip.getVis_num();
                }else if(shengfen.contains("河南")){
                    returnList[5] += ip.getVis_num();
                }else if(shengfen.contains("云南")){
                    returnList[6] += ip.getVis_num();
                }else if(shengfen.contains("辽宁")){
                    returnList[7] += ip.getVis_num();
                }else if(shengfen.contains("黑龙江")){
                    returnList[8] += ip.getVis_num();
                }else if(shengfen.contains("湖南")){
                    returnList[9] += ip.getVis_num();
                }else if(shengfen.contains("安徽")){
                    returnList[10] += ip.getVis_num();
                }else if(shengfen.contains("山东")){
                    returnList[11] += ip.getVis_num();
                }else if(shengfen.contains("新疆")){
                    returnList[12] += ip.getVis_num();
                }else if(shengfen.contains("江苏")){
                    returnList[13] += ip.getVis_num();
                }else if(shengfen.contains("浙江")){
                    returnList[14] += ip.getVis_num();
                }else if(shengfen.contains("江西")){
                    returnList[15] += ip.getVis_num();
                }else if(shengfen.contains("湖北")){
                    returnList[16] += ip.getVis_num();
                }else if(shengfen.contains("广西")){
                    returnList[17] += ip.getVis_num();
                }else if(shengfen.contains("甘肃")){
                    returnList[18] += ip.getVis_num();
                }else if(shengfen.contains("山西")){
                    returnList[19] += ip.getVis_num();
                }else if(shengfen.contains("内蒙古")){
                    returnList[20] += ip.getVis_num();
                }else if(shengfen.contains("陕西")){
                    returnList[21] += ip.getVis_num();
                }else if(shengfen.contains("吉林")){
                    returnList[22] += ip.getVis_num();
                }else if(shengfen.contains("福建")){
                    returnList[23] += ip.getVis_num();
                }else if(shengfen.contains("贵州")){
                    returnList[24] += ip.getVis_num();
                }else if(shengfen.contains("广东")){
                    returnList[25] += ip.getVis_num();
                }else if(shengfen.contains("青海")){
                    returnList[26] += ip.getVis_num();
                }else if(shengfen.contains("西藏")){
                    returnList[27] += ip.getVis_num();
                }else if(shengfen.contains("四川")){
                    returnList[28] += ip.getVis_num();
                }else if(shengfen.contains("宁夏")){
                    returnList[29] += ip.getVis_num();
                }else if(shengfen.contains("海南")){
                    returnList[30] += ip.getVis_num();
                }else if(shengfen.contains("台湾")){
                    returnList[31] += ip.getVis_num();
                }else if(shengfen.contains("香港")){
                    returnList[32] += ip.getVis_num();
                }else if(shengfen.contains("澳门")){
                    returnList[33] += ip.getVis_num();
                }
            }
        }
        return returnList;
    }
}
