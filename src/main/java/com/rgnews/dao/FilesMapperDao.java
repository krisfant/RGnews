package com.rgnews.dao;
import com.rgnews.model.FileDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FilesMapperDao {
    //增
    void insertFile(FileDo fileDo);
    void deleteFile(int file_id);
    List<FileDo> fileList();
    FileDo getFileById(int file_id);
}
