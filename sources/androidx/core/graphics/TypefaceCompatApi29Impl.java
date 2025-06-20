package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

@RequiresApi(29)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    private Font o(@NonNull FontFamily fontFamily, int i2) {
        FontStyle fontStyle = new FontStyle((i2 & 1) != 0 ? TypedValues.TransitionType.f4033j : 400, (i2 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int p = p(fontStyle, font.getStyle());
        for (int i3 = 1; i3 < fontFamily.getSize(); i3++) {
            Font font2 = fontFamily.getFont(i3);
            int p2 = p(fontStyle, font2.getStyle());
            if (p2 < p) {
                font = font2;
                p = p2;
            }
        }
        return font;
    }

    private static int p(@NonNull FontStyle fontStyle, @NonNull FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Nullable
    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        try {
            FontFamily.Builder builder = null;
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.a()) {
                try {
                    Font build = new Font.Builder(resources, fontFileResourceEntry.b()).setWeight(fontFileResourceEntry.e()).setSlant(fontFileResourceEntry.f() ? 1 : 0).setTtcIndex(fontFileResourceEntry.c()).setFontVariationSettings(fontFileResourceEntry.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(o(build2, i2).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Nullable
    public Typeface d(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(fontInfo.d(), "r", cancellationSignal);
                    if (openFileDescriptor != null) {
                        Font build = new Font.Builder(openFileDescriptor).setWeight(fontInfo.e()).setSlant(fontInfo.f() ? 1 : 0).setTtcIndex(fontInfo.c()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } else if (openFileDescriptor == null) {
                    }
                    openFileDescriptor.close();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(o(build2, i2).getStyle()).build();
            throw th;
        } catch (Exception unused2) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Typeface e(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Nullable
    public Typeface f(Context context, Resources resources, int i2, String str, int i3) {
        try {
            Font build = new Font.Builder(resources, i2).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Typeface g(@NonNull Context context, @NonNull Typeface typeface, int i2, boolean z) {
        return Typeface.create(typeface, i2, z);
    }

    /* access modifiers changed from: protected */
    public FontsContractCompat.FontInfo l(FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
