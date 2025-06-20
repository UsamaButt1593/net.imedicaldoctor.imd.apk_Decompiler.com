package org.apache.commons.httpclient.util;

import java.util.BitSet;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;

public class URIUtil {
    protected static final BitSet empty = new BitSet(1);

    protected static class Coder extends URI {
        protected Coder() {
        }

        public static String decode(char[] cArr, String str) throws URIException {
            return URI.decode(cArr, str);
        }

        public static char[] encode(String str, BitSet bitSet, String str2) throws URIException {
            return URI.encode(str, bitSet, str2);
        }

        public static String replace(String str, char c2, char c3) {
            StringBuffer stringBuffer = new StringBuffer(str.length());
            int i2 = 0;
            while (true) {
                int indexOf = str.indexOf(c2);
                if (indexOf >= 0) {
                    stringBuffer.append(str.substring(0, indexOf));
                    stringBuffer.append(c3);
                } else {
                    stringBuffer.append(str.substring(i2));
                }
                if (indexOf < 0) {
                    return stringBuffer.toString();
                }
                i2 = indexOf;
            }
        }

        public static boolean verifyEscaped(char[] cArr) {
            int i2 = 0;
            while (i2 < cArr.length) {
                char c2 = cArr[i2];
                if (c2 > 128) {
                    return false;
                }
                if (c2 == '%') {
                    if (Character.digit(cArr[i2 + 1], 16) != -1) {
                        i2 += 2;
                        if (Character.digit(cArr[i2], 16) == -1) {
                        }
                    }
                    return false;
                }
                i2++;
            }
            return true;
        }

        public static String replace(String str, char[] cArr, char[] cArr2) {
            for (int length = cArr.length; length > 0; length--) {
                str = replace(str, cArr[length], cArr2[length]);
            }
            return str;
        }
    }

    public static String decode(String str) throws URIException {
        try {
            return EncodingUtil.getString(URLCodec.decodeUrl(EncodingUtil.getAsciiBytes(str)), URI.getDefaultProtocolCharset());
        } catch (DecoderException e2) {
            throw new URIException(e2.getMessage());
        }
    }

    public static String encode(String str, BitSet bitSet) throws URIException {
        return encode(str, bitSet, URI.getDefaultProtocolCharset());
    }

    public static String encodeAll(String str) throws URIException {
        return encodeAll(str, URI.getDefaultProtocolCharset());
    }

    public static String encodePath(String str) throws URIException {
        return encodePath(str, URI.getDefaultProtocolCharset());
    }

    public static String encodePathQuery(String str) throws URIException {
        return encodePathQuery(str, URI.getDefaultProtocolCharset());
    }

    public static String encodeQuery(String str) throws URIException {
        return encodeQuery(str, URI.getDefaultProtocolCharset());
    }

    public static String encodeWithinAuthority(String str) throws URIException {
        return encodeWithinAuthority(str, URI.getDefaultProtocolCharset());
    }

    public static String encodeWithinPath(String str) throws URIException {
        return encodeWithinPath(str, URI.getDefaultProtocolCharset());
    }

    public static String encodeWithinQuery(String str) throws URIException {
        return encodeWithinQuery(str, URI.getDefaultProtocolCharset());
    }

    public static String getFromPath(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("//");
        int i2 = 0;
        if (indexOf >= 0 && str.lastIndexOf("/", indexOf - 1) < 0) {
            i2 = indexOf + 2;
        }
        int indexOf2 = str.indexOf("/", i2);
        return indexOf2 < 0 ? indexOf >= 0 ? "/" : str : str.substring(indexOf2);
    }

    public static String getName(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String path = getPath(str);
        int lastIndexOf = path.lastIndexOf("/");
        return lastIndexOf >= 0 ? path.substring(lastIndexOf + 1, path.length()) : path;
    }

    public static String getPath(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("//");
        int i2 = 0;
        if (indexOf >= 0 && str.lastIndexOf("/", indexOf - 1) < 0) {
            i2 = indexOf + 2;
        }
        int indexOf2 = str.indexOf("/", i2);
        int length = str.length();
        if (str.indexOf(63, indexOf2) != -1) {
            length = str.indexOf(63, indexOf2);
        }
        if (str.lastIndexOf("#") > indexOf2 && str.lastIndexOf("#") < length) {
            length = str.lastIndexOf("#");
        }
        return indexOf2 < 0 ? indexOf >= 0 ? "/" : str : str.substring(indexOf2, length);
    }

    public static String getPathQuery(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf("//");
        int i2 = 0;
        if (indexOf >= 0 && str.lastIndexOf("/", indexOf - 1) < 0) {
            i2 = indexOf + 2;
        }
        int indexOf2 = str.indexOf("/", i2);
        int length = str.length();
        if (str.lastIndexOf("#") > indexOf2) {
            length = str.lastIndexOf("#");
        }
        return indexOf2 < 0 ? indexOf >= 0 ? "/" : str : str.substring(indexOf2, length);
    }

    public static String getQuery(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int indexOf = str.indexOf("//");
        int i2 = 0;
        if (indexOf >= 0 && str.lastIndexOf("/", indexOf - 1) < 0) {
            i2 = indexOf + 2;
        }
        int indexOf2 = str.indexOf("/", i2);
        int length = str.length();
        int indexOf3 = str.indexOf("?", indexOf2);
        if (indexOf3 < 0) {
            return null;
        }
        int i3 = indexOf3 + 1;
        if (str.lastIndexOf("#") > i3) {
            length = str.lastIndexOf("#");
        }
        if (i3 < 0 || i3 == length) {
            return null;
        }
        return str.substring(i3, length);
    }

    public static String decode(String str, String str2) throws URIException {
        return Coder.decode(str.toCharArray(), str2);
    }

    public static String encode(String str, BitSet bitSet, String str2) throws URIException {
        return EncodingUtil.getAsciiString(URLCodec.encodeUrl(bitSet, EncodingUtil.getBytes(str, str2)));
    }

    public static String encodeAll(String str, String str2) throws URIException {
        return encode(str, empty, str2);
    }

    public static String encodePath(String str, String str2) throws URIException {
        return encode(str, URI.allowed_abs_path, str2);
    }

    public static String encodePathQuery(String str, String str2) throws URIException {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return encode(str, URI.allowed_abs_path, str2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(encode(str.substring(0, indexOf), URI.allowed_abs_path, str2));
        stringBuffer.append('?');
        stringBuffer.append(encode(str.substring(indexOf + 1), URI.allowed_query, str2));
        return stringBuffer.toString();
    }

    public static String encodeQuery(String str, String str2) throws URIException {
        return encode(str, URI.allowed_query, str2);
    }

    public static String encodeWithinAuthority(String str, String str2) throws URIException {
        return encode(str, URI.allowed_within_authority, str2);
    }

    public static String encodeWithinPath(String str, String str2) throws URIException {
        return encode(str, URI.allowed_within_path, str2);
    }

    public static String encodeWithinQuery(String str, String str2) throws URIException {
        return encode(str, URI.allowed_within_query, str2);
    }
}
