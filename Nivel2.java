import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Nivel2 extends World
{
    public Nivel2()
    {    
        super(600, 400, 1); 
        
        GreenfootImage original = new GreenfootImage("Fondo juego queque.png");
        original.scale(660, 440); 
        GreenfootImage fondo = new GreenfootImage(600, 400);
        fondo.drawImage(original, 0, 0); 
        setBackground(fondo);
        
        prepare();
    }
    
    private void prepare()
    {
        // 1. Suelo completo continuo
        for (int i = 0; i < 620; i += 35) {
            bloque piso = new bloque();
            piso.getImage().setTransparency(0); 
            addObject(piso, i, 385); 
        }
        
        // 2. Plataformas en forma de "S" con saltos perfectamente calculados
        
        // Plataforma 1 (Izquierda, baja) - 4 bloques anchos. ¡Sin abeja!
        // Sirve como refugio seguro de las balas del mago.
        addObject(new bloque(), 100, 290);
        addObject(new bloque(), 135, 290);
        addObject(new bloque(), 170, 290);
        addObject(new bloque(), 205, 290);
        
        // Plataforma 2 (Derecha, media) - 5 bloques anchos. 
        // Mucho espacio para que aterrices cuando la abeja se vaya al otro lado.
        addObject(new bloque(), 280, 200);
        addObject(new bloque(), 315, 200);
        addObject(new bloque(), 350, 200);
        addObject(new bloque(), 385, 200);
        addObject(new bloque(), 420, 200);
        
        // Plataforma 3 (Izquierda, alta) - 4 bloques anchos. 
        // Salto de regreso hacia la meta.
        addObject(new bloque(), 100, 110);
        addObject(new bloque(), 135, 110);
        addObject(new bloque(), 170, 110);
        addObject(new bloque(), 205, 110);
        
        // 3. Enemigos
        Tirador francotirador = new Tirador();
        addObject(francotirador, 560, 340); // Mago abajo a la derecha
        
        abeja enemigoVolador1 = new abeja();
        addObject(enemigoVolador1, 350, 160); // Abeja 1 patrullando la Plataforma 2
        
        abeja enemigoVolador2 = new abeja();
        addObject(enemigoVolador2, 150, 70); // Abeja 2 patrullando la Plataforma 3
        
        // 4. Personaje y Meta
        personaje protagonista = new personaje();
        addObject(protagonista, 40, 345); // Inicias abajo a la izquierda
        
        manzana meta = new manzana();
        addObject(meta, 100, 70); // El pastel está protegido al final de la Plataforma 3
    }
}