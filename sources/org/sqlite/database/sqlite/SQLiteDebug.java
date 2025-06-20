package org.sqlite.database.sqlite;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.util.Printer;
import java.util.ArrayList;

public final class SQLiteDebug {
    public static final boolean DEBUG_LOG_SLOW_QUERIES = false;
    public static final boolean DEBUG_SQL_LOG = Log.isLoggable("SQLiteLog", 2);
    public static final boolean DEBUG_SQL_STATEMENTS = Log.isLoggable("SQLiteStatements", 2);
    public static final boolean DEBUG_SQL_TIME = Log.isLoggable("SQLiteTime", 2);

    public static class DbStats {
        public String cache;
        public String dbName;
        public long dbSize;
        public int lookaside;
        public long pageSize;

        public DbStats(String str, long j2, long j3, int i2, int i3, int i4, int i5) {
            this.dbName = str;
            this.pageSize = j3 / PlaybackStateCompat.p3;
            this.dbSize = (j2 * j3) / PlaybackStateCompat.p3;
            this.lookaside = i2;
            this.cache = i3 + "/" + i4 + "/" + i5;
        }
    }

    public static class PagerStats {
        public ArrayList<DbStats> dbStats;
        public int largestMemAlloc;
        public int memoryUsed;
        public int pageCacheOverflow;
    }

    private SQLiteDebug() {
    }

    public static void dump(Printer printer, String[] strArr) {
        int length = strArr.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (strArr[i2].equals("-v")) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        SQLiteDatabase.dumpAll(printer, z);
    }

    public static PagerStats getDatabaseInfo() {
        PagerStats pagerStats = new PagerStats();
        nativeGetPagerStats(pagerStats);
        pagerStats.dbStats = SQLiteDatabase.getDbStats();
        return pagerStats;
    }

    private static native void nativeGetPagerStats(PagerStats pagerStats);

    public static boolean shouldLogSlowQuery(long j2) {
        return j2 >= ((long) 10000);
    }
}
