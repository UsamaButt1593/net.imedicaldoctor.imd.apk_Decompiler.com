package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class l implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f19683a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f19684b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f19685c;

    public /* synthetic */ l(SQLiteEventStore sQLiteEventStore, String str, String str2) {
        this.f19683a = sQLiteEventStore;
        this.f19684b = str;
        this.f19685c = str2;
    }

    public final Object apply(Object obj) {
        return this.f19683a.S0(this.f19684b, this.f19685c, (SQLiteDatabase) obj);
    }
}
