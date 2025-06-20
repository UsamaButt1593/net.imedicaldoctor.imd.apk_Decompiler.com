package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002#$B1\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b!\u0010\u000f¨\u0006%"}, d2 = {"Landroidx/activity/result/IntentSenderRequest;", "Landroid/os/Parcelable;", "Landroid/content/IntentSender;", "intentSender", "Landroid/content/Intent;", "fillInIntent", "", "flagsMask", "flagsValues", "<init>", "(Landroid/content/IntentSender;Landroid/content/Intent;II)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "describeContents", "()I", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "s", "Landroid/content/IntentSender;", "d", "()Landroid/content/IntentSender;", "X", "Landroid/content/Intent;", "a", "()Landroid/content/Intent;", "Y", "I", "b", "Z", "c", "X2", "Builder", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0})
@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    @NotNull
    @JvmField
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new IntentSenderRequest$Companion$CREATOR$1();
    @NotNull
    public static final Companion X2 = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final Intent X;
    private final int Y;
    private final int Z;
    @NotNull
    private final IntentSender s;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001c"}, d2 = {"Landroidx/activity/result/IntentSenderRequest$Builder;", "", "Landroid/content/IntentSender;", "intentSender", "<init>", "(Landroid/content/IntentSender;)V", "Landroid/app/PendingIntent;", "pendingIntent", "(Landroid/app/PendingIntent;)V", "Landroid/content/Intent;", "fillInIntent", "b", "(Landroid/content/Intent;)Landroidx/activity/result/IntentSenderRequest$Builder;", "", "values", "mask", "c", "(II)Landroidx/activity/result/IntentSenderRequest$Builder;", "Landroidx/activity/result/IntentSenderRequest;", "a", "()Landroidx/activity/result/IntentSenderRequest;", "Landroid/content/IntentSender;", "Landroid/content/Intent;", "I", "flagsMask", "d", "flagsValues", "Flag", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class Builder {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final IntentSender f2489a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Intent f2490b;

        /* renamed from: c  reason: collision with root package name */
        private int f2491c;

        /* renamed from: d  reason: collision with root package name */
        private int f2492d;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/activity/result/IntentSenderRequest$Builder$Flag;", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Retention(AnnotationRetention.s)
        @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
        private @interface Flag {
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Builder(@org.jetbrains.annotations.NotNull android.app.PendingIntent r2) {
            /*
                r1 = this;
                java.lang.String r0 = "pendingIntent"
                kotlin.jvm.internal.Intrinsics.p(r2, r0)
                android.content.IntentSender r2 = r2.getIntentSender()
                java.lang.String r0 = "pendingIntent.intentSender"
                kotlin.jvm.internal.Intrinsics.o(r2, r0)
                r1.<init>((android.content.IntentSender) r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.IntentSenderRequest.Builder.<init>(android.app.PendingIntent):void");
        }

        @NotNull
        public final IntentSenderRequest a() {
            return new IntentSenderRequest(this.f2489a, this.f2490b, this.f2491c, this.f2492d);
        }

        @NotNull
        public final Builder b(@Nullable Intent intent) {
            this.f2490b = intent;
            return this;
        }

        @NotNull
        public final Builder c(int i2, int i3) {
            this.f2492d = i2;
            this.f2491c = i3;
            return this;
        }

        public Builder(@NotNull IntentSender intentSender) {
            Intrinsics.p(intentSender, "intentSender");
            this.f2489a = intentSender;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\b\u0010\u0003¨\u0006\t"}, d2 = {"Landroidx/activity/result/IntentSenderRequest$Companion;", "", "<init>", "()V", "Landroid/os/Parcelable$Creator;", "Landroidx/activity/result/IntentSenderRequest;", "CREATOR", "Landroid/os/Parcelable$Creator;", "a", "activity_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void a() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public IntentSenderRequest(@NotNull IntentSender intentSender, @Nullable Intent intent, int i2, int i3) {
        Intrinsics.p(intentSender, "intentSender");
        this.s = intentSender;
        this.X = intent;
        this.Y = i2;
        this.Z = i3;
    }

    @Nullable
    public final Intent a() {
        return this.X;
    }

    public final int b() {
        return this.Y;
    }

    public final int c() {
        return this.Z;
    }

    @NotNull
    public final IntentSender d() {
        return this.s;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.p(parcel, "dest");
        parcel.writeParcelable(this.s, i2);
        parcel.writeParcelable(this.X, i2);
        parcel.writeInt(this.Y);
        parcel.writeInt(this.Z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntentSenderRequest(IntentSender intentSender, Intent intent, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(intentSender, (i4 & 2) != 0 ? null : intent, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public IntentSenderRequest(@org.jetbrains.annotations.NotNull android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.p(r4, r0)
            java.lang.Class<android.content.IntentSender> r0 = android.content.IntentSender.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r4.readParcelable(r0)
            kotlin.jvm.internal.Intrinsics.m(r0)
            android.content.IntentSender r0 = (android.content.IntentSender) r0
            java.lang.Class<android.content.Intent> r1 = android.content.Intent.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r4.readParcelable(r1)
            android.content.Intent r1 = (android.content.Intent) r1
            int r2 = r4.readInt()
            int r4 = r4.readInt()
            r3.<init>(r0, r1, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.IntentSenderRequest.<init>(android.os.Parcel):void");
    }
}
