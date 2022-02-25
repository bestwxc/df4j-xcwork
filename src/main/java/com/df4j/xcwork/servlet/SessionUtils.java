package com.df4j.xcwork.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    public static HttpSession getSession(HttpServletRequest request) {
        if (request != null) {
            return request.getSession(false);
        }
        return null;
    }

    public static HttpSession createSession(HttpServletRequest request) {
        if (request != null) {
            return request.getSession(true);
        }
        return null;
    }

    public static void setSessionAttribute(HttpSession session, String key, Object value) {
        session.setAttribute(key, value);
    }

    public static Object getSessionAttribute(HttpSession session, String key) {
        if (session != null) {
            return session.getAttribute(key);
        }
        return null;
    }
}