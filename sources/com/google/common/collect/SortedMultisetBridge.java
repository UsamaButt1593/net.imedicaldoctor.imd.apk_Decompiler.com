package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Set;
import java.util.SortedSet;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
interface SortedMultisetBridge<E> extends Multiset<E> {
    /* bridge */ /* synthetic */ Set e();

    SortedSet<E> e();
}
