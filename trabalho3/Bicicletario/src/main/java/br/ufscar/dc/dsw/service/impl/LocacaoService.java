package br.ufscar.dc.dsw.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.ILocacaoDAO;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.dto.LocacaoDTO;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;

@Service
@Transactional(readOnly = false)
public class LocacaoService implements ILocacaoService {

	@Autowired
	ILocacaoDAO dao;

	@Transactional(readOnly = true)
	public List<Locacao> buscarTodos() {
		return dao.findAll();
	}    
	
	
	public void salvar(Locacao locacao) {
		dao.save(locacao);
	}
	
	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Locacao buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Locacao> buscarTodosPorCliente(Long id) {
		return dao.findAllByCliente(id);
	}

	@Transactional(readOnly = true)
	public List<Locacao> buscarTodosPorLocadora(Long id) {
		return dao.findAllByLocadora(id);
	}
	
	@Transactional(readOnly = true)
    public List<Locacao> buscarLocacoesPorClienteELocadoraEData(Long clienteId, Long locadoraId, String data) {
        return dao.buscarLocacoesPorClienteELocadoraEData(clienteId.longValue(), locadoraId.longValue(), data);
    }
	
	//DTOs
    public List<LocacaoDTO> buscarTodosDTO() {
        List<Locacao> locacoes = dao.findAll();

        List<LocacaoDTO> locacaoDTOs = new ArrayList<>();

        for (Locacao locacao : locacoes) {
            Cliente cliente = locacao.getCliente();
            Locadora locadora = locacao.getLocadora();

            LocacaoDTO locacaoDTO = new LocacaoDTO();
            locacaoDTO.setId(locacao.getId());
            locacaoDTO.setData(locacao.getData());
            locacaoDTO.setValor(locacao.getValor());
            //Long id, String cpf, String telefone, String genero, String dataNasc
            locacaoDTO.setCliente(cliente.getId(), cliente.getCpf(), cliente.getTelefone(), cliente.getGenero(), cliente.getDataNasc() );
            //Long id, String cnpj, String cidade
            locacaoDTO.setLocadora(locadora.getId(), locadora.getCnpj(), locadora.getCidade());

            locacaoDTOs.add(locacaoDTO);
        }

        return locacaoDTOs;
    }


	@Transactional(readOnly = true)
	public LocacaoDTO buscarPorIdDTO(Long id) {
       Locacao locacao = dao.findById(id.longValue());

        LocacaoDTO locacaoDTO = new LocacaoDTO();

        Cliente cliente = locacao.getCliente();
        Locadora locadora = locacao.getLocadora();

        locacaoDTO.setId(locacao.getId());
        locacaoDTO.setData(locacao.getData());
        locacaoDTO.setValor(locacao.getValor());
        //Long id, String cpf, String telefone, String genero, String dataNasc
        locacaoDTO.setCliente(cliente.getId(), cliente.getCpf(), cliente.getTelefone(), cliente.getGenero(), cliente.getDataNasc() );
        //Long id, String cnpj, String cidade
        locacaoDTO.setLocadora(locadora.getId(), locadora.getCnpj(), locadora.getCidade());

        return locacaoDTO;
	}

	@Transactional(readOnly = true)
	public List<LocacaoDTO> buscarTodosPorClienteDTO(Long id) {
		List<Locacao> locacoes =  dao.findAllByCliente(id);


        List<LocacaoDTO> locacaoDTOs = new ArrayList<>();

        for (Locacao locacao : locacoes) {
            Cliente cliente = locacao.getCliente();
            Locadora locadora = locacao.getLocadora();

            LocacaoDTO locacaoDTO = new LocacaoDTO();
            locacaoDTO.setId(locacao.getId());
            locacaoDTO.setData(locacao.getData());
            locacaoDTO.setValor(locacao.getValor());
            //Long id, String cpf, String telefone, String genero, String dataNasc
            locacaoDTO.setCliente(cliente.getId(), cliente.getCpf(), cliente.getTelefone(), cliente.getGenero(), cliente.getDataNasc() );
            //Long id, String cnpj, String cidade
            locacaoDTO.setLocadora(locadora.getId(), locadora.getCnpj(), locadora.getCidade());

            locacaoDTOs.add(locacaoDTO);
        }

        return locacaoDTOs;
	}

	@Transactional(readOnly = true)
	public List<LocacaoDTO> buscarTodosPorLocadoraDTO(Long id) {
		List<Locacao> locacoes = dao.findAllByLocadora(id);


        List<LocacaoDTO> locacaoDTOs = new ArrayList<>();

        for (Locacao locacao : locacoes) {
            Cliente cliente = locacao.getCliente();
            Locadora locadora = locacao.getLocadora();

            LocacaoDTO locacaoDTO = new LocacaoDTO();
            locacaoDTO.setId(locacao.getId());
            locacaoDTO.setData(locacao.getData());
            locacaoDTO.setValor(locacao.getValor());
            //Long id, String cpf, String telefone, String genero, String dataNasc
            locacaoDTO.setCliente(cliente.getId(), cliente.getCpf(), cliente.getTelefone(), cliente.getGenero(), cliente.getDataNasc() );
            //Long id, String cnpj, String cidade
            locacaoDTO.setLocadora(locadora.getId(), locadora.getCnpj(), locadora.getCidade());

            locacaoDTOs.add(locacaoDTO);
        }

        return locacaoDTOs;
	}

}