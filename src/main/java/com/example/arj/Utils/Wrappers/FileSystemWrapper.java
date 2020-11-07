package com.example.arj.Utils.Wrappers;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileSystemWrapper {
    private int materialRequestId;
    private int purchaseOrderId;
    private MultipartFile file;
//    private File file;
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public int getMaterialRequestId() {
        return materialRequestId;
    }

    public void setMaterialRequestId(int materialRequestId) {
        this.materialRequestId = materialRequestId;
    }

//    public File getFile() {
//        return file;
//    }
//
//    public void setFile(File file) {
//        this.file = file;
//    }
}
