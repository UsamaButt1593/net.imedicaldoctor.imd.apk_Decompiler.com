package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuBuilder implements SupportMenu {
    private static final String L = "MenuBuilder";
    private static final String M = "android:menu:presenters";
    private static final String N = "android:menu:actionviewstates";
    private static final String O = "android:menu:expandedactionview";
    private static final int[] P = {1, 4, 5, 3, 2, 0};
    View A;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private ArrayList<MenuItemImpl> G = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> H = new CopyOnWriteArrayList<>();
    private MenuItemImpl I;
    private boolean J = false;
    private boolean K;

    /* renamed from: l  reason: collision with root package name */
    private final Context f2964l;

    /* renamed from: m  reason: collision with root package name */
    private final Resources f2965m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2966n;
    private boolean o;
    private Callback p;
    private ArrayList<MenuItemImpl> q;
    private ArrayList<MenuItemImpl> r;
    private boolean s;
    private ArrayList<MenuItemImpl> t;
    private ArrayList<MenuItemImpl> u;
    private boolean v;
    private int w = 0;
    private ContextMenu.ContextMenuInfo x;
    CharSequence y;
    Drawable z;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface Callback {
        boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem);

        void b(@NonNull MenuBuilder menuBuilder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ItemInvoker {
        boolean a(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.f2964l = context;
        this.f2965m = context.getResources();
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.s = true;
        this.t = new ArrayList<>();
        this.u = new ArrayList<>();
        this.v = true;
        l0(true);
    }

    private static int E(int i2) {
        int i3 = (-65536 & i2) >> 16;
        if (i3 >= 0) {
            int[] iArr = P;
            if (i3 < iArr.length) {
                return (i2 & 65535) | (iArr[i3] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void S(int i2, boolean z2) {
        if (i2 >= 0 && i2 < this.q.size()) {
            this.q.remove(i2);
            if (z2) {
                O(true);
            }
        }
    }

    private void e0(int i2, CharSequence charSequence, int i3, Drawable drawable, View view) {
        Resources F2 = F();
        if (view != null) {
            this.A = view;
            this.y = null;
            this.z = null;
        } else {
            if (i2 > 0) {
                this.y = F2.getText(i2);
            } else if (charSequence != null) {
                this.y = charSequence;
            }
            if (i3 > 0) {
                this.z = ContextCompat.l(x(), i3);
            } else if (drawable != null) {
                this.z = drawable;
            }
            this.A = null;
        }
        O(false);
    }

    private MenuItemImpl h(int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        return new MenuItemImpl(this, i2, i3, i4, i5, charSequence, i6);
    }

    private void j(boolean z2) {
        if (!this.H.isEmpty()) {
            n0();
            Iterator<WeakReference<MenuPresenter>> it2 = this.H.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.H.remove(next);
                } else {
                    menuPresenter.d(z2);
                }
            }
            m0();
        }
    }

    private void k(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(M);
        if (sparseParcelableArray != null && !this.H.isEmpty()) {
            Iterator<WeakReference<MenuPresenter>> it2 = this.H.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.H.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        menuPresenter.j(parcelable);
                    }
                }
            }
        }
    }

    private void l(Bundle bundle) {
        Parcelable n2;
        if (!this.H.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<MenuPresenter>> it2 = this.H.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.H.remove(next);
                } else {
                    int id = menuPresenter.getId();
                    if (id > 0 && (n2 = menuPresenter.n()) != null) {
                        sparseArray.put(id, n2);
                    }
                }
            }
            bundle.putSparseParcelableArray(M, sparseArray);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        if (androidx.core.view.ViewConfigurationCompat.n(android.view.ViewConfiguration.get(r2.f2964l), r2.f2964l) != false) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l0(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x001c
            android.content.res.Resources r3 = r2.f2965m
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L_0x001c
            android.content.Context r3 = r2.f2964l
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.f2964l
            boolean r3 = androidx.core.view.ViewConfigurationCompat.n(r3, r1)
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            r2.o = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuBuilder.l0(boolean):void");
    }

    private boolean m(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        boolean z2 = false;
        if (this.H.isEmpty()) {
            return false;
        }
        if (menuPresenter != null) {
            z2 = menuPresenter.l(subMenuBuilder);
        }
        Iterator<WeakReference<MenuPresenter>> it2 = this.H.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null) {
                this.H.remove(next);
            } else if (!z2) {
                z2 = menuPresenter2.l(subMenuBuilder);
            }
        }
        return z2;
    }

    private static int q(ArrayList<MenuItemImpl> arrayList, int i2) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).i() <= i2) {
                return size + 1;
            }
        }
        return 0;
    }

    public CharSequence A() {
        return this.y;
    }

    public View B() {
        return this.A;
    }

    public ArrayList<MenuItemImpl> C() {
        u();
        return this.u;
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        return this.E;
    }

    /* access modifiers changed from: package-private */
    public Resources F() {
        return this.f2965m;
    }

    public MenuBuilder G() {
        return this;
    }

    @NonNull
    public ArrayList<MenuItemImpl> H() {
        if (!this.s) {
            return this.r;
        }
        this.r.clear();
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.q.get(i2);
            if (menuItemImpl.isVisible()) {
                this.r.add(menuItemImpl);
            }
        }
        this.s = false;
        this.v = true;
        return this.r;
    }

    public boolean I() {
        return !this.B;
    }

    public boolean J() {
        return this.J;
    }

    /* access modifiers changed from: package-private */
    public boolean K() {
        return this.f2966n;
    }

    public boolean L() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public void M(MenuItemImpl menuItemImpl) {
        this.v = true;
        O(true);
    }

    /* access modifiers changed from: package-private */
    public void N(MenuItemImpl menuItemImpl) {
        this.s = true;
        O(true);
    }

    public void O(boolean z2) {
        if (!this.B) {
            if (z2) {
                this.s = true;
                this.v = true;
            }
            j(z2);
            return;
        }
        this.C = true;
        if (z2) {
            this.D = true;
        }
    }

    public boolean P(MenuItem menuItem, int i2) {
        return Q(menuItem, (MenuPresenter) null, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r1 != false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        if ((r9 & 1) == 0) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        if (r1 == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean Q(android.view.MenuItem r7, androidx.appcompat.view.menu.MenuPresenter r8, int r9) {
        /*
            r6 = this;
            androidx.appcompat.view.menu.MenuItemImpl r7 = (androidx.appcompat.view.menu.MenuItemImpl) r7
            r0 = 0
            if (r7 == 0) goto L_0x006c
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto L_0x000c
            goto L_0x006c
        L_0x000c:
            boolean r1 = r7.n()
            androidx.core.view.ActionProvider r2 = r7.b()
            r3 = 1
            if (r2 == 0) goto L_0x001f
            boolean r4 = r2.b()
            if (r4 == 0) goto L_0x001f
            r4 = 1
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            boolean r5 = r7.m()
            if (r5 == 0) goto L_0x0031
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L_0x006b
        L_0x002d:
            r6.f(r3)
            goto L_0x006b
        L_0x0031:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L_0x003f
            if (r4 == 0) goto L_0x003a
            goto L_0x003f
        L_0x003a:
            r7 = r9 & 1
            if (r7 != 0) goto L_0x006b
            goto L_0x002d
        L_0x003f:
            r9 = r9 & 4
            if (r9 != 0) goto L_0x0046
            r6.f(r0)
        L_0x0046:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L_0x0058
            androidx.appcompat.view.menu.SubMenuBuilder r9 = new androidx.appcompat.view.menu.SubMenuBuilder
            android.content.Context r0 = r6.x()
            r9.<init>(r0, r6, r7)
            r7.A(r9)
        L_0x0058:
            android.view.SubMenu r7 = r7.getSubMenu()
            androidx.appcompat.view.menu.SubMenuBuilder r7 = (androidx.appcompat.view.menu.SubMenuBuilder) r7
            if (r4 == 0) goto L_0x0063
            r2.g(r7)
        L_0x0063:
            boolean r7 = r6.m(r7, r8)
            r1 = r1 | r7
            if (r1 != 0) goto L_0x006b
            goto L_0x002d
        L_0x006b:
            return r1
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuBuilder.Q(android.view.MenuItem, androidx.appcompat.view.menu.MenuPresenter, int):boolean");
    }

    public void R(int i2) {
        S(i2, true);
    }

    public void T(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it2 = this.H.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            MenuPresenter menuPresenter2 = (MenuPresenter) next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.H.remove(next);
            }
        }
    }

    public void U(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(w());
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = getItem(i2);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((SubMenuBuilder) item.getSubMenu()).U(bundle);
                }
            }
            int i3 = bundle.getInt(O);
            if (i3 > 0 && (findItem = findItem(i3)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void V(Bundle bundle) {
        k(bundle);
    }

    public void W(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = getItem(i2);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt(O, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).W(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(w(), sparseArray);
        }
    }

    public void X(Bundle bundle) {
        l(bundle);
    }

    public void Y(Callback callback) {
        this.p = callback;
    }

    public void Z(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.x = contextMenuInfo;
    }

    /* access modifiers changed from: protected */
    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        int E2 = E(i4);
        MenuItemImpl h2 = h(i2, i3, i4, E2, charSequence, this.w);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.x;
        if (contextMenuInfo != null) {
            h2.y(contextMenuInfo);
        }
        ArrayList<MenuItemImpl> arrayList = this.q;
        arrayList.add(q(arrayList, E2), h2);
        O(true);
        return h2;
    }

    public MenuBuilder a0(int i2) {
        this.w = i2;
        return this;
    }

    public MenuItem add(int i2) {
        return a(0, 0, 0, this.f2965m.getString(i2));
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        int i6;
        PackageManager packageManager = this.f2964l.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i5 & 1) == 0) {
            removeGroup(i2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i7);
            int i8 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i8 < 0 ? intent : intentArr[i8]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i2, i3, i4, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i6 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i6] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i2) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f2965m.getString(i2));
    }

    public void b(MenuPresenter menuPresenter) {
        c(menuPresenter, this.f2964l);
    }

    /* access modifiers changed from: package-private */
    public void b0(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.q.size();
        n0();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItemImpl menuItemImpl = this.q.get(i2);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.p() && menuItemImpl.isCheckable()) {
                menuItemImpl.v(menuItemImpl == menuItem);
            }
        }
        m0();
    }

    public void c(MenuPresenter menuPresenter, Context context) {
        this.H.add(new WeakReference(menuPresenter));
        menuPresenter.i(context, this);
        this.v = true;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder c0(int i2) {
        e0(0, (CharSequence) null, i2, (Drawable) null, (View) null);
        return this;
    }

    public void clear() {
        MenuItemImpl menuItemImpl = this.I;
        if (menuItemImpl != null) {
            g(menuItemImpl);
        }
        this.q.clear();
        O(true);
    }

    public void clearHeader() {
        this.z = null;
        this.y = null;
        this.A = null;
        O(false);
    }

    public void close() {
        f(true);
    }

    public void d() {
        Callback callback = this.p;
        if (callback != null) {
            callback.b(this);
        }
    }

    /* access modifiers changed from: protected */
    public MenuBuilder d0(Drawable drawable) {
        e0(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    public void e() {
        this.B = true;
        clear();
        clearHeader();
        this.H.clear();
        this.B = false;
        this.C = false;
        this.D = false;
        O(true);
    }

    public final void f(boolean z2) {
        if (!this.F) {
            this.F = true;
            Iterator<WeakReference<MenuPresenter>> it2 = this.H.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.H.remove(next);
                } else {
                    menuPresenter.c(this, z2);
                }
            }
            this.F = false;
        }
    }

    /* access modifiers changed from: protected */
    public MenuBuilder f0(int i2) {
        e0(i2, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    public MenuItem findItem(int i2) {
        MenuItem findItem;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.q.get(i3);
            if (menuItemImpl.getItemId() == i2) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i2)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public boolean g(MenuItemImpl menuItemImpl) {
        boolean z2 = false;
        if (!this.H.isEmpty() && this.I == menuItemImpl) {
            n0();
            Iterator<WeakReference<MenuPresenter>> it2 = this.H.iterator();
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.H.remove(next);
                } else {
                    z2 = menuPresenter.f(this, menuItemImpl);
                    if (z2) {
                        break;
                    }
                }
            }
            m0();
            if (z2) {
                this.I = null;
            }
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public MenuBuilder g0(CharSequence charSequence) {
        e0(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    public MenuItem getItem(int i2) {
        return this.q.get(i2);
    }

    /* access modifiers changed from: protected */
    public MenuBuilder h0(View view) {
        e0(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    public boolean hasVisibleItems() {
        if (this.K) {
            return true;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.q.get(i2).isVisible()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean i(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
        Callback callback = this.p;
        return callback != null && callback.a(menuBuilder, menuItem);
    }

    public void i0(boolean z2) {
        this.E = z2;
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return s(i2, keyEvent) != null;
    }

    public void j0(boolean z2) {
        this.K = z2;
    }

    public void k0(boolean z2) {
        if (this.o != z2) {
            l0(z2);
            O(false);
        }
    }

    public void m0() {
        this.B = false;
        if (this.C) {
            this.C = false;
            O(this.D);
        }
    }

    public boolean n(MenuItemImpl menuItemImpl) {
        boolean z2 = false;
        if (this.H.isEmpty()) {
            return false;
        }
        n0();
        Iterator<WeakReference<MenuPresenter>> it2 = this.H.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            MenuPresenter menuPresenter = (MenuPresenter) next.get();
            if (menuPresenter == null) {
                this.H.remove(next);
            } else {
                z2 = menuPresenter.g(this, menuItemImpl);
                if (z2) {
                    break;
                }
            }
        }
        m0();
        if (z2) {
            this.I = menuItemImpl;
        }
        return z2;
    }

    public void n0() {
        if (!this.B) {
            this.B = true;
            this.C = false;
            this.D = false;
        }
    }

    public int o(int i2) {
        return p(i2, 0);
    }

    public int p(int i2, int i3) {
        int size = size();
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < size) {
            if (this.q.get(i3).getGroupId() == i2) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return P(findItem(i2), i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        MenuItemImpl s2 = s(i2, keyEvent);
        boolean P2 = s2 != null ? P(s2, i3) : false;
        if ((i3 & 2) != 0) {
            f(true);
        }
        return P2;
    }

    public int r(int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.q.get(i3).getItemId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public void removeGroup(int i2) {
        int o2 = o(i2);
        if (o2 >= 0) {
            int size = this.q.size() - o2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size || this.q.get(o2).getGroupId() != i2) {
                    O(true);
                } else {
                    S(o2, false);
                    i3 = i4;
                }
            }
            O(true);
        }
    }

    public void removeItem(int i2) {
        S(r(i2), true);
    }

    /* access modifiers changed from: package-private */
    public MenuItemImpl s(int i2, KeyEvent keyEvent) {
        ArrayList<MenuItemImpl> arrayList = this.G;
        arrayList.clear();
        t(arrayList, i2, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean K2 = K();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = arrayList.get(i3);
            char alphabeticShortcut = K2 ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (K2 && alphabeticShortcut == 8 && i2 == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    public void setGroupCheckable(int i2, boolean z2, boolean z3) {
        int size = this.q.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.q.get(i3);
            if (menuItemImpl.getGroupId() == i2) {
                menuItemImpl.w(z3);
                menuItemImpl.setCheckable(z2);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z2) {
        this.J = z2;
    }

    public void setGroupEnabled(int i2, boolean z2) {
        int size = this.q.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.q.get(i3);
            if (menuItemImpl.getGroupId() == i2) {
                menuItemImpl.setEnabled(z2);
            }
        }
    }

    public void setGroupVisible(int i2, boolean z2) {
        int size = this.q.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.q.get(i3);
            if (menuItemImpl.getGroupId() == i2 && menuItemImpl.B(z2)) {
                z3 = true;
            }
        }
        if (z3) {
            O(true);
        }
    }

    public void setQwertyMode(boolean z2) {
        this.f2966n = z2;
        O(false);
    }

    public int size() {
        return this.q.size();
    }

    /* access modifiers changed from: package-private */
    public void t(List<MenuItemImpl> list, int i2, KeyEvent keyEvent) {
        boolean K2 = K();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i2 == 67) {
            int size = this.q.size();
            for (int i3 = 0; i3 < size; i3++) {
                MenuItemImpl menuItemImpl = this.q.get(i3);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).t(list, i2, keyEvent);
                }
                char alphabeticShortcut = K2 ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if ((modifiers & SupportMenu.f5943e) == ((K2 ? menuItemImpl.getAlphabeticModifiers() : menuItemImpl.getNumericModifiers()) & SupportMenu.f5943e) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (K2 && alphabeticShortcut == 8 && i2 == 67)) && menuItemImpl.isEnabled()) {
                        list.add(menuItemImpl);
                    }
                }
            }
        }
    }

    public void u() {
        ArrayList<MenuItemImpl> H2 = H();
        if (this.v) {
            Iterator<WeakReference<MenuPresenter>> it2 = this.H.iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                WeakReference next = it2.next();
                MenuPresenter menuPresenter = (MenuPresenter) next.get();
                if (menuPresenter == null) {
                    this.H.remove(next);
                } else {
                    z2 |= menuPresenter.e();
                }
            }
            if (z2) {
                this.t.clear();
                this.u.clear();
                int size = H2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MenuItemImpl menuItemImpl = H2.get(i2);
                    (menuItemImpl.o() ? this.t : this.u).add(menuItemImpl);
                }
            } else {
                this.t.clear();
                this.u.clear();
                this.u.addAll(H());
            }
            this.v = false;
        }
    }

    public ArrayList<MenuItemImpl> v() {
        u();
        return this.t;
    }

    /* access modifiers changed from: protected */
    public String w() {
        return N;
    }

    public Context x() {
        return this.f2964l;
    }

    public MenuItemImpl y() {
        return this.I;
    }

    public Drawable z() {
        return this.z;
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return a(i2, i3, i4, this.f2965m.getString(i5));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return addSubMenu(i2, i3, i4, (CharSequence) this.f2965m.getString(i5));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return a(i2, i3, i4, charSequence);
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) a(i2, i3, i4, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.f2964l, this, menuItemImpl);
        menuItemImpl.A(subMenuBuilder);
        return subMenuBuilder;
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }
}
