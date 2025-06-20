package net.imedicaldoctor.imd.Data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.requery.android.database.sqlite.SQLiteDatabase;
import net.imedicaldoctor.imd.iMDLogger;
import org.apache.commons.lang3.StringUtils;

public class SpellProvider extends ContentProvider {
    private static final String X2 = "net.imedicaldoctor.spell";
    private static final UriMatcher Z = a();
    private String X;
    private final String Y = null;
    private SQLiteDatabase s;

    private static UriMatcher a() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI(X2, "spell/*/*", 101);
        uriMatcher.addURI(X2, "cspell/*/*", 102);
        return uriMatcher;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.Y == null ? 0 : 1;
    }

    public String getType(Uri uri) {
        if (Z.match(uri) != 401) {
            return null;
        }
        return this.X;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        try {
            this.s = SQLiteDatabase.openDatabase(new CompressHelper(getContext()).A(), (SQLiteDatabase.CursorFactory) null, 1);
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            Log.e("SpellProvider", "Can't open spell Database");
        }
        this.X = "0";
        return false;
    }

    public void onLowMemory() {
        iMDLogger.f("UTDProvider", "OnLowMemory");
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase sQLiteDatabase;
        String str3;
        int match = Z.match(uri);
        if (match == 101) {
            String[] split = uri.getLastPathSegment().trim().split(StringUtils.SPACE);
            String str4 = split[split.length - 1];
            String str5 = "";
            for (int i2 = 0; i2 < split.length - 1; i2++) {
                str5 = str5 + StringUtils.SPACE + split[i2];
            }
            String trim = str5.trim();
            sQLiteDatabase = this.s;
            str3 = "Select rowid as _id, word as suggest_text_1,\"" + trim + " \" || word from spell where word match '" + str4 + "*'";
        } else if (match != 102) {
            return null;
        } else {
            try {
                sQLiteDatabase = this.s;
                str3 = "Select rowid as _id, word as suggest_text_1 from contentspell where word match '" + uri.getLastPathSegment() + "*'";
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f(SpellProvider.class.toString(), "Error in UTDProvider query , " + e2);
                return null;
            }
        }
        return sQLiteDatabase.rawQuery(str3, (Object[]) null);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        onCreate();
        return 1;
    }
}
