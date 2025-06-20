package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
public interface ExtractorInput extends DataReader {
    int b(int i2) throws IOException;

    boolean d(byte[] bArr, int i2, int i3, boolean z) throws IOException;

    boolean g(int i2, boolean z) throws IOException;

    long getLength();

    long getPosition();

    boolean h(byte[] bArr, int i2, int i3, boolean z) throws IOException;

    long i();

    void j(int i2) throws IOException;

    <E extends Throwable> void l(long j2, E e2) throws Throwable;

    int m(byte[] bArr, int i2, int i3) throws IOException;

    void n();

    void o(int i2) throws IOException;

    boolean q(int i2, boolean z) throws IOException;

    int read(byte[] bArr, int i2, int i3) throws IOException;

    void readFully(byte[] bArr, int i2, int i3) throws IOException;

    void s(byte[] bArr, int i2, int i3) throws IOException;
}
