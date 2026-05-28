import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public MyWorld()
    {    
        super(600, 400, 1); 
        
        // 1. Zoom a la imagen para recortar los bordes derechos e inferiores (Logo)
        GreenfootImage original = new GreenfootImage("Fondo juego queque.png");
        original.scale(660, 440); // 10% más grande
        GreenfootImage fondo = new GreenfootImage(600, 400); // Lienzo exacto
        fondo.drawImage(original, 0, 0); // Dibuja pegado a la izquierda arriba
        setBackground(fondo);
        
        prepare();
    }
    
    private void prepare()
    {
        // 2. Suelo INVISIBLE posicionado en la grama oscura
        for (int i = 0; i < 620; i += 35) {
            bloque piso = new bloque();
            piso.getImage().setTransparency(0); 
            addObject(piso, i, 385); 
        }
        
        // 3. Crear 3 plataformas escalonadas que obligan a saltar en Zigzag
        // Plataforma 1 (Izquierda, accesible solo desde el suelo)
        addObject(new bloque(), 150, 290);
        addObject(new bloque(), 185, 290);
        addObject(new bloque(), 220, 290);
        
        // Plataforma 2 (Centro-Derecha, accesible solo desde Plataforma 1)
        addObject(new bloque(), 320, 210);
        addObject(new bloque(), 355, 210);
        addObject(new bloque(), 390, 210);
        
        // Plataforma 3 (Izquierda, accesible solo desde Plataforma 2)
        addObject(new bloque(), 150, 130);
        addObject(new bloque(), 185, 130);
        addObject(new bloque(), 220, 130);
        
        // 4. Personajes y Meta
        // Aparecen un poquito más arriba para caer parados justo en Y = 385
        personaje protagonista = new personaje();
        addObject(protagonista, 50, 345);
        
        abeja enemigo1 = new abeja();
        addObject(enemigo1, 350, 345);
        
        // La meta (manzana) se coloca sobre la Plataforma 3
        manzana meta = new manzana();
        addObject(meta, 185, 90);
    }
}