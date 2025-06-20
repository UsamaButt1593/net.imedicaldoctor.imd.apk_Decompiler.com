package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010(\n\u0002\u0010\f\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "b", "()Ljava/util/Iterator;"}, k = 3, mv = {1, 9, 0})
final class StringsKt___StringsKt$withIndex$1 extends Lambda implements Function0<Iterator<? extends Character>> {
    final /* synthetic */ CharSequence X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt___StringsKt$withIndex$1(CharSequence charSequence) {
        super(0);
        this.X = charSequence;
    }

    @NotNull
    /* renamed from: b */
    public final Iterator<Character> o() {
        return StringsKt__StringsKt.z3(this.X);
    }
}
