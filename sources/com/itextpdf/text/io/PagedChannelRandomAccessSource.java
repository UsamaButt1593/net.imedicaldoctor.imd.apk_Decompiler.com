package com.itextpdf.text.io;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;

class PagedChannelRandomAccessSource extends GroupedRandomAccessSource implements RandomAccessSource {

    /* renamed from: g  reason: collision with root package name */
    public static final int f25790g = 67108864;

    /* renamed from: h  reason: collision with root package name */
    public static final int f25791h = 16;

    /* renamed from: d  reason: collision with root package name */
    private final int f25792d;

    /* renamed from: e  reason: collision with root package name */
    private final FileChannel f25793e;

    /* renamed from: f  reason: collision with root package name */
    private final MRU<RandomAccessSource> f25794f;

    private static class MRU<E> {

        /* renamed from: a  reason: collision with root package name */
        private final int f25795a;

        /* renamed from: b  reason: collision with root package name */
        private LinkedList<E> f25796b = new LinkedList<>();

        public MRU(int i2) {
            this.f25795a = i2;
        }

        public E a(E e2) {
            if (this.f25796b.size() > 0 && this.f25796b.getFirst() == e2) {
                return null;
            }
            Iterator<E> it2 = this.f25796b.iterator();
            while (it2.hasNext()) {
                if (e2 == it2.next()) {
                    it2.remove();
                    this.f25796b.addFirst(e2);
                    return null;
                }
            }
            this.f25796b.addFirst(e2);
            if (this.f25796b.size() > this.f25795a) {
                return this.f25796b.removeLast();
            }
            return null;
        }
    }

    public PagedChannelRandomAccessSource(FileChannel fileChannel) throws IOException {
        this(fileChannel, 67108864, 16);
    }

    private static RandomAccessSource[] g(FileChannel fileChannel, int i2) throws IOException {
        long size = fileChannel.size();
        if (size > 0) {
            long j2 = (long) i2;
            int i3 = ((int) (size / j2)) + (size % j2 == 0 ? 0 : 1);
            MappedChannelRandomAccessSource[] mappedChannelRandomAccessSourceArr = new MappedChannelRandomAccessSource[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                long j3 = ((long) i4) * j2;
                mappedChannelRandomAccessSourceArr[i4] = new MappedChannelRandomAccessSource(fileChannel, j3, Math.min(size - j3, j2));
            }
            return mappedChannelRandomAccessSourceArr;
        }
        throw new IOException("File size must be greater than zero");
    }

    public void close() throws IOException {
        super.close();
        this.f25793e.close();
    }

    /* access modifiers changed from: protected */
    public int d(long j2) {
        return (int) (j2 / ((long) this.f25792d));
    }

    /* access modifiers changed from: protected */
    public void e(RandomAccessSource randomAccessSource) throws IOException {
        ((MappedChannelRandomAccessSource) randomAccessSource).d();
    }

    /* access modifiers changed from: protected */
    public void f(RandomAccessSource randomAccessSource) throws IOException {
        RandomAccessSource a2 = this.f25794f.a(randomAccessSource);
        if (a2 != null) {
            a2.close();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PagedChannelRandomAccessSource(java.nio.channels.FileChannel r2, int r3, int r4) throws java.io.IOException {
        /*
            r1 = this;
            int r3 = r3 / r4
            com.itextpdf.text.io.RandomAccessSource[] r0 = g(r2, r3)
            r1.<init>(r0)
            r1.f25793e = r2
            r1.f25792d = r3
            com.itextpdf.text.io.PagedChannelRandomAccessSource$MRU r2 = new com.itextpdf.text.io.PagedChannelRandomAccessSource$MRU
            r2.<init>(r4)
            r1.f25794f = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.io.PagedChannelRandomAccessSource.<init>(java.nio.channels.FileChannel, int, int):void");
    }
}
