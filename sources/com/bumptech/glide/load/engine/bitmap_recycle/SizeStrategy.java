package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;

@RequiresApi(19)
final class SizeStrategy implements LruPoolStrategy {

    /* renamed from: d  reason: collision with root package name */
    private static final int f18023d = 8;

    /* renamed from: a  reason: collision with root package name */
    private final KeyPool f18024a = new KeyPool();

    /* renamed from: b  reason: collision with root package name */
    private final GroupedLinkedMap<Key, Bitmap> f18025b = new GroupedLinkedMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final NavigableMap<Integer, Integer> f18026c = new PrettyPrintTreeMap();

    @VisibleForTesting
    static final class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        private final KeyPool f18027a;

        /* renamed from: b  reason: collision with root package name */
        int f18028b;

        Key(KeyPool keyPool) {
            this.f18027a = keyPool;
        }

        public void a() {
            this.f18027a.c(this);
        }

        public void b(int i2) {
            this.f18028b = i2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Key) && this.f18028b == ((Key) obj).f18028b;
        }

        public int hashCode() {
            return this.f18028b;
        }

        public String toString() {
            return SizeStrategy.g(this.f18028b);
        }
    }

    @VisibleForTesting
    static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Key a() {
            return new Key(this);
        }

        public Key e(int i2) {
            Key key = (Key) super.b();
            key.b(i2);
            return key;
        }
    }

    SizeStrategy() {
    }

    private void d(Integer num) {
        Integer num2 = this.f18026c.get(num);
        if (num2.intValue() == 1) {
            this.f18026c.remove(num);
        } else {
            this.f18026c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    static String g(int i2) {
        return "[" + i2 + "]";
    }

    private static String h(Bitmap bitmap) {
        return g(Util.h(bitmap));
    }

    public String a(int i2, int i3, Bitmap.Config config) {
        return g(Util.g(i2, i3, config));
    }

    public int b(Bitmap bitmap) {
        return Util.h(bitmap);
    }

    public String c(Bitmap bitmap) {
        return h(bitmap);
    }

    public void e(Bitmap bitmap) {
        Key e2 = this.f18024a.e(Util.h(bitmap));
        this.f18025b.d(e2, bitmap);
        Integer num = this.f18026c.get(Integer.valueOf(e2.f18028b));
        NavigableMap<Integer, Integer> navigableMap = this.f18026c;
        Integer valueOf = Integer.valueOf(e2.f18028b);
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        navigableMap.put(valueOf, Integer.valueOf(i2));
    }

    @Nullable
    public Bitmap f(int i2, int i3, Bitmap.Config config) {
        int g2 = Util.g(i2, i3, config);
        Key e2 = this.f18024a.e(g2);
        Integer ceilingKey = this.f18026c.ceilingKey(Integer.valueOf(g2));
        if (!(ceilingKey == null || ceilingKey.intValue() == g2 || ceilingKey.intValue() > g2 * 8)) {
            this.f18024a.c(e2);
            e2 = this.f18024a.e(ceilingKey.intValue());
        }
        Bitmap a2 = this.f18025b.a(e2);
        if (a2 != null) {
            a2.reconfigure(i2, i3, config);
            d(ceilingKey);
        }
        return a2;
    }

    @Nullable
    public Bitmap removeLast() {
        Bitmap f2 = this.f18025b.f();
        if (f2 != null) {
            d(Integer.valueOf(Util.h(f2)));
        }
        return f2;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.f18025b + "\n  SortedSizes" + this.f18026c;
    }
}
