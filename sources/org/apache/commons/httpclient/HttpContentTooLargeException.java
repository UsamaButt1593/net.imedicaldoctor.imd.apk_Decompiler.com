package org.apache.commons.httpclient;

public class HttpContentTooLargeException extends HttpException {
    private int maxlen;

    public HttpContentTooLargeException(String str, int i2) {
        super(str);
        this.maxlen = i2;
    }

    public int getMaxLength() {
        return this.maxlen;
    }
}
