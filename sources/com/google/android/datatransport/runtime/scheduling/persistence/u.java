package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class u implements SQLiteEventStore.Producer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteDatabase f19692a;

    public /* synthetic */ u(SQLiteDatabase sQLiteDatabase) {
        this.f19692a = sQLiteDatabase;
    }

    public final Object a() {
        return this.f19692a.beginTransaction();
    }
}
