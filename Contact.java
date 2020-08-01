/**
 * Name: Eric Truong
 * Date: Novmember 13, 2019
 * Description: Create a contact with information
 */

public class Contact {

    /**
     * Person's last name
     */
    private String lastName;

    /**
     * Person's first name
     */
    private String firstName;

    /**
     * Person's phone number
     */
    private String phone;

    /**
     * Person's address
     */
    private String address;

    /**
     * Person's city
     */
    private String city;

    /**
     * Person's zip code
     */
    private String zipCode;

    /**
     * Making a new contact with just last and first names
     * @param x person's last name
     * @param y person's first name
     */
    public Contact(String x, String y){

        lastName = x;

        firstName = y;

        phone = "";

        address = "";

        city = "";

        zipCode = "";
    }

    /**
     * Creating a contact with all their information
     * @param u person's last name
     * @param v person's first name
     * @param w person's phone number
     * @param x person's address
     * @param y person's city
     * @param z person's zip code
     */
    public Contact(String u, String v, String w, String x, String y, String z){

        lastName = u;

        firstName = v;

        phone = w;

        address = x;

        city = y;

        zipCode = z;
    }

    /**
     * Gives person's last name
     * @return  person's last name
     */
    public String getLastName(){

        return lastName;
    }

    /**
     * Gives a person's first name
     * @return  person's first name
     */
    public String getFirstName(){

        return firstName;
    }

    /**
     * Gives a person's phone number
     * @return  person's phone number
     */
    public String getPhone(){

        return phone;
    }

    /**
     * Gives a person's address
     * @return  person's address
     */
    public String getAddress(){

        return address;
    }

    /**
     * Gives a person's city
     * @return  person's city
     */
    public String getCity(){

        return city;
    }

    /**
     * Gives a person's zip code
     * @return  person's zip code
     */
    public String getZipCode(){

        return zipCode;
    }

    /**
     * Sets a person's last name
     * @param x desired last name
     * @return  true if able to be set, false otherwise
     */
    public boolean setLastName(String x){

        if(!x.equals("")){
            lastName = x;
            return true;
        }

        return false;
    }

    /**
     * Sets a person's first name
     * @param x desired first name
     * @return  true if able to be set, false otherwise
     */
    public boolean setFirstName(String x){

        if(!x.equals("")){
            firstName = x;
            return true;
        }

        return false;
    }

    /**
     * Sets a person's phone number
     * @param x desired phone number
     * @return  true if able to be set, false otherwise
     */
    public boolean setPhone(String x){

        if(!x.equals("")){
            phone = x;
            return true;
        }

        return false;
    }

    /**
     * Sets a person's address
     * @param x desired address
     * @return  true if able to be set, false otherwise
     */
    public boolean setAddress(String x) {

        if (!x.equals("")) {
            address = x;
            return true;
        }

        return false;
    }

    /**
     * Sets a person's city
     * @param x desired city
     * @return  true if able to be set, false otherwise
     */
    public boolean setCity(String x) {

        if (!x.equals("")) {
            city = x;
            return true;
        }

        return false;
    }

    /**
     * Sets a person's zip code
     * @param x desired zip code
     * @return  true if able to be set, false otherwise
     */
    public boolean setZipCode(String x) {

        if (!x.equals("")) {
            zipCode = x;
            return true;
        }

        return false;
    }

    /**
     * Puts a person's contact in a nice format
     * @return  person's contact is a printable string
     */
    @Override
    public String toString(){

        return lastName+","+firstName+","+phone+","+address+","+city+","+zipCode;
    }

    /**
     * See if two contacts are the same
     * @param o contact to compare
     * @return  if the first contact is same as second contact
     */
    @Override
    public boolean equals(Object o){

        if(o instanceof Contact){
            Contact f = (Contact) o;
            String last = f.getLastName();
            String first = f.getFirstName();
            return this.lastName.equals(last) && this.firstName.equals(first);
        }

        return false;
    }

    /**
     * Compare two contacts to see which comes first
     * @param f contact to compare
     * @return  whether the first contact comes first or after
     */
    public int compareTo(Contact f){

        String c1 = this.getLastName();
        String c2 = f.getLastName();

        if(c1.compareTo(c2) == 0){

            String d1 = this.getFirstName();
            String d2 = f.getFirstName();
            return d1.compareTo(d2);
        }

        return c1.compareTo(c2);
    }
}
