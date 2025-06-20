package androidx.activity.result;

import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "mediaType", "Landroidx/activity/result/PickVisualMediaRequest;", "a", "(Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;)Landroidx/activity/result/PickVisualMediaRequest;", "activity_release"}, k = 2, mv = {1, 8, 0})
public final class PickVisualMediaRequestKt {
    @NotNull
    public static final PickVisualMediaRequest a(@NotNull ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType) {
        Intrinsics.p(visualMediaType, "mediaType");
        return new PickVisualMediaRequest.Builder().b(visualMediaType).a();
    }

    public static /* synthetic */ PickVisualMediaRequest b(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            visualMediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.f2505a;
        }
        return a(visualMediaType);
    }
}
