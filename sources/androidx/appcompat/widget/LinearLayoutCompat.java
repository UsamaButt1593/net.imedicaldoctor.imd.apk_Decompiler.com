package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.LinearLayout;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.itextpdf.text.html.HtmlTags;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;

public class LinearLayoutCompat extends ViewGroup {
    public static final int l3 = 0;
    public static final int m3 = 1;
    public static final int n3 = 0;
    public static final int o3 = 1;
    public static final int p3 = 2;
    public static final int q3 = 4;
    private static final int r3 = 4;
    private static final int s3 = 0;
    private static final int t3 = 1;
    private static final int u3 = 2;
    private static final int v3 = 3;
    private static final String w3 = "androidx.appcompat.widget.LinearLayoutCompat";
    private int X2;
    private int Y2;
    private int Z2;
    private int a3;
    private int b3;
    private float c3;
    private boolean d3;
    private int[] e3;
    private int[] f3;
    private Drawable g3;
    private int h3;
    private int i3;
    private int j3;
    private int k3;
    private boolean s;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<LinearLayoutCompat> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f3203a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f3204b;

        /* renamed from: c  reason: collision with root package name */
        private int f3205c;

        /* renamed from: d  reason: collision with root package name */
        private int f3206d;

        /* renamed from: e  reason: collision with root package name */
        private int f3207e;

        /* renamed from: f  reason: collision with root package name */
        private int f3208f;

        /* renamed from: g  reason: collision with root package name */
        private int f3209g;

        /* renamed from: h  reason: collision with root package name */
        private int f3210h;

        /* renamed from: i  reason: collision with root package name */
        private int f3211i;

        /* renamed from: j  reason: collision with root package name */
        private int f3212j;

