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
    void updateNews(String sql);

    //查询
    List<NewsDo> queryNews(String sql);



}
