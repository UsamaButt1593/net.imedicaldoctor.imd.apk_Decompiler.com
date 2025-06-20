package kotlin.text;

import kotlin.Metadata;
import kotlin.collections.CharIterator;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"kotlin/text/StringsKt__StringsKt$iterator$1", "Lkotlin/collections/CharIterator;", "", "b", "()C", "", "hasNext", "()Z", "", "s", "I", "index", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class StringsKt__StringsKt$iterator$1 extends CharIterator {
    final /* synthetic */ CharSequence X;
    private int s;

    StringsKt__StringsKt$iterator$1(CharSequence charSequence) {
        this.X = charSequence;
    }

    public char b() {
        CharSequence charSequence = this.X;
        int i2 = this.s;
        this.s = i2 + 1;
        return charSequence.charAt(i2);
    }

    public boolean hasNext() {
        return this.s < this.X.length();
    }
}
