package androidx.media3.common;

import android.util.Pair;
import java.lang.Throwable;

public interface ErrorMessageProvider<T extends Throwable> {
    Pair<Integer, String> a(T t);
}
