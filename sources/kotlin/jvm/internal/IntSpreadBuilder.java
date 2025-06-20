package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0003*\u00020\u0002H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0006J\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lkotlin/jvm/internal/IntSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "", "size", "<init>", "(I)V", "i", "([I)I", "value", "", "h", "j", "()[I", "d", "[I", "values", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class IntSpreadBuilder extends PrimitiveSpreadBuilder<int[]> {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final int[] f28950d;

    public IntSpreadBuilder(int i2) {
        super(i2);
        this.f28950d = new int[i2];
    }

    public final void h(int i2) {
        int[] iArr = this.f28950d;
        int b2 = b();
        e(b2 + 1);
        iArr[b2] = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public int c(@NotNull int[] iArr) {
        Intrinsics.p(iArr, "<this>");
        return iArr.length;
    }

    @NotNull
    public final int[] j() {
        return (int[]) g(this.f28950d, new int[f()]);
    }
}
