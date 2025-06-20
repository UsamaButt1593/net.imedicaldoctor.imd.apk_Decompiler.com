package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;
import java.util.HashSet;

@UnstableApi
public final class MediaLibraryInfo {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9204a = "AndroidXMedia3";

    /* renamed from: b  reason: collision with root package name */
    public static final String f9205b = "1.3.1";

    /* renamed from: c  reason: collision with root package name */
    public static final String f9206c = "AndroidXMedia3/1.3.1";

    /* renamed from: d  reason: collision with root package name */
    public static final int f9207d = 1003001300;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f9208e = true;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f9209f = true;

    /* renamed from: g  reason: collision with root package name */
    private static final HashSet<String> f9210g = new HashSet<>();

    /* renamed from: h  reason: collision with root package name */
    private static String f9211h = "media3.common";

    private MediaLibraryInfo() {
    }

    public static synchronized void a(String str) {
        synchronized (MediaLibraryInfo.class) {
            if (f9210g.add(str)) {
                f9211h += ", " + str;
            }
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (MediaLibraryInfo.class) {
            str = f9211h;
        }
        return str;
    }
}
