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
package se.signatureservice.configuration.support.system;

import se.signatureservice.configuration.common.InternalErrorException;

import java.util.List;
import java.util.Map;

public interface SupportProfile {
    /**
     * The name of the related profile, set automatically by configuration manager.
     */
    String getRelatedProfile();

    /**
     * XAdES Signature level.
     * Supported values: XML-NOT-ETSI, XAdES-BASELINE-B, XAdES-BASELINE-T,
     * XAdES-BASELINE-LT, XAdES-BASELINE-LTA
     */
    String getXadesSignatureLevel();

    /**
     * XAdES Signature packing setting.
     * Supported values: DETACHED, ENVELOPED, ENVELOPING
     */
    String getXadesSignaturePacking();

    /**
     * XAdES canonicalization algorithm that will be used when
     * calculating digests for SignedInfo and SignedProperties structures
     */
    String getXadesCanonicalizationAlgorithmURI();

    /**
     * XAdES XPath location string that defines the area where
     * the signature will be added
     */
    String getXadesXPathLocationString();

    /**
     * PAdES Signature level.
     * Supported values: PDF-NOT-ETSI, PAdES-BASELINE-B, PAdES-BASELINE-T,
     * PAdES-BASELINE-LT, PAdES-BASELINE-LTA
     */
    String getPadesSignatureLevel();

    /**
     * PaDES Signature packing setting.
     * Supported values: DETACHED, ENVELOPED, ENVELOPING
     */
    String getPadesSignaturePacking();

    /**
     * PAdES content size reserved for signature data during
     * signature operation.
     */
    int getPadesContentSize();

    /**
     * CAdES Signature level.
     * Supported values: CMS-NOT-ETSI, CAdES-BASELINE-B, CAdES-BASELINE-T,
     * CAdES-BASELINE-LT, CAdES-BASELINE-LTA
     */
    String getCadesSignatureLevel();

    /**
     * CAdES Signature packing setting.
     * Supported values: DETACHED, ENVELOPING
     */
    String getCadesSignaturePacking();

    /**
     * Overlap in minutes to overcome problems with time
     * synchronization. Signing certificate ValidFrom date will be set
     * to current time minus the specified overlap.
     */
    int getSignatureValidityOverlapMinutes();

    /**
     * Signature certificate validity in minutes to request
     */
    int getSignatureValidityMinutes();

    /**
     * Signature algorithm in Java-form to use.
     */
    String getSignatureAlgorithm();

    /**
     * Algorithm schem to use when encrypting data. Used i.e. if encrypted sign
     * messages are enabled through the setting 'useEncryptedSignMessage'.
     * Available values: RSA_PKCS1_5_WITH_AES128, RSA_OAEP_WITH_AES128,
     * RSA_PKCS1_5_WITH_AES192, RSA_OAEP_WITH_AES192, RSA_PKCS1_5_WITH_AES256,
     * RSA_OAEP_WITH_AES256
     */
    String getEncryptionAlgorithmScheme();

    /**
     * Flag to choose if sign message should be encrypted or not. If this
     * is enabled the sign message will be encrypted using the public key
     * of the identity provider.
     */
    boolean isUseEncryptedSignMessage();

    /**
     * Flag indicating if the sign message must be shown for a valid signature.
     */
    boolean isSignMessageMustShow();

    /**
     * Mimetype of sign message.
     * Supported values: 'TEXT', 'HTML' or 'MARKDOWN'
     */
    String getSignMessageMimeType();

    /**
     * SAML Attribute name that will map against user ID
     * @deprecated Use defaultUserIdAttributeMapping (since 2019-05-25).
     */
    @Deprecated
    String getUserIdAttributeMapping();

    /**
     * SAML Attribute name that will map against user ID if
     * not specified in the identity provider configuration
     * (trustedAuthenticationServices).
     */
    String getDefaultUserIdAttributeMapping();

