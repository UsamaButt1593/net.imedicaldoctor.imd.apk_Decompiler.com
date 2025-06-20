package com.google.firebase.crashlytics.internal.persistence;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.ProcessDetailsProvider;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileStore {

    /* renamed from: h  reason: collision with root package name */
    private static final String f24207h = ".com.google.firebase.crashlytics.files.v1";

    /* renamed from: i  reason: collision with root package name */
    private static final String f24208i = ".com.google.firebase.crashlytics.files.v2";

    /* renamed from: j  reason: collision with root package name */
    private static final String f24209j = ".crashlytics.v3";

    /* renamed from: k  reason: collision with root package name */
    private static final String f24210k = "open-sessions";

    /* renamed from: l  reason: collision with root package name */
    private static final String f24211l = "native";

    /* renamed from: m  reason: collision with root package name */
    private static final String f24212m = "reports";

    /* renamed from: n  reason: collision with root package name */
    private static final String f24213n = "priority-reports";
    private static final String o = "native-reports";

    /* renamed from: a  reason: collision with root package name */
    final String f24214a;

    /* renamed from: b  reason: collision with root package name */
    private final File f24215b;

    /* renamed from: c  reason: collision with root package name */
    private final File f24216c;

    /* renamed from: d  reason: collision with root package name */
    private final File f24217d;

    /* renamed from: e  reason: collision with root package name */
    private final File f24218e;

    /* renamed from: f  reason: collision with root package name */
    private final File f24219f;

    /* renamed from: g  reason: collision with root package name */
    private final File f24220g;

    public FileStore(Context context) {
        String str;
        String d2 = ProcessDetailsProvider.f23508a.g(context).d();
        this.f24214a = d2;
        File filesDir = context.getFilesDir();
        this.f24215b = filesDir;
        if (z()) {
            str = f24209j + File.separator + y(d2);
        } else {
            str = f24207h;
        }
        File u = u(new File(filesDir, str));
        this.f24216c = u;
        this.f24217d = u(new File(u, f24210k));
        this.f24218e = u(new File(u, f24212m));
        this.f24219f = u(new File(u, f24213n));
        this.f24220g = u(new File(u, o));
    }

    private void b(String str) {
        File file = new File(this.f24215b, str);
        if (file.exists() && w(file)) {
            Logger f2 = Logger.f();
            f2.b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    private void c(String str) {
        String[] list;
        if (this.f24215b.exists() && (list = this.f24215b.list(new e(str))) != null) {
            for (String b2 : list) {
                b(b2);
            }
        }
    }

    private File q(String str) {
        return v(new File(this.f24217d, str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.io.File u(java.io.File r4) {
        /*
            java.lang.Class<com.google.firebase.crashlytics.internal.persistence.FileStore> r0 = com.google.firebase.crashlytics.internal.persistence.FileStore.class
            monitor-enter(r0)
            boolean r1 = r4.exists()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0034
            boolean r1 = r4.isDirectory()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0011
            monitor-exit(r0)
            return r4
        L_0x0011:
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.f()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r2.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "Unexpected non-directory file: "
            r2.append(r3)     // Catch:{ all -> 0x0032 }
            r2.append(r4)     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "; deleting file and creating new directory."
            r2.append(r3)     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0032 }
            r1.b(r2)     // Catch:{ all -> 0x0032 }
            r4.delete()     // Catch:{ all -> 0x0032 }
            goto L_0x0034
        L_0x0032:
            r4 = move-exception
            goto L_0x0054
        L_0x0034:
            boolean r1 = r4.mkdirs()     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0052
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.f()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r2.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "Could not create Crashlytics-specific directory: "
            r2.append(r3)     // Catch:{ all -> 0x0032 }
            r2.append(r4)     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0032 }
            r1.d(r2)     // Catch:{ all -> 0x0032 }
        L_0x0052:
            monitor-exit(r0)
            return r4
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.persistence.FileStore.u(java.io.File):java.io.File");
    }

    private static File v(File file) {
        file.mkdirs();
        return file;
    }

    static boolean w(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File w : listFiles) {
                w(w);
            }
        }
        return file.delete();
    }

    private static <T> List<T> x(@Nullable T[] tArr) {
        return tArr == null ? Collections.emptyList() : Arrays.asList(tArr);
    }

    @VisibleForTesting
    static String y(String str) {
        return str.length() > 40 ? CommonUtils.C(str) : str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    private boolean z() {
        return !this.f24214a.isEmpty();
    }

    public void d() {
        b(".com.google.firebase.crashlytics");
        b(".com.google.firebase.crashlytics-ndk");
        if (z()) {
            b(f24207h);
            c(f24208i + File.pathSeparator);
        }
    }

    @VisibleForTesting
    public void e() {
        w(this.f24216c);
    }

    public boolean f(String str) {
        return w(new File(this.f24217d, str));
    }

    public List<String> g() {
        return x(this.f24217d.list());
    }

    public File h(String str) {
        return new File(this.f24216c, str);
    }

    public List<File> i(FilenameFilter filenameFilter) {
        return x(this.f24216c.listFiles(filenameFilter));
    }

    public File j(String str) {
        return new File(this.f24220g, str);
    }

    public List<File> k() {
        return x(this.f24220g.listFiles());
    }

    public File l(String str) {
        return v(new File(q(str), f24211l));
    }

    public File m(String str) {
        return new File(this.f24219f, str);
    }

    public List<File> n() {
        return x(this.f24219f.listFiles());
    }

    public File o(String str) {
        return new File(this.f24218e, str);
    }

    public List<File> p() {
        return x(this.f24218e.listFiles());
    }

    public File r(String str, String str2) {
        return new File(q(str), str2);
    }

    public List<File> s(String str, FilenameFilter filenameFilter) {
        return x(q(str).listFiles(filenameFilter));
    }
}
