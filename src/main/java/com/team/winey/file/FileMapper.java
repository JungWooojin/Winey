package com.team.winey.file;

import com.team.winey.file.model.FileEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    FileEntity getFileEntityById(int id);
    void updPic(FileEntity entity);
    int count();
}
