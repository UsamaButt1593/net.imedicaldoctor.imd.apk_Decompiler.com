package org.apache.commons.httpclient;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.httpclient.auth.AuthChallengeException;
import org.apache.commons.httpclient.auth.AuthChallengeParser;
import org.apache.commons.httpclient.auth.AuthChallengeProcessor;
import org.apache.commons.httpclient.auth.AuthScheme;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.auth.AuthState;
import org.apache.commons.httpclient.auth.AuthenticationException;
import org.apache.commons.httpclient.auth.CredentialsNotAvailableException;
import org.apache.commons.httpclient.auth.CredentialsProvider;
import org.apache.commons.httpclient.auth.MalformedChallengeException;
import org.apache.commons.httpclient.params.HostParams;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class HttpMethodDirector {
    private static final Log LOG;
    public static final String PROXY_AUTH_CHALLENGE = "Proxy-Authenticate";
    public static final String PROXY_AUTH_RESP = "Proxy-Authorization";
    public static final String WWW_AUTH_CHALLENGE = "WWW-Authenticate";
    public static final String WWW_AUTH_RESP = "Authorization";
    static /* synthetic */ Class class$org$apache$commons$httpclient$HttpMethodDirector;
    private AuthChallengeProcessor authProcessor = null;
    private HttpConnection conn;
    private ConnectMethod connectMethod;
    private HttpConnectionManager connectionManager;
    private HostConfiguration hostConfiguration;
    private HttpClientParams params;
    private Set redirectLocations = null;
    private boolean releaseConnection = false;
    private HttpState state;

    static {
        Class cls = class$org$apache$commons$httpclient$HttpMethodDirector;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.HttpMethodDirector");
            class$org$apache$commons$httpclient$HttpMethodDirector = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public HttpMethodDirector(HttpConnectionManager httpConnectionManager, HostConfiguration hostConfiguration2, HttpClientParams httpClientParams, HttpState httpState) {
        this.connectionManager = httpConnectionManager;
        this.hostConfiguration = hostConfiguration2;
        this.params = httpClientParams;
        this.state = httpState;
        this.authProcessor = new AuthChallengeProcessor(this.params);
    }

    private void applyConnectionParams(HttpMethod httpMethod) throws IOException {
        Object parameter = httpMethod.getParams().getParameter("http.socket.timeout");
        if (parameter == null) {
            parameter = this.conn.getParams().getParameter("http.socket.timeout");
        }
        this.conn.setSocketTimeout(parameter != null ? ((Integer) parameter).intValue() : 0);
    }

    private void authenticate(HttpMethod httpMethod) {
        try {
            if (this.conn.isProxied() && !this.conn.isSecure()) {
                authenticateProxy(httpMethod);
            }
            authenticateHost(httpMethod);
        } catch (AuthenticationException e2) {
            LOG.error(e2.getMessage(), e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r1 = r8.getHostAuthState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void authenticateHost(org.apache.commons.httpclient.HttpMethod r8) throws org.apache.commons.httpclient.auth.AuthenticationException {
        /*
            r7 = this;
            java.lang.String r0 = "Authorization"
            boolean r1 = r7.cleanAuthHeaders(r8, r0)
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            org.apache.commons.httpclient.auth.AuthState r1 = r8.getHostAuthState()
            org.apache.commons.httpclient.auth.AuthScheme r2 = r1.getAuthScheme()
            if (r2 != 0) goto L_0x0014
            return
        L_0x0014:
            boolean r1 = r1.isAuthRequested()
            if (r1 != 0) goto L_0x0020
            boolean r1 = r2.isConnectionBased()
            if (r1 != 0) goto L_0x00a0
        L_0x0020:
            org.apache.commons.httpclient.params.HttpMethodParams r1 = r8.getParams()
            java.lang.String r1 = r1.getVirtualHost()
            if (r1 != 0) goto L_0x0030
            org.apache.commons.httpclient.HttpConnection r1 = r7.conn
            java.lang.String r1 = r1.getHost()
        L_0x0030:
            org.apache.commons.httpclient.HttpConnection r3 = r7.conn
            int r3 = r3.getPort()
            org.apache.commons.httpclient.auth.AuthScope r4 = new org.apache.commons.httpclient.auth.AuthScope
            java.lang.String r5 = r2.getRealm()
            java.lang.String r6 = r2.getSchemeName()
            r4.<init>(r1, r3, r5, r6)
            org.apache.commons.logging.Log r1 = LOG
            boolean r3 = r1.isDebugEnabled()
            if (r3 == 0) goto L_0x005f
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            java.lang.String r5 = "Authenticating with "
            r3.append(r5)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.debug(r3)
        L_0x005f:
            org.apache.commons.httpclient.HttpState r3 = r7.state
            org.apache.commons.httpclient.Credentials r3 = r3.getCredentials(r4)
            if (r3 == 0) goto L_0x0077
            java.lang.String r1 = r2.authenticate(r3, r8)
            if (r1 == 0) goto L_0x00a0
            org.apache.commons.httpclient.Header r2 = new org.apache.commons.httpclient.Header
            r3 = 1
            r2.<init>(r0, r1, r3)
            r8.addRequestHeader(r2)
            goto L_0x00a0
        L_0x0077:
            boolean r0 = r1.isWarnEnabled()
            if (r0 == 0) goto L_0x00a0
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r2 = "Required credentials not available for "
            r0.append(r2)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r1.warn(r0)
            org.apache.commons.httpclient.auth.AuthState r8 = r8.getHostAuthState()
            boolean r8 = r8.isPreemptive()
            if (r8 == 0) goto L_0x00a0
            java.lang.String r8 = "Preemptive authentication requested but no default credentials available"
            r1.warn(r8)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.HttpMethodDirector.authenticateHost(org.apache.commons.httpclient.HttpMethod):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r1 = r8.getProxyAuthState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void authenticateProxy(org.apache.commons.httpclient.HttpMethod r8) throws org.apache.commons.httpclient.auth.AuthenticationException {
        /*
            r7 = this;
            java.lang.String r0 = "Proxy-Authorization"
            boolean r1 = r7.cleanAuthHeaders(r8, r0)
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            org.apache.commons.httpclient.auth.AuthState r1 = r8.getProxyAuthState()
            org.apache.commons.httpclient.auth.AuthScheme r2 = r1.getAuthScheme()
            if (r2 != 0) goto L_0x0014
            return
        L_0x0014:
            boolean r1 = r1.isAuthRequested()
            if (r1 != 0) goto L_0x0020
            boolean r1 = r2.isConnectionBased()
            if (r1 != 0) goto L_0x0096
        L_0x0020:
            org.apache.commons.httpclient.auth.AuthScope r1 = new org.apache.commons.httpclient.auth.AuthScope
            org.apache.commons.httpclient.HttpConnection r3 = r7.conn
            java.lang.String r3 = r3.getProxyHost()
            org.apache.commons.httpclient.HttpConnection r4 = r7.conn
            int r4 = r4.getProxyPort()
            java.lang.String r5 = r2.getRealm()
            java.lang.String r6 = r2.getSchemeName()
            r1.<init>(r3, r4, r5, r6)
            org.apache.commons.logging.Log r3 = LOG
            boolean r4 = r3.isDebugEnabled()
            if (r4 == 0) goto L_0x0055
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            java.lang.String r5 = "Authenticating with "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            r3.debug(r4)
        L_0x0055:
            org.apache.commons.httpclient.HttpState r4 = r7.state
            org.apache.commons.httpclient.Credentials r4 = r4.getProxyCredentials(r1)
            if (r4 == 0) goto L_0x006d
            java.lang.String r1 = r2.authenticate(r4, r8)
            if (r1 == 0) goto L_0x0096
            org.apache.commons.httpclient.Header r2 = new org.apache.commons.httpclient.Header
            r3 = 1
            r2.<init>(r0, r1, r3)
            r8.addRequestHeader(r2)
            goto L_0x0096
        L_0x006d:
            boolean r0 = r3.isWarnEnabled()
            if (r0 == 0) goto L_0x0096
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r2 = "Required proxy credentials not available for "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3.warn(r0)
            org.apache.commons.httpclient.auth.AuthState r8 = r8.getProxyAuthState()
            boolean r8 = r8.isPreemptive()
            if (r8 == 0) goto L_0x0096
            java.lang.String r8 = "Preemptive authentication requested but no default proxy credentials available"
            r3.warn(r8)
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.HttpMethodDirector.authenticateProxy(org.apache.commons.httpclient.HttpMethod):void");
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private boolean cleanAuthHeaders(HttpMethod httpMethod, String str) {
        Header[] requestHeaders = httpMethod.getRequestHeaders(str);
        boolean z = true;
        for (Header header : requestHeaders) {
            if (header.isAutogenerated()) {
                httpMethod.removeRequestHeader(header);
            } else {
                z = false;
            }
        }
        return z;
    }

    private boolean executeConnect() throws IOException, HttpException {
        int statusCode;
        ConnectMethod connectMethod2 = new ConnectMethod(this.hostConfiguration);
        this.connectMethod = connectMethod2;
        connectMethod2.getParams().setDefaults(this.hostConfiguration.getParams());
        while (true) {
            if (!this.conn.isOpen()) {
                this.conn.open();
            }
            if (this.params.isAuthenticationPreemptive() || this.state.isAuthenticationPreemptive()) {
                LOG.debug("Preemptively sending default basic credentials");
                this.connectMethod.getProxyAuthState().setPreemptive();
                this.connectMethod.getProxyAuthState().setAuthAttempted(true);
            }
            try {
                authenticateProxy(this.connectMethod);
            } catch (AuthenticationException e2) {
                LOG.error(e2.getMessage(), e2);
            }
            applyConnectionParams(this.connectMethod);
            this.connectMethod.execute(this.state, this.conn);
            statusCode = this.connectMethod.getStatusCode();
            AuthState proxyAuthState = this.connectMethod.getProxyAuthState();
            proxyAuthState.setAuthRequested(statusCode == 407);
            if (proxyAuthState.isAuthRequested() && processAuthenticationResponse(this.connectMethod)) {
                if (this.connectMethod.getResponseBodyAsStream() != null) {
                    this.connectMethod.getResponseBodyAsStream().close();
                }
            }
        }
        if (statusCode < 200 || statusCode >= 300) {
            this.conn.close();
            return false;
        }
        this.conn.tunnelCreated();
        this.connectMethod = null;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0111, code lost:
        if (r12.conn.isOpen() != false) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0113, code lost:
        LOG.debug("Closing the connection.");
        r12.conn.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x011d, code lost:
        r12.releaseConnection = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011f, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0027 A[Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027, IOException -> 0x00a9, RuntimeException -> 0x0027 }, ExcHandler: RuntimeException (r13v3 'e' java.lang.RuntimeException A[CUSTOM_DECLARE, Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027, IOException -> 0x00a9, RuntimeException -> 0x0027 }]), Splitter:B:2:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void executeWithRetry(org.apache.commons.httpclient.HttpMethod r13) throws java.io.IOException, org.apache.commons.httpclient.HttpException {
        /*
            r12 = this;
            java.lang.String r0 = "Closing the connection."
            r1 = 0
        L_0x0003:
            r2 = 1
            int r1 = r1 + r2
            org.apache.commons.logging.Log r3 = LOG     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            boolean r4 = r3.isTraceEnabled()     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            if (r4 == 0) goto L_0x0030
            java.lang.StringBuffer r4 = new java.lang.StringBuffer     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            r4.<init>()     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            java.lang.String r5 = "Attempt number "
            r4.append(r5)     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            r4.append(r1)     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            java.lang.String r5 = " to process request"
            r4.append(r5)     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            java.lang.String r4 = r4.toString()     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            r3.trace(r4)     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            goto L_0x0030
        L_0x0027:
            r13 = move-exception
            goto L_0x010b
        L_0x002a:
            r3 = move-exception
            r9 = r3
            goto L_0x0074
        L_0x002d:
            r13 = move-exception
            goto L_0x010a
        L_0x0030:
            org.apache.commons.httpclient.HttpConnection r3 = r12.conn     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            org.apache.commons.httpclient.params.HttpConnectionParams r3 = r3.getParams()     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            boolean r3 = r3.isStaleCheckingEnabled()     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            if (r3 == 0) goto L_0x0041
            org.apache.commons.httpclient.HttpConnection r3 = r12.conn     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            r3.closeIfStale()     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
        L_0x0041:
            org.apache.commons.httpclient.HttpConnection r3 = r12.conn     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            boolean r3 = r3.isOpen()     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            if (r3 != 0) goto L_0x0069
            org.apache.commons.httpclient.HttpConnection r3 = r12.conn     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            r3.open()     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            org.apache.commons.httpclient.HttpConnection r3 = r12.conn     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            boolean r3 = r3.isProxied()     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            if (r3 == 0) goto L_0x0069
            org.apache.commons.httpclient.HttpConnection r3 = r12.conn     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            boolean r3 = r3.isSecure()     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            if (r3 == 0) goto L_0x0069
            boolean r3 = r13 instanceof org.apache.commons.httpclient.ConnectMethod     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            if (r3 != 0) goto L_0x0069
            boolean r3 = r12.executeConnect()     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            if (r3 != 0) goto L_0x0069
            return
        L_0x0069:
            r12.applyConnectionParams(r13)     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            org.apache.commons.httpclient.HttpState r3 = r12.state     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            org.apache.commons.httpclient.HttpConnection r4 = r12.conn     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            r13.execute(r3, r4)     // Catch:{ HttpException -> 0x002d, IOException -> 0x002a, RuntimeException -> 0x0027 }
            return
        L_0x0074:
            org.apache.commons.logging.Log r10 = LOG     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            r10.debug(r0)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            org.apache.commons.httpclient.HttpConnection r3 = r12.conn     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            r3.close()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            boolean r3 = r13 instanceof org.apache.commons.httpclient.HttpMethodBase     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            java.lang.String r11 = "Method retry handler returned false. Automatic recovery will not be attempted"
            if (r3 == 0) goto L_0x00ab
            r3 = r13
            org.apache.commons.httpclient.HttpMethodBase r3 = (org.apache.commons.httpclient.HttpMethodBase) r3     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            org.apache.commons.httpclient.MethodRetryHandler r3 = r3.getMethodRetryHandler()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            if (r3 == 0) goto L_0x00ab
            org.apache.commons.httpclient.HttpConnection r5 = r12.conn     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            org.apache.commons.httpclient.HttpRecoverableException r6 = new org.apache.commons.httpclient.HttpRecoverableException     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            java.lang.String r4 = r9.getMessage()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            r6.<init>(r4)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            boolean r8 = r13.isRequestSent()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            r4 = r13
            r7 = r1
            boolean r3 = r3.retryMethod(r4, r5, r6, r7, r8)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            if (r3 == 0) goto L_0x00a5
            goto L_0x00ab
        L_0x00a5:
            r10.debug(r11)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            throw r9     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
        L_0x00a9:
            r13 = move-exception
            goto L_0x0120
        L_0x00ab:
            org.apache.commons.httpclient.params.HttpMethodParams r3 = r13.getParams()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            java.lang.String r4 = "http.method.retry-handler"
            java.lang.Object r3 = r3.getParameter(r4)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            org.apache.commons.httpclient.HttpMethodRetryHandler r3 = (org.apache.commons.httpclient.HttpMethodRetryHandler) r3     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            if (r3 != 0) goto L_0x00be
            org.apache.commons.httpclient.DefaultHttpMethodRetryHandler r3 = new org.apache.commons.httpclient.DefaultHttpMethodRetryHandler     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            r3.<init>()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
        L_0x00be:
            boolean r3 = r3.retryMethod(r13, r9, r1)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            if (r3 == 0) goto L_0x0106
            boolean r3 = r10.isInfoEnabled()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            if (r3 == 0) goto L_0x00f2
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            r3.<init>()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            java.lang.String r4 = "I/O exception ("
            r3.append(r4)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            java.lang.Class r4 = r9.getClass()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            java.lang.String r4 = r4.getName()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            r3.append(r4)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            java.lang.String r4 = ") caught when processing request: "
            r3.append(r4)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            java.lang.String r4 = r9.getMessage()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            r3.append(r4)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            r10.info(r3)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
        L_0x00f2:
            boolean r3 = r10.isDebugEnabled()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            if (r3 == 0) goto L_0x00ff
            java.lang.String r3 = r9.getMessage()     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            r10.debug(r3, r9)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
        L_0x00ff:
            java.lang.String r3 = "Retrying request"
            r10.info(r3)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            goto L_0x0003
        L_0x0106:
            r10.debug(r11)     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
            throw r9     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
        L_0x010a:
            throw r13     // Catch:{ IOException -> 0x00a9, RuntimeException -> 0x0027 }
        L_0x010b:
            org.apache.commons.httpclient.HttpConnection r1 = r12.conn
            boolean r1 = r1.isOpen()
            if (r1 == 0) goto L_0x011d
            org.apache.commons.logging.Log r1 = LOG
            r1.debug(r0)
            org.apache.commons.httpclient.HttpConnection r0 = r12.conn
            r0.close()
        L_0x011d:
            r12.releaseConnection = r2
            throw r13
        L_0x0120:
            org.apache.commons.httpclient.HttpConnection r1 = r12.conn
            boolean r1 = r1.isOpen()
            if (r1 == 0) goto L_0x0132
            org.apache.commons.logging.Log r1 = LOG
            r1.debug(r0)
            org.apache.commons.httpclient.HttpConnection r0 = r12.conn
            r0.close()
        L_0x0132:
            r12.releaseConnection = r2
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.HttpMethodDirector.executeWithRetry(org.apache.commons.httpclient.HttpMethod):void");
    }

    private void fakeResponse(HttpMethod httpMethod) throws IOException, HttpException {
        Log log = LOG;
        log.debug("CONNECT failed, fake the response for the original method");
        if (httpMethod instanceof HttpMethodBase) {
            ((HttpMethodBase) httpMethod).fakeResponse(this.connectMethod.getStatusLine(), this.connectMethod.getResponseHeaderGroup(), this.connectMethod.getResponseBodyAsStream());
            httpMethod.getProxyAuthState().setAuthScheme(this.connectMethod.getProxyAuthState().getAuthScheme());
            this.connectMethod = null;
            return;
        }
        this.releaseConnection = true;
        log.warn("Unable to fake response on method as it is not derived from HttpMethodBase.");
    }

    private boolean isAuthenticationNeeded(HttpMethod httpMethod) {
        httpMethod.getHostAuthState().setAuthRequested(httpMethod.getStatusCode() == 401);
        httpMethod.getProxyAuthState().setAuthRequested(httpMethod.getStatusCode() == 407);
        if (!httpMethod.getHostAuthState().isAuthRequested() && !httpMethod.getProxyAuthState().isAuthRequested()) {
            return false;
        }
        Log log = LOG;
        log.debug("Authorization required");
        if (httpMethod.getDoAuthentication()) {
            return true;
        }
        log.info("Authentication requested but doAuthentication is disabled");
        return false;
    }

    private boolean isRedirectNeeded(HttpMethod httpMethod) {
        int statusCode = httpMethod.getStatusCode();
        if (statusCode != 307) {
            switch (statusCode) {
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        LOG.debug("Redirect required");
        return httpMethod.getFollowRedirects();
    }

    private boolean processAuthenticationResponse(HttpMethod httpMethod) {
        LOG.trace("enter HttpMethodBase.processAuthenticationResponse(HttpState, HttpConnection)");
        try {
            int statusCode = httpMethod.getStatusCode();
            if (statusCode == 401) {
                return processWWWAuthChallenge(httpMethod);
            }
            if (statusCode != 407) {
                return false;
            }
            return processProxyAuthChallenge(httpMethod);
        } catch (Exception e2) {
            Log log = LOG;
            if (log.isErrorEnabled()) {
                log.error(e2.getMessage(), e2);
            }
            return false;
        }
    }

    private boolean processProxyAuthChallenge(HttpMethod httpMethod) throws MalformedChallengeException, AuthenticationException {
        AuthScheme authScheme;
        AuthState proxyAuthState = httpMethod.getProxyAuthState();
        Map parseChallenges = AuthChallengeParser.parseChallenges(httpMethod.getResponseHeaders("Proxy-Authenticate"));
        if (parseChallenges.isEmpty()) {
            LOG.debug("Proxy authentication challenge(s) not found");
            return false;
        }
        try {
            authScheme = this.authProcessor.processChallenge(proxyAuthState, parseChallenges);
        } catch (AuthChallengeException e2) {
            Log log = LOG;
            if (log.isWarnEnabled()) {
                log.warn(e2.getMessage());
            }
            authScheme = null;
        }
        if (authScheme == null) {
            return false;
        }
        AuthScope authScope = new AuthScope(this.conn.getProxyHost(), this.conn.getProxyPort(), authScheme.getRealm(), authScheme.getSchemeName());
        Log log2 = LOG;
        if (log2.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Proxy authentication scope: ");
            stringBuffer.append(authScope);
            log2.debug(stringBuffer.toString());
        }
        if (!proxyAuthState.isAuthAttempted() || !authScheme.isComplete()) {
            proxyAuthState.setAuthAttempted(true);
            Credentials proxyCredentials = this.state.getProxyCredentials(authScope);
            if (proxyCredentials == null) {
                proxyCredentials = promptForProxyCredentials(authScheme, httpMethod.getParams(), authScope);
            }
            if (proxyCredentials != null) {
                return true;
            }
            if (log2.isInfoEnabled()) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("No credentials available for ");
                stringBuffer2.append(authScope);
                log2.info(stringBuffer2.toString());
            }
            return false;
        } else if (promptForProxyCredentials(authScheme, httpMethod.getParams(), authScope) != null) {
            return true;
        } else {
            if (log2.isInfoEnabled()) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Failure authenticating with ");
                stringBuffer3.append(authScope);
                log2.info(stringBuffer3.toString());
            }
            return false;
        }
    }

    private boolean processRedirectResponse(HttpMethod httpMethod) throws RedirectException {
        Header responseHeader = httpMethod.getResponseHeader("location");
        if (responseHeader == null) {
            Log log = LOG;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Received redirect response ");
            stringBuffer.append(httpMethod.getStatusCode());
            stringBuffer.append(" but no location header");
            log.error(stringBuffer.toString());
            return false;
        }
        String value = responseHeader.getValue();
        Log log2 = LOG;
        if (log2.isDebugEnabled()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Redirect requested to location '");
            stringBuffer2.append(value);
            stringBuffer2.append("'");
            log2.debug(stringBuffer2.toString());
        }
        try {
            URI uri = new URI(this.conn.getProtocol().getScheme(), (String) null, this.conn.getHost(), this.conn.getPort(), httpMethod.getPath());
            URI uri2 = new URI(value, true, httpMethod.getParams().getUriCharset());
            if (!uri2.isRelativeURI()) {
                httpMethod.getParams().setDefaults(this.params);
            } else if (this.params.isParameterTrue(HttpClientParams.REJECT_RELATIVE_REDIRECT)) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Relative redirect location '");
                stringBuffer3.append(value);
                stringBuffer3.append("' not allowed");
                log2.warn(stringBuffer3.toString());
                return false;
            } else {
                log2.debug("Redirect URI is not absolute - parsing as relative");
                uri2 = new URI(uri, uri2);
            }
            httpMethod.setURI(uri2);
            this.hostConfiguration.setHost(uri2);
            if (this.params.isParameterFalse(HttpClientParams.ALLOW_CIRCULAR_REDIRECTS)) {
                if (this.redirectLocations == null) {
                    this.redirectLocations = new HashSet();
                }
                this.redirectLocations.add(uri);
                try {
                    if (uri2.hasQuery()) {
                        uri2.setQuery((String) null);
                    }
                    if (this.redirectLocations.contains(uri2)) {
                        StringBuffer stringBuffer4 = new StringBuffer();
                        stringBuffer4.append("Circular redirect to '");
                        stringBuffer4.append(uri2);
                        stringBuffer4.append("'");
                        throw new CircularRedirectException(stringBuffer4.toString());
                    }
                } catch (URIException unused) {
                    return false;
                }
            }
            if (log2.isDebugEnabled()) {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("Redirecting from '");
                stringBuffer5.append(uri.getEscapedURI());
                stringBuffer5.append("' to '");
                stringBuffer5.append(uri2.getEscapedURI());
                log2.debug(stringBuffer5.toString());
            }
            httpMethod.getHostAuthState().invalidate();
            return true;
        } catch (URIException e2) {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Invalid redirect location: ");
            stringBuffer6.append(value);
            throw new InvalidRedirectLocationException(stringBuffer6.toString(), value, e2);
        }
    }

    private boolean processWWWAuthChallenge(HttpMethod httpMethod) throws MalformedChallengeException, AuthenticationException {
        AuthScheme authScheme;
        AuthState hostAuthState = httpMethod.getHostAuthState();
        Map parseChallenges = AuthChallengeParser.parseChallenges(httpMethod.getResponseHeaders("WWW-Authenticate"));
        if (parseChallenges.isEmpty()) {
            LOG.debug("Authentication challenge(s) not found");
            return false;
        }
        try {
            authScheme = this.authProcessor.processChallenge(hostAuthState, parseChallenges);
        } catch (AuthChallengeException e2) {
            Log log = LOG;
            if (log.isWarnEnabled()) {
                log.warn(e2.getMessage());
            }
            authScheme = null;
        }
        if (authScheme == null) {
            return false;
        }
        String virtualHost = httpMethod.getParams().getVirtualHost();
        if (virtualHost == null) {
            virtualHost = this.conn.getHost();
        }
        AuthScope authScope = new AuthScope(virtualHost, this.conn.getPort(), authScheme.getRealm(), authScheme.getSchemeName());
        Log log2 = LOG;
        if (log2.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Authentication scope: ");
            stringBuffer.append(authScope);
            log2.debug(stringBuffer.toString());
        }
        if (!hostAuthState.isAuthAttempted() || !authScheme.isComplete()) {
            hostAuthState.setAuthAttempted(true);
            Credentials credentials = this.state.getCredentials(authScope);
            if (credentials == null) {
                credentials = promptForCredentials(authScheme, httpMethod.getParams(), authScope);
            }
            if (credentials != null) {
                return true;
            }
            if (log2.isInfoEnabled()) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("No credentials available for ");
                stringBuffer2.append(authScope);
                log2.info(stringBuffer2.toString());
            }
            return false;
        } else if (promptForCredentials(authScheme, httpMethod.getParams(), authScope) != null) {
            return true;
        } else {
            if (log2.isInfoEnabled()) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Failure authenticating with ");
                stringBuffer3.append(authScope);
                log2.info(stringBuffer3.toString());
            }
            return false;
        }
    }

    private Credentials promptForCredentials(AuthScheme authScheme, HttpParams httpParams, AuthScope authScope) {
        Log log = LOG;
        log.debug("Credentials required");
        CredentialsProvider credentialsProvider = (CredentialsProvider) httpParams.getParameter(CredentialsProvider.PROVIDER);
        Credentials credentials = null;
        if (credentialsProvider != null) {
            try {
                credentials = credentialsProvider.getCredentials(authScheme, authScope.getHost(), authScope.getPort(), false);
            } catch (CredentialsNotAvailableException e2) {
                LOG.warn(e2.getMessage());
            }
            if (credentials != null) {
                this.state.setCredentials(authScope, credentials);
                Log log2 = LOG;
                if (log2.isDebugEnabled()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(authScope);
                    stringBuffer.append(" new credentials given");
                    log2.debug(stringBuffer.toString());
                }
            }
        } else {
            log.debug("Credentials provider not available");
        }
        return credentials;
    }

    private Credentials promptForProxyCredentials(AuthScheme authScheme, HttpParams httpParams, AuthScope authScope) {
        Log log = LOG;
        log.debug("Proxy credentials required");
        CredentialsProvider credentialsProvider = (CredentialsProvider) httpParams.getParameter(CredentialsProvider.PROVIDER);
        Credentials credentials = null;
        if (credentialsProvider != null) {
            try {
                credentials = credentialsProvider.getCredentials(authScheme, authScope.getHost(), authScope.getPort(), true);
            } catch (CredentialsNotAvailableException e2) {
                LOG.warn(e2.getMessage());
            }
            if (credentials != null) {
                this.state.setProxyCredentials(authScope, credentials);
                Log log2 = LOG;
                if (log2.isDebugEnabled()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(authScope);
                    stringBuffer.append(" new credentials given");
                    log2.debug(stringBuffer.toString());
                }
            }
        } else {
            log.debug("Proxy credentials provider not available");
        }
        return credentials;
    }

    public void executeMethod(HttpMethod httpMethod) throws IOException, HttpException {
        HttpConnection httpConnection;
        HttpConnection httpConnection2;
        boolean z;
        if (httpMethod != null) {
            this.hostConfiguration.getParams().setDefaults(this.params);
            httpMethod.getParams().setDefaults(this.hostConfiguration.getParams());
            Collection<Header> collection = (Collection) this.hostConfiguration.getParams().getParameter(HostParams.DEFAULT_HEADERS);
            if (collection != null) {
                for (Header addRequestHeader : collection) {
                    httpMethod.addRequestHeader(addRequestHeader);
                }
            }
            try {
                int intParameter = this.params.getIntParameter(HttpClientParams.MAX_REDIRECTS, 100);
                int i2 = 0;
                while (true) {
                    HttpConnection httpConnection3 = this.conn;
                    if (httpConnection3 != null && !this.hostConfiguration.hostEquals(httpConnection3)) {
                        this.conn.setLocked(false);
                        this.conn.releaseConnection();
                        this.conn = null;
                    }
                    boolean z2 = true;
                    if (this.conn == null) {
                        HttpConnection connectionWithTimeout = this.connectionManager.getConnectionWithTimeout(this.hostConfiguration, this.params.getConnectionManagerTimeout());
                        this.conn = connectionWithTimeout;
                        connectionWithTimeout.setLocked(true);
                        if (this.params.isAuthenticationPreemptive() || this.state.isAuthenticationPreemptive()) {
                            LOG.debug("Preemptively sending default basic credentials");
                            httpMethod.getHostAuthState().setPreemptive();
                            httpMethod.getHostAuthState().setAuthAttempted(true);
                            if (this.conn.isProxied() && !this.conn.isSecure()) {
                                httpMethod.getProxyAuthState().setPreemptive();
                                httpMethod.getProxyAuthState().setAuthAttempted(true);
                            }
                        }
                    }
                    authenticate(httpMethod);
                    executeWithRetry(httpMethod);
                    if (this.connectMethod != null) {
                        fakeResponse(httpMethod);
                        break;
                    }
                    if (!isRedirectNeeded(httpMethod) || !processRedirectResponse(httpMethod)) {
                        z = false;
                    } else {
                        i2++;
                        if (i2 < intParameter) {
                            Log log = LOG;
                            if (log.isDebugEnabled()) {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("Execute redirect ");
                                stringBuffer.append(i2);
                                stringBuffer.append(" of ");
                                stringBuffer.append(intParameter);
                                log.debug(stringBuffer.toString());
                            }
                            z = true;
                        } else {
                            LOG.error("Narrowly avoided an infinite loop in execute");
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("Maximum redirects (");
                            stringBuffer2.append(intParameter);
                            stringBuffer2.append(") exceeded");
                            throw new RedirectException(stringBuffer2.toString());
                        }
                    }
                    if (!isAuthenticationNeeded(httpMethod) || !processAuthenticationResponse(httpMethod)) {
                        z2 = z;
                    } else {
                        LOG.debug("Retry authentication");
                    }
                    if (!z2) {
                        break;
                    } else if (httpMethod.getResponseBodyAsStream() != null) {
                        httpMethod.getResponseBodyAsStream().close();
                    }
                }
                HttpConnection httpConnection4 = this.conn;
                if (httpConnection4 != null) {
                    httpConnection4.setLocked(false);
                }
                if ((this.releaseConnection || httpMethod.getResponseBodyAsStream() == null) && (httpConnection2 = this.conn) != null) {
                    httpConnection2.releaseConnection();
                }
            } catch (Throwable th) {
                HttpConnection httpConnection5 = this.conn;
                if (httpConnection5 != null) {
                    httpConnection5.setLocked(false);
                }
                if ((this.releaseConnection || httpMethod.getResponseBodyAsStream() == null) && (httpConnection = this.conn) != null) {
                    httpConnection.releaseConnection();
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Method may not be null");
        }
    }

    public HttpConnectionManager getConnectionManager() {
        return this.connectionManager;
    }

    public HostConfiguration getHostConfiguration() {
        return this.hostConfiguration;
    }

    public HttpParams getParams() {
        return this.params;
    }

    public HttpState getState() {
        return this.state;
    }
}
