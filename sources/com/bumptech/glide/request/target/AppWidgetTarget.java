package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

public class AppWidgetTarget extends CustomTarget<Bitmap> {
    private final ComponentName X2;
    private final RemoteViews Y2;
    private final int[] Z;
    private final Context Z2;
    private final int a3;

    public AppWidgetTarget(Context context, int i2, int i3, int i4, RemoteViews remoteViews, ComponentName componentName) {
        super(i2, i3);
        this.Z2 = (Context) Preconditions.e(context, "Context can not be null!");
        this.Y2 = (RemoteViews) Preconditions.e(remoteViews, "RemoteViews object can not be null!");
        this.X2 = (ComponentName) Preconditions.e(componentName, "ComponentName can not be null!");
        this.a3 = i4;
        this.Z = null;
    }

    private void g(@Nullable Bitmap bitmap) {
        this.Y2.setImageViewBitmap(this.a3, bitmap);
        h();
    }

    private void h() {
        AppWidgetManager instance = AppWidgetManager.getInstance(this.Z2);
        ComponentName componentName = this.X2;
        if (componentName != null) {
            instance.updateAppWidget(componentName, this.Y2);
        } else {
            instance.updateAppWidget(this.Z, this.Y2);
        }
    }

    /* renamed from: f */
    public void e(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        g(bitmap);
    }

    public void r(@Nullable Drawable drawable) {
        g((Bitmap) null);
    }

    public AppWidgetTarget(Context context, int i2, int i3, int i4, RemoteViews remoteViews, int... iArr) {
        super(i2, i3);
        if (iArr.length != 0) {
            this.Z2 = (Context) Preconditions.e(context, "Context can not be null!");
            this.Y2 = (RemoteViews) Preconditions.e(remoteViews, "RemoteViews object can not be null!");
            this.Z = (int[]) Preconditions.e(iArr, "WidgetIds can not be null!");
            this.a3 = i4;
            this.X2 = null;
            return;
        }
        throw new IllegalArgumentException("WidgetIds must have length > 0");
    }

    public AppWidgetTarget(Context context, int i2, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, componentName);
    }

    public AppWidgetTarget(Context context, int i2, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, iArr);
    }
}
