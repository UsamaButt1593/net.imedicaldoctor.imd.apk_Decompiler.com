package kotlin;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u00012\u00060\u0004j\u0002`\u0005B\u001f\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\b\u001a\u00028\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ@\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00012\b\b\u0002\u0010\b\u001a\u00028\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u000fR\u0017\u0010\u0007\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u000fR\u0017\u0010\b\u001a\u00028\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u000f¨\u0006#"}, d2 = {"Lkotlin/Triple;", "A", "B", "C", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "third", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "a", "()Ljava/lang/Object;", "b", "c", "d", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "s", "Ljava/lang/Object;", "f", "X", "g", "Y", "h", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class Triple<A, B, C> implements Serializable {
    private final B X;
    private final C Y;
    private final A s;

    public Triple(A a2, B b2, C c2) {
        this.s = a2;
        this.X = b2;
        this.Y = c2;
    }

    public static /* synthetic */ Triple e(Triple triple, A a2, B b2, C c2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            a2 = triple.s;
        }
        if ((i2 & 2) != 0) {
            b2 = triple.X;
        }
        if ((i2 & 4) != 0) {
            c2 = triple.Y;
        }
        return triple.d(a2, b2, c2);
    }

    public final A a() {
        return this.s;
    }

    public final B b() {
        return this.X;
    }

    public final C c() {
        return this.Y;
    }

    @NotNull
    public final Triple<A, B, C> d(A a2, B b2, C c2) {
        return new Triple<>(a2, b2, c2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return Intrinsics.g(this.s, triple.s) && Intrinsics.g(this.X, triple.X) && Intrinsics.g(this.Y, triple.Y);
    }

    public final A f() {
        return this.s;
    }

    public final B g() {
        return this.X;
    }

    public final C h() {
        return this.Y;
    }

    public int hashCode() {
        A a2 = this.s;
        int i2 = 0;
        int hashCode = (a2 == null ? 0 : a2.hashCode()) * 31;
        B b2 = this.X;
        int hashCode2 = (hashCode + (b2 == null ? 0 : b2.hashCode())) * 31;
        C c2 = this.Y;
        if (c2 != null) {
            i2 = c2.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        return ASCIIPropertyListParser.f18649g + this.s + ", " + this.X + ", " + this.Y + ASCIIPropertyListParser.f18650h;
    }
}
