package org.apache.commons.httpclient.cookie;

import java.util.Collection;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.NameValuePair;

public class IgnoreCookiesSpec implements CookieSpec {
    public boolean domainMatch(String str, String str2) {
        return false;
    }

    public String formatCookie(Cookie cookie) {
        return null;
    }

    public Header formatCookieHeader(Cookie cookie) throws IllegalArgumentException {
        return null;
    }

    public String formatCookies(Cookie[] cookieArr) throws IllegalArgumentException {
        return null;
    }

    public Collection getValidDateFormats() {
        return null;
    }

    public boolean match(String str, int i2, String str2, boolean z, Cookie cookie) {
        return false;
    }

    public Cookie[] parse(String str, int i2, String str2, boolean z, String str3) throws MalformedCookieException {
        return new Cookie[0];
    }

    public void parseAttribute(NameValuePair nameValuePair, Cookie cookie) throws MalformedCookieException, IllegalArgumentException {
    }

    public boolean pathMatch(String str, String str2) {
        return false;
    }

    public void setValidDateFormats(Collection collection) {
    }

    public void validate(String str, int i2, String str2, boolean z, Cookie cookie) throws MalformedCookieException, IllegalArgumentException {
    }

    public Header formatCookieHeader(Cookie[] cookieArr) throws IllegalArgumentException {
        return null;
    }

    public Cookie[] match(String str, int i2, String str2, boolean z, Cookie[] cookieArr) {
        return new Cookie[0];
    }

    public Cookie[] parse(String str, int i2, String str2, boolean z, Header header) throws MalformedCookieException, IllegalArgumentException {
        return new Cookie[0];
    }
}
