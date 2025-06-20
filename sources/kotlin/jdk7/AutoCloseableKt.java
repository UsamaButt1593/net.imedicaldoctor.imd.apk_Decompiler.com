package kotlin.jdk7;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aJ\u0010\u0005\u001a\u00028\u0001\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0000\"\u0004\b\u0001\u0010\u0002*\u00028\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"Ljava/lang/AutoCloseable;", "T", "R", "Lkotlin/Function1;", "block", "b", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "cause", "", "a", "(Ljava/lang/AutoCloseable;Ljava/lang/Throwable;)V", "kotlin-stdlib-jdk7"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "AutoCloseableKt")
public final class AutoCloseableKt {
    @SinceKotlin(version = "1.2")
    @PublishedApi
    public static final void a(@Nullable AutoCloseable autoCloseable, @Nullable Throwable th) {
        if (autoCloseable == null) {
            return;
        }
        if (th == null) {
            autoCloseable.close();
            return;
        }
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            ExceptionsKt.a(th, th2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        kotlin.jvm.internal.InlineMarker.d(1);
        a(r2, r3);
        kotlin.jvm.internal.InlineMarker.c(1);
     */
    @kotlin.SinceKotlin(version = "1.2")
    @kotlin.internal.InlineOnly
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T extends java.lang.AutoCloseable, R> R b(T r2, kotlin.jvm.functions.Function1<? super T, ? extends R> r3) {
        /*
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            r0 = 1
            java.lang.Object r3 = r3.f(r2)     // Catch:{ all -> 0x0015 }
            kotlin.jvm.internal.InlineMarker.d(r0)
            r1 = 0
            a(r2, r1)
            kotlin.jvm.internal.InlineMarker.c(r0)
            return r3
        L_0x0015:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r0)
            a(r2, r3)
            kotlin.jvm.internal.InlineMarker.c(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jdk7.AutoCloseableKt.b(java.lang.AutoCloseable, kotlin.jvm.functions.Function1):java.lang.Object");
    }
}
