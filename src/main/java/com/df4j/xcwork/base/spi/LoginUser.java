package com.df4j.xcwork.base.spi;

import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoginUser extends HashMap<String, Object> {
    public static final String USER_ID_KEY = "userId";
    public static final String USER_NAME_KEY = "userName";
    public static final String NICK_NAME_KEY = "nickName";
    public static final String DEPT_CODE_KEY = "deptCode";
    public static final String DEPT_NAME_KEY = "deptName";
    public static final String ADMIN_ROLE_FLAG_KEY = "adminRoleFlag";
    public static final String GRANTED_SYS_LIST_KEY = "grantedSysList";
    public static final String GRANTED_DEPT_LIST_KEY = "grantedDeptList";
    public static final String MANAGE_SYS_LIST_KEY = "manageSyslist";
    public static final String MANAGE_DEPT_LIST_KEY = "manageDeptList";

    public LoginUser() {
        this.put(ADMIN_ROLE_FLAG_KEY, 0);
        this.put(MANAGE_DEPT_LIST_KEY, new ArrayList<>());
        this.put(MANAGE_SYS_LIST_KEY, new ArrayList<>());
        this.put(GRANTED_DEPT_LIST_KEY, new ArrayList<>());
        this.put(GRANTED_DEPT_LIST_KEY, new ArrayList<>());
    }


    public String getUserId() {
        return (String) this.get(USER_ID_KEY);
    }

    public void setUserId(String userId) {
        this.put(USER_ID_KEY, userId);
    }

    public String getUserName() {
        return (String) this.get(USER_NAME_KEY);
    }

    public void setUserName(String userName) {
        this.put(USER_NAME_KEY, userName);
    }

    public String getNickName() {
        return (String) this.get(NICK_NAME_KEY);
    }

    public void setNickName(String nickName) {
        this.put(NICK_NAME_KEY, nickName);
    }

    public String getDeptCode() {
        return (String) this.get(DEPT_CODE_KEY);
    }

    public void setDeptCode(String deptCode) {
        this.put(DEPT_CODE_KEY, deptCode);
    }

    public String getDeptName() {
        return (String) this.get(DEPT_NAME_KEY);
    }

    public void setDeptName(String deptName) {
        this.put(DEPT_NAME_KEY, deptName);
    }

    public Integer getAdminRoleFlag() {
        return (Integer) this.get(ADMIN_ROLE_FLAG_KEY);
    }

    public void setAdminRoleFlag(Integer adminRoleFlag) {
        this.put(ADMIN_ROLE_FLAG_KEY, adminRoleFlag);
    }

    public List<String> getGrantedSysList() {
        return (List<String>) this.get(GRANTED_SYS_LIST_KEY);
    }

    public void setGrantedSysList(List<String> grantedSysList) {
        if (!ObjectUtils.isEmpty(grantedSysList)) {
            this.put(GRANTED_SYS_LIST_KEY, grantedSysList);
        }
    }

    public List<String> getGrantedDeptList() {
        return (List<String>) this.get(GRANTED_DEPT_LIST_KEY);
    }

    public void setGrantedDeptList(List<String> grantedDeptList) {
        if (!ObjectUtils.isEmpty(grantedDeptList)) {
            this.put(GRANTED_DEPT_LIST_KEY, grantedDeptList);
        }
    }

    public List<String> getManageSyslist() {
        return (List<String>) this.get(MANAGE_SYS_LIST_KEY);
    }

    public void setManageSyslist(List<String> manageSyslist) {
        if (!ObjectUtils.isEmpty(manageSyslist)) {
            this.put(MANAGE_SYS_LIST_KEY, manageSyslist);
        }
    }

    public List<String> getManageDeptList() {
        return (List<String>) this.get(MANAGE_DEPT_LIST_KEY);
    }

    public void setManageDeptList(List<String> manageDeptList) {
        if (!ObjectUtils.isEmpty(manageDeptList)) {
            this.put(MANAGE_DEPT_LIST_KEY, manageDeptList);
        }
    }

    boolean isSuperAdmin() {
        int adminRoleFlag = this.getAdminRoleFlag();
        return 1 == (adminRoleFlag & 1);
    }

    boolean isSysAdmin() {
        int adminRoleFlag = this.getAdminRoleFlag();
        return (1 == (adminRoleFlag & 1)) || (1 == ((adminRoleFlag >> 1) & 1));
    }

    boolean isDeptAdmin() {
        int adminRoleFlag = this.getAdminRoleFlag();
        return (1 == (adminRoleFlag & 1)) || (1 == ((adminRoleFlag >> 2) & 1));
    }
}