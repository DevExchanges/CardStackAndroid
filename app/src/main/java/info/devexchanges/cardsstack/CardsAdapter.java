package info.devexchanges.cardsstack;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class CardsAdapter extends ArrayAdapter<CardItem> {

    private Activity activity;
    private List<CardItem> cardItems;

    public CardsAdapter(Activity activity, int resource, List<CardItem> cards) {
        super(activity, resource);
        this.activity = activity;
        this.cardItems = cards;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_card, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "You liked it!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "You loved it!", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    private class ViewHolder {
        private ImageView imageView;
        private View btnLike;
        private View btnLove;

        public ViewHolder(View view) {
            btnLike = view.findViewById(R.id.like);
            btnLove = view.findViewById(R.id.love);
            imageView = (ImageView) view.findViewById(R.id.image_view);
        }
    }
}
