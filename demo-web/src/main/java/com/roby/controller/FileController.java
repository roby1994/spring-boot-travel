package com.roby.controller;

import com.roby.vo.FileInfo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by Tao Pingping on 2018/3/23.
 */

@RestController
@RequestMapping(value = "/file",produces = "application/json;charset=utf-8")
public class FileController {

    private String path = "C:\\opt";

    @PostMapping
    public FileInfo upload(@RequestParam("file") MultipartFile file) throws Exception {

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        File localFile = new File(path, file.getOriginalFilename());
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    /**
     * 多文件上传
     *
     * @param request
     * @return
     */
    @PostMapping("/uploadFiles")
    @ResponseBody
    public String uploadFiles(MultipartHttpServletRequest request) throws IOException {
        File savePath = new File(path);
        if (!savePath.exists()) {
            savePath.mkdirs();
        }
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    File saveFile = new File(savePath, file.getOriginalFilename());
                    stream = new BufferedOutputStream(new FileOutputStream(saveFile));
                    stream.write(bytes);
                    stream.flush();
                    stream.close();
                } catch (Exception e) {
                    if (stream != null) {
                        stream.close();
                        stream = null;
                    }
                    return "第 " + i + " 个文件上传有错误" + e.getMessage();
                }
            } else {
                return "第 " + i + " 个文件为空";
            }
        }
        return "所有文件上传成功";
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        try (InputStream inputStream = new FileInputStream(new File(path, id));
             OutputStream outputStream = response.getOutputStream();) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + id);

            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