        /* renamed from: a */
        public void readProperties(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull PropertyReader propertyReader) {
            if (this.f3203a) {
                propertyReader.readBoolean(this.f3204b, linearLayoutCompat.w());
                propertyReader.readInt(this.f3205c, linearLayoutCompat.getBaselineAlignedChildIndex());
                propertyReader.readGravity(this.f3206d, linearLayoutCompat.getGravity());
                propertyReader.readIntEnum(this.f3207e, linearLayoutCompat.getOrientation());
                propertyReader.readFloat(this.f3208f, linearLayoutCompat.getWeightSum());
                propertyReader.readObject(this.f3209g, linearLayoutCompat.getDividerDrawable());
                propertyReader.readInt(this.f3210h, linearLayoutCompat.getDividerPadding());
                propertyReader.readBoolean(this.f3211i, linearLayoutCompat.x());
                propertyReader.readIntFlag(this.f3212j, linearLayoutCompat.getShowDividers());
                return;
            }
            throw C0004e.a();
        }

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            this.f3204b = propertyMapper.mapBoolean("baselineAligned", 16843046);
            this.f3205c = propertyMapper.mapInt("baselineAlignedChildIndex", 16843047);
            this.f3206d = propertyMapper.mapGravity("gravity", 16842927);
            this.f3207e = propertyMapper.mapIntEnum("orientation", 16842948, new IntFunction<String>() {
                /* renamed from: a */
                public String apply(int i2) {
                    if (i2 != 0) {
                        return i2 != 1 ? String.valueOf(i2) : "vertical";
                    }
                    return "horizontal";
                }
            });
            this.f3208f = propertyMapper.mapFloat("weightSum", 16843048);
            this.f3209g = propertyMapper.mapObject("divider", R.attr.b1);
            this.f3210h = propertyMapper.mapInt("dividerPadding", R.attr.d1);
            this.f3211i = propertyMapper.mapBoolean("measureWithLargestChild", R.attr.k2);
            this.f3212j = propertyMapper.mapIntFlag("showDividers", R.attr.S2, new IntFunction<Set<String>>() {
                /* renamed from: a */
                public Set<String> apply(int i2) {
                    HashSet hashSet = new HashSet();
                    if (i2 == 0) {
                        hashSet.add("none");
                    }
                    if (i2 == 1) {
                        hashSet.add("beginning");
                    }
                    if (i2 == 2) {
                        hashSet.add(HtmlTags.g0);
                    }
                    if (i2 == 4) {
                        hashSet.add(TtmlNode.p0);
                    }
                    return hashSet;
                }
            });
            this.f3203a = true;
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(int i2, int i3, float f2) {
            super(i2, i3, f2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void E(View view, int i2, int i4, int i5, int i6) {
        view.layout(i2, i4, i5 + i2, i6 + i4);
    }

    private void m(int i2, int i4) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i5 = 0; i5 < i2; i5++) {
            View u = u(i5);
            if (u.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) u.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i6 = layoutParams.width;
                    layoutParams.width = u.getMeasuredWidth();
                    measureChildWithMargins(u, i4, 0, makeMeasureSpec, 0);
                    layoutParams.width = i6;
                }
            }
        }
    }

    private void n(int i2, int i4) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i5 = 0; i5 < i2; i5++) {
            View u = u(i5);
            if (u.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) u.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i6 = layoutParams.height;
                    layoutParams.height = u.getMeasuredHeight();
                    measureChildWithMargins(u, makeMeasureSpec, 0, i4, 0);
                    layoutParams.height = i6;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void A(View view, int i2, int i4, int i5, int i6, int i7) {
        measureChildWithMargins(view, i4, i5, i6, i7);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03aa, code lost:
        if (r8 > 0) goto L_0x03ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03be, code lost:
        if (r8 >= 0) goto L_0x03ae;
     */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0446  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void B(int r39, int r40) {
        /*
            r38 = this;
            r7 = r38
            r8 = r39
            r9 = r40
            r10 = 0
            r7.b3 = r10
            int r11 = r38.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r39)
            int r13 = android.view.View.MeasureSpec.getMode(r40)
            int[] r0 = r7.e3
            r14 = 4
            if (r0 == 0) goto L_0x001e
            int[] r0 = r7.f3
            if (r0 != 0) goto L_0x0026
        L_0x001e:
            int[] r0 = new int[r14]
            r7.e3 = r0
            int[] r0 = new int[r14]
            r7.f3 = r0
        L_0x0026:
            int[] r15 = r7.e3
            int[] r6 = r7.f3
            r16 = 3
            r5 = -1
            r15[r16] = r5
            r17 = 2
            r15[r17] = r5
            r18 = 1
            r15[r18] = r5
            r15[r10] = r5
            r6[r16] = r5
            r6[r17] = r5
            r6[r18] = r5
            r6[r10] = r5
            boolean r4 = r7.s
            boolean r3 = r7.d3
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 != r2) goto L_0x004c
            r19 = 1
            goto L_0x004e
        L_0x004c:
            r19 = 0
        L_0x004e:
            r20 = 0
            r0 = 0
            r1 = 0
            r14 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 1
            r27 = 0
        L_0x0061:
            r28 = r6
            r5 = 8
            if (r1 >= r11) goto L_0x01fa
            android.view.View r6 = r7.u(r1)
            if (r6 != 0) goto L_0x007f
            int r5 = r7.b3
            int r6 = r7.C(r1)
            int r5 = r5 + r6
            r7.b3 = r5
        L_0x0076:
            r2 = r1
            r33 = r3
            r37 = r4
            r1 = 1073741824(0x40000000, float:2.0)
            goto L_0x01e9
        L_0x007f:
            int r10 = r6.getVisibility()
            if (r10 != r5) goto L_0x008b
            int r5 = r7.r(r6, r1)
            int r1 = r1 + r5
            goto L_0x0076
        L_0x008b:
            boolean r5 = r7.v(r1)
            if (r5 == 0) goto L_0x0098
            int r5 = r7.b3
            int r10 = r7.h3
            int r5 = r5 + r10
            r7.b3 = r5
        L_0x0098:
            android.view.ViewGroup$LayoutParams r5 = r6.getLayoutParams()
            r10 = r5
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r10 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r10
            float r5 = r10.weight
            float r32 = r0 + r5
            if (r12 != r2) goto L_0x00e9
            int r0 = r10.width
            if (r0 != 0) goto L_0x00e9
            int r0 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00e9
            int r0 = r7.b3
            if (r19 == 0) goto L_0x00ba
            int r5 = r10.leftMargin
            int r2 = r10.rightMargin
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x00b7:
            r7.b3 = r0
            goto L_0x00c5
        L_0x00ba:
            int r2 = r10.leftMargin
            int r2 = r2 + r0
            int r5 = r10.rightMargin
            int r2 = r2 + r5
            int r0 = java.lang.Math.max(r0, r2)
            goto L_0x00b7
        L_0x00c5:
            if (r4 == 0) goto L_0x00da
            r0 = 0
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)
            r6.measure(r2, r2)
            r35 = r1
            r33 = r3
            r37 = r4
            r3 = r6
            r29 = -2
            goto L_0x0160
        L_0x00da:
            r35 = r1
            r33 = r3
            r37 = r4
            r3 = r6
            r1 = 1073741824(0x40000000, float:2.0)
            r24 = 1
            r29 = -2
            goto L_0x0162
        L_0x00e9:
            int r0 = r10.width
            if (r0 != 0) goto L_0x00f6
            int r0 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f6
            r5 = -2
            r10.width = r5
            r2 = 0
            goto L_0x00f9
        L_0x00f6:
            r5 = -2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00f9:
            int r0 = (r32 > r20 ? 1 : (r32 == r20 ? 0 : -1))
            if (r0 != 0) goto L_0x0102
            int r0 = r7.b3
            r29 = r0
            goto L_0x0104
        L_0x0102:
            r29 = 0
        L_0x0104:
            r34 = 0
            r0 = r38
            r35 = r1
            r1 = r6
            r36 = r2
            r2 = r35
            r33 = r3
            r3 = r39
            r37 = r4
            r4 = r29
            r9 = -1
            r29 = -2
            r5 = r40
            r31 = r6
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r34
            r0.A(r1, r2, r3, r4, r5, r6)
            r0 = r36
            if (r0 == r9) goto L_0x012b
            r10.width = r0
        L_0x012b:
            int r0 = r31.getMeasuredWidth()
            if (r19 == 0) goto L_0x0144
            int r1 = r7.b3
            int r2 = r10.leftMargin
            int r2 = r2 + r0
            int r3 = r10.rightMargin
            int r2 = r2 + r3
            r3 = r31
            int r4 = r7.t(r3)
            int r2 = r2 + r4
            int r1 = r1 + r2
        L_0x0141:
            r7.b3 = r1
            goto L_0x015a
        L_0x0144:
            r3 = r31
            int r1 = r7.b3
            int r2 = r1 + r0
            int r4 = r10.leftMargin
            int r2 = r2 + r4
            int r4 = r10.rightMargin
            int r2 = r2 + r4
            int r4 = r7.t(r3)
            int r2 = r2 + r4
            int r1 = java.lang.Math.max(r1, r2)
            goto L_0x0141
        L_0x015a:
            if (r33 == 0) goto L_0x0160
            int r14 = java.lang.Math.max(r0, r14)
        L_0x0160:
            r1 = 1073741824(0x40000000, float:2.0)
        L_0x0162:
            if (r13 == r1) goto L_0x016d
            int r0 = r10.height
            r2 = -1
            if (r0 != r2) goto L_0x016d
            r0 = 1
            r27 = 1
            goto L_0x016e
        L_0x016d:
            r0 = 0
        L_0x016e:
            int r2 = r10.topMargin
            int r4 = r10.bottomMargin
            int r2 = r2 + r4
            int r4 = r3.getMeasuredHeight()
            int r4 = r4 + r2
            int r5 = r3.getMeasuredState()
            r6 = r25
            int r25 = android.view.View.combineMeasuredStates(r6, r5)
            if (r37 == 0) goto L_0x01ab
            int r5 = r3.getBaseline()
            r6 = -1
            if (r5 == r6) goto L_0x01ab
            int r6 = r10.gravity
            if (r6 >= 0) goto L_0x0191
            int r6 = r7.a3
        L_0x0191:
            r6 = r6 & 112(0x70, float:1.57E-43)
            r9 = 4
            int r6 = r6 >> r9
            r6 = r6 & -2
            int r6 = r6 >> 1
            r9 = r15[r6]
            int r9 = java.lang.Math.max(r9, r5)
            r15[r6] = r9
            r9 = r28[r6]
            int r5 = r4 - r5
            int r5 = java.lang.Math.max(r9, r5)
            r28[r6] = r5
        L_0x01ab:
            r5 = r21
            int r21 = java.lang.Math.max(r5, r4)
            if (r26 == 0) goto L_0x01bb
            int r5 = r10.height
            r6 = -1
            if (r5 != r6) goto L_0x01bb
            r26 = 1
            goto L_0x01bd
        L_0x01bb:
            r26 = 0
        L_0x01bd:
            float r5 = r10.weight
            int r5 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r5 <= 0) goto L_0x01d1
            if (r0 == 0) goto L_0x01c8
        L_0x01c5:
            r10 = r23
            goto L_0x01ca
        L_0x01c8:
            r2 = r4
            goto L_0x01c5
        L_0x01ca:
            int r23 = java.lang.Math.max(r10, r2)
        L_0x01ce:
            r10 = r35
            goto L_0x01e1
        L_0x01d1:
            r10 = r23
            if (r0 == 0) goto L_0x01d8
        L_0x01d5:
            r4 = r22
            goto L_0x01da
        L_0x01d8:
            r2 = r4
            goto L_0x01d5
        L_0x01da:
            int r22 = java.lang.Math.max(r4, r2)
            r23 = r10
            goto L_0x01ce
        L_0x01e1:
            int r0 = r7.r(r3, r10)
            int r0 = r0 + r10
            r2 = r0
            r0 = r32
        L_0x01e9:
            int r2 = r2 + 1
            r9 = r40
            r1 = r2
            r6 = r28
            r3 = r33
            r4 = r37
            r2 = 1073741824(0x40000000, float:2.0)
            r5 = -1
            r10 = 0
            goto L_0x0061
        L_0x01fa:
            r33 = r3
            r37 = r4
            r2 = r21
            r4 = r22
            r10 = r23
            r6 = r25
            r1 = 1073741824(0x40000000, float:2.0)
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r29 = -2
            int r3 = r7.b3
            if (r3 <= 0) goto L_0x021d
            boolean r3 = r7.v(r11)
            if (r3 == 0) goto L_0x021d
            int r3 = r7.b3
            int r1 = r7.h3
            int r3 = r3 + r1
            r7.b3 = r3
        L_0x021d:
            r1 = r15[r18]
            r3 = -1
            if (r1 != r3) goto L_0x0235
            r21 = 0
            r5 = r15[r21]
            if (r5 != r3) goto L_0x0235
            r5 = r15[r17]
            if (r5 != r3) goto L_0x0235
            r5 = r15[r16]
            if (r5 == r3) goto L_0x0231
            goto L_0x0235
        L_0x0231:
            r1 = r2
            r21 = r6
            goto L_0x0264
        L_0x0235:
            r3 = r15[r16]
            r5 = 0
            r9 = r15[r5]
            r5 = r15[r17]
            int r1 = java.lang.Math.max(r1, r5)
            int r1 = java.lang.Math.max(r9, r1)
            int r1 = java.lang.Math.max(r3, r1)
            r3 = r28[r16]
            r5 = 0
            r9 = r28[r5]
            r5 = r28[r18]
            r21 = r6
            r6 = r28[r17]
            int r5 = java.lang.Math.max(r5, r6)
            int r5 = java.lang.Math.max(r9, r5)
            int r3 = java.lang.Math.max(r3, r5)
            int r1 = r1 + r3
            int r1 = java.lang.Math.max(r2, r1)
        L_0x0264:
            if (r33 == 0) goto L_0x026e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r12 == r2) goto L_0x026c
            if (r12 != 0) goto L_0x026e
        L_0x026c:
            r2 = 0
            goto L_0x0271
        L_0x026e:
            r23 = r1
            goto L_0x02c9
        L_0x0271:
            r7.b3 = r2
            r2 = 0
        L_0x0274:
            if (r2 >= r11) goto L_0x026e
            android.view.View r3 = r7.u(r2)
            if (r3 != 0) goto L_0x0286
            int r3 = r7.b3
            int r5 = r7.C(r2)
            int r3 = r3 + r5
            r7.b3 = r3
            goto L_0x0293
        L_0x0286:
            int r5 = r3.getVisibility()
            r6 = 8
            if (r5 != r6) goto L_0x0296
            int r3 = r7.r(r3, r2)
            int r2 = r2 + r3
        L_0x0293:
            r23 = r1
            goto L_0x02c4
        L_0x0296:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            int r6 = r7.b3
            if (r19 == 0) goto L_0x02af
            int r9 = r5.leftMargin
            int r9 = r9 + r14
            int r5 = r5.rightMargin
            int r9 = r9 + r5
            int r3 = r7.t(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            r7.b3 = r6
            goto L_0x0293
        L_0x02af:
            int r9 = r6 + r14
            r23 = r1
            int r1 = r5.leftMargin
            int r9 = r9 + r1
            int r1 = r5.rightMargin
            int r9 = r9 + r1
            int r1 = r7.t(r3)
            int r9 = r9 + r1
            int r1 = java.lang.Math.max(r6, r9)
            r7.b3 = r1
        L_0x02c4:
            int r2 = r2 + 1
            r1 = r23
            goto L_0x0274
        L_0x02c9:
            int r1 = r7.b3
            int r2 = r38.getPaddingLeft()
            int r3 = r38.getPaddingRight()
            int r2 = r2 + r3
            int r1 = r1 + r2
            r7.b3 = r1
            int r2 = r38.getSuggestedMinimumWidth()
            int r1 = java.lang.Math.max(r1, r2)
            r2 = 0
            int r1 = android.view.View.resolveSizeAndState(r1, r8, r2)
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r1
            int r3 = r7.b3
            int r2 = r2 - r3
            if (r24 != 0) goto L_0x0338
            if (r2 == 0) goto L_0x02f4
            int r5 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r5 <= 0) goto L_0x02f4
            goto L_0x0338
        L_0x02f4:
            int r0 = java.lang.Math.max(r4, r10)
            if (r33 == 0) goto L_0x0330
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 == r2) goto L_0x0330
            r10 = 0
        L_0x02ff:
            if (r10 >= r11) goto L_0x0330
            android.view.View r2 = r7.u(r10)
            if (r2 == 0) goto L_0x032d
            int r4 = r2.getVisibility()
            r5 = 8
            if (r4 != r5) goto L_0x0310
            goto L_0x032d
        L_0x0310:
            android.view.ViewGroup$LayoutParams r4 = r2.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r4 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r4
            float r4 = r4.weight
            int r4 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r4 <= 0) goto L_0x032d
            r4 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r4)
            int r6 = r2.getMeasuredHeight()
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r4)
            r2.measure(r5, r6)
        L_0x032d:
            int r10 = r10 + 1
            goto L_0x02ff
        L_0x0330:
            r2 = r40
            r25 = r11
            r9 = r21
            goto L_0x04c6
        L_0x0338:
            float r5 = r7.c3
            int r6 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r6 <= 0) goto L_0x033f
            r0 = r5
        L_0x033f:
            r5 = -1
            r15[r16] = r5
            r15[r17] = r5
            r15[r18] = r5
            r6 = 0
            r15[r6] = r5
            r28[r16] = r5
            r28[r17] = r5
            r28[r18] = r5
            r28[r6] = r5
            r7.b3 = r6
            r6 = r4
            r9 = r21
            r4 = -1
            r10 = 0
        L_0x0358:
            if (r10 >= r11) goto L_0x0470
            android.view.View r14 = r7.u(r10)
            if (r14 == 0) goto L_0x0368
            int r5 = r14.getVisibility()
            r3 = 8
            if (r5 != r3) goto L_0x036f
        L_0x0368:
            r3 = r2
            r25 = r11
            r2 = r40
            goto L_0x0466
        L_0x036f:
            android.view.ViewGroup$LayoutParams r5 = r14.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            float r3 = r5.weight
            int r23 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r23 <= 0) goto L_0x03d1
            float r8 = (float) r2
            float r8 = r8 * r3
            float r8 = r8 / r0
            int r8 = (int) r8
            float r0 = r0 - r3
            int r2 = r2 - r8
            int r3 = r38.getPaddingTop()
            int r23 = r38.getPaddingBottom()
            int r3 = r3 + r23
            r23 = r0
            int r0 = r5.topMargin
            int r3 = r3 + r0
            int r0 = r5.bottomMargin
            int r3 = r3 + r0
            int r0 = r5.height
            r24 = r2
            r25 = r11
            r11 = -1
            r2 = r40
            int r0 = android.view.ViewGroup.getChildMeasureSpec(r2, r3, r0)
            int r3 = r5.width
            if (r3 != 0) goto L_0x03b6
            r3 = 1073741824(0x40000000, float:2.0)
            if (r12 == r3) goto L_0x03aa
            goto L_0x03b8
        L_0x03aa:
            if (r8 <= 0) goto L_0x03ad
            goto L_0x03ae
        L_0x03ad:
            r8 = 0
        L_0x03ae:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r3)
            r14.measure(r8, r0)
            goto L_0x03c1
        L_0x03b6:
            r3 = 1073741824(0x40000000, float:2.0)
        L_0x03b8:
            int r30 = r14.getMeasuredWidth()
            int r8 = r30 + r8
            if (r8 >= 0) goto L_0x03ae
            goto L_0x03ad
        L_0x03c1:
            int r0 = r14.getMeasuredState()
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r3
            int r9 = android.view.View.combineMeasuredStates(r9, r0)
            r0 = r23
            r3 = r24
            goto L_0x03d7
        L_0x03d1:
            r3 = r2
            r25 = r11
            r11 = -1
            r2 = r40
        L_0x03d7:
            int r8 = r7.b3
            if (r19 == 0) goto L_0x03f6
            int r23 = r14.getMeasuredWidth()
            int r11 = r5.leftMargin
            int r23 = r23 + r11
            int r11 = r5.rightMargin
            int r23 = r23 + r11
            int r11 = r7.t(r14)
            int r23 = r23 + r11
            int r8 = r8 + r23
            r7.b3 = r8
            r23 = r0
        L_0x03f3:
            r0 = 1073741824(0x40000000, float:2.0)
            goto L_0x040f
        L_0x03f6:
            int r11 = r14.getMeasuredWidth()
            int r11 = r11 + r8
            r23 = r0
            int r0 = r5.leftMargin
            int r11 = r11 + r0
            int r0 = r5.rightMargin
            int r11 = r11 + r0
            int r0 = r7.t(r14)
            int r11 = r11 + r0
            int r0 = java.lang.Math.max(r8, r11)
            r7.b3 = r0
            goto L_0x03f3
        L_0x040f:
            if (r13 == r0) goto L_0x0418
            int r0 = r5.height
            r8 = -1
            if (r0 != r8) goto L_0x0418
            r0 = 1
            goto L_0x0419
        L_0x0418:
            r0 = 0
        L_0x0419:
            int r8 = r5.topMargin
            int r11 = r5.bottomMargin
            int r8 = r8 + r11
            int r11 = r14.getMeasuredHeight()
            int r11 = r11 + r8
            int r4 = java.lang.Math.max(r4, r11)
            if (r0 == 0) goto L_0x042a
            goto L_0x042b
        L_0x042a:
            r8 = r11
        L_0x042b:
            int r0 = java.lang.Math.max(r6, r8)
            if (r26 == 0) goto L_0x0438
            int r6 = r5.height
            r8 = -1
            if (r6 != r8) goto L_0x0439
            r6 = 1
            goto L_0x043a
        L_0x0438:
            r8 = -1
        L_0x0439:
            r6 = 0
        L_0x043a:
            if (r37 == 0) goto L_0x0461
            int r14 = r14.getBaseline()
            if (r14 == r8) goto L_0x0461
            int r5 = r5.gravity
            if (r5 >= 0) goto L_0x0448
            int r5 = r7.a3
        L_0x0448:
            r5 = r5 & 112(0x70, float:1.57E-43)
            r8 = 4
            int r5 = r5 >> r8
            r5 = r5 & -2
            int r5 = r5 >> 1
            r8 = r15[r5]
            int r8 = java.lang.Math.max(r8, r14)
            r15[r5] = r8
            r8 = r28[r5]
            int r11 = r11 - r14
            int r8 = java.lang.Math.max(r8, r11)
            r28[r5] = r8
        L_0x0461:
            r26 = r6
            r6 = r0
            r0 = r23
        L_0x0466:
            int r10 = r10 + 1
            r8 = r39
            r2 = r3
            r11 = r25
            r5 = -1
            goto L_0x0358
        L_0x0470:
            r2 = r40
            r25 = r11
            int r0 = r7.b3
            int r3 = r38.getPaddingLeft()
            int r5 = r38.getPaddingRight()
            int r3 = r3 + r5
            int r0 = r0 + r3
            r7.b3 = r0
            r0 = r15[r18]
            r3 = -1
            if (r0 != r3) goto L_0x0497
            r5 = 0
            r8 = r15[r5]
            if (r8 != r3) goto L_0x0497
            r5 = r15[r17]
            if (r5 != r3) goto L_0x0497
            r5 = r15[r16]
            if (r5 == r3) goto L_0x0495
            goto L_0x0497
        L_0x0495:
            r0 = r4
            goto L_0x04c3
        L_0x0497:
            r3 = r15[r16]
            r5 = 0
            r8 = r15[r5]
            r10 = r15[r17]
            int r0 = java.lang.Math.max(r0, r10)
            int r0 = java.lang.Math.max(r8, r0)
            int r0 = java.lang.Math.max(r3, r0)
            r3 = r28[r16]
            r5 = r28[r5]
            r8 = r28[r18]
            r10 = r28[r17]
            int r8 = java.lang.Math.max(r8, r10)
            int r5 = java.lang.Math.max(r5, r8)
            int r3 = java.lang.Math.max(r3, r5)
            int r0 = r0 + r3
            int r0 = java.lang.Math.max(r4, r0)
        L_0x04c3:
            r23 = r0
            r0 = r6
        L_0x04c6:
            if (r26 != 0) goto L_0x04cd
            r3 = 1073741824(0x40000000, float:2.0)
            if (r13 == r3) goto L_0x04cd
            goto L_0x04cf
        L_0x04cd:
            r0 = r23
        L_0x04cf:
            int r3 = r38.getPaddingTop()
            int r4 = r38.getPaddingBottom()
            int r3 = r3 + r4
            int r0 = r0 + r3
            int r3 = r38.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r0, r3)
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3 = r3 & r9
            r1 = r1 | r3
            int r3 = r9 << 16
            int r0 = android.view.View.resolveSizeAndState(r0, r2, r3)
            r7.setMeasuredDimension(r1, r0)
            if (r27 == 0) goto L_0x04f7
            r0 = r39
            r1 = r25
            r7.m(r1, r0)
        L_0x04f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.B(int, int):void");
    }

    /* access modifiers changed from: package-private */
    public int C(int i2) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02d0, code lost:
        if (r15 > 0) goto L_0x02d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02e4, code lost:
        if (r15 >= 0) goto L_0x02d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0312, code lost:
        if (r14.width == -1) goto L_0x0319;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D(int r34, int r35) {
        /*
            r33 = this;
            r7 = r33
            r8 = r34
            r9 = r35
            r10 = 0
            r7.b3 = r10
            int r11 = r33.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r34)
            int r13 = android.view.View.MeasureSpec.getMode(r35)
            int r14 = r7.X2
            boolean r15 = r7.d3
            r16 = 1
            r17 = 0
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r18 = 0
            r19 = 1
            r20 = 0
        L_0x002a:
            r10 = 8
            r22 = r4
            if (r6 >= r11) goto L_0x0199
            android.view.View r4 = r7.u(r6)
            if (r4 != 0) goto L_0x0047
            int r4 = r7.b3
            int r10 = r7.C(r6)
            int r4 = r4 + r10
            r7.b3 = r4
            r24 = r13
            r4 = r22
            r22 = r11
            goto L_0x018d
        L_0x0047:
            r24 = r1
            int r1 = r4.getVisibility()
            if (r1 != r10) goto L_0x005e
            int r1 = r7.r(r4, r6)
            int r6 = r6 + r1
            r4 = r22
            r1 = r24
            r22 = r11
            r24 = r13
            goto L_0x018d
        L_0x005e:
            boolean r1 = r7.v(r6)
            if (r1 == 0) goto L_0x006b
            int r1 = r7.b3
            int r10 = r7.i3
            int r1 = r1 + r10
            r7.b3 = r1
        L_0x006b:
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            r10 = r1
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r10 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r10
            float r1 = r10.weight
            float r25 = r0 + r1
            r0 = 1073741824(0x40000000, float:2.0)
            if (r13 != r0) goto L_0x00a5
            int r0 = r10.height
            if (r0 != 0) goto L_0x00a5
            int r0 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a5
            int r0 = r7.b3
            int r1 = r10.topMargin
            int r1 = r1 + r0
            r26 = r2
            int r2 = r10.bottomMargin
            int r1 = r1 + r2
            int r0 = java.lang.Math.max(r0, r1)
            r7.b3 = r0
            r0 = r3
            r3 = r4
            r31 = r5
            r8 = r24
            r29 = r26
            r18 = 1
            r24 = r13
            r13 = r22
            r22 = r11
            r11 = r6
            goto L_0x0113
        L_0x00a5:
            r26 = r2
            int r0 = r10.height
            if (r0 != 0) goto L_0x00b4
            int r0 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x00b4
            r0 = -2
            r10.height = r0
            r2 = 0
            goto L_0x00b6
        L_0x00b4:
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00b6:
            int r0 = (r25 > r17 ? 1 : (r25 == r17 ? 0 : -1))
            if (r0 != 0) goto L_0x00bf
            int r0 = r7.b3
            r27 = r0
            goto L_0x00c1
        L_0x00bf:
            r27 = 0
        L_0x00c1:
            r28 = 0
            r23 = 1073741824(0x40000000, float:2.0)
            r0 = r33
            r8 = r24
            r1 = r4
            r30 = r2
            r29 = r26
            r2 = r6
            r9 = r3
            r3 = r34
            r23 = r4
            r24 = r13
            r13 = r22
            r22 = r11
            r11 = 1073741824(0x40000000, float:2.0)
            r4 = r28
            r31 = r5
            r5 = r35
            r11 = r6
            r6 = r27
            r0.A(r1, r2, r3, r4, r5, r6)
            r1 = r30
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r0) goto L_0x00f0
            r10.height = r1
        L_0x00f0:
            int r0 = r23.getMeasuredHeight()
            int r1 = r7.b3
            int r2 = r1 + r0
            int r3 = r10.topMargin
            int r2 = r2 + r3
            int r3 = r10.bottomMargin
            int r2 = r2 + r3
            r3 = r23
            int r4 = r7.t(r3)
            int r2 = r2 + r4
            int r1 = java.lang.Math.max(r1, r2)
            r7.b3 = r1
            if (r15 == 0) goto L_0x0112
            int r0 = java.lang.Math.max(r0, r9)
            goto L_0x0113
        L_0x0112:
            r0 = r9
        L_0x0113:
            if (r14 < 0) goto L_0x011d
            int r6 = r11 + 1
            if (r14 != r6) goto L_0x011d
            int r1 = r7.b3
            r7.Y2 = r1
        L_0x011d:
            if (r11 >= r14) goto L_0x0125
            float r1 = r10.weight
            int r1 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r1 > 0) goto L_0x0128
        L_0x0125:
            r1 = 1073741824(0x40000000, float:2.0)
            goto L_0x0130
        L_0x0128:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
            r0.<init>(r1)
            throw r0
        L_0x0130:
            if (r12 == r1) goto L_0x013b
            int r1 = r10.width
            r2 = -1
            if (r1 != r2) goto L_0x013b
            r1 = 1
            r20 = 1
            goto L_0x013c
        L_0x013b:
            r1 = 0
        L_0x013c:
            int r2 = r10.leftMargin
            int r4 = r10.rightMargin
            int r2 = r2 + r4
            int r4 = r3.getMeasuredWidth()
            int r4 = r4 + r2
            r5 = r29
            int r5 = java.lang.Math.max(r5, r4)
            int r6 = r3.getMeasuredState()
            int r6 = android.view.View.combineMeasuredStates(r8, r6)
            if (r19 == 0) goto L_0x015e
            int r8 = r10.width
            r9 = -1
            if (r8 != r9) goto L_0x015e
            r19 = 1
            goto L_0x0160
        L_0x015e:
            r19 = 0
        L_0x0160:
            float r8 = r10.weight
            int r8 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r8 <= 0) goto L_0x016f
            if (r1 == 0) goto L_0x0169
            goto L_0x016a
        L_0x0169:
            r2 = r4
        L_0x016a:
            int r4 = java.lang.Math.max(r13, r2)
            goto L_0x017d
        L_0x016f:
            if (r1 == 0) goto L_0x0174
        L_0x0171:
            r1 = r31
            goto L_0x0176
        L_0x0174:
            r2 = r4
            goto L_0x0171
        L_0x0176:
            int r1 = java.lang.Math.max(r1, r2)
            r31 = r1
            r4 = r13
        L_0x017d:
            int r1 = r7.r(r3, r11)
            int r1 = r1 + r11
            r3 = r0
            r2 = r5
            r0 = r25
            r5 = r31
            r32 = r6
            r6 = r1
            r1 = r32
        L_0x018d:
            int r6 = r6 + 1
            r8 = r34
            r9 = r35
            r11 = r22
            r13 = r24
            goto L_0x002a
        L_0x0199:
            r8 = r1
            r9 = r3
            r1 = r5
            r24 = r13
            r13 = r22
            r5 = r2
            r22 = r11
            int r2 = r7.b3
            if (r2 <= 0) goto L_0x01b7
            r2 = r22
            boolean r3 = r7.v(r2)
            if (r3 == 0) goto L_0x01b9
            int r3 = r7.b3
            int r4 = r7.i3
            int r3 = r3 + r4
            r7.b3 = r3
            goto L_0x01b9
        L_0x01b7:
            r2 = r22
        L_0x01b9:
            r3 = r24
            if (r15 == 0) goto L_0x0207
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == r4) goto L_0x01c3
            if (r3 != 0) goto L_0x0207
        L_0x01c3:
            r4 = 0
            r7.b3 = r4
            r4 = 0
        L_0x01c7:
            if (r4 >= r2) goto L_0x0207
            android.view.View r6 = r7.u(r4)
            if (r6 != 0) goto L_0x01d9
            int r6 = r7.b3
            int r11 = r7.C(r4)
            int r6 = r6 + r11
        L_0x01d6:
            r7.b3 = r6
            goto L_0x0202
        L_0x01d9:
            int r11 = r6.getVisibility()
            if (r11 != r10) goto L_0x01e5
            int r6 = r7.r(r6, r4)
            int r4 = r4 + r6
            goto L_0x0202
        L_0x01e5:
            android.view.ViewGroup$LayoutParams r11 = r6.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r11 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r11
            int r14 = r7.b3
            int r21 = r14 + r9
            int r10 = r11.topMargin
            int r21 = r21 + r10
            int r10 = r11.bottomMargin
            int r21 = r21 + r10
            int r6 = r7.t(r6)
            int r6 = r21 + r6
            int r6 = java.lang.Math.max(r14, r6)
            goto L_0x01d6
        L_0x0202:
            int r4 = r4 + 1
            r10 = 8
            goto L_0x01c7
        L_0x0207:
            int r4 = r7.b3
            int r6 = r33.getPaddingTop()
            int r10 = r33.getPaddingBottom()
            int r6 = r6 + r10
            int r4 = r4 + r6
            r7.b3 = r4
            int r6 = r33.getSuggestedMinimumHeight()
            int r4 = java.lang.Math.max(r4, r6)
            r6 = r35
            r10 = r9
            r9 = 0
            int r4 = android.view.View.resolveSizeAndState(r4, r6, r9)
            r9 = 16777215(0xffffff, float:2.3509886E-38)
            r9 = r9 & r4
            int r11 = r7.b3
            int r9 = r9 - r11
            if (r18 != 0) goto L_0x0276
            if (r9 == 0) goto L_0x0235
            int r11 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r11 <= 0) goto L_0x0235
            goto L_0x0276
        L_0x0235:
            int r0 = java.lang.Math.max(r1, r13)
            if (r15 == 0) goto L_0x0271
            r1 = 1073741824(0x40000000, float:2.0)
            if (r3 == r1) goto L_0x0271
            r1 = 0
        L_0x0240:
            if (r1 >= r2) goto L_0x0271
            android.view.View r3 = r7.u(r1)
            if (r3 == 0) goto L_0x026e
            int r9 = r3.getVisibility()
            r11 = 8
            if (r9 != r11) goto L_0x0251
            goto L_0x026e
        L_0x0251:
            android.view.ViewGroup$LayoutParams r9 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r9 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r9
            float r9 = r9.weight
            int r9 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r9 <= 0) goto L_0x026e
            int r9 = r3.getMeasuredWidth()
            r11 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r11)
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r11)
            r3.measure(r9, r13)
        L_0x026e:
            int r1 = r1 + 1
            goto L_0x0240
        L_0x0271:
            r11 = r34
            r1 = r8
            goto L_0x035d
        L_0x0276:
            float r10 = r7.c3
            int r11 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r11 <= 0) goto L_0x027d
            r0 = r10
        L_0x027d:
            r10 = 0
            r7.b3 = r10
            r11 = r9
            r9 = r1
            r1 = r8
            r8 = 0
        L_0x0284:
            if (r8 >= r2) goto L_0x034c
            android.view.View r13 = r7.u(r8)
            int r14 = r13.getVisibility()
            r15 = 8
            if (r14 != r15) goto L_0x0298
            r21 = r11
            r11 = r34
            goto L_0x0345
        L_0x0298:
            android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r14 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r14
            float r10 = r14.weight
            int r18 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r18 <= 0) goto L_0x02f4
            float r15 = (float) r11
            float r15 = r15 * r10
            float r15 = r15 / r0
            int r15 = (int) r15
            float r0 = r0 - r10
            int r11 = r11 - r15
            int r10 = r33.getPaddingLeft()
            int r18 = r33.getPaddingRight()
            int r10 = r10 + r18
            r18 = r0
            int r0 = r14.leftMargin
            int r10 = r10 + r0
            int r0 = r14.rightMargin
            int r10 = r10 + r0
            int r0 = r14.width
            r21 = r11
            r11 = r34
            int r0 = android.view.ViewGroup.getChildMeasureSpec(r11, r10, r0)
            int r10 = r14.height
            if (r10 != 0) goto L_0x02dc
            r10 = 1073741824(0x40000000, float:2.0)
            if (r3 == r10) goto L_0x02d0
            goto L_0x02de
        L_0x02d0:
            if (r15 <= 0) goto L_0x02d3
            goto L_0x02d4
        L_0x02d3:
            r15 = 0
        L_0x02d4:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10)
            r13.measure(r0, r15)
            goto L_0x02e7
        L_0x02dc:
            r10 = 1073741824(0x40000000, float:2.0)
        L_0x02de:
            int r23 = r13.getMeasuredHeight()
            int r15 = r23 + r15
            if (r15 >= 0) goto L_0x02d4
            goto L_0x02d3
        L_0x02e7:
            int r0 = r13.getMeasuredState()
            r0 = r0 & -256(0xffffffffffffff00, float:NaN)
            int r1 = android.view.View.combineMeasuredStates(r1, r0)
            r0 = r18
            goto L_0x02f9
        L_0x02f4:
            r10 = r11
            r11 = r34
            r21 = r10
        L_0x02f9:
            int r10 = r14.leftMargin
            int r15 = r14.rightMargin
            int r10 = r10 + r15
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r10
            int r5 = java.lang.Math.max(r5, r15)
            r18 = r0
            r0 = 1073741824(0x40000000, float:2.0)
            if (r12 == r0) goto L_0x0315
            int r0 = r14.width
            r23 = r1
            r1 = -1
            if (r0 != r1) goto L_0x0318
            goto L_0x0319
        L_0x0315:
            r23 = r1
            r1 = -1
        L_0x0318:
            r10 = r15
        L_0x0319:
            int r0 = java.lang.Math.max(r9, r10)
            if (r19 == 0) goto L_0x0325
            int r9 = r14.width
            if (r9 != r1) goto L_0x0325
            r9 = 1
            goto L_0x0326
        L_0x0325:
            r9 = 0
        L_0x0326:
            int r10 = r7.b3
            int r15 = r13.getMeasuredHeight()
            int r15 = r15 + r10
            int r1 = r14.topMargin
            int r15 = r15 + r1
            int r1 = r14.bottomMargin
            int r15 = r15 + r1
            int r1 = r7.t(r13)
            int r15 = r15 + r1
            int r1 = java.lang.Math.max(r10, r15)
            r7.b3 = r1
            r19 = r9
            r1 = r23
            r9 = r0
            r0 = r18
        L_0x0345:
            int r8 = r8 + 1
            r11 = r21
            r10 = 0
            goto L_0x0284
        L_0x034c:
            r11 = r34
            int r0 = r7.b3
            int r3 = r33.getPaddingTop()
            int r8 = r33.getPaddingBottom()
            int r3 = r3 + r8
            int r0 = r0 + r3
            r7.b3 = r0
            r0 = r9
        L_0x035d:
            if (r19 != 0) goto L_0x0364
            r3 = 1073741824(0x40000000, float:2.0)
            if (r12 == r3) goto L_0x0364
            goto L_0x0365
        L_0x0364:
            r0 = r5
        L_0x0365:
            int r3 = r33.getPaddingLeft()
            int r5 = r33.getPaddingRight()
            int r3 = r3 + r5
            int r0 = r0 + r3
            int r3 = r33.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r0, r3)
            int r0 = android.view.View.resolveSizeAndState(r0, r11, r1)
            r7.setMeasuredDimension(r0, r4)
            if (r20 == 0) goto L_0x0383
            r7.n(r2, r6)
        L_0x0383:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.D(int, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int getBaseline() {
        int i2;
        if (this.X2 < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i4 = this.X2;
        if (childCount > i4) {
            View childAt = getChildAt(i4);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i5 = this.Y2;
                if (this.Z2 == 1 && (i2 = this.a3 & 112) != 48) {
                    if (i2 == 16) {
                        i5 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.b3) / 2;
                    } else if (i2 == 80) {
                        i5 = ((getBottom() - getTop()) - getPaddingBottom()) - this.b3;
                    }
                }
                return i5 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.X2 == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.X2;
    }

    public Drawable getDividerDrawable() {
        return this.g3;
    }

    public int getDividerPadding() {
        return this.k3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.h3;
    }

    @GravityInt
    public int getGravity() {
        return this.a3;
    }

    public int getOrientation() {
        return this.Z2;
    }

    public int getShowDividers() {
        return this.j3;
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.c3;
    }

    /* access modifiers changed from: package-private */
    public void i(Canvas canvas) {
        int i2;
        int left;
        int i4;
        int virtualChildCount = getVirtualChildCount();
        boolean b2 = ViewUtils.b(this);
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            View u = u(i5);
            if (!(u == null || u.getVisibility() == 8 || !v(i5))) {
                LayoutParams layoutParams = (LayoutParams) u.getLayoutParams();
                l(canvas, b2 ? u.getRight() + layoutParams.rightMargin : (u.getLeft() - layoutParams.leftMargin) - this.h3);
            }
        }
        if (v(virtualChildCount)) {
            View u2 = u(virtualChildCount - 1);
            if (u2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) u2.getLayoutParams();
                if (b2) {
                    left = u2.getLeft();
                    i4 = layoutParams2.leftMargin;
                } else {
                    i2 = u2.getRight() + layoutParams2.rightMargin;
                    l(canvas, i2);
                }
            } else if (b2) {
                i2 = getPaddingLeft();
                l(canvas, i2);
            } else {
                left = getWidth();
                i4 = getPaddingRight();
            }
            i2 = (left - i4) - this.h3;
            l(canvas, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View u = u(i2);
            if (!(u == null || u.getVisibility() == 8 || !v(i2))) {
                k(canvas, (u.getTop() - ((LayoutParams) u.getLayoutParams()).topMargin) - this.i3);
            }
        }
        if (v(virtualChildCount)) {
            View u2 = u(virtualChildCount - 1);
            k(canvas, u2 == null ? (getHeight() - getPaddingBottom()) - this.i3 : u2.getBottom() + ((LayoutParams) u2.getLayoutParams()).bottomMargin);
        }
    }

    /* access modifiers changed from: package-private */
    public void k(Canvas canvas, int i2) {
        this.g3.setBounds(getPaddingLeft() + this.k3, i2, (getWidth() - getPaddingRight()) - this.k3, this.i3 + i2);
        this.g3.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void l(Canvas canvas, int i2) {
        this.g3.setBounds(i2, getPaddingTop() + this.k3, this.h3 + i2, (getHeight() - getPaddingBottom()) - this.k3);
        this.g3.draw(canvas);
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public LayoutParams generateDefaultLayoutParams() {
        int i2 = this.Z2;
        if (i2 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i2 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        if (this.g3 != null) {
            if (this.Z2 == 1) {
                j(canvas);
            } else {
                i(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(w3);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(w3);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        if (this.Z2 == 1) {
            z(i2, i4, i5, i6);
        } else {
            y(i2, i4, i5, i6);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        if (this.Z2 == 1) {
            D(i2, i4);
        } else {
            B(i2, i4);
        }
    }

    /* renamed from: p */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) (LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public int r(View view, int i2) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int s(View view) {
        return 0;
    }

    public void setBaselineAligned(boolean z) {
        this.s = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.X2 = i2;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.g3) {
            this.g3 = drawable;
            boolean z = false;
            if (drawable != null) {
                this.h3 = drawable.getIntrinsicWidth();
                this.i3 = drawable.getIntrinsicHeight();
            } else {
                this.h3 = 0;
                this.i3 = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i2) {
        this.k3 = i2;
    }

    public void setGravity(@GravityInt int i2) {
        if (this.a3 != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= GravityCompat.f6387b;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.a3 = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i4 = i2 & GravityCompat.f6389d;
        int i5 = this.a3;
        if ((8388615 & i5) != i4) {
            this.a3 = i4 | (-8388616 & i5);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.d3 = z;
    }

    public void setOrientation(int i2) {
        if (this.Z2 != i2) {
            this.Z2 = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.j3) {
            requestLayout();
        }
        this.j3 = i2;
    }

    public void setVerticalGravity(int i2) {
        int i4 = i2 & 112;
        int i5 = this.a3;
        if ((i5 & 112) != i4) {
            this.a3 = i4 | (i5 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.c3 = Math.max(0.0f, f2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public int t(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public View u(int i2) {
        return getChildAt(i2);
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean v(int i2) {
        if (i2 == 0) {
            return (this.j3 & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.j3 & 4) != 0;
        }
        if ((this.j3 & 2) == 0) {
            return false;
        }
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            if (getChildAt(i4).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public boolean w() {
        return this.s;
    }

    public boolean x() {
        return this.d3;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void y(int r25, int r26, int r27, int r28) {
        /*
            r24 = this;
            r6 = r24
            boolean r0 = androidx.appcompat.widget.ViewUtils.b(r24)
            int r7 = r24.getPaddingTop()
            int r1 = r28 - r26
            int r2 = r24.getPaddingBottom()
            int r8 = r1 - r2
            int r1 = r1 - r7
            int r2 = r24.getPaddingBottom()
            int r9 = r1 - r2
            int r10 = r24.getVirtualChildCount()
            int r1 = r6.a3
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r1
            r11 = r1 & 112(0x70, float:1.57E-43)
            boolean r12 = r6.s
            int[] r13 = r6.e3
            int[] r14 = r6.f3
            int r1 = r24.getLayoutDirection()
            int r1 = androidx.core.view.GravityCompat.d(r2, r1)
            r15 = 2
            r5 = 1
            if (r1 == r5) goto L_0x004b
            r2 = 5
            if (r1 == r2) goto L_0x003f
            int r1 = r24.getPaddingLeft()
            goto L_0x0056
        L_0x003f:
            int r1 = r24.getPaddingLeft()
            int r1 = r1 + r27
            int r1 = r1 - r25
            int r2 = r6.b3
            int r1 = r1 - r2
            goto L_0x0056
        L_0x004b:
            int r1 = r24.getPaddingLeft()
            int r2 = r27 - r25
            int r3 = r6.b3
            int r2 = r2 - r3
            int r2 = r2 / r15
            int r1 = r1 + r2
        L_0x0056:
            r2 = 0
            if (r0 == 0) goto L_0x0060
            int r0 = r10 + -1
            r16 = r0
            r17 = -1
            goto L_0x0064
        L_0x0060:
            r16 = 0
            r17 = 1
        L_0x0064:
            r3 = 0
        L_0x0065:
            if (r3 >= r10) goto L_0x0141
            int r0 = r17 * r3
            int r2 = r16 + r0
            android.view.View r0 = r6.u(r2)
            if (r0 != 0) goto L_0x0082
            int r0 = r6.C(r2)
            int r1 = r1 + r0
        L_0x0076:
            r23 = r7
            r19 = r10
            r20 = r11
            r21 = 1
            r22 = -1
            goto L_0x0135
        L_0x0082:
            int r5 = r0.getVisibility()
            r15 = 8
            if (r5 == r15) goto L_0x0131
            int r15 = r0.getMeasuredWidth()
            int r5 = r0.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r18 = r0.getLayoutParams()
            r4 = r18
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r4 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r4
            r18 = r3
            if (r12 == 0) goto L_0x00aa
            int r3 = r4.height
            r19 = r10
            r10 = -1
            if (r3 == r10) goto L_0x00ac
            int r10 = r0.getBaseline()
            goto L_0x00ad
        L_0x00aa:
            r19 = r10
        L_0x00ac:
            r10 = -1
        L_0x00ad:
            int r3 = r4.gravity
            if (r3 >= 0) goto L_0x00b2
            r3 = r11
        L_0x00b2:
            r3 = r3 & 112(0x70, float:1.57E-43)
            r20 = r11
            r11 = 16
            if (r3 == r11) goto L_0x00ec
            r11 = 48
            if (r3 == r11) goto L_0x00dd
            r11 = 80
            if (r3 == r11) goto L_0x00c7
            r3 = r7
            r11 = -1
        L_0x00c4:
            r21 = 1
            goto L_0x00fa
        L_0x00c7:
            int r3 = r8 - r5
            int r11 = r4.bottomMargin
            int r3 = r3 - r11
            r11 = -1
            if (r10 == r11) goto L_0x00c4
            int r21 = r0.getMeasuredHeight()
            int r21 = r21 - r10
            r10 = 2
            r22 = r14[r10]
            int r22 = r22 - r21
            int r3 = r3 - r22
            goto L_0x00c4
        L_0x00dd:
            r11 = -1
            int r3 = r4.topMargin
            int r3 = r3 + r7
            if (r10 == r11) goto L_0x00c4
            r21 = 1
            r22 = r13[r21]
            int r22 = r22 - r10
            int r3 = r3 + r22
            goto L_0x00fa
        L_0x00ec:
            r11 = -1
            r21 = 1
            int r3 = r9 - r5
            r10 = 2
            int r3 = r3 / r10
            int r3 = r3 + r7
            int r10 = r4.topMargin
            int r3 = r3 + r10
            int r10 = r4.bottomMargin
            int r3 = r3 - r10
        L_0x00fa:
            boolean r10 = r6.v(r2)
            if (r10 == 0) goto L_0x0103
            int r10 = r6.h3
            int r1 = r1 + r10
        L_0x0103:
            int r10 = r4.leftMargin
            int r10 = r10 + r1
            int r1 = r6.s(r0)
            int r22 = r10 + r1
            r25 = r0
            r0 = r24
            r1 = r25
            r11 = r2
            r2 = r22
            r23 = r7
            r22 = -1
            r7 = r4
            r4 = r15
            r0.E(r1, r2, r3, r4, r5)
            int r0 = r7.rightMargin
            int r15 = r15 + r0
            r0 = r25
            int r1 = r6.t(r0)
            int r15 = r15 + r1
            int r10 = r10 + r15
            int r0 = r6.r(r0, r11)
            int r3 = r18 + r0
            r1 = r10
            goto L_0x0135
        L_0x0131:
            r18 = r3
            goto L_0x0076
        L_0x0135:
            int r3 = r3 + 1
            r10 = r19
            r11 = r20
            r7 = r23
            r5 = 1
            r15 = 2
            goto L_0x0065
        L_0x0141:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.y(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void z(int i2, int i4, int i5, int i6) {
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int i9 = i5 - i2;
        int paddingRight = i9 - getPaddingRight();
        int paddingRight2 = (i9 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i10 = this.a3;
        int i11 = i10 & 112;
        int i12 = i10 & GravityCompat.f6389d;
        int paddingTop = i11 != 16 ? i11 != 80 ? getPaddingTop() : ((getPaddingTop() + i6) - i4) - this.b3 : getPaddingTop() + (((i6 - i4) - this.b3) / 2);
        int i13 = 0;
        while (i13 < virtualChildCount) {
            View u = u(i13);
            if (u == null) {
                paddingTop += C(i13);
            } else if (u.getVisibility() != 8) {
                int measuredWidth = u.getMeasuredWidth();
                int measuredHeight = u.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) u.getLayoutParams();
                int i14 = layoutParams.gravity;
                if (i14 < 0) {
                    i14 = i12;
                }
                int d2 = GravityCompat.d(i14, getLayoutDirection()) & 7;
                if (d2 == 1) {
                    i7 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i8 = i7 - layoutParams.rightMargin;
                } else if (d2 != 5) {
                    i8 = layoutParams.leftMargin + paddingLeft;
                } else {
                    i7 = paddingRight - measuredWidth;
                    i8 = i7 - layoutParams.rightMargin;
                }
                int i15 = i8;
                if (v(i13)) {
                    paddingTop += this.i3;
                }
                int i16 = paddingTop + layoutParams.topMargin;
                E(u, i15, i16 + s(u), measuredWidth, measuredHeight);
                i13 += r(u, i13);
                paddingTop = i16 + measuredHeight + layoutParams.bottomMargin + t(u);
            }
            i13++;
        }
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = true;
        this.X2 = -1;
        this.Y2 = 0;
        this.a3 = 8388659;
        int[] iArr = R.styleable.L3;
        TintTypedArray G = TintTypedArray.G(context, attributeSet, iArr, i2, 0);
        ViewCompat.F1(this, context, iArr, attributeSet, G.B(), i2, 0);
        int o = G.o(R.styleable.N3, -1);
        if (o >= 0) {
            setOrientation(o);
        }
        int o2 = G.o(R.styleable.M3, -1);
        if (o2 >= 0) {
            setGravity(o2);
        }
        boolean a2 = G.a(R.styleable.O3, true);
        if (!a2) {
            setBaselineAligned(a2);
        }
        this.c3 = G.j(R.styleable.Q3, -1.0f);
        this.X2 = G.o(R.styleable.P3, -1);
        this.d3 = G.a(R.styleable.T3, false);
        setDividerDrawable(G.h(R.styleable.R3));
        this.j3 = G.o(R.styleable.U3, 0);
        this.k3 = G.g(R.styleable.S3, 0);
        G.I();
    }
}
