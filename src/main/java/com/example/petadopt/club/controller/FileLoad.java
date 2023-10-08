package com.example.petadopt.club.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Mr Wu
 * @create: 2019-08-25 19:09
 */
@Controller
public class FileLoad {
    public String uploadAdminPic(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("null");
        }
        String fileName = file.getOriginalFilename();
        try {
            String filePath = getSaveAdminPath();
            String path = filePath + file.getOriginalFilename();
            if (!file.isEmpty()) {
                File dir = new File(filePath);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                File tempFile = null;
                tempFile = new File(path);
                FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("error");
        }
        return fileName;
    }

    public String uploadUserPic(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("null");
        }
        String fileName = file.getOriginalFilename();
        try {
            String filePath = getSaveUserPath();
            String path = filePath + file.getOriginalFilename();
            if (!file.isEmpty()) {
                File dir = new File(filePath);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                File tempFile = null;
                tempFile = new File(path);
                FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("error");
        }
        return fileName;
    }

    public String uploadPetPic(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new Exception("null");
        }
        String fileName = file.getOriginalFilename();
        try {
            String filePath = getSavePetPath();
            String path = filePath + file.getOriginalFilename();
            if (!file.isEmpty()) {
                File dir = new File(filePath);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                File tempFile = null;
                tempFile = new File(path);
                FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("error");
        }
        return fileName;
    }

    public String getSavePetPath() {
        // 这里需要注意的是ApplicationHome是属于SpringBoot的类
        // 获取项目下/img路径
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        // 保存目录位置根据项目需求可随意更改
        return applicationHome.getDir().getParentFile()
                .getParentFile().getAbsolutePath() + "/src/main/webapp/static/images/animal/";
    }

    public String getSaveUserPath() {
        // 这里需要注意的是ApplicationHome是属于SpringBoot的类
        // 获取项目下/img路径
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        // 保存目录位置根据项目需求可随意更改
        return applicationHome.getDir().getParentFile()
                .getParentFile().getAbsolutePath() + "/src/main/webapp/static/images/user/";
    }

    public String getSaveAdminPath() {
        // 这里需要注意的是ApplicationHome是属于SpringBoot的类
        // 获取项目下/img路径
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());
        // 保存目录位置根据项目需求可随意更改
        return applicationHome.getDir().getParentFile()
                .getParentFile().getAbsolutePath() + "/src/main/webapp/static/images/admin/";
    }
}
