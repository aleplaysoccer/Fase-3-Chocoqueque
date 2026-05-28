import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class abeja extends Enemigo
{
    public abeja() 
    {
        // Hacemos la abeja más pequeña para poder saltarla
        GreenfootImage img = getImage();
        img.scale(40, 40); // Ajusta a 40x40 píxeles
        setImage(img);
    }

    public void act()
    {
        checkFall();
        moveBadGuy();
    }
}