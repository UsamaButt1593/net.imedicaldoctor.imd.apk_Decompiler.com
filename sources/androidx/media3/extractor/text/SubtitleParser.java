package androidx.media3.extractor.text;

import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface SubtitleParser {

    public interface Factory {

        /* renamed from: a  reason: collision with root package name */
        public static final Factory f13783a = new Factory() {
            public int a(Format format) {
                return 1;
            }

            public boolean b(Format format) {
                return false;
            }

            public SubtitleParser c(Format format) {
                throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
            }
        };

        int a(Format format);

        boolean b(Format format);

        SubtitleParser c(Format format);
    }

    public static class OutputOptions {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final OutputOptions f13784c = new OutputOptions(C.f9084b, false);

        /* renamed from: a  reason: collision with root package name */
        public final long f13785a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f13786b;

        private OutputOptions(long j2, boolean z) {
            this.f13785a = j2;
            this.f13786b = z;
        }

        public static OutputOptions b() {
            return f13784c;
        }

        public static OutputOptions c(long j2) {
            return new OutputOptions(j2, true);
        }

        public static OutputOptions d(long j2) {
            return new OutputOptions(j2, false);
        }
    }

    void a(byte[] bArr, int i2, int i3, OutputOptions outputOptions, Consumer<CuesWithTiming> consumer);

    Subtitle b(byte[] bArr, int i2, int i3);

    void c(byte[] bArr, OutputOptions outputOptions, Consumer<CuesWithTiming> consumer);

    int d();

    void reset();
}
