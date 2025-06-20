package kotlin.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0000H&¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lkotlin/text/MatchResult;", "", "next", "()Lkotlin/text/MatchResult;", "Lkotlin/ranges/IntRange;", "d", "()Lkotlin/ranges/IntRange;", "range", "", "getValue", "()Ljava/lang/String;", "value", "Lkotlin/text/MatchGroupCollection;", "c", "()Lkotlin/text/MatchGroupCollection;", "groups", "", "b", "()Ljava/util/List;", "groupValues", "Lkotlin/text/MatchResult$Destructured;", "a", "()Lkotlin/text/MatchResult$Destructured;", "destructured", "Destructured", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public interface MatchResult {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static Destructured a(@NotNull MatchResult matchResult) {
            return new Destructured(matchResult);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006H\n¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0006H\n¢\u0006\u0004\b\u000b\u0010\bJ\u0010\u0010\f\u001a\u00020\u0006H\n¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\r\u001a\u00020\u0006H\n¢\u0006\u0004\b\r\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u0006H\n¢\u0006\u0004\b\u000e\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u0006H\n¢\u0006\u0004\b\u000f\u0010\bJ\u0010\u0010\u0010\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0010\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0011\u0010\bJ\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lkotlin/text/MatchResult$Destructured;", "", "Lkotlin/text/MatchResult;", "match", "<init>", "(Lkotlin/text/MatchResult;)V", "", "a", "()Ljava/lang/String;", "c", "d", "e", "f", "g", "h", "i", "j", "b", "", "l", "()Ljava/util/List;", "Lkotlin/text/MatchResult;", "k", "()Lkotlin/text/MatchResult;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Destructured {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final MatchResult f29102a;

        public Destructured(@NotNull MatchResult matchResult) {
            Intrinsics.p(matchResult, "match");
            this.f29102a = matchResult;
        }

        @InlineOnly
        private final String a() {
            return k().b().get(1);
        }

        @InlineOnly
        private final String b() {
            return k().b().get(10);
        }

        @InlineOnly
        private final String c() {
            return k().b().get(2);
        }

        @InlineOnly
        private final String d() {
            return k().b().get(3);
        }

        @InlineOnly
        private final String e() {
            return k().b().get(4);
        }

        @InlineOnly
        private final String f() {
            return k().b().get(5);
        }

        @InlineOnly
        private final String g() {
            return k().b().get(6);
        }

        @InlineOnly
        private final String h() {
            return k().b().get(7);
        }

        @InlineOnly
        private final String i() {
            return k().b().get(8);
        }

        @InlineOnly
        private final String j() {
            return k().b().get(9);
        }

        @NotNull
        public final MatchResult k() {
            return this.f29102a;
        }

        @NotNull
        public final List<String> l() {
            return this.f29102a.b().subList(1, this.f29102a.b().size());
        }
    }

    @NotNull
    Destructured a();

    @NotNull
    List<String> b();

    @NotNull
    MatchGroupCollection c();

    @NotNull
    IntRange d();

    @NotNull
    String getValue();

    @Nullable
    MatchResult next();
}
