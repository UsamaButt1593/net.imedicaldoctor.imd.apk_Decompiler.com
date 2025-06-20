package kotlin.text;

import com.itextpdf.tool.xml.html.HTML;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0012\u001a\u00020\u000e8\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u001dR\u0014\u0010!\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\"¨\u0006$"}, d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "matcher", "", "input", "<init>", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "next", "()Lkotlin/text/MatchResult;", "a", "Ljava/util/regex/Matcher;", "b", "Ljava/lang/CharSequence;", "Lkotlin/text/MatchGroupCollection;", "c", "Lkotlin/text/MatchGroupCollection;", "()Lkotlin/text/MatchGroupCollection;", "groups", "", "", "d", "Ljava/util/List;", "groupValues_", "Ljava/util/regex/MatchResult;", "f", "()Ljava/util/regex/MatchResult;", "matchResult", "Lkotlin/ranges/IntRange;", "()Lkotlin/ranges/IntRange;", "range", "getValue", "()Ljava/lang/String;", "value", "()Ljava/util/List;", "groupValues", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class MatcherMatchResult implements MatchResult {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Matcher f29103a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f29104b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final MatchGroupCollection f29105c = new MatcherMatchResult$groups$1(this);
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private List<String> f29106d;

    public MatcherMatchResult(@NotNull Matcher matcher, @NotNull CharSequence charSequence) {
        Intrinsics.p(matcher, "matcher");
        Intrinsics.p(charSequence, HTML.Tag.q0);
        this.f29103a = matcher;
        this.f29104b = charSequence;
    }

    /* access modifiers changed from: private */
    public final MatchResult f() {
        return this.f29103a;
    }

    @NotNull
    public MatchResult.Destructured a() {
        return MatchResult.DefaultImpls.a(this);
    }

    @NotNull
    public List<String> b() {
        if (this.f29106d == null) {
            this.f29106d = new MatcherMatchResult$groupValues$1(this);
        }
        List<String> list = this.f29106d;
        Intrinsics.m(list);
        return list;
    }

    @NotNull
    public MatchGroupCollection c() {
        return this.f29105c;
    }

    @NotNull
    public IntRange d() {
        return RegexKt.i(f());
    }

    @NotNull
    public String getValue() {
        String group = f().group();
        Intrinsics.o(group, "matchResult.group()");
        return group;
    }

    @Nullable
    public MatchResult next() {
        int end = f().end() + (f().end() == f().start() ? 1 : 0);
        if (end > this.f29104b.length()) {
            return null;
        }
        Matcher matcher = this.f29103a.pattern().matcher(this.f29104b);
        Intrinsics.o(matcher, "matcher.pattern().matcher(input)");
        return RegexKt.f(matcher, end, this.f29104b);
    }
}
