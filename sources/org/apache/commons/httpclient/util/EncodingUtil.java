package org.apache.commons.httpclient.util;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.httpclient.HttpClientError;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EncodingUtil {
    private static final String DEFAULT_CHARSET = "ISO-8859-1";
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$util$EncodingUtil;

    static {
        Class cls = class$org$apache$commons$httpclient$util$EncodingUtil;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.util.EncodingUtil");
            class$org$apache$commons$httpclient$util$EncodingUtil = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    private EncodingUtil() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private static String doFormUrlEncode(NameValuePair[] nameValuePairArr, String str) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < nameValuePairArr.length; i2++) {
            URLCodec uRLCodec = new URLCodec();
            NameValuePair nameValuePair = nameValuePairArr[i2];
            if (nameValuePair.getName() != null) {
                if (i2 > 0) {
                    stringBuffer.append("&");
                }
                stringBuffer.append(uRLCodec.encode(nameValuePair.getName(), str));
                stringBuffer.append("=");
                if (nameValuePair.getValue() != null) {
                    stringBuffer.append(uRLCodec.encode(nameValuePair.getValue(), str));
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String formUrlEncode(NameValuePair[] nameValuePairArr, String str) {
        try {
            return doFormUrlEncode(nameValuePairArr, str);
        } catch (UnsupportedEncodingException unused) {
            Log log = LOG;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Encoding not supported: ");
            stringBuffer.append(str);
            log.error(stringBuffer.toString());
            try {
                return doFormUrlEncode(nameValuePairArr, "ISO-8859-1");
            } catch (UnsupportedEncodingException unused2) {
                throw new HttpClientError("Encoding not supported: ISO-8859-1");
            }
        }
    }

    public static byte[] getAsciiBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                throw new HttpClientError("HttpClient requires ASCII support");
            }
        } else {
            throw new IllegalArgumentException("Parameter may not be null");
        }
    }

    public static String getAsciiString(byte[] bArr) {
        return getAsciiString(bArr, 0, bArr.length);
    }

    public static byte[] getBytes(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("data may not be null");
        } else if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("charset may not be null or empty");
        } else {
            try {
                return str.getBytes(str2);
            } catch (UnsupportedEncodingException unused) {
                if (LOG.isWarnEnabled()) {
                    Log log = LOG;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unsupported encoding: ");
                    stringBuffer.append(str2);
                    stringBuffer.append(". System encoding used.");
                    log.warn(stringBuffer.toString());
                }
                return str.getBytes();
            }
        }
    }

    public static String getString(byte[] bArr, int i2, int i3, String str) {
        if (bArr == null) {
            throw new IllegalArgumentException("Parameter may not be null");
        } else if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("charset may not be null or empty");
        } else {
            try {
                return new String(bArr, i2, i3, str);
            } catch (UnsupportedEncodingException unused) {
                Log log = LOG;
                if (log.isWarnEnabled()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unsupported encoding: ");
                    stringBuffer.append(str);
                    stringBuffer.append(". System encoding used");
                    log.warn(stringBuffer.toString());
                }
                return new String(bArr, i2, i3);
            }
        }
    }

    public static String getAsciiString(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            try {
                return new String(bArr, i2, i3, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                throw new HttpClientError("HttpClient requires ASCII support");
            }
        } else {
            throw new IllegalArgumentException("Parameter may not be null");
        }
    }

    public static String getString(byte[] bArr, String str) {
        return getString(bArr, 0, bArr.length, str);
    }
}
