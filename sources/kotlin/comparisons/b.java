package kotlin.comparisons;

import java.util.Comparator;

public final /* synthetic */ class b implements Comparator {
    public final /* synthetic */ Comparator X;
    public final /* synthetic */ Comparator s;

    public /* synthetic */ b(Comparator comparator, Comparator comparator2) {
        this.s = comparator;
        this.X = comparator2;
    }

    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.H(this.s, this.X, obj, obj2);
    }
}
