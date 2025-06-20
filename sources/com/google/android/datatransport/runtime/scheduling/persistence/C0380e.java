package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0380e implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f19669a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EventInternal f19670b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f19671c;

    public /* synthetic */ C0380e(SQLiteEventStore sQLiteEventStore, EventInternal eventInternal, TransportContext transportContext) {
        this.f19669a = sQLiteEventStore;
        this.f19670b = eventInternal;
        this.f19671c = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f19669a.P0(this.f19670b, this.f19671c, (SQLiteDatabase) obj);
    }
}
