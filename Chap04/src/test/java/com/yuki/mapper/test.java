package com.yuki.mapper;

import com.yuki.bean.Starinfo;
import com.yuki.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    @Test
    public void selectLastNameEqualsZhang(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StarinfoMapper mapper = sqlSession.getMapper(StarinfoMapper.class);

        List<Starinfo> starinfos = mapper.selectLastNameEqualsZhang();
        sqlSession.close();
        for (Starinfo starinfo : starinfos) {
            System.out.println(starinfo);
        }
    }
    @Test
    public void selectStarsByNameOrArea(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StarinfoMapper mapper = sqlSession.getMapper(StarinfoMapper.class);
        Starinfo starinfo = new Starinfo();
        starinfo.setUsername("张");
        starinfo.setAreaname("中国");
        List<Starinfo> starinfos = mapper.selectStarsByNameOrArea(starinfo);
        sqlSession.close();
        //iter
        for (Starinfo starinfo1 : starinfos) {
            System.out.println(starinfo1);
        }
    }

    @Test
    public void selectStarinfoByUserid(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StarinfoMapper mapper = sqlSession.getMapper(StarinfoMapper.class);
        List<String> ids=new ArrayList<>();
        ids.add("s1");
        ids.add("s3");
        ids.add("s2");
        List<Starinfo> starinfos = mapper.selectStarinfoByUserid(ids);
        sqlSession.close();
        for (Starinfo starinfo : starinfos) {
            System.out.println(starinfo);
        }
    }

    @Test
    public void delete(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StarinfoMapper mapper = sqlSession.getMapper(StarinfoMapper.class);
        List<String> ids=new ArrayList<>();
        Boolean delete = false;
        ids.add("s1");
        ids.add("s3");
        ids.add("s2");
        delete = mapper.delete(ids);
        //提交事务
        sqlSession.commit(ids.size()>0);
        sqlSession.close();
        System.out.println(delete);

    }

    @Test
    public void insert(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StarinfoMapper mapper = sqlSession.getMapper(StarinfoMapper.class);
        List<Starinfo> starinfos = Arrays.asList(
                new Starinfo("s1", "张1", "女", "中国1区", 1),
                new Starinfo("s2", "张2", "男", "美国2区", 2),
                new Starinfo("s3", "李3", "女", "加拿大3区", 3)
                );
        Boolean insert = mapper.insert(starinfos);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(insert);

    }

    //安卓->鸿蒙
    @Test
    public void HarmonyOS(){
        String android="android";
        String HarmonyOS=android.replaceAll("android","HarmonyOS");
        System.out.println(HarmonyOS);
    }

    @Test
    public void sd(){
        String a="1,";
        String[] split = a.split(",");
        System.out.println(split[0]);
    }

}
