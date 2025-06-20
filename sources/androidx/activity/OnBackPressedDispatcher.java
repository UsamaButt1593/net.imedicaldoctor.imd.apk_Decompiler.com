package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nOnBackPressedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnBackPressedDispatcher.kt\nandroidx/activity/OnBackPressedDispatcher\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,430:1\n1747#2,3:431\n533#2,6:434\n533#2,6:440\n533#2,6:446\n533#2,6:452\n*S KotlinDebug\n*F\n+ 1 OnBackPressedDispatcher.kt\nandroidx/activity/OnBackPressedDispatcher\n*L\n114#1:431,3\n233#1:434,6\n251#1:440,6\n271#1:446,6\n290#1:452,6\n*E\n"})
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0004ABCDB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0015\b\u0017\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0005H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b'\u0010\u0013J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b(\u0010\u0013J\u000f\u0010)\u001a\u00020\u000bH\u0007¢\u0006\u0004\b)\u0010\u000fJ\u000f\u0010*\u001a\u00020\u000bH\u0007¢\u0006\u0004\b*\u0010\u000fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u001a0/8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010>¨\u0006E"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher;", "", "Ljava/lang/Runnable;", "fallbackOnBackPressed", "Landroidx/core/util/Consumer;", "", "onHasEnabledCallbacksChanged", "<init>", "(Ljava/lang/Runnable;Landroidx/core/util/Consumer;)V", "(Ljava/lang/Runnable;)V", "shouldBeRegistered", "", "t", "(Z)V", "u", "()V", "Landroidx/activity/BackEventCompat;", "backEvent", "r", "(Landroidx/activity/BackEventCompat;)V", "q", "o", "Landroid/window/OnBackInvokedDispatcher;", "invoker", "s", "(Landroid/window/OnBackInvokedDispatcher;)V", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "h", "(Landroidx/activity/OnBackPressedCallback;)V", "Landroidx/activity/Cancellable;", "j", "(Landroidx/activity/OnBackPressedCallback;)Landroidx/activity/Cancellable;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "i", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/activity/OnBackPressedCallback;)V", "n", "()Z", "m", "l", "p", "k", "a", "Ljava/lang/Runnable;", "b", "Landroidx/core/util/Consumer;", "Lkotlin/collections/ArrayDeque;", "c", "Lkotlin/collections/ArrayDeque;", "onBackPressedCallbacks", "d", "Landroidx/activity/OnBackPressedCallback;", "inProgressCallback", "Landroid/window/OnBackInvokedCallback;", "e", "Landroid/window/OnBackInvokedCallback;", "onBackInvokedCallback", "f", "Landroid/window/OnBackInvokedDispatcher;", "invokedDispatcher", "g", "Z", "backInvokedCallbackRegistered", "hasEnabledCallbacks", "Api33Impl", "Api34Impl", "LifecycleOnBackPressedCancellable", "OnBackPressedCancellable", "activity_release"}, k = 1, mv = {1, 8, 0})
public final class OnBackPressedDispatcher {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f2437a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Consumer<Boolean> f2438b;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final ArrayDeque<OnBackPressedCallback> f2439c;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public OnBackPressedCallback f2440d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private OnBackInvokedCallback f2441e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private OnBackInvokedDispatcher f2442f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2443g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2444h;

    @RequiresApi(33)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api33Impl;", "", "<init>", "()V", "dispatcher", "", "priority", "callback", "", "d", "(Ljava/lang/Object;ILjava/lang/Object;)V", "e", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/Function0;", "onBackInvoked", "Landroid/window/OnBackInvokedCallback;", "b", "(Lkotlin/jvm/functions/Function0;)Landroid/window/OnBackInvokedCallback;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class Api33Impl {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Api33Impl f2445a = new Api33Impl();

        private Api33Impl() {
        }

        /* access modifiers changed from: private */
        public static final void c(Function0 function0) {
            Intrinsics.p(function0, "$onBackInvoked");
            function0.o();
        }

        @NotNull
        @DoNotInline
        public final OnBackInvokedCallback b(@NotNull Function0<Unit> function0) {
            Intrinsics.p(function0, "onBackInvoked");
            return new k(function0);
        }

