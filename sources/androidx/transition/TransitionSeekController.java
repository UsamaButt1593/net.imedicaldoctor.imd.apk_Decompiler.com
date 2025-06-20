package androidx.transition;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

public interface TransitionSeekController {
    void a(@NonNull Consumer<TransitionSeekController> consumer);

    void c(@FloatRange(from = 0.0d, to = 1.0d) float f2);

    boolean d();

    @IntRange(from = 0)
    long e();

    void g(@IntRange(from = 0) long j2);

    void i(@NonNull Consumer<TransitionSeekController> consumer);

    void j(@NonNull Consumer<TransitionSeekController> consumer);

    void l();

    void n(@NonNull Consumer<TransitionSeekController> consumer);

    void o(@NonNull Runnable runnable);

    @FloatRange(from = 0.0d, to = 1.0d)
    float r();

    @IntRange(from = 0)
    long t();
}
