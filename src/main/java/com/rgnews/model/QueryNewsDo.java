package com.rgnews.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
public class QueryNewsDo {
    private int news_id;
    private int news_state;
    private Date start_time;
    private Date edd_time;
    private String news_title;

    private int queryMode;
}