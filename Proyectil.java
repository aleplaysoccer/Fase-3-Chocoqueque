import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Proyectil extends Actor
{
    // AHORA POSITIVO: 6 para que avance hacia donde apunta
    private int speed = 6; 

    public Proyectil() 
    {
        GreenfootImage img = getImage();
        img.scale(15, 15); 
        setImage(img);
    }

    public void act()
    {
        move(speed); // Se mueve en la dirección a la que fue rotado
        destruirEnBordes();
    }
    
    public void destruirEnBordes()
    {
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}