package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LongHashtable implements Cloneable {
    private transient int X;
    private int Y;
    private float Z;
    private transient Entry[] s;

    static class Entry {

        /* renamed from: a  reason: collision with root package name */
        int f26088a;

        /* renamed from: b  reason: collision with root package name */
        long f26089b;

        /* renamed from: c  reason: collision with root package name */
        long f26090c;

        /* renamed from: d  reason: collision with root package name */
        Entry f26091d;

        protected Entry(int i2, long j2, long j3, Entry entry) {
            this.f26088a = i2;
            this.f26089b = j2;
            this.f26090c = j3;
            this.f26091d = entry;
        }

        public long a() {
            return this.f26089b;
        }

        public long b() {
            return this.f26090c;
        }

        /* access modifiers changed from: protected */
        public Object clone() {
            int i2 = this.f26088a;
            long j2 = this.f26089b;
            long j3 = this.f26090c;
            Entry entry = this.f26091d;
            return new Entry(i2, j2, j3, entry != null ? (Entry) entry.clone() : null);
        }
    }

    static class LongHashtableIterator implements Iterator<Entry> {
        Entry[] X;
        Entry Y;
        int s;

        LongHashtableIterator(Entry[] entryArr) {
            this.X = entryArr;
            this.s = entryArr.length;
        }

        /* renamed from: a */
        public Entry next() {
            Entry entry;
            if (this.Y == null) {
                do {
                    int i2 = this.s;
                    int i3 = i2 - 1;
                    this.s = i3;
                    if (i2 <= 0) {
                        break;
                    }
                    entry = this.X[i3];
                    this.Y = entry;
                } while (entry == null);
            }
            Entry entry2 = this.Y;
            if (entry2 != null) {
                this.Y = entry2.f26091d;
                return entry2;
            }
            throw new NoSuchElementException(MessageLocalization.b("inthashtableiterator", new Object[0]));
        }

        public boolean hasNext() {
            Entry entry;
            if (this.Y != null) {
                return true;
            }
            do {
                int i2 = this.s;
                int i3 = i2 - 1;
                this.s = i3;
                if (i2 <= 0) {
                    return false;
                }
                entry = this.X[i3];
                this.Y = entry;
            } while (entry == null);
            return true;
        }

        public void remove() {
            throw new UnsupportedOperationException(MessageLocalization.b("remove.not.supported", new Object[0]));
        }
    }

    public LongHashtable() {
        this(150, 0.75f);
    }

    public void a() {
        Entry[] entryArr = this.s;
        int length = entryArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                entryArr[length] = null;
            } else {
                this.X = 0;
                return;
            }
        }
    }

    public boolean b(long j2) {
        Entry[] entryArr = this.s;
        int length = entryArr.length;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return false;
            }
            for (Entry entry = entryArr[i2]; entry != null; entry = entry.f26091d) {
                if (entry.f26090c == j2) {
                    return true;
                }
            }
            length = i2;
        }
    }

    public boolean c(long j2) {
        Entry[] entryArr = this.s;
        int i2 = (int) ((j2 >>> 32) ^ j2);
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i2) % entryArr.length]; entry != null; entry = entry.f26091d) {
            if (entry.f26088a == i2 && entry.f26089b == j2) {
                return true;
            }
        }
        return false;
    }

    public Object clone() {
        try {
            LongHashtable longHashtable = (LongHashtable) super.clone();
            longHashtable.s = new Entry[this.s.length];
            int length = this.s.length;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return longHashtable;
                }
                Entry[] entryArr = longHashtable.s;
                Entry entry = this.s[i2];
                entryArr[i2] = entry != null ? (Entry) entry.clone() : null;
                length = i2;
            }
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean d(long j2) {
        return b(j2);
    }

    public long e(long j2) {
        Entry[] entryArr = this.s;
        int i2 = (int) ((j2 >>> 32) ^ j2);
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i2) % entryArr.length]; entry != null; entry = entry.f26091d) {
            if (entry.f26088a == i2 && entry.f26089b == j2) {
                return entry.f26090c;
            }
        }
        return 0;
    }

    public Iterator<Entry> f() {
        return new LongHashtableIterator(this.s);
    }

    public long[] g() {
        int i2;
        long[] jArr = new long[this.X];
        int length = this.s.length;
        int i3 = 0;
        Entry entry = null;
        while (true) {
            if (entry == null) {
                while (true) {
                    i2 = length - 1;
                    if (length <= 0 || (entry = this.s[i2]) != null) {
                        length = i2;
                    } else {
                        length = i2;
                    }
                }
                length = i2;
            }
            if (entry == null) {
                return jArr;
            }
            Entry entry2 = entry.f26091d;
            jArr[i3] = entry.f26089b;
            entry = entry2;
            i3++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long h() {
        /*
            r5 = this;
            int r0 = r5.X
            r1 = 0
            if (r0 != 0) goto L_0x0007
            return r1
        L_0x0007:
            com.itextpdf.text.pdf.LongHashtable$Entry[] r0 = r5.s
            int r0 = r0.length
            r3 = 0
        L_0x000b:
            int r4 = r0 + -1
            if (r0 <= 0) goto L_0x0017
            com.itextpdf.text.pdf.LongHashtable$Entry[] r0 = r5.s
            r3 = r0[r4]
            if (r3 != 0) goto L_0x0017
            r0 = r4
            goto L_0x000b
        L_0x0017:
            if (r3 != 0) goto L_0x001a
            return r1
        L_0x001a:
            long r0 = r3.f26089b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.LongHashtable.h():long");
    }

    public boolean i() {
        return this.X == 0;
    }

    public long l(long j2, long j3) {
        Entry[] entryArr = this.s;
        int i2 = (int) ((j2 >>> 32) ^ j2);
        int i3 = Integer.MAX_VALUE & i2;
        int length = i3 % entryArr.length;
        for (Entry entry = entryArr[length]; entry != null; entry = entry.f26091d) {
            if (entry.f26088a == i2 && entry.f26089b == j2) {
                long j4 = entry.f26090c;
                entry.f26090c = j3;
                return j4;
            }
        }
        if (this.X >= this.Y) {
            m();
            entryArr = this.s;
            length = i3 % entryArr.length;
        }
        entryArr[length] = new Entry(i2, j2, j3, entryArr[length]);
        this.X++;
        return 0;
    }

    /* access modifiers changed from: protected */
    public void m() {
        Entry[] entryArr = this.s;
        int length = entryArr.length;
        int i2 = (length * 2) + 1;
        Entry[] entryArr2 = new Entry[i2];
        this.Y = (int) (((float) i2) * this.Z);
        this.s = entryArr2;
        while (true) {
            int i3 = length - 1;
            if (length > 0) {
                Entry entry = entryArr[i3];
                while (entry != null) {
                    Entry entry2 = entry.f26091d;
                    int i4 = (entry.f26088a & Integer.MAX_VALUE) % i2;
                    entry.f26091d = entryArr2[i4];
                    entryArr2[i4] = entry;
                    entry = entry2;
                }
                length = i3;
            } else {
                return;
            }
        }
    }

    public long n(long j2) {
        Entry[] entryArr = this.s;
        int i2 = (int) ((j2 >>> 32) ^ j2);
        int length = (Integer.MAX_VALUE & i2) % entryArr.length;
        Entry entry = null;
        for (Entry entry2 = entryArr[length]; entry2 != null; entry2 = entry2.f26091d) {
            if (entry2.f26088a == i2 && entry2.f26089b == j2) {
                Entry entry3 = entry2.f26091d;
                if (entry != null) {
                    entry.f26091d = entry3;
                } else {
                    entryArr[length] = entry3;
                }
                this.X--;
                long j3 = entry2.f26090c;
                entry2.f26090c = 0;
                return j3;
            }
            entry = entry2;
        }
        return 0;
    }

    public int o() {
        return this.X;
    }

    public long[] p() {
        long[] g2 = g();
        Arrays.sort(g2);
        return g2;
    }

    public LongHashtable(int i2) {
        this(i2, 0.75f);
    }

    public LongHashtable(int i2, float f2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(MessageLocalization.a("illegal.capacity.1", i2));
        } else if (f2 > 0.0f) {
            i2 = i2 == 0 ? 1 : i2;
            this.Z = f2;
            this.s = new Entry[i2];
            this.Y = (int) (((float) i2) * f2);
        } else {
            throw new IllegalArgumentException(MessageLocalization.b("illegal.load.1", String.valueOf(f2)));
        }
    }
}
