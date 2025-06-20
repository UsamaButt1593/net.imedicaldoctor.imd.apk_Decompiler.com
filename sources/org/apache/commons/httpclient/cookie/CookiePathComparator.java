package org.apache.commons.httpclient.cookie;

import java.util.Comparator;
import org.apache.commons.httpclient.Cookie;

public class CookiePathComparator implements Comparator {
    private String normalizePath(Cookie cookie) {
        String path = cookie.getPath();
        if (path == null) {
            path = "/";
        }
        if (path.endsWith("/")) {
            return path;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(path);
        stringBuffer.append("/");
        return stringBuffer.toString();
    }

    public int compare(Object obj, Object obj2) {
        String normalizePath = normalizePath((Cookie) obj);
        String normalizePath2 = normalizePath((Cookie) obj2);
        if (normalizePath.equals(normalizePath2)) {
            return 0;
        }
        if (normalizePath.startsWith(normalizePath2)) {
            return -1;
        }
        return normalizePath2.startsWith(normalizePath) ? 1 : 0;
    }
}
