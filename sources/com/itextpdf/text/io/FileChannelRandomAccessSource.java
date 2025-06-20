package com.itextpdf.text.io;

import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileChannelRandomAccessSource implements RandomAccessSource {

    /* renamed from: a  reason: collision with root package name */
    private final FileChannel f25772a;

    /* renamed from: b  reason: collision with root package name */
    private final MappedChannelRandomAccessSource f25773b;

    public FileChannelRandomAccessSource(FileChannel fileChannel) throws IOException {
        this.f25772a = fileChannel;
        if (fileChannel.size() != 0) {
            MappedChannelRandomAccessSource mappedChannelRandomAccessSource = new MappedChannelRandomAccessSource(fileChannel, 0, fileChannel.size());
            this.f25773b = mappedChannelRandomAccessSource;
            mappedChannelRandomAccessSource.d();
            return;
        }
        throw new IOException("File size is 0 bytes");
    }

    public int a(long j2, byte[] bArr, int i2, int i3) throws IOException {
        return this.f25773b.a(j2, bArr, i2, i3);
    }

    public int b(long j2) throws IOException {
        return this.f25773b.b(j2);
    }

    public void close() throws IOException {
        this.f25773b.close();
        this.f25772a.close();
    }

    public long length() {
        return this.f25773b.length();
    }
}
