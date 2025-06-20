package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\u001a!\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0004\u001a.\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\b¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0007\u001a\u00060\nj\u0002`\u000bH\u0002¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u0004\u001a;\u0010\u0015\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00002\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0012j\u0002`\u00130\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a3\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0012j\u0002`\u00130\u00180\u0017\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u0000H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a3\u0010\u001d\u001a\u00020\u001c2\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0012j\u0002`\u00130\u00182\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0012j\u0002`\u00130\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001b\u0010 \u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u0000HHø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\"\u0010\"\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\b¢\u0006\u0004\b\"\u0010\u0004\u001a!\u0010#\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0000¢\u0006\u0004\b#\u0010\u0004\u001a%\u0010$\u001a\f\u0012\b\u0012\u00060\u0012j\u0002`\u00130\u00112\n\u0010\u0007\u001a\u00060\nj\u0002`\u000bH\u0002¢\u0006\u0004\b$\u0010%\u001a\u001b\u0010(\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b(\u0010)\u001a\u0017\u0010+\u001a\u00020**\u00060\u0012j\u0002`\u0013H\u0000¢\u0006\u0004\b+\u0010,\u001a%\u0010/\u001a\u00020.*\f\u0012\b\u0012\u00060\u0012j\u0002`\u00130\u00182\u0006\u0010-\u001a\u00020&H\u0002¢\u0006\u0004\b/\u00100\u001a#\u00101\u001a\u00020**\u00060\u0012j\u0002`\u00132\n\u0010\u0019\u001a\u00060\u0012j\u0002`\u0013H\u0002¢\u0006\u0004\b1\u00102\u001a\u001b\u00103\u001a\u00020\u001c*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0000¢\u0006\u0004\b3\u00104\"\u0014\u00107\u001a\u00020&8\u0002XT¢\u0006\u0006\n\u0004\b5\u00106\"\u0014\u00109\u001a\u00020&8\u0002XT¢\u0006\u0006\n\u0004\b8\u00106\"\u001c\u0010<\u001a\n :*\u0004\u0018\u00010&0&8\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u00106\"\u001c\u0010=\u001a\n :*\u0004\u0018\u00010&0&8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u00106*\f\b\u0000\u0010>\"\u00020\n2\u00020\n*\f\b\u0000\u0010?\"\u00020\u00122\u00020\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"", "E", "exception", "p", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "r", "Lkotlin/coroutines/Continuation;", "continuation", "q", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "o", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "s", "cause", "result", "Ljava/util/ArrayDeque;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "resultStackTrace", "f", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "Lkotlin/Pair;", "", "e", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "recoveredStacktrace", "", "l", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "", "m", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "u", "g", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/util/ArrayDeque;", "", "message", "d", "(Ljava/lang/String;)Ljava/lang/StackTraceElement;", "", "k", "(Ljava/lang/StackTraceElement;)Z", "methodName", "", "i", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "h", "(Ljava/lang/StackTraceElement;Ljava/lang/StackTraceElement;)Z", "j", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "a", "Ljava/lang/String;", "baseContinuationImplClass", "b", "stackTraceRecoveryClass", "kotlin.jvm.PlatformType", "c", "baseContinuationImplClassName", "stackTraceRecoveryClassName", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class StackTraceRecoveryKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final String f29393a = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f29394b = "kotlinx.coroutines.internal.StackTraceRecoveryKt";

    /* renamed from: c  reason: collision with root package name */
    private static final String f29395c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f29396d;

    static {
        Object obj;
        Object obj2;
        try {
            Result.Companion companion = Result.X;
            obj = Result.b(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            obj = Result.b(ResultKt.a(th));
        }
        if (Result.e(obj) != null) {
            obj = f29393a;
        }
        f29395c = (String) obj;
        try {
            Result.Companion companion3 = Result.X;
            obj2 = Result.b(StackTraceRecoveryKt.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.X;
            obj2 = Result.b(ResultKt.a(th2));
        }
        if (Result.e(obj2) != null) {
            obj2 = f29394b;
        }
        f29396d = (String) obj2;
    }

    public static /* synthetic */ void a() {
    }

    public static /* synthetic */ void b() {
    }

    @NotNull
    @InternalCoroutinesApi
    public static final StackTraceElement d(@NotNull String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> e(E e2) {
        Throwable cause = e2.getCause();
        if (cause == null || !Intrinsics.g(cause.getClass(), e2.getClass())) {
            return TuplesKt.a(e2, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e2.getStackTrace();
        for (StackTraceElement k2 : stackTrace) {
            if (k(k2)) {
                return TuplesKt.a(cause, stackTrace);
            }
        }
        return TuplesKt.a(e2, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E f(E e2, E e3, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(d("Coroutine boundary"));
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int i2 = i(stackTrace, f29395c);
        int i3 = 0;
        if (i2 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array != null) {
                e3.setStackTrace((StackTraceElement[]) array);
                return e3;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[(arrayDeque.size() + i2)];
        for (int i4 = 0; i4 < i2; i4++) {
            stackTraceElementArr[i4] = stackTrace[i4];
        }
        Iterator<StackTraceElement> it2 = arrayDeque.iterator();
        while (it2.hasNext()) {
            int i5 = i3 + 1;
            stackTraceElementArr[i3 + i2] = it2.next();
            i3 = i5;
        }
        e3.setStackTrace(stackTraceElementArr);
        return e3;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015  */
    private static final java.util.ArrayDeque<java.lang.StackTraceElement> g(kotlin.coroutines.jvm.internal.CoroutineStackFrame r2) {
        /*
            java.util.ArrayDeque r0 = new java.util.ArrayDeque
            r0.<init>()
            java.lang.StackTraceElement r1 = r2.K()
            if (r1 == 0) goto L_0x000e
        L_0x000b:
            r0.add(r1)
        L_0x000e:
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r2 = r2.j()
            if (r2 != 0) goto L_0x0015
            return r0
        L_0x0015:
            java.lang.StackTraceElement r1 = r2.K()
            if (r1 == 0) goto L_0x000e
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.StackTraceRecoveryKt.g(kotlin.coroutines.jvm.internal.CoroutineStackFrame):java.util.ArrayDeque");
    }

    private static final boolean h(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && Intrinsics.g(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && Intrinsics.g(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && Intrinsics.g(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final int i(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Intrinsics.g(str, stackTraceElementArr[i2].getClassName())) {
                return i2;
            }
        }
        return -1;
    }

    public static final void j(@NotNull Throwable th, @NotNull Throwable th2) {
        th.initCause(th2);
    }

    public static final boolean k(@NotNull StackTraceElement stackTraceElement) {
        return StringsKt.s2(stackTraceElement.getClassName(), "\b\b\b", false, 2, (Object) null);
    }

    private static final void l(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (k(stackTraceElementArr[i2])) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = i2 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i3 <= length2) {
            while (true) {
                if (h(stackTraceElementArr[length2], arrayDeque.getLast())) {
                    arrayDeque.removeLast();
                }
                arrayDeque.addFirst(stackTraceElementArr[length2]);
                if (length2 != i3) {
                    length2--;
                } else {
                    return;
                }
            }
        }
    }

    @Nullable
    public static final Object m(@NotNull Throwable th, @NotNull Continuation<?> continuation) {
        throw th;
    }

    private static final Object n(Throwable th, Continuation<?> continuation) {
        throw th;
    }

    /* access modifiers changed from: private */
    public static final <E extends Throwable> E o(E e2, CoroutineStackFrame coroutineStackFrame) {
        Pair e3 = e(e2);
        E e4 = (Throwable) e3.a();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) e3.b();
        Throwable s = s(e4);
        if (s == null) {
            return e2;
        }
        ArrayDeque g2 = g(coroutineStackFrame);
        if (g2.isEmpty()) {
            return e2;
        }
        if (e4 != e2) {
            l(stackTraceElementArr, g2);
        }
        return f(e4, s, g2);
    }

    @NotNull
    public static final <E extends Throwable> E p(@NotNull E e2) {
        return e2;
    }

    @NotNull
    public static final <E extends Throwable> E q(@NotNull E e2, @NotNull Continuation<?> continuation) {
        return e2;
    }

    private static final <E extends Throwable> E r(E e2) {
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int length = stackTrace.length;
        int i2 = i(stackTrace, f29396d);
        int i3 = i2 + 1;
        int i4 = i(stackTrace, f29395c);
        int i5 = 0;
        int i6 = (length - i2) - (i4 == -1 ? 0 : length - i4);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i6];
        while (i5 < i6) {
            stackTraceElementArr[i5] = i5 == 0 ? d("Coroutine boundary") : stackTrace[(i3 + i5) - 1];
            i5++;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    private static final <E extends Throwable> E s(E e2) {
        E h2 = ExceptionsConstructorKt.h(e2);
        if (h2 == null) {
            return null;
        }
        if ((e2 instanceof CopyableThrowable) || Intrinsics.g(h2.getMessage(), e2.getMessage())) {
            return h2;
        }
        return null;
    }

    @NotNull
    public static final <E extends Throwable> E t(@NotNull E e2) {
        return e2;
    }

    @NotNull
    public static final <E extends Throwable> E u(@NotNull E e2) {
        E cause = e2.getCause();
        if (cause != null && Intrinsics.g(cause.getClass(), e2.getClass())) {
            for (StackTraceElement k2 : e2.getStackTrace()) {
                if (k(k2)) {
                    return cause;
                }
            }
        }
        return e2;
    }
}
