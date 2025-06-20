package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class B implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f19641a;

    public /* synthetic */ B(SQLiteEventStore sQLiteEventStore) {
        this.f19641a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f19641a.R0((Cursor) obj);
    }
}
