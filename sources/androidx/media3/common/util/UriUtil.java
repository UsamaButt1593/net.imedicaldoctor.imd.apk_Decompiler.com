package androidx.media3.common.util;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import java.util.List;

@UnstableApi
public final class UriUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final int f9641a = 4;

    /* renamed from: b  reason: collision with root package name */
    private static final int f9642b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f9643c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f9644d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static final int f9645e = 3;

    private UriUtil() {
    }

    @UnstableApi
    public static String a(Uri uri, Uri uri2) {
        if (uri.isOpaque() || uri2.isOpaque()) {
            return uri2.toString();
        }
        String scheme = uri.getScheme();
        String scheme2 = uri2.getScheme();
        if (scheme != null ? !(scheme2 == null || !Ascii.a(scheme, scheme2)) : scheme2 == null) {
            if (Util.g(uri.getAuthority(), uri2.getAuthority())) {
                List<String> pathSegments = uri.getPathSegments();
                List<String> pathSegments2 = uri2.getPathSegments();
                int min = Math.min(pathSegments.size(), pathSegments2.size());
                int i2 = 0;
                int i3 = 0;
                while (i2 < min && pathSegments.get(i2).equals(pathSegments2.get(i2))) {
                    i3++;
                    i2++;
                }
                StringBuilder sb = new StringBuilder();
                for (int i4 = i3; i4 < pathSegments.size(); i4++) {
                    sb.append("../");
                }
                while (i3 < pathSegments2.size()) {
                    sb.append(pathSegments2.get(i3));
                    if (i3 < pathSegments2.size() - 1) {
                        sb.append("/");
                    }
                    i3++;
                }
                return sb.toString();
            }
        }
        return uri2.toString();
    }

    private static int[] b(String str) {
        int i2;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i3 = indexOf4 + 2;
        if (i3 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i3) == '/') {
            i2 = str.indexOf(47, indexOf4 + 3);
            if (i2 == -1 || i2 > indexOf2) {
                i2 = indexOf2;
            }
        } else {
            i2 = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i2;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }

    public static boolean c(@Nullable String str) {
        return (str == null || b(str)[0] == -1) ? false : true;
    }

    private static String d(StringBuilder sb, int i2, int i3) {
        int i4;
        int i5;
        if (i2 >= i3) {
            return sb.toString();
        }
        if (sb.charAt(i2) == '/') {
            i2++;
        }
        int i6 = i2;
        int i7 = i6;
        while (i6 <= i3) {
            if (i6 == i3) {
                i4 = i6;
            } else if (sb.charAt(i6) == '/') {
                i4 = i6 + 1;
            } else {
                i6++;
            }
            int i8 = i7 + 1;
            if (i6 == i8 && sb.charAt(i7) == '.') {
                sb.delete(i7, i4);
                i3 -= i4 - i7;
            } else {
                if (i6 == i7 + 2 && sb.charAt(i7) == '.' && sb.charAt(i8) == '.') {
                    i5 = sb.lastIndexOf("/", i7 - 2) + 1;
                    int i9 = i5 > i2 ? i5 : i2;
                    sb.delete(i9, i4);
                    i3 -= i4 - i9;
                } else {
                    i5 = i6 + 1;
                }
                i7 = i5;
            }
            i6 = i7;
        }
        return sb.toString();
    }

    public static Uri e(Uri uri, String str) {
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.clearQuery();
        for (String next : uri.getQueryParameterNames()) {
            if (!next.equals(str)) {
                for (String appendQueryParameter : uri.getQueryParameters(next)) {
                    buildUpon.appendQueryParameter(next, appendQueryParameter);
                }
            }
        }
        return buildUpon.build();
    }

    public static String f(@Nullable String str, @Nullable String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] b2 = b(str2);
        if (b2[0] != -1) {
            sb.append(str2);
            d(sb, b2[1], b2[2]);
            return sb.toString();
        }
        int[] b3 = b(str);
        if (b2[3] == 0) {
            sb.append(str, 0, b3[3]);
            sb.append(str2);
            return sb.toString();
        } else if (b2[2] == 0) {
            sb.append(str, 0, b3[2]);
            sb.append(str2);
            return sb.toString();
        } else {
            int i2 = b2[1];
            if (i2 != 0) {
                int i3 = b3[0] + 1;
                sb.append(str, 0, i3);
                sb.append(str2);
                return d(sb, b2[1] + i3, i3 + b2[2]);
            } else if (str2.charAt(i2) == '/') {
                sb.append(str, 0, b3[1]);
                sb.append(str2);
                int i4 = b3[1];
                return d(sb, i4, b2[2] + i4);
            } else {
                int i5 = b3[0] + 2;
                int i6 = b3[1];
                if (i5 >= i6 || i6 != b3[2]) {
                    int lastIndexOf = str.lastIndexOf(47, b3[2] - 1);
                    int i7 = lastIndexOf == -1 ? b3[1] : lastIndexOf + 1;
                    sb.append(str, 0, i7);
                    sb.append(str2);
                    return d(sb, b3[1], i7 + b2[2]);
                }
                sb.append(str, 0, i6);
                sb.append('/');
                sb.append(str2);
                int i8 = b3[1];
                return d(sb, i8, b2[2] + i8 + 1);
            }
        }
    }

    public static Uri g(@Nullable String str, @Nullable String str2) {
        return Uri.parse(f(str, str2));
    }
}
