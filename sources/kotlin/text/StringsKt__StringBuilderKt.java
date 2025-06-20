package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a&\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a=\u0010\u000b\u001a\u00020\n2\u001b\u0010\t\u001a\u0017\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u000b\u0010\f\u001aE\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u001b\u0010\t\u001a\u0017\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a1\u0010\u0013\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\u0011\"\u0004\u0018\u00010\n¢\u0006\u0004\b\u0013\u0010\u0014\u001a1\u0010\u0015\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0011\"\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a4\u0010\u001b\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a&\u0010 \u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u001fH\b¢\u0006\u0004\b \u0010!\u001a&\u0010\"\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\b¢\u0006\u0004\b\"\u0010#\u001a&\u0010$\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\b¢\u0006\u0004\b$\u0010\u0005\u001a$\u0010%\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0012\u001a\u00020\u0017H\b¢\u0006\u0004\b%\u0010&\u001a$\u0010(\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0012\u001a\u00020'H\b¢\u0006\u0004\b(\u0010)\u001a$\u0010+\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0012\u001a\u00020*H\b¢\u0006\u0004\b+\u0010,\u0002\u0007\n\u0005\b20\u0001¨\u0006-"}, d2 = {"Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "obj", "h0", "(Ljava/lang/StringBuilder;Ljava/lang/Object;)Ljava/lang/StringBuilder;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "", "t0", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "", "capacity", "s0", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/String;", "", "value", "k0", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "j0", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "", "str", "offset", "len", "i0", "(Ljava/lang/StringBuilder;[CII)Ljava/lang/StringBuilder;", "l0", "(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "", "n0", "(Ljava/lang/StringBuilder;Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;", "p0", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "o0", "r0", "(Ljava/lang/StringBuilder;[C)Ljava/lang/StringBuilder;", "", "m0", "(Ljava/lang/StringBuilder;C)Ljava/lang/StringBuilder;", "", "q0", "(Ljava/lang/StringBuilder;Z)Ljava/lang/StringBuilder;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/text/StringsKt")
class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    @InlineOnly
    private static final StringBuilder h0(StringBuilder sb, Object obj) {
        Intrinsics.p(sb, "<this>");
        sb.append(obj);
        Intrinsics.o(sb, "this.append(obj)");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use appendRange instead.", replaceWith = @ReplaceWith(expression = "this.appendRange(str, offset, offset + len)", imports = {}))
    @InlineOnly
    private static final StringBuilder i0(StringBuilder sb, char[] cArr, int i2, int i3) {
        Intrinsics.p(sb, "<this>");
        Intrinsics.p(cArr, "str");
        throw new NotImplementedError((String) null, 1, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final StringBuilder j0(@NotNull StringBuilder sb, @NotNull Object... objArr) {
        Intrinsics.p(sb, "<this>");
        Intrinsics.p(objArr, "value");
        for (Object append : objArr) {
            sb.append(append);
        }
        return sb;
    }

    @NotNull
    public static final StringBuilder k0(@NotNull StringBuilder sb, @NotNull String... strArr) {
        Intrinsics.p(sb, "<this>");
        Intrinsics.p(strArr, "value");
        for (String append : strArr) {
            sb.append(append);
        }
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder l0(StringBuilder sb) {
        Intrinsics.p(sb, "<this>");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder m0(StringBuilder sb, char c2) {
        Intrinsics.p(sb, "<this>");
        sb.append(c2);
        Intrinsics.o(sb, "append(value)");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder n0(StringBuilder sb, CharSequence charSequence) {
        Intrinsics.p(sb, "<this>");
        sb.append(charSequence);
        Intrinsics.o(sb, "append(value)");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder o0(StringBuilder sb, Object obj) {
        Intrinsics.p(sb, "<this>");
        sb.append(obj);
        Intrinsics.o(sb, "append(value)");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder p0(StringBuilder sb, String str) {
        Intrinsics.p(sb, "<this>");
        sb.append(str);
        Intrinsics.o(sb, "append(value)");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder q0(StringBuilder sb, boolean z) {
        Intrinsics.p(sb, "<this>");
        sb.append(z);
        Intrinsics.o(sb, "append(value)");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder r0(StringBuilder sb, char[] cArr) {
        Intrinsics.p(sb, "<this>");
        Intrinsics.p(cArr, "value");
        sb.append(cArr);
        Intrinsics.o(sb, "append(value)");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String s0(int i2, Function1<? super StringBuilder, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        StringBuilder sb = new StringBuilder(i2);
        function1.f(sb);
        String sb2 = sb.toString();
        Intrinsics.o(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @InlineOnly
    private static final String t0(Function1<? super StringBuilder, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        StringBuilder sb = new StringBuilder();
        function1.f(sb);
        String sb2 = sb.toString();
        Intrinsics.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
