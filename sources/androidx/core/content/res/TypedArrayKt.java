package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\t\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001d\u0010\u0011\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0011\u0010\n\u001a\u001d\u0010\u0012\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\n\u001a\u001b\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0016\u001a\u00020\u000e*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0010\u001a\u001d\u0010\u0018\u001a\u00020\u0017*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001b\u0010\u001a\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001a\u0010\n\u001a\u001b\u0010\u001b\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001b\u0010\n\u001a\u001d\u0010\u001c\u001a\u00020\u0001*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u001c\u0010\n\u001a\u001b\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001b\u0010!\u001a\u00020 *\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b!\u0010\"\u001a!\u0010$\u001a\b\u0012\u0004\u0012\u00020 0#*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b$\u0010%\u001a.\u0010)\u001a\u00028\u0000\"\u0004\b\u0000\u0010&*\u00020\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000'H\b¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"Landroid/content/res/TypedArray;", "", "index", "", "a", "(Landroid/content/res/TypedArray;I)V", "", "b", "(Landroid/content/res/TypedArray;I)Z", "c", "(Landroid/content/res/TypedArray;I)I", "Landroid/content/res/ColorStateList;", "d", "(Landroid/content/res/TypedArray;I)Landroid/content/res/ColorStateList;", "", "e", "(Landroid/content/res/TypedArray;I)F", "f", "g", "Landroid/graphics/drawable/Drawable;", "h", "(Landroid/content/res/TypedArray;I)Landroid/graphics/drawable/Drawable;", "i", "Landroid/graphics/Typeface;", "j", "(Landroid/content/res/TypedArray;I)Landroid/graphics/Typeface;", "k", "l", "m", "", "n", "(Landroid/content/res/TypedArray;I)Ljava/lang/String;", "", "p", "(Landroid/content/res/TypedArray;I)Ljava/lang/CharSequence;", "", "o", "(Landroid/content/res/TypedArray;I)[Ljava/lang/CharSequence;", "R", "Lkotlin/Function1;", "block", "q", "(Landroid/content/res/TypedArray;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class TypedArrayKt {
    private static final void a(TypedArray typedArray, @StyleableRes int i2) {
        if (!typedArray.hasValue(i2)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean b(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        return typedArray.getBoolean(i2, false);
    }

    @ColorInt
    public static final int c(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        return typedArray.getColor(i2, 0);
    }

    @NotNull
    public static final ColorStateList d(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        ColorStateList colorStateList = typedArray.getColorStateList(i2);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float e(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        return typedArray.getDimension(i2, 0.0f);
    }

    @Dimension
    public static final int f(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        return typedArray.getDimensionPixelOffset(i2, 0);
    }

    @Dimension
    public static final int g(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        return typedArray.getDimensionPixelSize(i2, 0);
    }

    @NotNull
    public static final Drawable h(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        Drawable drawable = typedArray.getDrawable(i2);
        Intrinsics.m(drawable);
        return drawable;
    }

    public static final float i(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        return typedArray.getFloat(i2, 0.0f);
    }

    @RequiresApi(26)
    @NotNull
    public static final Typeface j(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        return TypedArrayApi26ImplKt.a(typedArray, i2);
    }

    public static final int k(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        return typedArray.getInt(i2, 0);
    }

    public static final int l(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        return typedArray.getInteger(i2, 0);
    }

    @AnyRes
    public static final int m(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        return typedArray.getResourceId(i2, 0);
    }

    @NotNull
    public static final String n(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        String string = typedArray.getString(i2);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    @NotNull
    public static final CharSequence[] o(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        return typedArray.getTextArray(i2);
    }

    @NotNull
    public static final CharSequence p(@NotNull TypedArray typedArray, @StyleableRes int i2) {
        a(typedArray, i2);
        CharSequence text = typedArray.getText(i2);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R q(@NotNull TypedArray typedArray, @NotNull Function1<? super TypedArray, ? extends R> function1) {
        R f2 = function1.f(typedArray);
        typedArray.recycle();
        return f2;
    }
}
