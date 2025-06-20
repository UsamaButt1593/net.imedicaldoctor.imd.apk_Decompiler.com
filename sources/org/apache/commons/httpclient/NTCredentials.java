package org.apache.commons.httpclient;

import org.apache.commons.httpclient.util.LangUtils;

public class NTCredentials extends UsernamePasswordCredentials {
    private String domain;
    private String host;

    public NTCredentials() {
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || !(obj instanceof NTCredentials)) {
            return false;
        }
        NTCredentials nTCredentials = (NTCredentials) obj;
        return LangUtils.equals(this.domain, nTCredentials.domain) && LangUtils.equals(this.host, nTCredentials.host);
    }

    public String getDomain() {
        return this.domain;
    }

    public String getHost() {
        return this.host;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(super.hashCode(), (Object) this.host), (Object) this.domain);
    }

    public void setDomain(String str) {
        if (str != null) {
            this.domain = str;
            return;
        }
        throw new IllegalArgumentException("Domain may not be null");
    }

    public void setHost(String str) {
        if (str != null) {
            this.host = str;
            return;
        }
        throw new IllegalArgumentException("Host may not be null");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(super.toString());
        stringBuffer.append("@");
        stringBuffer.append(this.host);
        stringBuffer.append(".");
        stringBuffer.append(this.domain);
        return stringBuffer.toString();
    }

    public NTCredentials(String str, String str2, String str3, String str4) {
        super(str, str2);
        if (str4 != null) {
            this.domain = str4;
            if (str3 != null) {
                this.host = str3;
                return;
            }
            throw new IllegalArgumentException("Host may not be null");
        }
        throw new IllegalArgumentException("Domain may not be null");
    }
}
