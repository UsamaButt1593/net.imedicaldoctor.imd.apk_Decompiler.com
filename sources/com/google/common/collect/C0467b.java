package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Map;

/* renamed from: com.google.common.collect.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0467b implements Predicate {
    public final /* synthetic */ Predicate s;

    public /* synthetic */ C0467b(Predicate predicate) {
        this.s = predicate;
    }

    public final boolean apply(Object obj) {
        return this.s.apply(Multisets.k(((Map.Entry) obj).getKey(), ((Collection) ((Map.Entry) obj).getValue()).size()));
    }
}
