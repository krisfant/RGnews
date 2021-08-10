package com.rgnews.control;

import com.rgnews.model.NewsDo;
import com.rgnews.model.Result;
import com.rgnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        try{
            newsService.insertNews(newsDo);
            return Result.success();
        }
        catch (Exception e){
            e.printStackTrace();
            return Result.failed();
        }
    }

    @DeleteMapping(value = "deleteNews")
    @ResponseBody
    public Result deleteNews(int news_id){
        try{
            newsService.deleteNews(news_id);
            return Result.success();
        }
        catch (Exception e){
            e.printStackTrace();
            return Result.failed();
        }

    }

    @PostMapping(value = "updateNews")
    @ResponseBody
    public Result updateNews(NewsDo newsDo){
        try{
            newsService.updateNews(newsDo);
            return Result.success();
        }
        catch (Exception e){
            e.printStackTrace();
            return Result.failed();
        }

    }


    @PostMapping(value = "queryNews")
    @ResponseBody
    public Result queryNews(NewsDo newsDo){
        List<NewsDo> newsDoList;
        int queryType = newsDo.getQueryType();
        switch (queryType){
            case 1:
                try{
                    newsDoList = newsService.getNewsById(newsDo.getNews_id());
                    if(newsDoList!=null && !newsDoList.isEmpty())
                    { return Result.success(newsDoList);}
                    else
                    { return Result.failed("没有符合条件的新闻"); }
                }
                catch (Exception e){
                    e.printStackTrace();
                    return Result.failed();
                }

            case 2:
                try{
                    newsDoList = newsService.getNewsByState(newsDo.getNews_state());
                    if(newsDoList!=null && !newsDoList.isEmpty())
                    { return Result.success(newsDoList);}
                    else
                    { return Result.failed("没有符合条件的新闻"); }
                }
                catch (Exception e){
                    e.printStackTrace();
                    return Result.failed();
                }
            case 3:
                try{
                    newsDoList = newsService.getNewsByTitle(newsDo.getNews_title());
                    if(newsDoList!=null && !newsDoList.isEmpty())
                    { return Result.success(newsDoList);}
                    else
                    { return Result.failed("没有符合条件的新闻"); }
                }
                catch (Exception e){
                    e.printStackTrace();
                    return Result.failed();
                }
            case 4:
                try{
                    newsDoList = newsService.getNewsByTime(newsDo.getStart_time(),newsDo.getEnd_time());
                    if(newsDoList!=null && !newsDoList.isEmpty())
                    { return Result.success(newsDoList);}
                    else
                    { return Result.failed("没有符合条件的新闻"); }
                }
                catch (Exception e){
                    e.printStackTrace();
                    return Result.failed();
                }
            default:
                try{
                    newsDoList = newsService.getAllNews();
                    if(newsDoList!=null && !newsDoList.isEmpty())
                    { return Result.success(newsDoList); }
                    else
                    { return Result.failed("没有符合条件的新闻"); }
                }
                catch (Exception e){
                    e.printStackTrace();
                    return Result.failed();
                }
        }
    }



//    @PostMapping(value = "getAllNews")
//    @ResponseBody
//    public Result getAllNews(){
//        List<NewsDo> newsDoList;
//        try{
//            newsDoList = newsService.getAllNews();
//            if(newsDoList!=null && !newsDoList.isEmpty())
//               {
//                   return Result.success(newsDoList);
//               }else
//               {
//                   return Result.failed("没有符合条件的新闻");
//               }
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return Result.failed();
//        }
//
//    }
//
//
//    @PostMapping(value = "getNewsById")
//    @ResponseBody
//    public Result getNewsById( @RequestParam int news_id){
//
//        List<NewsDo> newsDoList;
//        try{
//            newsDoList = newsService.getNewsById(news_id);
//            if(newsDoList!=null && !newsDoList.isEmpty())
//            {
//                return Result.success(newsDoList);
//            }else
//            {
//                return Result.failed("没有符合条件的新闻");
//            }
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return Result.failed();
//        }
//    }
//
//    @PostMapping(value = "getNewsByDate")
//    @ResponseBody
//    public Result getNewsByDate(@RequestParam Date news_date){
//        List<NewsDo> newsDoList;
//        try{
//            newsDoList = newsService.getNewsByDate(news_date);
//            if(newsDoList!=null && !newsDoList.isEmpty())
//            {
//                return Result.success(newsDoList);
//            }else
//            {
//                return Result.failed("没有符合条件的新闻");
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return Result.failed();
//        }
//    }
//
//    @PostMapping(value = "getNewsByTitle")
//    @ResponseBody
//    public Result getNewsByTitle(String news_title){
//        List<NewsDo> newsDoList ;
//        try{
//            newsDoList = newsService.getNewsByTitle(news_title);
//            if(newsDoList!=null && !newsDoList.isEmpty())
//            {
//                return Result.success(newsDoList);
//            }else
//            {
//                return Result.failed("没有符合条件的新闻");
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return Result.failed();
//        }
//    }
//
//    @PostMapping(value = "getNewsByState")
//    @ResponseBody
//    public Result getNewsByState(int news_state){
//        List<NewsDo> newsDoList;
//        try{
//            newsDoList = newsService.getNewsByState(news_state);
//            if(newsDoList!=null && !newsDoList.isEmpty())
//            {
//                return Result.success(newsDoList);
//            }else
//            {
//                return Result.failed("没有符合条件的新闻");
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return Result.failed();
//        }
//    }




}
