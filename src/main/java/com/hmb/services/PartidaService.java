package com.hmb.services;

import com.hmb.dao.PartidaDAO;
import com.hmb.dao.GanadorDAO;
import java.util.Random;

public class PartidaService {
	
	private PartidaDAO partidaDAO = new PartidaDAO();
	private GanadorDAO ganadorDAO = new GanadorDAO();
	
	public int generarNumeroHamburguesa (int limiteMax) {
		Random random = new Random();
		
		return random.nextInt(limiteMax) + 1;
	}
	
	
	public int evaluarIntento(int intentoJugador, int numeroSecreto) {
		
		if(intentoJugador == numeroSecreto) {
			
			System.out.println("Victoria");
			return 0; //acerto
			
		}else if (intentoJugador > numeroSecreto) {
			return -1; //resultado alto 
		}else {
			return 1; //muy bajo 
		}
		
	}
	
	public boolean registrarFinDePartida(int idJugador, int intentosUtilizados, boolean esGanador) {
	        
	        boolean partidaGuardada = partidaDAO.insertarPartida(idJugador, intentosUtilizados);

	        if (esGanador && partidaGuardada) {
	            return ganadorDAO.registrarGanador(idJugador);
	        }
	
	        return partidaGuardada;
	    }

}
