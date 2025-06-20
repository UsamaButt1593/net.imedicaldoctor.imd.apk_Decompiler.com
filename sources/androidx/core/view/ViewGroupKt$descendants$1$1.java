package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "child", "", "b", "(Landroid/view/View;)Ljava/util/Iterator;"}, k = 3, mv = {1, 8, 0})
final class ViewGroupKt$descendants$1$1 extends Lambda implements Function1<View, Iterator<? extends View>> {
    public static final ViewGroupKt$descendants$1$1 X = new ViewGroupKt$descendants$1$1();

    ViewGroupKt$descendants$1$1() {
        super(1);
    }

    @Nullable
    /* renamed from: b */
    public final Iterator<View> f(@NotNull View view) {
        Sequence<View> e2;
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null || (e2 = ViewGroupKt.e(viewGroup)) == null) {
            return null;
        }
        return e2.iterator();
    }
}
