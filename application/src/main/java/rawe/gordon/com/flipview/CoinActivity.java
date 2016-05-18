package rawe.gordon.com.flipview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;

public class CoinActivity extends AppCompatActivity {
    private CoinCirclesView circlesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coins);
        circlesView = (CoinCirclesView) findViewById(R.id.coins);
        circlesView.initialize(Arrays.asList(new Object(), new Object(),
                new Object(), new Object(), new Object(), new Object()
        ), this);
        circlesView.setColumnCount(4);
    }
}
