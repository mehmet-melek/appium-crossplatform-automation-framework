package qa.configurations.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configurations/general.properties",
        "classpath:configurations/android.properties",
        "classpath:configurations/ios.properties"})

public interface Configuration extends Config {

    @Key("server.uri")
    String serverUri();

    @Key("ios.app.path")
    String iosAppPath();

    @Key("ios.device.name")
    String iosDeviceName();

    @Key("ios.platform.version")
    String iosPlatformVersion();

    @Key("android.app.path")
    String androidAppPath();

    @Key("android.app.appPackage")
    String androidAppPackage();

    @Key("android.app.appActivity")
    String androidAppActivity();

    @Key("android.device.name")
    String androidDeviceName();

    @Key("android.platform.version")
    String androidPlatformVersion();


}
