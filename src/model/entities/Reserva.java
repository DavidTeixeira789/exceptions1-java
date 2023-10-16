package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DominioExceptions;

public class Reserva {
	
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numQuarto, Date checkIn, Date checkOut) throws DominioExceptions {
		if (!checkOut.after(checkIn)) {
			throw new DominioExceptions("Erro na reserva: a data de check-out deve ser posterior a data de check-in");
		}
		this.numQuarto = numQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif,TimeUnit.MILLISECONDS);
	}
	public void atualizacao(Date checkIn, Date checkOut) throws DominioExceptions {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DominioExceptions("As datas para atualização devem ser datas futuras");
		}
		if (!checkOut.after(checkIn)) {
			throw new DominioExceptions("Erro na reserva: a data de check-out deve ser posterior a data de check-in");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public String toString() {
		return "Quarto "+numQuarto+
				", check-in: "+sdf.format(checkIn)+", "+
				"check-out: "+sdf.format(checkOut)+", "+
				duracao()+" noites";
		        
	}

}
