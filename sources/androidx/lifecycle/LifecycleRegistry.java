package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0002DEB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\rJ\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\tH\u0017¢\u0006\u0004\b\u001e\u0010\rJ\u0017\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b%\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010-R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u00102R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010'R\u0016\u00106\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u0010'R&\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\t07j\b\u0012\u0004\u0012\u00020\t`88\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u00109R\u0014\u0010=\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R$\u0010@\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b&\u0010>\"\u0004\b?\u0010\rR\u0014\u0010C\u001a\u0002018VX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006F"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/LifecycleOwner;", "provider", "", "enforceMainThread", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Z)V", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/lifecycle/Lifecycle$State;", "next", "", "p", "(Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleObserver;", "observer", "g", "(Landroidx/lifecycle/LifecycleObserver;)Landroidx/lifecycle/Lifecycle$State;", "q", "()V", "state", "r", "lifecycleOwner", "j", "f", "t", "", "methodName", "i", "(Ljava/lang/String;)V", "n", "Landroidx/lifecycle/Lifecycle$Event;", "event", "l", "(Landroidx/lifecycle/Lifecycle$Event;)V", "a", "(Landroidx/lifecycle/LifecycleObserver;)V", "d", "b", "Z", "Landroidx/arch/core/internal/FastSafeIterableMap;", "Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "c", "Landroidx/arch/core/internal/FastSafeIterableMap;", "observerMap", "Landroidx/lifecycle/Lifecycle$State;", "Ljava/lang/ref/WeakReference;", "e", "Ljava/lang/ref/WeakReference;", "", "I", "addingObserverCounter", "handlingEvent", "h", "newEventOccurred", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "parentStates", "m", "()Z", "isSynced", "()Landroidx/lifecycle/Lifecycle$State;", "s", "currentState", "k", "()I", "observerCount", "Companion", "ObserverWithState", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0})
public class LifecycleRegistry extends Lifecycle {
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public static final Companion f8532j = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8533b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> f8534c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private Lifecycle.State f8535d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final WeakReference<LifecycleOwner> f8536e;

    /* renamed from: f  reason: collision with root package name */
    private int f8537f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8538g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8539h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Lifecycle.State> f8540i;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$Companion;", "", "<init>", "()V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/LifecycleRegistry;", "a", "(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/Lifecycle$State;", "state1", "state2", "b", "(Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/Lifecycle$State;)Landroidx/lifecycle/Lifecycle$State;", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        @VisibleForTesting
        public final LifecycleRegistry a(@NotNull LifecycleOwner lifecycleOwner) {
            Intrinsics.p(lifecycleOwner, "owner");
            return new LifecycleRegistry(lifecycleOwner, false, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        @NotNull
        public final Lifecycle.State b(@NotNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
            Intrinsics.p(state, "state1");
            return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "", "Landroidx/lifecycle/LifecycleObserver;", "observer", "Landroidx/lifecycle/Lifecycle$State;", "initialState", "<init>", "(Landroidx/lifecycle/LifecycleObserver;Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "a", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "Landroidx/lifecycle/Lifecycle$State;", "c", "()Landroidx/lifecycle/Lifecycle$State;", "e", "(Landroidx/lifecycle/Lifecycle$State;)V", "state", "Landroidx/lifecycle/LifecycleEventObserver;", "b", "Landroidx/lifecycle/LifecycleEventObserver;", "()Landroidx/lifecycle/LifecycleEventObserver;", "d", "(Landroidx/lifecycle/LifecycleEventObserver;)V", "lifecycleObserver", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0})
    public static final class ObserverWithState {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private Lifecycle.State f8541a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private LifecycleEventObserver f8542b;

        public ObserverWithState(@Nullable LifecycleObserver lifecycleObserver, @NotNull Lifecycle.State state) {
            Intrinsics.p(state, "initialState");
            Intrinsics.m(lifecycleObserver);
            this.f8542b = Lifecycling.f(lifecycleObserver);
            this.f8541a = state;
        }

        public final void a(@Nullable LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
            Intrinsics.p(event, NotificationCompat.I0);
            Lifecycle.State e2 = event.e();
            this.f8541a = LifecycleRegistry.f8532j.b(this.f8541a, e2);
            LifecycleEventObserver lifecycleEventObserver = this.f8542b;
            Intrinsics.m(lifecycleOwner);
            lifecycleEventObserver.d(lifecycleOwner, event);
            this.f8541a = e2;
        }

        @NotNull
        public final LifecycleEventObserver b() {
            return this.f8542b;
        }

        @NotNull
        public final Lifecycle.State c() {
            return this.f8541a;
        }

        public final void d(@NotNull LifecycleEventObserver lifecycleEventObserver) {
            Intrinsics.p(lifecycleEventObserver, "<set-?>");
            this.f8542b = lifecycleEventObserver;
        }

        public final void e(@NotNull Lifecycle.State state) {
            Intrinsics.p(state, "<set-?>");
            this.f8541a = state;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LifecycleRegistry(@NotNull LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, true);
        Intrinsics.p(lifecycleOwner, "provider");
    }

    private final void f(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> descendingIterator = this.f8534c.descendingIterator();
        Intrinsics.o(descendingIterator, "observerMap.descendingIterator()");
        while (descendingIterator.hasNext() && !this.f8539h) {
            Map.Entry next = descendingIterator.next();
            Intrinsics.o(next, "next()");
            LifecycleObserver lifecycleObserver = (LifecycleObserver) next.getKey();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.c().compareTo(this.f8535d) > 0 && !this.f8539h && this.f8534c.contains(lifecycleObserver)) {
                Lifecycle.Event a2 = Lifecycle.Event.Companion.a(observerWithState.c());
                if (a2 != null) {
                    r(a2.e());
                    observerWithState.a(lifecycleOwner, a2);
                    q();
                } else {
                    throw new IllegalStateException("no event down from " + observerWithState.c());
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r4 = r4.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.lifecycle.Lifecycle.State g(androidx.lifecycle.LifecycleObserver r4) {
        /*
            r3 = this;
            androidx.arch.core.internal.FastSafeIterableMap<androidx.lifecycle.LifecycleObserver, androidx.lifecycle.LifecycleRegistry$ObserverWithState> r0 = r3.f8534c
            java.util.Map$Entry r4 = r0.m(r4)
            r0 = 0
            if (r4 == 0) goto L_0x0016
            java.lang.Object r4 = r4.getValue()
            androidx.lifecycle.LifecycleRegistry$ObserverWithState r4 = (androidx.lifecycle.LifecycleRegistry.ObserverWithState) r4
            if (r4 == 0) goto L_0x0016
            androidx.lifecycle.Lifecycle$State r4 = r4.c()
            goto L_0x0017
        L_0x0016:
            r4 = r0
        L_0x0017:
            java.util.ArrayList<androidx.lifecycle.Lifecycle$State> r1 = r3.f8540i
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x002f
            java.util.ArrayList<androidx.lifecycle.Lifecycle$State> r0 = r3.f8540i
            int r1 = r0.size()
            int r1 = r1 + -1
            java.lang.Object r0 = r0.get(r1)
            androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
        L_0x002f:
            androidx.lifecycle.LifecycleRegistry$Companion r1 = f8532j
            androidx.lifecycle.Lifecycle$State r2 = r3.f8535d
            androidx.lifecycle.Lifecycle$State r4 = r1.b(r2, r4)
            androidx.lifecycle.Lifecycle$State r4 = r1.b(r4, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.LifecycleRegistry.g(androidx.lifecycle.LifecycleObserver):androidx.lifecycle.Lifecycle$State");
    }

    @JvmStatic
    @NotNull
    @VisibleForTesting
    public static final LifecycleRegistry h(@NotNull LifecycleOwner lifecycleOwner) {
        return f8532j.a(lifecycleOwner);
    }

    @SuppressLint({"RestrictedApi"})
    private final void i(String str) {
        if (this.f8533b && !ArchTaskExecutor.h().c()) {
            throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
        }
    }

    private final void j(LifecycleOwner lifecycleOwner) {
        SafeIterableMap<K, V>.IteratorWithAdditions d2 = this.f8534c.d();
        Intrinsics.o(d2, "observerMap.iteratorWithAdditions()");
        while (d2.hasNext() && !this.f8539h) {
            Map.Entry entry = (Map.Entry) d2.next();
            LifecycleObserver lifecycleObserver = (LifecycleObserver) entry.getKey();
            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
            while (observerWithState.c().compareTo(this.f8535d) < 0 && !this.f8539h && this.f8534c.contains(lifecycleObserver)) {
                r(observerWithState.c());
                Lifecycle.Event c2 = Lifecycle.Event.Companion.c(observerWithState.c());
                if (c2 != null) {
                    observerWithState.a(lifecycleOwner, c2);
                    q();
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.c());
                }
            }
        }
    }

    private final boolean m() {
        if (this.f8534c.size() == 0) {
            return true;
        }
        Map.Entry<LifecycleObserver, ObserverWithState> b2 = this.f8534c.b();
        Intrinsics.m(b2);
        Lifecycle.State c2 = b2.getValue().c();
        Map.Entry<LifecycleObserver, ObserverWithState> g2 = this.f8534c.g();
        Intrinsics.m(g2);
        Lifecycle.State c3 = g2.getValue().c();
        return c2 == c3 && this.f8535d == c3;
    }

    @JvmStatic
    @NotNull
    public static final Lifecycle.State o(@NotNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return f8532j.b(state, state2);
    }

    private final void p(Lifecycle.State state) {
        Lifecycle.State state2 = this.f8535d;
        if (state2 != state) {
            if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
                throw new IllegalStateException(("no event down from " + this.f8535d + " in component " + this.f8536e.get()).toString());
            }
            this.f8535d = state;
            if (this.f8538g || this.f8537f != 0) {
                this.f8539h = true;
                return;
            }
            this.f8538g = true;
            t();
            this.f8538g = false;
            if (this.f8535d == Lifecycle.State.DESTROYED) {
                this.f8534c = new FastSafeIterableMap<>();
            }
        }
    }

    private final void q() {
        ArrayList<Lifecycle.State> arrayList = this.f8540i;
        arrayList.remove(arrayList.size() - 1);
    }

    private final void r(Lifecycle.State state) {
        this.f8540i.add(state);
    }

    private final void t() {
        LifecycleOwner lifecycleOwner = this.f8536e.get();
        if (lifecycleOwner != null) {
            while (true) {
                boolean m2 = m();
                this.f8539h = false;
                if (!m2) {
                    Lifecycle.State state = this.f8535d;
                    Map.Entry<LifecycleObserver, ObserverWithState> b2 = this.f8534c.b();
                    Intrinsics.m(b2);
                    if (state.compareTo(b2.getValue().c()) < 0) {
                        f(lifecycleOwner);
                    }
                    Map.Entry<LifecycleObserver, ObserverWithState> g2 = this.f8534c.g();
                    if (!this.f8539h && g2 != null && this.f8535d.compareTo(g2.getValue().c()) > 0) {
                        j(lifecycleOwner);
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
    }

    public void a(@NotNull LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        Intrinsics.p(lifecycleObserver, "observer");
        i("addObserver");
        Lifecycle.State state = this.f8535d;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, state2);
        if (this.f8534c.j(lifecycleObserver, observerWithState) == null && (lifecycleOwner = this.f8536e.get()) != null) {
            boolean z = this.f8537f != 0 || this.f8538g;
            Lifecycle.State g2 = g(lifecycleObserver);
            this.f8537f++;
            while (observerWithState.c().compareTo(g2) < 0 && this.f8534c.contains(lifecycleObserver)) {
                r(observerWithState.c());
                Lifecycle.Event c2 = Lifecycle.Event.Companion.c(observerWithState.c());
                if (c2 != null) {
                    observerWithState.a(lifecycleOwner, c2);
                    q();
                    g2 = g(lifecycleObserver);
                } else {
                    throw new IllegalStateException("no event up from " + observerWithState.c());
                }
            }
            if (!z) {
                t();
            }
            this.f8537f--;
        }
    }

    @NotNull
    public Lifecycle.State b() {
        return this.f8535d;
    }

    public void d(@NotNull LifecycleObserver lifecycleObserver) {
        Intrinsics.p(lifecycleObserver, "observer");
        i("removeObserver");
        this.f8534c.k(lifecycleObserver);
    }

    public int k() {
        i("getObserverCount");
        return this.f8534c.size();
    }

    public void l(@NotNull Lifecycle.Event event) {
        Intrinsics.p(event, NotificationCompat.I0);
        i("handleLifecycleEvent");
        p(event.e());
    }

    @Deprecated(message = "Override [currentState].")
    @MainThread
    public void n(@NotNull Lifecycle.State state) {
        Intrinsics.p(state, "state");
        i("markState");
        s(state);
    }

    public void s(@NotNull Lifecycle.State state) {
        Intrinsics.p(state, "state");
        i("setCurrentState");
        p(state);
    }

    private LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z) {
        this.f8533b = z;
        this.f8534c = new FastSafeIterableMap<>();
        this.f8535d = Lifecycle.State.INITIALIZED;
        this.f8540i = new ArrayList<>();
        this.f8536e = new WeakReference<>(lifecycleOwner);
    }

    public /* synthetic */ LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(lifecycleOwner, z);
    }
}
