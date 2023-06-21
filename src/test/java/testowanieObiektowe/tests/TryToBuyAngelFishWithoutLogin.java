package testowanieObiektowe.tests;

import org.testng.annotations.Test;
import testowanieObiektowe.dirver.DriverUtils;
import testowanieObiektowe.page.objects.ShoppingCartPage;
import static testowanieObiektowe.navigation.ApplicationURLs.SHOPPING_CART_URL;
import static org.testng.Assert.assertEquals;

public class TryToBuyAngelFishWithoutLogin extends TestBase{

    @Test
    public void tryToBuyAngelFishWithoutLogin(){
        DriverUtils.navigateToPage(SHOPPING_CART_URL);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage
                .clickProceedToCheckOutLink()
                .assertThatWarningIsDisplayed("You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
}
