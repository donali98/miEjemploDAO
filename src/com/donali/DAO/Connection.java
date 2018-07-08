package com.donali.DAO;

import org.mariadb.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

/***
 * Clase conexion que simplemente sirve para conectarnos con la base
 */
public class Connection {

    /*
     Variables finales de tipo String que representan el user y pass que necesitamos
     para conectarnos a la base, por defecto cuando se instala mysql estos valores
     son 'root' y sin password
     */
    private static final String username = "root";
    private static final String password = "";

    /***
     * Variable 'connection' del mismo tipo que esta clase para aplicar Singleton,
     * por el hecho de que no necesitamos mas de una instancia de esta clase,
     * o en otras palabras, no necesitamos otra clase que conecte a la bases, porque
     * aparte de ser innecesario, consumiria recursos
     */

    private static Connection connection;

    /**
     * Constructor que se ejecuta una sola vez (por el Singleton) que inicializa la variable
     * 'connection', es como prepararla para ser usada para conectarlo
     */
    private Connection() {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /*
        Metodo que va a inicializar la variable (usar el constructor definido arriba) una sola vez (por el Singleton)
        y luego, cada vez que se mande a llamar este metodo en cualquier otra parte del programa, simplemente va  a devolver
        la variable connection ya que, como dije, solo sera inicializada una sola vez
    * */
     /*
            'synchronized' se usa simplemente para evitar que, en caso se mande a llamar 'al mismo tiempo' el metodo
            getInstance() desde dos pc's a la vez, no exista conflicto en la condicion, porque en el momento que en
            una pc's mande a llamar este metodo y verifique que connection este nulo, va a inicializar dicha variable
            pero como 'al mismo tiempo'(cosa que es imposible porque SIEMPRE hay una diferencia en milisegundos) existe
            otra persona con otra pc mandando a llamar este mismo metodo y por ende validando que connection no se halla
            inicializado (if(connection == null) ) puede que, por la diferencia de tiempos que existe, aun el programa
            corriendo en la pc del segundo cristiano aun no halla detectado que el primer cristiano ya inicializo la variable
            y ya no hace falta volverla a inicializar, y trate de inicializarla lo que caeria en conflicto, asi que
            'synchronized' ayuda a que se haga esa verificacion en todas las instancias del programa (las pc's corriendo el
            mismo programa) y que no ocurran esos conflictos
        */
    public synchronized static Connection getInstance(){

        //Si 'connection' aun no ha sido inicializada
        if(connection == null) {
            //Inicializar la variable ejecutando el codigo del constructor
            connection = new Connection();
        }

            return connection;
    }

    //Metodo que sera llamado para finalmente crear la conexion entre el programa y la base de datos
    public java.sql.Connection getConnection() throws SQLException {
        /*
         el primer parametro es la url del servidor, siempre va a ser la misma cambiando unicamente el slash '/'
         donde despues del mismo iria el nombre de la base de datos a conectar, el segundo y tercer parametro
         serian basicamente decirle al servidor que queres loguearte con el user y pass que antes definiste
        * */
        return DriverManager.getConnection("jdbc:mariadb:localhost:3306/ejemplo",username,password);
    }
}

