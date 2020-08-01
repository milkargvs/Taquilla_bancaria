/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taquilla_bancaria;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author MILKA
 */
public class Taquilla_bancaria {
    
    private String Hora;
    private int cont;
    private int fondosdispret;
    private static int usu;
    private int saldoactivo;
    private int fondosenc = 0;
    private int saldotoretiro;
    private int carga;
    private String proceso;
    private int idcliente;
    private int usu2;
    private int transferencia;
    private int fondosdisreci;
    private int cont5;
    private int deposito;
    private int logsusc;

    public void Hora() {
             Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss  dd/MM/yyyy");
//System.out.println("Hora y fecha: "+ hourdateFormat.format(date));
        String Hora = hourdateFormat.format(date); //To change body of generated methods, choose Tools | Templates.
     //To change body of generated methods, choose Tools | Templates.
    } //hace es con un dateformat para darle respétesentacion a la hora que se está realizando la operación
    
    public void usuarios() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("usuarios.in.txt"));
            String s = "";
            while ((s = br.readLine()) != null) {
                String data[] = new String[6];
                data = s.split(",");
                for (int i = 0; i < 6; i++) {
                    System.out.print(data[i] + " |||  ");
                }
                System.out.println();

            }

        } catch (Exception e) {
        }

    }//muestra usuarios registrados en Banesco
    
    public void registro() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("transacciones.out.txt"));
            String s = "";
            while ((s = br.readLine()) != null) {
                String data[] = new String[6];
                data = s.split(",");
                for (int i = 0; i < 6; i++) {
                    System.out.print(data[i] + " |  ");
                }
                System.out.println();

            }

        } catch (Exception e) {
        }

    }//registro de transacciones realizadas
    
    public void login() {
        Taquilla_bancaria tb = new Taquilla_bancaria();
        System.out.println("Introduce tu usuario");
        Scanner sc = new Scanner(System.in);
        int id_to_change = sc.nextInt();
        int usu = id_to_change;

        int cont3 = 0;
        int cont4 = 0;

        
        try {
            BufferedReader br = new BufferedReader(new FileReader("usuarios.in.txt"));
            String s = "";

            while ((s = br.readLine()) != null) {
                String data[] = new String[6];

                cont3 = cont3 + 1;
                data = s.split(",");
                if (id_to_change == Integer.parseInt(data[0])) {
                    cont = cont + cont3;

                    System.out.println("usuario localizado");
                    System.out.println("Nr" + cont);
                    fondosdispret = Integer.parseInt(data[5]);

                }
            }

        } catch (IOException | NumberFormatException e) {

        }

        System.out.println("clave de operaciones");
        int clave = sc.nextInt();

        int cont1 = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("usuarios.in.txt"));
            String s = "";

            while ((s = br.readLine()) != null) {
                String data[] = new String[6];

                cont4 = cont4 + 1;
                data = s.split(",");
                if (clave == Integer.parseInt(data[1])) {
                    cont1 = cont1 + cont4;
                    System.out.println("clave localizada");
                    System.out.println("Nr" + cont1);

                }

            }

        } catch (Exception e) {

        }
        if (cont > 0) {
            if (cont1 == cont) {
                System.out.println("acceso exitoso");
                proceso ="EXITOSO";
                carga = 2;

            } else {
                System.out.println("clave errada");
               proceso = "FRACASO";

            }
        } else {
            System.out.println("usario correcto/clave errada");
             proceso = "FRACASO";
                 

        }
        tb.Hora();
        try {
            String tipop = "Inicio de sesion";
            int user1 = usu;
            String monto = "NO APLICA";
            String userrecept = "NO APLICA";
            String hora = (Hora);
            int result = usu;

            File f = new File("transacciones.out.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(f, true));
            pw.append(tipop + "," + user1 + "," + monto + "," + userrecept + "," + result + "," + hora + "\n");
            pw.close();
        } catch (Exception e) {
        }

    } //ingresar a las operaciones; permite ingresar al user... 
    
    
    public void menu() {
        Scanner sc = new Scanner(System.in);

        Taquilla_bancaria tb = new Taquilla_bancaria();

        int v2;

        int v3;

        System.out.println("Bienvenido");
        tb.login();
        if (logsusc == 2) {

            System.out.println("presione 1 para retirar fondos");
            System.out.println("presione 2 para transferir fondos a otro usuario");
            System.out.println("presione 3 para consultar su saldo");
            System.out.println("presione 4 para realizar un deposito en su cuenta personal");
            System.out.println("presione 9 para salir");
            v2 = sc.nextInt();
            if (v2 == 1) {
                tb.retiro();
            }
            if (v2 == 2) {
                tb.transferenciadefondos();
            }
            if (v2 == 3) {
                tb.consultadesaldo();
            }
            if (v2 == 4) {
                tb.deposencuentapersonal();
            }

        } else {
            System.out.println("Datos incorrectos");
        }
        System.out.println("Porfavor!!");
        System.out.println("presione 1 para ver el registro de transacciones");
        System.out.println("presione 2 para ver el registro de usuarios");
        v3 = sc.nextInt();
        if (v3 == 1) {
            System.out.println("ACTIVIDAD |  N# USUARIO  | MONTO EN BS.F | US. RECEPTOR | RESULTADO  | HORA");
            tb.registro();
        }
        if (v3 == 2) {
            System.out.println("N# USUARIO |  CLAVE  | NOMBRE  | APELLIDO | CEDULA  | FONDOS DISP");
            tb.usuarios();
        }
        System.out.println("GRACIAS POR USAR NUESTROS SERVICIOS");

    }// MENU (NO HAY MUCHO QUE EXPLICAR AQUI..)
    
    public static void main(String[] args) {
        // TODO code application logic here
    
        BufferedReader bufEntrada = new BufferedReader(new InputStreamReader(System.in));
        Taquilla_bancaria tb = new Taquilla_bancaria();// TODO code application logic here
        tb.menu();
    }
    
}
