package com.rgnews.service;

import java.util.Date;
import java.util.List;
import com.rgnews.model.NewsDo;


public interface NewsService {



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
    List<NewsDo> getNewsByTime(String start_time,String end_time);
    List<NewsDo> getNewsByTitle(String news_title);//模糊查询
    List<NewsDo> getNewsByState(int news_state);


}
