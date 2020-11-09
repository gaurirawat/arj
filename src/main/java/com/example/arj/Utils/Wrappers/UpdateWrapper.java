package com.example.arj.Utils.Wrappers;

import java.util.List;

public class UpdateWrapper<T> {
    private T add;
    private T update;
    private int deleteId;
    private List<T> addList;
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

    public T getAdd() {
        return add;
    }

    public void setAdd(T add) {
        this.add = add;
    }

    public List<T> getAddList() {
        return addList;
    }

    public void setAddList(List<T> addList) {
        this.addList = addList;
    }

    public List<T> getDeleteList() {
        return deleteList;
    }

    public void setDeleteList(List<T> deleteList) {
        this.deleteList = deleteList;
    }
}
