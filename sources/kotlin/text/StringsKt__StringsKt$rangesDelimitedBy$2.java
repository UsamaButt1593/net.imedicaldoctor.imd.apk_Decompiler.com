package kotlin.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt$rangesDelimitedBy$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1486:1\n1#2:1487\n*E\n"})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "currentIndex", "Lkotlin/Pair;", "b", "(Ljava/lang/CharSequence;I)Lkotlin/Pair;"}, k = 3, mv = {1, 9, 0})
final class StringsKt__StringsKt$rangesDelimitedBy$2 extends Lambda implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ List<String> X;
    final /* synthetic */ boolean Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$rangesDelimitedBy$2(List<String> list, boolean z) {
        super(2);
        this.X = list;
        this.Y = z;
    }

    @Nullable
    public final Pair<Integer, Integer> b(@NotNull CharSequence charSequence, int i2) {
        Intrinsics.p(charSequence, "$this$$receiver");
        Pair K2 = StringsKt__StringsKt.b3(charSequence, this.X, i2, this.Y, false);
        if (K2 != null) {
            return TuplesKt.a(K2.e(), Integer.valueOf(((String) K2.f()).length()));
        }
        return null;
    }

    public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
        return b((CharSequence) obj, ((Number) obj2).intValue());
    }
}
