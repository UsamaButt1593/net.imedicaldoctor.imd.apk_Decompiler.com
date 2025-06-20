package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.IResultReceiver;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.Y})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() {
        /* renamed from: a */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        /* renamed from: b */
        public ResultReceiver[] newArray(int i2) {
            return new ResultReceiver[i2];
        }
    };
    final Handler X;
    IResultReceiver Y;
    final boolean s;

    class MyResultReceiver extends IResultReceiver.Stub {
        MyResultReceiver() {
        }

        public void A(int i2, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.X;
            if (handler != null) {
                handler.post(new MyRunnable(i2, bundle));
            } else {
                resultReceiver.a(i2, bundle);
            }
        }
    }

    class MyRunnable implements Runnable {
        final Bundle X;
        final int s;

        MyRunnable(int i2, Bundle bundle) {
            this.s = i2;
            this.X = bundle;
        }

        public void run() {
            ResultReceiver.this.a(this.s, this.X);
        }
    }

    public ResultReceiver(Handler handler) {
        this.s = true;
        this.X = handler;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, Bundle bundle) {
    }

    public void b(int i2, Bundle bundle) {
        if (this.s) {
            Handler handler = this.X;
            if (handler != null) {
                handler.post(new MyRunnable(i2, bundle));
            } else {
                a(i2, bundle);
            }
        } else {
            IResultReceiver iResultReceiver = this.Y;
            if (iResultReceiver != null) {
                try {
                    iResultReceiver.A(i2, bundle);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        synchronized (this) {
            try {
                if (this.Y == null) {
                    this.Y = new MyResultReceiver();
                }
                parcel.writeStrongBinder(this.Y.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    ResultReceiver(Parcel parcel) {
        this.s = false;
        this.X = null;
        this.Y = IResultReceiver.Stub.e(parcel.readStrongBinder());
    }
}
