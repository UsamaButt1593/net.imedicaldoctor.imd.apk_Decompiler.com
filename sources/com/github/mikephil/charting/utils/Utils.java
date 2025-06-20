package com.github.mikephil.charting.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.media3.extractor.AacUtil;
import com.dd.plist.ASCIIPropertyListParser;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.List;
import org.apache.commons.lang3.ClassUtils;

public abstract class Utils {

    /* renamed from: a  reason: collision with root package name */
    private static DisplayMetrics f19163a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f19164b = 50;

    /* renamed from: c  reason: collision with root package name */
    private static int f19165c = 8000;

    /* renamed from: d  reason: collision with root package name */
    public static final double f19166d = 0.017453292519943295d;

    /* renamed from: e  reason: collision with root package name */
    public static final float f19167e = 0.017453292f;

    /* renamed from: f  reason: collision with root package name */
    public static final double f19168f = Double.longBitsToDouble(1);

    /* renamed from: g  reason: collision with root package name */
    public static final float f19169g = Float.intBitsToFloat(1);

    /* renamed from: h  reason: collision with root package name */
    private static Rect f19170h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    private static Paint.FontMetrics f19171i = new Paint.FontMetrics();

    /* renamed from: j  reason: collision with root package name */
    private static Rect f19172j = new Rect();

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f19173k = {1, 10, 100, 1000, 10000, AacUtil.f12876f, 1000000, 10000000, 100000000, com.airbnb.lottie.utils.Utils.f17347a};

    /* renamed from: l  reason: collision with root package name */
    private static ValueFormatter f19174l = q();

    /* renamed from: m  reason: collision with root package name */
    private static Rect f19175m = new Rect();

    /* renamed from: n  reason: collision with root package name */
    private static Rect f19176n = new Rect();
    private static Paint.FontMetrics o = new Paint.FontMetrics();

    public static MPPointF A(MPPointF mPPointF, float f2, float f3) {
        MPPointF c2 = MPPointF.c(0.0f, 0.0f);
        B(mPPointF, f2, f3, c2);
        return c2;
    }

    public static void B(MPPointF mPPointF, float f2, float f3, MPPointF mPPointF2) {
        double d2 = (double) f2;
        double d3 = (double) f3;
        mPPointF2.Y = (float) (((double) mPPointF.Y) + (Math.cos(Math.toRadians(d3)) * d2));
        mPPointF2.Z = (float) (((double) mPPointF.Z) + (d2 * Math.sin(Math.toRadians(d3))));
    }

    public static int C() {
        return Build.VERSION.SDK_INT;
    }

    public static FSize D(float f2, float f3, float f4) {
        return F(f2, f3, f4 * 0.017453292f);
    }

    public static FSize E(FSize fSize, float f2) {
        return F(fSize.Y, fSize.Z, f2 * 0.017453292f);
    }

    public static FSize F(float f2, float f3, float f4) {
        double d2 = (double) f4;
        return FSize.b(Math.abs(((float) Math.cos(d2)) * f2) + Math.abs(((float) Math.sin(d2)) * f3), Math.abs(f2 * ((float) Math.sin(d2))) + Math.abs(f3 * ((float) Math.cos(d2))));
    }

    public static FSize G(FSize fSize, float f2) {
        return F(fSize.Y, fSize.Z, f2);
    }

