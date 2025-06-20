package androidx.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"androidx/activity/OnBackPressedDispatcherKt$addCallback$callback$1", "Landroidx/activity/OnBackPressedCallback;", "", "d", "()V", "activity_release"}, k = 1, mv = {1, 8, 0})
public final class OnBackPressedDispatcherKt$addCallback$callback$1 extends OnBackPressedCallback {

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Function1<OnBackPressedCallback, Unit> f2451d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnBackPressedDispatcherKt$addCallback$callback$1(boolean z, Function1<? super OnBackPressedCallback, Unit> function1) {
        super(z);
        this.f2451d = function1;
    }

    public void d() {
        this.f2451d.f(this);
    }
}
