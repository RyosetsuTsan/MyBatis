package com.yuki.mapper;

import com.yuki.bean.Starinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StarinfoMapper {
    /**
     * 条件查询：查询出所有姓“张”的中国明星信息
     * 固定写法，只能查姓张的中国明星
     */
    List<Starinfo> selectLastNameEqualsZhang();

    //条件查询 查询出所有姓“某”的 "某"国明星信息
    List<Starinfo> selectStarsByNameOrArea(Starinfo s);

    //条件查询 ：查询出 userid 为 s 1 、 s2 、 s3 、 s4 的明星信息
    List<Starinfo> selectStarinfoByUserid(@Param("ids") List<String> ids);

    //批量删除
    Boolean delete(List<String> ids);
    //批量添加
    Boolean insert(@Param("stars") List<Starinfo> s);
}
