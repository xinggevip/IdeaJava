package com.gaoxing.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
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
}
