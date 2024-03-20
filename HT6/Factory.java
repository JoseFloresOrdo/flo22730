public class Factory {
    
private Hash Factorio = null;

    public Hash CreateStack(String elec){
        switch(elec){
            case "MD5":
            Factorio = new MD5();
            break;
            case "Organica":
            Factorio = new Organica();
            break;
            case "SHA-1":
            Factorio = new SHA1();
            break;
        }
        return Factorio;
    }

}
