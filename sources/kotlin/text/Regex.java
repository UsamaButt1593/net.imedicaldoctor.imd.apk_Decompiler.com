package kotlin.text;

import com.itextpdf.tool.xml.html.HTML;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nRegex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n+ 2 Regex.kt\nkotlin/text/RegexKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,396:1\n22#2,3:397\n1#3:400\n*S KotlinDebug\n*F\n+ 1 Regex.kt\nkotlin/text/Regex\n*L\n102#1:397,3\n*E\n"})
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0013\u0018\u0000 @2\u00060\u0001j\u0002`\u0002:\u0002ABB\u0011\b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fB\u001f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0004\b\u0005\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0017J!\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0019H\u0007¢\u0006\u0004\b$\u0010\u001dJ\u001f\u0010%\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0019H\u0007¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0007¢\u0006\u0004\b(\u0010)J)\u0010,\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00130*¢\u0006\u0004\b,\u0010-J\u001d\u0010.\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0007¢\u0006\u0004\b.\u0010)J%\u00101\u001a\b\u0012\u0004\u0012\u00020\u0007002\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010/\u001a\u00020\u0019¢\u0006\u0004\b1\u00102J'\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e2\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010/\u001a\u00020\u0019H\u0007¢\u0006\u0004\b3\u0010 J\u000f\u00104\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u0003¢\u0006\u0004\b6\u00107R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001e\u0010<\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b=\u00105R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r8F¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006C"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/regex/Pattern;", "nativePattern", "<init>", "(Ljava/util/regex/Pattern;)V", "", "pattern", "(Ljava/lang/String;)V", "Lkotlin/text/RegexOption;", "option", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "", "options", "(Ljava/lang/String;Ljava/util/Set;)V", "", "u", "()Ljava/lang/Object;", "", "input", "", "k", "(Ljava/lang/CharSequence;)Z", "b", "", "startIndex", "Lkotlin/text/MatchResult;", "c", "(Ljava/lang/CharSequence;I)Lkotlin/text/MatchResult;", "Lkotlin/sequences/Sequence;", "e", "(Ljava/lang/CharSequence;I)Lkotlin/sequences/Sequence;", "j", "(Ljava/lang/CharSequence;)Lkotlin/text/MatchResult;", "index", "i", "l", "(Ljava/lang/CharSequence;I)Z", "replacement", "m", "(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/Function1;", "transform", "n", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "o", "limit", "", "p", "(Ljava/lang/CharSequence;I)Ljava/util/List;", "r", "toString", "()Ljava/lang/String;", "t", "()Ljava/util/regex/Pattern;", "s", "Ljava/util/regex/Pattern;", "X", "Ljava/util/Set;", "_options", "h", "g", "()Ljava/util/Set;", "Y", "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class Regex implements Serializable {
    @NotNull
    public static final Companion Y = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private Set<? extends RegexOption> X;
    /* access modifiers changed from: private */
    @NotNull
    public final Pattern s;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlin/text/Regex$Companion;", "", "<init>", "()V", "", "flags", "b", "(I)I", "", "literal", "Lkotlin/text/Regex;", "e", "(Ljava/lang/String;)Lkotlin/text/Regex;", "c", "(Ljava/lang/String;)Ljava/lang/String;", "d", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        public final int b(int i2) {
            return (i2 & 2) != 0 ? i2 | 64 : i2;
        }

        @NotNull
        public final String c(@NotNull String str) {
            Intrinsics.p(str, "literal");
            String quote = Pattern.quote(str);
            Intrinsics.o(quote, "quote(literal)");
            return quote;
        }

        @NotNull
        public final String d(@NotNull String str) {
            Intrinsics.p(str, "literal");
            String quoteReplacement = Matcher.quoteReplacement(str);
            Intrinsics.o(quoteReplacement, "quoteReplacement(literal)");
            return quoteReplacement;
        }

        @NotNull
        public final Regex e(@NotNull String str) {
            Intrinsics.p(str, "literal");
            return new Regex(str, RegexOption.LITERAL);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\r\b\u0002\u0018\u0000 \u00142\u00060\u0001j\u0002`\u0002:\u0001\u0015B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "pattern", "", "flags", "<init>", "(Ljava/lang/String;I)V", "", "c", "()Ljava/lang/Object;", "s", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "X", "I", "a", "()I", "Y", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    private static final class Serialized implements Serializable {
        @NotNull
        public static final Companion Y = new Companion((DefaultConstructorMarker) null);
        private static final long Z = 0;
        private final int X;
        @NotNull
        private final String s;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Serialized(@NotNull String str, int i2) {
            Intrinsics.p(str, "pattern");
            this.s = str;
            this.X = i2;
        }

        private final Object c() {
            Pattern compile = Pattern.compile(this.s, this.X);
            Intrinsics.o(compile, "compile(pattern, flags)");
            return new Regex(compile);
        }

        public final int a() {
            return this.X;
        }

        @NotNull
        public final String b() {
            return this.s;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(pattern)"
            kotlin.jvm.internal.Intrinsics.o(r2, r0)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    public static /* synthetic */ MatchResult d(Regex regex, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.c(charSequence, i2);
    }

    public static /* synthetic */ Sequence f(Regex regex, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.e(charSequence, i2);
    }

    public static /* synthetic */ List q(Regex regex, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.p(charSequence, i2);
    }

    public static /* synthetic */ Sequence s(Regex regex, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.r(charSequence, i2);
    }

    private final Object u() {
        String pattern = this.s.pattern();
        Intrinsics.o(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.s.flags());
    }

    public final boolean b(@NotNull CharSequence charSequence) {
        Intrinsics.p(charSequence, HTML.Tag.q0);
        return this.s.matcher(charSequence).find();
    }

    @Nullable
    public final MatchResult c(@NotNull CharSequence charSequence, int i2) {
        Intrinsics.p(charSequence, HTML.Tag.q0);
        Matcher matcher = this.s.matcher(charSequence);
        Intrinsics.o(matcher, "nativePattern.matcher(input)");
        return RegexKt.f(matcher, i2, charSequence);
    }

    @NotNull
    public final Sequence<MatchResult> e(@NotNull CharSequence charSequence, int i2) {
        Intrinsics.p(charSequence, HTML.Tag.q0);
        if (i2 >= 0 && i2 <= charSequence.length()) {
            return SequencesKt.n(new Regex$findAll$1(this, charSequence, i2), Regex$findAll$2.c3);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i2 + ", input length: " + charSequence.length());
    }

    @NotNull
    public final Set<RegexOption> g() {
        Set<? extends RegexOption> set = this.X;
        if (set != null) {
            return set;
        }
        int flags = this.s.flags();
        EnumSet<E> allOf = EnumSet.allOf(RegexOption.class);
        Intrinsics.o(allOf, "fromInt$lambda$1");
        CollectionsKt.N0(allOf, new Regex$special$$inlined$fromInt$1(flags));
        Set<? extends RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        Intrinsics.o(unmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
        this.X = unmodifiableSet;
        return unmodifiableSet;
    }

    @NotNull
    public final String h() {
        String pattern = this.s.pattern();
        Intrinsics.o(pattern, "nativePattern.pattern()");
        return pattern;
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final MatchResult i(@NotNull CharSequence charSequence, int i2) {
        Intrinsics.p(charSequence, HTML.Tag.q0);
        Matcher region = this.s.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i2, charSequence.length());
        if (!region.lookingAt()) {
            return null;
        }
        Intrinsics.o(region, "this");
        return new MatcherMatchResult(region, charSequence);
    }

    @Nullable
    public final MatchResult j(@NotNull CharSequence charSequence) {
        Intrinsics.p(charSequence, HTML.Tag.q0);
        Matcher matcher = this.s.matcher(charSequence);
        Intrinsics.o(matcher, "nativePattern.matcher(input)");
        return RegexKt.h(matcher, charSequence);
    }

    public final boolean k(@NotNull CharSequence charSequence) {
        Intrinsics.p(charSequence, HTML.Tag.q0);
        return this.s.matcher(charSequence).matches();
    }

    @SinceKotlin(version = "1.7")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final boolean l(@NotNull CharSequence charSequence, int i2) {
        Intrinsics.p(charSequence, HTML.Tag.q0);
        return this.s.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(i2, charSequence.length()).lookingAt();
    }

    @NotNull
    public final String m(@NotNull CharSequence charSequence, @NotNull String str) {
        Intrinsics.p(charSequence, HTML.Tag.q0);
        Intrinsics.p(str, "replacement");
        String replaceAll = this.s.matcher(charSequence).replaceAll(str);
        Intrinsics.o(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    @NotNull
    public final String n(@NotNull CharSequence charSequence, @NotNull Function1<? super MatchResult, ? extends CharSequence> function1) {
        Intrinsics.p(charSequence, HTML.Tag.q0);
        Intrinsics.p(function1, "transform");
        int i2 = 0;
        MatchResult d2 = d(this, charSequence, 0, 2, (Object) null);
        if (d2 == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(charSequence, i2, d2.d().c().intValue());
            sb.append((CharSequence) function1.f(d2));
            i2 = d2.d().h().intValue() + 1;
            d2 = d2.next();
            if (i2 >= length) {
                break;
            }
        } while (d2 != null);
        if (i2 < length) {
            sb.append(charSequence, i2, length);
        }
        String sb2 = sb.toString();
        Intrinsics.o(sb2, "sb.toString()");
        return sb2;
    }

    @NotNull
    public final String o(@NotNull CharSequence charSequence, @NotNull String str) {
        Intrinsics.p(charSequence, HTML.Tag.q0);
        Intrinsics.p(str, "replacement");
        String replaceFirst = this.s.matcher(charSequence).replaceFirst(str);
        Intrinsics.o(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    @NotNull
    public final List<String> p(@NotNull CharSequence charSequence, int i2) {
        Intrinsics.p(charSequence, HTML.Tag.q0);
        StringsKt__StringsKt.K4(i2);
        Matcher matcher = this.s.matcher(charSequence);
        if (i2 == 1 || !matcher.find()) {
            return CollectionsKt.k(charSequence.toString());
        }
        int i3 = 10;
        if (i2 > 0) {
            i3 = RangesKt.B(i2, 10);
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = i2 - 1;
        int i5 = 0;
        do {
            arrayList.add(charSequence.subSequence(i5, matcher.start()).toString());
            i5 = matcher.end();
            if ((i4 >= 0 && arrayList.size() == i4) || !matcher.find()) {
                arrayList.add(charSequence.subSequence(i5, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i5, matcher.start()).toString());
            i5 = matcher.end();
            break;
        } while (!matcher.find());
        arrayList.add(charSequence.subSequence(i5, charSequence.length()).toString());
        return arrayList;
    }

    @SinceKotlin(version = "1.6")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public final Sequence<String> r(@NotNull CharSequence charSequence, int i2) {
        Intrinsics.p(charSequence, HTML.Tag.q0);
        StringsKt__StringsKt.K4(i2);
        return SequencesKt.b(new Regex$splitToSequence$1(this, charSequence, i2, (Continuation<? super Regex$splitToSequence$1>) null));
    }

    @NotNull
    public final Pattern t() {
        return this.s;
    }

    @NotNull
    public String toString() {
        String pattern = this.s.toString();
        Intrinsics.o(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull java.util.Set<? extends kotlin.text.RegexOption> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            kotlin.text.Regex$Companion r0 = Y
            int r3 = kotlin.text.RegexKt.k(r3)
            int r3 = r0.b(r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureU…odeCase(options.toInt()))"
            kotlin.jvm.internal.Intrinsics.o(r2, r3)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            kotlin.text.Regex$Companion r0 = Y
            int r3 = r3.getValue()
            int r3 = r0.b(r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureUnicodeCase(option.value))"
            kotlin.jvm.internal.Intrinsics.o(r2, r3)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    @PublishedApi
    public Regex(@NotNull Pattern pattern) {
        Intrinsics.p(pattern, "nativePattern");
        this.s = pattern;
    }
}
