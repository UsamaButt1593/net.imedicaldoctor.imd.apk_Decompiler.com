package com.itextpdf.text.io;

import java.io.IOException;

class GroupedRandomAccessSource implements RandomAccessSource {

    /* renamed from: a  reason: collision with root package name */
    private final SourceEntry[] f25778a;

    /* renamed from: b  reason: collision with root package name */
    private SourceEntry f25779b;

    /* renamed from: c  reason: collision with root package name */
    private final long f25780c;

    private static class SourceEntry {

        /* renamed from: a  reason: collision with root package name */
        final RandomAccessSource f25781a;

        /* renamed from: b  reason: collision with root package name */
        final long f25782b;

        /* renamed from: c  reason: collision with root package name */
        final long f25783c;

        /* renamed from: d  reason: collision with root package name */
        final int f25784d;

        public SourceEntry(int i2, RandomAccessSource randomAccessSource, long j2) {
            this.f25784d = i2;
            this.f25781a = randomAccessSource;
            this.f25782b = j2;
            this.f25783c = (j2 + randomAccessSource.length()) - 1;
        }

        public long a(long j2) {
            return j2 - this.f25782b;
        }
    }

    public GroupedRandomAccessSource(RandomAccessSource[] randomAccessSourceArr) throws IOException {
        this.f25778a = new SourceEntry[randomAccessSourceArr.length];
        long j2 = 0;
        for (int i2 = 0; i2 < randomAccessSourceArr.length; i2++) {
            this.f25778a[i2] = new SourceEntry(i2, randomAccessSourceArr[i2], j2);
            j2 += randomAccessSourceArr[i2].length();
        }
        this.f25780c = j2;
        SourceEntry sourceEntry = this.f25778a[randomAccessSourceArr.length - 1];
        this.f25779b = sourceEntry;
        e(sourceEntry.f25781a);
    }

    private SourceEntry c(long j2) throws IOException {
        if (j2 >= this.f25780c) {
            return null;
        }
        SourceEntry sourceEntry = this.f25779b;
        if (j2 >= sourceEntry.f25782b && j2 <= sourceEntry.f25783c) {
            return sourceEntry;
        }
        f(sourceEntry.f25781a);
        int d2 = d(j2);
        while (true) {
            SourceEntry[] sourceEntryArr = this.f25778a;
            if (d2 >= sourceEntryArr.length) {
                return null;
            }
            SourceEntry sourceEntry2 = sourceEntryArr[d2];
            if (j2 < sourceEntry2.f25782b || j2 > sourceEntry2.f25783c) {
                d2++;
            } else {
                this.f25779b = sourceEntry2;
                e(sourceEntry2.f25781a);
                return this.f25779b;
            }
        }
    }

    public int a(long j2, byte[] bArr, int i2, int i3) throws IOException {
        SourceEntry c2 = c(j2);
        if (c2 == null) {
            return -1;
        }
        int i4 = i3;
        long a2 = c2.a(j2);
        while (i4 > 0 && c2 != null && a2 <= c2.f25781a.length()) {
            int a3 = c2.f25781a.a(a2, bArr, i2, i4);
            if (a3 == -1) {
                break;
            }
            i2 += a3;
            j2 += (long) a3;
            i4 -= a3;
            c2 = c(j2);
            a2 = 0;
        }
        if (i4 == i3) {
            return -1;
        }
        return i3 - i4;
    }

    public int b(long j2) throws IOException {
        SourceEntry c2 = c(j2);
        if (c2 == null) {
            return -1;
        }
        return c2.f25781a.b(c2.a(j2));
    }

    public void close() throws IOException {
        for (SourceEntry sourceEntry : this.f25778a) {
            sourceEntry.f25781a.close();
        }
    }

    /* access modifiers changed from: protected */
    public int d(long j2) {
        SourceEntry sourceEntry = this.f25779b;
        if (j2 >= sourceEntry.f25782b) {
            return sourceEntry.f25784d;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void e(RandomAccessSource randomAccessSource) throws IOException {
    }

    /* access modifiers changed from: protected */
    public void f(RandomAccessSource randomAccessSource) throws IOException {
    }

    public long length() {
        return this.f25780c;
    }
}
