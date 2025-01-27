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
package se.signatureservice.configuration.common.cache;

import se.signatureservice.configuration.common.InternalErrorException;
import se.signatureservice.configuration.common.InvalidArgumentException;

import java.io.IOException;
import java.util.Properties;

/**
 * Interface defining method used to store and fetch objects from an underlying cache provider.
 *
 * Created by philip on 08/02/17.
 */
public interface CacheProvider {

    /**
     * Method called by CacheService to initialize this provider.
     *
     * @param properties configuration from system configuration, never null.
     *
     * @throws InvalidArgumentException if invalid properties was found.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    void init(Properties properties) throws InvalidArgumentException, IOException, InternalErrorException;

    /**
     * Method to retrieve a String representation of a cached value from cache.
     *
     * Used for object with a global scope or where context is calculated manually using a unique key.
     *
     * @param key the key identifying the object.
     * @return the related value string of null if no valid related value was found.
     * @throws InvalidArgumentException invalid key was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    String get(String key) throws InvalidArgumentException, IOException, InternalErrorException;

    /**
     * Method to retrieve a String representation of a cached value from cache.
     *
     * @param contextId the id of the transaction or session or other applicable context.
     * @param key the key identifying the object.
     * @return the related value string of null if no valid related value was found.
     * @throws InvalidArgumentException invalid key was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    String get(String contextId, String key) throws InvalidArgumentException, IOException, InternalErrorException;

    /**
     * Method to retrieve a binary representation of a cached value from cache.
     *
     * Used for object with a global scope or where context is calculated manually using a unique key.
     *
     * @param key the key identifying the object.
     * @return the related value string of null if no valid related value was found.
     * @throws InvalidArgumentException invalid key was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    byte[] getBinary(String key) throws InvalidArgumentException, IOException, InternalErrorException;


    /**
     * Method to retrieve a binary representation of a cached value from cache.
     *
     * @param contextId the id of the transaction or session or other applicable context.
     * @param key the key identifying the object.
     * @return the related value string of null if no valid related value was found.
     * @throws InvalidArgumentException invalid key was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    byte[] getBinary(String contextId, String key) throws InvalidArgumentException, IOException, InternalErrorException;

    /**
     * Method to set a String representation of a object that should be cached.
     *
     * Used for object with a global scope or where context is calculated manually using a unique key.
     *
     * @param key the key identifying the object.
     * @param value String represation of the value
     * @throws InvalidArgumentException invalid key or value was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    void set(String key, String value) throws InvalidArgumentException, IOException, InternalErrorException;


    /**
     * Method to set a String representation of a object that should be cached.
     *
     * @param contextId the id of the transaction or session or other applicable context.
     * @param key the key identifying the object.
     * @param value String represation of the value
     * @throws InvalidArgumentException invalid key or value was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    void set(String contextId, String key, String value) throws InvalidArgumentException, IOException, InternalErrorException;

    /**
     * Method to set a String representation of a object that should be cached.
     *
     * Used for object with a global scope or where context is calculated manually using a unique key.
     *
     * @param key the key identifying the object.
     * @param value String representation of the value
     * @param metaData containing extra meta data related to the object such as time to live etc. If no meta data
     * tag is supplied is the provider default time to live used.
     * @throws InvalidArgumentException invalid key or value was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    void set(String key, String value, MetaData metaData) throws InvalidArgumentException, IOException, InternalErrorException;

    /**
     * Method to set a String representation of a object that should be cached.
     *
     * @param contextId the id of the transaction or session or other applicable context.
     * @param key the key identifying the object.
     * @param value String representation of the value
     * @param metaData containing extra meta data related to the object such as time to live etc. If no meta data
     * tag is supplied is the provider default time to live used.
     * @throws InvalidArgumentException invalid key or value was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    void set(String contextId, String key, String value, MetaData metaData) throws InvalidArgumentException, IOException, InternalErrorException;

    /**
     * Method to set a Binary representation of a object that should be cached.
     *
     * Used for object with a global scope or where context is calculated manually using a unique key.
     *
     * @param key the key identifying the object.
     * @param value binary representation of the value
     * @throws InvalidArgumentException invalid key or value was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    void set(String key, byte[] value) throws InvalidArgumentException, IOException, InternalErrorException;

    /**
     * Method to set a Binary representation of a object that should be cached.
     *
     * @param contextId the id of the transaction or session or other applicable context.
     * @param key the key identifying the object.
     * @param value binary representation of the value
     * @throws InvalidArgumentException invalid key or value was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    void set(String contextId, String key, byte[] value) throws InvalidArgumentException, IOException, InternalErrorException;

    /**
     * Method to set a Binary representation of a object that should be cached.
     *
     * Used for object with a global scope or where context is calculated manually using a unique key.
     *
     * @param key the key identifying the object.
     * @param value binary representation of the value
     * @param metaData containing extra meta data related to the object such as time to live etc. If no meta data
     * tag is supplied is the provider default time to live used.
     * @throws InvalidArgumentException invalid key or value was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    void set(String key, byte[] value, MetaData metaData) throws InvalidArgumentException, IOException, InternalErrorException;

    /**
     * Method to set a Binary representation of a object that should be cached.
     *
     * @param contextId the id of the transaction or session or other applicable context.
     * @param key the key identifying the object.
     * @param value binary representation of the value
     * @param metaData containing extra meta data related to the object such as time to live etc. If no meta data
     * tag is supplied is the provider default time to live used.
     * @throws InvalidArgumentException invalid key or value was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    void set(String contextId, String key, byte[] value, MetaData metaData) throws InvalidArgumentException, IOException, InternalErrorException;

    /**
     * Method to delete an object from the cache.
     *
     * @param key The key identifying the object to delete
     * @throws InvalidArgumentException invalid key or value was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    void delete(String key) throws InvalidArgumentException, IOException, InternalErrorException;

    /**
     * Method to delete an object from the cache with a specific context.
     *
     * @param contextId The id of the transaction or session or other applicable context.
     * @param key The key identifying the object to delete
     * @throws InvalidArgumentException invalid key or value was given.
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    void delete(String contextId, String key) throws InvalidArgumentException, IOException, InternalErrorException;

    /**
     * Method signaling to the provider that the connection should be closed down and resources should be released.
     *
     * @throws java.io.IOException if communication problems occurred with underlying systems.
     * @throws InternalErrorException internal error occurred in the system.
     */
    void close() throws IOException, InternalErrorException;

}