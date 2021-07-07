package com.rgnews.control;

import com.rgnews.model.NewsDo;
import com.rgnews.model.Result;
import com.rgnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class NewsControl {


    @Autowired
    private NewsService newsService;


    @PostMapping(value = "insertNews")
    @ResponseBody
    public Result insertNews(NewsDo newsDo){
        Result result =new Result() ;
        try{
            newsService.insertNews(newsDo);
            return result.success();
        }
        catch (Exception e){
            e.printStackTrace();
            return result.failed();
        }
    }

    @DeleteMapping(value = "deleteNews")
    @ResponseBody
    public Result deleteNews(int news_id){
        Result result =new Result() ;
        try{
            newsService.deleteNews(news_id);
            return result.success();
        }
        catch (Exception e){
            e.printStackTrace();
            return result.failed();
        }

    }

    @PostMapping(value = "updateNews")
    @ResponseBody
    public Result updateNews(NewsDo newsDo){
        Result result =new Result() ;
        try{
            newsService.updateNews(newsDo);
            return result.success();
        }
        catch (Exception e){
            e.printStackTrace();
            return result.failed();
        }

    }

    @PostMapping(value = "getAllNews")
    @ResponseBody
    public Result getAllNews(){
        List<NewsDo> newsDoList;
        Result result =new Result() ;
        try{
            newsDoList = newsService.getAllNews();
            if(newsDoList!=null && !newsDoList.isEmpty())
               {
                   return result.success(newsDoList);
               }else
               {
                   return result.failed("没有符合条件的新闻");
               }

        }
        catch (Exception e){
            e.printStackTrace();
            return result.failed();
        }

    }


    @PostMapping(value = "getNewsById")
    @ResponseBody
    public Result getNewsById( @RequestParam int news_id){

        List<NewsDo> newsDoList;
        Result result =new Result() ;
        try{
            newsDoList = newsService.getNewsById(news_id);
            if(newsDoList!=null && !newsDoList.isEmpty())
            {
                return result.success(newsDoList);
            }else
            {
                return result.failed("没有符合条件的新闻");
            }

        }
        catch (Exception e){
            e.printStackTrace();
            return result.failed();
        }
    }

    @PostMapping(value = "getNewsByDate")
    @ResponseBody
    public Result getNewsByDate(@RequestParam Date news_date){
        List<NewsDo> newsDoList;
        Result result =new Result() ;
        try{
            newsDoList = newsService.getNewsByDate(news_date);
            if(newsDoList!=null && !newsDoList.isEmpty())
            {
                return result.success(newsDoList);
            }else
            {
                return result.failed("没有符合条件的新闻");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return result.failed();
        }
    }

    @PostMapping(value = "getNewsByTitle")
    @ResponseBody
    public Result getNewsByTitle(String news_title){
        List<NewsDo> newsDoList ;
        Result result =new Result() ;
        try{
            newsDoList = newsService.getNewsByTitle(news_title);
            if(newsDoList!=null && !newsDoList.isEmpty())
            {
                return result.success(newsDoList);
            }else
            {
                return result.failed("没有符合条件的新闻");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return result.failed();
        }
    }

    @PostMapping(value = "getNewsByState")
    @ResponseBody
    public Result getNewsByState(int news_state){
        List<NewsDo> newsDoList;
        Result result =new Result() ;
        try{
            newsDoList = newsService.getNewsByState(news_state);
            if(newsDoList!=null && !newsDoList.isEmpty())
            {
                return result.success(newsDoList);
            }else
            {
                return result.failed("没有符合条件的新闻");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return result.failed();
        }
    }



}
