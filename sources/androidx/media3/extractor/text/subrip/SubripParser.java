package androidx.media3.extractor.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.e;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.DateUtils;

@UnstableApi
public final class SubripParser implements SubtitleParser {

    /* renamed from: d  reason: collision with root package name */
    public static final int f13989d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final float f13990e = 0.08f;

    /* renamed from: f  reason: collision with root package name */
    private static final float f13991f = 0.92f;

    /* renamed from: g  reason: collision with root package name */
    private static final float f13992g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    private static final String f13993h = "SubripParser";

    /* renamed from: i  reason: collision with root package name */
    private static final String f13994i = "(?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?";

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f13995j = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f13996k = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: l  reason: collision with root package name */
    private static final String f13997l = "\\{\\\\an[1-9]\\}";

    /* renamed from: m  reason: collision with root package name */
    private static final String f13998m = "{\\an1}";

    /* renamed from: n  reason: collision with root package name */
    private static final String f13999n = "{\\an2}";
    private static final String o = "{\\an3}";
    private static final String p = "{\\an4}";
    private static final String q = "{\\an5}";
    private static final String r = "{\\an6}";
    private static final String s = "{\\an7}";
    private static final String t = "{\\an8}";
    private static final String u = "{\\an9}";

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f14000a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<String> f14001b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final ParsableByteArray f14002c = new ParsableByteArray();

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.media3.common.text.Cue e(android.text.Spanned r17, @androidx.annotation.Nullable java.lang.String r18) {
        /*
            r16 = this;
            r0 = r18
            androidx.media3.common.text.Cue$Builder r1 = new androidx.media3.common.text.Cue$Builder
            r1.<init>()
            r2 = r17
            androidx.media3.common.text.Cue$Builder r1 = r1.A(r2)
            if (r0 != 0) goto L_0x0014
            androidx.media3.common.text.Cue r0 = r1.a()
            return r0
        L_0x0014:
            int r2 = r18.hashCode()
            java.lang.String r3 = "{\\an1}"
            java.lang.String r5 = "{\\an2}"
            java.lang.String r6 = "{\\an3}"
            java.lang.String r7 = "{\\an4}"
            java.lang.String r9 = "{\\an5}"
            java.lang.String r10 = "{\\an6}"
            java.lang.String r11 = "{\\an7}"
            java.lang.String r13 = "{\\an8}"
            java.lang.String r14 = "{\\an9}"
            r4 = 3
            r8 = 4
            r15 = 1
            r12 = 2
            switch(r2) {
                case -685620710: goto L_0x0073;
                case -685620679: goto L_0x006b;
                case -685620648: goto L_0x0063;
                case -685620617: goto L_0x005b;
                case -685620586: goto L_0x0053;
                case -685620555: goto L_0x004b;
                case -685620524: goto L_0x0043;
                case -685620493: goto L_0x003a;
                case -685620462: goto L_0x0032;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x007b
        L_0x0032:
            boolean r2 = r0.equals(r14)
            if (r2 == 0) goto L_0x007b
            r2 = 5
            goto L_0x007c
        L_0x003a:
            boolean r2 = r0.equals(r13)
            if (r2 == 0) goto L_0x007b
            r2 = 8
            goto L_0x007c
        L_0x0043:
            boolean r2 = r0.equals(r11)
            if (r2 == 0) goto L_0x007b
            r2 = 2
            goto L_0x007c
        L_0x004b:
            boolean r2 = r0.equals(r10)
            if (r2 == 0) goto L_0x007b
            r2 = 4
            goto L_0x007c
        L_0x0053:
            boolean r2 = r0.equals(r9)
            if (r2 == 0) goto L_0x007b
            r2 = 7
            goto L_0x007c
        L_0x005b:
            boolean r2 = r0.equals(r7)
            if (r2 == 0) goto L_0x007b
            r2 = 1
            goto L_0x007c
        L_0x0063:
            boolean r2 = r0.equals(r6)
            if (r2 == 0) goto L_0x007b
            r2 = 3
            goto L_0x007c
        L_0x006b:
            boolean r2 = r0.equals(r5)
            if (r2 == 0) goto L_0x007b
            r2 = 6
            goto L_0x007c
        L_0x0073:
            boolean r2 = r0.equals(r3)
            if (r2 == 0) goto L_0x007b
            r2 = 0
            goto L_0x007c
        L_0x007b:
            r2 = -1
        L_0x007c:
            if (r2 == 0) goto L_0x0091
            if (r2 == r15) goto L_0x0091
            if (r2 == r12) goto L_0x0091
            if (r2 == r4) goto L_0x008d
            if (r2 == r8) goto L_0x008d
            r8 = 5
            if (r2 == r8) goto L_0x008d
            r1.x(r15)
            goto L_0x0095
        L_0x008d:
            r1.x(r12)
            goto L_0x0095
        L_0x0091:
            r2 = 0
            r1.x(r2)
        L_0x0095:
            int r2 = r18.hashCode()
            switch(r2) {
                case -685620710: goto L_0x00de;
                case -685620679: goto L_0x00d6;
                case -685620648: goto L_0x00ce;
                case -685620617: goto L_0x00c6;
                case -685620586: goto L_0x00be;
                case -685620555: goto L_0x00b5;
                case -685620524: goto L_0x00ad;
                case -685620493: goto L_0x00a5;
                case -685620462: goto L_0x009d;
                default: goto L_0x009c;
            }
        L_0x009c:
            goto L_0x00e6
        L_0x009d:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x00e6
            r0 = 5
            goto L_0x00e7
        L_0x00a5:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x00e6
            r0 = 4
            goto L_0x00e7
        L_0x00ad:
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x00e6
            r0 = 3
            goto L_0x00e7
        L_0x00b5:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x00e6
            r0 = 8
            goto L_0x00e7
        L_0x00be:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00e6
            r0 = 7
            goto L_0x00e7
        L_0x00c6:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x00e6
            r0 = 6
            goto L_0x00e7
        L_0x00ce:
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x00e6
            r0 = 2
            goto L_0x00e7
        L_0x00d6:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x00e6
            r0 = 1
            goto L_0x00e7
        L_0x00de:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00e6
            r0 = 0
            goto L_0x00e7
        L_0x00e6:
            r0 = -1
        L_0x00e7:
            if (r0 == 0) goto L_0x00fe
            if (r0 == r15) goto L_0x00fe
            if (r0 == r12) goto L_0x00fe
            if (r0 == r4) goto L_0x00f9
            r2 = 4
            if (r0 == r2) goto L_0x00f9
            r2 = 5
            if (r0 == r2) goto L_0x00f9
            r1.u(r15)
            goto L_0x0101
        L_0x00f9:
            r0 = 0
            r1.u(r0)
            goto L_0x0101
        L_0x00fe:
            r1.u(r12)
        L_0x0101:
            int r0 = r1.i()
            float r0 = g(r0)
            androidx.media3.common.text.Cue$Builder r0 = r1.w(r0)
            int r1 = r1.f()
            float r1 = g(r1)
            r2 = 0
            androidx.media3.common.text.Cue$Builder r0 = r0.t(r1, r2)
            androidx.media3.common.text.Cue r0 = r0.a()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.subrip.SubripParser.e(android.text.Spanned, java.lang.String):androidx.media3.common.text.Cue");
    }

    private Charset f(ParsableByteArray parsableByteArray) {
        Charset T = parsableByteArray.T();
        return T != null ? T : Charsets.f22255c;
    }

    @VisibleForTesting(otherwise = 2)
    public static float g(int i2) {
        if (i2 == 0) {
            return 0.08f;
        }
        if (i2 == 1) {
            return 0.5f;
        }
        if (i2 == 2) {
            return f13991f;
        }
        throw new IllegalArgumentException();
    }

    private static long h(Matcher matcher, int i2) {
        String group = matcher.group(i2 + 1);
        long parseLong = (group != null ? Long.parseLong(group) * DateUtils.MILLIS_PER_HOUR : 0) + (Long.parseLong((String) Assertions.g(matcher.group(i2 + 2))) * 60000) + (Long.parseLong((String) Assertions.g(matcher.group(i2 + 3))) * 1000);
        String group2 = matcher.group(i2 + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    private String i(String str, ArrayList<String> arrayList) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder(trim);
        Matcher matcher = f13996k.matcher(trim);
        int i2 = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i2;
            int length = group.length();
            sb.replace(start, start + length, "");
            i2 += length;
        }
        return sb.toString();
    }

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        String str;
        Consumer<CuesWithTiming> consumer2;
        String str2;
        String str3;
        String str4;
        Consumer<CuesWithTiming> consumer3;
        int i4 = i2;
        SubtitleParser.OutputOptions outputOptions2 = outputOptions;
        Consumer<CuesWithTiming> consumer4 = consumer;
        String str5 = f13993h;
        this.f14002c.W(bArr, i4 + i3);
        this.f14002c.Y(i4);
        Charset f2 = f(this.f14002c);
        ArrayList<CuesWithTiming> arrayList = (outputOptions2.f13785a == C.f9084b || !outputOptions2.f13786b) ? null : new ArrayList<>();
        while (true) {
            String v = this.f14002c.v(f2);
            if (v == null) {
                break;
            } else if (v.length() != 0) {
                try {
                    Integer.parseInt(v);
                    String v2 = this.f14002c.v(f2);
                    if (v2 == null) {
                        Log.n(str5, "Unexpected end");
                        break;
                    }
                    Matcher matcher = f13995j.matcher(v2);
                    if (matcher.matches()) {
                        long h2 = h(matcher, 1);
                        long h3 = h(matcher, 6);
                        int i5 = 0;
                        this.f14000a.setLength(0);
                        this.f14001b.clear();
                        while (true) {
                            String v3 = this.f14002c.v(f2);
                            if (TextUtils.isEmpty(v3)) {
                                break;
                            }
                            if (this.f14000a.length() > 0) {
                                this.f14000a.append("<br>");
                            }
                            this.f14000a.append(i(v3, this.f14001b));
                        }
                        Spanned fromHtml = Html.fromHtml(this.f14000a.toString());
                        while (true) {
                            if (i5 >= this.f14001b.size()) {
                                str3 = str5;
                                str4 = null;
                                break;
                            }
                            str4 = this.f14001b.get(i5);
                            if (str4.matches(f13997l)) {
                                str3 = str5;
                                break;
                            }
                            i5++;
                        }
                        long j2 = outputOptions2.f13785a;
                        if (j2 == C.f9084b || h2 >= j2) {
                            consumer3 = consumer;
                            consumer3.accept(new CuesWithTiming(ImmutableList.K(e(fromHtml, str4)), h2, h3 - h2));
                        } else {
                            if (arrayList != null) {
                                arrayList.add(new CuesWithTiming(ImmutableList.K(e(fromHtml, str4)), h2, h3 - h2));
                            }
                            consumer3 = consumer;
                        }
                        consumer4 = consumer3;
                        str5 = str3;
                    } else {
                        String str6 = str5;
                        consumer2 = consumer4;
                        str2 = "Skipping invalid timing: " + v2;
                        str = str6;
                        Log.n(str, str2);
                        consumer4 = consumer2;
                        str5 = str;
                    }
                } catch (NumberFormatException unused) {
                    str = str5;
                    consumer2 = consumer4;
                    str2 = "Skipping invalid index: " + v;
                }
            }
        }
        Consumer<CuesWithTiming> consumer5 = consumer4;
        if (arrayList != null) {
            for (CuesWithTiming accept : arrayList) {
                consumer5.accept(accept);
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
}
