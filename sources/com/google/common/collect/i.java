package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.util.Collection;

public final /* synthetic */ class i implements Maps.EntryTransformer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Multimaps.TransformedEntriesMultimap f22517a;

    public /* synthetic */ i(Multimaps.TransformedEntriesMultimap transformedEntriesMultimap) {
        this.f22517a = transformedEntriesMultimap;
    }

    public final Object a(Object obj, Object obj2) {
        return this.f22517a.n(obj, (Collection) obj2);
    }
}
