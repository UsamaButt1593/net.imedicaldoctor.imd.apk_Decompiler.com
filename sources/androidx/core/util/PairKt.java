package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Pair;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001a,\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004\u001a,\u0010\u0005\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0004\u001a8\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\b¢\u0006\u0004\b\u0007\u0010\b\u001a8\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\b¢\u0006\u0004\b\t\u0010\n\u001a,\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\n¢\u0006\u0004\b\f\u0010\r\u001a,\u0010\u000e\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\n¢\u0006\u0004\b\u000e\u0010\r\u001a8\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a8\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\b¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"F", "S", "Landroidx/core/util/Pair;", "b", "(Landroidx/core/util/Pair;)Ljava/lang/Object;", "d", "Lkotlin/Pair;", "h", "(Landroidx/core/util/Pair;)Lkotlin/Pair;", "f", "(Lkotlin/Pair;)Landroidx/core/util/Pair;", "Landroid/util/Pair;", "a", "(Landroid/util/Pair;)Ljava/lang/Object;", "c", "g", "(Landroid/util/Pair;)Lkotlin/Pair;", "e", "(Lkotlin/Pair;)Landroid/util/Pair;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F a(@NotNull Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F b(@NotNull Pair<F, S> pair) {
        return pair.f6296a;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S c(@NotNull Pair<F, S> pair) {
        return pair.second;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S d(@NotNull Pair<F, S> pair) {
        return pair.f6297b;
    }

    @NotNull
    public static final <F, S> Pair<F, S> e(@NotNull kotlin.Pair<? extends F, ? extends S> pair) {
        return new Pair<>(pair.e(), pair.f());
    }

    @NotNull
    public static final <F, S> Pair<F, S> f(@NotNull kotlin.Pair<? extends F, ? extends S> pair) {
        return new Pair<>(pair.e(), pair.f());
    }

    @NotNull
    public static final <F, S> kotlin.Pair<F, S> g(@NotNull Pair<F, S> pair) {
        return new kotlin.Pair<>(pair.first, pair.second);
    }

    @NotNull
    public static final <F, S> kotlin.Pair<F, S> h(@NotNull Pair<F, S> pair) {
        return new kotlin.Pair<>(pair.f6296a, pair.f6297b);
    }
}
