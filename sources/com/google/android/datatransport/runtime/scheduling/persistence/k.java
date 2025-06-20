package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class k implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f19681a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f19682b;

    public /* synthetic */ k(SQLiteEventStore sQLiteEventStore, long j2) {
        this.f19681a = sQLiteEventStore;
        this.f19682b = j2;
    }

    public final Object apply(Object obj) {
        return this.f19681a.k0(this.f19682b, (SQLiteDatabase) obj);
    }
}
