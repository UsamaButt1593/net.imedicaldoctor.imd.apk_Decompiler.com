package org.sqlite.database.sqlite;

import android.os.StatFs;
import com.itextpdf.text.html.HtmlTags;

public final class SQLiteGlobal {
    private static final String TAG = "SQLiteGlobal";
    private static int sDefaultPageSize;
    private static final Object sLock = new Object();

    private SQLiteGlobal() {
    }

    public static String getDefaultJournalMode() {
        return "delete";
    }

    public static int getDefaultPageSize() {
        synchronized (sLock) {
            try {
                if (sDefaultPageSize == 0) {
                    sDefaultPageSize = new StatFs("/data").getBlockSize();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return 1024;
    }

    public static String getDefaultSyncMode() {
        return HtmlTags.y0;
    }

    public static int getJournalSizeLimit() {
        return 10000;
    }

    public static int getWALAutoCheckpoint() {
        return Math.max(1, 1000);
    }

    public static int getWALConnectionPoolSize() {
        return Math.max(2, 10);
    }

    public static String getWALSyncMode() {
        return HtmlTags.y0;
    }

    private static native int nativeReleaseMemory();

    public static int releaseMemory() {
        return nativeReleaseMemory();
    }
}
