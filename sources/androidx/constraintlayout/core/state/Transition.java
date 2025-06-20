package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.HashMap;

public class Transition implements TypedValues {
    private static final int A = -1;
    private static final int B = -2;
    public static final int q = 0;
    public static final int r = 1;
    public static final int s = 2;
    static final int t = 0;
    static final int u = 1;
    static final int v = 2;
    static final int w = 3;
    static final int x = 4;
    static final int y = 5;
    static final int z = 6;

    /* renamed from: h  reason: collision with root package name */
    HashMap<Integer, HashMap<String, KeyPosition>> f4113h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private HashMap<String, WidgetState> f4114i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    TypedBundle f4115j = new TypedBundle();

    /* renamed from: k  reason: collision with root package name */
    private int f4116k = 0;

    /* renamed from: l  reason: collision with root package name */
    private String f4117l = null;

    /* renamed from: m  reason: collision with root package name */
    private Easing f4118m = null;

    /* renamed from: n  reason: collision with root package name */
    private int f4119n = 0;
    private int o = 400;
    private float p = 0.0f;

    static class KeyPosition {

        /* renamed from: a  reason: collision with root package name */
        int f4120a;

        /* renamed from: b  reason: collision with root package name */
        String f4121b;

        /* renamed from: c  reason: collision with root package name */
        int f4122c;

        /* renamed from: d  reason: collision with root package name */
        float f4123d;

        /* renamed from: e  reason: collision with root package name */
        float f4124e;

        public KeyPosition(String str, int i2, int i3, float f2, float f3) {
            this.f4121b = str;
            this.f4120a = i2;
            this.f4122c = i3;
            this.f4123d = f2;
            this.f4124e = f3;
        }
    }

    static class WidgetState {

        /* renamed from: a  reason: collision with root package name */
        WidgetFrame f4125a = new WidgetFrame();

        /* renamed from: b  reason: collision with root package name */
        WidgetFrame f4126b = new WidgetFrame();

        /* renamed from: c  reason: collision with root package name */
        WidgetFrame f4127c = new WidgetFrame();

        /* renamed from: d  reason: collision with root package name */
        Motion f4128d;

        /* renamed from: e  reason: collision with root package name */
        MotionWidget f4129e = new MotionWidget(this.f4125a);

        /* renamed from: f  reason: collision with root package name */
        MotionWidget f4130f = new MotionWidget(this.f4126b);

        /* renamed from: g  reason: collision with root package name */
        MotionWidget f4131g = new MotionWidget(this.f4127c);

        /* renamed from: h  reason: collision with root package name */
        KeyCache f4132h = new KeyCache();

        /* renamed from: i  reason: collision with root package name */
        int f4133i = -1;

        /* renamed from: j  reason: collision with root package name */
        int f4134j = -1;

        public WidgetState() {
            Motion motion = new Motion(this.f4129e);
            this.f4128d = motion;
            motion.Z(this.f4129e);
            this.f4128d.X(this.f4130f);
        }

        public WidgetFrame a(int i2) {
            if (i2 == 0) {
                return this.f4125a;
            }
            return i2 == 1 ? this.f4126b : this.f4127c;
        }

        public void b(int i2, int i3, float f2, Transition transition) {
            this.f4133i = i3;
            this.f4134j = i2;
            this.f4128d.d0(i2, i3, 1.0f, System.nanoTime());
            WidgetFrame.n(i2, i3, this.f4127c, this.f4125a, this.f4126b, transition, f2);
            this.f4127c.q = f2;
            this.f4128d.Q(this.f4131g, f2, System.nanoTime(), this.f4132h);
        }

        public void c(TypedBundle typedBundle) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.g(motionKeyAttributes);
            this.f4128d.f(motionKeyAttributes);
        }

        public void d(TypedBundle typedBundle) {
            MotionKeyCycle motionKeyCycle = new MotionKeyCycle();
            typedBundle.g(motionKeyCycle);
            this.f4128d.f(motionKeyCycle);
        }

        public void e(TypedBundle typedBundle) {
            MotionKeyPosition motionKeyPosition = new MotionKeyPosition();
            typedBundle.g(motionKeyPosition);
            this.f4128d.f(motionKeyPosition);
        }

