package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;
import com.airbnb.lottie.utils.Utils;
import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.tool.xml.html.HTML;
import java.time.Instant;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001.B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bB\u0011\b\u0017\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u001bJ\u001f\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u001b¨\u0006/"}, d2 = {"Lcom/google/firebase/Timestamp;", "", "Landroid/os/Parcelable;", "", "seconds", "", "nanoseconds", "<init>", "(JI)V", "Ljava/util/Date;", "date", "(Ljava/util/Date;)V", "Ljava/time/Instant;", "time", "(Ljava/time/Instant;)V", "j", "()Ljava/util/Date;", "k", "()Ljava/time/Instant;", "other", "a", "(Lcom/google/firebase/Timestamp;)I", "", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "s", "J", "c", "()J", "X", "I", "b", "Y", "Companion", "com.google.firebase-firebase-common"}, k = 1, mv = {1, 8, 0})
public final class Timestamp implements Comparable<Timestamp>, Parcelable {
    @NotNull
    @JvmField
    public static final Parcelable.Creator<Timestamp> CREATOR = new Timestamp$Companion$CREATOR$1();
    @NotNull
    public static final Companion Y = new Companion((DefaultConstructorMarker) null);
    private final int X;
    private final long s;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00128\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/google/firebase/Timestamp$Companion;", "", "<init>", "()V", "Ljava/util/Date;", "Lkotlin/Pair;", "", "", "d", "(Ljava/util/Date;)Lkotlin/Pair;", "seconds", "nanoseconds", "", "e", "(JI)V", "Lcom/google/firebase/Timestamp;", "c", "()Lcom/google/firebase/Timestamp;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "com.google.firebase-firebase-common"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        public final Pair<Long, Integer> d(Date date) {
            Long valueOf;
            long j2 = (long) 1000;
            long time = date.getTime() / j2;
            int time2 = (int) ((date.getTime() % j2) * ((long) 1000000));
            if (time2 < 0) {
                valueOf = Long.valueOf(time - 1);
                time2 += Utils.f17347a;
            } else {
                valueOf = Long.valueOf(time);
            }
            return TuplesKt.a(valueOf, Integer.valueOf(time2));
        }

        /* access modifiers changed from: private */
        public final void e(long j2, int i2) {
            if (i2 < 0 || i2 >= 1000000000) {
                throw new IllegalArgumentException(("Timestamp nanoseconds out of range: " + i2).toString());
            } else if (-62135596800L > j2 || j2 >= 253402300800L) {
                throw new IllegalArgumentException(("Timestamp seconds out of range: " + j2).toString());
            }
        }

        @JvmStatic
        @NotNull
        public final Timestamp c() {
            return new Timestamp(new Date());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Timestamp(long j2, int i2) {
        Y.e(j2, i2);
        this.s = j2;
        this.X = i2;
    }

    @JvmStatic
    @NotNull
    public static final Timestamp g() {
        return Y.c();
    }

    /* renamed from: a */
    public int compareTo(@NotNull Timestamp timestamp) {
        Intrinsics.p(timestamp, "other");
        return ComparisonsKt.o(this, timestamp, Timestamp$compareTo$1.b3, Timestamp$compareTo$2.b3);
    }

    public final int b() {
        return this.X;
    }

    public final long c() {
        return this.s;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof Timestamp) && compareTo((Timestamp) obj) == 0);
    }

    public int hashCode() {
        long j2 = this.s;
        return (((((int) j2) * 1369) + ((int) (j2 >> 32))) * 37) + this.X;
    }

    @NotNull
    public final Date j() {
        return new Date((this.s * ((long) 1000)) + ((long) (this.X / 1000000)));
    }

    @RequiresApi(26)
    @NotNull
    public final Instant k() {
        Instant a2 = Instant.ofEpochSecond(this.s, (long) this.X);
        Intrinsics.o(a2, "ofEpochSecond(seconds, nanoseconds.toLong())");
        return a2;
    }

    @NotNull
    public String toString() {
        return "Timestamp(seconds=" + this.s + ", nanoseconds=" + this.X + ASCIIPropertyListParser.f18650h;
    }

    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.p(parcel, "dest");
        parcel.writeLong(this.s);
        parcel.writeInt(this.X);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RequiresApi(26)
    public Timestamp(@NotNull Instant instant) {
        this(i.a(instant), j.a(instant));
        Intrinsics.p(instant, HTML.Tag.P0);
    }

    public Timestamp(@NotNull Date date) {
        Intrinsics.p(date, DublinCoreProperties.f27398d);
        Companion companion = Y;
        Pair a2 = companion.d(date);
        long longValue = ((Number) a2.a()).longValue();
        int intValue = ((Number) a2.b()).intValue();
        companion.e(longValue, intValue);
        this.s = longValue;
        this.X = intValue;
    }
}
