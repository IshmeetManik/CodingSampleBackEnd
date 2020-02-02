package net.sample.doctor.docapp.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient {

        private long id;
        private String firstName;
        private String lastName;
        private String phoneNumber;

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }

    @OneToMany(targetEntity = Address.class,mappedBy = "patient",fetch  =FetchType.EAGER,cascade ={ CascadeType.ALL}
            ,orphanRemoval=true)
    public Set<Address> getAddressSet() {
        return addressSet;
    }



        private Set<Address> addressSet;

        public Patient() {

        }

        public Patient(String firstName, String lastName, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }

        @Column(name = "first_name", nullable = false)
        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        @Column(name = "last_name", nullable = false)
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Column(name = "phone_number", nullable = false)
        public String getPhoneNumber() {
            return phoneNumber;
        }
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + phoneNumber
                    + "]";
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return getId() == patient.getId() ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}


