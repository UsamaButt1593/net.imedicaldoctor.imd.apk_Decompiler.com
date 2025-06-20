package org.apache.commons.httpclient.params;

public class HttpConnectionParams extends DefaultHttpParams {
    public static final String CONNECTION_TIMEOUT = "http.connection.timeout";
    public static final String SO_LINGER = "http.socket.linger";
    public static final String SO_RCVBUF = "http.socket.receivebuffer";
    public static final String SO_SNDBUF = "http.socket.sendbuffer";
    public static final String SO_TIMEOUT = "http.socket.timeout";
    public static final String STALE_CONNECTION_CHECK = "http.connection.stalecheck";
    public static final String TCP_NODELAY = "http.tcp.nodelay";

    public int getConnectionTimeout() {
        return getIntParameter(CONNECTION_TIMEOUT, 0);
    }

    public int getLinger() {
        return getIntParameter(SO_LINGER, -1);
    }

    public int getReceiveBufferSize() {
        return getIntParameter(SO_RCVBUF, -1);
    }

    public int getSendBufferSize() {
        return getIntParameter(SO_SNDBUF, -1);
    }

    public int getSoTimeout() {
        return getIntParameter("http.socket.timeout", 0);
    }

    public boolean getTcpNoDelay() {
        return getBooleanParameter(TCP_NODELAY, true);
    }

    public boolean isStaleCheckingEnabled() {
        return getBooleanParameter(STALE_CONNECTION_CHECK, true);
    }

    public void setConnectionTimeout(int i2) {
        setIntParameter(CONNECTION_TIMEOUT, i2);
    }

    public void setLinger(int i2) {
        setIntParameter(SO_LINGER, i2);
    }

    public void setReceiveBufferSize(int i2) {
        setIntParameter(SO_RCVBUF, i2);
    }

    public void setSendBufferSize(int i2) {
        setIntParameter(SO_SNDBUF, i2);
    }

    public void setSoTimeout(int i2) {
        setIntParameter("http.socket.timeout", i2);
    }

    public void setStaleCheckingEnabled(boolean z) {
        setBooleanParameter(STALE_CONNECTION_CHECK, z);
    }

    public void setTcpNoDelay(boolean z) {
        setBooleanParameter(TCP_NODELAY, z);
    }
}
