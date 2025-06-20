package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportMenu;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {
    private final SupportMenu o;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu != null) {
            this.o = supportMenu;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(int i2) {
        return e(this.o.add(i2));
    }

    public int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = this.o.addIntentOptions(i2, i3, i4, componentName, intentArr, intent, i5, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i6 = 0; i6 < length; i6++) {
                menuItemArr2[i6] = e(menuItemArr3[i6]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(int i2) {
        return f(this.o.addSubMenu(i2));
    }

    public void clear() {
        g();
        this.o.clear();
    }

    public void close() {
        this.o.close();
    }

    public MenuItem findItem(int i2) {
        return e(this.o.findItem(i2));
    }

    public MenuItem getItem(int i2) {
        return e(this.o.getItem(i2));
    }

    public boolean hasVisibleItems() {
        return this.o.hasVisibleItems();
    }

    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return this.o.isShortcutKey(i2, keyEvent);
    }

    public boolean performIdentifierAction(int i2, int i3) {
        return this.o.performIdentifierAction(i2, i3);
    }

    public boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        return this.o.performShortcut(i2, keyEvent, i3);
    }

    public void removeGroup(int i2) {
        h(i2);
        this.o.removeGroup(i2);
    }

    public void removeItem(int i2) {
        i(i2);
        this.o.removeItem(i2);
    }

    public void setGroupCheckable(int i2, boolean z, boolean z2) {
        this.o.setGroupCheckable(i2, z, z2);
    }

    public void setGroupEnabled(int i2, boolean z) {
        this.o.setGroupEnabled(i2, z);
    }

    public void setGroupVisible(int i2, boolean z) {
        this.o.setGroupVisible(i2, z);
    }

    public void setQwertyMode(boolean z) {
        this.o.setQwertyMode(z);
    }

    public int size() {
        return this.o.size();
    }

    public MenuItem add(int i2, int i3, int i4, int i5) {
        return e(this.o.add(i2, i3, i4, i5));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return f(this.o.addSubMenu(i2, i3, i4, i5));
    }

    public MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return e(this.o.add(i2, i3, i4, charSequence));
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        return f(this.o.addSubMenu(i2, i3, i4, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return e(this.o.add(charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return f(this.o.addSubMenu(charSequence));
    }
}
