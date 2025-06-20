package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleHttpConnectionManager implements HttpConnectionManager {
    private static final Log LOG;
    private static final String MISUSE_MESSAGE = "SimpleHttpConnectionManager being used incorrectly.  Be sure that HttpMethod.releaseConnection() is always called and that only one thread and/or method is using this connection manager at a time.";
    static /* synthetic */ Class class$org$apache$commons$httpclient$SimpleHttpConnectionManager;
    private boolean alwaysClose;
    protected HttpConnection httpConnection;
    private long idleStartTime;
    private volatile boolean inUse;
    private HttpConnectionManagerParams params;

    static {
        Class cls = class$org$apache$commons$httpclient$SimpleHttpConnectionManager;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.SimpleHttpConnectionManager");
            class$org$apache$commons$httpclient$SimpleHttpConnectionManager = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public SimpleHttpConnectionManager() {
        this.params = new HttpConnectionManagerParams();
        this.idleStartTime = Long.MAX_VALUE;
        this.inUse = false;
        this.alwaysClose = false;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    static void finishLastResponse(HttpConnection httpConnection2) {
        InputStream lastResponseInputStream = httpConnection2.getLastResponseInputStream();
        if (lastResponseInputStream != null) {
            httpConnection2.setLastResponseInputStream((InputStream) null);
            try {
                lastResponseInputStream.close();
            } catch (IOException unused) {
                httpConnection2.close();
            }
        }
    }

    public void closeIdleConnections(long j2) {
        if (this.idleStartTime <= System.currentTimeMillis() - j2) {
            this.httpConnection.close();
        }
    }

    public HttpConnection getConnection(HostConfiguration hostConfiguration) {
        return getConnection(hostConfiguration, 0);
    }

    public HttpConnection getConnectionWithTimeout(HostConfiguration hostConfiguration, long j2) {
        HttpConnection httpConnection2 = this.httpConnection;
        if (httpConnection2 == null) {
            HttpConnection httpConnection3 = new HttpConnection(hostConfiguration);
            this.httpConnection = httpConnection3;
            httpConnection3.setHttpConnectionManager(this);
            this.httpConnection.getParams().setDefaults(this.params);
        } else if (!hostConfiguration.hostEquals(httpConnection2) || !hostConfiguration.proxyEquals(this.httpConnection)) {
            if (this.httpConnection.isOpen()) {
                this.httpConnection.close();
            }
            this.httpConnection.setHost(hostConfiguration.getHost());
            this.httpConnection.setPort(hostConfiguration.getPort());
            this.httpConnection.setProtocol(hostConfiguration.getProtocol());
            this.httpConnection.setLocalAddress(hostConfiguration.getLocalAddress());
            this.httpConnection.setProxyHost(hostConfiguration.getProxyHost());
            this.httpConnection.setProxyPort(hostConfiguration.getProxyPort());
        } else {
            finishLastResponse(this.httpConnection);
        }
        this.idleStartTime = Long.MAX_VALUE;
        if (this.inUse) {
            LOG.warn(MISUSE_MESSAGE);
        }
        this.inUse = true;
        return this.httpConnection;
    }

    public HttpConnectionManagerParams getParams() {
        return this.params;
    }

    public boolean isConnectionStaleCheckingEnabled() {
        return this.params.isStaleCheckingEnabled();
    }

    public void releaseConnection(HttpConnection httpConnection2) {
        HttpConnection httpConnection3 = this.httpConnection;
        if (httpConnection2 == httpConnection3) {
            if (this.alwaysClose) {
                httpConnection3.close();
            } else {
                finishLastResponse(httpConnection3);
            }
            this.inUse = false;
            this.idleStartTime = System.currentTimeMillis();
            return;
        }
        throw new IllegalStateException("Unexpected release of an unknown connection.");
    }

    public void setConnectionStaleCheckingEnabled(boolean z) {
        this.params.setStaleCheckingEnabled(z);
    }

    public void setParams(HttpConnectionManagerParams httpConnectionManagerParams) {
        if (httpConnectionManagerParams != null) {
            this.params = httpConnectionManagerParams;
            return;
        }
        throw new IllegalArgumentException("Parameters may not be null");
    }

    public void shutdown() {
        this.httpConnection.close();
    }

    public SimpleHttpConnectionManager(boolean z) {
        this.params = new HttpConnectionManagerParams();
        this.idleStartTime = Long.MAX_VALUE;
        this.inUse = false;
        this.alwaysClose = z;
    }

    public HttpConnection getConnection(HostConfiguration hostConfiguration, long j2) {
        return getConnectionWithTimeout(hostConfiguration, j2);
    }
}
