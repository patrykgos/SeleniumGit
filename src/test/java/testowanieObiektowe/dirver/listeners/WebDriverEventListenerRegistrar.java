package testowanieObiektowe.dirver.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class WebDriverEventListenerRegistrar {

    public synchronized static WebDriver registerWebDriverEventListener(WebDriver driver) {

        DriverEventListener driverEventListener = new DriverEventListener();

        EventFiringDecorator<WebDriver> eventFiringDecorator = new EventFiringDecorator<>(driverEventListener);

        return eventFiringDecorator.decorate(driver);
    }

}
