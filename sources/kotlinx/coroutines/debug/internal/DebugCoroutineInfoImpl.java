package kotlinx.coroutines.debug.internal;

import com.dd.plist.ASCIIPropertyListParser;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0012\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u000b0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHPø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0014\u0010\rJ#\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\u00068\u0000X\u0004¢\u0006\u0006\n\u0004\b\f\u0010 R\u001c\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0000@\u0000X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010#R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\"\u0010-R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b(\u0010\rR\u0011\u0010\u0016\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b/\u0010\u001bR(\u00104\u001a\u0004\u0018\u00010\u000f2\b\u00100\u001a\u0004\u0018\u00010\u000f8@@@X\u000e¢\u0006\f\u001a\u0004\b+\u00101\"\u0004\b2\u00103\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "creationStackBottom", "", "sequenceNumber", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/debug/internal/StackTraceFrame;J)V", "", "Ljava/lang/StackTraceElement;", "b", "()Ljava/util/List;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "frame", "", "k", "(Lkotlin/sequences/SequenceScope;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "", "state", "Lkotlin/coroutines/Continuation;", "j", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)V", "toString", "()Ljava/lang/String;", "a", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "d", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "J", "Ljava/lang/ref/WeakReference;", "c", "Ljava/lang/ref/WeakReference;", "_context", "Ljava/lang/String;", "_state", "Ljava/lang/Thread;", "e", "Ljava/lang/Thread;", "lastObservedThread", "f", "_lastObservedFrame", "()Lkotlin/coroutines/CoroutineContext;", "creationStackTrace", "g", "value", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "i", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "lastObservedFrame", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class DebugCoroutineInfoImpl {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final StackTraceFrame f29277a;
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public final long f29278b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<CoroutineContext> f29279c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private String f29280d = DebugCoroutineInfoImplKt.f29283a;
    @Nullable
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public Thread f29281e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<CoroutineStackFrame> f29282f;

    public DebugCoroutineInfoImpl(@Nullable CoroutineContext coroutineContext, @Nullable StackTraceFrame stackTraceFrame, long j2) {
        this.f29277a = stackTraceFrame;
        this.f29278b = j2;
        this.f29279c = new WeakReference<>(coroutineContext);
    }

    private final List<StackTraceElement> b() {
        StackTraceFrame stackTraceFrame = this.f29277a;
        return stackTraceFrame == null ? CollectionsKt.E() : SequencesKt.c3(SequencesKt.b(new DebugCoroutineInfoImpl$creationStackTrace$1(this, stackTraceFrame, (Continuation<? super DebugCoroutineInfoImpl$creationStackTrace$1>) null)));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(kotlin.sequences.SequenceScope<? super java.lang.StackTraceElement> r6, kotlin.coroutines.jvm.internal.CoroutineStackFrame r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1) r0
            int r1 = r0.b3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.b3
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r6 = r0.Y2
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r6 = (kotlin.coroutines.jvm.internal.CoroutineStackFrame) r6
            java.lang.Object r7 = r0.X2
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            java.lang.Object r2 = r0.Z
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r2 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl) r2
            kotlin.ResultKt.n(r8)
            goto L_0x005e
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003d:
            kotlin.ResultKt.n(r8)
            r2 = r5
        L_0x0041:
            if (r7 != 0) goto L_0x0046
            kotlin.Unit r6 = kotlin.Unit.f28779a
            return r6
        L_0x0046:
            java.lang.StackTraceElement r8 = r7.K()
            if (r8 == 0) goto L_0x0061
            r0.Z = r2
            r0.X2 = r6
            r0.Y2 = r7
            r0.b3 = r3
            java.lang.Object r8 = r6.a(r8, r0)
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x005e:
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x0061:
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r7 = r7.j()
            if (r7 == 0) goto L_0x0068
            goto L_0x0041
        L_0x0068:
            kotlin.Unit r6 = kotlin.Unit.f28779a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.k(kotlin.sequences.SequenceScope, kotlin.coroutines.jvm.internal.CoroutineStackFrame, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final CoroutineContext c() {
        return this.f29279c.get();
    }

    @Nullable
    public final StackTraceFrame d() {
        return this.f29277a;
    }

    @NotNull
    public final List<StackTraceElement> e() {
        return b();
    }

    @Nullable
    public final CoroutineStackFrame f() {
        WeakReference<CoroutineStackFrame> weakReference = this.f29282f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @NotNull
    public final String g() {
        return this.f29280d;
    }

    @NotNull
    public final List<StackTraceElement> h() {
        CoroutineStackFrame f2 = f();
        if (f2 == null) {
            return CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList();
        while (f2 != null) {
            StackTraceElement K = f2.K();
            if (K != null) {
                arrayList.add(K);
            }
            f2 = f2.j();
        }
        return arrayList;
    }

    public final void i(@Nullable CoroutineStackFrame coroutineStackFrame) {
        this.f29282f = coroutineStackFrame != null ? new WeakReference<>(coroutineStackFrame) : null;
    }

    public final void j(@NotNull String str, @NotNull Continuation<?> continuation) {
        if (!Intrinsics.g(this.f29280d, str) || !Intrinsics.g(str, DebugCoroutineInfoImplKt.f29285c) || f() == null) {
            this.f29280d = str;
            Thread thread = null;
            i(continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null);
            if (Intrinsics.g(str, DebugCoroutineInfoImplKt.f29284b)) {
                thread = Thread.currentThread();
            }
            this.f29281e = thread;
        }
    }

    @NotNull
    public String toString() {
        return "DebugCoroutineInfo(state=" + g() + ",context=" + c() + ASCIIPropertyListParser.f18650h;
    }
}
