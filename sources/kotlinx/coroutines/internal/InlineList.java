package kotlinx.coroutines.internal;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JvmInline
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00028\u0000H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\f\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\tH\b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u0001\u0003\u0001\u0004\u0018\u00010\u0002ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/InlineList;", "E", "", "holder", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "element", "h", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "action", "f", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "", "i", "(Ljava/lang/Object;)Ljava/lang/String;", "", "g", "(Ljava/lang/Object;)I", "other", "", "d", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "a", "Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class InlineList<E> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Object f29348a;

    private /* synthetic */ InlineList(Object obj) {
        this.f29348a = obj;
    }

    public static final /* synthetic */ InlineList a(Object obj) {
        return new InlineList(obj);
    }

    @NotNull
    public static <E> Object b(@Nullable Object obj) {
        return obj;
    }

    public static /* synthetic */ Object c(Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 1) != 0) {
            obj = null;
        }
        return b(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof InlineList) && Intrinsics.g(obj, ((InlineList) obj2).j());
    }

    public static final boolean e(Object obj, Object obj2) {
        return Intrinsics.g(obj, obj2);
    }

    public static final void f(Object obj, @NotNull Function1<? super E, Unit> function1) {
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                function1.f(obj);
                return;
            }
            ArrayList arrayList = (ArrayList) obj;
            int size = arrayList.size();
            while (true) {
                size--;
                if (-1 < size) {
                    function1.f(arrayList.get(size));
                } else {
                    return;
                }
            }
        }
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @NotNull
    public static final Object h(Object obj, E e2) {
        if (obj == null) {
            return b(e2);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e2);
            return b(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e2);
        return b(arrayList);
    }

    public static String i(Object obj) {
        return "InlineList(holder=" + obj + ASCIIPropertyListParser.f18650h;
    }

    public boolean equals(Object obj) {
        return d(this.f29348a, obj);
    }

    public int hashCode() {
        return g(this.f29348a);
    }

    public final /* synthetic */ Object j() {
        return this.f29348a;
    }

    public String toString() {
        return i(this.f29348a);
    }
}
