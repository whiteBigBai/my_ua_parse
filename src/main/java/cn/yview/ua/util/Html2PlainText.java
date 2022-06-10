package cn.yview.ua.util;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

public class Html2PlainText {
    public static String convert(String html) {
        if (StrUtil.isBlank(html)) {
            return "";
        } else {
            Document document = Jsoup.parse(html);
            Document.OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);
            document.outputSettings(outputSettings);
            document.select("br").append("\\n");
            document.select("p").append("\\n");
            document.select("p").append("\\n");
            String newHtml = document.html().replaceAll("\\\\n", "\n");
            String plainText = Jsoup.clean(newHtml, "", Whitelist.none(), outputSettings);
            String result = StringEscapeUtils.unescapeHtml(plainText.trim());
            return result;
        }
    }
}
