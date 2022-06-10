package cn.yview.ua;

import cn.hutool.core.util.StrUtil;
import cn.yview.ua.util.Html2PlainText;
import cn.yview.ua.util.MarkDown2Html;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Markdown2Text {
    public static void main(String[] args) {
        String path = Markdown2Text.class.getClassLoader().getResource("").getPath();
        File dir = new File(path);
        List<File> fileList = Arrays.asList(dir.listFiles())
                .stream()
                .filter(f -> StrUtil.endWith(f.getName(), ".md"))
                .collect(Collectors.toList());
        List<String> allPhoneModel = new ArrayList<>();
        fileList.forEach(file -> {
            try {
                FileInputStream stream = new FileInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
                List<String> list = reader.lines().collect(Collectors.toList());
                String content = list.stream().collect(Collectors.joining("\n"));
                //System.out.println(content);

                String html = MarkDown2Html.convert(content);
                //System.out.println(html);

                String text = Html2PlainText.convert(html);

                //System.out.println(text);
                String fileName = StrUtil.replace(file.getName(), ".md", ".txt");
                File txtFile = new File(file.getParent() + File.separator + fileName);
                FileUtils.write(txtFile, text, StandardCharsets.UTF_8);
                List<String> strings = FileUtils.readLines(txtFile, StandardCharsets.UTF_8);
                String collect = strings.stream()
                        .filter(str -> {
                                    return StrUtil.isNotBlank(str)
                                            && !StrUtil.endWith(str.trim(), ":")
                                            && StrUtil.contains(str, ":")
                                            && !StrUtil.contains(str, "汇总范围")
                                            && !StrUtil.contains(str, "codename")
                                            && !StrUtil.contains(str, "是否包含海外机型");
                                }
                        ).collect(Collectors.joining("\n"));
                allPhoneModel.add(collect);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        File file = new File(dir.getPath() + File.separator + "all.txt");
        String all = allPhoneModel.stream().collect(Collectors.joining("\n"));
        try {
            FileUtils.write(file, all, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
