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

import java.awt.Color;

/**
 * Utility to parse colors.
 *
 * @author Tobias Agerberg
 */
public class ColorParser {

    /**
     * Parse HTML-style hex representation of a color into
     * a java.awt.Color, ex. "#ff1ab4" or "#c3c3c355"
     *
     * Hex-string representation contains values for RED,
     * GREEN, BLUE and ALPHA with two hex-decimal digits
     * for each (#RRGGBBAA). Using two hex-decimal digits
     * each component can get a value between 0 (00) and
     * 255 (FF).
     *
     * @param colorHex Color hex string to parse
     * @return Color based on given input.
     * @throws NumberFormatException if given input cannot be parsed into valid color.
     */
    public static Color parse(String colorHex) throws NumberFormatException {
        Color color;

        if(colorHex == null){
            throw new NumberFormatException("Cannot parse null");
        }

        if(colorHex.startsWith("#")){
            colorHex = colorHex.substring(1);
        }

        if(colorHex.length() != 6 && colorHex.length() != 8){
            throw new NumberFormatException("Input has invalid length");
        }

        try {
            int r = Integer.parseInt(colorHex.substring(0,2), 16);
            int g = Integer.parseInt(colorHex.substring(2,4), 16);
            int b = Integer.parseInt(colorHex.substring(4,6), 16);
            int a = colorHex.length() == 6 ? 255 : Integer.parseInt(colorHex.substring(6,8), 16);

            color = new Color(r,g,b,a);
        } catch(Exception e){
            throw new NumberFormatException("Cannot parse input: ${e.message}");
        }

        return color;
    }
}
