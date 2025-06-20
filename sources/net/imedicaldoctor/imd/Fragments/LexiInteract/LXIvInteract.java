package net.imedicaldoctor.imd.Fragments.LexiInteract;

import android.database.DataSetObserver;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.SearchHelperFragment;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Views.ButtonSmall;
import net.imedicaldoctor.imd.iMDActivity;

public class LXIvInteract extends iMDActivity {

    public static class LXIvInteractFragment extends SearchHelperFragment {
        /* access modifiers changed from: private */
        public ArrayList<Bundle> A4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> B4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> C4;
        public ButtonSmall D4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> E4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> F4;

        public class HeaderViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public final TextView f29804a;

            public HeaderViewHolder(View view) {
                this.f29804a = (TextView) view.findViewById(R.id.f957header_text);
            }
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
        }

        public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            ArrayList<Bundle> arrayList;
            View inflate = layoutInflater.inflate(R.layout.f1242fragment_lxiv_interact, viewGroup, false);
            this.q4 = inflate;
            super.onFragmentBind(layoutInflater, viewGroup, bundle);
            this.r4 = (Toolbar) this.q4.findViewById(R.id.f1139toolbar);
            this.D4 = (ButtonSmall) this.q4.findViewById(R.id.f829back_button);
            this.r4.setNavigationOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    LXIvInteractFragment.this.k4.W1(true);
                }
            });
            ButtonSmall buttonSmall = this.D4;
            if (buttonSmall != null) {
                buttonSmall.setDrawableIcon(r().getResources().getDrawable(R.drawable.f537back_icon));
                this.D4.setRippleColor(r().getResources().getColor(R.color.f466toolbar_item_ripple_color));
                this.D4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        LXIvInteractFragment.this.k4.W1(true);
                    }
                });
                this.D4.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        LXIvInteractFragment.this.k4.Z1(true);
                        return true;
                    }
                });
            }
            d3();
            if (bundle == null || !bundle.containsKey("mDrugs")) {
                this.A4 = new ArrayList<>();
                this.B4 = new ArrayList<>();
                arrayList = new ArrayList<>();
            } else {
                this.A4 = bundle.getParcelableArrayList("mIVDrugs");
                this.B4 = bundle.getParcelableArrayList("mSites");
                arrayList = bundle.getParcelableArrayList("mSolutions");
            }
            this.C4 = arrayList;
            final CompressHelper compressHelper = new CompressHelper(r());
            this.E4 = compressHelper.V(this.h4, "Select * from site order by name");
            this.F4 = compressHelper.V(this.h4, "Select * from solution order by name");
            AnonymousClass4 r6 = new ListAdapter() {
                /* renamed from: a */
                public Bundle getItem(int i2) {
                    ArrayList m3;
                    int size;
                    int i3;
                    String str;
                    Bundle bundle = new Bundle();
                    if (i2 == 0) {
                        bundle.putString("Type", "Header");
                        str = "DRUGS";
                    } else if (i2 == 1) {
                        bundle.putString("Type", "Add");
                        str = "Add Drug";
                    } else if (i2 == LXIvInteractFragment.this.A4.size() + 2) {
                        bundle.putString("Type", "Header");
                        str = "AT SITES";
                    } else if (i2 == LXIvInteractFragment.this.A4.size() + 3) {
                        bundle.putString("Type", "Add");
                        str = "All Sites";
                    } else if (i2 == LXIvInteractFragment.this.A4.size() + 4 + LXIvInteractFragment.this.B4.size()) {
                        bundle.putString("Type", "Header");
                        str = "IN SOLUTIONS";
                    } else if (i2 == LXIvInteractFragment.this.A4.size() + 5 + LXIvInteractFragment.this.B4.size()) {
                        bundle.putString("Type", "Add");
                        str = "All Solutions";
                    } else {
                        if (i2 <= 1 || i2 >= LXIvInteractFragment.this.A4.size() + 2) {
                            if (i2 <= LXIvInteractFragment.this.A4.size() + 3 || i2 >= LXIvInteractFragment.this.A4.size() + 4 + LXIvInteractFragment.this.B4.size()) {
                                if (i2 > LXIvInteractFragment.this.A4.size() + 5 + LXIvInteractFragment.this.B4.size()) {
                                    bundle.putString("Type", "SolutionItem");
                                    m3 = LXIvInteractFragment.this.C4;
                                    size = LXIvInteractFragment.this.A4.size() + 6 + LXIvInteractFragment.this.B4.size();
                                }
                                return bundle;
                            }
                            bundle.putString("Type", "SiteItem");
                            m3 = LXIvInteractFragment.this.B4;
                            size = LXIvInteractFragment.this.A4.size() + 4;
                            i3 = i2 - size;
                        } else {
                            bundle.putString("Type", "DrugItem");
                            m3 = LXIvInteractFragment.this.A4;
                            i3 = i2 - 2;
                        }
                        bundle.putBundle("Item", (Bundle) m3.get(i3));
                        return bundle;
                    }
                    bundle.putString("Text", str);
                    return bundle;
                }

                public boolean areAllItemsEnabled() {
                    return false;
                }

                public int getCount() {
                    return LXIvInteractFragment.this.A4.size() + 4 + LXIvInteractFragment.this.B4.size() + 2 + LXIvInteractFragment.this.C4.size();
                }

                public long getItemId(int i2) {
                    return 0;
                }

                public int getItemViewType(int i2) {
                    Bundle a2 = getItem(i2);
                    if (a2.getString("Type").equals("Header")) {
                        return 0;
                    }
                    return a2.getString("Type").equals("Add") ? 1 : 2;
                }

                public View getView(int i2, View view, ViewGroup viewGroup) {
                    TextView textView;
                    Bundle a2 = getItem(i2);
                    final String string = a2.getString("Type");
                    if (string.equals("Header")) {
                        if (view == null) {
                            view = LayoutInflater.from(LXIvInteractFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false);
                            view.setTag(new HeaderViewHolder(view));
                        }
                        textView = ((HeaderViewHolder) view.getTag()).f29804a;
                    } else if (string.equals("Add")) {
                        if (view == null) {
                            view = LayoutInflater.from(LXIvInteractFragment.this.r()).inflate(R.layout.f1299list_view_item_add, viewGroup, false);
                            view.setTag(view.findViewById(R.id.text));
                        }
                        textView = (TextView) view.getTag();
                    } else {
                        if (view == null) {
                            view = LayoutInflater.from(LXIvInteractFragment.this.r()).inflate(R.layout.f1313list_view_item_delete, viewGroup, false);
                            view.setTag(view.findViewById(R.id.text));
                        }
                        final Bundle bundle = a2.getBundle("Item");
                        ((TextView) view.getTag()).setText(bundle.getString("name"));
                        ((TextView) view.findViewById(R.id.f902delete_button)).setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                ArrayList m3;
                                if (string.equals("DrugItem")) {
                                    m3 = LXIvInteractFragment.this.A4;
                                } else if (string.equals("SiteItem")) {
                                    m3 = LXIvInteractFragment.this.B4;
                                } else {
                                    if (string.equals("SolutionItem")) {
                                        m3 = LXIvInteractFragment.this.C4;
                                    }
                                    LXIvInteractFragment.this.g4.setAdapter(LXIvInteractFragment.this.g4.getAdapter());
                                }
                                m3.remove(bundle);
                                LXIvInteractFragment.this.g4.setAdapter(LXIvInteractFragment.this.g4.getAdapter());
                            }
                        });
                        return view;
                    }
                    textView.setText(a2.getString("Text"));
                    return view;
                }

                public int getViewTypeCount() {
                    return 3;
                }

                public boolean hasStableIds() {
                    return false;
                }

                public boolean isEmpty() {
                    return false;
                }

                public boolean isEnabled(int i2) {
                    String string = getItem(i2).getString("Type");
                    return string.equals("Add") || string.equals("DrugItem");
                }

                public void registerDataSetObserver(DataSetObserver dataSetObserver) {
                }

                public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
                }
            };
            ((Button) this.q4.findViewById(R.id.f989interac_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    CompressHelper compressHelper = new CompressHelper(LXIvInteractFragment.this.r());
                    if (LXIvInteractFragment.this.A4.size() == 0) {
                        CompressHelper.x2(LXIvInteractFragment.this.r(), "You must at least add one drug", 1);
                    } else if (LXIvInteractFragment.this.A4.size() == 1) {
                        Bundle bundle = (Bundle) LXIvInteractFragment.this.A4.get(0);
                        String string = bundle.getString("rowid");
                        Bundle bundle2 = LXIvInteractFragment.this.h4;
                        ArrayList<Bundle> V = compressHelper.V(bundle2, "Select d.id, vf.sequence, vf.label, f.content, f.fieldtype_id from document d join field f on f.document_id = d.id join chapter c on c.id = d.chapter_id join view v on v.id = c.view_id join viewfield vf on vf.view_id = v.id and vf.fieldtype_id = f.fieldtype_id join fieldtypesite s on vf.fieldtype_id = s.fieldtype_id join generic g on d.globalid = g.global_id  join item i on i.generic_id = g.id left join ivsolution l on f.document_id = l.document_id and f.fieldtype_id = l.fieldtype_id where i.rowid = " + string + " and f.fieldtype_id != 38 and f.fieldtype_id != 42 and s.site_id in (" + LXIvInteractFragment.this.r3() + ")  and (l.solution_id is null or l.solution_id in (" + LXIvInteractFragment.this.t3() + ")) union select d.id, vf.sequence, vf.label, iv.content, iv.fieldtype_id from document d join ivfield iv on iv.document_id = d.id join chapter c on c.id = d.chapter_id join view v on v.id = c.view_id join viewfield vf on vf.view_id = v.id and vf.fieldtype_id = iv.fieldtype_id join fieldtypesite s on vf.fieldtype_id = s.fieldtype_id join generic g on d.globalid = g.global_id join item i on i.generic_id = g.id  left join ivsolution l on iv.document_id = l.document_id and iv.fieldtype_id = l.fieldtype_id  left join solution sol on l.solution_id = sol.id  where i.rowid = " + string + " and iv.fieldtype_id != 38 and iv.fieldtype_id != 42  order by vf.sequence");
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelableArrayList("ivMonograph", V);
                        bundle3.putParcelableArrayList("Solutions", LXIvInteractFragment.this.u3());
                        bundle3.putParcelableArrayList("Sites", LXIvInteractFragment.this.s3());
                        bundle3.putInt("Mode", 2);
                        if (!(LXIvInteractFragment.this.B4.size() == 0 && LXIvInteractFragment.this.C4.size() == 0)) {
                            bundle3.putString(HttpHeaders.f22879g, "Note: Information shown represents only the sites and solutions you have chosen.");
                        }
                        compressHelper.B1(LXIvInteractFragment.this.h4, bundle.getString("rowid"), (String[]) null, (String) null, bundle3);
                    } else {
                        Bundle bundle4 = new Bundle();
                        bundle4.putParcelableArrayList("Sites", LXIvInteractFragment.this.s3());
                        bundle4.putParcelableArrayList("Solutions", LXIvInteractFragment.this.u3());
                        bundle4.putParcelableArrayList("Drugs", LXIvInteractFragment.this.A4);
                        bundle4.putBundle("DB", LXIvInteractFragment.this.h4);
                        if (!(LXIvInteractFragment.this.B4.size() == 0 && LXIvInteractFragment.this.C4.size() == 0)) {
                            bundle4.putString(HttpHeaders.f22879g, "Note: Information shown represents only the sites and solutions you have chosen.");
                        }
                        new CompressHelper(LXIvInteractFragment.this.r()).N(LXIVInteractResult.class, LXIVInteractResult.LXIvInteractResultFragment.class, bundle4);
                    }
                }
            });
            this.g4.setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[]{-1, -1465341784}));
            this.g4.setDividerHeight(1);
            this.g4.setAdapter(r6);
            this.g4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    LXIvInteractList lXIvInteractList;
                    FragmentManager M;
                    String str;
                    LXIvInteractFragment lXIvInteractFragment = LXIvInteractFragment.this;
                    lXIvInteractFragment.e4 = i2;
                    Bundle bundle = (Bundle) lXIvInteractFragment.g4.getAdapter().getItem(i2);
                    String string = bundle.getString("Type");
                    String string2 = bundle.getString("Text");
                    if (string.equals("Add")) {
                        if (string2.contains("Drug")) {
                            LXIvInteractDrugList lXIvInteractDrugList = new LXIvInteractDrugList();
                            Bundle bundle2 = new Bundle();
                            bundle2.putBundle("db", LXIvInteractFragment.this.h4);
                            bundle2.putString("Drugs", CompressHelper.J1(LXIvInteractFragment.this.A4, "generic_id", ",", "'", "'"));
                            lXIvInteractDrugList.i2(bundle2);
                            lXIvInteractDrugList.Z2(true);
                            lXIvInteractDrugList.A2(LXIvInteractFragment.this, 0);
                            lXIvInteractDrugList.e3(LXIvInteractFragment.this.M(), "LXIVInteractDrugsList");
                            return;
                        }
                        if (string2.contains("Solution")) {
                            lXIvInteractList = new LXIvInteractList();
                            Bundle bundle3 = new Bundle();
                            bundle3.putBundle("db", LXIvInteractFragment.this.h4);
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(LXIvInteractFragment.this.F4);
                            arrayList.removeAll(LXIvInteractFragment.this.C4);
                            if (arrayList.size() == 0) {
                                CompressHelper.x2(LXIvInteractFragment.this.r(), "There is nothing to select", 1);
                            }
                            bundle3.putParcelableArrayList("items", arrayList);
                            bundle3.putString("titleProperty", "name");
                            bundle3.putString("type", "Solution");
                            lXIvInteractList.i2(bundle3);
                            lXIvInteractList.Z2(true);
                            lXIvInteractList.A2(LXIvInteractFragment.this, 0);
                            M = LXIvInteractFragment.this.M();
                            str = "LXIVInteractListSolution";
                        } else if (string2.contains("Site")) {
                            lXIvInteractList = new LXIvInteractList();
                            Bundle bundle4 = new Bundle();
                            bundle4.putBundle("db", LXIvInteractFragment.this.h4);
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.addAll(LXIvInteractFragment.this.E4);
                            arrayList2.removeAll(LXIvInteractFragment.this.B4);
                            if (arrayList2.size() == 0) {
                                CompressHelper.x2(LXIvInteractFragment.this.r(), "There is nothing to select", 1);
                            }
                            bundle4.putParcelableArrayList("items", arrayList2);
                            bundle4.putString("titleProperty", "name");
                            bundle4.putString("type", "Site");
                            lXIvInteractList.i2(bundle4);
                            lXIvInteractList.Z2(true);
                            lXIvInteractList.A2(LXIvInteractFragment.this, 0);
                            M = LXIvInteractFragment.this.M();
                            str = "LXIVInteractListSite";
                        } else {
                            return;
                        }
                        lXIvInteractList.e3(M, str);
                    } else if (string.equals("DrugItem")) {
                        String string3 = bundle.getBundle("Item").getString("rowid");
                        CompressHelper compressHelper = compressHelper;
                        Bundle bundle5 = LXIvInteractFragment.this.h4;
                        ArrayList<Bundle> V = compressHelper.V(bundle5, "Select d.id, vf.sequence, vf.label, f.content, f.fieldtype_id from document d join field f on f.document_id = d.id join chapter c on c.id = d.chapter_id join view v on v.id = c.view_id join viewfield vf on vf.view_id = v.id and vf.fieldtype_id = f.fieldtype_id join fieldtypesite s on vf.fieldtype_id = s.fieldtype_id join generic g on d.globalid = g.global_id  join item i on i.generic_id = g.id left join ivsolution l on f.document_id = l.document_id and f.fieldtype_id = l.fieldtype_id where i.rowid = " + string3 + " and f.fieldtype_id != 38 and f.fieldtype_id != 42 and s.site_id in (" + LXIvInteractFragment.this.r3() + ")  and (l.solution_id is null or l.solution_id in (" + LXIvInteractFragment.this.t3() + ")) union select d.id, vf.sequence, vf.label, iv.content, iv.fieldtype_id from document d join ivfield iv on iv.document_id = d.id join chapter c on c.id = d.chapter_id join view v on v.id = c.view_id join viewfield vf on vf.view_id = v.id and vf.fieldtype_id = iv.fieldtype_id join fieldtypesite s on vf.fieldtype_id = s.fieldtype_id join generic g on d.globalid = g.global_id join item i on i.generic_id = g.id  left join ivsolution l on iv.document_id = l.document_id and iv.fieldtype_id = l.fieldtype_id  left join solution sol on l.solution_id = sol.id  where i.rowid = " + string3 + " and iv.fieldtype_id != 38 and iv.fieldtype_id != 42  order by vf.sequence");
                        Bundle bundle6 = new Bundle();
                        bundle6.putParcelableArrayList("ivMonograph", V);
                        bundle6.putParcelableArrayList("Solutions", LXIvInteractFragment.this.u3());
                        bundle6.putParcelableArrayList("Sites", LXIvInteractFragment.this.s3());
                        bundle6.putInt("Mode", 2);
                        if (!(LXIvInteractFragment.this.B4.size() == 0 && LXIvInteractFragment.this.C4.size() == 0)) {
                            bundle6.putString(HttpHeaders.f22879g, "Note: Information shown represents only the sites and solutions you have chosen.");
                        }
                        compressHelper.B1(LXIvInteractFragment.this.h4, bundle.getBundle("Item").getString("rowid"), (String[]) null, (String) null, bundle6);
                    }
                }
            });
            this.g4.setSelection(this.e4);
            o2(true);
            e3();
            return inflate;
        }

        public void d3() {
            if (getActivity().getSharedPreferences("default_preferences", 0).getBoolean("HideStatusBar", false)) {
                float dimension = b0().getDimension(R.dimen.f522toolbar_padding);
                Toolbar toolbar = this.r4;
                if (toolbar != null) {
                    toolbar.setPadding(0, (int) dimension, 0, 0);
                    CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.q4.findViewById(R.id.f882collapsing_toolbar);
                }
            }
        }

        public String i3() {
            new ArrayList();
            return CompressHelper.I1(this.E4, "id");
        }

        public String j3() {
            new ArrayList();
            return CompressHelper.I1(this.F4, "id");
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }

        public void p3(Bundle bundle) {
            if (this.A4.contains(bundle)) {
                CompressHelper.x2(r(), "You Already added this drug", 1);
                return;
            }
            this.A4.add(bundle);
            ListView listView = this.g4;
            listView.setAdapter(listView.getAdapter());
        }

        public void q3(Bundle bundle, String str) {
            ArrayList<Bundle> arrayList;
            if (!str.equals("Solution")) {
                if (str.equals("Site")) {
                    if (this.B4.contains(bundle)) {
                        CompressHelper.x2(r(), "You Already added this Site", 1);
                        return;
                    }
                    arrayList = this.B4;
                }
                ListView listView = this.g4;
                listView.setAdapter(listView.getAdapter());
            } else if (this.C4.contains(bundle)) {
                CompressHelper.x2(r(), "You Already added this Solution", 1);
                return;
            } else {
                arrayList = this.C4;
            }
            arrayList.add(bundle);
            ListView listView2 = this.g4;
            listView2.setAdapter(listView2.getAdapter());
        }

        public String r3() {
            return CompressHelper.I1(s3(), "id");
        }

        public ArrayList<Bundle> s3() {
            ArrayList<Bundle> arrayList = this.B4.size() == 0 ? this.E4 : this.B4;
            Bundle bundle = new Bundle();
            bundle.putString("id", "0");
            arrayList.add(bundle);
            return arrayList;
        }

        public String t3() {
            return CompressHelper.I1(u3(), "id");
        }

        public ArrayList<Bundle> u3() {
            return this.C4.size() == 0 ? this.F4 : this.C4;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a1(bundle, new LXIvInteractFragment());
    }
}
