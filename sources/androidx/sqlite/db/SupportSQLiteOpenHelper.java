package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteCompat;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H'R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Ljava/io/Closeable;", "databaseName", "", "getDatabaseName", "()Ljava/lang/String;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "close", "", "setWriteAheadLoggingEnabled", "enabled", "", "Callback", "Configuration", "Factory", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SupportSQLiteOpenHelper extends Closeable {

    @SourceDebugExtension({"SMAP\nSupportSQLiteOpenHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SupportSQLiteOpenHelper.kt\nandroidx/sqlite/db/SupportSQLiteOpenHelper$Callback\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,426:1\n1#2:427\n1855#3,2:428\n107#4:430\n79#4,22:431\n*S KotlinDebug\n*F\n+ 1 SupportSQLiteOpenHelper.kt\nandroidx/sqlite/db/SupportSQLiteOpenHelper$Callback\n*L\n243#1:428,2\n251#1:430\n251#1:431,22\n*E\n"})
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 \r2\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\u000eJ'\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "", "", "version", "<init>", "(I)V", "", "fileName", "", "a", "(Ljava/lang/String;)V", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "db", "b", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "d", "oldVersion", "newVersion", "g", "(Landroidx/sqlite/db/SupportSQLiteDatabase;II)V", "e", "f", "c", "I", "Companion", "sqlite_release"}, k = 1, mv = {1, 8, 0})
    public static abstract class Callback {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final Companion f15819b = new Companion((DefaultConstructorMarker) null);
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private static final String f15820c = "SupportSQLite";
        @JvmField

        /* renamed from: a  reason: collision with root package name */
        public final int f15821a;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback$Companion;", "", "()V", "TAG", "", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Callback(int i2) {
            this.f15821a = i2;
        }

        private final void a(String str) {
            if (!StringsKt.K1(str, ":memory:", true)) {
                int length = str.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length) {
                    boolean z2 = Intrinsics.t(str.charAt(!z ? i2 : length), 32) <= 0;
                    if (!z) {
                        if (!z2) {
                            z = true;
                        } else {
                            i2++;
                        }
                    } else if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                }
                if (str.subSequence(i2, length + 1).toString().length() != 0) {
                    Log.w(f15820c, "deleting the database file: " + str);
                    try {
                        SupportSQLiteCompat.Api16Impl.c(new File(str));
                    } catch (Exception e2) {
                        Log.w(f15820c, "delete failed: ", e2);
                    }
                }
            }
        }

        public void b(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.p(supportSQLiteDatabase, "db");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
            if (r1 != null) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
            r4 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
            if (r4.hasNext() != false) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
            r1 = ((android.util.Pair) r4.next()).second;
            kotlin.jvm.internal.Intrinsics.o(r1, "p.second");
            a((java.lang.String) r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x005b, code lost:
            r4 = r4.getPath();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
            if (r4 != null) goto L_0x0061;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
            a(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0064, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003a */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0083  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0038 A[ExcHandler: all (r2v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
          PHI: (r1v11 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r1v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v5 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v5 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:6:0x0033, B:9:0x003a, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:6:0x0033] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(@org.jetbrains.annotations.NotNull androidx.sqlite.db.SupportSQLiteDatabase r4) {
            /*
                r3 = this;
                java.lang.String r0 = "p.second"
                java.lang.String r1 = "db"
                kotlin.jvm.internal.Intrinsics.p(r4, r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Corruption reported by sqlite on database: "
                r1.append(r2)
                r1.append(r4)
                java.lang.String r2 = ".path"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "SupportSQLite"
                android.util.Log.e(r2, r1)
                boolean r1 = r4.isOpen()
                if (r1 != 0) goto L_0x0032
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x0031
                r3.a(r4)
            L_0x0031:
                return
            L_0x0032:
                r1 = 0
                java.util.List r1 = r4.getAttachedDbs()     // Catch:{ SQLiteException -> 0x003a, all -> 0x0038 }
                goto L_0x003a
            L_0x0038:
                r2 = move-exception
                goto L_0x003e
            L_0x003a:
                r4.close()     // Catch:{ IOException -> 0x0065, all -> 0x0038 }
                goto L_0x0066
            L_0x003e:
                if (r1 == 0) goto L_0x005b
                java.util.Iterator r4 = r1.iterator()
            L_0x0044:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x0064
                java.lang.Object r1 = r4.next()
                android.util.Pair r1 = (android.util.Pair) r1
                java.lang.Object r1 = r1.second
                kotlin.jvm.internal.Intrinsics.o(r1, r0)
                java.lang.String r1 = (java.lang.String) r1
                r3.a(r1)
                goto L_0x0044
            L_0x005b:
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x0064
                r3.a(r4)
            L_0x0064:
                throw r2
            L_0x0065:
            L_0x0066:
                if (r1 == 0) goto L_0x0083
                java.util.Iterator r4 = r1.iterator()
            L_0x006c:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x008c
                java.lang.Object r1 = r4.next()
                android.util.Pair r1 = (android.util.Pair) r1
                java.lang.Object r1 = r1.second
                kotlin.jvm.internal.Intrinsics.o(r1, r0)
                java.lang.String r1 = (java.lang.String) r1
                r3.a(r1)
                goto L_0x006c
            L_0x0083:
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x008c
                r3.a(r4)
            L_0x008c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.SupportSQLiteOpenHelper.Callback.c(androidx.sqlite.db.SupportSQLiteDatabase):void");
        }

        public abstract void d(@NotNull SupportSQLiteDatabase supportSQLiteDatabase);

        public void e(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3) {
            Intrinsics.p(supportSQLiteDatabase, "db");
            throw new SQLiteException("Can't downgrade database from version " + i2 + " to " + i3);
        }

        public void f(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.p(supportSQLiteDatabase, "db");
        }

        public abstract void g(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u0000 \u00162\u00020\u0001:\u0002\u0017\u0018B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001a\u00020\b8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u0019"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "", "Landroid/content/Context;", "context", "", "name", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "callback", "", "useNoBackupDirectory", "allowDataLossOnRecovery", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;ZZ)V", "a", "Landroid/content/Context;", "b", "Ljava/lang/String;", "c", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "d", "Z", "e", "f", "Builder", "Companion", "sqlite_release"}, k = 1, mv = {1, 8, 0})
    public static final class Configuration {
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        public static final Companion f15822f = new Companion((DefaultConstructorMarker) null);
        @NotNull
        @JvmField

        /* renamed from: a  reason: collision with root package name */
        public final Context f15823a;
        @Nullable
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public final String f15824b;
        @NotNull
        @JvmField

        /* renamed from: c  reason: collision with root package name */
        public final Callback f15825c;
        @JvmField

        /* renamed from: d  reason: collision with root package name */
        public final boolean f15826d;
        @JvmField

        /* renamed from: e  reason: collision with root package name */
        public final boolean f15827e;

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0016\u0010\u0015\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "b", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "", "name", "d", "(Ljava/lang/String;)Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "callback", "c", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;)Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "", "useNoBackupDirectory", "e", "(Z)Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "allowDataLossOnRecovery", "a", "Landroid/content/Context;", "Ljava/lang/String;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "Z", "sqlite_release"}, k = 1, mv = {1, 8, 0})
        public static class Builder {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final Context f15828a;
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            private String f15829b;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            private Callback f15830c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f15831d;

            /* renamed from: e  reason: collision with root package name */
            private boolean f15832e;

            public Builder(@NotNull Context context) {
                Intrinsics.p(context, "context");
                this.f15828a = context;
            }

            @NotNull
            public Builder a(boolean z) {
                this.f15832e = z;
                return this;
            }

            @NotNull
            public Configuration b() {
                String str;
                Callback callback = this.f15830c;
                if (callback == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.".toString());
                } else if (!this.f15831d || ((str = this.f15829b) != null && str.length() != 0)) {
                    return new Configuration(this.f15828a, this.f15829b, callback, this.f15831d, this.f15832e);
                } else {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
                }
            }

            @NotNull
            public Builder c(@NotNull Callback callback) {
                Intrinsics.p(callback, "callback");
                this.f15830c = callback;
                return this;
            }

            @NotNull
            public Builder d(@Nullable String str) {
                this.f15829b = str;
                return this;
            }

            @NotNull
            public Builder e(boolean z) {
                this.f15831d = z;
                return this;
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "a", "(Landroid/content/Context;)Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "sqlite_release"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            private Companion() {
            }

            @JvmStatic
            @NotNull
            public final Builder a(@NotNull Context context) {
                Intrinsics.p(context, "context");
                return new Builder(context);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Configuration(@NotNull Context context, @Nullable String str, @NotNull Callback callback, boolean z, boolean z2) {
            Intrinsics.p(context, "context");
            Intrinsics.p(callback, "callback");
            this.f15823a = context;
            this.f15824b = str;
            this.f15825c = callback;
            this.f15826d = z;
            this.f15827e = z2;
        }

        @JvmStatic
        @NotNull
        public static final Builder a(@NotNull Context context) {
            return f15822f.a(context);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Configuration(Context context, String str, Callback callback, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, str, callback, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "", "create", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "configuration", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Factory {
        @NotNull
        SupportSQLiteOpenHelper create(@NotNull Configuration configuration);
    }

    void close();

    @Nullable
    String getDatabaseName();

    @NotNull
    SupportSQLiteDatabase getReadableDatabase();

    @NotNull
    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean z);
}
