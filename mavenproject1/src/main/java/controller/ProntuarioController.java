package controller;

import dao.ProntuarioDAO;
import entidades.Prontuario;

/**
 *
 * @author jruza
 */
public class ProntuarioController {

    private ProntuarioDAO dao;

    public ProntuarioController() {
        this.dao = new ProntuarioDAO(); 
    }

    
    public Prontuario buscarPorCpfPaciente(String cpf) throws Exception {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new Exception("CPF da paciente não informado.");
        }
        
        return dao.buscarPorCpfPaciente(cpf.trim());
    }

    public void cadastrar(String cpfPaciente, String tipoSanguineo, String alergias, 
                          String medicamentos, String condicoes, String observacoes, String observacoes1) throws Exception {
        
        if (cpfPaciente == null || cpfPaciente.trim().isEmpty()) {
            throw new Exception("O CPF da paciente é obrigatório para criar o prontuário.");
        }


        if (dao.buscarPorCpfPaciente(cpfPaciente) != null) {
            throw new Exception("Já existe um prontuário cadastrado para esta paciente.");
        }

        Prontuario novoProntuario = new Prontuario();
        novoProntuario.setCpfPaciente(cpfPaciente);
        novoProntuario.setTipoSanguineo(tipoSanguineo);
        novoProntuario.setAlergias(alergias);
        novoProntuario.setMedicamentos(medicamentos);
        novoProntuario.setCondicoesPreExistentes(condicoes);
        novoProntuario.setObservacoes(observacoes);
        novoProntuario.setObservacoes1(observacoes1);

        dao.salvar(novoProntuario);
    }


    public void atualizar(String cpfPaciente, String tipoSanguineo, String alergias, 
                          String medicamentos, String condicoes, String observacoes, String observacoes1) throws Exception {
        
        if (cpfPaciente == null || cpfPaciente.trim().isEmpty()) {
            throw new Exception("O CPF da paciente é obrigatório para atualizar o prontuário.");
        }

      
        Prontuario prontuario = dao.buscarPorCpfPaciente(cpfPaciente);
        
        if (prontuario != null) {
            // 2. Atualiza os atributos com os dados vindos da tela
            prontuario.setTipoSanguineo(tipoSanguineo);
            prontuario.setAlergias(alergias);
            prontuario.setMedicamentos(medicamentos);
            prontuario.setCondicoesPreExistentes(condicoes);
            prontuario.setObservacoes(observacoes);
            prontuario.setObservacoes1(observacoes1);

            
            dao.editar(prontuario);
        } else {
            throw new Exception("Não foi possível encontrar o prontuário para atualizar.");
        }
    }
    public void adicionarExameAoProntuario(String cpfPaciente, String resumoExame) throws Exception {
        if (cpfPaciente == null || cpfPaciente.trim().isEmpty()) {
            throw new Exception("CPF da paciente não informado.");
        }

        // 1. Busca o prontuário atual
        entidades.Prontuario prontuario = dao.buscarPorCpfPaciente(cpfPaciente);
        
        if (prontuario != null) {
            // 2. Pega o que já estava escrito no campo circulado de verde
            String historicoAtual = prontuario.getObservacoes1();
            if (historicoAtual == null) {
                historicoAtual = "";
            }
            
            // 3. Junta o texto antigo com o novo exame (adicionando uma quebra de linha \n)
            String novoHistorico = historicoAtual + "\n- EXAME: " + resumoExame;
            
            // 4. Salva a alteração
            prontuario.setObservacoes1(novoHistorico.trim());
            dao.editar(prontuario);
        } else {
            throw new Exception("Prontuário não encontrado! Crie o prontuário primeiro.");
        }
    }
}