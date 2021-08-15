package com.rgnews.control;
import com.rgnews.model.FileDo;
import com.rgnews.model.Result;
import com.rgnews.service.FileService;
//import com.sun.deploy.net.URLEncoder;
import java.net.URLEncoder;

import com.rgnews.util.NameUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService fileService ;



    /**
     * 跳转上传单文件页面
     * @return
     */
    @RequestMapping("/upload")
    public String singleFile() {
        return "upload";
    }

//    /**
//     * 跳转上传多文件页面
//     * @return
//     */
//    @RequestMapping("/uploadBatch")
//    public String multipleFiles() {
//        return "/uploadBatch";
//    }


    /**
     * 上传单文件
     * @param file
     * @return
     */
    @PostMapping("/uploadFile")
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile file, @RequestParam("file_type")int file_type) {
        //判断非空
        if (file.isEmpty()) {
            return Result.failed("上传文件不能为空");
        }
        try {
            //文件路径
            String path = "D:\\datafile\\";
            //0或其他：未分类   1：图片  2：文档
            switch (file_type){
                case 1:path+="pic\\"; break;
                case 2:path+="doc\\"; break;
                default:path+="other\\";
            }
            // 测试MultipartFile接口的各个方法
            logger.info("[文件类型ContentType] - [{}]",file.getContentType());
            logger.info("[文件组件名称Name] - [{}]",file.getName());
            logger.info("[文件原名称OriginalFileName] - [{}]",file.getOriginalFilename());
            logger.info("[文件大小] - [{}]",file.getSize());
            logger.info(this.getClass().getName()+"图片路径："+path);

            // 获取文件名称
            String fileName = file.getOriginalFilename();
            // 获取文件后缀
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //文件名增加时间戳
            NameUtil nameUtil = new NameUtil();
            String nowtime = new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
            String newFileName =nameUtil.getFileNameNoEx(fileName)+nowtime+suffixName;


            File f = new File(path);
            // 如果不存在该路径就创建
            if (!f.exists()) {
                f.mkdir();
            }
            File dir = new File(path + newFileName);
            // 文件写入
            file.transferTo(dir);
            // 这里除了transferTo方法，也可以用字节流的方式上传文件，但是字节流比较慢，所以还是建议用transferTo
//            writeFile(file);
            FileDo fileDo = new FileDo();
            String upload_time = new SimpleDateFormat("YYYY-MM-DD").format(new Date());
            fileDo.setUpdate_time(upload_time);
            fileDo.setFile_name(newFileName);
            fileDo.setFile_type(file_type);
            fileDo.setFile_url(path+newFileName);
            fileService.insertFile(fileDo);
            return Result.success(path+newFileName,"文件已上传");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failed("上传失败");
        }
    }


//    @PostMapping("/uploadBatch")
//    @ResponseBody
//    public String uploadBatch(@RequestParam("files") MultipartFile[] files) {
//        logger.info("文件名称："+ files );
//        if(files!=null&&files.length>0){
//            String filePath = "D:\\datafile\\";
//            for (MultipartFile mf : files) {
//                // 获取文件名称
//                String fileName = mf.getOriginalFilename();
//                // 获取文件后缀
//                String suffixName = fileName.substring(fileName.lastIndexOf("."));
//                // 重新生成文件名
//                fileName = UUID.randomUUID()+suffixName;
//
//                if (mf.isEmpty()) {
//                    return "文件名称："+ fileName +"上传失败，原因是文件为空!";
//                }
//                File dir = new File(filePath + fileName);
//                try {
//                    // 写入文件
//                    mf.transferTo(dir);
//                    logger.info("文件名称："+ fileName +"上传成功");
//                } catch (IOException e) {
//                    logger.error(e.toString(), e);
//                    return "文件名称："+ fileName +"上传失败";
//                }
//            }
//            return "多文件上传成功";
//        }
//        return "上传文件不能为空";
//    }

    @PostMapping("/fileList")
    @ResponseBody
    public Result fileList(){
        List<FileDo> fileDoList;
        try{
            fileDoList = fileService.fileList();
            if(fileDoList!=null && !fileDoList.isEmpty())
            {
                return Result.success(fileDoList);
            }else
            {
                return Result.failed("未找到记录");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return Result.failed();
        }

    }

    @DeleteMapping(value = "deleteFile")
    @ResponseBody
    public Result deleteNews(int file_id){
        FileDo dfdo = fileService.getFileById(file_id);
        if(dfdo!=null){
            try{
                File df = new File(dfdo.getFile_url());
                df.delete();
                fileService.deleteFile(file_id);
                return Result.success();
            }
            catch (Exception e){
                e.printStackTrace();
                return Result.failed();
            }
        }
       return Result.failed("数据库内没有该记录");

    }

    @RequestMapping("/download")
    public String DownLoadSingleFile() {
        return "download";
    }


    @PostMapping("/downloadFile")
    @ResponseBody
    public Result downloadFile(HttpServletRequest request, HttpServletResponse response,int file_id) throws UnsupportedEncodingException {

        FileDo fileDo = fileService.getFileById(file_id);
        if (fileDo!=null) {
            String fileName = fileDo.getFile_name();// 文件名
            //设置文件路径
//            File file = new File("D:\\datafile\\pic\\1.txt");
            File file = new File(fileDo.getFile_url());
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("multipart/form-data");
                response.setHeader("Content-Disposition", "attachment; fileName="+  fileName +";filename*=utf-8''"+ URLEncoder.encode(fileName,"UTF-8"));
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    logger.info(""+i);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return Result.success();
            }
            return Result.failed("没有对应的文件");
        }
        else {
            return Result.failed("没有对应的文件");
        }
    }








}

