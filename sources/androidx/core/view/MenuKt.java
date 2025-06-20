package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\r\u001a\u00020\u0007*\u00020\u0000H\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0007*\u00020\u0000H\b¢\u0006\u0004\b\u000f\u0010\u000e\u001a7\u0010\u0014\u001a\u00020\n*\u00020\u00002!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\u0010H\b¢\u0006\u0004\b\u0014\u0010\u0015\u001aL\u0010\u0017\u001a\u00020\n*\u00020\u000026\u0010\u0013\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\n0\u0016H\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019*\u00020\u0000H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001c\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u001c\u0010\u001d\"\u0016\u0010 \u001a\u00020\u0001*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\"\u001b\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030!*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Landroid/view/Menu;", "", "index", "Landroid/view/MenuItem;", "d", "(Landroid/view/Menu;I)Landroid/view/MenuItem;", "item", "", "a", "(Landroid/view/Menu;Landroid/view/MenuItem;)Z", "", "j", "(Landroid/view/Menu;Landroid/view/MenuItem;)V", "g", "(Landroid/view/Menu;)Z", "h", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "action", "b", "(Landroid/view/Menu;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "c", "(Landroid/view/Menu;Lkotlin/jvm/functions/Function2;)V", "", "i", "(Landroid/view/Menu;)Ljava/util/Iterator;", "k", "(Landroid/view/Menu;I)V", "f", "(Landroid/view/Menu;)I", "size", "Lkotlin/sequences/Sequence;", "e", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "children", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nMenu.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Menu.kt\nandroidx/core/view/MenuKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,90:1\n1#2:91\n*E\n"})
public final class MenuKt {
    public static final boolean a(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (Intrinsics.g(menu.getItem(i2), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void b(@NotNull Menu menu, @NotNull Function1<? super MenuItem, Unit> function1) {
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            function1.f(menu.getItem(i2));
        }
    }

    public static final void c(@NotNull Menu menu, @NotNull Function2<? super Integer, ? super MenuItem, Unit> function2) {
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            function2.d0(Integer.valueOf(i2), menu.getItem(i2));
        }
    }

    @NotNull
    public static final MenuItem d(@NotNull Menu menu, int i2) {
        return menu.getItem(i2);
    }

    @NotNull
    public static final Sequence<MenuItem> e(@NotNull Menu menu) {
        return new MenuKt$children$1(menu);
    }

    public static final int f(@NotNull Menu menu) {
        return menu.size();
    }

    public static final boolean g(@NotNull Menu menu) {
        return menu.size() == 0;
    }

    public static final boolean h(@NotNull Menu menu) {
        return menu.size() != 0;
    }

    @NotNull
    public static final Iterator<MenuItem> i(@NotNull Menu menu) {
        return new MenuKt$iterator$1(menu);
    }

    public static final void j(@NotNull Menu menu, @NotNull MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }

    public static final void k(@NotNull Menu menu, int i2) {
        Unit unit;
        MenuItem item = menu.getItem(i2);
        if (item != null) {
            menu.removeItem(item.getItemId());
            unit = Unit.f28779a;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
