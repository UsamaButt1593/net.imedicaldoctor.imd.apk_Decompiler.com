package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

public class NotificationTarget extends CustomTarget<Bitmap> {
    private final Context X2;
    private final int Y2;
    private final RemoteViews Z;
    private final String Z2;
    private final Notification a3;
    private final int b3;

    public NotificationTarget(Context context, int i2, int i3, int i4, RemoteViews remoteViews, Notification notification, int i5, String str) {
        super(i2, i3);
        this.X2 = (Context) Preconditions.e(context, "Context must not be null!");
        this.a3 = (Notification) Preconditions.e(notification, "Notification object can not be null!");
        this.Z = (RemoteViews) Preconditions.e(remoteViews, "RemoteViews object can not be null!");
        this.b3 = i4;
        this.Y2 = i5;
        this.Z2 = str;
    }

    private void g(@Nullable Bitmap bitmap) {
        this.Z.setImageViewBitmap(this.b3, bitmap);
        h();
    }

    private void h() {
        ((NotificationManager) Preconditions.d((NotificationManager) this.X2.getSystemService("notification"))).notify(this.Z2, this.Y2, this.a3);
    }

    /* renamed from: f */
    public void e(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        g(bitmap);
    }

    public void r(@Nullable Drawable drawable) {
        g((Bitmap) null);
    }

    public NotificationTarget(Context context, int i2, RemoteViews remoteViews, Notification notification, int i3) {
        this(context, i2, remoteViews, notification, i3, (String) null);
    }

    public NotificationTarget(Context context, int i2, RemoteViews remoteViews, Notification notification, int i3, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i2, remoteViews, notification, i3, str);
    }
}
