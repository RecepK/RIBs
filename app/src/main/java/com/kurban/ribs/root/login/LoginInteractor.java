package com.kurban.ribs.root.login;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kurban.ribs.R;
import com.uber.rib.core.Bundle;
import com.uber.rib.core.Interactor;
import com.uber.rib.core.RibInteractor;

import javax.inject.Inject;

/**
 * Coordinates Business Logic for {@link LoginScope}.
 * <p>
 * TODO describe the logic of this scope.
 */
@RibInteractor
public class LoginInteractor
        extends Interactor<LoginInteractor.LoginPresenter, LoginRouter> {

    @Inject
    LoginPresenter presenter;

    @Override
    protected void didBecomeActive(@Nullable Bundle savedInstanceState) {
        super.didBecomeActive(savedInstanceState);
        Log.d("LoginInteractor", "didBecomeActive");

        Context context = presenter.getContext();

        String msg = context.getString(R.string.hello_world);

        presenter.setText(msg);

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void willResignActive() {
        super.willResignActive();
        Log.d("LoginInteractor", "willResignActive");
    }


    /**
     * Presenter interface implemented by this RIB's view.
     */
    interface LoginPresenter {
        Context getContext();

        void setText(@NonNull String value);
    }
}
