package rawe.gordon.com.flipview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import rawe.gordon.com.flipableview.AbstractFlipView;

/**
 * Created by gordon on 5/12/16.
 */
public class FlipView extends AbstractFlipView {

    public FlipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDirection(Direction.CLOCK_WISE);
    }

    @Override
    protected View getUpSideView() {
        View oneSide = LayoutInflater.from(getContext()).inflate(R.layout.layout_one_side, this, false);
        return oneSide;
    }

    @Override
    protected View getDownSideView() {
        View oneSide = LayoutInflater.from(getContext()).inflate(R.layout.layout_one_side, this, false);
        return oneSide;
    }

    @Override
    protected int getUpSidePadding() {
        return 0;
    }

    @Override
    protected int getDownSidePadding() {
        return 0;
    }
}
