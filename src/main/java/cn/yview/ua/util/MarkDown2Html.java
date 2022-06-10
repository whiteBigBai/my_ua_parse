package cn.yview.ua.util;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.io.InputStream;

public class MarkDown2Html {
    public static String convert(String md) {
        MutableDataSet options = new MutableDataSet();
        Parser parser = Parser.builder(options).build();
        HtmlRenderer htmlRenderer = HtmlRenderer.builder(options).build();
        Node document = parser.parse(md);
        String html = htmlRenderer.render(document);
        return html;
    }
}
