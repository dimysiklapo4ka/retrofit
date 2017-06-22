package com.example.d1mys1klapo4ka.retrofitandgson.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.d1mys1klapo4ka.retrofitandgson.R;
import com.example.d1mys1klapo4ka.retrofitandgson.retrofitModel.Agency;

import java.util.List;

public class AgencyAdapter extends ArrayAdapter<Agency>{

    List<Agency> agencies;
    Context context;
    private LayoutInflater inflater;

    public AgencyAdapter(@NonNull Context context, @NonNull List<Agency> objects) {
        super(context, 0, objects);

        this.agencies = objects;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Nullable
    @Override
    public Agency getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder vh;

        if (convertView == null){
            View view = inflater.inflate(R.layout.card_agencyes, parent, false);
            vh = ViewHolder.create((ConstraintLayout)view);
            view.setTag(vh);
        }else {
            vh = (ViewHolder)convertView.getTag();
        }

        Agency item = getItem(position);

        vh.mName.setText(item.getName());
        vh.mPrice.setText(item.getPrice());
        vh.mPhone.setText(item.getPhone());
        vh.mAddress.setText(item.getAddress());
        vh.mSchrdule.setText(item.getSchrdule());
        vh.mRequisites.setText(item.getRequisites());
        vh.mCreditCard.setText(item.getCreditCard());

        return vh.rootElement;
    }


    private static class ViewHolder{
        public final ConstraintLayout rootElement;
        public final TextView mName;
        public final TextView mPrice;
        public final TextView mPhone;
        public final TextView mAddress;
        public final TextView mSchrdule;
        public final TextView mRequisites;
        public final TextView mCreditCard;

        private ViewHolder(ConstraintLayout rootElement, TextView mName, TextView mPrice,
                           TextView mPhone, TextView mAddress, TextView mSchrdule,
                           TextView mRequisites, TextView mCreditCard) {
            this.rootElement = rootElement;
            this.mName = mName;
            this.mPrice = mPrice;
            this.mPhone = mPhone;
            this.mAddress = mAddress;
            this.mSchrdule = mSchrdule;
            this.mRequisites = mRequisites;
            this.mCreditCard = mCreditCard;
        }

        public static ViewHolder create(ConstraintLayout rootElement){

            TextView mName = (TextView) rootElement.findViewById(R.id.tv_name);
            TextView mPrice = (TextView) rootElement.findViewById(R.id.tv_price);
            TextView mPhone = (TextView) rootElement.findViewById(R.id.tv_phone);
            TextView mAddress = (TextView) rootElement.findViewById(R.id.tv_address);
            TextView mSchrdule = (TextView) rootElement.findViewById(R.id.tv_schrdule);
            TextView mRequisites = (TextView) rootElement.findViewById(R.id.tv_requisites);
            TextView mCreditCard = (TextView) rootElement.findViewById(R.id.tv_credit_card);

            return new ViewHolder(rootElement,mName,mPrice,mPhone,mAddress,mSchrdule,mRequisites,mCreditCard);
        }
    }
}
