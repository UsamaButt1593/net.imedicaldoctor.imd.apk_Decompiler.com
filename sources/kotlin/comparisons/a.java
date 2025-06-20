package kotlin.comparisons;

import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final /* synthetic */ Comparator s;

    public /* synthetic */ a(Comparator comparator) {
        this.s = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.w(this.s, obj, obj2);
    }
}
