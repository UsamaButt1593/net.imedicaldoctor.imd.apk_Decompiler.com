package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface SeekMap {

    public static final class SeekPoints {

        /* renamed from: a  reason: collision with root package name */
        public final SeekPoint f13112a;

        /* renamed from: b  reason: collision with root package name */
        public final SeekPoint f13113b;

        public SeekPoints(SeekPoint seekPoint) {
            this(seekPoint, seekPoint);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SeekPoints.class != obj.getClass()) {
                return false;
            }
            SeekPoints seekPoints = (SeekPoints) obj;
            return this.f13112a.equals(seekPoints.f13112a) && this.f13113b.equals(seekPoints.f13113b);
        }

        public int hashCode() {
            return (this.f13112a.hashCode() * 31) + this.f13113b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f13112a);
            if (this.f13112a.equals(this.f13113b)) {
                str = "";
            } else {
                str = ", " + this.f13113b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.f13112a = (SeekPoint) Assertions.g(seekPoint);
            this.f13113b = (SeekPoint) Assertions.g(seekPoint2);
        }
    }

    public static class Unseekable implements SeekMap {

        /* renamed from: d  reason: collision with root package name */
        private final long f13114d;

        /* renamed from: e  reason: collision with root package name */
        private final SeekPoints f13115e;

        public Unseekable(long j2) {
            this(j2, 0);
        }

        public boolean g() {
            return false;
        }

        public SeekPoints j(long j2) {
            return this.f13115e;
        }

        public long l() {
            return this.f13114d;
        }

        public Unseekable(long j2, long j3) {
            this.f13114d = j2;
            this.f13115e = new SeekPoints(j3 == 0 ? SeekPoint.f13116c : new SeekPoint(0, j3));
        }
    }

    boolean g();

    SeekPoints j(long j2);

    long l();
}
