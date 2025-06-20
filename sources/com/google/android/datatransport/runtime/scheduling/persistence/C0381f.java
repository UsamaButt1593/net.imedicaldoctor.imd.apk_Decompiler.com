package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0381f implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f19672a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f19673b;

    public /* synthetic */ C0381f(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f19672a = sQLiteEventStore;
        this.f19673b = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f19672a.C0(this.f19673b, (SQLiteDatabase) obj);
    }
}
