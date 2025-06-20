package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends VectorDrawableCommon {
    static final String d3 = "VectorDrawableCompat";
    static final PorterDuff.Mode e3 = PorterDuff.Mode.SRC_IN;
    private static final String f3 = "clip-path";
    private static final String g3 = "group";
    private static final String h3 = "path";
    private static final String i3 = "vector";
    private static final int j3 = 0;
    private static final int k3 = 1;
    private static final int l3 = 2;
    private static final int m3 = 0;
    private static final int n3 = 1;
    private static final int o3 = 2;
    private static final int p3 = 2048;
    private static final boolean q3 = false;
    private VectorDrawableCompatState X;
    private boolean X2;
    private PorterDuffColorFilter Y;
    private boolean Y2;
    private ColorFilter Z;
    private Drawable.ConstantState Z2;
    private final float[] a3;
    private final Matrix b3;
    private final Rect c3;

    private static class VClipPath extends VPath {
        VClipPath() {
        }

        private void j(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f16374b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f16373a = PathParser.d(string2);
            }
            this.f16375c = TypedArrayUtils.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public boolean e() {
            return true;
        }

        public void i(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.r(xmlPullParser, "pathData")) {
                TypedArray s = TypedArrayUtils.s(resources, theme, attributeSet, AndroidResources.I);
                j(s, xmlPullParser);
                s.recycle();
            }
        }

        VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }
    }

    private static class VFullPath extends VPath {

        /* renamed from: f  reason: collision with root package name */
        private int[] f16350f;

        /* renamed from: g  reason: collision with root package name */
        ComplexColorCompat f16351g;

        /* renamed from: h  reason: collision with root package name */
        float f16352h = 0.0f;

        /* renamed from: i  reason: collision with root package name */
        ComplexColorCompat f16353i;

        /* renamed from: j  reason: collision with root package name */
        float f16354j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        float f16355k = 1.0f;

        /* renamed from: l  reason: collision with root package name */
        float f16356l = 0.0f;

        /* renamed from: m  reason: collision with root package name */
        float f16357m = 1.0f;

        /* renamed from: n  reason: collision with root package name */
        float f16358n = 0.0f;
        Paint.Cap o = Paint.Cap.BUTT;
        Paint.Join p = Paint.Join.MITER;
        float q = 4.0f;

        VFullPath() {
        }

        private Paint.Cap i(int i2, Paint.Cap cap) {
            if (i2 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i2 != 1) {
                return i2 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        private Paint.Join j(int i2, Paint.Join join) {
            if (i2 == 0) {
                return Paint.Join.MITER;
            }
            if (i2 != 1) {
                return i2 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        private void l(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f16350f = null;
            if (TypedArrayUtils.r(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f16374b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f16373a = PathParser.d(string2);
                }
                Resources.Theme theme2 = theme;
                this.f16353i = TypedArrayUtils.i(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f16355k = TypedArrayUtils.j(typedArray, xmlPullParser, "fillAlpha", 12, this.f16355k);
                this.o = i(TypedArrayUtils.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.o);
                this.p = j(TypedArrayUtils.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.p);
                this.q = TypedArrayUtils.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.q);
                this.f16351g = TypedArrayUtils.i(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f16354j = TypedArrayUtils.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.f16354j);
                this.f16352h = TypedArrayUtils.j(typedArray, xmlPullParser, "strokeWidth", 4, this.f16352h);
                this.f16357m = TypedArrayUtils.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.f16357m);
                this.f16358n = TypedArrayUtils.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.f16358n);
                this.f16356l = TypedArrayUtils.j(typedArray, xmlPullParser, "trimPathStart", 5, this.f16356l);
                this.f16375c = TypedArrayUtils.k(typedArray, xmlPullParser, "fillType", 13, this.f16375c);
            }
        }

        public boolean a() {
            return this.f16353i.i() || this.f16351g.i();
        }

        public boolean b(int[] iArr) {
            return this.f16351g.j(iArr) | this.f16353i.j(iArr);
        }

        public void c(Resources.Theme theme) {
        }

        public boolean d() {
            return this.f16350f != null;
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.f16355k;
        }

        /* access modifiers changed from: package-private */
        @ColorInt
        public int getFillColor() {
            return this.f16353i.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.f16354j;
        }

        /* access modifiers changed from: package-private */
        @ColorInt
        public int getStrokeColor() {
            return this.f16351g.e();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f16352h;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.f16357m;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.f16358n;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.f16356l;
        }

        public void k(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray s = TypedArrayUtils.s(resources, theme, attributeSet, AndroidResources.t);
            l(s, xmlPullParser, theme);
            s.recycle();
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f2) {
            this.f16355k = f2;
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i2) {
            this.f16353i.k(i2);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f2) {
            this.f16354j = f2;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i2) {
            this.f16351g.k(i2);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f2) {
            this.f16352h = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f2) {
            this.f16357m = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f2) {
            this.f16358n = f2;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f2) {
            this.f16356l = f2;
        }

        VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.f16350f = vFullPath.f16350f;
            this.f16351g = vFullPath.f16351g;
            this.f16352h = vFullPath.f16352h;
            this.f16354j = vFullPath.f16354j;
            this.f16353i = vFullPath.f16353i;
            this.f16375c = vFullPath.f16375c;
            this.f16355k = vFullPath.f16355k;
            this.f16356l = vFullPath.f16356l;
            this.f16357m = vFullPath.f16357m;
            this.f16358n = vFullPath.f16358n;
            this.o = vFullPath.o;
            this.p = vFullPath.p;
            this.q = vFullPath.q;
        }
    }

    private static class VGroup extends VObject {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f16359a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<VObject> f16360b;

        /* renamed from: c  reason: collision with root package name */
        float f16361c;

        /* renamed from: d  reason: collision with root package name */
        private float f16362d;

        /* renamed from: e  reason: collision with root package name */
        private float f16363e;

        /* renamed from: f  reason: collision with root package name */
        private float f16364f;

        /* renamed from: g  reason: collision with root package name */
        private float f16365g;

        /* renamed from: h  reason: collision with root package name */
        private float f16366h;

        /* renamed from: i  reason: collision with root package name */
        private float f16367i;

        /* renamed from: j  reason: collision with root package name */
        final Matrix f16368j;

        /* renamed from: k  reason: collision with root package name */
        int f16369k;

        /* renamed from: l  reason: collision with root package name */
        private int[] f16370l;

        /* renamed from: m  reason: collision with root package name */
        private String f16371m;

        public VGroup() {
            super();
            this.f16359a = new Matrix();
            this.f16360b = new ArrayList<>();
            this.f16361c = 0.0f;
            this.f16362d = 0.0f;
            this.f16363e = 0.0f;
            this.f16364f = 1.0f;
            this.f16365g = 1.0f;
            this.f16366h = 0.0f;
            this.f16367i = 0.0f;
            this.f16368j = new Matrix();
            this.f16371m = null;
        }

        private void d() {
            this.f16368j.reset();
            this.f16368j.postTranslate(-this.f16362d, -this.f16363e);
            this.f16368j.postScale(this.f16364f, this.f16365g);
            this.f16368j.postRotate(this.f16361c, 0.0f, 0.0f);
            this.f16368j.postTranslate(this.f16366h + this.f16362d, this.f16367i + this.f16363e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f16370l = null;
            this.f16361c = TypedArrayUtils.j(typedArray, xmlPullParser, Key.f4369i, 5, this.f16361c);
            this.f16362d = typedArray.getFloat(1, this.f16362d);
            this.f16363e = typedArray.getFloat(2, this.f16363e);
            this.f16364f = TypedArrayUtils.j(typedArray, xmlPullParser, "scaleX", 3, this.f16364f);
            this.f16365g = TypedArrayUtils.j(typedArray, xmlPullParser, "scaleY", 4, this.f16365g);
            this.f16366h = TypedArrayUtils.j(typedArray, xmlPullParser, "translateX", 6, this.f16366h);
            this.f16367i = TypedArrayUtils.j(typedArray, xmlPullParser, "translateY", 7, this.f16367i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f16371m = string;
            }
            d();
        }

        public boolean a() {
            for (int i2 = 0; i2 < this.f16360b.size(); i2++) {
                if (this.f16360b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f16360b.size(); i2++) {
                z |= this.f16360b.get(i2).b(iArr);
            }
            return z;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray s = TypedArrayUtils.s(resources, theme, attributeSet, AndroidResources.f16322k);
            e(s, xmlPullParser);
            s.recycle();
        }

        public String getGroupName() {
            return this.f16371m;
        }

        public Matrix getLocalMatrix() {
            return this.f16368j;
        }

        public float getPivotX() {
            return this.f16362d;
        }

        public float getPivotY() {
            return this.f16363e;
        }

        public float getRotation() {
            return this.f16361c;
        }

        public float getScaleX() {
            return this.f16364f;
        }

        public float getScaleY() {
            return this.f16365g;
        }

        public float getTranslateX() {
            return this.f16366h;
        }

        public float getTranslateY() {
            return this.f16367i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f16362d) {
                this.f16362d = f2;
                d();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f16363e) {
                this.f16363e = f2;
                d();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f16361c) {
                this.f16361c = f2;
                d();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f16364f) {
                this.f16364f = f2;
                d();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f16365g) {
                this.f16365g = f2;
                d();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f16366h) {
                this.f16366h = f2;
                d();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f16367i) {
                this.f16367i = f2;
                d();
            }
        }

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            super();
            VPath vPath;
            this.f16359a = new Matrix();
            this.f16360b = new ArrayList<>();
            this.f16361c = 0.0f;
            this.f16362d = 0.0f;
            this.f16363e = 0.0f;
            this.f16364f = 1.0f;
            this.f16365g = 1.0f;
            this.f16366h = 0.0f;
            this.f16367i = 0.0f;
            Matrix matrix = new Matrix();
            this.f16368j = matrix;
            this.f16371m = null;
            this.f16361c = vGroup.f16361c;
            this.f16362d = vGroup.f16362d;
            this.f16363e = vGroup.f16363e;
            this.f16364f = vGroup.f16364f;
            this.f16365g = vGroup.f16365g;
            this.f16366h = vGroup.f16366h;
            this.f16367i = vGroup.f16367i;
            this.f16370l = vGroup.f16370l;
            String str = vGroup.f16371m;
            this.f16371m = str;
            this.f16369k = vGroup.f16369k;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.f16368j);
            ArrayList<VObject> arrayList = vGroup.f16360b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                VObject vObject = arrayList.get(i2);
                if (vObject instanceof VGroup) {
                    this.f16360b.add(new VGroup((VGroup) vObject, arrayMap));
                } else {
                    if (vObject instanceof VFullPath) {
                        vPath = new VFullPath((VFullPath) vObject);
                    } else if (vObject instanceof VClipPath) {
                        vPath = new VClipPath((VClipPath) vObject);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f16360b.add(vPath);
                    String str2 = vPath.f16374b;
                    if (str2 != null) {
                        arrayMap.put(str2, vPath);
                    }
                }
            }
        }
    }

    private static abstract class VObject {
        private VObject() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    private static abstract class VPath extends VObject {

        /* renamed from: e  reason: collision with root package name */
        protected static final int f16372e = 0;

        /* renamed from: a  reason: collision with root package name */
        protected PathParser.PathDataNode[] f16373a = null;

        /* renamed from: b  reason: collision with root package name */
        String f16374b;

        /* renamed from: c  reason: collision with root package name */
        int f16375c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f16376d;

        public VPath() {
            super();
        }

        public void c(Resources.Theme theme) {
        }

        public boolean d() {
            return false;
        }

        public boolean e() {
            return false;
        }

        public String f(PathParser.PathDataNode[] pathDataNodeArr) {
            String str = StringUtils.SPACE;
            for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
                str = str + pathDataNodeArr[i2].f5834a + ":";
                float[] fArr = pathDataNodeArr[i2].f5835b;
                for (int i3 = 0; i3 < fArr.length; i3++) {
                    str = str + fArr[i3] + ",";
                }
            }
            return str;
        }

        public void g(int i2) {
            String str = "";
            for (int i3 = 0; i3 < i2; i3++) {
                str = str + "    ";
            }
            Log.v(VectorDrawableCompat.d3, str + "current path is :" + this.f16374b + " pathData is " + f(this.f16373a));
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.f16373a;
        }

        public String getPathName() {
            return this.f16374b;
        }

        public void h(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.f16373a;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.k(pathDataNodeArr, path);
            }
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.b(this.f16373a, pathDataNodeArr)) {
                this.f16373a = PathParser.f(pathDataNodeArr);
            } else {
                PathParser.m(this.f16373a, pathDataNodeArr);
            }
        }

        public VPath(VPath vPath) {
            super();
            this.f16374b = vPath.f16374b;
            this.f16376d = vPath.f16376d;
            this.f16373a = PathParser.f(vPath.f16373a);
        }
    }

    private static class VPathRenderer {
        private static final Matrix q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        private final Path f16377a;

        /* renamed from: b  reason: collision with root package name */
        private final Path f16378b;

        /* renamed from: c  reason: collision with root package name */
        private final Matrix f16379c;

        /* renamed from: d  reason: collision with root package name */
        Paint f16380d;

        /* renamed from: e  reason: collision with root package name */
        Paint f16381e;

        /* renamed from: f  reason: collision with root package name */
        private PathMeasure f16382f;

        /* renamed from: g  reason: collision with root package name */
        private int f16383g;

        /* renamed from: h  reason: collision with root package name */
        final VGroup f16384h;

        /* renamed from: i  reason: collision with root package name */
        float f16385i;

        /* renamed from: j  reason: collision with root package name */
        float f16386j;

        /* renamed from: k  reason: collision with root package name */
        float f16387k;

        /* renamed from: l  reason: collision with root package name */
        float f16388l;

        /* renamed from: m  reason: collision with root package name */
        int f16389m;

        /* renamed from: n  reason: collision with root package name */
        String f16390n;
        Boolean o;
        final ArrayMap<String, Object> p;

        public VPathRenderer() {
            this.f16379c = new Matrix();
            this.f16385i = 0.0f;
            this.f16386j = 0.0f;
            this.f16387k = 0.0f;
            this.f16388l = 0.0f;
            this.f16389m = 255;
            this.f16390n = null;
            this.o = null;
            this.p = new ArrayMap<>();
            this.f16384h = new VGroup();
            this.f16377a = new Path();
            this.f16378b = new Path();
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private void c(VGroup vGroup, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            vGroup.f16359a.set(matrix);
            vGroup.f16359a.preConcat(vGroup.f16368j);
            canvas.save();
            for (int i4 = 0; i4 < vGroup.f16360b.size(); i4++) {
                VObject vObject = vGroup.f16360b.get(i4);
                if (vObject instanceof VGroup) {
                    c((VGroup) vObject, vGroup.f16359a, canvas, i2, i3, colorFilter);
                } else if (vObject instanceof VPath) {
                    d(vGroup, (VPath) vObject, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(VGroup vGroup, VPath vPath, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = ((float) i2) / this.f16387k;
            float f3 = ((float) i3) / this.f16388l;
            float min = Math.min(f2, f3);
            Matrix matrix = vGroup.f16359a;
            this.f16379c.set(matrix);
            this.f16379c.postScale(f2, f3);
            float e2 = e(matrix);
            if (e2 != 0.0f) {
                vPath.h(this.f16377a);
                Path path = this.f16377a;
                this.f16378b.reset();
                if (vPath.e()) {
                    this.f16378b.setFillType(vPath.f16375c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.f16378b.addPath(path, this.f16379c);
                    canvas.clipPath(this.f16378b);
                    return;
                }
                VFullPath vFullPath = (VFullPath) vPath;
                float f4 = vFullPath.f16356l;
                if (!(f4 == 0.0f && vFullPath.f16357m == 1.0f)) {
                    float f5 = vFullPath.f16358n;
                    float f6 = (f4 + f5) % 1.0f;
                    float f7 = (vFullPath.f16357m + f5) % 1.0f;
                    if (this.f16382f == null) {
                        this.f16382f = new PathMeasure();
                    }
                    this.f16382f.setPath(this.f16377a, false);
                    float length = this.f16382f.getLength();
                    float f8 = f6 * length;
                    float f9 = f7 * length;
                    path.reset();
                    if (f8 > f9) {
                        this.f16382f.getSegment(f8, length, path, true);
                        this.f16382f.getSegment(0.0f, f9, path, true);
                    } else {
                        this.f16382f.getSegment(f8, f9, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f16378b.addPath(path, this.f16379c);
                if (vFullPath.f16353i.l()) {
                    ComplexColorCompat complexColorCompat = vFullPath.f16353i;
                    if (this.f16381e == null) {
                        Paint paint = new Paint(1);
                        this.f16381e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f16381e;
                    if (complexColorCompat.h()) {
                        Shader f10 = complexColorCompat.f();
                        f10.setLocalMatrix(this.f16379c);
                        paint2.setShader(f10);
                        paint2.setAlpha(Math.round(vFullPath.f16355k * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(VectorDrawableCompat.a(complexColorCompat.e(), vFullPath.f16355k));
                    }
                    paint2.setColorFilter(colorFilter);
                    this.f16378b.setFillType(vFullPath.f16375c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f16378b, paint2);
                }
                if (vFullPath.f16351g.l()) {
                    ComplexColorCompat complexColorCompat2 = vFullPath.f16351g;
                    if (this.f16380d == null) {
                        Paint paint3 = new Paint(1);
                        this.f16380d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f16380d;
                    Paint.Join join = vFullPath.p;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = vFullPath.o;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(vFullPath.q);
                    if (complexColorCompat2.h()) {
                        Shader f11 = complexColorCompat2.f();
                        f11.setLocalMatrix(this.f16379c);
                        paint4.setShader(f11);
                        paint4.setAlpha(Math.round(vFullPath.f16354j * 255.0f));
                    } else {
                        paint4.setShader((Shader) null);
                        paint4.setAlpha(255);
                        paint4.setColor(VectorDrawableCompat.a(complexColorCompat2.e(), vFullPath.f16354j));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(vFullPath.f16352h * min * e2);
                    canvas.drawPath(this.f16378b, paint4);
                }
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            c(this.f16384h, q, canvas, i2, i3, colorFilter);
        }

        public boolean f() {
            if (this.o == null) {
                this.o = Boolean.valueOf(this.f16384h.a());
            }
            return this.o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f16384h.b(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f16389m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.f16389m = i2;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.f16379c = new Matrix();
            this.f16385i = 0.0f;
            this.f16386j = 0.0f;
            this.f16387k = 0.0f;
            this.f16388l = 0.0f;
            this.f16389m = 255;
            this.f16390n = null;
            this.o = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.p = arrayMap;
            this.f16384h = new VGroup(vPathRenderer.f16384h, arrayMap);
            this.f16377a = new Path(vPathRenderer.f16377a);
            this.f16378b = new Path(vPathRenderer.f16378b);
            this.f16385i = vPathRenderer.f16385i;
            this.f16386j = vPathRenderer.f16386j;
            this.f16387k = vPathRenderer.f16387k;
            this.f16388l = vPathRenderer.f16388l;
            this.f16383g = vPathRenderer.f16383g;
            this.f16389m = vPathRenderer.f16389m;
            this.f16390n = vPathRenderer.f16390n;
            String str = vPathRenderer.f16390n;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.o = vPathRenderer.o;
        }
    }

    private static class VectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f16391a;

        /* renamed from: b  reason: collision with root package name */
        VPathRenderer f16392b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f16393c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f16394d;

        /* renamed from: e  reason: collision with root package name */
        boolean f16395e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f16396f;

        /* renamed from: g  reason: collision with root package name */
        int[] f16397g;

        /* renamed from: h  reason: collision with root package name */
        ColorStateList f16398h;

        /* renamed from: i  reason: collision with root package name */
        PorterDuff.Mode f16399i;

        /* renamed from: j  reason: collision with root package name */
        int f16400j;

        /* renamed from: k  reason: collision with root package name */
        boolean f16401k;

        /* renamed from: l  reason: collision with root package name */
        boolean f16402l;

        /* renamed from: m  reason: collision with root package name */
        Paint f16403m;

        public VectorDrawableCompatState() {
            this.f16393c = null;
            this.f16394d = VectorDrawableCompat.e3;
            this.f16392b = new VPathRenderer();
        }

        public boolean a(int i2, int i3) {
            return i2 == this.f16396f.getWidth() && i3 == this.f16396f.getHeight();
        }

        public boolean b() {
            return !this.f16402l && this.f16398h == this.f16393c && this.f16399i == this.f16394d && this.f16401k == this.f16395e && this.f16400j == this.f16392b.getRootAlpha();
        }

        public void c(int i2, int i3) {
            if (this.f16396f == null || !a(i2, i3)) {
                this.f16396f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.f16402l = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f16396f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f16403m == null) {
                Paint paint = new Paint();
                this.f16403m = paint;
                paint.setFilterBitmap(true);
            }
            this.f16403m.setAlpha(this.f16392b.getRootAlpha());
            this.f16403m.setColorFilter(colorFilter);
            return this.f16403m;
        }

        public boolean f() {
            return this.f16392b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f16392b.f();
        }

        public int getChangingConfigurations() {
            return this.f16391a;
        }

        public boolean h(int[] iArr) {
            boolean g2 = this.f16392b.g(iArr);
            this.f16402l |= g2;
            return g2;
        }

        public void i() {
            this.f16398h = this.f16393c;
            this.f16399i = this.f16394d;
            this.f16400j = this.f16392b.getRootAlpha();
            this.f16401k = this.f16395e;
            this.f16402l = false;
        }

        public void j(int i2, int i3) {
            this.f16396f.eraseColor(0);
            this.f16392b.b(new Canvas(this.f16396f), i2, i3, (ColorFilter) null);
        }

        @NonNull
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.f16393c = null;
            this.f16394d = VectorDrawableCompat.e3;
            if (vectorDrawableCompatState != null) {
                this.f16391a = vectorDrawableCompatState.f16391a;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.f16392b);
                this.f16392b = vPathRenderer;
                if (vectorDrawableCompatState.f16392b.f16381e != null) {
                    vPathRenderer.f16381e = new Paint(vectorDrawableCompatState.f16392b.f16381e);
                }
                if (vectorDrawableCompatState.f16392b.f16380d != null) {
                    this.f16392b.f16380d = new Paint(vectorDrawableCompatState.f16392b.f16380d);
                }
                this.f16393c = vectorDrawableCompatState.f16393c;
                this.f16394d = vectorDrawableCompatState.f16394d;
                this.f16395e = vectorDrawableCompatState.f16395e;
            }
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }
    }

    @RequiresApi(24)
    private static class VectorDrawableDelegateState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f16404a;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f16404a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f16404a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f16404a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.s = (VectorDrawable) this.f16404a.newDrawable();
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.s = (VectorDrawable) this.f16404a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.s = (VectorDrawable) this.f16404a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    VectorDrawableCompat() {
        this.Y2 = true;
        this.a3 = new float[9];
        this.b3 = new Matrix();
        this.c3 = new Rect();
        this.X = new VectorDrawableCompatState();
    }

    static int a(int i2, float f2) {
        return (i2 & ViewCompat.x) | (((int) (((float) Color.alpha(i2)) * f2)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041 A[Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.VectorDrawableCompat e(@androidx.annotation.NonNull android.content.res.Resources r6, @androidx.annotation.DrawableRes int r7, @androidx.annotation.Nullable android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0023
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r0 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
            r0.<init>()
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.ResourcesCompat.g(r6, r7, r8)
            r0.s = r6
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState r6 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState
            android.graphics.drawable.Drawable r7 = r0.s
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.Z2 = r6
            return r0
        L_0x0023:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
        L_0x002b:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            r4 = 2
            if (r3 == r4) goto L_0x0036
            r5 = 1
            if (r3 == r5) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            if (r3 != r4) goto L_0x0041
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r6 = f(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            return r6
        L_0x003d:
            r6 = move-exception
            goto L_0x0049
        L_0x003f:
            r6 = move-exception
            goto L_0x0049
        L_0x0041:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
            throw r6     // Catch:{ XmlPullParserException -> 0x003f, IOException -> 0x003d }
        L_0x0049:
            android.util.Log.e(r1, r0, r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.e(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.graphics.drawable.VectorDrawableCompat");
    }

    public static VectorDrawableCompat f(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    private void i(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i2;
        int i4;
        VectorDrawableCompatState vectorDrawableCompatState = this.X;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f16392b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(vPathRenderer.f16384h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) arrayDeque.peek();
                if ("path".equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.k(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f16360b.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.p.put(vFullPath.getPathName(), vFullPath);
                    }
                    vectorDrawableCompatState.f16391a = vFullPath.f16376d | vectorDrawableCompatState.f16391a;
                    z = false;
                } else {
                    if (f3.equals(name)) {
                        VClipPath vClipPath = new VClipPath();
                        vClipPath.i(resources, attributeSet, theme, xmlPullParser);
                        vGroup.f16360b.add(vClipPath);
                        if (vClipPath.getPathName() != null) {
                            vPathRenderer.p.put(vClipPath.getPathName(), vClipPath);
                        }
                        i2 = vectorDrawableCompatState.f16391a;
                        i4 = vClipPath.f16376d;
                    } else if (g3.equals(name)) {
                        VGroup vGroup2 = new VGroup();
                        vGroup2.c(resources, attributeSet, theme, xmlPullParser);
                        vGroup.f16360b.add(vGroup2);
                        arrayDeque.push(vGroup2);
                        if (vGroup2.getGroupName() != null) {
                            vPathRenderer.p.put(vGroup2.getGroupName(), vGroup2);
                        }
                        i2 = vectorDrawableCompatState.f16391a;
                        i4 = vGroup2.f16369k;
                    }
                    vectorDrawableCompatState.f16391a = i4 | i2;
                }
            } else if (eventType == 3 && g3.equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean j() {
        return isAutoMirrored() && DrawableCompat.f(this) == 1;
    }

    private static PorterDuff.Mode k(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void l(VGroup vGroup, int i2) {
        String str = "";
        for (int i4 = 0; i4 < i2; i4++) {
            str = str + "    ";
        }
        Log.v(d3, str + "current group is :" + vGroup.getGroupName() + " rotation is " + vGroup.f16361c);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("matrix is :");
        sb.append(vGroup.getLocalMatrix().toString());
        Log.v(d3, sb.toString());
        for (int i5 = 0; i5 < vGroup.f16360b.size(); i5++) {
            VObject vObject = vGroup.f16360b.get(i5);
            if (vObject instanceof VGroup) {
                l((VGroup) vObject, i2 + 1);
            } else {
                ((VPath) vObject).g(i2 + 1);
            }
        }
    }

    private void n(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.X;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f16392b;
        vectorDrawableCompatState.f16394d = k(TypedArrayUtils.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList g2 = TypedArrayUtils.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (g2 != null) {
            vectorDrawableCompatState.f16393c = g2;
        }
        vectorDrawableCompatState.f16395e = TypedArrayUtils.e(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.f16395e);
        vPathRenderer.f16387k = TypedArrayUtils.j(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.f16387k);
        float j2 = TypedArrayUtils.j(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.f16388l);
        vPathRenderer.f16388l = j2;
        if (vPathRenderer.f16387k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (j2 > 0.0f) {
            vPathRenderer.f16385i = typedArray.getDimension(3, vPathRenderer.f16385i);
            float dimension = typedArray.getDimension(2, vPathRenderer.f16386j);
            vPathRenderer.f16386j = dimension;
            if (vPathRenderer.f16385i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                vPathRenderer.setAlpha(TypedArrayUtils.j(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    vPathRenderer.f16390n = string;
                    vPathRenderer.p.put(string, vPathRenderer);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.s;
        if (drawable == null) {
            return false;
        }
        DrawableCompat.b(drawable);
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.c3);
        if (this.c3.width() > 0 && this.c3.height() > 0) {
            ColorFilter colorFilter = this.Z;
            if (colorFilter == null) {
                colorFilter = this.Y;
            }
            canvas.getMatrix(this.b3);
            this.b3.getValues(this.a3);
            float abs = Math.abs(this.a3[0]);
            float abs2 = Math.abs(this.a3[4]);
            float abs3 = Math.abs(this.a3[1]);
            float abs4 = Math.abs(this.a3[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.c3.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.c3.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.c3;
                canvas.translate((float) rect.left, (float) rect.top);
                if (j()) {
                    canvas.translate((float) this.c3.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.c3.offsetTo(0, 0);
                this.X.c(min, min2);
                if (!this.Y2) {
                    this.X.j(min, min2);
                } else if (!this.X.b()) {
                    this.X.j(min, min2);
                    this.X.i();
                }
                this.X.d(canvas, colorFilter, this.c3);
                canvas.restoreToCount(save);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public float g() {
        VPathRenderer vPathRenderer;
        VectorDrawableCompatState vectorDrawableCompatState = this.X;
        if (vectorDrawableCompatState == null || (vPathRenderer = vectorDrawableCompatState.f16392b) == null) {
            return 1.0f;
        }
        float f2 = vPathRenderer.f16385i;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        float f4 = vPathRenderer.f16386j;
        if (f4 == 0.0f) {
            return 1.0f;
        }
        float f5 = vPathRenderer.f16388l;
        if (f5 == 0.0f) {
            return 1.0f;
        }
        float f6 = vPathRenderer.f16387k;
        if (f6 == 0.0f) {
            return 1.0f;
        }
        return Math.min(f6 / f2, f5 / f4);
    }

    public int getAlpha() {
        Drawable drawable = this.s;
        return drawable != null ? DrawableCompat.d(drawable) : this.X.f16392b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.s;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.X.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.s;
        return drawable != null ? DrawableCompat.e(drawable) : this.Z;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.s != null && Build.VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.s.getConstantState());
        }
        this.X.f16391a = getChangingConfigurations();
        return this.X;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.s;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.X.f16392b.f16386j;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.s;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.X.f16392b.f16385i;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.s;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* access modifiers changed from: package-private */
    public Object h(String str) {
        return this.X.f16392b.p.get(str);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.s;
        return drawable != null ? DrawableCompat.h(drawable) : this.X.f16395e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        r0 = r1.X.f16393c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = r1.X;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.s
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.isStateful()
            return r0
        L_0x0009:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r0 = r1.X
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.g()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r0 = r1.X
            android.content.res.ColorStateList r0 = r0.f16393c
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.isStateful():boolean");
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    /* access modifiers changed from: package-private */
    public void m(boolean z) {
        this.Y2 = z;
    }

    public Drawable mutate() {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.X2 && super.mutate() == this) {
            this.X = new VectorDrawableCompatState(this.X);
            this.X2 = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public PorterDuffColorFilter o(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.s;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.X;
        ColorStateList colorStateList = vectorDrawableCompatState.f16393c;
        if (colorStateList == null || (mode = vectorDrawableCompatState.f16394d) == null) {
            z = false;
        } else {
            this.Y = o(this.Y, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!vectorDrawableCompatState.g() || !vectorDrawableCompatState.h(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.X.f16392b.getRootAlpha() != i2) {
            this.X.f16392b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.j(drawable, z);
        } else {
            this.X.f16395e = z;
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f4) {
        super.setHotspot(f2, f4);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i4, int i5, int i6) {
        super.setHotspotBounds(i2, i4, i5, i6);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i2) {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.n(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.X;
        if (vectorDrawableCompatState.f16393c != colorStateList) {
            vectorDrawableCompatState.f16393c = colorStateList;
            this.Y = o(this.Y, colorStateList, vectorDrawableCompatState.f16394d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.p(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.X;
        if (vectorDrawableCompatState.f16394d != mode) {
            vectorDrawableCompatState.f16394d = mode;
            this.Y = o(this.Y, vectorDrawableCompatState.f16393c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.s;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    VectorDrawableCompat(@NonNull VectorDrawableCompatState vectorDrawableCompatState) {
        this.Y2 = true;
        this.a3 = new float[9];
        this.b3 = new Matrix();
        this.c3 = new Rect();
        this.X = vectorDrawableCompatState;
        this.Y = o(this.Y, vectorDrawableCompatState.f16393c, vectorDrawableCompatState.f16394d);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.X;
        vectorDrawableCompatState.f16392b = new VPathRenderer();
        TypedArray s = TypedArrayUtils.s(resources, theme, attributeSet, AndroidResources.f16312a);
        n(s, xmlPullParser, theme);
        s.recycle();
        vectorDrawableCompatState.f16391a = getChangingConfigurations();
        vectorDrawableCompatState.f16402l = true;
        i(resources, xmlPullParser, attributeSet, theme);
        this.Y = o(this.Y, vectorDrawableCompatState.f16393c, vectorDrawableCompatState.f16394d);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.Z = colorFilter;
        invalidateSelf();
    }
}
