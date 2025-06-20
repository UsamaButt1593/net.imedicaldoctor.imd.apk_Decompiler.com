package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

public final /* synthetic */ class j implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f19680a;

    public /* synthetic */ j(Map map) {
        this.f19680a = map;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.N0(this.f19680a, (Cursor) obj);
    }
}
