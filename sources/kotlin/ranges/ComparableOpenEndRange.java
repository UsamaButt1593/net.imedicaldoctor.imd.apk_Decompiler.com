package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.OpenEndRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00028\u00008\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00028\u00008\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/ComparableOpenEndRange;", "", "T", "Lkotlin/ranges/OpenEndRange;", "start", "endExclusive", "<init>", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "s", "Ljava/lang/Comparable;", "c", "()Ljava/lang/Comparable;", "X", "g", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
class ComparableOpenEndRange<T extends Comparable<? super T>> implements OpenEndRange<T> {
    @NotNull
    private final T X;
    @NotNull
    private final T s;

    public ComparableOpenEndRange(@NotNull T t, @NotNull T t2) {
        Intrinsics.p(t, "start");
        Intrinsics.p(t2, "endExclusive");
        this.s = t;
        this.X = t2;
    }

    public boolean b(@NotNull T t) {
        return OpenEndRange.DefaultImpls.a(this, t);
    }

    @NotNull
    public T c() {
        return this.s;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ComparableOpenEndRange) {
            if (!isEmpty() || !((ComparableOpenEndRange) obj).isEmpty()) {
                ComparableOpenEndRange comparableOpenEndRange = (ComparableOpenEndRange) obj;
                if (!Intrinsics.g(c(), comparableOpenEndRange.c()) || !Intrinsics.g(g(), comparableOpenEndRange.g())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @NotNull
    public T g() {
        return this.X;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (c().hashCode() * 31) + g().hashCode();
    }

    public boolean isEmpty() {
        return OpenEndRange.DefaultImpls.b(this);
    }

    @NotNull
    public String toString() {
        return c() + "..<" + g();
    }
}
