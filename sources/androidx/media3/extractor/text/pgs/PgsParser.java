package androidx.media3.extractor.text.pgs;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;

@UnstableApi
public final class PgsParser implements SubtitleParser {

    /* renamed from: e  reason: collision with root package name */
    public static final int f13919e = 2;

    /* renamed from: f  reason: collision with root package name */
    private static final int f13920f = 20;

    /* renamed from: g  reason: collision with root package name */
    private static final int f13921g = 21;

    /* renamed from: h  reason: collision with root package name */
    private static final int f13922h = 22;

    /* renamed from: i  reason: collision with root package name */
    private static final int f13923i = 128;

    /* renamed from: j  reason: collision with root package name */
    private static final byte f13924j = 120;

    /* renamed from: a  reason: collision with root package name */
    private final ParsableByteArray f13925a = new ParsableByteArray();

    /* renamed from: b  reason: collision with root package name */
    private final ParsableByteArray f13926b = new ParsableByteArray();

    /* renamed from: c  reason: collision with root package name */
    private final CueBuilder f13927c = new CueBuilder();
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Inflater f13928d;

    private static final class CueBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final ParsableByteArray f13929a = new ParsableByteArray();

        /* renamed from: b  reason: collision with root package name */
        private final int[] f13930b = new int[256];

        /* renamed from: c  reason: collision with root package name */
        private boolean f13931c;

        /* renamed from: d  reason: collision with root package name */
        private int f13932d;

        /* renamed from: e  reason: collision with root package name */
        private int f13933e;

        /* renamed from: f  reason: collision with root package name */
        private int f13934f;

        /* renamed from: g  reason: collision with root package name */
        private int f13935g;

        /* renamed from: h  reason: collision with root package name */
        private int f13936h;

        /* renamed from: i  reason: collision with root package name */
        private int f13937i;

        /* access modifiers changed from: private */
        public void e(ParsableByteArray parsableByteArray, int i2) {
            int O;
            if (i2 >= 4) {
                parsableByteArray.Z(3);
                int i3 = i2 - 4;
                if ((parsableByteArray.L() & 128) != 0) {
                    if (i3 >= 7 && (O = parsableByteArray.O()) >= 4) {
                        this.f13936h = parsableByteArray.R();
                        this.f13937i = parsableByteArray.R();
                        this.f13929a.U(O - 4);
                        i3 = i2 - 11;
                    } else {
                        return;
                    }
                }
                int f2 = this.f13929a.f();
                int g2 = this.f13929a.g();
                if (f2 < g2 && i3 > 0) {
                    int min = Math.min(i3, g2 - f2);
                    parsableByteArray.n(this.f13929a.e(), f2, min);
                    this.f13929a.Y(f2 + min);
                }
            }
        }

        /* access modifiers changed from: private */
        public void f(ParsableByteArray parsableByteArray, int i2) {
            if (i2 >= 19) {
                this.f13932d = parsableByteArray.R();
                this.f13933e = parsableByteArray.R();
                parsableByteArray.Z(11);
                this.f13934f = parsableByteArray.R();
                this.f13935g = parsableByteArray.R();
            }
        }

        /* access modifiers changed from: private */
        public void g(ParsableByteArray parsableByteArray, int i2) {
            if (i2 % 5 == 2) {
                parsableByteArray.Z(2);
                Arrays.fill(this.f13930b, 0);
                int i3 = i2 / 5;
                for (int i4 = 0; i4 < i3; i4++) {
                    int L = parsableByteArray.L();
                    int L2 = parsableByteArray.L();
                    int L3 = parsableByteArray.L();
                    int L4 = parsableByteArray.L();
                    int L5 = parsableByteArray.L();
                    double d2 = (double) L2;
                    double d3 = (double) (L3 - 128);
                    double d4 = (double) (L4 - 128);
                    this.f13930b[L] = (Util.w((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255) << 8) | (L5 << 24) | (Util.w((int) ((1.402d * d3) + d2), 0, 255) << 16) | Util.w((int) (d2 + (d4 * 1.772d)), 0, 255);
                }
                this.f13931c = true;
            }
        }

        @Nullable
        public Cue d() {
            int L;
            if (this.f13932d == 0 || this.f13933e == 0 || this.f13936h == 0 || this.f13937i == 0 || this.f13929a.g() == 0 || this.f13929a.f() != this.f13929a.g() || !this.f13931c) {
                return null;
            }
            this.f13929a.Y(0);
            int i2 = this.f13936h * this.f13937i;
            int[] iArr = new int[i2];
            int i3 = 0;
            while (i3 < i2) {
                int L2 = this.f13929a.L();
                if (L2 != 0) {
                    L = i3 + 1;
                    iArr[i3] = this.f13930b[L2];
                } else {
                    int L3 = this.f13929a.L();
                    if (L3 != 0) {
                        L = ((L3 & 64) == 0 ? L3 & 63 : ((L3 & 63) << 8) | this.f13929a.L()) + i3;
                        Arrays.fill(iArr, i3, L, (L3 & 128) == 0 ? 0 : this.f13930b[this.f13929a.L()]);
                    }
                }
                i3 = L;
            }
            return new Cue.Builder().r(Bitmap.createBitmap(iArr, this.f13936h, this.f13937i, Bitmap.Config.ARGB_8888)).w(((float) this.f13934f) / ((float) this.f13932d)).x(0).t(((float) this.f13935g) / ((float) this.f13933e), 0).u(0).z(((float) this.f13936h) / ((float) this.f13932d)).s(((float) this.f13937i) / ((float) this.f13933e)).a();
        }

        public void h() {
            this.f13932d = 0;
            this.f13933e = 0;
            this.f13934f = 0;
            this.f13935g = 0;
            this.f13936h = 0;
            this.f13937i = 0;
            this.f13929a.U(0);
            this.f13931c = false;
        }
    }

    private void e(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() > 0 && parsableByteArray.k() == 120) {
            if (this.f13928d == null) {
                this.f13928d = new Inflater();
            }
            if (Util.c1(parsableByteArray, this.f13926b, this.f13928d)) {
                parsableByteArray.W(this.f13926b.e(), this.f13926b.g());
            }
        }
    }

    @Nullable
    private static Cue f(ParsableByteArray parsableByteArray, CueBuilder cueBuilder) {
        int g2 = parsableByteArray.g();
        int L = parsableByteArray.L();
        int R = parsableByteArray.R();
        int f2 = parsableByteArray.f() + R;
        Cue cue = null;
        if (f2 > g2) {
            parsableByteArray.Y(g2);
            return null;
        }
        if (L != 128) {
            switch (L) {
                case 20:
                    cueBuilder.g(parsableByteArray, R);
                    break;
                case 21:
                    cueBuilder.e(parsableByteArray, R);
                    break;
                case 22:
                    cueBuilder.f(parsableByteArray, R);
                    break;
            }
        } else {
            cue = cueBuilder.d();
            cueBuilder.h();
        }
        parsableByteArray.Y(f2);
        return cue;
    }

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        this.f13925a.W(bArr, i3 + i2);
        this.f13925a.Y(i2);
        e(this.f13925a);
        this.f13927c.h();
        ArrayList arrayList = new ArrayList();
        while (this.f13925a.a() >= 3) {
            Cue f2 = f(this.f13925a, this.f13927c);
            if (f2 != null) {
                arrayList.add(f2);
            }
        }
        consumer.accept(new CuesWithTiming(arrayList, C.f9084b, C.f9084b));
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
