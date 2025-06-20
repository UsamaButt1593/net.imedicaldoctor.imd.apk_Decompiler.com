package kotlin.comparisons;

import java.util.Comparator;

public final /* synthetic */ class c implements Comparator {
    public final /* synthetic */ Comparator X;
    public final /* synthetic */ Comparator s;

    public /* synthetic */ c(Comparator comparator, Comparator comparator2) {
        this.s = comparator;
        this.X = comparator2;
    }

    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.A(this.s, this.X, obj, obj2);
    }
}
