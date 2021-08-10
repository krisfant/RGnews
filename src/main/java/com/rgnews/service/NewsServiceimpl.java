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


    List newsList = new ArrayList();

    @Override
    public void insertNews(NewsDo newsDo){
        newsDo.setNews_state(1);
        String nowtime = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
        newsDo.setUpdate_time(nowtime);

        newsMapper.insertNews(newsDo);
    }

    @Override
    public void deleteNews(int news_id){

        newsMapper.deleteNews(news_id);
    }

    @Override
    public void updateNews(NewsDo newsDo) {
        String nowtime = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss").format(new Date());
        newsDo.setUpdate_time(nowtime);
        newsMapper.updateNews(newsDo);
    }


    @Override
    public List<NewsDo> getAllNews(){
        newsList = newsMapper.getAllNews();
        return  newsList;
    }

    @Override
    public List<NewsDo> getNewsById(int news_id){
        newsList = newsMapper.getNewsById(news_id);
        return  newsList;
    }

    @Override
    public List<NewsDo> getNewsByTime(String start_time,String end_time){
        newsList = newsMapper.getNewsByTime(start_time,end_time);
        return  newsList;
    }

    @Override
    public List<NewsDo> getNewsByTitle(String news_title){
        newsList = newsMapper.getNewsByTitle(news_title);
        return  newsList;
    }

    @Override
    public List<NewsDo> getNewsByState(int news_state){
        newsList = newsMapper.getNewsByState(news_state);
        return  newsList;
    }

}
