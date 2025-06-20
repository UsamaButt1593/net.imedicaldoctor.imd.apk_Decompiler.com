package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\n¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0006*\u00020\u0005H\n¢\u0006\u0004\b\t\u0010\b\u001a\u0014\u0010\u000b\u001a\u00020\u0006*\u00020\nH\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\r\u001a\u00020\u0006*\u00020\nH\n¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Landroid/util/Size;", "", "c", "(Landroid/util/Size;)I", "f", "Landroid/util/SizeF;", "", "a", "(Landroid/util/SizeF;)F", "d", "Landroidx/core/util/SizeFCompat;", "b", "(Landroidx/core/util/SizeFCompat;)F", "e", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SuppressLint({"ClassVerificationFailure"})
public final class SizeKt {
    @RequiresApi(21)
    public static final float a(@NotNull SizeF sizeF) {
        return sizeF.getWidth();
    }

    public static final float b(@NotNull SizeFCompat sizeFCompat) {
        return sizeFCompat.b();
    }

    @RequiresApi(21)
    public static final int c(@NotNull Size size) {
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final float d(@NotNull SizeF sizeF) {
        return sizeF.getHeight();
    }

    public static final float e(@NotNull SizeFCompat sizeFCompat) {
        return sizeFCompat.a();
    }

    @RequiresApi(21)
    public static final int f(@NotNull Size size) {
        return size.getHeight();
    }
}
