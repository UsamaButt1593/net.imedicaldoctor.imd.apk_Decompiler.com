package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.util.IdleConnectionHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MultiThreadedHttpConnectionManager implements HttpConnectionManager {
    private static WeakHashMap ALL_CONNECTION_MANAGERS = new WeakHashMap();
    public static final int DEFAULT_MAX_HOST_CONNECTIONS = 2;
    public static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 20;
    /* access modifiers changed from: private */
    public static final Log LOG;
    /* access modifiers changed from: private */
    public static final ReferenceQueue REFERENCE_QUEUE = new ReferenceQueue();
    private static ReferenceQueueThread REFERENCE_QUEUE_THREAD;
    /* access modifiers changed from: private */
    public static final Map REFERENCE_TO_CONNECTION_SOURCE = new HashMap();
    static /* synthetic */ Class class$org$apache$commons$httpclient$MultiThreadedHttpConnectionManager;
    private ConnectionPool connectionPool = new ConnectionPool();
    /* access modifiers changed from: private */
    public HttpConnectionManagerParams params = new HttpConnectionManagerParams();
    /* access modifiers changed from: private */
    public volatile boolean shutdown = false;

    private class ConnectionPool {
        /* access modifiers changed from: private */
        public LinkedList freeConnections;
        private IdleConnectionHandler idleConnectionHandler;
        private final Map mapHosts;
        /* access modifiers changed from: private */
        public int numConnections;
        /* access modifiers changed from: private */
        public LinkedList waitingThreads;

        private ConnectionPool() {
            this.freeConnections = new LinkedList();
            this.waitingThreads = new LinkedList();
            this.mapHosts = new HashMap();
            this.idleConnectionHandler = new IdleConnectionHandler();
            this.numConnections = 0;
        }

        private synchronized void deleteConnection(HttpConnection httpConnection) {
            try {
                HostConfiguration access$1100 = MultiThreadedHttpConnectionManager.this.configurationForConnection(httpConnection);
                if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled()) {
                    Log access$700 = MultiThreadedHttpConnectionManager.LOG;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Reclaiming connection, hostConfig=");
                    stringBuffer.append(access$1100);
                    access$700.debug(stringBuffer.toString());
                }
                httpConnection.close();
                HostConnectionPool hostPool = getHostPool(access$1100, true);
                hostPool.freeConnections.remove(httpConnection);
                int i2 = hostPool.numConnections - 1;
                hostPool.numConnections = i2;
                this.numConnections--;
                if (i2 == 0 && hostPool.waitingThreads.isEmpty()) {
                    this.mapHosts.remove(access$1100);
                }
                this.idleConnectionHandler.remove(httpConnection);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        public synchronized void closeIdleConnections(long j2) {
            this.idleConnectionHandler.closeIdleConnections(j2);
        }

        public synchronized HttpConnection createConnection(HostConfiguration hostConfiguration) {
            HttpConnectionWithReference httpConnectionWithReference;
            try {
                HostConnectionPool hostPool = getHostPool(hostConfiguration, true);
                if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled()) {
                    Log access$700 = MultiThreadedHttpConnectionManager.LOG;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Allocating new connection, hostConfig=");
                    stringBuffer.append(hostConfiguration);
                    access$700.debug(stringBuffer.toString());
                }
                httpConnectionWithReference = new HttpConnectionWithReference(hostConfiguration);
                httpConnectionWithReference.getParams().setDefaults(MultiThreadedHttpConnectionManager.this.params);
                httpConnectionWithReference.setHttpConnectionManager(MultiThreadedHttpConnectionManager.this);
                this.numConnections++;
                hostPool.numConnections++;
                MultiThreadedHttpConnectionManager.storeReferenceToConnection(httpConnectionWithReference, hostConfiguration, this);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
            return httpConnectionWithReference;
        }

        public synchronized void deleteClosedConnections() {
            Iterator it2 = this.freeConnections.iterator();
            while (it2.hasNext()) {
                HttpConnection httpConnection = (HttpConnection) it2.next();
                if (!httpConnection.isOpen()) {
                    it2.remove();
                    deleteConnection(httpConnection);
                }
            }
        }

        public synchronized void deleteLeastUsedConnection() {
            try {
                HttpConnection httpConnection = (HttpConnection) this.freeConnections.removeFirst();
                if (httpConnection != null) {
                    deleteConnection(httpConnection);
                } else if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled()) {
                    MultiThreadedHttpConnectionManager.LOG.debug("Attempted to reclaim an unused connection but there were none.");
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        public void freeConnection(HttpConnection httpConnection) {
            HostConfiguration access$1100 = MultiThreadedHttpConnectionManager.this.configurationForConnection(httpConnection);
            if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled()) {
                Log access$700 = MultiThreadedHttpConnectionManager.LOG;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Freeing connection, hostConfig=");
                stringBuffer.append(access$1100);
                access$700.debug(stringBuffer.toString());
            }
            synchronized (this) {
                try {
                    if (MultiThreadedHttpConnectionManager.this.shutdown) {
                        httpConnection.close();
                        return;
                    }
                    HostConnectionPool hostPool = getHostPool(access$1100, true);
                    hostPool.freeConnections.add(httpConnection);
                    if (hostPool.numConnections == 0) {
                        Log access$7002 = MultiThreadedHttpConnectionManager.LOG;
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Host connection pool not found, hostConfig=");
                        stringBuffer2.append(access$1100);
                        access$7002.error(stringBuffer2.toString());
                        hostPool.numConnections = 1;
                    }
                    this.freeConnections.add(httpConnection);
                    MultiThreadedHttpConnectionManager.removeReferenceToConnection((HttpConnectionWithReference) httpConnection);
                    if (this.numConnections == 0) {
                        Log access$7003 = MultiThreadedHttpConnectionManager.LOG;
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append("Host connection pool not found, hostConfig=");
                        stringBuffer3.append(access$1100);
                        access$7003.error(stringBuffer3.toString());
                        this.numConnections = 1;
                    }
                    this.idleConnectionHandler.add(httpConnection);
                    notifyWaitingThread(hostPool);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public synchronized HttpConnection getFreeConnection(HostConfiguration hostConfiguration) {
            HttpConnectionWithReference httpConnectionWithReference;
            try {
                HostConnectionPool hostPool = getHostPool(hostConfiguration, false);
                if (hostPool == null || hostPool.freeConnections.size() <= 0) {
                    if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled()) {
                        Log access$700 = MultiThreadedHttpConnectionManager.LOG;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("There were no free connections to get, hostConfig=");
                        stringBuffer.append(hostConfiguration);
                        access$700.debug(stringBuffer.toString());
                    }
                    httpConnectionWithReference = null;
                } else {
                    httpConnectionWithReference = (HttpConnectionWithReference) hostPool.freeConnections.removeLast();
                    this.freeConnections.remove(httpConnectionWithReference);
                    MultiThreadedHttpConnectionManager.storeReferenceToConnection(httpConnectionWithReference, hostConfiguration, this);
                    if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled()) {
                        Log access$7002 = MultiThreadedHttpConnectionManager.LOG;
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Getting free connection, hostConfig=");
                        stringBuffer2.append(hostConfiguration);
                        access$7002.debug(stringBuffer2.toString());
                    }
                    this.idleConnectionHandler.remove(httpConnectionWithReference);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
            return httpConnectionWithReference;
        }

        public synchronized HostConnectionPool getHostPool(HostConfiguration hostConfiguration, boolean z) {
            HostConnectionPool hostConnectionPool;
            MultiThreadedHttpConnectionManager.LOG.trace("enter HttpConnectionManager.ConnectionPool.getHostPool(HostConfiguration)");
            hostConnectionPool = (HostConnectionPool) this.mapHosts.get(hostConfiguration);
            if (hostConnectionPool == null && z) {
                hostConnectionPool = new HostConnectionPool();
                hostConnectionPool.hostConfiguration = hostConfiguration;
                this.mapHosts.put(hostConfiguration, hostConnectionPool);
            }
            return hostConnectionPool;
        }

        public synchronized void handleLostConnection(HostConfiguration hostConfiguration) {
            try {
                HostConnectionPool hostPool = getHostPool(hostConfiguration, true);
                int i2 = hostPool.numConnections - 1;
                hostPool.numConnections = i2;
                if (i2 == 0 && hostPool.waitingThreads.isEmpty()) {
                    this.mapHosts.remove(hostConfiguration);
                }
                this.numConnections--;
                notifyWaitingThread(hostConfiguration);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        public synchronized void notifyWaitingThread(HostConfiguration hostConfiguration) {
            notifyWaitingThread(getHostPool(hostConfiguration, true));
        }

        public synchronized void shutdown() {
            try {
                Iterator it2 = this.freeConnections.iterator();
                while (it2.hasNext()) {
                    it2.remove();
                    ((HttpConnection) it2.next()).close();
                }
                MultiThreadedHttpConnectionManager.shutdownCheckedOutConnections(this);
                Iterator it3 = this.waitingThreads.iterator();
                while (it3.hasNext()) {
                    WaitingThread waitingThread = (WaitingThread) it3.next();
                    it3.remove();
                    waitingThread.interruptedByConnectionPool = true;
                    waitingThread.thread.interrupt();
                }
                this.mapHosts.clear();
                this.idleConnectionHandler.removeAll();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x007c A[Catch:{ all -> 0x002e }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void notifyWaitingThread(org.apache.commons.httpclient.MultiThreadedHttpConnectionManager.HostConnectionPool r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.util.LinkedList r0 = r4.waitingThreads     // Catch:{ all -> 0x002e }
                int r0 = r0.size()     // Catch:{ all -> 0x002e }
                if (r0 <= 0) goto L_0x003e
                org.apache.commons.logging.Log r0 = org.apache.commons.httpclient.MultiThreadedHttpConnectionManager.LOG     // Catch:{ all -> 0x002e }
                boolean r0 = r0.isDebugEnabled()     // Catch:{ all -> 0x002e }
                if (r0 == 0) goto L_0x0030
                org.apache.commons.logging.Log r0 = org.apache.commons.httpclient.MultiThreadedHttpConnectionManager.LOG     // Catch:{ all -> 0x002e }
                java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ all -> 0x002e }
                r1.<init>()     // Catch:{ all -> 0x002e }
                java.lang.String r2 = "Notifying thread waiting on host pool, hostConfig="
                r1.append(r2)     // Catch:{ all -> 0x002e }
                org.apache.commons.httpclient.HostConfiguration r2 = r4.hostConfiguration     // Catch:{ all -> 0x002e }
                r1.append(r2)     // Catch:{ all -> 0x002e }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x002e }
                r0.debug(r1)     // Catch:{ all -> 0x002e }
                goto L_0x0030
            L_0x002e:
                r4 = move-exception
                goto L_0x0086
            L_0x0030:
                java.util.LinkedList r4 = r4.waitingThreads     // Catch:{ all -> 0x002e }
                java.lang.Object r4 = r4.removeFirst()     // Catch:{ all -> 0x002e }
                org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$WaitingThread r4 = (org.apache.commons.httpclient.MultiThreadedHttpConnectionManager.WaitingThread) r4     // Catch:{ all -> 0x002e }
                java.util.LinkedList r0 = r3.waitingThreads     // Catch:{ all -> 0x002e }
            L_0x003a:
                r0.remove(r4)     // Catch:{ all -> 0x002e }
                goto L_0x007a
            L_0x003e:
                java.util.LinkedList r4 = r3.waitingThreads     // Catch:{ all -> 0x002e }
                int r4 = r4.size()     // Catch:{ all -> 0x002e }
                if (r4 <= 0) goto L_0x0066
                org.apache.commons.logging.Log r4 = org.apache.commons.httpclient.MultiThreadedHttpConnectionManager.LOG     // Catch:{ all -> 0x002e }
                boolean r4 = r4.isDebugEnabled()     // Catch:{ all -> 0x002e }
                if (r4 == 0) goto L_0x0059
                org.apache.commons.logging.Log r4 = org.apache.commons.httpclient.MultiThreadedHttpConnectionManager.LOG     // Catch:{ all -> 0x002e }
                java.lang.String r0 = "No-one waiting on host pool, notifying next waiting thread."
                r4.debug(r0)     // Catch:{ all -> 0x002e }
            L_0x0059:
                java.util.LinkedList r4 = r3.waitingThreads     // Catch:{ all -> 0x002e }
                java.lang.Object r4 = r4.removeFirst()     // Catch:{ all -> 0x002e }
                org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$WaitingThread r4 = (org.apache.commons.httpclient.MultiThreadedHttpConnectionManager.WaitingThread) r4     // Catch:{ all -> 0x002e }
                org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$HostConnectionPool r0 = r4.hostConnectionPool     // Catch:{ all -> 0x002e }
                java.util.LinkedList r0 = r0.waitingThreads     // Catch:{ all -> 0x002e }
                goto L_0x003a
            L_0x0066:
                org.apache.commons.logging.Log r4 = org.apache.commons.httpclient.MultiThreadedHttpConnectionManager.LOG     // Catch:{ all -> 0x002e }
                boolean r4 = r4.isDebugEnabled()     // Catch:{ all -> 0x002e }
                if (r4 == 0) goto L_0x0079
                org.apache.commons.logging.Log r4 = org.apache.commons.httpclient.MultiThreadedHttpConnectionManager.LOG     // Catch:{ all -> 0x002e }
                java.lang.String r0 = "Notifying no-one, there are no waiting threads"
                r4.debug(r0)     // Catch:{ all -> 0x002e }
            L_0x0079:
                r4 = 0
            L_0x007a:
                if (r4 == 0) goto L_0x0084
                r0 = 1
                r4.interruptedByConnectionPool = r0     // Catch:{ all -> 0x002e }
                java.lang.Thread r4 = r4.thread     // Catch:{ all -> 0x002e }
                r4.interrupt()     // Catch:{ all -> 0x002e }
            L_0x0084:
                monitor-exit(r3)
                return
            L_0x0086:
                monitor-exit(r3)     // Catch:{ all -> 0x002e }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.MultiThreadedHttpConnectionManager.ConnectionPool.notifyWaitingThread(org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$HostConnectionPool):void");
        }
    }

    private static class ConnectionSource {
        public ConnectionPool connectionPool;
        public HostConfiguration hostConfiguration;

        private ConnectionSource() {
        }
    }

    private static class HostConnectionPool {
        public LinkedList freeConnections;
        public HostConfiguration hostConfiguration;
        public int numConnections;
        public LinkedList waitingThreads;

        private HostConnectionPool() {
            this.freeConnections = new LinkedList();
            this.waitingThreads = new LinkedList();
            this.numConnections = 0;
        }
    }

    private static class HttpConnectionAdapter extends HttpConnection {
        private HttpConnection wrappedConnection;

        public HttpConnectionAdapter(HttpConnection httpConnection) {
            super(httpConnection.getHost(), httpConnection.getPort(), httpConnection.getProtocol());
            this.wrappedConnection = httpConnection;
        }

        public void close() {
            if (hasConnection()) {
                this.wrappedConnection.close();
            }
        }

        public boolean closeIfStale() throws IOException {
            if (hasConnection()) {
                return this.wrappedConnection.closeIfStale();
            }
            return false;
        }

        public void flushRequestOutputStream() throws IOException {
            if (hasConnection()) {
                this.wrappedConnection.flushRequestOutputStream();
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public String getHost() {
            if (hasConnection()) {
                return this.wrappedConnection.getHost();
            }
            return null;
        }

        public HttpConnectionManager getHttpConnectionManager() {
            if (hasConnection()) {
                return this.wrappedConnection.getHttpConnectionManager();
            }
            return null;
        }

        public InputStream getLastResponseInputStream() {
            if (hasConnection()) {
                return this.wrappedConnection.getLastResponseInputStream();
            }
            return null;
        }

        public InetAddress getLocalAddress() {
            if (hasConnection()) {
                return this.wrappedConnection.getLocalAddress();
            }
            return null;
        }

        public HttpConnectionParams getParams() {
            if (hasConnection()) {
                return this.wrappedConnection.getParams();
            }
            throw new IllegalStateException("Connection has been released");
        }

        public int getPort() {
            if (hasConnection()) {
                return this.wrappedConnection.getPort();
            }
            return -1;
        }

        public Protocol getProtocol() {
            if (hasConnection()) {
                return this.wrappedConnection.getProtocol();
            }
            return null;
        }

        public String getProxyHost() {
            if (hasConnection()) {
                return this.wrappedConnection.getProxyHost();
            }
            return null;
        }

        public int getProxyPort() {
            if (hasConnection()) {
                return this.wrappedConnection.getProxyPort();
            }
            return -1;
        }

        public OutputStream getRequestOutputStream() throws IOException, IllegalStateException {
            if (hasConnection()) {
                return this.wrappedConnection.getRequestOutputStream();
            }
            return null;
        }

        public InputStream getResponseInputStream() throws IOException, IllegalStateException {
            if (hasConnection()) {
                return this.wrappedConnection.getResponseInputStream();
            }
            return null;
        }

        public int getSendBufferSize() throws SocketException {
            if (hasConnection()) {
                return this.wrappedConnection.getSendBufferSize();
            }
            throw new IllegalStateException("Connection has been released");
        }

        public int getSoTimeout() throws SocketException {
            if (hasConnection()) {
                return this.wrappedConnection.getSoTimeout();
            }
            throw new IllegalStateException("Connection has been released");
        }

        public String getVirtualHost() {
            if (hasConnection()) {
                return this.wrappedConnection.getVirtualHost();
            }
            throw new IllegalStateException("Connection has been released");
        }

        /* access modifiers changed from: package-private */
        public HttpConnection getWrappedConnection() {
            return this.wrappedConnection;
        }

        /* access modifiers changed from: protected */
        public boolean hasConnection() {
            return this.wrappedConnection != null;
        }

        public boolean isOpen() {
            if (hasConnection()) {
                return this.wrappedConnection.isOpen();
            }
            return false;
        }

        public boolean isProxied() {
            if (hasConnection()) {
                return this.wrappedConnection.isProxied();
            }
            return false;
        }

        public boolean isResponseAvailable() throws IOException {
            if (hasConnection()) {
                return this.wrappedConnection.isResponseAvailable();
            }
            return false;
        }

        public boolean isSecure() {
            if (hasConnection()) {
                return this.wrappedConnection.isSecure();
            }
            return false;
        }

        public boolean isStaleCheckingEnabled() {
            if (hasConnection()) {
                return this.wrappedConnection.isStaleCheckingEnabled();
            }
            return false;
        }

        public boolean isTransparent() {
            if (hasConnection()) {
                return this.wrappedConnection.isTransparent();
            }
            return false;
        }

        public void open() throws IOException {
            if (hasConnection()) {
                this.wrappedConnection.open();
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void print(String str) throws IOException, IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.print(str);
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void printLine() throws IOException, IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.printLine();
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public String readLine() throws IOException, IllegalStateException {
            if (hasConnection()) {
                return this.wrappedConnection.readLine();
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void releaseConnection() {
            if (!isLocked() && hasConnection()) {
                HttpConnection httpConnection = this.wrappedConnection;
                this.wrappedConnection = null;
                httpConnection.releaseConnection();
            }
        }

        public void setConnectionTimeout(int i2) {
            if (hasConnection()) {
                this.wrappedConnection.setConnectionTimeout(i2);
            }
        }

        public void setHost(String str) throws IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.setHost(str);
            }
        }

        public void setHttpConnectionManager(HttpConnectionManager httpConnectionManager) {
            if (hasConnection()) {
                this.wrappedConnection.setHttpConnectionManager(httpConnectionManager);
            }
        }

        public void setLastResponseInputStream(InputStream inputStream) {
            if (hasConnection()) {
                this.wrappedConnection.setLastResponseInputStream(inputStream);
            }
        }

        public void setLocalAddress(InetAddress inetAddress) {
            if (hasConnection()) {
                this.wrappedConnection.setLocalAddress(inetAddress);
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void setParams(HttpConnectionParams httpConnectionParams) {
            if (hasConnection()) {
                this.wrappedConnection.setParams(httpConnectionParams);
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void setPort(int i2) throws IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.setPort(i2);
            }
        }

        public void setProtocol(Protocol protocol) {
            if (hasConnection()) {
                this.wrappedConnection.setProtocol(protocol);
            }
        }

        public void setProxyHost(String str) throws IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.setProxyHost(str);
            }
        }

        public void setProxyPort(int i2) throws IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.setProxyPort(i2);
            }
        }

        public void setSendBufferSize(int i2) throws SocketException {
            if (hasConnection()) {
                this.wrappedConnection.setSendBufferSize(i2);
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void setSoTimeout(int i2) throws SocketException, IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.setSoTimeout(i2);
            }
        }

        public void setSocketTimeout(int i2) throws SocketException, IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.setSocketTimeout(i2);
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void setStaleCheckingEnabled(boolean z) {
            if (hasConnection()) {
                this.wrappedConnection.setStaleCheckingEnabled(z);
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void setVirtualHost(String str) throws IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.setVirtualHost(str);
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void shutdownOutput() {
            if (hasConnection()) {
                this.wrappedConnection.shutdownOutput();
            }
        }

        public void tunnelCreated() throws IllegalStateException, IOException {
            if (hasConnection()) {
                this.wrappedConnection.tunnelCreated();
            }
        }

        public void write(byte[] bArr) throws IOException, IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.write(bArr);
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void writeLine() throws IOException, IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.writeLine();
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public boolean isResponseAvailable(int i2) throws IOException {
            if (hasConnection()) {
                return this.wrappedConnection.isResponseAvailable(i2);
            }
            return false;
        }

        public void print(String str, String str2) throws IOException, IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.print(str, str2);
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void printLine(String str) throws IOException, IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.printLine(str);
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public String readLine(String str) throws IOException, IllegalStateException {
            if (hasConnection()) {
                return this.wrappedConnection.readLine(str);
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException, IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.write(bArr, i2, i3);
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void writeLine(byte[] bArr) throws IOException, IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.writeLine(bArr);
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }

        public void printLine(String str, String str2) throws IOException, IllegalStateException {
            if (hasConnection()) {
                this.wrappedConnection.printLine(str, str2);
                return;
            }
            throw new IllegalStateException("Connection has been released");
        }
    }

    private static class HttpConnectionWithReference extends HttpConnection {
        public WeakReference reference = new WeakReference(this, MultiThreadedHttpConnectionManager.REFERENCE_QUEUE);

        public HttpConnectionWithReference(HostConfiguration hostConfiguration) {
            super(hostConfiguration);
        }
    }

    private static class ReferenceQueueThread extends Thread {
        private volatile boolean shutdown = false;

        public ReferenceQueueThread() {
            setDaemon(true);
            setName("MultiThreadedHttpConnectionManager cleanup");
        }

        private void handleReference(Reference reference) {
            ConnectionSource connectionSource;
            synchronized (MultiThreadedHttpConnectionManager.REFERENCE_TO_CONNECTION_SOURCE) {
                connectionSource = (ConnectionSource) MultiThreadedHttpConnectionManager.REFERENCE_TO_CONNECTION_SOURCE.remove(reference);
            }
            if (connectionSource != null) {
                if (MultiThreadedHttpConnectionManager.LOG.isDebugEnabled()) {
                    Log access$700 = MultiThreadedHttpConnectionManager.LOG;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Connection reclaimed by garbage collector, hostConfig=");
                    stringBuffer.append(connectionSource.hostConfiguration);
                    access$700.debug(stringBuffer.toString());
                }
                connectionSource.connectionPool.handleLostConnection(connectionSource.hostConfiguration);
            }
        }

        public void run() {
            while (!this.shutdown) {
                try {
                    Reference remove = MultiThreadedHttpConnectionManager.REFERENCE_QUEUE.remove();
                    if (remove != null) {
                        handleReference(remove);
                    }
                } catch (InterruptedException e2) {
                    MultiThreadedHttpConnectionManager.LOG.debug("ReferenceQueueThread interrupted", e2);
                }
            }
        }

        public void shutdown() {
            this.shutdown = true;
            interrupt();
        }
    }

    private static class WaitingThread {
        public HostConnectionPool hostConnectionPool;
        public boolean interruptedByConnectionPool;
        public Thread thread;

        private WaitingThread() {
            this.interruptedByConnectionPool = false;
        }
    }

    static {
        Class cls = class$org$apache$commons$httpclient$MultiThreadedHttpConnectionManager;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.MultiThreadedHttpConnectionManager");
            class$org$apache$commons$httpclient$MultiThreadedHttpConnectionManager = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public MultiThreadedHttpConnectionManager() {
        synchronized (ALL_CONNECTION_MANAGERS) {
            ALL_CONNECTION_MANAGERS.put(this, (Object) null);
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public HostConfiguration configurationForConnection(HttpConnection httpConnection) {
        HostConfiguration hostConfiguration = new HostConfiguration();
        hostConfiguration.setHost(httpConnection.getHost(), httpConnection.getPort(), httpConnection.getProtocol());
        if (httpConnection.getLocalAddress() != null) {
            hostConfiguration.setLocalAddress(httpConnection.getLocalAddress());
        }
        if (httpConnection.getProxyHost() != null) {
            hostConfiguration.setProxy(httpConnection.getProxyHost(), httpConnection.getProxyPort());
        }
        return hostConfiguration;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00e7, code lost:
        if (r6 != false) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0105, code lost:
        if (r6 != false) goto L_0x00e9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x010c A[SYNTHETIC, Splitter:B:69:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x011f A[Catch:{ all -> 0x0044 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x012f A[Catch:{ all -> 0x0044 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.commons.httpclient.HttpConnection doGetConnection(org.apache.commons.httpclient.HostConfiguration r19, long r20) throws org.apache.commons.httpclient.ConnectionPoolTimeoutException {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            org.apache.commons.httpclient.params.HttpConnectionManagerParams r2 = r1.params
            int r2 = r2.getMaxConnectionsPerHost(r0)
            org.apache.commons.httpclient.params.HttpConnectionManagerParams r3 = r1.params
            int r3 = r3.getMaxTotalConnections()
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ConnectionPool r4 = r1.connectionPool
            monitor-enter(r4)
            org.apache.commons.httpclient.HostConfiguration r5 = new org.apache.commons.httpclient.HostConfiguration     // Catch:{ all -> 0x0044 }
            r5.<init>(r0)     // Catch:{ all -> 0x0044 }
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0044 }
            r6 = 1
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$HostConnectionPool r7 = r0.getHostPool(r5, r6)     // Catch:{ all -> 0x0044 }
            r8 = 0
            r9 = 0
            int r0 = (r20 > r9 ? 1 : (r20 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r6 = 0
        L_0x0028:
            r11 = 0
            r12 = r20
            r16 = r9
            r14 = r11
            r15 = r14
        L_0x002f:
            if (r14 != 0) goto L_0x013b
            boolean r0 = r1.shutdown     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0133
            java.util.LinkedList r0 = r7.freeConnections     // Catch:{ all -> 0x0044 }
            int r0 = r0.size()     // Catch:{ all -> 0x0044 }
            if (r0 <= 0) goto L_0x0047
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0044 }
            org.apache.commons.httpclient.HttpConnection r14 = r0.getFreeConnection(r5)     // Catch:{ all -> 0x0044 }
            goto L_0x002f
        L_0x0044:
            r0 = move-exception
            goto L_0x013d
        L_0x0047:
            int r0 = r7.numConnections     // Catch:{ all -> 0x0044 }
            if (r0 >= r2) goto L_0x005a
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0044 }
            int r0 = r0.numConnections     // Catch:{ all -> 0x0044 }
            if (r0 >= r3) goto L_0x005a
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0044 }
        L_0x0055:
            org.apache.commons.httpclient.HttpConnection r14 = r0.createConnection(r5)     // Catch:{ all -> 0x0044 }
            goto L_0x002f
        L_0x005a:
            int r0 = r7.numConnections     // Catch:{ all -> 0x0044 }
            if (r0 >= r2) goto L_0x0072
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0044 }
            java.util.LinkedList r0 = r0.freeConnections     // Catch:{ all -> 0x0044 }
            int r0 = r0.size()     // Catch:{ all -> 0x0044 }
            if (r0 <= 0) goto L_0x0072
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0044 }
            r0.deleteLeastUsedConnection()     // Catch:{ all -> 0x0044 }
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0044 }
            goto L_0x0055
        L_0x0072:
            if (r6 == 0) goto L_0x0087
            int r0 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x0079
            goto L_0x0087
        L_0x0079:
            org.apache.commons.httpclient.ConnectionPoolTimeoutException r0 = new org.apache.commons.httpclient.ConnectionPoolTimeoutException     // Catch:{ InterruptedException -> 0x0084 }
            java.lang.String r9 = "Timeout waiting for connection"
            r0.<init>(r9)     // Catch:{ InterruptedException -> 0x0084 }
            throw r0     // Catch:{ InterruptedException -> 0x0084 }
        L_0x0081:
            r0 = move-exception
            goto L_0x011b
        L_0x0084:
            r0 = move-exception
            goto L_0x00f1
        L_0x0087:
            org.apache.commons.logging.Log r0 = LOG     // Catch:{ InterruptedException -> 0x0084 }
            boolean r9 = r0.isDebugEnabled()     // Catch:{ InterruptedException -> 0x0084 }
            if (r9 == 0) goto L_0x00a3
            java.lang.StringBuffer r9 = new java.lang.StringBuffer     // Catch:{ InterruptedException -> 0x0084 }
            r9.<init>()     // Catch:{ InterruptedException -> 0x0084 }
            java.lang.String r10 = "Unable to get a connection, waiting..., hostConfig="
            r9.append(r10)     // Catch:{ InterruptedException -> 0x0084 }
            r9.append(r5)     // Catch:{ InterruptedException -> 0x0084 }
            java.lang.String r9 = r9.toString()     // Catch:{ InterruptedException -> 0x0084 }
            r0.debug(r9)     // Catch:{ InterruptedException -> 0x0084 }
        L_0x00a3:
            if (r15 != 0) goto L_0x00ba
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$WaitingThread r9 = new org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$WaitingThread     // Catch:{ InterruptedException -> 0x0084 }
            r9.<init>()     // Catch:{ InterruptedException -> 0x0084 }
            r9.hostConnectionPool = r7     // Catch:{ InterruptedException -> 0x00b7, all -> 0x00b4 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ InterruptedException -> 0x00b7, all -> 0x00b4 }
            r9.thread = r0     // Catch:{ InterruptedException -> 0x00b7, all -> 0x00b4 }
            r15 = r9
            goto L_0x00bc
        L_0x00b4:
            r0 = move-exception
            r15 = r9
            goto L_0x011b
        L_0x00b7:
            r0 = move-exception
            r15 = r9
            goto L_0x00f1
        L_0x00ba:
            r15.interruptedByConnectionPool = r8     // Catch:{ InterruptedException -> 0x0084 }
        L_0x00bc:
            if (r6 == 0) goto L_0x00c2
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ InterruptedException -> 0x0084 }
        L_0x00c2:
            java.util.LinkedList r0 = r7.waitingThreads     // Catch:{ InterruptedException -> 0x0084 }
            r0.addLast(r15)     // Catch:{ InterruptedException -> 0x0084 }
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ConnectionPool r0 = r1.connectionPool     // Catch:{ InterruptedException -> 0x0084 }
            java.util.LinkedList r0 = r0.waitingThreads     // Catch:{ InterruptedException -> 0x0084 }
            r0.addLast(r15)     // Catch:{ InterruptedException -> 0x0084 }
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ConnectionPool r0 = r1.connectionPool     // Catch:{ InterruptedException -> 0x0084 }
            r0.wait(r12)     // Catch:{ InterruptedException -> 0x0084 }
            boolean r0 = r15.interruptedByConnectionPool     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x00e7
            java.util.LinkedList r0 = r7.waitingThreads     // Catch:{ all -> 0x0044 }
            r0.remove(r15)     // Catch:{ all -> 0x0044 }
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0044 }
            java.util.LinkedList r0 = r0.waitingThreads     // Catch:{ all -> 0x0044 }
            r0.remove(r15)     // Catch:{ all -> 0x0044 }
        L_0x00e7:
            if (r6 == 0) goto L_0x0108
        L_0x00e9:
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0044 }
            long r9 = r9 - r16
            long r12 = r12 - r9
            goto L_0x0108
        L_0x00f1:
            boolean r9 = r15.interruptedByConnectionPool     // Catch:{ all -> 0x0081 }
            if (r9 == 0) goto L_0x010c
            if (r9 != 0) goto L_0x0105
            java.util.LinkedList r0 = r7.waitingThreads     // Catch:{ all -> 0x0044 }
            r0.remove(r15)     // Catch:{ all -> 0x0044 }
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ConnectionPool r0 = r1.connectionPool     // Catch:{ all -> 0x0044 }
            java.util.LinkedList r0 = r0.waitingThreads     // Catch:{ all -> 0x0044 }
            r0.remove(r15)     // Catch:{ all -> 0x0044 }
        L_0x0105:
            if (r6 == 0) goto L_0x0108
            goto L_0x00e9
        L_0x0108:
            r9 = 0
            goto L_0x002f
        L_0x010c:
            org.apache.commons.logging.Log r2 = LOG     // Catch:{ all -> 0x0081 }
            java.lang.String r3 = "Interrupted while waiting for connection"
            r2.debug(r3, r0)     // Catch:{ all -> 0x0081 }
            java.lang.IllegalThreadStateException r0 = new java.lang.IllegalThreadStateException     // Catch:{ all -> 0x0081 }
            java.lang.String r2 = "Interrupted while waiting in MultiThreadedHttpConnectionManager"
            r0.<init>(r2)     // Catch:{ all -> 0x0081 }
            throw r0     // Catch:{ all -> 0x0081 }
        L_0x011b:
            boolean r2 = r15.interruptedByConnectionPool     // Catch:{ all -> 0x0044 }
            if (r2 != 0) goto L_0x012d
            java.util.LinkedList r2 = r7.waitingThreads     // Catch:{ all -> 0x0044 }
            r2.remove(r15)     // Catch:{ all -> 0x0044 }
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ConnectionPool r2 = r1.connectionPool     // Catch:{ all -> 0x0044 }
            java.util.LinkedList r2 = r2.waitingThreads     // Catch:{ all -> 0x0044 }
            r2.remove(r15)     // Catch:{ all -> 0x0044 }
        L_0x012d:
            if (r6 == 0) goto L_0x0132
            java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0044 }
        L_0x0132:
            throw r0     // Catch:{ all -> 0x0044 }
        L_0x0133:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "Connection factory has been shutdown."
            r0.<init>(r2)     // Catch:{ all -> 0x0044 }
            throw r0     // Catch:{ all -> 0x0044 }
        L_0x013b:
            monitor-exit(r4)     // Catch:{ all -> 0x0044 }
            return r14
        L_0x013d:
            monitor-exit(r4)     // Catch:{ all -> 0x0044 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.MultiThreadedHttpConnectionManager.doGetConnection(org.apache.commons.httpclient.HostConfiguration, long):org.apache.commons.httpclient.HttpConnection");
    }

    /* access modifiers changed from: private */
    public static void removeReferenceToConnection(HttpConnectionWithReference httpConnectionWithReference) {
        Map map = REFERENCE_TO_CONNECTION_SOURCE;
        synchronized (map) {
            map.remove(httpConnectionWithReference.reference);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void shutdownAll() {
        /*
            java.util.Map r0 = REFERENCE_TO_CONNECTION_SOURCE
            monitor-enter(r0)
            java.util.WeakHashMap r1 = ALL_CONNECTION_MANAGERS     // Catch:{ all -> 0x0037 }
            monitor-enter(r1)     // Catch:{ all -> 0x0037 }
            java.util.WeakHashMap r2 = ALL_CONNECTION_MANAGERS     // Catch:{ all -> 0x0026 }
            java.util.Set r2 = r2.keySet()     // Catch:{ all -> 0x0026 }
            java.util.WeakHashMap r3 = ALL_CONNECTION_MANAGERS     // Catch:{ all -> 0x0026 }
            int r3 = r3.size()     // Catch:{ all -> 0x0026 }
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager[] r3 = new org.apache.commons.httpclient.MultiThreadedHttpConnectionManager[r3]     // Catch:{ all -> 0x0026 }
            java.lang.Object[] r2 = r2.toArray(r3)     // Catch:{ all -> 0x0026 }
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager[] r2 = (org.apache.commons.httpclient.MultiThreadedHttpConnectionManager[]) r2     // Catch:{ all -> 0x0026 }
            r3 = 0
        L_0x001b:
            int r4 = r2.length     // Catch:{ all -> 0x0026 }
            if (r3 >= r4) goto L_0x002b
            r4 = r2[r3]     // Catch:{ all -> 0x0026 }
            if (r4 == 0) goto L_0x0028
            r4.shutdown()     // Catch:{ all -> 0x0026 }
            goto L_0x0028
        L_0x0026:
            r2 = move-exception
            goto L_0x0040
        L_0x0028:
            int r3 = r3 + 1
            goto L_0x001b
        L_0x002b:
            monitor-exit(r1)     // Catch:{ all -> 0x0026 }
            org.apache.commons.httpclient.MultiThreadedHttpConnectionManager$ReferenceQueueThread r1 = REFERENCE_QUEUE_THREAD     // Catch:{ all -> 0x0037 }
            if (r1 == 0) goto L_0x0039
            r1.shutdown()     // Catch:{ all -> 0x0037 }
            r1 = 0
            REFERENCE_QUEUE_THREAD = r1     // Catch:{ all -> 0x0037 }
            goto L_0x0039
        L_0x0037:
            r1 = move-exception
            goto L_0x0042
        L_0x0039:
            java.util.Map r1 = REFERENCE_TO_CONNECTION_SOURCE     // Catch:{ all -> 0x0037 }
            r1.clear()     // Catch:{ all -> 0x0037 }
            monitor-exit(r0)     // Catch:{ all -> 0x0037 }
            return
        L_0x0040:
            monitor-exit(r1)     // Catch:{ all -> 0x0026 }
            throw r2     // Catch:{ all -> 0x0037 }
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0037 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.MultiThreadedHttpConnectionManager.shutdownAll():void");
    }

    /* access modifiers changed from: private */
    public static void shutdownCheckedOutConnections(ConnectionPool connectionPool2) {
        ArrayList arrayList = new ArrayList();
        Map map = REFERENCE_TO_CONNECTION_SOURCE;
        synchronized (map) {
            try {
                Iterator it2 = map.keySet().iterator();
                while (it2.hasNext()) {
                    Reference reference = (Reference) it2.next();
                    if (((ConnectionSource) REFERENCE_TO_CONNECTION_SOURCE.get(reference)).connectionPool == connectionPool2) {
                        it2.remove();
                        HttpConnection httpConnection = (HttpConnection) reference.get();
                        if (httpConnection != null) {
                            arrayList.add(httpConnection);
                        }
                    }
                }
            } finally {
                while (true) {
                }
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            HttpConnection httpConnection2 = (HttpConnection) it3.next();
            httpConnection2.close();
            httpConnection2.setHttpConnectionManager((HttpConnectionManager) null);
            httpConnection2.releaseConnection();
        }
    }

    /* access modifiers changed from: private */
    public static void storeReferenceToConnection(HttpConnectionWithReference httpConnectionWithReference, HostConfiguration hostConfiguration, ConnectionPool connectionPool2) {
        ConnectionSource connectionSource = new ConnectionSource();
        connectionSource.connectionPool = connectionPool2;
        connectionSource.hostConfiguration = hostConfiguration;
        Map map = REFERENCE_TO_CONNECTION_SOURCE;
        synchronized (map) {
            try {
                if (REFERENCE_QUEUE_THREAD == null) {
                    ReferenceQueueThread referenceQueueThread = new ReferenceQueueThread();
                    REFERENCE_QUEUE_THREAD = referenceQueueThread;
                    referenceQueueThread.start();
                }
                map.put(httpConnectionWithReference.reference, connectionSource);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void closeIdleConnections(long j2) {
        this.connectionPool.closeIdleConnections(j2);
        deleteClosedConnections();
    }

    public void deleteClosedConnections() {
        this.connectionPool.deleteClosedConnections();
    }

    public HttpConnection getConnection(HostConfiguration hostConfiguration) {
        while (true) {
            try {
                return getConnectionWithTimeout(hostConfiguration, 0);
            } catch (ConnectionPoolTimeoutException e2) {
                LOG.debug("Unexpected exception while waiting for connection", e2);
            }
        }
    }

    public HttpConnection getConnectionWithTimeout(HostConfiguration hostConfiguration, long j2) throws ConnectionPoolTimeoutException {
        Log log = LOG;
        log.trace("enter HttpConnectionManager.getConnectionWithTimeout(HostConfiguration, long)");
        if (hostConfiguration != null) {
            if (log.isDebugEnabled()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("HttpConnectionManager.getConnection:  config = ");
                stringBuffer.append(hostConfiguration);
                stringBuffer.append(", timeout = ");
                stringBuffer.append(j2);
                log.debug(stringBuffer.toString());
            }
            return new HttpConnectionAdapter(doGetConnection(hostConfiguration, j2));
        }
        throw new IllegalArgumentException("hostConfiguration is null");
    }

    public int getConnectionsInPool() {
        int access$200;
        synchronized (this.connectionPool) {
            access$200 = this.connectionPool.numConnections;
        }
        return access$200;
    }

    public int getConnectionsInUse() {
        return getConnectionsInPool();
    }

    public int getMaxConnectionsPerHost() {
        return this.params.getDefaultMaxConnectionsPerHost();
    }

    public int getMaxTotalConnections() {
        return this.params.getMaxTotalConnections();
    }

    public HttpConnectionManagerParams getParams() {
        return this.params;
    }

    public boolean isConnectionStaleCheckingEnabled() {
        return this.params.isStaleCheckingEnabled();
    }

    public void releaseConnection(HttpConnection httpConnection) {
        LOG.trace("enter HttpConnectionManager.releaseConnection(HttpConnection)");
        if (httpConnection instanceof HttpConnectionAdapter) {
            httpConnection = ((HttpConnectionAdapter) httpConnection).getWrappedConnection();
        }
        SimpleHttpConnectionManager.finishLastResponse(httpConnection);
        this.connectionPool.freeConnection(httpConnection);
    }

    public void setConnectionStaleCheckingEnabled(boolean z) {
        this.params.setStaleCheckingEnabled(z);
    }

    public void setMaxConnectionsPerHost(int i2) {
        this.params.setDefaultMaxConnectionsPerHost(i2);
    }

    public void setMaxTotalConnections(int i2) {
        this.params.setMaxTotalConnections(i2);
    }

    public void setParams(HttpConnectionManagerParams httpConnectionManagerParams) {
        if (httpConnectionManagerParams != null) {
            this.params = httpConnectionManagerParams;
            return;
        }
        throw new IllegalArgumentException("Parameters may not be null");
    }

    public synchronized void shutdown() {
        synchronized (this.connectionPool) {
            try {
                if (!this.shutdown) {
                    this.shutdown = true;
                    this.connectionPool.shutdown();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public HttpConnection getConnection(HostConfiguration hostConfiguration, long j2) throws HttpException {
        LOG.trace("enter HttpConnectionManager.getConnection(HostConfiguration, long)");
        try {
            return getConnectionWithTimeout(hostConfiguration, j2);
        } catch (ConnectionPoolTimeoutException e2) {
            throw new HttpException(e2.getMessage());
        }
    }

    public int getConnectionsInPool(HostConfiguration hostConfiguration) {
        int i2;
        synchronized (this.connectionPool) {
            try {
                i2 = 0;
                HostConnectionPool hostPool = this.connectionPool.getHostPool(hostConfiguration, false);
                if (hostPool != null) {
                    i2 = hostPool.numConnections;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    public int getConnectionsInUse(HostConfiguration hostConfiguration) {
        return getConnectionsInPool(hostConfiguration);
    }
}
