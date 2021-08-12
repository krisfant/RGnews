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
    private String news_title;
    private String news_content;
    private String news_photo;
    private int rank;
}