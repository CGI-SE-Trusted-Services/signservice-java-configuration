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
package se.signatureservice.configuration.common;

/**
 * Exception that indicates an internal error occurred in the system.
 *
 * Created by philip on 08/02/17.
 */
public class InternalErrorException extends Exception {

    /**
     * Exception that indicates an internal error occurred in the system.
     * @param message description of the exception.
     */
    public InternalErrorException(String message){
        super(message);
    }

    /**
     * Exception that indicates an internal error occurred in the system.
     * @param message description of the exception.
     * @param cause optional cause of the exception.
     */
    public InternalErrorException(String message, Throwable cause){
        super(message,cause);
    }
}
