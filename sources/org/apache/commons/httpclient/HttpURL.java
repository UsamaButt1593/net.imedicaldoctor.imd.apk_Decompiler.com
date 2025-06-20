package org.apache.commons.httpclient;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.pdf.Barcode128;
import java.util.BitSet;
import kotlin.text.Typography;
import org.apache.commons.httpclient.util.URIUtil;

public class HttpURL extends URI {
    public static final int DEFAULT_PORT = 80;
    public static final char[] DEFAULT_SCHEME;
    public static final int _default_port = 80;
    public static final char[] _default_scheme;
    static final long serialVersionUID = -7158031098595039459L;

    static {
        char[] cArr = {Barcode128.K, 't', 't', 'p'};
        DEFAULT_SCHEME = cArr;
        _default_scheme = cArr;
    }

    protected HttpURL() {
    }

    protected static String toUserinfo(String str, String str2) throws URIException {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(20);
        BitSet bitSet = URI.allowed_within_userinfo;
        stringBuffer.append(URIUtil.encode(str, bitSet));
        if (str2 == null) {
            return stringBuffer.toString();
        }
        stringBuffer.append(ASCIIPropertyListParser.A);
        stringBuffer.append(URIUtil.encode(str2, bitSet));
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public void checkValid() throws URIException {
        if (!equals(this._scheme, DEFAULT_SCHEME) && this._scheme != null) {
            throw new URIException(1, "wrong class use");
        }
    }

    public String getEscapedPassword() {
        char[] rawPassword = getRawPassword();
        if (rawPassword == null) {
            return null;
        }
        return new String(rawPassword);
    }

    public String getEscapedUser() {
        char[] rawUser = getRawUser();
        if (rawUser == null) {
            return null;
        }
        return new String(rawUser);
    }

    public String getPassword() throws URIException {
        char[] rawPassword = getRawPassword();
        if (rawPassword == null) {
            return null;
        }
        return URI.decode(rawPassword, getProtocolCharset());
    }

    public int getPort() {
        int i2 = this._port;
        if (i2 == -1) {
            return 80;
        }
        return i2;
    }

    public char[] getRawAboveHierPath() throws URIException {
        char[] rawCurrentHierPath = getRawCurrentHierPath();
        return (rawCurrentHierPath == null || rawCurrentHierPath.length == 0) ? URI.rootPath : getRawCurrentHierPath(rawCurrentHierPath);
    }

    public char[] getRawCurrentHierPath() throws URIException {
        char[] cArr = this._path;
        return (cArr == null || cArr.length == 0) ? URI.rootPath : super.getRawCurrentHierPath(cArr);
    }

    public char[] getRawPassword() {
        int indexFirstOf = indexFirstOf(this._userinfo, (char) ASCIIPropertyListParser.A);
        if (indexFirstOf == -1) {
            return null;
        }
        char[] cArr = this._userinfo;
        int length = (cArr.length - indexFirstOf) - 1;
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, indexFirstOf + 1, cArr2, 0, length);
        return cArr2;
    }

    public char[] getRawPath() {
        char[] rawPath = super.getRawPath();
        return (rawPath == null || rawPath.length == 0) ? URI.rootPath : rawPath;
    }

    public char[] getRawScheme() {
        if (this._scheme == null) {
            return null;
        }
        return DEFAULT_SCHEME;
    }

    public char[] getRawUser() {
        char[] cArr = this._userinfo;
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        int indexFirstOf = indexFirstOf(cArr, (char) ASCIIPropertyListParser.A);
        if (indexFirstOf == -1) {
            return this._userinfo;
        }
        char[] cArr2 = new char[indexFirstOf];
        System.arraycopy(this._userinfo, 0, cArr2, 0, indexFirstOf);
        return cArr2;
    }

    public String getScheme() {
        if (this._scheme == null) {
            return null;
        }
        return new String(DEFAULT_SCHEME);
    }

