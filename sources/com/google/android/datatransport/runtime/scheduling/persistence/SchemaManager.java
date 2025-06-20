package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

final class SchemaManager extends SQLiteOpenHelper {
    private static final String X2 = "CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)";
    static final String Y = "com.google.android.datatransport.events";
    private static final String Y2 = "CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)";
    private static final String Z = "CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)";
    private static final String Z2 = "CREATE INDEX events_backend_id on events(context_id)";
    private static final String a3 = "CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)";
    private static final String b3 = "DROP TABLE events";
    private static final String c3 = "DROP TABLE event_metadata";
    private static final String d3 = "DROP TABLE transport_contexts";
    private static final String e3 = "CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))";
    private static final String f3 = "DROP TABLE IF EXISTS event_payloads";
    private static final String g3 = "CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))";
    private static final String h3 = "CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)";
    private static final String i3 = ("INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")");
    private static final String j3 = "DROP TABLE IF EXISTS log_event_dropped";
    private static final String k3 = "DROP TABLE IF EXISTS global_log_event_state";
    static int l3 = 7;
    private static final Migration m3;
    private static final Migration n3;
    private static final Migration o3;
    private static final Migration p3;
    private static final Migration q3;
    private static final Migration r3;
    private static final Migration s3;
    private static final List<Migration> t3;
    private boolean X = false;
    private final int s;

    public interface Migration {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        C c2 = new C();
        m3 = c2;
        D d2 = new D();
        n3 = d2;
        E e2 = new E();
        o3 = e2;
        F f2 = new F();
        p3 = f2;
        G g2 = new G();
        q3 = g2;
        H h2 = new H();
        r3 = h2;
        I i2 = new I();
        s3 = i2;
        t3 = Arrays.asList(new Migration[]{c2, d2, e2, f2, g2, h2, i2});
    }

    @Inject
    SchemaManager(Context context, @Named("SQLITE_DB_NAME") String str, @Named("SCHEMA_VERSION") int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        this.s = i2;
    }

    private void k(SQLiteDatabase sQLiteDatabase) {
        if (!this.X) {
            onConfigure(sQLiteDatabase);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void n(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(Z);
        sQLiteDatabase.execSQL(X2);
        sQLiteDatabase.execSQL(Y2);
        sQLiteDatabase.execSQL(Z2);
        sQLiteDatabase.execSQL(a3);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void p(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void r(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL(f3);
        sQLiteDatabase.execSQL(e3);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void s(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(j3);
        sQLiteDatabase.execSQL(k3);
        sQLiteDatabase.execSQL(g3);
        sQLiteDatabase.execSQL(h3);
        sQLiteDatabase.execSQL(i3);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void u(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN pseudonymous_id TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_clear_blob BLOB");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_encrypted_blob BLOB");
    }

    private void v(SQLiteDatabase sQLiteDatabase, int i2) {
        k(sQLiteDatabase);
        w(sQLiteDatabase, 0, i2);
    }

    private void w(SQLiteDatabase sQLiteDatabase, int i2, int i4) {
        List<Migration> list = t3;
        if (i4 <= list.size()) {
            while (i2 < i4) {
                t3.get(i2).a(sQLiteDatabase);
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i2 + " to " + i4 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.X = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        v(sQLiteDatabase, this.s);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i4) {
        sQLiteDatabase.execSQL(b3);
        sQLiteDatabase.execSQL(c3);
        sQLiteDatabase.execSQL(d3);
        sQLiteDatabase.execSQL(f3);
        sQLiteDatabase.execSQL(j3);
        sQLiteDatabase.execSQL(k3);
        v(sQLiteDatabase, i4);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        k(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i4) {
        k(sQLiteDatabase);
        w(sQLiteDatabase, i2, i4);
    }
}
