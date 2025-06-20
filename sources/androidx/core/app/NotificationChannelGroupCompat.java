package androidx.core.app;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotificationChannelGroupCompat {

    /* renamed from: a  reason: collision with root package name */
    final String f5301a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f5302b;

    /* renamed from: c  reason: collision with root package name */
    String f5303c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5304d;

    /* renamed from: e  reason: collision with root package name */
    private List<NotificationChannelCompat> f5305e;

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static NotificationChannelGroup a(String str, CharSequence charSequence) {
            return new NotificationChannelGroup(str, charSequence);
        }

        @DoNotInline
        static List<NotificationChannel> b(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getChannels();
        }

        @DoNotInline
        static String c(NotificationChannel notificationChannel) {
            return notificationChannel.getGroup();
        }

        @DoNotInline
        static String d(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        @DoNotInline
        static CharSequence e(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getName();
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static String a(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getDescription();
        }

        @DoNotInline
        static boolean b(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.isBlocked();
        }

        @DoNotInline
        static void c(NotificationChannelGroup notificationChannelGroup, String str) {
            notificationChannelGroup.setDescription(str);
        }
    }

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        final NotificationChannelGroupCompat f5306a;

        public Builder(@NonNull String str) {
            this.f5306a = new NotificationChannelGroupCompat(str);
        }

        @NonNull
        public NotificationChannelGroupCompat a() {
            return this.f5306a;
        }

        @NonNull
        public Builder b(@Nullable String str) {
            this.f5306a.f5303c = str;
            return this;
        }

        @NonNull
        public Builder c(@Nullable CharSequence charSequence) {
            this.f5306a.f5302b = charSequence;
            return this;
        }
    }

    @RequiresApi(28)
    NotificationChannelGroupCompat(@NonNull NotificationChannelGroup notificationChannelGroup) {
        this(notificationChannelGroup, Collections.emptyList());
    }

    @RequiresApi(26)
    private List<NotificationChannelCompat> b(List<NotificationChannel> list) {
        ArrayList arrayList = new ArrayList();
        for (NotificationChannel a2 : list) {
            NotificationChannel a3 = i.a(a2);
            if (this.f5301a.equals(Api26Impl.c(a3))) {
                arrayList.add(new NotificationChannelCompat(a3));
            }
        }
        return arrayList;
    }

    @NonNull
    public List<NotificationChannelCompat> a() {
        return this.f5305e;
    }

    @Nullable
    public String c() {
        return this.f5303c;
    }

    @NonNull
    public String d() {
        return this.f5301a;
    }

    @Nullable
    public CharSequence e() {
        return this.f5302b;
    }

    /* access modifiers changed from: package-private */
    public NotificationChannelGroup f() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            return null;
        }
        NotificationChannelGroup a2 = Api26Impl.a(this.f5301a, this.f5302b);
        if (i2 >= 28) {
            Api28Impl.c(a2, this.f5303c);
        }
        return a2;
    }

    public boolean g() {
        return this.f5304d;
    }

    @NonNull
    public Builder h() {
        return new Builder(this.f5301a).c(this.f5302b).b(this.f5303c);
    }

    @RequiresApi(26)
    NotificationChannelGroupCompat(@NonNull NotificationChannelGroup notificationChannelGroup, @NonNull List<NotificationChannel> list) {
        this(Api26Impl.d(notificationChannelGroup));
        List<NotificationChannelCompat> b2;
        this.f5302b = Api26Impl.e(notificationChannelGroup);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.f5303c = Api28Impl.a(notificationChannelGroup);
        }
        if (i2 >= 28) {
            this.f5304d = Api28Impl.b(notificationChannelGroup);
            b2 = b(Api26Impl.b(notificationChannelGroup));
        } else {
            b2 = b(list);
        }
        this.f5305e = b2;
    }

    NotificationChannelGroupCompat(@NonNull String str) {
        this.f5305e = Collections.emptyList();
        this.f5301a = (String) Preconditions.l(str);
    }
}
