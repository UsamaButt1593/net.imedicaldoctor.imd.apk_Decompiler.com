package kotlin.enums;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a9\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a3\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "E", "Lkotlin/Function0;", "", "entriesProvider", "Lkotlin/enums/EnumEntries;", "a", "(Lkotlin/jvm/functions/Function0;)Lkotlin/enums/EnumEntries;", "entries", "b", "([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class EnumEntriesKt {
    @SinceKotlin(version = "1.8")
    @PublishedApi
    @NotNull
    public static final <E extends Enum<E>> EnumEntries<E> a(@NotNull Function0<E[]> function0) {
        Intrinsics.p(function0, "entriesProvider");
        return new EnumEntriesList((Enum[]) function0.o());
    }

    @SinceKotlin(version = "1.8")
    @PublishedApi
    @NotNull
    public static final <E extends Enum<E>> EnumEntries<E> b(@NotNull E[] eArr) {
        Intrinsics.p(eArr, "entries");
        return new EnumEntriesList(eArr);
    }
}
