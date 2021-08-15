package com.rgnews.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class FileDo {
    private String file_name;
    private String update_time;
    private int file_id;
    private int file_type;
    private String file_url;
}
