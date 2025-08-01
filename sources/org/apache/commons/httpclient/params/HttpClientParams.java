package org.apache.commons.httpclient.params;

public class HttpClientParams extends HttpMethodParams {
    public static final String ALLOW_CIRCULAR_REDIRECTS = "http.protocol.allow-circular-redirects";
    public static final String CONNECTION_MANAGER_CLASS = "http.connection-manager.class";
    public static final String CONNECTION_MANAGER_TIMEOUT = "http.connection-manager.timeout";
    public static final String MAX_REDIRECTS = "http.protocol.max-redirects";
    public static final String PREEMPTIVE_AUTHENTICATION = "http.authentication.preemptive";
    private static final String[] PROTOCOL_STRICTNESS_PARAMETERS = {REJECT_RELATIVE_REDIRECT, ALLOW_CIRCULAR_REDIRECTS};
    public static final String REJECT_RELATIVE_REDIRECT = "http.protocol.reject-relative-redirect";

    public HttpClientParams() {
    }

    public Class getConnectionManagerClass() {
        return (Class) getParameter(CONNECTION_MANAGER_CLASS);
    }

    public long getConnectionManagerTimeout() {
        return getLongParameter(CONNECTION_MANAGER_TIMEOUT, 0);
    }

    public boolean isAuthenticationPreemptive() {
        return getBooleanParameter(PREEMPTIVE_AUTHENTICATION, false);
    }

    public void makeLenient() {
        super.makeLenient();
        setParameters(PROTOCOL_STRICTNESS_PARAMETERS, Boolean.FALSE);
    }

    public void makeStrict() {
        super.makeStrict();
        setParameters(PROTOCOL_STRICTNESS_PARAMETERS, Boolean.TRUE);
    }

    public void setAuthenticationPreemptive(boolean z) {
        setBooleanParameter(PREEMPTIVE_AUTHENTICATION, z);
    }

    public void setConnectionManagerClass(Class cls) {
        setParameter(CONNECTION_MANAGER_CLASS, cls);
    }

    public void setConnectionManagerTimeout(long j2) {
        setLongParameter(CONNECTION_MANAGER_TIMEOUT, j2);
    }

    public HttpClientParams(HttpParams httpParams) {
        super(httpParams);
    }
}
