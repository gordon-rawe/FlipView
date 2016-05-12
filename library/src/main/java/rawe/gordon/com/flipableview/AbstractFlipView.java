package rawe.gordon.com.flipableview;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * Created by gordon on 5/12/16.
 */
public abstract class AbstractFlipView extends LinearLayout implements View.OnClickListener {
    private View rootView;
    private ViewGroup upSideContainer, downSideContainer;
    private boolean isUpSide = true;
    private Direction direction;

    public AbstractFlipView(Context context, AttributeSet attrs) {
        super(context, attrs);
        rootView = LayoutInflater.from(getContext()).inflate(R.layout.flip_card, this);
        upSideContainer = (ViewGroup) rootView.findViewById(R.id.up_side);
        downSideContainer = (ViewGroup) rootView.findViewById(R.id.down_side);
        upSideContainer.addView(getUpSideView());
        downSideContainer.addView(getDownSideView());
        setDirection(Direction.CLOCK_WISE);
        setOnClickListener(this);
        setCameraDistance();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        if (direction == Direction.CLOCK_WISE) {
            setAnimatorsClockWise();
        } else {
            setAnimatorsAntiClockWise();
        }
    }

    private AnimatorSet rightOutAnimator; // 右出动画
    private AnimatorSet leftInAnimator; // 左入动画
    private AnimatorSet leftOutAnimator; // 左出动画
    private AnimatorSet rightInAnimator; // 右入动画

    @Override
    public void onClick(View view) {
        if (direction == Direction.CLOCK_WISE) flipCardClockWise();
        else flipCardAntiClockWise();
    }

    // 改变视角距离, 贴近屏幕
    private void setCameraDistance() {
        int distance = 1500;
        float scale = getResources().getDisplayMetrics().density * distance;
        upSideContainer.setCameraDistance(scale);
        downSideContainer.setCameraDistance(scale);
    }

    private void setAnimatorsClockWise() {
        rightOutAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.anim_out);
        leftInAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.anim_in);
    }

    private void setAnimatorsAntiClockWise() {
        leftOutAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.anim_out_reverse);
        rightInAnimator = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.anim_in_revervse);
    }

    protected abstract View getUpSideView();

    protected abstract View getDownSideView();

    // 翻转卡片
    public void flipCardClockWise() {
        // 正面朝上
        if (!isUpSide) {
            rightOutAnimator.setTarget(upSideContainer);
            leftInAnimator.setTarget(downSideContainer);
            rightOutAnimator.start();
            leftInAnimator.start();
            isUpSide = true;
        } else { // 背面朝上
            rightOutAnimator.setTarget(downSideContainer);
            leftInAnimator.setTarget(upSideContainer);
            rightOutAnimator.start();
            leftInAnimator.start();
            isUpSide = false;
        }
    }

    public void flipCardAntiClockWise() {
        // 正面朝上
        if (!isUpSide) {
            leftOutAnimator.setTarget(upSideContainer);
            rightInAnimator.setTarget(downSideContainer);
            leftOutAnimator.start();
            rightInAnimator.start();
            isUpSide = true;
        } else { // 背面朝上
            leftOutAnimator.setTarget(downSideContainer);
            rightInAnimator.setTarget(upSideContainer);
            leftOutAnimator.start();
            rightInAnimator.start();
            isUpSide = false;
        }
    }

    public enum Direction {
        CLOCK_WISE, ANTI_CLOCK_WISE
    }
}
