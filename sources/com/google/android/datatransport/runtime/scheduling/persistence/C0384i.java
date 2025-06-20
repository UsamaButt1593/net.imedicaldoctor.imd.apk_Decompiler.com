package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.i  reason: case insensitive filesystem */
public final /* synthetic */ class C0384i implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f19679a;

    public /* synthetic */ C0384i(SQLiteEventStore sQLiteEventStore) {
        this.f19679a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.f19679a.X0((SQLiteDatabase) obj);
    }
}
