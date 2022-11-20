package ar.edu.unlam.pb2;

public class Figurita {
private Integer codigoDeFigurita;
private Character LetraGrupo;
private String seleccion;
private String nombreDelJugador;
private Double valorDelJugadorEnElMercado;

public Figurita(Integer codigoDeFigurita, Character letraGrupo, String seleccion, String nombreDelJugador,
		Double valorDelJugadorEnElMercado) {
	this.codigoDeFigurita = codigoDeFigurita;
	LetraGrupo = letraGrupo;
	this.seleccion = seleccion;
	this.nombreDelJugador = nombreDelJugador;
	this.valorDelJugadorEnElMercado = valorDelJugadorEnElMercado;
}

public Integer getCodigoDeFigurita() {
	return codigoDeFigurita;
}

public void setCodigoDeFigurita(Integer codigoDeFigurita) {
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



}