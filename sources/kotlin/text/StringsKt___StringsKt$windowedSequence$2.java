package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "", "index", "b", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements Function1<Integer, R> {
    final /* synthetic */ int X;
    final /* synthetic */ CharSequence Y;
    final /* synthetic */ Function1<CharSequence, R> Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt___StringsKt$windowedSequence$2(int i2, CharSequence charSequence, Function1<? super CharSequence, ? extends R> function1) {
        super(1);
        this.X = i2;
        this.Y = charSequence;
        this.Z = function1;
    }

    public final R b(int i2) {
        int i3 = this.X + i2;
        if (i3 < 0 || i3 > this.Y.length()) {
            i3 = this.Y.length();
        }
        return this.Z.f(this.Y.subSequence(i2, i3));
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        return b(((Number) obj).intValue());
    }
}
