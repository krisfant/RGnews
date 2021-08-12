package com.rgnews.dao;

import com.rgnews.model.NewsDo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//@Repository
@Mapper
public interface NewsMapperDao {


    //增
    void insertNews(NewsDo newsDo);

    //删
    void deleteNews(int news_id);

    //改
    void updateNews(NewsDo newsDo);

    //查询所有
    List<NewsDo> queryNews(String sql);




}