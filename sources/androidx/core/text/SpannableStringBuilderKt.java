package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a)\u0010\u0006\u001a\u00020\u00052\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001aA\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\t2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a-\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u0012\u0010\u0011\u001a-\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u0013\u0010\u0011\u001a7\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0015\u001a\u00020\u00142\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a7\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0015\u001a\u00020\u00142\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u0018\u0010\u0017\u001a-\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u0019\u0010\u0011\u001a5\u0010\u001c\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001a2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u001e\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u001e\u0010\u0011\u001a-\u0010\u001f\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\b¢\u0006\u0004\b\u001f\u0010\u0011¨\u0006 "}, d2 = {"Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "Landroid/text/SpannedString;", "c", "(Lkotlin/jvm/functions/Function1;)Landroid/text/SpannedString;", "", "", "spans", "f", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "span", "e", "(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "b", "(Landroid/text/SpannableStringBuilder;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "g", "l", "", "color", "d", "(Landroid/text/SpannableStringBuilder;ILkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "a", "i", "", "proportion", "h", "(Landroid/text/SpannableStringBuilder;FLkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "k", "j", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSpannableStringBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableStringBuilder.kt\nandroidx/core/text/SpannableStringBuilderKt\n*L\n1#1,163:1\n74#1,4:164\n74#1,4:168\n74#1,4:172\n74#1,4:176\n74#1,4:180\n74#1,4:184\n74#1,4:188\n74#1,4:192\n74#1,4:196\n*S KotlinDebug\n*F\n+ 1 SpannableStringBuilder.kt\nandroidx/core/text/SpannableStringBuilderKt\n*L\n87#1:164,4\n96#1:168,4\n105#1:172,4\n115#1:176,4\n125#1:180,4\n134#1:184,4\n144#1:188,4\n153#1:192,4\n162#1:196,4\n*E\n"})
public final class SpannableStringBuilderKt {
    @NotNull
    public static final SpannableStringBuilder a(@NotNull SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, @NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i2);
        int length = spannableStringBuilder.length();
        function1.f(spannableStringBuilder);
        spannableStringBuilder.setSpan(backgroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder b(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableStringBuilder.length();
        function1.f(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannedString c(@NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        function1.f(spannableStringBuilder);
        return new SpannedString(spannableStringBuilder);
    }

    @NotNull
    public static final SpannableStringBuilder d(@NotNull SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, @NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i2);
        int length = spannableStringBuilder.length();
        function1.f(spannableStringBuilder);
        spannableStringBuilder.setSpan(foregroundColorSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder e(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Object obj, @NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        int length = spannableStringBuilder.length();
        function1.f(spannableStringBuilder);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder f(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Object[] objArr, @NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        int length = spannableStringBuilder.length();
        function1.f(spannableStringBuilder);
        for (Object span : objArr) {
            spannableStringBuilder.setSpan(span, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder g(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        StyleSpan styleSpan = new StyleSpan(2);
        int length = spannableStringBuilder.length();
        function1.f(spannableStringBuilder);
        spannableStringBuilder.setSpan(styleSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder h(@NotNull SpannableStringBuilder spannableStringBuilder, float f2, @NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f2);
        int length = spannableStringBuilder.length();
        function1.f(spannableStringBuilder);
        spannableStringBuilder.setSpan(relativeSizeSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder i(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int length = spannableStringBuilder.length();
        function1.f(spannableStringBuilder);
        spannableStringBuilder.setSpan(strikethroughSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder j(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int length = spannableStringBuilder.length();
        function1.f(spannableStringBuilder);
        spannableStringBuilder.setSpan(subscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder k(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int length = spannableStringBuilder.length();
        function1.f(spannableStringBuilder);
        spannableStringBuilder.setSpan(superscriptSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    @NotNull
    public static final SpannableStringBuilder l(@NotNull SpannableStringBuilder spannableStringBuilder, @NotNull Function1<? super SpannableStringBuilder, Unit> function1) {
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int length = spannableStringBuilder.length();
        function1.f(spannableStringBuilder);
        spannableStringBuilder.setSpan(underlineSpan, length, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }
}
