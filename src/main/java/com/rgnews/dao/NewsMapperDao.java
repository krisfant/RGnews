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
    List<NewsDo> getAllNews();
    //根据条件查询
    List<NewsDo> getNewsById(int news_id);
    List<NewsDo> getNewsByDate(Date news_date);
    List<NewsDo> getNewsByTitle(String news_title);//模糊查询
    List<NewsDo> getNewsByState(int news_state);

    NewsDo test();



}