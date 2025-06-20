package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class t implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f19691a;

    public /* synthetic */ t(SQLiteEventStore sQLiteEventStore) {
        this.f19691a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f19691a.j0((Cursor) obj);
    }
}