    /**
     * User attribute key that will be used to fetch display name
     * of user to use when performing signatures. If this setting is missing
     * or if the specified attribute is missing the userId will be used.
     */
    String getUserDisplayNameAttribute();

    /**
     * Signature service (frontend) SAML identity to specify in generated
     * EID Sign Requests (ex.https://esign.v2.st.signatureservice.se/signservice-frontend/metadata)
     */
    String getSignServiceId();

    /**
     * Signature service (frontend) URL to redirect the user to with the
     * generated EID sign request (ex. https://esign.v2.st.signatureservice.se/signservice-frontend/request/4321a583928)
     */
    String getSignServiceRequestURL();

    /**
     * Name of signature requesting entity/organisation.
     */
    String getSignRequester();

    /**
     * Boolean value if AuthnContextClassRef should be fetched
     * and parsed from metadata.
     *
     * Example configuration:
     * fetchAuthnContextClassRefFromMetaData: true
     */
    boolean isFetchAuthnContextClassRefFromMetaData();

    /**
     * Type/level of authentication to request in the signature process.
     * @deprecated Use defaultAuthnContextClassRef (since 2018-11-21).
     */
    @Deprecated
    String getAuthnContextClassRef();

    /**
     * Default Type/level of authentication to request in the signature process.
     */
    String getDefaultAuthnContextClassRef();

    /**
     * List of default Types/levels of authentication to request in the signature process.
     */
    List<String> getDefaultAuthnContextClassRefs();

    /**
     * Type of certificate to request in the signature process.
     * Supported values: PKC, QC, QC/SSCD
     */
    String getCertificateType();

    /**
     * List of DefaultUserIdAttributeMapping values which can be overloaded
     * via defaultUserIdAttributeMappingValues.
     *
     * Example configuration:
     *   defaultUserIdAttributeMappingValues:
     *     -"urn:oid:1.2.752.29.4.13"
     *     -"urn:oid:1.2.752.201.3.4"
     *     -"http://sambi.se/attributes/1/personalIdentityNumber"
     */
    List<String> getDefaultUserIdAttributeMappingValues();

    /**
     * Boolean value if requestedCertAttributes should be fetched
     * and parsed from metadata.
     *
     * Example configuration:
     * fetchCertAttributesFromMetaData: true
     */
    boolean isFetchCertAttributesFromMetaData();

    /**
     * Map containing custom attributes to be mapped to it's corresponding metadata for requestedCertAttributes.
     * Used in special cases when the Name in RequestedAttribute metadata don't apply.
     *
     * For each entry the following configuration keys are used :
     *   - samlAttributeName : The SAML attribute name to be matched against the Name
     *   for a RequestedAttribute in the metadata.
     *   - certAttributeRef : To which the samlAttributeName will be mapped to.
     *
     * Example configuration 1:
     * metadataCustomCertAttribute:
     *   givenName:
     *     samlAttributeName: "http://sambi.se/attributes/1/givenName"
     *     certAttributeRef: "2.5.4.42"
     *
     * Example configuration 2:
     * metadataCustomCertAttribute:
     *   surName:
     *     samlAttributeName:
     *       -"http://sambi.se/attributes/1/surname"
     *       -"urn:surname"
     *     certAttributeRef: "2.5.4.4"
     *     certNameType: "sda"
     *     required: true
     */
    Map<String, Map<String,Object>> getMetadataCustomCertAttribute();

    /**
     * Map containing Requests for subject attributes in a signer
     * certificate that is associated with the signer of the generated
     * signature as a result of the sign request.
     *
     * Example configuration:
     * requestedCertAttributes {
     *     givenName {
     *         samlAttributeName = "urn:oid:2.5.4.42"
     *         certAttributeRef = "2.5.4.42"
     *         required = true
     *     }
     * }
     */
    Map<String, Map<String,Object>> getRequestedCertAttributes();

