package se.signatureservice.configuration.common.utils;

import se.signatureservice.configuration.common.InternalErrorException;

import java.util.List;
import java.util.Map;

public class ConfigUtils {

    /**
     * Help method parsing a config object that can either be a string or a int value
     *
     * @param value the value to parse.
     * @param errorMessage the error message if parsing fails.
     * @return the parsed integer or null
     * @throws InternalErrorException if error occurred parsing the value
     */
    public static Integer parseInteger(Object value, String errorMessage) throws InternalErrorException{
        return parseInteger(value, errorMessage, false, null);
    }

    /**
     * Help method parsing a config object that can either be a string or a int value
     * @param value the value to parse.
     * @param errorMessage the error message if parsing fails.
     * @param required if the value is required.
     * @param defaultValue the default value if value is null.
     * @return the parsed integer
     * @throws InternalErrorException if error occurred parsing the value
     */
    public static Integer parseInteger(Object value, String errorMessage, boolean required, Integer defaultValue) throws InternalErrorException{

        if (value instanceof Integer) {
            return (Integer) value;
        }
        try{
            if(value instanceof String){
                if(((String) value).isEmpty()){
                    value = null;
                } else {
                    return Integer.parseInt((String) value);
                }
            }
        } catch(Exception e){
            throw new InternalErrorException(errorMessage,e);
        }
        if(isNullOrEmptyMap(value) && !required){
            return defaultValue;
        }
        throw new InternalErrorException(errorMessage);
    }

    /**
     * Help method parsing a config object that can either be a string or a boolean value
     *
     * @param value the value to parse.
     * @param errorMessage the error message if parsing fails.
     * @return the parsed boolean or false.
     * @throws InternalErrorException if error occurred parsing the value
     */
    public static Boolean parseBoolean(Object value, String errorMessage) throws InternalErrorException {
        return parseBoolean(value, errorMessage, false, null);
    }

    /**
     * Help method parsing a config object that can either be a string or a boolean value
     *
     * @param value the value to parse.
     * @param errorMessage the error message if parsing fails.
     * @param required if the value is required.
     * @param defaultValue the default value if value is null.
     * @return the parsed boolean
     * @throws InternalErrorException if error occurred parsing the value
     */
    public static Boolean parseBoolean(Object value, String errorMessage, boolean required, Boolean defaultValue) throws InternalErrorException {
        if (value instanceof Boolean) {
            return (Boolean) value;
        }

        if(value instanceof String){
            if(((String) value).isEmpty()){
                value = null;
            } else {
                String s = ((String) value).toLowerCase().trim();
                if(s.equals("true")) {
                    return true;
                }
                if(s.equals("false")) {
                    return false;
                }
                throw new InternalErrorException(errorMessage);
            }
        }

        if(isNullOrEmptyMap(value) && !required){
            return defaultValue;
        }

        throw new InternalErrorException(errorMessage);
    }

    /**
     * Help method parsing a config object that should be a string value.
     *
     * @param value the value to parse.
     * @param errorMessage the error message if parsing fails.
     * @return the parsed string or null.
     * @throws InternalErrorException if error occurred parsing the value
     */
    public static String parseString(Object value, String errorMessage) throws InternalErrorException {
        return parseString(value, errorMessage, false, null);
    }

    /**
     * Help method parsing a config object that should be a string value.
     *
     * @param value the value to parse.
     * @param errorMessage the error message if parsing fails.
     * @param required if the value is required.
     * @return the parsed string or null if not required.
     * @throws InternalErrorException if error occurred parsing the value
     */
    public static String parseString(Object value, String errorMessage, boolean required) throws InternalErrorException {
        return parseString(value, errorMessage, required, null);
    }

    /**
     * Help method parsing a config object that should be a string value
     *
     * @param value the value to parse.
     * @param errorMessage the error message if parsing fails.
     * @param required if the value is required.
     * @param defaultValue the default value if value is null.
     * @return the parsed string
     * @throws InternalErrorException if error occurred parsing the value
     */
    public static String parseString(Object value, String errorMessage, boolean required, String defaultValue) throws InternalErrorException{
        if(value instanceof String){
            if(((String)value).isEmpty()){
                value = null;
            } else {
                return (String)value;
            }
        }

        if(isNullOrEmptyMap(value) && !required){
            return defaultValue;
        }

        throw new InternalErrorException(errorMessage);
    }

