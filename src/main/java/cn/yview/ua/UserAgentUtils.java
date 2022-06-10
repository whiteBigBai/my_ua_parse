package cn.yview.ua;

import cn.hutool.core.util.StrUtil;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserAgentUtils {
    private static final Pattern pattern = Pattern.compile("(?<=\\()(.+)(?=\\))");

    public UADeviceModel analysisUA(String userAgent) {
        UADeviceModel uaDeviceModel = new UADeviceModel();
        if (StrUtil.isBlank(userAgent)) {
            return uaDeviceModel;
        } else {
            String[] strings = userAgent.split("\\)");
            List<String> list = Arrays.asList(strings)
                    .stream()
                    .map(tmp -> tmp += ")")
                    .filter(tmp -> StrUtil.contains(tmp, ";"))
                    .collect(Collectors.toList());

            if (list.size() > 0) {
                String str = list.get(0);
                Matcher mat = pattern.matcher(str);
                if (mat.find()) {
                    String group = mat.group();

                    List<String> asList = Arrays.asList(group.split(";"));
                    System.out.println(asList);
                } else {
                    return uaDeviceModel;
                }
            } else {
                return uaDeviceModel;
            }
        }
        return uaDeviceModel;
    }
}
