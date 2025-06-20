package androidx.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;

public interface MotionHelperInterface extends Animatable, MotionLayout.TransitionListener {
    void b(MotionLayout motionLayout);

    boolean e();

    boolean f();

    void g(MotionLayout motionLayout, HashMap<View, MotionController> hashMap);

    void h(Canvas canvas);

    void i(Canvas canvas);

    boolean j();
}
