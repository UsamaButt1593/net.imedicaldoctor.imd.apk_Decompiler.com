package org.apache.commons.httpclient;

import androidx.media3.extractor.AacUtil;
import org.apache.commons.lang3.ClassUtils;

public class HttpVersion implements Comparable {
    public static final HttpVersion HTTP_0_9 = new HttpVersion(0, 9);
    public static final HttpVersion HTTP_1_0 = new HttpVersion(1, 0);
    public static final HttpVersion HTTP_1_1 = new HttpVersion(1, 1);
    private int major = 0;
    private int minor = 0;

    public HttpVersion(int i2, int i3) {
        if (i2 >= 0) {
            this.major = i2;
            if (i3 >= 0) {
                this.minor = i3;
                return;
            }
            throw new IllegalArgumentException("HTTP minor version number may not be negative");
        }
        throw new IllegalArgumentException("HTTP major version number may not be negative");
    }

    public static HttpVersion parse(String str) throws ProtocolException {
        if (str == null) {
            throw new IllegalArgumentException("String may not be null");
        } else if (str.startsWith("HTTP/")) {
            int indexOf = str.indexOf(".", 5);
            if (indexOf != -1) {
                try {
                    try {
                        return new HttpVersion(Integer.parseInt(str.substring(5, indexOf)), Integer.parseInt(str.substring(indexOf + 1, str.length())));
                    } catch (NumberFormatException unused) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Invalid HTTP minor version number: ");
                        stringBuffer.append(str);
                        throw new ProtocolException(stringBuffer.toString());
                    }
                } catch (NumberFormatException unused2) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Invalid HTTP major version number: ");
                    stringBuffer2.append(str);
                    throw new ProtocolException(stringBuffer2.toString());
                }
            } else {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Invalid HTTP version number: ");
                stringBuffer3.append(str);
                throw new ProtocolException(stringBuffer3.toString());
            }
        } else {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Invalid HTTP version string: ");
            stringBuffer4.append(str);
            throw new ProtocolException(stringBuffer4.toString());
        }
    }

    public int compareTo(Object obj) {
        return compareTo((HttpVersion) obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpVersion)) {
            return false;
        }
        return equals((HttpVersion) obj);
    }

    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    public boolean greaterEquals(HttpVersion httpVersion) {
        return compareTo(httpVersion) >= 0;
    }

    public int hashCode() {
        return (this.major * AacUtil.f12876f) + this.minor;
    }

    public boolean lessEquals(HttpVersion httpVersion) {
        return compareTo(httpVersion) <= 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HTTP/");
        stringBuffer.append(this.major);
        stringBuffer.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        stringBuffer.append(this.minor);
        return stringBuffer.toString();
    }

    public int compareTo(HttpVersion httpVersion) {
        if (httpVersion != null) {
            int major2 = getMajor() - httpVersion.getMajor();
            return major2 == 0 ? getMinor() - httpVersion.getMinor() : major2;
        }
        throw new IllegalArgumentException("Version parameter may not be null");
    }

    public boolean equals(HttpVersion httpVersion) {
        return compareTo(httpVersion) == 0;
    }
}
