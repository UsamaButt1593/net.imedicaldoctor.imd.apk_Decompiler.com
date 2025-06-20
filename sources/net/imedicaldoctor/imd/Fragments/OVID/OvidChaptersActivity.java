package net.imedicaldoctor.imd.Fragments.OVID;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.itextpdf.tool.xml.html.HTML;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.MessageViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleSearchContentViewHolder;
import net.imedicaldoctor.imd.ViewHolders.RippleTextViewHolder;
import net.imedicaldoctor.imd.iMDActivity;

public class OvidChaptersActivity extends iMDActivity {

    public static class OvidChaptersFragment extends SearchHelperFragment {
        private static String C4;
        private String A4;
        private OvidContentSearchAdapter B4;

        public class OvidChaptersAdapter extends RecyclerView.Adapter {

            /* renamed from: d  reason: collision with root package name */
            public Context f29847d;

            /* renamed from: e  reason: collision with root package name */
            public ArrayList<Bundle> f29848e;

            /* renamed from: f  reason: collision with root package name */
            public String f29849f;

            public OvidChaptersAdapter(Context context, ArrayList<Bundle> arrayList, String str) {
                this.f29847d = context;
                this.f29848e = arrayList;
                this.f29849f = str;
            }

            public int C(int i2) {
                ArrayList<Bundle> arrayList = this.f29848e;
                if (arrayList == null) {
                    return 0;
                }
                Bundle bundle = arrayList.get(i2);
                if (bundle.getString("leaf").equals(IcyHeaders.a3)) {
                    return 0;
                }
                return (bundle.getString("xpath").length() > 0 || bundle.getString(HTML.Tag.V).length() > 0) ? 1 : 2;
            }

