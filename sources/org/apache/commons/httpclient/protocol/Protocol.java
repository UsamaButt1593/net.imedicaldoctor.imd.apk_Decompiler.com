package org.apache.commons.httpclient.protocol;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.httpclient.util.LangUtils;

public class Protocol {
    private static final Map PROTOCOLS = Collections.synchronizedMap(new HashMap());
    private int defaultPort;
    private String scheme;
    private boolean secure;
    private ProtocolSocketFactory socketFactory;

    public Protocol(String str, ProtocolSocketFactory protocolSocketFactory, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("scheme is null");
        } else if (protocolSocketFactory == null) {
            throw new IllegalArgumentException("socketFactory is null");
        } else if (i2 > 0) {
            this.scheme = str;
            this.socketFactory = protocolSocketFactory;
            this.defaultPort = i2;
            this.secure = protocolSocketFactory instanceof SecureProtocolSocketFactory;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("port is invalid: ");
            stringBuffer.append(i2);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    public static Protocol getProtocol(String str) throws IllegalStateException {
        if (str != null) {
            Protocol protocol = (Protocol) PROTOCOLS.get(str);
            return protocol == null ? lazyRegisterProtocol(str) : protocol;
        }
        throw new IllegalArgumentException("id is null");
    }

    private static Protocol lazyRegisterProtocol(String str) throws IllegalStateException {
        Protocol protocol;
        String str2 = "http";
        if (str2.equals(str)) {
            protocol = new Protocol(str2, (ProtocolSocketFactory) DefaultProtocolSocketFactory.getSocketFactory(), 80);
        } else {
            str2 = "https";
            if (str2.equals(str)) {
                protocol = new Protocol(str2, (SecureProtocolSocketFactory) SSLProtocolSocketFactory.getSocketFactory(), 443);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("unsupported protocol: '");
                stringBuffer.append(str);
                stringBuffer.append("'");
                throw new IllegalStateException(stringBuffer.toString());
            }
        }
        registerProtocol(str2, protocol);
        return protocol;
    }

    public static void registerProtocol(String str, Protocol protocol) {
        if (str == null) {
            throw new IllegalArgumentException("id is null");
        } else if (protocol != null) {
            PROTOCOLS.put(str, protocol);
        } else {
            throw new IllegalArgumentException("protocol is null");
        }
    }

    public static void unregisterProtocol(String str) {
        if (str != null) {
            PROTOCOLS.remove(str);
            return;
        }
        throw new IllegalArgumentException("id is null");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Protocol)) {
            return false;
        }
        Protocol protocol = (Protocol) obj;
        return this.defaultPort == protocol.getDefaultPort() && this.scheme.equalsIgnoreCase(protocol.getScheme()) && this.secure == protocol.isSecure() && this.socketFactory.equals(protocol.getSocketFactory());
    }

    public int getDefaultPort() {
        return this.defaultPort;
    }

    public String getScheme() {
        return this.scheme;
    }

    public ProtocolSocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.defaultPort), (Object) this.scheme.toLowerCase()), this.secure), (Object) this.socketFactory);
    }

    public boolean isSecure() {
        return this.secure;
    }

    public int resolvePort(int i2) {
        return i2 <= 0 ? getDefaultPort() : i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.scheme);
        stringBuffer.append(":");
        stringBuffer.append(this.defaultPort);
        return stringBuffer.toString();
    }

    public Protocol(String str, SecureProtocolSocketFactory secureProtocolSocketFactory, int i2) {
        this(str, (ProtocolSocketFactory) secureProtocolSocketFactory, i2);
    }
}
