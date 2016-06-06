package com.intellisoft.intellibusinessws.entities.ven;

import java.math.BigDecimal;

import com.intellisoft.intellibusinessws.entities.Entity;
import com.intellisoft.intellibusinessws.entities.annotations.KeyField;

public class Venta extends Entity{
	@KeyField
	private long nro;
	private int cliente;
	private long fecha;
	private BigDecimal monto;
	private boolean anulado;
	
	
	
	public Venta() {
		super();
	}

	public Venta(long nro, int cliente, long fecha, BigDecimal monto, boolean anulado) {
		super();
		this.nro = nro;
		this.cliente = cliente;
		this.fecha = fecha;
		this.monto = monto;
		this.anulado = anulado;
	}

	public long getNro() {
		return nro;
	}

	public void setNro(long nro) {
		this.nro = nro;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public long getFecha() {
		return fecha;
	}

	public void setFecha(long fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public boolean isAnulado() {
		return anulado;
	}

	public void setAnulado(boolean anulado) {
		this.anulado = anulado;
	}
	
	
	
	
	
	

}
