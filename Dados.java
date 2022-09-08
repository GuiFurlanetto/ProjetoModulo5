import java.time.LocalDate;
import java.time.LocalTime;

public class Dados {

    private Integer ID;
    private Integer rodada;
    private LocalDate data;
    private LocalTime hora;
    private String dia;
    private String mandante;
    private String visitante;
    private String vencedor;
    private Integer mandante_placar;
    private Integer visitante_placar;
    private String estado_vencedor;


    // precisa criar o construtor cheio e vazio


    public Dados() {
    }

    public Dados(Integer ID, Integer rodada, LocalDate data, LocalTime hora, String dia, String mandante, String visitante, String vencedor, Integer mandante_placar, Integer visitante_placar, String estado_vencedor) {
        this.ID = ID;
        this.rodada = rodada;
        this.data = data;
        this.hora = hora;
        this.dia = dia;
        this.mandante = mandante;
        this.visitante = visitante;
        this.vencedor = vencedor;
        this.mandante_placar = mandante_placar;
        this.visitante_placar = visitante_placar;
        this.estado_vencedor = estado_vencedor;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getRodada() {
        return rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMandante() {
        return mandante;
    }

    public void setMandante(String mandante) {
        this.mandante = mandante;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public Integer getMandante_placar() {
        return mandante_placar;
    }

    public void setMandante_placar(Integer mandante_placar) {
        this.mandante_placar = mandante_placar;
    }

    public Integer getVisitante_placar() {
        return visitante_placar;
    }

    public void setVisitante_placar(Integer visitante_placar) {
        this.visitante_placar = visitante_placar;
    }

    public String getEstado_vencedor() {
        return estado_vencedor;
    }

    public void setEstado_vencedor(String estado_vencedor) {
        this.estado_vencedor = estado_vencedor;
    }
}