    /**
     * Map containing attributes to be included in the signer element within the sign request,
     * in addition to the mandatory userId attribute (see defaultUserIdAttributeMapping) that
     * is always included as a signer attribute.
     *
     * For each entry the following configuration keys are used:
     *
     *   - samlAttributeName : The SAML attribute name to use for the signer attribute.
     *   - userAttributeMapping : User attribute key to look for when populating the signer attribute value.
     *   - required : If set to true the user given user attribute must exist, or an error is generated.
     *                If set to false the signer attribute is set only if the user attribute exists.
     *
     * Example configuration:
     * signerAttributes {
     *     orgAffiliation {
     *         samlAttributeName = "urn:oid:1.2.752.201.3.1"
     *         userAttributeMapping = "orgAffiliation"
     *         required = true
     *     }
     * }
     */
    Map<String, Map<String,Object>> getSignerAttributes();

    /**
     * Map containing trusted authentication services/identity providers that
     * can be used for the given profile. Corresponding metadata for
     * each trusted service must also be available in the metadata directory.
     * Note: defaultDisplayName will be used if display name is not available in
     * metadata.
     *
     * Example configuration:
     * trustedAuthenticationServices {
     *     iDPTest {
     *         entityId = "https://idptest.someservice.se/samlv2/idp/metadata"
     *         defaultDisplayName = "Test iDP ST"
     *         authnContextClassRef = "urn:oasis:names:tc:SAML:2.0:ac:classes:Password"
     *         userIdAttributeMapping = "urn:oid:1.2.752.29.4.13"
     *     }
     * }
     */
    Map<String,Map<String,Object>> getTrustedAuthenticationServices();

    /**
     * Required setting containing the Meta Data Entity Id of all trusted central services that
     * might send signature responses to this support service.
     */
    List<String> getAuthorizedCentralServiceEntityIds();

    /**
     * Required setting containing a list of authorized consumer URLs that can be specified
     * by the driving application.
     */
    List<String> getAuthorizedConsumerURLs();

    /**
     * Validation policy to use when verifying signed documents. Policy file must be specified
     * using filename (with or without .xml extension) of policy file which must be present
     * in the policy directory specified by the application setting 'validation.policy.directory'.
     */
    String getValidationPolicy();

    /**
     * Flag indicating if enhanced logging should be enabled or not. If enhanced logging is
     * enabled the following details will be written to the logfile using INFO-level:
     *
     * - Subject of certificate that was used for signing
     * - Signing time of document(s)
     * - Reference information of document(s) that were signed
     * - Name of document(s) that were signed
     * - Issuer of certificate that was used for signing
     * - Information about which authentication performed prior to signing (assurance level)
     * - Complete signature response received from central signature service during signature flow.
     *
     * NOTE: By enabling this feature sensitive information might be written to the logfile.
     */
    boolean isEnableEnhancedLogging();

    /**
     * Flag indicating if AuthnProfile element should be used or not in the generated
     * sign request. If enable the AuthnProfile will be set to the related signature profile
     * that was being used when generating the signature request.
     */
    boolean isEnableAuthnProfile();

    /**
     * Flag indicating if signed documents should be automatically validated before returned
     * from the support service. If enabled, validation information will be included in the response
     * from completeSignature API call.
     */
    boolean isEnableAutomaticValidation();

    /**
     * Flag indicating if it should be possible to create a signed document using
     * an expired certificate.
     * Default value: false
     */
    boolean isAllowSignWithExpiredCertificate();

    /**
     * Setting indicating the version that should be set in the SignRequestExtension. Default is "1.5" that
     * supports multiple authn context class references.
     */
    String getSignRequestExtensionVersion();

    /**
     * Get visible signature configuration
     * @return VisibleSignatureConfig instance
     */
    VisibleSignatureConfig getVisibleSignature() throws InternalErrorException;

    /**
     * Get timestamp configuration. Required for all profiles except basic (B).
     * @return TimeStampConfig instance
     */
    TimeStampConfig getTimeStamp() throws InternalErrorException;
}
