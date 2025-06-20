package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a9\u0010\b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\b\u0010\t\u001a9\u0010\n\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\n\u0010\t\u001a9\u0010\u000b\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\u000b\u0010\t\u001a9\u0010\f\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\f\u0010\t\u001a9\u0010\r\u001a\u00020\u0007*\u00020\u00002#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\r\u0010\t\u001aÍ\u0001\u0010\u0013\u001a\u00020\u0007*\u00020\u00002#\b\u0006\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u00012#\b\u0006\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u00050\u0001H\b¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroid/transition/Transition;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", "action", "Landroid/transition/Transition$TransitionListener;", "d", "(Landroid/transition/Transition;Lkotlin/jvm/functions/Function1;)Landroid/transition/Transition$TransitionListener;", "g", "c", "f", "e", "onEnd", "onStart", "onCancel", "onResume", "onPause", "a", "(Landroid/transition/Transition;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroid/transition/Transition$TransitionListener;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n1#1,76:1\n59#1,16:77\n59#1,16:93\n59#1,16:109\n59#1,16:125\n59#1,16:141\n*S KotlinDebug\n*F\n+ 1 Transition.kt\nandroidx/core/transition/TransitionKt\n*L\n26#1:77,16\n33#1:93,16\n40#1:109,16\n47#1:125,16\n54#1:141,16\n*E\n"})
public final class TransitionKt {
    @NotNull
    public static final Transition.TransitionListener a(@NotNull Transition transition, @NotNull Function1<? super Transition, Unit> function1, @NotNull Function1<? super Transition, Unit> function12, @NotNull Function1<? super Transition, Unit> function13, @NotNull Function1<? super Transition, Unit> function14, @NotNull Function1<? super Transition, Unit> function15) {
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function14, function15, function13, function12);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener b(Transition transition, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function1 = TransitionKt$addListener$1.X;
        }
        if ((i2 & 2) != 0) {
            function12 = TransitionKt$addListener$2.X;
        }
        Function1 function16 = function12;
        if ((i2 & 4) != 0) {
            function13 = TransitionKt$addListener$3.X;
        }
        Function1 function17 = function13;
        if ((i2 & 8) != 0) {
            function14 = TransitionKt$addListener$4.X;
        }
        if ((i2 & 16) != 0) {
            function15 = TransitionKt$addListener$5.X;
        }
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function14, function15, function17, function16);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @NotNull
    public static final Transition.TransitionListener c(@NotNull Transition transition, @NotNull Function1<? super Transition, Unit> function1) {
        TransitionKt$doOnCancel$$inlined$addListener$default$1 transitionKt$doOnCancel$$inlined$addListener$default$1 = new TransitionKt$doOnCancel$$inlined$addListener$default$1(function1);
        transition.addListener(transitionKt$doOnCancel$$inlined$addListener$default$1);
        return transitionKt$doOnCancel$$inlined$addListener$default$1;
    }

    @NotNull
    public static final Transition.TransitionListener d(@NotNull Transition transition, @NotNull Function1<? super Transition, Unit> function1) {
        TransitionKt$doOnEnd$$inlined$addListener$default$1 transitionKt$doOnEnd$$inlined$addListener$default$1 = new TransitionKt$doOnEnd$$inlined$addListener$default$1(function1);
        transition.addListener(transitionKt$doOnEnd$$inlined$addListener$default$1);
        return transitionKt$doOnEnd$$inlined$addListener$default$1;
    }

    @NotNull
    public static final Transition.TransitionListener e(@NotNull Transition transition, @NotNull Function1<? super Transition, Unit> function1) {
        TransitionKt$doOnPause$$inlined$addListener$default$1 transitionKt$doOnPause$$inlined$addListener$default$1 = new TransitionKt$doOnPause$$inlined$addListener$default$1(function1);
        transition.addListener(transitionKt$doOnPause$$inlined$addListener$default$1);
        return transitionKt$doOnPause$$inlined$addListener$default$1;
    }

    @NotNull
    public static final Transition.TransitionListener f(@NotNull Transition transition, @NotNull Function1<? super Transition, Unit> function1) {
        TransitionKt$doOnResume$$inlined$addListener$default$1 transitionKt$doOnResume$$inlined$addListener$default$1 = new TransitionKt$doOnResume$$inlined$addListener$default$1(function1);
        transition.addListener(transitionKt$doOnResume$$inlined$addListener$default$1);
        return transitionKt$doOnResume$$inlined$addListener$default$1;
    }

    @NotNull
    public static final Transition.TransitionListener g(@NotNull Transition transition, @NotNull Function1<? super Transition, Unit> function1) {
        TransitionKt$doOnStart$$inlined$addListener$default$1 transitionKt$doOnStart$$inlined$addListener$default$1 = new TransitionKt$doOnStart$$inlined$addListener$default$1(function1);
        transition.addListener(transitionKt$doOnStart$$inlined$addListener$default$1);
        return transitionKt$doOnStart$$inlined$addListener$default$1;
    }
}
