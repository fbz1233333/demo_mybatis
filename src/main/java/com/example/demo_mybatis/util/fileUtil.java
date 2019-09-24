package com.example.demo_mybatis.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fileUtil {

    public static String filetopath(MultipartFile file, String path) throws IOException {
        String value=file.getOriginalFilename();
        String suffix = value.substring(value.lastIndexOf("."));
        String fileName =String.valueOf((int)((Math.random())*10000000))+suffix;

        System.out.println(path);
        File dir=new File(path);
        if(!dir.exists()) dir.mkdirs();
        file.transferTo(new File(path+fileName));

        return path+fileName;
    }

    public static List<String> readfile(String filepath) throws FileNotFoundException, IOException {
        List<String> stringList=new ArrayList<>();
        try {
            File file = new File(filepath);
            if (!file.isDirectory()) {

                System.out.println("path=" + file.getPath());
                System.out.println("absolutepath=" + file.getAbsolutePath());
                System.out.println("name=" + file.getName());

            } else if (file.isDirectory()) {
           
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
//                        System.out.println("path=" + readfile.getPath());
//                        System.out.println("absolutepath="
//                                + readfile.getAbsolutePath());
//                        System.out.println("name=" + readfile.getName());
                        stringList.add(readfile.getName());

                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return stringList;
    }

    
}
