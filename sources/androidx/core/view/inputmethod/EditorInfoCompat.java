package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Preconditions;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class EditorInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6706a = 16777216;

    /* renamed from: b  reason: collision with root package name */
    public static final int f6707b = Integer.MIN_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f6708c = new String[0];

    /* renamed from: d  reason: collision with root package name */
    private static final String f6709d = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";

    /* renamed from: e  reason: collision with root package name */
    private static final String f6710e = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";

    /* renamed from: f  reason: collision with root package name */
    private static final String f6711f = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";

    /* renamed from: g  reason: collision with root package name */
    private static final String f6712g = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";

    /* renamed from: h  reason: collision with root package name */
    private static final String f6713h = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";

    /* renamed from: i  reason: collision with root package name */
    private static final String f6714i = "androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED";
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    static final int f6715j = 2048;
    @VisibleForTesting

    /* renamed from: k  reason: collision with root package name */
    static final int f6716k = 1024;

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        static CharSequence a(@NonNull EditorInfo editorInfo, int i2) {
            return editorInfo.getInitialSelectedText(i2);
        }

        static CharSequence b(@NonNull EditorInfo editorInfo, int i2, int i3) {
            return editorInfo.getInitialTextAfterCursor(i2, i3);
        }

        static CharSequence c(@NonNull EditorInfo editorInfo, int i2, int i3) {
            return editorInfo.getInitialTextBeforeCursor(i2, i3);
        }

        static void d(@NonNull EditorInfo editorInfo, CharSequence charSequence, int i2) {
            editorInfo.setInitialSurroundingSubText(charSequence, i2);
        }
    }

    @NonNull
    public static String[] a(@NonNull EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] a2 = editorInfo.contentMimeTypes;
            return a2 != null ? a2 : f6708c;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return f6708c;
        }
        String[] stringArray = bundle.getStringArray(f6709d);
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray(f6710e);
        }
        return stringArray != null ? stringArray : f6708c;
    }

    @Nullable
    public static CharSequence b(@NonNull EditorInfo editorInfo, int i2) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.a(editorInfo, i2);
        }
        if (editorInfo.extras == null) {
            return null;
        }
        int min = Math.min(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int max = Math.max(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int i3 = editorInfo.extras.getInt(f6712g);
        int i4 = editorInfo.extras.getInt(f6713h);
        int i5 = max - min;
        if (editorInfo.initialSelStart < 0 || editorInfo.initialSelEnd < 0 || i4 - i3 != i5 || (charSequence = editorInfo.extras.getCharSequence(f6711f)) == null) {
            return null;
        }
        return (i2 & 1) != 0 ? charSequence.subSequence(i3, i4) : TextUtils.substring(charSequence, i3, i4);
    }

    @Nullable
    public static CharSequence c(@NonNull EditorInfo editorInfo, int i2, int i3) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.b(editorInfo, i2, i3);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(f6711f)) == null) {
            return null;
        }
        int i4 = editorInfo.extras.getInt(f6713h);
        int i5 = i3 & 1;
        int min = Math.min(i2, charSequence.length() - i4) + i4;
        return i5 != 0 ? charSequence.subSequence(i4, min) : TextUtils.substring(charSequence, i4, min);
    }

    @Nullable
    public static CharSequence d(@NonNull EditorInfo editorInfo, int i2, int i3) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.c(editorInfo, i2, i3);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(f6711f)) == null) {
            return null;
        }
        int i4 = editorInfo.extras.getInt(f6712g);
        int i5 = i3 & 1;
        int min = i4 - Math.min(i2, i4);
        return i5 != 0 ? charSequence.subSequence(min, i4) : TextUtils.substring(charSequence, min, i4);
    }

    static int e(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return 0;
        }
        boolean containsKey = bundle.containsKey(f6709d);
        boolean containsKey2 = editorInfo.extras.containsKey(f6710e);
        if (containsKey && containsKey2) {
            return 4;
        }
        if (containsKey) {
            return 3;
        }
        return containsKey2 ? 2 : 0;
    }

    private static boolean f(CharSequence charSequence, int i2, int i3) {
        if (i3 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i2));
        }
        if (i3 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i2));
    }

    private static boolean g(int i2) {
        int i3 = i2 & 4095;
        return i3 == 129 || i3 == 225 || i3 == 18;
    }

    public static boolean h(@NonNull EditorInfo editorInfo) {
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(f6714i);
    }

    public static void i(@NonNull EditorInfo editorInfo, @Nullable String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray(f6709d, strArr);
        editorInfo.extras.putStringArray(f6710e, strArr);
    }

    public static void j(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence, int i2) {
        Preconditions.l(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.d(editorInfo, charSequence, i2);
            return;
        }
        int i3 = editorInfo.initialSelStart;
        int i4 = editorInfo.initialSelEnd;
        int i5 = i3 > i4 ? i4 - i2 : i3 - i2;
        int i6 = i3 > i4 ? i3 - i2 : i4 - i2;
        int length = charSequence.length();
        if (i2 < 0 || i5 < 0 || i6 > length) {
            m(editorInfo, (CharSequence) null, 0, 0);
        } else if (g(editorInfo.inputType)) {
            m(editorInfo, (CharSequence) null, 0, 0);
        } else if (length <= 2048) {
            m(editorInfo, charSequence, i5, i6);
        } else {
            n(editorInfo, charSequence, i5, i6);
        }
    }

    public static void k(@NonNull EditorInfo editorInfo, @NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.d(editorInfo, charSequence, 0);
        } else {
            j(editorInfo, charSequence, 0);
        }
    }

    public static void l(@NonNull EditorInfo editorInfo, boolean z) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putBoolean(f6714i, z);
    }

    private static void m(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence(f6711f, charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt(f6712g, i2);
        editorInfo.extras.putInt(f6713h, i3);
    }

    private static void n(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        int i4 = i3 - i2;
        int i5 = i4 > 1024 ? 0 : i4;
        int i6 = 2048 - i5;
        int min = Math.min(charSequence.length() - i3, i6 - Math.min(i2, (int) (((double) i6) * 0.8d)));
        int min2 = Math.min(i2, i6 - min);
        int i7 = i2 - min2;
        if (f(charSequence, i7, 0)) {
            i7++;
            min2--;
        }
        if (f(charSequence, (i3 + min) - 1, 1)) {
            min--;
        }
        m(editorInfo, i5 != i4 ? TextUtils.concat(new CharSequence[]{charSequence.subSequence(i7, i7 + min2), charSequence.subSequence(i3, min + i3)}) : charSequence.subSequence(i7, min2 + i5 + min + i7), min2, i5 + min2);
    }
}
