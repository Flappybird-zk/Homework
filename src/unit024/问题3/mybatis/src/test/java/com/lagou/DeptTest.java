package com.lagou;

import com.lagou.entity.TbDept;
import com.lagou.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class DeptTest {
    @Test
    public void testSelectAll() throws Exception {
        SqlSession sess = null;
        try{
            sess = DbUtils.openSession();
            List<TbDept> list = sess.selectList("tb_dept.selectAll");
            for(TbDept dept: list){
                System.out.println("部门号：" + dept.getDeptId() + "，部门名称：" + dept.getDeptName() + ", 部门主管：" + dept.getMajorName() + ", 电话：" + dept.getTelephone() + "，邮箱：" + dept.getEmail());
            }
        }catch (Exception e){
            throw e;
        }finally{
            DbUtils.closeSession(sess);
        }
    }
}
