package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0001H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a,\u0010\f\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\n¢\u0006\u0004\b\f\u0010\r\u001a$\u0010\u0010\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\n¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "Landroid/text/Spannable;", "d", "(Ljava/lang/CharSequence;)Landroid/text/Spannable;", "", "a", "(Landroid/text/Spannable;)V", "", "start", "end", "", "span", "b", "(Landroid/text/Spannable;IILjava/lang/Object;)V", "Lkotlin/ranges/IntRange;", "range", "c", "(Landroid/text/Spannable;Lkotlin/ranges/IntRange;Ljava/lang/Object;)V", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSpannableString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n+ 2 SpannedString.kt\nandroidx/core/text/SpannedStringKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,66:1\n31#2,4:67\n13579#3,2:71\n*S KotlinDebug\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n*L\n32#1:67,4\n32#1:71,2\n*E\n"})
public final class SpannableStringKt {
    public static final void a(@NotNull Spannable spannable) {
        for (Object removeSpan : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(removeSpan);
        }
    }

    public static final void b(@NotNull Spannable spannable, int i2, int i3, @NotNull Object obj) {
        spannable.setSpan(obj, i2, i3, 17);
    }

    public static final void c(@NotNull Spannable spannable, @NotNull IntRange intRange, @NotNull Object obj) {
        spannable.setSpan(obj, intRange.c().intValue(), intRange.h().intValue(), 17);
    }

    @NotNull
    public static final Spannable d(@NotNull CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }
}
