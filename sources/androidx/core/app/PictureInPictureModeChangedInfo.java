package androidx.core.app;

import android.content.res.Configuration;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0011\u0010\u0007\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b\t\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/core/app/PictureInPictureModeChangedInfo;", "", "", "isInPictureInPictureMode", "<init>", "(Z)V", "Landroid/content/res/Configuration;", "newConfig", "(ZLandroid/content/res/Configuration;)V", "a", "Z", "b", "()Z", "Landroid/content/res/Configuration;", "newConfiguration", "()Landroid/content/res/Configuration;", "core_release"}, k = 1, mv = {1, 8, 0})
public final class PictureInPictureModeChangedInfo {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f5567a;
    @RequiresApi(26)
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Configuration f5568b;

    public PictureInPictureModeChangedInfo(boolean z) {
        this.f5567a = z;
    }

    @RequiresApi(26)
    @NotNull
    public final Configuration a() {
        Configuration configuration = this.f5568b;
        if (configuration != null) {
            return configuration;
        }
        throw new IllegalStateException("PictureInPictureModeChangedInfo must be constructed with the constructor that takes a Configuration to access the newConfig. Are you running on an API 26 or higher device that makes this information available?".toString());
    }

    public final boolean b() {
        return this.f5567a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RequiresApi(26)
    public PictureInPictureModeChangedInfo(boolean z, @NotNull Configuration configuration) {
        this(z);
        Intrinsics.p(configuration, "newConfig");
        this.f5568b = configuration;
    }
}
