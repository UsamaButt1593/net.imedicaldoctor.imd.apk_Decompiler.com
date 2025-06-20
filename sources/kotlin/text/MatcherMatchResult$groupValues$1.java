package kotlin.text;

import kotlin.Metadata;
import kotlin.collections.AbstractList;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "", "index", "d", "(I)Ljava/lang/String;", "b", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class MatcherMatchResult$groupValues$1 extends AbstractList<String> {
    final /* synthetic */ MatcherMatchResult X;

    MatcherMatchResult$groupValues$1(MatcherMatchResult matcherMatchResult) {
        this.X = matcherMatchResult;
    }

    public int b() {
        return this.X.f().groupCount() + 1;
    }

    public /* bridge */ boolean c(String str) {
        return super.contains(str);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return c((String) obj);
    }

    @NotNull
    /* renamed from: d */
    public String get(int i2) {
        String group = this.X.f().group(i2);
        return group == null ? "" : group;
    }

    public /* bridge */ int g(String str) {
        return super.indexOf(str);
    }

    public /* bridge */ int h(String str) {
        return super.lastIndexOf(str);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof String)) {
            return -1;
        }
        return g((String) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof String)) {
            return -1;
        }
        return h((String) obj);
    }
}
