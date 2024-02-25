import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Vista {
    
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        List<Estudiante> Stud = new ArrayList<>();
        List<Docente> Maestro = new ArrayList<>();
        Map<String, Integer> diccionario = new HashMap<>();
        Map<String, String> pagos = new HashMap<>();
        Map<Estudiante, Docente> Reco = new HashMap<>();
        IExport dataSource = DatasourceFactory.getDataSourceInstance(1);

        // Generar nombres de clases y calificaciones aleatorias
        Random random = new Random();
        String[] nombresClases = {"Matemáticas", "Historia", "Biología", "Literatura", "Física"};
        String[] NombreProf = {"Prof. Pedro", "Prof. Marlene", "Prof. Hector", "Prof. Allen", "Prof. Carlos"};
        String[] Alum = {"Pepito", "Juan", "Paolo", "Ana", "Maria"};
        String[] Ape = {"Camposeco", "Arriola", "Flores", "Lopez", "Aguilar"};
        String[] Pag = {"Pagado", "No Pagado"};
        String[] Pe = {"Cobrado", "Sin pagar"};
        
        for (int i = 0; i < 5; i++) {
            String clase = nombresClases[random.nextInt(nombresClases.length)]; // Seleccionar un nombre de clase aleatorio
            int calificacion = random.nextInt(101); // Generar una calificación aleatoria entre 0 y 100
            diccionario.put(clase, calificacion); // Agregar la entrada al diccionario
            String Name = NombreProf[random.nextInt(NombreProf.length)];
            String Alumno = Alum[random.nextInt(Alum.length)];
            String Apelli = Ape[random.nextInt(Ape.length)];
            String Paga = Pag[random.nextInt(Pag.length)];
            String Co = Pe[random.nextInt(Pe.length)];
            Docente Profe = new Docente(Name, clase, calificacion, Co);
            Estudiante Ni = new Estudiante(Alumno, Apelli, Paga);
            Reco.put(Ni, Profe);
            Stud.add(Ni);
            Maestro.add(Profe);
        }

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String[] estadosPago = {"Pagado", "No pagado"};

        for (String mes : meses) {
            String estado = estadosPago[random.nextInt(estadosPago.length)]; // Seleccionar un estado de pago aleatorio
            pagos.put(mes, estado); // Agregar la entrada al diccionario
        }

        for (Map.Entry<Estudiante, Docente> entry : Reco.entrySet()) {
            Estudiante clave = entry.getKey();
            Docente valor = entry.getValue();
            System.out.println("Alumno: " + clave.getNombre() + ", Apellido: " + clave.getApellido() +
                    " --> Profesor: " + valor.getNombre() + ", Materia: " + valor.getMateria() + ",Nota" + valor.getNota());
        }

        System.out.println("¿Que Rol desempeña?");
        System.out.println("1) Estudiante");
        System.out.println("2) Docente");
        System.out.println("3) Personal administrativo");
        System.out.println("4) Auditor externo");

        int opc = teclado.nextInt();
        teclado.nextLine();
        switch (opc) {
            case 1:
                
            System.out.println("¿Qué deseas realizar?");
            System.out.println("1) Consulta de notas");
            System.out.println("2) Realizar pago");
            System.out.println("3) Consulta de pagos");
            System.out.println("4) ¿En que tipo de archivo desea guardar sus datos?");

            int A = teclado.nextInt();
            teclado.nextLine();
            
            if (A == 1){

                System.out.println("¿Qué clase desea consultar?");
                System.out.println("Matemáticas");
                System.out.println("Historia");
                System.out.println("Biología");
                System.out.println("Literatura");
                System.out.println("Física");
                String B = teclado.nextLine();
                if (diccionario.containsKey(B)) {
                    // Obtener y mostrar la calificación de la clase
                    int calificacion = diccionario.get(B);
                    System.out.println("La calificación de " + B + " es: " + calificacion);
                } else {
                    System.out.println("La clase especificada no se encontró en el diccionario.");
                }
                
            }
            if (A == 2){

                System.out.println("¿Qué mes desea pagar?");
                System.out.println("Enero");
                System.out.println("Febrero");
                System.out.println("Marzo");
                System.out.println("Abril");
                System.out.println("Mayo");
                System.out.println("Juio");
                System.out.println("Julio");
                System.out.println("Agosto");
                System.out.println("Septiembre");
                System.out.println("Octubre");
                System.out.println("Noviembre");
                System.out.println("Diciembre");
                String D = teclado.nextLine();

                if (pagos.containsKey(D)) {
                    // Actualizar el estado de pago de la clase
                    pagos.put(D, "Pagado");
                    System.out.println("Estado de pago actualizado correctamente.");
                } else {
                    System.out.println("Mes equivocado");
                }

            }

            if (A == 3){

                for (Map.Entry<String, String> entry : pagos.entrySet()) {
                    System.out.println("Mes: " + entry.getKey() + ", Estado de pago: " + entry.getValue());
                }

            }
            if (A == 4){
                
                System.out.println("1) CSV");
                System.out.println("2) Json");
                System.out.println("3) XML");
                int H = teclado.nextInt();
                teclado.nextLine();
                    
                

                if (H == 1){
                    File Note = dataSource.SaveNote(diccionario, "Notas.CSV");
                    File Pagos = dataSource.SavePagos(pagos, "Pagos.CSV");
                }
                if (H == 2){
                    File J = dataSource.SaveNote(diccionario, "Notas.Json");
                    File K = dataSource.SavePagos(pagos, "Pagos.Json");
                }
                if (H == 3){
                    File L = dataSource.SaveNote(diccionario, "Notas.xml");
                    File C = dataSource.SaveNote(diccionario, "Pagos.xml");
                }

            }

            break;
            case 2:

            System.out.println("¿Qué deseas realizar?");
            System.out.println("1) Ingresar notas");
            System.out.println("2) Cobrar Pago");
            System.out.println("3) Historial de Pagos");
            System.out.println("4) ¿En que tipo de archivo desea guardar sus datos?");
            int H = teclado.nextInt();
            teclado.nextLine();

            if (H == 1){

                System.out.println("Ingrese su nombre");
                String Name = teclado.nextLine();
                System.out.println("Ingrese la nueva nota");
                int Num = teclado.nextInt();
                teclado.nextLine();
                System.out.println("Ingrese el nombre del estudiante");
                String el = teclado.nextLine();
                System.out.println("Ingrese el apellido del estudiante");
                String ape = teclado.nextLine();
                System.out.println("Ingrese el estado del estudiante");
                String fe = teclado.nextLine();

                Estudiante nuevo = new Estudiante(el, ape, fe);
                Docente bue = Reco.get(nuevo);

                System.out.println(bue);

                if (bue != null) {
                    // Modificar el dato de la clase
                    bue.setNota(Num);
        
                    // Mostrar el cambio
                    System.out.println("Nueva nota: " + bue.getNota());
                } else {
                    System.out.println("No se encontró el alumno");
                }


            }
            if (H == 2){

                System.out.println("¿Qué mes desea cobrar?");
                System.out.println("Enero");
                System.out.println("Febrero");
                System.out.println("Marzo");
                System.out.println("Abril");
                System.out.println("Mayo");
                System.out.println("Juio");
                System.out.println("Julio");
                System.out.println("Agosto");
                System.out.println("Septiembre");
                System.out.println("Octubre");
                System.out.println("Noviembre");
                System.out.println("Diciembre");
                String D = teclado.nextLine();

                if (pagos.containsKey(D)) {
                    // Actualizar el estado de pago de la clase
                    pagos.put(D, "Pagado");
                    System.out.println("Estado de pago actualizado correctamente.");
                } else {
                    System.out.println("Mes equivocado");
                }

            }
            if (H == 3){

                for (Map.Entry<String, String> entry : pagos.entrySet()) {
                    System.out.println("Clase: " + entry.getKey() + ", Estado de pago: " + entry.getValue());
                }

            }
            if (H == 4){

                System.out.println("1) CSV");
                System.out.println("2) Json");
                System.out.println("3) XML");
                int w = teclado.nextInt();
                teclado.nextLine();
                    
                

                if (w == 1){
                    File Note = dataSource.SaveNote(diccionario, "Notas.CSV");
                    File Cobro = dataSource.SavePagos(pagos, "Pagos.CSV");
                }
                if (w == 2){
                    File J = dataSource.SaveNote(diccionario, "Notas.Json");
                    File K = dataSource.SavePagos(pagos, "Pagos.Json");
                }
                if (w == 3){
                    File L = dataSource.SaveNote(diccionario, "Notas.xml");
                    File C = dataSource.SaveNote(diccionario, "Pagos.xml");
                }

            }

            break;
            case 3:

            System.out.println("¿Qué deseas realizar?");
            System.out.println("1) Contratar Docente");
            System.out.println("2) Inscribir estudiante");
            System.out.println("3) Asignar estudiante");
            System.out.println("4) Asignar Docente");
            System.out.println("5) Asignar Pago a Docente");
            System.out.println("6) Resumen de notas y pagos");
            System.out.println("7) ¿En que tipo de archivo desea guardar sus datos?");
            int G = teclado.nextInt();
            teclado.nextLine();

            if (G == 1){

                System.out.println("Ingrese el nombre del docente");
                String N = teclado.nextLine();
                System.out.println("Ingrese la clase que impartira");
                String m = teclado.nextLine();
                int o = random.nextInt(101);
                String k = "Cobrado";

                Docente New = new Docente(N, m, o, k);
                Maestro.add(New);

            }
            if (G == 2){

                System.out.println("Ingrese el nombre del alumno");
                String N = teclado.nextLine();
                System.out.println("Ingrese su apellido");
                String m = teclado.nextLine();
                String p = "Pagado";

                Estudiante mew = new Estudiante(N, m, p);
                Stud.add(mew);

            }
            if (G == 3){
                
                System.out.println("Ingrese el nombre del alumno");
                String N = teclado.nextLine();
                System.out.println("Ingrese su apellido");
                String m = teclado.nextLine();
                System.out.println("Ingrese el nombre del docente");
                String n = teclado.nextLine();
                System.out.println("Ingrese la clase");
                String M = teclado.nextLine();
                int o = random.nextInt(101);
                String k = "Cobrado";
                String p = "Pagado";

                Estudiante mew = new Estudiante(N, m, p);
                Docente New = new Docente(n, M, o, k);
                Reco.put(mew, New);
                for (Map.Entry<Estudiante, Docente> entry : Reco.entrySet()) {
                    Estudiante clave = entry.getKey();
                    Docente valor = entry.getValue();
                    System.out.println("Alumno: " + clave.getNombre() + ", Apellido: " + clave.getApellido() +
                            " --> Profesor: " + valor.getNombre() + ", Materia: " + valor.getMateria() + ",Nota" + valor.getNota());
                }

            }
            if (G == 4){

                System.out.println("Ingrese el nombre del docente");
                String n = teclado.nextLine();
                System.out.println("Ingrese el nuevo curso del docente");
                String h = teclado.nextLine();
                for (Docente producto : Maestro) {
                    if (producto.getNombre().equals(n)) {
                        // Encontramos el producto por su nombre
        
                        // Modificar un atributo de la clase (por ejemplo, el precio)
                        producto.setMateria(h);
        
                        // Imprimir la lista de productos después de la modificación
                        System.out.println("Docentes:");
                        for (Docente p : Maestro) {
                            System.out.println("Nombre: " + p.getNombre() + ", Materia" + p.getMateria());
                        }
        
                        break; // Terminar el bucle después de encontrar el producto
                    }
                }

            }
            if (G == 5){

                System.out.println("¿Qué mes desea cobrar?");
                System.out.println("Enero");
                System.out.println("Febrero");
                System.out.println("Marzo");
                System.out.println("Abril");
                System.out.println("Mayo");
                System.out.println("Juio");
                System.out.println("Julio");
                System.out.println("Agosto");
                System.out.println("Septiembre");
                System.out.println("Octubre");
                System.out.println("Noviembre");
                System.out.println("Diciembre");
                String D = teclado.nextLine();

                if (pagos.containsKey(D)) {
                    // Actualizar el estado de pago de la clase
                    pagos.put(D, "Pagado");
                    System.out.println("Estado de pago actualizado correctamente.");
                } else {
                    System.out.println("Mes equivocado");
                }

            }
            if (G == 6){

                for (Map.Entry<Estudiante, Docente> entry : Reco.entrySet()) {
                    Estudiante clave = entry.getKey();
                    Docente valor = entry.getValue();
                    System.out.println("Alumno: " + clave.getNombre() + ", Apellido: " + clave.getApellido() +
                            " --> Profesor: " + valor.getNombre() + ", Materia: " + valor.getMateria() + ",Nota" + valor.getNota());
                }
                for (Map.Entry<String, String> entry : pagos.entrySet()) {
                    System.out.println("Mes: " + entry.getKey() + ", Estado de pago: " + entry.getValue());
                }
                
            }
            if (G == 7){
             
                System.out.println("1) CSV");
                System.out.println("2) Json");
                System.out.println("3) XML");
                int w = teclado.nextInt();
                teclado.nextLine();
                    
                if (w == 1){
                    File Note = dataSource.SaveNote(diccionario, "Notas.CSV");
                    File Pagos = dataSource.SavePagos(pagos, "Pagos.CSV");
                    File Todo = dataSource.SaveStudDoc(Reco, "Direccion.CSV");
                    File el = dataSource.SaveDoc(Maestro, "PagoMaestros.CSV");
                    File lo = dataSource.SaveStud(Stud, "PagoEstudiantes.CSV");
                }
                if (w == 2){
                    File J = dataSource.SaveNote(diccionario, "Notas.Json");
                    File K = dataSource.SavePagos(pagos, "Pagos.Json");
                    File Todo = dataSource.SaveStudDoc(Reco, "Direccion.Json");
                    File el = dataSource.SaveDoc(Maestro, "PagoMaestros.Json");
                    File lo = dataSource.SaveStud(Stud, "PagoEstudiantes.Json");
                }
                if (w == 3){
                    File L = dataSource.SaveNote(diccionario, "Notas.xml");
                    File C = dataSource.SaveNote(diccionario, "Pagos.xml");
                    File Todo = dataSource.SaveStudDoc(Reco, "Direccion.xml");
                    File el = dataSource.SaveDoc(Maestro, "PagoMaestros.xml");
                    File lo = dataSource.SaveStud(Stud, "PagoEstudiantes.xml");
                }

            }

            break;
            case 4:

            System.out.println("¿Qué deseas realizar?");
            System.out.println("1) Consulta de notas");
            System.out.println("2) Cuotas de estudiantes");
            System.out.println("3) Pagos a Docentes");
            System.out.println("4) ¿En que tipo de archivo desea guardar sus datos?");

            int L = teclado.nextInt();
            teclado.nextLine();

            if (L == 1){

                for (Map.Entry<Estudiante, Docente> entry : Reco.entrySet()) {
                    Estudiante clave = entry.getKey();
                    Docente valor = entry.getValue();
                    System.out.println("Alumno: " + clave.getNombre() + ", Apellido: " + clave.getApellido() +
                            " --> Profesor: " + valor.getNombre() + ", Materia: " + valor.getMateria() + ",Nota" + valor.getNota());
                }

            }
            if (L == 2){

                for (Map.Entry<Estudiante, Docente> entry : Reco.entrySet()) {
                    Estudiante clave = entry.getKey();
                    Docente valor = entry.getValue();
                    System.out.println("Alumno: " + clave.getNombre() + ", Apellido: " + clave.getApellido() + clave.getPagos());
                }

            }
            if (L == 3){

                for (Map.Entry<Estudiante, Docente> entry : Reco.entrySet()) {
                    Estudiante clave = entry.getKey();
                    Docente valor = entry.getValue();
                    System.out.println(
                            "Profesor: " + valor.getNombre() + ", Materia: " + valor.getMateria() + ",Estado" + valor.getCobro());
                }

            }
            if (L == 4){

                System.out.println("1) CSV");
                System.out.println("2) Json");
                System.out.println("3) XML");
                int w = teclado.nextInt();
                teclado.nextLine();
                    
                if (w == 1){
                    File Note = dataSource.SaveNote(diccionario, "Notas.CSV");
                    File el = dataSource.SaveDoc(Maestro, "PagoMaestros.CSV");
                    File lo = dataSource.SaveStud(Stud, "PagoEstudiantes.CSV");
                }
                if (w == 2){
                    File J = dataSource.SaveNote(diccionario, "Notas.Json");
                    File el = dataSource.SaveDoc(Maestro, "PagoMaestros.Json");
                    File lo = dataSource.SaveStud(Stud, "PagoEstudiantes.Json");
                }
                if (w == 3){
                    File o = dataSource.SaveNote(diccionario, "Notas.xml");
                    File el = dataSource.SaveDoc(Maestro, "PagoMaestros.xml");
                    File lo = dataSource.SaveStud(Stud, "PagoEstudiantes.xml");
                }

            }

            break;
            case 5:

            break;
            case 6:

            break;
            case 7:

            break;
            case 8:
            break;
        }
            

    }

}
