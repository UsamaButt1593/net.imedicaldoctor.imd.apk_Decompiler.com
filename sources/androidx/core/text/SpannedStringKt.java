package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a<\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0004*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "Landroid/text/Spanned;", "c", "(Ljava/lang/CharSequence;)Landroid/text/Spanned;", "", "T", "", "start", "end", "", "a", "(Landroid/text/Spanned;II)[Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class SpannedStringKt {
    public static /* synthetic */ Object[] b(Spanned spanned, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = spanned.length();
        }
        Intrinsics.y(4, ExifInterface.d5);
        return spanned.getSpans(i2, i3, Object.class);
    }

    @NotNull
    public static final Spanned c(@NotNull CharSequence charSequence) {
        return SpannedString.valueOf(charSequence);
    }
}
