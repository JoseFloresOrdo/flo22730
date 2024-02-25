import java.io.File;
import java.util.List;
import java.util.Map;

public interface IExport {
    public File SaveNote(Map<String, Integer> students, String path);
    public File SavePagos(Map<String, String> students, String path);
    public File SaveStudDoc(Map<Estudiante, Docente> students, String path);
    public File SaveStud(List<Estudiante> students, String path);
    public File SaveDoc(List<Docente> students, String path);
}
