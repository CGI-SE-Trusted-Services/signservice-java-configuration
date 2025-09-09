package se.signatureservice.configuration.common.fields;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Fields {
    public static final String ATTR_TYPE_RDN = "rdn";
    public static final String ATTR_TYPE_SAN = "san";
    public static final String ATTR_TYPE_SDA = "sda";

    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_COUNTRY = "country";
    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_SERIALNUMBER = "serialnumber";
    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_SURNAME = "surname";
    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_GIVENNAME = "givenname";
    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_EMAIL = "email";
    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_EMAIL_ADDRESS = "emailaddress";
    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_COMMONNAME = "commonname";
    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_LOCALITY = "localityname";

    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_ORGANISATION = "organisation";

    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_ORGANISATIONUNIT = "organisationunit";

    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_ORGANISATIONID = "organsiationid";

    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_INITIALS = "initials";

    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_PSEUDONYM = "pseudonym";

    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_STATE = "state";

    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_STREET = "street";

    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_TITLE = "title";

    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_TELEPHONENUMBER = "telephonenumber";

    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_UNIQUEIDENTIFIER = "uniqueidentifier";

    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_DATEOFBIRTH = "dateofbirth";
    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_PLACEOFBIRTH = "placeofbirth";
    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_NAMEATBIRTH = "nameatbirth";
    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_GENDER = "gender";
    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_COUNTRYOFCITIZENSHIP = "countryofcitizenship";
    /**
     * Field name used when requesting certificate.
     */
    public static String FIELDNAME_COUNTRYOFRESIDENCE = "countryofresidence";

    public static final Map<String, String> fieldNameToAttrRef = new LinkedHashMap<>();

    static {
        fieldNameToAttrRef.put(FIELDNAME_COMMONNAME, "2.5.4.3");
        fieldNameToAttrRef.put(FIELDNAME_SERIALNUMBER, "2.5.4.5");
        fieldNameToAttrRef.put(FIELDNAME_SURNAME, "2.5.4.4");
        fieldNameToAttrRef.put(FIELDNAME_COUNTRY, "2.5.4.6");
        fieldNameToAttrRef.put(FIELDNAME_LOCALITY, "2.5.4.7");
        fieldNameToAttrRef.put(FIELDNAME_STATE, "2.5.4.8");
        fieldNameToAttrRef.put(FIELDNAME_STREET, "2.5.4.9");
        fieldNameToAttrRef.put(FIELDNAME_ORGANISATION, "2.5.4.10");
        fieldNameToAttrRef.put(FIELDNAME_ORGANISATIONUNIT, "2.5.4.11");
        fieldNameToAttrRef.put(FIELDNAME_ORGANISATIONID, "2.5.4.97");
        fieldNameToAttrRef.put(FIELDNAME_TITLE, "2.5.4.12");
        fieldNameToAttrRef.put(FIELDNAME_GIVENNAME, "2.5.4.42");
        fieldNameToAttrRef.put(FIELDNAME_INITIALS, "2.5.4.43");
        fieldNameToAttrRef.put(FIELDNAME_PSEUDONYM, "2.5.4.65");
        fieldNameToAttrRef.put(FIELDNAME_DATEOFBIRTH, "1.3.6.1.5.5.7.9.1");
        fieldNameToAttrRef.put(FIELDNAME_PLACEOFBIRTH, "1.3.6.1.5.5.7.9.2");
        fieldNameToAttrRef.put(FIELDNAME_GENDER, "1.3.6.1.5.5.7.9.3");
        fieldNameToAttrRef.put(FIELDNAME_COUNTRYOFCITIZENSHIP, "1.3.6.1.5.5.7.9.4");
        fieldNameToAttrRef.put(FIELDNAME_COUNTRYOFRESIDENCE, "1.3.6.1.5.5.7.9.5");
        fieldNameToAttrRef.put(FIELDNAME_EMAIL, "0.9.2342.19200300.100.1.3");
        fieldNameToAttrRef.put(FIELDNAME_EMAIL_ADDRESS, "0.9.2342.19200300.100.1.3");
        fieldNameToAttrRef.put(FIELDNAME_UNIQUEIDENTIFIER, "2.5.4.45");
        fieldNameToAttrRef.put(FIELDNAME_NAMEATBIRTH, "1.3.36.8.3.14");
        fieldNameToAttrRef.put(FIELDNAME_TELEPHONENUMBER, "2.5.4.20");
    }

    public static final String OID_URI = "urn:oid:";

    public static final Map<String, List<String>> tokenFieldMapToDefaultSAMLAttributes = new LinkedHashMap<>();

    static {
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_COMMONNAME, Arrays.asList(OID_URI + "2.5.4.3", OID_URI + "2.16.840.1.113730.3.1.241"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_SERIALNUMBER, Arrays.asList(OID_URI + "2.5.4.5", OID_URI + "1.2.752.29.4.13", OID_URI + "1.2.752.201.3.4"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_SURNAME, Arrays.asList(OID_URI + "2.5.4.4"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_COUNTRY, Arrays.asList(OID_URI + "2.5.4.6"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_LOCALITY, Arrays.asList(OID_URI + "2.5.4.7"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_STATE, Arrays.asList(OID_URI + "2.5.4.8"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_STREET, Arrays.asList(OID_URI + "2.5.4.9", OID_URI + "1.2.752.201.3.9"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_ORGANISATION, Arrays.asList(OID_URI + "2.5.4.10"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_ORGANISATIONUNIT, Arrays.asList(OID_URI + "2.5.4.11", OID_URI + "1.2.752.201.3.7"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_ORGANISATIONID, Arrays.asList(OID_URI + "2.5.4.97"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_TITLE, Arrays.asList(OID_URI + "2.5.4.12"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_GIVENNAME, Arrays.asList(OID_URI + "2.5.4.42"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_INITIALS, Arrays.asList(OID_URI + "2.5.4.43"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_PSEUDONYM, Arrays.asList(OID_URI + "2.5.4.65", OID_URI + "1.2.752.201.3.5"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_DATEOFBIRTH, Arrays.asList(OID_URI + "1.3.6.1.5.5.7.9.1"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_PLACEOFBIRTH, Arrays.asList(OID_URI + "1.3.6.1.5.5.7.9.2"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_GENDER, Arrays.asList(OID_URI + "1.3.6.1.5.5.7.9.3"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_COUNTRYOFCITIZENSHIP, Arrays.asList(OID_URI + "1.3.6.1.5.5.7.9.4"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_COUNTRYOFRESIDENCE, Arrays.asList(OID_URI + "1.3.6.1.5.5.7.9.5"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_NAMEATBIRTH, Arrays.asList(OID_URI + "1.2.752.201.3.8"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_EMAIL, Arrays.asList(OID_URI + "0.9.2342.19200300.100.1.3"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_EMAIL_ADDRESS, Arrays.asList(OID_URI + "0.9.2342.19200300.100.1.3"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_UNIQUEIDENTIFIER, Arrays.asList(OID_URI + "2.5.4.45", OID_URI + "1.2.752.201.3.2"));
        tokenFieldMapToDefaultSAMLAttributes.put(FIELDNAME_TELEPHONENUMBER, Arrays.asList(OID_URI + "2.5.4.20"));
    }

    public static final Map<String, String> fieldNameToAttrType = new LinkedHashMap<>();

    static {
        fieldNameToAttrType.put(FIELDNAME_COUNTRY, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_SERIALNUMBER, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_SURNAME, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_GIVENNAME, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_EMAIL, ATTR_TYPE_SAN);
        fieldNameToAttrType.put(FIELDNAME_EMAIL_ADDRESS, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_COMMONNAME, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_LOCALITY, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_ORGANISATION, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_ORGANISATIONUNIT, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_ORGANISATIONID, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_INITIALS, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_PSEUDONYM, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_STATE, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_STREET, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_TITLE, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_UNIQUEIDENTIFIER, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_TELEPHONENUMBER, ATTR_TYPE_RDN);
        fieldNameToAttrType.put(FIELDNAME_DATEOFBIRTH, ATTR_TYPE_SDA);
        fieldNameToAttrType.put(FIELDNAME_PLACEOFBIRTH, ATTR_TYPE_SDA);
        fieldNameToAttrType.put(FIELDNAME_GENDER, ATTR_TYPE_SDA);
        fieldNameToAttrType.put(FIELDNAME_COUNTRYOFCITIZENSHIP, ATTR_TYPE_SDA);
        fieldNameToAttrType.put(FIELDNAME_COUNTRYOFRESIDENCE, ATTR_TYPE_SDA);
        fieldNameToAttrType.put(FIELDNAME_NAMEATBIRTH, ATTR_TYPE_SDA);
    }
}
