package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/credential.properties"})
public interface BrowserstackConfig extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("baseURL")
    String baseURL();

    @Key("appURL")
    String appURL();

    @Key("device")
    String device();

    @Key("os_version")
    String os_version();
}

