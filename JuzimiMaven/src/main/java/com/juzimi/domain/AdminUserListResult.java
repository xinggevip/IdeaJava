package com.juzimi.domain;

import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

public class AdminUserListResult {
    // 用户列表
    private List<Users> usersList = new ArrayList<>();
    // pageinfo
    private PageInfo pageInfo;

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    @Override
    public String toString() {
        return "AdminUserListResult{" +
                "usersList=" + usersList +
                ", pageInfo=" + pageInfo +
                '}';
    }
}
