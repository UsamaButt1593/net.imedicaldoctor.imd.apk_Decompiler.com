package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListFragment extends Fragment {
    static final int p4 = 16711681;
    static final int q4 = 16711682;
    static final int r4 = 16711683;
    private final Handler e4 = new Handler();
    private final Runnable f4 = new Runnable() {
        public void run() {
            ListView listView = ListFragment.this.i4;
            listView.focusableViewAvailable(listView);
        }
    };
    private final AdapterView.OnItemClickListener g4 = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            ListFragment.this.O2((ListView) adapterView, view, i2, j2);
        }
    };
    ListAdapter h4;
    ListView i4;
    View j4;
    TextView k4;
    View l4;
    View m4;
    CharSequence n4;
    boolean o4;

    private void J2() {
        if (this.i4 == null) {
            View q0 = q0();
            if (q0 != null) {
                if (q0 instanceof ListView) {
                    this.i4 = (ListView) q0;
                } else {
                    TextView textView = (TextView) q0.findViewById(p4);
                    this.k4 = textView;
                    if (textView == null) {
                        this.j4 = q0.findViewById(16908292);
                    } else {
                        textView.setVisibility(8);
                    }
                    this.l4 = q0.findViewById(q4);
                    this.m4 = q0.findViewById(r4);
                    View findViewById = q0.findViewById(16908298);
                    if (findViewById instanceof ListView) {
                        ListView listView = (ListView) findViewById;
                        this.i4 = listView;
                        View view = this.j4;
                        if (view == null) {
                            CharSequence charSequence = this.n4;
                            if (charSequence != null) {
                                this.k4.setText(charSequence);
                                listView = this.i4;
                                view = this.k4;
                            }
                        }
                        listView.setEmptyView(view);
                    } else if (findViewById == null) {
                        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                    } else {
                        throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                    }
                }
                this.o4 = true;
                this.i4.setOnItemClickListener(this.g4);
                ListAdapter listAdapter = this.h4;
                if (listAdapter != null) {
                    this.h4 = null;
                    R2(listAdapter);
                } else if (this.l4 != null) {
                    T2(false, false);
                }
                this.e4.post(this.f4);
                return;
            }
            throw new IllegalStateException("Content view not yet created");
        }
    }

    private void T2(boolean z, boolean z2) {
        J2();
        View view = this.l4;
        if (view == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.o4 != z) {
            this.o4 = z;
            if (z) {
                if (z2) {
                    view.startAnimation(AnimationUtils.loadAnimation(B(), 17432577));
                    this.m4.startAnimation(AnimationUtils.loadAnimation(B(), 17432576));
                } else {
                    view.clearAnimation();
                    this.m4.clearAnimation();
                }
                this.l4.setVisibility(8);
                this.m4.setVisibility(0);
                return;
            }
            if (z2) {
                view.startAnimation(AnimationUtils.loadAnimation(B(), 17432576));
                this.m4.startAnimation(AnimationUtils.loadAnimation(B(), 17432577));
            } else {
                view.clearAnimation();
                this.m4.clearAnimation();
            }
            this.l4.setVisibility(0);
            this.m4.setVisibility(8);
        }
    }

    @Nullable
    public ListAdapter K2() {
        return this.h4;
    }

    @NonNull
    public ListView L2() {
        J2();
        return this.i4;
    }

    public long M2() {
        J2();
        return this.i4.getSelectedItemId();
    }

    public int N2() {
        J2();
        return this.i4.getSelectedItemPosition();
    }

    public void O2(@NonNull ListView listView, @NonNull View view, int i2, long j2) {
    }

    @NonNull
    public final ListAdapter P2() {
        ListAdapter K2 = K2();
        if (K2 != null) {
            return K2;
        }
        throw new IllegalStateException("ListFragment " + this + " does not have a ListAdapter.");
    }

    public void Q2(@Nullable CharSequence charSequence) {
        J2();
        TextView textView = this.k4;
        if (textView != null) {
            textView.setText(charSequence);
            if (this.n4 == null) {
                this.i4.setEmptyView(this.k4);
            }
            this.n4 = charSequence;
            return;
        }
        throw new IllegalStateException("Can't be used with a custom content view");
    }

    public void R2(@Nullable ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.h4 != null;
        this.h4 = listAdapter;
        ListView listView = this.i4;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            if (!this.o4 && !z2) {
                if (b2().getWindowToken() != null) {
                    z = true;
                }
                T2(true, z);
            }
        }
    }

    public void S2(boolean z) {
        T2(z, true);
    }

    @Nullable
    public View U0(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Context X1 = X1();
        FrameLayout frameLayout = new FrameLayout(X1);
        LinearLayout linearLayout = new LinearLayout(X1);
        linearLayout.setId(q4);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(X1, (AttributeSet) null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(X1);
        frameLayout2.setId(r4);
        TextView textView = new TextView(X1);
        textView.setId(p4);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(X1);
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public void U2(boolean z) {
        T2(z, false);
    }

    public void V2(int i2) {
        J2();
        this.i4.setSelection(i2);
    }

    public void X0() {
        this.e4.removeCallbacks(this.f4);
        this.i4 = null;
        this.o4 = false;
        this.m4 = null;
        this.l4 = null;
        this.j4 = null;
        this.k4 = null;
        super.X0();
    }

    public void p1(@NonNull View view, @Nullable Bundle bundle) {
        super.p1(view, bundle);
        J2();
    }
}
