package net.imedicaldoctor.imd.ViewHolders;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.imedicaldoctor.imd.R;

public class MessageViewHolder extends RecyclerView.ViewHolder {
    public TextView I;
    public ImageView J;

    public MessageViewHolder(Context context, View view) {
        super(view);
        this.I = (TextView) view.findViewById(R.id.f1132text_view);
        this.J = (ImageView) view.findViewById(R.id.f980image_view);
        this.I.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/HelveticaNeue-Light.otf"));
    }
}
