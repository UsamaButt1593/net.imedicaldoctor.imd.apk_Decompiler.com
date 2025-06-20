package kotlin.io;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aJ\u0010\u0005\u001a\u00028\u0001\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u0000\"\u0004\b\u0001\u0010\u0002*\u00028\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"Ljava/io/Closeable;", "T", "R", "Lkotlin/Function1;", "block", "b", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "cause", "", "a", "(Ljava/io/Closeable;Ljava/lang/Throwable;)V", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "CloseableKt")
public final class CloseableKt {
    @SinceKotlin(version = "1.1")
    @PublishedApi
    public static final void a(@Nullable Closeable closeable, @Nullable Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            ExceptionsKt.a(th, th2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        kotlin.jvm.internal.InlineMarker.d(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (kotlin.internal.PlatformImplementationsKt.a(1, 1, 0) == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        if (r3 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        a(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        kotlin.jvm.internal.InlineMarker.c(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        throw r2;
     */
    @kotlin.internal.InlineOnly
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T extends java.io.Closeable, R> R b(T r3, kotlin.jvm.functions.Function1<? super T, ? extends R> r4) {
        /*
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.p(r4, r0)
            r0 = 0
            r1 = 1
            java.lang.Object r4 = r4.f(r3)     // Catch:{ all -> 0x0022 }
            kotlin.jvm.internal.InlineMarker.d(r1)
            boolean r0 = kotlin.internal.PlatformImplementationsKt.a(r1, r1, r0)
            if (r0 == 0) goto L_0x0019
            r0 = 0
            a(r3, r0)
            goto L_0x001e
        L_0x0019:
            if (r3 == 0) goto L_0x001e
            r3.close()
        L_0x001e:
            kotlin.jvm.internal.InlineMarker.c(r1)
            return r4
        L_0x0022:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r2 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r1)
            boolean r0 = kotlin.internal.PlatformImplementationsKt.a(r1, r1, r0)
            if (r0 != 0) goto L_0x0034
            if (r3 == 0) goto L_0x0037
            r3.close()     // Catch:{ all -> 0x0037 }
            goto L_0x0037
        L_0x0034:
            a(r3, r4)
        L_0x0037:
            kotlin.jvm.internal.InlineMarker.c(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.CloseableKt.b(java.io.Closeable, kotlin.jvm.functions.Function1):java.lang.Object");
    }
}
