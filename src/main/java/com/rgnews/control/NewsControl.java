package com.rgnews.control;

import com.rgnews.model.NewsDo;
import com.rgnews.model.Result;
import com.rgnews.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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
    public Result queryNews(NewsDo newsDo) {
        List<NewsDo> newsDoList;
        try{
            StringBuilder sql =new StringBuilder("select * from test_news where 1=1");

            int queryId=newsDo.getNews_id();
            if(queryId>0){ sql.append(" and news_id ="+queryId); }

            int queryState=newsDo.getNews_state();
            if(queryState>0){ sql.append(" and news_state ="+queryState); }

            String queryTitle = newsDo.getNews_title();
            if(queryTitle != null && !queryTitle.trim().isEmpty()){ sql.append(" and cname like"+queryTitle); }

            sql.append(" order by update_time");
            int rank=newsDo.getRank();
            if(rank == 0){
                sql.append(" desc");
            }

            newsDoList = newsService.queryNews(sql.toString());
            if(newsDoList!=null && !newsDoList.isEmpty())
            {
                return Result.success(newsDoList);
            }
            else {
                return Result.success("未查询到任何结果");
            }

        }catch(Exception e){
            e.printStackTrace();
            return Result.failed("查询失败");
        }



    }


}
