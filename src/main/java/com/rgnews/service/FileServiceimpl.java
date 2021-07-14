package com.rgnews.service;

import com.rgnews.dao.FilesMapperDao;
import com.rgnews.model.FileDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FileServiceimpl implements FileService{

    @Autowired
    FilesMapperDao filesMapper;

    @Override
    public void insertFile(FileDo fileDo){
        filesMapper.insertFile(fileDo);
    }

    @Override
    public void deleteFile(int file_id){filesMapper.deleteFile(file_id);}

    @Override
    public List<FileDo> fileList(){ return filesMapper.fileList(); }

    @Override
    public   FileDo getFileById(int file_id){return  filesMapper.getFileById(file_id);}
}
