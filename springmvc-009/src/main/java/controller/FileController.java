package controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * 文件上传：浏览器端向服务器端发送文件，最终服务器将文件保存到服务器上（本质上还是IO流，读文件和写文件）
 */
@Controller
public class FileController {

    @RequestMapping(value = "/fileup", method = RequestMethod.POST)
    /*
    SpringMVC专门为文件上传准备了一个类：MultipartFile multipartFile
    这个类怎么理解呢？这个类代表你从客户端传过来的那个文件
     */
    public String fileup(@RequestParam("filename") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        // 获取请求参数的名字
        String name = multipartFile.getName();
        System.out.println(name);

        // 获取的是文件真实的名字
        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println(originalFilename);

        // 接下来就是读客户端传过来的文件，写到服务器上
        // 输入流,负责读客户端的文件
        InputStream in = multipartFile.getInputStream();
        // 封装带有缓冲区的输入流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);

        ServletContext application = request.getServletContext();   // 应用域对象
        // 获取上传之后的存放目录file
        String realPath = application.getRealPath("/upload");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();
        }
        // 输出流
        OutputStream out = new FileOutputStream(file.getAbsolutePath() + "/" + UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf(".")));
        // 封装带有缓冲区的输出流
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);

        // 读写数据
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer, 0, len);
        }

        // 刷新缓冲区
        bufferedOutputStream.flush();

        // 关闭流
        bufferedInputStream.close();
        bufferedOutputStream.close();

        return "ok";
    }

    /*
    文件下载
     */
    @GetMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        // 获取文件路径
        ServletContext application = request.getServletContext();   // 应用域对象
        String realPath = application.getRealPath("/upload");
        File file = new File(realPath + "/" + "filename");
        // 读取文件内容
        byte[] bytes = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        // 设置响应头
        ResponseEntity<byte[]> responseEntity = ResponseEntity.ok()
               .contentType(MediaType.APPLICATION_OCTET_STREAM)
               .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + "filename")
               .body(bytes);
        return responseEntity;
    }

}
