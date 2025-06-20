package net.imedicaldoctor.imd.Data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.requery.android.database.sqlite.SQLiteCursor;
import io.requery.android.database.sqlite.SQLiteCursorDriver;
import io.requery.android.database.sqlite.SQLiteDatabase;
import io.requery.android.database.sqlite.SQLiteQuery;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class iMDProvider extends ContentProvider {
    private static final String X = "net.imedicaldoctor.imd";
    public static Bundle X2;
    private static HashMap<String, SQLiteDatabase> Y;
    private static HashMap<String, Integer> Z;
    private static final UriMatcher s = e();

    public class LeaklessCursor extends SQLiteCursor {
        static final String Y = "LeaklessCursor";
        final SQLiteDatabase s;

        public LeaklessCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            super(sQLiteCursorDriver, str, sQLiteQuery);
            this.s = sQLiteDatabase;
        }

        public void close() {
            iMDLogger.d(Y, "Closing LeaklessCursor: " + this.s.getPath());
            super.close();
            SQLiteDatabase sQLiteDatabase = this.s;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
            }
        }
    }

    public class LeaklessCursorFactory implements SQLiteDatabase.CursorFactory {
        public LeaklessCursorFactory() {
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            return new LeaklessCursor(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    private SQLiteDatabase a(String str) {
        SQLiteDatabase sQLiteDatabase;
        if (Y == null) {
            Y = new HashMap<>();
        }
        if (Z == null) {
            Z = new HashMap<>();
        }
        if (Y.containsKey(str)) {
            sQLiteDatabase = Y.get(str);
        } else {
            sQLiteDatabase = SQLiteDatabase.openDatabase(str, (SQLiteDatabase.CursorFactory) null, str.contains("/DBs.db") ? 1 : 2);
            sQLiteDatabase.disableWriteAheadLogging();
            sQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY");
            Y.put(str, sQLiteDatabase);
        }
        b(str);
        return sQLiteDatabase;
    }

    private void b(String str) {
        int i2;
        if (Z.containsKey(str)) {
            i2 = Z.get(str).intValue();
            Z.remove(str);
        } else {
            i2 = 0;
        }
        Z.put(str, Integer.valueOf(i2 + 1));
    }

    private void c(String str) {
        if (Y == null) {
            Y = new HashMap<>();
        }
        if (Z == null) {
            Z = new HashMap<>();
        }
        if (Y.containsKey(str)) {
            d(str);
            if ((Z.containsKey(str) ? Z.get(str).intValue() : 0) <= 0) {
                SQLiteDatabase sQLiteDatabase = Y.get(str);
                try {
                    if (sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                        iMDLogger.f("iMDProvider", "Closed database");
                    }
                } catch (Exception unused) {
                }
                Y.remove(str);
            }
        }
    }

    private void d(String str) {
        if (Z.containsKey(str)) {
            try {
                Z.remove(str);
                Z.put(str, Integer.valueOf(Z.get(str).intValue() - 1));
            } catch (Exception unused) {
            }
        }
    }

    private static UriMatcher e() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI("net.imedicaldoctor.imd", "*", 101);
        return uriMatcher;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (str2 != null) {
            iMDLogger.f("iMDProvider", "Query " + str + " - " + str2);
        }
        int match = s.match(uri);
        if (str2 == null) {
            try {
                c(str);
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
            }
            return null;
        } else if (match != 101) {
            return null;
        } else {
            try {
                return a(str).rawQuery(str2, (Object[]) null);
            } catch (Exception e3) {
                String cls = iMDProvider.class.toString();
                iMDLogger.f(cls, "Error in iMDProvider query , " + e3 + " in " + e3.getStackTrace());
                return null;
            }
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int i2 = 0;
        String str2 = strArr[0];
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(str, (SQLiteDatabase.CursorFactory) null, 2);
        openDatabase.disableWriteAheadLogging();
        openDatabase.execSQL("PRAGMA temp_store = MEMORY");
        if (strArr.length <= 1) {
            openDatabase.execSQL(str2);
        } else if (strArr[0].equals("SQLFile")) {
            String str3 = strArr[1];
            String[] split = StringUtils.split(str3, "/");
            String str4 = split[split.length - 1];
            int intValue = Integer.valueOf(strArr[2]).intValue();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(str3))), 131072);
                for (int i3 = 0; i3 < intValue; i3++) {
                    bufferedReader.readLine();
                }
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        i2++;
                        try {
                            iMDLogger.d("SQL Line - " + str4, i2 + "");
                            openDatabase.execSQL(readLine);
                        } catch (Exception e2) {
                            FirebaseCrashlytics.d().g(e2);
                            e2.printStackTrace();
                        }
                    } catch (Exception e3) {
                        FirebaseCrashlytics.d().g(e3);
                        e3.printStackTrace();
                    }
                }
                openDatabase.close();
            } catch (Exception e4) {
                FirebaseCrashlytics.d().g(e4);
                iMDLogger.f("ExecuteDB", "Error in reading and executing " + str3 + " With error : " + e4.getMessage());
                e4.printStackTrace();
            }
        } else {
            openDatabase.beginTransaction();
            int length = strArr.length;
            while (i2 < length) {
                openDatabase.execSQL(strArr[i2]);
                i2++;
            }
            openDatabase.setTransactionSuccessful();
            openDatabase.endTransaction();
        }
        try {
            if (openDatabase.isOpen()) {
                openDatabase.close();
            }
        } catch (Exception e5) {
            FirebaseCrashlytics.d().g(e5);
            iMDLogger.g("iMD Provider", "Closing database", e5);
        }
        return 1;
    }
}
