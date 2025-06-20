package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class ViewModel {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f8605a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Set<Closeable> f8606b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f8607c;

    public ViewModel() {
        this.f8605a = new HashMap();
        this.f8606b = new LinkedHashSet();
        this.f8607c = false;
    }

    private static void c(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public void a(@NonNull Closeable closeable) {
        Set<Closeable> set = this.f8606b;
        if (set != null) {
            synchronized (set) {
                this.f8606b.add(closeable);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public final void b() {
        this.f8607c = true;
        Map<String, Object> map = this.f8605a;
        if (map != null) {
            synchronized (map) {
                try {
                    for (Object c2 : this.f8605a.values()) {
                        c(c2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        Set<Closeable> set = this.f8606b;
        if (set != null) {
            synchronized (set) {
                try {
                    for (Closeable c3 : this.f8606b) {
                        c(c3);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        e();
    }

    /* access modifiers changed from: package-private */
    public <T> T d(String str) {
        T t;
        Map<String, Object> map = this.f8605a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = this.f8605a.get(str);
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public void e() {
    }

    /* access modifiers changed from: package-private */
    public <T> T f(String str, T t) {
        T t2;
        synchronized (this.f8605a) {
            try {
                t2 = this.f8605a.get(str);
                if (t2 == null) {
                    this.f8605a.put(str, t);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (t2 != null) {
            t = t2;
        }
        if (this.f8607c) {
            c(t);
        }
        return t;
    }

    public ViewModel(@NonNull Closeable... closeableArr) {
        this.f8605a = new HashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f8606b = linkedHashSet;
        this.f8607c = false;
        linkedHashSet.addAll(Arrays.asList(closeableArr));
    }
}
