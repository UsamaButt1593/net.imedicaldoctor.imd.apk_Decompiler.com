package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.dd.plist.ASCIIPropertyListParser;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@WorkerThread
public class SQLiteEventStore implements EventStore, SynchronizationGuard, ClientHealthMetricsStore {
    private static final String Y2 = "SQLiteEventStore";
    static final int Z2 = 16;
    private static final int a3 = 50;
    private static final Encoding b3 = Encoding.b("proto");
    private final Clock X;
    private final Provider<String> X2;
    private final Clock Y;
    private final EventStoreConfig Z;
    private final SchemaManager s;

    interface Function<T, U> {
        U apply(T t);
    }

    private static class Metadata {

        /* renamed from: a  reason: collision with root package name */
        final String f19652a;

        /* renamed from: b  reason: collision with root package name */
        final String f19653b;

        private Metadata(String str, String str2) {
            this.f19652a = str;
            this.f19653b = str2;
        }
    }

    interface Producer<T> {
        T a();
    }

    @Inject
    SQLiteEventStore(@WallTime Clock clock, @Monotonic Clock clock2, EventStoreConfig eventStoreConfig, SchemaManager schemaManager, @Named("PACKAGE_NAME") Provider<String> provider) {
        this.s = schemaManager;
        this.X = clock;
        this.Y = clock2;
        this.Z = eventStoreConfig;
        this.X2 = provider;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TimeWindow A0(long j2, SQLiteDatabase sQLiteDatabase) {
        return (TimeWindow) i1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new s(j2));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Long B0(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean C0(TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        Long e0 = e0(sQLiteDatabase, transportContext);
        return e0 == null ? Boolean.FALSE : (Boolean) i1(Z().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{e0.toString()}), new w());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List D0(SQLiteDatabase sQLiteDatabase) {
        return (List) i1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new n());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List G0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(TransportContext.a().b(cursor.getString(1)).d(PriorityMapping.b(cursor.getInt(2))).c(a1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List I0(TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        List<PersistedEvent> Y0 = Y0(sQLiteDatabase, transportContext, this.Z.d());
        for (Priority priority : Priority.values()) {
            if (priority != transportContext.d()) {
                int d2 = this.Z.d() - Y0.size();
                if (d2 <= 0) {
                    break;
                }
                Y0.addAll(Y0(sQLiteDatabase, transportContext.f(priority), d2));
            }
        }
        return i0(Y0, Z0(sQLiteDatabase, Y0));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ClientMetrics J0(Map map, ClientMetrics.Builder builder, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            LogEventDropped.Reason R = R(cursor.getInt(1));
            long j2 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(LogEventDropped.d().c(R).b(j2).a());
        }
        c1(builder, map);
        return builder.f(d0()).d(a0()).c(this.X2.get()).b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ClientMetrics K0(String str, Map map, ClientMetrics.Builder builder, SQLiteDatabase sQLiteDatabase) {
        return (ClientMetrics) i1(sQLiteDatabase.rawQuery(str, new String[0]), new C0382g(this, map, builder));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object L0(List list, TransportContext transportContext, Cursor cursor) {
        while (cursor.moveToNext()) {
            boolean z = false;
            long j2 = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z = true;
            }
            EventInternal.Builder o = EventInternal.a().n(cursor.getString(1)).i(cursor.getLong(2)).o(cursor.getLong(3));
            o.h(z ? new EncodedPayload(f1(cursor.getString(4)), cursor.getBlob(5)) : new EncodedPayload(f1(cursor.getString(4)), d1(j2)));
            if (!cursor.isNull(6)) {
                o.g(Integer.valueOf(cursor.getInt(6)));
            }
            if (!cursor.isNull(8)) {
                o.l(Integer.valueOf(cursor.getInt(8)));
            }
            if (!cursor.isNull(9)) {
                o.m(cursor.getString(9));
            }
            if (!cursor.isNull(10)) {
                o.j(cursor.getBlob(10));
            }
            if (!cursor.isNull(11)) {
                o.k(cursor.getBlob(11));
            }
            list.add(PersistedEvent.a(j2, transportContext, o.d()));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object N0(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j2 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j2));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j2), set);
            }
            set.add(new Metadata(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Long P0(EventInternal eventInternal, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        if (h0()) {
            e(1, LogEventDropped.Reason.CACHE_FULL, eventInternal.p());
            return -1L;
        }
        long T = T(sQLiteDatabase, transportContext);
        int e2 = this.Z.e();
        byte[] a2 = eventInternal.e().a();
        boolean z = a2.length <= e2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(T));
        contentValues.put("transport_name", eventInternal.p());
        contentValues.put("timestamp_ms", Long.valueOf(eventInternal.f()));
        contentValues.put("uptime_ms", Long.valueOf(eventInternal.q()));
        contentValues.put("payload_encoding", eventInternal.e().b().a());
        contentValues.put(HTML.Tag.g0, eventInternal.d());
        contentValues.put("num_attempts", 0);
        contentValues.put(CSS.Value.u0, Boolean.valueOf(z));
        contentValues.put("payload", z ? a2 : new byte[0]);
        contentValues.put("product_id", eventInternal.n());
        contentValues.put("pseudonymous_id", eventInternal.o());
        contentValues.put("experiment_ids_clear_blob", eventInternal.g());
        contentValues.put("experiment_ids_encrypted_blob", eventInternal.h());
        long insert = sQLiteDatabase.insert("events", (String) null, contentValues);
        if (!z) {
            int ceil = (int) Math.ceil(((double) a2.length) / ((double) e2));
            for (int i2 = 1; i2 <= ceil; i2++) {
                byte[] copyOfRange = Arrays.copyOfRange(a2, (i2 - 1) * e2, Math.min(i2 * e2, a2.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i2));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", (String) null, contentValues2);
            }
        }
        for (Map.Entry next : eventInternal.k().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", (String) next.getKey());
            contentValues3.put("value", (String) next.getValue());
            sQLiteDatabase.insert("event_metadata", (String) null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ byte[] Q0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i2 += blob.length;
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            byte[] bArr2 = (byte[]) arrayList.get(i4);
            System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
            i3 += bArr2.length;
        }
        return bArr;
    }

    private LogEventDropped.Reason R(int i2) {
        LogEventDropped.Reason reason = LogEventDropped.Reason.REASON_UNKNOWN;
        if (i2 == reason.d()) {
            return reason;
        }
        LogEventDropped.Reason reason2 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
        if (i2 == reason2.d()) {
            return reason2;
        }
        LogEventDropped.Reason reason3 = LogEventDropped.Reason.CACHE_FULL;
        if (i2 == reason3.d()) {
            return reason3;
        }
        LogEventDropped.Reason reason4 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
        if (i2 == reason4.d()) {
            return reason4;
        }
        LogEventDropped.Reason reason5 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
        if (i2 == reason5.d()) {
            return reason5;
        }
        LogEventDropped.Reason reason6 = LogEventDropped.Reason.INVALID_PAYLOD;
        if (i2 == reason6.d()) {
            return reason6;
        }
        LogEventDropped.Reason reason7 = LogEventDropped.Reason.SERVER_ERROR;
        if (i2 == reason7.d()) {
            return reason7;
        }
        Logging.c(Y2, "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i2));
        return reason;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object R0(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i2 = cursor.getInt(0);
            e((long) i2, LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    private void S(SQLiteDatabase sQLiteDatabase) {
        e1(new u(sQLiteDatabase), new v());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object S0(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        i1(sQLiteDatabase.rawQuery(str2, (String[]) null), new B(this));
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    private long T(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Long e0 = e0(sQLiteDatabase, transportContext);
        if (e0 != null) {
            return e0.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", transportContext.b());
        contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext.d())));
        contentValues.put("next_request_ms", 0);
        if (transportContext.c() != null) {
            contentValues.put("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Boolean T0(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object U0(String str, LogEventDropped.Reason reason, long j2, SQLiteDatabase sQLiteDatabase) {
        if (!((Boolean) i1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.d())}), new C0379d())).booleanValue()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(reason.d()));
            contentValues.put("events_dropped_count", Long.valueOf(j2));
            sQLiteDatabase.insert("log_event_dropped", (String) null, contentValues);
        } else {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j2 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.d())});
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object V0(long j2, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j2));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))}) < 1) {
            contentValues.put("backend_name", transportContext.b());
            contentValues.put("priority", Integer.valueOf(PriorityMapping.a(transportContext.d())));
            sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object X0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.X.a()).execute();
        return null;
    }

    private List<PersistedEvent> Y0(SQLiteDatabase sQLiteDatabase, TransportContext transportContext, int i2) {
        ArrayList arrayList = new ArrayList();
        Long e0 = e0(sQLiteDatabase, transportContext);
        if (e0 == null) {
            return arrayList;
        }
        i1(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", HTML.Tag.g0, CSS.Value.u0, "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{e0.toString()}, (String) null, (String) null, (String) null, String.valueOf(i2)), new C0377b(this, arrayList, transportContext));
        return arrayList;
    }

    private Map<Long, Set<Metadata>> Z0(SQLiteDatabase sQLiteDatabase, List<PersistedEvent> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(list.get(i2).c());
            if (i2 < list.size() - 1) {
                sb.append(ASCIIPropertyListParser.f18651i);
            }
        }
        sb.append(ASCIIPropertyListParser.f18650h);
        i1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), (String[]) null, (String) null, (String) null, (String) null), new j(hashMap));
        return hashMap;
    }

    private GlobalMetrics a0() {
        return GlobalMetrics.d().b(StorageMetrics.d().b(W()).c(EventStoreConfig.f19647f.f()).a()).a();
    }

    private static byte[] a1(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private long c0() {
        return Z().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private void c1(ClientMetrics.Builder builder, Map<String, List<LogEventDropped>> map) {
        for (Map.Entry next : map.entrySet()) {
            builder.a(LogSourceMetrics.d().d((String) next.getKey()).c((List) next.getValue()).b());
        }
    }

    private TimeWindow d0() {
        return (TimeWindow) g0(new q(this.X.a()));
    }

    private byte[] d1(long j2) {
        return (byte[]) i1(Z().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j2)}, (String) null, (String) null, "sequence_num"), new o());
    }

    @Nullable
    private Long e0(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))}));
        if (transportContext.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) i1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), (String) null, (String) null, (String) null), new C0378c());
    }

    private <T> T e1(Producer<T> producer, Function<Throwable, T> function) {
        long a2 = this.Y.a();
        while (true) {
            try {
                return producer.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.Y.a() >= ((long) this.Z.b()) + a2) {
                    return function.apply(e2);
                }
                SystemClock.sleep(50);
            }
        }
    }

    private static Encoding f1(@Nullable String str) {
        return str == null ? b3 : Encoding.b(str);
    }

    private long getPageSize() {
        return Z().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private boolean h0() {
        return c0() * getPageSize() >= this.Z.f();
    }

    private static String h1(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it2 = iterable.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next().c());
            if (it2.hasNext()) {
                sb.append(ASCIIPropertyListParser.f18651i);
            }
        }
        sb.append(ASCIIPropertyListParser.f18650h);
        return sb.toString();
    }

    private List<PersistedEvent> i0(List<PersistedEvent> list, Map<Long, Set<Metadata>> map) {
        ListIterator<PersistedEvent> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            PersistedEvent next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                EventInternal.Builder r = next.b().r();
                for (Metadata metadata : map.get(Long.valueOf(next.c()))) {
                    r.c(metadata.f19652a, metadata.f19653b);
                }
                listIterator.set(PersistedEvent.a(next.c(), next.d(), r.d()));
            }
        }
        return list;
    }

    @VisibleForTesting
    static <T> T i1(Cursor cursor, Function<Cursor, T> function) {
        try {
            return function.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object j0(Cursor cursor) {
        while (cursor.moveToNext()) {
            int i2 = cursor.getInt(0);
            e((long) i2, LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer k0(long j2, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j2)};
        i1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new t(this));
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object m0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete("events", (String) null, new String[0]);
        sQLiteDatabase.delete("transport_contexts", (String) null, new String[0]);
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object q0(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ SQLiteDatabase r0(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Long s0(Cursor cursor) {
        return Long.valueOf(cursor.moveToNext() ? cursor.getLong(0) : 0);
    }

    public void B2(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            g0(new l(this, "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + h1(iterable), "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name"));
        }
    }

    public void D(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            Z().compileStatement("DELETE FROM events WHERE _id in " + h1(iterable)).execute();
        }
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void Q() {
        g0(new x());
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public long W() {
        return c0() * getPageSize();
    }

    public Iterable<PersistedEvent> X(TransportContext transportContext) {
        return (Iterable) g0(new y(this, transportContext));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public SQLiteDatabase Z() {
        SchemaManager schemaManager = this.s;
        Objects.requireNonNull(schemaManager);
        return (SQLiteDatabase) e1(new z(schemaManager), new A());
    }

    public void b() {
        g0(new C0384i(this));
    }

    @Nullable
    public PersistedEvent b2(TransportContext transportContext, EventInternal eventInternal) {
        Logging.e(Y2, "Storing event with priority=%s, name=%s for destination %s", transportContext.d(), eventInternal.p(), transportContext.b());
        long longValue = ((Long) g0(new C0380e(this, eventInternal, transportContext))).longValue();
        if (longValue < 1) {
            return null;
        }
        return PersistedEvent.a(longValue, transportContext, eventInternal);
    }

    public <T> T c(SynchronizationGuard.CriticalSection<T> criticalSection) {
        SQLiteDatabase Z3 = Z();
        S(Z3);
        try {
            T execute = criticalSection.execute();
            Z3.setTransactionSuccessful();
            return execute;
        } finally {
            Z3.endTransaction();
        }
    }

    public void close() {
        this.s.close();
    }

    public ClientMetrics d() {
        return (ClientMetrics) g0(new C0376a(this, "SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new HashMap(), ClientMetrics.h()));
    }

    public void e(long j2, LogEventDropped.Reason reason, String str) {
        g0(new m(str, reason, j2));
    }

    public void f0(TransportContext transportContext, long j2) {
        g0(new C0383h(j2, transportContext));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public <T> T g0(Function<SQLiteDatabase, T> function) {
        SQLiteDatabase Z3 = Z();
        Z3.beginTransaction();
        try {
            T apply = function.apply(Z3);
            Z3.setTransactionSuccessful();
            return apply;
        } finally {
            Z3.endTransaction();
        }
    }

    public long m2(TransportContext transportContext) {
        return ((Long) i1(Z().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(PriorityMapping.a(transportContext.d()))}), new r())).longValue();
    }

    public int o() {
        return ((Integer) g0(new k(this, this.X.a() - this.Z.c()))).intValue();
    }

    public Iterable<TransportContext> t0() {
        return (Iterable) g0(new p());
    }

    public boolean u2(TransportContext transportContext) {
        return ((Boolean) g0(new C0381f(this, transportContext))).booleanValue();
    }
}
