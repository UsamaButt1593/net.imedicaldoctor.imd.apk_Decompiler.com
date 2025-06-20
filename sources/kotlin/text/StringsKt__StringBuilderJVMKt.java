package kotlin.text;

import com.itextpdf.text.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u001b\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a(\u0010\t\u001a\u00020\b*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n\u001a4\u0010\u000e\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\rH\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a$\u0010\u0010\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a,\u0010\u0012\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a>\u0010\u0017\u001a\u00020\b*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a4\u0010\u0019\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a4\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a<\u0010\u001e\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a<\u0010 \u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\b¢\u0006\u0004\b \u0010!\u001a&\u0010#\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\"H\b¢\u0006\u0004\b#\u0010$\u001a,\u0010%\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u000e\u0010\u0007\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\b¢\u0006\u0004\b%\u0010&\u001a$\u0010'\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020\u0004H\b¢\u0006\u0004\b'\u0010\u0011\u001a$\u0010)\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020(H\b¢\u0006\u0004\b)\u0010*\u001a$\u0010,\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020+H\b¢\u0006\u0004\b,\u0010-\u001a$\u0010/\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020.H\b¢\u0006\u0004\b/\u00100\u001a$\u00102\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u000201H\b¢\u0006\u0004\b2\u00103\u001a$\u00105\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u000204H\b¢\u0006\u0004\b5\u00106\u001a\u001b\u00109\u001a\u000607j\u0002`8*\u000607j\u0002`8H\u0007¢\u0006\u0004\b9\u0010:\u001a&\u0010;\u001a\u000607j\u0002`8*\u000607j\u0002`82\b\u0010\u0007\u001a\u0004\u0018\u00010\u001bH\b¢\u0006\u0004\b;\u0010<\u001a$\u0010=\u001a\u000607j\u0002`8*\u000607j\u0002`82\u0006\u0010\u0007\u001a\u00020\u0006H\b¢\u0006\u0004\b=\u0010>\u001a\u001b\u0010?\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0007¢\u0006\u0004\b?\u0010\u0003\u001a&\u0010@\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\"H\b¢\u0006\u0004\b@\u0010$\u001a&\u0010A\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u001bH\b¢\u0006\u0004\bA\u0010B\u001a&\u0010C\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\rH\b¢\u0006\u0004\bC\u0010D\u001a&\u0010F\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010EH\b¢\u0006\u0004\bF\u0010G\u001a,\u0010H\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u000e\u0010\u0007\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\b¢\u0006\u0004\bH\u0010&\u001a$\u0010I\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020\u0014H\b¢\u0006\u0004\bI\u0010J\u001a$\u0010K\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\b¢\u0006\u0004\bK\u0010L\u001a$\u0010N\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020MH\b¢\u0006\u0004\bN\u0010O\u001a$\u0010P\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020\u0004H\b¢\u0006\u0004\bP\u0010\u0011\u001a$\u0010Q\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020(H\b¢\u0006\u0004\bQ\u0010*\u001a$\u0010R\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020+H\b¢\u0006\u0004\bR\u0010-\u001a$\u0010S\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u00020.H\b¢\u0006\u0004\bS\u00100\u001a$\u0010T\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u000201H\b¢\u0006\u0004\bT\u00103\u001a$\u0010U\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0007\u001a\u000204H\b¢\u0006\u0004\bU\u00106¨\u0006V"}, d2 = {"Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Y", "(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "", "index", "", "value", "", "d0", "(Ljava/lang/StringBuilder;IC)V", "startIndex", "endIndex", "", "e0", "(Ljava/lang/StringBuilder;IILjava/lang/String;)Ljava/lang/StringBuilder;", "Z", "(Ljava/lang/StringBuilder;I)Ljava/lang/StringBuilder;", "a0", "(Ljava/lang/StringBuilder;II)Ljava/lang/StringBuilder;", "", "destination", "destinationOffset", "f0", "(Ljava/lang/StringBuilder;[CIII)V", "F", "(Ljava/lang/StringBuilder;[CII)Ljava/lang/StringBuilder;", "", "E", "(Ljava/lang/StringBuilder;Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;", "c0", "(Ljava/lang/StringBuilder;I[CII)Ljava/lang/StringBuilder;", "b0", "(Ljava/lang/StringBuilder;ILjava/lang/CharSequence;II)Ljava/lang/StringBuilder;", "Ljava/lang/StringBuffer;", "B", "(Ljava/lang/StringBuilder;Ljava/lang/StringBuffer;)Ljava/lang/StringBuilder;", "C", "(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "z", "", "D", "(Ljava/lang/StringBuilder;S)Ljava/lang/StringBuilder;", "", "w", "(Ljava/lang/StringBuilder;B)Ljava/lang/StringBuilder;", "", "A", "(Ljava/lang/StringBuilder;J)Ljava/lang/StringBuilder;", "", "y", "(Ljava/lang/StringBuilder;F)Ljava/lang/StringBuilder;", "", "x", "(Ljava/lang/StringBuilder;D)Ljava/lang/StringBuilder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "G", "(Ljava/lang/Appendable;)Ljava/lang/Appendable;", "I", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "H", "(Ljava/lang/Appendable;C)Ljava/lang/Appendable;", "J", "T", "Q", "(Ljava/lang/StringBuilder;Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;", "S", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "", "R", "(Ljava/lang/StringBuilder;Ljava/lang/Object;)Ljava/lang/StringBuilder;", "U", "X", "(Ljava/lang/StringBuilder;[C)Ljava/lang/StringBuilder;", "L", "(Ljava/lang/StringBuilder;C)Ljava/lang/StringBuilder;", "", "W", "(Ljava/lang/StringBuilder;Z)Ljava/lang/StringBuilder;", "O", "V", "K", "P", "N", "M", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/text/StringsKt")
@SourceDebugExtension({"SMAP\nStringBuilderJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringBuilderJVM.kt\nkotlin/text/StringsKt__StringBuilderJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,381:1\n1#2:382\n*E\n"})
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder A(StringBuilder sb, long j2) {
        Intrinsics.p(sb, "<this>");
        sb.append(j2);
        Intrinsics.o(sb, "append(value)");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder B(StringBuilder sb, StringBuffer stringBuffer) {
        Intrinsics.p(sb, "<this>");
        sb.append(stringBuffer);
        Intrinsics.o(sb, "append(value)");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder C(StringBuilder sb, StringBuilder sb2) {
        Intrinsics.p(sb, "<this>");
        sb.append(sb2);
        Intrinsics.o(sb, "append(value)");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder D(StringBuilder sb, short s) {
        Intrinsics.p(sb, "<this>");
        sb.append(s);
        Intrinsics.o(sb, "append(value.toInt())");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final StringBuilder E(StringBuilder sb, CharSequence charSequence, int i2, int i3) {
        Intrinsics.p(sb, "<this>");
        Intrinsics.p(charSequence, "value");
        sb.append(charSequence, i2, i3);
        Intrinsics.o(sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final StringBuilder F(StringBuilder sb, char[] cArr, int i2, int i3) {
        Intrinsics.p(sb, "<this>");
        Intrinsics.p(cArr, "value");
        sb.append(cArr, i2, i3 - i2);
        Intrinsics.o(sb, "this.append(value, start…x, endIndex - startIndex)");
        return sb;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final Appendable G(@NotNull Appendable appendable) {
        Intrinsics.p(appendable, "<this>");
        Appendable append = appendable.append(SystemProperties.f29113b);
        Intrinsics.o(append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final Appendable H(Appendable appendable, char c2) {
        Intrinsics.p(appendable, "<this>");
        Appendable append = appendable.append(c2);
        Intrinsics.o(append, "append(value)");
        return G(append);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final Appendable I(Appendable appendable, CharSequence charSequence) {
        Intrinsics.p(appendable, "<this>");
        Appendable append = appendable.append(charSequence);
        Intrinsics.o(append, "append(value)");
        return G(append);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final StringBuilder J(@NotNull StringBuilder sb) {
        Intrinsics.p(sb, "<this>");
        sb.append(SystemProperties.f29113b);
        Intrinsics.o(sb, "append(SystemProperties.LINE_SEPARATOR)");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder K(StringBuilder sb, byte b2) {
        Intrinsics.p(sb, "<this>");
        sb.append(b2);
        Intrinsics.o(sb, "append(value.toInt())");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder L(StringBuilder sb, char c2) {
        Intrinsics.p(sb, "<this>");
        sb.append(c2);
        Intrinsics.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder M(StringBuilder sb, double d2) {
        Intrinsics.p(sb, "<this>");
        sb.append(d2);
        Intrinsics.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder N(StringBuilder sb, float f2) {
        Intrinsics.p(sb, "<this>");
        sb.append(f2);
        Intrinsics.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder O(StringBuilder sb, int i2) {
        Intrinsics.p(sb, "<this>");
        sb.append(i2);
        Intrinsics.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder P(StringBuilder sb, long j2) {
        Intrinsics.p(sb, "<this>");
        sb.append(j2);
        Intrinsics.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder Q(StringBuilder sb, CharSequence charSequence) {
        Intrinsics.p(sb, "<this>");
        sb.append(charSequence);
        Intrinsics.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder R(StringBuilder sb, Object obj) {
        Intrinsics.p(sb, "<this>");
        sb.append(obj);
        Intrinsics.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder S(StringBuilder sb, String str) {
        Intrinsics.p(sb, "<this>");
        sb.append(str);
        Intrinsics.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder T(StringBuilder sb, StringBuffer stringBuffer) {
        Intrinsics.p(sb, "<this>");
        sb.append(stringBuffer);
        Intrinsics.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder U(StringBuilder sb, StringBuilder sb2) {
        Intrinsics.p(sb, "<this>");
        sb.append(sb2);
        Intrinsics.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder V(StringBuilder sb, short s) {
        Intrinsics.p(sb, "<this>");
        sb.append(s);
        Intrinsics.o(sb, "append(value.toInt())");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder W(StringBuilder sb, boolean z) {
        Intrinsics.p(sb, "<this>");
        sb.append(z);
        Intrinsics.o(sb, "append(value)");
        return J(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @InlineOnly
    private static final StringBuilder X(StringBuilder sb, char[] cArr) {
        Intrinsics.p(sb, "<this>");
        Intrinsics.p(cArr, "value");
        sb.append(cArr);
        Intrinsics.o(sb, "append(value)");
        return J(sb);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final StringBuilder Y(@NotNull StringBuilder sb) {
        Intrinsics.p(sb, "<this>");
        sb.setLength(0);
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final StringBuilder Z(StringBuilder sb, int i2) {
        Intrinsics.p(sb, "<this>");
        StringBuilder deleteCharAt = sb.deleteCharAt(i2);
        Intrinsics.o(deleteCharAt, "this.deleteCharAt(index)");
        return deleteCharAt;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final StringBuilder a0(StringBuilder sb, int i2, int i3) {
        Intrinsics.p(sb, "<this>");
        StringBuilder delete = sb.delete(i2, i3);
        Intrinsics.o(delete, "this.delete(startIndex, endIndex)");
        return delete;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final StringBuilder b0(StringBuilder sb, int i2, CharSequence charSequence, int i3, int i4) {
        Intrinsics.p(sb, "<this>");
        Intrinsics.p(charSequence, "value");
        StringBuilder insert = sb.insert(i2, charSequence, i3, i4);
        Intrinsics.o(insert, "this.insert(index, value, startIndex, endIndex)");
        return insert;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final StringBuilder c0(StringBuilder sb, int i2, char[] cArr, int i3, int i4) {
        Intrinsics.p(sb, "<this>");
        Intrinsics.p(cArr, "value");
        StringBuilder insert = sb.insert(i2, cArr, i3, i4 - i3);
        Intrinsics.o(insert, "this.insert(index, value…x, endIndex - startIndex)");
        return insert;
    }

    @InlineOnly
    private static final void d0(StringBuilder sb, int i2, char c2) {
        Intrinsics.p(sb, "<this>");
        sb.setCharAt(i2, c2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final StringBuilder e0(StringBuilder sb, int i2, int i3, String str) {
        Intrinsics.p(sb, "<this>");
        Intrinsics.p(str, "value");
        StringBuilder replace = sb.replace(i2, i3, str);
        Intrinsics.o(replace, "this.replace(startIndex, endIndex, value)");
        return replace;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final void f0(StringBuilder sb, char[] cArr, int i2, int i3, int i4) {
        Intrinsics.p(sb, "<this>");
        Intrinsics.p(cArr, Annotation.l3);
        sb.getChars(i3, i4, cArr, i2);
    }

    static /* synthetic */ void g0(StringBuilder sb, char[] cArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = sb.length();
        }
        Intrinsics.p(sb, "<this>");
        Intrinsics.p(cArr, Annotation.l3);
        sb.getChars(i3, i4, cArr, i2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder w(StringBuilder sb, byte b2) {
        Intrinsics.p(sb, "<this>");
        sb.append(b2);
        Intrinsics.o(sb, "append(value.toInt())");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder x(StringBuilder sb, double d2) {
        Intrinsics.p(sb, "<this>");
        sb.append(d2);
        Intrinsics.o(sb, "append(value)");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder y(StringBuilder sb, float f2) {
        Intrinsics.p(sb, "<this>");
        sb.append(f2);
        Intrinsics.o(sb, "append(value)");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final StringBuilder z(StringBuilder sb, int i2) {
        Intrinsics.p(sb, "<this>");
        sb.append(i2);
        Intrinsics.o(sb, "append(value)");
        sb.append(10);
        Intrinsics.o(sb, "append('\\n')");
        return sb;
    }
}
