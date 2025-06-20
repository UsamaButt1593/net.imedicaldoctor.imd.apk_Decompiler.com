package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt$addListener$listener$1\n*L\n1#1,76:1\n*E\n"})
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "Landroid/transition/Transition$TransitionListener;", "onTransitionCancel", "", "transition", "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 176)
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function1<Transition, Unit> f6284a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Function1<Transition, Unit> f6285b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function1<Transition, Unit> f6286c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Function1<Transition, Unit> f6287d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ Function1<Transition, Unit> f6288e;

    public TransitionKt$addListener$listener$1(Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function12, Function1<? super Transition, Unit> function13, Function1<? super Transition, Unit> function14, Function1<? super Transition, Unit> function15) {
        this.f6284a = function1;
        this.f6285b = function12;
        this.f6286c = function13;
        this.f6287d = function14;
        this.f6288e = function15;
    }

    public void onTransitionCancel(@NotNull Transition transition) {
        this.f6287d.f(transition);
    }

    public void onTransitionEnd(@NotNull Transition transition) {
        this.f6284a.f(transition);
    }

    public void onTransitionPause(@NotNull Transition transition) {
        this.f6286c.f(transition);
    }

    public void onTransitionResume(@NotNull Transition transition) {
        this.f6285b.f(transition);
    }

    public void onTransitionStart(@NotNull Transition transition) {
        this.f6288e.f(transition);
    }
}
