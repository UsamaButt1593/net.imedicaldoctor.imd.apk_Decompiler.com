package androidx.activity;

import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/res/Resources;", "resources", "", "b", "(Landroid/content/res/Resources;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0})
final class SystemBarStyle$Companion$auto$1 extends Lambda implements Function1<Resources, Boolean> {
    public static final SystemBarStyle$Companion$auto$1 X = new SystemBarStyle$Companion$auto$1();

    SystemBarStyle$Companion$auto$1() {
        super(1);
    }

    @NotNull
    /* renamed from: b */
    public final Boolean f(@NotNull Resources resources) {
        Intrinsics.p(resources, "resources");
        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
    }
}
