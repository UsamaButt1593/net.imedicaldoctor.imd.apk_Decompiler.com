package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.intrinsics.CancellableKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SelectBuilderImpl$onTimeout$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ Function1 X;
    final /* synthetic */ SelectBuilderImpl s;

    public SelectBuilderImpl$onTimeout$$inlined$Runnable$1(SelectBuilderImpl selectBuilderImpl, Function1 function1) {
        this.s = selectBuilderImpl;
        this.X = function1;
    }

    public final void run() {
        if (this.s.y()) {
            CancellableKt.d(this.X, this.s.J());
        }
    }
}
