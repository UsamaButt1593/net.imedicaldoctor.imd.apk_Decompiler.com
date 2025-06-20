package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class q implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f19689a;

    public /* synthetic */ q(long j2) {
        this.f19689a = j2;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.A0(this.f19689a, (SQLiteDatabase) obj);
    }
}
