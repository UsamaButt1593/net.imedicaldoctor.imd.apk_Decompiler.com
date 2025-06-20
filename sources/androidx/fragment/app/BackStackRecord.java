package androidx.fragment.app;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {
    private static final String R = "FragmentManager";
    final FragmentManager N;
    boolean O;
    int P;
    boolean Q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackStackRecord(@NonNull BackStackRecord backStackRecord) {
        super(backStackRecord.N.G0(), backStackRecord.N.J0() != null ? backStackRecord.N.J0().m().getClassLoader() : null, backStackRecord);
        this.P = -1;
        this.Q = false;
        this.N = backStackRecord.N;
        this.O = backStackRecord.O;
        this.P = backStackRecord.P;
        this.Q = backStackRecord.Q;
    }

    public boolean A() {
        return this.f7996c.isEmpty();
    }

    @NonNull
    public FragmentTransaction B(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.m3;
        if (fragmentManager == null || fragmentManager == this.N) {
            return super.B(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @NonNull
    public FragmentTransaction O(@NonNull Fragment fragment, @NonNull Lifecycle.State state) {
        if (fragment.m3 != this.N) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.N);
        } else if (state == Lifecycle.State.INITIALIZED && fragment.s > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        } else if (state != Lifecycle.State.DESTROYED) {
            return super.O(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    @NonNull
    public FragmentTransaction P(@Nullable Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.m3) == null || fragmentManager == this.N) {
            return super.P(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @NonNull
    public FragmentTransaction T(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.m3;
        if (fragmentManager == null || fragmentManager == this.N) {
            return super.T(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    public void U(int i2) {
        if (this.f8002i) {
            if (FragmentManager.W0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f7996c.size();
            for (int i3 = 0; i3 < size; i3++) {
                FragmentTransaction.Op op = this.f7996c.get(i3);
                Fragment fragment = op.f8009b;
                if (fragment != null) {
                    fragment.l3 += i2;
                    if (FragmentManager.W0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + op.f8009b + " to " + op.f8009b.l3);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void V() {
        int size = this.f7996c.size() - 1;
        while (size >= 0) {
            FragmentTransaction.Op op = this.f7996c.get(size);
            if (op.f8010c) {
                if (op.f8008a == 8) {
                    op.f8010c = false;
                    this.f7996c.remove(size - 1);
                    size--;
                } else {
                    int i2 = op.f8009b.r3;
                    op.f8008a = 2;
                    op.f8010c = false;
                    for (int i3 = size - 1; i3 >= 0; i3--) {
                        FragmentTransaction.Op op2 = this.f7996c.get(i3);
                        if (op2.f8010c && op2.f8009b.r3 == i2) {
                            this.f7996c.remove(i3);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    /* access modifiers changed from: package-private */
    public int W(boolean z) {
        if (!this.O) {
            if (FragmentManager.W0(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                X("  ", printWriter);
                printWriter.close();
            }
            this.O = true;
            this.P = this.f8002i ? this.N.r() : -1;
            this.N.h0(this, z);
            return this.P;
        }
        throw new IllegalStateException("commit already called");
    }

    public void X(String str, PrintWriter printWriter) {
        Y(str, printWriter, true);
    }

    public void Y(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f8004k);
            printWriter.print(" mIndex=");
            printWriter.print(this.P);
            printWriter.print(" mCommitted=");
            printWriter.println(this.O);
            if (this.f8001h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f8001h));
            }
            if (!(this.f7997d == 0 && this.f7998e == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f7997d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f7998e));
            }
            if (!(this.f7999f == 0 && this.f8000g == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f7999f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f8000g));
            }
            if (!(this.f8005l == 0 && this.f8006m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f8005l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f8006m);
            }
            if (!(this.f8007n == 0 && this.o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f8007n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.o);
            }
        }
        if (!this.f7996c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f7996c.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction.Op op = this.f7996c.get(i2);
                switch (op.f8008a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + op.f8008a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(StringUtils.SPACE);
                printWriter.println(op.f8009b);
                if (z) {
                    if (!(op.f8011d == 0 && op.f8012e == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.f8011d));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.f8012e));
                    }
                    if (op.f8013f != 0 || op.f8014g != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.f8013f));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.f8014g));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        FragmentManager fragmentManager;
        int size = this.f7996c.size();
        for (int i2 = 0; i2 < size; i2++) {
            FragmentTransaction.Op op = this.f7996c.get(i2);
            Fragment fragment = op.f8009b;
            if (fragment != null) {
                fragment.g3 = this.Q;
                fragment.s2(false);
                fragment.r2(this.f8001h);
                fragment.y2(this.p, this.q);
            }
            switch (op.f8008a) {
                case 1:
                    fragment.h2(op.f8011d, op.f8012e, op.f8013f, op.f8014g);
                    this.N.V1(fragment, false);
                    this.N.n(fragment);
                    continue;
                case 3:
                    fragment.h2(op.f8011d, op.f8012e, op.f8013f, op.f8014g);
                    this.N.C1(fragment);
                    continue;
                case 4:
                    fragment.h2(op.f8011d, op.f8012e, op.f8013f, op.f8014g);
                    this.N.T0(fragment);
                    continue;
                case 5:
                    fragment.h2(op.f8011d, op.f8012e, op.f8013f, op.f8014g);
                    this.N.V1(fragment, false);
                    this.N.c2(fragment);
                    continue;
                case 6:
                    fragment.h2(op.f8011d, op.f8012e, op.f8013f, op.f8014g);
                    this.N.E(fragment);
                    continue;
                case 7:
                    fragment.h2(op.f8011d, op.f8012e, op.f8013f, op.f8014g);
                    this.N.V1(fragment, false);
                    this.N.t(fragment);
                    continue;
                case 8:
                    fragmentManager = this.N;
                    break;
                case 9:
                    fragmentManager = this.N;
                    fragment = null;
                    break;
                case 10:
                    this.N.X1(fragment, op.f8016i);
                    continue;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f8008a);
            }
            fragmentManager.Y1(fragment);
        }
    }

    @Nullable
    public CharSequence a() {
        return this.f8005l != 0 ? this.N.J0().m().getText(this.f8005l) : this.f8006m;
    }

    /* access modifiers changed from: package-private */
    public void a0() {
        FragmentManager fragmentManager;
        for (int size = this.f7996c.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op = this.f7996c.get(size);
            Fragment fragment = op.f8009b;
            if (fragment != null) {
                fragment.g3 = this.Q;
                fragment.s2(true);
                fragment.r2(FragmentManager.O1(this.f8001h));
                fragment.y2(this.q, this.p);
            }
            switch (op.f8008a) {
                case 1:
                    fragment.h2(op.f8011d, op.f8012e, op.f8013f, op.f8014g);
                    this.N.V1(fragment, true);
                    this.N.C1(fragment);
                    continue;
                case 3:
                    fragment.h2(op.f8011d, op.f8012e, op.f8013f, op.f8014g);
                    this.N.n(fragment);
                    continue;
                case 4:
                    fragment.h2(op.f8011d, op.f8012e, op.f8013f, op.f8014g);
                    this.N.c2(fragment);
                    continue;
                case 5:
                    fragment.h2(op.f8011d, op.f8012e, op.f8013f, op.f8014g);
                    this.N.V1(fragment, true);
                    this.N.T0(fragment);
                    continue;
                case 6:
                    fragment.h2(op.f8011d, op.f8012e, op.f8013f, op.f8014g);
                    this.N.t(fragment);
                    continue;
                case 7:
                    fragment.h2(op.f8011d, op.f8012e, op.f8013f, op.f8014g);
                    this.N.V1(fragment, true);
                    this.N.E(fragment);
                    continue;
                case 8:
                    fragmentManager = this.N;
                    fragment = null;
                    break;
                case 9:
                    fragmentManager = this.N;
                    break;
                case 10:
                    this.N.X1(fragment, op.f8015h);
                    continue;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f8008a);
            }
            fragmentManager.Y1(fragment);
        }
    }

    public boolean b(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        if (FragmentManager.W0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f8002i) {
            return true;
        }
        this.N.m(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public Fragment b0(ArrayList<Fragment> arrayList, Fragment fragment) {
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i2 = 0;
        while (i2 < this.f7996c.size()) {
            FragmentTransaction.Op op = this.f7996c.get(i2);
            int i3 = op.f8008a;
            if (i3 != 1) {
                if (i3 == 2) {
                    Fragment fragment3 = op.f8009b;
                    int i4 = fragment3.r3;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList2.get(size);
                        if (fragment4.r3 == i4) {
                            if (fragment4 == fragment3) {
                                z = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f7996c.add(i2, new FragmentTransaction.Op(9, fragment4, true));
                                    i2++;
                                    fragment2 = null;
                                }
                                FragmentTransaction.Op op2 = new FragmentTransaction.Op(3, fragment4, true);
                                op2.f8011d = op.f8011d;
                                op2.f8013f = op.f8013f;
                                op2.f8012e = op.f8012e;
                                op2.f8014g = op.f8014g;
                                this.f7996c.add(i2, op2);
                                arrayList2.remove(fragment4);
                                i2++;
                            }
                        }
                    }
                    if (z) {
                        this.f7996c.remove(i2);
                        i2--;
                    } else {
                        op.f8008a = 1;
                        op.f8010c = true;
                        arrayList2.add(fragment3);
                    }
                } else if (i3 == 3 || i3 == 6) {
                    arrayList2.remove(op.f8009b);
                    Fragment fragment5 = op.f8009b;
                    if (fragment5 == fragment2) {
                        this.f7996c.add(i2, new FragmentTransaction.Op(9, fragment5));
                        i2++;
                        fragment2 = null;
                    }
                } else if (i3 != 7) {
                    if (i3 == 8) {
                        this.f7996c.add(i2, new FragmentTransaction.Op(9, fragment2, true));
                        op.f8010c = true;
                        i2++;
                        fragment2 = op.f8009b;
                    }
                }
                i2++;
            }
            arrayList2.add(op.f8009b);
            i2++;
        }
        return fragment2;
    }

    public int c() {
        return this.f8007n;
    }

    public void c0() {
        if (this.s != null) {
            for (int i2 = 0; i2 < this.s.size(); i2++) {
                this.s.get(i2).run();
            }
            this.s = null;
        }
    }

    public int d() {
        return this.f8005l;
    }

    /* access modifiers changed from: package-private */
    public Fragment d0(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f7996c.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op = this.f7996c.get(size);
            int i2 = op.f8008a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = op.f8009b;
                            break;
                        case 10:
                            op.f8016i = op.f8015h;
                            break;
                    }
                }
                arrayList.add(op.f8009b);
            }
            arrayList.remove(op.f8009b);
        }
        return fragment;
    }

    @Nullable
    public CharSequence e() {
        return this.f8007n != 0 ? this.N.J0().m().getText(this.f8007n) : this.o;
    }

    public int getId() {
        return this.P;
    }

    @Nullable
    public String getName() {
        return this.f8004k;
    }

    public int q() {
        return W(false);
    }

    public int r() {
        return W(true);
    }

    public void s() {
        w();
        this.N.k0(this, false);
    }

    public void t() {
        w();
        this.N.k0(this, true);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.P >= 0) {
            sb.append(" #");
            sb.append(this.P);
        }
        if (this.f8004k != null) {
            sb.append(StringUtils.SPACE);
            sb.append(this.f8004k);
        }
        sb.append("}");
        return sb.toString();
    }

    @NonNull
    public FragmentTransaction v(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.m3;
        if (fragmentManager == null || fragmentManager == this.N) {
            return super.v(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* access modifiers changed from: package-private */
    public void x(int i2, Fragment fragment, @Nullable String str, int i3) {
        super.x(i2, fragment, str, i3);
        fragment.m3 = this.N;
    }

    @NonNull
    public FragmentTransaction y(@NonNull Fragment fragment) {
        FragmentManager fragmentManager = fragment.m3;
        if (fragmentManager == null || fragmentManager == this.N) {
            return super.y(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackStackRecord(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager.G0(), fragmentManager.J0() != null ? fragmentManager.J0().m().getClassLoader() : null);
        this.P = -1;
        this.Q = false;
        this.N = fragmentManager;
    }
}
