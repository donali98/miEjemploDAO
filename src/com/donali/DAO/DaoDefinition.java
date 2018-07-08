package com.donali.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

/***
 * Interfaz donde se definiran las acciones basicas del objeto de conexion,
 * el <'GenericType'> se define para decirle a la interfaz que algunos parametros
 * y variables de retorno van a ser de tipo 'algo', como en este punto de definicion
 * de la interfaz aun no se sabe quien o quienes lo van a implementar, simplemente
 * se deja como que cada metodo va a retornar o necesitar un parametro de tipo 'x'
 * que se definira hasta en el momento de implementacion de la interfaz, pero aqui solo
 * es pura y exclusivamente la implementacion
 */
public interface DaoDefinition<GenericType> {
    //Metodo que retorna una lista de tipo 'algo' de la base de datos
    ArrayList<GenericType> getAll();


}
