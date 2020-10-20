package com.example.arj.Utils.Wrappers;

import java.util.List;

public class AdminWrapper {
    private String name;
    private String username;
    private String password;
    private String code;
    private int managerId;
    private int positionId;
    private List<Integer> peIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public List<Integer> getPeIds() {
        return peIds;
    }

    public void setPeIds(List<Integer> peIds) {
        this.peIds = peIds;
    }
}
