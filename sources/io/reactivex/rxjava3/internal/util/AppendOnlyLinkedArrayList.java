package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Predicate;
import org.reactivestreams.Subscriber;

public class AppendOnlyLinkedArrayList<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f28475a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f28476b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f28477c;

    /* renamed from: d  reason: collision with root package name */
    int f28478d;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int i2) {
        this.f28475a = i2;
        Object[] objArr = new Object[(i2 + 1)];
        this.f28476b = objArr;
        this.f28477c = objArr;
    }

    public <U> boolean a(Observer<? super U> observer) {
        Object[] objArr = this.f28476b;
        int i2 = this.f28475a;
        while (true) {
            int i3 = 0;
            if (objArr == null) {
                return false;
            }
            while (i3 < i2) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.c(objArr2, observer)) {
                    return true;
                } else {
                    i3++;
                }
            }
            objArr = objArr[i2];
        }
    }

    public <U> boolean b(Subscriber<? super U> subscriber) {
        Object[] objArr = this.f28476b;
        int i2 = this.f28475a;
        while (true) {
            int i3 = 0;
            if (objArr == null) {
                return false;
            }
            while (i3 < i2) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.e(objArr2, subscriber)) {
                    return true;
                } else {
                    i3++;
                }
            }
            objArr = objArr[i2];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(T r4) {
        /*
            r3 = this;
            int r0 = r3.f28475a
            int r1 = r3.f28478d
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.f28477c
            r2[r0] = r1
            r3.f28477c = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.f28477c
            r0[r1] = r4
            int r1 = r1 + 1
            r3.f28478d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList.c(java.lang.Object):void");
    }

    public void d(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i2 = this.f28475a;
        for (Object[] objArr = this.f28476b; objArr != null; objArr = objArr[i2]) {
            int i3 = 0;
            while (i3 < i2) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (!nonThrowingPredicate.test(objArr2)) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public <S> void e(S s, BiPredicate<? super S, ? super T> biPredicate) throws Throwable {
        Object[] objArr = this.f28476b;
        int i2 = this.f28475a;
        while (true) {
            int i3 = 0;
            while (i3 < i2) {
                Object[] objArr2 = objArr[i3];
                if (objArr2 != null && !biPredicate.a(s, objArr2)) {
                    i3++;
                } else {
                    return;
                }
            }
            objArr = objArr[i2];
        }
    }

    public void f(T t) {
        this.f28476b[0] = t;
    }
}
