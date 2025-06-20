package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@RequiresApi(19)
public class SizeConfigStrategy implements LruPoolStrategy {

    /* renamed from: d  reason: collision with root package name */
    private static final int f18010d = 8;

    /* renamed from: e  reason: collision with root package name */
    private static final Bitmap.Config[] f18011e;

    /* renamed from: f  reason: collision with root package name */
    private static final Bitmap.Config[] f18012f;

    /* renamed from: g  reason: collision with root package name */
    private static final Bitmap.Config[] f18013g = {Bitmap.Config.RGB_565};

    /* renamed from: h  reason: collision with root package name */
    private static final Bitmap.Config[] f18014h = {Bitmap.Config.ARGB_4444};

    /* renamed from: i  reason: collision with root package name */
    private static final Bitmap.Config[] f18015i = {Bitmap.Config.ALPHA_8};

    /* renamed from: a  reason: collision with root package name */
    private final KeyPool f18016a = new KeyPool();

    /* renamed from: b  reason: collision with root package name */
    private final GroupedLinkedMap<Key, Bitmap> f18017b = new GroupedLinkedMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f18018c = new HashMap();

    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18019a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18019a = r0
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f18019a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f18019a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f18019a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy.AnonymousClass1.<clinit>():void");
        }
    }

    @VisibleForTesting
    static final class Key implements Poolable {

        /* renamed from: a  reason: collision with root package name */
        private final KeyPool f18020a;

        /* renamed from: b  reason: collision with root package name */
        int f18021b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f18022c;

        public Key(KeyPool keyPool) {
            this.f18020a = keyPool;
        }

        public void a() {
            this.f18020a.c(this);
        }

        public void b(int i2, Bitmap.Config config) {
            this.f18021b = i2;
            this.f18022c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.f18021b == key.f18021b && Util.d(this.f18022c, key.f18022c);
        }

        public int hashCode() {
            int i2 = this.f18021b * 31;
            Bitmap.Config config = this.f18022c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return SizeConfigStrategy.h(this.f18021b, this.f18022c);
        }

        @VisibleForTesting
        Key(KeyPool keyPool, int i2, Bitmap.Config config) {
            this(keyPool);
            b(i2, config);
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

        public Key e(int i2, Bitmap.Config config) {
            Key key = (Key) b();
            key.b(i2, config);
            return key;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f18011e = configArr;
        f18012f = configArr;
    }

    private void d(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> j2 = j(bitmap.getConfig());
        Integer num2 = j2.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + c(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            j2.remove(num);
        } else {
            j2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private Key g(int i2, Bitmap.Config config) {
        Key e2 = this.f18016a.e(i2, config);
        Bitmap.Config[] i3 = i(config);
        int length = i3.length;
        int i4 = 0;
        while (i4 < length) {
            Bitmap.Config config2 = i3[i4];
            Integer ceilingKey = j(config2).ceilingKey(Integer.valueOf(i2));
            if (ceilingKey == null || ceilingKey.intValue() > i2 * 8) {
                i4++;
            } else {
                if (ceilingKey.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return e2;
                        }
                    } else if (config2.equals(config)) {
                        return e2;
                    }
                }
                this.f18016a.c(e2);
                return this.f18016a.e(ceilingKey.intValue(), config2);
            }
        }
        return e2;
    }

    static String h(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f18012f;
        }
        int i2 = AnonymousClass1.f18019a[config.ordinal()];
        if (i2 == 1) {
            return f18011e;
        }
        if (i2 == 2) {
            return f18013g;
        }
        if (i2 == 3) {
            return f18014h;
        }
        if (i2 == 4) {
            return f18015i;
        }
        return new Bitmap.Config[]{config};
    }

    private NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f18018c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f18018c.put(config, treeMap);
        return treeMap;
    }

    public String a(int i2, int i3, Bitmap.Config config) {
        return h(Util.g(i2, i3, config), config);
    }

    public int b(Bitmap bitmap) {
        return Util.h(bitmap);
    }

    public String c(Bitmap bitmap) {
        return h(Util.h(bitmap), bitmap.getConfig());
    }

    public void e(Bitmap bitmap) {
        Key e2 = this.f18016a.e(Util.h(bitmap), bitmap.getConfig());
        this.f18017b.d(e2, bitmap);
        NavigableMap<Integer, Integer> j2 = j(bitmap.getConfig());
        Integer num = j2.get(Integer.valueOf(e2.f18021b));
        Integer valueOf = Integer.valueOf(e2.f18021b);
        int i2 = 1;
        if (num != null) {
            i2 = 1 + num.intValue();
        }
        j2.put(valueOf, Integer.valueOf(i2));
    }

    @Nullable
    public Bitmap f(int i2, int i3, Bitmap.Config config) {
        Key g2 = g(Util.g(i2, i3, config), config);
        Bitmap a2 = this.f18017b.a(g2);
        if (a2 != null) {
            d(Integer.valueOf(g2.f18021b), a2);
            a2.reconfigure(i2, i3, config);
        }
        return a2;
    }

    @Nullable
    public Bitmap removeLast() {
        Bitmap f2 = this.f18017b.f();
        if (f2 != null) {
            d(Integer.valueOf(Util.h(f2)), f2);
        }
        return f2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f18017b);
        sb.append(", sortedSizes=(");
        for (Map.Entry next : this.f18018c.entrySet()) {
            sb.append(next.getKey());
            sb.append('[');
            sb.append(next.getValue());
            sb.append("], ");
        }
        if (!this.f18018c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
