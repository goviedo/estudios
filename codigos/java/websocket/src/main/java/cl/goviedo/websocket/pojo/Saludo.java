package cl.goviedo.websocket.pojo;

public class Saludo {
	
	private String contenido;
	
	public Saludo() {
		super();
	}

	public Saludo(String contenido) {
		super();
		this.contenido = contenido;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}
