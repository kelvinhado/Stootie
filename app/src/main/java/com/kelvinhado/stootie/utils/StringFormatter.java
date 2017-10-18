package com.kelvinhado.stootie.utils;

import android.content.Context;

import com.kelvinhado.stootie.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by kelvin on 18/10/2017.
 */

public class StringFormatter {

    public static String formatPrice(Context context, Double price) {
        return price != 0L ? Double.toString(price) + context.getString(R.string.local_money)
                : context.getString(R.string.money_free);
    }

    public static String formatDate(String date) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault());
        SimpleDateFormat outFormat = new SimpleDateFormat("EEEEEEEEE dd MMM", Locale.getDefault());
        try {
            Date result =  inFormat.parse(date);
            return outFormat.format(result);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String formatLastName(String lastName) {
        return lastName.substring(0, 1) + ".";
    }
}
