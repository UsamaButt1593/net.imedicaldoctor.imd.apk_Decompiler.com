package androidx.media3.datasource.cache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.AtomicFile;
import androidx.media3.common.util.Util;
import androidx.media3.database.DatabaseIOException;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.database.VersionTable;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.StringUtils;

class CachedContentIndex {

    /* renamed from: g  reason: collision with root package name */
    static final String f9992g = "cached_content_index.exi";

    /* renamed from: h  reason: collision with root package name */
    private static final int f9993h = 10485760;

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, CachedContent> f9994a;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<String> f9995b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseBooleanArray f9996c;

    /* renamed from: d  reason: collision with root package name */
    private final SparseBooleanArray f9997d;

    /* renamed from: e  reason: collision with root package name */
    private Storage f9998e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Storage f9999f;

    private static final class DatabaseStorage implements Storage {

        /* renamed from: e  reason: collision with root package name */
        private static final String f10000e = "ExoPlayerCacheIndex";

        /* renamed from: f  reason: collision with root package name */
        private static final int f10001f = 1;

        /* renamed from: g  reason: collision with root package name */
        private static final String f10002g = "id";

        /* renamed from: h  reason: collision with root package name */
        private static final String f10003h = "key";

        /* renamed from: i  reason: collision with root package name */
        private static final String f10004i = "metadata";

        /* renamed from: j  reason: collision with root package name */
        private static final int f10005j = 0;

        /* renamed from: k  reason: collision with root package name */
        private static final int f10006k = 1;

        /* renamed from: l  reason: collision with root package name */
        private static final int f10007l = 2;

        /* renamed from: m  reason: collision with root package name */
        private static final String f10008m = "id = ?";

        /* renamed from: n  reason: collision with root package name */
        private static final String[] f10009n = {"id", f10003h, "metadata"};
        private static final String o = "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)";

        /* renamed from: a  reason: collision with root package name */
        private final DatabaseProvider f10010a;

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<CachedContent> f10011b = new SparseArray<>();

        /* renamed from: c  reason: collision with root package name */
        private String f10012c;

        /* renamed from: d  reason: collision with root package name */
        private String f10013d;

        public DatabaseStorage(DatabaseProvider databaseProvider) {
            this.f10010a = databaseProvider;
        }

        private void i(SQLiteDatabase sQLiteDatabase, CachedContent cachedContent) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CachedContentIndex.v(cachedContent.d(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(cachedContent.f9985a));
            contentValues.put(f10003h, cachedContent.f9986b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) Assertions.g(this.f10013d), (String) null, contentValues);
        }

        public static void j(DatabaseProvider databaseProvider, long j2) throws DatabaseIOException {
            k(databaseProvider, Long.toHexString(j2));
        }

