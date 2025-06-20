package net.imedicaldoctor.imd.Fragments.VisualDDX;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.cursoradapter.widget.CursorAdapter;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.ViewerHelperActivity;
import net.imedicaldoctor.imd.Fragments.ViewerHelperFragment;
import net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDialogListInterface;
import net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxFindingsDialog;
import net.imedicaldoctor.imd.Fragments.VisualDXLookup.VDDxKeyQuestionsDialog;
import net.imedicaldoctor.imd.R;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class VDDxBuilderActivity extends ViewerHelperActivity {

    public static class VDDXBuilderFragment extends ViewerHelperFragment implements VDDialogListInterface {
        private boolean X4;
        /* access modifiers changed from: private */
        public Bundle Y4;
        /* access modifiers changed from: private */
        public int Z4;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> a5;
        /* access modifiers changed from: private */
        public Bundle b5;
        /* access modifiers changed from: private */
        public ArrayList<String> c5;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> d5;
        /* access modifiers changed from: private */
        public ArrayList<Bundle> e5;
        /* access modifiers changed from: private */
        public ArrayList<String> f5;
        /* access modifiers changed from: private */
        public ArrayList<String> g5;
        /* access modifiers changed from: private */
        public ArrayList<String> h5;
        /* access modifiers changed from: private */
        public int i5;
        /* access modifiers changed from: private */
        public ListView j5;

        public static class PhotoCaptionPlaceHolder extends RecyclerView.ViewHolder {
            public TextView I;
            public ImageView J;
            public ImageView K;

            public PhotoCaptionPlaceHolder(View view) {
                super(view);
                this.I = (TextView) view.findViewById(R.id.f866caption);
                this.J = (ImageView) view.findViewById(R.id.f980image_view);
                this.K = (ImageView) view.findViewById(R.id.f873checkmark);
            }
        }

        public Bundle I4(int i2, ArrayList<String> arrayList) {
            Iterator<String> it2 = arrayList.iterator();
            int i3 = 0;
            while (it2.hasNext()) {
                String next = it2.next();
                if (i2 == i3) {
                    Bundle bundle = new Bundle();
                    bundle.putString("Text", next);
                    bundle.putString("Type", "Header");
                    return bundle;
                }
                int Z42 = i3 + Z4(next);
                if (i2 <= Z42) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("Section", next);
                    bundle2.putInt("Index", (i2 - (Z42 - Z4(next))) - 1);
                    bundle2.putString("Type", "Item");
                    return bundle2;
                }
                i3 = Z42 + 1;
            }
            return null;
        }

        public void J4() {
            ListView listView = this.j5;
            listView.setAdapter(listView.getAdapter());
        }

        public void T0(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(R.menu.f1494search, menu);
            this.r4 = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
            X4();
        }

        public View U0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate(R.layout.f1280fragment_vddx_builder, viewGroup, false);
            if (bundle != null && bundle.containsKey("Restoring")) {
                this.e4 = true;
                if (bundle.containsKey("Find")) {
                    this.f4 = bundle.getString("Find");
                    this.o4 = bundle.getInt("FindIndex");
                }
                if (bundle.containsKey("mFinalHTML")) {
                    this.A4 = bundle.getString("mFinalHTML");
                }
                if (bundle.containsKey("mTitle")) {
                    this.F4 = bundle.getString("mTitle");
                }
                this.a5 = bundle.getParcelableArrayList("mAllFindings");
                this.Y4 = bundle.getBundle("mModule");
                this.Z4 = bundle.getInt("mGridViewCount");
                this.c5 = bundle.getStringArrayList("mSections");
                this.e5 = bundle.getParcelableArrayList("mDistributionSelectedItems");
                this.d5 = bundle.getParcelableArrayList("mLocationSelectedItems");
                this.f5 = bundle.getStringArrayList("mKeyQuestionSelectedItems");
                this.g5 = bundle.getStringArrayList("mOtherFindingsSelectedItems");
                this.h5 = bundle.getStringArrayList("mLesionsSelected");
                this.i5 = bundle.getInt("mVisualIndex");
                this.b5 = bundle.getBundle("mAllFindingsDic");
            }
            this.C4 = inflate;
            this.D4 = y().getBundle("DB");
            this.E4 = y().getString("URL");
            TabHost tabHost = (TabHost) inflate.findViewById(R.id.f939findtabhost);
            this.x4 = tabHost;
            if (tabHost != null) {
                tabHost.setup();
            }
            this.j5 = (ListView) inflate.findViewById(R.id.f996list_view);
            if (y() == null) {
                return inflate;
            }
            try {
                this.Q4 = new CompressHelper(r());
                if (this.Y4 == null) {
                    Bundle bundle2 = this.D4;
                    this.Y4 = this.Q4.G(new JSONObject(CompressHelper.e2(new File(CompressHelper.h1(bundle2, this.E4 + ".JS", "modules")))));
                    CompressHelper compressHelper = this.Q4;
                    Bundle bundle3 = this.D4;
                    this.a5 = compressHelper.V(bundle3, "SELECT id, shortName, longName, children, leaf, ',' || supportedModules || ',' as modules FROM Findings where modules like '%," + this.E4 + ",%'");
                    this.b5 = new Bundle();
                    Iterator<Bundle> it2 = this.a5.iterator();
                    while (it2.hasNext()) {
                        Bundle next = it2.next();
                        this.b5.putString(next.getString("id"), next.getString("shortName"));
                    }
                    this.Z4 = 1;
                    ArrayList<String> arrayList = new ArrayList<>();
                    this.c5 = arrayList;
                    arrayList.add("Visual Findings");
                    this.c5.add("Body Location Findings");
                    if (this.Y4.getParcelableArrayList("distributionFindingIconImageList").size() > 0) {
                        this.c5.add("Distribution Findings");
                    }
                    if (this.Y4.getParcelableArrayList("keyQuestionList").size() > 0) {
                        this.c5.add("Key Questions");
                    }
                    this.c5.add("Add Other Findings");
                    this.F4 = "";
                    this.A4 = "";
                    this.h5 = new ArrayList<>();
                    this.d5 = new ArrayList<>();
                    this.e5 = new ArrayList<>();
                    this.f5 = new ArrayList<>();
                    this.g5 = new ArrayList<>();
                }
                this.j5.setAdapter(new BaseAdapter() {
                    public boolean areAllItemsEnabled() {
                        return false;
                    }

                    public int getCount() {
                        VDDXBuilderFragment vDDXBuilderFragment = VDDXBuilderFragment.this;
                        return vDDXBuilderFragment.b5(vDDXBuilderFragment.c5);
                    }

                    public Object getItem(int i2) {
                        VDDXBuilderFragment vDDXBuilderFragment = VDDXBuilderFragment.this;
                        return vDDXBuilderFragment.I4(i2, vDDXBuilderFragment.c5);
                    }

                    public long getItemId(int i2) {
                        return 0;
                    }

                    public int getItemViewType(int i2) {
                        Bundle bundle = (Bundle) getItem(i2);
                        String string = bundle.getString("Type");
                        if (!string.equals("Header") && string.equals("Item")) {
                            String string2 = bundle.getString("Section");
                            int i3 = bundle.getInt("Index");
                            if (string2.equals("Visual Findings")) {
                                if (i3 == 0) {
                                    return 1;
                                }
                                if (i3 == 1) {
                                    return 2;
                                }
                            } else if (string2.equals("Body Location Findings")) {
                                return i3 == 0 ? 3 : 4;
                            } else {
                                if (string2.equals("Distribution Findings")) {
                                    return 5;
                                }
                                if (string2.equals("Key Questions")) {
                                    return i3 == 0 ? 3 : 4;
                                }
                                if (string2.equals("Add Other Findings")) {
                                    return i3 == 0 ? 3 : 4;
                                }
                            }
                        }
                        return 0;
                    }

                    public View getView(int i2, View view, ViewGroup viewGroup) {
                        TextView textView;
                        View.OnClickListener r0;
                        TextView textView2;
                        String str;
                        ArrayList V4;
                        int size;
                        RecyclerView.Adapter r11;
                        Bundle bundle = (Bundle) getItem(i2);
                        if (bundle.getString("Type").equals("Header")) {
                            if (view == null) {
                                view = LayoutInflater.from(VDDXBuilderFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false);
                                view.setTag(view.findViewById(R.id.f957header_text));
                            }
                            ((TextView) view.getTag()).setText(bundle.getString("Text"));
                            return view;
                        } else if (!bundle.getString("Type").equals("Item")) {
                            return view;
                        } else {
                            String string = bundle.getString("Section");
                            final int i3 = bundle.getInt("Index");
                            if (!string.equals("Visual Findings")) {
                                if (string.equals("Body Location Findings")) {
                                    if (i3 == 0) {
                                        if (view == null) {
                                            view = LayoutInflater.from(VDDXBuilderFragment.this.r()).inflate(R.layout.f1299list_view_item_add, viewGroup, false);
                                            view.setTag(view.findViewById(R.id.text));
                                        }
                                        textView2 = (TextView) view.getTag();
                                        str = "Add Body Location";
                                    } else {
                                        if (i3 <= VDDXBuilderFragment.this.d5.size()) {
                                            V4 = VDDXBuilderFragment.this.d5;
                                            size = i3 - 1;
                                        } else {
                                            V4 = VDDXBuilderFragment.this.e5;
                                            size = (i3 - VDDXBuilderFragment.this.d5.size()) - 1;
                                        }
                                        Bundle bundle2 = (Bundle) V4.get(size);
                                        String string2 = bundle2.getString("title");
                                        if (string2.length() == 0) {
                                            string2 = VDDXBuilderFragment.this.b5.getString(bundle2.getStringArrayList("findingIds").get(0));
                                        }
                                        if (view == null) {
                                            view = LayoutInflater.from(VDDXBuilderFragment.this.r()).inflate(R.layout.f1313list_view_item_delete, viewGroup, false);
                                            view.setTag(view.findViewById(R.id.text));
                                        }
                                        textView = (TextView) view.findViewById(R.id.f902delete_button);
                                        ((TextView) view.getTag()).setText(string2);
                                        r0 = new View.OnClickListener() {
                                            public void onClick(View view) {
                                                ArrayList V4;
                                                int size;
                                                if (i3 <= VDDXBuilderFragment.this.d5.size()) {
                                                    V4 = VDDXBuilderFragment.this.d5;
                                                    size = i3;
                                                } else {
                                                    V4 = VDDXBuilderFragment.this.e5;
                                                    size = i3 - VDDXBuilderFragment.this.d5.size();
                                                }
                                                V4.remove(size - 1);
                                                ((BaseAdapter) VDDXBuilderFragment.this.j5.getAdapter()).notifyDataSetChanged();
                                            }
                                        };
                                        textView.setOnClickListener(r0);
                                        return view;
                                    }
                                } else if (!string.equals("Distribution Findings")) {
                                    if (string.equals("Key Questions")) {
                                        if (i3 == 0) {
                                            if (view == null) {
                                                view = LayoutInflater.from(VDDXBuilderFragment.this.r()).inflate(R.layout.f1299list_view_item_add, viewGroup, false);
                                                view.setTag(view.findViewById(R.id.text));
                                            }
                                            textView2 = (TextView) view.getTag();
                                            str = "Add Key Questions";
                                        } else {
                                            final String str2 = (String) VDDXBuilderFragment.this.f5.get(i3 - 1);
                                            String string3 = VDDXBuilderFragment.this.b5.getString(str2);
                                            if (view == null) {
                                                view = LayoutInflater.from(VDDXBuilderFragment.this.r()).inflate(R.layout.f1313list_view_item_delete, viewGroup, false);
                                                view.setTag(view.findViewById(R.id.text));
                                            }
                                            textView = (TextView) view.findViewById(R.id.f902delete_button);
                                            ((TextView) view.getTag()).setText(string3);
                                            r0 = new View.OnClickListener() {
                                                public void onClick(View view) {
                                                    VDDXBuilderFragment.this.f5.remove(str2);
                                                    ((BaseAdapter) VDDXBuilderFragment.this.j5.getAdapter()).notifyDataSetChanged();
                                                }
                                            };
                                        }
                                    } else if (!string.equals("Add Other Findings")) {
                                        return view;
                                    } else {
                                        if (i3 == 0) {
                                            if (view == null) {
                                                view = LayoutInflater.from(VDDXBuilderFragment.this.r()).inflate(R.layout.f1299list_view_item_add, viewGroup, false);
                                                view.setTag(view.findViewById(R.id.text));
                                            }
                                            ((TextView) view.getTag()).setText("Add Other Findings");
                                            return view;
                                        }
                                        final String str3 = (String) VDDXBuilderFragment.this.g5.get(i3 - 1);
                                        String string4 = VDDXBuilderFragment.this.b5.getString(str3);
                                        if (view == null) {
                                            view = LayoutInflater.from(VDDXBuilderFragment.this.r()).inflate(R.layout.f1313list_view_item_delete, viewGroup, false);
                                            view.setTag(view.findViewById(R.id.text));
                                        }
                                        textView = (TextView) view.findViewById(R.id.f902delete_button);
                                        ((TextView) view.getTag()).setText(string4);
                                        r0 = new View.OnClickListener() {
                                            public void onClick(View view) {
                                                VDDXBuilderFragment.this.g5.remove(str3);
                                                ((BaseAdapter) VDDXBuilderFragment.this.j5.getAdapter()).notifyDataSetChanged();
                                            }
                                        };
                                    }
                                    textView.setOnClickListener(r0);
                                    return view;
                                } else if (view == null) {
                                    View inflate = LayoutInflater.from(VDDXBuilderFragment.this.r()).inflate(R.layout.f1335list_view_item_recycleview, viewGroup, false);
                                    inflate.setTag(inflate.findViewById(R.id.f1054recycler_view));
                                    final RecyclerView recyclerView = (RecyclerView) inflate.getTag();
                                    recyclerView.setLayoutManager(new LinearLayoutManager(VDDXBuilderFragment.this.r(), 0, false));
                                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                                    recyclerView.setOnTouchListener(new View.OnTouchListener() {
                                        public boolean onTouch(View view, MotionEvent motionEvent) {
                                            VDDXBuilderFragment.this.j5.requestDisallowInterceptTouchEvent(true);
                                            if (motionEvent.getActionMasked() == 1) {
                                                VDDXBuilderFragment.this.j5.requestDisallowInterceptTouchEvent(false);
                                            }
                                            return false;
                                        }
                                    });
                                    recyclerView.setAdapter(new RecyclerView.Adapter() {
                                        public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
                                            PhotoCaptionPlaceHolder photoCaptionPlaceHolder = (PhotoCaptionPlaceHolder) viewHolder;
                                            final Bundle bundle = (Bundle) VDDXBuilderFragment.this.Y4.getParcelableArrayList("distributionFindingIconImageList").get(i2);
                                            String g1 = CompressHelper.g1(VDDXBuilderFragment.this.D4, bundle.getString("imageName"));
                                            String g12 = CompressHelper.g1(VDDXBuilderFragment.this.D4, bundle.getString("mouseoverImageName"));
                                            photoCaptionPlaceHolder.I.setText(VDDXBuilderFragment.this.b5.getString(bundle.getString("findingId")));
                                            if (VDDXBuilderFragment.this.h5.contains(bundle.getString("findingId"))) {
                                                photoCaptionPlaceHolder.K.setVisibility(0);
                                            } else {
                                                photoCaptionPlaceHolder.K.setVisibility(8);
                                            }
                                            AnimationDrawable animationDrawable = new AnimationDrawable();
                                            animationDrawable.addFrame(new BitmapDrawable(BitmapFactory.decodeFile(g1)), 1000);
                                            animationDrawable.addFrame(new BitmapDrawable(BitmapFactory.decodeFile(g12)), 1000);
                                            animationDrawable.setOneShot(false);
                                            photoCaptionPlaceHolder.J.setImageDrawable(animationDrawable);
                                            photoCaptionPlaceHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View view) {
                                                    String string = bundle.getString("findingId");
                                                    if (VDDXBuilderFragment.this.h5.contains(string)) {
                                                        VDDXBuilderFragment.this.h5.remove(string);
                                                    } else {
                                                        VDDXBuilderFragment.this.h5.add(string);
                                                    }
                                                    recyclerView.getAdapter().H(i2);
                                                }
                                            });
                                        }

                                        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                                            return new PhotoCaptionPlaceHolder(LayoutInflater.from(VDDXBuilderFragment.this.r()).inflate(R.layout.f1288grid_view_item_image_caption_checkmark, viewGroup, false));
                                        }

                                        public int b() {
                                            return VDDXBuilderFragment.this.Y4.getParcelableArrayList("distributionFindingIconImageList").size();
                                        }
                                    });
                                    return inflate;
                                } else {
                                    ((RecyclerView) view.getTag()).getAdapter().G();
                                    return view;
                                }
                                textView2.setText(str);
                                return view;
                            } else if (view == null) {
                                View inflate2 = LayoutInflater.from(VDDXBuilderFragment.this.r()).inflate(R.layout.f1335list_view_item_recycleview, viewGroup, false);
                                inflate2.setTag(inflate2.findViewById(R.id.f1054recycler_view));
                                final RecyclerView recyclerView2 = (RecyclerView) inflate2.getTag();
                                recyclerView2.setLayoutManager(new LinearLayoutManager(VDDXBuilderFragment.this.r(), 0, false));
                                recyclerView2.setItemAnimator(new DefaultItemAnimator());
                                recyclerView2.setOnTouchListener(new View.OnTouchListener() {
                                    public boolean onTouch(View view, MotionEvent motionEvent) {
                                        VDDXBuilderFragment.this.j5.requestDisallowInterceptTouchEvent(true);
                                        if (motionEvent.getActionMasked() == 1) {
                                            VDDXBuilderFragment.this.j5.requestDisallowInterceptTouchEvent(false);
                                        }
                                        return false;
                                    }
                                });
                                if (i3 == 0) {
                                    r11 = new RecyclerView.Adapter() {
                                        public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
                                            PhotoCaptionPlaceHolder photoCaptionPlaceHolder = (PhotoCaptionPlaceHolder) viewHolder;
                                            final Bundle bundle = (Bundle) VDDXBuilderFragment.this.Y4.getParcelableArrayList("visualFindingIconImageList").get(i2);
                                            String g1 = CompressHelper.g1(VDDXBuilderFragment.this.D4, bundle.getString("imageName"));
                                            String g12 = CompressHelper.g1(VDDXBuilderFragment.this.D4, bundle.getString("mouseoverImageName"));
                                            photoCaptionPlaceHolder.I.setText(VDDXBuilderFragment.this.b5.getString(bundle.getString("findingId")));
                                            if (VDDXBuilderFragment.this.h5.contains(bundle.getString("findingId"))) {
                                                photoCaptionPlaceHolder.K.setVisibility(0);
                                            } else {
                                                photoCaptionPlaceHolder.K.setVisibility(8);
                                            }
                                            AnimationDrawable animationDrawable = new AnimationDrawable();
                                            animationDrawable.addFrame(new BitmapDrawable(BitmapFactory.decodeFile(g1)), 1000);
                                            animationDrawable.addFrame(new BitmapDrawable(BitmapFactory.decodeFile(g12)), 1000);
                                            animationDrawable.setOneShot(false);
                                            photoCaptionPlaceHolder.J.setImageDrawable(animationDrawable);
                                            photoCaptionPlaceHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View view) {
                                                    int i2 = i2;
                                                    if (i2 != VDDXBuilderFragment.this.i5) {
                                                        int unused = VDDXBuilderFragment.this.i5 = i2;
                                                        if (bundle.getParcelableArrayList("childIcons").size() > 0) {
                                                            int unused2 = VDDXBuilderFragment.this.Z4 = 2;
                                                            ((BaseAdapter) VDDXBuilderFragment.this.j5.getAdapter()).notifyDataSetChanged();
                                                            return;
                                                        }
                                                        int unused3 = VDDXBuilderFragment.this.Z4 = 1;
                                                        ((BaseAdapter) VDDXBuilderFragment.this.j5.getAdapter()).notifyDataSetChanged();
                                                    }
                                                    String string = bundle.getString("findingId");
                                                    if (VDDXBuilderFragment.this.h5.contains(string)) {
                                                        VDDXBuilderFragment.this.h5.remove(string);
                                                    } else {
                                                        VDDXBuilderFragment.this.h5.add(string);
                                                    }
                                                    recyclerView2.getAdapter().H(i2);
                                                }
                                            });
                                        }

                                        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                                            return new PhotoCaptionPlaceHolder(LayoutInflater.from(VDDXBuilderFragment.this.r()).inflate(R.layout.f1288grid_view_item_image_caption_checkmark, viewGroup, false));
                                        }

                                        public int b() {
                                            return VDDXBuilderFragment.this.Y4.getParcelableArrayList("visualFindingIconImageList").size();
                                        }
                                    };
                                } else if (i3 != 1) {
                                    return inflate2;
                                } else {
                                    r11 = new RecyclerView.Adapter() {
                                        public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
                                            PhotoCaptionPlaceHolder photoCaptionPlaceHolder = (PhotoCaptionPlaceHolder) viewHolder;
                                            final Bundle bundle = (Bundle) ((Bundle) VDDXBuilderFragment.this.Y4.getParcelableArrayList("visualFindingIconImageList").get(VDDXBuilderFragment.this.i5)).getParcelableArrayList("childIcons").get(i2);
                                            String g1 = CompressHelper.g1(VDDXBuilderFragment.this.D4, bundle.getString("imageName"));
                                            String g12 = CompressHelper.g1(VDDXBuilderFragment.this.D4, bundle.getString("mouseoverImageName"));
                                            photoCaptionPlaceHolder.I.setText(VDDXBuilderFragment.this.b5.getString(bundle.getString("findingId")));
                                            if (VDDXBuilderFragment.this.h5.contains(bundle.getString("findingId"))) {
                                                photoCaptionPlaceHolder.K.setVisibility(0);
                                            } else {
                                                photoCaptionPlaceHolder.K.setVisibility(8);
                                            }
                                            AnimationDrawable animationDrawable = new AnimationDrawable();
                                            animationDrawable.addFrame(new BitmapDrawable(BitmapFactory.decodeFile(g1)), 1000);
                                            animationDrawable.addFrame(new BitmapDrawable(BitmapFactory.decodeFile(g12)), 1000);
                                            animationDrawable.setOneShot(false);
                                            photoCaptionPlaceHolder.J.setImageDrawable(animationDrawable);
                                            photoCaptionPlaceHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View view) {
                                                    String string = bundle.getString("findingId");
                                                    if (VDDXBuilderFragment.this.h5.contains(string)) {
                                                        VDDXBuilderFragment.this.h5.remove(string);
                                                    } else {
                                                        VDDXBuilderFragment.this.h5.add(string);
                                                    }
                                                    recyclerView2.getAdapter().H(i2);
                                                }
                                            });
                                        }

                                        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
                                            return new PhotoCaptionPlaceHolder(LayoutInflater.from(VDDXBuilderFragment.this.r()).inflate(R.layout.f1288grid_view_item_image_caption_checkmark, viewGroup, false));
                                        }

                                        public int b() {
                                            return ((Bundle) VDDXBuilderFragment.this.Y4.getParcelableArrayList("visualFindingIconImageList").get(VDDXBuilderFragment.this.i5)).getParcelableArrayList("childIcons").size();
                                        }
                                    };
                                }
                                recyclerView2.setAdapter(r11);
                                return inflate2;
                            } else {
                                ((RecyclerView) view.getTag()).getAdapter().G();
                                return view;
                            }
                        }
                    }

                    public int getViewTypeCount() {
                        return 6;
                    }

                    public boolean hasStableIds() {
                        return false;
                    }

                    public boolean isEmpty() {
                        return false;
                    }

                    public boolean isEnabled(int i2) {
                        Bundle bundle = (Bundle) getItem(i2);
                        return bundle.getString("Type").equals("Item") && bundle.getInt("Index") == 0;
                    }
                });
                this.j5.setDivider(new ColorDrawable(Color.parseColor("#e5e5e5")));
                this.j5.setDividerHeight(1);
                if (!this.Q4.x1()) {
                    m4(this.F4);
                }
                this.j5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        DialogFragment vDDxFindingsDialog;
                        Bundle bundle;
                        Bundle bundle2 = (Bundle) adapterView.getItemAtPosition(i2);
                        if (bundle2.getString("Type").equals("Item")) {
                            String string = bundle2.getString("Section");
                            int i3 = bundle2.getInt("Index");
                            if (!string.equals("Visual Findings")) {
                                if (string.equals("Body Location Findings")) {
                                    if (i3 == 0) {
                                        vDDxFindingsDialog = new VDDxBodyPartDialog();
                                        bundle = new Bundle();
                                        bundle.putBundle("db", VDDXBuilderFragment.this.D4);
                                        bundle.putBundle("allFindings", VDDXBuilderFragment.this.b5);
                                        bundle.putParcelableArrayList("distribution", VDDXBuilderFragment.this.e5);
                                        bundle.putParcelableArrayList("location", VDDXBuilderFragment.this.d5);
                                        bundle.putString("bodyFolder", VDDXBuilderFragment.this.y().getBundle("moduleInfo").getString("bodyLocation"));
                                    } else {
                                        return;
                                    }
                                } else if (!string.equals("Distribution Findings")) {
                                    if (string.equals("Key Questions")) {
                                        if (i3 == 0) {
                                            vDDxFindingsDialog = new VDDxKeyQuestionsDialog();
                                            bundle = new Bundle();
                                            bundle.putBundle("db", VDDXBuilderFragment.this.D4);
                                            bundle.putBundle("allFindings", VDDXBuilderFragment.this.b5);
                                            bundle.putStringArrayList("selectedKeyQuestions", VDDXBuilderFragment.this.f5);
                                            bundle.putParcelableArrayList("allKeyQuestions", VDDXBuilderFragment.this.Y4.getParcelableArrayList("keyQuestionList"));
                                        } else {
                                            return;
                                        }
                                    } else if (string.equals("Add Other Findings") && i3 == 0) {
                                        vDDxFindingsDialog = new VDDxFindingsDialog();
                                        bundle = new Bundle();
                                        bundle.putBundle("db", VDDXBuilderFragment.this.D4);
                                        bundle.putBundle("allFindings", VDDXBuilderFragment.this.b5);
                                        bundle.putStringArrayList("selectedFindings", VDDXBuilderFragment.this.g5);
                                        bundle.putBundle("parent", new Bundle());
                                        bundle.putString("moduleId", VDDXBuilderFragment.this.E4);
                                        bundle.putStringArrayList("disabledItems", VDDXBuilderFragment.this.Y4());
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                                vDDxFindingsDialog.i2(bundle);
                                vDDxFindingsDialog.Z2(true);
                                vDDxFindingsDialog.A2(VDDXBuilderFragment.this, 0);
                                vDDxFindingsDialog.e3(VDDXBuilderFragment.this.M(), "VDDialogFragment");
                            }
                        }
                    }
                });
                r().setTitle(this.F4);
                ((Button) this.C4.findViewById(R.id.f897ddx_button)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        CompressHelper compressHelper;
                        Bundle bundle;
                        String[] strArr;
                        String str;
                        String str2;
                        ArrayList<String> Y4 = VDDXBuilderFragment.this.Y4();
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("moduleId", VDDXBuilderFragment.this.E4);
                        if (Y4.size() > 0) {
                            VDDXBuilderFragment vDDXBuilderFragment = VDDXBuilderFragment.this;
                            CompressHelper compressHelper2 = vDDXBuilderFragment.Q4;
                            Bundle bundle3 = vDDXBuilderFragment.D4;
                            strArr = null;
                            str = null;
                            compressHelper = compressHelper2;
                            bundle = bundle3;
                            str2 = "ddx-" + StringUtils.join((Iterable<?>) Y4, ",");
                        } else {
                            VDDXBuilderFragment vDDXBuilderFragment2 = VDDXBuilderFragment.this;
                            compressHelper = vDDXBuilderFragment2.Q4;
                            bundle = vDDXBuilderFragment2.D4;
                            strArr = null;
                            str = null;
                            str2 = "ddx-";
                        }
                        compressHelper.B1(bundle, str2, strArr, str, bundle2);
                    }
                });
                o2(false);
                Toolbar toolbar = (Toolbar) this.C4.findViewById(R.id.f1139toolbar);
                this.L4 = toolbar;
                toolbar.z(R.menu.f1494search);
                this.L4.setNavigationIcon((int) R.drawable.f539back_icon_small);
                this.L4.setNavigationOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (VDDXBuilderFragment.this.y().containsKey("Dialog")) {
                            try {
                                VDDXBuilderFragment.this.z().u().M(R.anim.f23to_fade_in, R.anim.f24to_fade_out).B(VDDXBuilderFragment.this).r();
                            } catch (Exception e2) {
                                FirebaseCrashlytics.d().g(e2);
                                e2.printStackTrace();
                            }
                        } else {
                            VDDXBuilderFragment.this.Q4.W1(false);
                        }
                    }
                });
                this.r4 = (SearchView) this.L4.getMenu().findItem(R.id.f814action_search).getActionView();
                X4();
                a5();
                G3();
                return inflate;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                B4(e2);
                return inflate;
            }
        }

        public void X4() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.r4.setImportantForAutofill(8);
            }
            this.r4.setIconifiedByDefault(false);
            this.r4.setQueryHint("Add Findings");
            this.r4.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
                public boolean a(int i2) {
                    Cursor c2 = VDDXBuilderFragment.this.r4.getSuggestionsAdapter().c();
                    if (!c2.moveToPosition(i2)) {
                        return false;
                    }
                    String string = c2.getString(c2.getColumnIndex("id"));
                    if (VDDXBuilderFragment.this.a5.contains(string)) {
                        VDDXBuilderFragment.this.r4.k0("", true);
                        VDDXBuilderFragment.this.G3();
                        return true;
                    }
                    VDDXBuilderFragment.this.g5.add(string);
                    VDDXBuilderFragment.this.r4.k0("", true);
                    VDDXBuilderFragment.this.G3();
                    ((BaseAdapter) VDDXBuilderFragment.this.j5.getAdapter()).notifyDataSetChanged();
                    return false;
                }

                public boolean b(int i2) {
                    a(i2);
                    return false;
                }
            });
            ((ImageView) this.r4.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    VDDXBuilderFragment.this.r4.k0("", false);
                    VDDXBuilderFragment.this.r4.clearFocus();
                    VDDXBuilderFragment.this.G3();
                }
            });
            this.r4.setSuggestionsAdapter(new CursorAdapter(r(), (Cursor) null, 0) {
                public void e(View view, Context context, Cursor cursor) {
                    TextView textView = (TextView) view.getTag();
                    if (VDDXBuilderFragment.this.g5.contains(cursor.getString(cursor.getColumnIndex("id")))) {
                        textView.setTextColor(-7829368);
                    }
                    textView.setText(cursor.getString(cursor.getColumnIndex("longName")));
                }

                public boolean isEnabled(int i2) {
                    Cursor cursor = (Cursor) getItem(i2);
                    return !VDDXBuilderFragment.this.g5.contains(cursor.getString(cursor.getColumnIndex("id")));
                }

                public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
                    View inflate = LayoutInflater.from(context).inflate(R.layout.f1375list_view_item_spell_drug, viewGroup, false);
                    inflate.setTag(inflate.findViewById(R.id.text));
                    return inflate;
                }
            });
            this.r4.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                public boolean a(final String str) {
                    if (str.length() <= 1) {
                        return false;
                    }
                    new AsyncTask() {
                        /* access modifiers changed from: protected */
                        public Object doInBackground(Object[] objArr) {
                            String str = "Select rowid as _id,* from FindingsSearch where longNameSearch match '" + str + "*' order by longName asc";
                            VDDXBuilderFragment vDDXBuilderFragment = VDDXBuilderFragment.this;
                            return vDDXBuilderFragment.Q4.V(vDDXBuilderFragment.D4, str);
                        }

                        /* access modifiers changed from: protected */
                        public void onPostExecute(Object obj) {
                            VDDXBuilderFragment.this.r4.getSuggestionsAdapter().m(VDDXBuilderFragment.this.Q4.h((ArrayList) obj));
                        }
                    }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                    return true;
                }

                public boolean b(String str) {
                    return false;
                }
            });
            this.r4.clearFocus();
        }

        public ArrayList<String> Y4() {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.addAll(this.h5);
            Iterator<Bundle> it2 = this.d5.iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getStringArrayList("findingIds"));
            }
            Iterator<Bundle> it3 = this.e5.iterator();
            while (it3.hasNext()) {
                arrayList.addAll(it3.next().getStringArrayList("findingIds"));
            }
            arrayList.addAll(this.f5);
            return arrayList;
        }

        public int Z4(String str) {
            ArrayList<String> arrayList;
            int size;
            if (str.equals("Visual Findings")) {
                return this.Z4;
            }
            if (str.equals("Body Location Findings")) {
                size = this.d5.size() + this.e5.size();
            } else if (str.equals("Distribution Findings")) {
                return 1;
            } else {
                if (str.equals("Key Questions")) {
                    arrayList = this.f5;
                } else if (!str.equals("Add Other Findings")) {
                    return 0;
                } else {
                    arrayList = this.g5;
                }
                size = arrayList.size();
            }
            return size + 1;
        }

        public void a5() {
            ((ListView) this.C4.findViewById(R.id.f996list_view)).setVisibility(0);
            ((TextView) this.C4.findViewById(R.id.f1086status_label)).setVisibility(8);
            ((LinearLayout) this.C4.findViewById(R.id.f1087status_layout)).setVisibility(8);
        }

        public int b5(ArrayList<String> arrayList) {
            int i2 = 0;
            if (arrayList == null) {
                return 0;
            }
            Iterator<String> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                i2 = i2 + Z4(it2.next()) + 1;
            }
            return i2;
        }

        public void h(Bundle bundle, String str) {
            str.equals("Module");
        }

        public void l1() {
            super.l1();
            G3();
        }

        public void m1(Bundle bundle) {
            super.m1(bundle);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.f1175activity_general_viewer);
        Y0(new VDDXBuilderFragment(), bundle);
    }
}
