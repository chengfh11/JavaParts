package parts;


/**
 * @autor: LuisK
 * @version: 1.0
 * @since: 9:57:54 AM
 */
public enum State {

    ALABAMA("Alabama", "AL"),
    ALASKA("Alaska", "AK"),
    AMERICAN_SAMOA("American Samoa", "AS"),
    ARIZONA("Arizona", "AZ"),
    ARKANSAS("Arkansas", "AR"),
    CALIFORNIA("California", "CA"),
    COLORADO("Colorado", "CO"),
    CONNECTICUT("Connecticut", "CT"),
    DELAWARE("Delaware", "DE"),
    DISTRICT_OF_COLUMBIA("District Of Columbia", "DC"),
    FEDERATED_STATES_OF_MICRONESIA("Federated States Of Micronesia", "FM"),
    FLORIDA("Florida", "FL"),
    GEORGIA("Georgia", "GA"),
    GUAM("Guam", "GU"),
    HAWAII("Hawaii", "HI"),
    IDAHO("Idaho", "ID"),
    ILLINOIS("Illinois", "IL"),
    INDIANA("Indiana", "IN"),
    IOWA("Iowa", "IA"),
    KANSAS("Kansas", "KS"),
    KENTUCKY("Kentucky", "KY"),
    LOUISIANA("Lousiana", "LA"),
    MAINE("Maine", "ME"),
    MARSHALL_ISLANDS("Marshall Islands", "MH"),
    MARYLAND("Maryland", "MD"),
    MASSACHUSETTS("Massachusetts", "MA"),
    MICHIGAN("Michigan", "MI"),
    MINNESOTA("Minnesota", "MN"),
    MISSISSIPPI("Mississsippi", "MS"),
    MISSOURI("Missouri", "MO"),
    MONTANA("Montana", "MT"),
    NEBRASKA("Nebraska", "NE"),
    NEVADA("Nevada", "NV"),
    NEW_HAMPSHIRE("New Hampshire", "NH"),
    NEW_JERSEY("New Jersey", "NJ"),
    NEW_MEXICO("New Mexico", "NM"),
    NEW_YORK("New York", "NY"),
    NORTH_CAROLINA("North Carolina", "NC"),
    NORTH_DAKOTA("North Dakota", "ND"),
    NORTHERN_MARIANA_ISLANDS("Northern Mariana Islands", "MP"),
    OHIO("Ohio", "OH"),
    OKLAHOMA("Oklahoma", "OK"),
    OREGON("Oregon", "OR"),
    OTHER("Other", "OT"),
    PALAU("Palau", "PW"),
    PENNSYLVANIA("Pennsylvania", "PA"),
    PUERTO_RICO("Puerto Rico", "PR"),
    RHODE_ISLAND("Rhode Island", "RI"),
    SOUTH_CAROLINA("South Carolina", "SC"),
    SOUTH_DAKOTA("South Dakota", "SD"),
    TENNESSEE("Tennessee", "TN"),
    TEXAS("Texas", "TX"),
    UTAH("Utah", "UT"),
    VERMONT("Vermont", "VT"),
    VIRGIN_ISLANDS("Virgin Islands", "VI"),
    VIRGINIA("Virginia", "VA"),
    WASHINGTON("Washington", "WA"),
    WEST_VIRGINIA("West Virginia", "WV"),
    WISCONSIN("Wisconsin", "WI"),
    WYOMING("Wyoming", "WY"),
    
    BERMUDA("BERMUDA","Be"),
    BOLIVIA("BOLIVIA","Bo"),
    BRITISH_COLUMBIA("BRITISH COLUMBIA","Br"),
    CANADA("CANADA","Ca"),
    MICRONESIA("MICRONESIA","Fm"),
    FRANCE("FRANCE","Fr"),
    MEXICO("MEXICO","Me"),
    UNITED_ARAB_EMIRATES("UNITED ARAB EMIRATES","UA"),
    SINGAPORE("SINGAPORE","Si"),
    Marshall_Islands("Marshall Islands","MH"),
    GERMANY("GERMANY","Ge"),
    REPUBLIC_OF_PALAU("REPUBLIC OF PALAU","PW"),
    QUEBEC("QUEBEC","Qu");
    
    //Military States    
    /*ARMED_FORCES_AFRICA("Armed Forces Africa", "AE"),
    ARMED_FORCES_AMERICAS_EXCEPT_CANADA("Armed Forces Americas Except Canada", "AA"),
    ARMED_FORCES_CANADA("Armed Forces Canada", "AE"),
    ARMED_FORCES_EUROPE("Armed Forces Europe", "AE"),
    ARMED_FORCES_MIDDLE_EAST("Armed Forces Middle East", "AE"),
    ARMED_FORCES_PACIFIC("Armed Forces Pacific", "AP");*/

    private final String displayName;
    private final String stateAbbreviation;

    State(String displayName, String stateAbbreviation) {
        this.displayName = displayName;
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }


    public static State fromDisplayName(String s) {
        for (State state : values()) {
            if (state.getDisplayName().equals(s)) {
                return state;
            }
        }
        throw new IllegalArgumentException(String.format("No State with display name [%s]", s));
    }

    public static State fromStateAbbreviation(String s) {
        for (State state : values()) {
            if (state.getStateAbbreviation().equals(s)) {
                return state;
            }
        }
        throw new IllegalArgumentException(String.format("No State with state abbreviation [%s]", s));
    }

}

