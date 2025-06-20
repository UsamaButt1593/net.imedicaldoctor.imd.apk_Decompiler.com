package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.HashMap;

@RestrictedInheritance(allowedOnPath = ".*javatests/com/google/android/gmscore/integ/client/common/robolectric/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@ShowFirstParty
@KeepForSdk
public class GmsSignatureVerifier {

    /* renamed from: a  reason: collision with root package name */
    private static final zzab f19865a;

    /* renamed from: b  reason: collision with root package name */
    private static final zzab f19866b;

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap f19867c = new HashMap();

    static {
        zzz zzz = new zzz();
        zzz.d("com.google.android.gms");
        zzz.a(204200000);
        zzl zzl = zzn.f20429d;
        zzz.c(zzag.zzn(zzl.z(), zzn.f20427b.z()));
        zzl zzl2 = zzn.f20428c;
        zzz.b(zzag.zzn(zzl2.z(), zzn.f20426a.z()));
        f19865a = zzz.e();
        zzz zzz2 = new zzz();
        zzz2.d("com.android.vending");
        zzz2.a(82240000);
        zzz2.c(zzag.zzm(zzl.z()));
        zzz2.b(zzag.zzm(zzl2.z()));
        f19866b = zzz2.e();
    }
}
