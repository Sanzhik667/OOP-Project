package Users;

import java.io.Serializable;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Admin extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    public Admin(String id, String firstName, String lastName, String email, String password, String role) {
        super(id, firstName, lastName, email, password, role);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + getId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", role='" + getRole() + '\'' +
                '}';
    }
}


