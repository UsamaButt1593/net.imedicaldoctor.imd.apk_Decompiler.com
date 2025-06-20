package kotlin.io.path;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.8")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/io/path/CopyActionResult;", "", "<init>", "(Ljava/lang/String;I)V", "s", "X", "Y", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0})
@ExperimentalPathApi
public enum CopyActionResult {
    CONTINUE,
    SKIP_SUBTREE,
    TERMINATE;

    static {
        CopyActionResult[] a2;
        X2 = EnumEntriesKt.b(a2);
    }

    @NotNull
    public static EnumEntries<CopyActionResult> b() {
        return X2;
    }
}
