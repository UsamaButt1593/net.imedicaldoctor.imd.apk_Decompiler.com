package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Collections;

public class HelperReference extends ConstraintReference implements Facade {
    protected final State j0;
    final State.Helper k0;
    protected ArrayList<Object> l0 = new ArrayList<>();
    private HelperWidget m0;

    public HelperReference(State state, State.Helper helper) {
        super(state);
        this.j0 = state;
        this.k0 = helper;
    }

    public HelperReference L0(Object... objArr) {
        Collections.addAll(this.l0, objArr);
        return this;
    }

    public HelperWidget M0() {
        return this.m0;
    }

    public State.Helper N0() {
        return this.k0;
    }

    public void O0(HelperWidget helperWidget) {
        this.m0 = helperWidget;
    }

    public ConstraintWidget a() {
        return M0();
    }

    public void apply() {
    }
}
