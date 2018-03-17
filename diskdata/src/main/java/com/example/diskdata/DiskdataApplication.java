package com.example.diskdata;

import com.example.diskdata.service.IDiskFileService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
@MapperScan("com.example.diskdata.mapper")
public class DiskdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiskdataApplication.class, args);
	}
}
