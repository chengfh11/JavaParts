package junk;

/**
 * Enumeration for bastardized HTTP 1.1 Response codes used
 * by the Kaptest Profile Service. display names are defined
 * in the i18n_labels.properties file.
 * User: byoung
 * Date: Apr 13, 2010
 * Time: 6:10:37 PM
 * @see kaplan.scorelms.settings.service.KaptestProfileService
 */
public enum KaptestProfileServiceResponseCode {
    OK ("kaptest.profile.service.response.ok"),
    BAD_REQUEST ("kaptest.profile.service.response.badRequest"),
    UNAUTHORIZED ("kaptest.profile.service.response.unauthorized"),
    FORBIDDEN ("kaptest.profile.service.response.forbidden"),
    CONFLICT ("kaptest.profile.service.response.conflict"),
    SERVER_ERROR ("kaptest.profile.service.response.error"),
    TIMEOUT ("kaptest.profile.service.response.timeout");

    private String displayName;
    
    /**
     * Constructor with display name argument.
     * @param displayName - the display name
     */
    KaptestProfileServiceResponseCode (String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the display name of this KaptestProfileServiceResponseCode
      * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the display name for this KaptestProfileServiceResponseCode
     * @param displayName - the display name to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
