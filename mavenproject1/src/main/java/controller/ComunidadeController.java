package controller;

import dao.InformacoesDAO;
import dao.MuralDAO;
import entidades.Informacoes;
import entidades.Mural;
import java.util.Date;
import java.util.List;

public class ComunidadeController {
    
    // Método atualizado com 5 parâmetros (incluindo autora e postagemPai)
    public void salvarPostMural(String tema, String titulo, String texto, entidades.Gestante autora, entidades.Mural postagemPai) throws Exception {
        if (texto == null || texto.trim().isEmpty()) {
            throw new Exception("O texto da postagem não pode estar vazio!");
        }
        Mural mural = new Mural();
        mural.setDataPublicacao(new Date());
        
        // Se for resposta, não precisa de tema e título
        if (postagemPai != null) {
            mural.setTextoDica(texto);
            mural.setPostagemPai(postagemPai);
        } else {
            mural.setTextoDica("TEMA: " + tema + " | TÍTULO: " + titulo + "\n" + texto);
        }
        
        mural.setGestante(autora); // Associa o nome da autora à postagem
        new MuralDAO().salvar(mural);
    }
    
    public void salvarPostInformacao(String tema, String titulo, String texto) throws Exception {
        if (texto == null || texto.trim().isEmpty()) {
            throw new Exception("O conteúdo não pode estar vazio!");
        }
        Informacoes info = new Informacoes();
        info.setDataPublicacao(new Date());
        info.setTituloAviso(titulo);
        info.setConteudoTecnico("TEMA: " + tema + "\n" + texto);
        
        new InformacoesDAO().salvar(info);
    }

    public List<Mural> listarMural() {
        return new MuralDAO().listarTodos();
    }

    public List<Informacoes> listarInformacoes() {
        return new InformacoesDAO().listarTodas();
    }
}