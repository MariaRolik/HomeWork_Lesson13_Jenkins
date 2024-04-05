package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/driver.properties")
public interface DriverConfig extends Config {
    @Key("browser.name")
    @DefaultValue("chrome")
    String browserName();
    @Key("browser.version")
    @DefaultValue("100")
    String browserVersion();
    @Key("browser.size")
    @DefaultValue("1920x1080")
    String browserSize();
    @Key("browser.remote.url")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String browserRemoteUrl();
    @Key("browser.page.Load.Strategy")
    @DefaultValue("eager")
    String pageLoadStrategy();

}
