package com.zinio.web.utilities;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class StringUtils {

    public static String randomString(String prefix, int length) {
        return prefix + RandomStringUtils.randomAlphabetic(length);
    }

    public static String randomNumber(String prefix, int length) {
        return prefix + RandomStringUtils.randomNumeric(length);
    }

    public static String randomNumber(int bound) {
        return Integer.toString(new Random().nextInt(bound));
    }

    public static String randomNumber() {return Double.toString(new Random().nextDouble());}

    public static int randomNumberInRange(int low, int high) {
        if (low == high || low > high) return new Random().nextInt(low) + low;
        else
            return new Random().nextInt(high - low) + low;
    }

    public static int randomNumberExceptValue(int low, int high, int exceptValue) {
        int value = randomNumberInRange(low, high);
        while (value == exceptValue) {
            value = randomNumberInRange(low, high);
        }
        return value;
    }

    public static String randomCharactersInString(String prefix, int length, String specialCharacters) {
        return prefix + RandomStringUtils.random(length, specialCharacters);
    }

    public static boolean isStringNumeric(String string) {
        try {
            Double.parseDouble(string);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static String getRandomItem(String[] items) {
        Random rand = new Random();
        return items[rand.nextInt(items.length)];
    }

    public static String[] getRandomItems(String[] items) {
        int number = randomNumberInRange(1, items.length - 1);
        String[] values = {};
        for (int i = 0; i < number; i++) {
            values = StringUtils.addStringToArray(values, items[i]);
        }
        return values;
    }

    public static String[] getNumberRandomItems(String[] items, int numberItems) {
        String[] values = {};
        for (int i = 0; i < numberItems; i++) {
            values = StringUtils.addStringToArray(values, items[i]);
        }
        return values;
    }

    public static String getRandomItemExceptValue(String[] items, String value) {
        Random rand = new Random();
        String _value = items[rand.nextInt(items.length)];

        while (_value.equals(value)) {
            _value = items[rand.nextInt(items.length)];
        }
        return _value;
    }

    public static String[] getRandomItemOn2DArray(String[][] items) {
        Random rand = new Random();
        int ranIdex = rand.nextInt(items.length);
        return items[ranIdex];
    }

    public static String[] getColumnsValueOn2DArray(String[][] items, int columnIndex) {
        int lengthItems = items.length;
        String[] output = new String[lengthItems];
        for (int i = 0; i < lengthItems; i++) {
            output[i] = items[i][columnIndex];
        }
        return output;
    }

    public static String[] addStringToArray(String[] stringArray, String stringToAdd) {
        return ArrayUtils.add(stringArray, stringToAdd);
    }

    public static String[] removeStringFromArray(String[] stringArray, String... stringToRemove) {
        for (String itemRemove : stringToRemove) {
            int index = getIndex(stringArray, itemRemove);
            stringArray = ArrayUtils.remove(stringArray, index);
        }

        return stringArray;
    }

    public static String[] combineArray(String[] array1, String[] array2) {
        return ArrayUtils.addAll(array1, array2);
    }

    public static String getLastSubString(String string, String separator) {
        String[] tmp = string.split(separator);
        return tmp[tmp.length - 1];
    }

    public static int getIndex(String[] stringArray, String expectedString) {
        int lengthArray = stringArray.length;
        for (int i = 0; i < lengthArray; i++) {
            if (stringArray[i].equals(expectedString))
                return i;
        }
        return -1;
    }

    public static String getDataFromKey(String[][] stringArray2D, String key) {
        int stringArray2DLength = stringArray2D.length;
        for (int i = 0; i < stringArray2DLength; i++)
            if (stringArray2D[i][0].equals(key)) return stringArray2D[i][1];
        return null;
    }

    public static String getKeyFromData(String[][] stringArray2D, String data) {
        int stringArray2DLength = stringArray2D.length;
        for (int i = 0; i < stringArray2DLength; i++)
            if (stringArray2D[i][1].equals(data)) return stringArray2D[i][0];
        return null;
    }

    public static String[] getValuesFromListObject(List<Object> objectList, String className, String fieldName) {
        String[] result = new String[]{};
        try {
            Class<?> _class = Class.forName(className);
            Field privateField = _class.getDeclaredField(fieldName);

            for (Object object : objectList) {
                String objectName = privateField.get(object).toString();
                result = StringUtils.addStringToArray(result, objectName);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String[] getValuesFromListWithCondition(List<Object> objectList, String className, String paramGetValue,
                                                          String paramCondition, String condition) {
        String[] result = null;
        try {
            Class<?> _class = Class.forName(className);
            Field privateField = _class.getDeclaredField(paramGetValue);
            Field fieldCondition = _class.getDeclaredField(paramCondition);

            for (Object object : objectList) {
                String objectName = fieldCondition.get(object).toString();
                if (objectName.equalsIgnoreCase(condition)) {
                    result = StringUtils.addStringToArray(result, privateField.get(object).toString());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String[] parseEnumToArrayList(Class<? extends Enum<?>> e) {
        return Arrays.toString(e.getEnumConstants()).replaceAll("^.|.$", "").split(", ");
    }

    public static String randomEnum(Class<? extends Enum<?>> e) {
        int length = e.getEnumConstants().length;
        return e.getEnumConstants()[randomNumberInRange(0, length - 1)].toString();
    }

    public static List<String> getCSVData(String filePath) {
        filePath = System.getProperty("user.dir") + filePath;
        List<String> result = new ArrayList<>();
        BufferedReader br;
        String line;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            result.remove(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String[] getKeyFromHashMap(HashMap<String, String[]> data) {
        Set<String> keys = data.keySet();
        return keys.toArray(new String[0]);
    }

    public static String[] getValuesFromHashMap(HashMap<String, String[]> data) {
        String[] result = {};
        String[] keys = getKeyFromHashMap(data);
        for (String key : keys) {
            result = StringUtils.combineArray(result, data.get(key));
        }
        return result;
    }

    public static String subString(String value) {
        return value.substring(0, Integer.parseInt(StringUtils.randomNumber(value.length())));
    }
}
