package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class s implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f19690a;

    public /* synthetic */ s(long j2) {
        this.f19690a = j2;
    }

    public final Object apply(Object obj) {
        return ((Cursor) obj).moveToNext();
    }
}
