package com.example.saurabhpandey.anamewidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.TextView;


/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in {@link ANameWidgetConfigureActivity ANameWidgetConfigureActivity}
 */
public class ANameWidget extends AppWidgetProvider {


//    public static String WIDGET_BUTTON = "com.example.saurabhpandey.anamewidget.WIDGET_BUTTON";
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = ANameWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.aname_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);
//        Intent intent = new Intent(WIDGET_BUTTON);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);

        // Instruct the widget manager to update the widget
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

            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            CharSequence widgetText = ANameWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.aname_widget);
            views.setTextViewText(R.id.appwidget_text, widgetText);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
//        final int N = appWidgetIds.length;
//        for (int i = 0; i < N; i++) {
//            ANameWidgetConfigureActivity.deleteTitlePref(context, appWidgetIds[i]);
//        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }


}




