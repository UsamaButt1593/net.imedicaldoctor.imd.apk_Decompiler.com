package org.apache.commons.httpclient;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.httpclient.util.ExceptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpConnection {
    private static final byte[] CRLF = {13, 10};
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$HttpConnection;
    private String hostName;
    private HttpConnectionManager httpConnectionManager;
    private InputStream inputStream;
    protected boolean isOpen;
    private InputStream lastResponseInputStream;
    private InetAddress localAddress;
    private boolean locked;
    private OutputStream outputStream;
    private HttpConnectionParams params;
    private int portNumber;
    private Protocol protocolInUse;
    private String proxyHostName;
    private int proxyPortNumber;
    private Socket socket;
    private boolean tunnelEstablished;
    private boolean usingSecureSocket;

    static {
        Class cls = class$org$apache$commons$httpclient$HttpConnection;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.HttpConnection");
            class$org$apache$commons$httpclient$HttpConnection = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public HttpConnection(String str, int i2) {
        this((String) null, -1, str, (String) null, i2, Protocol.getProtocol("http"));
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void assertNotOpen() throws IllegalStateException {
        if (this.isOpen) {
            throw new IllegalStateException("Connection is open");
        }
    }

    /* access modifiers changed from: protected */
    public void assertOpen() throws IllegalStateException {
        if (!this.isOpen) {
            throw new IllegalStateException("Connection is not open");
        }
    }

    public void close() {
        LOG.trace("enter HttpConnection.close()");
        closeSocketAndStreams();
    }

    public boolean closeIfStale() throws IOException {
        if (!this.isOpen || !isStale()) {
            return false;
        }
        LOG.debug("Connection is stale, closing...");
        close();
        return true;
    }

    /* access modifiers changed from: protected */
    public void closeSocketAndStreams() {
        LOG.trace("enter HttpConnection.closeSockedAndStreams()");
        this.isOpen = false;
        this.lastResponseInputStream = null;
        OutputStream outputStream2 = this.outputStream;
        if (outputStream2 != null) {
            this.outputStream = null;
            try {
                outputStream2.close();
            } catch (Exception e2) {
                LOG.debug("Exception caught when closing output", e2);
            }
        }
        InputStream inputStream2 = this.inputStream;
        if (inputStream2 != null) {
            this.inputStream = null;
            try {
                inputStream2.close();
            } catch (Exception e3) {
                LOG.debug("Exception caught when closing input", e3);
            }
        }
        Socket socket2 = this.socket;
        if (socket2 != null) {
            this.socket = null;
            try {
                socket2.close();
            } catch (Exception e4) {
                LOG.debug("Exception caught when closing socket", e4);
            }
        }
        this.tunnelEstablished = false;
        this.usingSecureSocket = false;
    }

    public void flushRequestOutputStream() throws IOException {
        LOG.trace("enter HttpConnection.flushRequestOutputStream()");
        assertOpen();
        this.outputStream.flush();
    }

    public String getHost() {
        return this.hostName;
    }

    public HttpConnectionManager getHttpConnectionManager() {
        return this.httpConnectionManager;
    }

    public InputStream getLastResponseInputStream() {
        return this.lastResponseInputStream;
    }

    public InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public HttpConnectionParams getParams() {
        return this.params;
    }

    public int getPort() {
        int i2 = this.portNumber;
        return i2 < 0 ? isSecure() ? 443 : 80 : i2;
    }

    public Protocol getProtocol() {
        return this.protocolInUse;
    }

    public String getProxyHost() {
        return this.proxyHostName;
    }

    public int getProxyPort() {
        return this.proxyPortNumber;
    }

    public OutputStream getRequestOutputStream() throws IOException, IllegalStateException {
        LOG.trace("enter HttpConnection.getRequestOutputStream()");
        assertOpen();
        OutputStream outputStream2 = this.outputStream;
        return Wire.CONTENT_WIRE.enabled() ? new WireLogOutputStream(outputStream2, Wire.CONTENT_WIRE) : outputStream2;
    }

    public InputStream getResponseInputStream() throws IOException, IllegalStateException {
        LOG.trace("enter HttpConnection.getResponseInputStream()");
        assertOpen();
        return this.inputStream;
    }

    public int getSendBufferSize() throws SocketException {
        Socket socket2 = this.socket;
        if (socket2 == null) {
            return -1;
        }
        return socket2.getSendBufferSize();
    }

    public int getSoTimeout() throws SocketException {
        return this.params.getSoTimeout();
    }

    /* access modifiers changed from: protected */
    public Socket getSocket() {
        return this.socket;
    }

    public String getVirtualHost() {
        return this.hostName;
    }

    /* access modifiers changed from: protected */
    public boolean isLocked() {
        return this.locked;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public boolean isProxied() {
        return this.proxyHostName != null && this.proxyPortNumber > 0;
    }

    public boolean isResponseAvailable() throws IOException {
        LOG.trace("enter HttpConnection.isResponseAvailable()");
        return this.isOpen && this.inputStream.available() > 0;
    }

    public boolean isSecure() {
        return this.protocolInUse.isSecure();
    }

    /* access modifiers changed from: protected */
    public boolean isStale() throws IOException {
        if (!this.isOpen) {
            return true;
        }
        boolean z = false;
        try {
            if (this.inputStream.available() > 0) {
                return false;
            }
            this.socket.setSoTimeout(1);
            this.inputStream.mark(1);
            if (this.inputStream.read() == -1) {
                z = true;
            } else {
                this.inputStream.reset();
            }
            this.socket.setSoTimeout(this.params.getSoTimeout());
            return z;
        } catch (InterruptedIOException e2) {
            if (!ExceptionUtil.isSocketTimeoutException(e2)) {
                throw e2;
            }
        } catch (IOException e3) {
            LOG.debug("An error occurred while reading from the socket, is appears to be stale", e3);
            return true;
        } catch (Throwable th) {
            this.socket.setSoTimeout(this.params.getSoTimeout());
            throw th;
        }
    }

    public boolean isStaleCheckingEnabled() {
        return this.params.isStaleCheckingEnabled();
    }

    public boolean isTransparent() {
        return !isProxied() || this.tunnelEstablished;
    }

    public void open() throws IOException {
        Log log = LOG;
        log.trace("enter HttpConnection.open()");
        String str = this.proxyHostName;
        String str2 = str == null ? this.hostName : str;
        int i2 = str == null ? this.portNumber : this.proxyPortNumber;
        assertNotOpen();
        if (log.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Open connection to ");
            stringBuffer.append(str2);
            stringBuffer.append(":");
            stringBuffer.append(i2);
            log.debug(stringBuffer.toString());
        }
        try {
            boolean z = false;
            if (this.socket == null) {
                this.usingSecureSocket = isSecure() && !isProxied();
                this.socket = ((!isSecure() || !isProxied()) ? this.protocolInUse : Protocol.getProtocol("http")).getSocketFactory().createSocket(str2, i2, this.localAddress, 0, this.params);
            }
            this.socket.setTcpNoDelay(this.params.getTcpNoDelay());
            this.socket.setSoTimeout(this.params.getSoTimeout());
            int linger = this.params.getLinger();
            if (linger >= 0) {
                Socket socket2 = this.socket;
                if (linger > 0) {
                    z = true;
                }
                socket2.setSoLinger(z, linger);
            }
            int sendBufferSize = this.params.getSendBufferSize();
            if (sendBufferSize >= 0) {
                this.socket.setSendBufferSize(sendBufferSize);
            }
            int receiveBufferSize = this.params.getReceiveBufferSize();
            if (receiveBufferSize >= 0) {
                this.socket.setReceiveBufferSize(receiveBufferSize);
            }
            int sendBufferSize2 = this.socket.getSendBufferSize();
            int i3 = 2048;
            if (sendBufferSize2 > 2048 || sendBufferSize2 <= 0) {
                sendBufferSize2 = 2048;
            }
            int receiveBufferSize2 = this.socket.getReceiveBufferSize();
            if (receiveBufferSize2 <= 2048) {
                if (receiveBufferSize2 > 0) {
                    i3 = receiveBufferSize2;
                }
            }
            this.inputStream = new BufferedInputStream(this.socket.getInputStream(), i3);
            this.outputStream = new BufferedOutputStream(this.socket.getOutputStream(), sendBufferSize2);
            this.isOpen = true;
        } catch (IOException e2) {
            closeSocketAndStreams();
            throw e2;
        }
    }

    public void print(String str) throws IOException, IllegalStateException {
        LOG.trace("enter HttpConnection.print(String)");
        write(EncodingUtil.getBytes(str, "ISO-8859-1"));
    }

    public void printLine() throws IOException, IllegalStateException {
        LOG.trace("enter HttpConnection.printLine()");
        writeLine();
    }

    public String readLine() throws IOException, IllegalStateException {
        LOG.trace("enter HttpConnection.readLine()");
        assertOpen();
        return HttpParser.readLine(this.inputStream);
    }

    public void releaseConnection() {
        Log log = LOG;
        log.trace("enter HttpConnection.releaseConnection()");
        if (this.locked) {
            log.debug("Connection is locked.  Call to releaseConnection() ignored.");
        } else if (this.httpConnectionManager != null) {
            log.debug("Releasing connection back to connection manager.");
            this.httpConnectionManager.releaseConnection(this);
        } else {
            log.warn("HttpConnectionManager is null.  Connection cannot be released.");
        }
    }

    public void setConnectionTimeout(int i2) {
        this.params.setConnectionTimeout(i2);
    }

    public void setHost(String str) throws IllegalStateException {
        if (str != null) {
            assertNotOpen();
            this.hostName = str;
            return;
        }
        throw new IllegalArgumentException("host parameter is null");
    }

    public void setHttpConnectionManager(HttpConnectionManager httpConnectionManager2) {
        this.httpConnectionManager = httpConnectionManager2;
    }

    public void setLastResponseInputStream(InputStream inputStream2) {
        this.lastResponseInputStream = inputStream2;
    }

    public void setLocalAddress(InetAddress inetAddress) {
        assertNotOpen();
        this.localAddress = inetAddress;
    }

    /* access modifiers changed from: protected */
    public void setLocked(boolean z) {
        this.locked = z;
    }

    public void setParams(HttpConnectionParams httpConnectionParams) {
        if (httpConnectionParams != null) {
            this.params = httpConnectionParams;
            return;
        }
        throw new IllegalArgumentException("Parameters may not be null");
    }

    public void setPort(int i2) throws IllegalStateException {
        assertNotOpen();
        this.portNumber = i2;
    }

    public void setProtocol(Protocol protocol) {
        assertNotOpen();
        if (protocol != null) {
            this.protocolInUse = protocol;
            return;
        }
        throw new IllegalArgumentException("protocol is null");
    }

    public void setProxyHost(String str) throws IllegalStateException {
        assertNotOpen();
        this.proxyHostName = str;
    }

    public void setProxyPort(int i2) throws IllegalStateException {
        assertNotOpen();
        this.proxyPortNumber = i2;
    }

    public void setSendBufferSize(int i2) throws SocketException {
        this.params.setSendBufferSize(i2);
    }

    public void setSoTimeout(int i2) throws SocketException, IllegalStateException {
        this.params.setSoTimeout(i2);
        Socket socket2 = this.socket;
        if (socket2 != null) {
            socket2.setSoTimeout(i2);
        }
    }

    public void setSocketTimeout(int i2) throws SocketException, IllegalStateException {
        assertOpen();
        Socket socket2 = this.socket;
        if (socket2 != null) {
            socket2.setSoTimeout(i2);
        }
    }

    public void setStaleCheckingEnabled(boolean z) {
        this.params.setStaleCheckingEnabled(z);
    }

    public void setVirtualHost(String str) throws IllegalStateException {
        assertNotOpen();
    }

    public void shutdownOutput() {
        LOG.trace("enter HttpConnection.shutdownOutput()");
        try {
            this.socket.getClass().getMethod("shutdownOutput", (Class[]) null).invoke(this.socket, (Object[]) null);
        } catch (Exception e2) {
            LOG.debug("Unexpected Exception caught", e2);
        }
    }

    public void tunnelCreated() throws IllegalStateException, IOException {
        Log log = LOG;
        log.trace("enter HttpConnection.tunnelCreated()");
        if (!isSecure() || !isProxied()) {
            throw new IllegalStateException("Connection must be secure and proxied to use this feature");
        } else if (!this.usingSecureSocket) {
            if (log.isDebugEnabled()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Secure tunnel to ");
                stringBuffer.append(this.hostName);
                stringBuffer.append(":");
                stringBuffer.append(this.portNumber);
                log.debug(stringBuffer.toString());
            }
            this.socket = ((SecureProtocolSocketFactory) this.protocolInUse.getSocketFactory()).createSocket(this.socket, this.hostName, this.portNumber, true);
            int sendBufferSize = this.params.getSendBufferSize();
            if (sendBufferSize >= 0) {
                this.socket.setSendBufferSize(sendBufferSize);
            }
            int receiveBufferSize = this.params.getReceiveBufferSize();
            if (receiveBufferSize >= 0) {
                this.socket.setReceiveBufferSize(receiveBufferSize);
            }
            int sendBufferSize2 = this.socket.getSendBufferSize();
            int i2 = 2048;
            if (sendBufferSize2 > 2048) {
                sendBufferSize2 = 2048;
            }
            int receiveBufferSize2 = this.socket.getReceiveBufferSize();
            if (receiveBufferSize2 <= 2048) {
                i2 = receiveBufferSize2;
            }
            this.inputStream = new BufferedInputStream(this.socket.getInputStream(), i2);
            this.outputStream = new BufferedOutputStream(this.socket.getOutputStream(), sendBufferSize2);
            this.usingSecureSocket = true;
            this.tunnelEstablished = true;
        } else {
            throw new IllegalStateException("Already using a secure socket");
        }
    }

    public void write(byte[] bArr) throws IOException, IllegalStateException {
        LOG.trace("enter HttpConnection.write(byte[])");
        write(bArr, 0, bArr.length);
    }

    public void writeLine() throws IOException, IllegalStateException {
        LOG.trace("enter HttpConnection.writeLine()");
        write(CRLF);
    }

    public HttpConnection(String str, int i2, String str2, int i3) {
        this(str, i2, str2, (String) null, i3, Protocol.getProtocol("http"));
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0040=Splitter:B:13:0x0040, B:24:0x007b=Splitter:B:24:0x007b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isResponseAvailable(int r7) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "An error ocurred while resetting soTimeout, we will assume that no response is available."
            org.apache.commons.logging.Log r1 = LOG
            java.lang.String r2 = "enter HttpConnection.isResponseAvailable(int)"
            r1.trace(r2)
            r6.assertOpen()
            java.io.InputStream r2 = r6.inputStream
            int r2 = r2.available()
            r3 = 1
            if (r2 <= 0) goto L_0x0017
            goto L_0x0087
        L_0x0017:
            r2 = 0
            java.net.Socket r4 = r6.socket     // Catch:{ InterruptedIOException -> 0x0038 }
            r4.setSoTimeout(r7)     // Catch:{ InterruptedIOException -> 0x0038 }
            java.io.InputStream r4 = r6.inputStream     // Catch:{ InterruptedIOException -> 0x0038 }
            r4.mark(r3)     // Catch:{ InterruptedIOException -> 0x0038 }
            java.io.InputStream r4 = r6.inputStream     // Catch:{ InterruptedIOException -> 0x0038 }
            int r4 = r4.read()     // Catch:{ InterruptedIOException -> 0x0038 }
            r5 = -1
            if (r4 == r5) goto L_0x003a
            java.io.InputStream r4 = r6.inputStream     // Catch:{ InterruptedIOException -> 0x0038 }
            r4.reset()     // Catch:{ InterruptedIOException -> 0x0038 }
            java.lang.String r4 = "Input data available"
            r1.debug(r4)     // Catch:{ InterruptedIOException -> 0x0038 }
            goto L_0x0040
        L_0x0036:
            r7 = move-exception
            goto L_0x0089
        L_0x0038:
            r1 = move-exception
            goto L_0x0054
        L_0x003a:
            java.lang.String r3 = "Input data not available"
            r1.debug(r3)     // Catch:{ InterruptedIOException -> 0x0038 }
            r3 = 0
        L_0x0040:
            java.net.Socket r7 = r6.socket     // Catch:{ IOException -> 0x004c }
            org.apache.commons.httpclient.params.HttpConnectionParams r1 = r6.params     // Catch:{ IOException -> 0x004c }
            int r1 = r1.getSoTimeout()     // Catch:{ IOException -> 0x004c }
            r7.setSoTimeout(r1)     // Catch:{ IOException -> 0x004c }
            goto L_0x0087
        L_0x004c:
            r7 = move-exception
            org.apache.commons.logging.Log r1 = LOG
            r1.debug(r0, r7)
        L_0x0052:
            r3 = 0
            goto L_0x0087
        L_0x0054:
            boolean r3 = org.apache.commons.httpclient.util.ExceptionUtil.isSocketTimeoutException(r1)     // Catch:{ all -> 0x0036 }
            if (r3 == 0) goto L_0x0088
            org.apache.commons.logging.Log r1 = LOG     // Catch:{ all -> 0x0036 }
            boolean r3 = r1.isDebugEnabled()     // Catch:{ all -> 0x0036 }
            if (r3 == 0) goto L_0x007b
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ all -> 0x0036 }
            r3.<init>()     // Catch:{ all -> 0x0036 }
            java.lang.String r4 = "Input data not available after "
            r3.append(r4)     // Catch:{ all -> 0x0036 }
            r3.append(r7)     // Catch:{ all -> 0x0036 }
            java.lang.String r7 = " ms"
            r3.append(r7)     // Catch:{ all -> 0x0036 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0036 }
            r1.debug(r7)     // Catch:{ all -> 0x0036 }
        L_0x007b:
            java.net.Socket r7 = r6.socket     // Catch:{ IOException -> 0x004c }
            org.apache.commons.httpclient.params.HttpConnectionParams r1 = r6.params     // Catch:{ IOException -> 0x004c }
            int r1 = r1.getSoTimeout()     // Catch:{ IOException -> 0x004c }
            r7.setSoTimeout(r1)     // Catch:{ IOException -> 0x004c }
            goto L_0x0052
        L_0x0087:
            return r3
        L_0x0088:
            throw r1     // Catch:{ all -> 0x0036 }
        L_0x0089:
            java.net.Socket r1 = r6.socket     // Catch:{ IOException -> 0x0095 }
            org.apache.commons.httpclient.params.HttpConnectionParams r2 = r6.params     // Catch:{ IOException -> 0x0095 }
            int r2 = r2.getSoTimeout()     // Catch:{ IOException -> 0x0095 }
            r1.setSoTimeout(r2)     // Catch:{ IOException -> 0x0095 }
            goto L_0x009b
        L_0x0095:
            r1 = move-exception
            org.apache.commons.logging.Log r2 = LOG
            r2.debug(r0, r1)
        L_0x009b:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.HttpConnection.isResponseAvailable(int):boolean");
    }

    public void print(String str, String str2) throws IOException, IllegalStateException {
        LOG.trace("enter HttpConnection.print(String)");
        write(EncodingUtil.getBytes(str, str2));
    }

    public void printLine(String str) throws IOException, IllegalStateException {
        LOG.trace("enter HttpConnection.printLine(String)");
        writeLine(EncodingUtil.getBytes(str, "ISO-8859-1"));
    }

    public String readLine(String str) throws IOException, IllegalStateException {
        LOG.trace("enter HttpConnection.readLine()");
        assertOpen();
        return HttpParser.readLine(this.inputStream, str);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException, IllegalStateException {
        LOG.trace("enter HttpConnection.write(byte[], int, int)");
        if (i2 < 0) {
            throw new IllegalArgumentException("Array offset may not be negative");
        } else if (i3 < 0) {
            throw new IllegalArgumentException("Array length may not be negative");
        } else if (i2 + i3 <= bArr.length) {
            assertOpen();
            this.outputStream.write(bArr, i2, i3);
        } else {
            throw new IllegalArgumentException("Given offset and length exceed the array length");
        }
    }

    public void writeLine(byte[] bArr) throws IOException, IllegalStateException {
        LOG.trace("enter HttpConnection.writeLine(byte[])");
        write(bArr);
        writeLine();
    }

    public HttpConnection(String str, int i2, String str2, int i3, Protocol protocol) {
        this.hostName = null;
        this.portNumber = -1;
        this.proxyHostName = null;
        this.proxyPortNumber = -1;
        this.socket = null;
        this.inputStream = null;
        this.outputStream = null;
        this.lastResponseInputStream = null;
        this.isOpen = false;
        this.params = new HttpConnectionParams();
        this.locked = false;
        this.usingSecureSocket = false;
        this.tunnelEstablished = false;
        if (str2 == null) {
            throw new IllegalArgumentException("host parameter is null");
        } else if (protocol != null) {
            this.proxyHostName = str;
            this.proxyPortNumber = i2;
            this.hostName = str2;
            this.portNumber = protocol.resolvePort(i3);
            this.protocolInUse = protocol;
        } else {
            throw new IllegalArgumentException("protocol is null");
        }
    }

    public void printLine(String str, String str2) throws IOException, IllegalStateException {
        LOG.trace("enter HttpConnection.printLine(String)");
        writeLine(EncodingUtil.getBytes(str, str2));
    }

    public HttpConnection(String str, int i2, String str2, String str3, int i3, Protocol protocol) {
        this(str, i2, str2, i3, protocol);
    }

    public HttpConnection(String str, int i2, Protocol protocol) {
        this((String) null, -1, str, (String) null, i2, protocol);
    }

    public HttpConnection(String str, String str2, int i2, Protocol protocol) {
        this((String) null, -1, str, str2, i2, protocol);
    }

    public HttpConnection(HostConfiguration hostConfiguration) {
        this(hostConfiguration.getProxyHost(), hostConfiguration.getProxyPort(), hostConfiguration.getHost(), hostConfiguration.getPort(), hostConfiguration.getProtocol());
        this.localAddress = hostConfiguration.getLocalAddress();
    }
}
