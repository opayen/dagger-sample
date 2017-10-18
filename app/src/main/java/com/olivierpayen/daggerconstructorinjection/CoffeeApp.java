package com.olivierpayen.daggerconstructorinjection;

import android.app.Application;

import com.olivierpayen.daggerconstructorinjection.coffee.CoffeeMaker;
import com.olivierpayen.daggerconstructorinjection.coffee.DripCoffeeModule;

import javax.inject.Singleton;

import dagger.Component;

public class CoffeeApp extends Application {
    private final CoffeeShop coffeeShop = createCoffeeShop();

    @Singleton
    @Component(modules = { DripCoffeeModule.class })
    public interface CoffeeShop {
        CoffeeMaker maker();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        coffeeShop.maker().brew();
    }

    private static CoffeeShop createCoffeeShop() {
        return DaggerCoffeeApp_CoffeeShop.create();
    }
}