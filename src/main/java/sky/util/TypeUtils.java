package sky.util;

import java.io.File;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/2/24 0024
 * Time: 22:35
 * To change this template use FileMode | Settings | FileMode Templates.
 */
public class TypeUtils {

    private static Map<String, HashSet<String>> suffix = new HashMap<String, HashSet<String>>() {{
        put("text", new HashSet<String>(Arrays.asList("doc", "pdf", "txt", "rm")));
        put("music", new HashSet<String>(Arrays.asList("ape", "mp3", "wma")));
        put("video", new HashSet<String>(Arrays.asList("3gp", "avi", "mp4", "mpeg", "rmvb")));
        put("image", new HashSet<String>(Arrays.asList("bmp", "gif", "jpeg", "jpg", "png", "webp")));
    }};

    public static String typ(String type) {
        int i = type.lastIndexOf(".");
        String postfix = type.substring(i + 1);
        for (Map.Entry<String, HashSet<String>> entry : suffix.entrySet()) {
            if (entry.getValue().contains(postfix)) {
                return entry.getKey();
            }

        }
        return "none";
    }

    public static String doDir(String dir) {
        File file = new File(dir);
        if (file.isDirectory()) {

            return doDir(file.getPath());
        }
        System.out.println(file);
        return file.getName();
    }
}
