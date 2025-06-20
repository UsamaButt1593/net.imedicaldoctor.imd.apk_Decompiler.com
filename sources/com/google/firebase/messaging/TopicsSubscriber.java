package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class TopicsSubscriber {

    /* renamed from: i  reason: collision with root package name */
    static final String f24887i = "INTERNAL_SERVER_ERROR";

    /* renamed from: j  reason: collision with root package name */
    static final String f24888j = "SERVICE_NOT_AVAILABLE";

    /* renamed from: k  reason: collision with root package name */
    private static final long f24889k = 30;

    /* renamed from: l  reason: collision with root package name */
    private static final long f24890l = 30;

    /* renamed from: m  reason: collision with root package name */
    private static final long f24891m = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: a  reason: collision with root package name */
    private final Context f24892a;

    /* renamed from: b  reason: collision with root package name */
    private final Metadata f24893b;

    /* renamed from: c  reason: collision with root package name */
    private final GmsRpc f24894c;

    /* renamed from: d  reason: collision with root package name */
    private final FirebaseMessaging f24895d;
    @GuardedBy("pendingOperations")

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> f24896e = new ArrayMap();

    /* renamed from: f  reason: collision with root package name */
    private final ScheduledExecutorService f24897f;
    @GuardedBy("this")

    /* renamed from: g  reason: collision with root package name */
    private boolean f24898g = false;

    /* renamed from: h  reason: collision with root package name */
    private final TopicsStore f24899h;

    private TopicsSubscriber(FirebaseMessaging firebaseMessaging, Metadata metadata, TopicsStore topicsStore, GmsRpc gmsRpc, Context context, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.f24895d = firebaseMessaging;
        this.f24893b = metadata;
        this.f24899h = topicsStore;
        this.f24894c = gmsRpc;
        this.f24892a = context;
        this.f24897f = scheduledExecutorService;
    }

    private void b(TopicOperation topicOperation, TaskCompletionSource<Void> taskCompletionSource) {
        ArrayDeque arrayDeque;
        synchronized (this.f24896e) {
            try {
                String e2 = topicOperation.e();
                if (this.f24896e.containsKey(e2)) {
                    arrayDeque = this.f24896e.get(e2);
                } else {
                    ArrayDeque arrayDeque2 = new ArrayDeque();
                    this.f24896e.put(e2, arrayDeque2);
                    arrayDeque = arrayDeque2;
                }
                arrayDeque.add(taskCompletionSource);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    private static <T> void c(Task<T> task) throws IOException {
        try {
            Tasks.b(task, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e2);
            }
        } catch (InterruptedException | TimeoutException e3) {
            throw new IOException(f24888j, e3);
        }
    }

    @WorkerThread
    private void d(String str) throws IOException {
        c(this.f24894c.n(this.f24895d.r(), str));
    }

    @WorkerThread
    private void e(String str) throws IOException {
        c(this.f24894c.o(this.f24895d.r(), str));
    }

    @VisibleForTesting
    static Task<TopicsSubscriber> f(FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc, Context context, @NonNull ScheduledExecutorService scheduledExecutorService) {
        return Tasks.d(scheduledExecutorService, new I(context, scheduledExecutorService, firebaseMessaging, metadata, gmsRpc));
    }

    static boolean i() {
        return Log.isLoggable(Constants.f24670a, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.f24670a, 3));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TopicsSubscriber k(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc) throws Exception {
        return new TopicsSubscriber(firebaseMessaging, metadata, TopicsStore.d(context, scheduledExecutorService), gmsRpc, context, scheduledExecutorService);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l(com.google.firebase.messaging.TopicOperation r5) {
        /*
            r4 = this;
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r0 = r4.f24896e
            monitor-enter(r0)
            java.lang.String r5 = r5.e()     // Catch:{ all -> 0x0011 }
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r4.f24896e     // Catch:{ all -> 0x0011 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x0011 }
            if (r1 != 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0011:
            r5 = move-exception
            goto L_0x0034
        L_0x0013:
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r4.f24896e     // Catch:{ all -> 0x0011 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0011 }
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch:{ all -> 0x0011 }
            java.lang.Object r2 = r1.poll()     // Catch:{ all -> 0x0011 }
            com.google.android.gms.tasks.TaskCompletionSource r2 = (com.google.android.gms.tasks.TaskCompletionSource) r2     // Catch:{ all -> 0x0011 }
            if (r2 == 0) goto L_0x0027
            r3 = 0
            r2.c(r3)     // Catch:{ all -> 0x0011 }
        L_0x0027:
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0011 }
            if (r1 == 0) goto L_0x0032
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r4.f24896e     // Catch:{ all -> 0x0011 }
            r1.remove(r5)     // Catch:{ all -> 0x0011 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            return
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x0011 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.l(com.google.firebase.messaging.TopicOperation):void");
    }

    private void q() {
        if (!j()) {
            u(0);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public TopicsStore g() {
        return this.f24899h;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f24899h.e() != null;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean j() {
        return this.f24898g;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079 A[Catch:{ IOException -> 0x001f }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m(com.google.firebase.messaging.TopicOperation r7) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "FirebaseMessaging"
            r1 = 0
            java.lang.String r2 = r7.b()     // Catch:{ IOException -> 0x001f }
            int r3 = r2.hashCode()     // Catch:{ IOException -> 0x001f }
            r4 = 83
            r5 = 1
            if (r3 == r4) goto L_0x0022
            r4 = 85
            if (r3 == r4) goto L_0x0015
            goto L_0x002c
        L_0x0015:
            java.lang.String r3 = "U"
            boolean r2 = r2.equals(r3)     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x002c
            r2 = 1
            goto L_0x002d
        L_0x001f:
            r7 = move-exception
            goto L_0x00a0
        L_0x0022:
            java.lang.String r3 = "S"
            boolean r2 = r2.equals(r3)     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x002c
            r2 = 0
            goto L_0x002d
        L_0x002c:
            r2 = -1
        L_0x002d:
            java.lang.String r3 = " succeeded."
            if (r2 == 0) goto L_0x0079
            if (r2 == r5) goto L_0x0053
            boolean r2 = i()     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x009f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x001f }
            r2.<init>()     // Catch:{ IOException -> 0x001f }
            java.lang.String r3 = "Unknown topic operation"
            r2.append(r3)     // Catch:{ IOException -> 0x001f }
            r2.append(r7)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = "."
            r2.append(r7)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r2.toString()     // Catch:{ IOException -> 0x001f }
        L_0x004f:
            android.util.Log.d(r0, r7)     // Catch:{ IOException -> 0x001f }
            goto L_0x009f
        L_0x0053:
            java.lang.String r2 = r7.c()     // Catch:{ IOException -> 0x001f }
            r6.e(r2)     // Catch:{ IOException -> 0x001f }
            boolean r2 = i()     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x009f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x001f }
            r2.<init>()     // Catch:{ IOException -> 0x001f }
            java.lang.String r4 = "Unsubscribe from topic: "
            r2.append(r4)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r7.c()     // Catch:{ IOException -> 0x001f }
            r2.append(r7)     // Catch:{ IOException -> 0x001f }
            r2.append(r3)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r2.toString()     // Catch:{ IOException -> 0x001f }
            goto L_0x004f
        L_0x0079:
            java.lang.String r2 = r7.c()     // Catch:{ IOException -> 0x001f }
            r6.d(r2)     // Catch:{ IOException -> 0x001f }
            boolean r2 = i()     // Catch:{ IOException -> 0x001f }
            if (r2 == 0) goto L_0x009f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x001f }
            r2.<init>()     // Catch:{ IOException -> 0x001f }
            java.lang.String r4 = "Subscribe to topic: "
            r2.append(r4)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r7.c()     // Catch:{ IOException -> 0x001f }
            r2.append(r7)     // Catch:{ IOException -> 0x001f }
            r2.append(r3)     // Catch:{ IOException -> 0x001f }
            java.lang.String r7 = r2.toString()     // Catch:{ IOException -> 0x001f }
            goto L_0x004f
        L_0x009f:
            return r5
        L_0x00a0:
            java.lang.String r2 = "SERVICE_NOT_AVAILABLE"
            java.lang.String r3 = r7.getMessage()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x00c6
            java.lang.String r2 = "INTERNAL_SERVER_ERROR"
            java.lang.String r3 = r7.getMessage()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00b9
            goto L_0x00c6
        L_0x00b9:
            java.lang.String r2 = r7.getMessage()
            if (r2 != 0) goto L_0x00c5
            java.lang.String r7 = "Topic operation failed without exception message. Will retry Topic operation."
        L_0x00c1:
            android.util.Log.e(r0, r7)
            return r1
        L_0x00c5:
            throw r7
        L_0x00c6:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Topic operation failed: "
            r2.append(r3)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = ". Will retry Topic operation."
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            goto L_0x00c1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.m(com.google.firebase.messaging.TopicOperation):boolean");
    }

    /* access modifiers changed from: package-private */
    public void n(Runnable runnable, long j2) {
        this.f24897f.schedule(runnable, j2, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public Task<Void> o(TopicOperation topicOperation) {
        this.f24899h.a(topicOperation);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        b(topicOperation, taskCompletionSource);
        return taskCompletionSource.a();
    }

    /* access modifiers changed from: package-private */
    public synchronized void p(boolean z) {
        this.f24898g = z;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        if (h()) {
            q();
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Void> s(String str) {
        Task<Void> o = o(TopicOperation.f(str));
        r();
        return o;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (m(r0) != false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        return false;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean t() throws java.io.IOException {
        /*
            r2 = this;
        L_0x0000:
            monitor-enter(r2)
            com.google.firebase.messaging.TopicsStore r0 = r2.f24899h     // Catch:{ all -> 0x0017 }
            com.google.firebase.messaging.TopicOperation r0 = r0.e()     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x001c
            boolean r0 = i()     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0017 }
            goto L_0x0019
        L_0x0017:
            r0 = move-exception
            goto L_0x002e
        L_0x0019:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            r0 = 1
            return r0
        L_0x001c:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            boolean r1 = r2.m(r0)
            if (r1 != 0) goto L_0x0025
            r0 = 0
            return r0
        L_0x0025:
            com.google.firebase.messaging.TopicsStore r1 = r2.f24899h
            r1.i(r0)
            r2.l(r0)
            goto L_0x0000
        L_0x002e:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.t():boolean");
    }

    /* access modifiers changed from: package-private */
    public void u(long j2) {
        n(new TopicsSyncTask(this, this.f24892a, this.f24893b, Math.min(Math.max(30, 2 * j2), f24891m)), j2);
        p(true);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> v(String str) {
        Task<Void> o = o(TopicOperation.g(str));
        r();
        return o;
    }
}
