package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.g  reason: case insensitive filesystem */
public final /* synthetic */ class C0382g implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f19674a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f19675b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ClientMetrics.Builder f19676c;

    public /* synthetic */ C0382g(SQLiteEventStore sQLiteEventStore, Map map, ClientMetrics.Builder builder) {
        this.f19674a = sQLiteEventStore;
        this.f19675b = map;
        this.f19676c = builder;
    }

    public final Object apply(Object obj) {
        return this.f19674a.J0(this.f19675b, this.f19676c, (Cursor) obj);
    }
}
