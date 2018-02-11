package com.gds.controller.back;

import com.gds.entity.Dict;
import com.gds.entity.MyFile;
import com.gds.service.FileService;
import com.gds.utils.PageBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;

@Controller
@RequestMapping("/back")
public class FileController {
    private Logger logger = Logger.getLogger(FileController.class);

    @Resource(name = "FileService")
    private FileService fileService;

    @RequestMapping("/fileList.do")
    public String list(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                       @RequestParam(value = "pageSize", required = false)Integer pageSize,
                       @RequestParam(value = "currentPage", required = false)Integer currentPage,
                       @RequestParam(value = "fileName", required = false)String fileName,
                       @RequestParam(value = "uploadUsername", required = false)String uploadUsername ){

        PageBean<MyFile> pageBeans = fileService.selectFilePageList(currentPage,pageSize,fileName,uploadUsername);
        model.addAttribute("page",pageBeans);
        model.addAttribute("beans",pageBeans.getBeans());
        model.addAttribute("fileName",fileName);
        model.addAttribute("uploadUsername",uploadUsername);
        logger.info("访问【fileList.do】接口；返回数据为："+pageBeans.toString());

        return "back/FileManager/list";
    }

    /**
     * 文件上传功能
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/fileUpload.do",method= RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request, ModelMap model) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        String filePath = path+"\\"+fileName;

        File dir = new File(path,fileName);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        file.transferTo(dir);
        model.addAttribute("filePath",filePath);
        model.addAttribute("fileName",fileName);
        return "back/FileManager/add";
    }

    /**
     * 文件下载功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/fileDown.do")
    public void down(HttpServletRequest request,HttpServletResponse response,
                     @RequestParam(value = "fileId", required = false)Integer fileId) throws Exception{

        MyFile file = fileService.selectByPrimaryKey(fileId);
        String fileUrl = file.getFileUrl();
        //模拟文件，myfile.txt为需要下载的文件
//        String fileName = request.getSession().getServletContext().getRealPath("upload")+"/myfile.txt";
//        fileUrl= fileUrl.replace("\\","/");
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileUrl)));
        //假如以中文名下载的话
        String filename = file.getFileName() ;
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }

    /**
     * fileSave
     */
    /**
     * 保存操作
     */
    @RequestMapping("/fileSave.do")
    public String fileSave(HttpServletRequest request, HttpServletResponse response, ModelMap model,MyFile file){
        file.setFileCreatTime(new Date());
        logger.info("fileSave.do接口接受到的参数为："+file);
        fileService.insert(file);
        return list(request, response,model,null,null,null,null);
    }

    /**
     * 跳转到新增页面
     */
    @RequestMapping("/fileToAddPage.do")
    public String fileToAddPage(HttpServletRequest request, HttpServletResponse response, ModelMap model){


        return "back/FileManager/add";
    }

    /**
     * 删除操作
     */
    @RequestMapping("/fileDelete.do")
    public String fileDelete(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                             @RequestParam(value = "fileId", required = false)Integer fileId ){
        fileService.deleteByPrimaryKey(fileId);
        return list(request, response,model,null,null,null,null);
    }



}
