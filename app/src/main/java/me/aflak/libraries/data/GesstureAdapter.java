package me.aflak.libraries.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.aflak.libraries.R;

public class GesstureAdapter {
    /*
     * RecyclerView.Adapter
     * RecyclerView.ViewHolder
     * */
    public class GestureAdapter extends RecyclerView.Adapter<GestureAdapter.GestureViewHolder> {

        private Context mCtx;
        private List<Gesture_my> gesturesList;

        public GestureAdapter(Context mCtx, List<Gesture_my> gesturesList) {
            this.mCtx = mCtx;
            this.gesturesList = gesturesList;
        }


        @Override
        public GestureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mCtx);
            View view = inflater.inflate(R.layout.gestures_lest_layout, null);
            GestureViewHolder holder = new GestureViewHolder(view);
            return new GestureViewHolder(view);
        }

        @Override
        public void onBindViewHolder(GestureViewHolder holder, int position) {
            Gesture_my gesture = gesturesList.get(position);

            holder.textViewTitle.setText(gesture.getTitle());
            holder.textViewInfo.setText(gesture.getInfo());
            holder.textViewRating.setText(String.valueOf(gesture.getRating()));
            holder.textViewPrice.setText(String.valueOf(gesture.getPrise()));

            holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(gesture.getImage()));
        }

        @Override
        public int getItemCount() {
            return gesturesList.size();
        }

        class GestureViewHolder extends RecyclerView.ViewHolder{

            ImageView imageView;
            TextView textViewName, textViewInfo, textViewTitle, textViewRating, textViewPrice;

            public GestureViewHolder(View itemView) {
                super(itemView);

                imageView = imageView.findViewById(R.id.imageView);
                textViewTitle = itemView.findViewById(R.id.textViewTitle);
                textViewInfo = itemView.findViewById(R.id.textViewShortDesc);
                textViewRating = itemView.findViewById(R.id.textViewRating);
                textViewPrice = itemView.findViewById(R.id.textViewPrice);
            }
        }
    }
}
