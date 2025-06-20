package org.apache.commons.httpclient;

import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

public interface HttpConnectionManager {
    void closeIdleConnections(long j2);

    HttpConnection getConnection(HostConfiguration hostConfiguration);

    HttpConnection getConnection(HostConfiguration hostConfiguration, long j2) throws HttpException;

    HttpConnection getConnectionWithTimeout(HostConfiguration hostConfiguration, long j2) throws ConnectionPoolTimeoutException;

    HttpConnectionManagerParams getParams();

    void releaseConnection(HttpConnection httpConnection);

    void setParams(HttpConnectionManagerParams httpConnectionManagerParams);
}
