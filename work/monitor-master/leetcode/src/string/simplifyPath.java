package string;

/**
 * @ClassName simplifyPath
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/29 14:40
 * @Version 1.0
 */
public class simplifyPath {
    public String simplifyPath(String path) {
        if (path.length() <= 1) {
            return "/";
        }
        StringBuilder pathTemp = new StringBuilder(path);
        // 去掉多余的"/./"变成 "//"
        deleteDotSlash(pathTemp);
        // 去多余斜杠.
        deleteSlash(pathTemp);
        // 按照路径去掉"../"
        return deleteDotDotSlash(pathTemp);
    }

    private String deleteDotDotSlash(StringBuilder pathTemp) {
        String temp = pathTemp.toString();
        String[] pathes = temp.split("/");
        int[] paths = new int[pathes.length];
        int capOfPaths = 0;
        for (int i = 0; i < pathes.length; i++) {
            if (pathes[i].equals("..")) {
                capOfPaths = (capOfPaths != 0 ? --capOfPaths : 0);
            } else {
                paths[capOfPaths++] = i;
            }
        }

        StringBuilder resPath = new StringBuilder();
        for (int i = 0; i < capOfPaths; i++) {
            resPath.append("/").append(pathes[paths[i]]);
        }
        if (resPath.length() == 0) {
            return "/";
        }
        deleteSlash(resPath);
        if (resPath.length() == 0) {
            return "/";
        }
        return resPath.toString();
    }

    private void deleteDotSlash(StringBuilder pathTemp) {
        int len = pathTemp.length();
        for (int i = len - 1; i > 0; i--) {
            // "/./"
            if (pathTemp.charAt(i) == '.') {
                if (i == len - 1 && pathTemp.charAt(i - 1) != '.') {
                    pathTemp.deleteCharAt(i);
                } else if (pathTemp.charAt(i - 1) == '/' && pathTemp.charAt(i + 1) == '/') {
                    pathTemp.deleteCharAt(i);
                }
            }
        }
    }

    private void deleteSlash(StringBuilder pathTemp) {
        if (pathTemp.charAt(pathTemp.length() - 1) == '/') {
            pathTemp.deleteCharAt(pathTemp.length() - 1);
        }
        for (int i = pathTemp.length() - 1; i > 0; i--) {
            // 遇到 "//" ，就删掉"/"
            if (pathTemp.charAt(i) == pathTemp.charAt(i - 1) && pathTemp.charAt(i - 1) == '/') {
                pathTemp.deleteCharAt(i);
            }
        }
    }
}
