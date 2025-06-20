package androidx.media3.extractor.avi;

import androidx.annotation.Nullable;
import androidx.media3.common.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;

final class ListChunk implements AviChunk {

    /* renamed from: a  reason: collision with root package name */
    public final ImmutableList<AviChunk> f13233a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13234b;

    private ListChunk(int i2, ImmutableList<AviChunk> immutableList) {
        this.f13234b = i2;
        this.f13233a = immutableList;
    }

    @Nullable
    private static AviChunk a(int i2, int i3, ParsableByteArray parsableByteArray) {
        switch (i2) {
            case AviExtractor.D /*1718776947*/:
                return StreamFormatChunk.d(i3, parsableByteArray);
            case AviExtractor.x /*1751742049*/:
                return AviMainHeaderChunk.b(parsableByteArray);
            case AviExtractor.F /*1752331379*/:
                return AviStreamHeaderChunk.d(parsableByteArray);
            case AviExtractor.E /*1852994675*/:
                return StreamNameChunk.a(parsableByteArray);
            default:
                return null;
        }
    }

    public static ListChunk c(int i2, ParsableByteArray parsableByteArray) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int g2 = parsableByteArray.g();
        int i3 = -2;
        while (parsableByteArray.a() > 8) {
            int w = parsableByteArray.w();
            int f2 = parsableByteArray.f() + parsableByteArray.w();
            parsableByteArray.X(f2);
            AviChunk c2 = w == 1414744396 ? c(parsableByteArray.w(), parsableByteArray) : a(w, i3, parsableByteArray);
            if (c2 != null) {
                if (c2.getType() == 1752331379) {
                    i3 = ((AviStreamHeaderChunk) c2).c();
                }
                builder.g(c2);
            }
            parsableByteArray.Y(f2);
            parsableByteArray.X(g2);
        }
        return new ListChunk(i2, builder.e());
    }

    @Nullable
    public <T extends AviChunk> T b(Class<T> cls) {
        UnmodifiableIterator<AviChunk> k2 = this.f13233a.iterator();
        while (k2.hasNext()) {
            T t = (AviChunk) k2.next();
            if (t.getClass() == cls) {
                return t;
            }
        }
        return null;
    }

    public int getType() {
        return this.f13234b;
    }
}
