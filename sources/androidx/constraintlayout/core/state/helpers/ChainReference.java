package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;

public class ChainReference extends HelperReference {
    protected float n0 = 0.5f;
    protected State.Chain o0 = State.Chain.SPREAD;

    public ChainReference(State state, State.Helper helper) {
        super(state, helper);
    }

    /* renamed from: P0 */
    public ChainReference m(float f2) {
        this.n0 = f2;
        return this;
    }

    public float Q0() {
        return this.n0;
    }

    public State.Chain R0() {
        return State.Chain.SPREAD;
    }

    public ChainReference S0(State.Chain chain) {
        this.o0 = chain;
        return this;
    }
}
