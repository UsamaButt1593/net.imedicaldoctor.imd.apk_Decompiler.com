package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\u001a?\u0010\u0006\u001a\u00020\u00052.\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u000f\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a!\u0010\u000b\u001a\u00020\u0005*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\nH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "Lkotlin/Pair;", "", "", "pairs", "Landroid/os/PersistableBundle;", "b", "([Lkotlin/Pair;)Landroid/os/PersistableBundle;", "a", "()Landroid/os/PersistableBundle;", "", "c", "(Ljava/util/Map;)Landroid/os/PersistableBundle;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPersistableBundle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersistableBundle.kt\nandroidx/core/os/PersistableBundleKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,155:1\n13579#2,2:156\n*S KotlinDebug\n*F\n+ 1 PersistableBundle.kt\nandroidx/core/os/PersistableBundleKt\n*L\n35#1:156,2\n*E\n"})
public final class PersistableBundleKt {
    @RequiresApi(21)
    @NotNull
    public static final PersistableBundle a() {
        return PersistableBundleApi21ImplKt.a(0);
    }

    @RequiresApi(21)
    @NotNull
    public static final PersistableBundle b(@NotNull Pair<String, ? extends Object>... pairArr) {
        PersistableBundle a2 = PersistableBundleApi21ImplKt.a(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            PersistableBundleApi21ImplKt.b(a2, pair.a(), pair.b());
        }
        return a2;
    }

    @RequiresApi(21)
    @NotNull
    public static final PersistableBundle c(@NotNull Map<String, ? extends Object> map) {
        PersistableBundle a2 = PersistableBundleApi21ImplKt.a(map.size());
        for (Map.Entry next : map.entrySet()) {
            PersistableBundleApi21ImplKt.b(a2, (String) next.getKey(), next.getValue());
        }
        return a2;
    }
}
