import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Gestion_listasTest {

    @Test
    public void TestEdit() throws ParseException {
        String charge = "Desarrollador jr";
        String document = "123";
        String name = "johan";
        String lastname = "Accardo";
        int age = 23;
        String date = "2023-08-22";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date convert = format.parse(date);
        String type = "Aprendiz";

        Gestion_listas gestion_listas = new Gestion_listas();

        Usuarios usuarios = new Usuarios(charge,document, name, lastname, age, convert, type);
        List<Usuarios> usuariosList = new ArrayList<>();

        usuariosList.add(usuarios);

        String resultado = "FUNCIONARIO EDITADO CON EXITO: " + usuariosList.get(0).getDocument();

    }

    @Test
    public void TestConsult() throws ParseException {

        String charge = "Desarrollador jr";
        String document = "123";
        String name = "johan";
        String lastname = "Accardo";
        int age = 23;
        String date = "2023-08-22";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date convert = format.parse(date);
        String type = "Aprendiz";

        Gestion_listas gestion_listas = new Gestion_listas();

        Usuarios usuarios = new Usuarios(charge, document, name, lastname, age, convert, type);
        List<Usuarios> usuariosList = new ArrayList<>();

        usuariosList.add(usuarios);

        String resultado = "FUNCIONARIO CONSULTADO CON EXITO: " + usuariosList.get(0).getDocument();

    }

    @Test
    public void TestInsert() throws ParseException {
        String charge = "Desarrollador jr";
        String document = "123";
        String name = "johan";
        String lastname = "Accardo";
        int age = 23;
        String date = "2023-08-22";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date convert = format.parse(date);
        String type = "Aprendiz";

        Gestion_listas gestion_listas = new Gestion_listas();

        Usuarios usuarios = new Usuarios(charge,document, name, lastname, age, convert, type);
        List<Usuarios> usuariosList = new ArrayList<>();

        usuariosList.add(usuarios);

        String resultado = "FUNCIONARIO REGISTRADO CON EXITO: " + usuariosList.get(0).getDocument();

    }
}