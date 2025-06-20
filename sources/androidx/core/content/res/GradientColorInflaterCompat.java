package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
final class GradientColorInflaterCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final int f5780a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f5781b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f5782c = 2;

    static final class ColorStops {

        /* renamed from: a  reason: collision with root package name */
        final int[] f5783a;

        /* renamed from: b  reason: collision with root package name */
        final float[] f5784b;

        ColorStops(@ColorInt int i2, @ColorInt int i3) {
            this.f5783a = new int[]{i2, i3};
            this.f5784b = new float[]{0.0f, 1.0f};
        }

        ColorStops(@ColorInt int i2, @ColorInt int i3, @ColorInt int i4) {
            this.f5783a = new int[]{i2, i3, i4};
            this.f5784b = new float[]{0.0f, 0.5f, 1.0f};
        }

        ColorStops(@NonNull List<Integer> list, @NonNull List<Float> list2) {
            int size = list.size();
            this.f5783a = new int[size];
            this.f5784b = new float[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.f5783a[i2] = list.get(i2).intValue();
                this.f5784b[i2] = list2.get(i2).floatValue();
            }
        }
    }

    private GradientColorInflaterCompat() {
    }

    private static ColorStops a(@Nullable ColorStops colorStops, @ColorInt int i2, @ColorInt int i3, boolean z, @ColorInt int i4) {
        ColorStops colorStops2;
        if (colorStops != null) {
            return colorStops;
        }
        if (z) {
            return colorStops2;
        }
        colorStops2 = new ColorStops(i2, i3);
        return colorStops2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Shader b(@androidx.annotation.NonNull android.content.res.Resources r4, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r5, @androidx.annotation.Nullable android.content.res.Resources.Theme r6) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)
        L_0x0004:
            int r1 = r5.next()
            r2 = 2
            if (r1 == r2) goto L_0x000f
            r3 = 1
            if (r1 == r3) goto L_0x000f
            goto L_0x0004
        L_0x000f:
            if (r1 != r2) goto L_0x0016
            android.graphics.Shader r4 = c(r4, r5, r0, r6)
            return r4
        L_0x0016:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.GradientColorInflaterCompat.b(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme):android.graphics.Shader");
    }

    static Shader c(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            Resources.Theme theme2 = theme;
            TypedArray s = TypedArrayUtils.s(resources, theme2, attributeSet, R.styleable.C);
            float j2 = TypedArrayUtils.j(s, xmlPullParser2, "startX", R.styleable.L, 0.0f);
            float j3 = TypedArrayUtils.j(s, xmlPullParser2, "startY", R.styleable.M, 0.0f);
            float j4 = TypedArrayUtils.j(s, xmlPullParser2, "endX", R.styleable.N, 0.0f);
            float j5 = TypedArrayUtils.j(s, xmlPullParser2, "endY", R.styleable.O, 0.0f);
            float j6 = TypedArrayUtils.j(s, xmlPullParser2, "centerX", R.styleable.G, 0.0f);
            float j7 = TypedArrayUtils.j(s, xmlPullParser2, "centerY", R.styleable.H, 0.0f);
            int k2 = TypedArrayUtils.k(s, xmlPullParser2, "type", R.styleable.F, 0);
            int f2 = TypedArrayUtils.f(s, xmlPullParser2, "startColor", R.styleable.D, 0);
            boolean r = TypedArrayUtils.r(xmlPullParser2, "centerColor");
            int f3 = TypedArrayUtils.f(s, xmlPullParser2, "centerColor", R.styleable.K, 0);
            int f4 = TypedArrayUtils.f(s, xmlPullParser2, "endColor", R.styleable.E, 0);
            int k3 = TypedArrayUtils.k(s, xmlPullParser2, "tileMode", R.styleable.J, 0);
            float f5 = j6;
            float j8 = TypedArrayUtils.j(s, xmlPullParser2, "gradientRadius", R.styleable.I, 0.0f);
            s.recycle();
            ColorStops a2 = a(d(resources, xmlPullParser, attributeSet, theme), f2, f4, r, f3);
            if (k2 == 1) {
                float f6 = f5;
                if (j8 > 0.0f) {
                    int[] iArr = a2.f5783a;
                    return new RadialGradient(f6, j7, j8, iArr, a2.f5784b, e(k3));
                }
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            } else if (k2 != 2) {
                return new LinearGradient(j2, j3, j4, j5, a2.f5783a, a2.f5784b, e(k3));
            } else {
                return new SweepGradient(f5, j7, a2.f5783a, a2.f5784b);
            }
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.core.content.res.GradientColorInflaterCompat.ColorStops d(@androidx.annotation.NonNull android.content.res.Resources r9, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r10, @androidx.annotation.NonNull android.util.AttributeSet r11, @androidx.annotation.Nullable android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L_0x0012:
            int r3 = r10.next()
            if (r3 == r1) goto L_0x0081
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L_0x0021
            r6 = 3
            if (r3 == r6) goto L_0x0081
        L_0x0021:
            r6 = 2
            if (r3 == r6) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            if (r5 > r0) goto L_0x0012
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0034
            goto L_0x0012
        L_0x0034:
            int[] r3 = androidx.core.R.styleable.P
            android.content.res.TypedArray r3 = androidx.core.content.res.TypedArrayUtils.s(r9, r12, r11, r3)
            int r5 = androidx.core.R.styleable.Q
            boolean r6 = r3.hasValue(r5)
            int r7 = androidx.core.R.styleable.R
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L_0x0066
            if (r8 == 0) goto L_0x0066
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L_0x0012
        L_0x0066:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L_0x0081:
            int r9 = r4.size()
            if (r9 <= 0) goto L_0x008d
            androidx.core.content.res.GradientColorInflaterCompat$ColorStops r9 = new androidx.core.content.res.GradientColorInflaterCompat$ColorStops
            r9.<init>((java.util.List<java.lang.Integer>) r4, (java.util.List<java.lang.Float>) r2)
            return r9
        L_0x008d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.GradientColorInflaterCompat.d(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.res.GradientColorInflaterCompat$ColorStops");
    }

    private static Shader.TileMode e(int i2) {
        if (i2 != 1) {
            return i2 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }
}
