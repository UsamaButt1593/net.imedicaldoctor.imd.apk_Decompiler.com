package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        u2();
    }

    private void u2() {
        p2(1);
        R1(new Fade(2)).R1(new ChangeBounds()).R1(new Fade(1));
    }

    public AutoTransition(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        u2();
    }
}
