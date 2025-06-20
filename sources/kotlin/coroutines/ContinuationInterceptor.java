package kotlin.coroutines;

import com.itextpdf.text.Annotation;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013J)\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ*\u0010\r\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\n*\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\u000f2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "T", "Lkotlin/coroutines/Continuation;", "continuation", "t", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "", "q", "(Lkotlin/coroutines/Continuation;)V", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "e", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "f", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "N2", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SinceKotlin(version = "1.3")
public interface ContinuationInterceptor extends CoroutineContext.Element {
    @NotNull
    public static final Key N2 = Key.s;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R a(@NotNull ContinuationInterceptor continuationInterceptor, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            Intrinsics.p(function2, Annotation.q3);
            return CoroutineContext.Element.DefaultImpls.a(continuationInterceptor, r, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E b(@NotNull ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext.Key<E> key) {
            Intrinsics.p(key, "key");
            if (key instanceof AbstractCoroutineContextKey) {
                AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
                if (!abstractCoroutineContextKey.a(continuationInterceptor.getKey())) {
                    return null;
                }
                E b2 = abstractCoroutineContextKey.b(continuationInterceptor);
                if (b2 instanceof CoroutineContext.Element) {
                    return b2;
                }
                return null;
            } else if (ContinuationInterceptor.N2 != key) {
                return null;
            } else {
                Intrinsics.n(continuationInterceptor, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return continuationInterceptor;
            }
        }

        @NotNull
        public static CoroutineContext c(@NotNull ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext.Key<?> key) {
            Intrinsics.p(key, "key");
            if (!(key instanceof AbstractCoroutineContextKey)) {
                return ContinuationInterceptor.N2 == key ? EmptyCoroutineContext.s : continuationInterceptor;
            }
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            return (!abstractCoroutineContextKey.a(continuationInterceptor.getKey()) || abstractCoroutineContextKey.b(continuationInterceptor) == null) ? continuationInterceptor : EmptyCoroutineContext.s;
        }

        @NotNull
        public static CoroutineContext d(@NotNull ContinuationInterceptor continuationInterceptor, @NotNull CoroutineContext coroutineContext) {
            Intrinsics.p(coroutineContext, "context");
            return CoroutineContext.Element.DefaultImpls.d(continuationInterceptor, coroutineContext);
        }

        public static void e(@NotNull ContinuationInterceptor continuationInterceptor, @NotNull Continuation<?> continuation) {
            Intrinsics.p(continuation, "continuation");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {
        static final /* synthetic */ Key s = new Key();

        private Key() {
        }
    }

    @Nullable
    <E extends CoroutineContext.Element> E e(@NotNull CoroutineContext.Key<E> key);

    @NotNull
    CoroutineContext f(@NotNull CoroutineContext.Key<?> key);

    void q(@NotNull Continuation<?> continuation);

    @NotNull
    <T> Continuation<T> t(@NotNull Continuation<? super T> continuation);
}
