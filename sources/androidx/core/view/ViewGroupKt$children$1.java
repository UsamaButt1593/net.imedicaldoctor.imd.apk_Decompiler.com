package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"androidx/core/view/ViewGroupKt$children$1", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "iterator", "", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ViewGroupKt$children$1 implements Sequence<View> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f6524a;

    ViewGroupKt$children$1(ViewGroup viewGroup) {
        this.f6524a = viewGroup;
    }

    @NotNull
    public Iterator<View> iterator() {
        return ViewGroupKt.k(this.f6524a);
    }
}
