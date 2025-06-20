package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public final class DrawableDecoderCompat {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f18358a = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable a(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        return c(context, context, i2, theme);
    }

    public static Drawable b(Context context, Context context2, @DrawableRes int i2) {
        return c(context, context2, i2, (Resources.Theme) null);
    }

    private static Drawable c(Context context, Context context2, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        try {
            if (f18358a) {
                return e(context2, i2, theme);
            }
        } catch (NoClassDefFoundError unused) {
            f18358a = false;
        } catch (IllegalStateException e2) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.l(context2, i2);
            }
            throw e2;
        } catch (Resources.NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i2, theme);
    }

    private static Drawable d(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        return ResourcesCompat.g(context.getResources(), i2, theme);
    }

    private static Drawable e(Context context, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.b(context, i2);
    }
}
