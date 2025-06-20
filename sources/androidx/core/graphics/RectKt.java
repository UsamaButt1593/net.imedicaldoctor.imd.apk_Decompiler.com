package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0007H\n¢\u0006\u0004\b\t\u0010\n\u001a\u0014\u0010\u000b\u001a\u00020\b*\u00020\u0007H\n¢\u0006\u0004\b\u000b\u0010\n\u001a\u0014\u0010\f\u001a\u00020\b*\u00020\u0007H\n¢\u0006\u0004\b\f\u0010\n\u001a\u0014\u0010\r\u001a\u00020\b*\u00020\u0007H\n¢\u0006\u0004\b\r\u0010\n\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\n¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\bH\n¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001c\u0010\u0019\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0018H\n¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010\u001c\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u001bH\n¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001f\u001a\u00020\u001e*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\n¢\u0006\u0004\b\u001f\u0010 \u001a\u001c\u0010\u000e\u001a\u00020\u001e*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\n¢\u0006\u0004\b\u000e\u0010!\u001a\u001c\u0010\"\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0001H\n¢\u0006\u0004\b\"\u0010\u0015\u001a\u001c\u0010#\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\bH\n¢\u0006\u0004\b#\u0010\u0017\u001a\u001c\u0010$\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0018H\n¢\u0006\u0004\b$\u0010\u001a\u001a\u001c\u0010%\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u001bH\n¢\u0006\u0004\b%\u0010\u001d\u001a\u001c\u0010'\u001a\u00020\u0000*\u00020\u00002\u0006\u0010&\u001a\u00020\u0001H\n¢\u0006\u0004\b'\u0010\u0015\u001a\u001c\u0010(\u001a\u00020\u0007*\u00020\u00072\u0006\u0010&\u001a\u00020\u0001H\n¢\u0006\u0004\b(\u0010)\u001a\u001c\u0010*\u001a\u00020\u0007*\u00020\u00072\u0006\u0010&\u001a\u00020\bH\n¢\u0006\u0004\b*\u0010\u0017\u001a\u001c\u0010+\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\f¢\u0006\u0004\b+\u0010\u0010\u001a\u001c\u0010,\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\f¢\u0006\u0004\b,\u0010\u0012\u001a\u001c\u0010-\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\f¢\u0006\u0004\b-\u0010\u0010\u001a\u001c\u0010.\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\f¢\u0006\u0004\b.\u0010\u0012\u001a\u001c\u0010/\u001a\u00020\u001e*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\f¢\u0006\u0004\b/\u0010 \u001a\u001c\u00100\u001a\u00020\u001e*\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\f¢\u0006\u0004\b0\u0010!\u001a\u001c\u00102\u001a\u000201*\u00020\u00002\u0006\u0010%\u001a\u00020\u0018H\n¢\u0006\u0004\b2\u00103\u001a\u001c\u00104\u001a\u000201*\u00020\u00072\u0006\u0010%\u001a\u00020\u001bH\n¢\u0006\u0004\b4\u00105\u001a\u0014\u00106\u001a\u00020\u0007*\u00020\u0000H\b¢\u0006\u0004\b6\u00107\u001a\u0014\u00108\u001a\u00020\u0000*\u00020\u0007H\b¢\u0006\u0004\b8\u00109\u001a\u0014\u0010:\u001a\u00020\u001e*\u00020\u0000H\b¢\u0006\u0004\b:\u0010;\u001a\u0014\u0010<\u001a\u00020\u001e*\u00020\u0007H\b¢\u0006\u0004\b<\u0010=\u001a\u001c\u0010?\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\"\u001a\u00020>H\b¢\u0006\u0004\b?\u0010@¨\u0006A"}, d2 = {"Landroid/graphics/Rect;", "", "d", "(Landroid/graphics/Rect;)I", "f", "h", "j", "Landroid/graphics/RectF;", "", "c", "(Landroid/graphics/RectF;)F", "e", "g", "i", "r", "w", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)Landroid/graphics/Rect;", "z", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)Landroid/graphics/RectF;", "xy", "u", "(Landroid/graphics/Rect;I)Landroid/graphics/Rect;", "x", "(Landroid/graphics/RectF;F)Landroid/graphics/RectF;", "Landroid/graphics/Point;", "v", "(Landroid/graphics/Rect;Landroid/graphics/Point;)Landroid/graphics/Rect;", "Landroid/graphics/PointF;", "y", "(Landroid/graphics/RectF;Landroid/graphics/PointF;)Landroid/graphics/RectF;", "Landroid/graphics/Region;", "q", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)Landroid/graphics/Region;", "(Landroid/graphics/RectF;Landroid/graphics/RectF;)Landroid/graphics/Region;", "m", "o", "n", "p", "factor", "A", "C", "(Landroid/graphics/RectF;I)Landroid/graphics/RectF;", "B", "s", "t", "a", "b", "I", "J", "", "k", "(Landroid/graphics/Rect;Landroid/graphics/Point;)Z", "l", "(Landroid/graphics/RectF;Landroid/graphics/PointF;)Z", "E", "(Landroid/graphics/Rect;)Landroid/graphics/RectF;", "D", "(Landroid/graphics/RectF;)Landroid/graphics/Rect;", "F", "(Landroid/graphics/Rect;)Landroid/graphics/Region;", "G", "(Landroid/graphics/RectF;)Landroid/graphics/Region;", "Landroid/graphics/Matrix;", "H", "(Landroid/graphics/RectF;Landroid/graphics/Matrix;)Landroid/graphics/RectF;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,365:1\n344#1,3:366\n344#1,3:369\n257#1,6:372\n122#1,3:378\n132#1,3:381\n344#1,3:384\n344#1,3:387\n344#1,3:390\n1#2:393\n*S KotlinDebug\n*F\n+ 1 Rect.kt\nandroidx/core/graphics/RectKt\n*L\n191#1:366,3\n192#1:369,3\n251#1:372,6\n268#1:378,3\n273#1:381,3\n313#1:384,3\n314#1:387,3\n358#1:390,3\n*E\n"})
public final class RectKt {
    @NotNull
    public static final Rect A(@NotNull Rect rect, int i2) {
        Rect rect2 = new Rect(rect);
        rect2.top *= i2;
        rect2.left *= i2;
        rect2.right *= i2;
        rect2.bottom *= i2;
        return rect2;
    }