    public String getUser() throws URIException {
        char[] rawUser = getRawUser();
        if (rawUser == null) {
            return null;
        }
        return URI.decode(rawUser, getProtocolCharset());
    }

    public void setEscapedPassword(String str) throws URIException {
        setRawPassword(str == null ? null : str.toCharArray());
    }

    public void setEscapedUser(String str) throws URIException, NullPointerException {
        setRawUser(str.toCharArray());
    }

    public void setEscapedUserinfo(String str, String str2) throws URIException, NullPointerException {
        setRawUserinfo(str.toCharArray(), str2 == null ? null : str2.toCharArray());
    }

    public void setPassword(String str) throws URIException {
        setRawPassword(str == null ? null : URI.encode(str, URI.allowed_within_userinfo, getProtocolCharset()));
    }

    public void setQuery(String str, String str2) throws URIException, NullPointerException {
        StringBuffer stringBuffer = new StringBuffer();
        String protocolCharset = getProtocolCharset();
        BitSet bitSet = URI.allowed_within_query;
        stringBuffer.append(URI.encode(str, bitSet, protocolCharset));
        stringBuffer.append(ASCIIPropertyListParser.f18654l);
        stringBuffer.append(URI.encode(str2, bitSet, protocolCharset));
        this._query = stringBuffer.toString().toCharArray();
        setURI();
    }

