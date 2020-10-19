package com.cqp.utils;

import entity.Path;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author zhd
 * @date 2020/10/18
 */
public class PhotoUtils {
    public static String addPhoto(MultipartFile file) throws IOException {
        String projectname;    //项目名称
        projectname = "cqPension";
        //文件（图片）路径
        String filePath = Path.rootPath + projectname + Path.photoPath;

        // 获取上传图片的文件名及其后缀(获取原始图片的拓展名)
        String fileName = file.getOriginalFilename();
        if (!fileName.equals("")) {
            //生成新的文件名字(不重复)
            String newFileName = UUID.randomUUID() + fileName;
            // 封装上传文件位置的全路径
            File targetFile = new File(filePath, newFileName);
            if(!targetFile.getParentFile().exists()){    //判断父级路径是否存在
                targetFile.getParentFile().mkdirs();
            }
            //System.out.println("上传相册的全路径:" + targetFile);
            // 把本地文件上传到封装上传文件位置
            file.transferTo(targetFile);
            return targetFile.toString();//返回图片路径
        }
        return "";
    }
}
