package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\nR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/MethodCallsLogger;", "", "<init>", "()V", "", "name", "", "type", "", "a", "(Ljava/lang/String;I)Z", "", "Ljava/util/Map;", "calledMethods", "lifecycle-common"}, k = 1, mv = {1, 8, 0})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MethodCallsLogger {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Integer> f8564a = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean a(@NotNull String str, int i2) {
        Intrinsics.p(str, "name");
        Integer num = this.f8564a.get(str);
        boolean z = false;
        int intValue = num != null ? num.intValue() : 0;
        if ((intValue & i2) != 0) {
            z = true;
        }
        this.f8564a.put(str, Integer.valueOf(i2 | intValue));
        return !z;
    }
}
