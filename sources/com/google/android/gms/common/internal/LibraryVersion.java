package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
@Deprecated
public class LibraryVersion {

    /* renamed from: b  reason: collision with root package name */
    private static final GmsLogger f20250b = new GmsLogger("LibraryVersion", "");

    /* renamed from: c  reason: collision with root package name */
    private static final LibraryVersion f20251c = new LibraryVersion();

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap f20252a = new ConcurrentHashMap();

    @VisibleForTesting
    protected LibraryVersion() {
    }

    @NonNull
    @KeepForSdk
    public static LibraryVersion a() {
        return f20251c;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a9  */
    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String b(@androidx.annotation.NonNull java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "Failed to get app version for libraryName: "
            java.lang.String r1 = "LibraryVersion"
            java.lang.String r2 = "Please provide a valid libraryName"
            com.google.android.gms.common.internal.Preconditions.m(r9, r2)
            java.util.concurrent.ConcurrentHashMap r2 = r8.f20252a
            boolean r2 = r2.containsKey(r9)
            if (r2 == 0) goto L_0x001a
            java.util.concurrent.ConcurrentHashMap r0 = r8.f20252a
            java.lang.Object r9 = r0.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            return r9
        L_0x001a:
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            r3 = 0
            java.lang.String r4 = "/%s.properties"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x0075 }
            r6 = 0
            r5[r6] = r9     // Catch:{ IOException -> 0x0075 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ IOException -> 0x0075 }
            java.lang.Class<com.google.android.gms.common.internal.LibraryVersion> r5 = com.google.android.gms.common.internal.LibraryVersion.class
            java.io.InputStream r4 = r5.getResourceAsStream(r4)     // Catch:{ IOException -> 0x0075 }
            if (r4 == 0) goto L_0x005e
            r2.load(r4)     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            java.lang.String r5 = "version"
            java.lang.String r3 = r2.getProperty(r5, r3)     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            com.google.android.gms.common.internal.GmsLogger r2 = f20250b     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            r5.<init>()     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            r5.append(r9)     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            java.lang.String r6 = " version is "
            r5.append(r6)     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            r5.append(r3)     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            r2.l(r1, r5)     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            goto L_0x0091
        L_0x0057:
            r9 = move-exception
            goto L_0x0073
        L_0x0059:
            r2 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L_0x007a
        L_0x005e:
            com.google.android.gms.common.internal.GmsLogger r2 = f20250b     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            r5.<init>()     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            r5.append(r0)     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            r5.append(r9)     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            r2.n(r1, r5)     // Catch:{ IOException -> 0x0059, all -> 0x0057 }
            goto L_0x0091
        L_0x0073:
            r3 = r4
            goto L_0x00a7
        L_0x0075:
            r2 = move-exception
            goto L_0x0079
        L_0x0077:
            r9 = move-exception
            goto L_0x00a7
        L_0x0079:
            r4 = r3
        L_0x007a:
            com.google.android.gms.common.internal.GmsLogger r5 = f20250b     // Catch:{ all -> 0x0077 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r6.<init>()     // Catch:{ all -> 0x0077 }
            r6.append(r0)     // Catch:{ all -> 0x0077 }
            r6.append(r9)     // Catch:{ all -> 0x0077 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0077 }
            r5.f(r1, r0, r2)     // Catch:{ all -> 0x0077 }
            r7 = r4
            r4 = r3
            r3 = r7
        L_0x0091:
            if (r4 == 0) goto L_0x0096
            com.google.android.gms.common.util.IOUtils.b(r4)
        L_0x0096:
            if (r3 != 0) goto L_0x00a1
            com.google.android.gms.common.internal.GmsLogger r0 = f20250b
            java.lang.String r2 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"
            r0.c(r1, r2)
            java.lang.String r3 = "UNKNOWN"
        L_0x00a1:
            java.util.concurrent.ConcurrentHashMap r0 = r8.f20252a
            r0.put(r9, r3)
            return r3
        L_0x00a7:
            if (r3 == 0) goto L_0x00ac
            com.google.android.gms.common.util.IOUtils.b(r3)
        L_0x00ac:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.LibraryVersion.b(java.lang.String):java.lang.String");
    }
}
