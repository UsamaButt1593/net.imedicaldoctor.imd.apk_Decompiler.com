package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() {
        /* renamed from: a */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* renamed from: b */
        public FragmentManagerState[] newArray(int i2) {
            return new FragmentManagerState[i2];
        }
    };
    ArrayList<String> X;
    String X2 = null;
    BackStackRecordState[] Y;
    ArrayList<String> Y2 = new ArrayList<>();
    int Z;
    ArrayList<BackStackState> Z2 = new ArrayList<>();
    ArrayList<FragmentManager.LaunchedFragmentInfo> a3;
    ArrayList<String> s;

    public FragmentManagerState() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStringList(this.s);
        parcel.writeStringList(this.X);
        parcel.writeTypedArray(this.Y, i2);
        parcel.writeInt(this.Z);
        parcel.writeString(this.X2);
        parcel.writeStringList(this.Y2);
        parcel.writeTypedList(this.Z2);
        parcel.writeTypedList(this.a3);
    }

    public FragmentManagerState(Parcel parcel) {
        this.s = parcel.createStringArrayList();
        this.X = parcel.createStringArrayList();
        this.Y = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
        this.Z = parcel.readInt();
        this.X2 = parcel.readString();
        this.Y2 = parcel.createStringArrayList();
        this.Z2 = parcel.createTypedArrayList(BackStackState.CREATOR);
        this.a3 = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
