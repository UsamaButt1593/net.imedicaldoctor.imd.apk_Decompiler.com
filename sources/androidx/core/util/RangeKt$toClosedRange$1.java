package androidx.core.util;

import android.util.Range;
import kotlin.Metadata;
import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001R\u001c\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00018\u00008\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00018\u00008\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\b"}, d2 = {"androidx/core/util/RangeKt$toClosedRange$1", "Lkotlin/ranges/ClosedRange;", "kotlin.jvm.PlatformType", "h", "()Ljava/lang/Comparable;", "endInclusive", "c", "start", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class RangeKt$toClosedRange$1 implements ClosedRange<T> {
    final /* synthetic */ Range<T> s;

    RangeKt$toClosedRange$1(Range<T> range) {
        this.s = range;
    }

    public boolean b(@NotNull T t) {
        return ClosedRange.DefaultImpls.a(this, t);
    }

    public T c() {
        return this.s.getLower();
    }

    public T h() {
        return this.s.getUpper();
    }

    public boolean isEmpty() {
        return ClosedRange.DefaultImpls.b(this);
    }
}
