package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

public class VerticalChainReference extends ChainReference {

    /* renamed from: androidx.constraintlayout.core.state.helpers.VerticalChainReference$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4159a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.state.State$Chain[] r0 = androidx.constraintlayout.core.state.State.Chain.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4159a = r0
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.SPREAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4159a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4159a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.state.State$Chain r1 = androidx.constraintlayout.core.state.State.Chain.PACKED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.helpers.VerticalChainReference.AnonymousClass1.<clinit>():void");
        }
    }

    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    public void apply() {
        ConstraintReference o;
        ConstraintReference C0;
        Iterator<Object> it2 = this.l0.iterator();
        while (it2.hasNext()) {
            this.j0.e(it2.next()).v();
        }
        Iterator<Object> it3 = this.l0.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it3.hasNext()) {
            ConstraintReference e2 = this.j0.e(it3.next());
            if (constraintReference2 == null) {
                Object obj = this.S;
                if (obj != null) {
                    C0 = e2.D0(obj);
                } else {
                    Object obj2 = this.T;
                    if (obj2 != null) {
                        C0 = e2.C0(obj2);
                    } else {
                        e2.D0(State.f4106j);
                        constraintReference2 = e2;
                    }
                }
                C0.b0(this.o).d0(this.u);
                constraintReference2 = e2;
            }
            if (constraintReference != null) {
                constraintReference.p(e2.getKey());
                e2.C0(constraintReference.getKey());
            }
            constraintReference = e2;
        }
        if (constraintReference != null) {
            Object obj3 = this.U;
            if (obj3 != null) {
                o = constraintReference.p(obj3);
            } else {
                Object obj4 = this.V;
                if (obj4 != null) {
                    o = constraintReference.o(obj4);
                } else {
                    constraintReference.o(State.f4106j);
                }
            }
            o.b0(this.p).d0(this.v);
        }
        if (constraintReference2 != null) {
            float f2 = this.n0;
            if (f2 != 0.5f) {
                constraintReference2.I0(f2);
            }
            int i2 = AnonymousClass1.f4159a[this.o0.ordinal()];
            if (i2 == 1) {
                constraintReference2.u0(0);
            } else if (i2 == 2) {
                constraintReference2.u0(1);
            } else if (i2 == 3) {
                constraintReference2.u0(2);
            }
        }
    }
}
