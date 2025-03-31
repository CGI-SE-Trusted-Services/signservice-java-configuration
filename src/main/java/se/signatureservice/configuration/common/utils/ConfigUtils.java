/************************************************************************
 *                                                                       *
 *  Signservice Java Configuration                                       *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public License   *
 *  (LGPL-3.0-or-later)                                                  *
 *  License as published by the Free Software Foundation; either         *
 *  version 3 of the License, or any later version.                      *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package se.signatureservice.configuration.common.utils;

import se.signatureservice.configuration.common.InternalErrorException;
import se.signatureservice.configuration.common.InvalidArgumentException;

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
    public static Integer parseInteger(Object value, String errorMessage) throws InternalErrorException {
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
    public static Integer parseInteger(Object value, String errorMessage, boolean required, Integer defaultValue) throws InternalErrorException {

        if (value instanceof Integer) {
            return (Integer) value;
        }
        try {
            if (value instanceof String) {
                if (((String) value).isEmpty()) {
                    value = null;
                } else {
                    return Integer.parseInt((String) value);
                }
            }
        } catch (Exception e) {
            throw new InternalErrorException(errorMessage, e);
        }
        if (isNullOrEmptyMap(value) && !required) {
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

        if (value instanceof String) {
            if (((String) value).isEmpty()) {
                value = null;
            } else {
                String s = ((String) value).toLowerCase().trim();
                if (s.equals("true")) {
                    return true;
                }
                if (s.equals("false")) {
                    return false;
                }
                throw new InternalErrorException(errorMessage);
            }
        }

        if (isNullOrEmptyMap(value) && !required) {
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
    public static String parseString(Object value, String errorMessage, boolean required, String defaultValue) throws InternalErrorException {
        if (value instanceof String) {
            if (!((String) value).trim().isEmpty()) {
                return (String) value;
            }
        } else if (isNullOrEmptyMap(value) && !required) {
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
    public static Float parseFloat(Object value, String errorMessage, boolean required, Float defaultValue) throws InternalErrorException {
        if (value instanceof Float) {
            return (Float) value;
        }
        if (value instanceof Long) {
            return ((Long) value).floatValue();
        }
        if (value instanceof Integer) {
            return ((Integer) value).floatValue();
        }
        try {
            if (value instanceof String) {
                if (((String) value).isEmpty()) {
                    value = null;
                } else {
                    return Float.parseFloat((String) value);
                }
            }
        } catch (Exception e) {
            throw new InternalErrorException(errorMessage, e);
        }
        if (isNullOrEmptyMap(value) && !required) {
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
        try {
            if (value instanceof String) {
                if (((String) value).isEmpty()) {
                    value = null;
                } else {
                    return Long.parseLong((String) value);
                }
            }
        } catch (Exception e) {
            throw new InternalErrorException(errorMessage, e);
        }
        if (isNullOrEmptyMap(value) && !required) {
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
    public static List<String> parseListOfString(Object value, String errorMessage, boolean required) throws InternalErrorException {
        if (value instanceof List<?>) {
            List<?> list = (List<?>) value;

            if (list.isEmpty() && required) {
                throw new InternalErrorException(errorMessage);
            }

            for (Object item : list) {
                if (item == null) {
                    throw new InternalErrorException(errorMessage);
                } else if (!(item instanceof String) || ((String) item).trim().isEmpty()) {
                    throw new InternalErrorException(errorMessage);
                }
            }

            return (List<String>) list;
        }

        if (isNullOrEmptyMap(value) && !required) {
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
    public static boolean isNullOrEmptyMap(Object value) {
        return value == null || (value instanceof Map && ((Map<?, ?>) value).isEmpty());
    }

    /**
     * Help method parsing the key/truststore extension of a specified file if not specified using type.
     *
     * @param type key/truststore file extension.
     * @param filePrefix file extension.
     * @return type if specified otherwise key/truststore file extension.
     * @throws InvalidArgumentException if an unsupported truststore filename extension was used.
     */
    public static String getKeyStoreExtension(String type, String filePrefix) throws InvalidArgumentException {
        if (type == null && filePrefix != null) {
            if (filePrefix.equalsIgnoreCase("p12") || filePrefix.equalsIgnoreCase("pfx")) {
                type = "PKCS12";
            } else if (filePrefix.equalsIgnoreCase("jks")) {
                type = "JKS";
            } else {
                throw new InvalidArgumentException("Unsupported truststore filename extension: ${trustStorePrefix}");
            }
        }
        return type;
    }

}
