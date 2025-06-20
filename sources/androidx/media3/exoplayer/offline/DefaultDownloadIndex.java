package androidx.media3.exoplayer.offline;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.database.VersionTable;
import androidx.media3.exoplayer.offline.DownloadRequest;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
public final class DefaultDownloadIndex implements WritableDownloadIndex {
    private static final int A = 4;
    private static final int B = 5;
    private static final int C = 6;
    private static final int D = 7;
    private static final int E = 8;
    private static final int F = 9;
    private static final int G = 10;
    private static final int H = 11;
    private static final int I = 12;
    private static final int J = 13;
    private static final int K = 14;
    private static final String L = "id = ?";
    private static final String M = "state = 2";
    private static final String N = p(3, 4);
    private static final String[] O = {"id", f11742i, f11743j, f11744k, f11745l, "data", f11747n, o, p, q, "stop_reason", s, t, u, v};
    private static final String P = "(id TEXT PRIMARY KEY NOT NULL,mime_type TEXT,uri TEXT NOT NULL,stream_keys TEXT NOT NULL,custom_cache_key TEXT,data BLOB NOT NULL,state INTEGER NOT NULL,start_time_ms INTEGER NOT NULL,update_time_ms INTEGER NOT NULL,content_length INTEGER NOT NULL,stop_reason INTEGER NOT NULL,failure_reason INTEGER NOT NULL,percent_downloaded REAL NOT NULL,bytes_downloaded INTEGER NOT NULL,key_set_id BLOB NOT NULL)";
    private static final String Q = "1";

    /* renamed from: f  reason: collision with root package name */
    private static final String f11739f = "ExoPlayerDownloads";
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    static final int f11740g = 3;

    /* renamed from: h  reason: collision with root package name */
    private static final String f11741h = "id";

    /* renamed from: i  reason: collision with root package name */
    private static final String f11742i = "mime_type";

    /* renamed from: j  reason: collision with root package name */
    private static final String f11743j = "uri";

    /* renamed from: k  reason: collision with root package name */
    private static final String f11744k = "stream_keys";

    /* renamed from: l  reason: collision with root package name */
    private static final String f11745l = "custom_cache_key";

    /* renamed from: m  reason: collision with root package name */
    private static final String f11746m = "data";

    /* renamed from: n  reason: collision with root package name */
    private static final String f11747n = "state";
    private static final String o = "start_time_ms";
    private static final String p = "update_time_ms";
    private static final String q = "content_length";
    private static final String r = "stop_reason";
    private static final String s = "failure_reason";
    private static final String t = "percent_downloaded";
    private static final String u = "bytes_downloaded";
    private static final String v = "key_set_id";
    private static final int w = 0;
    private static final int x = 1;
    private static final int y = 2;
    private static final int z = 3;

    /* renamed from: a  reason: collision with root package name */
    private final String f11748a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11749b;

    /* renamed from: c  reason: collision with root package name */
    private final DatabaseProvider f11750c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f11751d;
    @GuardedBy("initializationLock")

    /* renamed from: e  reason: collision with root package name */
    private boolean f11752e;

    private static final class DownloadCursorImpl implements DownloadCursor {
        private final Cursor s;

        private DownloadCursorImpl(Cursor cursor) {
            this.s = cursor;
        }

        public void close() {
            this.s.close();
        }

        public int getCount() {
            return this.s.getCount();
        }

        public int getPosition() {
            return this.s.getPosition();
        }

        public Download i2() {
            return DefaultDownloadIndex.n(this.s);
        }

        public /* synthetic */ boolean isAfterLast() {
            return a.a(this);
        }

        public /* synthetic */ boolean isBeforeFirst() {
            return a.b(this);
        }

        public boolean isClosed() {
            return this.s.isClosed();
        }

        public /* synthetic */ boolean isFirst() {
            return a.c(this);
        }

        public /* synthetic */ boolean isLast() {
            return a.d(this);
        }

        public /* synthetic */ boolean moveToFirst() {
            return a.e(this);
        }

        public /* synthetic */ boolean moveToLast() {
            return a.f(this);
        }

