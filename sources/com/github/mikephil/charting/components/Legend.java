package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class Legend extends ComponentBase {
    public float A;
    private boolean B;
    private List<FSize> C;
    private List<Boolean> D;
    private List<FSize> E;

    /* renamed from: g  reason: collision with root package name */
    private LegendEntry[] f18943g;

    /* renamed from: h  reason: collision with root package name */
    private LegendEntry[] f18944h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f18945i;

    /* renamed from: j  reason: collision with root package name */
    private LegendHorizontalAlignment f18946j;

    /* renamed from: k  reason: collision with root package name */
    private LegendVerticalAlignment f18947k;

    /* renamed from: l  reason: collision with root package name */
    private LegendOrientation f18948l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f18949m;

    /* renamed from: n  reason: collision with root package name */
    private LegendDirection f18950n;
    private LegendForm o;
    private float p;
    private float q;
    private DashPathEffect r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    public float x;
    public float y;
    public float z;

    /* renamed from: com.github.mikephil.charting.components.Legend$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18951a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r0 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18951a = r0
                com.github.mikephil.charting.components.Legend$LegendOrientation r1 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f18951a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendOrientation r1 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.components.Legend.AnonymousClass1.<clinit>():void");
        }
    }

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public Legend() {
        this.f18943g = new LegendEntry[0];
        this.f18945i = false;
        this.f18946j = LegendHorizontalAlignment.LEFT;
        this.f18947k = LegendVerticalAlignment.BOTTOM;
        this.f18948l = LegendOrientation.HORIZONTAL;
        this.f18949m = false;
        this.f18950n = LegendDirection.LEFT_TO_RIGHT;
        this.o = LegendForm.SQUARE;
        this.p = 8.0f;
        this.q = 3.0f;
        this.r = null;
        this.s = 6.0f;
        this.t = 0.0f;
        this.u = 5.0f;
        this.v = 3.0f;
        this.w = 0.95f;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.A = 0.0f;
        this.B = false;
        this.C = new ArrayList(16);
        this.D = new ArrayList(16);
        this.E = new ArrayList(16);
        this.f18938e = Utils.e(10.0f);
        this.f18935b = Utils.e(5.0f);
        this.f18936c = Utils.e(3.0f);
    }

    public float A(Paint paint) {
        float f2 = 0.0f;
        for (LegendEntry legendEntry : this.f18943g) {
            String str = legendEntry.f18952a;
            if (str != null) {
                float a2 = (float) Utils.a(paint, str);
                if (a2 > f2) {
                    f2 = a2;
                }
            }
        }
        return f2;
    }

    public float B(Paint paint) {
        float e2 = Utils.e(this.u);
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (LegendEntry legendEntry : this.f18943g) {
            float e3 = Utils.e(Float.isNaN(legendEntry.f18954c) ? this.p : legendEntry.f18954c);
            if (e3 > f3) {
                f3 = e3;
            }
            String str = legendEntry.f18952a;
            if (str != null) {
                float d2 = (float) Utils.d(paint, str);
                if (d2 > f2) {
                    f2 = d2;
                }
            }
        }
        return f2 + f3 + e2;
    }

    public LegendOrientation C() {
        return this.f18948l;
    }

    public float D() {
        return this.v;
    }

    public LegendVerticalAlignment E() {
        return this.f18947k;
    }

    public float F() {
        return this.s;
    }

    public float G() {
        return this.t;
    }

    public boolean H() {
        return this.f18949m;
    }

    public boolean I() {
        return this.f18945i;
    }

    public boolean J() {
        return this.B;
    }

    public void K() {
        this.f18945i = false;
    }

    public void L(List<LegendEntry> list) {
        this.f18943g = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
        this.f18945i = true;
    }

    public void M(LegendEntry[] legendEntryArr) {
        this.f18943g = legendEntryArr;
        this.f18945i = true;
    }

    public void N(LegendDirection legendDirection) {
        this.f18950n = legendDirection;
    }

    public void O(boolean z2) {
        this.f18949m = z2;
    }

    public void P(List<LegendEntry> list) {
        this.f18943g = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void Q(List<LegendEntry> list) {
        this.f18944h = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void R(int[] iArr, String[] strArr) {
        LegendForm legendForm;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < Math.min(iArr.length, strArr.length); i2++) {
            LegendEntry legendEntry = new LegendEntry();
            int i3 = iArr[i2];
            legendEntry.f18957f = i3;
            legendEntry.f18952a = strArr[i2];
            if (i3 == 1122868 || i3 == 0) {
                legendForm = LegendForm.NONE;
            } else if (i3 == 1122867) {
                legendForm = LegendForm.EMPTY;
            } else {
                arrayList.add(legendEntry);
            }
            legendEntry.f18953b = legendForm;
            arrayList.add(legendEntry);
        }
        this.f18944h = (LegendEntry[]) arrayList.toArray(new LegendEntry[arrayList.size()]);
    }

    public void S(LegendEntry[] legendEntryArr) {
        if (legendEntryArr == null) {
            legendEntryArr = new LegendEntry[0];
        }
        this.f18944h = legendEntryArr;
    }

    public void T(LegendForm legendForm) {
        this.o = legendForm;
    }

    public void U(DashPathEffect dashPathEffect) {
        this.r = dashPathEffect;
    }

    public void V(float f2) {
        this.q = f2;
    }

    public void W(float f2) {
        this.p = f2;
    }

    public void X(float f2) {
        this.u = f2;
    }

    public void Y(LegendHorizontalAlignment legendHorizontalAlignment) {
        this.f18946j = legendHorizontalAlignment;
    }

    public void Z(float f2) {
        this.w = f2;
    }

    public void a0(LegendOrientation legendOrientation) {
        this.f18948l = legendOrientation;
    }

    public void b0(float f2) {
        this.v = f2;
    }

    public void c0(LegendVerticalAlignment legendVerticalAlignment) {
        this.f18947k = legendVerticalAlignment;
    }

    public void d0(boolean z2) {
        this.B = z2;
    }

    public void e0(float f2) {
        this.s = f2;
    }

    public void f0(float f2) {
        this.t = f2;
    }

    public void m(Paint paint, ViewPortHandler viewPortHandler) {
        float f2;
        float f3;
        float f4;
        Paint paint2 = paint;
        float e2 = Utils.e(this.p);
        float e3 = Utils.e(this.v);
        float e4 = Utils.e(this.u);
        float e5 = Utils.e(this.s);
        float e6 = Utils.e(this.t);
        boolean z2 = this.B;
        LegendEntry[] legendEntryArr = this.f18943g;
        int length = legendEntryArr.length;
        this.A = B(paint);
        this.z = A(paint);
        int i2 = AnonymousClass1.f18951a[this.f18948l.ordinal()];
        if (i2 == 1) {
            float f5 = e2;
            float f6 = e3;
            LegendEntry[] legendEntryArr2 = legendEntryArr;
            float t2 = Utils.t(paint);
            float f7 = 0.0f;
            float f8 = 0.0f;
            float f9 = 0.0f;
            boolean z3 = false;
            for (int i3 = 0; i3 < length; i3++) {
                LegendEntry legendEntry = legendEntryArr2[i3];
                boolean z4 = legendEntry.f18953b != LegendForm.NONE;
                float e7 = Float.isNaN(legendEntry.f18954c) ? f5 : Utils.e(legendEntry.f18954c);
                String str = legendEntry.f18952a;
                if (!z3) {
                    f9 = 0.0f;
                }
                if (z4) {
                    if (z3) {
                        f9 += f6;
                    }
                    f9 += e7;
                }
                if (str != null) {
                    if (z4 && !z3) {
                        f9 += e4;
                    } else if (z3) {
                        f7 = Math.max(f7, f9);
                        f8 += t2 + e6;
                        f9 = 0.0f;
                        z3 = false;
                    }
                    f9 += (float) Utils.d(paint2, str);
                    if (i3 < length - 1) {
                        f8 += t2 + e6;
                    }
                } else {
                    f9 += e7;
                    if (i3 < length - 1) {
                        f9 += f6;
                    }
                    z3 = true;
                }
                f7 = Math.max(f7, f9);
            }
            this.x = f7;
            this.y = f8;
        } else if (i2 == 2) {
            float t3 = Utils.t(paint);
            float v2 = Utils.v(paint) + e6;
            float k2 = viewPortHandler.k() * this.w;
            this.D.clear();
            this.C.clear();
            this.E.clear();
            int i4 = 0;
            float f10 = 0.0f;
            int i5 = -1;
            float f11 = 0.0f;
            float f12 = 0.0f;
            while (i4 < length) {
                LegendEntry legendEntry2 = legendEntryArr[i4];
                float f13 = e2;
                float f14 = e5;
                boolean z5 = legendEntry2.f18953b != LegendForm.NONE;
                float e8 = Float.isNaN(legendEntry2.f18954c) ? f13 : Utils.e(legendEntry2.f18954c);
                String str2 = legendEntry2.f18952a;
                LegendEntry[] legendEntryArr3 = legendEntryArr;
                float f15 = v2;
                this.D.add(Boolean.FALSE);
                float f16 = i5 == -1 ? 0.0f : f11 + e3;
                if (str2 != null) {
                    f2 = e3;
                    this.C.add(Utils.b(paint2, str2));
                    f3 = f16 + (z5 ? e4 + e8 : 0.0f) + this.C.get(i4).Y;
                } else {
                    f2 = e3;
                    float f17 = e8;
                    this.C.add(FSize.b(0.0f, 0.0f));
                    f3 = f16 + (z5 ? f17 : 0.0f);
                    if (i5 == -1) {
                        i5 = i4;
                    }
                }
                if (str2 != null || i4 == length - 1) {
                    float f18 = f12;
                    int i6 = (f18 > 0.0f ? 1 : (f18 == 0.0f ? 0 : -1));
                    float f19 = i6 == 0 ? 0.0f : f14;
                    if (!z2 || i6 == 0 || k2 - f18 >= f19 + f3) {
                        f4 = f18 + f19 + f3;
                    } else {
                        this.E.add(FSize.b(f18, t3));
                        f10 = Math.max(f10, f18);
                        this.D.set(i5 > -1 ? i5 : i4, Boolean.TRUE);
                        f4 = f3;
                    }
                    if (i4 == length - 1) {
                        this.E.add(FSize.b(f4, t3));
                        f10 = Math.max(f10, f4);
                    }
                    f12 = f4;
                }
                if (str2 != null) {
                    i5 = -1;
                }
                i4++;
                e3 = f2;
                e2 = f13;
                e5 = f14;
                v2 = f15;
                f11 = f3;
                legendEntryArr = legendEntryArr3;
            }
            float f20 = v2;
            this.x = f10;
            this.y = (t3 * ((float) this.E.size())) + (f20 * ((float) (this.E.size() == 0 ? 0 : this.E.size() - 1)));
        }
        this.y += this.f18936c;
        this.x += this.f18935b;
    }

    public List<Boolean> n() {
        return this.D;
    }

    public List<FSize> o() {
        return this.C;
    }

    public List<FSize> p() {
        return this.E;
    }

    public LegendDirection q() {
        return this.f18950n;
    }

    public LegendEntry[] r() {
        return this.f18943g;
    }

    public LegendEntry[] s() {
        return this.f18944h;
    }

    public LegendForm t() {
        return this.o;
    }

    public DashPathEffect u() {
        return this.r;
    }

    public float v() {
        return this.q;
    }

    public float w() {
        return this.p;
    }

    public float x() {
        return this.u;
    }

    public LegendHorizontalAlignment y() {
        return this.f18946j;
    }

    public float z() {
        return this.w;
    }

    public Legend(LegendEntry[] legendEntryArr) {
        this();
        if (legendEntryArr != null) {
            this.f18943g = legendEntryArr;
            return;
        }
        throw new IllegalArgumentException("entries array is NULL");
    }
}
