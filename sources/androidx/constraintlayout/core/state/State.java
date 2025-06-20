package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.core.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.constraintlayout.core.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.core.state.helpers.VerticalChainReference;
import java.util.ArrayList;
import java.util.HashMap;

public class State {

    /* renamed from: f  reason: collision with root package name */
    static final int f4102f = -1;

    /* renamed from: g  reason: collision with root package name */
    static final int f4103g = 0;

    /* renamed from: h  reason: collision with root package name */
    static final int f4104h = 1;

    /* renamed from: i  reason: collision with root package name */
    static final int f4105i = 2;

    /* renamed from: j  reason: collision with root package name */
    public static final Integer f4106j = 0;

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<Object, Reference> f4107a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    protected HashMap<Object, HelperReference> f4108b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    HashMap<String, ArrayList<String>> f4109c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintReference f4110d;

    /* renamed from: e  reason: collision with root package name */
    private int f4111e;

    /* renamed from: androidx.constraintlayout.core.state.State$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4112a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.state.State$Helper[] r0 = androidx.constraintlayout.core.state.State.Helper.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4112a = r0
                androidx.constraintlayout.core.state.State$Helper r1 = androidx.constraintlayout.core.state.State.Helper.HORIZONTAL_CHAIN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4112a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.state.State$Helper r1 = androidx.constraintlayout.core.state.State.Helper.VERTICAL_CHAIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4112a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.state.State$Helper r1 = androidx.constraintlayout.core.state.State.Helper.ALIGN_HORIZONTALLY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4112a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.state.State$Helper r1 = androidx.constraintlayout.core.state.State.Helper.ALIGN_VERTICALLY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4112a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.state.State$Helper r1 = androidx.constraintlayout.core.state.State.Helper.BARRIER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.State.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Chain {
        SPREAD,
        SPREAD_INSIDE,
        PACKED
    }

    public enum Constraint {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BASELINE_TO_BASELINE,
        BASELINE_TO_TOP,
        BASELINE_TO_BOTTOM,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY,
        CIRCULAR_CONSTRAINT
    }

    public enum Direction {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM
    }

    public enum Helper {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        FLOW
    }

    public State() {
        ConstraintReference constraintReference = new ConstraintReference(this);
        this.f4110d = constraintReference;
        this.f4111e = 0;
        this.f4107a.put(f4106j, constraintReference);
    }

    private String h() {
        StringBuilder sb = new StringBuilder();
        sb.append("__HELPER_KEY_");
        int i2 = this.f4111e;
        this.f4111e = i2 + 1;
        sb.append(i2);
        sb.append("__");
        return sb.toString();
    }

    public GuidelineReference A(Object obj) {
        return k(obj, 1);
    }

    public State B(Dimension dimension) {
        return x(dimension);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0149, code lost:
        r1 = (androidx.constraintlayout.core.state.HelperReference) r0.d();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8) {
        /*
            r7 = this;
            r8.p2()
            androidx.constraintlayout.core.state.ConstraintReference r0 = r7.f4110d
            androidx.constraintlayout.core.state.Dimension r0 = r0.V()
            r1 = 0
            r0.j(r7, r8, r1)
            androidx.constraintlayout.core.state.ConstraintReference r0 = r7.f4110d
            androidx.constraintlayout.core.state.Dimension r0 = r0.D()
            r1 = 1
            r0.j(r7, r8, r1)
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r0 = r7.f4108b
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0021:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x004b
            java.lang.Object r1 = r0.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r2 = r7.f4108b
            java.lang.Object r2 = r2.get(r1)
            androidx.constraintlayout.core.state.HelperReference r2 = (androidx.constraintlayout.core.state.HelperReference) r2
            androidx.constraintlayout.core.widgets.HelperWidget r2 = r2.M0()
            if (r2 == 0) goto L_0x0021
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r3 = r7.f4107a
            java.lang.Object r3 = r3.get(r1)
            androidx.constraintlayout.core.state.Reference r3 = (androidx.constraintlayout.core.state.Reference) r3
            if (r3 != 0) goto L_0x0047
            androidx.constraintlayout.core.state.ConstraintReference r3 = r7.e(r1)
        L_0x0047:
            r3.b(r2)
            goto L_0x0021
        L_0x004b:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r0 = r7.f4107a
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0055:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0091
            java.lang.Object r1 = r0.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r2 = r7.f4107a
            java.lang.Object r2 = r2.get(r1)
            androidx.constraintlayout.core.state.Reference r2 = (androidx.constraintlayout.core.state.Reference) r2
            androidx.constraintlayout.core.state.ConstraintReference r3 = r7.f4110d
            if (r2 == r3) goto L_0x0055
            androidx.constraintlayout.core.state.helpers.Facade r3 = r2.d()
            boolean r3 = r3 instanceof androidx.constraintlayout.core.state.HelperReference
            if (r3 == 0) goto L_0x0055
            androidx.constraintlayout.core.state.helpers.Facade r2 = r2.d()
            androidx.constraintlayout.core.state.HelperReference r2 = (androidx.constraintlayout.core.state.HelperReference) r2
            androidx.constraintlayout.core.widgets.HelperWidget r2 = r2.M0()
            if (r2 == 0) goto L_0x0055
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r3 = r7.f4107a
            java.lang.Object r3 = r3.get(r1)
            androidx.constraintlayout.core.state.Reference r3 = (androidx.constraintlayout.core.state.Reference) r3
            if (r3 != 0) goto L_0x008d
            androidx.constraintlayout.core.state.ConstraintReference r3 = r7.e(r1)
        L_0x008d:
            r3.b(r2)
            goto L_0x0055
        L_0x0091:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r0 = r7.f4107a
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x009b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00d7
            java.lang.Object r1 = r0.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r2 = r7.f4107a
            java.lang.Object r1 = r2.get(r1)
            androidx.constraintlayout.core.state.Reference r1 = (androidx.constraintlayout.core.state.Reference) r1
            androidx.constraintlayout.core.state.ConstraintReference r2 = r7.f4110d
            if (r1 == r2) goto L_0x00d3
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r1.a()
            java.lang.Object r3 = r1.getKey()
            java.lang.String r3 = r3.toString()
            r2.j1(r3)
            r3 = 0
            r2.S1(r3)
            androidx.constraintlayout.core.state.helpers.Facade r3 = r1.d()
            boolean r3 = r3 instanceof androidx.constraintlayout.core.state.helpers.GuidelineReference
            if (r3 == 0) goto L_0x00cf
            r1.apply()
        L_0x00cf:
            r8.b(r2)
            goto L_0x009b
        L_0x00d3:
            r1.b(r8)
            goto L_0x009b
        L_0x00d7:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r8 = r7.f4108b
            java.util.Set r8 = r8.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x00e1:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0121
            java.lang.Object r0 = r8.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r1 = r7.f4108b
            java.lang.Object r0 = r1.get(r0)
            androidx.constraintlayout.core.state.HelperReference r0 = (androidx.constraintlayout.core.state.HelperReference) r0
            androidx.constraintlayout.core.widgets.HelperWidget r1 = r0.M0()
            if (r1 == 0) goto L_0x011d
            java.util.ArrayList<java.lang.Object> r1 = r0.l0
            java.util.Iterator r1 = r1.iterator()
        L_0x00ff:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x011d
            java.lang.Object r2 = r1.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r3 = r7.f4107a
            java.lang.Object r2 = r3.get(r2)
            androidx.constraintlayout.core.state.Reference r2 = (androidx.constraintlayout.core.state.Reference) r2
            androidx.constraintlayout.core.widgets.HelperWidget r3 = r0.M0()
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.a()
            r3.b(r2)
            goto L_0x00ff
        L_0x011d:
            r0.apply()
            goto L_0x00e1
        L_0x0121:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r8 = r7.f4107a
            java.util.Set r8 = r8.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x012b:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x019d
            java.lang.Object r0 = r8.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r1 = r7.f4107a
            java.lang.Object r0 = r1.get(r0)
            androidx.constraintlayout.core.state.Reference r0 = (androidx.constraintlayout.core.state.Reference) r0
            androidx.constraintlayout.core.state.ConstraintReference r1 = r7.f4110d
            if (r0 == r1) goto L_0x012b
            androidx.constraintlayout.core.state.helpers.Facade r1 = r0.d()
            boolean r1 = r1 instanceof androidx.constraintlayout.core.state.HelperReference
            if (r1 == 0) goto L_0x012b
            androidx.constraintlayout.core.state.helpers.Facade r1 = r0.d()
            androidx.constraintlayout.core.state.HelperReference r1 = (androidx.constraintlayout.core.state.HelperReference) r1
            androidx.constraintlayout.core.widgets.HelperWidget r2 = r1.M0()
            if (r2 == 0) goto L_0x012b
            java.util.ArrayList<java.lang.Object> r1 = r1.l0
            java.util.Iterator r1 = r1.iterator()
        L_0x015b:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0199
            java.lang.Object r3 = r1.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r4 = r7.f4107a
            java.lang.Object r4 = r4.get(r3)
            androidx.constraintlayout.core.state.Reference r4 = (androidx.constraintlayout.core.state.Reference) r4
            if (r4 == 0) goto L_0x0177
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r4.a()
        L_0x0173:
            r2.b(r3)
            goto L_0x015b
        L_0x0177:
            boolean r4 = r3 instanceof androidx.constraintlayout.core.state.Reference
            if (r4 == 0) goto L_0x0182
            androidx.constraintlayout.core.state.Reference r3 = (androidx.constraintlayout.core.state.Reference) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.a()
            goto L_0x0173
        L_0x0182:
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "couldn't find reference for "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4.println(r3)
            goto L_0x015b
        L_0x0199:
            r0.apply()
            goto L_0x012b
        L_0x019d:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r8 = r7.f4107a
            java.util.Set r8 = r8.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x01a7:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x01cb
            java.lang.Object r0 = r8.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r1 = r7.f4107a
            java.lang.Object r1 = r1.get(r0)
            androidx.constraintlayout.core.state.Reference r1 = (androidx.constraintlayout.core.state.Reference) r1
            r1.apply()
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.a()
            if (r1 == 0) goto L_0x01a7
            if (r0 == 0) goto L_0x01a7
            java.lang.String r0 = r0.toString()
            r1.o = r0
            goto L_0x01a7
        L_0x01cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.State.a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):void");
    }

    public BarrierReference b(Object obj, Direction direction) {
        ConstraintReference e2 = e(obj);
        if (e2.d() == null || !(e2.d() instanceof BarrierReference)) {
            BarrierReference barrierReference = new BarrierReference(this);
            barrierReference.P0(direction);
            e2.p0(barrierReference);
        }
        return (BarrierReference) e2.d();
    }

    public AlignHorizontallyReference c(Object... objArr) {
        AlignHorizontallyReference alignHorizontallyReference = (AlignHorizontallyReference) m((Object) null, Helper.ALIGN_HORIZONTALLY);
        alignHorizontallyReference.L0(objArr);
        return alignHorizontallyReference;
    }

    public AlignVerticallyReference d(Object... objArr) {
        AlignVerticallyReference alignVerticallyReference = (AlignVerticallyReference) m((Object) null, Helper.ALIGN_VERTICALLY);
        alignVerticallyReference.L0(objArr);
        return alignVerticallyReference;
    }

    public ConstraintReference e(Object obj) {
        Reference reference = this.f4107a.get(obj);
        if (reference == null) {
            reference = g(obj);
            this.f4107a.put(obj, reference);
            reference.c(obj);
        }
        if (reference instanceof ConstraintReference) {
            return (ConstraintReference) reference;
        }
        return null;
    }

    public int f(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).intValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public ConstraintReference g(Object obj) {
        return new ConstraintReference(this);
    }

    public void i() {
        for (Object next : this.f4107a.keySet()) {
            ConstraintReference e2 = e(next);
            if (e2 instanceof ConstraintReference) {
                e2.w0(next);
            }
        }
    }

    public ArrayList<String> j(String str) {
        if (this.f4109c.containsKey(str)) {
            return this.f4109c.get(str);
        }
        return null;
    }

    public GuidelineReference k(Object obj, int i2) {
        ConstraintReference e2 = e(obj);
        if (e2.d() == null || !(e2.d() instanceof GuidelineReference)) {
            GuidelineReference guidelineReference = new GuidelineReference(this);
            guidelineReference.h(i2);
            guidelineReference.c(obj);
            e2.p0(guidelineReference);
        }
        return (GuidelineReference) e2.d();
    }

    public State l(Dimension dimension) {
        return v(dimension);
    }

    public HelperReference m(Object obj, Helper helper) {
        HelperReference horizontalChainReference;
        if (obj == null) {
            obj = h();
        }
        HelperReference helperReference = this.f4108b.get(obj);
        if (helperReference == null) {
            int i2 = AnonymousClass1.f4112a[helper.ordinal()];
            if (i2 == 1) {
                horizontalChainReference = new HorizontalChainReference(this);
            } else if (i2 == 2) {
                horizontalChainReference = new VerticalChainReference(this);
            } else if (i2 == 3) {
                horizontalChainReference = new AlignHorizontallyReference(this);
            } else if (i2 == 4) {
                horizontalChainReference = new AlignVerticallyReference(this);
            } else if (i2 != 5) {
                helperReference = new HelperReference(this, helper);
                helperReference.c(obj);
                this.f4108b.put(obj, helperReference);
            } else {
                horizontalChainReference = new BarrierReference(this);
            }
            helperReference = horizontalChainReference;
            helperReference.c(obj);
            this.f4108b.put(obj, helperReference);
        }
        return helperReference;
    }

    public HorizontalChainReference n() {
        return (HorizontalChainReference) m((Object) null, Helper.HORIZONTAL_CHAIN);
    }

    public HorizontalChainReference o(Object... objArr) {
        HorizontalChainReference horizontalChainReference = (HorizontalChainReference) m((Object) null, Helper.HORIZONTAL_CHAIN);
        horizontalChainReference.L0(objArr);
        return horizontalChainReference;
    }

    public GuidelineReference p(Object obj) {
        return k(obj, 0);
    }

    public void q(Object obj, Object obj2) {
        ConstraintReference e2 = e(obj);
        if (e2 instanceof ConstraintReference) {
            e2.w0(obj2);
        }
    }

    /* access modifiers changed from: package-private */
    public Reference r(Object obj) {
        return this.f4107a.get(obj);
    }

    public void s() {
        this.f4108b.clear();
        this.f4109c.clear();
    }

    public boolean t(int i2) {
        return this.f4110d.D().k(i2);
    }

    public boolean u(int i2) {
        return this.f4110d.V().k(i2);
    }

    public State v(Dimension dimension) {
        this.f4110d.q0(dimension);
        return this;
    }

    public void w(String str, String str2) {
        ArrayList arrayList;
        ConstraintReference e2 = e(str);
        if (e2 instanceof ConstraintReference) {
            e2.t0(str2);
            if (!this.f4109c.containsKey(str2)) {
                arrayList = new ArrayList();
                this.f4109c.put(str2, arrayList);
            } else {
                arrayList = this.f4109c.get(str2);
            }
            arrayList.add(str);
        }
    }

    public State x(Dimension dimension) {
        this.f4110d.x0(dimension);
        return this;
    }

    public VerticalChainReference y() {
        return (VerticalChainReference) m((Object) null, Helper.VERTICAL_CHAIN);
    }

    public VerticalChainReference z(Object... objArr) {
        VerticalChainReference verticalChainReference = (VerticalChainReference) m((Object) null, Helper.VERTICAL_CHAIN);
        verticalChainReference.L0(objArr);
        return verticalChainReference;
    }
}
