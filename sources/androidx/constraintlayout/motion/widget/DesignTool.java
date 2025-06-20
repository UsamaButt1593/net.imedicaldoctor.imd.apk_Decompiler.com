package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import java.io.PrintStream;
import java.util.HashMap;

public class DesignTool implements ProxyInterface {

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f4356g = false;

    /* renamed from: h  reason: collision with root package name */
    private static final String f4357h = "DesignTool";

    /* renamed from: i  reason: collision with root package name */
    static final HashMap<Pair<Integer, Integer>, String> f4358i;

    /* renamed from: j  reason: collision with root package name */
    static final HashMap<String, String> f4359j;

    /* renamed from: a  reason: collision with root package name */
    private final MotionLayout f4360a;

    /* renamed from: b  reason: collision with root package name */
    private MotionScene f4361b;

    /* renamed from: c  reason: collision with root package name */
    private String f4362c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f4363d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f4364e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f4365f = -1;

    static {
        HashMap<Pair<Integer, Integer>, String> hashMap = new HashMap<>();
        f4358i = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        f4359j = hashMap2;
        hashMap.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        hashMap.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        hashMap.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        hashMap.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        hashMap.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        hashMap.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        hashMap.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        hashMap.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        hashMap.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        hashMap.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        hashMap.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        hashMap.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        hashMap.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        hashMap2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        hashMap2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        hashMap2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        hashMap2.put("layout_constraintTop_toTopOf", "layout_marginTop");
        hashMap2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        hashMap2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        hashMap2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        hashMap2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        hashMap2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        hashMap2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        hashMap2.put("layout_constraintRight_toRightOf", "layout_marginRight");
        hashMap2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout motionLayout) {
        this.f4360a = motionLayout;
    }

    private static void j(int i2, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i3, int i4) {
        String str = f4358i.get(Pair.create(Integer.valueOf(i3), Integer.valueOf(i4)));
        String str2 = hashMap.get(str);
        if (str2 != null) {
            String str3 = f4359j.get(str);
            constraintSet.L(view.getId(), i3, Integer.parseInt(str2), i4, str3 != null ? k(i2, hashMap.get(str3)) : 0);
        }
    }

