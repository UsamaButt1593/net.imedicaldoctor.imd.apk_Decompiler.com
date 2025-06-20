package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatBaseImpl {

    /* renamed from: b  reason: collision with root package name */
    private static final String f5862b = "TypefaceCompatBaseImpl";

    /* renamed from: c  reason: collision with root package name */
    private static final int f5863c = 0;
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> f5864a = new ConcurrentHashMap<>();

    private interface StyleExtractor<T> {
        int a(T t);

        boolean b(T t);
    }

    TypefaceCompatBaseImpl() {
    }

    private void a(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long n2 = n(typeface);
        if (n2 != 0) {
            this.f5864a.put(Long.valueOf(n2), fontFamilyFilesResourceEntry);
        }
    }

    private FontResourcesParserCompat.FontFileResourceEntry h(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i2) {
        return (FontResourcesParserCompat.FontFileResourceEntry) j(fontFamilyFilesResourceEntry.a(), i2, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>() {
            /* renamed from: c */
            public int a(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.e();
            }

            /* renamed from: d */
            public boolean b(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.f();
            }
        });
    }

    private FontResourcesParserCompat.FontFileResourceEntry i(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i2, boolean z) {
        return (FontResourcesParserCompat.FontFileResourceEntry) k(fontFamilyFilesResourceEntry.a(), i2, z, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>() {
            /* renamed from: c */
            public int a(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.e();
            }

            /* renamed from: d */
            public boolean b(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.f();
            }
        });
    }

    private static <T> T j(T[] tArr, int i2, StyleExtractor<T> styleExtractor) {
        return k(tArr, (i2 & 1) == 0 ? 400 : TypedValues.TransitionType.f4033j, (i2 & 2) != 0, styleExtractor);
    }

    private static <T> T k(T[] tArr, int i2, boolean z, StyleExtractor<T> styleExtractor) {
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(styleExtractor.a(t2) - i2) * 2) + (styleExtractor.b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    private static long n(@Nullable Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e2) {
            Log.e(f5862b, "Could not retrieve font from family.", e2);
            return 0;
        } catch (IllegalAccessException e3) {
            Log.e(f5862b, "Could not retrieve font from family.", e3);
            return 0;
        }
    }

    @Nullable
    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        FontResourcesParserCompat.FontFileResourceEntry h2 = h(fontFamilyFilesResourceEntry, i2);
        if (h2 == null) {
            return null;
        }
        Typeface h3 = TypefaceCompat.h(context, resources, h2.b(), h2.a(), 0, i2);
        a(h3, fontFamilyFilesResourceEntry);
        return h3;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Typeface c(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2, boolean z) {
        FontResourcesParserCompat.FontFileResourceEntry i3 = i(fontFamilyFilesResourceEntry, i2, z);
        if (i3 == null) {
            return null;
        }
        Typeface h2 = TypefaceCompat.h(context, resources, i3.b(), i3.a(), 0, 0);
        a(h2, fontFamilyFilesResourceEntry);
        return h2;
    }

    @Nullable
    public Typeface d(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(l(fontInfoArr, i2).d());
            try {
                Typeface e2 = e(context, inputStream);
                TypefaceCompatUtil.a(inputStream);
                return e2;
            } catch (IOException unused) {
                TypefaceCompatUtil.a(inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                TypefaceCompatUtil.a(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            TypefaceCompatUtil.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            TypefaceCompatUtil.a(inputStream2);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public Typeface e(Context context, InputStream inputStream) {
        File e2 = TypefaceCompatUtil.e(context);
        if (e2 == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.d(e2, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e2.getPath());
            e2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e2.delete();
        }
    }

    @Nullable
    public Typeface f(Context context, Resources resources, int i2, String str, int i3) {
        File e2 = TypefaceCompatUtil.e(context);
        if (e2 == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.c(e2, resources, i2)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(e2.getPath());
            e2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e2.delete();
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Typeface g(@NonNull Context context, @NonNull Typeface typeface, int i2, boolean z) {
        Typeface typeface2;
        try {
            typeface2 = WeightTypefaceApi14.a(this, context, typeface, i2, z);
        } catch (RuntimeException unused) {
            typeface2 = null;
        }
        return typeface2 == null ? typeface : typeface2;
    }

    /* access modifiers changed from: protected */
    public FontsContractCompat.FontInfo l(FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        return (FontsContractCompat.FontInfo) j(fontInfoArr, i2, new StyleExtractor<FontsContractCompat.FontInfo>() {
            /* renamed from: c */
            public int a(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.e();
            }

            /* renamed from: d */
            public boolean b(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.f();
            }
        });
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public FontResourcesParserCompat.FontFamilyFilesResourceEntry m(Typeface typeface) {
        long n2 = n(typeface);
        if (n2 == 0) {
            return null;
        }
        return this.f5864a.get(Long.valueOf(n2));
    }
}
