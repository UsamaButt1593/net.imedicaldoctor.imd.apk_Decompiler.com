package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.RealCall;
import okhttp3.internal.Util;

public final class Dispatcher {

    /* renamed from: h  reason: collision with root package name */
    static final /* synthetic */ boolean f30848h = false;

    /* renamed from: a  reason: collision with root package name */
    private int f30849a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f30850b = 5;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Runnable f30851c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f30852d;

    /* renamed from: e  reason: collision with root package name */
    private final Deque<RealCall.AsyncCall> f30853e = new ArrayDeque();

    /* renamed from: f  reason: collision with root package name */
    private final Deque<RealCall.AsyncCall> f30854f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    private final Deque<RealCall> f30855g = new ArrayDeque();

    public Dispatcher() {
    }

    private <T> void e(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.f30851c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!j() && runnable != null) {
            runnable.run();
        }
    }

    private boolean j() {
        int i2;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<RealCall.AsyncCall> it2 = this.f30853e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    RealCall.AsyncCall next = it2.next();
                    if (this.f30854f.size() >= this.f30849a) {
                        break;
                    } else if (o(next) < this.f30850b) {
                        it2.remove();
                        arrayList.add(next);
                        this.f30854f.add(next);
                    }
                }
                z = n() > 0;
            } finally {
                while (true) {
                }
            }
        }
        int size = arrayList.size();
        for (i2 = 0; i2 < size; i2++) {
            ((RealCall.AsyncCall) arrayList.get(i2)).m(d());
        }
        return z;
    }

    private int o(RealCall.AsyncCall asyncCall) {
        int i2 = 0;
        for (RealCall.AsyncCall next : this.f30854f) {
            if (!next.n().Y2 && next.o().equals(asyncCall.o())) {
                i2++;
            }
        }
        return i2;
    }

    public synchronized void a() {
        try {
            for (RealCall.AsyncCall n2 : this.f30853e) {
                n2.n().cancel();
            }
            for (RealCall.AsyncCall n3 : this.f30854f) {
                n3.n().cancel();
            }
            for (RealCall cancel : this.f30855g) {
                cancel.cancel();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(RealCall.AsyncCall asyncCall) {
        synchronized (this) {
            this.f30853e.add(asyncCall);
        }
        j();
    }

    /* access modifiers changed from: package-private */
    public synchronized void c(RealCall realCall) {
        this.f30855g.add(realCall);
    }

    public synchronized ExecutorService d() {
        try {
            if (this.f30852d == null) {
                this.f30852d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.H("OkHttp Dispatcher", false));
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f30852d;
    }

    /* access modifiers changed from: package-private */
    public void f(RealCall.AsyncCall asyncCall) {
        e(this.f30854f, asyncCall);
    }

    /* access modifiers changed from: package-private */
    public void g(RealCall realCall) {
        e(this.f30855g, realCall);
    }

    public synchronized int h() {
        return this.f30849a;
    }

    public synchronized int i() {
        return this.f30850b;
    }

    public synchronized List<Call> k() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (RealCall.AsyncCall n2 : this.f30853e) {
                arrayList.add(n2.n());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int l() {
        return this.f30853e.size();
    }

    public synchronized List<Call> m() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            arrayList.addAll(this.f30855g);
            for (RealCall.AsyncCall n2 : this.f30854f) {
                arrayList.add(n2.n());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int n() {
        return this.f30854f.size() + this.f30855g.size();
    }

    public synchronized void p(@Nullable Runnable runnable) {
        this.f30851c = runnable;
    }

    public void q(int i2) {
        if (i2 >= 1) {
            synchronized (this) {
                this.f30849a = i2;
            }
            j();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i2);
    }

    public void r(int i2) {
        if (i2 >= 1) {
            synchronized (this) {
                this.f30850b = i2;
            }
            j();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i2);
    }

    public Dispatcher(ExecutorService executorService) {
        this.f30852d = executorService;
    }
}
