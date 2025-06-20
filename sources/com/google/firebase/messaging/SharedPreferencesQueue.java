package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

final class SharedPreferencesQueue {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f24854a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24855b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24856c;
    @VisibleForTesting
    @GuardedBy("internalQueue")

    /* renamed from: d  reason: collision with root package name */
    final ArrayDeque<String> f24857d = new ArrayDeque<>();

    /* renamed from: e  reason: collision with root package name */
    private final Executor f24858e;
    @GuardedBy("internalQueue")

    /* renamed from: f  reason: collision with root package name */
    private boolean f24859f = false;

    private SharedPreferencesQueue(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f24854a = sharedPreferences;
        this.f24855b = str;
        this.f24856c = str2;
        this.f24858e = executor;
    }

    @GuardedBy("internalQueue")
    private String e(String str) {
        f(str != null);
        return str;
    }

    @GuardedBy("internalQueue")
    private boolean f(boolean z) {
        if (z && !this.f24859f) {
            s();
        }
        return z;
    }

    @WorkerThread
    static SharedPreferencesQueue j(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        SharedPreferencesQueue sharedPreferencesQueue = new SharedPreferencesQueue(sharedPreferences, str, str2, executor);
        sharedPreferencesQueue.k();
        return sharedPreferencesQueue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        return;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k() {
        /*
            r6 = this;
            java.util.ArrayDeque<java.lang.String> r0 = r6.f24857d
            monitor-enter(r0)
            java.util.ArrayDeque<java.lang.String> r1 = r6.f24857d     // Catch:{ all -> 0x0033 }
            r1.clear()     // Catch:{ all -> 0x0033 }
            android.content.SharedPreferences r1 = r6.f24854a     // Catch:{ all -> 0x0033 }
            java.lang.String r2 = r6.f24855b     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = ""
            java.lang.String r1 = r1.getString(r2, r3)     // Catch:{ all -> 0x0033 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x004b
            java.lang.String r2 = r6.f24856c     // Catch:{ all -> 0x0033 }
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x0021
            goto L_0x004b
        L_0x0021:
            java.lang.String r2 = r6.f24856c     // Catch:{ all -> 0x0033 }
            r3 = -1
            java.lang.String[] r1 = r1.split(r2, r3)     // Catch:{ all -> 0x0033 }
            int r2 = r1.length     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x0035
            java.lang.String r2 = "FirebaseMessaging"
            java.lang.String r3 = "Corrupted queue. Please check the queue contents and item separator provided"
            android.util.Log.e(r2, r3)     // Catch:{ all -> 0x0033 }
            goto L_0x0035
        L_0x0033:
            r1 = move-exception
            goto L_0x004d
        L_0x0035:
            int r2 = r1.length     // Catch:{ all -> 0x0033 }
            r3 = 0
        L_0x0037:
            if (r3 >= r2) goto L_0x0049
            r4 = r1[r3]     // Catch:{ all -> 0x0033 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0033 }
            if (r5 != 0) goto L_0x0046
            java.util.ArrayDeque<java.lang.String> r5 = r6.f24857d     // Catch:{ all -> 0x0033 }
            r5.add(r4)     // Catch:{ all -> 0x0033 }
        L_0x0046:
            int r3 = r3 + 1
            goto L_0x0037
        L_0x0049:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.SharedPreferencesQueue.k():void");
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void r() {
        synchronized (this.f24857d) {
            this.f24854a.edit().putString(this.f24855b, o()).commit();
        }
    }

    private void s() {
        this.f24858e.execute(new H(this));
    }

    public boolean b(@NonNull String str) {
        boolean f2;
        if (TextUtils.isEmpty(str) || str.contains(this.f24856c)) {
            return false;
        }
        synchronized (this.f24857d) {
            f2 = f(this.f24857d.add(str));
        }
        return f2;
    }

    @GuardedBy("internalQueue")
    public void c() {
        this.f24859f = true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void d() {
        synchronized (this.f24857d) {
            c();
        }
    }

    public void g() {
        synchronized (this.f24857d) {
            this.f24857d.clear();
            f(true);
        }
    }

    @GuardedBy("internalQueue")
    public void h() {
        this.f24859f = false;
        s();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void i() {
        synchronized (this.f24857d) {
            h();
        }
    }

    @Nullable
    public String l() {
        String peek;
        synchronized (this.f24857d) {
            peek = this.f24857d.peek();
        }
        return peek;
    }

    public String m() {
        String e2;
        synchronized (this.f24857d) {
            e2 = e(this.f24857d.remove());
        }
        return e2;
    }

    public boolean n(@Nullable Object obj) {
        boolean f2;
        synchronized (this.f24857d) {
            f2 = f(this.f24857d.remove(obj));
        }
        return f2;
    }

    @GuardedBy("internalQueue")
    @NonNull
    public String o() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it2 = this.f24857d.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            sb.append(this.f24856c);
        }
        return sb.toString();
    }

    @VisibleForTesting
    public String p() {
        String o;
        synchronized (this.f24857d) {
            o = o();
        }
        return o;
    }

    public int q() {
        int size;
        synchronized (this.f24857d) {
            size = this.f24857d.size();
        }
        return size;
    }

    @NonNull
    public List<String> t() {
        ArrayList arrayList;
        synchronized (this.f24857d) {
            arrayList = new ArrayList(this.f24857d);
        }
        return arrayList;
    }
}
