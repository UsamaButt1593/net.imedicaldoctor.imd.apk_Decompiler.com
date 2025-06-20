package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

/* renamed from: com.google.android.datatransport.runtime.scheduling.persistence.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0376a implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteEventStore f19662a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f19663b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f19664c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClientMetrics.Builder f19665d;

    public /* synthetic */ C0376a(SQLiteEventStore sQLiteEventStore, String str, Map map, ClientMetrics.Builder builder) {
        this.f19662a = sQLiteEventStore;
        this.f19663b = str;
        this.f19664c = map;
        this.f19665d = builder;
    }

    public final Object apply(Object obj) {
        return this.f19662a.K0(this.f19663b, this.f19664c, this.f19665d, (SQLiteDatabase) obj);
    }
}