    public void setRawPassword(char[] cArr) throws URIException {
        String str;
        if (cArr != null && !validate(cArr, URI.within_userinfo)) {
            throw new URIException(3, "escaped password not valid");
        } else if (getRawUser() == null || getRawUser().length == 0) {
            throw new URIException(1, "username required");
        } else {
            String str2 = new String(getRawUser());
            String str3 = cArr == null ? null : new String(cArr);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2);
            if (str3 == null) {
                str = "";
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(":");
                stringBuffer2.append(str3);
                str = stringBuffer2.toString();
            }
            stringBuffer.append(str);
            String stringBuffer3 = stringBuffer.toString();
            String str4 = new String(getRawHost());
            if (this._port != -1) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(str4);
                stringBuffer4.append(":");
                stringBuffer4.append(this._port);
                str4 = stringBuffer4.toString();
            }
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append(stringBuffer3);
            stringBuffer5.append("@");
            stringBuffer5.append(str4);
            String stringBuffer6 = stringBuffer5.toString();
            this._userinfo = stringBuffer3.toCharArray();
            this._authority = stringBuffer6.toCharArray();
            setURI();
        }
    }

    public void setRawUser(char[] cArr) throws URIException {
        String str;
        if (cArr == null || cArr.length == 0) {
            throw new URIException(1, "user required");
        } else if (validate(cArr, URI.within_userinfo)) {
            String str2 = new String(cArr);
            char[] rawPassword = getRawPassword();
            String str3 = rawPassword == null ? null : new String(rawPassword);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2);
            if (str3 == null) {
                str = "";
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(":");
                stringBuffer2.append(str3);
                str = stringBuffer2.toString();
            }
            stringBuffer.append(str);
            String stringBuffer3 = stringBuffer.toString();
            String str4 = new String(getRawHost());
            if (this._port != -1) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(str4);
                stringBuffer4.append(":");
                stringBuffer4.append(this._port);
                str4 = stringBuffer4.toString();
            }
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append(stringBuffer3);
            stringBuffer5.append("@");
            stringBuffer5.append(str4);
            String stringBuffer6 = stringBuffer5.toString();
            this._userinfo = stringBuffer3.toCharArray();
            this._authority = stringBuffer6.toCharArray();
            setURI();
        } else {
            throw new URIException(3, "escaped user not valid");
        }
    }

    public void setRawUserinfo(char[] cArr, char[] cArr2) throws URIException {
        String str;
        if (cArr == null || cArr.length == 0) {
            throw new URIException(1, "user required");
        }
        BitSet bitSet = URI.within_userinfo;
        if (!validate(cArr, bitSet) || (cArr2 != null && !validate(cArr2, bitSet))) {
            throw new URIException(3, "escaped userinfo not valid");
        }
        String str2 = new String(cArr);
        String str3 = cArr2 == null ? null : new String(cArr2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        if (str3 == null) {
            str = "";
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(":");
            stringBuffer2.append(str3);
            str = stringBuffer2.toString();
        }
        stringBuffer.append(str);
        String stringBuffer3 = stringBuffer.toString();
        String str4 = new String(getRawHost());
        if (this._port != -1) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(str4);
            stringBuffer4.append(":");
            stringBuffer4.append(this._port);
            str4 = stringBuffer4.toString();
        }
        StringBuffer stringBuffer5 = new StringBuffer();
        stringBuffer5.append(stringBuffer3);
        stringBuffer5.append("@");
        stringBuffer5.append(str4);
        String stringBuffer6 = stringBuffer5.toString();
        this._userinfo = stringBuffer3.toCharArray();
        this._authority = stringBuffer6.toCharArray();
        setURI();
    }

    /* access modifiers changed from: protected */
    public void setURI() {
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArr = this._scheme;
        if (cArr != null) {
            stringBuffer.append(cArr);
            stringBuffer.append(ASCIIPropertyListParser.A);
        }
        if (this._is_net_path) {
            stringBuffer.append("//");
            char[] cArr2 = this._authority;
            if (cArr2 != null) {
                if (this._userinfo != null) {
                    char[] cArr3 = this._host;
                    if (cArr3 != null) {
                        stringBuffer.append(cArr3);
                        if (this._port != -1) {
                            stringBuffer.append(ASCIIPropertyListParser.A);
                            stringBuffer.append(this._port);
                        }
                    }
                } else {
                    stringBuffer.append(cArr2);
                }
            }
        }
        char[] cArr4 = this._opaque;
        if (cArr4 == null || !this._is_opaque_part) {
            char[] cArr5 = this._path;
            if (!(cArr5 == null || cArr5.length == 0)) {
                stringBuffer.append(cArr5);
            }
        } else {
            stringBuffer.append(cArr4);
        }
        if (this._query != null) {
            stringBuffer.append('?');
            stringBuffer.append(this._query);
        }
        this._uri = stringBuffer.toString().toCharArray();
        this.hash = 0;
    }

    public void setUser(String str) throws URIException, NullPointerException {
        setRawUser(URI.encode(str, URI.allowed_within_userinfo, getProtocolCharset()));
    }

    public void setUserinfo(String str, String str2) throws URIException, NullPointerException {
        String protocolCharset = getProtocolCharset();
        BitSet bitSet = URI.within_userinfo;
        setRawUserinfo(URI.encode(str, bitSet, protocolCharset), str2 == null ? null : URI.encode(str2, bitSet, protocolCharset));
    }

    public HttpURL(String str) throws URIException {
        parseUriReference(str, false);
        checkValid();
    }

    public void setQuery(String[] strArr, String[] strArr2) throws URIException, NullPointerException {
        int length = strArr.length;
        if (length == strArr2.length) {
            StringBuffer stringBuffer = new StringBuffer();
            String protocolCharset = getProtocolCharset();
            int i2 = 0;
            while (i2 < length) {
                String str = strArr[i2];
                BitSet bitSet = URI.allowed_within_query;
                stringBuffer.append(URI.encode(str, bitSet, protocolCharset));
                stringBuffer.append(ASCIIPropertyListParser.f18654l);
                stringBuffer.append(URI.encode(strArr2[i2], bitSet, protocolCharset));
                i2++;
                if (i2 < length) {
                    stringBuffer.append(Typography.f29117d);
                }
            }
            this._query = stringBuffer.toString().toCharArray();
            setURI();
            return;
        }
        throw new URIException("wrong array size of query");
    }

    public HttpURL(String str, int i2, String str2) throws URIException {
        this((String) null, (String) null, str, i2, str2, (String) null, (String) null);
    }

    public HttpURL(String str, int i2, String str2, String str3) throws URIException {
        this((String) null, (String) null, str, i2, str2, str3, (String) null);
    }

    public HttpURL(String str, String str2) throws URIException {
        this.protocolCharset = str2;
        parseUriReference(str, false);
        checkValid();
    }

    public HttpURL(String str, String str2, int i2, String str3) throws URIException {
        this(str, str2, i2, str3, (String) null, (String) null);
    }

    public HttpURL(String str, String str2, int i2, String str3, String str4) throws URIException {
        this(str, str2, i2, str3, str4, (String) null);
    }

    public HttpURL(String str, String str2, int i2, String str3, String str4, String str5) throws URIException {
        StringBuffer stringBuffer = new StringBuffer();
        if (!(str == null && str2 == null && i2 == -1)) {
            this._scheme = DEFAULT_SCHEME;
            stringBuffer.append(_default_scheme);
            stringBuffer.append("://");
            if (str != null) {
                stringBuffer.append(str);
                stringBuffer.append('@');
            }
            if (str2 != null) {
                stringBuffer.append(URIUtil.encode(str2, URI.allowed_host));
                if (!(i2 == -1 && i2 == 80)) {
                    stringBuffer.append(ASCIIPropertyListParser.A);
                    stringBuffer.append(i2);
                }
            }
        }
        if (str3 != null) {
            if (URI.scheme == null || str3.startsWith("/")) {
                stringBuffer.append(URIUtil.encode(str3, URI.allowed_abs_path));
            } else {
                throw new URIException(1, "abs_path requested");
            }
        }
        if (str4 != null) {
            stringBuffer.append('?');
            stringBuffer.append(URIUtil.encode(str4, URI.allowed_query));
        }
        if (str5 != null) {
            stringBuffer.append('#');
            stringBuffer.append(URIUtil.encode(str5, URI.allowed_fragment));
        }
        parseUriReference(stringBuffer.toString(), true);
        checkValid();
    }

    public HttpURL(String str, String str2, String str3) throws URIException {
        this(str, str2, str3, -1, (String) null, (String) null, (String) null);
    }

    public HttpURL(String str, String str2, String str3, int i2) throws URIException {
        this(str, str2, str3, i2, (String) null, (String) null, (String) null);
    }

    public HttpURL(String str, String str2, String str3, int i2, String str4) throws URIException {
        this(str, str2, str3, i2, str4, (String) null, (String) null);
    }

    public HttpURL(String str, String str2, String str3, int i2, String str4, String str5) throws URIException {
        this(str, str2, str3, i2, str4, str5, (String) null);
    }

    public HttpURL(String str, String str2, String str3, int i2, String str4, String str5, String str6) throws URIException {
        this(toUserinfo(str, str2), str3, i2, str4, str5, str6);
    }

    public HttpURL(String str, String str2, String str3, String str4) throws URIException {
        this((String) null, (String) null, str, -1, str2, str3, str4);
    }

    public HttpURL(String str, String str2, String str3, String str4, String str5) throws URIException {
        this(str, str2, -1, str3, str4, str5);
    }

    public HttpURL(HttpURL httpURL, String str) throws URIException {
        this(httpURL, new HttpURL(str));
    }

    public HttpURL(HttpURL httpURL, HttpURL httpURL2) throws URIException {
        super((URI) httpURL, (URI) httpURL2);
        checkValid();
    }

    public HttpURL(char[] cArr) throws URIException, NullPointerException {
        parseUriReference(new String(cArr), true);
        checkValid();
    }

    public HttpURL(char[] cArr, String str) throws URIException, NullPointerException {
        this.protocolCharset = str;
        parseUriReference(new String(cArr), true);
        checkValid();
    }
}
