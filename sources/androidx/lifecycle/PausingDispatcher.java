package androidx.lifecycle;

import com.itextpdf.tool.xml.css.CSS;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0000X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/PausingDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "Lkotlin/coroutines/CoroutineContext;", "context", "", "T", "(Lkotlin/coroutines/CoroutineContext;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "R", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "Landroidx/lifecycle/DispatchQueue;", "Y", "Landroidx/lifecycle/DispatchQueue;", "dispatchQueue", "lifecycle-common"}, k = 1, mv = {1, 8, 0})
public final class PausingDispatcher extends CoroutineDispatcher {
    @NotNull
    @JvmField
    public final DispatchQueue Y = new DispatchQueue();

    public void R(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.p(coroutineContext, "context");
        Intrinsics.p(runnable, CSS.Value.v0);
        this.Y.c(coroutineContext, runnable);
    }

    public boolean T(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.p(coroutineContext, "context");
        if (Dispatchers.e().i0().T(coroutineContext)) {
            return true;
        }
        return !this.Y.b();
    }
}
