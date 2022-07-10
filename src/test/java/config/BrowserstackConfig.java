package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/credentials.properties"})
public interface BrowserstackConfig extends Config {

    @Key("browserstack.user")
    String login();

    @Key("browserstack.key")
    String password();

    @Key("app")
    String appURL();

    @Key("device")
    String device();

    @Key("os_version")
    String os_version();

    @Key("baseURL")
    String baseURL();

}

