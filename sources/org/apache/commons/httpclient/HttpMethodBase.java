package org.apache.commons.httpclient;

import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collection;
import org.apache.commons.httpclient.auth.AuthState;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.httpclient.cookie.CookieVersionSupport;
import org.apache.commons.httpclient.cookie.RFC2109Spec;
import org.apache.commons.httpclient.cookie.RFC2965Spec;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.httpclient.util.ExceptionUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class HttpMethodBase implements HttpMethod {
    private static final int DEFAULT_INITIAL_BUFFER_SIZE = 4096;
    private static final Log LOG;
    private static final int RESPONSE_WAIT_TIME_MS = 3000;
    static /* synthetic */ Class class$org$apache$commons$httpclient$HttpMethodBase;
    private volatile boolean aborted = false;
    private boolean connectionCloseForced = false;
    private CookieSpec cookiespec = null;
    private boolean doAuthentication = true;
    protected HttpVersion effectiveVersion = null;
    private boolean followRedirects = false;
    private AuthState hostAuthState = new AuthState();
    private HttpHost httphost = null;
    private MethodRetryHandler methodRetryHandler;
    private HttpMethodParams params = new HttpMethodParams();
    private String path = null;
    private AuthState proxyAuthState = new AuthState();
    private String queryString = null;
    private int recoverableExceptionCount = 0;
    private HeaderGroup requestHeaders = new HeaderGroup();
    private boolean requestSent = false;
    private byte[] responseBody = null;
    private HttpConnection responseConnection = null;
    private HeaderGroup responseHeaders = new HeaderGroup();
    private InputStream responseStream = null;
    private HeaderGroup responseTrailerHeaders = new HeaderGroup();
    protected StatusLine statusLine = null;
    private boolean used = false;

    static {
        Class cls = class$org$apache$commons$httpclient$HttpMethodBase;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.HttpMethodBase");
            class$org$apache$commons$httpclient$HttpMethodBase = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public HttpMethodBase() {
    }

    private static boolean canResponseHaveBody(int i2) {
        LOG.trace("enter HttpMethodBase.canResponseHaveBody(int)");
        return ((i2 >= 100 && i2 <= 199) || i2 == 204 || i2 == 304) ? false : true;
    }

    private void checkExecuteConditions(HttpState httpState, HttpConnection httpConnection) throws HttpException {
        if (httpState == null) {
            throw new IllegalArgumentException("HttpState parameter may not be null");
        } else if (httpConnection == null) {
            throw new IllegalArgumentException("HttpConnection parameter may not be null");
        } else if (this.aborted) {
            throw new IllegalStateException("Method has been aborted");
        } else if (!validate()) {
            throw new ProtocolException("HttpMethodBase object not valid");
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private void ensureConnectionRelease() {
        HttpConnection httpConnection = this.responseConnection;
        if (httpConnection != null) {
            httpConnection.releaseConnection();
            this.responseConnection = null;
        }
    }

    protected static String generateRequestLine(HttpConnection httpConnection, String str, String str2, String str3, String str4) {
        LOG.trace("enter HttpMethodBase.generateRequestLine(HttpConnection, String, String, String, String)");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(StringUtils.SPACE);
        if (!httpConnection.isTransparent()) {
            Protocol protocol = httpConnection.getProtocol();
            stringBuffer.append(protocol.getScheme().toLowerCase());
            stringBuffer.append("://");
            stringBuffer.append(httpConnection.getHost());
            if (!(httpConnection.getPort() == -1 || httpConnection.getPort() == protocol.getDefaultPort())) {
                stringBuffer.append(":");
                stringBuffer.append(httpConnection.getPort());
            }
        }
        if (str2 == null) {
            stringBuffer.append("/");
        } else {
            if (!httpConnection.isTransparent() && !str2.startsWith("/")) {
                stringBuffer.append("/");
            }
            stringBuffer.append(str2);
        }
        if (str3 != null) {
            if (str3.indexOf("?") != 0) {
                stringBuffer.append("?");
            }
            stringBuffer.append(str3);
        }
        stringBuffer.append(StringUtils.SPACE);
        stringBuffer.append(str4);
        stringBuffer.append("\r\n");
        return stringBuffer.toString();
    }

    private CookieSpec getCookieSpec(HttpState httpState) {
        if (this.cookiespec == null) {
            int cookiePolicy = httpState.getCookiePolicy();
            this.cookiespec = cookiePolicy == -1 ? CookiePolicy.getCookieSpec(this.params.getCookiePolicy()) : CookiePolicy.getSpecByPolicy(cookiePolicy);
            this.cookiespec.setValidDateFormats((Collection) this.params.getParameter(HttpMethodParams.DATE_PATTERNS));
        }
        return this.cookiespec;
    }

    private String getRequestLine(HttpConnection httpConnection) {
        return generateRequestLine(httpConnection, getName(), getPath(), getQueryString(), this.effectiveVersion.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.InputStream readResponseBody(org.apache.commons.httpclient.HttpConnection r11) throws org.apache.commons.httpclient.HttpException, java.io.IOException {
        /*
            r10 = this;
            org.apache.commons.logging.Log r0 = LOG
            java.lang.String r1 = "enter HttpMethodBase.readResponseBody(HttpConnection)"
            r0.trace(r1)
            r1 = 0
            r10.responseBody = r1
            java.io.InputStream r2 = r11.getResponseInputStream()
            org.apache.commons.httpclient.Wire r3 = org.apache.commons.httpclient.Wire.CONTENT_WIRE
            boolean r3 = r3.enabled()
            if (r3 == 0) goto L_0x001e
            org.apache.commons.httpclient.WireLogInputStream r3 = new org.apache.commons.httpclient.WireLogInputStream
            org.apache.commons.httpclient.Wire r4 = org.apache.commons.httpclient.Wire.CONTENT_WIRE
            r3.<init>(r2, r4)
            r2 = r3
        L_0x001e:
            org.apache.commons.httpclient.StatusLine r3 = r10.statusLine
            int r3 = r3.getStatusCode()
            boolean r3 = canResponseHaveBody(r3)
            org.apache.commons.httpclient.HeaderGroup r4 = r10.responseHeaders
            java.lang.String r5 = "Transfer-Encoding"
            org.apache.commons.httpclient.Header r4 = r4.getFirstHeader(r5)
            r5 = 1
            if (r4 == 0) goto L_0x00ad
            java.lang.String r6 = r4.getValue()
            java.lang.String r7 = "chunked"
            boolean r8 = r7.equalsIgnoreCase(r6)
            if (r8 != 0) goto L_0x0061
            java.lang.String r8 = "identity"
            boolean r8 = r8.equalsIgnoreCase(r6)
            if (r8 != 0) goto L_0x0061
            boolean r8 = r0.isWarnEnabled()
            if (r8 == 0) goto L_0x0061
            java.lang.StringBuffer r8 = new java.lang.StringBuffer
            r8.<init>()
            java.lang.String r9 = "Unsupported transfer encoding: "
            r8.append(r9)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r0.warn(r6)
        L_0x0061:
            org.apache.commons.httpclient.HeaderElement[] r4 = r4.getElements()
            int r6 = r4.length
            if (r6 <= 0) goto L_0x00a4
            int r6 = r6 - r5
            r4 = r4[r6]
            java.lang.String r4 = r4.getName()
            boolean r4 = r7.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x00a4
            org.apache.commons.httpclient.params.HttpConnectionParams r4 = r11.getParams()
            int r4 = r4.getSoTimeout()
            boolean r11 = r11.isResponseAvailable(r4)
            if (r11 == 0) goto L_0x0089
            org.apache.commons.httpclient.ChunkedInputStream r11 = new org.apache.commons.httpclient.ChunkedInputStream
            r11.<init>(r2, r10)
            goto L_0x00e3
        L_0x0089:
            org.apache.commons.httpclient.params.HttpMethodParams r11 = r10.getParams()
            java.lang.String r2 = "http.protocol.strict-transfer-encoding"
            boolean r11 = r11.isParameterTrue(r2)
            if (r11 != 0) goto L_0x009c
            java.lang.String r11 = "Chunk-encoded body missing"
            r0.warn(r11)
            r2 = r1
            goto L_0x00e4
        L_0x009c:
            org.apache.commons.httpclient.ProtocolException r11 = new org.apache.commons.httpclient.ProtocolException
            java.lang.String r0 = "Chunk-encoded body declared but not sent"
            r11.<init>(r0)
            throw r11
        L_0x00a4:
            java.lang.String r11 = "Response content is not chunk-encoded"
        L_0x00a6:
            r0.info(r11)
            r10.setConnectionCloseForced(r5)
            goto L_0x00e4
        L_0x00ad:
            long r6 = r10.getResponseContentLength()
            r8 = -1
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 != 0) goto L_0x00de
            if (r3 == 0) goto L_0x00e4
            org.apache.commons.httpclient.HttpVersion r11 = r10.effectiveVersion
            org.apache.commons.httpclient.HttpVersion r4 = org.apache.commons.httpclient.HttpVersion.HTTP_1_1
            boolean r11 = r11.greaterEquals(r4)
            if (r11 == 0) goto L_0x00e4
            org.apache.commons.httpclient.HeaderGroup r11 = r10.responseHeaders
            java.lang.String r4 = "Connection"
            org.apache.commons.httpclient.Header r11 = r11.getFirstHeader(r4)
            if (r11 == 0) goto L_0x00d2
            java.lang.String r11 = r11.getValue()
            goto L_0x00d3
        L_0x00d2:
            r11 = r1
        L_0x00d3:
            java.lang.String r4 = "close"
            boolean r11 = r4.equalsIgnoreCase(r11)
            if (r11 != 0) goto L_0x00e4
            java.lang.String r11 = "Response content length is not known"
            goto L_0x00a6
        L_0x00de:
            org.apache.commons.httpclient.ContentLengthInputStream r11 = new org.apache.commons.httpclient.ContentLengthInputStream
            r11.<init>((java.io.InputStream) r2, (long) r6)
        L_0x00e3:
            r2 = r11
        L_0x00e4:
            if (r3 != 0) goto L_0x00e7
            goto L_0x00e8
        L_0x00e7:
            r1 = r2
        L_0x00e8:
            if (r1 == 0) goto L_0x00f5
            org.apache.commons.httpclient.AutoCloseInputStream r11 = new org.apache.commons.httpclient.AutoCloseInputStream
            org.apache.commons.httpclient.HttpMethodBase$1 r0 = new org.apache.commons.httpclient.HttpMethodBase$1
            r0.<init>()
            r11.<init>(r1, r0)
            r1 = r11
        L_0x00f5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.HttpMethodBase.readResponseBody(org.apache.commons.httpclient.HttpConnection):java.io.InputStream");
    }

    private boolean responseAvailable() {
        return (this.responseBody == null && this.responseStream == null) ? false : true;
    }

    public void abort() {
        if (!this.aborted) {
            this.aborted = true;
            HttpConnection httpConnection = this.responseConnection;
            if (httpConnection != null) {
                httpConnection.close();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addCookieRequestHeader(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter HttpMethodBase.addCookieRequestHeader(HttpState, HttpConnection)");
        Header[] headers = getRequestHeaderGroup().getHeaders(HttpHeaders.p);
        for (Header header : headers) {
            if (header.isAutogenerated()) {
                getRequestHeaderGroup().removeHeader(header);
            }
        }
        CookieSpec cookieSpec = getCookieSpec(httpState);
        String virtualHost = this.params.getVirtualHost();
        if (virtualHost == null) {
            virtualHost = httpConnection.getHost();
        }
        Cookie[] match = cookieSpec.match(virtualHost, httpConnection.getPort(), getPath(), httpConnection.isSecure(), httpState.getCookies());
        if (match != null && match.length > 0) {
            if (getParams().isParameterTrue(HttpMethodParams.SINGLE_COOKIE_HEADER)) {
                getRequestHeaderGroup().addHeader(new Header(HttpHeaders.p, cookieSpec.formatCookies(match), true));
            } else {
                for (Cookie formatCookie : match) {
                    getRequestHeaderGroup().addHeader(new Header(HttpHeaders.p, cookieSpec.formatCookie(formatCookie), true));
                }
            }
            if (cookieSpec instanceof CookieVersionSupport) {
                CookieVersionSupport cookieVersionSupport = (CookieVersionSupport) cookieSpec;
                int version = cookieVersionSupport.getVersion();
                boolean z = false;
                for (Cookie version2 : match) {
                    if (version != version2.getVersion()) {
                        z = true;
                    }
                }
                if (z) {
                    getRequestHeaderGroup().addHeader(cookieVersionSupport.getVersionHeader());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addHostRequestHeader(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        Log log = LOG;
        log.trace("enter HttpMethodBase.addHostRequestHeader(HttpState, HttpConnection)");
        String virtualHost = this.params.getVirtualHost();
        if (virtualHost != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Using virtual host name: ");
            stringBuffer.append(virtualHost);
            log.debug(stringBuffer.toString());
        } else {
            virtualHost = httpConnection.getHost();
        }
        int port = httpConnection.getPort();
        if (log.isDebugEnabled()) {
            log.debug("Adding Host request header");
        }
        if (httpConnection.getProtocol().getDefaultPort() != port) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(virtualHost);
            stringBuffer2.append(":");
            stringBuffer2.append(port);
            virtualHost = stringBuffer2.toString();
        }
        setRequestHeader(HttpHeaders.w, virtualHost);
    }

    /* access modifiers changed from: protected */
    public void addProxyConnectionHeader(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter HttpMethodBase.addProxyConnectionHeader(HttpState, HttpConnection)");
        if (!httpConnection.isTransparent() && getRequestHeader("Proxy-Connection") == null) {
            addRequestHeader("Proxy-Connection", HttpHeaders.u0);
        }
    }

    public void addRequestHeader(String str, String str2) {
        addRequestHeader(new Header(str, str2));
    }

    /* access modifiers changed from: protected */
    public void addRequestHeaders(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter HttpMethodBase.addRequestHeaders(HttpState, HttpConnection)");
        addUserAgentRequestHeader(httpState, httpConnection);
        addHostRequestHeader(httpState, httpConnection);
        addCookieRequestHeader(httpState, httpConnection);
        addProxyConnectionHeader(httpState, httpConnection);
    }

    public void addResponseFooter(Header header) {
        getResponseTrailerHeaderGroup().addHeader(header);
    }

    /* access modifiers changed from: protected */
    public void addUserAgentRequestHeader(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter HttpMethodBase.addUserAgentRequestHeaders(HttpState, HttpConnection)");
        if (getRequestHeader(HttpHeaders.P) == null) {
            String str = (String) getParams().getParameter(HttpMethodParams.USER_AGENT);
            if (str == null) {
                str = "Jakarta Commons-HttpClient";
            }
            setRequestHeader(HttpHeaders.P, str);
        }
    }

    /* access modifiers changed from: protected */
    public void checkNotUsed() throws IllegalStateException {
        if (this.used) {
            throw new IllegalStateException("Already used.");
        }
    }

    /* access modifiers changed from: protected */
    public void checkUsed() throws IllegalStateException {
        if (!this.used) {
            throw new IllegalStateException("Not Used.");
        }
    }

    public int execute(HttpState httpState, HttpConnection httpConnection) throws HttpException, IOException {
        LOG.trace("enter HttpMethodBase.execute(HttpState, HttpConnection)");
        this.responseConnection = httpConnection;
        checkExecuteConditions(httpState, httpConnection);
        this.statusLine = null;
        this.connectionCloseForced = false;
        httpConnection.setLastResponseInputStream((InputStream) null);
        if (this.effectiveVersion == null) {
            this.effectiveVersion = this.params.getVersion();
        }
        writeRequest(httpState, httpConnection);
        this.requestSent = true;
        readResponse(httpState, httpConnection);
        this.used = true;
        return this.statusLine.getStatusCode();
    }

    /* access modifiers changed from: package-private */
    public void fakeResponse(StatusLine statusLine2, HeaderGroup headerGroup, InputStream inputStream) {
        this.used = true;
        this.statusLine = statusLine2;
        this.responseHeaders = headerGroup;
        this.responseBody = null;
        this.responseStream = inputStream;
    }

    public String getAuthenticationRealm() {
        return this.hostAuthState.getRealm();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getContentCharSet(org.apache.commons.httpclient.Header r4) {
        /*
            r3 = this;
            org.apache.commons.logging.Log r0 = LOG
            java.lang.String r1 = "enter getContentCharSet( Header contentheader )"
            r0.trace(r1)
            if (r4 == 0) goto L_0x0021
            org.apache.commons.httpclient.HeaderElement[] r4 = r4.getElements()
            int r1 = r4.length
            r2 = 1
            if (r1 != r2) goto L_0x0021
            r1 = 0
            r4 = r4[r1]
            java.lang.String r1 = "charset"
            org.apache.commons.httpclient.NameValuePair r4 = r4.getParameterByName(r1)
            if (r4 == 0) goto L_0x0021
            java.lang.String r4 = r4.getValue()
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            if (r4 != 0) goto L_0x0046
            org.apache.commons.httpclient.params.HttpMethodParams r4 = r3.getParams()
            java.lang.String r4 = r4.getContentCharset()
            boolean r1 = r0.isDebugEnabled()
            if (r1 == 0) goto L_0x0046
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.String r2 = "Default charset used: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.debug(r1)
        L_0x0046:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.HttpMethodBase.getContentCharSet(org.apache.commons.httpclient.Header):java.lang.String");
    }

    public boolean getDoAuthentication() {
        return this.doAuthentication;
    }

    public HttpVersion getEffectiveVersion() {
        return this.effectiveVersion;
    }

    public boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public AuthState getHostAuthState() {
        return this.hostAuthState;
    }

    public HostConfiguration getHostConfiguration() {
        HostConfiguration hostConfiguration = new HostConfiguration();
        hostConfiguration.setHost(this.httphost);
        return hostConfiguration;
    }

    public MethodRetryHandler getMethodRetryHandler() {
        return this.methodRetryHandler;
    }

    public abstract String getName();

    public HttpMethodParams getParams() {
        return this.params;
    }

    public String getPath() {
        String str = this.path;
        return (str == null || str.equals("")) ? "/" : this.path;
    }

    public AuthState getProxyAuthState() {
        return this.proxyAuthState;
    }

    public String getProxyAuthenticationRealm() {
        return this.proxyAuthState.getRealm();
    }

    public String getQueryString() {
        return this.queryString;
    }

    public int getRecoverableExceptionCount() {
        return this.recoverableExceptionCount;
    }

    public String getRequestCharSet() {
        return getContentCharSet(getRequestHeader(HttpHeaders.f22875c));
    }

    public Header getRequestHeader(String str) {
        if (str == null) {
            return null;
        }
        return getRequestHeaderGroup().getCondensedHeader(str);
    }

    /* access modifiers changed from: protected */
    public HeaderGroup getRequestHeaderGroup() {
        return this.requestHeaders;
    }

    public Header[] getRequestHeaders() {
        return getRequestHeaderGroup().getAllHeaders();
    }

    public byte[] getResponseBody() throws IOException {
        InputStream responseBodyAsStream;
        if (this.responseBody == null && (responseBodyAsStream = getResponseBodyAsStream()) != null) {
            long responseContentLength = getResponseContentLength();
            if (responseContentLength <= 2147483647L) {
                int intParameter = getParams().getIntParameter(HttpMethodParams.BUFFER_WARN_TRIGGER_LIMIT, 1048576);
                if (responseContentLength == -1 || responseContentLength > ((long) intParameter)) {
                    LOG.warn("Going to buffer response body of large or unknown size. Using getResponseBodyAsStream instead is recommended.");
                }
                LOG.debug("Buffering response body");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(responseContentLength > 0 ? (int) responseContentLength : 4096);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = responseBodyAsStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.close();
                setResponseStream((InputStream) null);
                this.responseBody = byteArrayOutputStream.toByteArray();
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Content too large to be buffered: ");
                stringBuffer.append(responseContentLength);
                stringBuffer.append(" bytes");
                throw new IOException(stringBuffer.toString());
            }
        }
        return this.responseBody;
    }

    public InputStream getResponseBodyAsStream() throws IOException {
        InputStream inputStream = this.responseStream;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.responseBody == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.responseBody);
        LOG.debug("re-creating response stream from byte array");
        return byteArrayInputStream;
    }

    public String getResponseBodyAsString() throws IOException {
        byte[] responseBody2 = responseAvailable() ? getResponseBody() : null;
        if (responseBody2 != null) {
            return EncodingUtil.getString(responseBody2, getResponseCharSet());
        }
        return null;
    }

    public String getResponseCharSet() {
        return getContentCharSet(getResponseHeader(HttpHeaders.f22875c));
    }

    public long getResponseContentLength() {
        Header[] headers = getResponseHeaderGroup().getHeaders(HttpHeaders.f22874b);
        if (headers.length == 0) {
            return -1;
        }
        if (headers.length > 1) {
            LOG.warn("Multiple content-length headers detected");
        }
        int length = headers.length - 1;
        while (length >= 0) {
            try {
                return Long.parseLong(headers[length].getValue());
            } catch (NumberFormatException e2) {
                Log log = LOG;
                if (log.isWarnEnabled()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Invalid content-length value: ");
                    stringBuffer.append(e2.getMessage());
                    log.warn(stringBuffer.toString());
                }
                length--;
            }
        }
        return -1;
    }

    public Header getResponseFooter(String str) {
        if (str == null) {
            return null;
        }
        return getResponseTrailerHeaderGroup().getCondensedHeader(str);
    }

    public Header[] getResponseFooters() {
        return getResponseTrailerHeaderGroup().getAllHeaders();
    }

    public Header getResponseHeader(String str) {
        if (str == null) {
            return null;
        }
        return getResponseHeaderGroup().getCondensedHeader(str);
    }

    /* access modifiers changed from: protected */
    public HeaderGroup getResponseHeaderGroup() {
        return this.responseHeaders;
    }

    public Header[] getResponseHeaders() {
        return getResponseHeaderGroup().getAllHeaders();
    }

    /* access modifiers changed from: protected */
    public InputStream getResponseStream() {
        return this.responseStream;
    }

    /* access modifiers changed from: protected */
    public HeaderGroup getResponseTrailerHeaderGroup() {
        return this.responseTrailerHeaders;
    }

    public int getStatusCode() {
        return this.statusLine.getStatusCode();
    }

    public StatusLine getStatusLine() {
        return this.statusLine;
    }

    public String getStatusText() {
        return this.statusLine.getReasonPhrase();
    }

    public URI getURI() throws URIException {
        StringBuffer stringBuffer = new StringBuffer();
        HttpHost httpHost = this.httphost;
        if (httpHost != null) {
            stringBuffer.append(httpHost.getProtocol().getScheme());
            stringBuffer.append("://");
            stringBuffer.append(this.httphost.getHostName());
            int port = this.httphost.getPort();
            if (!(port == -1 || port == this.httphost.getProtocol().getDefaultPort())) {
                stringBuffer.append(":");
                stringBuffer.append(port);
            }
        }
        stringBuffer.append(this.path);
        if (this.queryString != null) {
            stringBuffer.append('?');
            stringBuffer.append(this.queryString);
        }
        return new URI(stringBuffer.toString(), true, getParams().getUriCharset());
    }

    public boolean hasBeenUsed() {
        return this.used;
    }

    public boolean isAborted() {
        return this.aborted;
    }

    /* access modifiers changed from: protected */
    public boolean isConnectionCloseForced() {
        return this.connectionCloseForced;
    }

    public boolean isHttp11() {
        return this.params.getVersion().equals(HttpVersion.HTTP_1_1);
    }

    public boolean isRequestSent() {
        return this.requestSent;
    }

    public boolean isStrictMode() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e5 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processCookieHeaders(org.apache.commons.httpclient.cookie.CookieSpec r18, org.apache.commons.httpclient.Header[] r19, org.apache.commons.httpclient.HttpState r20, org.apache.commons.httpclient.HttpConnection r21) {
        /*
            r17 = this;
            r7 = r18
            r8 = r19
            java.lang.String r9 = "\". "
            org.apache.commons.logging.Log r0 = LOG
            java.lang.String r1 = "enter HttpMethodBase.processCookieHeaders(Header[], HttpState, HttpConnection)"
            r0.trace(r1)
            r10 = r17
            org.apache.commons.httpclient.params.HttpMethodParams r0 = r10.params
            java.lang.String r0 = r0.getVirtualHost()
            if (r0 != 0) goto L_0x001b
            java.lang.String r0 = r21.getHost()
        L_0x001b:
            r11 = r0
            r12 = 0
            r13 = 0
        L_0x001e:
            int r0 = r8.length
            if (r13 >= r0) goto L_0x00ee
            r14 = r8[r13]
            int r3 = r21.getPort()     // Catch:{ MalformedCookieException -> 0x0039 }
            java.lang.String r4 = r17.getPath()     // Catch:{ MalformedCookieException -> 0x0039 }
            boolean r5 = r21.isSecure()     // Catch:{ MalformedCookieException -> 0x0039 }
            r1 = r18
            r2 = r11
            r6 = r14
            org.apache.commons.httpclient.Cookie[] r0 = r1.parse((java.lang.String) r2, (int) r3, (java.lang.String) r4, (boolean) r5, (org.apache.commons.httpclient.Header) r6)     // Catch:{ MalformedCookieException -> 0x0039 }
        L_0x0037:
            r14 = r0
            goto L_0x0066
        L_0x0039:
            r0 = move-exception
            org.apache.commons.logging.Log r1 = LOG
            boolean r2 = r1.isWarnEnabled()
            if (r2 == 0) goto L_0x0064
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            java.lang.String r3 = "Invalid cookie header: \""
            r2.append(r3)
            java.lang.String r3 = r14.getValue()
            r2.append(r3)
            r2.append(r9)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.warn(r0)
        L_0x0064:
            r0 = 0
            goto L_0x0037
        L_0x0066:
            if (r14 == 0) goto L_0x00e8
            r15 = 0
        L_0x0069:
            int r0 = r14.length
            if (r15 >= r0) goto L_0x00e8
            r6 = r14[r15]
            int r3 = r21.getPort()     // Catch:{ MalformedCookieException -> 0x00b7 }
            java.lang.String r4 = r17.getPath()     // Catch:{ MalformedCookieException -> 0x00b7 }
            boolean r5 = r21.isSecure()     // Catch:{ MalformedCookieException -> 0x00b7 }
            r1 = r18
            r2 = r11
            r16 = r6
            r1.validate(r2, r3, r4, r5, r6)     // Catch:{ MalformedCookieException -> 0x00b1 }
            r1 = r20
            r2 = r16
            r1.addCookie(r2)     // Catch:{ MalformedCookieException -> 0x00af }
            org.apache.commons.logging.Log r0 = LOG     // Catch:{ MalformedCookieException -> 0x00af }
            boolean r3 = r0.isDebugEnabled()     // Catch:{ MalformedCookieException -> 0x00af }
            if (r3 == 0) goto L_0x00e5
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ MalformedCookieException -> 0x00af }
            r3.<init>()     // Catch:{ MalformedCookieException -> 0x00af }
            java.lang.String r4 = "Cookie accepted: \""
            r3.append(r4)     // Catch:{ MalformedCookieException -> 0x00af }
            java.lang.String r4 = r7.formatCookie(r2)     // Catch:{ MalformedCookieException -> 0x00af }
            r3.append(r4)     // Catch:{ MalformedCookieException -> 0x00af }
            java.lang.String r4 = "\""
            r3.append(r4)     // Catch:{ MalformedCookieException -> 0x00af }
            java.lang.String r3 = r3.toString()     // Catch:{ MalformedCookieException -> 0x00af }
            r0.debug(r3)     // Catch:{ MalformedCookieException -> 0x00af }
            goto L_0x00e5
        L_0x00af:
            r0 = move-exception
            goto L_0x00bb
        L_0x00b1:
            r0 = move-exception
            r1 = r20
            r2 = r16
            goto L_0x00bb
        L_0x00b7:
            r0 = move-exception
            r1 = r20
            r2 = r6
        L_0x00bb:
            org.apache.commons.logging.Log r3 = LOG
            boolean r4 = r3.isWarnEnabled()
            if (r4 == 0) goto L_0x00e5
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            java.lang.String r5 = "Cookie rejected: \""
            r4.append(r5)
            java.lang.String r2 = r7.formatCookie(r2)
            r4.append(r2)
            r4.append(r9)
            java.lang.String r0 = r0.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.warn(r0)
        L_0x00e5:
            int r15 = r15 + 1
            goto L_0x0069
        L_0x00e8:
            r1 = r20
            int r13 = r13 + 1
            goto L_0x001e
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.HttpMethodBase.processCookieHeaders(org.apache.commons.httpclient.cookie.CookieSpec, org.apache.commons.httpclient.Header[], org.apache.commons.httpclient.HttpState, org.apache.commons.httpclient.HttpConnection):void");
    }

    /* access modifiers changed from: protected */
    public void processResponseBody(HttpState httpState, HttpConnection httpConnection) {
    }

    /* access modifiers changed from: protected */
    public void processResponseHeaders(HttpState httpState, HttpConnection httpConnection) {
        LOG.trace("enter HttpMethodBase.processResponseHeaders(HttpState, HttpConnection)");
        CookieSpec cookieSpec = getCookieSpec(httpState);
        processCookieHeaders(cookieSpec, getResponseHeaderGroup().getHeaders(RFC2109Spec.SET_COOKIE_KEY), httpState, httpConnection);
        if ((cookieSpec instanceof CookieVersionSupport) && ((CookieVersionSupport) cookieSpec).getVersion() > 0) {
            processCookieHeaders(cookieSpec, getResponseHeaderGroup().getHeaders(RFC2965Spec.SET_COOKIE2_KEY), httpState, httpConnection);
        }
    }

    /* access modifiers changed from: protected */
    public void processStatusLine(HttpState httpState, HttpConnection httpConnection) {
    }

    /* access modifiers changed from: protected */
    public void readResponse(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter HttpMethodBase.readResponse(HttpState, HttpConnection)");
        while (this.statusLine == null) {
            readStatusLine(httpState, httpConnection);
            processStatusLine(httpState, httpConnection);
            readResponseHeaders(httpState, httpConnection);
            processResponseHeaders(httpState, httpConnection);
            int statusCode = this.statusLine.getStatusCode();
            if (statusCode >= 100 && statusCode < 200) {
                Log log = LOG;
                if (log.isInfoEnabled()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Discarding unexpected response: ");
                    stringBuffer.append(this.statusLine.toString());
                    log.info(stringBuffer.toString());
                }
                this.statusLine = null;
            }
        }
        readResponseBody(httpState, httpConnection);
        processResponseBody(httpState, httpConnection);
    }

    /* access modifiers changed from: protected */
    public void readResponseHeaders(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter HttpMethodBase.readResponseHeaders(HttpState,HttpConnection)");
        getResponseHeaderGroup().clear();
        getResponseHeaderGroup().setHeaders(HttpParser.parseHeaders(httpConnection.getResponseInputStream(), getParams().getHttpElementCharset()));
    }

    /* access modifiers changed from: protected */
    public void readStatusLine(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter HttpMethodBase.readStatusLine(HttpState, HttpConnection)");
        int intParameter = getParams().getIntParameter(HttpMethodParams.STATUS_LINE_GARBAGE_LIMIT, Integer.MAX_VALUE);
        int i2 = 0;
        while (true) {
            String readLine = httpConnection.readLine(getParams().getHttpElementCharset());
            if (readLine == null && i2 == 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("The server ");
                stringBuffer.append(httpConnection.getHost());
                stringBuffer.append(" failed to respond");
                throw new NoHttpResponseException(stringBuffer.toString());
            }
            if (Wire.HEADER_WIRE.enabled()) {
                Wire wire = Wire.HEADER_WIRE;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(readLine);
                stringBuffer2.append("\r\n");
                wire.input(stringBuffer2.toString());
            }
            if (readLine != null && StatusLine.startsWithHTTP(readLine)) {
                StatusLine statusLine2 = new StatusLine(readLine);
                this.statusLine = statusLine2;
                String httpVersion = statusLine2.getHttpVersion();
                if (!getParams().isParameterFalse(HttpMethodParams.UNAMBIGUOUS_STATUS_LINE) || !httpVersion.equals("HTTP")) {
                    this.effectiveVersion = HttpVersion.parse(httpVersion);
                    return;
                }
                getParams().setVersion(HttpVersion.HTTP_1_0);
                Log log = LOG;
                if (log.isWarnEnabled()) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Ambiguous status line (HTTP protocol version missing):");
                    stringBuffer3.append(this.statusLine.toString());
                    log.warn(stringBuffer3.toString());
                    return;
                }
                return;
            } else if (readLine == null || i2 >= intParameter) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("The server ");
                stringBuffer4.append(httpConnection.getHost());
                stringBuffer4.append(" failed to respond with a valid HTTP response");
            } else {
                i2++;
            }
        }
        StringBuffer stringBuffer42 = new StringBuffer();
        stringBuffer42.append("The server ");
        stringBuffer42.append(httpConnection.getHost());
        stringBuffer42.append(" failed to respond with a valid HTTP response");
        throw new ProtocolException(stringBuffer42.toString());
    }

    public void recycle() {
        LOG.trace("enter HttpMethodBase.recycle()");
        releaseConnection();
        this.path = null;
        this.followRedirects = false;
        this.doAuthentication = true;
        this.queryString = null;
        getRequestHeaderGroup().clear();
        getResponseHeaderGroup().clear();
        getResponseTrailerHeaderGroup().clear();
        this.statusLine = null;
        this.effectiveVersion = null;
        this.aborted = false;
        this.used = false;
        this.params = new HttpMethodParams();
        this.responseBody = null;
        this.recoverableExceptionCount = 0;
        this.connectionCloseForced = false;
        this.hostAuthState.invalidate();
        this.proxyAuthState.invalidate();
        this.cookiespec = null;
        this.requestSent = false;
    }

    public void releaseConnection() {
        try {
            InputStream inputStream = this.responseStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
        } finally {
            ensureConnectionRelease();
        }
    }

    public void removeRequestHeader(String str) {
        Header[] headers = getRequestHeaderGroup().getHeaders(str);
        for (Header removeHeader : headers) {
            getRequestHeaderGroup().removeHeader(removeHeader);
        }
    }

    /* access modifiers changed from: protected */
    public void responseBodyConsumed() {
        this.responseStream = null;
        HttpConnection httpConnection = this.responseConnection;
        if (httpConnection != null) {
            httpConnection.setLastResponseInputStream((InputStream) null);
            if (!shouldCloseConnection(this.responseConnection)) {
                try {
                    if (this.responseConnection.isResponseAvailable()) {
                        if (getParams().isParameterTrue(HttpMethodParams.WARN_EXTRA_INPUT)) {
                            LOG.warn("Extra response data detected - closing connection");
                        }
                        this.responseConnection.close();
                    }
                } catch (IOException e2) {
                    LOG.warn(e2.getMessage());
                }
            }
            this.responseConnection.close();
        }
        this.connectionCloseForced = false;
        ensureConnectionRelease();
    }

    /* access modifiers changed from: protected */
    public void setConnectionCloseForced(boolean z) {
        Log log = LOG;
        if (log.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Force-close connection: ");
            stringBuffer.append(z);
            log.debug(stringBuffer.toString());
        }
        this.connectionCloseForced = z;
    }

    public void setDoAuthentication(boolean z) {
        this.doAuthentication = z;
    }

    public void setFollowRedirects(boolean z) {
        this.followRedirects = z;
    }

    public void setHostConfiguration(HostConfiguration hostConfiguration) {
        if (hostConfiguration != null) {
            this.httphost = new HttpHost(hostConfiguration.getHost(), hostConfiguration.getPort(), hostConfiguration.getProtocol());
        } else {
            this.httphost = null;
        }
    }

    public void setHttp11(boolean z) {
        HttpMethodParams httpMethodParams;
        HttpVersion httpVersion;
        if (z) {
            httpMethodParams = this.params;
            httpVersion = HttpVersion.HTTP_1_1;
        } else {
            httpMethodParams = this.params;
            httpVersion = HttpVersion.HTTP_1_0;
        }
        httpMethodParams.setVersion(httpVersion);
    }

    public void setMethodRetryHandler(MethodRetryHandler methodRetryHandler2) {
        this.methodRetryHandler = methodRetryHandler2;
    }

    public void setParams(HttpMethodParams httpMethodParams) {
        if (httpMethodParams != null) {
            this.params = httpMethodParams;
            return;
        }
        throw new IllegalArgumentException("Parameters may not be null");
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setQueryString(String str) {
        this.queryString = str;
    }

    public void setRequestHeader(String str, String str2) {
        setRequestHeader(new Header(str, str2));
    }

    /* access modifiers changed from: protected */
    public void setResponseStream(InputStream inputStream) {
        this.responseStream = inputStream;
    }

    public void setStrictMode(boolean z) {
        if (z) {
            this.params.makeStrict();
        } else {
            this.params.makeLenient();
        }
    }

    public void setURI(URI uri) throws URIException {
        if (uri.isAbsoluteURI()) {
            this.httphost = new HttpHost(uri);
        }
        setPath(uri.getPath() == null ? "/" : uri.getEscapedPath());
        setQueryString(uri.getEscapedQuery());
    }

    /* access modifiers changed from: protected */
    public boolean shouldCloseConnection(HttpConnection httpConnection) {
        StringBuffer stringBuffer;
        String str;
        if (isConnectionCloseForced()) {
            LOG.debug("Should force-close connection.");
            return true;
        }
        Header firstHeader = !httpConnection.isTransparent() ? this.responseHeaders.getFirstHeader("proxy-connection") : null;
        if (firstHeader == null) {
            firstHeader = this.responseHeaders.getFirstHeader("connection");
        }
        if (firstHeader == null) {
            firstHeader = this.requestHeaders.getFirstHeader("connection");
        }
        if (firstHeader != null) {
            if (firstHeader.getValue().equalsIgnoreCase("close")) {
                Log log = LOG;
                if (log.isDebugEnabled()) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Should close connection in response to directive: ");
                    stringBuffer2.append(firstHeader.getValue());
                    log.debug(stringBuffer2.toString());
                }
                return true;
            } else if (firstHeader.getValue().equalsIgnoreCase("keep-alive")) {
                Log log2 = LOG;
                if (!log2.isDebugEnabled()) {
                    return false;
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Should NOT close connection in response to directive: ");
                stringBuffer3.append(firstHeader.getValue());
                log2.debug(stringBuffer3.toString());
                return false;
            } else {
                Log log3 = LOG;
                if (log3.isDebugEnabled()) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("Unknown directive: ");
                    stringBuffer4.append(firstHeader.toExternalForm());
                    log3.debug(stringBuffer4.toString());
                }
            }
        }
        Log log4 = LOG;
        log4.debug("Resorting to protocol version default close connection policy");
        if (this.effectiveVersion.greaterEquals(HttpVersion.HTTP_1_1)) {
            if (log4.isDebugEnabled()) {
                stringBuffer = new StringBuffer();
                str = "Should NOT close connection, using ";
            }
            return this.effectiveVersion.lessEquals(HttpVersion.HTTP_1_0);
        }
        if (log4.isDebugEnabled()) {
            stringBuffer = new StringBuffer();
            str = "Should close connection, using ";
        }
        return this.effectiveVersion.lessEquals(HttpVersion.HTTP_1_0);
        stringBuffer.append(str);
        stringBuffer.append(this.effectiveVersion.toString());
        log4.debug(stringBuffer.toString());
        return this.effectiveVersion.lessEquals(HttpVersion.HTTP_1_0);
    }

    public boolean validate() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void writeRequest(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        Log log = LOG;
        log.trace("enter HttpMethodBase.writeRequest(HttpState, HttpConnection)");
        writeRequestLine(httpState, httpConnection);
        writeRequestHeaders(httpState, httpConnection);
        httpConnection.writeLine();
        if (Wire.HEADER_WIRE.enabled()) {
            Wire.HEADER_WIRE.output("\r\n");
        }
        HttpVersion version = getParams().getVersion();
        Header requestHeader = getRequestHeader(HttpHeaders.s);
        String value = requestHeader != null ? requestHeader.getValue() : null;
        if (value != null && value.compareToIgnoreCase("100-continue") == 0) {
            if (version.greaterEquals(HttpVersion.HTTP_1_1)) {
                httpConnection.flushRequestOutputStream();
                int soTimeout = httpConnection.getParams().getSoTimeout();
                try {
                    httpConnection.setSocketTimeout(3000);
                    readStatusLine(httpState, httpConnection);
                    processStatusLine(httpState, httpConnection);
                    readResponseHeaders(httpState, httpConnection);
                    processResponseHeaders(httpState, httpConnection);
                    if (this.statusLine.getStatusCode() == 100) {
                        this.statusLine = null;
                        log.debug("OK to continue received");
                        httpConnection.setSocketTimeout(soTimeout);
                    } else {
                        httpConnection.setSocketTimeout(soTimeout);
                        return;
                    }
                } catch (InterruptedIOException e2) {
                    if (ExceptionUtil.isSocketTimeoutException(e2)) {
                        removeRequestHeader(HttpHeaders.s);
                        LOG.info("100 (continue) read timeout. Resume sending the request");
                    } else {
                        throw e2;
                    }
                } catch (Throwable th) {
                    httpConnection.setSocketTimeout(soTimeout);
                    throw th;
                }
            } else {
                removeRequestHeader(HttpHeaders.s);
                log.info("'Expect: 100-continue' handshake is only supported by HTTP/1.1 or higher");
            }
        }
        writeRequestBody(httpState, httpConnection);
        httpConnection.flushRequestOutputStream();
    }

    /* access modifiers changed from: protected */
    public boolean writeRequestBody(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        return true;
    }

    /* access modifiers changed from: protected */
    public void writeRequestHeaders(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter HttpMethodBase.writeRequestHeaders(HttpState,HttpConnection)");
        addRequestHeaders(httpState, httpConnection);
        String httpElementCharset = getParams().getHttpElementCharset();
        Header[] requestHeaders2 = getRequestHeaders();
        for (Header externalForm : requestHeaders2) {
            String externalForm2 = externalForm.toExternalForm();
            if (Wire.HEADER_WIRE.enabled()) {
                Wire.HEADER_WIRE.output(externalForm2);
            }
            httpConnection.print(externalForm2, httpElementCharset);
        }
    }

    /* access modifiers changed from: protected */
    public void writeRequestLine(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter HttpMethodBase.writeRequestLine(HttpState, HttpConnection)");
        String requestLine = getRequestLine(httpConnection);
        if (Wire.HEADER_WIRE.enabled()) {
            Wire.HEADER_WIRE.output(requestLine);
        }
        httpConnection.print(requestLine, getParams().getHttpElementCharset());
    }

    public HttpMethodBase(String str) throws IllegalArgumentException, IllegalStateException {
        if (str != null) {
            try {
                if (str.equals("")) {
                }
                setURI(new URI(str, true, getParams().getUriCharset()));
            } catch (URIException e2) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Invalid uri '");
                stringBuffer.append(str);
                stringBuffer.append("': ");
                stringBuffer.append(e2.getMessage());
                throw new IllegalArgumentException(stringBuffer.toString());
            }
        }
        str = "/";
        setURI(new URI(str, true, getParams().getUriCharset()));
    }

    public void addRequestHeader(Header header) {
        Log log = LOG;
        log.trace("HttpMethodBase.addRequestHeader(Header)");
        if (header == null) {
            log.debug("null header value ignored");
        } else {
            getRequestHeaderGroup().addHeader(header);
        }
    }

    public Header[] getRequestHeaders(String str) {
        return getRequestHeaderGroup().getHeaders(str);
    }

    public byte[] getResponseBody(int i2) throws IOException {
        InputStream responseBodyAsStream;
        if (i2 >= 0) {
            if (this.responseBody == null && (responseBodyAsStream = getResponseBodyAsStream()) != null) {
                long responseContentLength = getResponseContentLength();
                if (responseContentLength == -1 || responseContentLength <= ((long) i2)) {
                    LOG.debug("Buffering response body");
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(responseContentLength > 0 ? (int) responseContentLength : 4096);
                    byte[] bArr = new byte[2048];
                    int i3 = 0;
                    do {
                        int read = responseBodyAsStream.read(bArr, 0, Math.min(2048, i2 - i3));
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                        i3 += read;
                    } while (i3 < i2);
                    setResponseStream((InputStream) null);
                    if (i3 != i2 || responseBodyAsStream.read() == -1) {
                        this.responseBody = byteArrayOutputStream.toByteArray();
                    } else {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Content-Length not known but larger than ");
                        stringBuffer.append(i2);
                        throw new HttpContentTooLargeException(stringBuffer.toString(), i2);
                    }
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Content-Length is ");
                    stringBuffer2.append(responseContentLength);
                    throw new HttpContentTooLargeException(stringBuffer2.toString(), i2);
                }
            }
            return this.responseBody;
        }
        throw new IllegalArgumentException("maxlen must be positive");
    }

    public String getResponseBodyAsString(int i2) throws IOException {
        if (i2 >= 0) {
            byte[] responseBody2 = responseAvailable() ? getResponseBody(i2) : null;
            if (responseBody2 != null) {
                return EncodingUtil.getString(responseBody2, getResponseCharSet());
            }
            return null;
        }
        throw new IllegalArgumentException("maxlen must be positive");
    }

    public Header[] getResponseHeaders(String str) {
        return getResponseHeaderGroup().getHeaders(str);
    }

    /* access modifiers changed from: protected */
    public void readResponseBody(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter HttpMethodBase.readResponseBody(HttpState, HttpConnection)");
        InputStream readResponseBody = readResponseBody(httpConnection);
        if (readResponseBody == null) {
            responseBodyConsumed();
            return;
        }
        httpConnection.setLastResponseInputStream(readResponseBody);
        setResponseStream(readResponseBody);
    }

    public void removeRequestHeader(Header header) {
        if (header != null) {
            getRequestHeaderGroup().removeHeader(header);
        }
    }

    public void setQueryString(NameValuePair[] nameValuePairArr) {
        LOG.trace("enter HttpMethodBase.setQueryString(NameValuePair[])");
        this.queryString = EncodingUtil.formUrlEncode(nameValuePairArr, "UTF-8");
    }

    public void setRequestHeader(Header header) {
        Header[] headers = getRequestHeaderGroup().getHeaders(header.getName());
        for (Header removeHeader : headers) {
            getRequestHeaderGroup().removeHeader(removeHeader);
        }
        getRequestHeaderGroup().addHeader(header);
    }
}
