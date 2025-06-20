package androidx.media3.exoplayer.trackselection;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

@UnstableApi
public final class TrackSelectionArray {

    /* renamed from: a  reason: collision with root package name */
    public final int f12411a;

    /* renamed from: b  reason: collision with root package name */
    private final TrackSelection[] f12412b;

    /* renamed from: c  reason: collision with root package name */
    private int f12413c;

    public TrackSelectionArray(TrackSelection... trackSelectionArr) {
        this.f12412b = trackSelectionArr;
        this.f12411a = trackSelectionArr.length;
    }

    @Nullable
    public TrackSelection a(int i2) {
        return this.f12412b[i2];
    }

    public TrackSelection[] b() {
        return (TrackSelection[]) this.f12412b.clone();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionArray.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f12412b, ((TrackSelectionArray) obj).f12412b);
    }

    public int hashCode() {
        if (this.f12413c == 0) {
            this.f12413c = MetaDo.w + Arrays.hashCode(this.f12412b);
        }
        return this.f12413c;
    }
}
