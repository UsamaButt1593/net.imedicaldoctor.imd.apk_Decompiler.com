package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

interface SpecialEffectsControllerFactory {
    @NonNull
    SpecialEffectsController a(@NonNull ViewGroup viewGroup);
}
