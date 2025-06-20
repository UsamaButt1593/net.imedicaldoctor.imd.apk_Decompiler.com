package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dd.plist.ASCIIPropertyListParser;

@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() {
        /* renamed from: a */
        public ActivityResult createFromParcel(@NonNull Parcel parcel) {
            return new ActivityResult(parcel);
        }

        /* renamed from: b */
        public ActivityResult[] newArray(int i2) {
            return new ActivityResult[i2];
        }
    };
    @Nullable
    private final Intent X;
    private final int s;

    public ActivityResult(int i2, @Nullable Intent intent) {
        this.s = i2;
        this.X = intent;
    }

    @NonNull
    public static String c(int i2) {
        if (i2 != -1) {
            return i2 != 0 ? String.valueOf(i2) : "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    @Nullable
    public Intent a() {
        return this.X;
    }

    public int b() {
        return this.s;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.s) + ", data=" + this.X + ASCIIPropertyListParser.f18653k;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeInt(this.s);
        parcel.writeInt(this.X == null ? 0 : 1);
        Intent intent = this.X;
        if (intent != null) {
            intent.writeToParcel(parcel, i2);
        }
    }

    ActivityResult(Parcel parcel) {
        this.s = parcel.readInt();
        this.X = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
