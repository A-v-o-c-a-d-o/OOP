import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week10 {
    /** Function. */
    public static List<String> getAllFunctions(String fileContent) {
        Pattern pattern;
        Matcher matcher;
        List<String> importList = new ArrayList<>();
        String packageName = "";
        List<String> classList = new ArrayList<>();
        List<String> methodList = new ArrayList<>();
        String cmtRe = "//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/";
        fileContent = fileContent.replaceAll(cmtRe, "");

        //find all import
        String importRe = "(?:import|package)\\s+(static\\s+)*[a-zA-Z][a-zA-Z0-9_]*"
                + "(\\.[a-zA-Z0-9_]+)*[0-9a-zA-Z_]*;";
        pattern = Pattern.compile(importRe);
        matcher = pattern.matcher(fileContent);
        while (matcher.find()) {
            String[] a = matcher.group().split(" ");
            if (a[0].equals("import")) {
                importList.add(a[1].substring(0, a[1].length() - 1));
            } else {
                packageName = a[1].substring(0, a[1].length() - 1);
            }
        }

        // find all class
        String classRe = "class [a-zA-Z][a-zA-Z0-9_]*";
        pattern = Pattern.compile(classRe);
        matcher = pattern.matcher(fileContent);
        while (matcher.find()) {
            classList.add(matcher.group().split(" ")[1]);
        }

        //find all signature
        String methodName = "[\\$_\\w]+";
        String methodPara = "\\([^\\)]*\\)";
        String typeRe = "(\\<(\\w+(\\s*,\\s*\\w+)*)*\\>\\s+)?\\w+\\s*"
                + "(\\<(\\w+(\\s*,\\s*\\w+)*)*\\>)?(\\[\\])?\\s+";
        String methodSign = "static\\s+" + typeRe + methodName + methodPara;
        pattern = Pattern.compile(methodSign);
        matcher = pattern.matcher(fileContent);
        String func;
        while (matcher.find()) {
            func = matcher.group().trim();
            func = func.replaceAll("static\\s+" + typeRe, "");

            // get Parameter
            String sub = func.substring(func.indexOf("(") + 1, func.indexOf(")"));
            String[] subList = sub.split(", ");
            String[] l = subList[0].split(" ");
            String func1 = getType(l[0], !classList.isEmpty()
                ? classList.get(0) : null, packageName, importList);
            for (int i = 1; i < subList.length; i++) {
                l = subList[i].split(" ");
                l[0] = l[0].replace("...", "");
                l[0] = getType(l[0], !classList.isEmpty()
                    ? classList.get(0) : null, packageName, importList);
                func1 += "," + l[0];
            }
            String name = func.substring(0, func.indexOf("("));
            func = name + "(" + func1 + ")";

            methodList.add(func);
        }
        return methodList;
    }

    /** Type. */
    private static String getType(String type, String className,
                                 String packageName, List<String> importList) {
        type = type.trim();

        switch (type) {
            case "": {
                return "";
            }
            case "String[]":
            case "StringBuffer[]":
            case "Boolean[]":
            case "Byte[]":
            case "Character[]":
            case "Double[]":
            case "Float[]":
            case "Integer[]":
            case "Long[]":
            case "Number[]":
            case "Object[]":
            case "Short[]":
            case "StringBuilder[]":
            case "Void[]":
            case "Class[]":
            case "Iterable[]":
            case "String":
            case "StringBuffer":
            case "Boolean":
            case "Byte":
            case "Character":
            case "Double":
            case "Float":
            case "Integer":
            case "Long":
            case "Number":
            case "Object":
            case "Short":
            case "StringBuilder":
            case "Void":
            case "Class":
            case "Iterable": {
                return "java.lang." + type;
            }

            case "Date": return "java.util." + type;

            case "File": return "java.io." + type;

            case "void[]":
            case "byte[]":
            case "short[]":
            case "char[]":
            case "boolean[]":
            case "float[]":
            case "double[]":
            case "long[]":
            case "int[]":
            case "T":
            case "T[]":
            case "?":
            case "void":
            case "byte":
            case "short":
            case "char":
            case "boolean":
            case "float":
            case "double":
            case "long":
            case "int": {
                return type;
            }
            default: {
                if (type.contains("<") && type.contains(">")) {
                    int i1 = type.indexOf("<");
                    int i2 = type.indexOf(">");
                    String mid = type.substring(i1 + 1, i2);
                    String front = type.substring(0, i1);
                    String beside = type.substring(i2 + 1);

                    mid = getType(mid, className, packageName, importList);
                    front = getType(front, className, packageName, importList);
                    beside = getType(beside, className, packageName, importList);
                    return front + "<" + mid + ">" + beside;
                }

                for (int i = 0; i < importList.size(); i++) {
                    if (importList.get(i).contains(type)) {
                        return importList.get(i);
                    }
                }
            }
            
            return packageName + "." + type;
        }
    }
}