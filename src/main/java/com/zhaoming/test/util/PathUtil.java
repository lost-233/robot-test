package com.zhaoming.test.util;

/**
 * @author zm
 */
public class PathUtil {
    /**
     * 项目路径
     * @return
     */
    public static String getPath() {
        String path = PathUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        if (System.getProperty("os.name").contains("dows")) {
            path = path.substring(1, path.length());
        }
        if (path.contains("jar")) {
            path = path.substring(0, path.lastIndexOf("."));
            return path.substring(0, path.lastIndexOf("/"));
        }
        return path.replace("target/classes/", "");
    }
}
