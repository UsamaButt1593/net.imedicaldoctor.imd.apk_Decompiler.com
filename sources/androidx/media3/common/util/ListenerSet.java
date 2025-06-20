package androidx.media3.common.util;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.FlagSet;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

@UnstableApi
public final class ListenerSet<T> {

    /* renamed from: j  reason: collision with root package name */
    private static final int f9557j = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Clock f9558a;

    /* renamed from: b  reason: collision with root package name */
    private final HandlerWrapper f9559b;

    /* renamed from: c  reason: collision with root package name */
    private final IterationFinishedEvent<T> f9560c;

    /* renamed from: d  reason: collision with root package name */
    private final CopyOnWriteArraySet<ListenerHolder<T>> f9561d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayDeque<Runnable> f9562e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque<Runnable> f9563f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f9564g;
    @GuardedBy("releasedLock")

    /* renamed from: h  reason: collision with root package name */
    private boolean f9565h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9566i;

    public interface Event<T> {
        void f(T t);
    }

    public interface IterationFinishedEvent<T> {
        void a(T t, FlagSet flagSet);
    }

    private static final class ListenerHolder<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f9567a;

        /* renamed from: b  reason: collision with root package name */
        private FlagSet.Builder f9568b = new FlagSet.Builder();

        /* renamed from: c  reason: collision with root package name */
        private boolean f9569c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9570d;

        public ListenerHolder(T t) {
            this.f9567a = t;
        }

        public void a(int i2, Event<T> event) {
            if (!this.f9570d) {
                if (i2 != -1) {
                    this.f9568b.a(i2);
                }
                this.f9569c = true;
                event.f(this.f9567a);
            }
        }

        public void b(IterationFinishedEvent<T> iterationFinishedEvent) {
            if (!this.f9570d && this.f9569c) {
                FlagSet e2 = this.f9568b.e();
                this.f9568b = new FlagSet.Builder();
                this.f9569c = false;
                iterationFinishedEvent.a(this.f9567a, e2);
            }
        }

        public void c(IterationFinishedEvent<T> iterationFinishedEvent) {
            this.f9570d = true;
            if (this.f9569c) {
                this.f9569c = false;
                iterationFinishedEvent.a(this.f9567a, this.f9568b.e());
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ListenerHolder.class != obj.getClass()) {
                return false;
            }
            return this.f9567a.equals(((ListenerHolder) obj).f9567a);
        }

        public int hashCode() {
            return this.f9567a.hashCode();
        }
    }

    public ListenerSet(Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        this(new CopyOnWriteArraySet(), looper, clock, iterationFinishedEvent, true);
    }

    /* access modifiers changed from: private */
    public boolean h(Message message) {
        Iterator<ListenerHolder<T>> it2 = this.f9561d.iterator();
        while (it2.hasNext()) {
            it2.next().b(this.f9560c);
            if (this.f9559b.g(0)) {
                return true;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void i(CopyOnWriteArraySet copyOnWriteArraySet, int i2, Event event) {
        Iterator it2 = copyOnWriteArraySet.iterator();
        while (it2.hasNext()) {
            ((ListenerHolder) it2.next()).a(i2, event);
        }
    }

    private void p() {
        if (this.f9566i) {
            Assertions.i(Thread.currentThread() == this.f9559b.o().getThread());
        }
    }

    public void c(T t) {
        Assertions.g(t);
        synchronized (this.f9564g) {
            try {
                if (!this.f9565h) {
                    this.f9561d.add(new ListenerHolder(t));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d() {
        p();
        this.f9561d.clear();
    }

    @CheckResult
    public ListenerSet<T> e(Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent) {
        return new ListenerSet(this.f9561d, looper, clock, iterationFinishedEvent, this.f9566i);
    }

    @CheckResult
    public ListenerSet<T> f(Looper looper, IterationFinishedEvent<T> iterationFinishedEvent) {
        return e(looper, this.f9558a, iterationFinishedEvent);
    }

    public void g() {
        p();
        if (!this.f9563f.isEmpty()) {
            if (!this.f9559b.g(0)) {
                HandlerWrapper handlerWrapper = this.f9559b;
                handlerWrapper.b(handlerWrapper.f(0));
            }
            boolean z = !this.f9562e.isEmpty();
            this.f9562e.addAll(this.f9563f);
            this.f9563f.clear();
            if (!z) {
                while (!this.f9562e.isEmpty()) {
                    this.f9562e.peekFirst().run();
                    this.f9562e.removeFirst();
                }
            }
        }
    }

    public void j(int i2, Event<T> event) {
        p();
        this.f9563f.add(new C0179c(new CopyOnWriteArraySet(this.f9561d), i2, event));
    }

    public void k() {
        p();
        synchronized (this.f9564g) {
            this.f9565h = true;
        }
        Iterator<ListenerHolder<T>> it2 = this.f9561d.iterator();
        while (it2.hasNext()) {
            it2.next().c(this.f9560c);
        }
        this.f9561d.clear();
    }

    public void l(T t) {
        p();
        Iterator<ListenerHolder<T>> it2 = this.f9561d.iterator();
        while (it2.hasNext()) {
            ListenerHolder next = it2.next();
            if (next.f9567a.equals(t)) {
                next.c(this.f9560c);
                this.f9561d.remove(next);
            }
        }
    }

    public void m(int i2, Event<T> event) {
        j(i2, event);
        g();
    }

    @Deprecated
    public void n(boolean z) {
        this.f9566i = z;
    }

    public int o() {
        p();
        return this.f9561d.size();
    }

    private ListenerSet(CopyOnWriteArraySet<ListenerHolder<T>> copyOnWriteArraySet, Looper looper, Clock clock, IterationFinishedEvent<T> iterationFinishedEvent, boolean z) {
        this.f9558a = clock;
        this.f9561d = copyOnWriteArraySet;
        this.f9560c = iterationFinishedEvent;
        this.f9564g = new Object();
        this.f9562e = new ArrayDeque<>();
        this.f9563f = new ArrayDeque<>();
        this.f9559b = clock.e(looper, new C0178b(this));
        this.f9566i = z;
    }
}
