package com.rgnews.service;


import com.rgnews.dao.NewsMapperDao;
import com.rgnews.model.NewsDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class NewsServiceimpl implements NewsService{
    @Autowired
    NewsMapperDao newsMapper;

    @Override
    public void insertNews(NewsDo newsDo){
        newsDo.setNews_state(1);
        String nowtime = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
        newsDo.setUpdate_time(nowtime);

        newsMapper.insertNews(newsDo);
    }

    @Override
    public void deleteNews(int news_id){

        newsMapper.deleteNews(news_id);
    }

    @Override
    public void updateNews(String sql) {
        newsMapper.updateNews(sql);
    }


    @Override
    public List<NewsDo> queryNews(String sql){
        List newsList = newsMapper.queryNews(sql);
        return  newsList;
    }


}
