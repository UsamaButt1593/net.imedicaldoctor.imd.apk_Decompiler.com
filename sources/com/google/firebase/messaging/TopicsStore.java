package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;

final class TopicsStore {
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    static final String f24880d = "com.google.android.gms.appid";
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    static final String f24881e = "topic_operation_queue";

    /* renamed from: f  reason: collision with root package name */
    private static final String f24882f = ",";
    @GuardedBy("TopicsStore.class")

    /* renamed from: g  reason: collision with root package name */
    private static WeakReference<TopicsStore> f24883g;

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f24884a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferencesQueue f24885b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f24886c;

    private TopicsStore(SharedPreferences sharedPreferences, Executor executor) {
        this.f24886c = executor;
        this.f24884a = sharedPreferences;
    }

    @VisibleForTesting
    static synchronized void b() {
        synchronized (TopicsStore.class) {
            WeakReference<TopicsStore> weakReference = f24883g;
            if (weakReference != null) {
                weakReference.clear();
            }
        }
    }

    @WorkerThread
    public static synchronized TopicsStore d(Context context, Executor executor) {
        TopicsStore topicsStore;
        synchronized (TopicsStore.class) {
            try {
                WeakReference<TopicsStore> weakReference = f24883g;
                topicsStore = weakReference != null ? weakReference.get() : null;
                if (topicsStore == null) {
                    topicsStore = new TopicsStore(context.getSharedPreferences(f24880d, 0), executor);
                    topicsStore.g();
                    f24883g = new WeakReference<>(topicsStore);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return topicsStore;
    }

    @WorkerThread
    private synchronized void g() {
        this.f24885b = SharedPreferencesQueue.j(this.f24884a, f24881e, f24882f, this.f24886c);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean a(TopicOperation topicOperation) {
        return this.f24885b.b(topicOperation.e());
    }

    /* access modifiers changed from: package-private */
    public synchronized void c() {
        this.f24885b.g();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public synchronized TopicOperation e() {
        return TopicOperation.a(this.f24885b.l());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public synchronized List<TopicOperation> f() {
        ArrayList arrayList;
        List<String> t = this.f24885b.t();
        arrayList = new ArrayList(t.size());
        for (String a2 : t) {
            arrayList.add(TopicOperation.a(a2));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public synchronized TopicOperation h() {
        try {
        } catch (NoSuchElementException unused) {
            Log.e(Constants.f24670a, "Polling operation queue failed");
            return null;
        }
        return TopicOperation.a(this.f24885b.m());
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean i(TopicOperation topicOperation) {
        return this.f24885b.n(topicOperation.e());
    }
}
