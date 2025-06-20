package org.apache.commons.httpclient.cookie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HeaderElement;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.util.ParameterFormatter;
import org.apache.commons.logging.Log;

public class RFC2965Spec extends CookieSpecBase implements CookieVersionSupport {
    private static final Comparator PATH_COMPOARATOR = new CookiePathComparator();
    public static final String SET_COOKIE2_KEY = "set-cookie2";
    private final List attribHandlerList = new ArrayList(10);
    private final Map attribHandlerMap = new HashMap(10);
    private final ParameterFormatter formatter;
    private final CookieSpec rfc2109 = new RFC2109Spec();

    private class Cookie2DomainAttributeHandler implements CookieAttributeHandler {
        private Cookie2DomainAttributeHandler() {
        }

        public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
            if (cookie == null) {
                throw new IllegalArgumentException("Cookie may not be null");
            } else if (cookieOrigin != null) {
                String lowerCase = cookieOrigin.getHost().toLowerCase();
                String domain = cookie.getDomain();
                return RFC2965Spec.this.domainMatch(lowerCase, domain) && lowerCase.substring(0, lowerCase.length() - domain.length()).indexOf(46) == -1;
            } else {
                throw new IllegalArgumentException("Cookie origin may not be null");
            }
        }

        public void parse(Cookie cookie, String str) throws MalformedCookieException {
            if (cookie == null) {
                throw new IllegalArgumentException("Cookie may not be null");
            } else if (str == null) {
                throw new MalformedCookieException("Missing value for domain attribute");
            } else if (!str.trim().equals("")) {
                String lowerCase = str.toLowerCase();
                if (!lowerCase.startsWith(".")) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(".");
                    stringBuffer.append(lowerCase);
                    lowerCase = stringBuffer.toString();
                }
                cookie.setDomain(lowerCase);
                cookie.setDomainAttributeSpecified(true);
            } else {
                throw new MalformedCookieException("Blank value for domain attribute");
            }
        }

        public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
            if (cookie == null) {
                throw new IllegalArgumentException("Cookie may not be null");
            } else if (cookieOrigin != null) {
                String lowerCase = cookieOrigin.getHost().toLowerCase();
                if (cookie.getDomain() != null) {
                    String lowerCase2 = cookie.getDomain().toLowerCase();
                    if (cookie.isDomainAttributeSpecified()) {
                        if (lowerCase2.startsWith(".")) {
                            int indexOf = lowerCase2.indexOf(46, 1);
                            if ((indexOf < 0 || indexOf == lowerCase2.length() - 1) && !lowerCase2.equals(".local")) {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("Domain attribute \"");
                                stringBuffer.append(cookie.getDomain());
                                stringBuffer.append("\" violates RFC 2965: the value contains no embedded dots ");
                                stringBuffer.append("and the value is not .local");
                                throw new MalformedCookieException(stringBuffer.toString());
                            } else if (!RFC2965Spec.this.domainMatch(lowerCase, lowerCase2)) {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("Domain attribute \"");
                                stringBuffer2.append(cookie.getDomain());
                                stringBuffer2.append("\" violates RFC 2965: effective host name does not ");
                                stringBuffer2.append("domain-match domain attribute.");
                                throw new MalformedCookieException(stringBuffer2.toString());
                            } else if (lowerCase.substring(0, lowerCase.length() - lowerCase2.length()).indexOf(46) != -1) {
                                StringBuffer stringBuffer3 = new StringBuffer();
                                stringBuffer3.append("Domain attribute \"");
                                stringBuffer3.append(cookie.getDomain());
                                stringBuffer3.append("\" violates RFC 2965: ");
                                stringBuffer3.append("effective host minus domain may not contain any dots");
                                throw new MalformedCookieException(stringBuffer3.toString());
                            }
                        } else {
                            StringBuffer stringBuffer4 = new StringBuffer();
                            stringBuffer4.append("Domain attribute \"");
                            stringBuffer4.append(cookie.getDomain());
                            stringBuffer4.append("\" violates RFC 2109: domain must start with a dot");
                            throw new MalformedCookieException(stringBuffer4.toString());
                        }
                    } else if (!cookie.getDomain().equals(lowerCase)) {
                        StringBuffer stringBuffer5 = new StringBuffer();
                        stringBuffer5.append("Illegal domain attribute: \"");
                        stringBuffer5.append(cookie.getDomain());
                        stringBuffer5.append("\".");
                        stringBuffer5.append("Domain of origin: \"");
                        stringBuffer5.append(lowerCase);
                        stringBuffer5.append("\"");
                        throw new MalformedCookieException(stringBuffer5.toString());
                    }
                } else {
                    throw new MalformedCookieException("Invalid cookie state: domain not specified");
                }
            } else {
                throw new IllegalArgumentException("Cookie origin may not be null");
            }
        }
    }

    private class Cookie2MaxageAttributeHandler implements CookieAttributeHandler {
        private Cookie2MaxageAttributeHandler() {
        }

        public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
            return true;
        }

        public void parse(Cookie cookie, String str) throws MalformedCookieException {
            int i2;
            if (cookie == null) {
                throw new IllegalArgumentException("Cookie may not be null");
            } else if (str != null) {
                try {
                    i2 = Integer.parseInt(str);
                } catch (NumberFormatException unused) {
                    i2 = -1;
                }
                if (i2 >= 0) {
                    cookie.setExpiryDate(new Date(System.currentTimeMillis() + (((long) i2) * 1000)));
                    return;
                }
                throw new MalformedCookieException("Invalid max-age attribute.");
            } else {
                throw new MalformedCookieException("Missing value for max-age attribute");
            }
        }

        public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        }
    }

    private class Cookie2PathAttributeHandler implements CookieAttributeHandler {
        private Cookie2PathAttributeHandler() {
        }

        public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
            if (cookie == null) {
                throw new IllegalArgumentException("Cookie may not be null");
            } else if (cookieOrigin != null) {
                String path = cookieOrigin.getPath();
                if (cookie.getPath() == null) {
                    CookieSpecBase.LOG.warn("Invalid cookie state: path attribute is null.");
                    return false;
                }
                if (path.trim().equals("")) {
                    path = "/";
                }
                return RFC2965Spec.this.pathMatch(path, cookie.getPath());
            } else {
                throw new IllegalArgumentException("Cookie origin may not be null");
            }
        }

        public void parse(Cookie cookie, String str) throws MalformedCookieException {
            if (cookie == null) {
                throw new IllegalArgumentException("Cookie may not be null");
            } else if (str == null) {
                throw new MalformedCookieException("Missing value for path attribute");
            } else if (!str.trim().equals("")) {
                cookie.setPath(str);
                cookie.setPathAttributeSpecified(true);
            } else {
                throw new MalformedCookieException("Blank value for path attribute");
            }
        }

        public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
            if (cookie == null) {
                throw new IllegalArgumentException("Cookie may not be null");
            } else if (cookieOrigin != null) {
                String path = cookieOrigin.getPath();
                if (path == null) {
                    throw new IllegalArgumentException("Path of origin host may not be null.");
                } else if (cookie.getPath() != null) {
                    if (path.trim().equals("")) {
                        path = "/";
                    }
                    if (!RFC2965Spec.this.pathMatch(path, cookie.getPath())) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Illegal path attribute \"");
                        stringBuffer.append(cookie.getPath());
                        stringBuffer.append("\". Path of origin: \"");
                        stringBuffer.append(path);
                        stringBuffer.append("\"");
                        throw new MalformedCookieException(stringBuffer.toString());
                    }
                } else {
                    throw new MalformedCookieException("Invalid cookie state: path attribute is null.");
                }
            } else {
                throw new IllegalArgumentException("Cookie origin may not be null");
            }
        }
    }

    private class Cookie2PortAttributeHandler implements CookieAttributeHandler {
        private Cookie2PortAttributeHandler() {
        }

        public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
            if (cookie == null) {
                throw new IllegalArgumentException("Cookie may not be null");
            } else if (cookieOrigin == null) {
                throw new IllegalArgumentException("Cookie origin may not be null");
            } else if (!(cookie instanceof Cookie2)) {
                return false;
            } else {
                Cookie2 cookie2 = (Cookie2) cookie;
                int port = cookieOrigin.getPort();
                if (!cookie2.isPortAttributeSpecified()) {
                    return true;
                }
                if (cookie2.getPorts() != null) {
                    return RFC2965Spec.this.portMatch(port, cookie2.getPorts());
                }
                CookieSpecBase.LOG.warn("Invalid cookie state: port not specified");
                return false;
            }
        }

        public void parse(Cookie cookie, String str) throws MalformedCookieException {
            if (cookie == null) {
                throw new IllegalArgumentException("Cookie may not be null");
            } else if (cookie instanceof Cookie2) {
                Cookie2 cookie2 = (Cookie2) cookie;
                if (str == null || str.trim().equals("")) {
                    cookie2.setPortAttributeBlank(true);
                } else {
                    cookie2.setPorts(RFC2965Spec.this.parsePortAttribute(str));
                }
                cookie2.setPortAttributeSpecified(true);
            }
        }

        public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
            if (cookie == null) {
                throw new IllegalArgumentException("Cookie may not be null");
            } else if (cookieOrigin == null) {
                throw new IllegalArgumentException("Cookie origin may not be null");
            } else if (cookie instanceof Cookie2) {
                Cookie2 cookie2 = (Cookie2) cookie;
                int port = cookieOrigin.getPort();
                if (cookie2.isPortAttributeSpecified() && !RFC2965Spec.this.portMatch(port, cookie2.getPorts())) {
                    throw new MalformedCookieException("Port attribute violates RFC 2965: Request port not found in cookie's port list.");
                }
            }
        }
    }

    private class Cookie2VersionAttributeHandler implements CookieAttributeHandler {
        private Cookie2VersionAttributeHandler() {
        }

        public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
            return true;
        }

        public void parse(Cookie cookie, String str) throws MalformedCookieException {
            int i2;
            if (cookie == null) {
                throw new IllegalArgumentException("Cookie may not be null");
            } else if (cookie instanceof Cookie2) {
                Cookie2 cookie2 = (Cookie2) cookie;
                if (str != null) {
                    try {
                        i2 = Integer.parseInt(str);
                    } catch (NumberFormatException unused) {
                        i2 = -1;
                    }
                    if (i2 >= 0) {
                        cookie2.setVersion(i2);
                        cookie2.setVersionAttributeSpecified(true);
                        return;
                    }
                    throw new MalformedCookieException("Invalid cookie version.");
                }
                throw new MalformedCookieException("Missing value for version attribute");
            }
        }

        public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
            if (cookie == null) {
                throw new IllegalArgumentException("Cookie may not be null");
            } else if ((cookie instanceof Cookie2) && !((Cookie2) cookie).isVersionAttributeSpecified()) {
                throw new MalformedCookieException("Violates RFC 2965. Version attribute is required.");
            }
        }
    }

    private class CookieCommentAttributeHandler implements CookieAttributeHandler {
        private CookieCommentAttributeHandler() {
        }

        public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
            return true;
        }

        public void parse(Cookie cookie, String str) throws MalformedCookieException {
            cookie.setComment(str);
        }

        public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        }
    }

    private class CookieCommentUrlAttributeHandler implements CookieAttributeHandler {
        private CookieCommentUrlAttributeHandler() {
        }

        public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
            return true;
        }

        public void parse(Cookie cookie, String str) throws MalformedCookieException {
            if (cookie instanceof Cookie2) {
                ((Cookie2) cookie).setCommentURL(str);
            }
        }

        public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        }
    }

    private class CookieDiscardAttributeHandler implements CookieAttributeHandler {
        private CookieDiscardAttributeHandler() {
        }

        public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
            return true;
        }

        public void parse(Cookie cookie, String str) throws MalformedCookieException {
            if (cookie instanceof Cookie2) {
                ((Cookie2) cookie).setDiscard(true);
            }
        }

        public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        }
    }

    private class CookieSecureAttributeHandler implements CookieAttributeHandler {
        private CookieSecureAttributeHandler() {
        }

        public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
            if (cookie == null) {
                throw new IllegalArgumentException("Cookie may not be null");
            } else if (cookieOrigin != null) {
                return cookie.getSecure() == cookieOrigin.isSecure();
            } else {
                throw new IllegalArgumentException("Cookie origin may not be null");
            }
        }

        public void parse(Cookie cookie, String str) throws MalformedCookieException {
            cookie.setSecure(true);
        }

        public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        }
    }

    public RFC2965Spec() {
        ParameterFormatter parameterFormatter = new ParameterFormatter();
        this.formatter = parameterFormatter;
        parameterFormatter.setAlwaysUseQuotes(true);
        registerAttribHandler(Cookie2.PATH, new Cookie2PathAttributeHandler());
        registerAttribHandler(Cookie2.DOMAIN, new Cookie2DomainAttributeHandler());
        registerAttribHandler(Cookie2.PORT, new Cookie2PortAttributeHandler());
        registerAttribHandler(Cookie2.MAXAGE, new Cookie2MaxageAttributeHandler());
        registerAttribHandler(Cookie2.SECURE, new CookieSecureAttributeHandler());
        registerAttribHandler(Cookie2.COMMENT, new CookieCommentAttributeHandler());
        registerAttribHandler(Cookie2.COMMENTURL, new CookieCommentUrlAttributeHandler());
        registerAttribHandler(Cookie2.DISCARD, new CookieDiscardAttributeHandler());
        registerAttribHandler("version", new Cookie2VersionAttributeHandler());
    }

    private String createPortAttribute(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(iArr[i2]);
        }
        return stringBuffer.toString();
    }

    private void doFormatCookie2(Cookie2 cookie2, StringBuffer stringBuffer) {
        String name = cookie2.getName();
        String value = cookie2.getValue();
        String str = "";
        if (value == null) {
            value = str;
        }
        this.formatter.format(stringBuffer, new NameValuePair(name, value));
        if (cookie2.getDomain() != null && cookie2.isDomainAttributeSpecified()) {
            stringBuffer.append("; ");
            this.formatter.format(stringBuffer, new NameValuePair("$Domain", cookie2.getDomain()));
        }
        if (cookie2.getPath() != null && cookie2.isPathAttributeSpecified()) {
            stringBuffer.append("; ");
            this.formatter.format(stringBuffer, new NameValuePair("$Path", cookie2.getPath()));
        }
        if (cookie2.isPortAttributeSpecified()) {
            if (!cookie2.isPortAttributeBlank()) {
                str = createPortAttribute(cookie2.getPorts());
            }
            stringBuffer.append("; ");
            this.formatter.format(stringBuffer, new NameValuePair("$Port", str));
        }
    }

    private static String getEffectiveHost(String str) {
        String lowerCase = str.toLowerCase();
        if (str.indexOf(46) >= 0) {
            return lowerCase;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(lowerCase);
        stringBuffer.append(".local");
        return stringBuffer.toString();
    }

    /* access modifiers changed from: private */
    public int[] parsePortAttribute(String str) throws MalformedCookieException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            try {
                int parseInt = Integer.parseInt(stringTokenizer.nextToken().trim());
                iArr[i2] = parseInt;
                if (parseInt >= 0) {
                    i2++;
                } else {
                    throw new MalformedCookieException("Invalid Port attribute.");
                }
            } catch (NumberFormatException e2) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Invalid Port attribute: ");
                stringBuffer.append(e2.getMessage());
                throw new MalformedCookieException(stringBuffer.toString());
            }
        }
        return iArr;
    }

    /* access modifiers changed from: private */
    public boolean portMatch(int i2, int[] iArr) {
        for (int i3 : iArr) {
            if (i2 == i3) {
                return true;
            }
        }
        return false;
    }

    public boolean domainMatch(String str, String str2) {
        return str.equals(str2) || (str2.startsWith(".") && str.endsWith(str2));
    }

    /* access modifiers changed from: protected */
    public CookieAttributeHandler findAttribHandler(String str) {
        return (CookieAttributeHandler) this.attribHandlerMap.get(str);
    }

    public String formatCookie(Cookie cookie) {
        CookieSpecBase.LOG.trace("enter RFC2965Spec.formatCookie(Cookie)");
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (!(cookie instanceof Cookie2)) {
            return this.rfc2109.formatCookie(cookie);
        } else {
            Cookie2 cookie2 = (Cookie2) cookie;
            int version = cookie2.getVersion();
            StringBuffer stringBuffer = new StringBuffer();
            this.formatter.format(stringBuffer, new NameValuePair("$Version", Integer.toString(version)));
            stringBuffer.append("; ");
            doFormatCookie2(cookie2, stringBuffer);
            return stringBuffer.toString();
        }
    }

    public String formatCookies(Cookie[] cookieArr) {
        boolean z;
        CookieSpecBase.LOG.trace("enter RFC2965Spec.formatCookieHeader(Cookie[])");
        if (cookieArr != null) {
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= cookieArr.length) {
                    z = false;
                    break;
                }
                Cookie cookie = cookieArr[i3];
                if (!(cookie instanceof Cookie2)) {
                    z = true;
                    break;
                }
                if (cookie.getVersion() > i2) {
                    i2 = cookie.getVersion();
                }
                i3++;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            if (z || i2 < 1) {
                return this.rfc2109.formatCookies(cookieArr);
            }
            Arrays.sort(cookieArr, PATH_COMPOARATOR);
            StringBuffer stringBuffer = new StringBuffer();
            this.formatter.format(stringBuffer, new NameValuePair("$Version", Integer.toString(i2)));
            for (Cookie2 doFormatCookie2 : cookieArr) {
                stringBuffer.append("; ");
                doFormatCookie2(doFormatCookie2, stringBuffer);
            }
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException("Cookies may not be null");
    }

    /* access modifiers changed from: protected */
    public CookieAttributeHandler getAttribHandler(String str) {
        CookieAttributeHandler findAttribHandler = findAttribHandler(str);
        if (findAttribHandler != null) {
            return findAttribHandler;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Handler not registered for ");
        stringBuffer.append(str);
        stringBuffer.append(" attribute.");
        throw new IllegalStateException(stringBuffer.toString());
    }

    /* access modifiers changed from: protected */
    public Iterator getAttribHandlerIterator() {
        return this.attribHandlerList.iterator();
    }

    public int getVersion() {
        return 1;
    }

    public Header getVersionHeader() {
        ParameterFormatter parameterFormatter = new ParameterFormatter();
        StringBuffer stringBuffer = new StringBuffer();
        parameterFormatter.format(stringBuffer, new NameValuePair("$Version", Integer.toString(getVersion())));
        return new Header("Cookie2", stringBuffer.toString(), true);
    }

    public boolean match(String str, int i2, String str2, boolean z, Cookie cookie) {
        CookieSpecBase.LOG.trace("enter RFC2965.match(String, int, String, boolean, Cookie");
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        } else if (!(cookie instanceof Cookie2)) {
            return this.rfc2109.match(str, i2, str2, z, cookie);
        } else {
            if (cookie.isPersistent() && cookie.isExpired()) {
                return false;
            }
            CookieOrigin cookieOrigin = new CookieOrigin(getEffectiveHost(str), i2, str2, z);
            Iterator attribHandlerIterator = getAttribHandlerIterator();
            while (attribHandlerIterator.hasNext()) {
                if (!((CookieAttributeHandler) attribHandlerIterator.next()).match(cookie, cookieOrigin)) {
                    return false;
                }
            }
            return true;
        }
    }

    public Cookie[] parse(String str, int i2, String str2, boolean z, String str3) throws MalformedCookieException {
        int i3 = i2;
        CookieSpecBase.LOG.trace("enter RFC2965Spec.parse(String, int, String, boolean, String)");
        if (str == null) {
            throw new IllegalArgumentException("Host of origin may not be null");
        } else if (str.trim().equals("")) {
            throw new IllegalArgumentException("Host of origin may not be blank");
        } else if (i3 < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid port: ");
            stringBuffer.append(i3);
            throw new IllegalArgumentException(stringBuffer.toString());
        } else if (str2 == null) {
            throw new IllegalArgumentException("Path of origin may not be null.");
        } else if (str3 != null) {
            String str4 = str2.trim().equals("") ? "/" : str2;
            String effectiveHost = getEffectiveHost(str);
            HeaderElement[] parseElements = HeaderElement.parseElements(str3.toCharArray());
            LinkedList linkedList = new LinkedList();
            int i4 = 0;
            while (i4 < parseElements.length) {
                HeaderElement headerElement = parseElements[i4];
                try {
                    Cookie2 cookie2 = new Cookie2(effectiveHost, headerElement.getName(), headerElement.getValue(), str4, (Date) null, false, new int[]{i2});
                    NameValuePair[] parameters = headerElement.getParameters();
                    if (parameters != null) {
                        HashMap hashMap = new HashMap(parameters.length);
                        for (int length = parameters.length - 1; length >= 0; length--) {
                            NameValuePair nameValuePair = parameters[length];
                            hashMap.put(nameValuePair.getName().toLowerCase(), nameValuePair);
                        }
                        for (Map.Entry value : hashMap.entrySet()) {
                            parseAttribute((NameValuePair) value.getValue(), cookie2);
                        }
                    }
                    linkedList.add(cookie2);
                    i4++;
                } catch (IllegalArgumentException e2) {
                    throw new MalformedCookieException(e2.getMessage());
                }
            }
            return (Cookie[]) linkedList.toArray(new Cookie[linkedList.size()]);
        } else {
            throw new IllegalArgumentException("Header may not be null.");
        }
    }

    public void parseAttribute(NameValuePair nameValuePair, Cookie cookie) throws MalformedCookieException {
        if (nameValuePair == null) {
            throw new IllegalArgumentException("Attribute may not be null.");
        } else if (nameValuePair.getName() == null) {
            throw new IllegalArgumentException("Attribute Name may not be null.");
        } else if (cookie != null) {
            String lowerCase = nameValuePair.getName().toLowerCase();
            String value = nameValuePair.getValue();
            CookieAttributeHandler findAttribHandler = findAttribHandler(lowerCase);
            if (findAttribHandler == null) {
                Log log = CookieSpecBase.LOG;
                if (log.isDebugEnabled()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unrecognized cookie attribute: ");
                    stringBuffer.append(nameValuePair.toString());
                    log.debug(stringBuffer.toString());
                    return;
                }
                return;
            }
            findAttribHandler.parse(cookie, value);
        } else {
            throw new IllegalArgumentException("Cookie may not be null.");
        }
    }

    /* access modifiers changed from: protected */
    public void registerAttribHandler(String str, CookieAttributeHandler cookieAttributeHandler) {
        if (str == null) {
            throw new IllegalArgumentException("Attribute name may not be null");
        } else if (cookieAttributeHandler != null) {
            if (!this.attribHandlerList.contains(cookieAttributeHandler)) {
                this.attribHandlerList.add(cookieAttributeHandler);
            }
            this.attribHandlerMap.put(str, cookieAttributeHandler);
        } else {
            throw new IllegalArgumentException("Attribute handler may not be null");
        }
    }

    public void validate(String str, int i2, String str2, boolean z, Cookie cookie) throws MalformedCookieException {
        CookieSpecBase.LOG.trace("enter RFC2965Spec.validate(String, int, String, boolean, Cookie)");
        if (!(cookie instanceof Cookie2)) {
            this.rfc2109.validate(str, i2, str2, z, cookie);
        } else if (cookie.getName().indexOf(32) != -1) {
            throw new MalformedCookieException("Cookie name may not contain blanks");
        } else if (!cookie.getName().startsWith("$")) {
            CookieOrigin cookieOrigin = new CookieOrigin(getEffectiveHost(str), i2, str2, z);
            Iterator attribHandlerIterator = getAttribHandlerIterator();
            while (attribHandlerIterator.hasNext()) {
                ((CookieAttributeHandler) attribHandlerIterator.next()).validate(cookie, cookieOrigin);
            }
        } else {
            throw new MalformedCookieException("Cookie name may not start with $");
        }
    }

    public Cookie[] parse(String str, int i2, String str2, boolean z, Header header) throws MalformedCookieException {
        CookieSpecBase.LOG.trace("enter RFC2965.parse(String, int, String, boolean, Header)");
        if (header == null) {
            throw new IllegalArgumentException("Header may not be null.");
        } else if (header.getName() == null) {
            throw new IllegalArgumentException("Header name may not be null.");
        } else if (header.getName().equalsIgnoreCase(SET_COOKIE2_KEY)) {
            return parse(str, i2, str2, z, header.getValue());
        } else if (header.getName().equalsIgnoreCase(RFC2109Spec.SET_COOKIE_KEY)) {
            return this.rfc2109.parse(str, i2, str2, z, header.getValue());
        } else {
            throw new MalformedCookieException("Header name is not valid. RFC 2965 supports \"set-cookie\" and \"set-cookie2\" headers.");
        }
    }
}