        @DoNotInline
        public final void d(@NotNull Object obj, int i2, @NotNull Object obj2) {
            Intrinsics.p(obj, "dispatcher");
            Intrinsics.p(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i2, (OnBackInvokedCallback) obj2);
        }

        @DoNotInline
        public final void e(@NotNull Object obj, @NotNull Object obj2) {
            Intrinsics.p(obj, "dispatcher");
            Intrinsics.p(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    @RequiresApi(34)
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jq\u0010\u0010\u001a\u00020\u000f2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00042!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$Api34Impl;", "", "<init>", "()V", "Lkotlin/Function1;", "Landroidx/activity/BackEventCompat;", "Lkotlin/ParameterName;", "name", "backEvent", "", "onBackStarted", "onBackProgressed", "Lkotlin/Function0;", "onBackInvoked", "onBackCancelled", "Landroid/window/OnBackInvokedCallback;", "a", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Landroid/window/OnBackInvokedCallback;", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class Api34Impl {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Api34Impl f2446a = new Api34Impl();

        private Api34Impl() {
        }

        @NotNull
        @DoNotInline
        public final OnBackInvokedCallback a(@NotNull Function1<? super BackEventCompat, Unit> function1, @NotNull Function1<? super BackEventCompat, Unit> function12, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
            Intrinsics.p(function1, "onBackStarted");
            Intrinsics.p(function12, "onBackProgressed");
            Intrinsics.p(function0, "onBackInvoked");
            Intrinsics.p(function02, "onBackCancelled");
            return new OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(function1, function12, function0, function02);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/activity/Cancellable;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "<init>", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/lifecycle/Lifecycle;Landroidx/activity/OnBackPressedCallback;)V", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "d", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "cancel", "()V", "s", "Landroidx/lifecycle/Lifecycle;", "X", "Landroidx/activity/OnBackPressedCallback;", "Y", "Landroidx/activity/Cancellable;", "currentCancellable", "activity_release"}, k = 1, mv = {1, 8, 0})
    private final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        @NotNull
        private final OnBackPressedCallback X;
        @Nullable
        private Cancellable Y;
        final /* synthetic */ OnBackPressedDispatcher Z;
        @NotNull
        private final Lifecycle s;

        public LifecycleOnBackPressedCancellable(@NotNull OnBackPressedDispatcher onBackPressedDispatcher, @NotNull Lifecycle lifecycle, OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.p(lifecycle, "lifecycle");
            Intrinsics.p(onBackPressedCallback, "onBackPressedCallback");
            this.Z = onBackPressedDispatcher;
            this.s = lifecycle;
            this.X = onBackPressedCallback;
            lifecycle.a(this);
        }

        public void cancel() {
            this.s.d(this);
            this.X.i(this);
            Cancellable cancellable = this.Y;
            if (cancellable != null) {
                cancellable.cancel();
            }
            this.Y = null;
        }

        public void d(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
            Intrinsics.p(lifecycleOwner, "source");
            Intrinsics.p(event, NotificationCompat.I0);
            if (event == Lifecycle.Event.ON_START) {
                this.Y = this.Z.j(this.X);
            } else if (event == Lifecycle.Event.ON_STOP) {
                Cancellable cancellable = this.Y;
                if (cancellable != null) {
                    cancellable.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/activity/OnBackPressedDispatcher$OnBackPressedCancellable;", "Landroidx/activity/Cancellable;", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "<init>", "(Landroidx/activity/OnBackPressedDispatcher;Landroidx/activity/OnBackPressedCallback;)V", "", "cancel", "()V", "s", "Landroidx/activity/OnBackPressedCallback;", "activity_release"}, k = 1, mv = {1, 8, 0})
    private final class OnBackPressedCancellable implements Cancellable {
        final /* synthetic */ OnBackPressedDispatcher X;
        @NotNull
        private final OnBackPressedCallback s;

        public OnBackPressedCancellable(@NotNull OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.p(onBackPressedCallback, "onBackPressedCallback");
            this.X = onBackPressedDispatcher;
            this.s = onBackPressedCallback;
        }

        public void cancel() {
            this.X.f2439c.remove(this.s);
            if (Intrinsics.g(this.X.f2440d, this.s)) {
                this.s.c();
                this.X.f2440d = null;
            }
            this.s.i(this);
            Function0<Unit> b2 = this.s.b();
            if (b2 != null) {
                b2.o();
            }
            this.s.k((Function0<Unit>) null);
        }
    }

    @JvmOverloads
    public OnBackPressedDispatcher() {
        this((Runnable) null, 1, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void o() {
        OnBackPressedCallback onBackPressedCallback;
        ArrayDeque<OnBackPressedCallback> arrayDeque = this.f2439c;
        ListIterator<OnBackPressedCallback> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                onBackPressedCallback = null;
                break;
            }
            onBackPressedCallback = listIterator.previous();
            if (onBackPressedCallback.g()) {
                break;
            }
        }
        OnBackPressedCallback onBackPressedCallback2 = onBackPressedCallback;
        this.f2440d = null;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.c();
        }
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void q(BackEventCompat backEventCompat) {
        OnBackPressedCallback onBackPressedCallback;
        ArrayDeque<OnBackPressedCallback> arrayDeque = this.f2439c;
        ListIterator<OnBackPressedCallback> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                onBackPressedCallback = null;
                break;
            }
            onBackPressedCallback = listIterator.previous();
            if (onBackPressedCallback.g()) {
                break;
            }
        }
        OnBackPressedCallback onBackPressedCallback2 = onBackPressedCallback;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.e(backEventCompat);
        }
    }

    /* access modifiers changed from: private */
    @MainThread
    public final void r(BackEventCompat backEventCompat) {
        OnBackPressedCallback onBackPressedCallback;
        ArrayDeque<OnBackPressedCallback> arrayDeque = this.f2439c;
        ListIterator<OnBackPressedCallback> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                onBackPressedCallback = null;
                break;
            }
            onBackPressedCallback = listIterator.previous();
            if (onBackPressedCallback.g()) {
                break;
            }
        }
        OnBackPressedCallback onBackPressedCallback2 = onBackPressedCallback;
        this.f2440d = onBackPressedCallback2;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.f(backEventCompat);
        }
    }

