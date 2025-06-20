package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u001c\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\u0007\u001a\u00020\n*\u00020\nH\n¢\u0006\u0004\b\u0007\u0010\u000b\u001a\u0014\u0010\f\u001a\u00020\n*\u00020\nH\n¢\u0006\u0004\b\f\u0010\u000b\u001a\u0014\u0010\r\u001a\u00020\n*\u00020\nH\n¢\u0006\u0004\b\r\u0010\u000b\u001a\u0014\u0010\u000e\u001a\u00020\n*\u00020\nH\n¢\u0006\u0004\b\u000e\u0010\u000b\u001a\u0014\u0010\u000f\u001a\u00020\u0000*\u00020\nH\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0014\u0010\u0012\u001a\u00020\u0011*\u00020\nH\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\u0001*\u00020\u0011H\n¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u0011H\n¢\u0006\u0004\b\u0016\u0010\u0015\u001a\u0014\u0010\u0017\u001a\u00020\u0001*\u00020\u0011H\n¢\u0006\u0004\b\u0017\u0010\u0015\u001a\u0014\u0010\u0018\u001a\u00020\u0001*\u00020\u0011H\n¢\u0006\u0004\b\u0018\u0010\u0015\u001a\u0014\u0010\u0019\u001a\u00020\u0000*\u00020\u0011H\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\n*\u00020\u0011H\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001f\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\f¢\u0006\u0004\b\u001f\u0010 \u001a\u001c\u0010\"\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u001e\u001a\u00020!H\f¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010$\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001dH\f¢\u0006\u0004\b$\u0010%\u001a\u001c\u0010&\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001e\u001a\u00020!H\f¢\u0006\u0004\b&\u0010'\u001a\u001c\u0010(\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dH\f¢\u0006\u0004\b(\u0010)\u001a\u001c\u0010*\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001e\u001a\u00020!H\f¢\u0006\u0004\b*\u0010+\u001a\u0014\u0010-\u001a\u00020\n*\u00020,H\b¢\u0006\u0004\b-\u0010.\"\u0016\u00100\u001a\u00020\n*\u00020\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b/\u0010\u000b\"\u0016\u00102\u001a\u00020\n*\u00020\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b1\u0010\u000b\"\u0016\u00104\u001a\u00020\n*\u00020\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b3\u0010\u000b\"\u0016\u00106\u001a\u00020\n*\u00020\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b5\u0010\u000b\"\u0016\u00109\u001a\u00020\u0001*\u00020\n8Ç\u0002¢\u0006\u0006\u001a\u0004\b7\u00108\"\u0016\u00100\u001a\u00020\u0001*\u00020\u00118Ç\u0002¢\u0006\u0006\u001a\u0004\b:\u0010\u0015\"\u0016\u00102\u001a\u00020\u0001*\u00020\u00118Ç\u0002¢\u0006\u0006\u001a\u0004\b;\u0010\u0015\"\u0016\u00104\u001a\u00020\u0001*\u00020\u00118Ç\u0002¢\u0006\u0006\u001a\u0004\b<\u0010\u0015\"\u0016\u00106\u001a\u00020\u0001*\u00020\u00118Ç\u0002¢\u0006\u0006\u001a\u0004\b=\u0010\u0015\"\u0016\u00109\u001a\u00020\u0001*\u00020\u00118Ç\u0002¢\u0006\u0006\u001a\u0004\b>\u0010\u0015\"\u0016\u0010B\u001a\u00020?*\u00020\u00118Ç\u0002¢\u0006\u0006\u001a\u0004\b@\u0010A\"\u0016\u0010D\u001a\u00020?*\u00020\u00118Ç\u0002¢\u0006\u0006\u001a\u0004\bC\u0010A\"\u0016\u0010\u001e\u001a\u00020!*\u00020\u00118Ç\u0002¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006G"}, d2 = {"Landroid/graphics/Color;", "", "b", "(Landroid/graphics/Color;)F", "e", "h", "k", "c", "F", "(Landroid/graphics/Color;Landroid/graphics/Color;)Landroid/graphics/Color;", "", "(I)I", "f", "i", "l", "G", "(I)Landroid/graphics/Color;", "", "K", "(I)J", "a", "(J)F", "d", "g", "j", "H", "(J)Landroid/graphics/Color;", "I", "(J)I", "Landroid/graphics/ColorSpace$Named;", "colorSpace", "m", "(ILandroid/graphics/ColorSpace$Named;)J", "Landroid/graphics/ColorSpace;", "n", "(ILandroid/graphics/ColorSpace;)J", "o", "(JLandroid/graphics/ColorSpace$Named;)J", "p", "(JLandroid/graphics/ColorSpace;)J", "q", "(Landroid/graphics/Color;Landroid/graphics/ColorSpace$Named;)Landroid/graphics/Color;", "r", "(Landroid/graphics/Color;Landroid/graphics/ColorSpace;)Landroid/graphics/Color;", "", "J", "(Ljava/lang/String;)I", "t", "alpha", "C", "red", "y", "green", "v", "blue", "z", "(I)F", "luminance", "s", "B", "x", "u", "A", "", "D", "(J)Z", "isSrgb", "E", "isWideGamut", "w", "(J)Landroid/graphics/ColorSpace;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class ColorKt {
    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float A(long j2) {
        return Color.luminance(j2);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float B(long j2) {
        return Color.red(j2);
    }

    public static final int C(@ColorInt int i2) {
        return (i2 >> 16) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean D(long j2) {
        return Color.isSrgb(j2);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean E(long j2) {
        return Color.isWideGamut(j2);
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color F(@NotNull Color color, @NotNull Color color2) {
        return ColorUtils.w(color2, color);
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color G(@ColorInt int i2) {
        return Color.valueOf(i2);
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color H(long j2) {
        return Color.valueOf(j2);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @ColorInt
    public static final int I(long j2) {
        return Color.toArgb(j2);
    }

    @ColorInt
    public static final int J(@NotNull String str) {
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long K(@ColorInt int i2) {
        return Color.pack(i2);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float a(long j2) {
        return Color.red(j2);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float b(@NotNull Color color) {
        return color.getComponent(0);
    }

    public static final int c(@ColorInt int i2) {
        return (i2 >> 24) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float d(long j2) {
        return Color.green(j2);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float e(@NotNull Color color) {
        return color.getComponent(1);
    }

    public static final int f(@ColorInt int i2) {
        return (i2 >> 16) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float g(long j2) {
        return Color.blue(j2);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float h(@NotNull Color color) {
        return color.getComponent(2);
    }

    public static final int i(@ColorInt int i2) {
        return (i2 >> 8) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float j(long j2) {
        return Color.alpha(j2);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float k(@NotNull Color color) {
        return color.getComponent(3);
    }

    public static final int l(@ColorInt int i2) {
        return i2 & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long m(@ColorInt int i2, @NotNull ColorSpace.Named named) {
        return Color.convert(i2, ColorSpace.get(named));
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long n(@ColorInt int i2, @NotNull ColorSpace colorSpace) {
        return Color.convert(i2, colorSpace);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long o(long j2, @NotNull ColorSpace.Named named) {
        return Color.convert(j2, ColorSpace.get(named));
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long p(long j2, @NotNull ColorSpace colorSpace) {
        return Color.convert(j2, colorSpace);
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color q(@NotNull Color color, @NotNull ColorSpace.Named named) {
        return color.convert(ColorSpace.get(named));
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color r(@NotNull Color color, @NotNull ColorSpace colorSpace) {
        return color.convert(colorSpace);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float s(long j2) {
        return Color.alpha(j2);
    }

    public static final int t(@ColorInt int i2) {
        return (i2 >> 24) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float u(long j2) {
        return Color.blue(j2);
    }

    public static final int v(@ColorInt int i2) {
        return i2 & 255;
    }

    @RequiresApi(26)
    @NotNull
    @SuppressLint({"ClassVerificationFailure"})
    public static final ColorSpace w(long j2) {
        return Color.colorSpace(j2);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float x(long j2) {
        return Color.green(j2);
    }

    public static final int y(@ColorInt int i2) {
        return (i2 >> 8) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float z(@ColorInt int i2) {
        return Color.luminance(i2);
    }
}
