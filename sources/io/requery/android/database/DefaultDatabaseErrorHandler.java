package io.requery.android.database;

import android.util.Log;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.io.File;

public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    private static final String TAG = "DefaultDatabaseError";

    private void deleteDatabaseFile(String str) {
        if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
            Log.e(TAG, "deleting the database file: " + str);
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e2) {
                Log.w(TAG, "delete failed: " + e2.getMessage());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        if (r0 != null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        r3 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        if (r3.hasNext() != false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        deleteDatabaseFile((java.lang.String) r3.next().second);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        deleteDatabaseFile(r3.getPath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0030 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002e A[ExcHandler: all (r1v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
      PHI: (r0v10 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r0v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:5:0x0029, B:8:0x0030, B:9:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCorruption(io.requery.android.database.sqlite.SQLiteDatabase r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Corruption reported by sqlite on database: "
            r0.append(r1)
            java.lang.String r1 = r3.getPath()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "DefaultDatabaseError"
            android.util.Log.e(r1, r0)
            boolean r0 = r3.isOpen()
            if (r0 != 0) goto L_0x0028
            java.lang.String r3 = r3.getPath()
            r2.deleteDatabaseFile(r3)
            return
        L_0x0028:
            r0 = 0
            java.util.List r0 = r3.getAttachedDbs()     // Catch:{ SQLiteException -> 0x0030, all -> 0x002e }
            goto L_0x0030
        L_0x002e:
            r1 = move-exception
            goto L_0x0034
        L_0x0030:
            r3.close()     // Catch:{ SQLiteException -> 0x0056, all -> 0x002e }
            goto L_0x0057
        L_0x0034:
            if (r0 == 0) goto L_0x004e
            java.util.Iterator r3 = r0.iterator()
        L_0x003a:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0055
            java.lang.Object r0 = r3.next()
            android.util.Pair r0 = (android.util.Pair) r0
            java.lang.Object r0 = r0.second
            java.lang.String r0 = (java.lang.String) r0
            r2.deleteDatabaseFile(r0)
            goto L_0x003a
        L_0x004e:
            java.lang.String r3 = r3.getPath()
            r2.deleteDatabaseFile(r3)
        L_0x0055:
            throw r1
        L_0x0056:
        L_0x0057:
            if (r0 == 0) goto L_0x0071
            java.util.Iterator r3 = r0.iterator()
        L_0x005d:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0078
            java.lang.Object r0 = r3.next()
            android.util.Pair r0 = (android.util.Pair) r0
            java.lang.Object r0 = r0.second
            java.lang.String r0 = (java.lang.String) r0
            r2.deleteDatabaseFile(r0)
            goto L_0x005d
        L_0x0071:
            java.lang.String r3 = r3.getPath()
            r2.deleteDatabaseFile(r3)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.requery.android.database.DefaultDatabaseErrorHandler.onCorruption(io.requery.android.database.sqlite.SQLiteDatabase):void");
    }
}
