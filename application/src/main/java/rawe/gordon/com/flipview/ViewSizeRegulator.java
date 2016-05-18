package rawe.gordon.com.flipview;

import android.util.Log;
import android.view.View;

/**
 * Created by gordon on 16/5/7.
 */
public class ViewSizeRegulator {

    public static void regulateViewRatio(final View view, final float ratio) throws Exception {
        if (view != null) view.post(new Runnable() {
            @Override
            public void run() {
                view.getLayoutParams().height = (int) (view.getWidth() / ratio);
                view.requestLayout();
                if (view.getWidth() == 0)
                    Log.e("ViewSizeRegulator", "regulateViewRatio failed to regulate view size");
            }
        });
    }
}
