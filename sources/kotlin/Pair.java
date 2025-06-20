package kotlin;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00060\u0003j\u0002`\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ0\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u0001HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\rR\u0017\u0010\u0006\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\r¨\u0006\u001e"}, d2 = {"Lkotlin/Pair;", "A", "B", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "a", "()Ljava/lang/Object;", "b", "c", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "s", "Ljava/lang/Object;", "e", "X", "f", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class Pair<A, B> implements Serializable {
    private final B X;
    private final A s;

    public Pair(A a2, B b2) {
        this.s = a2;
        this.X = b2;
    }

    public static /* synthetic */ Pair d(Pair pair, A a2, B b2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            a2 = pair.s;
        }
        if ((i2 & 2) != 0) {
            b2 = pair.X;
        }
        return pair.c(a2, b2);
    }

    public final A a() {
        return this.s;
    }

    public final B b() {
        return this.X;
    }

    @NotNull
    public final Pair<A, B> c(A a2, B b2) {
        return new Pair<>(a2, b2);
    }

    public final A e() {
        return this.s;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return Intrinsics.g(this.s, pair.s) && Intrinsics.g(this.X, pair.X);
    }

    public final B f() {
        return this.X;
    }

    public int hashCode() {
        A a2 = this.s;
        int i2 = 0;
        int hashCode = (a2 == null ? 0 : a2.hashCode()) * 31;
        B b2 = this.X;
        if (b2 != null) {
            i2 = b2.hashCode();
        }
        return hashCode + i2;
    }

    @NotNull
    public String toString() {
        return ASCIIPropertyListParser.f18649g + this.s + ", " + this.X + ASCIIPropertyListParser.f18650h;
    }
}
