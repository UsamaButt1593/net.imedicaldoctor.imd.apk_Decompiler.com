package org.apache.commons.httpclient.util;

import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.HttpConnectionManager;

public class IdleConnectionTimeoutThread extends Thread {
    private List connectionManagers = new ArrayList();
    private long connectionTimeout = C.c2;
    private boolean shutdown = false;
    private long timeoutInterval = 1000;

    public IdleConnectionTimeoutThread() {
        setDaemon(true);
    }

    public synchronized void addConnectionManager(HttpConnectionManager httpConnectionManager) {
        if (!this.shutdown) {
            this.connectionManagers.add(httpConnectionManager);
        } else {
            throw new IllegalStateException("IdleConnectionTimeoutThread has been shutdown");
        }
    }

    /* access modifiers changed from: protected */
    public void handleCloseIdleConnections(HttpConnectionManager httpConnectionManager) {
        httpConnectionManager.closeIdleConnections(this.connectionTimeout);
    }

    public synchronized void removeConnectionManager(HttpConnectionManager httpConnectionManager) {
        if (!this.shutdown) {
            this.connectionManagers.remove(httpConnectionManager);
        } else {
            throw new IllegalStateException("IdleConnectionTimeoutThread has been shutdown");
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0001 */
    /* JADX WARNING: Removed duplicated region for block: B:1:0x0001 A[LOOP:0: B:1:0x0001->B:18:0x0001, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void run() {
        /*
            r2 = this;
            monitor-enter(r2)
        L_0x0001:
            boolean r0 = r2.shutdown     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0023
            java.util.List r0 = r2.connectionManagers     // Catch:{ all -> 0x001b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x001b }
        L_0x000b:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x001d
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x001b }
            org.apache.commons.httpclient.HttpConnectionManager r1 = (org.apache.commons.httpclient.HttpConnectionManager) r1     // Catch:{ all -> 0x001b }
            r2.handleCloseIdleConnections(r1)     // Catch:{ all -> 0x001b }
            goto L_0x000b
        L_0x001b:
            r0 = move-exception
            goto L_0x002a
        L_0x001d:
            long r0 = r2.timeoutInterval     // Catch:{ InterruptedException -> 0x0001 }
            r2.wait(r0)     // Catch:{ InterruptedException -> 0x0001 }
            goto L_0x0001
        L_0x0023:
            java.util.List r0 = r2.connectionManagers     // Catch:{ all -> 0x001b }
            r0.clear()     // Catch:{ all -> 0x001b }
            monitor-exit(r2)
            return
        L_0x002a:
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.util.IdleConnectionTimeoutThread.run():void");
    }

    public synchronized void setConnectionTimeout(long j2) {
        if (!this.shutdown) {
            this.connectionTimeout = j2;
        } else {
            throw new IllegalStateException("IdleConnectionTimeoutThread has been shutdown");
        }
    }

    public synchronized void setTimeoutInterval(long j2) {
        if (!this.shutdown) {
            this.timeoutInterval = j2;
        } else {
            throw new IllegalStateException("IdleConnectionTimeoutThread has been shutdown");
        }
    }

    public synchronized void shutdown() {
        this.shutdown = true;
        notifyAll();
    }
}
