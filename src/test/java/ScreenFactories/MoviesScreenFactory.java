package ScreenFactories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class MoviesScreenFactory {

    @AndroidFindBy(id = "btnHamburger")
    public MobileElement profileButton;

    @AndroidFindBy (id = "tvTitle")
    public MobileElement movieTitle;

    @AndroidFindBy (id = "iv_movie_date_active_select")
    public MobileElement movieDateActiveCheckMark;

    @AndroidFindBy (id = "tbButtonInterested")
    public MobileElement interestedButton;

}
