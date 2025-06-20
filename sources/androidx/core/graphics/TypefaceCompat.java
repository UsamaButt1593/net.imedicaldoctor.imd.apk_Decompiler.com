package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;

public class TypefaceCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final TypefaceCompatBaseImpl f5840a;

    /* renamed from: b  reason: collision with root package name */
    private static final LruCache<String, Typeface> f5841b = new LruCache<>(16);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private ResourcesCompat.FontCallback f5842j;

        public ResourcesCallbackAdapter(@Nullable ResourcesCompat.FontCallback fontCallback) {
            this.f5842j = fontCallback;
        }

        public void a(int i2) {
            ResourcesCompat.FontCallback fontCallback = this.f5842j;
            if (fontCallback != null) {
                fontCallback.f(i2);
            }
        }

        public void b(@NonNull Typeface typeface) {
            ResourcesCompat.FontCallback fontCallback = this.f5842j;
            if (fontCallback != null) {
                fontCallback.g(typeface);
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f5840a = i2 >= 29 ? new TypefaceCompatApi29Impl() : i2 >= 28 ? new TypefaceCompatApi28Impl() : i2 >= 26 ? new TypefaceCompatApi26Impl() : (i2 < 24 || !TypefaceCompatApi24Impl.q()) ? new TypefaceCompatApi21Impl() : new TypefaceCompatApi24Impl();
    }

    private TypefaceCompat() {
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void a() {
        f5841b.evictAll();
    }

    @NonNull
    public static Typeface b(@NonNull Context context, @Nullable Typeface typeface, int i2) {
        if (context != null) {
            return Typeface.create(typeface, i2);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @NonNull
    public static Typeface c(@NonNull Context context, @Nullable Typeface typeface, @IntRange(from = 1, to = 1000) int i2, boolean z) {
        if (context != null) {
            Preconditions.g(i2, 1, 1000, "weight");
            if (typeface == null) {
                typeface = Typeface.DEFAULT;
            }
            return f5840a.g(context, typeface, i2, z);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface d(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        return f5840a.d(context, cancellationSignal, fontInfoArr, i2);
    }

    @Deprecated
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface e(@NonNull Context context, @NonNull FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, @NonNull Resources resources, int i2, int i3, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z) {
        return f(context, familyResourceEntry, resources, i2, (String) null, 0, i3, fontCallback, handler, z);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface f(@NonNull Context context, @NonNull FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, @NonNull Resources resources, int i2, @Nullable String str, int i3, int i4, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z) {
        Typeface typeface;
        FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry2 = familyResourceEntry;
        ResourcesCompat.FontCallback fontCallback2 = fontCallback;
        Handler handler2 = handler;
        if (familyResourceEntry2 instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry2;
            Typeface m2 = m(providerResourceEntry.c());
            if (m2 != null) {
                if (fontCallback2 != null) {
                    fontCallback2.d(m2, handler2);
                }
                return m2;
            }
            typeface = FontsContractCompat.f(context, providerResourceEntry.b(), i4, !z ? fontCallback2 == null : providerResourceEntry.a() == 0, z ? providerResourceEntry.d() : -1, ResourcesCompat.FontCallback.e(handler), new ResourcesCallbackAdapter(fontCallback2));
            Resources resources2 = resources;
            int i5 = i4;
        } else {
            Context context2 = context;
            Resources resources3 = resources;
            typeface = f5840a.b(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry2, resources, i4);
            if (fontCallback2 != null) {
                if (typeface != null) {
                    fontCallback2.d(typeface, handler2);
                } else {
                    fontCallback2.c(-3, handler2);
                }
            }
        }
        if (typeface != null) {
            f5841b.put(i(resources, i2, str, i3, i4), typeface);
        }
        return typeface;
    }

    @Deprecated
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface g(@NonNull Context context, @NonNull Resources resources, int i2, String str, int i3) {
        return h(context, resources, i2, str, 0, i3);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface h(@NonNull Context context, @NonNull Resources resources, int i2, String str, int i3, int i4) {
        Typeface f2 = f5840a.f(context, resources, i2, str, i4);
        if (f2 != null) {
            f5841b.put(i(resources, i2, str, i3, i4), f2);
        }
        return f2;
    }

    private static String i(Resources resources, int i2, String str, int i3, int i4) {
        return resources.getResourcePackageName(i2) + '-' + str + '-' + i3 + '-' + i2 + '-' + i4;
    }

    @Deprecated
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface j(@NonNull Resources resources, int i2, int i3) {
        return k(resources, i2, (String) null, 0, i3);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface k(@NonNull Resources resources, int i2, @Nullable String str, int i3, int i4) {
        return f5841b.get(i(resources, i2, str, i3, i4));
    }

    @Nullable
    private static Typeface l(Context context, Typeface typeface, int i2) {
        TypefaceCompatBaseImpl typefaceCompatBaseImpl = f5840a;
        FontResourcesParserCompat.FontFamilyFilesResourceEntry m2 = typefaceCompatBaseImpl.m(typeface);
        if (m2 == null) {
            return null;
        }
        return typefaceCompatBaseImpl.b(context, m2, context.getResources(), i2);
    }

    private static Typeface m(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
