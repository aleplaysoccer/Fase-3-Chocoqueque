import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List; // Importante para poder buscar listas de objetos

public class Tirador extends Actor
{
    private int timer = 0;
    private int cooldown = 100; 

    public Tirador() 
    {
        GreenfootImage img = getImage();
        img.scale(60, 80); 
        img.mirrorHorizontally(); 
        setImage(img);
    }

    public void act()
    {
        timer++;
        if (timer >= cooldown) {
            disparar();
            timer = 0; 
        }
    }
    
    public void disparar()
    {
        Proyectil bala = new Proyectil();
        getWorld().addObject(bala, getX() - 30, getY() + 10); 
        
        // --- NUEVA LÓGICA DE APUNTADO ---
        // Busca a todos los personajes en el mundo (solo hay uno, pero Greenfoot devuelve una lista)
        List<personaje> jugadores = getWorld().getObjects(personaje.class);
        
        // Si la lista no está vacía (es decir, el personaje sigue vivo y en pantalla)
        if (!jugadores.isEmpty()) {
            // Obtenemos al jugador 0 (tu chocobanano)
            personaje prota = jugadores.get(0);
            // Hacemos que la bala gire para apuntar exactamente al centro de tu personaje
            bala.turnTowards(prota.getX(), prota.getY());
        }
    }
}