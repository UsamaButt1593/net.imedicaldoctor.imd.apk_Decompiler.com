package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface OnReceiveContentListener {
    @Nullable
    ContentInfoCompat a(@NonNull View view, @NonNull ContentInfoCompat contentInfoCompat);
}