    public static void H(Context context) {
        if (context == null) {
            f19164b = ViewConfiguration.getMinimumFlingVelocity();
            f19165c = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        f19164b = viewConfiguration.getScaledMinimumFlingVelocity();
        f19165c = viewConfiguration.getScaledMaximumFlingVelocity();
        f19163a = context.getResources().getDisplayMetrics();
    }

    @Deprecated
    public static void I(Resources resources) {
        f19163a = resources.getDisplayMetrics();
        f19164b = ViewConfiguration.getMinimumFlingVelocity();
        f19165c = ViewConfiguration.getMaximumFlingVelocity();
    }

    public static double J(double d2) {
        if (d2 == Double.POSITIVE_INFINITY) {
            return d2;
        }
        double d3 = d2 + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d3) + (d3 >= 0.0d ? 1 : -1));
    }

    @SuppressLint({"NewApi"})
    public static void K(View view) {
        view.postInvalidateOnAnimation();
    }

    public static float L(double d2) {
        if (Double.isInfinite(d2) || Double.isNaN(d2) || d2 == 0.0d) {
            return 0.0f;
        }
        float pow = (float) Math.pow(10.0d, (double) (1 - ((int) ((float) Math.ceil((double) ((float) Math.log10(d2 < 0.0d ? -d2 : d2)))))));
        return ((float) Math.round(d2 * ((double) pow))) / pow;
    }

    public static void M(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, (float) f19165c);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (i2 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    public static int a(Paint paint, String str) {
        Rect rect = f19170h;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static FSize b(Paint paint, String str) {
        FSize b2 = FSize.b(0.0f, 0.0f);
        c(paint, str, b2);
        return b2;
    }

    public static void c(Paint paint, String str, FSize fSize) {
        Rect rect = f19172j;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        fSize.Y = (float) rect.width();
        fSize.Z = (float) rect.height();
    }

    public static int d(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static float e(float f2) {
        DisplayMetrics displayMetrics = f19163a;
        if (displayMetrics != null) {
            return f2 * displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return f2;
    }

    public static int[] f(List<Integer> list) {
        int[] iArr = new int[list.size()];
        i(list, iArr);
        return iArr;
    }

    public static float g(float f2) {
        DisplayMetrics displayMetrics = f19163a;
        if (displayMetrics != null) {
            return f2 / displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertPixelsToDp(...). Otherwise conversion does not take place.");
        return f2;
    }

    public static String[] h(List<String> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = list.get(i2);
        }
        return strArr;
    }

    public static void i(List<Integer> list, int[] iArr) {
        int length = iArr.length < list.size() ? iArr.length : list.size();
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = list.get(i2).intValue();
        }
    }

    public static void j(List<String> list, String[] strArr) {
        int length = strArr.length < list.size() ? strArr.length : list.size();
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = list.get(i2);
        }
    }

    public static void k(Canvas canvas, Drawable drawable, int i2, int i3, int i4, int i5) {
        MPPointF b2 = MPPointF.b();
        b2.Y = (float) (i2 - (i4 / 2));
        b2.Z = (float) (i3 - (i5 / 2));
        drawable.copyBounds(f19175m);
        Rect rect = f19175m;
        int i6 = rect.left;
        int i7 = rect.top;
        drawable.setBounds(i6, i7, i6 + i4, i4 + i7);
        int save = canvas.save();
        canvas.translate(b2.Y, b2.Z);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public static void l(Canvas canvas, StaticLayout staticLayout, float f2, float f3, TextPaint textPaint, MPPointF mPPointF, float f4) {
        float f5;
        float f6;
        float fontMetrics = textPaint.getFontMetrics(o);
        float width = (float) staticLayout.getWidth();
        float lineCount = ((float) staticLayout.getLineCount()) * fontMetrics;
        float f7 = 0.0f - ((float) f19176n.left);
        float f8 = lineCount + 0.0f;
        Paint.Align textAlign = textPaint.getTextAlign();
        textPaint.setTextAlign(Paint.Align.LEFT);
        if (f4 != 0.0f) {
            f5 = f7 - (width * 0.5f);
            f6 = f8 - (lineCount * 0.5f);
            if (!(mPPointF.Y == 0.5f && mPPointF.Z == 0.5f)) {
                FSize D = D(width, lineCount, f4);
                f2 -= D.Y * (mPPointF.Y - 0.5f);
                f3 -= D.Z * (mPPointF.Z - 0.5f);
                FSize.c(D);
            }
            canvas.save();
            canvas.translate(f2, f3);
            canvas.rotate(f4);
        } else {
            float f9 = mPPointF.Y;
            if (!(f9 == 0.0f && mPPointF.Z == 0.0f)) {
                f7 -= width * f9;
                f8 -= lineCount * mPPointF.Z;
            }
            f5 = f7 + f2;
            f6 = f8 + f3;
            canvas.save();
        }
        canvas.translate(f5, f6);
        staticLayout.draw(canvas);
        canvas.restore();
        textPaint.setTextAlign(textAlign);
    }

    public static void m(Canvas canvas, String str, float f2, float f3, TextPaint textPaint, FSize fSize, MPPointF mPPointF, float f4) {
        TextPaint textPaint2 = textPaint;
        l(canvas, new StaticLayout(str, 0, str.length(), textPaint2, (int) Math.max(Math.ceil((double) fSize.Y), 1.0d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false), f2, f3, textPaint2, mPPointF, f4);
    }

    public static void n(Canvas canvas, String str, float f2, float f3, Paint paint, MPPointF mPPointF, float f4) {
        float fontMetrics = paint.getFontMetrics(o);
        paint.getTextBounds(str, 0, str.length(), f19176n);
        float f5 = 0.0f - ((float) f19176n.left);
        float f6 = (-o.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f4 != 0.0f) {
            float width = f5 - (((float) f19176n.width()) * 0.5f);
            float f7 = f6 - (fontMetrics * 0.5f);
            if (!(mPPointF.Y == 0.5f && mPPointF.Z == 0.5f)) {
                FSize D = D((float) f19176n.width(), fontMetrics, f4);
                f2 -= D.Y * (mPPointF.Y - 0.5f);
                f3 -= D.Z * (mPPointF.Z - 0.5f);
                FSize.c(D);
            }
            canvas.save();
            canvas.translate(f2, f3);
            canvas.rotate(f4);
            canvas.drawText(str, width, f7, paint);
            canvas.restore();
        } else {
            if (!(mPPointF.Y == 0.0f && mPPointF.Z == 0.0f)) {
                f5 -= ((float) f19176n.width()) * mPPointF.Y;
                f6 -= fontMetrics * mPPointF.Z;
            }
            canvas.drawText(str, f5 + f2, f6 + f3, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static String o(float f2, int i2, boolean z) {
        return p(f2, i2, z, ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    public static String p(float f2, int i2, boolean z, char c2) {
        boolean z2;
        float f3 = f2;
        char[] cArr = new char[35];
        if (f3 == 0.0f) {
            return "0";
        }
        int i3 = 0;
        boolean z3 = f3 < 1.0f && f3 > -1.0f;
        if (f3 < 0.0f) {
            f3 = -f3;
            z2 = true;
        } else {
            z2 = false;
        }
        int[] iArr = f19173k;
        int i4 = i2;
        int length = i4 > iArr.length ? iArr.length - 1 : i4;
        long round = (long) Math.round(f3 * ((float) iArr[length]));
        int i5 = 34;
        boolean z4 = false;
        while (true) {
            if (round == 0 && i3 >= length + 1) {
                break;
            }
            int i6 = (int) (round % 10);
            round /= 10;
            int i7 = i5 - 1;
            cArr[i5] = (char) (i6 + 48);
            int i8 = i3 + 1;
            if (i8 == length) {
                i5 -= 2;
                cArr[i7] = ASCIIPropertyListParser.f18651i;
                i3 += 2;
                z4 = true;
            } else {
                if (z && round != 0 && i8 > length) {
                    int i9 = (i8 - length) % 4;
                    if (z4) {
                        if (i9 == 0) {
                            i5 -= 2;
                            cArr[i7] = c2;
                        }
                    } else if (i9 == 3) {
                        i5 -= 2;
                        cArr[i7] = c2;
                    }
                    i3 += 2;
                }
                i3 = i8;
                i5 = i7;
            }
        }
        if (z3) {
            cArr[i5] = '0';
            i3++;
            i5--;
        }
        if (z2) {
            cArr[i5] = '-';
            i3++;
        }
        int i10 = 35 - i3;
        return String.valueOf(cArr, i10, 35 - i10);
    }

    private static ValueFormatter q() {
        return new DefaultValueFormatter(1);
    }

    public static int r(float f2) {
        float L = L((double) f2);
        if (Float.isInfinite(L)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10((double) L))) + 2;
    }

    public static ValueFormatter s() {
        return f19174l;
    }

    public static float t(Paint paint) {
        return u(paint, f19171i);
    }

    public static float u(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float v(Paint paint) {
        return w(paint, f19171i);
    }

    public static float w(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static int x() {
        return f19165c;
    }

    public static int y() {
        return f19164b;
    }

    public static float z(float f2) {
        while (f2 < 0.0f) {
            f2 += 360.0f;
        }
        return f2 % 360.0f;
    }
}
