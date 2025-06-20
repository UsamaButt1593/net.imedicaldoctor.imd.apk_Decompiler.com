package androidx.core.graphics;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.dd.plist.ASCIIPropertyListParser;

public final class PathSegment {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f5836a;

    /* renamed from: b  reason: collision with root package name */
    private final float f5837b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f5838c;

    /* renamed from: d  reason: collision with root package name */
    private final float f5839d;

    public PathSegment(@NonNull PointF pointF, float f2, @NonNull PointF pointF2, float f3) {
        this.f5836a = (PointF) Preconditions.m(pointF, "start == null");
        this.f5837b = f2;
        this.f5838c = (PointF) Preconditions.m(pointF2, "end == null");
        this.f5839d = f3;
    }

    @NonNull
    public PointF a() {
        return this.f5838c;
    }

    public float b() {
        return this.f5839d;
    }

    @NonNull
    public PointF c() {
        return this.f5836a;
    }

    public float d() {
        return this.f5837b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        return Float.compare(this.f5837b, pathSegment.f5837b) == 0 && Float.compare(this.f5839d, pathSegment.f5839d) == 0 && this.f5836a.equals(pathSegment.f5836a) && this.f5838c.equals(pathSegment.f5838c);
    }

    public int hashCode() {
        int hashCode = this.f5836a.hashCode() * 31;
        float f2 = this.f5837b;
        int i2 = 0;
        int floatToIntBits = (((hashCode + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + this.f5838c.hashCode()) * 31;
        float f3 = this.f5839d;
        if (f3 != 0.0f) {
            i2 = Float.floatToIntBits(f3);
        }
        return floatToIntBits + i2;
    }

    public String toString() {
        return "PathSegment{start=" + this.f5836a + ", startFraction=" + this.f5837b + ", end=" + this.f5838c + ", endFraction=" + this.f5839d + ASCIIPropertyListParser.f18653k;
    }
}
