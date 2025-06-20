package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

public abstract class DownsampleStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f18266a = new AtLeast();

    /* renamed from: b  reason: collision with root package name */
    public static final DownsampleStrategy f18267b = new AtMost();

    /* renamed from: c  reason: collision with root package name */
    public static final DownsampleStrategy f18268c = new FitCenter();

    /* renamed from: d  reason: collision with root package name */
    public static final DownsampleStrategy f18269d = new CenterInside();

    /* renamed from: e  reason: collision with root package name */
    public static final DownsampleStrategy f18270e;

    /* renamed from: f  reason: collision with root package name */
    public static final DownsampleStrategy f18271f = new None();

    /* renamed from: g  reason: collision with root package name */
    public static final DownsampleStrategy f18272g;

    /* renamed from: h  reason: collision with root package name */
    public static final Option<DownsampleStrategy> f18273h;

    /* renamed from: i  reason: collision with root package name */
    static final boolean f18274i = true;

    private static class AtLeast extends DownsampleStrategy {
        AtLeast() {
        }

        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            int min = Math.min(i3 / i5, i2 / i4);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(min));
        }
    }

    private static class AtMost extends DownsampleStrategy {
        AtMost() {
        }

        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.MEMORY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            int ceil = (int) Math.ceil((double) Math.max(((float) i3) / ((float) i5), ((float) i2) / ((float) i4)));
            int i6 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i6 = 0;
            }
            return 1.0f / ((float) (max << i6));
        }
    }

    private static class CenterInside extends DownsampleStrategy {
        CenterInside() {
        }

        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return b(i2, i3, i4, i5) == 1.0f ? SampleSizeRounding.QUALITY : DownsampleStrategy.f18268c.a(i2, i3, i4, i5);
        }

        public float b(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, DownsampleStrategy.f18268c.b(i2, i3, i4, i5));
        }
    }

    private static class CenterOutside extends DownsampleStrategy {
        CenterOutside() {
        }

        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            return Math.max(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
        }
    }

    private static class FitCenter extends DownsampleStrategy {
        FitCenter() {
        }

        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return DownsampleStrategy.f18274i ? SampleSizeRounding.QUALITY : SampleSizeRounding.MEMORY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            if (DownsampleStrategy.f18274i) {
                return Math.min(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
            }
            int max = Math.max(i3 / i5, i2 / i4);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(max));
        }
    }

    private static class None extends DownsampleStrategy {
        None() {
        }

        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }

        public float b(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }
    }

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    static {
        CenterOutside centerOutside = new CenterOutside();
        f18270e = centerOutside;
        f18272g = centerOutside;
        f18273h = Option.g("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", centerOutside);
    }

    public abstract SampleSizeRounding a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
