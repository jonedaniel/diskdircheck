package com.example.diskdata.service.impl;

import com.example.diskdata.mapper.DiskFileCheckMapper;
import com.example.diskdata.model.DiskFileCheck;
import com.example.diskdata.service.IDiskFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DiskFileServiceImpl implements IDiskFileService {
    @Autowired
    private DiskFileCheckMapper diskFileCheckMapper;

    @Override
    public void save(File file) {
        DiskFileCheck df = new DiskFileCheck();
        df.setName(file.getName());
        Long size = getSize(file);
        if (size < 200) {
            return;
        }
        df.setSize(size.toString()+"MB");
        df.setPath(file.getPath());
        System.out.println(df);
    }

    private Long getSize(File file) {
        Long sum = 0L;
        File[] files = file.listFiles();
        if (files!=null) {
            for (File file1 : files) {
                sum += file1.length();
            }
        }
        return sum/1024/1024;
    }
}
