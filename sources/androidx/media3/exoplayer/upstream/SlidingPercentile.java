package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@UnstableApi
public class SlidingPercentile {

    /* renamed from: h  reason: collision with root package name */
    private static final Comparator<Sample> f12589h = new h();

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator<Sample> f12590i = new i();

    /* renamed from: j  reason: collision with root package name */
    private static final int f12591j = -1;

    /* renamed from: k  reason: collision with root package name */
    private static final int f12592k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static final int f12593l = 1;

    /* renamed from: m  reason: collision with root package name */
    private static final int f12594m = 5;

    /* renamed from: a  reason: collision with root package name */
    private final int f12595a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Sample> f12596b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Sample[] f12597c = new Sample[5];

    /* renamed from: d  reason: collision with root package name */
    private int f12598d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f12599e;

    /* renamed from: f  reason: collision with root package name */
    private int f12600f;

    /* renamed from: g  reason: collision with root package name */
    private int f12601g;

    private static class Sample {

        /* renamed from: a  reason: collision with root package name */
        public int f12602a;

        /* renamed from: b  reason: collision with root package name */
        public int f12603b;

        /* renamed from: c  reason: collision with root package name */
        public float f12604c;

        private Sample() {
        }
    }

    public SlidingPercentile(int i2) {
        this.f12595a = i2;
    }

    private void d() {
        if (this.f12598d != 1) {
            Collections.sort(this.f12596b, f12589h);
            this.f12598d = 1;
        }
    }

    private void e() {
        if (this.f12598d != 0) {
            Collections.sort(this.f12596b, f12590i);
            this.f12598d = 0;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int g(Sample sample, Sample sample2) {
        return sample.f12602a - sample2.f12602a;
    }

    public void c(int i2, float f2) {
        Sample sample;
        int i3;
        Sample sample2;
        int i4;
        d();
        int i5 = this.f12601g;
        if (i5 > 0) {
            Sample[] sampleArr = this.f12597c;
            int i6 = i5 - 1;
            this.f12601g = i6;
            sample = sampleArr[i6];
        } else {
            sample = new Sample();
        }
        int i7 = this.f12599e;
        this.f12599e = i7 + 1;
        sample.f12602a = i7;
        sample.f12603b = i2;
        sample.f12604c = f2;
        this.f12596b.add(sample);
        int i8 = this.f12600f + i2;
        while (true) {
            this.f12600f = i8;
            while (true) {
                int i9 = this.f12600f;
                int i10 = this.f12595a;
                if (i9 > i10) {
                    i3 = i9 - i10;
                    sample2 = this.f12596b.get(0);
                    i4 = sample2.f12603b;
                    if (i4 > i3) {
                        break;
                    }
                    this.f12600f -= i4;
                    this.f12596b.remove(0);
                    int i11 = this.f12601g;
                    if (i11 < 5) {
                        Sample[] sampleArr2 = this.f12597c;
                        this.f12601g = i11 + 1;
                        sampleArr2[i11] = sample2;
                    }
                } else {
                    return;
                }
            }
            sample2.f12603b = i4 - i3;
            i8 = this.f12600f - i3;
        }
    }

    public float f(float f2) {
        e();
        float f3 = f2 * ((float) this.f12600f);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f12596b.size(); i3++) {
            Sample sample = this.f12596b.get(i3);
            i2 += sample.f12603b;
            if (((float) i2) >= f3) {
                return sample.f12604c;
            }
        }
        if (this.f12596b.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<Sample> arrayList = this.f12596b;
        return arrayList.get(arrayList.size() - 1).f12604c;
    }

    public void i() {
        this.f12596b.clear();
        this.f12598d = -1;
        this.f12599e = 0;
        this.f12600f = 0;
    }
}
