package parcialsoftware;

/**
 * @author Jessica Albarracín
 */
public abstract class Usuario
{

    private String nombre;
    private String email;
    private String clave;

    public Usuario()
    {
        this.nombre = "";
        this.email = "";
        this.clave = "";
    }

    public Usuario(String nombre, String email, String clave)
    {
        this.nombre = nombre;
        this.email = email;
        this.clave = clave;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getClave()
    {
        return clave;
    }

    public void setClave(String clave)
    {
        this.clave = clave;
    }

    @Override
    public String toString()
    {
        return this.nombre + "," + this.email + "," + this.clave;
    }

    public abstract String menu();
}
