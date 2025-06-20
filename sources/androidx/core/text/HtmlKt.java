package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a6\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\b¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u000b\u001a\u00020\u0000*\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0001H\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"", "", "flags", "Landroid/text/Html$ImageGetter;", "imageGetter", "Landroid/text/Html$TagHandler;", "tagHandler", "Landroid/text/Spanned;", "a", "(Ljava/lang/String;ILandroid/text/Html$ImageGetter;Landroid/text/Html$TagHandler;)Landroid/text/Spanned;", "option", "c", "(Landroid/text/Spanned;I)Ljava/lang/String;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class HtmlKt {
    @NotNull
    public static final Spanned a(@NotNull String str, int i2, @Nullable Html.ImageGetter imageGetter, @Nullable Html.TagHandler tagHandler) {
        return HtmlCompat.b(str, i2, imageGetter, tagHandler);
    }

    public static /* synthetic */ Spanned b(String str, int i2, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            imageGetter = null;
        }
        if ((i3 & 4) != 0) {
            tagHandler = null;
        }
        return HtmlCompat.b(str, i2, imageGetter, tagHandler);
    }

    @NotNull
    public static final String c(@NotNull Spanned spanned, int i2) {
        return HtmlCompat.c(spanned, i2);
    }

    public static /* synthetic */ String d(Spanned spanned, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return HtmlCompat.c(spanned, i2);
    }
}
