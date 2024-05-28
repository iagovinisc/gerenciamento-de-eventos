package control;

public class Evento {
	private int id;
    private String nome_evento, nome_organizador, nome_palestrante, tipo_evento, data, horario, local;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome_evento() {
		return nome_evento;
	}
	public void setNome_evento(String nome_evento) {
		this.nome_evento = nome_evento;
	}
	public String getNome_organizador() {
		return nome_organizador;
	}
	public void setNome_organizador(String nome_organizador) {
		this.nome_organizador = nome_organizador;
	}
	public String getNome_palestrante() {
		return nome_palestrante;
	}
	public void setNome_palestrante(String nome_palestrante) {
		this.nome_palestrante = nome_palestrante;
	}
	public String getTipo_evento() {
		return tipo_evento;
	}
	public void setTipo_evento(String tipo_evento) {
		this.tipo_evento = tipo_evento;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
}

