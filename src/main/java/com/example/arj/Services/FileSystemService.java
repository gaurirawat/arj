package com.example.arj.Services;

import com.example.arj.DAO.MaterialRequestDao;
import com.example.arj.DAO.PurchaseOrderDao;
import com.example.arj.Models.MaterialRequest;
import com.example.arj.Models.PurchaseOrder;
import com.example.arj.Utils.Exceptions.FileNotFoundException;
import com.example.arj.Utils.Exceptions.FileStorageException;
import com.example.arj.Utils.FileUploadProperties;
import com.example.arj.Utils.Wrappers.FileSystemWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    MaterialRequestDao materialRequestDao;

    private final Path path;
    private final int size;

    public FileSystemService(FileUploadProperties fileUploadProperties) {
        //"user.home" will give us home directory of system in almost all the systems. and then we append our path mentioned directory path in properties.
        this.path = Paths.get(System.getProperty("user.home"),fileUploadProperties.getLocation())
                .toAbsolutePath()
                .normalize();
        this.size=Integer.parseInt(fileUploadProperties.getSize());
    }

    public boolean uploadFile(MultipartFile file, int materialRequestId) {

        String dirPath=(materialRequestId/size)+"";
        Path completeDirPath=path.resolve(dirPath);

        String filePath = dirPath+"/"+ file.getOriginalFilename();
        Path completeFilePath = path.resolve(filePath);
        PurchaseOrder purchaseOrder=new PurchaseOrder();
        purchaseOrder.setPath(filePath);
        purchaseOrder.setMaterialRequest(materialRequestDao.find(materialRequestId));
        purchaseOrder = purchaseOrderDao.save(purchaseOrder);
        try {
            if (!Files.exists(completeDirPath)) {
                System.out.println("directory doesn't exist at :" + completeDirPath.toString());
                Files.createDirectories(completeDirPath);
            }
            Files.copy(file.getInputStream(), completeFilePath, StandardCopyOption.REPLACE_EXISTING);   //

        } catch (Exception e) {
//            if file upload throws an exception then revert insertion operation
            purchaseOrderDao.delete(purchaseOrder);
            System.out.println(e);
            throw new FileStorageException("Could not upload file");
        }
        System.out.println("uploaded successfully");
        return true;
    }


    public ResponseEntity<Resource> downloadFile(int purchaseOrderId){
        PurchaseOrder purchaseOrder = purchaseOrderDao.find(purchaseOrderId);
        Path completePath = path.resolve(purchaseOrder.getPath()).normalize();
        try {
            Resource resource = new UrlResource(completePath.toUri());
            if (resource.exists() || resource.isReadable())
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + resource.getFilename() + "\"")
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .body(resource);
            else
                throw new FileNotFoundException("Could not find file");
        }
        catch (Exception e) {
            System.out.println(e);
            throw new FileNotFoundException("Could not download file");
        }
    }
    @Transactional
    public boolean deleteFile(int purchaseOrderId){
        PurchaseOrder purchaseOrder = purchaseOrderDao.find(purchaseOrderId);
        Path completePath = path.resolve(purchaseOrder.getPath()).normalize();
        /* * *
        We are removing it first from the DB and then from the storage,
        Because if DB operation will throw and exception then it won't delete file physically,
        and if file operation does then we can revert our DB operation.
        but if first file operation is success and then DB throws an exception,
        then reverting that operation is not possible.
        * * */
        purchaseOrderDao.delete(purchaseOrderId);
        try {
            Resource resource = new UrlResource(completePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                Files.delete(completePath);

                return true;
            }
            else
                throw new FileNotFoundException("Could not find file");
        }
        catch (Exception e) {
            System.out.println(e);
            throw new FileNotFoundException("Could not delete file");
        }
    }

    public boolean test(FileSystemWrapper fileSystemWrapper){
        System.out.println(fileSystemWrapper);
        return true;
    }

}
