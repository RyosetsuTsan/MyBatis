import com.yuki.bean.Course;
import com.yuki.mapper.CourseMapper;
import com.yuki.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test {
    @Test
    public void select() throws Exception{
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        List<Course> courses = mapper.selectByExample(null);
        for (Course cours : courses) {
            System.out.println(cours);
        }
    }

}
