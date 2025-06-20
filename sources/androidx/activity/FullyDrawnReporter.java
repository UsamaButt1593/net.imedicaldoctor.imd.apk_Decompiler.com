package androidx.activity;

import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\nJ\u001b\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001cR \u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010#R\u0011\u0010&\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010%¨\u0006'"}, d2 = {"Landroidx/activity/FullyDrawnReporter;", "", "Ljava/util/concurrent/Executor;", "executor", "Lkotlin/Function0;", "", "reportFullyDrawn", "<init>", "(Ljava/util/concurrent/Executor;Lkotlin/jvm/functions/Function0;)V", "f", "()V", "c", "h", "callback", "b", "(Lkotlin/jvm/functions/Function0;)V", "g", "d", "a", "Ljava/util/concurrent/Executor;", "Lkotlin/jvm/functions/Function0;", "Ljava/lang/Object;", "lock", "", "I", "reporterCount", "", "e", "Z", "reportPosted", "reportedFullyDrawn", "", "Ljava/util/List;", "onReportCallbacks", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "reportRunnable", "()Z", "isFullyDrawnReported", "activity_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nFullyDrawnReporter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FullyDrawnReporter.kt\nandroidx/activity/FullyDrawnReporter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,190:1\n1#2:191\n1855#3,2:192\n*S KotlinDebug\n*F\n+ 1 FullyDrawnReporter.kt\nandroidx/activity/FullyDrawnReporter\n*L\n154#1:192,2\n*E\n"})
public final class FullyDrawnReporter {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Executor f2426a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Unit> f2427b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Object f2428c = new Object();
    @GuardedBy("lock")

    /* renamed from: d  reason: collision with root package name */
    private int f2429d;
    @GuardedBy("lock")

    /* renamed from: e  reason: collision with root package name */
    private boolean f2430e;
    @GuardedBy("lock")

    /* renamed from: f  reason: collision with root package name */
    private boolean f2431f;
    @NotNull
    @GuardedBy("lock")

    /* renamed from: g  reason: collision with root package name */
    private final List<Function0<Unit>> f2432g = new ArrayList();
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f2433h = new j(this);

    public FullyDrawnReporter(@NotNull Executor executor, @NotNull Function0<Unit> function0) {
        Intrinsics.p(executor, "executor");
        Intrinsics.p(function0, "reportFullyDrawn");
        this.f2426a = executor;
        this.f2427b = function0;
    }

    private final void f() {
        if (!this.f2430e && this.f2429d == 0) {
            this.f2430e = true;
            this.f2426a.execute(this.f2433h);
        }
    }

    /* access modifiers changed from: private */
    public static final void i(FullyDrawnReporter fullyDrawnReporter) {
        Intrinsics.p(fullyDrawnReporter, "this$0");
        synchronized (fullyDrawnReporter.f2428c) {
            try {
                fullyDrawnReporter.f2430e = false;
                if (fullyDrawnReporter.f2429d == 0 && !fullyDrawnReporter.f2431f) {
                    fullyDrawnReporter.f2427b.o();
                    fullyDrawnReporter.d();
                }
                Unit unit = Unit.f28779a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(@NotNull Function0<Unit> function0) {
        boolean z;
        Intrinsics.p(function0, "callback");
        synchronized (this.f2428c) {
            if (this.f2431f) {
                z = true;
            } else {
                this.f2432g.add(function0);
                z = false;
            }
        }
        if (z) {
            function0.o();
        }
    }

    public final void c() {
        synchronized (this.f2428c) {
            try {
                if (!this.f2431f) {
                    this.f2429d++;
                }
                Unit unit = Unit.f28779a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.X})
    public final void d() {
        synchronized (this.f2428c) {
            try {
                this.f2431f = true;
                for (Function0 o : this.f2432g) {
                    o.o();
                }
                this.f2432g.clear();
                Unit unit = Unit.f28779a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean e() {
        boolean z;
        synchronized (this.f2428c) {
            z = this.f2431f;
        }
        return z;
    }

    public final void g(@NotNull Function0<Unit> function0) {
        Intrinsics.p(function0, "callback");
        synchronized (this.f2428c) {
            this.f2432g.remove(function0);
            Unit unit = Unit.f28779a;
        }
    }

    public final void h() {
        int i2;
        synchronized (this.f2428c) {
            try {
                if (!this.f2431f && (i2 = this.f2429d) > 0) {
                    this.f2429d = i2 - 1;
                    f();
                }
                Unit unit = Unit.f28779a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
