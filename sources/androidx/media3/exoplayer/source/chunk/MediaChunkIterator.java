package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;
import java.util.NoSuchElementException;

@UnstableApi
public interface MediaChunkIterator {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaChunkIterator f12297a = new MediaChunkIterator() {
        public long a() {
            throw new NoSuchElementException();
        }

        public DataSpec b() {
            throw new NoSuchElementException();
        }

        public boolean c() {
            return true;
        }

        public long d() {
            throw new NoSuchElementException();
        }

        public boolean next() {
            return false;
        }

        public void reset() {
        }
    };

    long a();

    DataSpec b();

    boolean c();

    long d();

    boolean next();

    void reset();
}
