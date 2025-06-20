package androidx.media3.common;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.List;

@UnstableApi
public final class BundleListRetriever extends Binder {

    /* renamed from: m  reason: collision with root package name */
    private static final int f9080m = (Util.f9646a >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536);

    /* renamed from: n  reason: collision with root package name */
    private static final int f9081n = 0;
    private static final int o = 1;
    private static final int p = 2;

    /* renamed from: l  reason: collision with root package name */
    private final ImmutableList<Bundle> f9082l;

    public BundleListRetriever(List<Bundle> list) {
        this.f9082l = ImmutableList.B(list);
    }

    public static ImmutableList<Bundle> a(IBinder iBinder) {
        return iBinder instanceof BundleListRetriever ? ((BundleListRetriever) iBinder).f9082l : b(iBinder);
    }

    @VisibleForTesting
    static ImmutableList<Bundle> b(IBinder iBinder) {
        int readInt;
        ImmutableList.Builder r = ImmutableList.r();
        int i2 = 1;
        int i3 = 0;
        while (i2 != 0) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInt(i3);
                iBinder.transact(1, obtain, obtain2, 0);
                while (true) {
                    readInt = obtain2.readInt();
                    if (readInt != 1) {
                        break;
                    }
                    r.g((Bundle) Assertions.g(obtain2.readBundle()));
                    i3++;
                }
                obtain2.recycle();
                obtain.recycle();
                i2 = readInt;
            } catch (RemoteException e2) {
                throw new RuntimeException(e2);
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
        return r.e();
    }

    /* access modifiers changed from: protected */
    public boolean onTransact(int i2, Parcel parcel, @Nullable Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return super.onTransact(i2, parcel, parcel2, i3);
        }
        int i4 = 0;
        if (parcel2 == null) {
            return false;
        }
        int size = this.f9082l.size();
        int readInt = parcel.readInt();
        while (readInt < size && parcel2.dataSize() < f9080m) {
            parcel2.writeInt(1);
            parcel2.writeBundle(this.f9082l.get(readInt));
            readInt++;
        }
        if (readInt < size) {
            i4 = 2;
        }
        parcel2.writeInt(i4);
        return true;
    }
}
