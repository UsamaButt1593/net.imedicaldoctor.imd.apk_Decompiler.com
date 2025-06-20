package androidx.media3.extractor.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
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
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import java.nio.charset.Charset;
import java.util.List;

@UnstableApi
public final class Tx3gParser implements SubtitleParser {

    /* renamed from: h  reason: collision with root package name */
    public static final int f14071h = 2;

    /* renamed from: i  reason: collision with root package name */
    private static final String f14072i = "Tx3gParser";

    /* renamed from: j  reason: collision with root package name */
    private static final int f14073j = 1937013100;

    /* renamed from: k  reason: collision with root package name */
    private static final int f14074k = 1952608120;

    /* renamed from: l  reason: collision with root package name */
    private static final String f14075l = "Serif";

    /* renamed from: m  reason: collision with root package name */
    private static final int f14076m = 8;

    /* renamed from: n  reason: collision with root package name */
    private static final int f14077n = 2;
    private static final int o = 12;
    private static final int p = 1;
    private static final int q = 2;
    private static final int r = 4;
    private static final int s = 16711680;
    private static final int t = 0;
    private static final int u = 0;
    private static final int v = -1;
    private static final String w = "sans-serif";
    private static final float x = 0.85f;

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f14078a = new ParsableByteArray();

    /* renamed from: b  reason: collision with root package name */
    private final boolean f14079b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14080c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14081d;

    /* renamed from: e  reason: collision with root package name */
    private final String f14082e;

    /* renamed from: f  reason: collision with root package name */
    private final float f14083f;

    /* renamed from: g  reason: collision with root package name */
    private final int f14084g;

    public Tx3gParser(List<byte[]> list) {
        String str = "sans-serif";
        boolean z = false;
        if (list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.f14080c = bArr[24];
            this.f14081d = ((bArr[26] & 255) << Ascii.B) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.f14082e = f14075l.equals(Util.U(bArr, 43, bArr.length - 43)) ? C.f9096n : str;
            int i2 = bArr[25] * Ascii.x;
            this.f14084g = i2;
            z = (bArr[0] & 32) != 0 ? true : z;
            this.f14079b = z;
            if (z) {
                this.f14083f = Util.v(((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) i2), 0.0f, 0.95f);
            } else {
                this.f14083f = x;
            }
        } else {
            this.f14080c = 0;
            this.f14081d = -1;
            this.f14082e = str;
            this.f14079b = false;
            this.f14083f = x;
            this.f14084g = -1;
        }
    }

