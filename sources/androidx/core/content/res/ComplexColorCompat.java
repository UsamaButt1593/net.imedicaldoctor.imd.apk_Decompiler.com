package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Shader;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ComplexColorCompat {

    /* renamed from: d  reason: collision with root package name */
    private static final String f5759d = "ComplexColorCompat";

    /* renamed from: a  reason: collision with root package name */
    private final Shader f5760a;

    /* renamed from: b  reason: collision with root package name */
    private final ColorStateList f5761b;

    /* renamed from: c  reason: collision with root package name */
    private int f5762c;

    private ComplexColorCompat(Shader shader, ColorStateList colorStateList, @ColorInt int i2) {
        this.f5760a = shader;
        this.f5761b = colorStateList;
        this.f5762c = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.core.content.res.ComplexColorCompat a(@androidx.annotation.NonNull android.content.res.Resources r4, @androidx.annotation.ColorRes int r5, @androidx.annotation.Nullable android.content.res.Resources.Theme r6) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            android.content.res.XmlResourceParser r5 = r4.getXml(r5)
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)
        L_0x0008:
            int r1 = r5.next()
            r2 = 2
            if (r1 == r2) goto L_0x0013
            r3 = 1
            if (r1 == r3) goto L_0x0013
            goto L_0x0008
        L_0x0013:
            if (r1 != r2) goto L_0x005c
            java.lang.String r1 = r5.getName()
            r1.hashCode()
            java.lang.String r2 = "gradient"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x0053
            java.lang.String r2 = "selector"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0035
            android.content.res.ColorStateList r4 = androidx.core.content.res.ColorStateListInflaterCompat.b(r4, r5, r0, r6)
            androidx.core.content.res.ComplexColorCompat r4 = c(r4)
            return r4
        L_0x0035:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r5 = r5.getPositionDescription()
            r6.append(r5)
            java.lang.String r5 = ": unsupported complex color tag "
            r6.append(r5)
            r6.append(r1)
            java.lang.String r5 = r6.toString()
            r4.<init>(r5)
            throw r4
        L_0x0053:
            android.graphics.Shader r4 = androidx.core.content.res.GradientColorInflaterCompat.c(r4, r5, r0, r6)
            androidx.core.content.res.ComplexColorCompat r4 = d(r4)
            return r4
        L_0x005c:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ComplexColorCompat.a(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.core.content.res.ComplexColorCompat");
    }

    static ComplexColorCompat b(@ColorInt int i2) {
        return new ComplexColorCompat((Shader) null, (ColorStateList) null, i2);
    }

    static ComplexColorCompat c(@NonNull ColorStateList colorStateList) {
        return new ComplexColorCompat((Shader) null, colorStateList, colorStateList.getDefaultColor());
    }

    static ComplexColorCompat d(@NonNull Shader shader) {
        return new ComplexColorCompat(shader, (ColorStateList) null, 0);
    }

    @Nullable
    public static ComplexColorCompat g(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) {
        try {
            return a(resources, i2, theme);
        } catch (Exception e2) {
            Log.e(f5759d, "Failed to inflate ComplexColor.", e2);
            return null;
        }
    }

    @ColorInt
    public int e() {
        return this.f5762c;
    }

    @Nullable
    public Shader f() {
        return this.f5760a;
    }

    public boolean h() {
        return this.f5760a != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f5761b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean i() {
        /*
            r1 = this;
            android.graphics.Shader r0 = r1.f5760a
            if (r0 != 0) goto L_0x0010
            android.content.res.ColorStateList r0 = r1.f5761b
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ComplexColorCompat.i():boolean");
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f5761b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f5762c) {
                this.f5762c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(@ColorInt int i2) {
        this.f5762c = i2;
    }

    public boolean l() {
        return h() || this.f5762c != 0;
    }
}
