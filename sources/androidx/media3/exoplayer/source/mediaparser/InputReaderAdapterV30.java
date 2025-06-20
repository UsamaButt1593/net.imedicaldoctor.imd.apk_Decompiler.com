package androidx.media3.exoplayer.source.mediaparser;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.DataReader;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.IOException;

@RequiresApi(30)
@UnstableApi
@SuppressLint({"Override"})
public final class InputReaderAdapterV30 implements MediaParser.SeekableInputReader {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private DataReader f12300a;

    /* renamed from: b  reason: collision with root package name */
    private long f12301b;

    /* renamed from: c  reason: collision with root package name */
    private long f12302c;

    /* renamed from: d  reason: collision with root package name */
    private long f12303d;

    public long a() {
        long j2 = this.f12303d;
        this.f12303d = -1;
        return j2;
    }

    public void b(long j2) {
        this.f12302c = j2;
    }

    public void c(DataReader dataReader, long j2) {
        this.f12300a = dataReader;
        this.f12301b = j2;
        this.f12303d = -1;
    }

    public long getLength() {
        return this.f12301b;
    }

    public long getPosition() {
        return this.f12302c;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int read = ((DataReader) Util.o(this.f12300a)).read(bArr, i2, i3);
        this.f12302c += (long) read;
        return read;
    }

    public void seekToPosition(long j2) {
        this.f12303d = j2;
    }
}