    private void e(ParsableByteArray parsableByteArray, SpannableStringBuilder spannableStringBuilder) {
        Assertions.a(parsableByteArray.a() >= 12);
        int R = parsableByteArray.R();
        int R2 = parsableByteArray.R();
        parsableByteArray.Z(2);
        int L = parsableByteArray.L();
        parsableByteArray.Z(1);
        int s2 = parsableByteArray.s();
        if (R2 > spannableStringBuilder.length()) {
            Log.n(f14072i, "Truncating styl end (" + R2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            R2 = spannableStringBuilder.length();
        }
        if (R >= R2) {
            Log.n(f14072i, "Ignoring styl with start (" + R + ") >= end (" + R2 + ").");
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        int i2 = R;
        int i3 = R2;
        g(spannableStringBuilder2, L, this.f14080c, i2, i3, 0);
        f(spannableStringBuilder2, s2, this.f14081d, i2, i3, 0);
    }

    private static void f(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4, int i5, int i6) {
        if (i2 != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i2 >>> 8) | ((i2 & 255) << 24)), i4, i5, i6 | 33);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void g(android.text.SpannableStringBuilder r5, int r6, int r7, int r8, int r9, int r10) {
        /*
            if (r6 == r7) goto L_0x004d
            r7 = r10 | 33
            r10 = r6 & 1
            r0 = 0
            r1 = 1
            if (r10 == 0) goto L_0x000c
            r10 = 1
            goto L_0x000d
        L_0x000c:
            r10 = 0
        L_0x000d:
            r2 = r6 & 2
            if (r2 == 0) goto L_0x0013
            r2 = 1
            goto L_0x0014
        L_0x0013:
            r2 = 0
        L_0x0014:
            if (r10 == 0) goto L_0x0026
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            if (r2 == 0) goto L_0x0022
            r4 = 3
            r3.<init>(r4)
        L_0x001e:
            r5.setSpan(r3, r8, r9, r7)
            goto L_0x002f
        L_0x0022:
            r3.<init>(r1)
            goto L_0x001e
        L_0x0026:
            if (r2 == 0) goto L_0x002f
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r4 = 2
            r3.<init>(r4)
            goto L_0x001e
        L_0x002f:
            r6 = r6 & 4
            if (r6 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r1 = 0
        L_0x0035:
            if (r1 == 0) goto L_0x003f
            android.text.style.UnderlineSpan r6 = new android.text.style.UnderlineSpan
            r6.<init>()
            r5.setSpan(r6, r8, r9, r7)
        L_0x003f:
            if (r1 != 0) goto L_0x004d
            if (r10 != 0) goto L_0x004d
            if (r2 != 0) goto L_0x004d
            android.text.style.StyleSpan r6 = new android.text.style.StyleSpan
            r6.<init>(r0)
            r5.setSpan(r6, r8, r9, r7)
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.tx3g.Tx3gParser.g(android.text.SpannableStringBuilder, int, int, int, int, int):void");
    }

    private static void h(SpannableStringBuilder spannableStringBuilder, String str, int i2, int i3) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i2, i3, 16711713);
        }
    }

    private static String i(ParsableByteArray parsableByteArray) {
        Assertions.a(parsableByteArray.a() >= 2);
        int R = parsableByteArray.R();
        if (R == 0) {
            return "";
        }
        int f2 = parsableByteArray.f();
        Charset T = parsableByteArray.T();
        int f3 = R - (parsableByteArray.f() - f2);
        if (T == null) {
            T = Charsets.f22255c;
        }
        return parsableByteArray.J(f3, T);
    }

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        int i4 = i2;
        Consumer<CuesWithTiming> consumer2 = consumer;
        this.f14078a.W(bArr, i4 + i3);
        this.f14078a.Y(i4);
        String i5 = i(this.f14078a);
        if (i5.isEmpty()) {
            consumer2.accept(new CuesWithTiming(ImmutableList.I(), C.f9084b, C.f9084b));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(i5);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        g(spannableStringBuilder2, this.f14080c, 0, 0, spannableStringBuilder.length(), s);
        f(spannableStringBuilder2, this.f14081d, -1, 0, spannableStringBuilder.length(), s);
        h(spannableStringBuilder, this.f14082e, 0, spannableStringBuilder.length());
        float f2 = this.f14083f;
        while (this.f14078a.a() >= 8) {
            int f3 = this.f14078a.f();
            int s2 = this.f14078a.s();
            int s3 = this.f14078a.s();
            boolean z = true;
            if (s3 == f14073j) {
                if (this.f14078a.a() < 2) {
                    z = false;
                }
                Assertions.a(z);
                int R = this.f14078a.R();
                for (int i6 = 0; i6 < R; i6++) {
                    e(this.f14078a, spannableStringBuilder);
                }
            } else if (s3 == f14074k && this.f14079b) {
                if (this.f14078a.a() < 2) {
                    z = false;
                }
                Assertions.a(z);
                f2 = Util.v(((float) this.f14078a.R()) / ((float) this.f14084g), 0.0f, 0.95f);
            }
            this.f14078a.Y(f3 + s2);
        }
        consumer2.accept(new CuesWithTiming(ImmutableList.K(new Cue.Builder().A(spannableStringBuilder).t(f2, 0).u(0).a()), C.f9084b, C.f9084b));
    }

    public /* synthetic */ Subtitle b(byte[] bArr, int i2, int i3) {
        return e.b(this, bArr, i2, i3);
    }

    public /* synthetic */ void c(byte[] bArr, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        e.a(this, bArr, outputOptions, consumer);
    }

    public int d() {
        return 2;
    }

    public /* synthetic */ void reset() {
        e.c(this);
    }
}
