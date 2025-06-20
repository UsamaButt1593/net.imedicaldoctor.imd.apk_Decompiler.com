package org.sqlite.database;

import android.util.Log;
import java.io.File;
import net.imedicaldoctor.imd.iMDLogger;
import org.sqlite.database.sqlite.SQLiteDatabase;

public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    private static final String TAG = "DefaultDatabaseErrorHandler";

    private void deleteDatabaseFile(String str) {
        if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
            iMDLogger.f(TAG, "deleting the database file: " + str);
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e2) {
                Log.w(TAG, "delete failed: " + e2.getMessage());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        if (r0 != null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        r3 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        if (r3.hasNext() != false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        deleteDatabaseFile((java.lang.String) r3.next().second);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        deleteDatabaseFile(r3.getPath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0037 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035 A[ExcHandler: all (r1v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
      PHI: (r0v11 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v5 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v5 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:8:0x0030, B:11:0x0037, B:12:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:8:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCorruption(org.sqlite.database.sqlite.SQLiteDatabase r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Corruption reported by sqlite on database: "
            r0.append(r1)
            java.lang.String r1 = r3.getPath()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "DefaultDatabaseErrorHandler"
            net.imedicaldoctor.imd.iMDLogger.f(r1, r0)
            boolean r0 = org.sqlite.database.sqlite.SQLiteDatabase.hasCodec()
            if (r0 == 0) goto L_0x0021
            return
        L_0x0021:
            boolean r0 = r3.isOpen()
            if (r0 != 0) goto L_0x002f
            java.lang.String r3 = r3.getPath()
            r2.deleteDatabaseFile(r3)
            return
        L_0x002f:
            r0 = 0
            java.util.List r0 = r3.getAttachedDbs()     // Catch:{ SQLiteException -> 0x0037, all -> 0x0035 }
            goto L_0x0037
        L_0x0035:
            r1 = move-exception
            goto L_0x003b
        L_0x0037:
            r3.close()     // Catch:{ SQLiteException -> 0x005d, all -> 0x0035 }
            goto L_0x005e
        L_0x003b:
            if (r0 == 0) goto L_0x0055
            java.util.Iterator r3 = r0.iterator()
        L_0x0041:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x005c
            java.lang.Object r0 = r3.next()
            android.util.Pair r0 = (android.util.Pair) r0
            java.lang.Object r0 = r0.second
            java.lang.String r0 = (java.lang.String) r0
            r2.deleteDatabaseFile(r0)
            goto L_0x0041
        L_0x0055:
            java.lang.String r3 = r3.getPath()
            r2.deleteDatabaseFile(r3)
        L_0x005c:
            throw r1
        L_0x005d:
        L_0x005e:
            if (r0 == 0) goto L_0x0078
            java.util.Iterator r3 = r0.iterator()
        L_0x0064:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x007f
            java.lang.Object r0 = r3.next()
            android.util.Pair r0 = (android.util.Pair) r0
            java.lang.Object r0 = r0.second
            java.lang.String r0 = (java.lang.String) r0
            r2.deleteDatabaseFile(r0)
            goto L_0x0064
        L_0x0078:
            java.lang.String r3 = r3.getPath()
            r2.deleteDatabaseFile(r3)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.sqlite.database.DefaultDatabaseErrorHandler.onCorruption(org.sqlite.database.sqlite.SQLiteDatabase):void");
    }
}
