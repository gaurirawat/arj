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

    public T getSave() {
        return save;
    }

    public void setSave(T save) {
        this.save = save;
    }

    public List<T> getSaveList() {
        return saveList;
    }

    public void setSaveList(List<T> saveList) {
        this.saveList = saveList;
    }

    public List<T> getDeleteList() {
        return deleteList;
    }

    public void setDeleteList(List<T> deleteList) {
        this.deleteList = deleteList;
    }
}
