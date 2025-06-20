package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class Dimension {

    /* renamed from: i  reason: collision with root package name */
    public static final Object f4086i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public static final Object f4087j = new Object();

    /* renamed from: k  reason: collision with root package name */
    public static final Object f4088k = new Object();

    /* renamed from: l  reason: collision with root package name */
    public static final Object f4089l = new Object();

    /* renamed from: m  reason: collision with root package name */
    public static final Object f4090m = new Object();

    /* renamed from: n  reason: collision with root package name */
    public static final Object f4091n = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final int f4092a;

    /* renamed from: b  reason: collision with root package name */
    int f4093b;

    /* renamed from: c  reason: collision with root package name */
    int f4094c;

    /* renamed from: d  reason: collision with root package name */
    float f4095d;

    /* renamed from: e  reason: collision with root package name */
    int f4096e;

    /* renamed from: f  reason: collision with root package name */
    String f4097f;

    /* renamed from: g  reason: collision with root package name */
    Object f4098g;

    /* renamed from: h  reason: collision with root package name */
    boolean f4099h;

    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    private Dimension() {
        this.f4092a = -2;
        this.f4093b = 0;
        this.f4094c = Integer.MAX_VALUE;
        this.f4095d = 1.0f;
        this.f4096e = 0;
        this.f4097f = null;
        this.f4098g = f4087j;
        this.f4099h = false;
    }

    public static Dimension a(int i2) {
        Dimension dimension = new Dimension(f4086i);
        dimension.l(i2);
        return dimension;
    }

    public static Dimension b(Object obj) {
        Dimension dimension = new Dimension(f4086i);
        dimension.m(obj);
        return dimension;
    }

    public static Dimension c() {
        return new Dimension(f4089l);
    }

    public static Dimension d(Object obj, float f2) {
        Dimension dimension = new Dimension(f4090m);
        dimension.s(obj, f2);
        return dimension;
    }

    public static Dimension e(String str) {
        Dimension dimension = new Dimension(f4091n);
        dimension.t(str);
        return dimension;
    }

    public static Dimension f() {
        return new Dimension(f4088k);
    }

    public static Dimension g(int i2) {
        Dimension dimension = new Dimension();
        dimension.v(i2);
        return dimension;
    }

    public static Dimension h(Object obj) {
        Dimension dimension = new Dimension();
        dimension.w(obj);
        return dimension;
    }

    public static Dimension i() {
        return new Dimension(f4087j);
    }

    public void j(State state, ConstraintWidget constraintWidget, int i2) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        String str = this.f4097f;
        if (str != null) {
            constraintWidget.n1(str);
        }
        int i3 = 2;
        if (i2 == 0) {
            if (this.f4099h) {
                constraintWidget.D1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj = this.f4098g;
                if (obj == f4087j) {
                    i3 = 1;
                } else if (obj != f4090m) {
                    i3 = 0;
                }
                constraintWidget.E1(i3, this.f4093b, this.f4094c, this.f4095d);
                return;
            }
            int i4 = this.f4093b;
            if (i4 > 0) {
                constraintWidget.P1(i4);
            }
            int i5 = this.f4094c;
            if (i5 < Integer.MAX_VALUE) {
                constraintWidget.M1(i5);
            }
            Object obj2 = this.f4098g;
            if (obj2 == f4087j) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (obj2 == f4089l) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            } else if (obj2 == null) {
                constraintWidget.D1(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.c2(this.f4096e);
                return;
            } else {
                return;
            }
            constraintWidget.D1(dimensionBehaviour2);
        } else if (this.f4099h) {
            constraintWidget.Y1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            Object obj3 = this.f4098g;
            if (obj3 == f4087j) {
                i3 = 1;
            } else if (obj3 != f4090m) {
                i3 = 0;
            }
            constraintWidget.Z1(i3, this.f4093b, this.f4094c, this.f4095d);
        } else {
            int i6 = this.f4093b;
            if (i6 > 0) {
                constraintWidget.O1(i6);
            }
            int i7 = this.f4094c;
            if (i7 < Integer.MAX_VALUE) {
                constraintWidget.L1(i7);
            }
            Object obj4 = this.f4098g;
            if (obj4 == f4087j) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            } else if (obj4 == f4089l) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            } else if (obj4 == null) {
                constraintWidget.Y1(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.y1(this.f4096e);
                return;
            } else {
                return;
            }
            constraintWidget.Y1(dimensionBehaviour);
        }
    }

    public boolean k(int i2) {
        return this.f4098g == null && this.f4096e == i2;
    }

    public Dimension l(int i2) {
        this.f4098g = null;
        this.f4096e = i2;
        return this;
    }

    public Dimension m(Object obj) {
        this.f4098g = obj;
        if (obj instanceof Integer) {
            this.f4096e = ((Integer) obj).intValue();
            this.f4098g = null;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public int n() {
        return this.f4096e;
    }

    public Dimension o(int i2) {
        if (this.f4094c >= 0) {
            this.f4094c = i2;
        }
        return this;
    }

    public Dimension p(Object obj) {
        Object obj2 = f4087j;
        if (obj == obj2 && this.f4099h) {
            this.f4098g = obj2;
            this.f4094c = Integer.MAX_VALUE;
        }
        return this;
    }

    public Dimension q(int i2) {
        if (i2 >= 0) {
            this.f4093b = i2;
        }
        return this;
    }

    public Dimension r(Object obj) {
        if (obj == f4087j) {
            this.f4093b = -2;
        }
        return this;
    }

    public Dimension s(Object obj, float f2) {
        this.f4095d = f2;
        return this;
    }

    public Dimension t(String str) {
        this.f4097f = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void u(int i2) {
        this.f4099h = false;
        this.f4098g = null;
        this.f4096e = i2;
    }

    public Dimension v(int i2) {
        this.f4099h = true;
        if (i2 >= 0) {
            this.f4094c = i2;
        }
        return this;
    }

    public Dimension w(Object obj) {
        this.f4098g = obj;
        this.f4099h = true;
        return this;
    }

    private Dimension(Object obj) {
        this.f4092a = -2;
        this.f4093b = 0;
        this.f4094c = Integer.MAX_VALUE;
        this.f4095d = 1.0f;
        this.f4096e = 0;
        this.f4097f = null;
        this.f4099h = false;
        this.f4098g = obj;
    }
}
