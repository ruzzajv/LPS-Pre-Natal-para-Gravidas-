package controller;

import dao.AgendaDAO;
import dao.ConsultaDAO;
import entidades.Agenda;
import entidades.Consulta;
import java.util.List;

public class AgendaController {

    private final AgendaDAO agendaDAO;
    private final ConsultaDAO consultaDAO;

    public AgendaController() {
        this.agendaDAO = new AgendaDAO();
        this.consultaDAO = new ConsultaDAO();
    }

    public List<Consulta> listarConsultasDaAgenda() {
        return consultaDAO.listarTodas();
    }

    public void excluirConsulta(Long idConsulta) throws Exception {
        consultaDAO.excluir(idConsulta);
    }

    public void salvarAgenda(Agenda agenda) throws Exception {
        agendaDAO.salvar(agenda);
    }

    public void editarAgenda(Agenda agenda) throws Exception {
        agendaDAO.editar(agenda);
    }

    public void excluirAgenda(Long idAgenda) throws Exception {
        agendaDAO.excluir(idAgenda);
    }
}