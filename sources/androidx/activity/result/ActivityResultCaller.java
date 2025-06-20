package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;

public interface ActivityResultCaller {
    @NonNull
    <I, O> ActivityResultLauncher<I> G(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback);

    @NonNull
    <I, O> ActivityResultLauncher<I> t(@NonNull ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultRegistry activityResultRegistry, @NonNull ActivityResultCallback<O> activityResultCallback);
}
