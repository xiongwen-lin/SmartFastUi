
package com.apemans.quickui.recyclerview;


import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Description: RecyclerView 设置item之间的间距
 * Reference: https://www.jianshu.com/p/e372cec819db
 * NOTE:不支持GridLayout + Header 分组
 * Usage:
 * int spacing = DisplayHelper.dp2px(context,2);
 * boolean includeEdge = true;
 * recyclereView.addItemDecoration(new SpacesGridItemDecoration(SPAN_COUNT, spacing, includeEdge));
 */
public class SpacesGridItemDecoration extends RecyclerView.ItemDecoration {
    private final int spanCount; //列数
    private final int spacing; //间距 px
    private final boolean includeEdge; //是否包含边缘

    public SpacesGridItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, RecyclerView parent, @NonNull RecyclerView.State state) {
        //这里是关键，需要根据你有几列来判断
        int position = parent.getChildAdapterPosition(view); // item position
        int column = position % spanCount; // item column

        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
            outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

            if (position < spanCount) { // top edge
                outRect.top = spacing;
            }
            outRect.bottom = spacing; // item bottom
        } else {
            outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing; // item top
            }
        }
    }
}