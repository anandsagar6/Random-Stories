package com.example.datingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> cardData;

    public CardAdapter(Context context, List<String> cardData) {
        super(context, R.layout.card_item, cardData);
        this.context = context;
        this.cardData = cardData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.card_title);
        textView.setText(cardData.get(position));

        return convertView;
    }
}
