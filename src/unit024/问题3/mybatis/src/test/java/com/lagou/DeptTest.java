package com.lagou;

import com.lagou.dao.TbDeptDAO;
import com.lagou.entity.TbDept;
import com.lagou.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DeptTest {
    @Test
    public void testSelectAll() throws Exception {
        SqlSession sess = null;
        try{
            sess = DbUtils.openSession();
            TbDeptDAO dao = sess.getMapper(TbDeptDAO.class);
            List<TbDept> list = dao.selectAll();
            for(TbDept dept: list){
                System.out.println(dept.getDeptId() + "|" + dept.getDeptName() + "|" + dept.getMajorName() + "|" + dept.getTelephone() + "|" + dept.getEmail());
            }
        }catch (Exception e){
            throw e;
        }finally{
            DbUtils.closeSession(sess);
        }



    }
}
