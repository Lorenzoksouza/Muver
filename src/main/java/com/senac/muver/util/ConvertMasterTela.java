package com.senac.muver.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;

import com.senac.muver.model.Estudio;
import com.senac.muver.model.Luthier;
import com.senac.muver.model.Master;
import com.senac.muver.model.MasterTela;
import com.senac.muver.model.Musico;

public class ConvertMasterTela {

	public ArrayList<MasterTela> converteListaMasterEmMasterTela(ArrayList<Master> listaUsuarios) {
		
		ArrayList<MasterTela> usuariosTela = new ArrayList<MasterTela>();
		for (Master m : listaUsuarios) {
			MasterTela mt = new MasterTela();
			try { 
				InputStream initialStream =new ByteArrayInputStream(m.getFotoPerfil());
					    File targetFile = new File("src/main/resources/static/images/photos/" + m.getNome() + ".png");
					    OutputStream outStream = new FileOutputStream(targetFile);
					 
					    byte[] buffer = new byte[8 * 1024];
					    int bytesRead;
					    while ((bytesRead = initialStream.read(buffer)) != -1) {
					        outStream.write(buffer, 0, bytesRead);
					    }
					    mt.setFotoPerfil(new File("images/photos/" + m.getNome() + ".png"));
					    IOUtils.closeQuietly(initialStream);
					    IOUtils.closeQuietly(outStream);
		        } catch (Exception e) { 
		           e.printStackTrace(); 
		        }
			mt.setNome(m.getNome());
			mt.setDescricao(m.getDescricao());
			usuariosTela.add(mt);
		}
		return  usuariosTela;
	}

	public MasterTela converteMasterEmMasterTela(Master usuario) {
		MasterTela mt = new MasterTela();
		try { 
			InputStream initialStream =new ByteArrayInputStream(usuario.getFotoPerfil());
				    File targetFile = new File("src/main/resources/static/images/photos/" + usuario.getNome() + ".png");
				    OutputStream outStream = new FileOutputStream(targetFile);
				 
				    byte[] buffer = new byte[8 * 1024];
				    int bytesRead;
				    while ((bytesRead = initialStream.read(buffer)) != -1) {
				        outStream.write(buffer, 0, bytesRead);
				    }
				    IOUtils.closeQuietly(initialStream);
				    IOUtils.closeQuietly(outStream);
	        } catch (Exception e) { 
	           e.printStackTrace(); 
	        }
		mt.setFotoPerfil(new File("images/photos/" + usuario.getNome() + ".png"));
		mt.setNome(usuario.getNome());
		mt.setDescricao(usuario.getDescricao());
		mt.setLinkFb(usuario.getLinkFb());
		mt.setLinkIg(usuario.getLinkIg());
		mt.setTipoUsuario(usuario.getTipoUsuario());
		mt.setEmail(usuario.getEmail());
		mt.setNota(usuario.getNota());
		mt.setNumeroAvaliacoes(usuario.getNumeroAvaliacoes());
		return mt;
	}
	
	public MasterTela converteLuthierEmMasterTela(Luthier l) {
		MasterTela mt = new MasterTela();
		try { 
			InputStream initialStream =new ByteArrayInputStream(l.getFotoPerfil());
				    File targetFile = new File("src/main/resources/static/images/photos/" + l.getNome() + ".png");
				    OutputStream outStream = new FileOutputStream(targetFile);
				 
				    byte[] buffer = new byte[8 * 1024];
				    int bytesRead;
				    while ((bytesRead = initialStream.read(buffer)) != -1) {
				        outStream.write(buffer, 0, bytesRead);
				    }
				    IOUtils.closeQuietly(initialStream);
				    IOUtils.closeQuietly(outStream);
	        } catch (Exception e) { 
	           e.printStackTrace(); 
	        }
		mt.setInstrumentos(l.getInstrumento());
		mt.setFotoPerfil(new File("images/photos/" + l.getNome() + ".png"));
		mt.setNome(l.getNome());
		mt.setDescricao(l.getDescricao());
		mt.setLinkFb(l.getLinkFb());
		mt.setLinkIg(l.getLinkIg());
		mt.setTipoUsuario(l.getTipoUsuario());
		mt.setEmail(l.getEmail());
		mt.setLocalizacao(l.getLocalizacao());
		mt.setDisponibilidade(l.getDisponibilidade());
		mt.setNota(l.getNota());
		mt.setNumeroAvaliacoes(l.getNumeroAvaliacoes());
		return mt;
	}

	public MasterTela converteEstudioEmMasterTela(Estudio es) {
		MasterTela mt = new MasterTela();
		try { 
			InputStream initialStream =new ByteArrayInputStream(es.getFotoPerfil());
				    File targetFile = new File("src/main/resources/static/images/photos/" + es.getNome() + ".png");
				    OutputStream outStream = new FileOutputStream(targetFile);
				 
				    byte[] buffer = new byte[8 * 1024];
				    int bytesRead;
				    while ((bytesRead = initialStream.read(buffer)) != -1) {
				        outStream.write(buffer, 0, bytesRead);
				    }
				    IOUtils.closeQuietly(initialStream);
				    IOUtils.closeQuietly(outStream);
	        } catch (Exception e) { 
	           e.printStackTrace(); 
	        }
		mt.setFotoPerfil(new File("images/photos/" + es.getNome() + ".png"));
		mt.setNome(es.getNome());
		mt.setDescricao(es.getDescricao());
		mt.setLinkFb(es.getLinkFb());
		mt.setLinkIg(es.getLinkIg());
		mt.setTipoUsuario(es.getTipoUsuario());
		mt.setEmail(es.getEmail());
		mt.setLocalizacao(es.getLocalizacao());
		mt.setDisponibilidade(es.getDisponibilidade());
		mt.setNota(es.getNota());
		mt.setNumeroAvaliacoes(es.getNumeroAvaliacoes());
		return mt;
	}


	public MasterTela converteMusicoEmMasterTela(Musico m) {
		MasterTela mt = new MasterTela();
		try { 
			InputStream initialStream =new ByteArrayInputStream(m.getFotoPerfil());
				    File targetFile = new File("src/main/resources/static/images/photos/" + m.getNome() + ".png");
				    OutputStream outStream = new FileOutputStream(targetFile);
				 
				    byte[] buffer = new byte[8 * 1024];
				    int bytesRead;
				    while ((bytesRead = initialStream.read(buffer)) != -1) {
				        outStream.write(buffer, 0, bytesRead);
				    }
				    IOUtils.closeQuietly(initialStream);
				    IOUtils.closeQuietly(outStream);
	        } catch (Exception e) { 
	           e.printStackTrace(); 
	        }
		mt.setInstrumentos(m.getInstrumento());
		mt.setEstiloMusical(m.getEstiloMusical());
		mt.setFotoPerfil(new File("images/photos/" + m.getNome() + ".png"));
		mt.setNome(m.getNome());
		mt.setDescricao(m.getDescricao());
		mt.setLinkFb(m.getLinkFb());
		mt.setLinkIg(m.getLinkIg());
		mt.setTipoUsuario(m.getTipoUsuario());
		mt.setEmail(m.getEmail());
		mt.setNumeroAvaliacoes(m.getNumeroAvaliacoes());
		return mt;
	}
	
}
