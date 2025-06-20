package kotlin.io;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "b", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 9, 0})
final class TextStreamsKt$readLines$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ArrayList<String> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextStreamsKt$readLines$1(ArrayList<String> arrayList) {
        super(1);
        this.X = arrayList;
    }

    public final void b(@NotNull String str) {
        Intrinsics.p(str, "it");
        this.X.add(str);
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        b((String) obj);
        return Unit.f28779a;
    }
}
