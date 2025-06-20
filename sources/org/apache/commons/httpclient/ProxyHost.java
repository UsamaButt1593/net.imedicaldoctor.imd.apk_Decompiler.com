package org.apache.commons.httpclient;

import org.apache.commons.httpclient.protocol.Protocol;

public class ProxyHost extends HttpHost {
    public ProxyHost(String str) {
        this(str, -1);
    }

    public Object clone() throws CloneNotSupportedException {
        return (ProxyHost) super.clone();
    }

    public ProxyHost(String str, int i2) {
        super(str, i2, Protocol.getProtocol("http"));
    }

    public ProxyHost(ProxyHost proxyHost) {
        super((HttpHost) proxyHost);
    }
}
