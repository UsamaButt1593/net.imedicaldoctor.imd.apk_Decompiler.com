package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class p implements SQLiteEventStore.Function {
    public final Object apply(Object obj) {
        return SQLiteEventStore.D0((SQLiteDatabase) obj);
    }
}
