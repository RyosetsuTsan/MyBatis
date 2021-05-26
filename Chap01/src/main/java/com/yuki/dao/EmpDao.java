package com.yuki.dao;

import com.yuki.pojo.Emp;
import java.util.List;
import java.util.Map;

public interface EmpDao {
    //查询全部员工
    List<Emp> getEmpList();
    //模糊查询
    List<Emp> likeEmplist(String name);

    //根据id查员工
    Emp getEmpById(Integer id);
    //添加员工
    int insertEmp(Emp emp);
    int insertEmp2(Map<String,Object> map);//万能的Map
    //修改员工
    int updateEmp(Emp emp);
    //删除员工
    int deleteEmp(Integer id);

}
