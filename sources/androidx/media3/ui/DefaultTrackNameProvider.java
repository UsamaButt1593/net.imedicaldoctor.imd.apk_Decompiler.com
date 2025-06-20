package androidx.media3.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.Locale;

@UnstableApi
public class DefaultTrackNameProvider implements TrackNameProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f14626a;

    public DefaultTrackNameProvider(Resources resources) {
        this.f14626a = (Resources) Assertions.g(resources);
    }

    private String b(Format format) {
        Resources resources;
        int i2;
        int i3 = format.s3;
        if (i3 == -1 || i3 < 1) {
            return "";
        }
        if (i3 == 1) {
            resources = this.f14626a;
            i2 = R.string.C;
        } else if (i3 == 2) {
            resources = this.f14626a;
            i2 = R.string.N;
        } else if (i3 == 6 || i3 == 7) {
            resources = this.f14626a;
            i2 = R.string.P;
        } else if (i3 != 8) {
            resources = this.f14626a;
            i2 = R.string.O;
        } else {
            resources = this.f14626a;
            i2 = R.string.Q;
        }
        return resources.getString(i2);
    }

    private String c(Format format) {
        int i2 = format.b3;
        if (i2 == -1) {
            return "";
        }
        return this.f14626a.getString(R.string.B, new Object[]{Float.valueOf(((float) i2) / 1000000.0f)});
    }

    private String d(Format format) {
        return TextUtils.isEmpty(format.X) ? "" : format.X;
    }

    private String e(Format format) {
        String j2 = j(f(format), h(format));
        return TextUtils.isEmpty(j2) ? d(format) : j2;
    }

    private String f(Format format) {
        String str = format.Z;
        if (TextUtils.isEmpty(str) || C.k1.equals(str)) {
            return "";
        }
        Locale forLanguageTag = Util.f9646a >= 21 ? Locale.forLanguageTag(str) : new Locale(str);
        Locale n0 = Util.n0();
        String displayName = forLanguageTag.getDisplayName(n0);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int offsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, offsetByCodePoints).toUpperCase(n0) + displayName.substring(offsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    private String g(Format format) {
        int i2 = format.k3;
        int i3 = format.l3;
        if (i2 == -1 || i3 == -1) {
            return "";
        }
        return this.f14626a.getString(R.string.D, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    private String h(Format format) {
        String string = (format.Y2 & 2) != 0 ? this.f14626a.getString(R.string.E) : "";
        if ((format.Y2 & 4) != 0) {
            string = j(string, this.f14626a.getString(R.string.H));
        }
        if ((format.Y2 & 8) != 0) {
            string = j(string, this.f14626a.getString(R.string.G));
        }
        return (format.Y2 & 1088) != 0 ? j(string, this.f14626a.getString(R.string.F)) : string;
    }

    private static int i(Format format) {
        int l2 = MimeTypes.l(format.f3);
        if (l2 != -1) {
            return l2;
        }
        if (MimeTypes.o(format.c3) != null) {
            return 2;
        }
        if (MimeTypes.c(format.c3) != null) {
            return 1;
        }
        if (format.k3 == -1 && format.l3 == -1) {
            return (format.s3 == -1 && format.t3 == -1) ? -1 : 1;
        }
        return 2;
    }

    private String j(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                if (TextUtils.isEmpty(str)) {
                    str = str2;
                } else {
                    str = this.f14626a.getString(R.string.A, new Object[]{str, str2});
                }
            }
        }
        return str;
    }

    public String a(Format format) {
        int i2 = i(format);
        String j2 = i2 == 2 ? j(h(format), g(format), c(format)) : i2 == 1 ? j(e(format), b(format), c(format)) : e(format);
        if (j2.length() != 0) {
            return j2;
        }
        String str = format.Z;
        if (str == null || str.trim().isEmpty()) {
            return this.f14626a.getString(R.string.R);
        }
        return this.f14626a.getString(R.string.S, new Object[]{str});
    }
}
