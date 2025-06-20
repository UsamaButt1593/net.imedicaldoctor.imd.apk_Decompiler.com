package com.google.common.collect;

import java.util.Comparator;

/* renamed from: com.google.common.collect.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0471f implements Comparator {
    public final /* synthetic */ Comparator s;

    public /* synthetic */ C0471f(Comparator comparator) {
        this.s = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return this.s.compare(((PeekingIterator) obj).peek(), ((PeekingIterator) obj2).peek());
    }
}
