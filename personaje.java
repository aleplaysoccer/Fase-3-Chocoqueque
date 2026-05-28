import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class personaje extends Actor
{
    public int vSpeed;
    public int gravity = 2; 
    public boolean jumping;
    public int jumpStrength = 22; 
    public int speed = 5;
    public int lives = 1;
    
    // Variables para guardar nuestras dos únicas imágenes
    private GreenfootImage imgDerecha;
    private GreenfootImage imgIzquierda;
    
    public personaje()
    {
        // Cargamos las imágenes PNG exactas
        imgDerecha = new GreenfootImage("chocobanano1.png");
        imgIzquierda = new GreenfootImage("chocobanano2.png");
        
        // Ajustamos el tamaño para que encaje bien en tus plataformas
        imgDerecha.scale(40, 70);
        imgIzquierda.scale(40, 70);
        
        // Imagen con la que inicia el juego (viendo a la derecha)
        setImage(imgDerecha);
    }
    
    public void act()
    {
        checkFall();
        checkKeys();
        death();
        win(); 
    }
    
    public void checkKeys(){
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + speed, getY());
            setImage(imgDerecha); // Voltea a ver a la derecha al caminar
        }
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX() - speed, getY());
            setImage(imgIzquierda); // Voltea a ver a la izquierda al caminar
        }
        if(Greenfoot.isKeyDown("w") && jumping == false)
        {
            jump();
        }
    }
    
    public void checkFall(){
        // Lógica para chocar la cabeza con las plataformas desde abajo
        if (vSpeed < 0) {
            int spriteHeight = getImage().getHeight();
            Actor ceiling = getOneObjectAtOffset(0, -(spriteHeight / 2), bloque.class);
            if (ceiling != null) {
                vSpeed = 0; 
            }
        }

        if(onGround() == true)
            vSpeed = 0;
        else
            fall();
    }
    
    public void fall(){
        setLocation(getX(), getY() + vSpeed);
        if(vSpeed <= 12)
            vSpeed = vSpeed + gravity;
        
        jumping = true;
    }
    
    public boolean onGround(){
        int spriteHeight = getImage().getHeight();
        int lookForGround = spriteHeight / 2;
        Actor ground = getOneObjectAtOffset(0, lookForGround, bloque.class);
        
        if(ground == null || vSpeed < 0)
        {
            jumping = true;
            return false;
        }
        else 
        {
            moveToGround(ground);
            return true;
        }
    }
    
    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight()) / 2;

        setLocation(getX(), newY);
        jumping = false;
    }
    
    public void jump(){
        vSpeed = vSpeed - jumpStrength;
        jumping = true;
        fall();
    }
    
    public void death(){
        // Mueres si tocas a un Enemigo (abeja), a un Proyectil, o si caes al vacío
        Actor badguys = getOneIntersectingObject(Enemigo.class);
        Actor balas = getOneIntersectingObject(Proyectil.class);
        
        if(badguys != null || balas != null || getY() > 390){
            lives = lives - 1;
            
            if (lives <= 0){
                // Reproduce el sonido de muerte
                Greenfoot.playSound("muerte.wav"); 
                
                getWorld().showText("¡HAS PERDIDO!", 300, 200);
                Greenfoot.stop(); 
            }
        }
    }
    
    public void win(){
        Actor meta = getOneIntersectingObject(manzana.class);
        if(meta != null){
            
            // Reproduce el sonido de victoria (comer el queque)
            Greenfoot.playSound("comer.wav"); 
            
            // Transiciones de niveles (del Mundo 1 al Nivel 2 y victoria final)
            if (getWorld() instanceof MyWorld) {
                Greenfoot.setWorld(new Nivel2());
            } 
            else if (getWorld() instanceof Nivel2) {
                getWorld().showText("¡HAS COMPLETADO EL JUEGO!", 300, 200);
                Greenfoot.stop(); 
            }
        }
    }
}