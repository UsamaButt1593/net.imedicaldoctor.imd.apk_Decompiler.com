package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintAnchor {

    /* renamed from: j  reason: collision with root package name */
    private static final boolean f4176j = false;

    /* renamed from: k  reason: collision with root package name */
    private static final int f4177k = Integer.MIN_VALUE;

    /* renamed from: a  reason: collision with root package name */
    private HashSet<ConstraintAnchor> f4178a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f4179b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4180c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintWidget f4181d;

    /* renamed from: e  reason: collision with root package name */
    public final Type f4182e;

    /* renamed from: f  reason: collision with root package name */
    public ConstraintAnchor f4183f;

    /* renamed from: g  reason: collision with root package name */
    public int f4184g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f4185h = Integer.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    SolverVariable f4186i;

    /* renamed from: androidx.constraintlayout.core.widgets.ConstraintAnchor$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4187a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4187a = r0
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4187a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4187a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4187a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4187a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f4187a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f4187a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f4187a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f4187a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintAnchor.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f4181d = constraintWidget;
        this.f4182e = type;
    }

    private boolean s(ConstraintWidget constraintWidget, HashSet<ConstraintWidget> hashSet) {
        if (hashSet.contains(constraintWidget)) {
            return false;
        }
        hashSet.add(constraintWidget);
        if (constraintWidget == i()) {
            return true;
        }
        ArrayList<ConstraintAnchor> s = constraintWidget.s();
        int size = s.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintAnchor constraintAnchor = s.get(i2);
            if (constraintAnchor.u(this) && constraintAnchor.p() && s(constraintAnchor.k().i(), hashSet)) {
                return true;
            }
        }
        return false;
    }

    public void A(int i2) {
        this.f4179b = i2;
        this.f4180c = true;
    }

    public void B(int i2) {
        if (p()) {
            this.f4185h = i2;
        }
    }

    public void C(int i2) {
        if (p()) {
            this.f4184g = i2;
        }
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i2) {
        return b(constraintAnchor, i2, Integer.MIN_VALUE, false);
    }

    public boolean b(ConstraintAnchor constraintAnchor, int i2, int i3, boolean z) {
        if (constraintAnchor == null) {
            x();
            return true;
        } else if (!z && !v(constraintAnchor)) {
            return false;
        } else {
            this.f4183f = constraintAnchor;
            if (constraintAnchor.f4178a == null) {
                constraintAnchor.f4178a = new HashSet<>();
            }
            HashSet<ConstraintAnchor> hashSet = this.f4183f.f4178a;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.f4184g = i2;
            this.f4185h = i3;
            return true;
        }
    }

    public void c(ConstraintAnchor constraintAnchor, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        ConstraintAnchor constraintAnchor2;
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor3 = this.f4183f;
        if (!(constraintAnchor3 == null || (hashSet = constraintAnchor3.f4178a) == null)) {
            hashSet.remove(this);
        }
        ConstraintAnchor constraintAnchor4 = constraintAnchor.f4183f;
        if (constraintAnchor4 != null) {
            constraintAnchor2 = hashMap.get(constraintAnchor.f4183f.f4181d).r(constraintAnchor4.l());
        } else {
            constraintAnchor2 = null;
        }
        this.f4183f = constraintAnchor2;
        ConstraintAnchor constraintAnchor5 = this.f4183f;
        if (constraintAnchor5 != null) {
            if (constraintAnchor5.f4178a == null) {
                constraintAnchor5.f4178a = new HashSet<>();
            }
            this.f4183f.f4178a.add(this);
        }
        this.f4184g = constraintAnchor.f4184g;
        this.f4185h = constraintAnchor.f4185h;
    }

    public void d(int i2, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        HashSet<ConstraintAnchor> hashSet = this.f4178a;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                Grouping.a(it2.next().f4181d, i2, arrayList, widgetGroup);
            }
        }
    }

    public HashSet<ConstraintAnchor> e() {
        return this.f4178a;
    }

    public int f() {
        if (!this.f4180c) {
            return 0;
        }
        return this.f4179b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r0 = r3.f4183f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int g() {
        /*
            r3 = this;
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r3.f4181d
            int r0 = r0.l0()
            r1 = 8
            if (r0 != r1) goto L_0x000c
            r0 = 0
            return r0
        L_0x000c:
            int r0 = r3.f4185h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r2) goto L_0x0021
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f4183f
            if (r0 == 0) goto L_0x0021
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.f4181d
            int r0 = r0.l0()
            if (r0 != r1) goto L_0x0021
            int r0 = r3.f4185h
            return r0
        L_0x0021:
            int r0 = r3.f4184g
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintAnchor.g():int");
    }

    public final ConstraintAnchor h() {
        switch (AnonymousClass1.f4187a[this.f4182e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f4181d.S;
            case 3:
                return this.f4181d.Q;
            case 4:
                return this.f4181d.T;
            case 5:
                return this.f4181d.R;
            default:
                throw new AssertionError(this.f4182e.name());
        }
    }

    public ConstraintWidget i() {
        return this.f4181d;
    }

    public SolverVariable j() {
        return this.f4186i;
    }

    public ConstraintAnchor k() {
        return this.f4183f;
    }

    public Type l() {
        return this.f4182e;
    }

    public boolean m() {
        HashSet<ConstraintAnchor> hashSet = this.f4178a;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            if (it2.next().h().p()) {
                return true;
            }
        }
        return false;
    }

    public boolean n() {
        HashSet<ConstraintAnchor> hashSet = this.f4178a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean o() {
        return this.f4180c;
    }

    public boolean p() {
        return this.f4183f != null;
    }

    public boolean q(ConstraintWidget constraintWidget) {
        if (s(constraintWidget, new HashSet())) {
            return false;
        }
        ConstraintWidget U = i().U();
        return U == constraintWidget || constraintWidget.U() == U;
    }

    public boolean r(ConstraintWidget constraintWidget, ConstraintAnchor constraintAnchor) {
        return q(constraintWidget);
    }

    public boolean t() {
        switch (AnonymousClass1.f4187a[this.f4182e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                throw new AssertionError(this.f4182e.name());
        }
    }

    public String toString() {
        return this.f4181d.y() + ":" + this.f4182e.toString();
    }

    public boolean u(ConstraintAnchor constraintAnchor) {
        Type l2 = constraintAnchor.l();
        Type type = this.f4182e;
        if (l2 == type) {
            return true;
        }
        switch (AnonymousClass1.f4187a[type.ordinal()]) {
            case 1:
                return l2 != Type.BASELINE;
            case 2:
            case 3:
            case 7:
                return l2 == Type.LEFT || l2 == Type.RIGHT || l2 == Type.CENTER_X;
            case 4:
            case 5:
            case 6:
            case 8:
                return l2 == Type.TOP || l2 == Type.BOTTOM || l2 == Type.CENTER_Y || l2 == Type.BASELINE;
            case 9:
                return false;
            default:
                throw new AssertionError(this.f4182e.name());
        }
    }

    public boolean v(ConstraintAnchor constraintAnchor) {
        boolean z = false;
        if (constraintAnchor == null) {
            return false;
        }
        Type l2 = constraintAnchor.l();
        Type type = this.f4182e;
        if (l2 == type) {
            return type != Type.BASELINE || (constraintAnchor.i().q0() && i().q0());
        }
        switch (AnonymousClass1.f4187a[type.ordinal()]) {
            case 1:
                return (l2 == Type.BASELINE || l2 == Type.CENTER_X || l2 == Type.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z2 = l2 == Type.LEFT || l2 == Type.RIGHT;
                if (!(constraintAnchor.i() instanceof Guideline)) {
                    return z2;
                }
                if (z2 || l2 == Type.CENTER_X) {
                    z = true;
                }
                return z;
            case 4:
            case 5:
                boolean z3 = l2 == Type.TOP || l2 == Type.BOTTOM;
                if (!(constraintAnchor.i() instanceof Guideline)) {
                    return z3;
                }
                if (z3 || l2 == Type.CENTER_Y) {
                    z = true;
                }
                return z;
            case 6:
                return (l2 == Type.LEFT || l2 == Type.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f4182e.name());
        }
    }

    public boolean w() {
        switch (AnonymousClass1.f4187a[this.f4182e.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 7:
                return false;
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
                return true;
            default:
                throw new AssertionError(this.f4182e.name());
        }
    }

    public void x() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.f4183f;
        if (!(constraintAnchor == null || (hashSet = constraintAnchor.f4178a) == null)) {
            hashSet.remove(this);
            if (this.f4183f.f4178a.size() == 0) {
                this.f4183f.f4178a = null;
            }
        }
        this.f4178a = null;
        this.f4183f = null;
        this.f4184g = 0;
        this.f4185h = Integer.MIN_VALUE;
        this.f4180c = false;
        this.f4179b = 0;
    }

    public void y() {
        this.f4180c = false;
        this.f4179b = 0;
    }

    public void z(Cache cache) {
        SolverVariable solverVariable = this.f4186i;
        if (solverVariable == null) {
            this.f4186i = new SolverVariable(SolverVariable.Type.UNRESTRICTED, (String) null);
        } else {
            solverVariable.i();
        }
    }
}
