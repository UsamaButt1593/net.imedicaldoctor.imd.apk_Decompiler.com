package com.google.firebase.messaging;

import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

class RequestDeduplicator {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f24838a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Task<String>> f24839b = new ArrayMap();

    interface GetTokenRequest {
        Task<String> start();
    }

    RequestDeduplicator(Executor executor) {
        this.f24838a = executor;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task c(String str, Task task) throws Exception {
        synchronized (this) {
            this.f24839b.remove(str);
        }
        return task;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.android.gms.tasks.Task<java.lang.String> b(java.lang.String r4, com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Map<java.lang.String, com.google.android.gms.tasks.Task<java.lang.String>> r0 = r3.f24839b     // Catch:{ all -> 0x002b }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002b }
            com.google.android.gms.tasks.Task r0 = (com.google.android.gms.tasks.Task) r0     // Catch:{ all -> 0x002b }
            r1 = 3
            if (r0 == 0) goto L_0x002f
            java.lang.String r5 = "FirebaseMessaging"
            boolean r5 = android.util.Log.isLoggable(r5, r1)     // Catch:{ all -> 0x002b }
            if (r5 == 0) goto L_0x002d
            java.lang.String r5 = "FirebaseMessaging"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r1.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r2 = "Joining ongoing request for: "
            r1.append(r2)     // Catch:{ all -> 0x002b }
            r1.append(r4)     // Catch:{ all -> 0x002b }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x002b }
            android.util.Log.d(r5, r4)     // Catch:{ all -> 0x002b }
            goto L_0x002d
        L_0x002b:
            r4 = move-exception
            goto L_0x0063
        L_0x002d:
            monitor-exit(r3)
            return r0
        L_0x002f:
            java.lang.String r0 = "FirebaseMessaging"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r1.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r2 = "Making new request for: "
            r1.append(r2)     // Catch:{ all -> 0x002b }
            r1.append(r4)     // Catch:{ all -> 0x002b }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x002b }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x002b }
        L_0x004d:
            com.google.android.gms.tasks.Task r5 = r5.start()     // Catch:{ all -> 0x002b }
            java.util.concurrent.Executor r0 = r3.f24838a     // Catch:{ all -> 0x002b }
            com.google.firebase.messaging.G r1 = new com.google.firebase.messaging.G     // Catch:{ all -> 0x002b }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x002b }
            com.google.android.gms.tasks.Task r5 = r5.p(r0, r1)     // Catch:{ all -> 0x002b }
            java.util.Map<java.lang.String, com.google.android.gms.tasks.Task<java.lang.String>> r0 = r3.f24839b     // Catch:{ all -> 0x002b }
            r0.put(r4, r5)     // Catch:{ all -> 0x002b }
            monitor-exit(r3)
            return r5
        L_0x0063:
            monitor-exit(r3)     // Catch:{ all -> 0x002b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.RequestDeduplicator.b(java.lang.String, com.google.firebase.messaging.RequestDeduplicator$GetTokenRequest):com.google.android.gms.tasks.Task");
    }
}
