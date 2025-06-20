package androidx.media3.extractor.text.ssa;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.primitives.Ints;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;

final class SsaStyle {

    /* renamed from: k  reason: collision with root package name */
    private static final String f13956k = "SsaStyle";

    /* renamed from: l  reason: collision with root package name */
    public static final int f13957l = -1;

    /* renamed from: m  reason: collision with root package name */
    public static final int f13958m = 1;

    /* renamed from: n  reason: collision with root package name */
    public static final int f13959n = 2;
    public static final int o = 3;
    public static final int p = 4;
    public static final int q = 5;
    public static final int r = 6;
    public static final int s = 7;
    public static final int t = 8;
    public static final int u = 9;
    public static final int v = -1;
    public static final int w = 1;
    public static final int x = 3;

    /* renamed from: a  reason: collision with root package name */
    public final String f13960a;

    /* renamed from: b  reason: collision with root package name */
    public final int f13961b;
    @ColorInt
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Integer f13962c;
    @ColorInt
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Integer f13963d;

    /* renamed from: e  reason: collision with root package name */
    public final float f13964e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f13965f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f13966g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f13967h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f13968i;

    /* renamed from: j  reason: collision with root package name */
    public final int f13969j;

    static final class Format {

        /* renamed from: a  reason: collision with root package name */
        public final int f13970a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13971b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13972c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13973d;

        /* renamed from: e  reason: collision with root package name */
        public final int f13974e;

        /* renamed from: f  reason: collision with root package name */
        public final int f13975f;

        /* renamed from: g  reason: collision with root package name */
        public final int f13976g;

        /* renamed from: h  reason: collision with root package name */
        public final int f13977h;

        /* renamed from: i  reason: collision with root package name */
        public final int f13978i;

        /* renamed from: j  reason: collision with root package name */
        public final int f13979j;

        /* renamed from: k  reason: collision with root package name */
        public final int f13980k;

