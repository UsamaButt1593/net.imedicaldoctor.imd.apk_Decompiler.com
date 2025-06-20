package org.apache.commons.httpclient.protocol;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.params.HttpConnectionParams;

public class DefaultProtocolSocketFactory implements ProtocolSocketFactory {
    private static final DefaultProtocolSocketFactory factory = new DefaultProtocolSocketFactory();

    static DefaultProtocolSocketFactory getSocketFactory() {
        return factory;
    }

    public Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
        return new Socket(str, i2);
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass().equals(getClass());
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        return new Socket(str, i2, inetAddress, i3);
    }

    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3, HttpConnectionParams httpConnectionParams) throws IOException, UnknownHostException, ConnectTimeoutException {
        if (httpConnectionParams != null) {
            int connectionTimeout = httpConnectionParams.getConnectionTimeout();
            if (connectionTimeout == 0) {
                return createSocket(str, i2, inetAddress, i3);
            }
            Socket createSocket = ReflectionSocketFactory.createSocket("javax.net.SocketFactory", str, i2, inetAddress, i3, connectionTimeout);
            return createSocket == null ? ControllerThreadSocketFactory.createSocket(this, str, i2, inetAddress, i3, connectionTimeout) : createSocket;
        }
        throw new IllegalArgumentException("Parameters may not be null");
    }
}
