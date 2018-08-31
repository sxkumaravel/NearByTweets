package com.kumars.nearbytweets.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.widget.Toast;

import com.kumars.nearbytweets.viewmodel.BaseViewModel;
import com.kumars.nearbytweets.viewmodel.IView;

/**
 *
 *
 */

public abstract class BaseActivity<B extends ViewDataBinding, T extends BaseViewModel> extends Activity implements IView {

    protected T mViewModel;
    B mBinding;

    /**
     * ViewModel must be initialized before bindView() is called
     *
     * @param layout layout for the activity
     */
    protected final void bindView(int layout) {
        if (mViewModel == null) {
            throw new IllegalStateException("mViewModel must not be null and should be injected via activityComponent().inject(this)");
        }
        mBinding = DataBindingUtil.setContentView(this, layout);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewModel.clearSubscriptions();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewModel.detach();
    }

    @Override
    public void error(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void error() {
        Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
    }
}
