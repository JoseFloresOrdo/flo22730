import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DiccionarioWrapper {
    private Map<String, Integer> diccionario;
    private Map<String, String> Dic;
    private Map<Estudiante, Docente> stud;
    private List<Estudiante> Alum;
    private List<Docente> Doci;

    public List<Docente> getDoci(){
        return Doci;
    }

    public void stDoci(List<Docente> Doci){
        this.Doci = Doci;
    }

    public List<Estudiante> getAlum(){
        return Alum;
    }

    public void setAlum(List<Estudiante> Alum){
        this.Alum = Alum;
    }

    public Map<Estudiante, Docente> getstud() {
        return stud;
    }

    public void setstud(Map<Estudiante, Docente> stud) {
        this.stud = stud;
    }

    public Map<String, Integer> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<String, Integer> diccionario) {
        this.diccionario = diccionario;
    }

    public Map<String, String> getDic(){
        return Dic;
    }

    public void setDic(Map<String, String> Dic){
        this.Dic = Dic;
    }


}