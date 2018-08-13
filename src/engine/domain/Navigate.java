package engine.domain;

import engine.Driver;
import engine.domain.pageObjects.deezer.WelcomePage;

public final class Navigate {
    final static String URL ="https://www.deezer.com";

    public static WelcomePage navigateToDeezerApp(){
     Driver.load(URL);
     return new WelcomePage();
    }
}
