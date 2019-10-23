package com.gaoxing.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

@Controller
public class MyController {
    @RequestMapping("test1")
    public String test1(){
        return "result.jsp";
    }

    @RequestMapping("/download/{filename:.+}")
    public ResponseEntity download(@PathVariable String filename, HttpSession session) throws Exception {
        System.out.println(filename);

        // 1.获取文件路径
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/download/" + filename);

        // 2.把文件读取到程序中
        FileInputStream io = new FileInputStream(realPath);
        byte[] body = new byte[io.available()];
        io.read(body);

        // 3.创建响应头
        HttpHeaders httpHeaders = new HttpHeaders();
        filename = URLEncoder.encode(filename, "UTF-8"); // 解决下载文件名中文乱码问题
        httpHeaders.add("Content-Disposition","attachment;filename" + filename);

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(body, httpHeaders, HttpStatus.OK);

        return responseEntity;
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam("file")CommonsMultipartFile file,HttpSession session) throws Exception {
        System.out.println("文件类型：" + file.getContentType());
        System.out.println("文件名称：" + file.getOriginalFilename());
        System.out.println("文件大小：" + file.getSize() + "字节");
        System.out.println("文件属性名称：" + file.getName());

        //确定上传的路径
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/upload");
        //变成程序当中的路径
        File uploadPath = new File(realPath);
        if(!uploadPath.exists()){//如果路径不存在 ,创建一个新的
            uploadPath.mkdirs();
        }
        //确认最终的路径  /文件夹/文件名    工程的名称/upload/java.png
        String fileName = file.getOriginalFilename();
        uploadPath = new File(uploadPath+"/"+fileName);

        //开始上传
        file.transferTo(uploadPath);


        return "success";
    }

    @RequestMapping("/exception")
    public String exception(){
        int i = 1 / 0;
        return "success";
    }

    @RequestMapping("/local")
    public String local(){

        return "local";
    }



    /**
     * 专门处理异常
     * @param ex  异常信息
     */
    /*@ExceptionHandler(value = ArithmeticException.class) // 算术异常处理
    public String doexception(Exception ex){
        System.out.println(ex.getMessage());
        return "error";
    }

    @ExceptionHandler(value = RuntimeException.class) // 运行时异常处理
    public String doexception2(Exception ex){
        System.out.println(ex.getMessage());
        return "error";
    }

    @ExceptionHandler(value = Exception.class) // 所有异常处理
    public String doexception3(Exception ex){
        System.out.println(ex.getMessage());
        return "error";
    }*/
}
