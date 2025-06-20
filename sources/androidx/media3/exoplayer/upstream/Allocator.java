package androidx.media3.exoplayer.upstream;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface Allocator {

    public interface AllocationNode {
        Allocation a();

        @Nullable
        AllocationNode next();
    }

    void a(AllocationNode allocationNode);

    Allocation b();

    void c(Allocation allocation);

    void d();

    int e();

    int f();
}
