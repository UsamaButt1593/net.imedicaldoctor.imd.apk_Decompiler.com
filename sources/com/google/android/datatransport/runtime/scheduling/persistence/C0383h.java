package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0383h implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f19677a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TransportContext f19678b;

    public /* synthetic */ C0383h(long j2, TransportContext transportContext) {
        this.f19677a = j2;
        this.f19678b = transportContext;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.V0(this.f19677a, this.f19678b, (SQLiteDatabase) obj);
    }
}
