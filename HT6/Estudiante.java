public class Estudiante{
    
    public String name;
    public String phone;
    public String email;
    public String postalZip;
    public String country;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostalZip() {
        return this.postalZip;
    }

    public void setPostalZip(String postalZip) {
        this.postalZip = postalZip;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString(){
        String est= "Nombre: "+name+"\nTeléfono: "+phone+"\nemail: "+email+"\nCódigo Postal: "+postalZip+"\nPais: "+ country;
        return est;
    }

    public String toStringNac(){
        String est= "Nombre: "+name+" Teléfono: "+phone+" email: "+email+" Código Postal: "+postalZip;
        return est;
    }


}