        private Format(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.f13970a = i2;
            this.f13971b = i3;
            this.f13972c = i4;
            this.f13973d = i5;
            this.f13974e = i6;
            this.f13975f = i7;
            this.f13976g = i8;
            this.f13977h = i9;
            this.f13978i = i10;
            this.f13979j = i11;
            this.f13980k = i12;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        @androidx.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static androidx.media3.extractor.text.ssa.SsaStyle.Format a(java.lang.String r18) {
            /*
                r0 = 1
                r1 = 7
                r2 = r18
                java.lang.String r2 = r2.substring(r1)
                java.lang.String r3 = ","
                java.lang.String[] r2 = android.text.TextUtils.split(r2, r3)
                r3 = -1
                r4 = 0
                r5 = 0
                r7 = -1
                r8 = -1
                r9 = -1
                r10 = -1
                r11 = -1
                r12 = -1
                r13 = -1
                r14 = -1
                r15 = -1
                r16 = -1
            L_0x001c:
                int r6 = r2.length
                if (r5 >= r6) goto L_0x00c3
                r6 = r2[r5]
                java.lang.String r6 = r6.trim()
                java.lang.String r6 = com.google.common.base.Ascii.g(r6)
                r6.hashCode()
                int r17 = r6.hashCode()
                switch(r17) {
                    case -1178781136: goto L_0x009d;
                    case -1026963764: goto L_0x0092;
                    case -192095652: goto L_0x0087;
                    case -70925746: goto L_0x007c;
                    case 3029637: goto L_0x0071;
                    case 3373707: goto L_0x0066;
                    case 366554320: goto L_0x005b;
                    case 767321349: goto L_0x0050;
                    case 1767875043: goto L_0x0043;
                    case 1988365454: goto L_0x0036;
                    default: goto L_0x0033;
                }
            L_0x0033:
                r1 = -1
                goto L_0x00a7
            L_0x0036:
                java.lang.String r1 = "outlinecolour"
                boolean r1 = r6.equals(r1)
                if (r1 != 0) goto L_0x003f
                goto L_0x0033
            L_0x003f:
                r1 = 9
                goto L_0x00a7
            L_0x0043:
                java.lang.String r1 = "alignment"
                boolean r1 = r6.equals(r1)
                if (r1 != 0) goto L_0x004c
                goto L_0x0033
            L_0x004c:
                r1 = 8
                goto L_0x00a7
            L_0x0050:
                java.lang.String r1 = "borderstyle"
                boolean r1 = r6.equals(r1)
                if (r1 != 0) goto L_0x0059
                goto L_0x0033
            L_0x0059:
                r1 = 7
                goto L_0x00a7
            L_0x005b:
                java.lang.String r1 = "fontsize"
                boolean r1 = r6.equals(r1)
                if (r1 != 0) goto L_0x0064
                goto L_0x0033
            L_0x0064:
                r1 = 6
                goto L_0x00a7
            L_0x0066:
                java.lang.String r1 = "name"
                boolean r1 = r6.equals(r1)
                if (r1 != 0) goto L_0x006f
                goto L_0x0033
            L_0x006f:
                r1 = 5
                goto L_0x00a7
            L_0x0071:
                java.lang.String r1 = "bold"
                boolean r1 = r6.equals(r1)
                if (r1 != 0) goto L_0x007a
                goto L_0x0033
            L_0x007a:
                r1 = 4
                goto L_0x00a7
            L_0x007c:
                java.lang.String r1 = "primarycolour"
                boolean r1 = r6.equals(r1)
                if (r1 != 0) goto L_0x0085
                goto L_0x0033
            L_0x0085:
                r1 = 3
                goto L_0x00a7
            L_0x0087:
                java.lang.String r1 = "strikeout"
                boolean r1 = r6.equals(r1)
                if (r1 != 0) goto L_0x0090
                goto L_0x0033
            L_0x0090:
                r1 = 2
                goto L_0x00a7
            L_0x0092:
                java.lang.String r1 = "underline"
                boolean r1 = r6.equals(r1)
                if (r1 != 0) goto L_0x009b
                goto L_0x0033
            L_0x009b:
                r1 = 1
                goto L_0x00a7
            L_0x009d:
                java.lang.String r1 = "italic"
                boolean r1 = r6.equals(r1)
                if (r1 != 0) goto L_0x00a6
                goto L_0x0033
            L_0x00a6:
                r1 = 0
            L_0x00a7:
                switch(r1) {
                    case 0: goto L_0x00be;
                    case 1: goto L_0x00bc;
                    case 2: goto L_0x00ba;
                    case 3: goto L_0x00b8;
                    case 4: goto L_0x00b6;
                    case 5: goto L_0x00b4;
                    case 6: goto L_0x00b2;
                    case 7: goto L_0x00af;
                    case 8: goto L_0x00ad;
                    case 9: goto L_0x00ab;
                    default: goto L_0x00aa;
                }
            L_0x00aa:
                goto L_0x00bf
            L_0x00ab:
                r10 = r5
                goto L_0x00bf
            L_0x00ad:
                r8 = r5
                goto L_0x00bf
            L_0x00af:
                r16 = r5
                goto L_0x00bf
            L_0x00b2:
                r11 = r5
                goto L_0x00bf
            L_0x00b4:
                r7 = r5
                goto L_0x00bf
            L_0x00b6:
                r12 = r5
                goto L_0x00bf
            L_0x00b8:
                r9 = r5
                goto L_0x00bf
            L_0x00ba:
                r15 = r5
                goto L_0x00bf
            L_0x00bc:
                r14 = r5
                goto L_0x00bf
            L_0x00be:
                r13 = r5
            L_0x00bf:
                int r5 = r5 + r0
                r1 = 7
                goto L_0x001c
            L_0x00c3:
                if (r7 == r3) goto L_0x00cf
                androidx.media3.extractor.text.ssa.SsaStyle$Format r0 = new androidx.media3.extractor.text.ssa.SsaStyle$Format
                int r1 = r2.length
                r6 = r0
                r17 = r1
                r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
                goto L_0x00d0
            L_0x00cf:
                r0 = 0
            L_0x00d0:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ssa.SsaStyle.Format.a(java.lang.String):androidx.media3.extractor.text.ssa.SsaStyle$Format");
        }
    }

    static final class Overrides {

        /* renamed from: c  reason: collision with root package name */
        private static final String f13981c = "SsaStyle.Overrides";

        /* renamed from: d  reason: collision with root package name */
        private static final Pattern f13982d = Pattern.compile("\\{([^}]*)\\}");

        /* renamed from: e  reason: collision with root package name */
        private static final String f13983e = "\\s*\\d+(?:\\.\\d+)?\\s*";

        /* renamed from: f  reason: collision with root package name */
        private static final Pattern f13984f = Pattern.compile(Util.S("\\\\pos\\((%1$s),(%1$s)\\)", f13983e));

        /* renamed from: g  reason: collision with root package name */
        private static final Pattern f13985g = Pattern.compile(Util.S("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", f13983e));

        /* renamed from: h  reason: collision with root package name */
        private static final Pattern f13986h = Pattern.compile("\\\\an(\\d+)");

        /* renamed from: a  reason: collision with root package name */
        public final int f13987a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final PointF f13988b;

        private Overrides(int i2, @Nullable PointF pointF) {
            this.f13987a = i2;
            this.f13988b = pointF;
        }

        private static int a(String str) {
            Matcher matcher = f13986h.matcher(str);
            if (matcher.find()) {
                return SsaStyle.e((String) Assertions.g(matcher.group(1)));
            }
            return -1;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|5|(1:7)|8|9|(2:11|18)(1:17)|15|1) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0021 */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0009 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static androidx.media3.extractor.text.ssa.SsaStyle.Overrides b(java.lang.String r5) {
            /*
                java.util.regex.Pattern r0 = f13982d
                java.util.regex.Matcher r5 = r0.matcher(r5)
                r0 = -1
                r1 = 0
                r2 = -1
            L_0x0009:
                boolean r3 = r5.find()
                if (r3 == 0) goto L_0x002b
                r3 = 1
                java.lang.String r3 = r5.group(r3)
                java.lang.Object r3 = androidx.media3.common.util.Assertions.g(r3)
                java.lang.String r3 = (java.lang.String) r3
                android.graphics.PointF r4 = c(r3)     // Catch:{ RuntimeException -> 0x0021 }
                if (r4 == 0) goto L_0x0021
                r1 = r4
            L_0x0021:
                int r3 = a(r3)     // Catch:{ RuntimeException -> 0x0029 }
                if (r3 == r0) goto L_0x0009
                r2 = r3
                goto L_0x0009
            L_0x0029:
                goto L_0x0009
            L_0x002b:
                androidx.media3.extractor.text.ssa.SsaStyle$Overrides r5 = new androidx.media3.extractor.text.ssa.SsaStyle$Overrides
                r5.<init>(r2, r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ssa.SsaStyle.Overrides.b(java.lang.String):androidx.media3.extractor.text.ssa.SsaStyle$Overrides");
        }

        @Nullable
        private static PointF c(String str) {
            String str2;
            String str3;
            Matcher matcher = f13984f.matcher(str);
            Matcher matcher2 = f13985g.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    Log.h(f13981c, "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                str2 = matcher.group(1);
                str3 = matcher.group(2);
            } else if (!find2) {
                return null;
            } else {
                str2 = matcher2.group(1);
                str3 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) Assertions.g(str2)).trim()), Float.parseFloat(((String) Assertions.g(str3)).trim()));
        }

        public static String d(String str) {
            return f13982d.matcher(str).replaceAll("");
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SsaAlignment {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SsaBorderStyle {
    }

    private SsaStyle(String str, int i2, @ColorInt @Nullable Integer num, @ColorInt @Nullable Integer num2, float f2, boolean z, boolean z2, boolean z3, boolean z4, int i3) {
        this.f13960a = str;
        this.f13961b = i2;
        this.f13962c = num;
        this.f13963d = num2;
        this.f13964e = f2;
        this.f13965f = z;
        this.f13966g = z2;
        this.f13967h = z3;
        this.f13968i = z4;
        this.f13969j = i3;
    }

    @Nullable
    public static SsaStyle b(String str, Format format) {
        String str2 = str;
        Format format2 = format;
        Assertions.a(str2.startsWith("Style:"));
        String[] split = TextUtils.split(str2.substring(6), ",");
        int length = split.length;
        int i2 = format2.f13980k;
        if (length != i2) {
            Log.n(f13956k, Util.S("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i2), Integer.valueOf(split.length), str2));
            return null;
        }
        try {
            String trim = split[format2.f13970a].trim();
            int i3 = format2.f13971b;
            int e2 = i3 != -1 ? e(split[i3].trim()) : -1;
            int i4 = format2.f13972c;
            Integer h2 = i4 != -1 ? h(split[i4].trim()) : null;
            int i5 = format2.f13973d;
            Integer h3 = i5 != -1 ? h(split[i5].trim()) : null;
            int i6 = format2.f13974e;
            float i7 = i6 != -1 ? i(split[i6].trim()) : -3.4028235E38f;
            int i8 = format2.f13975f;
            boolean z = i8 != -1 && f(split[i8].trim());
            int i9 = format2.f13976g;
            boolean z2 = i9 != -1 && f(split[i9].trim());
            int i10 = format2.f13977h;
            boolean z3 = i10 != -1 && f(split[i10].trim());
            int i11 = format2.f13978i;
            boolean z4 = i11 != -1 && f(split[i11].trim());
            int i12 = format2.f13979j;
            return new SsaStyle(trim, e2, h2, h3, i7, z, z2, z3, z4, i12 != -1 ? g(split[i12].trim()) : -1);
        } catch (RuntimeException e3) {
            Log.o(f13956k, "Skipping malformed 'Style:' line: '" + str2 + "'", e3);
            return null;
        }
    }

    private static boolean c(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private static boolean d(int i2) {
        return i2 == 1 || i2 == 3;
    }

    /* access modifiers changed from: private */
    public static int e(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (c(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        Log.n(f13956k, "Ignoring unknown alignment: " + str);
        return -1;
    }

    private static boolean f(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e2) {
            Log.o(f13956k, "Failed to parse boolean value: '" + str + "'", e2);
            return false;
        }
    }

    private static int g(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (d(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        Log.n(f13956k, "Ignoring unknown BorderStyle: " + str);
        return -1;
    }

    @ColorInt
    @Nullable
    public static Integer h(String str) {
        try {
            long parseLong = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            Assertions.a(parseLong <= InternalZipConstants.f30717k);
            return Integer.valueOf(Color.argb(Ints.d(((parseLong >> 24) & 255) ^ 255), Ints.d(parseLong & 255), Ints.d((parseLong >> 8) & 255), Ints.d((parseLong >> 16) & 255)));
        } catch (IllegalArgumentException e2) {
            Log.o(f13956k, "Failed to parse color expression: '" + str + "'", e2);
            return null;
        }
    }

    private static float i(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e2) {
            Log.o(f13956k, "Failed to parse font size: '" + str + "'", e2);
            return -3.4028235E38f;
        }
    }
}
