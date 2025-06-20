package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.Comparator;

public final /* synthetic */ class k implements Comparator {
    public final /* synthetic */ Comparator X;
    public final /* synthetic */ Comparator s;

    public /* synthetic */ k(Comparator comparator, Comparator comparator2) {
        this.s = comparator;
        this.X = comparator2;
    }

    public final int compare(Object obj, Object obj2) {
        return RegularImmutableTable.O(this.s, this.X, (Table.Cell) obj, (Table.Cell) obj2);
    }
}
