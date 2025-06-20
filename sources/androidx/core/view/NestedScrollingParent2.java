package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

public interface NestedScrollingParent2 extends NestedScrollingParent {
    void q(@NonNull View view, int i2, int i3, int i4, int i5, int i6);

    boolean r(@NonNull View view, @NonNull View view2, int i2, int i3);

    void s(@NonNull View view, @NonNull View view2, int i2, int i3);

    void t(@NonNull View view, int i2);

    void u(@NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4);
}
