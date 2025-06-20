package androidx.core.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 View.kt\nandroidx/core/view/ViewKt$doOnPreDraw$1\n*L\n1#1,414:1\n*E\n"})
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 8, 0}, xi = 176)
public final class ViewKt$doOnPreDraw$1 implements Runnable {
    final /* synthetic */ View X;
    final /* synthetic */ Function1<View, Unit> s;

    public ViewKt$doOnPreDraw$1(Function1<? super View, Unit> function1, View view) {
        this.s = function1;
        this.X = view;
    }

    public final void run() {
        this.s.f(this.X);
    }
}
