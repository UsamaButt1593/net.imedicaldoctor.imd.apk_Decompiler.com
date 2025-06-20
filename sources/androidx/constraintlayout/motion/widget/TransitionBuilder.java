package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;

public class TransitionBuilder {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4564a = "TransitionBuilder";

    public static MotionScene.Transition a(MotionScene motionScene, int i2, int i3, ConstraintSet constraintSet, int i4, ConstraintSet constraintSet2) {
        MotionScene.Transition transition = new MotionScene.Transition(i2, motionScene, i3, i4);
        b(motionScene, transition, constraintSet, constraintSet2);
        return transition;
    }

    private static void b(MotionScene motionScene, MotionScene.Transition transition, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
        int I = transition.I();
        int B = transition.B();
        motionScene.j0(I, constraintSet);
        motionScene.j0(B, constraintSet2);
    }

    public static void c(MotionLayout motionLayout) {
        MotionScene motionScene = motionLayout.E3;
        if (motionScene == null) {
            throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
        } else if (!motionScene.s0(motionLayout)) {
            throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
        } else if (motionScene.f4509c == null || motionScene.s().isEmpty()) {
            throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
        }
    }
}
