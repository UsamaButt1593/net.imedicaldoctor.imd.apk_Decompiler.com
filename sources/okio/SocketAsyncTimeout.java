package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "Ljava/net/Socket;", "socket", "<init>", "(Ljava/net/Socket;)V", "Ljava/io/IOException;", "cause", "y", "(Ljava/io/IOException;)Ljava/io/IOException;", "", "C", "()V", "n", "Ljava/net/Socket;", "okio"}, k = 1, mv = {1, 5, 1})
final class SocketAsyncTimeout extends AsyncTimeout {
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final Socket f31394n;

    public SocketAsyncTimeout(@NotNull Socket socket) {
        Intrinsics.p(socket, "socket");
        this.f31394n = socket;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.AssertionError} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Exception} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void C() {
        /*
            r5 = this;
            java.lang.String r0 = "Failed to close timed out socket "
            java.net.Socket r1 = r5.f31394n     // Catch:{ Exception -> 0x000a, AssertionError -> 0x0008 }
            r1.close()     // Catch:{ Exception -> 0x000a, AssertionError -> 0x0008 }
            goto L_0x0023
        L_0x0008:
            r1 = move-exception
            goto L_0x000c
        L_0x000a:
            r1 = move-exception
            goto L_0x0012
        L_0x000c:
            boolean r2 = okio.Okio.l(r1)
            if (r2 == 0) goto L_0x0022
        L_0x0012:
            java.util.logging.Logger r2 = okio.Okio__JvmOkioKt.f31370a
            java.util.logging.Level r3 = java.util.logging.Level.WARNING
            java.net.Socket r4 = r5.f31394n
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.C(r0, r4)
            r2.log(r3, r0, r1)
            goto L_0x0023
        L_0x0022:
            throw r1
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.SocketAsyncTimeout.C():void");
    }

    /* access modifiers changed from: protected */
    @NotNull
    public IOException y(@Nullable IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
