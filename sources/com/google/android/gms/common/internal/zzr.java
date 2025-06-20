package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

final class zzr implements Handler.Callback {
    final /* synthetic */ zzs s;

    /* synthetic */ zzr(zzs zzs, zzq zzq) {
        this.s = zzs;
    }

    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            synchronized (this.s.f20319f) {
                try {
                    zzo zzo = (zzo) message.obj;
                    zzp zzp = (zzp) this.s.f20319f.get(zzo);
                    if (zzp != null && zzp.i()) {
                        if (zzp.j()) {
                            zzp.g("GmsClientSupervisor");
                        }
                        this.s.f20319f.remove(zzo);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        } else if (i2 != 1) {
            return false;
        } else {
            synchronized (this.s.f20319f) {
                try {
                    zzo zzo2 = (zzo) message.obj;
                    zzp zzp2 = (zzp) this.s.f20319f.get(zzo2);
                    if (zzp2 != null && zzp2.a() == 3) {
                        String valueOf = String.valueOf(zzo2);
                        Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + valueOf, new Exception());
                        ComponentName b2 = zzp2.b();
                        if (b2 == null) {
                            b2 = zzo2.a();
                        }
                        if (b2 == null) {
                            String c2 = zzo2.c();
                            Preconditions.r(c2);
                            b2 = new ComponentName(c2, "unknown");
                        }
                        zzp2.onServiceDisconnected(b2);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return true;
        }
    }
}
