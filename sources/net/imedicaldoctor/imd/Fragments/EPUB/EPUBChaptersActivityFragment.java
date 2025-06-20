package net.imedicaldoctor.imd.Fragments.EPUB;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.common.C;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.RippleTextViewHolder;
import org.apache.commons.lang3.StringUtils;

public class EPUBChaptersActivityFragment extends SearchHelperFragment {
    private static String G4;
    /* access modifiers changed from: private */
    public String A4;
    /* access modifiers changed from: private */
    public Boolean B4;
    /* access modifiers changed from: private */
    public ArrayList<String> C4;
    /* access modifiers changed from: private */
    public ArrayList<String> D4;
    /* access modifiers changed from: private */
    public ArrayList<String> E4;
    public BroadcastReceiver F4 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                if (EPUBChaptersActivityFragment.this.getActivity().getSharedPreferences("default_preferences", 0).getBoolean("shake", false)) {
                    LocalBroadcastManager.b(EPUBChaptersActivityFragment.this.r()).f(EPUBChaptersActivityFragment.this.F4);
                    EPUBChaptersActivityFragment.this.r3();
                    EPUBChaptersActivityFragment.this.q4.postDelayed(new Runnable() {
                        public void run() {
                            LocalBroadcastManager.b(EPUBChaptersActivityFragment.this.r()).c(EPUBChaptersActivityFragment.this.F4, new IntentFilter("Shake"));
                        }
                    }, C.c2);
                }
            } catch (Exception unused) {
            }
        }
    };

    public class AccountTextViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final TextView I;
        /* access modifiers changed from: private */
        public final MaterialRippleLayout J;

        public AccountTextViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.text);
            this.J = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
        }
    }

    public class ButtonChaptersAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        public Context f29718d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<Bundle> f29719e;

        /* renamed from: f  reason: collision with root package name */
        public String f29720f;

        /* renamed from: g  reason: collision with root package name */
        public String f29721g;

        /* renamed from: h  reason: collision with root package name */
        public String f29722h;

        public ButtonChaptersAdapter(Context context, ArrayList<Bundle> arrayList, String str, String str2, String str3) {
            this.f29718d = context;
            this.f29719e = arrayList;
            this.f29720f = str;
            this.f29722h = str3;
            this.f29721g = str2;
        }

        public int C(int i2) {
            if (i2 == this.f29719e.size()) {
                return 2;
            }
            return this.f29719e.get(i2).getString("leaf").equals(IcyHeaders.a3) ? 0 : 1;
        }

        public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
            if (i2 == this.f29719e.size()) {
                AccountTextViewHolder accountTextViewHolder = (AccountTextViewHolder) viewHolder;
                accountTextViewHolder.I.setText(this.f29721g);
                accountTextViewHolder.I.setTextColor(EPUBChaptersActivityFragment.this.b0().getColor(R.color.f469white));
                accountTextViewHolder.J.setBackgroundColor(Color.parseColor(this.f29722h));
                accountTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        ButtonChaptersAdapter.this.d0();
                    }
                });
                return;
            }
            RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
            final Bundle bundle = this.f29719e.get(i2);
            rippleTextViewHolder.I.setText(bundle.getString(this.f29720f));
            rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ButtonChaptersAdapter.this.e0(bundle, i2);
                }
            });
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new RippleTextViewHolder(LayoutInflater.from(this.f29718d).inflate(R.layout.f1342list_view_item_ripple_text, viewGroup, false));
            }
            if (i2 == 1) {
                return new RippleTextViewHolder(LayoutInflater.from(this.f29718d).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
            }
            if (i2 != 2) {
                return null;
            }
            return new AccountTextViewHolder(LayoutInflater.from(this.f29718d).inflate(R.layout.f1298list_view_item_account_text, viewGroup, false));
        }

        public int b() {
            return this.f29719e.size() + 1;
        }

        public void d0() {
        }

        public void e0(Bundle bundle, int i2) {
        }
    }

    public class EPUBChaptersAdapter extends RecyclerView.Adapter {

        /* renamed from: d  reason: collision with root package name */
        public Context f29724d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<Bundle> f29725e;

        /* renamed from: f  reason: collision with root package name */
        public String f29726f;

        public EPUBChaptersAdapter(Context context, ArrayList<Bundle> arrayList, String str) {
            this.f29724d = context;
            this.f29725e = arrayList;
            this.f29726f = str;
        }

        public int C(int i2) {
            return this.f29725e.get(i2).getString("leaf").equals(IcyHeaders.a3) ? 0 : 1;
        }

        public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
            RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
            final Bundle bundle = this.f29725e.get(i2);
            rippleTextViewHolder.I.setText(bundle.getString(this.f29726f));
            rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    EPUBChaptersAdapter.this.d0(bundle, i2);
                }
            });
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new RippleTextViewHolder(LayoutInflater.from(this.f29724d).inflate(R.layout.f1342list_view_item_ripple_text, viewGroup, false));
            }
            if (i2 == 1) {
                return new RippleTextViewHolder(LayoutInflater.from(this.f29724d).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
            }
            return null;
        }

        public int b() {
            return this.f29725e.size();
        }

        public void d0(Bundle bundle, int i2) {
        }
    }

    public void Q0(Bundle bundle) {
        super.Q0(bundle);
        LocalBroadcastManager.b(r()).c(this.F4, new IntentFilter("Shake"));
    }

    public void T0(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.f1494search, menu);
        this.s4 = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
        O2();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment$6} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v24, resolved type: net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment$5} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment$5} */
    /* JADX WARNING: type inference failed for: r11v18, types: [androidx.recyclerview.widget.RecyclerView$Adapter] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFragmentBind(android.view.LayoutInflater r10, android.view.ViewGroup r11, android.os.Bundle r12) {
        /*
            r9 = this;
            r0 = 2131558538(0x7f0d008a, float:1.8742395E38)
            r1 = 0
            android.view.View r10 = r10.inflate(r0, r11, r1)
            r9.q4 = r10
            r9.W2(r12)
            r9.S2()
            android.view.View r11 = r9.q4
            r12 = 2131362540(0x7f0a02ec, float:1.8344863E38)
            android.view.View r11 = r11.findViewById(r12)
            androidx.appcompat.widget.SearchView r11 = (androidx.appcompat.widget.SearchView) r11
            r9.s4 = r11
            r9.O2()
            android.view.View r11 = r9.q4
            r12 = 2131362493(0x7f0a02bd, float:1.8344768E38)
            android.view.View r11 = r11.findViewById(r12)
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            r9.w4 = r11
            android.view.View r11 = r9.q4
            r12 = 2131361934(0x7f0a008e, float:1.8343634E38)
            android.view.View r11 = r11.findViewById(r12)
            com.google.android.material.appbar.AppBarLayout r11 = (com.google.android.material.appbar.AppBarLayout) r11
            android.view.View r12 = r9.q4
            r0 = 2131361947(0x7f0a009b, float:1.834366E38)
            android.view.View r12 = r12.findViewById(r0)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            android.os.Bundle r0 = r9.y()
            r2 = 1
            java.lang.String r3 = "0"
            if (r0 == 0) goto L_0x0085
            android.os.Bundle r0 = r9.y()
            java.lang.String r4 = "ParentId"
            boolean r0 = r0.containsKey(r4)
            if (r0 == 0) goto L_0x0085
            android.os.Bundle r0 = r9.y()
            java.lang.String r0 = r0.getString(r4)
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x006d
            r11.D(r2, r1)
            r12.setVisibility(r1)
            goto L_0x007a
        L_0x006d:
            r11.D(r1, r1)
            net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment$4 r0 = new net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment$4
            r0.<init>(r12)
            r2 = 800(0x320, double:3.953E-321)
            r11.postDelayed(r0, r2)
        L_0x007a:
            android.os.Bundle r11 = r9.y()
            java.lang.String r11 = r11.getString(r4)
            r9.A4 = r11
            goto L_0x008d
        L_0x0085:
            r11.D(r2, r1)
            r12.setVisibility(r1)
            r9.A4 = r3
        L_0x008d:
            net.imedicaldoctor.imd.Data.CompressHelper r11 = r9.k4
            android.os.Bundle r12 = r9.h4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Select id as _id,* from TOC where parentId = "
            r0.append(r2)
            java.lang.String r2 = r9.A4
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.util.ArrayList r11 = r11.V(r12, r0)
            r9.n4 = r11
            android.os.Bundle r11 = r9.h4
            java.lang.String r12 = "Name"
            java.lang.String r11 = r11.getString(r12)
            java.lang.String r12 = "auntminnie"
            boolean r11 = r11.contains(r12)
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            r9.B4 = r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00da
            net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment$5 r11 = new net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment$5
            androidx.fragment.app.FragmentActivity r4 = r9.r()
            java.util.ArrayList<android.os.Bundle> r5 = r9.n4
            java.lang.String r7 = "Random Case"
            java.lang.String r8 = "#0e4b06"
            java.lang.String r6 = "name"
            r2 = r11
            r3 = r9
            r2.<init>(r4, r5, r6, r7, r8)
        L_0x00d7:
            r9.l4 = r11
            goto L_0x00e8
        L_0x00da:
            net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment$6 r11 = new net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment$6
            androidx.fragment.app.FragmentActivity r12 = r9.r()
            java.util.ArrayList<android.os.Bundle> r0 = r9.n4
            java.lang.String r2 = "name"
            r11.<init>(r12, r0, r2)
            goto L_0x00d7
        L_0x00e8:
            net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment$7 r11 = new net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment$7
            androidx.fragment.app.FragmentActivity r5 = r9.r()
            java.util.ArrayList<android.os.Bundle> r6 = r9.o4
            java.lang.String r7 = "text"
            java.lang.String r8 = "subText"
            r3 = r11
            r4 = r9
            r3.<init>(r5, r6, r7, r8)
            r9.m4 = r11
            androidx.recyclerview.widget.RecyclerView r11 = r9.w4
            androidx.recyclerview.widget.RecyclerView$Adapter r12 = r9.l4
            r11.setAdapter(r12)
            r9.N2()
            r9.o2(r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Fragments.EPUB.EPUBChaptersActivityFragment.U0(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.b(r()).f(this.F4);
    }

    public ArrayList<Bundle> a3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id, Text as text,snippet(search) as subText, type, contentId from search where search match '" + str + "' ORDER BY rank(matchinfo(search)) DESC");
    }

    public ArrayList<Bundle> g3(String str) {
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        return compressHelper.V(bundle, "Select rowid as _id,word from spell where word match '" + str + "*'");
    }

    public String q3(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add("'" + it2.next() + "'");
        }
        return StringUtils.join((Iterable<?>) arrayList2, ",");
    }

    public void r3() {
        L2(new Runnable() {
            public void run() {
                String i3 = EPUBChaptersActivityFragment.this.A4;
                if (EPUBChaptersActivityFragment.this.B4.booleanValue() && i3.equals("0")) {
                    i3 = IcyHeaders.a3;
                }
                if (EPUBChaptersActivityFragment.this.C4 == null) {
                    ArrayList unused = EPUBChaptersActivityFragment.this.C4 = new ArrayList();
                    EPUBChaptersActivityFragment ePUBChaptersActivityFragment = EPUBChaptersActivityFragment.this;
                    ePUBChaptersActivityFragment.s3(i3, ePUBChaptersActivityFragment.C4);
                }
                ArrayList unused2 = EPUBChaptersActivityFragment.this.D4 = new ArrayList();
                EPUBChaptersActivityFragment ePUBChaptersActivityFragment2 = EPUBChaptersActivityFragment.this;
                CompressHelper compressHelper = ePUBChaptersActivityFragment2.k4;
                String h2 = compressHelper.h2();
                StringBuilder sb = new StringBuilder();
                sb.append("Select dbAddress from recent where dbName ='");
                sb.append(EPUBChaptersActivityFragment.this.h4.getString("Name"));
                sb.append("' AND dbAddress in (");
                EPUBChaptersActivityFragment ePUBChaptersActivityFragment3 = EPUBChaptersActivityFragment.this;
                sb.append(ePUBChaptersActivityFragment3.q3(ePUBChaptersActivityFragment3.C4));
                sb.append(")");
                ArrayList unused3 = ePUBChaptersActivityFragment2.D4 = compressHelper.Z(h2, sb.toString(), "dbAddress");
                ArrayList unused4 = EPUBChaptersActivityFragment.this.E4 = new ArrayList(EPUBChaptersActivityFragment.this.C4);
                if (EPUBChaptersActivityFragment.this.D4 != null) {
                    EPUBChaptersActivityFragment.this.E4.removeAll(EPUBChaptersActivityFragment.this.D4);
                } else {
                    ArrayList unused5 = EPUBChaptersActivityFragment.this.D4 = new ArrayList();
                }
            }
        }, new Runnable() {
            public void run() {
                if (EPUBChaptersActivityFragment.this.E4.size() == 0) {
                    CompressHelper.x2(EPUBChaptersActivityFragment.this.r(), "All are reviewed", 1);
                    return;
                }
                FragmentActivity r = EPUBChaptersActivityFragment.this.r();
                CompressHelper.x2(r, EPUBChaptersActivityFragment.this.E4.size() + " Remaining (" + EPUBChaptersActivityFragment.this.D4.size() + " Reviewed)", 1);
                int nextInt = new Random().nextInt(EPUBChaptersActivityFragment.this.E4.size());
                new CompressHelper(EPUBChaptersActivityFragment.this.r()).A1(EPUBChaptersActivityFragment.this.h4, (String) EPUBChaptersActivityFragment.this.E4.get(nextInt), (String[]) null, (String) null);
            }
        });
    }

    public void s3(String str, ArrayList<String> arrayList) {
        Log.d("readChildTOCS", "parentId = " + str);
        CompressHelper compressHelper = this.k4;
        Bundle bundle = this.h4;
        ArrayList<Bundle> V = compressHelper.V(bundle, "Select * from TOC where parentId = " + str);
        if (V == null) {
            V = new ArrayList<>();
        }
        Iterator<Bundle> it2 = V.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            if (next.getString("leaf").equals("0")) {
                arrayList.add(next.getString("docId"));
            } else {
                s3(next.getString("id"), arrayList);
            }
        }
    }
}
