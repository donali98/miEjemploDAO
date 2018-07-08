package com.donali.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/***
 * Clase abstracta, cuyo concepto honestamente no entiendo a cabalidad XD pero basicamente, y en
 *  este particular ejemplo, sirve para definir atributos comunes, y metodos genericos
 *  que solo falta definirles el tipo de dato que van a manipular, por eso el '<GenericType>'
 *  e implementa la definicion
 */
public  abstract class BaseDao<GenericType> implements DaoDefinition<GenericType> {

    /**
     * Nestor puso estos dos campos como una clase interna aparte, no entiendo muy bien sus razones,
     * pero bastaba con crear estos dos atributos de tipo String, uno para establecer el nombre
     * de la tabla y el otro para almacenar los campos de la tabla en la base de datos
     */
    private String tableName;
    private String[] tableFields;

    /**
     * Metodos abstractos que van a ser especificados en las clases que van a heredar de esta (BaseDao)
     * ya que, el objetivo principal de la clase es que esta sirva para realizar las operaciones a la
     * base de datos para cualquier tabla, una suerte de clase generica o clase maestra de operaciones
     * que sirve para darle mantenimiento (insetar,modificar,eliminar y consultar) a cualquier tabla
     * de la base
     */

    /*
      Metodo que sirve para pasar un registro de la base a un objeto del programa, se usa en 2 ocaciones,
      cuando se obtienen una lista de registros completa de la base y cuando se obtiene un registro en concreto
    */
    abstract GenericType mapToObject(ResultSet resultSet);

    //Obtiene el statement (o la consulta lista a ser ejecutada) para obtener un registro en especifico
    abstract PreparedStatement getSelectStatement(Connection con, GenericType objectToFind, String parameter);
    //Obtiene el statement (o la consulta lista a ser ejecutada) para insertar un registro
    abstract PreparedStatement getInsertStatement(Connection con,GenericType newInsertedObject);
    //Obtiene el statement (o la consulta lista a ser ejecutada) para eliminar un registro

    abstract PreparedStatement getDeleteStatement(Connection con,GenericType objectToDelete);

    public BaseDao(String tableName, String[] tableFields) {
        this.tableName = tableName;
        this.tableFields = tableFields;
    }

    @Override
    public ArrayList<GenericType> getAll() {
        return null;
    }
}
