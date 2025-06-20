package androidx.constraintlayout.core;

public class GoalRow extends ArrayRow {
    public GoalRow(Cache cache) {
        super(cache);
    }

    public void f(SolverVariable solverVariable) {
        super.f(solverVariable);
        solverVariable.f3--;
    }
}
