package blockchain.j7arsen.com.blockchain.utils.screen.creator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import blockchain.j7arsen.com.blockchain.base.BaseFragment;

public interface IScreenCreator {

    void startActivity(Activity activity, Class initClass);

    void startActivity(Fragment fragment, Activity activity, Class initClass);

    void startActivity(Activity activity, Class initClass, int requestCode);

    void startActivity(Fragment fragment, Activity activity, Class initClass, int requestCode);

    void startActivity(Activity activity, Class initClass, Bundle bundle);

    void startActivity(Fragment fragment, Activity activity, Class initClass, Bundle bundle);

    void startActivity(Activity activity, Class initClass, Bundle bundle, int requestCode);

    void startActivity(Fragment fragment, Activity activity, Class initClass, Bundle bundle, int requestCode);

    <T extends BaseFragment> T newInstance(Class<T> mClass);

    <T extends BaseFragment> T newInstance(Class<T> mClass, Bundle bundle);

}