    @RequiresApi(33)
    private final void t(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f2442f;
        OnBackInvokedCallback onBackInvokedCallback = this.f2441e;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback != null) {
            if (z && !this.f2443g) {
                Api33Impl.f2445a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
                this.f2443g = true;
            } else if (!z && this.f2443g) {
                Api33Impl.f2445a.e(onBackInvokedDispatcher, onBackInvokedCallback);
                this.f2443g = false;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void u() {
        boolean z = this.f2444h;
        ArrayDeque<OnBackPressedCallback> arrayDeque = this.f2439c;
        boolean z2 = false;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator<T> it2 = arrayDeque.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((OnBackPressedCallback) it2.next()).g()) {
                        z2 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.f2444h = z2;
        if (z2 != z) {
            Consumer<Boolean> consumer = this.f2438b;
            if (consumer != null) {
                consumer.accept(Boolean.valueOf(z2));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                t(z2);
            }
        }
    }

    @MainThread
    public final void h(@NotNull OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.p(onBackPressedCallback, "onBackPressedCallback");
        j(onBackPressedCallback);
    }

    @MainThread
    public final void i(@NotNull LifecycleOwner lifecycleOwner, @NotNull OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.p(lifecycleOwner, "owner");
        Intrinsics.p(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle a2 = lifecycleOwner.a();
        if (a2.b() != Lifecycle.State.DESTROYED) {
            onBackPressedCallback.a(new LifecycleOnBackPressedCancellable(this, a2, onBackPressedCallback));
            u();
            onBackPressedCallback.k(new OnBackPressedDispatcher$addCallback$1(this));
        }
    }

    @NotNull
    @MainThread
    public final Cancellable j(@NotNull OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.p(onBackPressedCallback, "onBackPressedCallback");
        this.f2439c.add(onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(this, onBackPressedCallback);
        onBackPressedCallback.a(onBackPressedCancellable);
        u();
        onBackPressedCallback.k(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return onBackPressedCancellable;
    }

    @VisibleForTesting
    @MainThread
    public final void k() {
        o();
    }

    @VisibleForTesting
    @MainThread
    public final void l(@NotNull BackEventCompat backEventCompat) {
        Intrinsics.p(backEventCompat, "backEvent");
        q(backEventCompat);
    }

    @VisibleForTesting
    @MainThread
    public final void m(@NotNull BackEventCompat backEventCompat) {
        Intrinsics.p(backEventCompat, "backEvent");
        r(backEventCompat);
    }

    @MainThread
    public final boolean n() {
        return this.f2444h;
    }

    @MainThread
    public final void p() {
        OnBackPressedCallback onBackPressedCallback;
        ArrayDeque<OnBackPressedCallback> arrayDeque = this.f2439c;
        ListIterator<OnBackPressedCallback> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                onBackPressedCallback = null;
                break;
            }
            onBackPressedCallback = listIterator.previous();
            if (onBackPressedCallback.g()) {
                break;
            }
        }
        OnBackPressedCallback onBackPressedCallback2 = onBackPressedCallback;
        this.f2440d = null;
        if (onBackPressedCallback2 != null) {
            onBackPressedCallback2.d();
            return;
        }
        Runnable runnable = this.f2437a;
        if (runnable != null) {
            runnable.run();
        }
    }

    @RequiresApi(33)
    public final void s(@NotNull OnBackInvokedDispatcher onBackInvokedDispatcher) {
        Intrinsics.p(onBackInvokedDispatcher, "invoker");
        this.f2442f = onBackInvokedDispatcher;
        t(this.f2444h);
    }

    @JvmOverloads
    public OnBackPressedDispatcher(@Nullable Runnable runnable) {
        this(runnable, (Consumer<Boolean>) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : runnable);
    }

    public OnBackPressedDispatcher(@Nullable Runnable runnable, @Nullable Consumer<Boolean> consumer) {
        this.f2437a = runnable;
        this.f2438b = consumer;
        this.f2439c = new ArrayDeque<>();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            this.f2441e = i2 >= 34 ? Api34Impl.f2446a.a(new Function1<BackEventCompat, Unit>(this) {
                final /* synthetic */ OnBackPressedDispatcher X;

                {
                    this.X = r1;
                }

                public final void b(@NotNull BackEventCompat backEventCompat) {
                    Intrinsics.p(backEventCompat, "backEvent");
                    this.X.r(backEventCompat);
                }

                public /* bridge */ /* synthetic */ Object f(Object obj) {
                    b((BackEventCompat) obj);
                    return Unit.f28779a;
                }
            }, new Function1<BackEventCompat, Unit>(this) {
                final /* synthetic */ OnBackPressedDispatcher X;

                {
                    this.X = r1;
                }

                public final void b(@NotNull BackEventCompat backEventCompat) {
                    Intrinsics.p(backEventCompat, "backEvent");
                    this.X.q(backEventCompat);
                }

                public /* bridge */ /* synthetic */ Object f(Object obj) {
                    b((BackEventCompat) obj);
                    return Unit.f28779a;
                }
            }, new Function0<Unit>(this) {
                final /* synthetic */ OnBackPressedDispatcher X;

                {
                    this.X = r1;
                }

                public final void b() {
                    this.X.p();
                }

                public /* bridge */ /* synthetic */ Object o() {
                    b();
                    return Unit.f28779a;
                }
            }, new Function0<Unit>(this) {
                final /* synthetic */ OnBackPressedDispatcher X;

                {
                    this.X = r1;
                }

                public final void b() {
                    this.X.o();
                }

                public /* bridge */ /* synthetic */ Object o() {
                    b();
                    return Unit.f28779a;
                }
            }) : Api33Impl.f2445a.b(new Function0<Unit>(this) {
                final /* synthetic */ OnBackPressedDispatcher X;

                {
                    this.X = r1;
                }

                public final void b() {
                    this.X.p();
                }

                public /* bridge */ /* synthetic */ Object o() {
                    b();
                    return Unit.f28779a;
                }
            });
        }
    }
}
