package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0014\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\b¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\u0010\u001a\u0004\u0018\u00010\u000f*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000f*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0013\u0010\u0016\u001a\u00020\u0015*\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u0019\u001a\u00020\u0015*\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"", "Lkotlin/text/FlagEnum;", "", "k", "(Ljava/lang/Iterable;)I", "", "T", "value", "", "g", "(I)Ljava/util/Set;", "Ljava/util/regex/Matcher;", "from", "", "input", "Lkotlin/text/MatchResult;", "f", "(Ljava/util/regex/Matcher;ILjava/lang/CharSequence;)Lkotlin/text/MatchResult;", "h", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)Lkotlin/text/MatchResult;", "Ljava/util/regex/MatchResult;", "Lkotlin/ranges/IntRange;", "i", "(Ljava/util/regex/MatchResult;)Lkotlin/ranges/IntRange;", "groupIndex", "j", "(Ljava/util/regex/MatchResult;I)Lkotlin/ranges/IntRange;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,396:1\n1789#2,3:397\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/RegexKt\n*L\n19#1:397,3\n*E\n"})
public final class RegexKt {
    /* access modifiers changed from: private */
    public static final MatchResult f(Matcher matcher, int i2, CharSequence charSequence) {
        if (!matcher.find(i2)) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    private static final /* synthetic */ <T extends Enum<T> & FlagEnum> Set<T> g(int i2) {
        Intrinsics.y(4, ExifInterface.d5);
        EnumSet<E> allOf = EnumSet.allOf(Enum.class);
        Intrinsics.o(allOf, "fromInt$lambda$1");
        Intrinsics.w();
        CollectionsKt.N0(allOf, new RegexKt$fromInt$1$1(i2));
        Set<T> unmodifiableSet = Collections.unmodifiableSet(allOf);
        Intrinsics.o(unmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
        return unmodifiableSet;
    }

    /* access modifiers changed from: private */
    public static final MatchResult h(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new MatcherMatchResult(matcher, charSequence);
    }

    /* access modifiers changed from: private */
    public static final IntRange i(MatchResult matchResult) {
        return RangesKt.W1(matchResult.start(), matchResult.end());
    }

    /* access modifiers changed from: private */
    public static final IntRange j(MatchResult matchResult, int i2) {
        return RangesKt.W1(matchResult.start(i2), matchResult.end(i2));
    }

    /* access modifiers changed from: private */
    public static final int k(Iterable<? extends FlagEnum> iterable) {
        int i2 = 0;
        for (FlagEnum value : iterable) {
            i2 |= value.getValue();
        }
        return i2;
    }
}
