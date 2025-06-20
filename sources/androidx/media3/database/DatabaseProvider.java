package androidx.media3.database;

import android.database.sqlite.SQLiteDatabase;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface DatabaseProvider {

    /* renamed from: b  reason: collision with root package name */
    public static final String f9718b = "ExoPlayer";

    SQLiteDatabase getReadableDatabase();

    SQLiteDatabase getWritableDatabase();
}
