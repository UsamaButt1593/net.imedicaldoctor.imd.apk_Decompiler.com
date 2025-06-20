package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(21)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/core/os/PersistableBundleApi21ImplKt;", "", "<init>", "()V", "", "capacity", "Landroid/os/PersistableBundle;", "a", "(I)Landroid/os/PersistableBundle;", "persistableBundle", "", "key", "value", "", "b", "(Landroid/os/PersistableBundle;Ljava/lang/String;Ljava/lang/Object;)V", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
final class PersistableBundleApi21ImplKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final PersistableBundleApi21ImplKt f6071a = new PersistableBundleApi21ImplKt();

    private PersistableBundleApi21ImplKt() {
    }

    @JvmStatic
    @NotNull
    @DoNotInline
    public static final PersistableBundle a(int i2) {
        return new PersistableBundle(i2);
    }

    @JvmStatic
    @DoNotInline
    public static final void b(@NotNull PersistableBundle persistableBundle, @Nullable String str, @Nullable Object obj) {
        String str2;
        if (obj == null) {
            str2 = null;
        } else if (obj instanceof Boolean) {
            if (Build.VERSION.SDK_INT >= 22) {
                PersistableBundleApi22ImplKt.a(persistableBundle, str, ((Boolean) obj).booleanValue());
                return;
            }
            throw new IllegalArgumentException("Illegal value type boolean for key \"" + str + '\"');
        } else if (obj instanceof Double) {
            persistableBundle.putDouble(str, ((Number) obj).doubleValue());
            return;
        } else if (obj instanceof Integer) {
            persistableBundle.putInt(str, ((Number) obj).intValue());
            return;
        } else if (obj instanceof Long) {
            persistableBundle.putLong(str, ((Number) obj).longValue());
            return;
        } else if (obj instanceof String) {
            str2 = (String) obj;
        } else if (obj instanceof boolean[]) {
            if (Build.VERSION.SDK_INT >= 22) {
                PersistableBundleApi22ImplKt.b(persistableBundle, str, (boolean[]) obj);
                return;
            }
            throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + str + '\"');
        } else if (obj instanceof double[]) {
            persistableBundle.putDoubleArray(str, (double[]) obj);
            return;
        } else if (obj instanceof int[]) {
            persistableBundle.putIntArray(str, (int[]) obj);
            return;
        } else if (obj instanceof long[]) {
            persistableBundle.putLongArray(str, (long[]) obj);
            return;
        } else if (obj instanceof Object[]) {
            Class<?> componentType = obj.getClass().getComponentType();
            Intrinsics.m(componentType);
            if (String.class.isAssignableFrom(componentType)) {
                Intrinsics.n(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                persistableBundle.putStringArray(str, (String[]) obj);
                return;
            }
            String canonicalName = componentType.getCanonicalName();
            throw new IllegalArgumentException("Illegal value array type " + canonicalName + " for key \"" + str + '\"');
        } else {
            String canonicalName2 = obj.getClass().getCanonicalName();
            throw new IllegalArgumentException("Illegal value type " + canonicalName2 + " for key \"" + str + '\"');
        }
        persistableBundle.putString(str, str2);
    }
}
