package testowanieObiektowe.navigation;

import testowanieObiektowe.configuration.AppProperties;

public class ApplicationURLs {

    public static final String APPLICATION_URL = AppProperties.getAllUrl();
    public static final String LOGIN_URL = APPLICATION_URL + "actions/Account.action?signonForm=";
    public static final String SHOPPING_CART_URL = APPLICATION_URL + "actions/Cart.action?addItemToCart=&workingItemId=EST-2";
}
