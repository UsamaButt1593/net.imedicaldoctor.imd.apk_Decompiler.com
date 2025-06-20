package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.VisibleForTesting;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\t\u001a\u00020\u0000*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\f\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001d\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a%\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0019\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\"\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0000X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001c\u0010\u001d\"\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroid/os/Handler;", "", "name", "Lkotlinx/coroutines/android/HandlerDispatcher;", "g", "(Landroid/os/Handler;Ljava/lang/String;)Lkotlinx/coroutines/android/HandlerDispatcher;", "Landroid/os/Looper;", "", "async", "d", "(Landroid/os/Looper;Z)Landroid/os/Handler;", "", "e", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", "l", "(Lkotlinx/coroutines/CancellableContinuation;)V", "Landroid/view/Choreographer;", "choreographer", "j", "(Landroid/view/Choreographer;Lkotlinx/coroutines/CancellableContinuation;)V", "a", "J", "MAX_DELAY", "b", "Lkotlinx/coroutines/android/HandlerDispatcher;", "i", "()V", "Main", "Landroid/view/Choreographer;", "kotlinx-coroutines-android"}, k = 2, mv = {1, 6, 0})
public final class HandlerDispatcherKt {

    /* renamed from: a  reason: collision with root package name */
    private static final long f29219a = 4611686018427387903L;
    @Nullable
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public static final HandlerDispatcher f29220b;
    @Nullable
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        HandlerDispatcher handlerDispatcher = null;
        try {
            Result.Companion companion = Result.X;
            obj = Result.b(new HandlerContext(d(Looper.getMainLooper(), true), (String) null, 2, (DefaultConstructorMarker) null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            obj = Result.b(ResultKt.a(th));
        }
        if (!Result.i(obj)) {
            handlerDispatcher = obj;
        }
        f29220b = handlerDispatcher;
    }

    @NotNull
    @VisibleForTesting
    public static final Handler d(@NotNull Looper looper, boolean z) {
        if (!z) {
            return new Handler(looper);
        }
        Class<Looper> cls = Looper.class;
        Class<Handler> cls2 = Handler.class;
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = cls2.getDeclaredMethod("createAsync", new Class[]{cls}).invoke((Object) null, new Object[]{looper});
            if (invoke != null) {
                return (Handler) invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
        }
        try {
            return cls2.getDeclaredConstructor(new Class[]{cls, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }

    @Nullable
    public static final Object e(@NotNull Continuation<? super Long> continuation) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 != null) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.e(continuation), 1);
            cancellableContinuationImpl.W();
            j(choreographer2, cancellableContinuationImpl);
            Object y = cancellableContinuationImpl.y();
            if (y == IntrinsicsKt.l()) {
                DebugProbesKt.c(continuation);
            }
            return y;
        }
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.e(continuation), 1);
        cancellableContinuationImpl2.W();
        Dispatchers.e().R(EmptyCoroutineContext.s, new HandlerDispatcherKt$awaitFrame$lambda3$$inlined$Runnable$1(cancellableContinuationImpl2));
        Object y2 = cancellableContinuationImpl2.y();
        if (y2 == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y2;
    }

    @NotNull
    @JvmOverloads
    @JvmName(name = "from")
    public static final HandlerDispatcher f(@NotNull Handler handler) {
        return h(handler, (String) null, 1, (Object) null);
    }

    @NotNull
    @JvmOverloads
    @JvmName(name = "from")
    public static final HandlerDispatcher g(@NotNull Handler handler, @Nullable String str) {
        return new HandlerContext(handler, str);
    }

    public static /* synthetic */ HandlerDispatcher h(Handler handler, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        return g(handler, str);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void i() {
    }

    /* access modifiers changed from: private */
    public static final void j(Choreographer choreographer2, CancellableContinuation<? super Long> cancellableContinuation) {
        choreographer2.postFrameCallback(new b(cancellableContinuation));
    }

    /* access modifiers changed from: private */
    public static final void k(CancellableContinuation cancellableContinuation, long j2) {
        cancellableContinuation.S(Dispatchers.e(), Long.valueOf(j2));
    }

    /* access modifiers changed from: private */
    public static final void l(CancellableContinuation<? super Long> cancellableContinuation) {
        Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = Choreographer.getInstance();
            Intrinsics.m(choreographer2);
            choreographer = choreographer2;
        }
        j(choreographer2, cancellableContinuation);
    }
}
