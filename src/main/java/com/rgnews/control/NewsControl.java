package com.rgnews.control;

import com.rgnews.model.NewsDo;
import com.rgnews.model.Result;
import com.rgnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class NewsControl {


    @Autowired
    private NewsService newsService;


    @PostMapping(value = "test")
    @ResponseBody
    public Result test(){
        Result result =new Result() ;
        NewsDo newsDo = new NewsDo();
        try{
        newsDo = newsService.test();
        return result.success(newsDo);
        }
        catch (Exception e){
            e.printStackTrace();
            return result.failed();
        }

    }


    @PostMapping(value = "insertNews")
    @ResponseBody
    public void insertNews(NewsDo newsDo){
        try{
            newsService.insertNews(newsDo);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @DeleteMapping(value = "deleteNews")
    @ResponseBody
    public void deleteNews(int news_id){
        try{
            newsService.deleteNews(news_id);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @PostMapping(value = "updateNews")
    @ResponseBody
    public void updateNews(NewsDo newsDo){
        try{
            newsService.updateNews(newsDo);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @PostMapping(value = "getAllNews")
    @ResponseBody
    public List getAllNews(){
        List<NewsDo> newsDoList = new ArrayList();
        try{
            newsDoList = newsService.getAllNews();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  newsDoList;

    }


    @PostMapping(value = "getNewsById")
    @ResponseBody
    public List<NewsDo> getNewsById(@RequestParam int news_id){

        List<NewsDo> newsDoList = new ArrayList();
        try{
            newsDoList = newsService.getNewsById(news_id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  newsDoList;
    }

    @PostMapping(value = "getNewsByDate")
    @ResponseBody
    public List<NewsDo> getNewsByDate(@RequestParam Date news_date){
        List<NewsDo> newsDoList = new ArrayList();
        try{
            newsDoList = newsService.getNewsByDate(news_date);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  newsDoList;
    }

    @PostMapping(value = "getNewsByTitle")
    @ResponseBody
    public List<NewsDo> getNewsByTitle(String news_title){
        List<NewsDo> newsDoList = new ArrayList();
        try{
            newsDoList = newsService.getNewsByTitle(news_title);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  newsDoList;
    }

    @PostMapping(value = "getNewsByState")
    @ResponseBody
    public List<NewsDo> getNewsByState(int news_state){
        List<NewsDo> newsDoList = new ArrayList();
        try{
            newsDoList = newsService.getNewsByState(news_state);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  newsDoList;
    }



}
