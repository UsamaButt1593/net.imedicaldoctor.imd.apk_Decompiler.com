package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0003*\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lkotlin/jvm/internal/LongSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "", "size", "<init>", "(I)V", "i", "([J)I", "", "value", "", "h", "(J)V", "j", "()[J", "d", "[J", "values", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class LongSpreadBuilder extends PrimitiveSpreadBuilder<long[]> {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final long[] f28956d;

    public LongSpreadBuilder(int i2) {
        super(i2);
        this.f28956d = new long[i2];
    }

    public final void h(long j2) {
        long[] jArr = this.f28956d;
        int b2 = b();
        e(b2 + 1);
        jArr[b2] = j2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public int c(@NotNull long[] jArr) {
        Intrinsics.p(jArr, "<this>");
        return jArr.length;
    }

    @NotNull
    public final long[] j() {
        return (long[]) g(this.f28956d, new long[f()]);
    }
}
