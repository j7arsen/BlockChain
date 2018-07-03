package blockchain.j7arsen.com.blockchain.base;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends MvpAppCompatActivity {

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnbinder = ButterKnife.bind(this);
    }

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
