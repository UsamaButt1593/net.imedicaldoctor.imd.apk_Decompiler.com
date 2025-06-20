package org.apache.commons.httpclient.cookie;

public final class CookieOrigin {
    private final String host;
    private final String path;
    private final int port;
    private final boolean secure;

    public CookieOrigin(String str, int i2, String str2, boolean z) {
        if (str == null) {
            throw new IllegalArgumentException("Host of origin may not be null");
        } else if (str.trim().equals("")) {
            throw new IllegalArgumentException("Host of origin may not be blank");
        } else if (i2 < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid port: ");
            stringBuffer.append(i2);
            throw new IllegalArgumentException(stringBuffer.toString());
        } else if (str2 != null) {
            this.host = str;
            this.port = i2;
            this.path = str2;
            this.secure = z;
        } else {
            throw new IllegalArgumentException("Path of origin may not be null.");
        }
    }

    public String getHost() {
        return this.host;
    }

    public String getPath() {
        return this.path;
    }

    public int getPort() {
        return this.port;
    }

    public boolean isSecure() {
        return this.secure;
    }
}
