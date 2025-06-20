package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;

public class ShareActionProvider extends ActionProvider {

    /* renamed from: k  reason: collision with root package name */
    private static final int f3263k = 4;

    /* renamed from: l  reason: collision with root package name */
    public static final String f3264l = "share_history.xml";

    /* renamed from: e  reason: collision with root package name */
    private int f3265e = 4;

    /* renamed from: f  reason: collision with root package name */
    private final ShareMenuItemOnMenuItemClickListener f3266f = new ShareMenuItemOnMenuItemClickListener();

    /* renamed from: g  reason: collision with root package name */
    final Context f3267g;

    /* renamed from: h  reason: collision with root package name */
    String f3268h = f3264l;

    /* renamed from: i  reason: collision with root package name */
    OnShareTargetSelectedListener f3269i;

    /* renamed from: j  reason: collision with root package name */
    private ActivityChooserModel.OnChooseActivityListener f3270j;

    public interface OnShareTargetSelectedListener {
        boolean a(ShareActionProvider shareActionProvider, Intent intent);
    }

    private class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
        ShareActivityChooserModelPolicy() {
        }

        public boolean a(ActivityChooserModel activityChooserModel, Intent intent) {
            ShareActionProvider shareActionProvider = ShareActionProvider.this;
            OnShareTargetSelectedListener onShareTargetSelectedListener = shareActionProvider.f3269i;
            if (onShareTargetSelectedListener == null) {
                return false;
            }
            onShareTargetSelectedListener.a(shareActionProvider, intent);
            return false;
        }
    }

    private class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        ShareMenuItemOnMenuItemClickListener() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            ShareActionProvider shareActionProvider = ShareActionProvider.this;
            Intent b2 = ActivityChooserModel.d(shareActionProvider.f3267g, shareActionProvider.f3268h).b(menuItem.getItemId());
            if (b2 == null) {
                return true;
            }
            String action = b2.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                ShareActionProvider.this.r(b2);
            }
            ShareActionProvider.this.f3267g.startActivity(b2);
            return true;
        }
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.f3267g = context;
    }

    private void n() {
        if (this.f3269i != null) {
            if (this.f3270j == null) {
                this.f3270j = new ShareActivityChooserModelPolicy();
            }
            ActivityChooserModel.d(this.f3267g, this.f3268h).u(this.f3270j);
        }
    }

    public boolean b() {
        return true;
    }

    public View d() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f3267g);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.d(this.f3267g, this.f3268h));
        }
        TypedValue typedValue = new TypedValue();
        this.f3267g.getTheme().resolveAttribute(R.attr.A, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.b(this.f3267g, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.z);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.y);
        return activityChooserView;
    }

    public void g(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel d2 = ActivityChooserModel.d(this.f3267g, this.f3268h);
        PackageManager packageManager = this.f3267g.getPackageManager();
        int f2 = d2.f();
        int min = Math.min(f2, this.f3265e);
        for (int i2 = 0; i2 < min; i2++) {
            ResolveInfo e2 = d2.e(i2);
            subMenu.add(0, i2, i2, e2.loadLabel(packageManager)).setIcon(e2.loadIcon(packageManager)).setOnMenuItemClickListener(this.f3266f);
        }
        if (min < f2) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.f3267g.getString(R.string.f2652e));
            for (int i3 = 0; i3 < f2; i3++) {
                ResolveInfo e3 = d2.e(i3);
                addSubMenu.add(0, i3, i3, e3.loadLabel(packageManager)).setIcon(e3.loadIcon(packageManager)).setOnMenuItemClickListener(this.f3266f);
            }
        }
    }

    public void o(OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.f3269i = onShareTargetSelectedListener;
        n();
    }

    public void p(String str) {
        this.f3268h = str;
        n();
    }

    public void q(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                r(intent);
            }
        }
        ActivityChooserModel.d(this.f3267g, this.f3268h).t(intent);
    }

    /* access modifiers changed from: package-private */
    public void r(Intent intent) {
        intent.addFlags(134742016);
    }
}
