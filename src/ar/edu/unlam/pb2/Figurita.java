package ar.edu.unlam.pb2;

public class Figurita implements Comparable<Figurita> {
private String codigoDeFigurita;
private Character LetraGrupo;
private String seleccion;
private Integer numeroFigurita;
private String nombreDelJugador;
private Double valorDelJugadorEnElMercado;

public Figurita(String codigoDeFigurita, Character letraGrupo, String seleccion,Integer numeroFigurita, String nombreDelJugador,
		Double valorDelJugadorEnElMercado) {
	this.codigoDeFigurita = codigoDeFigurita;
	LetraGrupo = letraGrupo;
	this.seleccion = seleccion;
	this.numeroFigurita=numeroFigurita;
	this.nombreDelJugador = nombreDelJugador;
	this.valorDelJugadorEnElMercado = valorDelJugadorEnElMercado;
}



public Integer getNumeroFigurita() {
	return numeroFigurita;
}


public void setNumeroFigurita(Integer numeroFigurita) {
	this.numeroFigurita = numeroFigurita;
}



public String getCodigoDeFigurita() {
	return codigoDeFigurita;
}

public void setCodigoDeFigurita(String codigoDeFigurita) {
	this.codigoDeFigurita = codigoDeFigurita;
}

public Character getLetraGrupo() {
	return LetraGrupo;
}

public void setLetraGrupo(Character letraGrupo) {
	LetraGrupo = letraGrupo;
}

public String getSeleccion() {
	return seleccion;
}

public void setSeleccion(String seleccion) {
	this.seleccion = seleccion;
}

public String getNombreDelJugador() {
	return nombreDelJugador;
}

public void setNombreDelJugador(String nombreDelJugador) {
	this.nombreDelJugador = nombreDelJugador;
}

public Double getValorDelJugadorEnElMercado() {
	return valorDelJugadorEnElMercado;
}

public void setValorDelJugadorEnElMercado(Double valorDelJugadorEnElMercado) {
	this.valorDelJugadorEnElMercado = valorDelJugadorEnElMercado;
}

@Override
public int compareTo(Figurita o) {
	if(this.getLetraGrupo().equals(o.getLetraGrupo())) {
		if(this.getSeleccion().equals(o.getSeleccion())) {
			return this.getNumeroFigurita().compareTo(o.getNumeroFigurita());
		} return this.getSeleccion().compareTo(o.getSeleccion());
	} return this.getLetraGrupo().compareTo(o.getLetraGrupo());
}



}
