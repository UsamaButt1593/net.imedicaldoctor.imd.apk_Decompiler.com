package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.HelperWidget;

public class BarrierReference extends HelperReference {
    private State.Direction n0;
    private int o0;
    private Barrier p0;

    /* renamed from: androidx.constraintlayout.core.state.helpers.BarrierReference$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4150a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.core.state.State$Direction[] r0 = androidx.constraintlayout.core.state.State.Direction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4150a = r0
                androidx.constraintlayout.core.state.State$Direction r1 = androidx.constraintlayout.core.state.State.Direction.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4150a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.state.State$Direction r1 = androidx.constraintlayout.core.state.State.Direction.START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4150a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.state.State$Direction r1 = androidx.constraintlayout.core.state.State.Direction.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4150a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.state.State$Direction r1 = androidx.constraintlayout.core.state.State.Direction.END     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4150a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.core.state.State$Direction r1 = androidx.constraintlayout.core.state.State.Direction.TOP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f4150a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.core.state.State$Direction r1 = androidx.constraintlayout.core.state.State.Direction.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.helpers.BarrierReference.AnonymousClass1.<clinit>():void");
        }
    }

    public BarrierReference(State state) {
        super(state, State.Helper.BARRIER);
    }

    public HelperWidget M0() {
        if (this.p0 == null) {
            this.p0 = new Barrier();
        }
        return this.p0;
    }

    public void P0(State.Direction direction) {
        this.n0 = direction;
    }

    public void apply() {
        M0();
        int i2 = AnonymousClass1.f4150a[this.n0.ordinal()];
        int i3 = 3;
        if (i2 == 3 || i2 == 4) {
            i3 = 1;
        } else if (i2 == 5) {
            i3 = 2;
        } else if (i2 != 6) {
            i3 = 0;
        }
        this.p0.u2(i3);
        this.p0.v2(this.o0);
    }

    public ConstraintReference b0(int i2) {
        this.o0 = i2;
        return this;
    }

    public ConstraintReference c0(Object obj) {
        b0(this.j0.f(obj));
        return this;
    }
}
