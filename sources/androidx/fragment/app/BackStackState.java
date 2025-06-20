package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"BanParcelableUsage"})
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {
        /* renamed from: a */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* renamed from: b */
        public BackStackState[] newArray(int i2) {
            return new BackStackState[i2];
        }
    };
    final List<BackStackRecordState> X;
    final List<String> s;

    BackStackState(@NonNull Parcel parcel) {
        this.s = parcel.createStringArrayList();
        this.X = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public List<BackStackRecord> a(@NonNull FragmentManager fragmentManager, Map<String, Fragment> map) {
        HashMap hashMap = new HashMap(this.s.size());
        for (String next : this.s) {
            Fragment fragment = map.get(next);
            if (fragment != null) {
                hashMap.put(fragment.Y2, fragment);
            } else {
                FragmentState C = fragmentManager.H0().C(next, (FragmentState) null);
                if (C != null) {
                    Fragment a2 = C.a(fragmentManager.G0(), fragmentManager.J0().m().getClassLoader());
                    hashMap.put(a2.Y2, a2);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (BackStackRecordState c2 : this.X) {
            arrayList.add(c2.c(fragmentManager, hashMap));
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeStringList(this.s);
        parcel.writeTypedList(this.X);
    }

    BackStackState(List<String> list, List<BackStackRecordState> list2) {
        this.s = list;
        this.X = list2;
    }
}
