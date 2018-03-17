package com.example.diskdata;

import com.example.diskdata.mapper.DiskFileCheckMapper;
import com.example.diskdata.service.IDiskFileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiskdataApplicationTests {

    @Autowired
    private DiskFileCheckMapper fileCheckMapper;
    @Autowired
    private IDiskFileService    diskFileService;

    @Test
    public void contextLoads() {
        System.out.println(fileCheckMapper.selectAll());
    }

    @Test
    public void getAllDir() {
        File file = new File("C:/Windows");
        fileLoop(file);
    }

    private void fileLoop(File file) {
        if (file.isDirectory()) {
            if (file.length() == 0) {
                return;
            }
            diskFileService.save(file);
            File[] files = file.listFiles();
            if (files == null) {
                return;
            }
            for (File file1 : files) {
                fileLoop(file1);
            }
        }
    }


    @Test
    public void fileSizeTest() {
        File file = new File("C:/Windows");
        System.out.println(file.getName());
        System.out.println(file.length());

        String name = "123.45.6";
        System.out.println(name.substring(name.lastIndexOf(".")));
    }
}
