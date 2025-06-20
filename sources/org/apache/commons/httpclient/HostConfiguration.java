package org.apache.commons.httpclient;

import java.net.InetAddress;
import org.apache.commons.httpclient.params.HostParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.util.LangUtils;

public class HostConfiguration implements Cloneable {
    public static final HostConfiguration ANY_HOST_CONFIGURATION = new HostConfiguration();
    private HttpHost host = null;
    private InetAddress localAddress = null;
    private HostParams params = new HostParams();
    private ProxyHost proxyHost = null;

    public HostConfiguration() {
    }

    private void init(HostConfiguration hostConfiguration) {
        synchronized (hostConfiguration) {
            try {
                HttpHost httpHost = hostConfiguration.host;
                if (httpHost != null) {
                    this.host = (HttpHost) httpHost.clone();
                } else {
                    this.host = null;
                }
                ProxyHost proxyHost2 = hostConfiguration.proxyHost;
                if (proxyHost2 != null) {
                    this.proxyHost = (ProxyHost) proxyHost2.clone();
                } else {
                    this.proxyHost = null;
                }
                this.localAddress = hostConfiguration.getLocalAddress();
                this.params = (HostParams) hostConfiguration.getParams().clone();
            } catch (CloneNotSupportedException unused) {
                throw new IllegalArgumentException("Host configuration could not be cloned");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object clone() {
        try {
            HostConfiguration hostConfiguration = (HostConfiguration) super.clone();
            hostConfiguration.init(this);
            return hostConfiguration;
        } catch (CloneNotSupportedException unused) {
            throw new IllegalArgumentException("Host configuration could not be cloned");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r5 instanceof org.apache.commons.httpclient.HostConfiguration     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 == 0) goto L_0x0031
            r0 = 1
            if (r5 != r4) goto L_0x000b
            monitor-exit(r4)
            return r0
        L_0x000b:
            org.apache.commons.httpclient.HostConfiguration r5 = (org.apache.commons.httpclient.HostConfiguration) r5     // Catch:{ all -> 0x002d }
            org.apache.commons.httpclient.HttpHost r2 = r4.host     // Catch:{ all -> 0x002d }
            org.apache.commons.httpclient.HttpHost r3 = r5.host     // Catch:{ all -> 0x002d }
            boolean r2 = org.apache.commons.httpclient.util.LangUtils.equals(r2, r3)     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002f
            org.apache.commons.httpclient.ProxyHost r2 = r4.proxyHost     // Catch:{ all -> 0x002d }
            org.apache.commons.httpclient.ProxyHost r3 = r5.proxyHost     // Catch:{ all -> 0x002d }
            boolean r2 = org.apache.commons.httpclient.util.LangUtils.equals(r2, r3)     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002f
            java.net.InetAddress r2 = r4.localAddress     // Catch:{ all -> 0x002d }
            java.net.InetAddress r5 = r5.localAddress     // Catch:{ all -> 0x002d }
            boolean r5 = org.apache.commons.httpclient.util.LangUtils.equals(r2, r5)     // Catch:{ all -> 0x002d }
            if (r5 == 0) goto L_0x002f
            r1 = 1
            goto L_0x002f
        L_0x002d:
            r5 = move-exception
            goto L_0x0033
        L_0x002f:
            monitor-exit(r4)
            return r1
        L_0x0031:
            monitor-exit(r4)
            return r1
        L_0x0033:
            monitor-exit(r4)     // Catch:{ all -> 0x002d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.HostConfiguration.equals(java.lang.Object):boolean");
    }

    public synchronized String getHost() {
        HttpHost httpHost = this.host;
        if (httpHost == null) {
            return null;
        }
        return httpHost.getHostName();
    }

    public synchronized String getHostURL() {
        HttpHost httpHost;
        httpHost = this.host;
        if (httpHost != null) {
        } else {
            throw new IllegalStateException("Host must be set to create a host URL");
        }
        return httpHost.toURI();
    }

    public synchronized InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public HostParams getParams() {
        return this.params;
    }

    public synchronized int getPort() {
        HttpHost httpHost = this.host;
        if (httpHost == null) {
            return -1;
        }
        return httpHost.getPort();
    }

    public synchronized Protocol getProtocol() {
        HttpHost httpHost = this.host;
        if (httpHost == null) {
            return null;
        }
        return httpHost.getProtocol();
    }

    public synchronized String getProxyHost() {
        ProxyHost proxyHost2 = this.proxyHost;
        if (proxyHost2 == null) {
            return null;
        }
        return proxyHost2.getHostName();
    }

    public synchronized int getProxyPort() {
        ProxyHost proxyHost2 = this.proxyHost;
        if (proxyHost2 == null) {
            return -1;
        }
        return proxyHost2.getPort();
    }

    public synchronized String getVirtualHost() {
        return this.params.getVirtualHost();
    }

    public synchronized int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, (Object) this.host), (Object) this.proxyHost), (Object) this.localAddress);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0053, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean hostEquals(org.apache.commons.httpclient.HttpConnection r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 == 0) goto L_0x0057
            org.apache.commons.httpclient.HttpHost r0 = r3.host     // Catch:{ all -> 0x0048 }
            r1 = 0
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r0.getHostName()     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = r4.getHost()     // Catch:{ all -> 0x0048 }
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x0018
            monitor-exit(r3)
            return r1
        L_0x0018:
            org.apache.commons.httpclient.HttpHost r0 = r3.host     // Catch:{ all -> 0x0048 }
            int r0 = r0.getPort()     // Catch:{ all -> 0x0048 }
            int r2 = r4.getPort()     // Catch:{ all -> 0x0048 }
            if (r0 == r2) goto L_0x0026
            monitor-exit(r3)
            return r1
        L_0x0026:
            org.apache.commons.httpclient.HttpHost r0 = r3.host     // Catch:{ all -> 0x0048 }
            org.apache.commons.httpclient.protocol.Protocol r0 = r0.getProtocol()     // Catch:{ all -> 0x0048 }
            org.apache.commons.httpclient.protocol.Protocol r2 = r4.getProtocol()     // Catch:{ all -> 0x0048 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x0038
            monitor-exit(r3)
            return r1
        L_0x0038:
            java.net.InetAddress r0 = r3.localAddress     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x004a
            java.net.InetAddress r4 = r4.getLocalAddress()     // Catch:{ all -> 0x0048 }
            boolean r4 = r0.equals(r4)     // Catch:{ all -> 0x0048 }
            if (r4 != 0) goto L_0x0052
            monitor-exit(r3)
            return r1
        L_0x0048:
            r4 = move-exception
            goto L_0x005f
        L_0x004a:
            java.net.InetAddress r4 = r4.getLocalAddress()     // Catch:{ all -> 0x0048 }
            if (r4 == 0) goto L_0x0052
            monitor-exit(r3)
            return r1
        L_0x0052:
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x0055:
            monitor-exit(r3)
            return r1
        L_0x0057:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0048 }
            java.lang.String r0 = "Connection may not be null"
            r4.<init>(r0)     // Catch:{ all -> 0x0048 }
            throw r4     // Catch:{ all -> 0x0048 }
        L_0x005f:
            monitor-exit(r3)     // Catch:{ all -> 0x0048 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.HostConfiguration.hostEquals(org.apache.commons.httpclient.HttpConnection):boolean");
    }

    public synchronized boolean isHostSet() {
        return this.host != null;
    }

    public synchronized boolean isProxySet() {
        return this.proxyHost != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean proxyEquals(org.apache.commons.httpclient.HttpConnection r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x0032
            org.apache.commons.httpclient.ProxyHost r0 = r4.proxyHost     // Catch:{ all -> 0x0025 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0029
            java.lang.String r0 = r0.getHostName()     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = r5.getProxyHost()     // Catch:{ all -> 0x0025 }
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0027
            org.apache.commons.httpclient.ProxyHost r0 = r4.proxyHost     // Catch:{ all -> 0x0025 }
            int r0 = r0.getPort()     // Catch:{ all -> 0x0025 }
            int r5 = r5.getProxyPort()     // Catch:{ all -> 0x0025 }
            if (r0 != r5) goto L_0x0027
            r1 = 1
            goto L_0x0027
        L_0x0025:
            r5 = move-exception
            goto L_0x003a
        L_0x0027:
            monitor-exit(r4)
            return r1
        L_0x0029:
            java.lang.String r5 = r5.getProxyHost()     // Catch:{ all -> 0x0025 }
            if (r5 != 0) goto L_0x0030
            r1 = 1
        L_0x0030:
            monitor-exit(r4)
            return r1
        L_0x0032:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0025 }
            java.lang.String r0 = "Connection may not be null"
            r5.<init>(r0)     // Catch:{ all -> 0x0025 }
            throw r5     // Catch:{ all -> 0x0025 }
        L_0x003a:
            monitor-exit(r4)     // Catch:{ all -> 0x0025 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.HostConfiguration.proxyEquals(org.apache.commons.httpclient.HttpConnection):boolean");
    }

    public synchronized void setHost(String str) {
        Protocol protocol = Protocol.getProtocol("http");
        setHost(str, protocol.getDefaultPort(), protocol);
    }

    public synchronized void setLocalAddress(InetAddress inetAddress) {
        this.localAddress = inetAddress;
    }

    public void setParams(HostParams hostParams) {
        if (hostParams != null) {
            this.params = hostParams;
            return;
        }
        throw new IllegalArgumentException("Parameters may not be null");
    }

    public synchronized void setProxy(String str, int i2) {
        this.proxyHost = new ProxyHost(str, i2);
    }

    public synchronized void setProxyHost(ProxyHost proxyHost2) {
        this.proxyHost = proxyHost2;
    }

    public synchronized String toString() {
        StringBuffer stringBuffer;
        boolean z;
        try {
            stringBuffer = new StringBuffer(50);
            stringBuffer.append("HostConfiguration[");
            boolean z2 = true;
            if (this.host != null) {
                stringBuffer.append("host=");
                stringBuffer.append(this.host);
                z = true;
            } else {
                z = false;
            }
            if (this.proxyHost != null) {
                if (z) {
                    stringBuffer.append(", ");
                } else {
                    z = true;
                }
                stringBuffer.append("proxyHost=");
                stringBuffer.append(this.proxyHost);
            }
            if (this.localAddress != null) {
                if (z) {
                    stringBuffer.append(", ");
                    z2 = z;
                }
                stringBuffer.append("localAddress=");
                stringBuffer.append(this.localAddress);
                if (z2) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append("params=");
                stringBuffer.append(this.params);
            }
            stringBuffer.append("]");
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return stringBuffer.toString();
    }

    public HostConfiguration(HostConfiguration hostConfiguration) {
        init(hostConfiguration);
    }

    public synchronized void setHost(String str, int i2) {
        setHost(str, i2, Protocol.getProtocol("http"));
    }

    public synchronized void setHost(String str, int i2, String str2) {
        this.host = new HttpHost(str, i2, Protocol.getProtocol(str2));
    }

    public synchronized void setHost(String str, int i2, Protocol protocol) {
        if (str == null) {
            throw new IllegalArgumentException("host must not be null");
        } else if (protocol != null) {
            this.host = new HttpHost(str, i2, protocol);
        } else {
            throw new IllegalArgumentException("protocol must not be null");
        }
    }

    public synchronized void setHost(String str, String str2, int i2, Protocol protocol) {
        setHost(str, i2, protocol);
        this.params.setVirtualHost(str2);
    }

    public synchronized void setHost(HttpHost httpHost) {
        this.host = httpHost;
    }

    public synchronized void setHost(URI uri) {
        try {
            setHost(uri.getHost(), uri.getPort(), uri.getScheme());
        } catch (URIException e2) {
            throw new IllegalArgumentException(e2.toString());
        }
    }
}
