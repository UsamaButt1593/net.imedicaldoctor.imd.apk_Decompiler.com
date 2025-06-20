package com.google.firebase.crashlytics.internal.metadata;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.g;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsBackgroundWorker;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

public class UserMetadata {

    /* renamed from: h  reason: collision with root package name */
    public static final String f23741h = "user-data";

    /* renamed from: i  reason: collision with root package name */
    public static final String f23742i = "keys";

    /* renamed from: j  reason: collision with root package name */
    public static final String f23743j = "internal-keys";

    /* renamed from: k  reason: collision with root package name */
    public static final String f23744k = "rollouts-state";
    @VisibleForTesting

    /* renamed from: l  reason: collision with root package name */
    public static final int f23745l = 64;
    @VisibleForTesting

    /* renamed from: m  reason: collision with root package name */
    public static final int f23746m = 1024;
    @VisibleForTesting

    /* renamed from: n  reason: collision with root package name */
    public static final int f23747n = 8192;
    @VisibleForTesting
    public static final int o = 128;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final MetaDataStore f23748a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final CrashlyticsBackgroundWorker f23749b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public String f23750c;

    /* renamed from: d  reason: collision with root package name */
    private final SerializeableKeysMap f23751d = new SerializeableKeysMap(false);

    /* renamed from: e  reason: collision with root package name */
    private final SerializeableKeysMap f23752e = new SerializeableKeysMap(true);

    /* renamed from: f  reason: collision with root package name */
    private final RolloutAssignmentList f23753f = new RolloutAssignmentList(128);

    /* renamed from: g  reason: collision with root package name */
    private final AtomicMarkableReference<String> f23754g = new AtomicMarkableReference<>((Object) null, false);

    private class SerializeableKeysMap {

        /* renamed from: a  reason: collision with root package name */
        final AtomicMarkableReference<KeysMap> f23755a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicReference<Callable<Void>> f23756b = new AtomicReference<>((Object) null);

        /* renamed from: c  reason: collision with root package name */
        private final boolean f23757c;

        public SerializeableKeysMap(boolean z) {
            this.f23757c = z;
            this.f23755a = new AtomicMarkableReference<>(new KeysMap(64, z ? 8192 : 1024), false);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Void c() throws Exception {
            this.f23756b.set((Object) null);
            e();
            return null;
        }

        private void d() {
            c cVar = new c(this);
            if (g.a(this.f23756b, (Object) null, cVar)) {
                UserMetadata.this.f23749b.h(cVar);
            }
        }

        private void e() {
            Map<String, String> map;
            synchronized (this) {
                try {
                    if (this.f23755a.isMarked()) {
                        map = this.f23755a.getReference().a();
                        AtomicMarkableReference<KeysMap> atomicMarkableReference = this.f23755a;
                        atomicMarkableReference.set(atomicMarkableReference.getReference(), false);
                    } else {
                        map = null;
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (map != null) {
                UserMetadata.this.f23748a.r(UserMetadata.this.f23750c, map, this.f23757c);
            }
        }

        public Map<String, String> b() {
            return this.f23755a.getReference().a();
        }

        public boolean f(String str, String str2) {
            synchronized (this) {
                try {
                    if (!this.f23755a.getReference().d(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference<KeysMap> atomicMarkableReference = this.f23755a;
                    atomicMarkableReference.set(atomicMarkableReference.getReference(), true);
                    d();
                    return true;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public void g(Map<String, String> map) {
            synchronized (this) {
                this.f23755a.getReference().e(map);
                AtomicMarkableReference<KeysMap> atomicMarkableReference = this.f23755a;
                atomicMarkableReference.set(atomicMarkableReference.getReference(), true);
            }
            d();
        }
    }

    public UserMetadata(String str, FileStore fileStore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        this.f23750c = str;
        this.f23748a = new MetaDataStore(fileStore);
        this.f23749b = crashlyticsBackgroundWorker;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object j() throws Exception {
        n();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object k(List list) throws Exception {
        this.f23748a.s(this.f23750c, list);
        return null;
    }

    public static UserMetadata l(String str, FileStore fileStore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker) {
        MetaDataStore metaDataStore = new MetaDataStore(fileStore);
        UserMetadata userMetadata = new UserMetadata(str, fileStore, crashlyticsBackgroundWorker);
        userMetadata.f23751d.f23755a.getReference().e(metaDataStore.j(str, false));
        userMetadata.f23752e.f23755a.getReference().e(metaDataStore.j(str, true));
        userMetadata.f23754g.set(metaDataStore.l(str), false);
        userMetadata.f23753f.c(metaDataStore.k(str));
        return userMetadata;
    }

    @Nullable
    public static String m(String str, FileStore fileStore) {
        return new MetaDataStore(fileStore).l(str);
    }

    private void n() {
        boolean z;
        String str;
        synchronized (this.f23754g) {
            try {
                z = false;
                if (this.f23754g.isMarked()) {
                    str = i();
                    this.f23754g.set(str, false);
                    z = true;
                } else {
                    str = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (z) {
            this.f23748a.t(this.f23750c, str);
        }
    }

    public Map<String, String> f() {
        return this.f23751d.b();
    }

    public Map<String, String> g() {
        return this.f23752e.b();
    }

    public List<CrashlyticsReport.Session.Event.RolloutAssignment> h() {
        return this.f23753f.a();
    }

    @Nullable
    public String i() {
        return this.f23754g.getReference();
    }

    public boolean o(String str, String str2) {
        return this.f23751d.f(str, str2);
    }

    public void p(Map<String, String> map) {
        this.f23751d.g(map);
    }

    public boolean q(String str, String str2) {
        return this.f23752e.f(str, str2);
    }

    public void r(String str) {
        synchronized (this.f23750c) {
            try {
                this.f23750c = str;
                Map<String, String> b2 = this.f23751d.b();
                List<RolloutAssignment> b3 = this.f23753f.b();
                if (i() != null) {
                    this.f23748a.t(str, i());
                }
                if (!b2.isEmpty()) {
                    this.f23748a.q(str, b2);
                }
                if (!b3.isEmpty()) {
                    this.f23748a.s(str, b3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void s(String str) {
        String c2 = KeysMap.c(str, 1024);
        synchronized (this.f23754g) {
            try {
                if (!CommonUtils.A(c2, this.f23754g.getReference())) {
                    this.f23754g.set(c2, true);
                    this.f23749b.h(new b(this));
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    @CanIgnoreReturnValue
    public boolean t(List<RolloutAssignment> list) {
        synchronized (this.f23753f) {
            try {
                if (!this.f23753f.c(list)) {
                    return false;
                }
                this.f23749b.h(new a(this, this.f23753f.b()));
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
