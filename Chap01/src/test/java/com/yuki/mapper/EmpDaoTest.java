package com.yuki.mapper;

import com.yuki.pojo.Emp;
import com.yuki.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class EmpDaoTest {
    @Test
    public void select(){
        //第一步：获得sqlSession对象
         SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //第二步：执行SQL getMapper
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        List<Emp> empList = empDao.getEmpList();
        for (Emp emp : empList) {
            System.out.println(emp.toString());
        }
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void selectlike(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        List<Emp> empList = empDao.likeEmplist("%张%");//容易被sql注入（传入张 or 1=1）就会返回所有值
        for (Emp emp : empList) {
            System.out.println(emp.toString());
        }
        sqlSession.close();
    }
    @Test
    public void selectById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = mapper.getEmpById(14);
        System.out.println(emp.toString());
        sqlSession.close();
    }
    //增删改需要提交事务
    @Test
    public void insert(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        Emp emp=new Emp(null,"范一开","男","1999-02-14","13312345678");
        int rows=empDao.insertEmp(emp);
        if (rows>0) System.out.println("添加成功");
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void insert2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("mingzi","名字");
        map.put("shouji","13241234");
        map.put("xingbie","女");
        map.put("shengri","1999-2-21");

        int rows = empDao.insertEmp2(map);

        if (rows>0) System.out.println("添加成功");
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void update(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        Emp emp=new Emp(14,"赵六","女","1999-02-14","12314161278");
        int rows=empDao.updateEmp(emp);
        if (rows>0) System.out.println("修改成功");
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void delete(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        EmpDao empDao = sqlSession.getMapper(EmpDao.class);
        int rows = empDao.deleteEmp(5);
        if (rows>0) System.out.println("删除成功");
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
