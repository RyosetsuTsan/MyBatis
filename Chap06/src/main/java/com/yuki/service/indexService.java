package com.yuki.service;

import com.yuki.bean.Course;
import com.yuki.bean.CourseExample;
import com.yuki.mapper.CourseMapper;
import com.yuki.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yuki
 */

public class indexService {
    //加载sqlSession
    private final static SqlSession sqlSession = MyBatisUtils.getSqlSession();
    private final static CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

    //展示所有数据
    public List<Course> findAll(){
        return mapper.selectByExample(null);
    }

    //多行删除
    public boolean delete(List<Integer> ids){
        CourseExample example = new CourseExample();
        example.createCriteria().andIdIn(ids);
        int res = mapper.deleteByExample(example);
        sqlSession.commit();
        return res == ids.size();
    }

    //条件查询
    /**
     * 除了id和数量
     * 课程名称____
     * 开始时间____
     * 结束时间____
     * 教师姓名____
     */
    public List<Course> FindBy(String name,String sd,String ed,String teacher){
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        Date start=null,end=null;
        try {
            if (sd.length()>5)start=simple.parse(sd);
            if (ed.length()>5)end=simple.parse(ed);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CourseExample e = new CourseExample();
        CourseExample.Criteria c = e.createCriteria();
        if (name!=null) {
//            CourseExample.Criteria c1 = example.createCriteria()
            c.andNameLike("%"+name+"%");
            //todo or条件
//            example.or(c1);
        }
        if (teacher!=null)c.andTeacherLike("%"+teacher+"%");
        if (start!=null)c.andStartdateGreaterThanOrEqualTo(start);
        if (end!=null)c.andEnddateLessThanOrEqualTo(end);
        return mapper.selectByExample(e);

    }
}
