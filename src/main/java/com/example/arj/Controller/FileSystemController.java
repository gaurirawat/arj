package com.example.arj.Controller;

import com.example.arj.DAO.EmployeeDao;
import com.example.arj.Models.Employee;
import com.example.arj.Services.FileSystemService;
import com.example.arj.Utils.Exceptions.FileException;
import com.example.arj.Utils.Wrappers.FileSystemWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;

@RestController()
@RequestMapping("fileSystem")
public class FileSystemController{

    @Autowired
    FileSystemService fileSystemService;

    @GetMapping("/test")
    public void test(){
        fileSystemService.test();
    }

    @PostMapping("/upload")
    public boolean uploadFile(@RequestParam("file") MultipartFile multipartFile){
//        int materialRequestId=fileSystemWrapper.getMaterialRequestId();
//        System.out.println(materialRequestId);
//        return true;
//        File file=fileSystemWrapper.getFile();
//        MultipartFile multipartFile=fileSystemWrapper.getFile();
        int materialRequestId=1;
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(materialRequestId);
        return fileSystemService.uploadFile(multipartFile,materialRequestId);
    }

    @GetMapping
    public Resource downloadFile(@RequestBody FileSystemWrapper fileSystemWrapper){
        int purchaseOrderId = fileSystemWrapper.getPurchaseOrderId();
        return fileSystemService.downloadFile(purchaseOrderId);
    }

    @PostMapping("/delete")
    public boolean deleteFile(@RequestBody FileSystemWrapper fileSystemWrapper){
        int purchaseOrderId = fileSystemWrapper.getPurchaseOrderId();
        return fileSystemService.deleteFile(purchaseOrderId);
    }
}
