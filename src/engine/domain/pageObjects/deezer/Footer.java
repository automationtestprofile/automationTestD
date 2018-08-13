package engine.domain.pageObjects.deezer;

import engine.Driver;
import engine.Locatable;
import engine.enums.SearchBy;

import java.util.Locale;

public class Footer {
    public static Driver driver = new Driver();

    private final Locatable returnToMainPageFooterButton =
            new Locatable(SearchBy.CSSSELECTOR, ".footer .logo-deezer",
                    "Return to main page from footer");

    private final  Locatable facebookIcon =
            new Locatable(SearchBy.CLASSNAME, "svg-icon svg-icon-rounded-facebook",
                    "Idon for navigate to facebook page");

    private final  Locatable tweeterIcon =
            new Locatable(SearchBy.CLASSNAME, "svg-icon svg-icon-rounded-twitter",
                    "Icon for navigate to tweeter page");

    private final  Locatable youTubeIcon =
            new Locatable(SearchBy.CLASSNAME, "svg-icon svg-icon-rounded-youtube",
                    "Icon for navigate to YouTube page");

    private final  Locatable instagramIcon =
            new Locatable(SearchBy.CLASSNAME, "svg-icon svg-icon-rounded-instagram",
                    "Icon for navigate to Instagram page");

    private final  Locatable ratesLink =
            new Locatable(SearchBy.ID, "footer-link-offers",
                    "Link to page with rates");

    private final  Locatable posibilitiesLink =
            new Locatable(SearchBy.ID, "footer-link-features",
                    "Link to page with posibilities");

    private final  Locatable exploreChanelsLink =
            new Locatable(SearchBy.ID, "footer-link-explore",
                    "Link to page with all posibile chanels of music");

    private final  Locatable listOfDevicesLink =
            new Locatable(SearchBy.ID, "footer-link-devices",
                    "Link to page with all possibile supported devices");

    private final  Locatable blogLink =
            new Locatable(SearchBy.ID, "footer-link-blog",
                    "Link to page with blogs");

    private final  Locatable helpLink =
            new Locatable(SearchBy.ID, "footer-link-support",
                    "Link to Help page");

    private final  Locatable infoAboutLabelsLink =
            new Locatable(SearchBy.ID, "footer-link-label_artists",
                    "Link to page with information about artists and labels");

    private final  Locatable infoAboutPressLink =
            new Locatable(SearchBy.ID, "footer-link-press",
                    "Link to page with information about press");

    private final  Locatable infoAboutCompanyLink =
            new Locatable(SearchBy.ID, "footer-link-company",
                    "Link to page with information about Company");

    private final  Locatable jobOffersLink =
            new Locatable(SearchBy.ID, "footer-link-jobs",
                    "Link to page with information about vacancies");

    private final  Locatable rulesUsingLink =
            new Locatable(SearchBy.ID, "footer-link-cgu",
                    "Link to page with information about using and rules of product");

    private final  Locatable personalDataLink =
            new Locatable(SearchBy.ID, "footer-link-personal-datas",
                    "Link to page with information about all personal data of user");

    private final  Locatable contactMailLink =
            new Locatable(SearchBy.ID, "footer-link-contact",
                    "Link to new mail window");

    private final  Locatable legalDataLink =
            new Locatable(SearchBy.ID, "footer-link-legal",
                    "Link to page with information about all legal information");

    private final  Locatable privacySettingsLink =
            new Locatable(SearchBy.ID, "footer-link-cookie-preference",
                    "Link to popup with political agreedments about cookies and tracking technologies ");

    private final  Locatable langugeList =
            new Locatable(SearchBy.ID, "language_select",
                    "List for selecting the interface`s language");


}
