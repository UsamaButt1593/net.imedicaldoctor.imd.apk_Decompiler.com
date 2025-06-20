package org.apache.commons.httpclient.auth;

import com.dd.plist.ASCIIPropertyListParser;
import org.apache.commons.httpclient.util.LangUtils;

public class AuthScope {
    public static final AuthScope ANY = new AuthScope((String) null, -1, (String) null, (String) null);
    public static final String ANY_HOST = null;
    public static final int ANY_PORT = -1;
    public static final String ANY_REALM = null;
    public static final String ANY_SCHEME = null;
    private String host;
    private int port;
    private String realm;
    private String scheme;

    public AuthScope(String str, int i2) {
        this(str, i2, ANY_REALM, ANY_SCHEME);
    }

    private static boolean paramsEqual(int i2, int i3) {
        return i2 == i3;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthScope)) {
            return super.equals(obj);
        }
        AuthScope authScope = (AuthScope) obj;
        return paramsEqual(this.host, authScope.host) && paramsEqual(this.port, authScope.port) && paramsEqual(this.realm, authScope.realm) && paramsEqual(this.scheme, authScope.scheme);
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getRealm() {
        return this.realm;
    }

    public String getScheme() {
        return this.scheme;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, (Object) this.host), this.port), (Object) this.realm), (Object) this.scheme);
    }

    public int match(AuthScope authScope) {
        int i2;
        if (paramsEqual(this.scheme, authScope.scheme)) {
            i2 = 1;
        } else {
            String str = this.scheme;
            String str2 = ANY_SCHEME;
            if (str != str2 && authScope.scheme != str2) {
                return -1;
            }
            i2 = 0;
        }
        if (paramsEqual(this.realm, authScope.realm)) {
            i2 += 2;
        } else {
            String str3 = this.realm;
            String str4 = ANY_REALM;
            if (!(str3 == str4 || authScope.realm == str4)) {
                return -1;
            }
        }
        if (paramsEqual(this.port, authScope.port)) {
            i2 += 4;
        } else if (!(this.port == -1 || authScope.port == -1)) {
            return -1;
        }
        if (paramsEqual(this.host, authScope.host)) {
            return i2 + 8;
        }
        String str5 = this.host;
        String str6 = ANY_HOST;
        if (str5 == str6 || authScope.host == str6) {
            return i2;
        }
        return -1;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String str = this.scheme;
        if (str != null) {
            stringBuffer.append(str.toUpperCase());
            stringBuffer.append(' ');
        }
        if (this.realm != null) {
            stringBuffer.append('\'');
            stringBuffer.append(this.realm);
            stringBuffer.append('\'');
        } else {
            stringBuffer.append("<any realm>");
        }
        if (this.host != null) {
            stringBuffer.append('@');
            stringBuffer.append(this.host);
            if (this.port >= 0) {
                stringBuffer.append(ASCIIPropertyListParser.A);
                stringBuffer.append(this.port);
            }
        }
        return stringBuffer.toString();
    }

    public AuthScope(String str, int i2, String str2) {
        this(str, i2, str2, ANY_SCHEME);
    }

    private static boolean paramsEqual(String str, String str2) {
        if (str == null) {
            return str == str2;
        }
        return str.equals(str2);
    }

    public AuthScope(String str, int i2, String str2, String str3) {
        this.scheme = null;
        this.realm = null;
        this.host = null;
        this.port = -1;
        this.host = str == null ? ANY_HOST : str.toLowerCase();
        this.port = i2 < 0 ? -1 : i2;
        this.realm = str2 == null ? ANY_REALM : str2;
        this.scheme = str3 == null ? ANY_SCHEME : str3.toUpperCase();
    }

    public AuthScope(AuthScope authScope) {
        this.scheme = null;
        this.realm = null;
        this.host = null;
        this.port = -1;
        if (authScope != null) {
            this.host = authScope.getHost();
            this.port = authScope.getPort();
            this.realm = authScope.getRealm();
            this.scheme = authScope.getScheme();
            return;
        }
        throw new IllegalArgumentException("Scope may not be null");
    }
}
