package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;

public class DefaultHttpMethodRetryHandler implements HttpMethodRetryHandler {
    private static Class SSL_HANDSHAKE_EXCEPTION;
    private boolean requestSentRetryEnabled;
    private int retryCount;

    static {
        try {
            SSL_HANDSHAKE_EXCEPTION = Class.forName("javax.net.ssl.SSLHandshakeException");
        } catch (ClassNotFoundException unused) {
        }
    }

    public DefaultHttpMethodRetryHandler() {
        this(3, false);
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public boolean isRequestSentRetryEnabled() {
        return this.requestSentRetryEnabled;
    }

    public boolean retryMethod(HttpMethod httpMethod, IOException iOException, int i2) {
        if (httpMethod == null) {
            throw new IllegalArgumentException("HTTP method may not be null");
        } else if (iOException == null) {
            throw new IllegalArgumentException("Exception parameter may not be null");
        } else if (((httpMethod instanceof HttpMethodBase) && ((HttpMethodBase) httpMethod).isAborted()) || i2 > this.retryCount) {
            return false;
        } else {
            if (iOException instanceof NoHttpResponseException) {
                return true;
            }
            if ((iOException instanceof InterruptedIOException) || (iOException instanceof UnknownHostException) || (iOException instanceof NoRouteToHostException)) {
                return false;
            }
            Class cls = SSL_HANDSHAKE_EXCEPTION;
            if (cls == null || !cls.isInstance(iOException)) {
                return !httpMethod.isRequestSent() || this.requestSentRetryEnabled;
            }
            return false;
        }
    }

    public DefaultHttpMethodRetryHandler(int i2, boolean z) {
        this.retryCount = i2;
        this.requestSentRetryEnabled = z;
    }
}
