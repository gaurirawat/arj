package com.example.arj.Utils.Wrappers;

import java.util.List;

public class UpdateWrapper<T> {
    private T save;
    private T update;
    private int deleteId;
    private List<T> saveList;
    private List<T> deleteList;

    public T getUpdate() {
        return update;
    }

    public void setUpdate(T update) {
        this.update = update;
    }

    public int getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(int deleteId) {
        this.deleteId = deleteId;
    }

    public T getsave() {
        return save;
    }

    public void setsave(T save) {
        this.save = save;
    }

    public List<T> getsaveList() {
        return saveList;
    }

    public void setsaveList(List<T> saveList) {
        this.saveList = saveList;
    }

    public List<T> getDeleteList() {
        return deleteList;
    }

    public void setDeleteList(List<T> deleteList) {
        this.deleteList = deleteList;
    }
}
