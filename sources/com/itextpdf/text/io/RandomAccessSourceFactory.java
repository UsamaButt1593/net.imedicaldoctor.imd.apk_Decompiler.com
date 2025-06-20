package com.itextpdf.text.io;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.channels.FileChannel;

public final class RandomAccessSourceFactory {

    /* renamed from: a  reason: collision with root package name */
    private boolean f25799a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f25800b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25801c = false;

    private RandomAccessSource d(InputStream inputStream) throws IOException {
        try {
            return new ArrayRandomAccessSource(StreamUtil.d(inputStream));
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private RandomAccessSource e(String str) throws IOException {
        InputStream b2 = StreamUtil.b(str);
        if (b2 != null) {
            return d(b2);
        }
        throw new IOException(MessageLocalization.b("1.not.found.as.file.or.resource", str));
    }

    public RandomAccessSource a(RandomAccessFile randomAccessFile) throws IOException {
        if (this.f25800b) {
            return new RAFRandomAccessSource(randomAccessFile);
        }
        if (randomAccessFile.length() <= 0) {
            return new RAFRandomAccessSource(randomAccessFile);
        }
        try {
            return c(randomAccessFile.getChannel());
        } catch (MapFailedException unused) {
            return new RAFRandomAccessSource(randomAccessFile);
        }
    }

    public RandomAccessSource b(String str) throws IOException {
        File file = new File(str);
        if (!file.canRead()) {
            return (str.startsWith("file:/") || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("jar:") || str.startsWith("wsjar:") || str.startsWith("wsjar:") || str.startsWith("vfszip:")) ? i(new URL(str)) : e(str);
        }
        if (this.f25799a) {
            return d(new FileInputStream(str));
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, this.f25801c ? "rw" : "r");
        if (this.f25801c) {
            randomAccessFile.getChannel().lock();
        }
        try {
            return a(randomAccessFile);
        } catch (IOException e2) {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
            throw e2;
        } catch (RuntimeException e3) {
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            throw e3;
        }
    }

    public RandomAccessSource c(FileChannel fileChannel) throws IOException {
        GetBufferedRandomAccessSource getBufferedRandomAccessSource;
        if (fileChannel.size() <= 67108864) {
            FileChannelRandomAccessSource fileChannelRandomAccessSource = new FileChannelRandomAccessSource(fileChannel);
            return getBufferedRandomAccessSource;
        }
        getBufferedRandomAccessSource = new GetBufferedRandomAccessSource(new PagedChannelRandomAccessSource(fileChannel));
        return getBufferedRandomAccessSource;
    }

    public RandomAccessSource f(RandomAccessSource randomAccessSource, long[] jArr) throws IOException {
        RandomAccessSource[] randomAccessSourceArr = new RandomAccessSource[(jArr.length / 2)];
        for (int i2 = 0; i2 < jArr.length; i2 += 2) {
            randomAccessSourceArr[i2 / 2] = new WindowRandomAccessSource(randomAccessSource, jArr[i2], jArr[i2 + 1]);
        }
        return new GroupedRandomAccessSource(randomAccessSourceArr);
    }

    public RandomAccessSource g(InputStream inputStream) throws IOException {
        try {
            return j(StreamUtil.d(inputStream));
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public RandomAccessSource h(RandomAccessFile randomAccessFile) throws IOException {
        return new RAFRandomAccessSource(randomAccessFile);
    }

    public RandomAccessSource i(URL url) throws IOException {
        InputStream openStream = url.openStream();
        try {
            return g(openStream);
        } finally {
            try {
                openStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public RandomAccessSource j(byte[] bArr) {
        return new ArrayRandomAccessSource(bArr);
    }

    public RandomAccessSourceFactory k(boolean z) {
        this.f25801c = z;
        return this;
    }

    public RandomAccessSourceFactory l(boolean z) {
        this.f25799a = z;
        return this;
    }

    public RandomAccessSourceFactory m(boolean z) {
        this.f25800b = z;
        return this;
    }
}
