package kotlin.coroutines;

import com.itextpdf.text.Annotation;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\u00012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002XT¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lkotlin/coroutines/EmptyCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "", "a", "()Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext$Element;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "e", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "R", "initial", "Lkotlin/Function2;", "operation", "n", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "context", "v", "(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "f", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "X", "J", "serialVersionUID", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SinceKotlin(version = "1.3")
public final class EmptyCoroutineContext implements CoroutineContext, Serializable {
    private static final long X = 0;
    @NotNull
    public static final EmptyCoroutineContext s = new EmptyCoroutineContext();

    private EmptyCoroutineContext() {
    }

    private final Object a() {
        return s;
    }

    @Nullable
    public <E extends CoroutineContext.Element> E e(@NotNull CoroutineContext.Key<E> key) {
        Intrinsics.p(key, "key");
        return null;
    }

    @NotNull
    public CoroutineContext f(@NotNull CoroutineContext.Key<?> key) {
        Intrinsics.p(key, "key");
        return this;
    }

    public int hashCode() {
        return 0;
    }

    public <R> R n(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.p(function2, Annotation.q3);
        return r;
    }

    @NotNull
    public String toString() {
        return "EmptyCoroutineContext";
    }

    @NotNull
    public CoroutineContext v(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.p(coroutineContext, "context");
        return coroutineContext;
    }
}
