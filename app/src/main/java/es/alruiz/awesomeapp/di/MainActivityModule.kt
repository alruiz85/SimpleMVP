package es.alruiz.awesomeapp.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class MainActivityModule {

    //TIP
    //Place MainActivity dependencies here
    //@Provides
    //@ActivityScoped
    //internal fun provideMainView(@ActivityContext context: Context): MainView = context as MainView

}