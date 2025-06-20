package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0004\b\r\u0010\f\u001a\u0014\u0010\u000e\u001a\u00020\u0007*\u00020\u0000H\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0007*\u00020\u0000H\b¢\u0006\u0004\b\u0010\u0010\u000f\u001a7\u0010\u0015\u001a\u00020\n*\u00020\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\u0011H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001aL\u0010\u0018\u001a\u00020\n*\u00020\u000026\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\u0017H\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a*\u00020\u0000H\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001e\u0010\u001f\u001a\u00020\n*\u00020\u001d2\b\b\u0001\u0010\u001e\u001a\u00020\u0001H\b¢\u0006\u0004\b\u001f\u0010 \u001a<\u0010%\u001a\u00020\n*\u00020\u001d2\b\b\u0003\u0010!\u001a\u00020\u00012\b\b\u0003\u0010\"\u001a\u00020\u00012\b\b\u0003\u0010#\u001a\u00020\u00012\b\b\u0003\u0010$\u001a\u00020\u0001H\b¢\u0006\u0004\b%\u0010&\u001a<\u0010)\u001a\u00020\n*\u00020\u001d2\b\b\u0003\u0010'\u001a\u00020\u00012\b\b\u0003\u0010\"\u001a\u00020\u00012\b\b\u0003\u0010(\u001a\u00020\u00012\b\b\u0003\u0010$\u001a\u00020\u0001H\b¢\u0006\u0004\b)\u0010&\"\u0016\u0010\u001e\u001a\u00020\u0001*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0016\u0010/\u001a\u00020,*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u001b\u00103\u001a\b\u0012\u0004\u0012\u00020\u000300*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b1\u00102\"\u001b\u00105\u001a\b\u0012\u0004\u0012\u00020\u000300*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b4\u00102¨\u00066"}, d2 = {"Landroid/view/ViewGroup;", "", "index", "Landroid/view/View;", "d", "(Landroid/view/ViewGroup;I)Landroid/view/View;", "view", "", "a", "(Landroid/view/ViewGroup;Landroid/view/View;)Z", "", "m", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "l", "i", "(Landroid/view/ViewGroup;)Z", "j", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "action", "b", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "c", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;)V", "", "k", "(Landroid/view/ViewGroup;)Ljava/util/Iterator;", "Landroid/view/ViewGroup$MarginLayoutParams;", "size", "n", "(Landroid/view/ViewGroup$MarginLayoutParams;I)V", "left", "top", "right", "bottom", "o", "(Landroid/view/ViewGroup$MarginLayoutParams;IIII)V", "start", "end", "q", "h", "(Landroid/view/ViewGroup;)I", "Lkotlin/ranges/IntRange;", "g", "(Landroid/view/ViewGroup;)Lkotlin/ranges/IntRange;", "indices", "Lkotlin/sequences/Sequence;", "e", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "children", "f", "descendants", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class ViewGroupKt {
    public static final boolean a(@NotNull ViewGroup viewGroup, @NotNull View view) {
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void b(@NotNull ViewGroup viewGroup, @NotNull Function1<? super View, Unit> function1) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            function1.f(viewGroup.getChildAt(i2));
        }
    }

    public static final void c(@NotNull ViewGroup viewGroup, @NotNull Function2<? super Integer, ? super View, Unit> function2) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            function2.d0(Integer.valueOf(i2), viewGroup.getChildAt(i2));
        }
    }

    @NotNull
    public static final View d(@NotNull ViewGroup viewGroup, int i2) {
        View childAt = viewGroup.getChildAt(i2);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + viewGroup.getChildCount());
    }

    @NotNull
    public static final Sequence<View> e(@NotNull ViewGroup viewGroup) {
        return new ViewGroupKt$children$1(viewGroup);
    }

    @NotNull
    public static final Sequence<View> f(@NotNull ViewGroup viewGroup) {
        return new ViewGroupKt$special$$inlined$Sequence$1(viewGroup);
    }

    @NotNull
    public static final IntRange g(@NotNull ViewGroup viewGroup) {
        return RangesKt.W1(0, viewGroup.getChildCount());
    }

    public static final int h(@NotNull ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    public static final boolean i(@NotNull ViewGroup viewGroup) {
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean j(@NotNull ViewGroup viewGroup) {
        return viewGroup.getChildCount() != 0;
    }

    @NotNull
    public static final Iterator<View> k(@NotNull ViewGroup viewGroup) {
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void l(@NotNull ViewGroup viewGroup, @NotNull View view) {
        viewGroup.removeView(view);
    }

    public static final void m(@NotNull ViewGroup viewGroup, @NotNull View view) {
        viewGroup.addView(view);
    }

    public static final void n(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2) {
        marginLayoutParams.setMargins(i2, i2, i2, i2);
    }

    public static final void o(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        marginLayoutParams.setMargins(i2, i3, i4, i5);
    }

    public static /* synthetic */ void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.leftMargin;
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.rightMargin;
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMargins(i2, i3, i4, i5);
    }

    public static final void q(@NotNull ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }

    public static /* synthetic */ void r(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.getMarginStart();
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.getMarginEnd();
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }
}
