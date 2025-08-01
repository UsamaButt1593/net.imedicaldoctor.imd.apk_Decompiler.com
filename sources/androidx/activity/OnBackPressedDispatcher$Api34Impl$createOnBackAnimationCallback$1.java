package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"androidx/activity/OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1", "Landroid/window/OnBackAnimationCallback;", "onBackCancelled", "", "onBackInvoked", "onBackProgressed", "backEvent", "Landroid/window/BackEvent;", "onBackStarted", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1 implements OnBackAnimationCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function1<BackEventCompat, Unit> f2447a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Function1<BackEventCompat, Unit> f2448b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function0<Unit> f2449c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Function0<Unit> f2450d;

    OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1(Function1<? super BackEventCompat, Unit> function1, Function1<? super BackEventCompat, Unit> function12, Function0<Unit> function0, Function0<Unit> function02) {
        this.f2447a = function1;
        this.f2448b = function12;
        this.f2449c = function0;
        this.f2450d = function02;
    }

    public void onBackCancelled() {
        this.f2450d.o();
    }

    public void onBackInvoked() {
        this.f2449c.o();
    }

    public void onBackProgressed(@NotNull BackEvent backEvent) {
        Intrinsics.p(backEvent, "backEvent");
        this.f2448b.f(new BackEventCompat(backEvent));
    }

    public void onBackStarted(@NotNull BackEvent backEvent) {
        Intrinsics.p(backEvent, "backEvent");
        this.f2447a.f(new BackEventCompat(backEvent));
    }
}
