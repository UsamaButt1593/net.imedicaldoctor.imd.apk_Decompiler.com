package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;

class AttributeStrategy implements LruPoolStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final KeyPool f17969a = new KeyPool();

    /* renamed from: b  reason: collision with root package name */
    private final GroupedLinkedMap<Key, Bitmap> f17970b = new GroupedLinkedMap<>();

    @VisibleForTesting
    static class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        private final KeyPool f17971a;

        /* renamed from: b  reason: collision with root package name */
        private int f17972b;

        /* renamed from: c  reason: collision with root package name */
        private int f17973c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap.Config f17974d;

        public Key(KeyPool keyPool) {
            this.f17971a = keyPool;
        }

        public void a() {
            this.f17971a.c(this);
        }

        public void b(int i2, int i3, Bitmap.Config config) {
            this.f17972b = i2;
            this.f17973c = i3;
            this.f17974d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.f17972b == key.f17972b && this.f17973c == key.f17973c && this.f17974d == key.f17974d;
        }

        public int hashCode() {
            int i2 = ((this.f17972b * 31) + this.f17973c) * 31;
            Bitmap.Config config = this.f17974d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return AttributeStrategy.d(this.f17972b, this.f17973c, this.f17974d);
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

        /* access modifiers changed from: package-private */
        public Key e(int i2, int i3, Bitmap.Config config) {
            Key key = (Key) b();
            key.b(i2, i3, config);
            return key;
        }
    }

    AttributeStrategy() {
    }

    static String d(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + "x" + i3 + "], " + config;
    }

    private static String g(Bitmap bitmap) {
        return d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public String a(int i2, int i3, Bitmap.Config config) {
        return d(i2, i3, config);
    }

    public int b(Bitmap bitmap) {
        return Util.h(bitmap);
    }

    public String c(Bitmap bitmap) {
        return g(bitmap);
    }

    public void e(Bitmap bitmap) {
        this.f17970b.d(this.f17969a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public Bitmap f(int i2, int i3, Bitmap.Config config) {
        return this.f17970b.a(this.f17969a.e(i2, i3, config));
    }

    public Bitmap removeLast() {
        return this.f17970b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f17970b;
    }
}
