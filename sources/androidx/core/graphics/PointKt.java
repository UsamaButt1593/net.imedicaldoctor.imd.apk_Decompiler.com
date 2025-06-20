package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u001f\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\n¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0006*\u00020\u0005H\n¢\u0006\u0004\b\t\u0010\b\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\n¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0012\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0014\u0010\f\u001a\u001c\u0010\u0015\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0015\u0010\u000e\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0016\u0010\u0011\u001a\u001c\u0010\u0017\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0017\u0010\u0013\u001a\u0014\u0010\u0018\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0005*\u00020\u0005H\n¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001d\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0006H\n¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010\n\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0006H\n¢\u0006\u0004\b\n\u0010\u0013\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0006H\n¢\u0006\u0004\b\u001f\u0010\u001e\u001a\u001c\u0010 \u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0006H\n¢\u0006\u0004\b \u0010\u0013\u001a\u0014\u0010!\u001a\u00020\u0005*\u00020\u0000H\b¢\u0006\u0004\b!\u0010\"\u001a\u0014\u0010#\u001a\u00020\u0000*\u00020\u0005H\b¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroid/graphics/Point;", "", "b", "(Landroid/graphics/Point;)I", "d", "Landroid/graphics/PointF;", "", "a", "(Landroid/graphics/PointF;)F", "c", "p", "l", "(Landroid/graphics/Point;Landroid/graphics/Point;)Landroid/graphics/Point;", "n", "(Landroid/graphics/PointF;Landroid/graphics/PointF;)Landroid/graphics/PointF;", "xy", "k", "(Landroid/graphics/Point;I)Landroid/graphics/Point;", "m", "(Landroid/graphics/PointF;F)Landroid/graphics/PointF;", "h", "j", "g", "i", "s", "(Landroid/graphics/Point;)Landroid/graphics/Point;", "t", "(Landroid/graphics/PointF;)Landroid/graphics/PointF;", "scalar", "o", "(Landroid/graphics/Point;F)Landroid/graphics/Point;", "e", "f", "r", "(Landroid/graphics/Point;)Landroid/graphics/PointF;", "q", "(Landroid/graphics/PointF;)Landroid/graphics/Point;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class PointKt {
    public static final float a(@NotNull PointF pointF) {
        return pointF.x;
    }

    public static final int b(@NotNull Point point) {
        return point.x;
    }

    public static final float c(@NotNull PointF pointF) {
        return pointF.y;
    }

    public static final int d(@NotNull Point point) {
        return point.y;
    }

    @NotNull
    public static final Point e(@NotNull Point point, float f2) {
        return new Point(Math.round(((float) point.x) / f2), Math.round(((float) point.y) / f2));
    }

    @NotNull
    public static final PointF f(@NotNull PointF pointF, float f2) {
        return new PointF(pointF.x / f2, pointF.y / f2);
    }

    @NotNull
    public static final Point g(@NotNull Point point, int i2) {
        Point point2 = new Point(point.x, point.y);
        int i3 = -i2;
        point2.offset(i3, i3);
        return point2;
    }

    @NotNull
    public static final Point h(@NotNull Point point, @NotNull Point point2) {
        Point point3 = new Point(point.x, point.y);
        point3.offset(-point2.x, -point2.y);
        return point3;
    }

    @NotNull
    public static final PointF i(@NotNull PointF pointF, float f2) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f3 = -f2;
        pointF2.offset(f3, f3);
        return pointF2;
    }

    @NotNull
    public static final PointF j(@NotNull PointF pointF, @NotNull PointF pointF2) {
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(-pointF2.x, -pointF2.y);
        return pointF3;
    }

    @NotNull
    public static final Point k(@NotNull Point point, int i2) {
        Point point2 = new Point(point.x, point.y);
        point2.offset(i2, i2);
        return point2;
    }

    @NotNull
    public static final Point l(@NotNull Point point, @NotNull Point point2) {
        Point point3 = new Point(point.x, point.y);
        point3.offset(point2.x, point2.y);
        return point3;
    }

    @NotNull
    public static final PointF m(@NotNull PointF pointF, float f2) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f2, f2);
        return pointF2;
    }

    @NotNull
    public static final PointF n(@NotNull PointF pointF, @NotNull PointF pointF2) {
        PointF pointF3 = new PointF(pointF.x, pointF.y);
        pointF3.offset(pointF2.x, pointF2.y);
        return pointF3;
    }

    @NotNull
    public static final Point o(@NotNull Point point, float f2) {
        return new Point(Math.round(((float) point.x) * f2), Math.round(((float) point.y) * f2));
    }

    @NotNull
    public static final PointF p(@NotNull PointF pointF, float f2) {
        return new PointF(pointF.x * f2, pointF.y * f2);
    }

    @NotNull
    public static final Point q(@NotNull PointF pointF) {
        return new Point((int) pointF.x, (int) pointF.y);
    }

    @NotNull
    public static final PointF r(@NotNull Point point) {
        return new PointF(point);
    }

    @NotNull
    public static final Point s(@NotNull Point point) {
        return new Point(-point.x, -point.y);
    }

    @NotNull
    public static final PointF t(@NotNull PointF pointF) {
        return new PointF(-pointF.x, -pointF.y);
    }
}
