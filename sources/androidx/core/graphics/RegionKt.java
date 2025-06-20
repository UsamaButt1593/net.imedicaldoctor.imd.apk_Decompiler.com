package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\n¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\f\u0010\t\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\n¢\u0006\u0004\b\r\u0010\u000b\u001a\u0014\u0010\u000e\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0010\u0010\u000f\u001a\u001c\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\f¢\u0006\u0004\b\u0011\u0010\t\u001a\u001c\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\f¢\u0006\u0004\b\u0012\u0010\u000b\u001a\u001c\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\f¢\u0006\u0004\b\u0013\u0010\t\u001a\u001c\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\f¢\u0006\u0004\b\u0014\u0010\u000b\u001a\u001c\u0010\u0015\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\f¢\u0006\u0004\b\u0015\u0010\t\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\f¢\u0006\u0004\b\u0016\u0010\u000b\u001a7\u0010\u001d\u001a\u00020\u001b*\u00020\u00002!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0017H\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u001f*\u00020\u0000H\u0002¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Landroid/graphics/Region;", "Landroid/graphics/Point;", "p", "", "c", "(Landroid/graphics/Region;Landroid/graphics/Point;)Z", "Landroid/graphics/Rect;", "r", "k", "(Landroid/graphics/Region;Landroid/graphics/Rect;)Landroid/graphics/Region;", "l", "(Landroid/graphics/Region;Landroid/graphics/Region;)Landroid/graphics/Region;", "f", "g", "m", "(Landroid/graphics/Region;)Landroid/graphics/Region;", "h", "i", "j", "a", "b", "n", "o", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "", "action", "d", "(Landroid/graphics/Region;Lkotlin/jvm/functions/Function1;)V", "", "e", "(Landroid/graphics/Region;)Ljava/util/Iterator;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRegion.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Region.kt\nandroidx/core/graphics/RegionKt\n*L\n1#1,158:1\n71#1,3:159\n35#1,3:162\n44#1,3:165\n*S KotlinDebug\n*F\n+ 1 Region.kt\nandroidx/core/graphics/RegionKt\n*L\n79#1:159,3\n84#1:162,3\n89#1:165,3\n*E\n"})
public final class RegionKt {
    @NotNull
    public static final Region a(@NotNull Region region, @NotNull Rect rect) {
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.INTERSECT);
        return region2;
    }

    @NotNull
    public static final Region b(@NotNull Region region, @NotNull Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.INTERSECT);
        return region3;
    }

    public static final boolean c(@NotNull Region region, @NotNull Point point) {
        return region.contains(point.x, point.y);
    }

    public static final void d(@NotNull Region region, @NotNull Function1<? super Rect, Unit> function1) {
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (regionIterator.next(rect)) {
                function1.f(rect);
            } else {
                return;
            }
        }
    }

    @NotNull
    public static final Iterator<Rect> e(@NotNull Region region) {
        return new RegionKt$iterator$1(region);
    }

    @NotNull
    public static final Region f(@NotNull Region region, @NotNull Rect rect) {
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.DIFFERENCE);
        return region2;
    }

    @NotNull
    public static final Region g(@NotNull Region region, @NotNull Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.DIFFERENCE);
        return region3;
    }

    @NotNull
    public static final Region h(@NotNull Region region) {
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @NotNull
    public static final Region i(@NotNull Region region, @NotNull Rect rect) {
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @NotNull
    public static final Region j(@NotNull Region region, @NotNull Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @NotNull
    public static final Region k(@NotNull Region region, @NotNull Rect rect) {
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    @NotNull
    public static final Region l(@NotNull Region region, @NotNull Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    @NotNull
    public static final Region m(@NotNull Region region) {
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @NotNull
    public static final Region n(@NotNull Region region, @NotNull Rect rect) {
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.XOR);
        return region2;
    }

    @NotNull
    public static final Region o(@NotNull Region region, @NotNull Region region2) {
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.XOR);
        return region3;
    }
}
