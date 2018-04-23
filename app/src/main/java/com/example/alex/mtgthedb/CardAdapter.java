package com.example.alex.mtgthedb;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    List<Card> returnedCards;

    public CardAdapter(List<Card> browseCards) {
        this.returnedCards = browseCards;
    }
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardAdapter.ViewHolder holder, int position) {
        holder.fCardName.setText(returnedCards.get(position).getName()  + "\nType: " + returnedCards.get(position).getType() + "\nQuantity: "
                + returnedCards.get(position).getQuantity() + "\nDeck Quantity: " + returnedCards.get(position).getDeckQuantity() + "\n\n");
    }

    @Override
    public int getItemCount() {
        return returnedCards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView fCardName;
        public ViewHolder(View itemView) {
            super(itemView);

            fCardName = itemView.findViewById(R.id.FCardName);
        }
    }
}


