package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.a;
import androidx.constraintlayout.core.motion.utils.e;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Set;

public class MotionWidget implements TypedValues {
    public static final int A = 0;
    public static final int B = 0;
    public static final int C = -1;
    public static final int D = -1;
    public static final int E = -2;
    public static final int F = Integer.MIN_VALUE;
    public static final int G = 1;

    /* renamed from: m  reason: collision with root package name */
    public static final int f3683m = 0;

    /* renamed from: n  reason: collision with root package name */
    public static final int f3684n = 1;
    private static final int o = -1;
    private static final int p = -2;
    public static final int q = 0;
    public static final int r = 4;
    private static final int s = -3;
    private static final int t = -4;
    public static final int u = 0;
    public static final int v = 1;
    public static final int w = 2;
    public static final int x = 3;
    public static final int y = 4;
    public static final int z = -1;

    /* renamed from: h  reason: collision with root package name */
    WidgetFrame f3685h = new WidgetFrame();

    /* renamed from: i  reason: collision with root package name */
    Motion f3686i = new Motion();

    /* renamed from: j  reason: collision with root package name */
    PropertySet f3687j = new PropertySet();

    /* renamed from: k  reason: collision with root package name */
    private float f3688k;

    /* renamed from: l  reason: collision with root package name */
    float f3689l;

    public static class Motion {

        /* renamed from: n  reason: collision with root package name */
        private static final int f3690n = -2;
        private static final int o = -1;
        private static final int p = -3;

        /* renamed from: a  reason: collision with root package name */
        public int f3691a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f3692b = 0;

        /* renamed from: c  reason: collision with root package name */
        public String f3693c = null;

        /* renamed from: d  reason: collision with root package name */
        public int f3694d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f3695e = 0;

        /* renamed from: f  reason: collision with root package name */
        public float f3696f = Float.NaN;

        /* renamed from: g  reason: collision with root package name */
        public int f3697g = -1;

        /* renamed from: h  reason: collision with root package name */
        public float f3698h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public float f3699i = Float.NaN;

        /* renamed from: j  reason: collision with root package name */
        public int f3700j = -1;

        /* renamed from: k  reason: collision with root package name */
        public String f3701k = null;

        /* renamed from: l  reason: collision with root package name */
        public int f3702l = -3;

        /* renamed from: m  reason: collision with root package name */
        public int f3703m = -1;
    }

    public static class PropertySet {

        /* renamed from: a  reason: collision with root package name */
        public int f3704a = 4;

        /* renamed from: b  reason: collision with root package name */
        public int f3705b = 0;

        /* renamed from: c  reason: collision with root package name */
        public float f3706c = 1.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f3707d = Float.NaN;
    }

    public MotionWidget() {
    }

    public float A(int i2) {
        switch (i2) {
            case 303:
                return this.f3685h.p;
            case 304:
                return this.f3685h.f4145k;
            case 305:
                return this.f3685h.f4146l;
            case 306:
                return this.f3685h.f4147m;
            case 308:
                return this.f3685h.f4142h;
            case 309:
                return this.f3685h.f4143i;
            case 310:
                return this.f3685h.f4144j;
            case 311:
                return this.f3685h.f4148n;
            case 312:
                return this.f3685h.o;
            case 313:
                return this.f3685h.f4140f;
            case 314:
                return this.f3685h.f4141g;
            case 315:
                return this.f3688k;
            case 316:
                return this.f3689l;
            default:
                return Float.NaN;
        }
    }

    public int B() {
        return this.f3687j.f3704a;
    }

    public WidgetFrame C() {
        return this.f3685h;
    }

    public int D() {
        WidgetFrame widgetFrame = this.f3685h;
        return widgetFrame.f4138d - widgetFrame.f4136b;
    }

    public int E() {
        return this.f3685h.f4136b;
    }

    public int F() {
        return this.f3685h.f4137c;
    }

    public void G(int i2, int i3, int i4, int i5) {
        H(i2, i3, i4, i5);
    }

    public void H(int i2, int i3, int i4, int i5) {
        if (this.f3685h == null) {
            this.f3685h = new WidgetFrame((ConstraintWidget) null);
        }
        WidgetFrame widgetFrame = this.f3685h;
        widgetFrame.f4137c = i3;
        widgetFrame.f4136b = i2;
        widgetFrame.f4138d = i4;
        widgetFrame.f4139e = i5;
    }

    public void I(String str, int i2, float f2) {
        this.f3685h.v(str, i2, f2);
    }

    public void J(String str, int i2, int i3) {
        this.f3685h.w(str, i2, i3);
    }

    public void K(String str, int i2, String str2) {
        this.f3685h.x(str, i2, str2);
    }

    public void L(String str, int i2, boolean z2) {
        this.f3685h.y(str, i2, z2);
    }

    public void M(CustomAttribute customAttribute, float[] fArr) {
        this.f3685h.v(customAttribute.f3659b, TypedValues.Custom.f3958k, fArr[0]);
    }

    public void N(float f2) {
        this.f3685h.f4140f = f2;
    }

    public void O(float f2) {
        this.f3685h.f4141g = f2;
    }

    public void P(float f2) {
        this.f3685h.f4142h = f2;
    }

    public void Q(float f2) {
        this.f3685h.f4143i = f2;
    }

