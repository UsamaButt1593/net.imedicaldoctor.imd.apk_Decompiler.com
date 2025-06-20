package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/core/animation/AnimatorKt$addPauseListener$listener$1", "Landroid/animation/Animator$AnimatorPauseListener;", "onAnimationPause", "", "animator", "Landroid/animation/Animator;", "onAnimationResume", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    final /* synthetic */ Function1<Animator, Unit> X;
    final /* synthetic */ Function1<Animator, Unit> s;

    AnimatorKt$addPauseListener$listener$1(Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function12) {
        this.s = function1;
        this.X = function12;
    }

    public void onAnimationPause(@NotNull Animator animator) {
        this.s.f(animator);
    }

    public void onAnimationResume(@NotNull Animator animator) {
        this.X.f(animator);
    }
}
