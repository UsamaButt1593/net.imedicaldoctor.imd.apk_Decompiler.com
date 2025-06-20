package org.apache.commons.httpclient.cookie;

import com.google.common.net.HttpHeaders;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.util.DateParseException;
import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CookieSpecBase implements CookieSpec {
    protected static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$cookie$CookieSpec;
    private Collection datepatterns = null;

    static {
        Class cls = class$org$apache$commons$httpclient$cookie$CookieSpec;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.cookie.CookieSpec");
            class$org$apache$commons$httpclient$cookie$CookieSpec = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    private static void addInPathOrder(List list, Cookie cookie) {
        int i2 = 0;
        while (i2 < list.size() && cookie.compare(cookie, (Cookie) list.get(i2)) <= 0) {
            i2++;
        }
        list.add(i2, cookie);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public boolean domainMatch(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str2.startsWith(".")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(".");
            stringBuffer.append(str2);
            str2 = stringBuffer.toString();
        }
        return str.endsWith(str2) || str.equals(str2.substring(1));
    }

    public String formatCookie(Cookie cookie) {
        LOG.trace("enter CookieSpecBase.formatCookie(Cookie)");
        if (cookie != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(cookie.getName());
            stringBuffer.append("=");
            String value = cookie.getValue();
            if (value != null) {
                stringBuffer.append(value);
            }
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException("Cookie may not be null");
    }

    public Header formatCookieHeader(Cookie cookie) {
        LOG.trace("enter CookieSpecBase.formatCookieHeader(Cookie)");
        return new Header(HttpHeaders.p, formatCookie(cookie));
    }

    public String formatCookies(Cookie[] cookieArr) throws IllegalArgumentException {
        LOG.trace("enter CookieSpecBase.formatCookies(Cookie[])");
        if (cookieArr == null) {
            throw new IllegalArgumentException("Cookie array may not be null");
        } else if (cookieArr.length != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < cookieArr.length; i2++) {
                if (i2 > 0) {
                    stringBuffer.append("; ");
                }
                stringBuffer.append(formatCookie(cookieArr[i2]));
            }
            return stringBuffer.toString();
        } else {
            throw new IllegalArgumentException("Cookie array may not be empty");
        }
    }

    public Collection getValidDateFormats() {
        return this.datepatterns;
    }

    public boolean match(String str, int i2, String str2, boolean z, Cookie cookie) {
        String str3;
        Log log = LOG;
        log.trace("enter CookieSpecBase.match(String, int, String, boolean, Cookie");
        if (str == null) {
            throw new IllegalArgumentException("Host of origin may not be null");
        } else if (str.trim().equals("")) {
            throw new IllegalArgumentException("Host of origin may not be blank");
        } else if (i2 < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid port: ");
            stringBuffer.append(i2);
            throw new IllegalArgumentException(stringBuffer.toString());
        } else if (str2 == null) {
            throw new IllegalArgumentException("Path of origin may not be null.");
        } else if (cookie != null) {
            if (str2.trim().equals("")) {
                str2 = "/";
            }
            String lowerCase = str.toLowerCase();
            if (cookie.getDomain() == null) {
                str3 = "Invalid cookie state: domain not specified";
            } else if (cookie.getPath() == null) {
                str3 = "Invalid cookie state: path not specified";
            } else if ((cookie.getExpiryDate() == null || cookie.getExpiryDate().after(new Date())) && domainMatch(lowerCase, cookie.getDomain()) && pathMatch(str2, cookie.getPath())) {
                return !cookie.getSecure() || z;
            } else {
                return false;
            }
            log.warn(str3);
            return false;
        } else {
            throw new IllegalArgumentException("Cookie may not be null");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.commons.httpclient.Cookie[] parse(java.lang.String r11, int r12, java.lang.String r13, boolean r14, java.lang.String r15) throws org.apache.commons.httpclient.cookie.MalformedCookieException {
        /*
            r10 = this;
            org.apache.commons.logging.Log r14 = LOG
            java.lang.String r0 = "enter CookieSpecBase.parse(String, port, path, boolean, Header)"
            r14.trace(r0)
            if (r11 == 0) goto L_0x00e2
            java.lang.String r14 = r11.trim()
            java.lang.String r0 = ""
            boolean r14 = r14.equals(r0)
            if (r14 != 0) goto L_0x00da
            if (r12 < 0) goto L_0x00c3
            if (r13 == 0) goto L_0x00bb
            if (r15 == 0) goto L_0x00b3
            java.lang.String r12 = r13.trim()
            boolean r12 = r12.equals(r0)
            java.lang.String r14 = "/"
            if (r12 == 0) goto L_0x0028
            r13 = r14
        L_0x0028:
            java.lang.String r11 = r11.toLowerCase()
            int r12 = r13.lastIndexOf(r14)
            r14 = 0
            r0 = 1
            if (r12 < 0) goto L_0x003b
            if (r12 != 0) goto L_0x0037
            r12 = 1
        L_0x0037:
            java.lang.String r13 = r13.substring(r14, r12)
        L_0x003b:
            java.lang.String r12 = r15.toLowerCase()
            java.lang.String r1 = "expires="
            int r12 = r12.indexOf(r1)
            r1 = -1
            if (r12 == r1) goto L_0x006d
            int r12 = r12 + 8
            java.lang.String r2 = ";"
            int r2 = r15.indexOf(r2, r12)
            if (r2 != r1) goto L_0x0056
            int r2 = r15.length()
        L_0x0056:
            java.lang.String r12 = r15.substring(r12, r2)     // Catch:{ DateParseException -> 0x006d }
            java.util.Collection r1 = r10.datepatterns     // Catch:{ DateParseException -> 0x006d }
            org.apache.commons.httpclient.util.DateUtil.parseDate(r12, r1)     // Catch:{ DateParseException -> 0x006d }
            org.apache.commons.httpclient.HeaderElement[] r12 = new org.apache.commons.httpclient.HeaderElement[r0]
            org.apache.commons.httpclient.HeaderElement r0 = new org.apache.commons.httpclient.HeaderElement
            char[] r15 = r15.toCharArray()
            r0.<init>(r15)
            r12[r14] = r0
            goto L_0x0075
        L_0x006d:
            char[] r12 = r15.toCharArray()
            org.apache.commons.httpclient.HeaderElement[] r12 = org.apache.commons.httpclient.HeaderElement.parseElements((char[]) r12)
        L_0x0075:
            int r15 = r12.length
            org.apache.commons.httpclient.Cookie[] r15 = new org.apache.commons.httpclient.Cookie[r15]
            r7 = 0
        L_0x0079:
            int r0 = r12.length
            if (r7 >= r0) goto L_0x00b2
            r8 = r12[r7]
            org.apache.commons.httpclient.Cookie r9 = new org.apache.commons.httpclient.Cookie     // Catch:{ IllegalArgumentException -> 0x00a7 }
            java.lang.String r2 = r8.getName()     // Catch:{ IllegalArgumentException -> 0x00a7 }
            java.lang.String r3 = r8.getValue()     // Catch:{ IllegalArgumentException -> 0x00a7 }
            r5 = 0
            r6 = 0
            r0 = r9
            r1 = r11
            r4 = r13
            r0.<init>((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.util.Date) r5, (boolean) r6)     // Catch:{ IllegalArgumentException -> 0x00a7 }
            org.apache.commons.httpclient.NameValuePair[] r0 = r8.getParameters()
            if (r0 == 0) goto L_0x00a2
            r1 = 0
        L_0x0097:
            int r2 = r0.length
            if (r1 >= r2) goto L_0x00a2
            r2 = r0[r1]
            r10.parseAttribute(r2, r9)
            int r1 = r1 + 1
            goto L_0x0097
        L_0x00a2:
            r15[r7] = r9
            int r7 = r7 + 1
            goto L_0x0079
        L_0x00a7:
            r11 = move-exception
            org.apache.commons.httpclient.cookie.MalformedCookieException r12 = new org.apache.commons.httpclient.cookie.MalformedCookieException
            java.lang.String r11 = r11.getMessage()
            r12.<init>(r11)
            throw r12
        L_0x00b2:
            return r15
        L_0x00b3:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Header may not be null."
            r11.<init>(r12)
            throw r11
        L_0x00bb:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Path of origin may not be null."
            r11.<init>(r12)
            throw r11
        L_0x00c3:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.StringBuffer r13 = new java.lang.StringBuffer
            r13.<init>()
            java.lang.String r14 = "Invalid port: "
            r13.append(r14)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            r11.<init>(r12)
            throw r11
        L_0x00da:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Host of origin may not be blank"
            r11.<init>(r12)
            throw r11
        L_0x00e2:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Host of origin may not be null"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.cookie.CookieSpecBase.parse(java.lang.String, int, java.lang.String, boolean, java.lang.String):org.apache.commons.httpclient.Cookie[]");
    }

    public void parseAttribute(NameValuePair nameValuePair, Cookie cookie) throws MalformedCookieException {
        if (nameValuePair == null) {
            throw new IllegalArgumentException("Attribute may not be null.");
        } else if (cookie != null) {
            String lowerCase = nameValuePair.getName().toLowerCase();
            String value = nameValuePair.getValue();
            if (lowerCase.equals(Cookie2.PATH)) {
                if (value == null || value.trim().equals("")) {
                    value = "/";
                }
                cookie.setPath(value);
                cookie.setPathAttributeSpecified(true);
            } else if (lowerCase.equals(Cookie2.DOMAIN)) {
                if (value == null) {
                    throw new MalformedCookieException("Missing value for domain attribute");
                } else if (!value.trim().equals("")) {
                    cookie.setDomain(value);
                    cookie.setDomainAttributeSpecified(true);
                } else {
                    throw new MalformedCookieException("Blank value for domain attribute");
                }
            } else if (lowerCase.equals(Cookie2.MAXAGE)) {
                if (value != null) {
                    try {
                        cookie.setExpiryDate(new Date(System.currentTimeMillis() + (((long) Integer.parseInt(value)) * 1000)));
                    } catch (NumberFormatException e2) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Invalid max-age attribute: ");
                        stringBuffer.append(e2.getMessage());
                        throw new MalformedCookieException(stringBuffer.toString());
                    }
                } else {
                    throw new MalformedCookieException("Missing value for max-age attribute");
                }
            } else if (lowerCase.equals(Cookie2.SECURE)) {
                cookie.setSecure(true);
            } else if (lowerCase.equals(Cookie2.COMMENT)) {
                cookie.setComment(value);
            } else if (!lowerCase.equals("expires")) {
                Log log = LOG;
                if (log.isDebugEnabled()) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Unrecognized cookie attribute: ");
                    stringBuffer2.append(nameValuePair.toString());
                    log.debug(stringBuffer2.toString());
                }
            } else if (value != null) {
                try {
                    cookie.setExpiryDate(DateUtil.parseDate(value, this.datepatterns));
                } catch (DateParseException e3) {
                    LOG.debug("Error parsing cookie date", e3);
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Unable to parse expiration date parameter: ");
                    stringBuffer3.append(value);
                    throw new MalformedCookieException(stringBuffer3.toString());
                }
            } else {
                throw new MalformedCookieException("Missing value for expires attribute");
            }
        } else {
            throw new IllegalArgumentException("Cookie may not be null.");
        }
    }

    public boolean pathMatch(String str, String str2) {
        boolean startsWith = str.startsWith(str2);
        return (!startsWith || str.length() == str2.length() || str2.endsWith("/")) ? startsWith : str.charAt(str2.length()) == CookieSpec.PATH_DELIM_CHAR;
    }

    public void setValidDateFormats(Collection collection) {
        this.datepatterns = collection;
    }

    public void validate(String str, int i2, String str2, boolean z, Cookie cookie) throws MalformedCookieException {
        LOG.trace("enter CookieSpecBase.validate(String, port, path, boolean, Cookie)");
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
            if (str2.trim().equals("")) {
                str2 = "/";
            }
            String lowerCase = str.toLowerCase();
            if (cookie.getVersion() >= 0) {
                if (lowerCase.indexOf(".") >= 0) {
                    if (!lowerCase.endsWith(cookie.getDomain())) {
                        String domain = cookie.getDomain();
                        if (domain.startsWith(".")) {
                            domain = domain.substring(1, domain.length());
                        }
                        if (!lowerCase.equals(domain)) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("Illegal domain attribute \"");
                            stringBuffer2.append(cookie.getDomain());
                            stringBuffer2.append("\". Domain of origin: \"");
                            stringBuffer2.append(lowerCase);
                            stringBuffer2.append("\"");
                            throw new MalformedCookieException(stringBuffer2.toString());
                        }
                    }
                } else if (!lowerCase.equals(cookie.getDomain())) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Illegal domain attribute \"");
                    stringBuffer3.append(cookie.getDomain());
                    stringBuffer3.append("\". Domain of origin: \"");
                    stringBuffer3.append(lowerCase);
                    stringBuffer3.append("\"");
                    throw new MalformedCookieException(stringBuffer3.toString());
                }
                if (!str2.startsWith(cookie.getPath())) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("Illegal path attribute \"");
                    stringBuffer4.append(cookie.getPath());
                    stringBuffer4.append("\". Path of origin: \"");
                    stringBuffer4.append(str2);
                    stringBuffer4.append("\"");
                    throw new MalformedCookieException(stringBuffer4.toString());
                }
                return;
            }
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Illegal version number ");
            stringBuffer5.append(cookie.getValue());
            throw new MalformedCookieException(stringBuffer5.toString());
        } else {
            throw new IllegalArgumentException("Path of origin may not be null.");
        }
    }

    public Header formatCookieHeader(Cookie[] cookieArr) {
        LOG.trace("enter CookieSpecBase.formatCookieHeader(Cookie[])");
        return new Header(HttpHeaders.p, formatCookies(cookieArr));
    }

    public Cookie[] match(String str, int i2, String str2, boolean z, Cookie[] cookieArr) {
        LOG.trace("enter CookieSpecBase.match(String, int, String, boolean, Cookie[])");
        if (cookieArr == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < cookieArr.length; i3++) {
            if (match(str, i2, str2, z, cookieArr[i3])) {
                addInPathOrder(linkedList, cookieArr[i3]);
            }
        }
        return (Cookie[]) linkedList.toArray(new Cookie[linkedList.size()]);
    }

    public Cookie[] parse(String str, int i2, String str2, boolean z, Header header) throws MalformedCookieException {
        LOG.trace("enter CookieSpecBase.parse(String, port, path, boolean, String)");
        if (header != null) {
            return parse(str, i2, str2, z, header.getValue());
        }
        throw new IllegalArgumentException("Header may not be null.");
    }
}
