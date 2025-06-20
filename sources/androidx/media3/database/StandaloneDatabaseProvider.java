package androidx.media3.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public class StandaloneDatabaseProvider extends SQLiteOpenHelper implements DatabaseProvider {
    private static final int X = 1;
    private static final String Y = "SADatabaseProvider";
    public static final String s = "exoplayer_internal.db";

    public StandaloneDatabaseProvider(Context context) {
        super(context.getApplicationContext(), s, (SQLiteDatabase.CursorFactory) null, 1);
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        Cursor query = sQLiteDatabase.query("sqlite_master", new String[]{"type", "name"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        while (query.moveToNext()) {
            try {
                String string = query.getString(0);
                String string2 = query.getString(1);
                if (!"sqlite_sequence".equals(string2)) {
                    String str = "DROP " + string + " IF EXISTS " + string2;
                    try {
                        sQLiteDatabase.execSQL(str);
                    } catch (SQLException e2) {
                        Log.e(Y, "Error executing " + str, e2);
                    }
                }
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        query.close();
        return;
        throw th;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        b(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
