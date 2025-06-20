package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

public interface OnApplyWindowInsetsListener {
    @NonNull
    WindowInsetsCompat a(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat);
}
