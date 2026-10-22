package controller;

import dao.ConsultaDAO;
import dao.UsuarioDAO;
import entidades.Consulta;
import entidades.Gestante;
import entidades.Medico;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ConsultaController {

    private final ConsultaDAO consultaDAO;
    private final UsuarioDAO usuarioDAO;
    private final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    private final SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

    public ConsultaController() {
        this.consultaDAO = new ConsultaDAO();
        this.usuarioDAO = new UsuarioDAO();
    }

    public void salvarOuAtualizar(Long idConsulta, String cpfOuNomeGestante, String medicoTermo,
            String dataStr, String horaStr, String motivo,
            String relatorio, boolean gravidezRisco, String previsaoParto) throws Exception {

        if (cpfOuNomeGestante == null || cpfOuNomeGestante.trim().isEmpty()) {
            throw new Exception("É necessário informar o CPF ou nome da Gestante (Paciente).");
        }

        Gestante gestante = consultaDAO.buscarGestante(cpfOuNomeGestante);
        if (gestante == null) {
            throw new Exception("Nenhuma gestante encontrada com o CPF/Nome: " + cpfOuNomeGestante);
        }

        Medico medico = null;
        if (medicoTermo != null && !medicoTermo.trim().isEmpty()) {
            medico = consultaDAO.buscarMedico(medicoTermo);
            if (medico == null) {
                throw new Exception("Nenhum médico encontrado com o CPF, CRM ou Nome: " + medicoTermo);
            }
        }

        Date dataConvertida;
        try {
            dataConvertida = formatoData.parse(dataStr.trim());
        } catch (Exception e) {
            throw new Exception("Data inválida! Use o formato dd/MM/aaaa (ex: 25/10/2026).");
        }

        Date horaConvertida;
        try {
            String horaTexto = horaStr.trim();
            if (horaTexto.length() == 5) {
                horaTexto += ":00";
            }
            SimpleDateFormat formatoCompleto = new SimpleDateFormat("HH:mm:ss");
            horaConvertida = formatoCompleto.parse(horaTexto);
        } catch (Exception e) {
            throw new Exception("Hora inválida! Use o formato HH:mm (ex: 14:30).");
        }

        gestante.setGravidezDeRisco(gravidezRisco ? "Sim" : "Não");
        if (previsaoParto != null && !previsaoParto.trim().isEmpty()) {
            gestante.setPrevisaoDoParto(previsaoParto.trim());
        }
        usuarioDAO.editar(gestante);

        Consulta consulta;
        if (idConsulta != null) {
            consulta = consultaDAO.buscarPorId(idConsulta);
            if (consulta == null) {
                throw new Exception("Consulta não encontrada para edição.");
            }
        } else {
            consulta = new Consulta();
        }

        consulta.setGestante(gestante);
        consulta.setMedico(medico);
        consulta.setData(dataConvertida);
        consulta.setHora(horaConvertida);
        consulta.setMotivo(motivo);
        consulta.setStatus(relatorio); // Guarda o relatóriona Consulta

        if (idConsulta != null) {
            consultaDAO.editar(consulta);
        } else {
            consultaDAO.agendar(consulta);
        }
    }

    public Consulta buscarPorId(Long id) {
        return consultaDAO.buscarPorId(id);
    }

    public List<Consulta> listarTodas() {
        return consultaDAO.listarTodas();
    }

    public void excluir(Long id) throws Exception {
        consultaDAO.excluir(id);
    }

    public String formatarData(Date data) {
        return data != null ? formatoData.format(data) : "";
    }

    public String formatarHora(Date hora) {
        if (hora == null) {
            return "";
        }
        SimpleDateFormat formatoExibicao = new SimpleDateFormat("HH:mm");
        return formatoExibicao.format(hora);
    }
}
