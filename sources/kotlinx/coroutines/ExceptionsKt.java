package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a%\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\b¢\u0006\u0004\b\n\u0010\u000b*\n\u0010\f\"\u00020\u00042\u00020\u0004¨\u0006\r"}, d2 = {"", "message", "", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "a", "(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/util/concurrent/CancellationException;", "other", "", "b", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "CancellationException", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class ExceptionsKt {
    @NotNull
    public static final CancellationException a(@Nullable String str, @Nullable Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static final void b(@NotNull Throwable th, @NotNull Throwable th2) {
        kotlin.ExceptionsKt.a(th, th2);
    }
}
