package kotlin.coroutines.cancellation;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a(\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\b\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\b¢\u0006\u0004\b\b\u0010\t*\u001a\b\u0007\u0010\r\"\u00020\u00042\u00020\u0004B\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¨\u0006\u000e"}, d2 = {"", "message", "", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", "a", "(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/util/concurrent/CancellationException;", "b", "(Ljava/lang/Throwable;)Ljava/util/concurrent/CancellationException;", "Lkotlin/SinceKotlin;", "version", "1.4", "CancellationException", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nCancellationException.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellationException.kt\nkotlin/coroutines/cancellation/CancellationExceptionKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,22:1\n1#2:23\n*E\n"})
public final class CancellationExceptionKt {
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final CancellationException b(Throwable th) {
        CancellationException cancellationException = new CancellationException(th != null ? th.toString() : null);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void c() {
    }
}
