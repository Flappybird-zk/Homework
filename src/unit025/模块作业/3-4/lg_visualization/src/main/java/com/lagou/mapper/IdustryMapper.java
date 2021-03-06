package com.lagou.mapper;

import com.lagou.vo.ConverterVo;
import com.lagou.vo.IndustryVo;
import com.lagou.vo.SalaryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IdustryMapper {
    /**
     * 统计各个城市招聘情况
     * @return
     */
    public List<ConverterVo> countCityPosition() ;

    List<IndustryVo> countIndustryTop();

    /**
     * 统计热门行业对比
     * @param industryName
     * @param startDate
     * @param endDate
     * @return
     */
    List<IndustryVo> getIndustryData(@Param("industryName") String industryName,
                                     @Param("startDate") String startDate,
                                     @Param("endDate") String endDate);

    /**
     * 统计平均薪资
     * @return
     */
    List<SalaryVo> countSalaryTop();
}
