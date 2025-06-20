package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/google/firebase/Timestamp$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/google/firebase/Timestamp;", "Landroid/os/Parcel;", "source", "a", "(Landroid/os/Parcel;)Lcom/google/firebase/Timestamp;", "", "size", "", "b", "(I)[Lcom/google/firebase/Timestamp;", "com.google.firebase-firebase-common"}, k = 1, mv = {1, 8, 0})
public final class Timestamp$Companion$CREATOR$1 implements Parcelable.Creator<Timestamp> {
    Timestamp$Companion$CREATOR$1() {
    }

    @NotNull
    /* renamed from: a */
    public Timestamp createFromParcel(@NotNull Parcel parcel) {
        Intrinsics.p(parcel, "source");
        return new Timestamp(parcel.readLong(), parcel.readInt());
    }

    @NotNull
    /* renamed from: b */
    public Timestamp[] newArray(int i2) {
        return new Timestamp[i2];
    }
}
