package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class Palette {

    /* renamed from: f  reason: collision with root package name */
    static final int f14972f = 12544;

    /* renamed from: g  reason: collision with root package name */
    static final int f14973g = 16;

    /* renamed from: h  reason: collision with root package name */
    static final float f14974h = 3.0f;

    /* renamed from: i  reason: collision with root package name */
    static final float f14975i = 4.5f;

    /* renamed from: j  reason: collision with root package name */
    static final String f14976j = "Palette";

    /* renamed from: k  reason: collision with root package name */
    static final boolean f14977k = false;

    /* renamed from: l  reason: collision with root package name */
    static final Filter f14978l = new Filter() {

        /* renamed from: a  reason: collision with root package name */
        private static final float f14984a = 0.05f;

        /* renamed from: b  reason: collision with root package name */
        private static final float f14985b = 0.95f;

        private boolean b(float[] fArr) {
            return fArr[2] <= f14984a;
        }

        private boolean c(float[] fArr) {
            float f2 = fArr[0];
            return f2 >= 10.0f && f2 <= 37.0f && fArr[1] <= 0.82f;
        }

        private boolean d(float[] fArr) {
            return fArr[2] >= f14985b;
        }

        public boolean a(int i2, float[] fArr) {
            return !d(fArr) && !b(fArr) && !c(fArr);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final List<Swatch> f14979a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Target> f14980b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Target, Swatch> f14981c = new ArrayMap();

    /* renamed from: d  reason: collision with root package name */
    private final SparseBooleanArray f14982d = new SparseBooleanArray();
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Swatch f14983e = a();

    public static final class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final List<Swatch> f14986a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f14987b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Target> f14988c;

        /* renamed from: d  reason: collision with root package name */
        private int f14989d;

        /* renamed from: e  reason: collision with root package name */
        private int f14990e;

        /* renamed from: f  reason: collision with root package name */
        private int f14991f;

        /* renamed from: g  reason: collision with root package name */
        private final List<Filter> f14992g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private Rect f14993h;

        public Builder(@NonNull Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.f14988c = arrayList;
            this.f14989d = 16;
            this.f14990e = Palette.f14972f;
            this.f14991f = -1;
            ArrayList arrayList2 = new ArrayList();
            this.f14992g = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(Palette.f14978l);
            this.f14987b = bitmap;
            this.f14986a = null;
            arrayList.add(Target.y);
            arrayList.add(Target.z);
            arrayList.add(Target.A);
            arrayList.add(Target.B);
            arrayList.add(Target.C);
            arrayList.add(Target.D);
        }

        private int[] h(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.f14993h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.f14993h.height();
            int[] iArr2 = new int[(width2 * height2)];
            for (int i2 = 0; i2 < height2; i2++) {
                Rect rect2 = this.f14993h;
                System.arraycopy(iArr, ((rect2.top + i2) * width) + rect2.left, iArr2, i2 * width2, width2);
            }
            return iArr2;
        }

        private Bitmap l(Bitmap bitmap) {
            int max;
            int i2;
            double d2 = -1.0d;
            if (this.f14990e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i3 = this.f14990e;
                if (width > i3) {
                    d2 = Math.sqrt(((double) i3) / ((double) width));
                }
            } else if (this.f14991f > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i2 = this.f14991f)) {
                d2 = ((double) i2) / ((double) max);
            }
            return d2 <= 0.0d ? bitmap : Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * d2), (int) Math.ceil(((double) bitmap.getHeight()) * d2), false);
        }

        @NonNull
        public Builder a(Filter filter) {
            if (filter != null) {
                this.f14992g.add(filter);
            }
            return this;
        }

        @NonNull
        public Builder b(@NonNull Target target) {
            if (!this.f14988c.contains(target)) {
                this.f14988c.add(target);
            }
            return this;
        }

        @NonNull
        public Builder c() {
            this.f14992g.clear();
            return this;
        }

        @NonNull
        public Builder d() {
            this.f14993h = null;
            return this;
        }

        @NonNull
        public Builder e() {
            List<Target> list = this.f14988c;
            if (list != null) {
                list.clear();
            }
            return this;
        }

        @NonNull
        public AsyncTask<Bitmap, Void, Palette> f(@NonNull final PaletteAsyncListener paletteAsyncListener) {
            if (paletteAsyncListener != null) {
                return new AsyncTask<Bitmap, Void, Palette>() {
                    /* access modifiers changed from: protected */
                    @Nullable
                    /* renamed from: a */
                    public Palette doInBackground(Bitmap... bitmapArr) {
                        try {
                            return Builder.this.g();
                        } catch (Exception e2) {
                            Log.e(Palette.f14976j, "Exception thrown during async generate", e2);
                            return null;
                        }
                    }

                    /* access modifiers changed from: protected */
                    /* renamed from: b */
                    public void onPostExecute(@Nullable Palette palette) {
                        paletteAsyncListener.a(palette);
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[]{this.f14987b});
            }
            throw new IllegalArgumentException("listener can not be null");
        }

        @NonNull
        public Palette g() {
            List<Swatch> list;
            Filter[] filterArr;
            Bitmap bitmap = this.f14987b;
            if (bitmap != null) {
                Bitmap l2 = l(bitmap);
                Rect rect = this.f14993h;
                if (!(l2 == this.f14987b || rect == null)) {
                    double width = ((double) l2.getWidth()) / ((double) this.f14987b.getWidth());
                    rect.left = (int) Math.floor(((double) rect.left) * width);
                    rect.top = (int) Math.floor(((double) rect.top) * width);
                    rect.right = Math.min((int) Math.ceil(((double) rect.right) * width), l2.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(((double) rect.bottom) * width), l2.getHeight());
                }
                int[] h2 = h(l2);
                int i2 = this.f14989d;
                if (this.f14992g.isEmpty()) {
                    filterArr = null;
                } else {
                    List<Filter> list2 = this.f14992g;
                    filterArr = (Filter[]) list2.toArray(new Filter[list2.size()]);
                }
                ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(h2, i2, filterArr);
                if (l2 != this.f14987b) {
                    l2.recycle();
                }
                list = colorCutQuantizer.d();
            } else {
                list = this.f14986a;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            Palette palette = new Palette(list, this.f14988c);
            palette.f();
            return palette;
        }

        @NonNull
        public Builder i(int i2) {
            this.f14989d = i2;
            return this;
        }

        @NonNull
        public Builder j(int i2) {
            this.f14990e = i2;
            this.f14991f = -1;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder k(int i2) {
            this.f14991f = i2;
            this.f14990e = -1;
            return this;
        }

        @NonNull
        public Builder m(@Px int i2, @Px int i3, @Px int i4, @Px int i5) {
            if (this.f14987b != null) {
                if (this.f14993h == null) {
                    this.f14993h = new Rect();
                }
                this.f14993h.set(0, 0, this.f14987b.getWidth(), this.f14987b.getHeight());
                if (!this.f14993h.intersect(i2, i3, i4, i5)) {
                    throw new IllegalArgumentException("The given region must intersect with the Bitmap's dimensions.");
                }
            }
            return this;
        }

        public Builder(@NonNull List<Swatch> list) {
            this.f14988c = new ArrayList();
            this.f14989d = 16;
            this.f14990e = Palette.f14972f;
            this.f14991f = -1;
            ArrayList arrayList = new ArrayList();
            this.f14992g = arrayList;
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("List of Swatches is not valid");
            }
            arrayList.add(Palette.f14978l);
            this.f14986a = list;
            this.f14987b = null;
        }
    }

    public interface Filter {
        boolean a(@ColorInt int i2, @NonNull float[] fArr);
    }

    public interface PaletteAsyncListener {
        void a(@Nullable Palette palette);
    }

    public static final class Swatch {

        /* renamed from: a  reason: collision with root package name */
        private final int f14996a;

        /* renamed from: b  reason: collision with root package name */
        private final int f14997b;

        /* renamed from: c  reason: collision with root package name */
        private final int f14998c;

        /* renamed from: d  reason: collision with root package name */
        private final int f14999d;

        /* renamed from: e  reason: collision with root package name */
        private final int f15000e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f15001f;

        /* renamed from: g  reason: collision with root package name */
        private int f15002g;

        /* renamed from: h  reason: collision with root package name */
        private int f15003h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private float[] f15004i;

        public Swatch(@ColorInt int i2, int i3) {
            this.f14996a = Color.red(i2);
            this.f14997b = Color.green(i2);
            this.f14998c = Color.blue(i2);
            this.f14999d = i2;
            this.f15000e = i3;
        }

        private void a() {
            int D;
            if (!this.f15001f) {
                int o = ColorUtils.o(-1, this.f14999d, Palette.f14975i);
                int o2 = ColorUtils.o(-1, this.f14999d, 3.0f);
                if (o == -1 || o2 == -1) {
                    int o3 = ColorUtils.o(ViewCompat.y, this.f14999d, Palette.f14975i);
                    int o4 = ColorUtils.o(ViewCompat.y, this.f14999d, 3.0f);
                    if (o3 == -1 || o4 == -1) {
                        this.f15003h = o != -1 ? ColorUtils.D(-1, o) : ColorUtils.D(ViewCompat.y, o3);
                        this.f15002g = o2 != -1 ? ColorUtils.D(-1, o2) : ColorUtils.D(ViewCompat.y, o4);
                        this.f15001f = true;
                        return;
                    }
                    this.f15003h = ColorUtils.D(ViewCompat.y, o3);
                    D = ColorUtils.D(ViewCompat.y, o4);
                } else {
                    this.f15003h = ColorUtils.D(-1, o);
                    D = ColorUtils.D(-1, o2);
                }
                this.f15002g = D;
                this.f15001f = true;
            }
        }

        @ColorInt
        public int b() {
            a();
            return this.f15003h;
        }

        @NonNull
        public float[] c() {
            if (this.f15004i == null) {
                this.f15004i = new float[3];
            }
            ColorUtils.e(this.f14996a, this.f14997b, this.f14998c, this.f15004i);
            return this.f15004i;
        }

        public int d() {
            return this.f15000e;
        }

        @ColorInt
        public int e() {
            return this.f14999d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Swatch.class != obj.getClass()) {
                return false;
            }
            Swatch swatch = (Swatch) obj;
            return this.f15000e == swatch.f15000e && this.f14999d == swatch.f14999d;
        }

        @ColorInt
        public int f() {
            a();
            return this.f15002g;
        }

        public int hashCode() {
            return (this.f14999d * 31) + this.f15000e;
        }

        public String toString() {
            return Swatch.class.getSimpleName() + " [RGB: #" + Integer.toHexString(e()) + ']' + " [HSL: " + Arrays.toString(c()) + ']' + " [Population: " + this.f15000e + ']' + " [Title Text: #" + Integer.toHexString(f()) + ']' + " [Body Text: #" + Integer.toHexString(b()) + ']';
        }

        Swatch(int i2, int i3, int i4, int i5) {
            this.f14996a = i2;
            this.f14997b = i3;
            this.f14998c = i4;
            this.f14999d = Color.rgb(i2, i3, i4);
            this.f15000e = i5;
        }

        Swatch(float[] fArr, int i2) {
            this(ColorUtils.a(fArr), i2);
            this.f15004i = fArr;
        }
    }

    Palette(List<Swatch> list, List<Target> list2) {
        this.f14979a = list;
        this.f14980b = list2;
    }

    private boolean D(Swatch swatch, Target target) {
        float[] c2 = swatch.c();
        return c2[1] >= target.e() && c2[1] <= target.c() && c2[2] >= target.d() && c2[2] <= target.b() && !this.f14982d.get(swatch.e());
    }

    @Nullable
    private Swatch a() {
        int size = this.f14979a.size();
        int i2 = Integer.MIN_VALUE;
        Swatch swatch = null;
        for (int i3 = 0; i3 < size; i3++) {
            Swatch swatch2 = this.f14979a.get(i3);
            if (swatch2.d() > i2) {
                i2 = swatch2.d();
                swatch = swatch2;
            }
        }
        return swatch;
    }

    @NonNull
    public static Builder b(@NonNull Bitmap bitmap) {
        return new Builder(bitmap);
    }

    @NonNull
    public static Palette c(@NonNull List<Swatch> list) {
        return new Builder(list).g();
    }

    @Deprecated
    public static Palette d(Bitmap bitmap) {
        return b(bitmap).g();
    }

    @Deprecated
    public static Palette e(Bitmap bitmap, int i2) {
        return b(bitmap).i(i2).g();
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> g(Bitmap bitmap, int i2, PaletteAsyncListener paletteAsyncListener) {
        return b(bitmap).i(i2).f(paletteAsyncListener);
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> h(Bitmap bitmap, PaletteAsyncListener paletteAsyncListener) {
        return b(bitmap).f(paletteAsyncListener);
    }

    private float i(Swatch swatch, Target target) {
        float[] c2 = swatch.c();
        Swatch swatch2 = this.f14983e;
        int d2 = swatch2 != null ? swatch2.d() : 1;
        float f2 = 0.0f;
        float g2 = target.g() > 0.0f ? target.g() * (1.0f - Math.abs(c2[1] - target.i())) : 0.0f;
        float a2 = target.a() > 0.0f ? target.a() * (1.0f - Math.abs(c2[2] - target.h())) : 0.0f;
        if (target.f() > 0.0f) {
            f2 = target.f() * (((float) swatch.d()) / ((float) d2));
        }
        return g2 + a2 + f2;
    }

    @Nullable
    private Swatch j(Target target) {
        Swatch v = v(target);
        if (v != null && target.j()) {
            this.f14982d.append(v.e(), true);
        }
        return v;
    }

    @Nullable
    private Swatch v(Target target) {
        int size = this.f14979a.size();
        float f2 = 0.0f;
        Swatch swatch = null;
        for (int i2 = 0; i2 < size; i2++) {
            Swatch swatch2 = this.f14979a.get(i2);
            if (D(swatch2, target)) {
                float i3 = i(swatch2, target);
                if (swatch == null || i3 > f2) {
                    swatch = swatch2;
                    f2 = i3;
                }
            }
        }
        return swatch;
    }

    @NonNull
    public List<Target> A() {
        return Collections.unmodifiableList(this.f14980b);
    }

    @ColorInt
    public int B(@ColorInt int i2) {
        return k(Target.z, i2);
    }

    @Nullable
    public Swatch C() {
        return y(Target.z);
    }

    /* access modifiers changed from: package-private */
    public void f() {
        int size = this.f14980b.size();
        for (int i2 = 0; i2 < size; i2++) {
            Target target = this.f14980b.get(i2);
            target.k();
            this.f14981c.put(target, j(target));
        }
        this.f14982d.clear();
    }

    @ColorInt
    public int k(@NonNull Target target, @ColorInt int i2) {
        Swatch y = y(target);
        return y != null ? y.e() : i2;
    }

    @ColorInt
    public int l(@ColorInt int i2) {
        return k(Target.D, i2);
    }

    @Nullable
    public Swatch m() {
        return y(Target.D);
    }

    @ColorInt
    public int n(@ColorInt int i2) {
        return k(Target.A, i2);
    }

    @Nullable
    public Swatch o() {
        return y(Target.A);
    }

    @ColorInt
    public int p(@ColorInt int i2) {
        Swatch swatch = this.f14983e;
        return swatch != null ? swatch.e() : i2;
    }

    @Nullable
    public Swatch q() {
        return this.f14983e;
    }

    @ColorInt
    public int r(@ColorInt int i2) {
        return k(Target.B, i2);
    }

    @Nullable
    public Swatch s() {
        return y(Target.B);
    }

    @ColorInt
    public int t(@ColorInt int i2) {
        return k(Target.y, i2);
    }

    @Nullable
    public Swatch u() {
        return y(Target.y);
    }

    @ColorInt
    public int w(@ColorInt int i2) {
        return k(Target.C, i2);
    }

    @Nullable
    public Swatch x() {
        return y(Target.C);
    }

    @Nullable
    public Swatch y(@NonNull Target target) {
        return this.f14981c.get(target);
    }

    @NonNull
    public List<Swatch> z() {
        return Collections.unmodifiableList(this.f14979a);
    }
}
