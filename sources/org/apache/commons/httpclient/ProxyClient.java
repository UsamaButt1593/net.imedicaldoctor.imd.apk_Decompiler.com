package org.apache.commons.httpclient;

import java.io.IOException;
import java.net.Socket;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpParams;

public class ProxyClient {
    private HostConfiguration hostConfiguration;
    private HttpClientParams params;
    private HttpState state;

    public static class ConnectResponse {
        private ConnectMethod connectMethod;
        private Socket socket;

        private ConnectResponse() {
        }

        /* access modifiers changed from: private */
        public void setConnectMethod(ConnectMethod connectMethod2) {
            this.connectMethod = connectMethod2;
        }

        /* access modifiers changed from: private */
        public void setSocket(Socket socket2) {
            this.socket = socket2;
        }

        public ConnectMethod getConnectMethod() {
            return this.connectMethod;
        }

        public Socket getSocket() {
            return this.socket;
        }
    }

    static class DummyConnectionManager implements HttpConnectionManager {
        private HttpParams connectionParams;
        private HttpConnection httpConnection;

        DummyConnectionManager() {
        }

        public void closeIdleConnections(long j2) {
        }

        public HttpConnection getConnection() {
            return this.httpConnection;
        }

        public HttpConnection getConnectionWithTimeout(HostConfiguration hostConfiguration, long j2) {
            HttpConnection httpConnection2 = new HttpConnection(hostConfiguration);
            this.httpConnection = httpConnection2;
            httpConnection2.setHttpConnectionManager(this);
            this.httpConnection.getParams().setDefaults(this.connectionParams);
            return this.httpConnection;
        }

        public HttpConnectionManagerParams getParams() {
            return null;
        }

        public void releaseConnection(HttpConnection httpConnection2) {
        }

        public void setConnectionParams(HttpParams httpParams) {
            this.connectionParams = httpParams;
        }

        public void setParams(HttpConnectionManagerParams httpConnectionManagerParams) {
        }

        public HttpConnection getConnection(HostConfiguration hostConfiguration) {
            return getConnectionWithTimeout(hostConfiguration, -1);
        }

        public HttpConnection getConnection(HostConfiguration hostConfiguration, long j2) throws HttpException {
            return getConnectionWithTimeout(hostConfiguration, j2);
        }
    }

    public ProxyClient() {
        this(new HttpClientParams());
    }

    public ConnectResponse connect() throws IOException, HttpException {
        HostConfiguration hostConfiguration2 = getHostConfiguration();
        if (hostConfiguration2.getProxyHost() == null) {
            throw new IllegalStateException("proxy host must be configured");
        } else if (hostConfiguration2.getHost() == null) {
            throw new IllegalStateException("destination host must be configured");
        } else if (!hostConfiguration2.getProtocol().isSecure()) {
            ConnectMethod connectMethod = new ConnectMethod(getHostConfiguration());
            connectMethod.getParams().setDefaults(getParams());
            DummyConnectionManager dummyConnectionManager = new DummyConnectionManager();
            dummyConnectionManager.setConnectionParams(getParams());
            new HttpMethodDirector(dummyConnectionManager, hostConfiguration2, getParams(), getState()).executeMethod(connectMethod);
            ConnectResponse connectResponse = new ConnectResponse();
            connectResponse.setConnectMethod(connectMethod);
            if (connectMethod.getStatusCode() == 200) {
                connectResponse.setSocket(dummyConnectionManager.getConnection().getSocket());
            } else {
                dummyConnectionManager.getConnection().close();
            }
            return connectResponse;
        } else {
            throw new IllegalStateException("secure protocol socket factory may not be used");
        }
    }

    public synchronized HostConfiguration getHostConfiguration() {
        return this.hostConfiguration;
    }

    public synchronized HttpClientParams getParams() {
        return this.params;
    }

    public synchronized HttpState getState() {
        return this.state;
    }

    public synchronized void setHostConfiguration(HostConfiguration hostConfiguration2) {
        this.hostConfiguration = hostConfiguration2;
    }

    public synchronized void setParams(HttpClientParams httpClientParams) {
        if (httpClientParams != null) {
            this.params = httpClientParams;
        } else {
            throw new IllegalArgumentException("Parameters may not be null");
        }
    }

    public synchronized void setState(HttpState httpState) {
        this.state = httpState;
    }

    public ProxyClient(HttpClientParams httpClientParams) {
        this.state = new HttpState();
        this.params = null;
        this.hostConfiguration = new HostConfiguration();
        if (httpClientParams != null) {
            this.params = httpClientParams;
            return;
        }
        throw new IllegalArgumentException("Params may not be null");
    }
}
