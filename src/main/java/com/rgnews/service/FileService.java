package com.rgnews.service;

import com.rgnews.model.FileDo;
import java.util.List;


public interface FileService {
    void insertFile(FileDo fileDo);
    void deleteFile(int file_id);
    List<FileDo> fileList();
    FileDo getFileById(int file_id);


}

