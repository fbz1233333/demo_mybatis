package com.example.demo_mybatis.daoTest;

import com.example.demo_mybatis.util.fileUtil;
import org.codehaus.plexus.util.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileTest {

    public static void main(String[] args) throws IOException {
    
        for (String string:fileUtil.readfile("H:\\manga\\9671335\\pagelist")){
            System.out.println(string);
        }
        System.out.println(fileUtil.readfile("H:\\manga\\9671335\\pagelist").size());
    }
}
