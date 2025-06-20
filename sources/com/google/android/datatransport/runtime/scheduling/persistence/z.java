package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class z implements SQLiteEventStore.Producer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SchemaManager f19695a;

    public /* synthetic */ z(SchemaManager schemaManager) {
        this.f19695a = schemaManager;
    }

    public final Object a() {
        return this.f19695a.getWritableDatabase();
    }
}
