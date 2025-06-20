package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/ranges/ClosedRange;", "", "T", "", "value", "", "b", "(Ljava/lang/Comparable;)Z", "isEmpty", "()Z", "c", "()Ljava/lang/Comparable;", "start", "h", "endInclusive", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public interface ClosedRange<T extends Comparable<? super T>> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T extends Comparable<? super T>> boolean a(@NotNull ClosedRange<T> closedRange, @NotNull T t) {
            Intrinsics.p(t, "value");
            return t.compareTo(closedRange.c()) >= 0 && t.compareTo(closedRange.h()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(@NotNull ClosedRange<T> closedRange) {
            return closedRange.c().compareTo(closedRange.h()) > 0;
        }
    }

    boolean b(@NotNull T t);

    @NotNull
    T c();

    @NotNull
    T h();

    boolean isEmpty();
}
