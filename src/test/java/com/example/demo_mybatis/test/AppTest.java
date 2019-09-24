package com.example.demo_mybatis.test;

import com.example.demo_mybatis.exception.NativeException;
import com.example.demo_mybatis.exception.ZeroException;

public class AppTest {
    public static  void main(String[] args){
        test1 test=new test1();
        try {
            System.out.println("商"+test.shang(1,0));
        }catch (ZeroException e){
            System.out.println(e.getMessage());
        } catch (NativeException e){
            System.out.println(e.getMessage());
        }
    }
}
