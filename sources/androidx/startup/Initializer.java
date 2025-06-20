package androidx.startup;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.List;

public interface Initializer<T> {
    @NonNull
    T a(@NonNull Context context);

    @NonNull
    List<Class<? extends Initializer<?>>> dependencies();
}
