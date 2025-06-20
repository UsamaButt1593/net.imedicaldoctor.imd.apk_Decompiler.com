package com.bumptech.glide.load.engine.executor;

import android.os.StrictMode;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

final class RuntimeCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18094a = "GlideRuntimeCompat";

    /* renamed from: b  reason: collision with root package name */
    private static final String f18095b = "cpu[0-9]+";

    /* renamed from: c  reason: collision with root package name */
    private static final String f18096c = "/sys/devices/system/cpu/";

    private RuntimeCompat() {
    }

    static int a() {
        return Runtime.getRuntime().availableProcessors();
    }

    /* JADX INFO: finally extract failed */
    private static int b() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            File file = new File(f18096c);
            final Pattern compile = Pattern.compile(f18095b);
            fileArr = file.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return compile.matcher(str).matches();
                }
            });
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        return Math.max(1, fileArr != null ? fileArr.length : 0);
    }
}
