package androidx.media3.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class DefaultDatabaseProvider implements DatabaseProvider {
    private final SQLiteOpenHelper s;

    public DefaultDatabaseProvider(SQLiteOpenHelper sQLiteOpenHelper) {
        this.s = sQLiteOpenHelper;
    }

    public SQLiteDatabase getReadableDatabase() {
        return this.s.getReadableDatabase();
    }

    public SQLiteDatabase getWritableDatabase() {
        return this.s.getWritableDatabase();
    }
}
