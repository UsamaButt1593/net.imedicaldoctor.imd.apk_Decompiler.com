package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

public class Optimizer {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4219a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f4220b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f4221c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f4222d = 4;

    /* renamed from: e  reason: collision with root package name */
    public static final int f4223e = 8;

    /* renamed from: f  reason: collision with root package name */
    public static final int f4224f = 16;

    /* renamed from: g  reason: collision with root package name */
    public static final int f4225g = 32;

    /* renamed from: h  reason: collision with root package name */
    public static final int f4226h = 64;

    /* renamed from: i  reason: collision with root package name */
    public static final int f4227i = 128;

    /* renamed from: j  reason: collision with root package name */
    public static final int f4228j = 256;

    /* renamed from: k  reason: collision with root package name */
    public static final int f4229k = 512;

    /* renamed from: l  reason: collision with root package name */
    public static final int f4230l = 1024;

    /* renamed from: m  reason: collision with root package name */
    public static final int f4231m = 257;

    /* renamed from: n  reason: collision with root package name */
    static boolean[] f4232n = new boolean[3];
    static final int o = 0;
    static final int p = 1;
    static final int q = 2;

    static void a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        constraintWidget.t = -1;
        constraintWidget.u = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.b0[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.b0[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.Q.f4184g;
            int m0 = constraintWidgetContainer.m0() - constraintWidget.S.f4184g;
            ConstraintAnchor constraintAnchor = constraintWidget.Q;
            constraintAnchor.f4186i = linearSystem.u(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.S;
            constraintAnchor2.f4186i = linearSystem.u(constraintAnchor2);
            linearSystem.f(constraintWidget.Q.f4186i, i2);
            linearSystem.f(constraintWidget.S.f4186i, m0);
            constraintWidget.t = 2;
            constraintWidget.C1(i2, m0);
        }
        if (constraintWidgetContainer.b0[1] != dimensionBehaviour2 && constraintWidget.b0[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i3 = constraintWidget.R.f4184g;
            int D = constraintWidgetContainer.D() - constraintWidget.T.f4184g;
            ConstraintAnchor constraintAnchor3 = constraintWidget.R;
            constraintAnchor3.f4186i = linearSystem.u(constraintAnchor3);
            ConstraintAnchor constraintAnchor4 = constraintWidget.T;
            constraintAnchor4.f4186i = linearSystem.u(constraintAnchor4);
            linearSystem.f(constraintWidget.R.f4186i, i3);
            linearSystem.f(constraintWidget.T.f4186i, D);
            if (constraintWidget.n0 > 0 || constraintWidget.l0() == 8) {
                ConstraintAnchor constraintAnchor5 = constraintWidget.U;
                constraintAnchor5.f4186i = linearSystem.u(constraintAnchor5);
                linearSystem.f(constraintWidget.U.f4186i, constraintWidget.n0 + i3);
            }
            constraintWidget.u = 2;
            constraintWidget.X1(i3, D);
        }
    }

    public static final boolean b(int i2, int i3) {
        return (i2 & i3) == i3;
    }
}
