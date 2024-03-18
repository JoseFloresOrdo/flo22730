public class Factory<T> {
    
    private IStack<T> Factorio = null;

    public IStack<T> CreateStack(String elec){
        switch(elec){
            case "MD5":
            Factorio = new MD5();
            case "Organica":
            Factorio = new Organica();
            case "SHA-1":
            Factorio = new SHA-1();
        }
    }

}
