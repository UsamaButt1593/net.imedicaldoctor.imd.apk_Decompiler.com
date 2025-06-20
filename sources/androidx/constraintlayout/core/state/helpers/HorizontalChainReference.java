package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

public class HorizontalChainReference extends ChainReference {

    /* renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4158a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.state.State$Chain[] r0 = androidx.constraintlayout.core.state.State.Chain.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4158a = r0
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.SPREAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4158a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4158a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.PACKED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.helpers.HorizontalChainReference.AnonymousClass1.<clinit>():void");
        }
    }

    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    public void apply() {
        ConstraintReference z;
        ConstraintReference b0;
        int i2;
        ConstraintReference z2;
        ConstraintReference z0;
        ConstraintReference b02;
        int i3;
        ConstraintReference z02;
        Iterator<Object> it2 = this.l0.iterator();
        while (it2.hasNext()) {
            this.j0.e(it2.next()).u();
        }
        Iterator<Object> it3 = this.l0.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it3.hasNext()) {
            ConstraintReference e2 = this.j0.e(it3.next());
            if (constraintReference2 == null) {
                Object obj = this.O;
                if (obj != null) {
                    z02 = e2.A0(obj);
                } else {
                    Object obj2 = this.P;
                    if (obj2 != null) {
                        z02 = e2.z0(obj2);
                    } else {
                        Object obj3 = this.K;
                        if (obj3 != null) {
                            z0 = e2.A0(obj3);
                        } else {
                            Object obj4 = this.L;
                            if (obj4 != null) {
                                z0 = e2.z0(obj4);
                            } else {
                                e2.A0(State.f4106j);
                                constraintReference2 = e2;
                            }
                        }
                        b02 = z0.b0(this.f4081k);
                        i3 = this.q;
                        b02.d0(i3);
                        constraintReference2 = e2;
                    }
                }
                b02 = z02.b0(this.f4083m);
                i3 = this.s;
                b02.d0(i3);
                constraintReference2 = e2;
            }
            if (constraintReference != null) {
                constraintReference.A(e2.getKey());
                e2.z0(constraintReference.getKey());
            }
            constraintReference = e2;
        }
        if (constraintReference != null) {
            Object obj5 = this.Q;
            if (obj5 != null) {
                z2 = constraintReference.A(obj5);
            } else {
                Object obj6 = this.R;
                if (obj6 != null) {
                    z2 = constraintReference.z(obj6);
                } else {
                    Object obj7 = this.M;
                    if (obj7 != null) {
                        z = constraintReference.A(obj7);
                    } else {
                        Object obj8 = this.N;
                        if (obj8 != null) {
                            z = constraintReference.z(obj8);
                        } else {
                            constraintReference.z(State.f4106j);
                        }
                    }
                    b0 = z.b0(this.f4082l);
                    i2 = this.r;
                    b0.d0(i2);
                }
            }
            b0 = z2.b0(this.f4084n);
            i2 = this.t;
            b0.d0(i2);
        }
        if (constraintReference2 != null) {
            float f2 = this.n0;
            if (f2 != 0.5f) {
                constraintReference2.X(f2);
            }
            int i4 = AnonymousClass1.f4158a[this.o0.ordinal()];
            if (i4 == 1) {
                constraintReference2.r0(0);
            } else if (i4 == 2) {
                constraintReference2.r0(1);
            } else if (i4 == 3) {
                constraintReference2.r0(2);
            }
        }
    }
}
