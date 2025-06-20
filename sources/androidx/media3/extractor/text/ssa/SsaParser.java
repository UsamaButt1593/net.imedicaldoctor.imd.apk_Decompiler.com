package androidx.media3.extractor.text.ssa;

import android.text.Layout;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.e;
import androidx.media3.extractor.text.ssa.SsaStyle;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UnstableApi
public final class SsaParser implements SubtitleParser {

    /* renamed from: g  reason: collision with root package name */
    public static final int f13943g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final String f13944h = "SsaParser";

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f13945i = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: j  reason: collision with root package name */
    static final String f13946j = "Format:";

    /* renamed from: k  reason: collision with root package name */
    static final String f13947k = "Style:";

    /* renamed from: l  reason: collision with root package name */
    private static final String f13948l = "Dialogue:";

    /* renamed from: m  reason: collision with root package name */
    private static final float f13949m = 0.05f;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f13950a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final SsaDialogueFormat f13951b;

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f13952c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, SsaStyle> f13953d;

    /* renamed from: e  reason: collision with root package name */
    private float f13954e;

    /* renamed from: f  reason: collision with root package name */
    private float f13955f;

    public SsaParser() {
        this((List<byte[]>) null);
    }

    private static int e(long j2, List<Long> list, List<List<Cue>> list2) {
        int i2;
        ArrayList arrayList;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i2 = 0;
                break;
            } else if (list.get(size).longValue() == j2) {
                return size;
            } else {
                if (list.get(size).longValue() < j2) {
                    i2 = size + 1;
                    break;
                }
                size--;
            }
        }
        list.add(i2, Long.valueOf(j2));
        if (i2 != 0) {
            arrayList = new ArrayList(list2.get(i2 - 1));
        }
        list2.add(i2, arrayList);
        return i2;
    }

    private static float f(int i2) {
        if (i2 == 0) {
            return f13949m;
        }
        if (i2 != 1) {
            return i2 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.common.text.Cue g(java.lang.String r8, @androidx.annotation.Nullable androidx.media3.extractor.text.ssa.SsaStyle r9, androidx.media3.extractor.text.ssa.SsaStyle.Overrides r10, float r11, float r12) {
        /*
            android.text.SpannableString r0 = new android.text.SpannableString
            r0.<init>(r8)
            androidx.media3.common.text.Cue$Builder r8 = new androidx.media3.common.text.Cue$Builder
            r8.<init>()
            androidx.media3.common.text.Cue$Builder r8 = r8.A(r0)
            r1 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r2 = 0
            if (r9 == 0) goto L_0x009e
            java.lang.Integer r3 = r9.f13962c
            r4 = 33
            if (r3 == 0) goto L_0x002c
            android.text.style.ForegroundColorSpan r3 = new android.text.style.ForegroundColorSpan
            java.lang.Integer r5 = r9.f13962c
            int r5 = r5.intValue()
            r3.<init>(r5)
            int r5 = r0.length()
            r0.setSpan(r3, r2, r5, r4)
        L_0x002c:
            int r3 = r9.f13969j
            r5 = 3
            if (r3 != r5) goto L_0x0047
            java.lang.Integer r3 = r9.f13963d
            if (r3 == 0) goto L_0x0047
            android.text.style.BackgroundColorSpan r3 = new android.text.style.BackgroundColorSpan
            java.lang.Integer r6 = r9.f13963d
            int r6 = r6.intValue()
            r3.<init>(r6)
            int r6 = r0.length()
            r0.setSpan(r3, r2, r6, r4)
        L_0x0047:
            float r3 = r9.f13964e
            r6 = 1
            int r7 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r7 == 0) goto L_0x0056
            int r7 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r7 == 0) goto L_0x0056
            float r3 = r3 / r12
            r8.C(r3, r6)
        L_0x0056:
            boolean r3 = r9.f13965f
            if (r3 == 0) goto L_0x006b
            boolean r7 = r9.f13966g
            if (r7 == 0) goto L_0x006b
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r3.<init>(r5)
        L_0x0063:
            int r5 = r0.length()
            r0.setSpan(r3, r2, r5, r4)
            goto L_0x007e
        L_0x006b:
            if (r3 == 0) goto L_0x0073
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r3.<init>(r6)
            goto L_0x0063
        L_0x0073:
            boolean r3 = r9.f13966g
            if (r3 == 0) goto L_0x007e
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r5 = 2
            r3.<init>(r5)
            goto L_0x0063
        L_0x007e:
            boolean r3 = r9.f13967h
            if (r3 == 0) goto L_0x008e
            android.text.style.UnderlineSpan r3 = new android.text.style.UnderlineSpan
            r3.<init>()
            int r5 = r0.length()
            r0.setSpan(r3, r2, r5, r4)
        L_0x008e:
            boolean r3 = r9.f13968i
            if (r3 == 0) goto L_0x009e
            android.text.style.StrikethroughSpan r3 = new android.text.style.StrikethroughSpan
            r3.<init>()
            int r5 = r0.length()
            r0.setSpan(r3, r2, r5, r4)
        L_0x009e:
            int r0 = r10.f13987a
            r3 = -1
            if (r0 == r3) goto L_0x00a4
            goto L_0x00aa
        L_0x00a4:
            if (r9 == 0) goto L_0x00a9
            int r0 = r9.f13961b
            goto L_0x00aa
        L_0x00a9:
            r0 = -1
        L_0x00aa:
            android.text.Layout$Alignment r9 = q(r0)
            androidx.media3.common.text.Cue$Builder r9 = r8.B(r9)
            int r3 = p(r0)
            androidx.media3.common.text.Cue$Builder r9 = r9.x(r3)
            int r0 = o(r0)
            r9.u(r0)
            android.graphics.PointF r9 = r10.f13988b
            if (r9 == 0) goto L_0x00dc
            int r0 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00dc
            int r0 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00dc
            float r9 = r9.x
            float r9 = r9 / r11
            r8.w(r9)
            android.graphics.PointF r9 = r10.f13988b
            float r9 = r9.y
            float r9 = r9 / r12
        L_0x00d8:
            r8.t(r9, r2)
            goto L_0x00f0
        L_0x00dc:
            int r9 = r8.i()
            float r9 = f(r9)
            r8.w(r9)
            int r9 = r8.f()
            float r9 = f(r9)
            goto L_0x00d8
        L_0x00f0:
            androidx.media3.common.text.Cue r8 = r8.a()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ssa.SsaParser.g(java.lang.String, androidx.media3.extractor.text.ssa.SsaStyle, androidx.media3.extractor.text.ssa.SsaStyle$Overrides, float, float):androidx.media3.common.text.Cue");
    }

    private Charset h(ParsableByteArray parsableByteArray) {
        Charset T = parsableByteArray.T();
        return T != null ? T : Charsets.f22255c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0065, code lost:
        r3 = r12.f13940c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(java.lang.String r11, androidx.media3.extractor.text.ssa.SsaDialogueFormat r12, java.util.List<java.util.List<androidx.media3.common.text.Cue>> r13, java.util.List<java.lang.Long> r14) {
        /*
            r10 = this;
            java.lang.String r0 = "Dialogue:"
            boolean r0 = r11.startsWith(r0)
            androidx.media3.common.util.Assertions.a(r0)
            r0 = 9
            java.lang.String r0 = r11.substring(r0)
            int r1 = r12.f13942e
            java.lang.String r2 = ","
            java.lang.String[] r0 = r0.split(r2, r1)
            int r1 = r0.length
            int r2 = r12.f13942e
            java.lang.String r3 = "SsaParser"
            if (r1 == r2) goto L_0x0033
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Skipping dialogue line with fewer columns than format: "
            r12.append(r13)
        L_0x0028:
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            androidx.media3.common.util.Log.n(r3, r11)
            return
        L_0x0033:
            int r1 = r12.f13938a
            r1 = r0[r1]
            long r1 = n(r1)
            java.lang.String r4 = "Skipping invalid timing: "
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x004f
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
        L_0x004b:
            r12.append(r4)
            goto L_0x0028
        L_0x004f:
            int r7 = r12.f13939b
            r7 = r0[r7]
            long r7 = n(r7)
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x0061
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            goto L_0x004b
        L_0x0061:
            java.util.Map<java.lang.String, androidx.media3.extractor.text.ssa.SsaStyle> r11 = r10.f13953d
            if (r11 == 0) goto L_0x0077
            int r3 = r12.f13940c
            r4 = -1
            if (r3 == r4) goto L_0x0077
            r3 = r0[r3]
            java.lang.String r3 = r3.trim()
            java.lang.Object r11 = r11.get(r3)
            androidx.media3.extractor.text.ssa.SsaStyle r11 = (androidx.media3.extractor.text.ssa.SsaStyle) r11
            goto L_0x0078
        L_0x0077:
            r11 = 0
        L_0x0078:
            int r12 = r12.f13941d
            r12 = r0[r12]
            androidx.media3.extractor.text.ssa.SsaStyle$Overrides r0 = androidx.media3.extractor.text.ssa.SsaStyle.Overrides.b(r12)
            java.lang.String r12 = androidx.media3.extractor.text.ssa.SsaStyle.Overrides.d(r12)
            java.lang.String r3 = "\\N"
            java.lang.String r4 = "\n"
            java.lang.String r12 = r12.replace(r3, r4)
            java.lang.String r3 = "\\n"
            java.lang.String r12 = r12.replace(r3, r4)
            java.lang.String r3 = "\\h"
            java.lang.String r4 = " "
            java.lang.String r12 = r12.replace(r3, r4)
            float r3 = r10.f13954e
            float r4 = r10.f13955f
            androidx.media3.common.text.Cue r11 = g(r12, r11, r0, r3, r4)
            int r12 = e(r1, r14, r13)
            int r14 = e(r7, r14, r13)
        L_0x00aa:
            if (r12 >= r14) goto L_0x00b8
            java.lang.Object r0 = r13.get(r12)
            java.util.List r0 = (java.util.List) r0
            r0.add(r11)
            int r12 = r12 + 1
            goto L_0x00aa
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ssa.SsaParser.i(java.lang.String, androidx.media3.extractor.text.ssa.SsaDialogueFormat, java.util.List, java.util.List):void");
    }

    private void j(ParsableByteArray parsableByteArray, List<List<Cue>> list, List<Long> list2, Charset charset) {
        SsaDialogueFormat ssaDialogueFormat = this.f13950a ? this.f13951b : null;
        while (true) {
            String v = parsableByteArray.v(charset);
            if (v == null) {
                return;
            }
            if (v.startsWith(f13946j)) {
                ssaDialogueFormat = SsaDialogueFormat.a(v);
            } else if (v.startsWith(f13948l)) {
                if (ssaDialogueFormat == null) {
                    Log.n(f13944h, "Skipping dialogue line before complete format: " + v);
                } else {
                    i(v, ssaDialogueFormat, list, list2);
                }
            }
        }
    }

    private void k(ParsableByteArray parsableByteArray, Charset charset) {
        while (true) {
            String v = parsableByteArray.v(charset);
            if (v == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(v)) {
                l(parsableByteArray, charset);
            } else if ("[V4+ Styles]".equalsIgnoreCase(v)) {
                this.f13953d = m(parsableByteArray, charset);
            } else if ("[V4 Styles]".equalsIgnoreCase(v)) {
                Log.h(f13944h, "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(v)) {
                return;
            }
        }
    }

    private void l(ParsableByteArray parsableByteArray, Charset charset) {
        while (true) {
            String v = parsableByteArray.v(charset);
            if (v == null) {
                return;
            }
            if (parsableByteArray.a() == 0 || parsableByteArray.i(charset) != '[') {
                String[] split = v.split(":");
                if (split.length == 2) {
                    String g2 = Ascii.g(split[0].trim());
                    g2.hashCode();
                    if (g2.equals("playresx")) {
                        this.f13954e = Float.parseFloat(split[1].trim());
                    } else if (g2.equals("playresy")) {
                        try {
                            this.f13955f = Float.parseFloat(split[1].trim());
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    private static Map<String, SsaStyle> m(ParsableByteArray parsableByteArray, Charset charset) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SsaStyle.Format format = null;
        while (true) {
            String v = parsableByteArray.v(charset);
            if (v == null || (parsableByteArray.a() != 0 && parsableByteArray.i(charset) == '[')) {
                return linkedHashMap;
            }
            if (v.startsWith(f13946j)) {
                format = SsaStyle.Format.a(v);
            } else if (v.startsWith(f13947k)) {
                if (format == null) {
                    Log.n(f13944h, "Skipping 'Style:' line before 'Format:' line: " + v);
                } else {
                    SsaStyle b2 = SsaStyle.b(v, format);
                    if (b2 != null) {
                        linkedHashMap.put(b2.f13960a, b2);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static long n(String str) {
        Matcher matcher = f13945i.matcher(str.trim());
        return !matcher.matches() ? C.f9084b : (Long.parseLong((String) Util.o(matcher.group(1))) * 3600000000L) + (Long.parseLong((String) Util.o(matcher.group(2))) * 60000000) + (Long.parseLong((String) Util.o(matcher.group(3))) * 1000000) + (Long.parseLong((String) Util.o(matcher.group(4))) * 10000);
    }

    private static int o(int i2) {
        switch (i2) {
            case -1:
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
            default:
                Log.n(f13944h, "Unknown alignment: " + i2);
                return Integer.MIN_VALUE;
        }
    }

    private static int p(int i2) {
        switch (i2) {
            case -1:
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
            default:
                Log.n(f13944h, "Unknown alignment: " + i2);
                return Integer.MIN_VALUE;
        }
    }

    @Nullable
    private static Layout.Alignment q(int i2) {
        switch (i2) {
            case -1:
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                Log.n(f13944h, "Unknown alignment: " + i2);
                return null;
        }
    }

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i4 = i2;
        SubtitleParser.OutputOptions outputOptions2 = outputOptions;
        Consumer<CuesWithTiming> consumer2 = consumer;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        this.f13952c.W(bArr, i4 + i3);
        this.f13952c.Y(i4);
        Charset h2 = h(this.f13952c);
        if (!this.f13950a) {
            k(this.f13952c, h2);
        }
        j(this.f13952c, arrayList3, arrayList4, h2);
        ArrayList<CuesWithTiming> arrayList5 = (outputOptions2.f13785a == C.f9084b || !outputOptions2.f13786b) ? null : new ArrayList<>();
        int i5 = 0;
        while (i5 < arrayList3.size()) {
            List list = (List) arrayList3.get(i5);
            if (list.isEmpty() && i5 != 0) {
                arrayList2 = arrayList3;
                arrayList = arrayList4;
            } else if (i5 != arrayList3.size() - 1) {
                long longValue = ((Long) arrayList4.get(i5)).longValue();
                long longValue2 = ((Long) arrayList4.get(i5 + 1)).longValue() - ((Long) arrayList4.get(i5)).longValue();
                arrayList2 = arrayList3;
                arrayList = arrayList4;
                long j2 = outputOptions2.f13785a;
                if (j2 == C.f9084b || longValue >= j2) {
                    consumer2.accept(new CuesWithTiming(list, longValue, longValue2));
                } else if (arrayList5 != null) {
                    arrayList5.add(new CuesWithTiming(list, longValue, longValue2));
                }
            } else {
                throw new IllegalStateException();
            }
            i5++;
            arrayList3 = arrayList2;
            arrayList4 = arrayList;
        }
        if (arrayList5 != null) {
            for (CuesWithTiming accept : arrayList5) {
                consumer2.accept(accept);
            }
        }
    }

    public /* synthetic */ Subtitle b(byte[] bArr, int i2, int i3) {
        return e.b(this, bArr, i2, i3);
    }

    public /* synthetic */ void c(byte[] bArr, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        e.a(this, bArr, outputOptions, consumer);
    }

    public int d() {
        return 1;
    }

    public /* synthetic */ void reset() {
        e.c(this);
    }

    public SsaParser(@Nullable List<byte[]> list) {
        this.f13954e = -3.4028235E38f;
        this.f13955f = -3.4028235E38f;
        this.f13952c = new ParsableByteArray();
        if (list == null || list.isEmpty()) {
            this.f13950a = false;
            this.f13951b = null;
            return;
        }
        this.f13950a = true;
        String T = Util.T(list.get(0));
        Assertions.a(T.startsWith(f13946j));
        this.f13951b = (SsaDialogueFormat) Assertions.g(SsaDialogueFormat.a(T));
        k(new ParsableByteArray(list.get(1)), Charsets.f22255c);
    }
}
