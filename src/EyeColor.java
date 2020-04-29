import javax.naming.ldap.PagedResultsControl;

public enum EyeColor {
    Blue("Blue"),
    Green("Green"),
    Brown(""),
    Gray(""),
    Gold(""),
    Black("");

    private String description;
    EyeColor(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
