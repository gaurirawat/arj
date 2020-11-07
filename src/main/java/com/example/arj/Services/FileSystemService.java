package com.example.arj.Services;

import com.example.arj.DAO.PurchaseOrderDao;
import com.example.arj.Models.PurchaseOrder;
import com.example.arj.Utils.Exceptions.FileNotFoundException;
import com.example.arj.Utils.Exceptions.FileStorageException;
import com.example.arj.Utils.FileUploadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;

@Component
public class FileSystemService {

    @Autowired
    PurchaseOrderDao purchaseOrderDao;

    private final Path path;
    private final int size;

    public FileSystemService(FileUploadProperties fileUploadProperties) {
        this.path = Paths.get(fileUploadProperties.getLocation())
                .toAbsolutePath()
                .normalize();
        this.size=Integer.parseInt(fileUploadProperties.getSize());
    }

    public boolean uploadFile(MultipartFile file, int materialRequestId) {
        String remFilePath=(materialRequestId/size)+"";
        Path completePath=path.resolve(remFilePath);
        try {
            if (!Files.exists(completePath))
                Files.createDirectory(completePath);
            remFilePath +="/"+ file.getOriginalFilename();
            completePath = path.resolve(remFilePath);
//            FileInputStream fileInputStream=new FileInputStream(file);
            Files.copy(file.getInputStream(), completePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            throw new FileStorageException("Could not upload file");
        }
        PurchaseOrder purchaseOrder=new PurchaseOrder();
        purchaseOrder.setPath(remFilePath);
        purchaseOrderDao.save(purchaseOrder);
        System.out.print(remFilePath);
        System.out.print(completePath.toString());
        return true;
    }


    public Resource downloadFile(int purchaseOrderId){
        PurchaseOrder purchaseOrder = purchaseOrderDao.find(purchaseOrderId);
        Path completePath = path.resolve(purchaseOrder.getPath()).normalize();
        try {
            Resource resource = new UrlResource(completePath.toUri());
            if (resource.exists() || resource.isReadable())
                return resource;
            else
                throw new FileNotFoundException("Could not find file");
        }
        catch (Exception e) {
            throw new FileNotFoundException("Could not download file");
        }
    }

    public boolean deleteFile(int purchaseOrderId){
        PurchaseOrder purchaseOrder = purchaseOrderDao.find(purchaseOrderId);
        Path completePath = path.resolve(purchaseOrder.getPath()).normalize();
        try {
            Resource resource = new UrlResource(completePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                Files.delete(completePath);
                purchaseOrderDao.delete(purchaseOrderId);
                return true;
            }
            else
                throw new FileNotFoundException("Could not find file");
        }
        catch (Exception e) {
            throw new FileNotFoundException("Could not delete file");
        }
    }

    public void test(){
        System.out.print(path);
        System.out.print(size);
    }

}
