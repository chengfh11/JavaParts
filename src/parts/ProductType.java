package parts;

/**
 * @autor: LuisK
 * @version: 1.0
 * @since: 9:57:54 AM
 */
public enum ProductType {

    onlineStudent("ONLINE"),
    classRoomStudent("CLASSROOM"),
    liveOnlineStudent("LIVEONLINE"),
    tutoringStudent("TUTORING");
    
    private final String displayName;
    

    ProductType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}

