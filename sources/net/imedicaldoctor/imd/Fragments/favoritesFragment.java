package net.imedicaldoctor.imd.Fragments;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.ViewCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.extractor.AacUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;
import com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder;
import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.tool.xml.css.CSS;
import com.timehop.stickyheadersrecyclerview.ItemVisibilityAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersTouchListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.R;
import net.imedicaldoctor.imd.Utils.MaterialRippleLayout;
import net.imedicaldoctor.imd.ViewHolders.HeaderCellViewHolder;
import net.imedicaldoctor.imd.ViewHolders.StatusAdapter;
import net.imedicaldoctor.imd.iMDLogger;
import okio.BufferedSink;
import okio.Okio;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class favoritesFragment extends SearchHelperFragment {
    /* access modifiers changed from: private */
    public FavoriteAdapter A4;
    /* access modifiers changed from: private */
    public ArrayList<Bundle> B4;
    /* access modifiers changed from: private */
    public ArrayList<Bundle> C4;
    private boolean D4;
    /* access modifiers changed from: private */
    public RecyclerView E4;
    /* access modifiers changed from: private */
    public String F4;
    /* access modifiers changed from: private */
    public boolean G4;
    private Activity H4;
    /* access modifiers changed from: private */
    public boolean I4;
    private MenuItem J4;
    private MenuItem K4;
    /* access modifiers changed from: private */
    public ArrayList<String> L4;
    /* access modifiers changed from: private */
    public StickyRecyclerHeadersDecoration M4;
    StickyRecyclerHeadersTouchListener N4;
    /* access modifiers changed from: private */
    public RecyclerViewDragDropManager O4;
    private boolean P4;
    public CompressHelper Q4;
    private final BroadcastReceiver R4 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            iMDLogger.d("favorite", "received favorite changed message");
            favoritesFragment.this.m3();
        }
    };

    public static class AddCellViewHolder extends RecyclerView.ViewHolder {
        public TextView I;

        public AddCellViewHolder(View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.text);
        }
    }

    public static class EditFavoriteCellViewHolder extends AbstractDraggableItemViewHolder implements DraggableItemViewHolder {
        public TextView J;
        public ImageView K;
        public LinearLayout L;
        public ImageView M;

        public EditFavoriteCellViewHolder(View view) {
            super(view);
            this.J = (TextView) view.findViewById(R.id.f896database_title);
            this.K = (ImageView) view.findViewById(R.id.f921drag_indicator);
            this.L = (LinearLayout) view.findViewById(R.id.f885container_view);
            this.M = (ImageView) view.findViewById(R.id.f1058remove_icon);
        }
    }

    public class EditFavoritesAdapter extends RecyclerView.Adapter implements DraggableItemAdapter {

        /* renamed from: d  reason: collision with root package name */
        HashMap<String, Integer> f30168d;

        /* renamed from: e  reason: collision with root package name */
        int f30169e = 0;

        public EditFavoritesAdapter() {
            HashMap<String, Integer> hashMap = new HashMap<>();
            this.f30168d = hashMap;
            hashMap.put("AddSection", Integer.valueOf(AacUtil.f12876f));
            this.f30168d.put("EditSectionas", Integer.valueOf(this.f30169e));
            this.f30169e++;
            if (favoritesFragment.this.C4 != null) {
                Iterator it2 = favoritesFragment.this.C4.iterator();
                while (it2.hasNext()) {
                    this.f30168d.put("EditSection" + ((Bundle) it2.next()).getString("title"), Integer.valueOf(this.f30169e));
                    this.f30169e = this.f30169e + 1;
                }
                Iterator it3 = favoritesFragment.this.C4.iterator();
                while (it3.hasNext()) {
                    Bundle bundle = (Bundle) it3.next();
                    this.f30168d.put("Section" + bundle.getString("title"), Integer.valueOf(this.f30169e));
                    this.f30169e = this.f30169e + 1;
                    for (int i2 = 0; i2 < bundle.getParcelableArrayList("items").size(); i2++) {
                        Bundle bundle2 = (Bundle) bundle.getParcelableArrayList("items").get(i2);
                        this.f30168d.put("Database" + bundle2.getString("dbName") + bundle2.getString("dbAddress"), Integer.valueOf(this.f30169e));
                        this.f30169e = this.f30169e + 1;
                    }
                }
                a0(true);
            }
        }

        public long B(int i2) {
            StringBuilder sb;
            String str;
            String sb2;
            Object obj;
            if (i2 < favoritesFragment.this.C4.size() + 1) {
                if (i2 == 0) {
                    obj = this.f30168d.get("EditSectionas");
                } else {
                    sb2 = "EditSection" + ((Bundle) favoritesFragment.this.C4.get(i2 - 1)).getString("title");
                    obj = this.f30168d.get(sb2);
                }
            } else if (i2 == favoritesFragment.this.C4.size() + 1) {
                return SilenceSkippingAudioProcessor.A;
            } else {
                favoritesFragment favoritesfragment = favoritesFragment.this;
                Bundle l3 = favoritesfragment.l3((i2 - favoritesFragment.this.C4.size()) - 2, favoritesfragment.C4);
                if (l3.containsKey("Item")) {
                    l3 = l3.getBundle("Item");
                    sb = new StringBuilder();
                    sb.append("Database");
                    sb.append(l3.getString("dbName"));
                    str = "dbAddress";
                } else {
                    sb = new StringBuilder();
                    sb.append("Section");
                    str = "Title";
                }
                sb.append(l3.getString(str));
                sb2 = sb.toString();
                if (!this.f30168d.containsKey(sb2)) {
                    return -1;
                }
                obj = this.f30168d.get(sb2);
            }
            return (long) ((Integer) obj).intValue();
        }

        public int C(int i2) {
            if (i2 < favoritesFragment.this.C4.size() + 1) {
                return i2 == 0 ? 1 : 2;
            }
            if (i2 == favoritesFragment.this.C4.size() + 1) {
                return 3;
            }
            favoritesFragment favoritesfragment = favoritesFragment.this;
            return favoritesfragment.l3((i2 - favoritesFragment.this.C4.size()) - 2, favoritesfragment.C4).containsKey("Title") ? 1 : 0;
        }

        public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
            if (viewHolder.F() == 3) {
                AddCellViewHolder addCellViewHolder = (AddCellViewHolder) viewHolder;
                addCellViewHolder.I.setText("Add Section");
                addCellViewHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        final EditText editText = new EditText(favoritesFragment.this.r());
                        editText.setTextColor(favoritesFragment.this.b0().getColor(R.color.f140black));
                        new AlertDialog.Builder(favoritesFragment.this.r(), R.style.f2185alertDialogTheme).l("Enter Section Name").setView(editText).y("Add", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                String obj = editText.getText().toString();
                                if (obj.length() == 0) {
                                    CompressHelper.x2(favoritesFragment.this.r(), "You must enter a name for the section", 1);
                                    return;
                                }
                                if (EditFavoritesAdapter.this.f30168d.containsKey("EditSection" + obj)) {
                                    CompressHelper.x2(favoritesFragment.this.r(), "You already have a section with this name", 1);
                                    return;
                                }
                                Bundle bundle = new Bundle();
                                bundle.putString("title", obj);
                                bundle.putParcelableArrayList("items", new ArrayList());
                                favoritesFragment.this.C4.add(bundle);
                                favoritesFragment.this.E4.getAdapter().G();
                                EditFavoritesAdapter editFavoritesAdapter = EditFavoritesAdapter.this;
                                editFavoritesAdapter.f30169e++;
                                editFavoritesAdapter.f30168d.put("EditSection" + obj, Integer.valueOf(EditFavoritesAdapter.this.f30169e));
                            }
                        }).p("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        }).I();
                    }
                });
            } else if (i2 >= favoritesFragment.this.C4.size() + 1) {
                favoritesFragment favoritesfragment = favoritesFragment.this;
                final Bundle l3 = favoritesfragment.l3((i2 - favoritesFragment.this.C4.size()) - 2, favoritesfragment.C4);
                if (l3.containsKey("Item")) {
                    Bundle bundle = l3.getBundle("Item");
                    final EditFavoriteCellViewHolder editFavoriteCellViewHolder = (EditFavoriteCellViewHolder) viewHolder;
                    editFavoriteCellViewHolder.J.setText(bundle.getString("dbDocName"));
                    editFavoriteCellViewHolder.M.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            int i2 = l3.getInt("Section");
                            int i3 = l3.getInt("Row");
                            Bundle bundle = l3.getBundle("Item");
                            ((Bundle) favoritesFragment.this.C4.get(i2)).getParcelableArrayList("items").remove(i3);
                            CompressHelper compressHelper = favoritesFragment.this.Q4;
                            String X0 = compressHelper.X0();
                            compressHelper.q(X0, "Delete from favorites where _id=" + bundle.getString("_id"));
                            favoritesFragment.this.E4.getAdapter().G();
                        }
                    });
                    final String string = bundle.getString("dbDocName");
                    editFavoriteCellViewHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            final EditText editText = new EditText(favoritesFragment.this.r());
                            editText.setText(string);
                            editText.setTextColor(favoritesFragment.this.b0().getColor(R.color.f140black));
                            new AlertDialog.Builder(favoritesFragment.this.r(), R.style.f2185alertDialogTheme).l("Edit Document Name").setView(editText).y("Edit", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                    String obj = editText.getText().toString();
                                    if (obj.length() == 0) {
                                        CompressHelper.x2(favoritesFragment.this.r(), "You must enter a name for the document", 1);
                                    } else if (!obj.equals(string)) {
                                        Bundle bundle = (Bundle) ((Bundle) favoritesFragment.this.C4.get(l3.getInt("Section"))).getParcelableArrayList("items").get(l3.getInt("Row"));
                                        bundle.remove("dbDocName");
                                        bundle.putString("dbDocName", obj);
                                        editFavoriteCellViewHolder.J.setText(obj);
                                        EditFavoritesAdapter editFavoritesAdapter = EditFavoritesAdapter.this;
                                        editFavoritesAdapter.f30169e++;
                                        editFavoritesAdapter.f30168d.put("Database" + bundle.getString("dbName") + bundle.getString("dbAddress"), Integer.valueOf(EditFavoritesAdapter.this.f30169e));
                                    }
                                }
                            }).p("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            }).I();
                        }
                    });
                    return;
                }
                ((HeaderCellViewHolder) viewHolder).I.setText(l3.getString("Title"));
            } else if (i2 == 0) {
                ((HeaderCellViewHolder) viewHolder).I.setText("Sections");
            } else {
                final String string2 = ((Bundle) favoritesFragment.this.C4.get(i2 - 1)).getString("title");
                EditHeaderCellViewHolder editHeaderCellViewHolder = (EditHeaderCellViewHolder) viewHolder;
                editHeaderCellViewHolder.J.setText(string2);
                editHeaderCellViewHolder.f15587a.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        final EditText editText = new EditText(favoritesFragment.this.r());
                        editText.setText(string2);
                        editText.setTextColor(favoritesFragment.this.b0().getColor(R.color.f140black));
                        new AlertDialog.Builder(favoritesFragment.this.r(), R.style.f2185alertDialogTheme).l("Edit Section Name").setView(editText).y("Edit", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                                String obj = editText.getText().toString();
                                if (obj.length() == 0) {
                                    CompressHelper.x2(favoritesFragment.this.r(), "You must enter a name for the section", 1);
                                } else if (!obj.equals(string2)) {
                                    if (EditFavoritesAdapter.this.f30168d.containsKey("EditSection" + obj)) {
                                        CompressHelper.x2(favoritesFragment.this.r(), "You already have a section with this name", 1);
                                        return;
                                    }
                                    Bundle bundle = (Bundle) favoritesFragment.this.C4.get(i2 - 1);
                                    bundle.remove("title");
                                    bundle.putString("title", obj);
                                    favoritesFragment.this.E4.getAdapter().G();
                                    EditFavoritesAdapter editFavoritesAdapter = EditFavoritesAdapter.this;
                                    editFavoritesAdapter.f30169e++;
                                    editFavoritesAdapter.f30168d.put("EditSection" + obj, Integer.valueOf(EditFavoritesAdapter.this.f30169e));
                                }
                            }
                        }).p("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        }).I();
                    }
                });
                editHeaderCellViewHolder.M.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        ArrayList parcelableArrayList = ((Bundle) favoritesFragment.this.C4.get(i2 - 1)).getParcelableArrayList("items");
                        if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                            favoritesFragment.this.C4.remove(i2 - 1);
                            favoritesFragment.this.E4.getAdapter().G();
                            return;
                        }
                        CompressHelper.x2(favoritesFragment.this.r(), "First delete favorite items inside this section", 1);
                    }
                });
            }
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                return new EditFavoriteCellViewHolder(LayoutInflater.from(favoritesFragment.this.r()).inflate(R.layout.f1320list_view_item_favorite_edit, viewGroup, false));
            }
            if (i2 == 1) {
                return new HeaderCellViewHolder(LayoutInflater.from(favoritesFragment.this.r()).inflate(R.layout.f1310list_view_item_database_header, viewGroup, false));
            }
            if (i2 == 2) {
                return new EditHeaderCellViewHolder(LayoutInflater.from(favoritesFragment.this.r()).inflate(R.layout.f1311list_view_item_database_header_edit, viewGroup, false));
            }
            if (i2 == 3) {
                return new AddCellViewHolder(LayoutInflater.from(favoritesFragment.this.r()).inflate(R.layout.f1299list_view_item_add, viewGroup, false));
            }
            return null;
        }

        public int b() {
            if (favoritesFragment.this.C4 == null || favoritesFragment.this.C4.size() == 0) {
                return 0;
            }
            favoritesFragment favoritesfragment = favoritesFragment.this;
            return favoritesfragment.J3(favoritesfragment.C4) + favoritesFragment.this.C4.size() + 2;
        }

        public void h(int i2, int i3) {
            if (i2 <= 0 || i2 >= favoritesFragment.this.C4.size() + 1) {
                favoritesFragment favoritesfragment = favoritesFragment.this;
                Bundle l3 = favoritesfragment.l3((i2 - favoritesFragment.this.C4.size()) - 2, favoritesfragment.C4);
                int i4 = l3.getInt("Row");
                int i5 = l3.getInt("Section");
                Bundle bundle = (Bundle) ((Bundle) favoritesFragment.this.C4.get(i5)).getParcelableArrayList("items").get(i4);
                favoritesFragment favoritesfragment2 = favoritesFragment.this;
                Bundle l32 = favoritesfragment2.l3((i3 - favoritesFragment.this.C4.size()) - 2, favoritesfragment2.C4);
                int i6 = l32.getInt("Row");
                int i7 = l32.getInt("Section");
                iMDLogger.f("Staring Drag", "Section " + i5 + " , Row : " + i4 + ", Section2:" + i7 + ", row2:" + i6);
                ((Bundle) favoritesFragment.this.C4.get(i5)).getParcelableArrayList("items").remove(i4);
                if (l32.containsKey("Title")) {
                    int i8 = l32.getInt("Row2");
                    int i9 = l32.getInt("Section2");
                    iMDLogger.f("Staring Drag", "Section22:" + i9 + ", row22:" + i8);
                    if (i5 >= i7) {
                        if (((Bundle) favoritesFragment.this.C4.get(i9)).getParcelableArrayList("items").size() == 0) {
                            i8 = 0;
                        }
                        ((Bundle) favoritesFragment.this.C4.get(i9)).getParcelableArrayList("items").add(i8, bundle);
                        return;
                    }
                }
                ((Bundle) favoritesFragment.this.C4.get(i7)).getParcelableArrayList("items").add(i6, bundle);
                return;
            }
            int i10 = i2 - 1;
            favoritesFragment.this.C4.remove(i10);
            favoritesFragment.this.C4.add(i3 - 1, (Bundle) favoritesFragment.this.C4.get(i10));
        }

        public boolean k(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4) {
            ImageView imageView;
            LinearLayout linearLayout;
            if (viewHolder.F() == 1 || viewHolder.F() == 3) {
                return false;
            }
            if (viewHolder.F() == 2) {
                EditHeaderCellViewHolder editHeaderCellViewHolder = (EditHeaderCellViewHolder) viewHolder;
                imageView = editHeaderCellViewHolder.K;
                linearLayout = editHeaderCellViewHolder.L;
            } else {
                EditFavoriteCellViewHolder editFavoriteCellViewHolder = (EditFavoriteCellViewHolder) viewHolder;
                imageView = editFavoriteCellViewHolder.K;
                linearLayout = editFavoriteCellViewHolder.L;
            }
            linearLayout.getTop();
            ViewCompat.C0(linearLayout);
            boolean a2 = ViewUtils.a(imageView, i3 - (linearLayout.getLeft() + ((int) (ViewCompat.B0(linearLayout) + 0.5f))), 50);
            iMDLogger.f("CanDrag", a2 ? PdfBoolean.l3 : "false");
            return a2;
        }

        public ItemDraggableRange w(RecyclerView.ViewHolder viewHolder, int i2) {
            if (i2 <= 0 || i2 >= favoritesFragment.this.C4.size() + 1) {
                return new ItemDraggableRange(favoritesFragment.this.C4.size() + 3, b() - 1);
            }
            iMDLogger.j("RequestingRange", "Range requested");
            return new ItemDraggableRange(1, favoritesFragment.this.C4.size());
        }
    }

    public static class EditHeaderCellViewHolder extends AbstractDraggableItemViewHolder implements DraggableItemViewHolder {
        public TextView J;
        public ImageView K;
        public LinearLayout L;
        public ImageView M;

        public EditHeaderCellViewHolder(View view) {
            super(view);
            this.J = (TextView) view.findViewById(R.id.f957header_text);
            this.K = (ImageView) view.findViewById(R.id.f921drag_indicator);
            this.L = (LinearLayout) view.findViewById(R.id.f885container_view);
            this.M = (ImageView) view.findViewById(R.id.f1058remove_icon);
        }
    }

    public class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View view) {
            super(view);
        }
    }

    public class FavoriteAdapter extends RecyclerView.Adapter implements StickyRecyclerHeadersAdapter {
        public FavoriteAdapter() {
        }

        public int C(int i2) {
            favoritesFragment favoritesfragment;
            ArrayList q3;
            if (favoritesFragment.this.B4 == null || favoritesFragment.this.B4.size() == 0) {
                favoritesfragment = favoritesFragment.this;
                q3 = favoritesfragment.C4;
            } else {
                favoritesfragment = favoritesFragment.this;
                q3 = favoritesfragment.B4;
            }
            return favoritesfragment.k3(i2, q3).containsKey("Item") ? 0 : 1;
        }

        public void R(RecyclerView.ViewHolder viewHolder, final int i2) {
            favoritesFragment favoritesfragment;
            ArrayList q3;
            if (viewHolder.F() != 1) {
                FavoriteItemViewHolder favoriteItemViewHolder = (FavoriteItemViewHolder) viewHolder;
                if (favoritesFragment.this.B4 == null || favoritesFragment.this.B4.size() == 0) {
                    favoritesfragment = favoritesFragment.this;
                    q3 = favoritesfragment.C4;
                } else {
                    favoritesfragment = favoritesFragment.this;
                    q3 = favoritesfragment.B4;
                }
                Bundle bundle = favoritesfragment.k3(i2, q3).getBundle("Item");
                favoriteItemViewHolder.I.setText(bundle.getString("dbDocName"));
                final String string = bundle.getString("_id");
                if (favoritesFragment.this.I4) {
                    favoriteItemViewHolder.J.setVisibility(0);
                    favoriteItemViewHolder.J.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            favoritesFragment.this.C3(string);
                            favoritesFragment.this.m3();
                        }
                    });
                    favoriteItemViewHolder.K.setRippleOverlay(false);
                } else {
                    favoriteItemViewHolder.K.setRippleOverlay(true);
                    favoriteItemViewHolder.J.setVisibility(8);
                }
                favoriteItemViewHolder.K.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        favoritesFragment favoritesfragment;
                        int i2;
                        ArrayList q3;
                        CompressHelper compressHelper;
                        if (favoritesFragment.this.B4 == null || favoritesFragment.this.B4.size() == 0) {
                            favoritesfragment = favoritesFragment.this;
                            i2 = i2;
                            q3 = favoritesfragment.C4;
                        } else {
                            favoritesfragment = favoritesFragment.this;
                            i2 = i2;
                            q3 = favoritesfragment.B4;
                        }
                        Bundle bundle = favoritesfragment.k3(i2, q3).getBundle("Item");
                        Bundle i1 = favoritesFragment.this.Q4.i1(bundle.getString("dbName"));
                        if (i1 == null) {
                            CompressHelper.x2(favoritesFragment.this.D3(), "You don't have this database installed", 1);
                            return;
                        }
                        String string = i1.getString("Type");
                        String string2 = bundle.getString("dbAddress");
                        favoritesFragment.this.h4 = i1;
                        if (string.equals("uworld")) {
                            compressHelper = favoritesFragment.this.Q4;
                            string2 = "question-" + string2;
                        } else {
                            compressHelper = favoritesFragment.this.Q4;
                        }
                        compressHelper.A1(i1, string2, (String[]) null, (String) null);
                        favoritesFragment.this.V2();
                    }
                });
            }
        }

        public RecyclerView.ViewHolder T(ViewGroup viewGroup, int i2) {
            if (i2 == 1) {
                return new EmptyViewHolder(LayoutInflater.from(favoritesFragment.this.r()).inflate(R.layout.f1325list_view_item_header_keeper, viewGroup, false));
            }
            View inflate = LayoutInflater.from(favoritesFragment.this.r()).inflate(R.layout.f1319list_view_item_favorite, viewGroup, false);
            favoritesFragment favoritesfragment = favoritesFragment.this;
            return new FavoriteItemViewHolder(favoritesfragment.r(), inflate);
        }

        public int b() {
            favoritesFragment favoritesfragment;
            ArrayList q3;
            if (favoritesFragment.this.B4 == null || favoritesFragment.this.B4.size() == 0) {
                favoritesfragment = favoritesFragment.this;
                q3 = favoritesfragment.C4;
            } else {
                favoritesfragment = favoritesFragment.this;
                q3 = favoritesfragment.B4;
            }
            return favoritesfragment.I3(q3);
        }

        public RecyclerView.ViewHolder o(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(favoritesFragment.this.r()).inflate(R.layout.f1357list_view_item_search_header, viewGroup, false);
            favoritesFragment favoritesfragment = favoritesFragment.this;
            return new SearchHeaderViewHolder(favoritesfragment.r(), inflate);
        }

        public void p(RecyclerView.ViewHolder viewHolder, int i2) {
            favoritesFragment favoritesfragment;
            ArrayList q3;
            SearchHeaderViewHolder searchHeaderViewHolder = (SearchHeaderViewHolder) viewHolder;
            if (favoritesFragment.this.B4 == null || favoritesFragment.this.B4.size() == 0) {
                favoritesfragment = favoritesFragment.this;
                q3 = favoritesfragment.C4;
            } else {
                favoritesfragment = favoritesFragment.this;
                q3 = favoritesfragment.B4;
            }
            Bundle k3 = favoritesfragment.k3(i2, q3);
            viewHolder.f15587a.setTag(Integer.valueOf(i2));
            Bundle j1 = favoritesFragment.this.Q4.j1(k3.getString("Database"));
            if (j1 == null) {
                searchHeaderViewHolder.I.setVisibility(8);
                searchHeaderViewHolder.J.setText(k3.getString("Database"));
                return;
            }
            searchHeaderViewHolder.I.setVisibility(0);
            searchHeaderViewHolder.J.setText(j1.getString("Title"));
            String C = CompressHelper.C(j1);
            if (C.contains("file:///android_asset/")) {
                try {
                    InputStream open = favoritesFragment.this.r().getAssets().open(C.replace("file:///android_asset/", ""));
                    searchHeaderViewHolder.I.setImageBitmap(BitmapFactory.decodeStream(open));
                    open.close();
                } catch (Exception e2) {
                    FirebaseCrashlytics.d().g(e2);
                    e2.printStackTrace();
                }
            } else {
                searchHeaderViewHolder.I.setImageURI(Uri.parse(C));
            }
        }

        public long r(int i2) {
            favoritesFragment favoritesfragment;
            ArrayList q3;
            if (favoritesFragment.this.B4 == null || favoritesFragment.this.B4.size() == 0) {
                favoritesfragment = favoritesFragment.this;
                q3 = favoritesfragment.C4;
            } else {
                favoritesfragment = favoritesFragment.this;
                q3 = favoritesfragment.B4;
            }
            return (long) favoritesfragment.j3(i2, q3);
        }
    }

    public class FavoriteItemViewHolder extends RecyclerView.ViewHolder {
        public TextView I;
        public ImageView J;
        public MaterialRippleLayout K;

        public FavoriteItemViewHolder(Context context, View view) {
            super(view);
            this.I = (TextView) view.findViewById(R.id.text);
            this.K = (MaterialRippleLayout) view.findViewById(R.id.f1061ripple_layout);
            this.J = (ImageView) view.findViewById(R.id.f1058remove_icon);
        }
    }

    public class HeaderViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f30172a;

        /* renamed from: b  reason: collision with root package name */
        public final ImageView f30173b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f30174c;

        public HeaderViewHolder(View view) {
            this.f30172a = (TextView) view.findViewById(R.id.f896database_title);
            this.f30173b = (ImageView) view.findViewById(R.id.f893database_image);
            this.f30174c = (ImageView) view.findViewById(R.id.icon);
        }
    }

    public class ListViewItemContentSearchPlaceHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f30176a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f30177b;

        public ListViewItemContentSearchPlaceHolder(View view) {
            this.f30176a = (TextView) view.findViewById(R.id.f1136title_text);
            this.f30177b = (TextView) view.findViewById(R.id.f1098subtitle_text);
        }
    }

    public class ListViewItemFavoritePlaceHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f30179a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f30180b;

        public ListViewItemFavoritePlaceHolder(View view) {
            this.f30179a = (TextView) view.findViewById(R.id.text);
            this.f30180b = (ImageView) view.findViewById(R.id.f1058remove_icon);
        }
    }

    public class SearchHeaderViewHolder extends RecyclerView.ViewHolder {
        public ImageView I;
        public TextView J;
        public ImageView K;

        public SearchHeaderViewHolder(Context context, View view) {
            super(view);
            this.J = (TextView) view.findViewById(R.id.f896database_title);
            this.I = (ImageView) view.findViewById(R.id.f893database_image);
            this.K = (ImageView) view.findViewById(R.id.icon);
        }
    }

    public void B3() {
        if (!this.P4) {
            this.E4.setItemDecoration(this.M4);
            this.P4 = true;
        }
    }

    public void C3(String str) {
        CompressHelper compressHelper = this.Q4;
        String X0 = compressHelper.X0();
        compressHelper.q(X0, "Delete from favorites where _id=" + str);
    }

    public Activity D3() {
        return this.H4;
    }

    public ArrayList<Bundle> E3() {
        String str = this.Q4.M1() + "/favorites.json";
        ArrayList<Bundle> i3 = i3();
        if (i3 == null) {
            return null;
        }
        if (new File(str).exists()) {
            try {
                JSONArray jSONArray = new JSONArray(new String(this.Q4.c2(str)));
                ArrayList<Bundle> arrayList = new ArrayList<>();
                int i2 = 0;
                while (i2 < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = 0;
                    while (i4 < jSONArray2.length()) {
                        final JSONObject jSONObject2 = jSONArray2.getJSONObject(i4);
                        ArrayList arrayList3 = new ArrayList(Collections2.d(i3, new Predicate<Bundle>() {
                            /* renamed from: a */
                            public boolean apply(Bundle bundle) {
                                try {
                                    return bundle.getString("dbName").equals(jSONObject2.getString("Database")) && bundle.getString("dbAddress").equals(jSONObject2.getString("Address"));
                                } catch (Exception e2) {
                                    FirebaseCrashlytics.d().g(e2);
                                    iMDLogger.f("Error in filtering", e2.getLocalizedMessage());
                                    return false;
                                }
                            }
                        }));
                        JSONArray jSONArray3 = jSONArray;
                        if (arrayList3.size() == 1) {
                            Bundle bundle = (Bundle) arrayList3.get(0);
                            i3.remove(bundle);
                            bundle.remove("dbDocName");
                            bundle.putString("dbDocName", jSONObject2.getString("Title"));
                            arrayList2.add(bundle);
                        }
                        i4++;
                        jSONArray = jSONArray3;
                    }
                    JSONArray jSONArray4 = jSONArray;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("title", jSONObject.getString("title"));
                    bundle2.putParcelableArrayList("items", arrayList2);
                    arrayList.add(bundle2);
                    i2++;
                    jSONArray = jSONArray4;
                }
                if (i3.size() > 0) {
                    ArrayList<Bundle> r2 = this.Q4.r2(i3, "dbTitle");
                    for (int i5 = 0; i5 < r2.size(); i5++) {
                        final Bundle bundle3 = r2.get(i5);
                        ArrayList arrayList4 = new ArrayList(Collections2.d(arrayList, new Predicate<Bundle>() {
                            /* renamed from: a */
                            public boolean apply(Bundle bundle) {
                                return bundle.getString("title").equals(bundle3.getString("title"));
                            }
                        }));
                        if (arrayList4.size() == 0) {
                            Bundle bundle4 = new Bundle();
                            bundle4.putString("title", bundle3.getString("title"));
                            bundle4.putParcelableArrayList("items", bundle3.getParcelableArrayList("items"));
                            arrayList.add(bundle4);
                        } else {
                            Bundle bundle5 = (Bundle) arrayList4.get(0);
                            ArrayList parcelableArrayList = bundle5.getParcelableArrayList("items");
                            parcelableArrayList.addAll(bundle3.getParcelableArrayList("items"));
                            int indexOf = arrayList.indexOf(bundle5);
                            Bundle bundle6 = new Bundle();
                            bundle6.putString("title", bundle5.getString("title"));
                            bundle6.putParcelableArrayList("items", parcelableArrayList);
                            arrayList.remove(indexOf);
                            arrayList.add(indexOf, bundle6);
                        }
                    }
                }
                return arrayList;
            } catch (Exception e2) {
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f("Error in Reading Json", e2.getLocalizedMessage());
            }
        }
        return this.Q4.r2(i3, "dbTitle");
    }

    public void F3() {
        if (this.P4) {
            this.E4.A1(this.M4);
            this.P4 = false;
        }
    }

    public void G3(ArrayList<Bundle> arrayList) {
        FileOutputStream fileOutputStream;
        Throwable th;
        BufferedSink d2;
        Throwable th2;
        ArrayList<Bundle> arrayList2 = arrayList;
        if (arrayList2 != null) {
            String str = this.Q4.M1() + "/favorites.json";
            ArrayList arrayList3 = new ArrayList();
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            while (i2 < arrayList.size()) {
                Bundle bundle = arrayList2.get(i2);
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("items");
                ArrayList arrayList4 = new ArrayList();
                JSONArray jSONArray2 = new JSONArray();
                int i3 = 0;
                while (i3 < parcelableArrayList.size()) {
                    Bundle bundle2 = (Bundle) parcelableArrayList.get(i3);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("Database", bundle2.getString("dbName"));
                    ArrayList arrayList5 = parcelableArrayList;
                    bundle3.putString("Address", bundle2.getString("dbAddress"));
                    String str2 = str;
                    int i4 = i2;
                    bundle3.putString("Title", bundle2.getString("dbDocName"));
                    arrayList4.add(bundle3);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("Database", bundle2.getString("dbName"));
                        jSONObject.put("Address", bundle2.getString("dbAddress"));
                        jSONObject.put("Title", bundle2.getString("dbDocName"));
                        jSONArray2.put(jSONObject);
                    } catch (Exception unused) {
                    }
                    i3++;
                    ArrayList<Bundle> arrayList6 = arrayList;
                    parcelableArrayList = arrayList5;
                    str = str2;
                    i2 = i4;
                }
                String str3 = str;
                int i5 = i2;
                Bundle bundle4 = new Bundle();
                bundle4.putString("title", bundle.getString("title"));
                bundle4.putParcelableArrayList("items", arrayList4);
                arrayList3.add(bundle4);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("title", bundle.getString("title"));
                    jSONObject2.put("items", jSONArray2);
                    jSONArray.put(jSONObject2);
                } catch (Exception unused2) {
                }
                i2 = i5 + 1;
                arrayList2 = arrayList;
                str = str3;
            }
            String jSONArray3 = jSONArray.toString();
            String str4 = str;
            if (new File(str4).exists()) {
                new File(str4).delete();
            }
            try {
                fileOutputStream = new FileOutputStream(new File(str4));
                d2 = Okio.d(Okio.p(fileOutputStream));
                d2.W0(jSONArray3);
                d2.flush();
                d2.close();
                fileOutputStream.close();
                return;
            } catch (IOException e2) {
                FirebaseCrashlytics.d().g(e2);
                iMDLogger.f("Error in writing json", e2.getLocalizedMessage());
                return;
            } catch (Throwable th3) {
                th.addSuppressed(th3);
            }
        } else {
            return;
        }
        throw th;
        throw th2;
    }

    public void H3() {
        ArrayList<Bundle> arrayList = this.C4;
        if (arrayList == null || arrayList.size() == 0) {
            f3("No Favorites");
        } else {
            e3();
        }
    }

    public int I3(ArrayList<Bundle> arrayList) {
        int i2 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<Bundle> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            if (!(next == null || next.getParcelableArrayList("items") == null)) {
                i2 += this.L4.contains(next.getString("title")) ? 1 : next.getParcelableArrayList("items").size();
            }
        }
        return i2;
    }

    public int J3(ArrayList<Bundle> arrayList) {
        int i2 = 0;
        if (arrayList == null) {
            return 0;
        }
        Iterator<Bundle> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            i2 = i2 + it2.next().getParcelableArrayList("items").size() + 1;
        }
        return i2;
    }

    public void M0(Activity activity) {
        iMDLogger.j("favoritesFragment", "OnAttach");
        super.M0(activity);
        this.H4 = activity;
    }

    public void Q0(Bundle bundle) {
        super.Q0(bundle);
        LocalBroadcastManager.b(D3()).c(this.R4, new IntentFilter("net.imedicaldoctor.imd.favorite"));
    }

    public void T0(Menu menu, MenuInflater menuInflater) {
        try {
            r().setTitle("");
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        menuInflater.inflate(R.menu.f1446menu_favorites, menu);
        final MenuItem findItem = menu.findItem(R.id.f795action_edit);
        final MenuItem findItem2 = menu.findItem(R.id.f794action_done);
        this.J4 = findItem;
        this.K4 = findItem2;
        findItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                favoritesFragment.this.s4.clearFocus();
                if (!(favoritesFragment.this.B4 == null || favoritesFragment.this.B4.size() == 0)) {
                    favoritesFragment.this.s4.k0("", false);
                    favoritesFragment.this.s4.clearFocus();
                    ArrayList unused = favoritesFragment.this.B4 = null;
                    favoritesFragment.this.H3();
                    favoritesFragment.this.V2();
                }
                findItem.setVisible(false);
                findItem2.setVisible(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(favoritesFragment.this.r());
                RecyclerViewDragDropManager unused2 = favoritesFragment.this.O4 = new RecyclerViewDragDropManager();
                favoritesFragment.this.O4.R((NinePatchDrawable) favoritesFragment.this.b0().getDrawable(R.drawable.Q7));
                RecyclerView.Adapter o = favoritesFragment.this.O4.o(new EditFavoritesAdapter());
                favoritesFragment.this.F3();
                favoritesFragment.this.E4.setLayoutManager(linearLayoutManager);
                favoritesFragment.this.E4.setAdapter(o);
                favoritesFragment.this.O4.h(favoritesFragment.this.E4);
                return false;
            }
        });
        findItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (!(favoritesFragment.this.B4 == null || favoritesFragment.this.B4.size() == 0)) {
                    favoritesFragment.this.s4.k0("", false);
                    favoritesFragment.this.s4.clearFocus();
                    ArrayList unused = favoritesFragment.this.B4 = null;
                    favoritesFragment.this.H3();
                    favoritesFragment.this.V2();
                }
                findItem.setVisible(true);
                findItem2.setVisible(false);
                favoritesFragment.this.O4.N();
                favoritesFragment.this.B3();
                favoritesFragment.this.M4.n();
                favoritesFragment.this.A4.G();
                boolean unused2 = favoritesFragment.this.I4 = false;
                favoritesFragment favoritesfragment = favoritesFragment.this;
                favoritesfragment.G3(favoritesfragment.C4);
                favoritesFragment.this.H3();
                return false;
            }
        });
        menu.findItem(R.id.f802action_navigation).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                ((mainActivity) favoritesFragment.this.r()).onToolbarNavigationClicked();
                return true;
            }
        });
        final SearchView searchView = (SearchView) menu.findItem(R.id.f814action_search).getActionView();
        this.s4 = searchView;
        if (Build.VERSION.SDK_INT >= 26) {
            searchView.setImportantForAutofill(8);
        }
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Search Favorites");
        final String str = this.F4;
        this.s4.postDelayed(new Runnable() {
            public void run() {
                boolean unused = favoritesFragment.this.G4 = true;
                favoritesFragment.this.s4.k0(str, false);
                String str = favoritesFragment.this.f4;
                if (str != null && str.length() > 0) {
                    if (favoritesFragment.this.B4 == null || favoritesFragment.this.B4.size() == 0) {
                        favoritesFragment favoritesfragment = favoritesFragment.this;
                        favoritesfragment.s4.k0(favoritesfragment.f4, true);
                    } else {
                        favoritesFragment favoritesfragment2 = favoritesFragment.this;
                        favoritesfragment2.s4.k0(favoritesfragment2.f4, false);
                        favoritesFragment.this.e3();
                    }
                    favoritesFragment.this.V2();
                }
            }
        }, 10);
        this.G4 = false;
        ((ImageView) searchView.findViewById(R.id.search_close_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                searchView.k0("", false);
                searchView.clearFocus();
                ArrayList unused = favoritesFragment.this.B4 = null;
                favoritesFragment.this.H3();
                favoritesFragment.this.V2();
                favoritesFragment.this.A4.G();
                favoritesFragment.this.M4.n();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(final String str) {
                if (!favoritesFragment.this.G4) {
                    return true;
                }
                if (str.length() == 0) {
                    favoritesFragment.this.H3();
                    ArrayList unused = favoritesFragment.this.B4 = null;
                    favoritesFragment.this.A4.G();
                    favoritesFragment.this.M4.n();
                    return true;
                }
                String unused2 = favoritesFragment.this.F4 = str;
                favoritesFragment.this.f4 = str;
                new AsyncTask() {
                    /* access modifiers changed from: protected */
                    public Object doInBackground(Object[] objArr) {
                        ArrayList<Bundle> arrayList = CompressHelper.t;
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            arrayList2.add("WHEN '" + arrayList.get(i2).getString("Name").replace("'", "''") + "' THEN " + i2);
                        }
                        String str = "case dbName " + StringUtils.join((Iterable<?>) arrayList2, StringUtils.SPACE) + " end";
                        CompressHelper compressHelper = favoritesFragment.this.Q4;
                        ArrayList<Bundle> Y = compressHelper.Y(compressHelper.X0(), "Select * from favorites where dbDocName like '%" + str + "%' order by " + str);
                        favoritesFragment favoritesfragment = favoritesFragment.this;
                        ArrayList unused = favoritesfragment.B4 = favoritesfragment.Q4.r2(Y, "dbTitle");
                        return null;
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(Object obj) {
                        if (favoritesFragment.this.B4 == null || favoritesFragment.this.B4.size() == 0) {
                            favoritesFragment.this.f3("Nothing Found");
                            return;
                        }
                        favoritesFragment.this.e3();
                        favoritesFragment.this.A4.G();
                        favoritesFragment.this.M4.n();
                    }

                    /* access modifiers changed from: protected */
                    public void onPreExecute() {
                        favoritesFragment.this.f3("Searching ...");
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
                return false;
            }

            public boolean b(String str) {
                return false;
            }
        });
        r().setTitle("");
    }

    public View onFragmentBind(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.q4;
        if (view != null) {
            return view;
        }
        this.L4 = new ArrayList<>();
        this.Q4 = new CompressHelper(r());
        View inflate = layoutInflater.inflate(R.layout.f1230fragment_favorites, viewGroup, false);
        this.q4 = inflate;
        if (bundle != null && bundle.containsKey("Position")) {
            this.e4 = bundle.getInt("Position");
        }
        if (bundle != null && bundle.containsKey("Query")) {
            this.f4 = bundle.getString("Query");
        }
        if (bundle != null && bundle.containsKey("mIsSubmitted")) {
            this.D4 = bundle.getBoolean("mIsSubmitted");
        }
        this.E4 = (RecyclerView) this.q4.findViewById(R.id.f1054recycler_view);
        this.B4 = new ArrayList<>();
        if (bundle != null && bundle.containsKey("mResults")) {
            this.B4 = bundle.getParcelableArrayList("mResults");
        }
        this.C4 = new ArrayList<>();
        if (bundle != null && bundle.containsKey("mFavorites")) {
            this.C4 = bundle.getParcelableArrayList("mFavorites");
        }
        this.A4 = new FavoriteAdapter();
        ArrayList<Bundle> arrayList = this.C4;
        if (arrayList == null || arrayList.size() == 0) {
            ArrayList<Bundle> E3 = E3();
            this.C4 = E3;
            G3(E3);
        }
        StickyRecyclerHeadersDecoration stickyRecyclerHeadersDecoration = new StickyRecyclerHeadersDecoration(this.A4, new ItemVisibilityAdapter() {
            public boolean a(int i2) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) favoritesFragment.this.E4.getLayoutManager();
                linearLayoutManager.B2();
                linearLayoutManager.E2();
                boolean z = linearLayoutManager.B2() <= i2 && linearLayoutManager.E2() >= i2;
                Boolean valueOf = Boolean.valueOf(z);
                iMDLogger.f(CSS.Property.m0, i2 + " visible + " + valueOf);
                return z;
            }
        });
        this.M4 = stickyRecyclerHeadersDecoration;
        StickyRecyclerHeadersTouchListener stickyRecyclerHeadersTouchListener = new StickyRecyclerHeadersTouchListener(this.E4, stickyRecyclerHeadersDecoration);
        this.N4 = stickyRecyclerHeadersTouchListener;
        stickyRecyclerHeadersTouchListener.h(new StickyRecyclerHeadersTouchListener.OnHeaderClickListener() {
            public void a(View view, int i2, long j2) {
                String b1 = favoritesFragment.this.Q4.b1(((Bundle) ((favoritesFragment.this.B4 == null || favoritesFragment.this.B4.size() == 0) ? favoritesFragment.this.C4 : favoritesFragment.this.B4).get((int) j2)).getString("title"));
                if (favoritesFragment.this.L4.contains(b1)) {
                    favoritesFragment.this.L4.remove(b1);
                } else {
                    favoritesFragment.this.L4.add(b1);
                }
                favoritesFragment.this.E4.getAdapter().G();
            }
        });
        this.E4.s(this.N4);
        B3();
        this.E4.setLayoutManager(new LinearLayoutManager(r()));
        this.E4.setItemAnimator(new DefaultItemAnimator());
        this.E4.setItemDecoration(new CustomItemDecoration(r()));
        this.E4.setAdapter(this.A4);
        this.A4.Z(new RecyclerView.AdapterDataObserver() {
            public void a() {
                favoritesFragment.this.M4.n();
            }
        });
        o2(true);
        H3();
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.b(D3()).f(this.R4);
    }

    public void e3() {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter = this.E4.getAdapter();
        FavoriteAdapter favoriteAdapter = this.A4;
        if (adapter != favoriteAdapter) {
            B3();
            recyclerView = this.E4;
            favoriteAdapter = this.A4;
        } else {
            recyclerView = this.E4;
        }
        recyclerView.setAdapter(favoriteAdapter);
    }

    public void f3(String str) {
        try {
            if (!str.equals("Searching")) {
                this.M4.n();
                F3();
            }
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
        }
        this.E4.setLayoutManager(new LinearLayoutManager(r(), 1, false));
        this.E4.setAdapter(new StatusAdapter(r(), str));
    }

    public ArrayList<Bundle> i3() {
        ArrayList<Bundle> arrayList = CompressHelper.t;
        Log.e("Speed", "Favorites sortedDatabases");
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList2.add("WHEN '" + arrayList.get(i2).getString("Name").replace("'", "''") + "' THEN " + i2);
            }
        }
        if (arrayList2.size() <= 0) {
            return null;
        }
        String str = "case dbName " + StringUtils.join((Iterable<?>) arrayList2, StringUtils.SPACE) + " end";
        CompressHelper compressHelper = this.Q4;
        return compressHelper.Y(compressHelper.X0(), "select * from favorites order by " + str);
    }

    public int j3(int i2, ArrayList<Bundle> arrayList) {
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            Bundle bundle = arrayList.get(i4);
            i3 += this.L4.contains(bundle.getString("title")) ? 1 : bundle.getParcelableArrayList("items").size();
            if (i2 < i3) {
                return i4;
            }
        }
        return 0;
    }

    public Bundle k3(int i2, ArrayList<Bundle> arrayList) {
        Iterator<Bundle> it2 = arrayList.iterator();
        int i3 = 0;
        while (it2.hasNext()) {
            Bundle next = it2.next();
            String b1 = this.Q4.b1(next.getString("title"));
            int size = this.L4.contains(b1) ? 1 : next.getParcelableArrayList("items").size();
            i3 += size;
            if (i2 < i3) {
                int i4 = i2 - (i3 - size);
                Bundle bundle = new Bundle();
                bundle.putString("Database", this.Q4.b1(next.getString("title")));
                if (this.L4.contains(b1)) {
                    if (i4 == 0) {
                        return bundle;
                    }
                    i4--;
                }
                bundle.putBundle("Item", (Bundle) next.getParcelableArrayList("items").get(i4));
                return bundle;
            }
        }
        return null;
    }

    public void l1() {
        super.l1();
        V2();
    }

    public Bundle l3(int i2, ArrayList<Bundle> arrayList) {
        Iterator<Bundle> it2 = arrayList.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it2.hasNext()) {
            Bundle next = it2.next();
            if (i2 == i3) {
                Bundle bundle = new Bundle();
                bundle.putString("Title", this.Q4.b1(next.getString("title")));
                bundle.putInt("Row", 0);
                bundle.putInt("Section", i4);
                bundle.putInt("Row2", 1);
                bundle.putInt("Section2", i4 - 1);
                return bundle;
            }
            int size = i3 + next.getParcelableArrayList("items").size();
            if (i2 <= size) {
                int size2 = (i2 - (size - next.getParcelableArrayList("items").size())) - 1;
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("Item", (Bundle) next.getParcelableArrayList("items").get(size2));
                bundle2.putInt("Row", size2);
                bundle2.putInt("Section", i4);
                return bundle2;
            }
            i3 = size + 1;
            i4++;
        }
        return null;
    }

    public void m1(Bundle bundle) {
        super.m1(bundle);
    }

    public void m3() {
        this.C4 = E3();
        this.M4.n();
        B3();
        this.A4.G();
        H3();
    }
}
