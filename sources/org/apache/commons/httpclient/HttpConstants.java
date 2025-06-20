package org.apache.commons.httpclient;

import java.io.UnsupportedEncodingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpConstants {
    public static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    public static final String HTTP_ELEMENT_CHARSET = "US-ASCII";
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$HttpConstants;

    static {
        Class cls = class$org$apache$commons$httpclient$HttpConstants;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.HttpConstants");
            class$org$apache$commons$httpclient$HttpConstants = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static byte[] getAsciiBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException("HttpClient requires ASCII support");
            }
        } else {
            throw new IllegalArgumentException("Parameter may not be null");
        }
    }

    public static String getAsciiString(byte[] bArr) {
        return getAsciiString(bArr, 0, bArr.length);
    }

    public static byte[] getBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                Log log = LOG;
                if (log.isWarnEnabled()) {
                    log.warn("Unsupported encoding: US-ASCII. System default encoding used");
                }
                return str.getBytes();
            }
        } else {
            throw new IllegalArgumentException("Parameter may not be null");
        }
    }

    public static byte[] getContentBytes(String str) {
        return getContentBytes(str, (String) null);
    }

    public static String getContentString(byte[] bArr) {
        return getContentString(bArr, (String) null);
    }

    public static String getString(byte[] bArr) {
        return getString(bArr, 0, bArr.length);
    }

    public static String getAsciiString(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            try {
                return new String(bArr, i2, i3, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                throw new RuntimeException("HttpClient requires ASCII support");
            }
        } else {
            throw new IllegalArgumentException("Parameter may not be null");
        }
    }

    public static byte[] getContentBytes(String str, String str2) {
        if (str != null) {
            if (str2 == null || str2.equals("")) {
                str2 = "ISO-8859-1";
            }
            try {
                return str.getBytes(str2);
            } catch (UnsupportedEncodingException unused) {
                if (LOG.isWarnEnabled()) {
                    Log log = LOG;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unsupported encoding: ");
                    stringBuffer.append(str2);
                    stringBuffer.append(". HTTP default encoding used");
                    log.warn(stringBuffer.toString());
                }
                try {
                    return str.getBytes("ISO-8859-1");
                } catch (UnsupportedEncodingException unused2) {
                    Log log2 = LOG;
                    if (log2.isWarnEnabled()) {
                        log2.warn("Unsupported encoding: ISO-8859-1. System encoding used");
                    }
                    return str.getBytes();
                }
            }
        } else {
            throw new IllegalArgumentException("Parameter may not be null");
        }
    }

    public static String getContentString(byte[] bArr, int i2, int i3) {
        return getContentString(bArr, i2, i3, (String) null);
    }

    public static String getString(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            try {
                return new String(bArr, i2, i3, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                Log log = LOG;
                if (log.isWarnEnabled()) {
                    log.warn("Unsupported encoding: US-ASCII. System default encoding used");
                }
                return new String(bArr, i2, i3);
            }
        } else {
            throw new IllegalArgumentException("Parameter may not be null");
        }
    }

    public static String getContentString(byte[] bArr, int i2, int i3, String str) {
        if (bArr != null) {
            if (str == null || str.equals("")) {
                str = "ISO-8859-1";
            }
            try {
                return new String(bArr, i2, i3, str);
            } catch (UnsupportedEncodingException unused) {
                Log log = LOG;
                if (log.isWarnEnabled()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unsupported encoding: ");
                    stringBuffer.append(str);
                    stringBuffer.append(". Default HTTP encoding used");
                    log.warn(stringBuffer.toString());
                }
                try {
                    return new String(bArr, i2, i3, "ISO-8859-1");
                } catch (UnsupportedEncodingException unused2) {
                    Log log2 = LOG;
                    if (log2.isWarnEnabled()) {
                        log2.warn("Unsupported encoding: ISO-8859-1. System encoding used");
                    }
                    return new String(bArr, i2, i3);
                }
            }
        } else {
            throw new IllegalArgumentException("Parameter may not be null");
        }
    }

    public static String getContentString(byte[] bArr, String str) {
        return getContentString(bArr, 0, bArr.length, str);
    }
}