    /**
     * Help method parsing a config object that can either be a string or a long value
     *
     * @param value the value to parse.
     * @param errorMessage the error message if parsing fails.
     * @param required if the value is required.
     * @param defaultValue the default value if value is null.
     * @return the parsed float
     * @throws InternalErrorException if error occurred parsing the value
     */
    public static Float parseFloat(Object value, String errorMessage, boolean required, Float defaultValue) throws InternalErrorException{
        if(value instanceof Float) {
            return (Float) value;
        }
        if(value instanceof Long) {
            return ((Long)value).floatValue();
        }
        if(value instanceof Integer){
            return ((Integer)value).floatValue();
        }
        try {
            if(value instanceof String){
                if(((String) value).isEmpty()){
                    value = null;
                } else {
                    return Float.parseFloat((String) value);
                }
            }
        } catch(Exception e){
            throw new InternalErrorException(errorMessage,e);
        }
        if(isNullOrEmptyMap(value) && !required){
            return defaultValue;
        }
        throw new InternalErrorException(errorMessage);
    }

    /**
     * Help method parsing a config object that can either be a string or a long value
     *
     * @param value the value to parse.
     * @param errorMessage the error message if parsing fails.
     * @return the parsed long or null
     * @throws InternalErrorException if error occurred parsing the value
     */
    public static Long parseLong(Object value, String errorMessage) throws InternalErrorException {
        return parseLong(value, errorMessage, false, null);
    }

    /**
     * Help method parsing a config object that can either be a string or a long value
     *
     * @param value the value to parse.
     * @param errorMessage the error message if parsing fails.
     * @param required if the value is required.
     * @return the parsed long or null if not required
     * @throws InternalErrorException if error occurred parsing the value
     */
    public static Long parseLong(Object value, String errorMessage, boolean required) throws InternalErrorException {
        return parseLong(value, errorMessage, required, null);
    }

    /**
     * Help method parsing a config object that can either be a string or a long value
     *
     * @param value the value to parse.
     * @param errorMessage the error message if parsing fails.
     * @param required if the value is required.
     * @param defaultValue the default value if value is null.
     * @return the parsed long
     * @throws InternalErrorException if error occurred parsing the value
     */
    public static Long parseLong(Object value, String errorMessage, boolean required, Long defaultValue) throws InternalErrorException {

        if (value instanceof Integer) {
            return ((Integer) value).longValue();
        }
        if (value instanceof Long) {
            return (Long) value;
        }
        try{
            if(value instanceof String){
                if(((String) value).isEmpty()){
                    value = null;
                } else {
                    return Long.parseLong((String) value);
                }
            }
        } catch(Exception e){
            throw new InternalErrorException(errorMessage, e);
        }
        if(isNullOrEmptyMap(value) && !required){
            return defaultValue;
        }
        throw new InternalErrorException(errorMessage);
    }

    /**
     * Help method to parse a List of Strings from configuration.
     *
     * @param value the value to parse.
     * @param errorMessage the error message if parsing fails.
     * @return the parsed list or null
     * @throws InternalErrorException if error occurred parsing the value
     */
    public static List<String> parseListOfString(Object value, String errorMessage)  throws InternalErrorException{
        return parseListOfString(value, errorMessage, false);
    }

    /**
     * Help method to parse a List of Strings from configuration.
     *
     * @param value the value to parse.
     * @param errorMessage the error message if parsing fails.
     * @param required if the value is required.
     * @return the parsed list
     * @throws InternalErrorException if error occurred parsing the value
     */
    @SuppressWarnings("unchecked")
    public static List<String> parseListOfString(Object value, String errorMessage, boolean required)  throws InternalErrorException{
        if(value instanceof List){
            List<String> list = (List) value;
            for(Object s : list){
                if(!(s instanceof String)){
                    throw new InternalErrorException(errorMessage);
                }
            }
            if(list.size() == 0 && required){
                throw new InternalErrorException(errorMessage);
            }

            return list;
        }
        if(isNullOrEmptyMap(value) && !required){
            return null;
        }

        throw new InternalErrorException(errorMessage);
    }

    /**
     * Check if an object is null or an empty Map.
     *
     * @param value object to check.
     * @return ture if object is null or an empty map, otherwise false.
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNullOrEmptyMap(Object value){
        if(value == null){
            return true;
        }

        return value instanceof Map && ((Map) value).isEmpty();
    }
}
