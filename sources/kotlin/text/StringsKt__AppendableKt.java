package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a9\u0010\b\u001a\u00028\u0000\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001*\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a7\u0010\u000b\u001a\u00028\u0000\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001*\u00028\u00002\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\n\"\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\b¢\u0006\u0004\b\r\u0010\u000e\u001a&\u0010\u000f\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a$\u0010\u0012\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0011H\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a;\u0010\u0018\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0014\u001a\u00028\u00002\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "T", "", "value", "", "startIndex", "endIndex", "f", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "", "a", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "c", "(Ljava/lang/Appendable;)Ljava/lang/Appendable;", "e", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "", "d", "(Ljava/lang/Appendable;C)Ljava/lang/Appendable;", "element", "Lkotlin/Function1;", "transform", "", "b", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/text/StringsKt")
class StringsKt__AppendableKt {
    @NotNull
    public static final <T extends Appendable> T a(@NotNull T t, @NotNull CharSequence... charSequenceArr) {
        Intrinsics.p(t, "<this>");
        Intrinsics.p(charSequenceArr, "value");
        for (CharSequence append : charSequenceArr) {
            t.append(append);
        }
        return t;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [kotlin.jvm.functions.Function1<? super T, ? extends java.lang.CharSequence>, kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void b(@org.jetbrains.annotations.NotNull java.lang.Appendable r1, T r2, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super T, ? extends java.lang.CharSequence> r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r1, r0)
            if (r3 == 0) goto L_0x0011
            java.lang.Object r2 = r3.f(r2)
        L_0x000b:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
        L_0x000d:
            r1.append(r2)
            goto L_0x002d
        L_0x0011:
            if (r2 != 0) goto L_0x0015
            r3 = 1
            goto L_0x0017
        L_0x0015:
            boolean r3 = r2 instanceof java.lang.CharSequence
        L_0x0017:
            if (r3 == 0) goto L_0x001a
            goto L_0x000b
        L_0x001a:
            boolean r3 = r2 instanceof java.lang.Character
            if (r3 == 0) goto L_0x0028
            java.lang.Character r2 = (java.lang.Character) r2
            char r2 = r2.charValue()
            r1.append(r2)
            goto L_0x002d
        L_0x0028:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            goto L_0x000d
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__AppendableKt.b(java.lang.Appendable, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable c(Appendable appendable) {
        Intrinsics.p(appendable, "<this>");
        Appendable append = appendable.append(10);
        Intrinsics.o(append, "append('\\n')");
        return append;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable d(Appendable appendable, char c2) {
        Intrinsics.p(appendable, "<this>");
        Appendable append = appendable.append(c2);
        Intrinsics.o(append, "append(value)");
        Appendable append2 = append.append(10);
        Intrinsics.o(append2, "append('\\n')");
        return append2;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final Appendable e(Appendable appendable, CharSequence charSequence) {
        Intrinsics.p(appendable, "<this>");
        Appendable append = appendable.append(charSequence);
        Intrinsics.o(append, "append(value)");
        Appendable append2 = append.append(10);
        Intrinsics.o(append2, "append('\\n')");
        return append2;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T extends Appendable> T f(@NotNull T t, @NotNull CharSequence charSequence, int i2, int i3) {
        Intrinsics.p(t, "<this>");
        Intrinsics.p(charSequence, "value");
        T append = t.append(charSequence, i2, i3);
        Intrinsics.n(append, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return append;
    }
}
