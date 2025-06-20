package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.List;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0377b implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f19666a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f19667b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TransportContext f19668c;

    public /* synthetic */ C0377b(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        this.f19666a = sQLiteEventStore;
        this.f19667b = list;
        this.f19668c = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f19666a.L0(this.f19667b, this.f19668c, (Cursor) obj);
    }
}
