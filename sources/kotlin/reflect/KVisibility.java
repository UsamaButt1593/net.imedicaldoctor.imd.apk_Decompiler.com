package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlin/reflect/KVisibility;", "", "<init>", "(Ljava/lang/String;I)V", "s", "X", "Y", "Z", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@SinceKotlin(version = "1.1")
public enum KVisibility {
    PUBLIC,
    PROTECTED,
    INTERNAL,
    PRIVATE;

    static {
        KVisibility[] a2;
        Y2 = EnumEntriesKt.b(a2);
    }

    @NotNull
    public static EnumEntries<KVisibility> b() {
        return Y2;
    }
}
