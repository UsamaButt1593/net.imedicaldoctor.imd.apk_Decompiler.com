package androidx.sqlite.db;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.itextpdf.text.Annotation;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat;", "", "()V", "Api16Impl", "Api19Impl", "Api21Impl", "Api23Impl", "Api29Impl", "sqlite_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SupportSQLiteCompat {

    @RequiresApi(16)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJK\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0010\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\rH\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\rH\u0007¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api16Impl;", "", "<init>", "()V", "Landroid/os/CancellationSignal;", "cancellationSignal", "", "a", "(Landroid/os/CancellationSignal;)V", "b", "()Landroid/os/CancellationSignal;", "Ljava/io/File;", "file", "", "c", "(Ljava/io/File;)Z", "Landroid/database/sqlite/SQLiteDatabase;", "sQLiteDatabase", "", "sql", "", "selectionArgs", "editTable", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "cursorFactory", "Landroid/database/Cursor;", "f", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/Cursor;", "enable", "g", "(Landroid/database/sqlite/SQLiteDatabase;Z)V", "d", "(Landroid/database/sqlite/SQLiteDatabase;)V", "e", "(Landroid/database/sqlite/SQLiteDatabase;)Z", "Landroid/database/sqlite/SQLiteOpenHelper;", "sQLiteOpenHelper", "enabled", "h", "(Landroid/database/sqlite/SQLiteOpenHelper;Z)V", "sqlite_release"}, k = 1, mv = {1, 8, 0})
    public static final class Api16Impl {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Api16Impl f15814a = new Api16Impl();

        private Api16Impl() {
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void a(@NotNull CancellationSignal cancellationSignal) {
            Intrinsics.p(cancellationSignal, "cancellationSignal");
            cancellationSignal.cancel();
        }

        @JvmStatic
        @NotNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final CancellationSignal b() {
            return new CancellationSignal();
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final boolean c(@NotNull File file) {
            Intrinsics.p(file, Annotation.k3);
            return SQLiteDatabase.deleteDatabase(file);
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void d(@NotNull SQLiteDatabase sQLiteDatabase) {
            Intrinsics.p(sQLiteDatabase, "sQLiteDatabase");
            sQLiteDatabase.disableWriteAheadLogging();
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final boolean e(@NotNull SQLiteDatabase sQLiteDatabase) {
            Intrinsics.p(sQLiteDatabase, "sQLiteDatabase");
            return sQLiteDatabase.isWriteAheadLoggingEnabled();
        }

        @JvmStatic
        @NotNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final Cursor f(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String str, @NotNull String[] strArr, @Nullable String str2, @NotNull CancellationSignal cancellationSignal, @NotNull SQLiteDatabase.CursorFactory cursorFactory) {
            Intrinsics.p(sQLiteDatabase, "sQLiteDatabase");
            Intrinsics.p(str, "sql");
            Intrinsics.p(strArr, "selectionArgs");
            Intrinsics.p(cancellationSignal, "cancellationSignal");
            Intrinsics.p(cursorFactory, "cursorFactory");
            Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
            Intrinsics.o(rawQueryWithFactory, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
            return rawQueryWithFactory;
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void g(@NotNull SQLiteDatabase sQLiteDatabase, boolean z) {
            Intrinsics.p(sQLiteDatabase, "sQLiteDatabase");
            sQLiteDatabase.setForeignKeyConstraintsEnabled(z);
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void h(@NotNull SQLiteOpenHelper sQLiteOpenHelper, boolean z) {
            Intrinsics.p(sQLiteOpenHelper, "sQLiteOpenHelper");
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(z);
        }
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api19Impl;", "", "<init>", "()V", "Landroid/database/Cursor;", "cursor", "Landroid/net/Uri;", "a", "(Landroid/database/Cursor;)Landroid/net/Uri;", "Landroid/app/ActivityManager;", "activityManager", "", "b", "(Landroid/app/ActivityManager;)Z", "sqlite_release"}, k = 1, mv = {1, 8, 0})
    public static final class Api19Impl {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Api19Impl f15815a = new Api19Impl();

        private Api19Impl() {
        }

        @JvmStatic
        @NotNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final Uri a(@NotNull Cursor cursor) {
            Intrinsics.p(cursor, "cursor");
            Uri notificationUri = cursor.getNotificationUri();
            Intrinsics.o(notificationUri, "cursor.notificationUri");
            return notificationUri;
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final boolean b(@NotNull ActivityManager activityManager) {
            Intrinsics.p(activityManager, "activityManager");
            return activityManager.isLowRamDevice();
        }
    }

    @RequiresApi(21)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api21Impl;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Ljava/io/File;", "a", "(Landroid/content/Context;)Ljava/io/File;", "sqlite_release"}, k = 1, mv = {1, 8, 0})
    public static final class Api21Impl {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Api21Impl f15816a = new Api21Impl();

        private Api21Impl() {
        }

        @JvmStatic
        @NotNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final File a(@NotNull Context context) {
            Intrinsics.p(context, "context");
            File noBackupFilesDir = context.getNoBackupFilesDir();
            Intrinsics.o(noBackupFilesDir, "context.noBackupFilesDir");
            return noBackupFilesDir;
        }
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api23Impl;", "", "<init>", "()V", "Landroid/database/Cursor;", "cursor", "Landroid/os/Bundle;", "extras", "", "a", "(Landroid/database/Cursor;Landroid/os/Bundle;)V", "sqlite_release"}, k = 1, mv = {1, 8, 0})
    public static final class Api23Impl {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Api23Impl f15817a = new Api23Impl();

        private Api23Impl() {
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void a(@NotNull Cursor cursor, @NotNull Bundle bundle) {
            Intrinsics.p(cursor, "cursor");
            Intrinsics.p(bundle, "extras");
            cursor.setExtras(bundle);
        }
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteCompat$Api29Impl;", "", "<init>", "()V", "Landroid/database/Cursor;", "cursor", "Landroid/content/ContentResolver;", "cr", "", "Landroid/net/Uri;", "uris", "", "b", "(Landroid/database/Cursor;Landroid/content/ContentResolver;Ljava/util/List;)V", "a", "(Landroid/database/Cursor;)Ljava/util/List;", "sqlite_release"}, k = 1, mv = {1, 8, 0})
    public static final class Api29Impl {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final Api29Impl f15818a = new Api29Impl();

        private Api29Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @JvmStatic
        @NotNull
        public static final List<Uri> a(@NotNull Cursor cursor) {
            Intrinsics.p(cursor, "cursor");
            List<Uri> notificationUris = cursor.getNotificationUris();
            Intrinsics.m(notificationUris);
            return notificationUris;
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void b(@NotNull Cursor cursor, @NotNull ContentResolver contentResolver, @NotNull List<? extends Uri> list) {
            Intrinsics.p(cursor, "cursor");
            Intrinsics.p(contentResolver, "cr");
            Intrinsics.p(list, "uris");
            cursor.setNotificationUris(contentResolver, list);
        }
    }

    private SupportSQLiteCompat() {
    }
}
