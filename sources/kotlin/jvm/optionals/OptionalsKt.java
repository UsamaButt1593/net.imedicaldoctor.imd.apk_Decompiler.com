package kotlin.jvm.optionals;

import com.itextpdf.text.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a.\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\f\u0012\b\b\u0001\u0012\u0004\b\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00028\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a8\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\f\u0012\b\b\u0001\u0012\u0004\b\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a=\u0010\u000e\u001a\u00028\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0010\b\u0001\u0010\f*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\r\u001a\u00028\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u0002\u000b\n\u0002\b9\n\u0005\b20\u0001¨\u0006\u0019"}, d2 = {"", "T", "Ljava/util/Optional;", "d", "(Ljava/util/Optional;)Ljava/lang/Object;", "defaultValue", "b", "(Ljava/util/Optional;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "c", "(Ljava/util/Optional;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "C", "destination", "e", "(Ljava/util/Optional;Ljava/util/Collection;)Ljava/util/Collection;", "", "f", "(Ljava/util/Optional;)Ljava/util/List;", "", "g", "(Ljava/util/Optional;)Ljava/util/Set;", "Lkotlin/sequences/Sequence;", "a", "(Ljava/util/Optional;)Lkotlin/sequences/Sequence;", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 9, 0})
public final class OptionalsKt {
    @SinceKotlin(version = "1.8")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> Sequence<T> a(@NotNull Optional<? extends T> optional) {
        Intrinsics.p(optional, "<this>");
        if (!optional.isPresent()) {
            return SequencesKt.g();
        }
        return SequencesKt.q(optional.get());
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T b(@NotNull Optional<? extends T> optional, T t) {
        Intrinsics.p(optional, "<this>");
        return optional.isPresent() ? optional.get() : t;
    }

    @SinceKotlin(version = "1.8")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T c(@NotNull Optional<? extends T> optional, @NotNull Function0<? extends T> function0) {
        Intrinsics.p(optional, "<this>");
        Intrinsics.p(function0, "defaultValue");
        return optional.isPresent() ? optional.get() : function0.o();
    }

    @SinceKotlin(version = "1.8")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T d(@NotNull Optional<T> optional) {
        Intrinsics.p(optional, "<this>");
        return optional.orElse((Object) null);
    }

    @SinceKotlin(version = "1.8")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, C extends Collection<? super T>> C e(@NotNull Optional<T> optional, @NotNull C c2) {
        Intrinsics.p(optional, "<this>");
        Intrinsics.p(c2, Annotation.l3);
        if (optional.isPresent()) {
            Object a2 = optional.get();
            Intrinsics.o(a2, "get()");
            c2.add(a2);
        }
        return c2;
    }

    @SinceKotlin(version = "1.8")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> List<T> f(@NotNull Optional<? extends T> optional) {
        Intrinsics.p(optional, "<this>");
        return optional.isPresent() ? CollectionsKt.k(optional.get()) : CollectionsKt.E();
    }

    @SinceKotlin(version = "1.8")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> Set<T> g(@NotNull Optional<? extends T> optional) {
        Intrinsics.p(optional, "<this>");
        return optional.isPresent() ? SetsKt.f(optional.get()) : SetsKt.k();
    }
}
