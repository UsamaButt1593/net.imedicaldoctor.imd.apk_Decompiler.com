package org.apache.commons.httpclient.cookie;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.util.ParameterFormatter;

public class RFC2109Spec extends CookieSpecBase {
    public static final String SET_COOKIE_KEY = "set-cookie";
    private final ParameterFormatter formatter;

    public RFC2109Spec() {
        ParameterFormatter parameterFormatter = new ParameterFormatter();
        this.formatter = parameterFormatter;
        parameterFormatter.setAlwaysUseQuotes(true);
    }

    private void formatCookieAsVer(StringBuffer stringBuffer, Cookie cookie, int i2) {
        String value = cookie.getValue();
        if (value == null) {
            value = "";
        }
        formatParam(stringBuffer, new NameValuePair(cookie.getName(), value), i2);
        if (cookie.getPath() != null && cookie.isPathAttributeSpecified()) {
            stringBuffer.append("; ");
            formatParam(stringBuffer, new NameValuePair("$Path", cookie.getPath()), i2);
        }
        if (cookie.getDomain() != null && cookie.isDomainAttributeSpecified()) {
            stringBuffer.append("; ");
            formatParam(stringBuffer, new NameValuePair("$Domain", cookie.getDomain()), i2);
        }
    }

    private void formatParam(StringBuffer stringBuffer, NameValuePair nameValuePair, int i2) {
        if (i2 < 1) {
            stringBuffer.append(nameValuePair.getName());
            stringBuffer.append("=");
            if (nameValuePair.getValue() != null) {
                stringBuffer.append(nameValuePair.getValue());
                return;
            }
            return;
        }
        this.formatter.format(stringBuffer, nameValuePair);
    }

    public boolean domainMatch(String str, String str2) {
        return str.equals(str2) || (str2.startsWith(".") && str.endsWith(str2));
    }

    public String formatCookie(Cookie cookie) {
        CookieSpecBase.LOG.trace("enter RFC2109Spec.formatCookie(Cookie)");
        if (cookie != null) {
            int version = cookie.getVersion();
            StringBuffer stringBuffer = new StringBuffer();
            formatParam(stringBuffer, new NameValuePair("$Version", Integer.toString(version)), version);
            stringBuffer.append("; ");
            formatCookieAsVer(stringBuffer, cookie, version);
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException("Cookie may not be null");
    }

    public String formatCookies(Cookie[] cookieArr) {
        CookieSpecBase.LOG.trace("enter RFC2109Spec.formatCookieHeader(Cookie[])");
        int i2 = Integer.MAX_VALUE;
        for (Cookie cookie : cookieArr) {
            if (cookie.getVersion() < i2) {
                i2 = cookie.getVersion();
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        formatParam(stringBuffer, new NameValuePair("$Version", Integer.toString(i2)), i2);
        for (Cookie formatCookieAsVer : cookieArr) {
            stringBuffer.append("; ");
            formatCookieAsVer(stringBuffer, formatCookieAsVer, i2);
        }
        return stringBuffer.toString();
    }

    public void parseAttribute(NameValuePair nameValuePair, Cookie cookie) throws MalformedCookieException {
        if (nameValuePair == null) {
            throw new IllegalArgumentException("Attribute may not be null.");
        } else if (cookie != null) {
            String lowerCase = nameValuePair.getName().toLowerCase();
            String value = nameValuePair.getValue();
            if (lowerCase.equals(Cookie2.PATH)) {
                if (value == null) {
                    throw new MalformedCookieException("Missing value for path attribute");
                } else if (!value.trim().equals("")) {
                    cookie.setPath(value);
                    cookie.setPathAttributeSpecified(true);
                } else {
                    throw new MalformedCookieException("Blank value for path attribute");
                }
            } else if (!lowerCase.equals("version")) {
                super.parseAttribute(nameValuePair, cookie);
            } else if (value != null) {
                try {
                    cookie.setVersion(Integer.parseInt(value));
                } catch (NumberFormatException e2) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Invalid version: ");
                    stringBuffer.append(e2.getMessage());
                    throw new MalformedCookieException(stringBuffer.toString());
                }
            } else {
                throw new MalformedCookieException("Missing value for version attribute");
            }
        } else {
            throw new IllegalArgumentException("Cookie may not be null.");
        }
    }

    public void validate(String str, int i2, String str2, boolean z, Cookie cookie) throws MalformedCookieException {
        CookieSpecBase.LOG.trace("enter RFC2109Spec.validate(String, int, String, boolean, Cookie)");
        super.validate(str, i2, str2, z, cookie);
        if (cookie.getName().indexOf(32) != -1) {
            throw new MalformedCookieException("Cookie name may not contain blanks");
        } else if (cookie.getName().startsWith("$")) {
            throw new MalformedCookieException("Cookie name may not start with $");
        } else if (cookie.isDomainAttributeSpecified() && !cookie.getDomain().equals(str)) {
            if (cookie.getDomain().startsWith(".")) {
                int indexOf = cookie.getDomain().indexOf(46, 1);
                if (indexOf < 0 || indexOf == cookie.getDomain().length() - 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Domain attribute \"");
                    stringBuffer.append(cookie.getDomain());
                    stringBuffer.append("\" violates RFC 2109: domain must contain an embedded dot");
                    throw new MalformedCookieException(stringBuffer.toString());
                }
                String lowerCase = str.toLowerCase();
                if (!lowerCase.endsWith(cookie.getDomain())) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Illegal domain attribute \"");
                    stringBuffer2.append(cookie.getDomain());
                    stringBuffer2.append("\". Domain of origin: \"");
                    stringBuffer2.append(lowerCase);
                    stringBuffer2.append("\"");
                    throw new MalformedCookieException(stringBuffer2.toString());
                } else if (lowerCase.substring(0, lowerCase.length() - cookie.getDomain().length()).indexOf(46) != -1) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Domain attribute \"");
                    stringBuffer3.append(cookie.getDomain());
                    stringBuffer3.append("\" violates RFC 2109: host minus domain may not contain any dots");
                    throw new MalformedCookieException(stringBuffer3.toString());
                }
            } else {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Domain attribute \"");
                stringBuffer4.append(cookie.getDomain());
                stringBuffer4.append("\" violates RFC 2109: domain must start with a dot");
                throw new MalformedCookieException(stringBuffer4.toString());
            }
        }
    }
}
