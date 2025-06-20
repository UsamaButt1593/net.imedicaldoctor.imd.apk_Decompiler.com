package androidx.core.graphics;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"androidx/core/graphics/RegionKt$iterator$1", "", "Landroid/graphics/Rect;", "", "hasNext", "()Z", "a", "()Landroid/graphics/Rect;", "Landroid/graphics/RegionIterator;", "s", "Landroid/graphics/RegionIterator;", "iterator", "X", "Landroid/graphics/Rect;", "rect", "Y", "Z", "hasMore", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
public final class RegionKt$iterator$1 implements Iterator<Rect>, KMappedMarker {
    @NotNull
    private final Rect X;
    private boolean Y;
    @NotNull
    private final RegionIterator s;

    RegionKt$iterator$1(Region region) {
        RegionIterator regionIterator = new RegionIterator(region);
        this.s = regionIterator;
        Rect rect = new Rect();
        this.X = rect;
        this.Y = regionIterator.next(rect);
    }

    @NotNull
    /* renamed from: a */
    public Rect next() {
        if (this.Y) {
            Rect rect = new Rect(this.X);
            this.Y = this.s.next(this.X);
            return rect;
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean hasNext() {
        return this.Y;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
