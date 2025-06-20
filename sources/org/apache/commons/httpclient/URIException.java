package org.apache.commons.httpclient;

public class URIException extends HttpException {
    public static final int ESCAPING = 3;
    public static final int PARSING = 1;
    public static final int PUNYCODE = 4;
    public static final int UNKNOWN = 0;
    public static final int UNSUPPORTED_ENCODING = 2;
    protected String reason;
    protected int reasonCode;

    public URIException() {
    }

    public String getReason() {
        return this.reason;
    }

    public int getReasonCode() {
        return this.reasonCode;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setReasonCode(int i2) {
        this.reasonCode = i2;
    }

    public URIException(int i2) {
        this.reasonCode = i2;
    }

    public URIException(int i2, String str) {
        super(str);
        this.reason = str;
        this.reasonCode = i2;
    }

    public URIException(String str) {
        super(str);
        this.reason = str;
        this.reasonCode = 0;
    }
}
