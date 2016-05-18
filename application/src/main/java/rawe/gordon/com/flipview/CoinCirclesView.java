package rawe.gordon.com.flipview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import rawe.gordon.com.flipview.grids.AbstractRecyclerGrid;

/**
 * Created by gordon on 5/12/16.
 */
public class CoinCirclesView extends AbstractRecyclerGrid<Object> {


    public CoinCirclesView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.layout_coin;
    }

    @Override
    protected int getColumnCount() {
        return 4;
    }

    @Override
    protected void bindViews(View view, Object model, Activity activity) {

    }
}
