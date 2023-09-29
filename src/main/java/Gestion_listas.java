import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Gestion_listas {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("*****GESTION DE LISTAS*****");

        System.out.println("Cuantos funcionarios trabajan en la empresa?: ");
        int count = Integer.parseInt(scanner.nextLine());

        List<Usuarios> listausuarios = new ArrayList<>(count);

        for (int i = 1; i <= count; i++){

            System.out.println("Ingrese el cargo del funcionario: ");
            String charge = scanner.nextLine();

            System.out.println("Ingrese cedula del funcionario #: "+i);
            String document = scanner.nextLine();

            System.out.println("Ingrese el nombre del funcionario: ");
            String name = scanner.nextLine();

            System.out.println("Ingrese el apellido del funcionario: ");
            String lastname = scanner.nextLine();

            System.out.println("Ingrese la edad del funcionario: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese la fecha de registro del funcionario: ");
            String date = scanner.nextLine();

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date convert = format.parse(date);

            System.out.println("Ingrese el tipo de contrato del funcionario: ");
            String type  = scanner.nextLine();

            if (charge.equals("") || document.equals("") || name.equals("") || lastname.equals("") || age <=  0 || date.equals("") || type.equals("") ){
                System.out.println("Uno o mas campos no cumplen con los criterios minimos");
                i--;
            }else {
                Usuarios usuarios = new Usuarios(charge, document, name, lastname, age, convert, type);
                listausuarios.add(usuarios);
            }
        }

        System.out.println("Se han agregado con exito una cantidad de "+count+ " funcionario.");

        boolean aux = true;

        while (aux) {

            System.out.println("1. Consultar un dato en la lista: ");
            System.out.println("2. Editar dato del funcionario: ");
            System.out.println("3. Terminar y almacenar en base de datos: ");

            System.out.println("Ingrese un numero entre 1 - 3: ");
            int result = Integer.parseInt(scanner.nextLine());

            switch (result) {
                case 1:
                    System.out.println("Ingrese el documento del funcionario del cual quiere consultar su informacion: ");
                    String document_consult = scanner.nextLine();

                    Select_One(listausuarios, document_consult);

                    break;
                case 2:
                    System.out.println("Ingrese el documento del funcionario a modificar: ");
                    String document = scanner.nextLine();

                    System.out.println("Ingrese el nuevo cargo del funcionario (si aplica): ");
                    String charge = scanner.nextLine();

                    System.out.println("Ingrese el nuevo nombre del funcionario (si aplica): ");
                    String name = scanner.nextLine();

                    System.out.println("Ingrese el nuevo apellido del funcionario (si aplica): ");
                    String lastname = scanner.nextLine();

                    System.out.println("Ingrese la nueva edad del funcionario (si aplica): ");
                    int age = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese la nueva fecha de registro del funcionario (si aplica): ");
                    String date = scanner.nextLine();

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date convert = format.parse(date);

                    System.out.println("Ingrese el nuevo tipo de contrato del funcionario (si aplica): ");
                    String type = scanner.nextLine();

                    Usuarios usuarios = new Usuarios (charge, document, name, lastname, age, convert, type);
                    Edit(listausuarios, usuarios);

                    for (int i = 0; i < listausuarios.size(); i++){
                        System.out.println("Personas almacenadas hasta el momento: "+listausuarios.get(i).getName());
                    }
                    break;

                case 3:
                    aux = false;
                    break;
            }
        }
        Insert(listausuarios);
    }

    private static void Select_One(List<Usuarios> listausuarios, String document_consult) {

        for (int i=0; i < listausuarios.size(); i++) {
            if (document_consult.equals(listausuarios.get(i).getDocument())) {
                listausuarios.get(i);

                System.out.println("Este es el documento: "+listausuarios.get(i));
            }
        }
    }

    public static void Edit(List<Usuarios> listausuarios, Usuarios usuarios) {

        for (int i = 0; i < listausuarios.size(); i++) {

            if (usuarios.getDocument().equals(listausuarios.get(i).getDocument())){
                listausuarios.get(i).setCharge(usuarios.getCharge());
                listausuarios.get(i).setName(usuarios.getName());
                listausuarios.get(i).setLastname(usuarios.getLastname());
                listausuarios.get(i).setAge(usuarios.getAge());
                listausuarios.get(i).setDate(usuarios.getDate());
                listausuarios.get(i).setType(usuarios.getType());
                listausuarios.get(i).setDocument(usuarios.getDocument());
                System.out.println("FUNCIONARIO EDITADO CON EXITO: "+listausuarios.get(i).getDocument());
            }
        }
    }

    public static void Insert(List<Usuarios> listausuarios){

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/listas";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios");

            // Preparar la sentencia
            for (int i = 0; i < listausuarios.size(); i++){
                String sql = "INSERT INTO usuarios (cargo, documento, nombre, apellido, edad, fecha_registro, tipo_contrato) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, listausuarios.get(i).getCharge());
                preparedStatement.setString(2, listausuarios.get(i).getDocument());
                preparedStatement.setString(3, listausuarios.get(i).getName());
                preparedStatement.setString(4, listausuarios.get(i).getLastname());
                preparedStatement.setInt(5, listausuarios.get(i).getAge());
                preparedStatement.setString(6, String.valueOf(listausuarios.get(i).getDate()));
                preparedStatement.setString(7, listausuarios.get(i).getType());

                // Ejecutar la sentencia
                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Se ha agregado con exito el funcionario: "+ listausuarios.get(i).getName());
                } else {
                    System.out.println("No se pudo agregar el funcionario: "+ listausuarios.get(i).getName());
                }
            }
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
