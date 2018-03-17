package com.example.diskdata.mapper;

import com.example.diskdata.model.DiskFileCheck;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiskFileCheckMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DiskFileCheck record);

    DiskFileCheck selectByPrimaryKey(Long id);

    List<DiskFileCheck> selectAll();

    int updateByPrimaryKey(DiskFileCheck record);
}