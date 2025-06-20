package org.apache.commons.httpclient;

import com.dd.plist.ASCIIPropertyListParser;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.util.LangUtils;

public class HttpHost implements Cloneable {
    private String hostname;
    private int port;
    private Protocol protocol;

    public HttpHost(String str) {
        this(str, -1, Protocol.getProtocol("http"));
    }

    private void init(HttpHost httpHost) {
        this.hostname = httpHost.hostname;
        this.port = httpHost.port;
        this.protocol = httpHost.protocol;
    }

    public Object clone() throws CloneNotSupportedException {
        HttpHost httpHost = (HttpHost) super.clone();
        httpHost.init(this);
        return httpHost;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HttpHost)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        HttpHost httpHost = (HttpHost) obj;
        return this.hostname.equalsIgnoreCase(httpHost.hostname) && this.port == httpHost.port && this.protocol.equals(httpHost.protocol);
    }

    public String getHostName() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, (Object) this.hostname), this.port), (Object) this.protocol);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append(toURI());
        return stringBuffer.toString();
    }

    public String toURI() {
        StringBuffer stringBuffer = new StringBuffer(50);
        stringBuffer.append(this.protocol.getScheme());
        stringBuffer.append("://");
        stringBuffer.append(this.hostname);
        if (this.port != this.protocol.getDefaultPort()) {
            stringBuffer.append(ASCIIPropertyListParser.A);
            stringBuffer.append(this.port);
        }
        return stringBuffer.toString();
    }

    public HttpHost(String str, int i2) {
        this(str, i2, Protocol.getProtocol("http"));
    }

    public HttpHost(String str, int i2, Protocol protocol2) {
        this.hostname = null;
        this.port = -1;
        this.protocol = null;
        if (str == null) {
            throw new IllegalArgumentException("Host name may not be null");
        } else if (protocol2 != null) {
            this.hostname = str;
            this.protocol = protocol2;
            if (i2 >= 0) {
                this.port = i2;
            } else {
                this.port = protocol2.getDefaultPort();
            }
        } else {
            throw new IllegalArgumentException("Protocol may not be null");
        }
    }

    public HttpHost(HttpHost httpHost) {
        this.hostname = null;
        this.port = -1;
        this.protocol = null;
        init(httpHost);
    }

    public HttpHost(URI uri) throws URIException {
        this(uri.getHost(), uri.getPort(), Protocol.getProtocol(uri.getScheme()));
    }
}
