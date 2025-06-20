package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002/0B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0017R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00061"}, d2 = {"Landroidx/lifecycle/ProcessLifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "", "h", "g", "f", "i", "l", "m", "Landroid/content/Context;", "context", "j", "(Landroid/content/Context;)V", "", "s", "I", "startedCounter", "X", "resumedCounter", "", "Y", "Z", "pauseSent", "stopSent", "Landroid/os/Handler;", "X2", "Landroid/os/Handler;", "handler", "Landroidx/lifecycle/LifecycleRegistry;", "Y2", "Landroidx/lifecycle/LifecycleRegistry;", "registry", "Ljava/lang/Runnable;", "Z2", "Ljava/lang/Runnable;", "delayedPauseRunnable", "Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "a3", "Landroidx/lifecycle/ReportFragment$ActivityInitializationListener;", "initializationListener", "Landroidx/lifecycle/Lifecycle;", "a", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "b3", "Api29Impl", "Companion", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0})
public final class ProcessLifecycleOwner implements LifecycleOwner {
    @NotNull
    public static final Companion b3 = new Companion((DefaultConstructorMarker) null);
    public static final long c3 = 700;
    /* access modifiers changed from: private */
    @NotNull
    public static final ProcessLifecycleOwner d3 = new ProcessLifecycleOwner();
    private int X;
    @Nullable
    private Handler X2;
    private boolean Y = true;
    @NotNull
    private final LifecycleRegistry Y2 = new LifecycleRegistry(this);
    private boolean Z = true;
    @NotNull
    private final Runnable Z2 = new i(this);
    /* access modifiers changed from: private */
    @NotNull
    public final ReportFragment.ActivityInitializationListener a3 = new ProcessLifecycleOwner$initializationListener$1(this);
    private int s;

    @RequiresApi(29)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/ProcessLifecycleOwner$Api29Impl;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Landroid/app/Application$ActivityLifecycleCallbacks;", "callback", "", "a", "(Landroid/app/Activity;Landroid/app/Application$ActivityLifecycleCallbacks;)V", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0})
    public static final class Api29Impl {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Api29Impl f8565a = new Api29Impl();

        private Api29Impl() {
        }

        @JvmStatic
        @DoNotInline
        public static final void a(@NotNull Activity activity, @NotNull Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            Intrinsics.p(activity, "activity");
            Intrinsics.p(activityLifecycleCallbacks, "callback");
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0000XT¢\u0006\f\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u000f\u0010\u0003R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/ProcessLifecycleOwner$Companion;", "", "<init>", "()V", "Landroidx/lifecycle/LifecycleOwner;", "a", "()Landroidx/lifecycle/LifecycleOwner;", "Landroid/content/Context;", "context", "", "c", "(Landroid/content/Context;)V", "", "TIMEOUT_MS", "J", "b", "Landroidx/lifecycle/ProcessLifecycleOwner;", "newInstance", "Landroidx/lifecycle/ProcessLifecycleOwner;", "lifecycle-process_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void b() {
        }

        @JvmStatic
        @NotNull
        public final LifecycleOwner a() {
            return ProcessLifecycleOwner.d3;
        }

        @JvmStatic
        public final void c(@NotNull Context context) {
            Intrinsics.p(context, "context");
            ProcessLifecycleOwner.d3.j(context);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private ProcessLifecycleOwner() {
    }

    /* access modifiers changed from: private */
    public static final void k(ProcessLifecycleOwner processLifecycleOwner) {
        Intrinsics.p(processLifecycleOwner, "this$0");
        processLifecycleOwner.l();
        processLifecycleOwner.m();
    }

    @JvmStatic
    @NotNull
    public static final LifecycleOwner n() {
        return b3.a();
    }

    @JvmStatic
    public static final void o(@NotNull Context context) {
        b3.c(context);
    }

    @NotNull
    public Lifecycle a() {
        return this.Y2;
    }

    public final void f() {
        int i2 = this.X - 1;
        this.X = i2;
        if (i2 == 0) {
            Handler handler = this.X2;
            Intrinsics.m(handler);
            handler.postDelayed(this.Z2, 700);
        }
    }

    public final void g() {
        int i2 = this.X + 1;
        this.X = i2;
        if (i2 != 1) {
            return;
        }
        if (this.Y) {
            this.Y2.l(Lifecycle.Event.ON_RESUME);
            this.Y = false;
            return;
        }
        Handler handler = this.X2;
        Intrinsics.m(handler);
        handler.removeCallbacks(this.Z2);
    }

    public final void h() {
        int i2 = this.s + 1;
        this.s = i2;
        if (i2 == 1 && this.Z) {
            this.Y2.l(Lifecycle.Event.ON_START);
            this.Z = false;
        }
    }

    public final void i() {
        this.s--;
        m();
    }

    public final void j(@NotNull Context context) {
        Intrinsics.p(context, "context");
        this.X2 = new Handler();
        this.Y2.l(Lifecycle.Event.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.n(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new ProcessLifecycleOwner$attach$1(this));
    }

    public final void l() {
        if (this.X == 0) {
            this.Y = true;
            this.Y2.l(Lifecycle.Event.ON_PAUSE);
        }
    }

    public final void m() {
        if (this.s == 0 && this.Y) {
            this.Y2.l(Lifecycle.Event.ON_STOP);
            this.Z = true;
        }
    }
}
