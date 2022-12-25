package com.gec.service;

import com.gec.pojo.Ip;
import com.gec.pojo.ResultFlowVo;
import com.gec.pojo.ResultVo;

import java.util.List;

public interface FlowService {
    /**
     * 获取pvs
     * @param startDate 查询条件的开始时间
     * @param endDate 查询条件的结束时间
     * @return ResultVo
     */
    ResultVo getPvs(String startDate, String endDate);

    ResultFlowVo getFlow(String startDate, String endDate);

    ResultVo getAvgPvs(String startDate, String endDate);

    List<Ip> getIpList();
}
