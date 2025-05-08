/************************************************************************
 *                                                                       *
 *  Signature Service - Java Configuration Library                       *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public License   *
 *  License as published by the Free Software Foundation; either         *
 *  version 3 of the License, or any later version.                      *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package se.signatureservice.configuration.support.system;

import se.signatureservice.configuration.common.InternalErrorException;
import se.signatureservice.configuration.common.utils.ConfigUtils;

import java.util.Map;

/**
 * Representation of all configuration needed for time stamping.
 *
 * @author Tobias Agerberg
 */
public class TimeStampConfig {

    private static final String DEFAULT_SSL_PROTOCOL = "TLSv1.2";
    private static final String DEFAULT_PROXY_SCHEME = "http";
    private static final Integer DEFAULT_PROXY_PORT = 80;

    /**
     * Time Stamp Authority (TSA) URL to use when requesting time stamp.
     */
    String url;

    /**
     * Username to use for connection to TSA.
     */
    String username;

    /**
     * Password to use for connection to TSA.
     */
    String password;

    /**
     * Path to keystore to use, containing client certificate, when connecting
     * to TSA. Must exist either on file system or on class-path.
     */
    String keyStorePath;

    /**
     * Keystore password.
     */
    String keyStorePassword;

    /**
     * Keystore type ("JKS", or "PKCS12")
     */
    String keyStoreType;

    /**
     * Path to truststore to use, containing trusted TSA server certificate issuers.
     * Must exist either on file system or on class-path.
     */
    String trustStorePath;

    /**
     * Truststore password.
     */
    String trustStorePassword;

    /**
     * Truststore type ("JKS", or "PKCS12").
     */
    String trustStoreType;

    /**
     * Proxy hostname to use.
     */
    String proxyHost;

    /**
     * Proxy port to connect to.
     * (Default: 80)
     */
    int proxyPort;

    /**
     * Proxy scheme to use for connection, ex: "http" or "https".
     * (Default: http)
     */
    String proxyScheme = DEFAULT_PROXY_SCHEME;

    /**
     * Username to use when connecting to proxy.
     */
    String proxyUser;

    /**
     * Password to use when connecting to proxy.
     */
    String proxyPassword;

    /**
     * Comma-separated list of hosts to exclude from the proxy.
     */
    String proxyExcludedHosts;

    /**
     * SSL/TLS protocol to use when connecting to TSA.
     * (Default: "TLS v1.2")
     */
    String sslProtocol = DEFAULT_SSL_PROTOCOL;

    /**
     * Create an empty timestamp configuration.
     */
    public TimeStampConfig(){
    }

    /**
     * Create timestamp configuration based on given map values.
     *
     * @param config Map containing timestamp configuration parameters to use.
     */
    public TimeStampConfig(Map<String,String> config) throws InternalErrorException {
        if (config != null) {
            url = ConfigUtils.parseString(config.get("url"), "Invalid value for 'url' in timeStamp configuration", true, null);
            username = ConfigUtils.parseString(config.get("username"), "Invalid value for 'username' in timeStamp configuration", false, null);
            password = ConfigUtils.parseString(config.get("password"), "Invalid value for 'password' in timeStamp configuration", false, null);
            keyStorePath = ConfigUtils.parseString(config.get("keyStorePath"), "Invalid value for 'keyStorePath' in timeStamp configuration", false, null);
            keyStorePassword = ConfigUtils.parseString(config.get("keyStorePassword"), "Invalid value for 'keyStorePassword' in timeStamp configuration", false, null);
            keyStoreType = ConfigUtils.parseString(config.get("keyStoreType"), "Invalid value for 'keyStoreType' in timeStamp configuration", false, null);
            trustStorePath = ConfigUtils.parseString(config.get("trustStorePath"), "Invalid value for 'trustStorePath' in timeStamp configuration", false, null);
            trustStorePassword = ConfigUtils.parseString(config.get("trustStorePassword"), "Invalid value for 'trustStorePassword' in timeStamp configuration", false, null);
            trustStoreType = ConfigUtils.parseString(config.get("trustStoreType"), "Invalid value for 'trustStoreType' in timeStamp configuration", false, null);
            proxyHost = ConfigUtils.parseString(config.get("proxyHost"), "Invalid value for 'proxyHost' in timeStamp configuration", false, null);
            proxyPort = ConfigUtils.parseInteger(config.get("proxyPort"), "Invalid value for 'proxyPort' in timeStamp configuration", false, DEFAULT_PROXY_PORT);
            proxyScheme = ConfigUtils.parseString(config.get("proxyScheme"), "Invalid value for 'proxyScheme' in timeStamp configuration", false, DEFAULT_PROXY_SCHEME);
            proxyUser = ConfigUtils.parseString(config.get("proxyUser"), "Invalid value for 'proxyUser' in timeStamp configuration", false, null);
            proxyPassword = ConfigUtils.parseString(config.get("proxyPassword"), "Invalid value for 'proxyPassword' in timeStamp configuration", false, null);
            proxyExcludedHosts = ConfigUtils.parseString(config.get("proxyExcludedHosts"), "Invalid value for 'proxyExcludedHosts' in timeStamp configuration", false, null);
            sslProtocol = ConfigUtils.parseString(config.get("sslProtocol"), "Invalid value for 'sslProtocol' in timeStamp configuration", false, null);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKeyStorePath() {
        return keyStorePath;
    }

    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }

    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    public void setKeyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
    }

    public String getKeyStoreType() {
        return keyStoreType;
    }

    public void setKeyStoreType(String keyStoreType) {
        this.keyStoreType = keyStoreType;
    }

    public String getTrustStorePath() {
        return trustStorePath;
    }

    public void setTrustStorePath(String trustStorePath) {
        this.trustStorePath = trustStorePath;
    }

    public String getTrustStorePassword() {
        return trustStorePassword;
    }

    public void setTrustStorePassword(String trustStorePassword) {
        this.trustStorePassword = trustStorePassword;
    }

    public String getTrustStoreType() {
        return trustStoreType;
    }

    public void setTrustStoreType(String trustStoreType) {
        this.trustStoreType = trustStoreType;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getProxyScheme(){
        return proxyScheme;
    }

    public void setProxyScheme(String proxyScheme){
        this.proxyScheme = proxyScheme;
    }

    public String getProxyUser() {
        return proxyUser;
    }

    public void setProxyUser(String proxyUser) {
        this.proxyUser = proxyUser;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public void setProxyPassword(String proxyPassword) {
        this.proxyPassword = proxyPassword;
    }

    public String getProxyExcludedHosts() {
        return proxyExcludedHosts;
    }

    public void setProxyExcludedHosts(String proxyExcludedHosts) {
        this.proxyExcludedHosts = proxyExcludedHosts;
    }

    public String getSslProtocol() {
        return sslProtocol;
    }

    public void setSslProtocol(String sslProtocol) {
        this.sslProtocol = sslProtocol;
    }
}
