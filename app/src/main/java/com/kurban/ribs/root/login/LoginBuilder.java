package com.kurban.ribs.root.login;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kurban.ribs.R;
import com.uber.rib.core.InteractorBaseComponent;
import com.uber.rib.core.ViewBuilder;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;
import javax.inject.Scope;

import dagger.Binds;
import dagger.BindsInstance;
import dagger.Provides;

import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Builder for the {@link LoginScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
public class LoginBuilder
    extends ViewBuilder<LoginView, LoginRouter, LoginBuilder.ParentComponent> {

  public LoginBuilder(ParentComponent dependency) {
    super(dependency);
  }

  /**
   * Builds a new {@link LoginRouter}.
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new {@link LoginRouter}.
   */
  public LoginRouter build(ViewGroup parentViewGroup) {
    LoginView view = createView(parentViewGroup);
    LoginInteractor interactor = new LoginInteractor();
    Component component = DaggerLoginBuilder_Component.builder()
        .parentComponent(getDependency())
        .view(view)
        .interactor(interactor)
        .build();
    return component.loginRouter();
  }

  @Override
  protected LoginView inflateView(LayoutInflater inflater, ViewGroup parentViewGroup) {
      return (LoginView) inflater.inflate(R.layout.rib_login, parentViewGroup, false);
  }

  public interface ParentComponent {
    // TODO: Define dependencies required from your parent interactor here.
  }

  @dagger.Module
  public abstract static class Module {

    @LoginScope
    @Binds
    abstract LoginInteractor.LoginPresenter presenter(LoginView view);

    @LoginScope
    @Provides
    static LoginRouter router(
      Component component,
      LoginView view,
      LoginInteractor interactor) {
      return new LoginRouter(view, interactor, component);
    }

    // TODO: Create provider methods for dependencies created by this Rib. These should be static.
  }

  @LoginScope
  @dagger.Component(modules = Module.class,
       dependencies = ParentComponent.class)
  interface Component extends InteractorBaseComponent<LoginInteractor>, BuilderComponent {

    @dagger.Component.Builder
    interface Builder {
      @BindsInstance
      Builder interactor(LoginInteractor interactor);
      @BindsInstance
      Builder view(LoginView view);
      Builder parentComponent(ParentComponent component);
      Component build();
    }
  }

  interface BuilderComponent  {
    LoginRouter loginRouter();
  }

  @Scope
  @Retention(CLASS)
  @interface LoginScope { }

  @Qualifier
  @Retention(CLASS)
  @interface LoginInternal { }
}
