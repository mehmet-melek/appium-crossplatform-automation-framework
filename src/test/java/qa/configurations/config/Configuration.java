package qa.configurations.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:conf/general.properties",
        "classpath:conf/android.properties",
        "classpath:conf/ios.properties"})

public interface Configuration extends Config {

    @Key("run.ip")
    String serverIp();

    @Key("run.port")
    String serverPort();

    @Key("ios.app.path")
    String iosAppPath();

    @Key("ios.app.appName")
    String iosAppName();

    @Key("ios.device.name")
    String iosDeviceName();

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
