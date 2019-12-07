package com.kurban.ribs.root;

import com.kurban.ribs.root.login.LoginBuilder;
import com.kurban.ribs.root.login.LoginRouter;
import com.uber.rib.core.ViewRouter;

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 * <p>
 * TODO describe the possible child configurations of this scope.
 */
public class RootRouter extends ViewRouter<RootView, RootInteractor, RootBuilder.Component> {

    private LoginBuilder loginBuilder;
    private LoginRouter loginRouter;

    public RootRouter(
            RootView view,
            RootInteractor interactor,
            RootBuilder.Component component,
            LoginBuilder loginBuilder) {
        super(view, interactor, component);
        this.loginBuilder = loginBuilder;
    }

    void attachLogin() {
        loginRouter = loginBuilder.build(getView());
        attachChild(loginRouter);
        getView().addView(loginRouter.getView());
    }

    void detachLogin() {
        detachChild(loginRouter);
        getView().removeView(loginRouter.getView());
    }
}
