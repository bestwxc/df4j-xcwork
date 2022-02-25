package com.df4j.xcwork.servlet;

import com.df4j.xcwork.base.spi.LoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUserUtils {

    private static final String LOGIN_USER_KEY = "XCWORK_LOGIN_USER";

    public LoginUser getLoginUser(HttpServletRequest request) {
        HttpSession session = SessionUtils.getSession(request);
        if (session != null) {
            Object obj = SessionUtils.getSessionAttribute(session, LOGIN_USER_KEY);
            if (obj != null) {
                return (LoginUser) obj;
            }
        }
        return null;
    }


    public void setLoginUser(HttpServletRequest request, LoginUser loginUser) {
        HttpSession session = SessionUtils.getSession(request);
        SessionUtils.setSessionAttribute(session, LOGIN_USER_KEY, loginUser);
    }
}
