import cn.yview.ua.util.Html2PlainText;
import cn.yview.ua.util.MarkDown2Html;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class TestMd {
    @Test
    public void testMd() {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        System.out.println(path);
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("vivo.md");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
            List<String> list = reader.lines().collect(Collectors.toList());
            String content = list.stream().collect(Collectors.joining("\n"));
            //System.out.println(content);

            String html = MarkDown2Html.convert(content);
            //System.out.println(html);

            String text = Html2PlainText.convert(html);

            //System.out.println(text);
            URL resource = this.getClass().getResource("/");
            File file = new File(resource.getPath() + "/vivo.txt");
            FileUtils.write(file, text, StandardCharsets.UTF_8);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
