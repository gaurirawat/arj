package com.example.arj.Utils.Wrappers;

import java.util.List;

public class UpdateWrapper<T> {
    private List<T> addList;
    private List<T> deleteList;

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
