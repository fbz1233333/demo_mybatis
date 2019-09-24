package com.example.demo_mybatis.test;

import com.example.demo_mybatis.exception.NativeException;
import com.example.demo_mybatis.exception.ZeroException;
import org.junit.jupiter.api.Test;

public class test1 {
  
    public int shang(int x,int y) throws ZeroException, NativeException {
        if(y<0){
            throw new NativeException("您输入的是"+y+",规定除数不能为附属");
        }
        if(y==0){
            throw new ZeroException("除数不能为0");
        }
        int m=x/y;
        return  m;
    }
}