        private static void k(DatabaseProvider databaseProvider, String str) throws DatabaseIOException {
            SQLiteDatabase writableDatabase;
            try {
                String o2 = o(str);
                writableDatabase = databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                VersionTable.c(writableDatabase, 1, str);
                m(writableDatabase, o2);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }

        private void l(SQLiteDatabase sQLiteDatabase, int i2) {
            sQLiteDatabase.delete((String) Assertions.g(this.f10013d), f10008m, new String[]{Integer.toString(i2)});
        }

        private static void m(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        private Cursor n() {
            return this.f10010a.getReadableDatabase().query((String) Assertions.g(this.f10013d), f10009n, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        }

        private static String o(String str) {
            return f10000e + str;
        }

        private void p(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            VersionTable.d(sQLiteDatabase, 1, (String) Assertions.g(this.f10012c), 1);
            m(sQLiteDatabase, (String) Assertions.g(this.f10013d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.f10013d + StringUtils.SPACE + o);
        }

        public void a() throws DatabaseIOException {
            k(this.f10010a, (String) Assertions.g(this.f10012c));
        }

        public void b(HashMap<String, CachedContent> hashMap) throws IOException {
            SQLiteDatabase writableDatabase;
            try {
                writableDatabase = this.f10010a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                p(writableDatabase);
                for (CachedContent i2 : hashMap.values()) {
                    i(writableDatabase, i2);
                }
                writableDatabase.setTransactionSuccessful();
                this.f10011b.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }

        public boolean c() throws DatabaseIOException {
            try {
                return VersionTable.b(this.f10010a.getReadableDatabase(), 1, (String) Assertions.g(this.f10012c)) != -1;
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        public void d(HashMap<String, CachedContent> hashMap) throws IOException {
            SQLiteDatabase writableDatabase;
            if (this.f10011b.size() != 0) {
                try {
                    writableDatabase = this.f10010a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    for (int i2 = 0; i2 < this.f10011b.size(); i2++) {
                        CachedContent valueAt = this.f10011b.valueAt(i2);
                        if (valueAt == null) {
                            l(writableDatabase, this.f10011b.keyAt(i2));
                        } else {
                            i(writableDatabase, valueAt);
                        }
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f10011b.clear();
                    writableDatabase.endTransaction();
                } catch (SQLException e2) {
                    throw new DatabaseIOException(e2);
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            }
        }

        public void e(long j2) {
            String hexString = Long.toHexString(j2);
            this.f10012c = hexString;
            this.f10013d = o(hexString);
        }

        public void f(CachedContent cachedContent) {
            this.f10011b.put(cachedContent.f9985a, cachedContent);
        }

        public void g(CachedContent cachedContent, boolean z) {
            if (z) {
                this.f10011b.delete(cachedContent.f9985a);
            } else {
                this.f10011b.put(cachedContent.f9985a, (Object) null);
            }
        }

        public void h(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) throws IOException {
            Cursor n2;
            SQLiteDatabase writableDatabase;
            Assertions.i(this.f10011b.size() == 0);
            try {
                if (VersionTable.b(this.f10010a.getReadableDatabase(), 1, (String) Assertions.g(this.f10012c)) != 1) {
                    writableDatabase = this.f10010a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    p(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                }
                n2 = n();
                while (n2.moveToNext()) {
                    CachedContent cachedContent = new CachedContent(n2.getInt(0), (String) Assertions.g(n2.getString(1)), CachedContentIndex.s(new DataInputStream(new ByteArrayInputStream(n2.getBlob(2)))));
                    hashMap.put(cachedContent.f9986b, cachedContent);
                    sparseArray.put(cachedContent.f9985a, cachedContent.f9986b);
                }
                n2.close();
                return;
            } catch (SQLiteException e2) {
                hashMap.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e2);
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
            throw th;
        }
    }

    private static class LegacyStorage implements Storage {

        /* renamed from: h  reason: collision with root package name */
        private static final int f10014h = 2;

        /* renamed from: i  reason: collision with root package name */
        private static final int f10015i = 2;

        /* renamed from: j  reason: collision with root package name */
        private static final int f10016j = 1;

        /* renamed from: a  reason: collision with root package name */
        private final boolean f10017a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final Cipher f10018b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final SecretKeySpec f10019c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final SecureRandom f10020d;

        /* renamed from: e  reason: collision with root package name */
        private final AtomicFile f10021e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f10022f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private ReusableBufferedOutputStream f10023g;

        public LegacyStorage(File file, @Nullable byte[] bArr, boolean z) {
            SecretKeySpec secretKeySpec;
            Cipher cipher;
            boolean z2 = false;
            Assertions.i(bArr != null || !z);
            SecureRandom secureRandom = null;
            if (bArr != null) {
                Assertions.a(bArr.length == 16 ? true : z2);
                try {
                    cipher = CachedContentIndex.j();
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                    throw new IllegalStateException(e2);
                }
            } else {
                Assertions.a(!z);
                cipher = null;
                secretKeySpec = null;
            }
            this.f10017a = z;
            this.f10018b = cipher;
            this.f10019c = secretKeySpec;
            this.f10020d = z ? new SecureRandom() : secureRandom;
            this.f10021e = new AtomicFile(file);
        }

        private int i(CachedContent cachedContent, int i2) {
            int hashCode = (cachedContent.f9985a * 31) + cachedContent.f9986b.hashCode();
            if (i2 >= 2) {
                return (hashCode * 31) + cachedContent.d().hashCode();
            }
            long a2 = c.a(cachedContent.d());
            return (hashCode * 31) + ((int) (a2 ^ (a2 >>> 32)));
        }

        private CachedContent j(int i2, DataInputStream dataInputStream) throws IOException {
            DefaultContentMetadata defaultContentMetadata;
            int readInt = dataInputStream.readInt();
            String readUTF = dataInputStream.readUTF();
            if (i2 < 2) {
                long readLong = dataInputStream.readLong();
                ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
                ContentMetadataMutations.h(contentMetadataMutations, readLong);
                defaultContentMetadata = DefaultContentMetadata.f10029f.f(contentMetadataMutations);
            } else {
                defaultContentMetadata = CachedContentIndex.s(dataInputStream);
            }
            return new CachedContent(readInt, readUTF, defaultContentMetadata);
        }

        /* JADX WARNING: Removed duplicated region for block: B:56:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00bd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean k(java.util.HashMap<java.lang.String, androidx.media3.datasource.cache.CachedContent> r11, android.util.SparseArray<java.lang.String> r12) {
            /*
                r10 = this;
                androidx.media3.common.util.AtomicFile r0 = r10.f10021e
                boolean r0 = r0.c()
                r1 = 1
                if (r0 != 0) goto L_0x000a
                return r1
            L_0x000a:
                r0 = 0
                r2 = 0
                java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b3, all -> 0x00b1 }
                androidx.media3.common.util.AtomicFile r4 = r10.f10021e     // Catch:{ IOException -> 0x00b3, all -> 0x00b1 }
                java.io.InputStream r4 = r4.d()     // Catch:{ IOException -> 0x00b3, all -> 0x00b1 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00b3, all -> 0x00b1 }
                java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch:{ IOException -> 0x00b3, all -> 0x00b1 }
                r4.<init>(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b1 }
                int r2 = r4.readInt()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                if (r2 < 0) goto L_0x00ad
                r5 = 2
                if (r2 <= r5) goto L_0x0027
                goto L_0x00ad
            L_0x0027:
                int r6 = r4.readInt()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                r6 = r6 & r1
                if (r6 == 0) goto L_0x006c
                javax.crypto.Cipher r6 = r10.f10018b     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                if (r6 != 0) goto L_0x0036
                androidx.media3.common.util.Util.t(r4)
                return r0
            L_0x0036:
                r6 = 16
                byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                r4.readFully(r6)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                javax.crypto.spec.IvParameterSpec r7 = new javax.crypto.spec.IvParameterSpec     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                r7.<init>(r6)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                javax.crypto.Cipher r6 = r10.f10018b     // Catch:{ InvalidKeyException -> 0x0065, InvalidAlgorithmParameterException -> 0x0063 }
                javax.crypto.spec.SecretKeySpec r8 = r10.f10019c     // Catch:{ InvalidKeyException -> 0x0065, InvalidAlgorithmParameterException -> 0x0063 }
                java.lang.Object r8 = androidx.media3.common.util.Util.o(r8)     // Catch:{ InvalidKeyException -> 0x0065, InvalidAlgorithmParameterException -> 0x0063 }
                java.security.Key r8 = (java.security.Key) r8     // Catch:{ InvalidKeyException -> 0x0065, InvalidAlgorithmParameterException -> 0x0063 }
                r6.init(r5, r8, r7)     // Catch:{ InvalidKeyException -> 0x0065, InvalidAlgorithmParameterException -> 0x0063 }
                java.io.DataInputStream r5 = new java.io.DataInputStream     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                javax.crypto.CipherInputStream r6 = new javax.crypto.CipherInputStream     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                javax.crypto.Cipher r7 = r10.f10018b     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                r6.<init>(r3, r7)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                r5.<init>(r6)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                r4 = r5
                goto L_0x0072
            L_0x005d:
                r11 = move-exception
                r2 = r4
                goto L_0x00b5
            L_0x0060:
                r2 = r4
                goto L_0x00bb
            L_0x0063:
                r11 = move-exception
                goto L_0x0066
            L_0x0065:
                r11 = move-exception
            L_0x0066:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                r12.<init>(r11)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                throw r12     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            L_0x006c:
                boolean r3 = r10.f10017a     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                if (r3 == 0) goto L_0x0072
                r10.f10022f = r1     // Catch:{ IOException -> 0x0060, all -> 0x005d }
            L_0x0072:
                int r3 = r4.readInt()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                r5 = 0
                r6 = 0
            L_0x0078:
                if (r5 >= r3) goto L_0x0092
                androidx.media3.datasource.cache.CachedContent r7 = r10.j(r2, r4)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                java.lang.String r8 = r7.f9986b     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                r11.put(r8, r7)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                int r8 = r7.f9985a     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                java.lang.String r9 = r7.f9986b     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                r12.put(r8, r9)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                int r7 = r10.i(r7, r2)     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                int r6 = r6 + r7
                int r5 = r5 + 1
                goto L_0x0078
            L_0x0092:
                int r11 = r4.readInt()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                int r12 = r4.read()     // Catch:{ IOException -> 0x0060, all -> 0x005d }
                r2 = -1
                if (r12 != r2) goto L_0x009f
                r12 = 1
                goto L_0x00a0
            L_0x009f:
                r12 = 0
            L_0x00a0:
                if (r11 != r6) goto L_0x00a9
                if (r12 != 0) goto L_0x00a5
                goto L_0x00a9
            L_0x00a5:
                androidx.media3.common.util.Util.t(r4)
                return r1
            L_0x00a9:
                androidx.media3.common.util.Util.t(r4)
                return r0
            L_0x00ad:
                androidx.media3.common.util.Util.t(r4)
                return r0
            L_0x00b1:
                r11 = move-exception
                goto L_0x00b5
            L_0x00b3:
                goto L_0x00bb
            L_0x00b5:
                if (r2 == 0) goto L_0x00ba
                androidx.media3.common.util.Util.t(r2)
            L_0x00ba:
                throw r11
            L_0x00bb:
                if (r2 == 0) goto L_0x00c0
                androidx.media3.common.util.Util.t(r2)
            L_0x00c0:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.cache.CachedContentIndex.LegacyStorage.k(java.util.HashMap, android.util.SparseArray):boolean");
        }

        private void l(CachedContent cachedContent, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(cachedContent.f9985a);
            dataOutputStream.writeUTF(cachedContent.f9986b);
            CachedContentIndex.v(cachedContent.d(), dataOutputStream);
        }

        private void m(HashMap<String, CachedContent> hashMap) throws IOException {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream f2 = this.f10021e.f();
                ReusableBufferedOutputStream reusableBufferedOutputStream = this.f10023g;
                if (reusableBufferedOutputStream == null) {
                    this.f10023g = new ReusableBufferedOutputStream(f2);
                } else {
                    reusableBufferedOutputStream.b(f2);
                }
                ReusableBufferedOutputStream reusableBufferedOutputStream2 = this.f10023g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(reusableBufferedOutputStream2);
                try {
                    dataOutputStream2.writeInt(2);
                    int i2 = 0;
                    dataOutputStream2.writeInt(this.f10017a ? 1 : 0);
                    if (this.f10017a) {
                        byte[] bArr = new byte[16];
                        ((SecureRandom) Util.o(this.f10020d)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        ((Cipher) Util.o(this.f10018b)).init(1, (Key) Util.o(this.f10019c), new IvParameterSpec(bArr));
                        dataOutputStream2.flush();
                        dataOutputStream2 = new DataOutputStream(new CipherOutputStream(reusableBufferedOutputStream2, this.f10018b));
                    }
                    dataOutputStream2.writeInt(hashMap.size());
                    for (CachedContent next : hashMap.values()) {
                        l(next, dataOutputStream2);
                        i2 += i(next, 2);
                    }
                    dataOutputStream2.writeInt(i2);
                    this.f10021e.b(dataOutputStream2);
                    Util.t((Closeable) null);
                } catch (InvalidKeyException e2) {
                    e = e2;
                    throw new IllegalStateException(e);
                } catch (InvalidAlgorithmParameterException e3) {
                    e = e3;
                    throw new IllegalStateException(e);
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    Util.t(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                Util.t(dataOutputStream);
                throw th;
            }
        }

        public void a() {
            this.f10021e.a();
        }

        public void b(HashMap<String, CachedContent> hashMap) throws IOException {
            m(hashMap);
            this.f10022f = false;
        }

        public boolean c() {
            return this.f10021e.c();
        }

        public void d(HashMap<String, CachedContent> hashMap) throws IOException {
            if (this.f10022f) {
                b(hashMap);
            }
        }

        public void e(long j2) {
        }

        public void f(CachedContent cachedContent) {
            this.f10022f = true;
        }

        public void g(CachedContent cachedContent, boolean z) {
            this.f10022f = true;
        }

        public void h(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) {
            Assertions.i(!this.f10022f);
            if (!k(hashMap, sparseArray)) {
                hashMap.clear();
                sparseArray.clear();
                this.f10021e.a();
            }
        }
    }

    private interface Storage {
        void a() throws IOException;

        void b(HashMap<String, CachedContent> hashMap) throws IOException;

        boolean c() throws IOException;

        void d(HashMap<String, CachedContent> hashMap) throws IOException;

        void e(long j2);

        void f(CachedContent cachedContent);

        void g(CachedContent cachedContent, boolean z);

        void h(HashMap<String, CachedContent> hashMap, SparseArray<String> sparseArray) throws IOException;
    }

    public CachedContentIndex(DatabaseProvider databaseProvider) {
        this(databaseProvider, (File) null, (byte[]) null, false, false);
    }

    private CachedContent d(String str) {
        int n2 = n(this.f9995b);
        CachedContent cachedContent = new CachedContent(n2, str);
        this.f9994a.put(str, cachedContent);
        this.f9995b.put(n2, str);
        this.f9997d.put(n2, true);
        this.f9998e.f(cachedContent);
        return cachedContent;
    }

    @WorkerThread
    public static void g(DatabaseProvider databaseProvider, long j2) throws DatabaseIOException {
        DatabaseStorage.j(databaseProvider, j2);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"GetInstance"})
    public static Cipher j() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (Util.f9646a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    @VisibleForTesting
    static int n(SparseArray<String> sparseArray) {
        int size = sparseArray.size();
        int i2 = 0;
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt >= 0) {
            return keyAt;
        }
        while (i2 < size && i2 == sparseArray.keyAt(i2)) {
            i2++;
        }
        return i2;
    }

    public static boolean q(String str) {
        return str.startsWith(f9992g);
    }

    /* access modifiers changed from: private */
    public static DefaultContentMetadata s(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < readInt) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 >= 0) {
                int min = Math.min(readInt2, f9993h);
                byte[] bArr = Util.f9651f;
                int i3 = 0;
                while (i3 != readInt2) {
                    int i4 = i3 + min;
                    bArr = Arrays.copyOf(bArr, i4);
                    dataInputStream.readFully(bArr, i3, min);
                    min = Math.min(readInt2 - i4, f9993h);
                    i3 = i4;
                }
                hashMap.put(readUTF, bArr);
                i2++;
            } else {
                throw new IOException("Invalid value size: " + readInt2);
            }
        }
        return new DefaultContentMetadata(hashMap);
    }

    /* access modifiers changed from: private */
    public static void v(DefaultContentMetadata defaultContentMetadata, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> g2 = defaultContentMetadata.g();
        dataOutputStream.writeInt(g2.size());
        for (Map.Entry next : g2) {
            dataOutputStream.writeUTF((String) next.getKey());
            byte[] bArr = (byte[]) next.getValue();
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
    }

    public void e(String str, ContentMetadataMutations contentMetadataMutations) {
        CachedContent o = o(str);
        if (o.b(contentMetadataMutations)) {
            this.f9998e.f(o);
        }
    }

    public int f(String str) {
        return o(str).f9985a;
    }

    @Nullable
    public CachedContent h(String str) {
        return this.f9994a.get(str);
    }

    public Collection<CachedContent> i() {
        return Collections.unmodifiableCollection(this.f9994a.values());
    }

    public ContentMetadata k(String str) {
        CachedContent h2 = h(str);
        return h2 != null ? h2.d() : DefaultContentMetadata.f10029f;
    }

    @Nullable
    public String l(int i2) {
        return this.f9995b.get(i2);
    }

    public Set<String> m() {
        return this.f9994a.keySet();
    }

    public CachedContent o(String str) {
        CachedContent cachedContent = this.f9994a.get(str);
        return cachedContent == null ? d(str) : cachedContent;
    }

    @WorkerThread
    public void p(long j2) throws IOException {
        Storage storage;
        this.f9998e.e(j2);
        Storage storage2 = this.f9999f;
        if (storage2 != null) {
            storage2.e(j2);
        }
        if (this.f9998e.c() || (storage = this.f9999f) == null || !storage.c()) {
            this.f9998e.h(this.f9994a, this.f9995b);
        } else {
            this.f9999f.h(this.f9994a, this.f9995b);
            this.f9998e.b(this.f9994a);
        }
        Storage storage3 = this.f9999f;
        if (storage3 != null) {
            storage3.a();
            this.f9999f = null;
        }
    }

    public void r(String str) {
        CachedContent cachedContent = this.f9994a.get(str);
        if (cachedContent != null && cachedContent.g() && cachedContent.i()) {
            this.f9994a.remove(str);
            int i2 = cachedContent.f9985a;
            boolean z = this.f9997d.get(i2);
            this.f9998e.g(cachedContent, z);
            SparseArray<String> sparseArray = this.f9995b;
            if (z) {
                sparseArray.remove(i2);
                this.f9997d.delete(i2);
                return;
            }
            sparseArray.put(i2, (Object) null);
            this.f9996c.put(i2, true);
        }
    }

    public void t() {
        UnmodifiableIterator<String> k2 = ImmutableSet.C(this.f9994a.keySet()).iterator();
        while (k2.hasNext()) {
            r(k2.next());
        }
    }

    @WorkerThread
    public void u() throws IOException {
        this.f9998e.d(this.f9994a);
        int size = this.f9996c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f9995b.remove(this.f9996c.keyAt(i2));
        }
        this.f9996c.clear();
        this.f9997d.clear();
    }

    public CachedContentIndex(@Nullable DatabaseProvider databaseProvider, @Nullable File file, @Nullable byte[] bArr, boolean z, boolean z2) {
        Assertions.i((databaseProvider == null && file == null) ? false : true);
        this.f9994a = new HashMap<>();
        this.f9995b = new SparseArray<>();
        this.f9996c = new SparseBooleanArray();
        this.f9997d = new SparseBooleanArray();
        LegacyStorage legacyStorage = null;
        DatabaseStorage databaseStorage = databaseProvider != null ? new DatabaseStorage(databaseProvider) : null;
        legacyStorage = file != null ? new LegacyStorage(new File(file, f9992g), bArr, z) : legacyStorage;
        if (databaseStorage == null || (legacyStorage != null && z2)) {
            this.f9998e = (Storage) Util.o(legacyStorage);
            this.f9999f = databaseStorage;
            return;
        }
        this.f9998e = databaseStorage;
        this.f9999f = legacyStorage;
    }
}