        public void f(ConstraintWidget constraintWidget, int i2) {
            if (i2 == 0) {
                this.f4125a.C(constraintWidget);
                this.f4128d.Z(this.f4129e);
            } else if (i2 == 1) {
                this.f4126b.C(constraintWidget);
                this.f4128d.X(this.f4130f);
            }
            this.f4134j = -1;
        }
    }

    public static Interpolator E(int i2, String str) {
        switch (i2) {
            case -1:
                return new a(str);
            case 0:
                return new b();
            case 1:
                return new c();
            case 2:
                return new d();
            case 3:
                return new e();
            case 4:
                return new h();
            case 5:
                return new g();
            case 6:
                return new f();
            default:
                return null;
        }
    }

    private WidgetState L(String str) {
        return this.f4114i.get(str);
    }

    private WidgetState M(String str, ConstraintWidget constraintWidget, int i2) {
        WidgetState widgetState = this.f4114i.get(str);
        if (widgetState == null) {
            widgetState = new WidgetState();
            this.f4115j.g(widgetState.f4128d);
            this.f4114i.put(str, widgetState);
            if (constraintWidget != null) {
                widgetState.f(constraintWidget, i2);
            }
        }
        return widgetState;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float Q(String str, float f2) {
        return (float) Easing.c(str).a((double) f2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float R(float f2) {
        return (float) Easing.c("standard").a((double) f2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float S(float f2) {
        return (float) Easing.c("accelerate").a((double) f2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float T(float f2) {
        return (float) Easing.c("decelerate").a((double) f2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float U(float f2) {
        return (float) Easing.c("linear").a((double) f2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float V(float f2) {
        return (float) Easing.c("anticipate").a((double) f2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float W(float f2) {
        return (float) Easing.c("overshoot").a((double) f2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ float X(float f2) {
        return (float) Easing.c("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").a((double) f2);
    }

    public WidgetFrame A(String str) {
        WidgetState widgetState = this.f4114i.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f4126b;
    }

    public WidgetFrame B(ConstraintWidget constraintWidget) {
        return M(constraintWidget.o, (ConstraintWidget) null, 2).f4127c;
    }

    public WidgetFrame C(String str) {
        WidgetState widgetState = this.f4114i.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f4127c;
    }

    public Interpolator D() {
        return E(this.f4116k, this.f4117l);
    }

    public int F(String str, float[] fArr, int[] iArr, int[] iArr2) {
        return this.f4114i.get(str).f4128d.j(fArr, iArr, iArr2);
    }

    public Motion G(String str) {
        return M(str, (ConstraintWidget) null, 0).f4128d;
    }

    public int H(WidgetFrame widgetFrame) {
        int i2 = 0;
        for (int i3 = 0; i3 <= 100; i3++) {
            HashMap hashMap = this.f4113h.get(Integer.valueOf(i3));
            if (!(hashMap == null || ((KeyPosition) hashMap.get(widgetFrame.f4135a.o)) == null)) {
                i2++;
            }
        }
        return i2;
    }

    public float[] I(String str) {
        float[] fArr = new float[124];
        this.f4114i.get(str).f4128d.k(fArr, 62);
        return fArr;
    }

    public WidgetFrame J(ConstraintWidget constraintWidget) {
        return M(constraintWidget.o, (ConstraintWidget) null, 0).f4125a;
    }

    public WidgetFrame K(String str) {
        WidgetState widgetState = this.f4114i.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f4125a;
    }

    public boolean N() {
        return this.f4113h.size() > 0;
    }

    public void O(int i2, int i3, float f2) {
        Easing easing = this.f4118m;
        if (easing != null) {
            f2 = (float) easing.a((double) f2);
        }
        for (String str : this.f4114i.keySet()) {
            this.f4114i.get(str).b(i2, i3, f2, this);
        }
    }

    public boolean P() {
        return this.f4114i.isEmpty();
    }

    public void Y(TypedBundle typedBundle) {
        typedBundle.f(this.f4115j);
        typedBundle.g(this);
    }

    public void Z(ConstraintWidgetContainer constraintWidgetContainer, int i2) {
        ArrayList<ConstraintWidget> l2 = constraintWidgetContainer.l2();
        int size = l2.size();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = l2.get(i3);
            M(constraintWidget.o, (ConstraintWidget) null, i2).f(constraintWidget, i2);
        }
    }

    public boolean a(int i2, int i3) {
        return false;
    }

    public boolean b(int i2, float f2) {
        if (i2 != 706) {
            return false;
        }
        this.p = f2;
        return false;
    }

    public boolean c(int i2, String str) {
        if (i2 != 705) {
            return false;
        }
        this.f4117l = str;
        this.f4118m = Easing.c(str);
        return false;
    }

    public boolean d(int i2, boolean z2) {
        return false;
    }

    public int e(String str) {
        return 0;
    }

    public void n(int i2, String str, String str2, int i3) {
        M(str, (ConstraintWidget) null, i2).a(i2).c(str2, i3);
    }

    public void o(int i2, String str, String str2, float f2) {
        M(str, (ConstraintWidget) null, i2).a(i2).d(str2, f2);
    }

    public void p(String str, TypedBundle typedBundle) {
        M(str, (ConstraintWidget) null, 0).c(typedBundle);
    }

    public void q(String str, TypedBundle typedBundle) {
        M(str, (ConstraintWidget) null, 0).d(typedBundle);
    }

    public void r(String str, int i2, int i3, float f2, float f3) {
        TypedBundle typedBundle = new TypedBundle();
        typedBundle.b(TypedValues.PositionType.r, 2);
        typedBundle.b(100, i2);
        typedBundle.a(TypedValues.PositionType.f4023n, f2);
        typedBundle.a(507, f3);
        M(str, (ConstraintWidget) null, 0).e(typedBundle);
        KeyPosition keyPosition = new KeyPosition(str, i2, i3, f2, f3);
        HashMap hashMap = this.f4113h.get(Integer.valueOf(i2));
        if (hashMap == null) {
            hashMap = new HashMap();
            this.f4113h.put(Integer.valueOf(i2), hashMap);
        }
        hashMap.put(str, keyPosition);
    }

    public void s(String str, TypedBundle typedBundle) {
        M(str, (ConstraintWidget) null, 0).e(typedBundle);
    }

    public void t() {
        this.f4114i.clear();
    }

    public boolean u(String str) {
        return this.f4114i.containsKey(str);
    }

    public void v(WidgetFrame widgetFrame, float[] fArr, float[] fArr2, float[] fArr3) {
        KeyPosition keyPosition;
        int i2 = 0;
        for (int i3 = 0; i3 <= 100; i3++) {
            HashMap hashMap = this.f4113h.get(Integer.valueOf(i3));
            if (!(hashMap == null || (keyPosition = (KeyPosition) hashMap.get(widgetFrame.f4135a.o)) == null)) {
                fArr[i2] = keyPosition.f4123d;
                fArr2[i2] = keyPosition.f4124e;
                fArr3[i2] = (float) keyPosition.f4120a;
                i2++;
            }
        }
    }

    public KeyPosition w(String str, int i2) {
        KeyPosition keyPosition;
        while (i2 <= 100) {
            HashMap hashMap = this.f4113h.get(Integer.valueOf(i2));
            if (hashMap != null && (keyPosition = (KeyPosition) hashMap.get(str)) != null) {
                return keyPosition;
            }
            i2++;
        }
        return null;
    }

    public KeyPosition x(String str, int i2) {
        KeyPosition keyPosition;
        while (i2 >= 0) {
            HashMap hashMap = this.f4113h.get(Integer.valueOf(i2));
            if (hashMap != null && (keyPosition = (KeyPosition) hashMap.get(str)) != null) {
                return keyPosition;
            }
            i2--;
        }
        return null;
    }

    public int y() {
        return this.f4119n;
    }

    public WidgetFrame z(ConstraintWidget constraintWidget) {
        return M(constraintWidget.o, (ConstraintWidget) null, 1).f4126b;
    }
}
