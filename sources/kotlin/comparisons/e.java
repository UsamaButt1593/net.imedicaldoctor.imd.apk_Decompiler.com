package kotlin.comparisons;

import java.util.Comparator;

public final /* synthetic */ class e implements Comparator {
    public final /* synthetic */ Comparator s;

    public /* synthetic */ e(Comparator comparator) {
        this.s = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.t(this.s, obj, obj2);
    }
}
