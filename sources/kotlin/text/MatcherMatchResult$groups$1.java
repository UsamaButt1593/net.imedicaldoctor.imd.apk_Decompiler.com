package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "", "index", "get", "(I)Lkotlin/text/MatchGroup;", "", "name", "i", "(Ljava/lang/String;)Lkotlin/text/MatchGroup;", "b", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {
    final /* synthetic */ MatcherMatchResult s;

    MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.s = matcherMatchResult;
    }

    public int b() {
        return this.s.f().groupCount() + 1;
    }

    public /* bridge */ boolean c(MatchGroup matchGroup) {
        return super.contains(matchGroup);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj == null ? true : obj instanceof MatchGroup)) {
            return false;
        }
        return c((MatchGroup) obj);
    }

    @Nullable
    public MatchGroup get(int i2) {
        IntRange d2 = RegexKt.j(this.s.f(), i2);
        if (d2.c().intValue() < 0) {
            return null;
        }
        String group = this.s.f().group(i2);
        Intrinsics.o(group, "matchResult.group(index)");
        return new MatchGroup(group, d2);
    }

    @Nullable
    public MatchGroup i(@NotNull String str) {
        Intrinsics.p(str, "name");
        return PlatformImplementationsKt.f28815a.c(this.s.f(), str);
    }

    public boolean isEmpty() {
        return false;
    }

    @NotNull
    public Iterator<MatchGroup> iterator() {
        return SequencesKt.k1(CollectionsKt.x1(CollectionsKt.F(this)), new MatcherMatchResult$groups$1$iterator$1(this)).iterator();
    }
}
