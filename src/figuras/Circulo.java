/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Berlis
 */
public class Circulo extends Figura {

    public Circulo(Point ubicacion, int anchura, int altura, Color color) {
        super(color);
        setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura));
    }

    @Override
    public void actualizar(Point puntoActual) {
        getMarcoDeFigura().actualizarDimensiones(puntoActual);
    }

    @Override
    public void dibujar(Graphics g) {
        getMarcoDeFigura().calcularDimensiones();
        Graphics2D g2 = (Graphics2D)g;

        int x = getMarcoDeFigura().getX();
        int y = getMarcoDeFigura().getY();
        int anchura = getMarcoDeFigura().getAnchura();
        int altura = getMarcoDeFigura().getAltura();

        if (dibujarRellena()) {
            g2.setColor(getColorSecundario());
            g2.fillOval(x, y, anchura, altura);
        }

        g2.setStroke(new BasicStroke(getGrosor()));
        g2.setColor(getColor());
        g2.drawOval(x, y, anchura, altura);

    }

}
