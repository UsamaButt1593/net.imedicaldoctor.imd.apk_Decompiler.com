package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010(\n\u0002\u0010\n\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "b", "()Ljava/util/Iterator;"}, k = 3, mv = {1, 9, 0})
final class ArraysKt___ArraysKt$withIndex$3 extends Lambda implements Function0<Iterator<? extends Short>> {
    final /* synthetic */ short[] X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ArraysKt___ArraysKt$withIndex$3(short[] sArr) {
        super(0);
        this.X = sArr;
    }

    @NotNull
    /* renamed from: b */
    public final Iterator<Short> o() {
        return ArrayIteratorsKt.h(this.X);
    }
}
