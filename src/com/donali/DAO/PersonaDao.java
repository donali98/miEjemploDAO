package com.donali.DAO;

import com.donali.models.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDao extends BaseDao<Persona> {

    public PersonaDao() {
        super("persona", new String[]{"nombre","direccion"});
    }

    @Override
    Persona mapToObject(ResultSet resultSet) {
        Persona persona = new Persona();
        try {
            persona.setId(resultSet.getInt(0));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, Persona objectToFind, String parameter) {
        return null;
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Persona newInsertedObject) {
        return null;
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, Persona objectToDelete) {
        return null;
    }
}
