package com.gec.mapper;

import com.gec.pojo.*;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PvsMapper {
    long countByExample(PvsExample example);

    int deleteByExample(PvsExample example);

    int insert(Pvs record);

    int insertSelective(Pvs record);

    List<Pvs> selectByExample(PvsExample example);

    int updateByExampleSelective(@Param("record") Pvs record, @Param("example") PvsExample example);

    int updateByExample(@Param("record") Pvs record, @Param("example") PvsExample example);

    List<AvgPvs> selectAvgByExample(PvsExample pvsExample);

    List<Flow> selectByFlow(PvsExample pvsExample);

    List<Ip> selectIpList();
}