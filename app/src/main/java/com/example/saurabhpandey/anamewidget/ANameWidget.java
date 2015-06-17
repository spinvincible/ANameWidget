package com.example.saurabhpandey.anamewidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;


public class ANameWidget extends AppWidgetProvider {


    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = ANameWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.aname_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);
//        Intent intent = new Intent(WIDGET_BUTTON);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

//    @Override
//    public void onReceive(Context context, Intent intent) {
//        super.onReceive(context, intent);
//        if (WIDGET_BUTTON.equals(intent.getAction())) {
//
//
//        }
//    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
                         int[] appWidgetIds)
    {
        for (int i = 0; i < appWidgetIds.length; i++) {
            int appWidgetId = appWidgetIds[i];
            // Create an Intent to launch ExampleActivity
//            Intent intent = new Intent(context, ANameWidgetConfigureActivity.class);
//            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            CharSequence widgetText = ANameWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.aname_widget);
            views.setTextViewText(R.id.appwidget_text, widgetText);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {

        Toast.makeText( context, "A Name Widget will miss you" , Toast.LENGTH_LONG).show();
//        final int N = appWidgetIds.length;
//        for (int i = 0; i < N; i++) {
//            ANameWidgetConfigureActivity.deleteTitlePref(context, appWidgetIds[i]);
//        }
    }

    @Override
    public void onEnabled(Context context) {
        Toast.makeText( context, "Thanks for choosing A Name Widget" , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDisabled(Context context) {
        Toast.makeText( context, "Thanks for choosing A Name Widget" , Toast.LENGTH_LONG).show();

    }


}