        public /* synthetic */ boolean moveToNext() {
            return a.g(this);
        }

        public boolean moveToPosition(int i2) {
            return this.s.moveToPosition(i2);
        }

        public /* synthetic */ boolean moveToPrevious() {
            return a.h(this);
        }
    }

    public DefaultDownloadIndex(DatabaseProvider databaseProvider) {
        this(databaseProvider, "");
    }

    private static List<StreamKey> j(@Nullable String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String p2 : Util.p2(str, ",")) {
            String[] p22 = Util.p2(p2, "\\.");
            Assertions.i(p22.length == 3);
            arrayList.add(new StreamKey(Integer.parseInt(p22[0]), Integer.parseInt(p22[1]), Integer.parseInt(p22[2])));
        }
        return arrayList;
    }

    @VisibleForTesting
    static String k(List<StreamKey> list) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            StreamKey streamKey = list.get(i2);
            sb.append(streamKey.s);
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            sb.append(streamKey.X);
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            sb.append(streamKey.Y);
            sb.append(ASCIIPropertyListParser.f18651i);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private void l() throws DatabaseIOException {
        SQLiteDatabase writableDatabase;
        synchronized (this.f11751d) {
            if (!this.f11752e) {
                try {
                    int b2 = VersionTable.b(this.f11750c.getReadableDatabase(), 0, this.f11748a);
                    if (b2 != 3) {
                        writableDatabase = this.f11750c.getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        VersionTable.d(writableDatabase, 0, this.f11748a, 3);
                        List<Download> r2 = b2 == 2 ? r(writableDatabase) : new ArrayList<>();
                        writableDatabase.execSQL("DROP TABLE IF EXISTS " + this.f11749b);
                        writableDatabase.execSQL("CREATE TABLE " + this.f11749b + StringUtils.SPACE + P);
                        for (Download s2 : r2) {
                            s(s2, writableDatabase);
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    }
                    this.f11752e = true;
                } catch (SQLException e2) {
                    throw new DatabaseIOException(e2);
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        }
    }

    private Cursor m(String str, @Nullable String[] strArr) throws DatabaseIOException {
        try {
            return this.f11750c.getReadableDatabase().query(this.f11749b, O, str, strArr, (String) null, (String) null, "start_time_ms ASC");
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    /* access modifiers changed from: private */
    public static Download n(Cursor cursor) {
        byte[] blob = cursor.getBlob(14);
        DownloadRequest.Builder f2 = new DownloadRequest.Builder((String) Assertions.g(cursor.getString(0)), Uri.parse((String) Assertions.g(cursor.getString(2)))).e(cursor.getString(1)).f(j(cursor.getString(3)));
        if (blob.length <= 0) {
            blob = null;
        }
        DownloadRequest a2 = f2.d(blob).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.f11818a = cursor.getLong(13);
        downloadProgress.f11819b = cursor.getFloat(12);
        int i2 = cursor.getInt(6);
        return new Download(a2, i2, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i2 == 4 ? cursor.getInt(11) : 0, downloadProgress);
    }

    private static Download o(Cursor cursor) {
        DownloadRequest a2 = new DownloadRequest.Builder((String) Assertions.g(cursor.getString(0)), Uri.parse((String) Assertions.g(cursor.getString(2)))).e(q(cursor.getString(1))).f(j(cursor.getString(3))).b(cursor.getString(4)).c(cursor.getBlob(5)).a();
        DownloadProgress downloadProgress = new DownloadProgress();
        downloadProgress.f11818a = cursor.getLong(13);
        downloadProgress.f11819b = cursor.getFloat(12);
        int i2 = cursor.getInt(6);
        return new Download(a2, i2, cursor.getLong(7), cursor.getLong(8), cursor.getLong(9), cursor.getInt(10), i2 == 4 ? cursor.getInt(11) : 0, downloadProgress);
    }

    private static String p(int... iArr) {
        if (iArr.length == 0) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f11747n);
        sb.append(" IN (");
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 > 0) {
                sb.append(ASCIIPropertyListParser.f18651i);
            }
            sb.append(iArr[i2]);
        }
        sb.append(ASCIIPropertyListParser.f18650h);
        return sb.toString();
    }

    private static String q(@Nullable String str) {
        if ("dash".equals(str)) {
            return MimeTypes.s0;
        }
        if ("hls".equals(str)) {
            return MimeTypes.t0;
        }
        return "ss".equals(str) ? MimeTypes.u0 : MimeTypes.D;
    }

    private List<Download> r(SQLiteDatabase sQLiteDatabase) {
        Throwable th;
        ArrayList arrayList = new ArrayList();
        if (!Util.v2(sQLiteDatabase, this.f11749b)) {
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        Cursor query = sQLiteDatabase2.query(this.f11749b, new String[]{"id", "title", f11743j, f11744k, f11745l, "data", f11747n, o, p, q, "stop_reason", s, t, u}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        while (query.moveToNext()) {
            try {
                arrayList.add(o(query));
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        query.close();
        return arrayList;
        throw th;
    }

    private void s(Download download, SQLiteDatabase sQLiteDatabase) {
        byte[] bArr = download.f11762a.X2;
        if (bArr == null) {
            bArr = Util.f9651f;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", download.f11762a.s);
        contentValues.put(f11742i, download.f11762a.Y);
        contentValues.put(f11743j, download.f11762a.X.toString());
        contentValues.put(f11744k, k(download.f11762a.Z));
        contentValues.put(f11745l, download.f11762a.Y2);
        contentValues.put("data", download.f11762a.Z2);
        contentValues.put(f11747n, Integer.valueOf(download.f11763b));
        contentValues.put(o, Long.valueOf(download.f11764c));
        contentValues.put(p, Long.valueOf(download.f11765d));
        contentValues.put(q, Long.valueOf(download.f11766e));
        contentValues.put("stop_reason", Integer.valueOf(download.f11767f));
        contentValues.put(s, Integer.valueOf(download.f11768g));
        contentValues.put(t, Float.valueOf(download.b()));
        contentValues.put(u, Long.valueOf(download.a()));
        contentValues.put(v, bArr);
        sQLiteDatabase.replaceOrThrow(this.f11749b, (String) null, contentValues);
    }

    public DownloadCursor a(int... iArr) throws DatabaseIOException {
        l();
        return new DownloadCursorImpl(m(p(iArr), (String[]) null));
    }

    public void b() throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(f11747n, 5);
            contentValues.put(s, 0);
            this.f11750c.getWritableDatabase().update(this.f11749b, contentValues, (String) null, (String[]) null);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public void c(String str, int i2) throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i2));
            SQLiteDatabase writableDatabase = this.f11750c.getWritableDatabase();
            String str2 = this.f11749b;
            writableDatabase.update(str2, contentValues, N + " AND " + L, new String[]{str});
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public void d(Download download) throws DatabaseIOException {
        l();
        try {
            s(download, this.f11750c.getWritableDatabase());
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public void e() throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(f11747n, 0);
            this.f11750c.getWritableDatabase().update(this.f11749b, contentValues, M, (String[]) null);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    @Nullable
    public Download f(String str) throws DatabaseIOException {
        Cursor m2;
        l();
        try {
            m2 = m(L, new String[]{str});
            if (m2.getCount() == 0) {
                m2.close();
                return null;
            }
            m2.moveToNext();
            Download n2 = n(m2);
            m2.close();
            return n2;
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void g(String str) throws DatabaseIOException {
        l();
        try {
            this.f11750c.getWritableDatabase().delete(this.f11749b, L, new String[]{str});
        } catch (SQLiteException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public void h(int i2) throws DatabaseIOException {
        l();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("stop_reason", Integer.valueOf(i2));
            this.f11750c.getWritableDatabase().update(this.f11749b, contentValues, N, (String[]) null);
        } catch (SQLException e2) {
            throw new DatabaseIOException(e2);
        }
    }

    public DefaultDownloadIndex(DatabaseProvider databaseProvider, String str) {
        this.f11748a = str;
        this.f11750c = databaseProvider;
        this.f11749b = f11739f + str;
        this.f11751d = new Object();
    }
}
