package com.example.diskdata.service;

import com.example.diskdata.model.DiskFileCheck;

import java.io.File;

public class DiskCheckUtil {
    public static void main(String[] args) {
        new DiskCheckUtil().getAllDir();
    }

    public void getAllDir() {
        File file = new File("C:/Windows");
        fileLoop(file);
    }

    private void fileLoop(File file) {
        if (file.isDirectory()) {
            if (file.length() == 0) {
                return;
            }
            save(file);
            File[] files = file.listFiles();
            if (files == null) {
                return;
            }
            for (File file1 : files) {
                fileLoop(file1);
            }
        }
    }

    private void save(File file) {
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
