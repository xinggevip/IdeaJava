package com.juzimi.web;

import com.juzimi.domain.Album;
import com.juzimi.domain.Result;
import com.juzimi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class UploadDownController {

    @Autowired
    private AlbumService albumService;

    /**
     * 文件上传
     * @param albumPicture
     * @param request
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public Result upload(@RequestParam("albumPicture") MultipartFile albumPicture, HttpServletRequest request) {

        //获取文件在服务器的储存位置
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = albumPicture.getOriginalFilename();
        System.out.println("原始文件名称：" + originalFileName);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        //设置文件新名称: 当前时间+文件名称（不包含格式）
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(d);
        String fileName = date + name + "." + type;
        System.out.println("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);

        //将文件保存到服务器指定位置
        try {
            albumPicture.transferTo(targetFile);
            System.out.println("上传成功");
            //将文件在服务器的存储路径返回
            return new Result(true,"/upload/" + fileName,100);
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            return new Result(false, "上传失败",-100);
        }
    }



    @RequestMapping("/savealbum")
    @ResponseBody
    public Result save(@RequestBody Album album) {
        System.out.println("来到了web层");
        if(album != null){
            Integer save = albumService.save(album);
            if (save != -1){
                return new Result(true,"创建成功",save);
            }
        }
        return new Result(false, "创建失败",-1);
    }


    @RequestMapping("/delpicture")
    @ResponseBody
    public Result deletepicture(@RequestBody Album album, HttpServletRequest request){
        System.out.println("来到了delpicture");
        System.out.println(album.getAlbumPicture());
        //获取文件在服务器的储存位置
//        String path = request.getSession().getServletContext().getRealPath("/");
//        File filePath = new File(path);
//        System.out.println("服务器文件路径：" + path);

        /**
         * 1.判断是否存在此文件
         * 2.存在则删除
         * 3.不存在则return信息文件不存在
         */

        //获取文件在服务器的储存位置
        String path = request.getSession().getServletContext().getRealPath(album.getAlbumPicture());
        System.out.println("文件在服务器的储存位置:=====" + path);

        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        // 判断文件是否存在
        if (!filePath.exists() && !filePath.isDirectory()) {
            // 不存在则返回信息
            System.out.println("文件不存在");
            return new Result(false,"文件不存在，删除失败");
        }else{
            // 存在则删除并返回信息
            System.out.println("存在文件，开始删吧");
            boolean delete = filePath.delete();
            if (delete == true){
                return new Result(true,"删除成功");
            }else{
                return new Result(false,"删除失败");
            }
        }

    }

}