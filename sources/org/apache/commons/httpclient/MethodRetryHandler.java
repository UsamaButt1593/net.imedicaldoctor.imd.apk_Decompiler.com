package org.apache.commons.httpclient;

public interface MethodRetryHandler {
    boolean retryMethod(HttpMethod httpMethod, HttpConnection httpConnection, HttpRecoverableException httpRecoverableException, int i2, boolean z);
}
