package com.lagou.dao;

import com.lagou.entity.TbDept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbDeptDAO {
    @Select("SELECT * FROM `tb_dept`;")
    public List<TbDept> selectAll();
}
