package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.net.URL;

interface ModelTypes<T> {
    @CheckResult
    @Deprecated
    T f(@Nullable URL url);

    @CheckResult
    @NonNull
    T g(@Nullable Uri uri);

    @CheckResult
    @NonNull
    T h(@Nullable byte[] bArr);

    @CheckResult
    @NonNull
    T i(@Nullable File file);

    @CheckResult
    @NonNull
    T l(@Nullable Drawable drawable);

    @CheckResult
    @NonNull
    T m(@Nullable Bitmap bitmap);

    @CheckResult
    @NonNull
    T n(@Nullable Object obj);

    @CheckResult
    @NonNull
    T o(@RawRes @DrawableRes @Nullable Integer num);

    @CheckResult
    @NonNull
    T t(@Nullable String str);
}