    private static int k(int i2, String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(100)) == -1) {
            return 0;
        }
        return (int) (((float) (Integer.valueOf(str.substring(0, indexOf)).intValue() * i2)) / 160.0f);
    }

    private static void l(int i2, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap) {
        String str = hashMap.get("layout_editor_absoluteX");
        if (str != null) {
            constraintSet.W0(view.getId(), k(i2, str));
        }
        String str2 = hashMap.get("layout_editor_absoluteY");
        if (str2 != null) {
            constraintSet.X0(view.getId(), k(i2, str2));
        }
    }

    private static void m(ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i2) {
        String str = hashMap.get(i2 == 1 ? "layout_constraintVertical_bias" : "layout_constraintHorizontal_bias");
        if (str == null) {
            return;
        }
        if (i2 == 0) {
            constraintSet.f1(view.getId(), Float.parseFloat(str));
        } else if (i2 == 1) {
            constraintSet.A1(view.getId(), Float.parseFloat(str));
        }
    }

    private static void n(int i2, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i3) {
        String str = hashMap.get(i3 == 1 ? "layout_height" : "layout_width");
        if (str != null) {
            int k2 = !str.equalsIgnoreCase("wrap_content") ? k(i2, str) : -2;
            int id = view.getId();
            if (i3 == 0) {
                constraintSet.W(id, k2);
            } else {
                constraintSet.P(id, k2);
            }
        }
    }

    public String A() {
        if (!(this.f4362c == null || this.f4363d == null)) {
            float y = y();
            if (y <= 0.01f) {
                return this.f4362c;
            }
            if (y >= 0.99f) {
                return this.f4363d;
            }
        }
        return this.f4362c;
    }

    public boolean B() {
        return (this.f4362c == null || this.f4363d == null) ? false : true;
    }

    public void C(Object obj, String str, Object obj2) {
        if (obj instanceof Key) {
            ((Key) obj).j(str, obj2);
            this.f4360a.T0();
            this.f4360a.W3 = true;
        }
    }

    public void D(String str) {
        if (str == null) {
            str = "motion_base";
        }
        if (this.f4362c != str) {
            this.f4362c = str;
            this.f4363d = null;
            MotionLayout motionLayout = this.f4360a;
            if (motionLayout.E3 == null) {
                motionLayout.E3 = this.f4361b;
            }
            int O0 = motionLayout.O0(str);
            this.f4364e = O0;
            if (O0 != 0) {
                if (O0 == this.f4360a.getStartState()) {
                    this.f4360a.setProgress(0.0f);
                } else {
                    if (O0 != this.f4360a.getEndState()) {
                        this.f4360a.g1(O0);
                    }
                    this.f4360a.setProgress(1.0f);
                }
            }
            this.f4360a.requestLayout();
        }
    }

    public void E(String str, String str2) {
        MotionLayout motionLayout = this.f4360a;
        if (motionLayout.E3 == null) {
            motionLayout.E3 = this.f4361b;
        }
        int O0 = motionLayout.O0(str);
        int O02 = this.f4360a.O0(str2);
        this.f4360a.Y0(O0, O02);
        this.f4364e = O0;
        this.f4365f = O02;
        this.f4362c = str;
        this.f4363d = str2;
    }

    public void F(Object obj, int i2) {
        MotionController motionController;
        if ((obj instanceof View) && (motionController = this.f4360a.O3.get(obj)) != null) {
            motionController.S(i2);
            this.f4360a.invalidate();
        }
    }

    public long a() {
        return this.f4360a.getTransitionTimeMs();
    }

    public int b(int i2, String str, Object obj, float[] fArr, int i3, float[] fArr2, int i4) {
        MotionController motionController;
        View view = (View) obj;
        if (i2 != 0) {
            MotionLayout motionLayout = this.f4360a;
            if (motionLayout.E3 == null || view == null || (motionController = motionLayout.O3.get(view)) == null) {
                return -1;
            }
        } else {
            motionController = null;
        }
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            int t = this.f4360a.E3.t() / 16;
            motionController.f(fArr2, t);
            return t;
        } else if (i2 == 2) {
            int t2 = this.f4360a.E3.t() / 16;
            motionController.e(fArr2, (int[]) null);
            return t2;
        } else if (i2 != 3) {
            return -1;
        } else {
            this.f4360a.E3.t();
            return motionController.l(str, fArr2, i4);
        }
    }

    public boolean c(Object obj, int i2, int i3, float f2, float f3) {
        if (!(obj instanceof View)) {
            return false;
        }
        MotionLayout motionLayout = this.f4360a;
        if (motionLayout.E3 != null) {
            MotionController motionController = motionLayout.O3.get(obj);
            MotionLayout motionLayout2 = this.f4360a;
            int i4 = (int) (motionLayout2.R3 * 100.0f);
            if (motionController != null) {
                View view = (View) obj;
                if (motionLayout2.E3.S(view, i4)) {
                    float y = motionController.y(2, f2, f3);
                    float y2 = motionController.y(5, f2, f3);
                    this.f4360a.E3.l0(view, i4, "motion:percentX", Float.valueOf(y));
                    this.f4360a.E3.l0(view, i4, "motion:percentY", Float.valueOf(y2));
                    this.f4360a.T0();
                    this.f4360a.u0(true);
                    this.f4360a.invalidate();
                    return true;
                }
            }
        }
        return false;
    }

    public void d(float f2) {
        MotionLayout motionLayout = this.f4360a;
        if (motionLayout.E3 == null) {
            motionLayout.E3 = this.f4361b;
        }
        motionLayout.setProgress(f2);
        this.f4360a.u0(true);
        this.f4360a.requestLayout();
        this.f4360a.invalidate();
    }

    public Boolean e(Object obj, Object obj2, float f2, float f3, String[] strArr, float[] fArr) {
        if (!(obj instanceof KeyPositionBase)) {
            return Boolean.FALSE;
        }
        View view = (View) obj2;
        this.f4360a.O3.get(view).N(view, (KeyPositionBase) obj, f2, f3, strArr, fArr);
        this.f4360a.T0();
        this.f4360a.W3 = true;
        return Boolean.TRUE;
    }

    public void f(Object obj, int i2, String str, Object obj2) {
        MotionScene motionScene = this.f4360a.E3;
        if (motionScene != null) {
            motionScene.l0((View) obj, i2, str, obj2);
            MotionLayout motionLayout = this.f4360a;
            motionLayout.U3 = ((float) i2) / 100.0f;
            motionLayout.S3 = 0.0f;
            motionLayout.T0();
            this.f4360a.u0(true);
        }
    }

    public void g(int i2, String str, Object obj, Object obj2) {
        View view = (View) obj;
        HashMap hashMap = (HashMap) obj2;
        int O0 = this.f4360a.O0(str);
        ConstraintSet o = this.f4360a.E3.o(O0);
        if (o != null) {
            o.E(view.getId());
            n(i2, o, view, hashMap, 0);
            n(i2, o, view, hashMap, 1);
            int i3 = i2;
            ConstraintSet constraintSet = o;
            View view2 = view;
            HashMap hashMap2 = hashMap;
            j(i3, constraintSet, view2, hashMap2, 6, 6);
            j(i3, constraintSet, view2, hashMap2, 6, 7);
            j(i3, constraintSet, view2, hashMap2, 7, 7);
            j(i3, constraintSet, view2, hashMap2, 7, 6);
            j(i3, constraintSet, view2, hashMap2, 1, 1);
            j(i3, constraintSet, view2, hashMap2, 1, 2);
            j(i3, constraintSet, view2, hashMap2, 2, 2);
            j(i3, constraintSet, view2, hashMap2, 2, 1);
            j(i3, constraintSet, view2, hashMap2, 3, 3);
            j(i3, constraintSet, view2, hashMap2, 3, 4);
            j(i3, constraintSet, view2, hashMap2, 4, 3);
            j(i3, constraintSet, view2, hashMap2, 4, 4);
            j(i3, constraintSet, view2, hashMap2, 5, 5);
            m(o, view, hashMap, 0);
            m(o, view, hashMap, 1);
            l(i2, o, view, hashMap);
            this.f4360a.l1(O0, o);
            this.f4360a.requestLayout();
        }
    }

    public float h(Object obj, int i2, float f2, float f3) {
        MotionController motionController;
        if ((obj instanceof View) && (motionController = this.f4360a.O3.get((View) obj)) != null) {
            return motionController.y(i2, f2, f3);
        }
        return 0.0f;
    }

    public Object i(Object obj, float f2, float f3) {
        MotionController motionController;
        View view = (View) obj;
        MotionLayout motionLayout = this.f4360a;
        if (motionLayout.E3 == null) {
            return -1;
        }
        if (view == null || (motionController = motionLayout.O3.get(view)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        return motionController.B(viewGroup.getWidth(), viewGroup.getHeight(), f2, f3);
    }

    public void o(boolean z) {
        this.f4360a.q0(z);
    }

    public void p(String str) {
        MotionLayout motionLayout = this.f4360a;
        if (motionLayout.E3 == null) {
            motionLayout.E3 = this.f4361b;
        }
        int O0 = motionLayout.O0(str);
        PrintStream printStream = System.out;
        printStream.println(" dumping  " + str + " (" + O0 + ")");
        try {
            this.f4360a.E3.o(O0).g0(this.f4360a.E3, new int[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int q(Object obj, float[] fArr) {
        MotionScene motionScene = this.f4360a.E3;
        if (motionScene == null) {
            return -1;
        }
        int t = motionScene.t() / 16;
        MotionController motionController = this.f4360a.O3.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.e(fArr, (int[]) null);
        return t;
    }

    public int r(Object obj, float[] fArr, int i2) {
        MotionLayout motionLayout = this.f4360a;
        if (motionLayout.E3 == null) {
            return -1;
        }
        MotionController motionController = motionLayout.O3.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.f(fArr, i2);
        return i2;
    }

    public void s(Object obj, float[] fArr) {
        MotionScene motionScene = this.f4360a.E3;
        if (motionScene != null) {
            int t = motionScene.t() / 16;
            MotionController motionController = this.f4360a.O3.get(obj);
            if (motionController != null) {
                motionController.h(fArr, t);
            }
        }
    }

    public String t() {
        int endState = this.f4360a.getEndState();
        if (this.f4365f == endState) {
            return this.f4363d;
        }
        String C0 = this.f4360a.C0(endState);
        if (C0 != null) {
            this.f4363d = C0;
            this.f4365f = endState;
        }
        return C0;
    }

    public int u(Object obj, int i2, int[] iArr) {
        MotionController motionController = this.f4360a.O3.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.x(i2, iArr);
    }

    public int v(Object obj, int[] iArr, float[] fArr) {
        MotionController motionController = this.f4360a.O3.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.z(iArr, fArr);
    }

    public Object w(int i2, int i3, int i4) {
        MotionLayout motionLayout = this.f4360a;
        MotionScene motionScene = motionLayout.E3;
        if (motionScene == null) {
            return null;
        }
        return motionScene.y(motionLayout.getContext(), i2, i3, i4);
    }

    public Object x(Object obj, int i2, int i3) {
        if (this.f4360a.E3 == null) {
            return null;
        }
        int id = ((View) obj).getId();
        MotionLayout motionLayout = this.f4360a;
        return motionLayout.E3.y(motionLayout.getContext(), i2, id, i3);
    }

    public float y() {
        return this.f4360a.getProgress();
    }

    public String z() {
        int startState = this.f4360a.getStartState();
        if (this.f4364e == startState) {
            return this.f4362c;
        }
        String C0 = this.f4360a.C0(startState);
        if (C0 != null) {
            this.f4362c = C0;
            this.f4364e = startState;
        }
        return this.f4360a.C0(startState);
    }
}
