package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflater {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f27845a = {16843490};

    /* renamed from: b  reason: collision with root package name */
    private static final int f27846b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f27847c = {16843489};

    /* renamed from: d  reason: collision with root package name */
    private static final int f27848d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f27849e = {16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};

    /* renamed from: f  reason: collision with root package name */
    private static final int f27850f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static final int f27851g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f27852h = 2;

    /* renamed from: i  reason: collision with root package name */
    private static final int f27853i = 3;

    /* renamed from: j  reason: collision with root package name */
    private static final int f27854j = 4;

    /* renamed from: k  reason: collision with root package name */
    private static final int f27855k = 5;

    /* renamed from: l  reason: collision with root package name */
    private static final int f27856l = 6;

    /* renamed from: m  reason: collision with root package name */
    private static final int f27857m = 7;

    /* renamed from: n  reason: collision with root package name */
    private static final int f27858n = 0;
    private static final int o = 0;

    private static Animator a(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return b(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), (AnimatorSet) null, 0);
    }

    private static Animator b(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i2) throws XmlPullParserException, IOException {
        int i3;
        Animator animator;
        ObjectAnimator objectAnimator;
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = null;
        Animator animator2 = null;
        while (true) {
            int next = xmlPullParser.next();
            i3 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next != 2) {
                    animator = animator2;
                } else {
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        objectAnimator = e(context, attributeSet);
                    } else if (name.equals("animator")) {
                        objectAnimator = d(context, attributeSet, (ValueAnimator) null);
                    } else if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f27845a);
                        TypedValue typedValue = new TypedValue();
                        obtainStyledAttributes.getValue(0, typedValue);
                        if (typedValue.type == 16) {
                            i3 = typedValue.data;
                        }
                        b(context, xmlPullParser, attributeSet, animatorSet2, i3);
                        obtainStyledAttributes.recycle();
                        objectAnimator = animatorSet2;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet == null) {
                        animator = objectAnimator;
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(objectAnimator);
                        animator = objectAnimator;
                    }
                }
                animator2 = animator;
            }
        }
        if (!(animatorSet == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                animatorArr[i3] = (Animator) it2.next();
                i3++;
            }
            if (i2 == 0) {
                animatorSet.F(animatorArr);
            } else {
                animatorSet.D(animatorArr);
            }
        }
        return animator2;
    }

    public static Animator c(Context context, int i2) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            XmlResourceParser animation = context.getResources().getAnimation(i2);
            Animator a2 = a(context, animation);
            if (animation != null) {
                animation.close();
            }
            return a2;
        } catch (XmlPullParserException e2) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
            notFoundException.initCause(e2);
            throw notFoundException;
        } catch (IOException e3) {
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i2));
            notFoundException2.initCause(e3);
            throw notFoundException2;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:77:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.nineoldandroids.animation.ValueAnimator d(android.content.Context r17, android.util.AttributeSet r18, com.nineoldandroids.animation.ValueAnimator r19) throws android.content.res.Resources.NotFoundException {
        /*
            r0 = r17
            int[] r1 = f27849e
            r2 = r18
            android.content.res.TypedArray r1 = r0.obtainStyledAttributes(r2, r1)
            r2 = 1
            r3 = 0
            int r4 = r1.getInt(r2, r3)
            long r4 = (long) r4
            r6 = 2
            int r7 = r1.getInt(r6, r3)
            long r7 = (long) r7
            r9 = 7
            int r9 = r1.getInt(r9, r3)
            if (r19 != 0) goto L_0x0024
            com.nineoldandroids.animation.ValueAnimator r10 = new com.nineoldandroids.animation.ValueAnimator
            r10.<init>()
            goto L_0x0026
        L_0x0024:
            r10 = r19
        L_0x0026:
            if (r9 != 0) goto L_0x002a
            r9 = 1
            goto L_0x002b
        L_0x002a:
            r9 = 0
        L_0x002b:
            r11 = 5
            android.util.TypedValue r12 = r1.peekValue(r11)
            if (r12 == 0) goto L_0x0034
            r13 = 1
            goto L_0x0035
        L_0x0034:
            r13 = 0
        L_0x0035:
            if (r13 == 0) goto L_0x003a
            int r12 = r12.type
            goto L_0x003b
        L_0x003a:
            r12 = 0
        L_0x003b:
            r14 = 6
            android.util.TypedValue r15 = r1.peekValue(r14)
            if (r15 == 0) goto L_0x0045
            r16 = 1
            goto L_0x0047
        L_0x0045:
            r16 = 0
        L_0x0047:
            if (r16 == 0) goto L_0x004c
            int r15 = r15.type
            goto L_0x004d
        L_0x004c:
            r15 = 0
        L_0x004d:
            r2 = 31
            r3 = 28
            if (r13 == 0) goto L_0x0057
            if (r12 < r3) goto L_0x0057
            if (r12 <= r2) goto L_0x005d
        L_0x0057:
            if (r16 == 0) goto L_0x0066
            if (r15 < r3) goto L_0x0066
            if (r15 > r2) goto L_0x0066
        L_0x005d:
            com.nineoldandroids.animation.ArgbEvaluator r9 = new com.nineoldandroids.animation.ArgbEvaluator
            r9.<init>()
            r10.w0(r9)
            r9 = 0
        L_0x0066:
            r2 = 0
            if (r9 == 0) goto L_0x00b0
            if (r13 == 0) goto L_0x0099
            if (r12 != r11) goto L_0x0072
            float r3 = r1.getDimension(r11, r2)
            goto L_0x0076
        L_0x0072:
            float r3 = r1.getFloat(r11, r2)
        L_0x0076:
            if (r16 == 0) goto L_0x008f
            if (r15 != r11) goto L_0x007f
            float r2 = r1.getDimension(r14, r2)
            goto L_0x0083
        L_0x007f:
            float r2 = r1.getFloat(r14, r2)
        L_0x0083:
            float[] r6 = new float[r6]
            r9 = 0
            r6[r9] = r3
            r12 = 1
            r6[r12] = r2
            r10.y0(r6)
            goto L_0x00ad
        L_0x008f:
            r9 = 0
            r12 = 1
            float[] r2 = new float[r12]
            r2[r9] = r3
            r10.y0(r2)
            goto L_0x00ad
        L_0x0099:
            r9 = 0
            r12 = 1
            if (r15 != r11) goto L_0x00a2
            float r2 = r1.getDimension(r14, r2)
            goto L_0x00a6
        L_0x00a2:
            float r2 = r1.getFloat(r14, r2)
        L_0x00a6:
            float[] r3 = new float[r12]
            r3[r9] = r2
            r10.y0(r3)
        L_0x00ad:
            r2 = 0
            goto L_0x0117
        L_0x00b0:
            r9 = 0
            if (r13 == 0) goto L_0x00f3
            if (r12 != r11) goto L_0x00bb
            float r6 = r1.getDimension(r11, r2)
            int r6 = (int) r6
            goto L_0x00ca
        L_0x00bb:
            if (r12 < r3) goto L_0x00c6
            r6 = 31
            if (r12 > r6) goto L_0x00c6
            int r6 = r1.getColor(r11, r9)
            goto L_0x00ca
        L_0x00c6:
            int r6 = r1.getInt(r11, r9)
        L_0x00ca:
            if (r16 == 0) goto L_0x00eb
            if (r15 != r11) goto L_0x00d4
            float r2 = r1.getDimension(r14, r2)
            int r2 = (int) r2
            goto L_0x00e3
        L_0x00d4:
            if (r15 < r3) goto L_0x00df
            r2 = 31
            if (r15 > r2) goto L_0x00df
            int r2 = r1.getColor(r14, r9)
            goto L_0x00e3
        L_0x00df:
            int r2 = r1.getInt(r14, r9)
        L_0x00e3:
            int[] r2 = new int[]{r6, r2}
            r10.C0(r2)
            goto L_0x00ad
        L_0x00eb:
            int[] r2 = new int[]{r6}
            r10.C0(r2)
            goto L_0x00ad
        L_0x00f3:
            if (r16 == 0) goto L_0x00ad
            if (r15 != r11) goto L_0x00ff
            float r2 = r1.getDimension(r14, r2)
            int r2 = (int) r2
            r3 = r2
            r2 = 0
            goto L_0x0110
        L_0x00ff:
            if (r15 < r3) goto L_0x010b
            r2 = 31
            if (r15 > r2) goto L_0x010b
            r2 = 0
            int r3 = r1.getColor(r14, r2)
            goto L_0x0110
        L_0x010b:
            r2 = 0
            int r3 = r1.getInt(r14, r2)
        L_0x0110:
            int[] r3 = new int[]{r3}
            r10.C0(r3)
        L_0x0117:
            r10.m(r4)
            r10.o(r7)
            r3 = 3
            boolean r4 = r1.hasValue(r3)
            if (r4 == 0) goto L_0x012b
            int r3 = r1.getInt(r3, r2)
            r10.E0(r3)
        L_0x012b:
            r3 = 4
            boolean r4 = r1.hasValue(r3)
            if (r4 == 0) goto L_0x013a
            r4 = 1
            int r3 = r1.getInt(r3, r4)
            r10.F0(r3)
        L_0x013a:
            int r2 = r1.getResourceId(r2, r2)
            if (r2 <= 0) goto L_0x0147
            android.view.animation.Interpolator r0 = android.view.animation.AnimationUtils.loadInterpolator(r0, r2)
            r10.n(r0)
        L_0x0147:
            r1.recycle()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.animation.AnimatorInflater.d(android.content.Context, android.util.AttributeSet, com.nineoldandroids.animation.ValueAnimator):com.nineoldandroids.animation.ValueAnimator");
    }

    private static ObjectAnimator e(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        d(context, attributeSet, objectAnimator);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f27847c);
        objectAnimator.h1(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return objectAnimator;
    }
}
