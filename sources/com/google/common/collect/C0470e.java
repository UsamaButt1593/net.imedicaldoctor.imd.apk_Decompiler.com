package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;

/* renamed from: com.google.common.collect.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0470e implements Comparator {
    public final /* synthetic */ Comparator s;

    public /* synthetic */ C0470e(Comparator comparator) {
        this.s = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return ImmutableSortedMap.v0(this.s, (Map.Entry) obj, (Map.Entry) obj2);
    }
}
