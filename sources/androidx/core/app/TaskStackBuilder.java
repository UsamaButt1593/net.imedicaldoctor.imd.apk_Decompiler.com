package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

public final class TaskStackBuilder implements Iterable<Intent> {
    private static final String Y = "TaskStackBuilder";
    private final Context X;
    private final ArrayList<Intent> s = new ArrayList<>();

    public interface SupportParentable {
        @Nullable
        Intent v();
    }

    private TaskStackBuilder(Context context) {
        this.X = context;
    }

    @NonNull
    public static TaskStackBuilder j(@NonNull Context context) {
        return new TaskStackBuilder(context);
    }

    @Deprecated
    public static TaskStackBuilder m(Context context) {
        return j(context);
    }

    @NonNull
    public TaskStackBuilder b(@NonNull Intent intent) {
        this.s.add(intent);
        return this;
    }

    @NonNull
    public TaskStackBuilder c(@NonNull Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.X.getPackageManager());
        }
        if (component != null) {
            g(component);
        }
        b(intent);
        return this;
    }

    @NonNull
    public TaskStackBuilder d(@NonNull Activity activity) {
        Intent v = activity instanceof SupportParentable ? ((SupportParentable) activity).v() : null;
        if (v == null) {
            v = NavUtils.a(activity);
        }
        if (v != null) {
            ComponentName component = v.getComponent();
            if (component == null) {
                component = v.resolveActivity(this.X.getPackageManager());
            }
            g(component);
            b(v);
        }
        return this;
    }

    @NonNull
    public TaskStackBuilder g(@NonNull ComponentName componentName) {
        int size = this.s.size();
        try {
            Context context = this.X;
            while (true) {
                Intent b2 = NavUtils.b(context, componentName);
                if (b2 == null) {
                    return this;
                }
                this.s.add(size, b2);
                context = this.X;
                componentName = b2.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(Y, "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    @NonNull
    public TaskStackBuilder h(@NonNull Class<?> cls) {
        return g(new ComponentName(this.X, cls));
    }

    @NonNull
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.s.iterator();
    }

    @Nullable
    public Intent k(int i2) {
        return this.s.get(i2);
    }

    @Deprecated
    public Intent n(int i2) {
        return k(i2);
    }

    public int o() {
        return this.s.size();
    }

    @NonNull
    public Intent[] q() {
        int size = this.s.size();
        Intent[] intentArr = new Intent[size];
        if (size == 0) {
            return intentArr;
        }
        intentArr[0] = new Intent(this.s.get(0)).addFlags(268484608);
        for (int i2 = 1; i2 < size; i2++) {
            intentArr[i2] = new Intent(this.s.get(i2));
        }
        return intentArr;
    }

    @Nullable
    public PendingIntent r(int i2, int i3) {
        return t(i2, i3, (Bundle) null);
    }

    @Nullable
    public PendingIntent t(int i2, int i3, @Nullable Bundle bundle) {
        if (!this.s.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.s.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            return PendingIntent.getActivities(this.X, i2, intentArr, i3, bundle);
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }

    public void x() {
        z((Bundle) null);
    }

    public void z(@Nullable Bundle bundle) {
        if (!this.s.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.s.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!ContextCompat.z(this.X, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.X.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
