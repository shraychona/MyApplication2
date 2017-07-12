package com.shray.myapplication.helper;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by shray on 10-07-2017.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable drawable;

    public DividerItemDecoration(Drawable drawable) {
        this.drawable = drawable;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if(parent.getChildAdapterPosition(view)==0) {
            return;
        }
        outRect.top=drawable.getIntrinsicHeight();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int dividerLeft=parent.getPaddingLeft();
        int dividerRight=parent.getWidth()-parent.getPaddingRight();
        int dividerBottom,dividerTop;
        int count=parent.getChildCount();
        for(int i=0;i<count;i++) {
            View view=parent.getChildAt(i);
            RecyclerView.LayoutParams params= (RecyclerView.LayoutParams) view.getLayoutParams();

            dividerTop = view.getBottom() + params.bottomMargin;
            dividerBottom= dividerTop + drawable.getIntrinsicHeight();
            drawable.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom);
            drawable.draw(c);
            }

    }

}
