package com.gmail.vtc.vlado.musicalstructure;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by user on 12.3.2018..
 */

public class RecyclerItemListener implements RecyclerView.OnItemTouchListener {

    private RecyclerTouchListener listener;
    private GestureDetector gestureDetector;

    public interface RecyclerTouchListener {
        public void onClickItem(View view, int position);

        public void onLongClickItem(View view, int position);

    }

    public RecyclerItemListener(Context ctx, final RecyclerView rv, final RecyclerTouchListener listener) {
        this.listener = listener;
        gestureDetector = new GestureDetector(ctx, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public void onLongPress(MotionEvent e) {

                View v = rv.findChildViewUnder(e.getX(), e.getY());

                listener.onLongClickItem(v, rv.getChildAdapterPosition(v));


            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {

                View v = rv.findChildViewUnder(e.getX(), e.getY());
                listener.onClickItem(v, rv.getChildAdapterPosition(v));

                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        return (child != null && gestureDetector.onTouchEvent(e));
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
