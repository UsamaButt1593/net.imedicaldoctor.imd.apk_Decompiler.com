package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntHashtable implements Cloneable {
    private transient int X;
    private int Y;
    private float Z;
    private transient Entry[] s;

    static class Entry {

        /* renamed from: a  reason: collision with root package name */
        int f26074a;

        /* renamed from: b  reason: collision with root package name */
        int f26075b;

        /* renamed from: c  reason: collision with root package name */
        int f26076c;

        /* renamed from: d  reason: collision with root package name */
        Entry f26077d;

        protected Entry(int i2, int i3, int i4, Entry entry) {
            this.f26074a = i2;
            this.f26075b = i3;
            this.f26076c = i4;
            this.f26077d = entry;
        }

        public int a() {
            return this.f26075b;
        }

        public int b() {
            return this.f26076c;
        }

        /* access modifiers changed from: protected */
        public Object clone() {
            int i2 = this.f26074a;
            int i3 = this.f26075b;
            int i4 = this.f26076c;
            Entry entry = this.f26077d;
            return new Entry(i2, i3, i4, entry != null ? (Entry) entry.clone() : null);
        }
    }

    static class IntHashtableIterator implements Iterator<Entry> {
        Entry[] X;
        Entry Y;
        int s;

        IntHashtableIterator(Entry[] entryArr) {
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
                this.Y = entry2.f26077d;
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

    public IntHashtable() {
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

    public boolean b(int i2) {
        Entry[] entryArr = this.s;
        int length = entryArr.length;
        while (true) {
            int i3 = length - 1;
            if (length <= 0) {
                return false;
            }
            for (Entry entry = entryArr[i3]; entry != null; entry = entry.f26077d) {
                if (entry.f26076c == i2) {
                    return true;
                }
            }
            length = i3;
        }
    }

    public boolean c(int i2) {
        Entry[] entryArr = this.s;
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i2) % entryArr.length]; entry != null; entry = entry.f26077d) {
            if (entry.f26074a == i2 && entry.f26075b == i2) {
                return true;
            }
        }
        return false;
    }

    public Object clone() {
        try {
            IntHashtable intHashtable = (IntHashtable) super.clone();
            intHashtable.s = new Entry[this.s.length];
            int length = this.s.length;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return intHashtable;
                }
                Entry[] entryArr = intHashtable.s;
                Entry entry = this.s[i2];
                entryArr[i2] = entry != null ? (Entry) entry.clone() : null;
                length = i2;
            }
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean d(int i2) {
        return b(i2);
    }

    public int e(int i2) {
        Entry[] entryArr = this.s;
        for (Entry entry = entryArr[(Integer.MAX_VALUE & i2) % entryArr.length]; entry != null; entry = entry.f26077d) {
            if (entry.f26074a == i2 && entry.f26075b == i2) {
                return entry.f26076c;
            }
        }
        return 0;
    }

    public Iterator<Entry> f() {
        return new IntHashtableIterator(this.s);
    }

    public int[] g() {
        int i2;
        int[] iArr = new int[this.X];
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
                return iArr;
            }
            Entry entry2 = entry.f26077d;
            iArr[i3] = entry.f26075b;
            entry = entry2;
            i3++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0018 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int h() {
        /*
            r4 = this;
            int r0 = r4.X
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            com.itextpdf.text.pdf.IntHashtable$Entry[] r0 = r4.s
            int r0 = r0.length
            r2 = 0
        L_0x000a:
            int r3 = r0 + -1
            if (r0 <= 0) goto L_0x0016
            com.itextpdf.text.pdf.IntHashtable$Entry[] r0 = r4.s
            r2 = r0[r3]
            if (r2 != 0) goto L_0x0016
            r0 = r3
            goto L_0x000a
        L_0x0016:
            if (r2 != 0) goto L_0x0019
            return r1
        L_0x0019:
            int r0 = r2.f26075b
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.IntHashtable.h():int");
    }

    public boolean i() {
        return this.X == 0;
    }

    public int l(int i2, int i3) {
        Entry[] entryArr = this.s;
        int i4 = Integer.MAX_VALUE & i2;
        int length = i4 % entryArr.length;
        for (Entry entry = entryArr[length]; entry != null; entry = entry.f26077d) {
            if (entry.f26074a == i2 && entry.f26075b == i2) {
                int i5 = entry.f26076c;
                entry.f26076c = i3;
                return i5;
            }
        }
        if (this.X >= this.Y) {
            m();
            entryArr = this.s;
            length = i4 % entryArr.length;
        }
        entryArr[length] = new Entry(i2, i2, i3, entryArr[length]);
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
                    Entry entry2 = entry.f26077d;
                    int i4 = (entry.f26074a & Integer.MAX_VALUE) % i2;
                    entry.f26077d = entryArr2[i4];
                    entryArr2[i4] = entry;
                    entry = entry2;
                }
                length = i3;
            } else {
                return;
            }
        }
    }

    public int n(int i2) {
        Entry[] entryArr = this.s;
        int length = (Integer.MAX_VALUE & i2) % entryArr.length;
        Entry entry = null;
        for (Entry entry2 = entryArr[length]; entry2 != null; entry2 = entry2.f26077d) {
            if (entry2.f26074a == i2 && entry2.f26075b == i2) {
                Entry entry3 = entry2.f26077d;
                if (entry != null) {
                    entry.f26077d = entry3;
                } else {
                    entryArr[length] = entry3;
                }
                this.X--;
                int i3 = entry2.f26076c;
                entry2.f26076c = 0;
                return i3;
            }
            entry = entry2;
        }
        return 0;
    }

    public int o() {
        return this.X;
    }

    public int[] p() {
        int[] g2 = g();
        Arrays.sort(g2);
        return g2;
    }

    public IntHashtable(int i2) {
        this(i2, 0.75f);
    }

    public IntHashtable(int i2, float f2) {
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
