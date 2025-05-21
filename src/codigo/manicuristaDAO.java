package codigo;

import java.sql.*;

public class manicuristaDAO 
{
    public static void insertarManicurista(manicurista m) 
    {
        Connection con = null;
        try 
        {
            con = dbConnection.conectar();
            String sql = "INSERT INTO manicurista (ID_MANICURISTA, nombre, telefono) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, m.getId());
            ps.setString(2, m.getNombre());
            ps.setString(3, m.getTelefono());

            int filas = ps.executeUpdate();
            if (filas > 0) 
            {
                System.out.println("Manicurista registrado con éxito.");
            }
        } 
        catch (SQLException e) 
        {
            if (e.getErrorCode() == 1062) 
            {
                System.out.println("Error: El ID ya está registrado.");
            } 
            else 
            {
                System.out.println("Error de base de datos: " + e.getMessage());
            }
        } 
        finally 
        {
            if (con != null) 
            {
                try 
                {
                    con.close();
                } 
                catch (SQLException e) 
                {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    public static manicurista autenticarManicurista(int id) 
    {
        Connection con = null;
        try 
        {
            con = dbConnection.conectar();
            String sql = "SELECT * FROM manicurista WHERE ID_MANICURISTA = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) 
            {
                return new manicurista
                (
                    rs.getInt("ID_MANICURISTA"),
                    rs.getString("nombre"),
                    rs.getString("especialidad")
                );
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Error de base de datos: " + e.getMessage());
        } 
        finally 
        {
            if (con != null) 
            {
                try 
                {
                    con.close();
                } 
                catch (SQLException e) 
                {
                    System.out.println("❌ Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
        return null;
    }
}
