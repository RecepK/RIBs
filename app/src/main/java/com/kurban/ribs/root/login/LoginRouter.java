package com.kurban.ribs.root.login;

import com.uber.rib.core.ViewRouter;

/**
 * Adds and removes children of {@link LoginBuilder.LoginScope}.
 * <p>
 * TODO describe the possible child configurations of this scope.
 */
public class LoginRouter extends
        ViewRouter<LoginView, LoginInteractor, LoginBuilder.Component> {

    public LoginRouter(
            LoginView view,
            LoginInteractor interactor,
            LoginBuilder.Component component) {
        super(view, interactor, component);
    }
}
