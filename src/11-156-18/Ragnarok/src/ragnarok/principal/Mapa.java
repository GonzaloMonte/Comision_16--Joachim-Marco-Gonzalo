package ragnarok.principal;

import java.util.Collection;
import java.util.LinkedList;

import ragnarok.entidades.Entidad;
import ragnarok.entidades.Heroe;
import ragnarok.entidades.enemigos.EnemigoArmado;
import ragnarok.entidades.enemigos.EnemigoArmadoEspecial;
import ragnarok.entidades.enemigos.KamikazeBuscador;
import ragnarok.entidades.enemigos.KamikazeEspecial;
import ragnarok.entidades.enemigos.KamikazeMareado;
import ragnarok.graficos.Posicion;
import ragnarok.obstaculos.Barrera;
import ragnarok.obstaculos.Obstaculo;
import ragnarok.powerups.Observer;
import ragnarok.powerups.ObserverCongelar;
import ragnarok.powerups.ObserverSuperMisil;

public class Mapa {
	
	private final int ultimoNivel = 11;
	private int cantEnemigos;
	
	private static Mapa mapa;
	private int nivel;
	private Collection<Entidad> coleccionEntidades;
	private Collection<Entidad> coleccionAAgregar;
	private Collection<Entidad> coleccionAEliminar;
	private Posicion[] coleccionPosicionEnemigos;
	
	private int vidasExtra;
	
	protected Observer[] listaDeObservadores;
	
	private Heroe heroe;
	
	private Mapa() {
		heroe=new Heroe();
		vidasExtra = 3;
		nivel = 6;
		coleccionEntidades = new LinkedList<Entidad>();
		coleccionAAgregar = new LinkedList<Entidad>();
		coleccionAEliminar = new LinkedList<Entidad>();
        crearEntidades(nivel);
        agregarEntidad(heroe);
        listaDeObservadores=new Observer[2];
		listaDeObservadores[0]=new ObserverCongelar(this);
		listaDeObservadores[1]=new ObserverSuperMisil(this);
	}
	
	private void crearEntidades(int nivel) {
		switch (nivel) {
			case 1 : {
					//2 Kamikazes buscadores, 1 kamikaze mareado
				generarTodo(2,1,0,0,0,0,0);
				break;
			}
			case 2 : {
					//1 kamikaze buscador,2 Kamikaze mareado, 2 enemigos armados
				generarTodo(1,2,0,2,0,0,0);
				break;
					
			}
			case 3 : {
				//, 2 kamikazes mareados,2 Enemigos armados, 1 enemigo armado especial
				generarTodo(0,2,0,2,1,0,0);
			break;
				
			}
			case 4 : {
				//1 kamikaze buscador, 1 kamikaze mareado, 3 enemigos armados,2 Enemigos armados especiales
				generarTodo(1,1,0,3,2,0,0);
			break;
				
			}
			case 5 : {
				// 2 kamikaze buscador, 2 kamikaze mareado,4 enemigos armados, 2 enemigos armados especiales
				generarTodo(2,2,0,4,2,0,0);
			break;
				
			}
			case 6 : {
				// 2 kamikaze buscadores,2 kamikaze mareado, 2 enemigos armados especiales, 2 barreras, 2 obstaculos
				generarTodo(2,2,0,0,2,2,1);
			break;
				
			}
			case 7 : {
				//4 kamikazes buscadores,2 kamikazes especiales,2 Enemigos armados, 2 enemigos armados especiales,  4 obstaculos
				generarTodo(4,0,2,2,2,0,3);
			break;
				
			}
			case 8 : {
				// 4 kamikazes buscadores,2 kamikaze mareados, 2 kamikaze especiales, 4 enemigos armados, 2 enemigos armados especiales, 2 barreras, 2 obstaculos
				generarTodo(4,2,2,4,2,2,2);
			break;
				
			}
			case 9 : {
				// 3 kamikaze buscador,4 kamikaze mareado, 2 kamikaze especial, 6 enemigos armados, 1 enemigo armado especial, 3 barreras, 1 obstaculo
				generarTodo(3,2,2,6,1,2,0);
			break;
				
			}
			case 10 : {
				//4 kamikaze buscador,2 kamikaze mareado,  2 kamikaze especial, 9 enemigo armado, 3 enemigo armado especial, 4 barreras
				generarTodo(4,2,2,9,3,1,0);
			break;
				
			}
		}
		setPosiciones(coleccionEntidades);
	}
	private void generarTodo(int KB,int KM,int KE,int EA,int EAE,int B,int O) {
		int aux;
		cantEnemigos = KB+KM+KE+EA+EAE;
		for (aux=0;aux<KB;aux++) {
			coleccionEntidades.add(new KamikazeBuscador());
		}
		for (aux=0;aux<KM;aux++) {
			coleccionEntidades.add(new KamikazeMareado());
		}
		for (aux=0;aux<KE;aux++) {
			coleccionEntidades.add(new KamikazeEspecial());
		}
		for (aux=0;aux<EA;aux++) {
			coleccionEntidades.add(new EnemigoArmado());
		}
		for (aux=0;aux<EAE;aux++) {
			coleccionEntidades.add(new EnemigoArmadoEspecial());
		}
		for (aux=0;aux<B;aux++) {
			coleccionEntidades.add(new Barrera());
		}
		for (aux=0;aux<O;aux++) {
			coleccionEntidades.add(new Obstaculo());
		}
	}
	
