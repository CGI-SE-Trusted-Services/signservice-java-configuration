package se.signatureservice.configuration.support.system;

import se.signatureservice.configuration.common.InternalErrorException;
import se.signatureservice.configuration.common.utils.ConfigUtils;

import java.util.Map;

/**
 * Representation of all configuration needed for visible signatures.
 *
 * @author Tobias Agerberg
 */
public class VisibleSignatureConfig {

    /**
     * Flag to enable/disable visible signatures in signed PDF documents. Visible signatures
     * will only be included if all required attributes for visible signatures are included
     * in the "signatureAttributes" parameters in call to prepareSignature.
     * Default is disabled.
     */
    boolean enable = false;

    /**
     * Class path to font file to use when rendering text for visible signature.
     * Default, if not specified, is PT Serif Regular.
     */
    String font = null;

    /**
     * Font size for rendered text.
     * Default size is 9.
     */
    float fontSize = 9;

    /**
     * Font color for rendered text.
     * Default is black.
     */
    String fontColor = "#000000";

    /**
     * Background for rendered text.
     * Default is white.
     */
    String backgroundColor = "#ffffff";

    /**
     * Flag to control if logo image should be displayed or not
     * within the visible signature.
     * Default is true.
     */
    boolean showLogo = true;

    /**
     * Class path to logo image to display if `showLogo` is enabled.
     * Default: CGI logo
     */
    String logoImage = "/visibleSignatures/Default_Logo.png";

    /**
     * Flag to control if header line should be displayed or not.
     * Default is true.
     */
    boolean showHeadline = true;

    /**
     * Text content of header line to display.
     * Default is "Document Digital Signed"
     */
    String headlineText = "Document Digital Signed";

    /**
     * Label to use before name of signer.
     * Default is "Signer"
     */
    String signerLabel = "Signer";

    /**
     * Label to use before time stamp.
     * Default is "Time"
     */
    String timeStampLabel = "Time";

    /**
     * Padding to use around text.
     * Default is 50.
     */
    float textPadding = 50;

    /**
     * Create visible signature configuration with default values.
     */
    public VisibleSignatureConfig(){
    }

    /**
     * Create visible signature configuration based on given map values.
     *
     * @param config Map containing visible signature configuration parameters
     * to use, that will override default configuration values.
     */
    public VisibleSignatureConfig(Map<String,String> config) throws InternalErrorException {
        if(config != null){
            enable = ConfigUtils.parseBoolean(config.get("enable"), "Invalid value for 'enable' in visibleSignature configuration", false, enable);
            font = ConfigUtils.parseString(config.get("font"), "Invalid value for 'font' in visibleSignature configuration", false, font);
            fontSize = ConfigUtils.parseFloat(config.get("fontSize"), "Invalid value for 'fontSize' in visibleSignature configuration", false, fontSize);
            showLogo = ConfigUtils.parseBoolean(config.get("showLogo"), "Invalid value for 'showLogo' in visibleSignature configuration", false, showLogo);
            logoImage = ConfigUtils.parseString(config.get("logoImage"), "Invalid value for 'logoImage' in visibleSignature configuration", false, logoImage);
            showHeadline = ConfigUtils.parseBoolean(config.get("showHeadline"), "Invalid value for 'showHeadline' in visibleSignature configuration", false, showHeadline);
            headlineText = ConfigUtils.parseString(config.get("headlineText"), "Invalid value for 'headlineText' in visibleSignature configuration", false, headlineText);
            signerLabel = ConfigUtils.parseString(config.get("signerLabel"), "Invalid value for 'signerLabel' in visibleSignature configuration", false, signerLabel);
            timeStampLabel = ConfigUtils.parseString(config.get("timeStampLabel"), "Invalid value for 'timeStampLabel' in visibleSignature configuration", false, timeStampLabel);
            textPadding = ConfigUtils.parseFloat(config.get("textPadding"), "Invalid value for 'textPadding' in visibleSignature configuration", false, textPadding);

            try {
                String colorHex = ConfigUtils.parseString(config.get("fontColor"), "Invalid value for 'fontColor' in visibleSignature configuration", false, null);
                if(colorHex != null){
                    fontColor = colorHex;
                }
            } catch(Exception e){
                throw new InternalErrorException("Invalid color specified for 'fontColor' in visibleSignature configuration: ${e.message}");
            }

            try {
                String colorHex = ConfigUtils.parseString(config.get("backgroundColor"), "Invalid value for 'backgroundColor' in visibleSignature configuration", false, null);
                if(colorHex != null){
                    backgroundColor = colorHex;
                }
            } catch(Exception e){
                throw new InternalErrorException("Invalid color specified for 'backgroundColor' in visibleSignature configuration: ${e.message}");
            }
        }
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public float getFontSize() {
        return fontSize;
    }

    public void setFontSize(float fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public boolean isShowLogo() {
        return showLogo;
    }

    public void setShowLogo(boolean showLogo) {
        this.showLogo = showLogo;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }

    public boolean isShowHeadline() {
        return showHeadline;
    }

    public void setShowHeadline(boolean showHeadline) {
        this.showHeadline = showHeadline;
    }

    public String getHeadlineText() {
        return headlineText;
    }

    public void setHeadlineText(String headlineText) {
        this.headlineText = headlineText;
    }

    public String getSignerLabel() {
        return signerLabel;
    }

    public void setSignerLabel(String signerLabel) {
        this.signerLabel = signerLabel;
    }

    public String getTimeStampLabel() {
        return timeStampLabel;
    }

    public void setTimeStampLabel(String timeStampLabel) {
        this.timeStampLabel = timeStampLabel;
    }

    public float getTextPadding() {
        return textPadding;
    }

    public void setTextPadding(float textPadding) {
        this.textPadding = textPadding;
    }
}