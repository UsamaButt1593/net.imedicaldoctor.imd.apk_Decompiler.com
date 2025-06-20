package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class y implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f19693a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f19694b;

    public /* synthetic */ y(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f19693a = sQLiteEventStore;
        this.f19694b = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f19693a.I0(this.f19694b, (SQLiteDatabase) obj);
    }
}
