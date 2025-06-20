package androidx.media3.extractor.mp3;

import androidx.media3.common.C;
import androidx.media3.extractor.SeekMap;

interface Seeker extends SeekMap {

    public static class UnseekableSeeker extends SeekMap.Unseekable implements Seeker {
        public UnseekableSeeker() {
            super(C.f9084b);
        }

        public long b(long j2) {
            return 0;
        }

        public long f() {
            return -1;
        }

        public int k() {
            return C.f9088f;
        }
    }

    long b(long j2);

    long f();

    int k();
}
