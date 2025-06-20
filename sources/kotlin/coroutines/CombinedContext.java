package kotlin.coroutines;

import com.itextpdf.text.Annotation;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n1#2:197\n*E\n"})
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001-B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J*\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001b\u001a\u00028\u00002\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010 \u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0016¢\u0006\u0004\b \u0010!J\u001a\u0010#\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b%\u0010\u000bJ\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "", "h", "()I", "", "a", "(Lkotlin/coroutines/CoroutineContext$Element;)Z", "context", "g", "(Lkotlin/coroutines/CombinedContext;)Z", "", "j", "()Ljava/lang/Object;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "e", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "R", "initial", "Lkotlin/Function2;", "operation", "n", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "f", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "s", "Lkotlin/coroutines/CoroutineContext;", "X", "Lkotlin/coroutines/CoroutineContext$Element;", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class CombinedContext implements CoroutineContext, Serializable {
    @NotNull
    private final CoroutineContext.Element X;
    @NotNull
    private final CoroutineContext s;

    @SourceDebugExtension({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,196:1\n12720#2,3:197\n*S KotlinDebug\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n*L\n193#1:197,3\n*E\n"})
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\b\u0002\u0018\u0000 \u000f2\u00060\u0001j\u0002`\u0002:\u0001\u0010B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "Lkotlin/coroutines/CoroutineContext;", "elements", "<init>", "([Lkotlin/coroutines/CoroutineContext;)V", "", "b", "()Ljava/lang/Object;", "s", "[Lkotlin/coroutines/CoroutineContext;", "a", "()[Lkotlin/coroutines/CoroutineContext;", "X", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    private static final class Serialized implements Serializable {
        @NotNull
        public static final Companion X = new Companion((DefaultConstructorMarker) null);
        private static final long Y = 0;
        @NotNull
        private final CoroutineContext[] s;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Serialized(@NotNull CoroutineContext[] coroutineContextArr) {
            Intrinsics.p(coroutineContextArr, "elements");
            this.s = coroutineContextArr;
        }

        private final Object b() {
            CoroutineContext[] coroutineContextArr = this.s;
            CoroutineContext coroutineContext = EmptyCoroutineContext.s;
            for (CoroutineContext v : coroutineContextArr) {
                coroutineContext = coroutineContext.v(v);
            }
            return coroutineContext;
        }

        @NotNull
        public final CoroutineContext[] a() {
            return this.s;
        }
    }

    public CombinedContext(@NotNull CoroutineContext coroutineContext, @NotNull CoroutineContext.Element element) {
        Intrinsics.p(coroutineContext, "left");
        Intrinsics.p(element, "element");
        this.s = coroutineContext;
        this.X = element;
    }

    private final boolean a(CoroutineContext.Element element) {
        return Intrinsics.g(e(element.getKey()), element);
    }

    private final boolean g(CombinedContext combinedContext) {
        while (a(combinedContext.X)) {
            CoroutineContext coroutineContext = combinedContext.s;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                Intrinsics.n(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return a((CoroutineContext.Element) coroutineContext);
            }
        }
        return false;
    }

    private final int h() {
        int i2 = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.s;
            combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return i2;
            }
            i2++;
        }
    }

    private final Object j() {
        int h2 = h();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[h2];
        Ref.IntRef intRef = new Ref.IntRef();
        n(Unit.f28779a, new CombinedContext$writeReplace$1(coroutineContextArr, intRef));
        if (intRef.s == h2) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Nullable
    public <E extends CoroutineContext.Element> E e(@NotNull CoroutineContext.Key<E> key) {
        Intrinsics.p(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e2 = combinedContext.X.e(key);
            if (e2 != null) {
                return e2;
            }
            CoroutineContext coroutineContext = combinedContext.s;
            if (!(coroutineContext instanceof CombinedContext)) {
                return coroutineContext.e(key);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.h() != h() || !combinedContext.g(this)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    @NotNull
    public CoroutineContext f(@NotNull CoroutineContext.Key<?> key) {
        Intrinsics.p(key, "key");
        if (this.X.e(key) != null) {
            return this.s;
        }
        CoroutineContext f2 = this.s.f(key);
        if (f2 == this.s) {
            return this;
        }
        return f2 == EmptyCoroutineContext.s ? this.X : new CombinedContext(f2, this.X);
    }

    public int hashCode() {
        return this.s.hashCode() + this.X.hashCode();
    }

    public <R> R n(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.p(function2, Annotation.q3);
        return function2.d0(this.s.n(r, function2), this.X);
    }

    @NotNull
    public String toString() {
        return '[' + ((String) n("", CombinedContext$toString$1.X)) + ']';
    }

    @NotNull
    public CoroutineContext v(@NotNull CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.a(this, coroutineContext);
    }
}
