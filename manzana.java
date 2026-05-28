import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class manzana extends Actor
{
    /**
     * Constructor: Se ejecuta cuando se crea el objeto
     */
    public manzana() 
    {
        // Obtenemos la imagen asignada a este actor
        GreenfootImage img = getImage();
        
        // Reducimos la imagen a 40x40 píxeles
        img.scale(40, 40); 
        
        // Le aplicamos la imagen ya escalada al actor
        setImage(img);
    }

    /**
     * Act - do whatever the manzana wants to do.
     */
    public void act()
    {
        // El pastel no hace nada por sí solo, solo espera a ser comido
    }
}