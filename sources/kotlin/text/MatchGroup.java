package kotlin.text;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Lkotlin/text/MatchGroup;", "", "", "value", "Lkotlin/ranges/IntRange;", "range", "<init>", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "a", "()Ljava/lang/String;", "b", "()Lkotlin/ranges/IntRange;", "c", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)Lkotlin/text/MatchGroup;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "f", "Lkotlin/ranges/IntRange;", "e", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class MatchGroup {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f29100a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final IntRange f29101b;

    public MatchGroup(@NotNull String str, @NotNull IntRange intRange) {
        Intrinsics.p(str, "value");
        Intrinsics.p(intRange, "range");
        this.f29100a = str;
        this.f29101b = intRange;
    }

    public static /* synthetic */ MatchGroup d(MatchGroup matchGroup, String str, IntRange intRange, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = matchGroup.f29100a;
        }
        if ((i2 & 2) != 0) {
            intRange = matchGroup.f29101b;
        }
        return matchGroup.c(str, intRange);
    }

    @NotNull
    public final String a() {
        return this.f29100a;
    }

    @NotNull
    public final IntRange b() {
        return this.f29101b;
    }

    @NotNull
    public final MatchGroup c(@NotNull String str, @NotNull IntRange intRange) {
        Intrinsics.p(str, "value");
        Intrinsics.p(intRange, "range");
        return new MatchGroup(str, intRange);
    }

    @NotNull
    public final IntRange e() {
        return this.f29101b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchGroup)) {
            return false;
        }
        MatchGroup matchGroup = (MatchGroup) obj;
        return Intrinsics.g(this.f29100a, matchGroup.f29100a) && Intrinsics.g(this.f29101b, matchGroup.f29101b);
    }

    @NotNull
    public final String f() {
        return this.f29100a;
    }

    public int hashCode() {
        return (this.f29100a.hashCode() * 31) + this.f29101b.hashCode();
    }

    @NotNull
    public String toString() {
        return "MatchGroup(value=" + this.f29100a + ", range=" + this.f29101b + ASCIIPropertyListParser.f18650h;
    }
}
