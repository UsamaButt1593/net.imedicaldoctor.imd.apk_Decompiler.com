package org.apache.commons.httpclient;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.pdf.Barcode128;
import org.apache.commons.httpclient.util.URIUtil;

public class HttpsURL extends HttpURL {
    public static final int DEFAULT_PORT = 443;
    public static final char[] DEFAULT_SCHEME;
    public static final int _default_port = 443;
    public static final char[] _default_scheme;
    static final long serialVersionUID = 887844277028676648L;

    static {
        char[] cArr = {Barcode128.K, 't', 't', 'p', 's'};
        DEFAULT_SCHEME = cArr;
        _default_scheme = cArr;
    }

    protected HttpsURL() {
    }

    /* access modifiers changed from: protected */
    public void checkValid() throws URIException {
        if (!equals(this._scheme, DEFAULT_SCHEME) && this._scheme != null) {
            throw new URIException(1, "wrong class use");
        }
    }

    public int getPort() {
        int i2 = this._port;
        if (i2 == -1) {
            return 443;
        }
        return i2;
    }

    public char[] getRawScheme() {
        if (this._scheme == null) {
            return null;
        }
        return DEFAULT_SCHEME;
    }

    public String getScheme() {
        if (this._scheme == null) {
            return null;
        }
        return new String(DEFAULT_SCHEME);
    }

    public HttpsURL(String str) throws URIException {
        parseUriReference(str, false);
        checkValid();
    }

    public HttpsURL(String str, int i2, String str2) throws URIException {
        this((String) null, str, i2, str2, (String) null, (String) null);
    }

    public HttpsURL(String str, int i2, String str2, String str3) throws URIException {
        this((String) null, str, i2, str2, str3, (String) null);
    }

    public HttpsURL(String str, String str2) throws URIException {
        this.protocolCharset = str2;
        parseUriReference(str, false);
        checkValid();
    }

    public HttpsURL(String str, String str2, int i2, String str3) throws URIException {
        this(str, str2, i2, str3, (String) null, (String) null);
    }

    public HttpsURL(String str, String str2, int i2, String str3, String str4) throws URIException {
        this(str, str2, i2, str3, str4, (String) null);
    }

    public HttpsURL(String str, String str2, int i2, String str3, String str4, String str5) throws URIException {
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
                if (!(i2 == -1 && i2 == 443)) {
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

    public HttpsURL(String str, String str2, String str3) throws URIException {
        this(str, str2, str3, -1, (String) null, (String) null, (String) null);
    }

    public HttpsURL(String str, String str2, String str3, int i2) throws URIException {
        this(str, str2, str3, i2, (String) null, (String) null, (String) null);
    }

    public HttpsURL(String str, String str2, String str3, int i2, String str4) throws URIException {
        this(str, str2, str3, i2, str4, (String) null, (String) null);
    }

    public HttpsURL(String str, String str2, String str3, int i2, String str4, String str5) throws URIException {
        this(str, str2, str3, i2, str4, str5, (String) null);
    }

    public HttpsURL(String str, String str2, String str3, int i2, String str4, String str5, String str6) throws URIException {
        this(HttpURL.toUserinfo(str, str2), str3, i2, str4, str5, str6);
    }

    public HttpsURL(String str, String str2, String str3, String str4) throws URIException {
        this((String) null, str, -1, str2, str3, str4);
    }

    public HttpsURL(String str, String str2, String str3, String str4, String str5) throws URIException {
        this(str, str2, -1, str3, str4, str5);
    }

    public HttpsURL(HttpsURL httpsURL, String str) throws URIException {
        this(httpsURL, new HttpsURL(str));
    }

    public HttpsURL(HttpsURL httpsURL, HttpsURL httpsURL2) throws URIException {
        super((HttpURL) httpsURL, (HttpURL) httpsURL2);
        checkValid();
    }

    public HttpsURL(char[] cArr) throws URIException, NullPointerException {
        parseUriReference(new String(cArr), true);
        checkValid();
    }

    public HttpsURL(char[] cArr, String str) throws URIException, NullPointerException {
        this.protocolCharset = str;
        parseUriReference(new String(cArr), true);
        checkValid();
    }
}
