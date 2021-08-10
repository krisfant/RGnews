package com.rgnews.util;


public class NameUtil {
    public String getFileNameNoEx(String fileName){
        if ((fileName != null) && (fileName.length() > 0)) {
            int dot = fileName.lastIndexOf('.');
            if ((dot >-1) && (dot < (fileName.length()))) {
                return  fileName.substring(0, dot);
            }
        }
        return fileName;
    }
}