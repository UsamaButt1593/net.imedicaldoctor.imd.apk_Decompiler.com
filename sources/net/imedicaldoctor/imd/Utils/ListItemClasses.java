package net.imedicaldoctor.imd.Utils;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import net.imedicaldoctor.imd.R;

public class ListItemClasses {

    public class DatabaseViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f30426a;

        /* renamed from: b  reason: collision with root package name */
        public final ImageView f30427b;

        public DatabaseViewHolder(View view) {
            this.f30426a = (TextView) view.findViewById(R.id.f896database_title);
            this.f30427b = (ImageView) view.findViewById(R.id.f893database_image);
        }
    }

    public class HeaderViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f30429a;

        public HeaderViewHolder(View view) {
            this.f30429a = (TextView) view.findViewById(R.id.f957header_text);
        }
    }

    public class InteractionViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f30431a;

        /* renamed from: b  reason: collision with root package name */
        public final ImageView f30432b;

        /* renamed from: c  reason: collision with root package name */
        public final TextView f30433c;

        public InteractionViewHolder(View view) {
            this.f30433c = (TextView) view.findViewById(R.id.f1098subtitle_text);
            this.f30431a = (TextView) view.findViewById(R.id.f1136title_text);
            this.f30432b = (ImageView) view.findViewById(R.id.image);
        }
    }
}
