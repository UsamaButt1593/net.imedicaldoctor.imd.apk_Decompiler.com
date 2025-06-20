package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class m implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f19686a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LogEventDropped.Reason f19687b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f19688c;

    public /* synthetic */ m(String str, LogEventDropped.Reason reason, long j2) {
        this.f19686a = str;
        this.f19687b = reason;
        this.f19688c = j2;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.U0(this.f19686a, this.f19687b, this.f19688c, (SQLiteDatabase) obj);
    }
}
