package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ColorStateListInflaterCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f5758a = new ThreadLocal<>();

    private ColorStateListInflaterCompat() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList a(@androidx.annotation.NonNull android.content.res.Resources r4, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r5, @androidx.annotation.Nullable android.content.res.Resources.Theme r6) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
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
            android.content.res.ColorStateList r4 = b(r4, r5, r0, r6)
            return r4
        L_0x0016:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ColorStateListInflaterCompat.a(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    @NonNull
    public static ColorStateList b(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    @NonNull
    private static TypedValue c() {
        ThreadLocal<TypedValue> threadLocal = f5758a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @Nullable
    public static ColorStateList d(@NonNull Resources resources, @XmlRes int i2, @Nullable Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i2), theme);
        } catch (Exception e2) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e2);
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object[]] */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0075, code lost:
        if (r9.hasValue(r11) != false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0086, code lost:
        if (r9.hasValue(r11) != false) goto L_0x0088;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList e(@androidx.annotation.NonNull android.content.res.Resources r17, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r18, @androidx.annotation.NonNull android.util.AttributeSet r19, @androidx.annotation.Nullable android.content.res.Resources.Theme r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = r17
            r1 = r19
            r2 = r20
            int r3 = r18.getDepth()
            r4 = 1
            int r3 = r3 + r4
            r5 = 20
            int[][] r6 = new int[r5][]
            int[] r5 = new int[r5]
            r8 = 0
        L_0x0013:
            int r9 = r18.next()
            if (r9 == r4) goto L_0x00e1
            int r10 = r18.getDepth()
            if (r10 >= r3) goto L_0x0022
            r11 = 3
            if (r9 == r11) goto L_0x00e1
        L_0x0022:
            r11 = 2
            if (r9 != r11) goto L_0x00dc
            if (r10 > r3) goto L_0x00dc
            java.lang.String r9 = r18.getName()
            java.lang.String r10 = "item"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0035
            goto L_0x00dc
        L_0x0035:
            int[] r9 = androidx.core.R.styleable.f5187d
            android.content.res.TypedArray r9 = h(r0, r2, r1, r9)
            int r10 = androidx.core.R.styleable.f5188e
            r11 = -1
            int r12 = r9.getResourceId(r10, r11)
            r13 = -65281(0xffffffffffff00ff, float:NaN)
            if (r12 == r11) goto L_0x005c
            boolean r11 = f(r0, r12)
            if (r11 != 0) goto L_0x005c
            android.content.res.XmlResourceParser r10 = r0.getXml(r12)     // Catch:{ Exception -> 0x005a }
            android.content.res.ColorStateList r10 = a(r0, r10, r2)     // Catch:{ Exception -> 0x005a }
            int r10 = r10.getDefaultColor()     // Catch:{ Exception -> 0x005a }
            goto L_0x0060
        L_0x005a:
            int r10 = androidx.core.R.styleable.f5188e
        L_0x005c:
            int r10 = r9.getColor(r10, r13)
        L_0x0060:
            int r11 = androidx.core.R.styleable.f5189f
            boolean r12 = r9.hasValue(r11)
            r13 = 1065353216(0x3f800000, float:1.0)
            if (r12 == 0) goto L_0x006f
        L_0x006a:
            float r13 = r9.getFloat(r11, r13)
            goto L_0x0078
        L_0x006f:
            int r11 = androidx.core.R.styleable.f5191h
            boolean r12 = r9.hasValue(r11)
            if (r12 == 0) goto L_0x0078
            goto L_0x006a
        L_0x0078:
            int r11 = android.os.Build.VERSION.SDK_INT
            r12 = 31
            r14 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r11 < r12) goto L_0x008d
            int r11 = androidx.core.R.styleable.f5190g
            boolean r12 = r9.hasValue(r11)
            if (r12 == 0) goto L_0x008d
        L_0x0088:
            float r11 = r9.getFloat(r11, r14)
            goto L_0x0090
        L_0x008d:
            int r11 = androidx.core.R.styleable.f5192i
            goto L_0x0088
        L_0x0090:
            r9.recycle()
            int r9 = r19.getAttributeCount()
            int[] r12 = new int[r9]
            r14 = 0
            r15 = 0
        L_0x009b:
            if (r14 >= r9) goto L_0x00c7
            int r4 = r1.getAttributeNameResource(r14)
            r7 = 16843173(0x10101a5, float:2.3694738E-38)
            if (r4 == r7) goto L_0x00c1
            r7 = 16843551(0x101031f, float:2.3695797E-38)
            if (r4 == r7) goto L_0x00c1
            int r7 = androidx.core.R.attr.f5097a
            if (r4 == r7) goto L_0x00c1
            int r7 = androidx.core.R.attr.f5109m
            if (r4 == r7) goto L_0x00c1
            int r7 = r15 + 1
            r0 = 0
            boolean r16 = r1.getAttributeBooleanValue(r14, r0)
            if (r16 == 0) goto L_0x00bd
            goto L_0x00be
        L_0x00bd:
            int r4 = -r4
        L_0x00be:
            r12[r15] = r4
            r15 = r7
        L_0x00c1:
            int r14 = r14 + 1
            r4 = 1
            r0 = r17
            goto L_0x009b
        L_0x00c7:
            int[] r0 = android.util.StateSet.trimStateSet(r12, r15)
            int r4 = g(r10, r13, r11)
            int[] r5 = androidx.core.content.res.GrowingArrayUtils.a(r5, r8, r4)
            java.lang.Object[] r0 = androidx.core.content.res.GrowingArrayUtils.c(r6, r8, r0)
            r6 = r0
            int[][] r6 = (int[][]) r6
            int r8 = r8 + 1
        L_0x00dc:
            r4 = 1
            r0 = r17
            goto L_0x0013
        L_0x00e1:
            int[] r0 = new int[r8]
            int[][] r1 = new int[r8][]
            r2 = 0
            java.lang.System.arraycopy(r5, r2, r0, r2, r8)
            java.lang.System.arraycopy(r6, r2, r1, r2, r8)
            android.content.res.ColorStateList r2 = new android.content.res.ColorStateList
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ColorStateListInflaterCompat.e(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    private static boolean f(@NonNull Resources resources, @ColorRes int i2) {
        TypedValue c2 = c();
        resources.getValue(i2, c2, true);
        int i3 = c2.type;
        return i3 >= 28 && i3 <= 31;
    }

    @ColorInt
    private static int g(@ColorInt int i2, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 100.0d) float f3) {
        boolean z = f3 >= 0.0f && f3 <= 100.0f;
        if (f2 == 1.0f && !z) {
            return i2;
        }
        int e2 = MathUtils.e((int) ((((float) Color.alpha(i2)) * f2) + 0.5f), 0, 255);
        if (z) {
            CamColor c2 = CamColor.c(i2);
            i2 = CamColor.q(c2.j(), c2.i(), f3);
        }
        return (i2 & ViewCompat.x) | (e2 << 24);
    }

    private static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
