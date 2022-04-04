package com.vicking.util.tools.d;


public class DeseriCollectionUtilBuilder {

    public static String getBooleansArr(String value) {
        String type = "Boolean";
        String s = "{" +
                "int len = DeseriUtil.getShort(is);" +
                type+"[] arr = new "+type+"[len];" +
                "if(arr.length > 0) {" +
                "DeseriUtil.get" + type + "s(is, arr);" +
                String.format(value, "set") +
                "}}";
        return s;
    }

    public static String getBooleansSet(String value) {
        String type = "Boolean";
        String s = "{HashSet<"+type+"> set = new HashSet<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!set.isEmpty()) " +
                String.format(value, "set") +
                "}";
        return s;
    }

    public static String getBooleansList(String value) {
        String type = "Boolean";
        String s = "{ArrayList<"+type+"> list = new ArrayList<>();" +
                   "DeseriUtil.get" + type + "s(is, list);" +
                   "if(!list.isEmpty()) " +
                    String.format(value, "list") +
                    "}";
        return s;
    }



    public static String getDatesArr(String value) {
        String type = "Date";
        String s = "{" +
                "int len = DeseriUtil.getShort(is);" +
                type+"[] arr = new "+type+"[len];" +
                "if(arr.length > 0) {" +
                "DeseriUtil.get" + type + "s(is, arr);" +
                String.format(value, "set") +
                "}}";
        return s;
    }

    public static String getDatesSet(String value) {
        String type = "Date";
        String s = "{HashSet<"+type+"> set = new HashSet<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!set.isEmpty()) " +
                String.format(value, "set") +
                "}";
        return s;
    }

    public static String getDatesList(String value) {
        String type = "Date";
        String s = "{ArrayList<"+type+"> list = new ArrayList<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!list.isEmpty()) " +
                String.format(value, "list") +
                "}";
        return s;
    }


    public static String getDoublesArr(String value) {
        String type = "Double";
        String s = "{" +
                "int len = DeseriUtil.getShort(is);" +
                type+"[] arr = new "+type+"[len];" +
                "if(arr.length > 0) {" +
                "DeseriUtil.get" + type + "s(is, arr);" +
                String.format(value, "set") +
                "}}";
        return s;
    }

    public static String getDoublesSet(String value) {
        String type = "Double";
        String s = "{HashSet<"+type+"> set = new HashSet<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!set.isEmpty()) " +
                String.format(value, "set") +
                "}";
        return s;
    }

    public static String getDoublesList(String value) {
        String type = "Double";
        String s = "{ArrayList<"+type+"> list = new ArrayList<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!list.isEmpty()) " +
                String.format(value, "list") +
                "}";
        return s;
    }


    public static String getFloatsArr(String value) {
        String type = "Float";
        String s = "{" +
                "int len = DeseriUtil.getShort(is);" +
                type+"[] arr = new "+type+"[len];" +
                "if(arr.length > 0) {" +
                "DeseriUtil.get" + type + "s(is, arr);" +
                String.format(value, "set") +
                "}}";
        return s;
    }

    public static String getFloatsSet(String value) {
        String type = "Float";
        String s = "{HashSet<"+type+"> set = new HashSet<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!set.isEmpty()) " +
                String.format(value, "set") +
                "}";
        return s;
    }

    public static String getFloatsList(String value) {
        String type = "Float";
        String s = "{ArrayList<"+type+"> list = new ArrayList<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!list.isEmpty()) " +
                String.format(value, "list") +
                "}";
        return s;
    }


    public static String getBytesArr(String value) {
        String type = "Byte";
        String s = "{" +
                "int len = DeseriUtil.getShort(is);" +
                type+"[] arr = new "+type+"[len];" +
                "if(arr.length > 0) {" +
                "DeseriUtil.get" + type + "s(is, arr);" +
                String.format(value, "set") +
                "}}";
        return s;
    }

    public static String getBytesSet(String value) {
        String type = "Byte";
        String s = "{HashSet<"+type+"> set = new HashSet<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!set.isEmpty()) " +
                String.format(value, "set") +
                "}";
        return s;
    }

    public static String getBytesList(String value) {
        String type = "Byte";
        String s = "{ArrayList<"+type+"> list = new ArrayList<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!list.isEmpty()) " +
                String.format(value, "list") +
                "}";
        return s;
    }

    public static String getShortsArr(String value) {
        String type = "Short";
        String s = "{" +
                "int len = DeseriUtil.getShort(is);" +
                type+"[] arr = new "+type+"[len];" +
                "if(arr.length > 0) {" +
                "DeseriUtil.get" + type + "s(is, arr);" +
                String.format(value, "set") +
                "}}";
        return s;
    }

    public static String getShortsSet(String value) {
        String type = "Short";
        String s = "{HashSet<"+type+"> set = new HashSet<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!set.isEmpty()) " +
                String.format(value, "set") +
                "}";
        return s;
    }

    public static String getShortsList(String value) {
        String type = "Short";
        String s = "{ArrayList<"+type+"> list = new ArrayList<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!list.isEmpty()) " +
                String.format(value, "list") +
                "}";
        return s;
    }

    public static String getIntsArr(String value) {
        String type = "Int";
        String s = "{" +
                "int len = DeseriUtil.getShort(is);" +
                type+"[] arr = new "+type+"[len];" +
                "if(arr.length > 0) {" +
                "DeseriUtil.get" + type + "s(is, arr);" +
                String.format(value, "set") +
                "}}";
        return s;
    }

    public static String getIntsSet(String value) {
        String type = "Int";
        String s = "{HashSet<"+type+"> set = new HashSet<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!set.isEmpty()) " +
                String.format(value, "set") +
                "}";
        return s;
    }

    public static String getIntsList(String value) {
        String type = "Int";
        String s = "{ArrayList<"+type+"> list = new ArrayList<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!list.isEmpty()) " +
                String.format(value, "list") +
                "}";
        return s;
    }


    public static String getLongsArr(String value) {
        String type = "Long";
        String s = "{" +
                "int len = DeseriUtil.getShort(is);" +
                type+"[] arr = new "+type+"[len];" +
                "if(arr.length > 0) {" +
                "DeseriUtil.get" + type + "s(is, arr);" +
                String.format(value, "set") +
                "}}";
        return s;
    }

    public static String getLongsSet(String value) {
        String type = "Long";
        String s = "{HashSet<"+type+"> set = new HashSet<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!set.isEmpty()) " +
                String.format(value, "set") +
                "}";
        return s;
    }

    public static String getLongsList(String value) {
        String type = "Long";
        String s = "{ArrayList<"+type+"> list = new ArrayList<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!list.isEmpty()) " +
                String.format(value, "list") +
                "}";
        return s;
    }

    public static String getStringsArr(String value) {
        String type = "String";
        String s = "{" +
                "int len = DeseriUtil.getShort(is);" +
                type+"[] arr = new "+type+"[len];" +
                "if(arr.length > 0) {" +
                "DeseriUtil.get" + type + "s(is, arr);" +
                String.format(value, "set") +
                "}}";
        return s;
    }

    public static String getStringsSet(String value) {
        String type = "String";
        String s = "{HashSet<"+type+"> set = new HashSet<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!set.isEmpty()) " +
                String.format(value, "set") +
                "}";
        return s;
    }

    public static String getStringsList(String value) {
        String type = "String";
        String s = "{ArrayList<"+type+"> list = new ArrayList<>();" +
                "DeseriUtil.get" + type + "s(is, list);" +
                "if(!list.isEmpty()) " +
                String.format(value, "list") +
                "}";
        return s;
    }


}