    @NotNull
    public static final RectF B(@NotNull RectF rectF, float f2) {
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f2;
        rectF2.left *= f2;
        rectF2.right *= f2;
        rectF2.bottom *= f2;
        return rectF2;
    }

    @NotNull
    public static final RectF C(@NotNull RectF rectF, int i2) {
        float f2 = (float) i2;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f2;
        rectF2.left *= f2;
        rectF2.right *= f2;
        rectF2.bottom *= f2;
        return rectF2;
    }

    @NotNull
    public static final Rect D(@NotNull RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    @NotNull
    public static final RectF E(@NotNull Rect rect) {
        return new RectF(rect);
    }

    @NotNull
    public static final Region F(@NotNull Rect rect) {
        return new Region(rect);
    }

    @NotNull
    public static final Region G(@NotNull RectF rectF) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @NotNull
    public static final RectF H(@NotNull RectF rectF, @NotNull Matrix matrix) {
        matrix.mapRect(rectF);
        return rectF;
    }

    @NotNull
    public static final Region I(@NotNull Rect rect, @NotNull Rect rect2) {
        Region region = new Region(rect);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @NotNull
    public static final Region J(@NotNull RectF rectF, @NotNull RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @NotNull
    @SuppressLint({"CheckResult"})
    public static final Rect a(@NotNull Rect rect, @NotNull Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        return rect3;
    }

    @NotNull
    @SuppressLint({"CheckResult"})
    public static final RectF b(@NotNull RectF rectF, @NotNull RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.intersect(rectF2);
        return rectF3;
    }

    public static final float c(@NotNull RectF rectF) {
        return rectF.left;
    }

    public static final int d(@NotNull Rect rect) {
        return rect.left;
    }

    public static final float e(@NotNull RectF rectF) {
        return rectF.top;
    }

    public static final int f(@NotNull Rect rect) {
        return rect.top;
    }

    public static final float g(@NotNull RectF rectF) {
        return rectF.right;
    }

    public static final int h(@NotNull Rect rect) {
        return rect.right;
    }

    public static final float i(@NotNull RectF rectF) {
        return rectF.bottom;
    }

    public static final int j(@NotNull Rect rect) {
        return rect.bottom;
    }

    public static final boolean k(@NotNull Rect rect, @NotNull Point point) {
        return rect.contains(point.x, point.y);
    }

    public static final boolean l(@NotNull RectF rectF, @NotNull PointF pointF) {
        return rectF.contains(pointF.x, pointF.y);
    }

    @NotNull
    public static final Rect m(@NotNull Rect rect, int i2) {
        Rect rect2 = new Rect(rect);
        int i3 = -i2;
        rect2.offset(i3, i3);
        return rect2;
    }

    @NotNull
    public static final Rect n(@NotNull Rect rect, @NotNull Point point) {
        Rect rect2 = new Rect(rect);
        rect2.offset(-point.x, -point.y);
        return rect2;
    }

    @NotNull
    public static final RectF o(@NotNull RectF rectF, float f2) {
        RectF rectF2 = new RectF(rectF);
        float f3 = -f2;
        rectF2.offset(f3, f3);
        return rectF2;
    }

    @NotNull
    public static final RectF p(@NotNull RectF rectF, @NotNull PointF pointF) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-pointF.x, -pointF.y);
        return rectF2;
    }

    @NotNull
    public static final Region q(@NotNull Rect rect, @NotNull Rect rect2) {
        Region region = new Region(rect);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Region r(@NotNull RectF rectF, @NotNull RectF rectF2) {
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        rectF2.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @NotNull
    public static final Rect s(@NotNull Rect rect, @NotNull Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @NotNull
    public static final RectF t(@NotNull RectF rectF, @NotNull RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }

    @NotNull
    public static final Rect u(@NotNull Rect rect, int i2) {
        Rect rect2 = new Rect(rect);
        rect2.offset(i2, i2);
        return rect2;
    }

    @NotNull
    public static final Rect v(@NotNull Rect rect, @NotNull Point point) {
        Rect rect2 = new Rect(rect);
        rect2.offset(point.x, point.y);
        return rect2;
    }

    @NotNull
    public static final Rect w(@NotNull Rect rect, @NotNull Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.union(rect2);
        return rect3;
    }

    @NotNull
    public static final RectF x(@NotNull RectF rectF, float f2) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f2, f2);
        return rectF2;
    }

    @NotNull
    public static final RectF y(@NotNull RectF rectF, @NotNull PointF pointF) {
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(pointF.x, pointF.y);
        return rectF2;
    }

    @NotNull
    public static final RectF z(@NotNull RectF rectF, @NotNull RectF rectF2) {
        RectF rectF3 = new RectF(rectF);
        rectF3.union(rectF2);
        return rectF3;
    }
}
