package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypedArrayUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5799a = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int a(@NonNull Context context, int i2, int i3) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId != 0 ? i2 : i3;
    }

    public static boolean b(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i3, boolean z) {
        return typedArray.getBoolean(i2, typedArray.getBoolean(i3, z));
    }

    @Nullable
    public static Drawable c(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i3) {
        Drawable drawable = typedArray.getDrawable(i2);
        return drawable == null ? typedArray.getDrawable(i3) : drawable;
    }

    public static int d(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i3, int i4) {
        return typedArray.getInt(i2, typedArray.getInt(i3, i4));
    }

    public static boolean e(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i2, boolean z) {
        return !r(xmlPullParser, str) ? z : typedArray.getBoolean(i2, z);
    }

    @ColorInt
    public static int f(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i2, @ColorInt int i3) {
        return !r(xmlPullParser, str) ? i3 : typedArray.getColor(i2, i3);
    }

    @Nullable
    public static ColorStateList g(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i2) {
        if (!r(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i2, typedValue);
        int i3 = typedValue.type;
        if (i3 != 2) {
            return (i3 < 28 || i3 > 31) ? ColorStateListInflaterCompat.d(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme) : h(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i2 + ": " + typedValue);
    }

    @NonNull
    private static ColorStateList h(@NonNull TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static ComplexColorCompat i(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @Nullable Resources.Theme theme, @NonNull String str, @StyleableRes int i2, @ColorInt int i3) {
        if (r(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            int i4 = typedValue.type;
            if (i4 >= 28 && i4 <= 31) {
                return ComplexColorCompat.b(typedValue.data);
            }
            ComplexColorCompat g2 = ComplexColorCompat.g(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            if (g2 != null) {
                return g2;
            }
        }
        return ComplexColorCompat.b(i3);
    }

    public static float j(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i2, float f2) {
        return !r(xmlPullParser, str) ? f2 : typedArray.getFloat(i2, f2);
    }

    public static int k(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i2, int i3) {
        return !r(xmlPullParser, str) ? i3 : typedArray.getInt(i2, i3);
    }

    @AnyRes
    public static int l(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i2, @AnyRes int i3) {
        return !r(xmlPullParser, str) ? i3 : typedArray.getResourceId(i2, i3);
    }

    @Nullable
    public static String m(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i2) {
        if (!r(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i2);
    }

    @AnyRes
    public static int n(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i3, @AnyRes int i4) {
        return typedArray.getResourceId(i2, typedArray.getResourceId(i3, i4));
    }

    @Nullable
    public static String o(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i3) {
        String string = typedArray.getString(i2);
        return string == null ? typedArray.getString(i3) : string;
    }

    @Nullable
    public static CharSequence p(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i3) {
        CharSequence text = typedArray.getText(i2);
        return text == null ? typedArray.getText(i3) : text;
    }

    @Nullable
    public static CharSequence[] q(@NonNull TypedArray typedArray, @StyleableRes int i2, @StyleableRes int i3) {
        CharSequence[] textArray = typedArray.getTextArray(i2);
        return textArray == null ? typedArray.getTextArray(i3) : textArray;
    }

    public static boolean r(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        return xmlPullParser.getAttributeValue(f5799a, str) != null;
    }

    @NonNull
    public static TypedArray s(@NonNull Resources resources, @Nullable Resources.Theme theme, @NonNull AttributeSet attributeSet, @NonNull int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @Nullable
    public static TypedValue t(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, int i2) {
        if (!r(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i2);
    }
}