            public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
                if (viewHolder.F() == 0 || viewHolder.F() == 2) {
                    RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
                    final Bundle bundle = this.f29848e.get(i2);
                    rippleTextViewHolder.I.setText(bundle.getString(this.f29849f));
                    rippleTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            OvidChaptersAdapter.this.e0(bundle, i2);
                        }
                    });
                } else if (viewHolder.F() == 1) {
                    RippleInfoTextViewHolder rippleInfoTextViewHolder = (RippleInfoTextViewHolder) viewHolder;
                    final Bundle bundle2 = this.f29848e.get(i2);
                    rippleInfoTextViewHolder.I.setText(bundle2.getString(this.f29849f));
                    rippleInfoTextViewHolder.K.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            OvidChaptersAdapter.this.e0(bundle2, i2);
                        }
                    });
                    rippleInfoTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            OvidChaptersAdapter.this.d0(bundle2, i2);
                        }
                    });
                }
            }

            public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                if (i2 == 0) {
                    return new RippleTextViewHolder(LayoutInflater.from(this.f29847d).inflate(R.layout.f1342list_view_item_ripple_text, viewGroup, false));
                }
                if (i2 == 1) {
                    return new RippleInfoTextViewHolder(LayoutInflater.from(this.f29847d).inflate(R.layout.f1340list_view_item_ripple_goto_arrow, viewGroup, false));
                } else if (i2 == 2) {
                    return new RippleTextViewHolder(LayoutInflater.from(this.f29847d).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
                } else {
                    return null;
                }
            }

            public int b() {
                ArrayList<Bundle> arrayList = this.f29848e;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            }

            public void d0(Bundle bundle, int i2) {
            }

            public void e0(Bundle bundle, int i2) {
            }
        }

        public class OvidContentSearchAdapter extends RecyclerView.Adapter {

            /* renamed from: d  reason: collision with root package name */
            public Context f29851d;

            /* renamed from: e  reason: collision with root package name */
            public ArrayList<Bundle> f29852e;

            /* renamed from: f  reason: collision with root package name */
            public String f29853f;

            /* renamed from: g  reason: collision with root package name */
            public String f29854g;

            public OvidContentSearchAdapter(Context context, ArrayList<Bundle> arrayList, String str, String str2) {
                this.f29851d = context;
                this.f29852e = arrayList;
                this.f29853f = str;
                this.f29854g = str2;
            }

            public int C(int i2) {
                ArrayList<Bundle> arrayList = this.f29852e;
                if (arrayList == null || arrayList.size() == 0) {
                    return 0;
                }
                if (!this.f29852e.get(i2).getString("type").equals("0")) {
                    return 3;
                }
                OvidChaptersFragment ovidChaptersFragment = OvidChaptersFragment.this;
                CompressHelper compressHelper = ovidChaptersFragment.k4;
                Bundle bundle = ovidChaptersFragment.h4;
                Bundle z = compressHelper.z(compressHelper.V(bundle, "Select * from TOC where id=" + this.f29852e.get(i2).getString("contentId")));
                if (z.getString("leaf").equals(IcyHeaders.a3)) {
                    return 0;
                }
                return (z.getString("xpath").length() > 0 || z.getString(HTML.Tag.V).length() > 0) ? 1 : 2;
            }

            public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
                MaterialRippleLayout materialRippleLayout;
                View.OnClickListener r1;
                ArrayList<Bundle> arrayList = this.f29852e;
                if (arrayList == null || arrayList.size() == 0) {
                    MessageViewHolder messageViewHolder = (MessageViewHolder) viewHolder;
                    return;
                }
                if (viewHolder.F() == 3) {
                    RippleSearchContentViewHolder rippleSearchContentViewHolder = (RippleSearchContentViewHolder) viewHolder;
                    final Bundle bundle = this.f29852e.get(i2);
                    rippleSearchContentViewHolder.I.setText(bundle.getString(this.f29853f));
                    if (this.f29854g == null) {
                        rippleSearchContentViewHolder.J.setVisibility(8);
                    } else {
                        rippleSearchContentViewHolder.J.setVisibility(0);
                        rippleSearchContentViewHolder.J.setText(Html.fromHtml(bundle.getString(this.f29854g)));
                    }
                    materialRippleLayout = rippleSearchContentViewHolder.K;
                    r1 = new View.OnClickListener() {
                        public void onClick(View view) {
                            OvidContentSearchAdapter.this.e0(bundle, i2);
                        }
                    };
                } else {
                    OvidChaptersFragment ovidChaptersFragment = OvidChaptersFragment.this;
                    CompressHelper compressHelper = ovidChaptersFragment.k4;
                    Bundle bundle2 = ovidChaptersFragment.h4;
                    final Bundle z = compressHelper.z(compressHelper.V(bundle2, "Select * from TOC where id=" + this.f29852e.get(i2).getString("contentId")));
                    if (viewHolder.F() == 0 || viewHolder.F() == 2) {
                        RippleTextViewHolder rippleTextViewHolder = (RippleTextViewHolder) viewHolder;
                        rippleTextViewHolder.I.setText(z.getString("name"));
                        materialRippleLayout = rippleTextViewHolder.J;
                        r1 = new View.OnClickListener() {
                            public void onClick(View view) {
                                OvidContentSearchAdapter.this.e0(z, i2);
                            }
                        };
                    } else if (viewHolder.F() == 1) {
                        RippleInfoTextViewHolder rippleInfoTextViewHolder = (RippleInfoTextViewHolder) viewHolder;
                        rippleInfoTextViewHolder.I.setText(z.getString("name"));
                        rippleInfoTextViewHolder.K.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                OvidContentSearchAdapter.this.e0(z, i2);
                            }
                        });
                        rippleInfoTextViewHolder.J.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                OvidContentSearchAdapter.this.d0(z, i2);
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                }
                materialRippleLayout.setOnClickListener(r1);
            }

            public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                ArrayList<Bundle> arrayList = this.f29852e;
                if (arrayList == null || arrayList.size() == 0) {
                    return new MessageViewHolder(this.f29851d, LayoutInflater.from(this.f29851d).inflate(R.layout.f1300list_view_item_card_notfound, viewGroup, false));
                } else if (i2 == 0) {
                    return new RippleTextViewHolder(LayoutInflater.from(this.f29851d).inflate(R.layout.f1342list_view_item_ripple_text, viewGroup, false));
                } else {
                    if (i2 == 1) {
                        return new RippleInfoTextViewHolder(LayoutInflater.from(this.f29851d).inflate(R.layout.f1340list_view_item_ripple_goto_arrow, viewGroup, false));
                    } else if (i2 == 2) {
                        return new RippleTextViewHolder(LayoutInflater.from(this.f29851d).inflate(R.layout.f1343list_view_item_ripple_text_arrow, viewGroup, false));
                    } else {
                        if (i2 == 3) {
                            return new RippleSearchContentViewHolder(LayoutInflater.from(this.f29851d).inflate(R.layout.f1355list_view_item_search_content_ripple, viewGroup, false));
                        }
                        return null;
                    }
                }
            }

            public int b() {
                ArrayList<Bundle> arrayList = this.f29852e;
                if (arrayList == null || arrayList.size() == 0) {
                    return 1;
                }
                return this.f29852e.size();
            }

            public void d0(Bundle bundle, int i2) {
            }

            public void e0(Bundle bundle, int i2) {
            }

            public void f0(ArrayList<Bundle> arrayList) {
                this.f29852e = arrayList;
                G();
            }
        }

        public class RippleInfoTextViewHolder extends RecyclerView.ViewHolder {
            public TextView I;
            public ImageView J;
            public MaterialRippleLayout K;

            public RippleInfoTextViewHolder(View view) {
                super(view);
                this.I = (TextView) view.findViewById(R.id.f1132text_view);
                this.K = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
                this.J = (ImageView) view.findViewById(R.id.f986info_button);
            }
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1494search, menu);
            this.s4 = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
            O2();
        }

        public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            String str;
            View inflate = layoutInflater.inflate(R.layout.f1246fragment_new_list, viewGroup, false);
            this.q4 = inflate;
            W2(bundle);
            S2();
            this.s4 = (SearchView) this.q4.findViewById(R.id.f1069search_view);
            O2();
            this.w4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
            AppBarLayout appBarLayout = (AppBarLayout) this.q4.findViewById(R.id.f825appbar);
            final RelativeLayout relativeLayout = (RelativeLayout) this.q4.findViewById(R.id.f830background_layout);
            if (y() == null || !y().containsKey("ParentId")) {
                appBarLayout.D(true, false);
                relativeLayout.setVisibility(0);
                str = "0";
            } else {
                appBarLayout.D(false, false);
                appBarLayout.postDelayed(new Runnable() {
                    public void run() {
                        relativeLayout.setVisibility(0);
                    }
                }, 800);
                str = y().getString("ParentId");
            }
            this.A4 = str;
            CompressHelper compressHelper = this.k4;
            Bundle bundle2 = this.h4;
            this.n4 = compressHelper.V(bundle2, "Select id as _id,* from toc where parentId = " + this.A4);
            this.l4 = new OvidChaptersAdapter(r(), this.n4, "name") {
                public void d0(Bundle bundle, int i2) {
                    OvidChaptersFragment.this.V2();
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("gotoSection", bundle);
                    OvidChaptersFragment ovidChaptersFragment = OvidChaptersFragment.this;
                    ovidChaptersFragment.k4.B1(ovidChaptersFragment.h4, bundle.getString("bookId"), (String[]) null, (String) null, bundle2);
                }

                public void e0(Bundle bundle, int i2) {
                    OvidChaptersFragment.this.V2();
                    String string = bundle.getString("leaf");
                    String string2 = bundle.getString("bookId");
                    if (string.equals(IcyHeaders.a3)) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putBundle("gotoSection", bundle);
                        OvidChaptersFragment ovidChaptersFragment = OvidChaptersFragment.this;
                        ovidChaptersFragment.k4.B1(ovidChaptersFragment.h4, string2, (String[]) null, (String) null, bundle2);
                        return;
                    }
                    Bundle bundle3 = new Bundle();
                    bundle3.putBundle("DB", OvidChaptersFragment.this.h4);
                    bundle3.putString("ParentId", bundle.getString("id"));
                    OvidChaptersFragment.this.k4.N(OvidChaptersActivity.class, OvidChaptersFragment.class, bundle3);
                }
            };
            this.B4 = new OvidContentSearchAdapter(r(), this.o4, "text", "subText") {
                public void d0(Bundle bundle, int i2) {
                    OvidChaptersFragment.this.V2();
                    Bundle bundle2 = new Bundle();
                    bundle2.putBundle("gotoSection", bundle);
                    OvidChaptersFragment ovidChaptersFragment = OvidChaptersFragment.this;
                    ovidChaptersFragment.k4.B1(ovidChaptersFragment.h4, bundle.getString("bookId"), (String[]) null, (String) null, bundle2);
                }

                public void e0(Bundle bundle, int i2) {
                    Bundle e0;
                    Bundle bundle2 = bundle;
                    OvidChaptersFragment.this.V2();
                    Class<OvidChaptersFragment> cls = OvidChaptersFragment.class;
                    Class<OvidChaptersActivity> cls2 = OvidChaptersActivity.class;
                    if (!bundle2.containsKey("type")) {
                        String string = bundle2.getString("leaf");
                        String string2 = bundle2.getString("bookId");
                        if (string.equals(IcyHeaders.a3)) {
                            Bundle bundle3 = new Bundle();
                            bundle3.putBundle("gotoSection", bundle2);
                            OvidChaptersFragment ovidChaptersFragment = OvidChaptersFragment.this;
                            ovidChaptersFragment.k4.B1(ovidChaptersFragment.h4, string2, (String[]) null, (String) null, bundle3);
                            return;
                        }
                        Bundle bundle4 = new Bundle();
                        bundle4.putBundle("DB", OvidChaptersFragment.this.h4);
                        bundle4.putString("ParentId", bundle2.getString("id"));
                        OvidChaptersFragment.this.k4.N(cls2, cls, bundle4);
                        return;
                    }
                    String string3 = bundle2.getString("type");
                    String string4 = bundle2.getString("contentId");
                    if (string3.equals("0")) {
                        OvidChaptersFragment ovidChaptersFragment2 = OvidChaptersFragment.this;
                        CompressHelper compressHelper = ovidChaptersFragment2.k4;
                        Bundle bundle5 = ovidChaptersFragment2.h4;
                        Bundle s1 = compressHelper.s1(compressHelper.V(bundle5, "Select * from TOC where id=" + string4));
                        if (s1.getString("leaf").equals(IcyHeaders.a3)) {
                            Bundle bundle6 = new Bundle();
                            bundle6.putBundle("gotoSection", s1);
                            OvidChaptersFragment ovidChaptersFragment3 = OvidChaptersFragment.this;
                            ovidChaptersFragment3.k4.B1(ovidChaptersFragment3.h4, s1.getString("bookId"), (String[]) null, (String) null, bundle6);
                            return;
                        }
                        Bundle bundle7 = new Bundle();
                        bundle7.putBundle("DB", OvidChaptersFragment.this.h4);
                        bundle7.putString("ParentId", s1.getString("id"));
                        OvidChaptersFragment.this.k4.N(cls2, cls, bundle7);
                    } else if (string3.equals(IcyHeaders.a3)) {
                        OvidChaptersFragment ovidChaptersFragment4 = OvidChaptersFragment.this;
                        ovidChaptersFragment4.k4.A1(ovidChaptersFragment4.h4, string4, (String[]) null, (String) null);
                    } else if (!string3.equals(ExifInterface.Y4)) {
                        if (string3.equals(ExifInterface.Z4)) {
                            OvidChaptersFragment ovidChaptersFragment5 = OvidChaptersFragment.this;
                            CompressHelper compressHelper2 = ovidChaptersFragment5.k4;
                            Bundle bundle8 = ovidChaptersFragment5.h4;
                            e0 = compressHelper2.e0(bundle8, "select * from images where imagename='" + string4 + "'");
                            if (e0 == null) {
                                return;
                            }
                        } else if (string3.equals("4")) {
                            OvidChaptersFragment ovidChaptersFragment6 = OvidChaptersFragment.this;
                            CompressHelper compressHelper3 = ovidChaptersFragment6.k4;
                            Bundle bundle9 = ovidChaptersFragment6.h4;
                            e0 = compressHelper3.e0(bundle9, "select * from tables where id=" + string4);
                            if (e0 == null) {
                                return;
                            }
                        } else if (string3.equals("5")) {
                            OvidChaptersFragment ovidChaptersFragment7 = OvidChaptersFragment.this;
                            ovidChaptersFragment7.k4.A1(ovidChaptersFragment7.h4, string4, ovidChaptersFragment7.T2(bundle2.getString("subText")), (String) null);
                            return;
                        } else {
                            return;
                        }
                        String string5 = e0.getString("bookId");
                        String string6 = e0.getString("goto");
                        OvidChaptersFragment ovidChaptersFragment8 = OvidChaptersFragment.this;
                        ovidChaptersFragment8.k4.A1(ovidChaptersFragment8.h4, string5, (String[]) null, string6);
                    }
                }
            };
            this.w4.setAdapter(this.l4);
            N2();
            o2(false);
            return inflate;
        }

        public void X2() {
            this.B4.f0(this.o4);
            this.w4.setAdapter(this.B4);
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
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new OvidChaptersFragment());
    }
}