    public void R(float f2) {
        this.f3685h.f4144j = f2;
    }

    public void S(float f2) {
        this.f3685h.f4148n = f2;
    }

    public void T(float f2) {
        this.f3685h.o = f2;
    }

    public void U(float f2) {
        this.f3685h.f4145k = f2;
    }

    public void V(float f2) {
        this.f3685h.f4146l = f2;
    }

    public void W(float f2) {
        this.f3685h.f4147m = f2;
    }

    public boolean X(int i2, float f2) {
        switch (i2) {
            case 303:
                this.f3685h.p = f2;
                return true;
            case 304:
                this.f3685h.f4145k = f2;
                return true;
            case 305:
                this.f3685h.f4146l = f2;
                return true;
            case 306:
                this.f3685h.f4147m = f2;
                return true;
            case 308:
                this.f3685h.f4142h = f2;
                return true;
            case 309:
                this.f3685h.f4143i = f2;
                return true;
            case 310:
                this.f3685h.f4144j = f2;
                return true;
            case 311:
                this.f3685h.f4148n = f2;
                return true;
            case 312:
                this.f3685h.o = f2;
                return true;
            case 313:
                this.f3685h.f4140f = f2;
                return true;
            case 314:
                this.f3685h.f4141g = f2;
                return true;
            case 315:
                this.f3688k = f2;
                return true;
            case 316:
                this.f3689l = f2;
                return true;
            default:
                return false;
        }
    }

    public boolean Y(int i2, float f2) {
        switch (i2) {
            case 600:
                this.f3686i.f3696f = f2;
                return true;
            case 601:
                this.f3686i.f3698h = f2;
                return true;
            case TypedValues.MotionType.r /*602*/:
                this.f3686i.f3699i = f2;
                return true;
            default:
                return false;
        }
    }

    public boolean Z(int i2, int i3) {
        switch (i2) {
            case TypedValues.MotionType.u /*605*/:
                this.f3686i.f3691a = i3;
                return true;
            case TypedValues.MotionType.v /*606*/:
                this.f3686i.f3692b = i3;
                return true;
            case TypedValues.MotionType.w /*607*/:
                this.f3686i.f3694d = i3;
                return true;
            case TypedValues.MotionType.x /*608*/:
                this.f3686i.f3695e = i3;
                return true;
            case TypedValues.MotionType.y /*609*/:
                this.f3686i.f3697g = i3;
                return true;
            case TypedValues.MotionType.z /*610*/:
                this.f3686i.f3700j = i3;
                return true;
            case TypedValues.MotionType.A /*611*/:
                this.f3686i.f3702l = i3;
                return true;
            case TypedValues.MotionType.B /*612*/:
                this.f3686i.f3703m = i3;
                return true;
            default:
                return false;
        }
    }

    public boolean a(int i2, int i3) {
        return X(i2, (float) i3);
    }

    public boolean a0(int i2, String str) {
        if (i2 == 603) {
            this.f3686i.f3693c = str;
            return true;
        } else if (i2 != 604) {
            return false;
        } else {
            this.f3686i.f3701k = str;
            return true;
        }
    }

    public boolean b(int i2, float f2) {
        if (X(i2, f2)) {
            return true;
        }
        return Y(i2, f2);
    }

    public void b0(int i2) {
        this.f3687j.f3704a = i2;
    }

    public boolean c(int i2, String str) {
        return a0(i2, str);
    }

    public boolean d(int i2, boolean z2) {
        return false;
    }

    public int e(String str) {
        int a2 = a.a(str);
        return a2 != -1 ? a2 : e.a(str);
    }

    public MotionWidget f(int i2) {
        return null;
    }

    public float g() {
        return this.f3687j.f3706c;
    }

    public int h() {
        return this.f3685h.f4139e;
    }

    public CustomVariable i(String str) {
        return this.f3685h.g(str);
    }

    public Set<String> j() {
        return this.f3685h.h();
    }

    public int k() {
        WidgetFrame widgetFrame = this.f3685h;
        return widgetFrame.f4139e - widgetFrame.f4137c;
    }

    public int l() {
        return this.f3685h.f4136b;
    }

    public String m() {
        return this.f3685h.k();
    }

    public MotionWidget n() {
        return null;
    }

    public float o() {
        return this.f3685h.f4140f;
    }

    public float p() {
        return this.f3685h.f4141g;
    }

    public int q() {
        return this.f3685h.f4138d;
    }

    public float r() {
        return this.f3685h.f4142h;
    }

    public float s() {
        return this.f3685h.f4143i;
    }

    public float t() {
        return this.f3685h.f4144j;
    }

    public String toString() {
        return this.f3685h.f4136b + ", " + this.f3685h.f4137c + ", " + this.f3685h.f4138d + ", " + this.f3685h.f4139e;
    }

    public float u() {
        return this.f3685h.f4148n;
    }

    public float v() {
        return this.f3685h.o;
    }

    public int w() {
        return this.f3685h.f4137c;
    }

    public float x() {
        return this.f3685h.f4145k;
    }

    public float y() {
        return this.f3685h.f4146l;
    }

    public float z() {
        return this.f3685h.f4147m;
    }

    public MotionWidget(WidgetFrame widgetFrame) {
        this.f3685h = widgetFrame;
    }
}
