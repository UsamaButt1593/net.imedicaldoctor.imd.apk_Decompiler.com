package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements Comparator {
    public final /* synthetic */ Function1[] s;

    public /* synthetic */ d(Function1[] function1Arr) {
        this.s = function1Arr;
    }

    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.i(this.s, obj, obj2);
    }
}
