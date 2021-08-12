package com.rgnews.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
public class NewsDo {

    private int news_id;
    private int news_state;
    private String update_time;
    private String start_time;
    private String end_time;
    private String news_title;
    private String news_content;
    private String news_photo;
    private int rank;
    //queryType默认为查询所有
//    1:int news_id
//    2:int news_state
//    3:String news_title
//    4:String start_time end_time
//    其他和为空都是查所有
}