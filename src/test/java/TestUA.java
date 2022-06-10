import cn.yview.ua.UADeviceModel;
import cn.yview.ua.UserAgentUtils;
import org.junit.Test;

public class TestUA {

    @Test
    public void testUA() {

        String ua = "Mozilla/5.0 (Linux; U; Android 11; zh-cn; ONEPLUS A6000 Build/RKQ1.201217.002) AppleWebKit/533.1 (KHTML, like Gecko) Mobile Safari/533.1";
        //String ua = "Dalvik/2.1.0 (Linux; U; Android 10; M2004J19C MIUI/V12.0.4.0.QJCCNXM)";
        UserAgentUtils userAgentUtils = new UserAgentUtils();
        UADeviceModel uaDeviceModel = userAgentUtils.analysisUA(ua);
        System.out.println(uaDeviceModel);
    }


}
