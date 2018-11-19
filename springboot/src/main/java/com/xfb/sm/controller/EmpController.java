package com.xfb.sm.controller;

import com.xfb.sm.entity.Emp;
import com.xfb.sm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * className:EmpController
 * describe:
 * author:邢芳彬
 * createTime:2018-11-09 16:20
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;
    @Value("${upload.path}")
    private String filePath;
    private ResourceLoader resourceLoader;

    @Autowired
    public EmpController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    /**
     * 跳转上传
     * @return
     */
    @RequestMapping("toUpload")
    public String toUpload() {
        return "picupload";
    }



    /**
     * 上传方法
     * @param filePic
     * @return
     */
    @RequestMapping("/picUpload")
    public String picUpload(@RequestParam MultipartFile filePic) {
        //获取源文件名称
        String origin = filePic.getOriginalFilename();
        //获取源文件名称后缀
        String suffix = origin.substring(origin.lastIndexOf("."));
        //组装新名称
        String newFileName = UUID.randomUUID() + suffix;//随机串.jpg
        //创建文件
        File file = new File("E:/images/", newFileName);//D:/images/随机串.jpg
       /* if (!file.exists()) {*/
       /*     file.mkdirs();//创建父目录*/
       /* }*/
        try {
            filePic.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "empList";
    }

    public String uploadFile(MultipartFile oldfile,String savePath){
        //获取原文件名称
        String originalFilename = oldfile.getOriginalFilename();//1.jpg
        //获取原文件名称后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));//.jpg
        //组装新名称
        String newFileName = UUID.randomUUID()+suffix;//随机串.jpg

        //创建文件
        File file  =new File(savePath, newFileName);//D:/images/随机串.jpg
   /* if(!file.exists()){
        file.mkdirs();//创建父目录
    }*/
        try {
            //文件读写
            oldfile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }






    @RequestMapping("show")
    public ResponseEntity show(String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + filePath + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }


    /**
     * 跳转列表
     * @return
     */
    @RequestMapping("/toList")
    public String toList() {
        return "empList";
    }
    /**
     * 员工列表
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public List<Emp> list(@RequestParam Map map) {
       /* map.put("sort", map.get("sort")==null?"empno":map.get("sort"));
        map.put("order", map.get("order")==null?"asc":map.get("order"));*/
        return empService.getList(map);
    }

    /**
     * 雇员添加
     * @param emp
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object add(@RequestBody Emp emp) {
        return empService.add(emp);
    }


    @RequestMapping("/getById")
    public Object getById(@RequestParam Map map) {
       return empService.getById(map);
    }

    /**
     * 雇员删除
     * @param empNo
     * @return
     */
    @RequestMapping("/delete")
    public Object delete(Integer empNo) {
        empService.delete(empNo);
        return "删除成功";
    }

    /**
     * 调用存储过程，根据部门编号返回人员列表
     * @param deptNo
     * @return
     */
    @ResponseBody
    @RequestMapping("/proList")
    public Object getProListByDeptNo(Integer deptNo) {
        return empService.getProListBydeptNo(deptNo);
    }
}
