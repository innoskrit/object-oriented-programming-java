package in.innoskrit.exercises.library_management_system.model;

public class Librarian {
    private String id;
    private String name;
    private boolean isAdmin;

    public Librarian(String id, String name, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.isAdmin = isAdmin;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}

