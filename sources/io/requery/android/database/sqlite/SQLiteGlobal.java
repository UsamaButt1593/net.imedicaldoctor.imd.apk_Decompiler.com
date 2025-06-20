package io.requery.android.database.sqlite;

import android.os.StatFs;
import com.itextpdf.text.html.HtmlTags;

public final class SQLiteGlobal {
    private static int sDefaultPageSize;
    private static final Object sLock = new Object();

    private SQLiteGlobal() {
    }

    public static String getDefaultJournalMode() {
        return "TRUNCATE";
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
        return "FULL";
    }

    public static int getJournalSizeLimit() {
        return 524288;
    }

    public static int getWALAutoCheckpoint() {
        return 1000;
    }

    public static int getWALConnectionPoolSize() {
        return 10;
    }

    public static String getWALSyncMode() {
        return HtmlTags.y0;
    }

    private static native int nativeReleaseMemory();

    public static int releaseMemory() {
        return nativeReleaseMemory();
    }
}
