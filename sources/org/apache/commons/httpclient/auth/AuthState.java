package org.apache.commons.httpclient.auth;

public class AuthState {
    public static final String PREEMPTIVE_AUTH_SCHEME = "basic";
    private boolean authAttempted = false;
    private boolean authRequested = false;
    private AuthScheme authScheme = null;
    private boolean preemptive = false;

    public AuthScheme getAuthScheme() {
        return this.authScheme;
    }

    public String getRealm() {
        AuthScheme authScheme2 = this.authScheme;
        if (authScheme2 != null) {
            return authScheme2.getRealm();
        }
        return null;
    }

    public void invalidate() {
        this.authScheme = null;
        this.authRequested = false;
        this.authAttempted = false;
        this.preemptive = false;
    }

    public boolean isAuthAttempted() {
        return this.authAttempted;
    }

    public boolean isAuthRequested() {
        return this.authRequested;
    }

    public boolean isPreemptive() {
        return this.preemptive;
    }

    public void setAuthAttempted(boolean z) {
        this.authAttempted = z;
    }

    public void setAuthRequested(boolean z) {
        this.authRequested = z;
    }

    public void setAuthScheme(AuthScheme authScheme2) {
        if (authScheme2 == null) {
            invalidate();
            return;
        }
        if (this.preemptive && !this.authScheme.getClass().isInstance(authScheme2)) {
            this.preemptive = false;
            this.authAttempted = false;
        }
        this.authScheme = authScheme2;
    }

    public void setPreemptive() {
        if (this.preemptive) {
            return;
        }
        if (this.authScheme == null) {
            this.authScheme = AuthPolicy.getAuthScheme(PREEMPTIVE_AUTH_SCHEME);
            this.preemptive = true;
            return;
        }
        throw new IllegalStateException("Authentication state already initialized");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Auth state: auth requested [");
        stringBuffer.append(this.authRequested);
        stringBuffer.append("]; auth attempted [");
        stringBuffer.append(this.authAttempted);
        if (this.authScheme != null) {
            stringBuffer.append("]; auth scheme [");
            stringBuffer.append(this.authScheme.getSchemeName());
            stringBuffer.append("]; realm [");
            stringBuffer.append(this.authScheme.getRealm());
        }
        stringBuffer.append("] preemptive [");
        stringBuffer.append(this.preemptive);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
