package com.df4j.xcwork.base.utils;

import com.df4j.xcwork.base.exception.XcworkException;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import static com.df4j.xcwork.base.constants.XcworkSystemPropertyName.*;

/**
 * 框架使用工具
 */
public class XcworkUtils {

    public static boolean debug = false;

    static {
        String debugProperty = System.getProperty(DEBUG, "false");
        debug = "true".equalsIgnoreCase(debugProperty)
                || "1".equalsIgnoreCase(debugProperty);
    }


    public static boolean isDebug() {
        return debug;
    }

}
