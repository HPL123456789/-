package com.gec.service.impl;

import com.gec.mapper.PvsMapper;
import com.gec.pojo.*;
import com.gec.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //表示这个类是业务层的类 让spring创建对象      IOC 控制反转
public class FlowServiceImpl implements FlowService {

    //获取mapper层的对象
    @Autowired
    PvsMapper pvsMapper;

    /**
     * 获取pvs
     *
     * @param startDate 查询条件的开始时间
     * @param endDate   查询条件的结束时间
     * @return ResultVo
     */
    @Override
    public ResultVo getPvs(String startDate, String endDate) {
        PvsExample pvsExample = new PvsExample();
        pvsExample.setOrderByClause("daystr Asc");
        PvsExample.Criteria criteria = pvsExample.createCriteria();
        //封装查询条件  between ... and
        criteria.andDaystrBetween(startDate, endDate);

        //调用mapper的方法
        List<Pvs> pvs = pvsMapper.selectByExample(pvsExample);

        //创建数组
        String[] dates = new String[pvs.size()];
        Long[] data = new Long[pvs.size()];
        
        //遍历集合 pvs
//        for (int i = 0;i < pvs.size();i++) {
//            //将日期和pv分别保存到数组
//            dates[i] = pvs.get(i).getDaystr();
//            data[i] = pvs.get(i).getPvs();
//        }
        int i = 0;
        for (Pvs pv : pvs) {
            //将日期和pv分别保存到数组
            dates[i] = pv.getDaystr();
            data[i] = pv.getPvs();
            i++;
        }
        //创建ResultVo的对象
        ResultVo resultVo = new ResultVo();
        //将数组封装到resultVo
        resultVo.setDates(dates);
        resultVo.setData(data);

        return resultVo;
    }

    @Override
    public ResultFlowVo getFlow(String startDate, String endDate) {
        PvsExample pvsExample = new PvsExample();
        pvsExample.setOrderByClause("daystr Asc");
        PvsExample.Criteria criteria = pvsExample.createCriteria();
        //封装查询条件  between ... and
        criteria.andDaystrBetween(startDate, endDate);

        //调用mapper的方法
        List<Flow> flows = pvsMapper.selectByFlow(pvsExample);

        //创建数组
        String[] dates = new String[flows.size()];
        String[] uvs = new String[flows.size()];
        String[] new_uvs = new String[flows.size()];
        //遍历集合 pvs
//        for (int i = 0;i < pvs.size();i++) {
//            //将日期和pv分别保存到数组
//            dates[i] = pvs.get(i).getDaystr();
//            data[i] = pvs.get(i).getPvs();
//        }
        int i = 0;
        for (Flow flow : flows) {
            //将日期和pv分别保存到数组
            dates[i] = flow.getDaystr();
            uvs[i] = flow.getUvs();
            new_uvs[i] = flow.getNew_uvs();
            i++;
        }
        //创建ResultVo的对象
        ResultFlowVo resultFlowVo = new ResultFlowVo();
        //将数组封装到resultVo
        resultFlowVo.setDates(dates);
        resultFlowVo.setUvs(uvs);
        resultFlowVo.setNew_uvs(new_uvs);
        return resultFlowVo;
    }

    @Override
    public ResultVo getAvgPvs(String startDate, String endDate) {
        PvsExample pvsExample = new PvsExample();
        pvsExample.setOrderByClause("daystr Asc");
        PvsExample.Criteria criteria = pvsExample.createCriteria();
        //封装查询条件  between ... and
        criteria.andDaystrBetween(startDate, endDate);

        //调用mapper的方法
        List<AvgPvs> avgPvsList = pvsMapper.selectAvgByExample(pvsExample);

        //创建数组
        String[] dates = new String[avgPvsList.size()];
        Double[] data = new Double[avgPvsList.size()];

        //遍历集合 pvs
//        for (int i = 0;i < pvs.size();i++) {
//            //将日期和pv分别保存到数组
//            dates[i] = pvs.get(i).getDaystr();
//            data[i] = pvs.get(i).getPvs();
//        }
        int i = 0;
        for (AvgPvs avgPvs : avgPvsList) {
            //将日期和pv分别保存到数组
            dates[i] = avgPvs.getDaystr();
            data[i] = avgPvs.getAvgPvs();
            i++;
        }
        //创建ResultVo的对象
        ResultVo resultVo = new ResultVo();
        //将数组封装到resultVo
        resultVo.setDates(dates);
        resultVo.setData(data);

        return resultVo;
    }

    @Override
    public List<Ip> getIpList() {

        //调用mapper的方法
        List<Ip> ipList = pvsMapper.selectIpList();

        return ipList;
    }
}