	private Posicion[] UbicarEntidades(int nivel) {
		Posicion pos;
		coleccionPosicionEnemigos= new Posicion[coleccionEntidades.size()];
		
		switch(nivel) {
			case 1: {
					//2 Kamikazes buscadores, 1 kamikaze mareado
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2-150);
					coleccionPosicionEnemigos[0]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2+150);
					coleccionPosicionEnemigos[1]=pos;
					pos=new Posicion(Juego.ANCHO-200,(Juego.ALTO-Juego.caminable)/2);
					coleccionPosicionEnemigos[2]=pos;
			break;
			}
			case 2:{
					//1 kamikaze buscador,2 Kamikaze mareado, 2 enemigos armados
					pos=new Posicion(Juego.ANCHO-200,(Juego.ALTO-Juego.caminable)/2+25);
					coleccionPosicionEnemigos[0]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2+150);
					coleccionPosicionEnemigos[1]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2-150);
					coleccionPosicionEnemigos[2]=pos;
					pos=new Posicion(Juego.ANCHO-150,(Juego.ALTO-Juego.caminable)/2+100);
					coleccionPosicionEnemigos[3]=pos;
					pos=new Posicion(Juego.ANCHO-150,(Juego.ALTO-Juego.caminable)/2-100);
					coleccionPosicionEnemigos[4]=pos;
					
			break;
			}
			case 3 : {
					//, 2 kamikazes mareados,2 Enemigos armados, 1 enemigo armado especial
					pos=new Posicion(Juego.ANCHO-300,(Juego.ALTO-Juego.caminable)/2+100);
					coleccionPosicionEnemigos[0]=pos;
					pos=new Posicion(Juego.ANCHO-300,(Juego.ALTO-Juego.caminable)/2-100);
					coleccionPosicionEnemigos[1]=pos;
					pos=new Posicion(Juego.ANCHO-200,(Juego.ALTO-Juego.caminable)/2-200);
					coleccionPosicionEnemigos[2]=pos;
					pos=new Posicion(Juego.ANCHO-200,(Juego.ALTO-Juego.caminable)/2+150);
					coleccionPosicionEnemigos[3]=pos;
					pos=new Posicion(Juego.ANCHO-100,(Juego.ALTO-Juego.caminable)/2);
					coleccionPosicionEnemigos[4]=pos;
			break;
				
			}
			case 4 : {
					//1 kamikaze buscador, 1 kamikaze mareado, 3 enemigos armados,2 Enemigos armados especiales
					pos=new Posicion(Juego.ANCHO-300,(Juego.ALTO-Juego.caminable)/2+50);
					coleccionPosicionEnemigos[0]=pos;
					pos=new Posicion(Juego.ANCHO-300,(Juego.ALTO-Juego.caminable)/2-50);
					coleccionPosicionEnemigos[1]=pos;
					pos=new Posicion(Juego.ANCHO-100,(Juego.ALTO-Juego.caminable)/2-100);
					coleccionPosicionEnemigos[2]=pos;
					pos=new Posicion(Juego.ANCHO-100,(Juego.ALTO-Juego.caminable)/2+100);
					coleccionPosicionEnemigos[3]=pos;
					pos=new Posicion(Juego.ANCHO-100,(Juego.ALTO-Juego.caminable)/2);
					coleccionPosicionEnemigos[4]=pos;
					pos=new Posicion(Juego.ANCHO-200,(Juego.ALTO-Juego.caminable)/2+150);
					coleccionPosicionEnemigos[5]=pos;
					pos=new Posicion(Juego.ANCHO-200,(Juego.ALTO-Juego.caminable)/2-150);
					coleccionPosicionEnemigos[6]=pos;
			break;
				
			}
			case 5 : {
					// 2 kamikaze buscador, 2 kamikaze mareado,4 enemigos armados, 2 enemigos armados especiales
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2+50);
					coleccionPosicionEnemigos[0]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2-50);
					coleccionPosicionEnemigos[1]=pos;
					pos=new Posicion(Juego.ANCHO-300,(Juego.ALTO-Juego.caminable)/2-100);
					coleccionPosicionEnemigos[2]=pos;
					pos=new Posicion(Juego.ANCHO-300,(Juego.ALTO-Juego.caminable)/2+100);
					coleccionPosicionEnemigos[3]=pos;
					pos=new Posicion(Juego.ANCHO-75,(Juego.ALTO-Juego.caminable)/2+75);
					coleccionPosicionEnemigos[4]=pos;
					pos=new Posicion(Juego.ANCHO-75,(Juego.ALTO-Juego.caminable)/2-75);
					coleccionPosicionEnemigos[5]=pos;
					pos=new Posicion(Juego.ANCHO-125,(Juego.ALTO-Juego.caminable)/2-150);
					coleccionPosicionEnemigos[6]=pos;
					pos=new Posicion(Juego.ANCHO-125,(Juego.ALTO-Juego.caminable)/2+150);
					coleccionPosicionEnemigos[7]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2+175);
					coleccionPosicionEnemigos[8]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2-200);
					coleccionPosicionEnemigos[9]=pos;
			break;
				
			}
			case 6 : {
					// 2 kamikaze buscadores,2 kamikaze mareado, 2 enemigos armados especiales, 2 obstaculos, 2 barrera
					pos=new Posicion(Juego.ANCHO-350,(Juego.ALTO-Juego.caminable)/2);
					coleccionPosicionEnemigos[0]=pos;
					pos=new Posicion(Juego.ANCHO-450,(Juego.ALTO-Juego.caminable)/2);
					coleccionPosicionEnemigos[1]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2-175);
					coleccionPosicionEnemigos[2]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2+175);
					coleccionPosicionEnemigos[3]=pos;
					pos=new Posicion(Juego.ANCHO-100,(Juego.ALTO-Juego.caminable)/2+175);
					coleccionPosicionEnemigos[4]=pos;
					pos=new Posicion(Juego.ANCHO-100,(Juego.ALTO-Juego.caminable)/2-175);
					coleccionPosicionEnemigos[5]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2-25);
					coleccionPosicionEnemigos[6]=pos;
					pos=new Posicion(Juego.ANCHO-600,(Juego.ALTO-Juego.caminable)/2+125);
					coleccionPosicionEnemigos[7]=pos;
					pos=new Posicion(Juego.ANCHO-600,(Juego.ALTO-Juego.caminable)/2-175);
					coleccionPosicionEnemigos[8]=pos;
			break;
				
			}
			case 7 : {
					//4 kamikazes buscadores,2 kamikazes especiales,2 Enemigos armados, 2 enemigos armados especiales,  4 obstaculos
					pos=new Posicion(Juego.ANCHO-450,(Juego.ALTO-Juego.caminable)/2+175);
					coleccionPosicionEnemigos[0]=pos;
					pos=new Posicion(Juego.ANCHO-350,(Juego.ALTO-Juego.caminable)/2-175);
					coleccionPosicionEnemigos[1]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2+175);
					coleccionPosicionEnemigos[2]=pos;
					pos=new Posicion(Juego.ANCHO-150,(Juego.ALTO-Juego.caminable)/2-175);
					coleccionPosicionEnemigos[3]=pos;
					pos=new Posicion(Juego.ANCHO-300,(Juego.ALTO-Juego.caminable)/2+105);
					coleccionPosicionEnemigos[4]=pos;
					pos=new Posicion(Juego.ANCHO-300,(Juego.ALTO-Juego.caminable)/2-105);
					coleccionPosicionEnemigos[5]=pos;
					pos=new Posicion(Juego.ANCHO-110,(Juego.ALTO-Juego.caminable)/2-50);
					coleccionPosicionEnemigos[6]=pos;
					pos=new Posicion(Juego.ANCHO-110,(Juego.ALTO-Juego.caminable)/2+50);
					coleccionPosicionEnemigos[7]=pos;
					pos=new Posicion(Juego.ANCHO-220,(Juego.ALTO-Juego.caminable)/2-85);
					coleccionPosicionEnemigos[8]=pos;
					pos=new Posicion(Juego.ANCHO-220,(Juego.ALTO-Juego.caminable)/2+85);
					coleccionPosicionEnemigos[9]=pos;
					pos=new Posicion(Juego.ANCHO-600,(Juego.ALTO-Juego.caminable)/2+175);
					coleccionPosicionEnemigos[10]=pos;
					pos=new Posicion(Juego.ANCHO-600,(Juego.ALTO-Juego.caminable)/2-175);
					coleccionPosicionEnemigos[11]=pos;
					pos=new Posicion(Juego.ANCHO-400,(Juego.ALTO-Juego.caminable)/2);
					coleccionPosicionEnemigos[12]=pos;
			break;
				
			}
			case 8 : {
					// 4 kamikazes buscadores,2 kamikaze mareados, 2 kamikaze especiales, 4 enemigos armados, 2 enemigos armados especiales, 2 barreras, 2 obstaculos
					pos=new Posicion(Juego.ANCHO-150,(Juego.ALTO-Juego.caminable)/2+175);
					coleccionPosicionEnemigos[0]=pos;
					pos=new Posicion(Juego.ANCHO-150,(Juego.ALTO-Juego.caminable)/2-200);
					coleccionPosicionEnemigos[1]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2+175);
					coleccionPosicionEnemigos[2]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2-200);
					coleccionPosicionEnemigos[3]=pos;
					pos=new Posicion(Juego.ANCHO-500,(Juego.ALTO-Juego.caminable)/2+65);
					coleccionPosicionEnemigos[4]=pos;
					pos=new Posicion(Juego.ANCHO-500,(Juego.ALTO-Juego.caminable)/2-65);
					coleccionPosicionEnemigos[5]=pos;
					pos=new Posicion(Juego.ANCHO-600,(Juego.ALTO-Juego.caminable)/2);
					coleccionPosicionEnemigos[6]=pos;
					pos=new Posicion(Juego.ANCHO-400,(Juego.ALTO-Juego.caminable)/2);
					coleccionPosicionEnemigos[7]=pos;
					pos=new Posicion(Juego.ANCHO-150,(Juego.ALTO-Juego.caminable)/2+75);
					coleccionPosicionEnemigos[8]=pos;
					pos=new Posicion(Juego.ANCHO-150,(Juego.ALTO-Juego.caminable)/2-75);
					coleccionPosicionEnemigos[9]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2+75);
					coleccionPosicionEnemigos[10]=pos;
					pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2-75);
					coleccionPosicionEnemigos[11]=pos;
					pos=new Posicion(Juego.ANCHO-400,(Juego.ALTO-Juego.caminable)/2+75);
					coleccionPosicionEnemigos[12]=pos;
					pos=new Posicion(Juego.ANCHO-400,(Juego.ALTO-Juego.caminable)/2-75);
					coleccionPosicionEnemigos[13]=pos;
					pos=new Posicion(Juego.ANCHO-325,(Juego.ALTO-Juego.caminable)/2+75);
					coleccionPosicionEnemigos[14]=pos;
					pos=new Posicion(Juego.ANCHO-325,(Juego.ALTO-Juego.caminable)/2-75);
					coleccionPosicionEnemigos[15]=pos;
					pos=new Posicion(Juego.ANCHO-570,(Juego.ALTO-Juego.caminable)/2-200);
					coleccionPosicionEnemigos[16]=pos;
					pos=new Posicion(Juego.ANCHO-570,(Juego.ALTO-Juego.caminable)/2+160);
					coleccionPosicionEnemigos[17]=pos;
			break;
				
			}
			case 9 : {
					// 3 kamikaze buscador,2 kamikaze mareado, 2 kamikaze especial, 6 enemigos armados, 1 enemigo armado especial, 3 barreras
				pos=new Posicion(Juego.ANCHO-600,(Juego.ALTO-Juego.caminable)/2+175);
				coleccionPosicionEnemigos[0]=pos;
				pos=new Posicion(Juego.ANCHO-600,(Juego.ALTO-Juego.caminable)/2);
				coleccionPosicionEnemigos[1]=pos;
				pos=new Posicion(Juego.ANCHO-600,(Juego.ALTO-Juego.caminable)/2-175);
				coleccionPosicionEnemigos[2]=pos;
				pos=new Posicion(Juego.ANCHO-500,(Juego.ALTO-Juego.caminable)/2);
				coleccionPosicionEnemigos[3]=pos;
				pos=new Posicion(Juego.ANCHO-300,(Juego.ALTO-Juego.caminable)/2);
				coleccionPosicionEnemigos[4]=pos;
				pos=new Posicion(Juego.ANCHO-150,(Juego.ALTO-Juego.caminable)/2+150);
				coleccionPosicionEnemigos[5]=pos;
				pos=new Posicion(Juego.ANCHO-150,(Juego.ALTO-Juego.caminable)/2-175);
				coleccionPosicionEnemigos[6]=pos;
				pos=new Posicion(Juego.ANCHO-150,(Juego.ALTO-Juego.caminable)/2-100);
				coleccionPosicionEnemigos[7]=pos;
				pos=new Posicion(Juego.ANCHO-150,(Juego.ALTO-Juego.caminable)/2+50);
				coleccionPosicionEnemigos[8]=pos;
				pos=new Posicion(Juego.ANCHO-100,(Juego.ALTO-Juego.caminable)/2-25);
				coleccionPosicionEnemigos[9]=pos;
				pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2+50);
				coleccionPosicionEnemigos[10]=pos;
				pos=new Posicion(Juego.ANCHO-250,(Juego.ALTO-Juego.caminable)/2-100);
				coleccionPosicionEnemigos[11]=pos;
				pos=new Posicion(Juego.ANCHO-200,(Juego.ALTO-Juego.caminable)/2-25);
				coleccionPosicionEnemigos[12]=pos;
				pos=new Posicion(Juego.ANCHO-400,(Juego.ALTO-Juego.caminable)/2);
				coleccionPosicionEnemigos[13]=pos;
				pos=new Posicion(Juego.ANCHO-500,(Juego.ALTO-Juego.caminable)/2+135);
				coleccionPosicionEnemigos[14]=pos;
				pos=new Posicion(Juego.ANCHO-500,(Juego.ALTO-Juego.caminable)/2-175);
				coleccionPosicionEnemigos[15]=pos;
			break;
				
			}
			case 10 : {
				//4 kamikaze buscador,2 kamikaze mareado,  2 kamikaze especial, 9 enemigo armado, 3 enemigo armado especial, 1 barreras
					pos=new Posicion(Juego.ANCHO-500,(Juego.ALTO-Juego.caminable)/2+170);
					coleccionPosicionEnemigos[0]=pos;
					pos=new Posicion(Juego.ANCHO-500,(Juego.ALTO-Juego.caminable)/2-200);
					coleccionPosicionEnemigos[1]=pos;
					pos=new Posicion(Juego.ANCHO-400,(Juego.ALTO-Juego.caminable)/2+170);
					coleccionPosicionEnemigos[2]=pos;
					pos=new Posicion(Juego.ANCHO-400,(Juego.ALTO-Juego.caminable)/2-200);
					coleccionPosicionEnemigos[3]=pos;
					pos=new Posicion(Juego.ANCHO-550,(Juego.ALTO-Juego.caminable)/2-145);
					coleccionPosicionEnemigos[4]=pos;
					pos=new Posicion(Juego.ANCHO-550,(Juego.ALTO-Juego.caminable)/2+125);
					coleccionPosicionEnemigos[5]=pos;
					pos=new Posicion(Juego.ANCHO-300,(Juego.ALTO-Juego.caminable)/2+150);
					coleccionPosicionEnemigos[6]=pos;
					pos=new Posicion(Juego.ANCHO-300,(Juego.ALTO-Juego.caminable)/2-150);
					coleccionPosicionEnemigos[7]=pos;
					pos=new Posicion(Juego.ANCHO-125,(Juego.ALTO-Juego.caminable)/2+150);
					coleccionPosicionEnemigos[8]=pos;
					pos=new Posicion(Juego.ANCHO-225,(Juego.ALTO-Juego.caminable)/2+100);
					coleccionPosicionEnemigos[9]=pos;
					pos=new Posicion(Juego.ANCHO-300,(Juego.ALTO-Juego.caminable)/2-25);
					coleccionPosicionEnemigos[10]=pos;
					pos=new Posicion(Juego.ANCHO-225,(Juego.ALTO-Juego.caminable)/2-125);
					coleccionPosicionEnemigos[11]=pos;
					pos=new Posicion(Juego.ANCHO-125,(Juego.ALTO-Juego.caminable)/2-225);
					coleccionPosicionEnemigos[12]=pos;
					pos=new Posicion(Juego.ANCHO-650,(Juego.ALTO-Juego.caminable)/2+125);
					coleccionPosicionEnemigos[13]=pos;
					pos=new Posicion(Juego.ANCHO-650,(Juego.ALTO-Juego.caminable)/2-175);
					coleccionPosicionEnemigos[14]=pos;
					pos=new Posicion(Juego.ANCHO-400,(Juego.ALTO-Juego.caminable)/2+75);
					coleccionPosicionEnemigos[15]=pos;
					pos=new Posicion(Juego.ANCHO-400,(Juego.ALTO-Juego.caminable)/2-145);
					coleccionPosicionEnemigos[16]=pos;
					pos=new Posicion(Juego.ANCHO-100,(Juego.ALTO-Juego.caminable)/2+50);
					coleccionPosicionEnemigos[17]=pos;
					pos=new Posicion(Juego.ANCHO-200,(Juego.ALTO-Juego.caminable)/2);
					coleccionPosicionEnemigos[18]=pos;
					pos=new Posicion(Juego.ANCHO-100,(Juego.ALTO-Juego.caminable)/2-75);
					coleccionPosicionEnemigos[19]=pos;
					pos=new Posicion(Juego.ANCHO-600,(Juego.ALTO-Juego.caminable)/2-50);
					coleccionPosicionEnemigos[20]=pos;
			break;
				
			}
		}
		return coleccionPosicionEnemigos;
	}
	
	private void setPosiciones(Collection<Entidad> lista) {
		UbicarEntidades(nivel);
		int i=0;
		Posicion pos;
		for(Entidad entidad:lista) {
			if (entidad!=heroe) {
				pos=coleccionPosicionEnemigos[i];
				entidad.setPosicion(pos.getX(), pos.getY());
				i++;
			}
		}
	}
	
	public int cantEnemigos() {
		return cantEnemigos;
	}
		
	public Collection<Entidad> getEntidades() {
		return coleccionEntidades;
	}
	
	public Heroe getHeroe() {
		return heroe;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public static Mapa getMapa() {
		if (mapa==null) {
			mapa=new Mapa();
		}
		return mapa;
	}
	
	public void subirNivel() {
		nivel++;
		for (Entidad e : coleccionEntidades) {
			if (e!=heroe) {
				eliminarEntidad(e);
			}
		}
		for (int i = 0 ; i < listaDeObservadores.length ; i++) {
			listaDeObservadores[i].setEstado(false);
		}
		actualizarColeccion();
		crearEntidades(nivel);
	}
	
	public void resetearNivel() {
		coleccionEntidades.removeAll(coleccionEntidades);
		if (vidasExtra>0) {
			int puntaje = heroe.getPuntaje();
			heroe = new Heroe();
			heroe.sumarPuntaje(puntaje);
			agregarEntidad(heroe);
			crearEntidades(nivel);
			vidasExtra--;
		}
		for (int i = 0 ; i < listaDeObservadores.length ; i++) {
			listaDeObservadores[i].setEstado(false);
		}
	}
	
	public void agregarEntidad(Entidad e) {
		coleccionAAgregar.add(e);
	}
	
	public void eliminarEntidad(Entidad e) {
		coleccionAEliminar.add(e);
	}
	
	public void actualizarColeccion() {
		actualizarEliminados();
		for (Entidad e: coleccionAEliminar) {
			coleccionEntidades.remove(e);
		}
		coleccionAEliminar.removeAll(coleccionAEliminar);
		for (Entidad e: coleccionAAgregar) {
			coleccionEntidades.add(e);
		}
		coleccionAAgregar.removeAll(coleccionAAgregar);
	}
	
	private void actualizarEliminados() {
		for (Entidad e:coleccionEntidades) {
			if (e.getVida()<=0) {
				coleccionAEliminar.add(e);
			}
		}
	}
	
	public void reiniciarMapa() {
		heroe =new Heroe();
		vidasExtra = 3;
		nivel = 1;
		coleccionEntidades.removeAll(coleccionEntidades);
		coleccionAAgregar.removeAll(coleccionAAgregar);
		coleccionAEliminar.removeAll(coleccionAEliminar);
        crearEntidades(nivel);
        agregarEntidad(heroe);
	}
	
	public int getVidasExtra() {
		return vidasExtra;
	}
	
	public int getUltimoNivel() {
		return ultimoNivel;
	}
	
	public void decrementarContEnemigo() {
		cantEnemigos--;
	}

	public void agregarObservadores(Observer obs, int pos) {
		listaDeObservadores[pos]=obs;
		
	}
	public void eliminarObservador(int pos) {
			listaDeObservadores[pos]=null;
	}
	public Observer getObsList(int pos){
		return listaDeObservadores[pos];
	}
}
