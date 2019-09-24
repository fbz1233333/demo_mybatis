package com.example.demo_mybatis.controller;

import com.example.demo_mybatis.dao.MangaDao;
import com.example.demo_mybatis.entity.Manga;
import com.example.demo_mybatis.entity.User;
import com.example.demo_mybatis.util.fileUtil;
import com.example.demo_mybatis.util.zipUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/manga")
public class MangaController {
    @Resource
    MangaDao mangaDao;


    @RequestMapping("/recordInfo")
    public String recordInfo(HttpSession session, Manga manga){
        session.setAttribute("manga",manga);
        return "upload";
    }

    @RequestMapping("/getFile1")

    public String get1(@RequestParam("file1") MultipartFile file1, HttpSession session) throws Exception {
        User user=(User) session.getAttribute("loginUser");
        Manga manga= (Manga) session.getAttribute("manga");
        Date date=new Date();

        String mangaDir=String.valueOf((int)((Math.random())*10000000));
        manga.setmDir(mangaDir);
        manga.setmTime(date);
        manga.setUploader(user);
        
        String path1 = "H:/manga/";
        File dir=new File(path1+mangaDir);
        if(!dir.exists()) dir.mkdirs();

        String path=dir.getAbsolutePath();
        System.out.println("绝对路径"+path);
   


        //所需要的目录
        String rarPath=path+"/zip/";
        String pageList=path+"/pagelist/";

         //上传zip
        String fileName=fileUtil.filetopath(file1,rarPath);

        //上传分页,先获取文件位置，在解到预定文件夹
        File file=new File(fileName);
        System.out.println(file.getPath());
        zipUtil.unZip(file,pageList);
        
        mangaDao.addManga(manga);
        return "redirect:/user/myInfo/"+user.getuId();
    }


    @RequestMapping("/mangalist")
    public String mangalist(Model model){
        List<Manga> mangaList=mangaDao.getMangas();
        model.addAttribute("mangalist",mangaList);
        return "mangalist";
    }

    @RequestMapping("/getMangas")
    @ResponseBody
    public List<Manga> getMangas(){
        return mangaDao.getMangas();
    }

    @RequestMapping("/getOne/{id}")
    public String getOne(Model model,@PathVariable("id") int id,HttpSession session) {
        Manga manga=mangaDao.getMangaById(id);
        session.setAttribute("manga",manga);
        
        return "redirect:/manga/getPage/1";
    }

    @RequestMapping("/getPage/{id}")
    public String getOn2e(Model model,@PathVariable("id") int id,HttpSession session) throws IOException {
        Manga manga= (Manga) session.getAttribute("manga");
        model.addAttribute("nowPage",id);
        List<String> pl=fileUtil.readfile("H:\\manga\\"+manga.getmDir()+"\\pagelist");
        session.setAttribute("pagelist",pl);
        String src=pl.get(id);
        model.addAttribute("src",src);
        return "PageOne";
    }

    @RequestMapping("/getPage2/{id}")
    @ResponseBody
    public String getOn22e(Model model,@PathVariable("id") int id,HttpSession session) throws IOException {
        Manga manga= (Manga) session.getAttribute("manga");
        List<String> pl=fileUtil.readfile("H:\\manga\\"+manga.getmDir()+"\\pagelist");
        String src=pl.get(id);
        return  src;

    }

   //下载功能先搁置
    @RequestMapping("/download")
    @ResponseBody
    public String download(HttpSession session){
        Manga manga= (Manga) session.getAttribute("manga");
        return "success";
    }

    @RequestMapping("/getMine")
    public String getMine(Model model,HttpSession session){

        User me=(User)session.getAttribute("loginUser");
        model.addAttribute("mangalist",mangaDao.getMine(me));
        return "mangalist";
    }

    @RequestMapping("/split/{id}")
    public String split(Model model,@PathVariable("id") int id, HttpSession session) throws IOException {
        Manga manga=mangaDao.getMangaById(id);
        List<String> pl=fileUtil.readfile("H:\\manga\\"+manga.getmDir()+"\\pagelist");
        model.addAttribute("pagelist",pl);
        session.setAttribute("manga",manga);

        model.addAttribute("manga",manga);
        return "pageSplit";
    }


}
