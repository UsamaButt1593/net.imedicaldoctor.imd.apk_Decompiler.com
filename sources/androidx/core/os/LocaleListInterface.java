package androidx.core.os;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

interface LocaleListInterface {
    @IntRange(from = -1)
    int a(Locale locale);

    String b();

    Object c();

    @Nullable
    Locale d(@NonNull String[] strArr);

    Locale get(int i2);

    boolean isEmpty();

    @IntRange(from = 0)
    int size();
}
