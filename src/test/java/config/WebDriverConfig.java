package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/local.properties")
public interface WebDriverConfig extends Config {
    @Key("browser.name")
    @DefaultValue("firefox")
    String browserName();

    @Key("browser.version")
    @DefaultValue("99.0")
    String browserVersion();

    @Key("browser.size")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browser.remote.url")
    String browserRemoteUrl();

    @Key("page.load.strategy")
    @DefaultValue("eager")
    String pageLoadStrategy();
}
