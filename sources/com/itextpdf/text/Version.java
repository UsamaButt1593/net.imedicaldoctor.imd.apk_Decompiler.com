package com.itextpdf.text;

import org.apache.commons.lang3.StringUtils;

public final class Version {

    /* renamed from: e  reason: collision with root package name */
    public static String f25731e = " (AGPL-version)";

    /* renamed from: f  reason: collision with root package name */
    private static Version f25732f;

    /* renamed from: a  reason: collision with root package name */
    private String f25733a = "iText®";

    /* renamed from: b  reason: collision with root package name */
    private String f25734b = "5.5.9";

    /* renamed from: c  reason: collision with root package name */
    private String f25735c = (this.f25733a + StringUtils.SPACE + this.f25734b + " ©2000-2015 iText Group NV");

    /* renamed from: d  reason: collision with root package name */
    private String f25736d = null;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0039, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r1 = new java.lang.StringBuilder();
        r2 = f25732f;
        r1.append(r2.f25735c);
        r1.append(f25731e);
        r2.f25735c = r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0195, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x017b */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0083 A[Catch:{ Exception -> 0x017b }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008b A[Catch:{ Exception -> 0x017b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.itextpdf.text.Version a() {
        /*
            com.itextpdf.text.Version r0 = f25732f
            if (r0 != 0) goto L_0x0196
            com.itextpdf.text.Version r0 = new com.itextpdf.text.Version
            r0.<init>()
            f25732f = r0
            monitor-enter(r0)
            java.lang.String r1 = "com.itextpdf.license.LicenseKey"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x017b }
            java.lang.String r2 = "getLicenseeInfo"
            r3 = 0
            java.lang.reflect.Method r2 = r1.getMethod(r2, r3)     // Catch:{ Exception -> 0x017b }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ Exception -> 0x017b }
            java.lang.Object r1 = r2.invoke(r1, r3)     // Catch:{ Exception -> 0x017b }
            java.lang.String[] r1 = (java.lang.String[]) r1     // Catch:{ Exception -> 0x017b }
            r2 = 3
            r3 = r1[r2]     // Catch:{ Exception -> 0x017b }
            if (r3 == 0) goto L_0x003c
            java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x017b }
            int r3 = r3.length()     // Catch:{ Exception -> 0x017b }
            if (r3 <= 0) goto L_0x003c
            com.itextpdf.text.Version r3 = f25732f     // Catch:{ Exception -> 0x017b }
            r2 = r1[r2]     // Catch:{ Exception -> 0x017b }
        L_0x0036:
            r3.f25736d = r2     // Catch:{ Exception -> 0x017b }
            goto L_0x0074
        L_0x0039:
            r1 = move-exception
            goto L_0x0194
        L_0x003c:
            com.itextpdf.text.Version r2 = f25732f     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = "Trial version "
            r2.f25736d = r3     // Catch:{ Exception -> 0x017b }
            r2 = 5
            r3 = r1[r2]     // Catch:{ Exception -> 0x017b }
            if (r3 != 0) goto L_0x005d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017b }
            r2.<init>()     // Catch:{ Exception -> 0x017b }
            com.itextpdf.text.Version r3 = f25732f     // Catch:{ Exception -> 0x017b }
            java.lang.String r4 = r3.f25736d     // Catch:{ Exception -> 0x017b }
            r2.append(r4)     // Catch:{ Exception -> 0x017b }
            java.lang.String r4 = "unauthorised"
            r2.append(r4)     // Catch:{ Exception -> 0x017b }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x017b }
            goto L_0x0036
        L_0x005d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017b }
            r3.<init>()     // Catch:{ Exception -> 0x017b }
            com.itextpdf.text.Version r4 = f25732f     // Catch:{ Exception -> 0x017b }
            java.lang.String r5 = r4.f25736d     // Catch:{ Exception -> 0x017b }
            r3.append(r5)     // Catch:{ Exception -> 0x017b }
            r2 = r1[r2]     // Catch:{ Exception -> 0x017b }
            r3.append(r2)     // Catch:{ Exception -> 0x017b }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x017b }
            r4.f25736d = r2     // Catch:{ Exception -> 0x017b }
        L_0x0074:
            r2 = 4
            r3 = r1[r2]     // Catch:{ Exception -> 0x017b }
            if (r3 == 0) goto L_0x008b
            java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x017b }
            int r3 = r3.length()     // Catch:{ Exception -> 0x017b }
            if (r3 <= 0) goto L_0x008b
            com.itextpdf.text.Version r3 = f25732f     // Catch:{ Exception -> 0x017b }
            r1 = r1[r2]     // Catch:{ Exception -> 0x017b }
            r3.f25735c = r1     // Catch:{ Exception -> 0x017b }
            goto L_0x0192
        L_0x008b:
            r2 = 2
            r3 = r1[r2]     // Catch:{ Exception -> 0x017b }
            if (r3 == 0) goto L_0x0101
            java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x017b }
            int r3 = r3.length()     // Catch:{ Exception -> 0x017b }
            if (r3 <= 0) goto L_0x0101
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017b }
            r3.<init>()     // Catch:{ Exception -> 0x017b }
            com.itextpdf.text.Version r4 = f25732f     // Catch:{ Exception -> 0x017b }
            java.lang.String r5 = r4.f25735c     // Catch:{ Exception -> 0x017b }
            r3.append(r5)     // Catch:{ Exception -> 0x017b }
            java.lang.String r5 = " ("
            r3.append(r5)     // Catch:{ Exception -> 0x017b }
            r1 = r1[r2]     // Catch:{ Exception -> 0x017b }
            r3.append(r1)     // Catch:{ Exception -> 0x017b }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x017b }
            r4.f25735c = r1     // Catch:{ Exception -> 0x017b }
            com.itextpdf.text.Version r1 = f25732f     // Catch:{ Exception -> 0x017b }
            java.lang.String r1 = r1.f25736d     // Catch:{ Exception -> 0x017b }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ Exception -> 0x017b }
            java.lang.String r2 = "trial"
            boolean r1 = r1.startsWith(r2)     // Catch:{ Exception -> 0x017b }
            if (r1 != 0) goto L_0x00df
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017b }
            r1.<init>()     // Catch:{ Exception -> 0x017b }
            com.itextpdf.text.Version r2 = f25732f     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = r2.f25735c     // Catch:{ Exception -> 0x017b }
            r1.append(r3)     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = "; licensed version)"
            r1.append(r3)     // Catch:{ Exception -> 0x017b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x017b }
        L_0x00db:
            r2.f25735c = r1     // Catch:{ Exception -> 0x017b }
            goto L_0x0192
        L_0x00df:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017b }
            r1.<init>()     // Catch:{ Exception -> 0x017b }
            com.itextpdf.text.Version r2 = f25732f     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = r2.f25735c     // Catch:{ Exception -> 0x017b }
            r1.append(r3)     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = "; "
            r1.append(r3)     // Catch:{ Exception -> 0x017b }
            com.itextpdf.text.Version r3 = f25732f     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = r3.f25736d     // Catch:{ Exception -> 0x017b }
            r1.append(r3)     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = ")"
            r1.append(r3)     // Catch:{ Exception -> 0x017b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x017b }
            goto L_0x00db
        L_0x0101:
            r2 = 0
            r3 = r1[r2]     // Catch:{ Exception -> 0x017b }
            if (r3 == 0) goto L_0x0175
            java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x017b }
            int r3 = r3.length()     // Catch:{ Exception -> 0x017b }
            if (r3 <= 0) goto L_0x0175
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017b }
            r3.<init>()     // Catch:{ Exception -> 0x017b }
            com.itextpdf.text.Version r4 = f25732f     // Catch:{ Exception -> 0x017b }
            java.lang.String r5 = r4.f25735c     // Catch:{ Exception -> 0x017b }
            r3.append(r5)     // Catch:{ Exception -> 0x017b }
            java.lang.String r5 = " ("
            r3.append(r5)     // Catch:{ Exception -> 0x017b }
            r1 = r1[r2]     // Catch:{ Exception -> 0x017b }
            r3.append(r1)     // Catch:{ Exception -> 0x017b }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x017b }
            r4.f25735c = r1     // Catch:{ Exception -> 0x017b }
            com.itextpdf.text.Version r1 = f25732f     // Catch:{ Exception -> 0x017b }
            java.lang.String r1 = r1.f25736d     // Catch:{ Exception -> 0x017b }
            java.lang.String r1 = r1.toLowerCase()     // Catch:{ Exception -> 0x017b }
            java.lang.String r2 = "trial"
            boolean r1 = r1.startsWith(r2)     // Catch:{ Exception -> 0x017b }
            if (r1 != 0) goto L_0x0152
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017b }
            r1.<init>()     // Catch:{ Exception -> 0x017b }
            com.itextpdf.text.Version r2 = f25732f     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = r2.f25735c     // Catch:{ Exception -> 0x017b }
            r1.append(r3)     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = "; licensed version)"
            r1.append(r3)     // Catch:{ Exception -> 0x017b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x017b }
            goto L_0x00db
        L_0x0152:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017b }
            r1.<init>()     // Catch:{ Exception -> 0x017b }
            com.itextpdf.text.Version r2 = f25732f     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = r2.f25735c     // Catch:{ Exception -> 0x017b }
            r1.append(r3)     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = "; "
            r1.append(r3)     // Catch:{ Exception -> 0x017b }
            com.itextpdf.text.Version r3 = f25732f     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = r3.f25736d     // Catch:{ Exception -> 0x017b }
            r1.append(r3)     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = ")"
            r1.append(r3)     // Catch:{ Exception -> 0x017b }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x017b }
            goto L_0x00db
        L_0x0175:
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ Exception -> 0x017b }
            r1.<init>()     // Catch:{ Exception -> 0x017b }
            throw r1     // Catch:{ Exception -> 0x017b }
        L_0x017b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r1.<init>()     // Catch:{ all -> 0x0039 }
            com.itextpdf.text.Version r2 = f25732f     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = r2.f25735c     // Catch:{ all -> 0x0039 }
            r1.append(r3)     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = f25731e     // Catch:{ all -> 0x0039 }
            r1.append(r3)     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0039 }
            r2.f25735c = r1     // Catch:{ all -> 0x0039 }
        L_0x0192:
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            goto L_0x0196
        L_0x0194:
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r1
        L_0x0196:
            com.itextpdf.text.Version r0 = f25732f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Version.a():com.itextpdf.text.Version");
    }

    public static boolean f() {
        return a().e().indexOf(f25731e) > 0;
    }

    public String b() {
        return this.f25736d;
    }

    public String c() {
        return this.f25733a;
    }

    public String d() {
        return this.f25734b;
    }

    public String e() {
        return this.f25735c;
    }
}
