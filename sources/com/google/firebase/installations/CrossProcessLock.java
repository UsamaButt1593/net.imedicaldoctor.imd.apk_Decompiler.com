package com.google.firebase.installations;

import android.util.Log;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

class CrossProcessLock {

    /* renamed from: c  reason: collision with root package name */
    private static final String f24408c = "CrossProcessLock";

    /* renamed from: a  reason: collision with root package name */
    private final FileChannel f24409a;

    /* renamed from: b  reason: collision with root package name */
    private final FileLock f24410b;

    private CrossProcessLock(FileChannel fileChannel, FileLock fileLock) {
        this.f24409a = fileChannel;
        this.f24410b = fileLock;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d A[SYNTHETIC, Splitter:B:15:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044 A[SYNTHETIC, Splitter:B:19:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.firebase.installations.CrossProcessLock a(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0032, Error -> 0x0030, OverlappingFileLockException -> 0x002c }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ IOException -> 0x0032, Error -> 0x0030, OverlappingFileLockException -> 0x002c }
            r1.<init>(r4, r5)     // Catch:{ IOException -> 0x0032, Error -> 0x0030, OverlappingFileLockException -> 0x002c }
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0032, Error -> 0x0030, OverlappingFileLockException -> 0x002c }
            java.lang.String r5 = "rw"
            r4.<init>(r1, r5)     // Catch:{ IOException -> 0x0032, Error -> 0x0030, OverlappingFileLockException -> 0x002c }
            java.nio.channels.FileChannel r4 = r4.getChannel()     // Catch:{ IOException -> 0x0032, Error -> 0x0030, OverlappingFileLockException -> 0x002c }
            java.nio.channels.FileLock r5 = r4.lock()     // Catch:{ IOException -> 0x002a, Error -> 0x0028, OverlappingFileLockException -> 0x0025 }
            com.google.firebase.installations.CrossProcessLock r1 = new com.google.firebase.installations.CrossProcessLock     // Catch:{ IOException -> 0x0023, Error -> 0x0021, OverlappingFileLockException -> 0x001f }
            r1.<init>(r4, r5)     // Catch:{ IOException -> 0x0023, Error -> 0x0021, OverlappingFileLockException -> 0x001f }
            return r1
        L_0x001f:
            r1 = move-exception
            goto L_0x0034
        L_0x0021:
            r1 = move-exception
            goto L_0x0034
        L_0x0023:
            r1 = move-exception
            goto L_0x0034
        L_0x0025:
            r1 = move-exception
        L_0x0026:
            r5 = r0
            goto L_0x0034
        L_0x0028:
            r1 = move-exception
            goto L_0x0026
        L_0x002a:
            r1 = move-exception
            goto L_0x0026
        L_0x002c:
            r1 = move-exception
        L_0x002d:
            r4 = r0
            r5 = r4
            goto L_0x0034
        L_0x0030:
            r1 = move-exception
            goto L_0x002d
        L_0x0032:
            r1 = move-exception
            goto L_0x002d
        L_0x0034:
            java.lang.String r2 = "CrossProcessLock"
            java.lang.String r3 = "encountered error while creating and acquiring the lock, ignoring"
            android.util.Log.e(r2, r3, r1)
            if (r5 == 0) goto L_0x0042
            r5.release()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0042
        L_0x0041:
        L_0x0042:
            if (r4 == 0) goto L_0x0047
            r4.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0047:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.CrossProcessLock.a(android.content.Context, java.lang.String):com.google.firebase.installations.CrossProcessLock");
    }

    /* access modifiers changed from: package-private */
    public void b() {
        try {
            this.f24410b.release();
            this.f24409a.close();
        } catch (IOException e2) {
            Log.e(f24408c, "encountered error while releasing, ignoring", e2);
        }
    }
}
